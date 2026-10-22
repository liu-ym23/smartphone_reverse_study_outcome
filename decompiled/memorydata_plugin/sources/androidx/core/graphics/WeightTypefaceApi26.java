package androidx.core.graphics;

import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.collection.LongSparseArray;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
final class WeightTypefaceApi26 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_WITH_EXACT_STYLE_METHOD = "nativeCreateFromTypefaceWithExactStyle";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor = null;
    private static final Method sNativeCreateFromTypefaceWithExactStyle = null;
    private static final Field sNativeInstance = null;
    private static final Object sWeightCacheLock = null;
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = null;

    static {
        Field r1 = null;
        Field r2 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Throwable -> L5
        Method r3 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_WITH_EXACT_STYLE_METHOD, new Class[]{Long.TYPE, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L5
        r3.setAccessible(true);     // Catch: Throwable -> L5
        Constructor<Typeface> r4 = Typeface.class.getDeclaredConstructor(new Class[]{Long.TYPE});     // Catch: Throwable -> L5
        r4.setAccessible(true);     // Catch: Throwable -> L5
        r1 = r2;
    L7:
        sNativeInstance = r1;
        sNativeCreateFromTypefaceWithExactStyle = r3;
        sConstructor = r4;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L5:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r3 = null;
        r4 = null;
        goto L7
    }

    private WeightTypefaceApi26() {
    }

    private static Typeface create(long r4) {
        return (Typeface) ZeusTransformUtils.preCheckCast(sConstructor.newInstance(new Object[]{Long.valueOf(r4)}), Typeface.class, "com.obric.memorydata.plugin");
    L5:
        return null;
    }

    static Typeface createWeightStyle(Typeface r7, int r8, boolean r9) {
        if (isPrivateApiAvailable() == true) goto L6;
        return null;
    L6:
        int r0 = (r8 << 1) | (r9 ? 1 : 0);
        Object r1 = sWeightCacheLock;
        monitor-enter(r1);
        long r2 = getNativeInstance(r7);     // Catch: Throwable -> L18
        LongSparseArray<SparseArray<Typeface>> r10 = sWeightTypefaceCache;     // Catch: Throwable -> L18
        SparseArray<Typeface> r4 = (SparseArray) ZeusTransformUtils.preCheckCast(r10.get(r2), SparseArray.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r4 != null) goto L11;
        r4 = new SparseArray(4);     // Catch: Throwable -> L18
        r10.put(r2, r4);     // Catch: Throwable -> L18
    L15:
        Typeface r11 = create(nativeCreateFromTypefaceWithExactStyle(r2, r8, r9));     // Catch: Throwable -> L18
        r4.put(r0 == true ? 1 : 0, r11);     // Catch: Throwable -> L18
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r11;
    L11:
        Typeface r12 = (Typeface) ZeusTransformUtils.preCheckCast(r4.get(r0 == true ? 1 : 0), Typeface.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r12 == null) goto L15;
        monitor-exit(r1);     // Catch: Throwable -> L18
        return r12;
    L18:
        th = move-exception;
        throw th;
    }

    private static long getNativeInstance(Typeface r2) {
        return sNativeInstance.getLong(r2);
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

    private static long nativeCreateFromTypefaceWithExactStyle(long r4, int r6, boolean r7) {
        return ((Long) ZeusTransformUtils.preCheckCast(sNativeCreateFromTypefaceWithExactStyle.invoke(null, new Object[]{Long.valueOf(r4), Integer.valueOf(r6), Boolean.valueOf(r7)}), Long.class, "com.obric.memorydata.plugin")).longValue();
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
