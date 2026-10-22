package androidx.appcompat.app;

import android.content.res.Resources;
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
    public static class Api16Impl {
        private Api16Impl() {
        }

        @DoNotInline
        public static void clear(LongSparseArray r5) {
            r5.clear();
        }
    }

    private ResourcesFlusher() {
    }

    public static void flush(@NonNull Resources r5) {
    }

    @RequiresApi(21)
    private static void flushLollipops(@NonNull Resources r5) {
        if (sDrawableCacheFieldFetched == false) goto L21;
    L10:
        Field r10 = sDrawableCacheField;
        if (r10 == null) goto L23;
        Map r11 = (Map) r10.get(r5);     // Catch: IllegalAccessException -> L14
    L16:
        if (r11 == null) goto L24;
        r11.clear();
        return;
    L24:
        return;
    L14:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e);
        r11 = null;
        goto L16
    L23:
        return;
    L21:
        Field r12 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L7
        sDrawableCacheField = r12;     // Catch: NoSuchFieldException -> L7
        r12.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        sDrawableCacheFieldFetched = true;
    L7:
        e = move-exception;
        Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
        goto L9
    }

    @RequiresApi(23)
    private static void flushMarshmallows(@NonNull Resources r5) {
        if (sDrawableCacheFieldFetched == false) goto L23;
    L10:
        Field r10 = sDrawableCacheField;
        if (r10 != null) goto L21;
    L16:
        Object r11 = null;
    L17:
        if (r11 != null) goto L19;
        return;
    L19:
        flushThemedResourcesCache(r11);
        return;
    L21:
        r11 = r10.get(r5);     // Catch: IllegalAccessException -> L14
    L14:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from Resources#mDrawableCache", e);
        goto L16
    L23:
        Field r12 = Resources.class.getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L7
        sDrawableCacheField = r12;     // Catch: NoSuchFieldException -> L7
        r12.setAccessible(true);     // Catch: NoSuchFieldException -> L7
    L9:
        sDrawableCacheFieldFetched = true;
    L7:
        e = move-exception;
        Log.e(TAG, "Could not retrieve Resources#mDrawableCache field", e);
        goto L9
    }

    @RequiresApi(24)
    private static void flushNougats(@NonNull Resources r5) {
        if (sResourcesImplFieldFetched == false) goto L41;
    L9:
        Field r10 = sResourcesImplField;
        if (r10 != null) goto L12;
        return;
    L12:
        Object r11 = null;
        Object r12 = r10.get(r5);     // Catch: IllegalAccessException -> L15
    L17:
        if (r12 != null) goto L20;
        return;
    L20:
        if (sDrawableCacheFieldFetched == false) goto L35;
    L26:
        Field r13 = sDrawableCacheField;
        if (r13 != null) goto L39;
    L32:
        if (r11 == null) goto L43;
        flushThemedResourcesCache(r11);
        return;
    L43:
        return;
    L39:
        r11 = r13.get(r12);     // Catch: IllegalAccessException -> L30
    L30:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from ResourcesImpl#mDrawableCache", e);
        goto L32
    L35:
        Field r14 = r12.getClass().getDeclaredField("mDrawableCache");     // Catch: NoSuchFieldException -> L23
        sDrawableCacheField = r14;     // Catch: NoSuchFieldException -> L23
        r14.setAccessible(true);     // Catch: NoSuchFieldException -> L23
    L25:
        sDrawableCacheFieldFetched = true;
    L23:
        e = move-exception;
        Log.e(TAG, "Could not retrieve ResourcesImpl#mDrawableCache field", e);
    L15:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from Resources#mResourcesImpl", e);
        r12 = null;
        goto L17
    L41:
        Field r15 = Resources.class.getDeclaredField("mResourcesImpl");     // Catch: NoSuchFieldException -> L6
        sResourcesImplField = r15;     // Catch: NoSuchFieldException -> L6
        r15.setAccessible(true);     // Catch: NoSuchFieldException -> L6
    L8:
        sResourcesImplFieldFetched = true;
    L6:
        e = move-exception;
        Log.e(TAG, "Could not retrieve Resources#mResourcesImpl field", e);
        goto L8
    }

    @RequiresApi(16)
    private static void flushThemedResourcesCache(@NonNull Object r5) {
        if (sThemedResourceCacheClazzFetched == false) goto L33;
    L9:
        Class<?> r10 = sThemedResourceCacheClazz;
        if (r10 != null) goto L13;
        return;
    L13:
        if (sThemedResourceCache_mUnthemedEntriesFieldFetched == false) goto L29;
    L19:
        Field r11 = sThemedResourceCache_mUnthemedEntriesField;
        if (r11 != null) goto L31;
        return;
    L31:
        LongSparseArray r12 = (LongSparseArray) r11.get(r5);     // Catch: IllegalAccessException -> L24
    L26:
        if (r12 == null) goto L35;
        Api16Impl.clear(r12);
        return;
    L35:
        return;
    L24:
        e = move-exception;
        Log.e(TAG, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e);
        r12 = null;
        goto L26
    L29:
        Field r13 = r10.getDeclaredField("mUnthemedEntries");     // Catch: NoSuchFieldException -> L16
        sThemedResourceCache_mUnthemedEntriesField = r13;     // Catch: NoSuchFieldException -> L16
        r13.setAccessible(true);     // Catch: NoSuchFieldException -> L16
    L18:
        sThemedResourceCache_mUnthemedEntriesFieldFetched = true;
    L16:
        e = move-exception;
        Log.e(TAG, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e);
        goto L18
    L33:
        sThemedResourceCacheClazz = Class.forName("android.content.res.ThemedResourceCache");     // Catch: ClassNotFoundException -> L6
    L8:
        sThemedResourceCacheClazzFetched = true;
    L6:
        e = move-exception;
        Log.e(TAG, "Could not find ThemedResourceCache class", e);
        goto L8
    }
}
