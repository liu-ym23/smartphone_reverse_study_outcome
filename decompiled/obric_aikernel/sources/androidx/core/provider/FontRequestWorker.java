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

    static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        TypefaceResult(int r10) {
            this.mTypeface = null;
            this.mResult = r10;
        }

        @SuppressLint({"WrongConstant"})
        TypefaceResult(@NonNull Typeface r10) {
            this.mTypeface = r10;
            this.mResult = 0;
        }

        @SuppressLint({"WrongConstant"})
        boolean isSuccess() {
            if (this.mResult != 0) goto L5;
            return true;
        L5:
            return false;
        }
    }

    static {
        sTypefaceCache = new LruCache(16);
        DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
        LOCK = new Object();
        PENDING_REPLIES = new SimpleArrayMap();
    }

    private FontRequestWorker() {
    }

    private static String createCacheId(@NonNull FontRequest r10, int r11) {
        return r10.getId() + "-" + r11;
    }

    @SuppressLint({"WrongConstant"})
    private static int getFontFamilyResultStatus(@NonNull FontsContractCompat.FontFamilyResult r10) {
        int r11 = 1;
        if (r10.getStatusCode() != 0) goto L5;
        FontsContractCompat.FontInfo[] r12 = r10.getFonts();
        if (r12 != null) goto L12;
    L23:
        return r11;
    L12:
        if (r12.length == 0) goto L23;
        int r13 = r12.length;
        r11 = 0;
        int r14 = 0;
    L15:
        if (r14 >= r13) goto L23;
        int r15 = r12[r14].getResultCode();
        if (r15 != 0) goto L18;
        r14 = r14 + 1;
        goto L15
    L18:
        if (r15 >= 0) goto L21;
        return -3;
    L21:
        return r15;
    L5:
        if (r10.getStatusCode() == 1) goto L7;
        return -3;
    L7:
        return -2;
    }

    @NonNull
    static TypefaceResult getFontSync(@NonNull String r10, @NonNull Context r11, @NonNull FontRequest r12, int r13) {
        LruCache<String, Typeface> r14 = sTypefaceCache;
        Typeface r15 = r14.get(r10);
        if (r15 == null) goto L20;
        return new TypefaceResult(r15);
    L20:
        FontsContractCompat.FontFamilyResult r16 = FontProvider.getFontFamilyResult(r11, r12, null);     // Catch: PackageManager.NameNotFoundException -> L18
        int r17 = getFontFamilyResultStatus(r16);
        if (r17 != 0) goto L11;
        Typeface r18 = TypefaceCompat.createFromFontInfo(r11, null, r16.getFonts(), r13);
        if (r18 == null) goto L17;
        r14.put(r10, r18);
        return new TypefaceResult(r18);
    L17:
        return new TypefaceResult(-3);
    L11:
        return new TypefaceResult(r17);
    L19:
        return new TypefaceResult(-1);
    }

    static Typeface requestFontAsync(@NonNull final Context r10, @NonNull final FontRequest r11, final int r12, @Nullable Executor r13, @NonNull final CallbackWithHandler r14) {
        final String r15 = createCacheId(r11, r12);
        Typeface r16 = sTypefaceCache.get(r15);
        if (r16 == null) goto L6;
        r14.onTypefaceResult(new TypefaceResult(r16));
        return r16;
    L6:
        Consumer<TypefaceResult> r17 = new AnonymousClass2(r14);
        Object r18 = LOCK;
        monitor-enter(r18);
        SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> r19 = PENDING_REPLIES;     // Catch: Throwable -> L20
        ArrayList<Consumer<TypefaceResult>> r20 = r19.get(r15);     // Catch: Throwable -> L20
        if (r20 == null) goto L13;
        r20.add(r17);     // Catch: Throwable -> L20
        monitor-exit(r18);     // Catch: Throwable -> L20
        return null;
    L13:
        ArrayList<Consumer<TypefaceResult>> r21 = new ArrayList();     // Catch: Throwable -> L20
        r21.add(r17);     // Catch: Throwable -> L20
        r19.put(r15, r21);     // Catch: Throwable -> L20
        monitor-exit(r18);     // Catch: Throwable -> L20
        Callable<TypefaceResult> r22 = new AnonymousClass3(r15, r10, r11, r12);
        if (r13 != null) goto L18;
        r13 = DEFAULT_EXECUTOR_SERVICE;
    L18:
        RequestExecutor.execute(r13, r22, new AnonymousClass4(r15));
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    static Typeface requestFontSync(@NonNull final Context r10, @NonNull final FontRequest r11, @NonNull CallbackWithHandler r12, final int r13, int r14) {
        final String r15 = createCacheId(r11, r13);
        Typeface r16 = sTypefaceCache.get(r15);
        if (r16 == null) goto L7;
        r12.onTypefaceResult(new TypefaceResult(r16));
        return r16;
    L7:
        if (r14 != (-1)) goto L10;
        TypefaceResult r17 = getFontSync(r15, r10, r11, r13);
        r12.onTypefaceResult(r17);
        return r17.mTypeface;
    L10:
        Callable<TypefaceResult> r18 = new AnonymousClass1(r15, r10, r11, r13);
        TypefaceResult r19 = (TypefaceResult) RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, r18, r14);     // Catch: InterruptedException -> L13
        r12.onTypefaceResult(r19);     // Catch: InterruptedException -> L13
        return r19.mTypeface;
    L13:
        r12.onTypefaceResult(new TypefaceResult(-3));
        return null;
    }

    static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }
}
