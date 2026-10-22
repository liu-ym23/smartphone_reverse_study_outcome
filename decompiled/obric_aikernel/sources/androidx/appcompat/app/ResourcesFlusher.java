package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ResourcesFlusher {
    private static final String TAG = "ResourcesFlusher";
    private static Field sDrawableCacheField;
    private static boolean sDrawableCacheFieldFetched;
    private static Field sResourcesImplField;
    private static boolean sResourcesImplFieldFetched;
    private static Class<?> sThemedResourceCacheClazz;
    private static boolean sThemedResourceCacheClazzFetched;
    private static Field sThemedResourceCache_mUnthemedEntriesField;
    private static boolean sThemedResourceCache_mUnthemedEntriesFieldFetched;

    @RequiresApi(16)
    static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        static void clear(LongSparseArray r10) {
            r10.clear();
        }
    }

    private ResourcesFlusher() {
    }

    static void flush(@NonNull Resources r10) {
        int r11 = Build.VERSION.SDK_INT;
        if (r11 < 28) goto L6;
        return;
    L6:
        if (r11 < 24) goto L9;
        flushNougats(r10);
        return;
    L9:
        if (r11 < 23) goto L12;
        flushMarshmallows(r10);
        return;
    L12:
        if (r11 < 21) goto L17;
        flushLollipops(r10);
        return;
    }

    @RequiresApi(21)
    private static void flushLollipops(@NonNull Resources r10) {
        if (sDrawableCacheFieldFetched == false) goto L20;
    L10:
        Field r11 = sDrawableCacheField;
        if (r11 == null) goto L24;
        Map r12 = null;
        r12 = (Map) r11.get(r10);     // Catch: IllegalAccessException -> L15
    L17:
        if (r12 == null) goto L25;
        r12.clear();
        return;
    L25:
        return;
    L15:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e);
        goto L17
    L24:
        return;
    L20:
        Field r13 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L7
        sDrawableCacheField = r13;     // Catch: NoSuchFieldException -> L7
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        sDrawableCacheFieldFetched = true;
    L7:
        e = move-exception;
        Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
        goto L9
    }

    @RequiresApi(23)
    private static void flushMarshmallows(@NonNull Resources r10) {
        if (sDrawableCacheFieldFetched == false) goto L22;
    L10:
        Object r11 = null;
        Field r12 = sDrawableCacheField;
        if (r12 != null) goto L20;
    L16:
        if (r11 != null) goto L18;
        return;
    L18:
        flushThemedResourcesCache(r11);
        return;
    L20:
        r11 = r12.get(r10);     // Catch: IllegalAccessException -> L14
    L14:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e);
        goto L16
    L22:
        Field r13 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L7
        sDrawableCacheField = r13;     // Catch: NoSuchFieldException -> L7
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        sDrawableCacheFieldFetched = true;
    L7:
        e = move-exception;
        Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
        goto L9
    }

    @RequiresApi(24)
    private static void flushNougats(@NonNull Resources r10) {
        if (sResourcesImplFieldFetched == false) goto L41;
    L9:
        Field r11 = sResourcesImplField;
        if (r11 != null) goto L12;
        return;
    L12:
        Object r12 = null;
        Object r13 = r11.get(r10);     // Catch: IllegalAccessException -> L15
    L17:
        if (r13 != null) goto L20;
        return;
    L20:
        if (sDrawableCacheFieldFetched == false) goto L35;
    L26:
        Field r14 = sDrawableCacheField;
        if (r14 != null) goto L39;
    L32:
        if (r12 == null) goto L43;
        flushThemedResourcesCache(r12);
        return;
    L43:
        return;
    L39:
        r12 = r14.get(r13);     // Catch: IllegalAccessException -> L30
    L30:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from ResourcesImpl#mDrawableCache", e);
        goto L32
    L35:
        Field r15 = r13.getClass().getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L23
        sDrawableCacheField = r15;     // Catch: NoSuchFieldException -> L23
        r15.setAccessible(true);     // Catch: NoSuchFieldException -> L23
    L25:
        sDrawableCacheFieldFetched = true;
    L23:
        e = move-exception;
        Log.e(TAG, "Could not retrieve ResourcesImpl#mDrawableCache field", e);
    L15:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from Resources#mResourcesImpl", e);
        r13 = null;
        goto L17
    L41:
        Field r16 = Resources.class.getDeclaredField("mResourcesImpl");     // Catch: NoSuchFieldException -> L6
        sResourcesImplField = r16;     // Catch: NoSuchFieldException -> L6
        r16.setAccessible(true);     // Catch: NoSuchFieldException -> L6
    L8:
        sResourcesImplFieldFetched = true;
    L6:
        e = move-exception;
        Log.e(TAG, "Could not retrieve Resources#mResourcesImpl field", e);
        goto L8
    }

    @RequiresApi(16)
    private static void flushThemedResourcesCache(@NonNull Object r10) {
        if (sThemedResourceCacheClazzFetched == false) goto L34;
    L9:
        Class<?> r11 = sThemedResourceCacheClazz;
        if (r11 != null) goto L13;
        return;
    L13:
        if (sThemedResourceCache_mUnthemedEntriesFieldFetched == false) goto L32;
    L19:
        Field r12 = sThemedResourceCache_mUnthemedEntriesField;
        if (r12 != null) goto L22;
        return;
    L22:
        LongSparseArray r13 = null;
        r13 = (LongSparseArray) r12.get(r10);     // Catch: IllegalAccessException -> L25
    L27:
        if (r13 == null) goto L36;
        Api16Impl.clear(r13);
        return;
    L36:
        return;
    L25:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e);
        goto L27
    L32:
        Field r14 = r11.getDeclaredField("mUnthemedEntries");     // Catch: NoSuchFieldException -> L16
        sThemedResourceCache_mUnthemedEntriesField = r14;     // Catch: NoSuchFieldException -> L16
        r14.setAccessible(true);     // Catch: NoSuchFieldException -> L16
    L18:
        sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
    L16:
        e = move-exception;
        Log.e(TAG, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e);
        goto L18
    L34:
        sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");     // Catch: ClassNotFoundException -> L6
    L8:
        sThemedResourceCacheClazzFetched = true;
    L6:
        e = move-exception;
        Log.e(TAG, "Could not find ThemedResourceCache class", e);
        goto L8
    }
}
