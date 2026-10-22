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
@RequiresApi(21)
@SuppressLint({"SoonBlockedPrivateApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class WeightTypefaceApi21 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_METHOD = "nativeCreateFromTypeface";
    private static final String NATIVE_CREATE_WEIGHT_ALIAS_METHOD = "nativeCreateWeightAlias";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor = null;
    private static final Method sNativeCreateFromTypeface = null;
    private static final Method sNativeCreateWeightAlias = null;
    private static final Field sNativeInstance = null;
    private static final Object sWeightCacheLock = null;

    @GuardedBy("sWeightCacheLock")
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = null;

    static {
        Field r10 = null;
        Field r11 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Throwable -> L5
        Class r12 = Long.TYPE;     // Catch: Throwable -> L5
        Class r13 = Integer.TYPE;     // Catch: Throwable -> L5
        Method r14 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_METHOD, new Class[]{r12, r13});     // Catch: Throwable -> L5
        r14.setAccessible(true);     // Catch: Throwable -> L5
        Method r15 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_WEIGHT_ALIAS_METHOD, new Class[]{r12, r13});     // Catch: Throwable -> L5
        r15.setAccessible(true);     // Catch: Throwable -> L5
        Constructor<Typeface> r16 = Typeface.class.getDeclaredConstructor(new Class[]{r12});     // Catch: Throwable -> L5
        r16.setAccessible(true);     // Catch: Throwable -> L5
        r10 = r11;
    L7:
        sNativeInstance = r10;
        sNativeCreateFromTypeface = r14;
        sNativeCreateWeightAlias = r15;
        sConstructor = r16;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L5:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r14 = null;
        r15 = null;
        r16 = null;
        goto L7
    }

    private WeightTypefaceApi21() {
    }

    @Nullable
    private static Typeface create(long r10) {
        return sConstructor.newInstance(new Object[]{Long.valueOf(r10)});
    L5:
        return null;
    }

    @Nullable
    static Typeface createWeightStyle(@NonNull Typeface r10, int r11, boolean r12) {
        if (isPrivateApiAvailable() == true) goto L6;
        return null;
    L6:
        int r13 = (r11 << 1) | (r12 ? 1 : 0);
        Object r14 = sWeightCacheLock;
        monitor-enter(r14);
        long r15 = getNativeInstance(r10);     // Catch: Throwable -> L23
        LongSparseArray<SparseArray<Typeface>> r16 = sWeightTypefaceCache;     // Catch: Throwable -> L23
        SparseArray<Typeface> r17 = r16.get(r15);     // Catch: Throwable -> L23
        if (r17 != null) goto L11;
        r17 = new SparseArray(4);     // Catch: Throwable -> L23
        r16.put(r15, r17);     // Catch: Throwable -> L23
    L16:
        if (r12 != r10.isItalic()) goto L19;
        long r18 = nativeCreateWeightAlias(r15, r11);     // Catch: Throwable -> L23
    L18:
        Typeface r19 = create(r18);     // Catch: Throwable -> L23
        r17.put(r13 == true ? 1 : 0, r19);     // Catch: Throwable -> L23
        monitor-exit(r14);     // Catch: Throwable -> L23
        return r19;
    L19:
        r18 = nativeCreateFromTypefaceWithExactStyle(r15, r11, r12);     // Catch: Throwable -> L23
        goto L18
    L11:
        Typeface r20 = r17.get(r13 == true ? 1 : 0);     // Catch: Throwable -> L23
        if (r20 == null) goto L16;
        monitor-exit(r14);     // Catch: Throwable -> L23
        return r20;
    L23:
        th = move-exception;
        throw th;
    }

    private static long getNativeInstance(@NonNull Typeface r10) {
        return sNativeInstance.getLong(r10);
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
    private static long nativeCreateFromTypefaceWithExactStyle(long r10, int r11, boolean r12) {
        if (r12 == false) goto L5;
        int r13 = 2;
    L14:
        return ((Long) sNativeCreateWeightAlias.invoke(null, new Object[]{Long.valueOf(((Long) sNativeCreateFromTypeface.invoke(null, new Object[]{Long.valueOf(r10), Integer.valueOf(r13)})).longValue()), Integer.valueOf(r11)})).longValue();
    L11:
        e = move-exception;
        throw new RuntimeException(e);
    L8:
        e = move-exception;
        throw new RuntimeException(e);
    L5:
        r13 = 0;
        goto L14
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long nativeCreateWeightAlias(long r10, int r11) {
        return ((Long) sNativeCreateWeightAlias.invoke(null, new Object[]{Long.valueOf(r10), Integer.valueOf(r11)})).longValue();
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
