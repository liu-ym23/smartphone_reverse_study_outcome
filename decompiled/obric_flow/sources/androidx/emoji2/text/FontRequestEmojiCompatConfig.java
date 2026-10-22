package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.core.graphics.TypefaceCompatUtil;
import androidx.core.os.TraceCompat;
import androidx.core.provider.FontRequest;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public class FontRequestEmojiCompatConfig extends EmojiCompat.Config {
    private static final FontProviderHelper DEFAULT_FONTS_CONTRACT = null;

    public static class ExponentialBackoffRetryPolicy extends RetryPolicy {
        private long mRetryOrigin;
        private final long mTotalMs;

        public ExponentialBackoffRetryPolicy(long r5) {
            this.mTotalMs = r5;
        }

        @Override // androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy
        public long getRetryDelay() {
            if (this.mRetryOrigin != 0) goto L6;
            this.mRetryOrigin = SystemClock.uptimeMillis();
            return 0;
        L6:
            long r5 = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (r5 <= this.mTotalMs) goto L11;
            return -1;
        L11:
            return Math.min(Math.max(r5, 1000), this.mTotalMs - r5);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class FontProviderHelper {
        public FontProviderHelper() {
        }

        @Nullable
        public Typeface buildTypeface(@NonNull Context r5, @NonNull FontsContractCompat.FontInfo r10) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.buildTypeface(r5, null, new FontsContractCompat.FontInfo[]{r10});
        }

        @NonNull
        public FontsContractCompat.FontFamilyResult fetchFonts(@NonNull Context r5, @NonNull FontRequest r10) throws PackageManager.NameNotFoundException {
            return FontsContractCompat.fetchFonts(r5, null, r10);
        }

        public void registerObserver(@NonNull Context r5, @NonNull Uri r10, @NonNull ContentObserver r11) {
            r5.getContentResolver().registerContentObserver(r10, false, r11);
        }

        public void unregisterObserver(@NonNull Context r5, @NonNull ContentObserver r10) {
            r5.getContentResolver().unregisterContentObserver(r10);
        }
    }

    public static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
        private static final String S_TRACE_BUILD_TYPEFACE = "EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface";

        @Nullable
        @GuardedBy("mLock")
        EmojiCompat.MetadataRepoLoaderCallback mCallback;

        @NonNull
        private final Context mContext;

        @Nullable
        @GuardedBy("mLock")
        private Executor mExecutor;

        @NonNull
        private final FontProviderHelper mFontProviderHelper;

        @NonNull
        private final Object mLock;

        @Nullable
        @GuardedBy("mLock")
        private Handler mMainHandler;

        @Nullable
        @GuardedBy("mLock")
        private Runnable mMainHandlerLoadCallback;

        @Nullable
        @GuardedBy("mLock")
        private ThreadPoolExecutor mMyThreadPoolExecutor;

        @Nullable
        @GuardedBy("mLock")
        private ContentObserver mObserver;

        @NonNull
        private final FontRequest mRequest;

        @Nullable
        @GuardedBy("mLock")
        private RetryPolicy mRetryPolicy;

        public FontRequestMetadataLoader(@NonNull Context r5, @NonNull FontRequest r10, @NonNull FontProviderHelper r11) {
            this.mLock = new Object();
            Preconditions.checkNotNull(r5, "Context cannot be null");
            Preconditions.checkNotNull(r10, "FontRequest cannot be null");
            this.mContext = r5.getApplicationContext();
            this.mRequest = r10;
            this.mFontProviderHelper = r11;
        }

        private void cleanUp() {
            Object r5 = this.mLock;
            monitor-enter(r5);
            this.mCallback = null;     // Catch: Throwable -> L8
            ContentObserver r10 = this.mObserver;     // Catch: Throwable -> L8
            if (r10 == null) goto L10;
            this.mFontProviderHelper.unregisterObserver(this.mContext, r10);     // Catch: Throwable -> L8
            this.mObserver = null;     // Catch: Throwable -> L8
        L10:
            Handler r11 = this.mMainHandler;     // Catch: Throwable -> L8
            if (r11 == null) goto L13;
            r11.removeCallbacks(this.mMainHandlerLoadCallback);     // Catch: Throwable -> L8
        L13:
            this.mMainHandler = null;     // Catch: Throwable -> L8
            ThreadPoolExecutor r12 = this.mMyThreadPoolExecutor;     // Catch: Throwable -> L8
            if (r12 == null) goto L16;
            r12.shutdown();     // Catch: Throwable -> L8
        L16:
            this.mExecutor = null;     // Catch: Throwable -> L8
            this.mMyThreadPoolExecutor = null;     // Catch: Throwable -> L8
            monitor-exit(r5);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @WorkerThread
        private FontsContractCompat.FontInfo retrieveFontInfo() {
            FontsContractCompat.FontFamilyResult r5 = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);     // Catch: PackageManager.NameNotFoundException -> L15
            if (r5.getStatusCode() != 0) goto L14;
            FontsContractCompat.FontInfo[] r10 = r5.getFonts();
            if (r10 == null) goto L12;
            if (r10.length == 0) goto L12;
            return r10[0];
        L12:
            throw new RuntimeException("fetchFonts failed (empty result)");
        L14:
            throw new RuntimeException("fetchFonts failed (" + r5.getStatusCode() + ")");
        L15:
            e = move-exception;
            throw new RuntimeException("provider not found", e);
        }

        @RequiresApi(19)
        @WorkerThread
        private void scheduleRetry(Uri r10, long r11) {
            Object r5 = this.mLock;
            monitor-enter(r5);
            final Handler r12 = this.mMainHandler;     // Catch: Throwable -> L7
            if (r12 != null) goto L10;
            r12 = ConcurrencyHelpers.mainHandlerAsync();     // Catch: Throwable -> L7
            this.mMainHandler = r12;     // Catch: Throwable -> L7
        L10:
            if (this.mObserver != null) goto L13;
            ContentObserver r13 = new AnonymousClass1(this, r12);     // Catch: Throwable -> L7
            this.mObserver = r13;     // Catch: Throwable -> L7
            this.mFontProviderHelper.registerObserver(this.mContext, r10, r13);     // Catch: Throwable -> L7
        L13:
            if (this.mMainHandlerLoadCallback != null) goto L15;
            this.mMainHandlerLoadCallback = new d(this, 1);     // Catch: Throwable -> L7
        L15:
            r12.postDelayed(this.mMainHandlerLoadCallback, r11);     // Catch: Throwable -> L7
            monitor-exit(r5);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @RequiresApi(19)
        @WorkerThread
        public void createMetadata() {
            Object r5 = this.mLock;
            monitor-enter(r5);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mCallback != null) goto L10;
            monitor-exit(r5);     // Catch: Throwable -> L8
            return;
        L10:
            monitor-exit(r5);     // Catch: Throwable -> L8
            FontsContractCompat.FontInfo r10 = retrieveFontInfo();     // Catch: Throwable -> L28
            int r11 = r10.getResultCode();     // Catch: Throwable -> L28
            if (r11 != 2) goto L30;
            Object r12 = this.mLock;     // Catch: Throwable -> L28
            monitor-enter(r12);     // Catch: Throwable -> L28
            RetryPolicy r13 = this.mRetryPolicy;     // Catch: Throwable -> L22
            if (r13 == null) goto L24;
            long r14 = r13.getRetryDelay();     // Catch: Throwable -> L22
            if (r14 < 0) goto L24;
            scheduleRetry(r10.getUri(), r14);     // Catch: Throwable -> L22
            monitor-exit(r12);     // Catch: Throwable -> L22
            return;
        L24:
            monitor-exit(r12);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;     // Catch: Throwable -> L28
        L30:
            if (r11 != 0) goto L54;
            TraceCompat.beginSection(S_TRACE_BUILD_TYPEFACE);     // Catch: Throwable -> L47
            Typeface r15 = this.mFontProviderHelper.buildTypeface(this.mContext, r10);     // Catch: Throwable -> L47
            ByteBuffer r16 = TypefaceCompatUtil.mmap(this.mContext, null, r10.getUri());     // Catch: Throwable -> L47
            if (r16 == null) goto L50;
            if (r15 == null) goto L50;
            MetadataRepo r17 = MetadataRepo.create(r15, r16);     // Catch: Throwable -> L47
            TraceCompat.endSection();     // Catch: Throwable -> L28
            Object r18 = this.mLock;     // Catch: Throwable -> L28
            monitor-enter(r18);     // Catch: Throwable -> L28
            EmojiCompat.MetadataRepoLoaderCallback r19 = this.mCallback;     // Catch: Throwable -> L40
            if (r19 == null) goto L42;
            r19.onLoaded(r17);     // Catch: Throwable -> L40
        L42:
            monitor-exit(r18);     // Catch: Throwable -> L40
            cleanUp();     // Catch: Throwable -> L28
            return;
        L40:
            th = move-exception;
            throw th;     // Catch: Throwable -> L28
        L50:
            throw new RuntimeException("Unable to open file.");     // Catch: Throwable -> L47
        L47:
            th = move-exception;
            TraceCompat.endSection();     // Catch: Throwable -> L28
            throw th;     // Catch: Throwable -> L28
        L54:
            throw new RuntimeException("fetchFonts result is not OK. (" + r11 + ")");     // Catch: Throwable -> L28
        L28:
            th = move-exception;
            monitor-enter(this.mLock);
            EmojiCompat.MetadataRepoLoaderCallback r20 = this.mCallback;     // Catch: Throwable -> L60
            if (r20 == null) goto L62;
            r20.onFailed(th);     // Catch: Throwable -> L60
        L62:
            cleanUp();
            return;
        L60:
            th = move-exception;
            throw th;
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        @RequiresApi(19)
        public void load(@NonNull EmojiCompat.MetadataRepoLoaderCallback r5) {
            Preconditions.checkNotNull(r5, "LoaderCallback cannot be null");
            Object r10 = this.mLock;
            monitor-enter(r10);
            this.mCallback = r5;     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            loadInternal();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @RequiresApi(19)
        public void loadInternal() {
            Object r5 = this.mLock;
            monitor-enter(r5);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.mCallback != null) goto L11;
            monitor-exit(r5);     // Catch: Throwable -> L8
            return;
        L11:
            if (this.mExecutor != null) goto L13;
            ThreadPoolExecutor r10 = ConcurrencyHelpers.createBackgroundPriorityExecutor("emojiCompat");     // Catch: Throwable -> L8
            this.mMyThreadPoolExecutor = r10;     // Catch: Throwable -> L8
            this.mExecutor = r10;     // Catch: Throwable -> L8
        L13:
            this.mExecutor.execute(new d(this, 0));     // Catch: Throwable -> L8
            monitor-exit(r5);     // Catch: Throwable -> L8
        }

        public void setExecutor(@NonNull Executor r5) {
            Object r10 = this.mLock;
            monitor-enter(r10);
            this.mExecutor = r5;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setRetryPolicy(@Nullable RetryPolicy r5) {
            Object r10 = this.mLock;
            monitor-enter(r10);
            this.mRetryPolicy = r5;     // Catch: Throwable -> L7
            monitor-exit(r10);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static abstract class RetryPolicy {
        public RetryPolicy() {
        }

        public abstract long getRetryDelay();
    }

    static {
        DEFAULT_FONTS_CONTRACT = new FontProviderHelper();
    }

    public FontRequestEmojiCompatConfig(@NonNull Context r5, @NonNull FontRequest r10) {
        super(new FontRequestMetadataLoader(r5, r10, DEFAULT_FONTS_CONTRACT));
    }

    @NonNull
    @Deprecated
    public FontRequestEmojiCompatConfig setHandler(@Nullable Handler r5) {
        if (r5 != null) goto L4;
        return this;
    L4:
        setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(r5));
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig setLoadingExecutor(@NonNull Executor r5) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setExecutor(r5);
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig setRetryPolicy(@Nullable RetryPolicy r5) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setRetryPolicy(r5);
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FontRequestEmojiCompatConfig(@NonNull Context r5, @NonNull FontRequest r10, @NonNull FontProviderHelper r11) {
        super(new FontRequestMetadataLoader(r5, r10, r11));
    }
}
