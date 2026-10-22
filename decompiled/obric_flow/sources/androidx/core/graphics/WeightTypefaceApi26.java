package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
@SuppressLint({"SoonBlockedPrivateApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class WeightTypefaceApi26 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_WITH_EXACT_STYLE_METHOD = "nativeCreateFromTypefaceWithExactStyle";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor = null;
    private static final Method sNativeCreateFromTypefaceWithExactStyle = null;
    private static final Field sNativeInstance = null;
    private static final Object sWeightCacheLock = null;

    @GuardedBy("sWeightCacheLock")
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = null;

    static {
        Field r5 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Throwable -> L5
        Class r10 = Long.TYPE;     // Catch: Throwable -> L5
        Method r11 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_WITH_EXACT_STYLE_METHOD, new Class[]{r10, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L5
        r11.setAccessible(true);     // Catch: Throwable -> L5
        Constructor<Typeface> r12 = Typeface.class.getDeclaredConstructor(new Class[]{r10});     // Catch: Throwable -> L5
        r12.setAccessible(true);     // Catch: Throwable -> L5
    L7:
        sNativeInstance = r5;
        sNativeCreateFromTypefaceWithExactStyle = r11;
        sConstructor = r12;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L5:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r5 = null;
        r12 = null;
        r11 = null;
        goto L7
    }

    private WeightTypefaceApi26() {
    }

    @Nullable
    private static Typeface create(long r5) {
        return sConstructor.newInstance(new Object[]{Long.valueOf(r5)});
    L5:
        return null;
    }

    @Nullable
    public static Typeface createWeightStyle(@NonNull Typeface r10, int r11, boolean r12) {
        if (isPrivateApiAvailable() == true) goto L6;
        return null;
    L6:
        int r5 = (r11 << 1) | (r12 ? 1 : 0);
        Object r13 = sWeightCacheLock;
        monitor-enter(r13);
        long r14 = getNativeInstance(r10);     // Catch: Throwable -> L11
        LongSparseArray<SparseArray<Typeface>> r15 = sWeightTypefaceCache;     // Catch: Throwable -> L11
        SparseArray<Typeface> r16 = r15.get(r14);     // Catch: Throwable -> L11
        if (r16 != null) goto L13;
        r16 = new SparseArray(4);     // Catch: Throwable -> L11
        r15.put(r14, r16);     // Catch: Throwable -> L11
    L17:
        Typeface r17 = create(nativeCreateFromTypefaceWithExactStyle(r14, r11, r12));     // Catch: Throwable -> L11
        r16.put(r5 == true ? 1 : 0, r17);     // Catch: Throwable -> L11
        monitor-exit(r13);     // Catch: Throwable -> L11
        return r17;
    L13:
        Typeface r18 = r16.get(r5 == true ? 1 : 0);     // Catch: Throwable -> L11
        if (r18 == null) goto L17;
        monitor-exit(r13);     // Catch: Throwable -> L11
        return r18;
    L11:
        th = move-exception;
        throw th;
    }

    private static long getNativeInstance(@NonNull Typeface r5) {
        return sNativeInstance.getLong(r5);
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

    @SuppressLint({"BanUncheckedReflection"})
    private static long nativeCreateFromTypefaceWithExactStyle(long r5, int r10, boolean r11) {
        return ((Long) sNativeCreateFromTypefaceWithExactStyle.invoke(null, new Object[]{Long.valueOf(r5), Integer.valueOf(r10), Boolean.valueOf(r11)})).longValue();
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
