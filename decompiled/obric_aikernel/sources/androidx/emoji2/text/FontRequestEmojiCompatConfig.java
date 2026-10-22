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

        public ExponentialBackoffRetryPolicy(long r10) {
            this.mTotalMs = r10;
        }

        @Override // androidx.emoji2.text.FontRequestEmojiCompatConfig.RetryPolicy
        public long getRetryDelay() {
            if (this.mRetryOrigin != 0) goto L6;
            this.mRetryOrigin = SystemClock.uptimeMillis();
            return 0;
        L6:
            long r10 = SystemClock.uptimeMillis() - this.mRetryOrigin;
            if (r10 <= this.mTotalMs) goto L11;
            return -1;
        L11:
            return Math.min(Math.max(r10, 1000), this.mTotalMs - r10);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class FontProviderHelper {
        public FontProviderHelper() {
        }

        @Nullable
        public Typeface buildTypeface(@NonNull Context r10, @NonNull FontsContractCompat.FontInfo r11) {
            return FontsContractCompat.buildTypeface(r10, null, new FontsContractCompat.FontInfo[]{r11});
        }

        @NonNull
        public FontsContractCompat.FontFamilyResult fetchFonts(@NonNull Context r10, @NonNull FontRequest r11) {
            return FontsContractCompat.fetchFonts(r10, null, r11);
        }

        public void registerObserver(@NonNull Context r10, @NonNull Uri r11, @NonNull ContentObserver r12) {
            r10.getContentResolver().registerContentObserver(r11, false, r12);
        }

        public void unregisterObserver(@NonNull Context r10, @NonNull ContentObserver r11) {
            r10.getContentResolver().unregisterContentObserver(r11);
        }
    }

    private static class FontRequestMetadataLoader implements EmojiCompat.MetadataRepoLoader {
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

        FontRequestMetadataLoader(@NonNull Context r10, @NonNull FontRequest r11, @NonNull FontProviderHelper r12) {
            this.mLock = new Object();
            Preconditions.checkNotNull(r10, "Context cannot be null");
            Preconditions.checkNotNull(r11, "FontRequest cannot be null");
            this.mContext = r10.getApplicationContext();
            this.mRequest = r11;
            this.mFontProviderHelper = r12;
        }

        private void cleanUp() {
            Object r10 = this.mLock;
            monitor-enter(r10);
            this.mCallback = null;     // Catch: Throwable -> L17
            ContentObserver r11 = this.mObserver;     // Catch: Throwable -> L17
            if (r11 == null) goto L8;
            this.mFontProviderHelper.unregisterObserver(this.mContext, r11);     // Catch: Throwable -> L17
            this.mObserver = null;     // Catch: Throwable -> L17
        L8:
            Handler r12 = this.mMainHandler;     // Catch: Throwable -> L17
            if (r12 == null) goto L11;
            r12.removeCallbacks(this.mMainHandlerLoadCallback);     // Catch: Throwable -> L17
        L11:
            this.mMainHandler = null;     // Catch: Throwable -> L17
            ThreadPoolExecutor r13 = this.mMyThreadPoolExecutor;     // Catch: Throwable -> L17
            if (r13 == null) goto L14;
            r13.shutdown();     // Catch: Throwable -> L17
        L14:
            this.mExecutor = null;     // Catch: Throwable -> L17
            this.mMyThreadPoolExecutor = null;     // Catch: Throwable -> L17
            monitor-exit(r10);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        }

        @WorkerThread
        private FontsContractCompat.FontInfo retrieveFontInfo() {
            FontsContractCompat.FontFamilyResult r10 = this.mFontProviderHelper.fetchFonts(this.mContext, this.mRequest);     // Catch: PackageManager.NameNotFoundException -> L15
            if (r10.getStatusCode() != 0) goto L14;
            FontsContractCompat.FontInfo[] r11 = r10.getFonts();
            if (r11 == null) goto L12;
            if (r11.length == 0) goto L12;
            return r11[0];
        L12:
            throw new RuntimeException("fetchFonts failed (empty result)");
        L14:
            throw new RuntimeException("fetchFonts failed (" + r10.getStatusCode() + ")");
        L15:
            e = move-exception;
            throw new RuntimeException("provider not found", e);
        }

        @RequiresApi(19)
        @WorkerThread
        private void scheduleRetry(Uri r10, long r11) {
            Object r12 = this.mLock;
            monitor-enter(r12);
            final Handler r13 = this.mMainHandler;     // Catch: Throwable -> L16
            if (r13 != null) goto L8;
            r13 = ConcurrencyHelpers.mainHandlerAsync();     // Catch: Throwable -> L16
            this.mMainHandler = r13;     // Catch: Throwable -> L16
        L8:
            if (this.mObserver != null) goto L11;
            ContentObserver r14 = new AnonymousClass1(this, r13);     // Catch: Throwable -> L16
            this.mObserver = r14;     // Catch: Throwable -> L16
            this.mFontProviderHelper.registerObserver(this.mContext, r10, r14);     // Catch: Throwable -> L16
        L11:
            if (this.mMainHandlerLoadCallback != null) goto L13;
            this.mMainHandlerLoadCallback = new e(this);     // Catch: Throwable -> L16
        L13:
            r13.postDelayed(this.mMainHandlerLoadCallback, r11);     // Catch: Throwable -> L16
            monitor-exit(r12);     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @RequiresApi(19)
        @WorkerThread
        void createMetadata() {
            Object r10 = this.mLock;
            monitor-enter(r10);
        L60:
            th = move-exception;
            throw th;
        L5:
            if (this.mCallback != null) goto L8;
            monitor-exit(r10);     // Catch: Throwable -> L60
            return;
        L8:
            monitor-exit(r10);     // Catch: Throwable -> L60
            FontsContractCompat.FontInfo r11 = retrieveFontInfo();     // Catch: Throwable -> L48
            int r12 = r11.getResultCode();     // Catch: Throwable -> L48
            if (r12 != 2) goto L25;
            Object r13 = this.mLock;     // Catch: Throwable -> L48
            monitor-enter(r13);     // Catch: Throwable -> L48
            RetryPolicy r14 = this.mRetryPolicy;     // Catch: Throwable -> L22
            if (r14 == null) goto L20;
            long r15 = r14.getRetryDelay();     // Catch: Throwable -> L22
            if (r15 < 0) goto L20;
            scheduleRetry(r11.getUri(), r15);     // Catch: Throwable -> L22
            monitor-exit(r13);     // Catch: Throwable -> L22
            return;
        L20:
            monitor-exit(r13);     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L25:
            if (r12 != 0) goto L47;
            TraceCompat.beginSection(S_TRACE_BUILD_TYPEFACE);     // Catch: Throwable -> L43
            Typeface r16 = this.mFontProviderHelper.buildTypeface(this.mContext, r11);     // Catch: Throwable -> L43
            ByteBuffer r17 = TypefaceCompatUtil.mmap(this.mContext, null, r11.getUri());     // Catch: Throwable -> L43
            if (r17 == null) goto L42;
            if (r16 == null) goto L42;
            MetadataRepo r18 = MetadataRepo.create(r16, r17);     // Catch: Throwable -> L43
            TraceCompat.endSection();     // Catch: Throwable -> L48
            Object r19 = this.mLock;     // Catch: Throwable -> L48
            monitor-enter(r19);     // Catch: Throwable -> L48
            EmojiCompat.MetadataRepoLoaderCallback r20 = this.mCallback;     // Catch: Throwable -> L38
            if (r20 == null) goto L35;
            r20.onLoaded(r18);     // Catch: Throwable -> L38
        L35:
            monitor-exit(r19);     // Catch: Throwable -> L38
            cleanUp();     // Catch: Throwable -> L48
            return;
        L38:
            th = move-exception;
            throw th;     // Catch: Throwable -> L48
        L42:
            throw new RuntimeException("Unable to open file.");     // Catch: Throwable -> L43
        L43:
            th = move-exception;
            TraceCompat.endSection();     // Catch: Throwable -> L48
            throw th;     // Catch: Throwable -> L48
        L47:
            throw new RuntimeException("fetchFonts result is not OK. (" + r12 + ")");     // Catch: Throwable -> L48
        L48:
            th = move-exception;
            monitor-enter(this.mLock);
            EmojiCompat.MetadataRepoLoaderCallback r21 = this.mCallback;     // Catch: Throwable -> L57
            if (r21 == null) goto L54;
            r21.onFailed(th);     // Catch: Throwable -> L57
        L54:
            cleanUp();
            return;
        L57:
            th = move-exception;
            throw th;
        }

        @Override // androidx.emoji2.text.EmojiCompat.MetadataRepoLoader
        @RequiresApi(19)
        public void load(@NonNull EmojiCompat.MetadataRepoLoaderCallback r10) {
            Preconditions.checkNotNull(r10, "LoaderCallback cannot be null");
            Object r11 = this.mLock;
            monitor-enter(r11);
            this.mCallback = r10;     // Catch: Throwable -> L8
            monitor-exit(r11);     // Catch: Throwable -> L8
            loadInternal();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @RequiresApi(19)
        void loadInternal() {
            Object r10 = this.mLock;
            monitor-enter(r10);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.mCallback != null) goto L9;
            monitor-exit(r10);     // Catch: Throwable -> L14
            return;
        L9:
            if (this.mExecutor != null) goto L11;
            ThreadPoolExecutor r11 = ConcurrencyHelpers.createBackgroundPriorityExecutor("emojiCompat");     // Catch: Throwable -> L14
            this.mMyThreadPoolExecutor = r11;     // Catch: Throwable -> L14
            this.mExecutor = r11;     // Catch: Throwable -> L14
        L11:
            this.mExecutor.execute(new d(this));     // Catch: Throwable -> L14
            monitor-exit(r10);     // Catch: Throwable -> L14
        }

        public void setExecutor(@NonNull Executor r10) {
            Object r11 = this.mLock;
            monitor-enter(r11);
            this.mExecutor = r10;     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        public void setRetryPolicy(@Nullable RetryPolicy r10) {
            Object r11 = this.mLock;
            monitor-enter(r11);
            this.mRetryPolicy = r10;     // Catch: Throwable -> L7
            monitor-exit(r11);     // Catch: Throwable -> L7
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

    public FontRequestEmojiCompatConfig(@NonNull Context r10, @NonNull FontRequest r11) {
        super(new FontRequestMetadataLoader(r10, r11, DEFAULT_FONTS_CONTRACT));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public FontRequestEmojiCompatConfig(@NonNull Context r10, @NonNull FontRequest r11, @NonNull FontProviderHelper r12) {
        super(new FontRequestMetadataLoader(r10, r11, r12));
    }

    @NonNull
    @Deprecated
    public FontRequestEmojiCompatConfig setHandler(@Nullable Handler r10) {
        if (r10 != null) goto L4;
        return this;
    L4:
        setLoadingExecutor(ConcurrencyHelpers.convertHandlerToExecutor(r10));
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig setLoadingExecutor(@NonNull Executor r10) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setExecutor(r10);
        return this;
    }

    @NonNull
    public FontRequestEmojiCompatConfig setRetryPolicy(@Nullable RetryPolicy r10) {
        ((FontRequestMetadataLoader) getMetadataRepoLoader()).setRetryPolicy(r10);
        return this;
    }
}
