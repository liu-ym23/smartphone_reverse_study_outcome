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
        Field r5 = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);     // Catch: Exception -> L4
        r5.setAccessible(true);     // Catch: Exception -> L4
    L6:
        sNativeInstance = r5;
        sWeightTypefaceCache = new LongSparseArray(3);
        sWeightCacheLock = new Object();
        return;
    L4:
        e = move-exception;
        Log.e(TAG, e.getClass().getName(), e);
        r5 = null;
        goto L6
    }

    private WeightTypefaceApi14() {
    }

    @Nullable
    public static Typeface createWeightStyle(@NonNull TypefaceCompatBaseImpl r10, @NonNull Context r11, @NonNull Typeface r12, int r13, boolean r14) {
        if (isPrivateApiAvailable() == true) goto L6;
        return null;
    L6:
        int r5 = (r13 << 1) | (r14 ? 1 : 0);
        Object r15 = sWeightCacheLock;
        monitor-enter(r15);
        long r16 = getNativeInstance(r12);     // Catch: Throwable -> L11
        LongSparseArray<SparseArray<Typeface>> r17 = sWeightTypefaceCache;     // Catch: Throwable -> L11
        SparseArray<Typeface> r18 = r17.get(r16);     // Catch: Throwable -> L11
        if (r18 != null) goto L13;
        r18 = new SparseArray(4);     // Catch: Throwable -> L11
        r17.put(r16, r18);     // Catch: Throwable -> L11
    L17:
        Typeface r19 = getBestFontFromFamily(r10, r11, r12, r13, r14);     // Catch: Throwable -> L11
        if (r19 != null) goto L20;
        r19 = platformTypefaceCreate(r12, r13, r14);     // Catch: Throwable -> L11
    L20:
        r18.put(r5 == true ? 1 : 0, r19);     // Catch: Throwable -> L11
        monitor-exit(r15);     // Catch: Throwable -> L11
        return r19;
    L13:
        Typeface r20 = r18.get(r5 == true ? 1 : 0);     // Catch: Throwable -> L11
        if (r20 == null) goto L17;
        monitor-exit(r15);     // Catch: Throwable -> L11
        return r20;
    L11:
        th = move-exception;
        throw th;
    }

    @Nullable
    private static Typeface getBestFontFromFamily(@NonNull TypefaceCompatBaseImpl r10, @NonNull Context r11, @NonNull Typeface r12, int r13, boolean r14) {
        FontResourcesParserCompat.FontFamilyFilesResourceEntry r5 = r10.getFontFamily(r12);
        if (r5 != null) goto L7;
        return null;
    L7:
        return r10.createFromFontFamilyFilesResourceEntry(r11, r5, r11.getResources(), r13, r14);
    }

    private static long getNativeInstance(@NonNull Typeface r5) {
        return ((Number) sNativeInstance.get(r5)).longValue();
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

    private static Typeface platformTypefaceCreate(Typeface r5, int r10, boolean r11) {
        int r12 = 0;
        if (r10 < 600) goto L5;
        boolean r13 = true;
    L6:
        if (r13 == true) goto L9;
        if (r11 == true) goto L9;
    L15:
        return Typeface.create(r5, r12);
    L9:
        if (r13 == true) goto L11;
        r12 = 2;
        goto L15
    L11:
        if (r11 == true) goto L13;
        r12 = 1;
        goto L15
    L13:
        r12 = 3;
        goto L15
    L5:
        r13 = false;
        goto L6
    }
}
