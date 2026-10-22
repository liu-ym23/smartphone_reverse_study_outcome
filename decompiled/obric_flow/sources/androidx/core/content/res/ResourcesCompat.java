package androidx.core.content.res;

import a2.b;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
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

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static Drawable getDrawable(Resources r5, int r10, Resources.Theme r11) {
            return r5.getDrawable(r10, r11);
        }

        @DoNotInline
        public static Drawable getDrawableForDensity(Resources r5, int r10, int r11, Resources.Theme r12) {
            return r5.getDrawableForDensity(r10, r11, r12);
        }
    }

    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        public static int getColor(Resources r5, int r10, Resources.Theme r11) {
            return r5.getColor(r10, r11);
        }

        @NonNull
        @DoNotInline
        public static ColorStateList getColorStateList(@NonNull Resources r5, @ColorRes int r10, @Nullable Resources.Theme r11) {
            return r5.getColorStateList(r10, r11);
        }
    }

    @RequiresApi(29)
    public static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        public static float getFloat(@NonNull Resources r5, @DimenRes int r10) {
            return r5.getFloat(r10);
        }
    }

    public static class ColorStateListCacheEntry {
        final Configuration mConfiguration;
        final int mThemeHash;
        final ColorStateList mValue;

        public ColorStateListCacheEntry(@NonNull ColorStateList r5, @NonNull Configuration r10, @Nullable Resources.Theme r11) {
            this.mValue = r5;
            this.mConfiguration = r10;
            if (r11 != null) goto L5;
            int r12 = 0;
        L6:
            this.mThemeHash = r12;
            return;
        L5:
            r12 = r11.hashCode();
            goto L6
        }
    }

    public static final class ColorStateListCacheKey {
        final Resources mResources;
        final Resources.Theme mTheme;

        public ColorStateListCacheKey(@NonNull Resources r5, @Nullable Resources.Theme r10) {
            this.mResources = r5;
            this.mTheme = r10;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L17:
            return false;
        L8:
            if (ColorStateListCacheKey.class != r5.getClass()) goto L17;
            ColorStateListCacheKey r10 = (ColorStateListCacheKey) r5;
            if (this.mResources.equals(r10.mResources) == false) goto L16;
            if (ObjectsCompat.equals(this.mTheme, r10.mTheme) == false) goto L16;
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

        public static /* synthetic */ void a(FontCallback r5, Typeface r10) {
            r5.lambda$callbackSuccessAsync$0(r10);
        }

        public static /* synthetic */ void b(FontCallback r5, int r10) {
            r5.lambda$callbackFailAsync$1(r10);
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler getHandler(@Nullable Handler r5) {
            if (r5 == null) goto L4;
            return r5;
        L4:
            return new Handler(Looper.getMainLooper());
        }

        private /* synthetic */ void lambda$callbackFailAsync$1(int r5) {
            onFontRetrievalFailed(r5);
        }

        private /* synthetic */ void lambda$callbackSuccessAsync$0(Typeface r5) {
            onFontRetrieved(r5);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackFailAsync(int r5, @Nullable Handler r10) {
            getHandler(r10).post(new a(r5, 0, this));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void callbackSuccessAsync(@NonNull Typeface r5, @Nullable Handler r10) {
            getHandler(r10).post(new b(1, this, r5));
        }

        public abstract void onFontRetrievalFailed(int r5);

        public abstract void onFontRetrieved(@NonNull Typeface r5);
    }

    public static final class ThemeCompat {

        @RequiresApi(23)
        public static class Api23Impl {
            private static Method sRebaseMethod;
            private static boolean sRebaseMethodFetched;
            private static final Object sRebaseMethodLock = null;

            static {
                sRebaseMethodLock = new Object();
            }

            private Api23Impl() {
            }

            @SuppressLint({"BanUncheckedReflection"})
            public static void rebase(@NonNull Resources.Theme r10) {
                Object r5 = sRebaseMethodLock;
                monitor-enter(r5);
            L10:
                th = move-exception;
                throw th;
            L6:
                if (sRebaseMethodFetched == false) goto L25;
            L15:
                Method r11 = sRebaseMethod;     // Catch: Throwable -> L10
                if (r11 != null) goto L29;
            L21:
                monitor-exit(r5);     // Catch: Throwable -> L10
                return;
            L29:
                r11.invoke(r10, null);     // Catch: Throwable -> L10 Throwable -> L19
            L19:
                e = move-exception;
                Log.i(ResourcesCompat.TAG, "Failed to invoke rebase() method via reflection", e);     // Catch: Throwable -> L10
                sRebaseMethod = null;     // Catch: Throwable -> L10
                goto L21
            L25:
                Method r12 = Resources.Theme.class.getDeclaredMethod("rebase", null);     // Catch: Throwable -> L10 NoSuchMethodException -> L12
                sRebaseMethod = r12;     // Catch: Throwable -> L10 NoSuchMethodException -> L12
                r12.setAccessible(true);     // Catch: Throwable -> L10 NoSuchMethodException -> L12
            L14:
                sRebaseMethodFetched = true;     // Catch: Throwable -> L10
                goto L15
            L12:
                e = move-exception;
                Log.i(ResourcesCompat.TAG, "Failed to retrieve rebase() method", e);     // Catch: Throwable -> L10
                goto L14
            }
        }

        @RequiresApi(29)
        public static class Api29Impl {
            private Api29Impl() {
            }

            @DoNotInline
            public static void rebase(@NonNull Resources.Theme r5) {
                r5.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void rebase(@NonNull Resources.Theme r5) {
            Api29Impl.rebase(r5);
        }
    }

    static {
        sTempTypedValue = new ThreadLocal();
        sColorStateCaches = new WeakHashMap(0);
        sColorStateCacheLock = new Object();
    }

    private ResourcesCompat() {
    }

    private static void addColorStateListToCache(@NonNull ColorStateListCacheKey r5, @ColorRes int r10, @NonNull ColorStateList r11, @Nullable Resources.Theme r12) {
        Object r13 = sColorStateCacheLock;
        monitor-enter(r13);
        WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> r14 = sColorStateCaches;     // Catch: Throwable -> L7
        SparseArray<ColorStateListCacheEntry> r15 = r14.get(r5);     // Catch: Throwable -> L7
        if (r15 != null) goto L9;
        r15 = new SparseArray();     // Catch: Throwable -> L7
        r14.put(r5, r15);     // Catch: Throwable -> L7
    L9:
        r15.append(r10, new ColorStateListCacheEntry(r11, r5.mResources.getConfiguration(), r12));     // Catch: Throwable -> L7
        monitor-exit(r13);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void clearCachesForTheme(@NonNull Resources.Theme r5) {
        Object r10 = sColorStateCacheLock;
        monitor-enter(r10);
        Iterator<ColorStateListCacheKey> r11 = sColorStateCaches.keySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r11.hasNext() == false) goto L14;
        ColorStateListCacheKey r12 = r11.next();     // Catch: Throwable -> L12
        if (r12 == null) goto L6;
        if (r5.equals(r12.mTheme) == false) goto L6;
        r11.remove();     // Catch: Throwable -> L12
        goto L6
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Nullable
    private static ColorStateList getCachedColorStateList(@NonNull ColorStateListCacheKey r5, @ColorRes int r10) {
        Object r11 = sColorStateCacheLock;
        monitor-enter(r11);
        SparseArray<ColorStateListCacheEntry> r12 = sColorStateCaches.get(r5);     // Catch: Throwable -> L17
        if (r12 != null) goto L7;
    L26:
        monitor-exit(r11);     // Catch: Throwable -> L17
        return null;
    L7:
        if (r12.size() <= 0) goto L26;
        ColorStateListCacheEntry r13 = r12.get(r10);     // Catch: Throwable -> L17
        if (r13 == null) goto L26;
        if (r13.mConfiguration.equals(r5.mResources.getConfiguration()) == false) goto L25;
        Resources.Theme r14 = r5.mTheme;     // Catch: Throwable -> L17
        if (r14 == null) goto L15;
    L19:
        if (r14 == null) goto L25;
        if (r13.mThemeHash != r14.hashCode()) goto L25;
    L22:
        ColorStateList r15 = r13.mValue;     // Catch: Throwable -> L17
        monitor-exit(r11);     // Catch: Throwable -> L17
        return r15;
    L15:
        if (r13.mThemeHash == 0) goto L22;
    L25:
        r12.remove(r10);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;
    }

    @Nullable
    public static Typeface getCachedFont(@NonNull Context r10, @FontRes int r11) throws Resources.NotFoundException {
        if (r10.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r10, r11, new TypedValue(), 0, null, null, false, true);
    }

    @ColorInt
    public static int getColor(@NonNull Resources r5, @ColorRes int r10, @Nullable Resources.Theme r11) throws Resources.NotFoundException {
        return Api23Impl.getColor(r5, r10, r11);
    }

    @Nullable
    public static ColorStateList getColorStateList(@NonNull Resources r5, @ColorRes int r10, @Nullable Resources.Theme r11) throws Resources.NotFoundException {
        ColorStateListCacheKey r12 = new ColorStateListCacheKey(r5, r11);
        ColorStateList r13 = getCachedColorStateList(r12, r10);
        if (r13 == null) goto L5;
        return r13;
    L5:
        ColorStateList r14 = inflateColorStateList(r5, r10, r11);
        if (r14 == null) goto L10;
        addColorStateListToCache(r12, r10, r14, r11);
        return r14;
    L10:
        return Api23Impl.getColorStateList(r5, r10, r11);
    }

    @Nullable
    public static Drawable getDrawable(@NonNull Resources r5, @DrawableRes int r10, @Nullable Resources.Theme r11) throws Resources.NotFoundException {
        return Api21Impl.getDrawable(r5, r10, r11);
    }

    @Nullable
    public static Drawable getDrawableForDensity(@NonNull Resources r5, @DrawableRes int r10, int r11, @Nullable Resources.Theme r12) throws Resources.NotFoundException {
        return Api21Impl.getDrawableForDensity(r5, r10, r11, r12);
    }

    public static float getFloat(@NonNull Resources r5, @DimenRes int r10) {
        return Api29Impl.getFloat(r5, r10);
    }

    @Nullable
    public static Typeface getFont(@NonNull Context r10, @FontRes int r11) throws Resources.NotFoundException {
        if (r10.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r10, r11, new TypedValue(), 0, null, null, false, false);
    }

    @NonNull
    private static TypedValue getTypedValue() {
        ThreadLocal<TypedValue> r5 = sTempTypedValue;
        TypedValue r10 = r5.get();
        if (r10 != null) goto L6;
        TypedValue r11 = new TypedValue();
        r5.set(r11);
        return r11;
    L6:
        return r10;
    }

    @Nullable
    private static ColorStateList inflateColorStateList(Resources r5, int r10, @Nullable Resources.Theme r11) {
        if (isColorInt(r5, r10) == false) goto L11;
        return null;
    L11:
        return ColorStateListInflaterCompat.createFromXml(r5, r5.getXml(r10), r11);
    L8:
        e = move-exception;
        Log.w(TAG, "Failed to inflate ColorStateList, leaving it to the framework", e);
        return null;
    }

    private static boolean isColorInt(@NonNull Resources r5, @ColorRes int r10) {
        TypedValue r11 = getTypedValue();
        r5.getValue(r10, r11, true);
        int r12 = r11.type;
        if (r12 >= 28) goto L5;
    L7:
        return false;
    L5:
        if (r12 > 31) goto L7;
        return true;
    }

    private static Typeface loadFont(@NonNull Context r10, int r11, @NonNull TypedValue r12, int r13, @Nullable FontCallback r14, @Nullable Handler r15, boolean r16, boolean r17) {
        Resources r5 = r10.getResources();
        r5.getValue(r11, r12, true);
        Typeface r18 = loadFont(r10, r5, r12, r11, r13, r14, r15, r16, r17);
        if (r18 != null) goto L9;
        if (r14 != null) goto L9;
        if (r17 == true) goto L9;
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(r11) + " could not be retrieved.");
    L9:
        return r18;
    }

    public static void getFont(@NonNull Context r10, @FontRes int r11, @NonNull FontCallback r12, @Nullable Handler r13) throws Resources.NotFoundException {
        Preconditions.checkNotNull(r12);
        if (r10.isRestricted() == false) goto L6;
        r12.callbackFailAsync(-4, r13);
        return;
    L6:
        loadFont(r10, r11, new TypedValue(), 0, r12, r13, false, false);
    }

    private static Typeface loadFont(@NonNull Context r16, Resources r17, @NonNull TypedValue r18, int r19, int r20, @Nullable FontCallback r21, @Nullable Handler r22, boolean r23, boolean r24) {
        CharSequence r5 = r18.string;
        if (r5 == null) goto L49;
        String r14 = r5.toString();
        int r15 = 0;
        if (r14.startsWith("res/") == true) goto L9;
        if (r21 == null) goto L8;
        r21.callbackFailAsync(-3, r22);
    L8:
        return null;
    L9:
        Typeface r10 = TypefaceCompat.findFromCache(r17, r19, r14, r18.assetCookie, r20);
        if (r10 == null) goto L14;
        if (r21 == null) goto L13;
        r21.callbackSuccessAsync(r10, r22);
    L13:
        return r10;
    L14:
        if (r24 == false) goto L50;
        return null;
    L50:
    L23:
        e = e;
        r15 = -3;
    L42:
        Log.e(TAG, "Failed to read xml resource ".concat(r14), e);
    L44:
        if (r21 == null) goto L52;
        r21.callbackFailAsync(r15, r22);
        return null;
    L52:
        return null;
    L25:
        e = e;
        r15 = -3;
    L43:
        Log.e(TAG, "Failed to parse xml resource ".concat(r14), e);
        goto L44
    L51:
        if (r14.toLowerCase().endsWith(".xml") == false) goto L36;
        FontResourcesParserCompat.FamilyResourceEntry r11 = FontResourcesParserCompat.parse(r17.getXml(r19), r17);     // Catch: IOException -> L23 XmlPullParserException -> L25
        if (r11 != null) goto L31;
        Log.e(TAG, "Failed to find font-family tag");     // Catch: IOException -> L23 XmlPullParserException -> L25
        if (r21 == null) goto L27;
        r21.callbackFailAsync(-3, r22);     // Catch: IOException -> L23 XmlPullParserException -> L25
    L27:
        return null;
    L31:
        return TypefaceCompat.createFromResourcesFamilyXml(r16, r11, r17, r19, r14, r18.assetCookie, r20, r21, r22, r23);
    L36:
        Typeface r12 = TypefaceCompat.createFromResourcesFontFile(r16, r17, r19, r14, r18.assetCookie, r20);     // Catch: IOException -> L32 XmlPullParserException -> L34
        if (r21 == null) goto L41;
        if (r12 == null) goto L40;
        r21.callbackSuccessAsync(r12, r22);     // Catch: IOException -> L32 XmlPullParserException -> L34
        goto L41
    L40:
        r21.callbackFailAsync(-3, r22);     // Catch: IOException -> L32 XmlPullParserException -> L34
    L41:
        return r12;
    L32:
        e = e;
    L34:
        e = e;
        goto L43
    L49:
        throw new Resources.NotFoundException("Resource \"" + r17.getResourceName(r19) + "\" (" + Integer.toHexString(r19) + ") is not a Font: " + r18);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface getFont(@NonNull Context r10, @FontRes int r11, @NonNull TypedValue r12, int r13, @Nullable FontCallback r14) throws Resources.NotFoundException {
        if (r10.isRestricted() == false) goto L7;
        return null;
    L7:
        return loadFont(r10, r11, r12, r13, r14, null, true, false);
    }
}
