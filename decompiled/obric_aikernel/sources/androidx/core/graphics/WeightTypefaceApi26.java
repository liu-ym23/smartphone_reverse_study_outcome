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
        Field r10 = null;
        Field r11 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Throwable -> L5
        Class r12 = Long.TYPE;     // Catch: Throwable -> L5
        Method r13 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_WITH_EXACT_STYLE_METHOD, new Class[]{r12, Integer.TYPE, Boolean.TYPE});     // Catch: Throwable -> L5
        r13.setAccessible(true);     // Catch: Throwable -> L5
        Constructor<Typeface> r14 = Typeface.class.getDeclaredConstructor(new Class[]{r12});     // Catch: Throwable -> L5
        r14.setAccessible(true);     // Catch: Throwable -> L5
        r10 = r11;
    L7:
        sNativeInstance = r10;
        sNativeCreateFromTypefaceWithExactStyle = r13;
        sConstructor = r14;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L5:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r13 = null;
        r14 = null;
        goto L7
    }

    private WeightTypefaceApi26() {
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
        long r15 = getNativeInstance(r10);     // Catch: Throwable -> L18
        LongSparseArray<SparseArray<Typeface>> r16 = sWeightTypefaceCache;     // Catch: Throwable -> L18
        SparseArray<Typeface> r17 = r16.get(r15);     // Catch: Throwable -> L18
        if (r17 != null) goto L11;
        r17 = new SparseArray(4);     // Catch: Throwable -> L18
        r16.put(r15, r17);     // Catch: Throwable -> L18
    L15:
        Typeface r18 = create(nativeCreateFromTypefaceWithExactStyle(r15, r11, r12));     // Catch: Throwable -> L18
        r17.put(r13 == true ? 1 : 0, r18);     // Catch: Throwable -> L18
        monitor-exit(r14);     // Catch: Throwable -> L18
        return r18;
    L11:
        Typeface r19 = r17.get(r13 == true ? 1 : 0);     // Catch: Throwable -> L18
        if (r19 == null) goto L15;
        monitor-exit(r14);     // Catch: Throwable -> L18
        return r19;
    L18:
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
        return ((Long) sNativeCreateFromTypefaceWithExactStyle.invoke(null, new Object[]{Long.valueOf(r10), Integer.valueOf(r11), Boolean.valueOf(r12)})).longValue();
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}
