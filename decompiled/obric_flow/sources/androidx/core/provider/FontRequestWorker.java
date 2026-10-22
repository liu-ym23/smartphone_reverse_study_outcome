package androidx.core.provider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Consumer;
import androidx.room.writer.DaoWriter;
import com.bytedance.keva.KevaImpl;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
class FontRequestWorker {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = null;
    static final Object LOCK = null;

    @GuardedBy("LOCK")
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES = null;
    static final LruCache<String, Typeface> sTypefaceCache = null;

    public static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        public TypefaceResult(int r5) {
            this.mTypeface = null;
            this.mResult = r5;
        }

        @SuppressLint({"WrongConstant"})
        public boolean isSuccess() {
            if (this.mResult != 0) goto L5;
            return true;
        L5:
            return false;
        }

        @SuppressLint({"WrongConstant"})
        public TypefaceResult(@NonNull Typeface r5) {
            this.mTypeface = r5;
            this.mResult = 0;
        }
    }

    static {
        sTypefaceCache = new LruCache(16);
        DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        LOCK = new Object();
        PENDING_REPLIES = new SimpleArrayMap();
    }

    private FontRequestWorker() {
    }

    private static String createCacheId(@NonNull FontRequest r5, int r10) {
        return r5.getId() + DaoWriter.PreparedStmtQuery.NO_PARAM_FIELD + r10;
    }

    @SuppressLint({"WrongConstant"})
    private static int getFontFamilyResultStatus(@NonNull FontsContractCompat.FontFamilyResult r5) {
        int r10 = 1;
        if (r5.getStatusCode() != 0) goto L5;
        FontsContractCompat.FontInfo[] r11 = r5.getFonts();
        if (r11 != null) goto L12;
    L23:
        return r10;
    L12:
        if (r11.length == 0) goto L23;
        int r12 = r11.length;
        r10 = 0;
        int r13 = 0;
    L15:
        if (r13 >= r12) goto L23;
        int r14 = r11[r13].getResultCode();
        if (r14 != 0) goto L18;
        r13 = r13 + 1;
        goto L15
    L18:
        if (r14 >= 0) goto L21;
        return -3;
    L21:
        return r14;
    L5:
        if (r5.getStatusCode() == 1) goto L7;
        return -3;
    L7:
        return -2;
    }

    @NonNull
    public static TypefaceResult getFontSync(@NonNull String r5, @NonNull Context r10, @NonNull FontRequest r11, int r12) {
        LruCache<String, Typeface> r13 = sTypefaceCache;
        Typeface r14 = r13.get(r5);
        if (r14 == null) goto L20;
        return new TypefaceResult(r14);
    L20:
        FontsContractCompat.FontFamilyResult r15 = FontProvider.getFontFamilyResult(r10, r11, null);     // Catch: PackageManager.NameNotFoundException -> L18
        int r16 = getFontFamilyResultStatus(r15);
        if (r16 != 0) goto L11;
        Typeface r17 = TypefaceCompat.createFromFontInfo(r10, null, r15.getFonts(), r12);
        if (r17 == null) goto L17;
        r13.put(r5, r17);
        return new TypefaceResult(r17);
    L17:
        return new TypefaceResult(-3);
    L11:
        return new TypefaceResult(r16);
    L19:
        return new TypefaceResult(-1);
    }

    public static Typeface requestFontAsync(@NonNull final Context r5, @NonNull final FontRequest r10, final int r11, @Nullable Executor r12, @NonNull final CallbackWithHandler r13) {
        final String r14 = createCacheId(r10, r11);
        Typeface r15 = sTypefaceCache.get(r14);
        if (r15 == null) goto L6;
        r13.onTypefaceResult(new TypefaceResult(r15));
        return r15;
    L6:
        Consumer<TypefaceResult> r16 = new AnonymousClass2(r13);
        Object r17 = LOCK;
        monitor-enter(r17);
        SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> r18 = PENDING_REPLIES;     // Catch: Throwable -> L13
        ArrayList<Consumer<TypefaceResult>> r19 = r18.get(r14);     // Catch: Throwable -> L13
        if (r19 == null) goto L15;
        r19.add(r16);     // Catch: Throwable -> L13
        monitor-exit(r17);     // Catch: Throwable -> L13
        return null;
    L15:
        ArrayList<Consumer<TypefaceResult>> r20 = new ArrayList();     // Catch: Throwable -> L13
        r20.add(r16);     // Catch: Throwable -> L13
        r18.put(r14, r20);     // Catch: Throwable -> L13
        monitor-exit(r17);     // Catch: Throwable -> L13
        Callable<TypefaceResult> r21 = new AnonymousClass3(r14, r5, r10, r11);
        if (r12 != null) goto L20;
        r12 = DEFAULT_EXECUTOR_SERVICE;
    L20:
        RequestExecutor.execute(r12, r21, new AnonymousClass4(r14));
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public static Typeface requestFontSync(@NonNull final Context r5, @NonNull final FontRequest r10, @NonNull CallbackWithHandler r11, final int r12, int r13) {
        final String r14 = createCacheId(r10, r12);
        Typeface r15 = sTypefaceCache.get(r14);
        if (r15 == null) goto L7;
        r11.onTypefaceResult(new TypefaceResult(r15));
        return r15;
    L7:
        if (r13 != (-1)) goto L10;
        TypefaceResult r16 = getFontSync(r14, r5, r10, r12);
        r11.onTypefaceResult(r16);
        return r16.mTypeface;
    L10:
        Callable<TypefaceResult> r17 = new AnonymousClass1(r14, r5, r10, r12);
        TypefaceResult r18 = (TypefaceResult) RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, r17, r13);     // Catch: InterruptedException -> L13
        r11.onTypefaceResult(r18);     // Catch: InterruptedException -> L13
        return r18.mTypeface;
    L13:
        r11.onTypefaceResult(new TypefaceResult(-3));
        return null;
    }

    public static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }
}
