package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.FontResourcesParserCompat;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
final class WeightTypefaceApi14 {
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Field sNativeInstance = null;
    private static final Object sWeightCacheLock = null;
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = null;

    static {
        Field r0 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Exception -> L4
        r0.setAccessible(true);     // Catch: Exception -> L4
    L6:
        sNativeInstance = r0;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L4:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r0 = null;
        goto L6
    }

    private WeightTypefaceApi14() {
    }

    static Typeface createWeightStyle(TypefaceCompatBaseImpl r8, Context r9, Typeface r10, int r11, boolean r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        if (isPrivateApiAvailable() == true) goto L6;
        return null;
    L6:
        int r0 = (r11 << 1) | (r12 ? 1 : 0);
        Object r1 = sWeightCacheLock;
        monitor-enter(r1);
        long r2 = getNativeInstance(r10);     // Catch: Throwable -> L21
        LongSparseArray<SparseArray<Typeface>> r4 = sWeightTypefaceCache;     // Catch: Throwable -> L21
        SparseArray<Typeface> r5 = (SparseArray) ZeusTransformUtils.preCheckCast(r4.get(r2), SparseArray.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r5 != null) goto L11;
        r5 = new SparseArray(4);     // Catch: Throwable -> L21
        r4.put(r2, r5);     // Catch: Throwable -> L21
    L15:
        Typeface r14 = getBestFontFromFamily(r8, r13, r10, r11, r12);     // Catch: Throwable -> L21
        if (r14 != null) goto L18;
        r14 = platformTypefaceCreate(r10, r11, r12);     // Catch: Throwable -> L21
    L18:
        r5.put(r0 == true ? 1 : 0, r14);     // Catch: Throwable -> L21
        monitor-exit(r1);     // Catch: Throwable -> L21
        return r14;
    L11:
        Typeface r3 = (Typeface) ZeusTransformUtils.preCheckCast(r5.get(r0 == true ? 1 : 0), Typeface.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r3 == null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L21
        return r3;
    L21:
        th = move-exception;
        throw th;
    }

    private static Typeface getBestFontFromFamily(TypefaceCompatBaseImpl r8, Context r9, Typeface r10, int r11, boolean r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        FontResourcesParserCompat.FontFamilyFilesResourceEntry r4 = r8.getFontFamily(r10);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r8.createFromFontFamilyFilesResourceEntry(r3, r4, ZeusTransformUtils.getResources(r3, "com.obric.memorydata.plugin"), r11, r12);
    }

    private static long getNativeInstance(Typeface r2) {
        return ((Number) ZeusTransformUtils.preCheckCast(sNativeInstance.get(r2), Number.class, "com.obric.memorydata.plugin")).longValue();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private static boolean isPrivateApiAvailable() {
        if (sNativeInstance == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static Typeface platformTypefaceCreate(Typeface r3, int r4, boolean r5) {
        int r0 = 1;
        if (r4 < 600) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == true) goto L9;
        if (r5 == true) goto L9;
        r0 = 0;
    L15:
        return Typeface.create(r3, r0);
    L9:
        if (r6 == true) goto L11;
        r0 = 2;
        goto L15
    L11:
        if (r5 == false) goto L15;
        r0 = 3;
        goto L15
    L5:
        r6 = false;
        goto L6
    }
}
