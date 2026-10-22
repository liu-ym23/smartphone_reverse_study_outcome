package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class ResourcesCompat {

    @AnyRes
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";
    private static final Object sColorStateCacheLock = null;

    @GuardedBy("sColorStateCacheLock")
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> sColorStateCaches = null;
    private static final ThreadLocal<TypedValue> sTempTypedValue = null;

    @RequiresApi(15)
    static class Api15Impl {
        private Api15Impl() {
        }

        @DoNotInline
        static Drawable getDrawableForDensity(Resources r10, int r11, int r12) {
            return r10.getDrawableForDensity(r11, r12);
        }
    }

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Drawable getDrawable(Resources r10, int r11, Resources.Theme r12) {
            return r10.getDrawable(r11, r12);
        }

        @DoNotInline
        static Drawable getDrawableForDensity(Resources r10, int r11, int r12, Resources.Theme r13) {
            return r10.getDrawableForDensity(r11, r12, r13);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int getColor(Resources r10, int r11, Resources.Theme r12) {
            return r10.getColor(r11, r12);
        }

        @NonNull
        @DoNotInline
        static ColorStateList getColorStateList(@NonNull Resources r10, @ColorRes int r11, @Nullable Resources.Theme r12) {
            return r10.getColorStateList(r11, r12);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static float getFloat(@NonNull Resources r10, @DimenRes int r11) {
            return r10.getFloat(r11);
        }
    }

    private static class ColorStateListCacheEntry {
        final Configuration mConfiguration;
        final int mThemeHash;
        final ColorStateList mValue;

        ColorStateListCacheEntry(@NonNull ColorStateList r10, @NonNull Configuration r11, @Nullable Resources.Theme r12) {
            this.mValue = r10;
            this.mConfiguration = r11;
            if (r12 != null) goto L5;
            int r13 = 0;
        L6:
            this.mThemeHash = r13;
            return;
        L5:
            r13 = r12.hashCode();
            goto L6
        }
    }

    private static final class ColorStateListCacheKey {
        final Resources mResources;
        final Resources.Theme mTheme;

        ColorStateListCacheKey(@NonNull Resources r10, @Nullable Resources.Theme r11) {
            this.mResources = r10;
            this.mTheme = r11;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if (r10 != null) goto L8;
        L17:
            return false;
        L8:
            if (ColorStateListCacheKey.class != r10.getClass()) goto L17;
            ColorStateListCacheKey r11 = (ColorStateListCacheKey) r10;
            if (this.mResources.equals(r11.mResources) == false) goto L16;
            if (ObjectsCompat.equals(this.mTheme, r11.mTheme) == false) goto L16;
            return true;
        L16:
            return false;
        }

        public int hashCode() {
            return ObjectsCompat.hash(new Object[]{this.mResources, this.mTheme});
        }
    }

    public static abstract class FontCallback {
        public FontCallback() {
        }

        public static /* synthetic */ void a(FontCallback r10, int r11) {
            r10.lambda$callbackFailAsync$1(r11);
        }

        public static /* synthetic */ void b(FontCallback r10, Typeface r11) {
            r10.lambda$callbackSuccessAsync$0(r11);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler getHandler(@Nullable Handler r10) {
            if (r10 == null) goto L4;
            return r10;
        L4:
            return new Handler(Looper.getMainLooper());
        }

        private /* synthetic */ void lambda$callbackFailAsync$1(int r10) {
            onFontRetrievalFailed(r10);
        }

        private /* synthetic */ void lambda$callbackSuccessAsync$0(Typeface r10) {
            onFontRetrieved(r10);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(final int r10, @Nullable Handler r11) {
            getHandler(r11).post(new a(this, r10));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(@NonNull final Typeface r10, @Nullable Handler r11) {
            getHandler(r11).post(new b(this, r10));
        }

        public abstract void onFontRetrievalFailed(int r10);

        public abstract void onFontRetrieved(@NonNull Typeface r10);
    }

    public static final class ThemeCompat {

        @RequiresApi(23)
        static class Api23Impl {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = null;

            static {
                sRebaseMethodLock = new Object();
            }

            private Api23Impl() {
            }

            @SuppressLint({"BanUncheckedReflection"})
            static void rebase(@NonNull Resources.Theme r10) {
                Object r11 = sRebaseMethodLock;
                monitor-enter(r11);
            L21:
                th = move-exception;
                throw th;
            L6:
                if (sRebaseMethodFetched == false) goto L24;
            L13:
                Method r12 = sRebaseMethod;     // Catch: Throwable -> L21
                if (r12 != null) goto L26;
            L19:
                monitor-exit(r11);     // Catch: Throwable -> L21
                return;
            L26:
                r12.invoke(r10, new Object[0]);     // Catch: Throwable -> L17 Throwable -> L21
            L17:
                e = move-exception;
                Log.i(ResourcesCompat.TAG, "Failed to invoke rebase() method via reflection", e);     // Catch: Throwable -> L21
                sRebaseMethod = null;     // Catch: Throwable -> L21
                goto L19
            L24:
                Method r13 = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);     // Catch: NoSuchMethodException -> L10 Throwable -> L21
                sRebaseMethod = r13;     // Catch: NoSuchMethodException -> L10 Throwable -> L21
                r13.setAccessible(true);     // Catch: NoSuchMethodException -> L10 Throwable -> L21
            L12:
                sRebaseMethodFetched = true;     // Catch: Throwable -> L21
                goto L13
            L10:
                e = move-exception;
                Log.i(ResourcesCompat.TAG, "Failed to retrieve rebase() method", e);     // Catch: Throwable -> L21
                goto L12
            }
        }

        @RequiresApi(29)
        static class Api29Impl {
            private Api29Impl() {
            }

            @DoNotInline
            static void rebase(@NonNull Resources.Theme r10) {
                r10.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(@NonNull Resources.Theme r10) {
            int r11 = Build.VERSION.SDK_INT;
            if (r11 < 29) goto L6;
            Api29Impl.rebase(r10);
            return;
        L6:
            if (r11 < 23) goto L10;
            Api23Impl.rebase(r10);
            return;
        }
    }

    static {
        sTempTypedValue = new ThreadLocal();
        sColorStateCaches = new WeakHashMap(0);
        sColorStateCacheLock = new Object();
    }

    private ResourcesCompat() {
    }

    private static void addColorStateListToCache(@NonNull ColorStateListCacheKey r10, @ColorRes int r11, @NonNull ColorStateList r12, @Nullable Resources.Theme r13) {
        Object r14 = sColorStateCacheLock;
        monitor-enter(r14);
        WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> r15 = sColorStateCaches;     // Catch: Throwable -> L10
        SparseArray<ColorStateListCacheEntry> r16 = r15.get(r10);     // Catch: Throwable -> L10
        if (r16 != null) goto L7;
        r16 = new SparseArray();     // Catch: Throwable -> L10
        r15.put(r10, r16);     // Catch: Throwable -> L10
    L7:
        r16.append(r11, new ColorStateListCacheEntry(r12, r10.mResources.getConfiguration(), r13));     // Catch: Throwable -> L10
        monitor-exit(r14);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static void clearCachesForTheme(@NonNull Resources.Theme r10) {
        Object r11 = sColorStateCacheLock;
        monitor-enter(r11);
        Iterator<ColorStateListCacheKey> r12 = sColorStateCaches.keySet().iterator();     // Catch: Throwable -> L14
    L6:
        if (r12.hasNext() == false) goto L12;
        ColorStateListCacheKey r13 = r12.next();     // Catch: Throwable -> L14
        if (r13 == null) goto L6;
        if (r10.equals(r13.mTheme) == false) goto L6;
        r12.remove();     // Catch: Throwable -> L14
        goto L6
    L12:
        monitor-exit(r11);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Nullable
    private static ColorStateList getCachedColorStateList(@NonNull ColorStateListCacheKey r10, @ColorRes int r11) {
        Object r12 = sColorStateCacheLock;
        monitor-enter(r12);
        SparseArray<ColorStateListCacheEntry> r13 = sColorStateCaches.get(r10);     // Catch: Throwable -> L26
        if (r13 != null) goto L7;
    L23:
        monitor-exit(r12);     // Catch: Throwable -> L26
        return null;
    L7:
        if (r13.size() <= 0) goto L23;
        ColorStateListCacheEntry r14 = r13.get(r11);     // Catch: Throwable -> L26
        if (r14 == null) goto L23;
        if (r14.mConfiguration.equals(r10.mResources.getConfiguration()) == false) goto L22;
        Resources.Theme r15 = r10.mTheme;     // Catch: Throwable -> L26
        if (r15 == null) goto L15;
    L16:
        if (r15 == null) goto L22;
        if (r14.mThemeHash != r15.hashCode()) goto L22;
    L19:
        ColorStateList r16 = r14.mValue;     // Catch: Throwable -> L26
        monitor-exit(r12);     // Catch: Throwable -> L26
        return r16;
    L15:
        if (r14.mThemeHash == 0) goto L19;
    L22:
        r13.remove(r11);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    @Nullable
    public static Typeface getCachedFont(@NonNull Context r10, @FontRes int r11) {
        if (r10.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r10, r11, new TypedValue(), 0, null, null, false, true);
    }

    @ColorInt
    public static int getColor(@NonNull Resources r10, @ColorRes int r11, @Nullable Resources.Theme r12) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getColor(r10, r11, r12);
    L7:
        return r10.getColor(r11);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources r10, @ColorRes int r11, @Nullable Resources.Theme r12) {
        ColorStateListCacheKey r13 = new ColorStateListCacheKey(r10, r12);
        ColorStateList r14 = getCachedColorStateList(r13, r11);
        if (r14 == null) goto L5;
        return r14;
    L5:
        ColorStateList r15 = inflateColorStateList(r10, r11, r12);
        if (r15 == null) goto L10;
        addColorStateListToCache(r13, r11, r15, r12);
        return r15;
    L10:
        if (Build.VERSION.SDK_INT < 23) goto L14;
        return Api23Impl.getColorStateList(r10, r11, r12);
    L14:
        return r10.getColorStateList(r11);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources r10, @DrawableRes int r11, @Nullable Resources.Theme r12) {
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return Api21Impl.getDrawable(r10, r11, r12);
    L7:
        return r10.getDrawable(r11);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources r10, @DrawableRes int r11, int r12, @Nullable Resources.Theme r13) {
        int r14 = Build.VERSION.SDK_INT;
        if (r14 < 21) goto L7;
        return Api21Impl.getDrawableForDensity(r10, r11, r12, r13);
    L7:
        if (r14 < 15) goto L11;
        return Api15Impl.getDrawableForDensity(r10, r11, r12);
    L11:
        return r10.getDrawable(r11);
    }

    public static float getFloat(@NonNull Resources r10, @DimenRes int r11) {
        if (Build.VERSION.SDK_INT >= 29) goto L5;
        TypedValue r12 = getTypedValue();
        r10.getValue(r11, r12, true);
        if (r12.type != 4) goto L11;
        return r12.getFloat();
    L11:
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(r11) + " type #0x" + Integer.toHexString(r12.type) + " is not valid");
    L5:
        return Api29Impl.getFloat(r10, r11);
    }

    @Nullable
    public static Typeface getFont(@NonNull Context r10, @FontRes int r11) {
        if (r10.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r10, r11, new TypedValue(), 0, null, null, false, false);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context r10, @FontRes int r11, @NonNull TypedValue r12, int r13, @Nullable FontCallback r14) {
        if (r10.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r10, r11, r12, r13, r14, null, true, false);
    }

    public static void getFont(@NonNull Context r10, @FontRes int r11, @NonNull FontCallback r12, @Nullable Handler r13) {
        Preconditions.checkNotNull(r12);
        if (r10.isRestricted() == false) goto L6;
        r12.callbackFailAsync(-4, r13);
        return;
    L6:
        loadFont(r10, r11, new TypedValue(), 0, r12, r13, false, false);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r10 = sTempTypedValue;
        TypedValue r11 = r10.get();
        if (r11 != null) goto L6;
        TypedValue r12 = new TypedValue();
        r10.set(r12);
        return r12;
    L6:
        return r11;
    }

    @Nullable
    private static ColorStateList inflateColorStateList(Resources r10, int r11, @Nullable Resources.Theme r12) {
        if (isColorInt(r10, r11) == false) goto L11;
        return null;
    L11:
        return ColorStateListInflaterCompat.createFromXml(r10, r10.getXml(r11), r12);
    L8:
        e = move-exception;
        Log.w(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e);
        return null;
    }

    private static boolean isColorInt(@NonNull Resources r10, @ColorRes int r11) {
        TypedValue r12 = getTypedValue();
        r10.getValue(r11, r12, true);
        int r13 = r12.type;
        if (r13 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r13 > 31) goto L7;
        return true;
    }

    private static Typeface loadFont(@NonNull Context r10, int r11, @NonNull TypedValue r12, int r13, @Nullable FontCallback r14, @Nullable Handler r15, boolean r16, boolean r17) {
        Resources r18 = r10.getResources();
        r18.getValue(r11, r12, true);
        Typeface r19 = loadFont(r10, r18, r12, r11, r13, r14, r15, r16, r17);
        if (r19 != null) goto L9;
        if (r14 != null) goto L9;
        if (r17 == true) goto L9;
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(r11) + " could not be retrieved.");
    L9:
        return r19;
    }

    private static Typeface loadFont(@NonNull Context r17, Resources r18, @NonNull TypedValue r19, int r20, int r21, @Nullable FontCallback r22, @Nullable Handler r23, boolean r24, boolean r25) {
        CharSequence r10 = r19.string;
        if (r10 == null) goto L41;
        String r14 = r10.toString();
        if (r14.startsWith("res/") == true) goto L9;
        if (r22 == null) goto L8;
        r22.callbackFailAsync(-3, r23);
    L8:
        return null;
    L9:
        Typeface r11 = TypefaceCompat.findFromCache(r18, r20, r14, r19.assetCookie, r21);
        if (r11 == null) goto L14;
        if (r22 == null) goto L13;
        r22.callbackSuccessAsync(r11, r23);
    L13:
        return r11;
    L14:
        if (r25 == false) goto L42;
        return null;
    L42:
    L32:
        e = e;
        StringBuilder r12 = new StringBuilder();
        String r13 = "Failed to read xml resource ";
    L36:
        r12.append(r13);
        r12.append(r14);
        Log.e(TAG, r12.toString(), e);
        if (r22 == null) goto L39;
        r22.callbackFailAsync(-3, r23);
    L39:
        return null;
    L34:
        e = e;
        r12 = new StringBuilder();
        r13 = "Failed to parse xml resource ";
        goto L36
    L17:
        if (r14.toLowerCase().endsWith(".xml") == false) goto L26;
        FontResourcesParserCompat.FamilyResourceEntry r15 = FontResourcesParserCompat.parse(r18.getXml(r20), r18);     // Catch: IOException -> L32 XmlPullParserException -> L34
        if (r15 != null) goto L25;
        Log.e(TAG, "Failed to find font-family tag");     // Catch: IOException -> L32 XmlPullParserException -> L34
        if (r22 == null) goto L23;
        r22.callbackFailAsync(-3, r23);     // Catch: IOException -> L32 XmlPullParserException -> L34
    L23:
        return null;
    L25:
        return TypefaceCompat.createFromResourcesFamilyXml(r17, r15, r18, r20, r14, r19.assetCookie, r21, r22, r23, r24);
    L26:
        Typeface r16 = TypefaceCompat.createFromResourcesFontFile(r17, r18, r20, r14, r19.assetCookie, r21);     // Catch: IOException -> L32 XmlPullParserException -> L34
        if (r22 == null) goto L31;
        if (r16 == null) goto L30;
        r22.callbackSuccessAsync(r16, r23);     // Catch: IOException -> L32 XmlPullParserException -> L34
        goto L31
    L30:
        r22.callbackFailAsync(-3, r23);     // Catch: IOException -> L32 XmlPullParserException -> L34
    L31:
        return r16;
    L41:
        throw new Resources.NotFoundException("Resource \"" + r18.getResourceName(r20) + "\" (" + Integer.toHexString(r20) + ") is not a Font: " + r19);
    }
}
