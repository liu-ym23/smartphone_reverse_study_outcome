package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import androidx.core.content.res.FontResourcesParserCompat;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
final class WeightTypefaceApi14 {
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Field sNativeInstance = null;
    private static final Object sWeightCacheLock = null;

    @GuardedBy("sWeightCacheLock")
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache = null;

    static {
        Field r10 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Exception -> L4
        r10.setAccessible(true);     // Catch: Exception -> L4
    L6:
        sNativeInstance = r10;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L4:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r10 = null;
        goto L6
    }

    private WeightTypefaceApi14() {
    }

    @Nullable
    static Typeface createWeightStyle(@NonNull TypefaceCompatBaseImpl r10, @NonNull Context r11, @NonNull Typeface r12, int r13, boolean r14) {
        if (isPrivateApiAvailable() == true) goto L6;
        return null;
    L6:
        int r15 = (r13 << 1) | (r14 ? 1 : 0);
        Object r16 = sWeightCacheLock;
        monitor-enter(r16);
        long r17 = getNativeInstance(r12);     // Catch: Throwable -> L21
        LongSparseArray<SparseArray<Typeface>> r18 = sWeightTypefaceCache;     // Catch: Throwable -> L21
        SparseArray<Typeface> r19 = r18.get(r17);     // Catch: Throwable -> L21
        if (r19 != null) goto L11;
        r19 = new SparseArray(4);     // Catch: Throwable -> L21
        r18.put(r17, r19);     // Catch: Throwable -> L21
    L15:
        Typeface r20 = getBestFontFromFamily(r10, r11, r12, r13, r14);     // Catch: Throwable -> L21
        if (r20 != null) goto L18;
        r20 = platformTypefaceCreate(r12, r13, r14);     // Catch: Throwable -> L21
    L18:
        r19.put(r15 == true ? 1 : 0, r20);     // Catch: Throwable -> L21
        monitor-exit(r16);     // Catch: Throwable -> L21
        return r20;
    L11:
        Typeface r21 = r19.get(r15 == true ? 1 : 0);     // Catch: Throwable -> L21
        if (r21 == null) goto L15;
        monitor-exit(r16);     // Catch: Throwable -> L21
        return r21;
    L21:
        th = move-exception;
        throw th;
    }

    @Nullable
    private static Typeface getBestFontFromFamily(@NonNull TypefaceCompatBaseImpl r10, @NonNull Context r11, @NonNull Typeface r12, int r13, boolean r14) {
        FontResourcesParserCompat.FontFamilyFilesResourceEntry r15 = r10.getFontFamily(r12);
        if (r15 != null) goto L7;
        return null;
    L7:
        return r10.createFromFontFamilyFilesResourceEntry(r11, r15, r11.getResources(), r13, r14);
    }

    private static long getNativeInstance(@NonNull Typeface r10) {
        return ((Number) sNativeInstance.get(r10)).longValue();
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

    private static Typeface platformTypefaceCreate(Typeface r10, int r11, boolean r12) {
        int r13 = 1;
        if (r11 < 600) goto L5;
        boolean r14 = true;
    L6:
        if (r14 == true) goto L9;
        if (r12 == true) goto L9;
        r13 = 0;
    L15:
        return Typeface.create(r10, r13);
    L9:
        if (r14 == true) goto L11;
        r13 = 2;
        goto L15
    L11:
        if (r12 == false) goto L15;
        r13 = 3;
        goto L15
    L5:
        r14 = false;
        goto L6
    }
}
