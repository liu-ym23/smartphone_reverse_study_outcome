package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Consumer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
class FontRequestWorker {
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = null;
    static final Object LOCK = null;
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES = null;
    static final LruCache<String, Typeface> sTypefaceCache = null;

    static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        TypefaceResult(int r2) {
            this.mTypeface = null;
            this.mResult = r2;
        }

        TypefaceResult(Typeface r1) {
            this.mTypeface = r1;
            this.mResult = 0;
        }

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

    private static String createCacheId(FontRequest r1, int r2) {
        return r1.getId() + "-" + r2;
    }

    private static int getFontFamilyResultStatus(FontsContractCompat.FontFamilyResult r5) {
        int r2 = 1;
        if (r5.getStatusCode() != 0) goto L5;
        FontsContractCompat.FontInfo[] r6 = r5.getFonts();
        if (r6 != null) goto L12;
    L23:
        return r2;
    L12:
        if (r6.length == 0) goto L23;
        int r0 = r6.length;
        r2 = 0;
        int r3 = 0;
    L15:
        if (r3 >= r0) goto L23;
        int r4 = r6[r3].getResultCode();
        if (r4 != 0) goto L18;
        r3 = r3 + 1;
        goto L15
    L18:
        if (r4 >= 0) goto L21;
        return -3;
    L21:
        return r4;
    L5:
        if (r5.getStatusCode() == 1) goto L7;
        return -3;
    L7:
        return -2;
    }

    static TypefaceResult getFontSync(String r4, Context r5, FontRequest r6, int r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        LruCache<String, Typeface> r0 = sTypefaceCache;
        Typeface r1 = (Typeface) ZeusTransformUtils.preCheckCast(r0.get(r4), Typeface.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L20;
        return new TypefaceResult(r1);
    L20:
        FontsContractCompat.FontFamilyResult r9 = FontProvider.getFontFamilyResult(r8, r6, null);     // Catch: PackageManager.NameNotFoundException -> L18
        int r2 = getFontFamilyResultStatus(r9);
        if (r2 != 0) goto L11;
        Typeface r10 = TypefaceCompat.createFromFontInfo(r8, null, r9.getFonts(), r7);
        if (r10 == null) goto L17;
        r0.put(r4, r10);
        return new TypefaceResult(r10);
    L17:
        return new TypefaceResult(-3);
    L11:
        return new TypefaceResult(r2);
    L19:
        return new TypefaceResult(-1);
    }

    static Typeface requestFontAsync(Context r6, final FontRequest r7, final int r8, Executor r9, final CallbackWithHandler r10) {
        final Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Executor r12 = (Executor) ZeusTransformUtils.wrapperContextForParams(r9, Executor.class, "com.obric.memorydata.plugin");
        final String r0 = createCacheId(r7, r8);
        Typeface r1 = (Typeface) ZeusTransformUtils.preCheckCast(sTypefaceCache.get(r0), Typeface.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r10.onTypefaceResult(new TypefaceResult(r1));
        return r1;
    L6:
        Consumer<TypefaceResult> r2 = new AnonymousClass2(r10);
        Object r13 = LOCK;
        monitor-enter(r13);
        SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> r3 = PENDING_REPLIES;     // Catch: Throwable -> L20
        ArrayList r4 = (ArrayList) ZeusTransformUtils.preCheckCast(r3.get(r0), ArrayList.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r4 == null) goto L13;
        r4.add(r2);     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        return null;
    L13:
        ArrayList<Consumer<TypefaceResult>> r5 = new ArrayList();     // Catch: Throwable -> L20
        r5.add(r2);     // Catch: Throwable -> L20
        r3.put(r0, r5);     // Catch: Throwable -> L20
        monitor-exit(r13);     // Catch: Throwable -> L20
        Callable<TypefaceResult> r14 = new AnonymousClass3(r0, r11, r7, r8);
        if (r12 != null) goto L18;
        r12 = DEFAULT_EXECUTOR_SERVICE;
    L18:
        RequestExecutor.execute(r12, r14, new AnonymousClass4(r0));
        return null;
    L20:
        th = move-exception;
        throw th;
    }

    static Typeface requestFontSync(Context r4, final FontRequest r5, CallbackWithHandler r6, final int r7, int r8) {
        final Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        final String r0 = createCacheId(r5, r7);
        Typeface r2 = (Typeface) ZeusTransformUtils.preCheckCast(sTypefaceCache.get(r0), Typeface.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        r6.onTypefaceResult(new TypefaceResult(r2));
        return r2;
    L7:
        if (r8 != (-1)) goto L10;
        TypefaceResult r10 = getFontSync(r0, r9, r5, r7);
        r6.onTypefaceResult(r10);
        return r10.mTypeface;
    L10:
        Callable<TypefaceResult> r3 = new AnonymousClass1(r0, r9, r5, r7);
        TypefaceResult r11 = (TypefaceResult) ZeusTransformUtils.preCheckCast(RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, r3, r8), TypefaceResult.class, "com.obric.memorydata.plugin");     // Catch: InterruptedException -> L13
        r6.onTypefaceResult(r11);     // Catch: InterruptedException -> L13
        return r11.mTypeface;
    L13:
        r6.onTypefaceResult(new TypefaceResult(-3));
        return null;
    }

    static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }
}
