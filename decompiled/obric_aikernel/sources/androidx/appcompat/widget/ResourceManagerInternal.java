package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResourceManagerInternal {
    private static final ColorFilterLruCache COLOR_FILTER_CACHE = null;
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE = null;
    private static ResourceManagerInternal INSTANCE = null;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "ResourceManagerInternal";
    private SimpleArrayMap<String, InflateDelegate> mDelegates;
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> mDrawableCaches;
    private boolean mHasCheckedVectorDrawableSetup;
    private ResourceManagerHooks mHooks;
    private SparseArrayCompat<String> mKnownDrawableIdTags;
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> mTintLists;
    private TypedValue mTypedValue;

    static class AsldcInflateDelegate implements InflateDelegate {
        AsldcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) {
            return AnimatedStateListDrawableCompat.createFromXmlInner(r10, r10.getResources(), r11, r12, r13);
        L4:
            e = move-exception;
            Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
            return null;
        }
    }

    private static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) {
            return AnimatedVectorDrawableCompat.createFromXmlInner(r10, r10.getResources(), r11, r12, r13);
        L4:
            e = move-exception;
            Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
            return null;
        }
    }

    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int r10) {
            super(r10);
        }

        private static int generateCacheKey(int r10, PorterDuff.Mode r11) {
            return ((r10 + 31) * 31) + r11.hashCode();
        }

        PorterDuffColorFilter get(int r10, PorterDuff.Mode r11) {
            return get(Integer.valueOf(generateCacheKey(r10, r11)));
        }

        PorterDuffColorFilter put(int r10, PorterDuff.Mode r11, PorterDuffColorFilter r12) {
            return put(Integer.valueOf(generateCacheKey(r10, r11)), r12);
        }
    }

    static class DrawableDelegate implements InflateDelegate {
        DrawableDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) {
            String r14 = r12.getClassAttribute();
            if (r14 != null) goto L12;
        L11:
            return null;
        L12:
            Drawable r15 = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(r14).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);     // Catch: Exception -> L9
            if (Build.VERSION.SDK_INT < 21) goto L7;
            Compatibility.Api21Impl.inflate(r15, r10.getResources(), r11, r12, r13);     // Catch: Exception -> L9
        L8:
            return r15;
        L7:
            r15.inflate(r10.getResources(), r11, r12);     // Catch: Exception -> L9
        L9:
            e = move-exception;
            Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
            goto L11
        }
    }

    private interface InflateDelegate {
        Drawable createFromXmlInner(@NonNull Context r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ResourceManagerHooks {
        @Nullable
        Drawable createDrawableFor(@NonNull ResourceManagerInternal r10, @NonNull Context r11, @DrawableRes int r12);

        @Nullable
        ColorStateList getTintListForDrawableRes(@NonNull Context r10, @DrawableRes int r11);

        @Nullable
        PorterDuff.Mode getTintModeForDrawableRes(int r10);

        boolean tintDrawable(@NonNull Context r10, @DrawableRes int r11, @NonNull Drawable r12);

        boolean tintDrawableUsingColorFilter(@NonNull Context r10, @DrawableRes int r11, @NonNull Drawable r12);
    }

    private static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context r10, @NonNull XmlPullParser r11, @NonNull AttributeSet r12, @Nullable Resources.Theme r13) {
            return VectorDrawableCompat.createFromXmlInner(r10.getResources(), r11, r12, r13);
        L4:
            e = move-exception;
            Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
            return null;
        }
    }

    static {
        DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
        COLOR_FILTER_CACHE = new ColorFilterLruCache(6);
    }

    public ResourceManagerInternal() {
        this.mDrawableCaches = new WeakHashMap(0);
    }

    private void addDelegate(@NonNull String r10, @NonNull InflateDelegate r11) {
        if (this.mDelegates != null) goto L5;
        this.mDelegates = new SimpleArrayMap();
    L5:
        this.mDelegates.put(r10, r11);
    }

    private synchronized boolean addDrawableToCache(@NonNull Context r10, long r11, @NonNull Drawable r12) {
        monitor-enter(this);
        Drawable.ConstantState r13 = r12.getConstantState();     // Catch: Throwable -> L13
        if (r13 == null) goto L12;
        LongSparseArray<WeakReference<Drawable.ConstantState>> r14 = this.mDrawableCaches.get(r10);     // Catch: Throwable -> L13
        if (r14 != null) goto L8;
        r14 = new LongSparseArray();     // Catch: Throwable -> L13
        this.mDrawableCaches.put(r10, r14);     // Catch: Throwable -> L13
    L8:
        r14.put(r11, new WeakReference(r13));     // Catch: Throwable -> L13
        boolean r15 = true;
    L10:
        monitor-exit(this);
        return r15;
    L12:
        r15 = false;
    L13:
        th = move-exception;
        throw th;
    }

    private void addTintListToCache(@NonNull Context r10, @DrawableRes int r11, @NonNull ColorStateList r12) {
        if (this.mTintLists != null) goto L5;
        this.mTintLists = new WeakHashMap();
    L5:
        SparseArrayCompat<ColorStateList> r13 = this.mTintLists.get(r10);
        if (r13 != null) goto L8;
        r13 = new SparseArrayCompat();
        this.mTintLists.put(r10, r13);
    L8:
        r13.append(r11, r12);
    }

    private void checkVectorDrawableSetup(@NonNull Context r10) {
        if (this.mHasCheckedVectorDrawableSetup == false) goto L5;
        return;
    L5:
        this.mHasCheckedVectorDrawableSetup = true;
        Drawable r11 = getDrawable(r10, R.drawable.abc_vector_test);
        if (r11 != null) goto L8;
    L10:
        this.mHasCheckedVectorDrawableSetup = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    L8:
        if (isVectorDrawable(r11) == false) goto L10;
    }

    private static long createCacheKey(TypedValue r10) {
        return (((long) r10.assetCookie) << 32) | ((long) r10.data);
    }

    private Drawable createDrawableIfNeeded(@NonNull Context r10, @DrawableRes int r11) {
        if (this.mTypedValue != null) goto L5;
        this.mTypedValue = new TypedValue();
    L5:
        TypedValue r12 = this.mTypedValue;
        r10.getResources().getValue(r11, r12, true);
        long r13 = createCacheKey(r12);
        Drawable r14 = getCachedDrawable(r10, r13);
        if (r14 == null) goto L8;
        return r14;
    L8:
        ResourceManagerHooks r15 = this.mHooks;
        if (r15 != null) goto L11;
        Drawable r16 = null;
    L12:
        if (r16 == null) goto L14;
        r16.setChangingConfigurations(r12.changingConfigurations);
        addDrawableToCache(r10, r13, r16);
    L14:
        return r16;
    L11:
        r16 = r15.createDrawableFor(this, r10, r11);
        goto L12
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList r10, PorterDuff.Mode r11, int[] r12) {
        if (r10 == null) goto L7;
        if (r11 != null) goto L6;
        return null;
    L6:
        return getPorterDuffColorFilter(r10.getColorForState(r12, 0), r11);
    L7:
        return null;
    }

    public static synchronized ResourceManagerInternal get() {
        monitor-enter(ResourceManagerInternal.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L7;
        ResourceManagerInternal r10 = new ResourceManagerInternal();     // Catch: Throwable -> L10
        INSTANCE = r10;     // Catch: Throwable -> L10
        installDefaultInflateDelegates(r10);     // Catch: Throwable -> L10
    L7:
        ResourceManagerInternal r11 = INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(ResourceManagerInternal.class);
        return r11;
    }

    private synchronized Drawable getCachedDrawable(@NonNull Context r10, long r11) {
        monitor-enter(this);
        LongSparseArray<WeakReference<Drawable.ConstantState>> r12 = this.mDrawableCaches.get(r10);     // Catch: Throwable -> L18
        if (r12 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        WeakReference<Drawable.ConstantState> r13 = r12.get(r11);     // Catch: Throwable -> L18
        if (r13 == null) goto L16;
        Drawable.ConstantState r14 = r13.get();     // Catch: Throwable -> L18
        if (r14 == null) goto L15;
        Drawable r15 = r14.newDrawable(r10.getResources());     // Catch: Throwable -> L18
        monitor-exit(this);
        return r15;
    L15:
        r12.remove(r11);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int r10, PorterDuff.Mode r11) {
        monitor-enter(ResourceManagerInternal.class);
        ColorFilterLruCache r12 = COLOR_FILTER_CACHE;     // Catch: Throwable -> L9
        PorterDuffColorFilter r13 = r12.get(r10, r11);     // Catch: Throwable -> L9
        if (r13 != null) goto L7;
        r13 = new PorterDuffColorFilter(r10, r11);     // Catch: Throwable -> L9
        r12.put(r10, r11, r13);     // Catch: Throwable -> L9
    L7:
        monitor-exit(ResourceManagerInternal.class);
        return r13;
    L9:
        th = move-exception;
        throw th;
    }

    private ColorStateList getTintListFromCache(@NonNull Context r10, @DrawableRes int r11) {
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> r12 = this.mTintLists;
        if (r12 == null) goto L8;
        SparseArrayCompat<ColorStateList> r13 = r12.get(r10);
        if (r13 != null) goto L7;
        return null;
    L7:
        return r13.get(r11);
    L8:
        return null;
    }

    private static void installDefaultInflateDelegates(@NonNull ResourceManagerInternal r10) {
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        r10.addDelegate("vector", new VdcInflateDelegate());
        r10.addDelegate("animated-vector", new AvdcInflateDelegate());
        r10.addDelegate("animated-selector", new AsldcInflateDelegate());
        r10.addDelegate("drawable", new DrawableDelegate());
        return;
    }

    private static boolean isVectorDrawable(@NonNull Drawable r10) {
        if ((r10 instanceof VectorDrawableCompat) == false) goto L5;
    L8:
        return true;
    L5:
        if (PLATFORM_VD_CLAZZ.equals(r10.getClass().getName()) == true) goto L8;
        return false;
    }

    private Drawable loadDrawableFromDelegates(@NonNull Context r11, @DrawableRes int r12) {
        SimpleArrayMap<String, InflateDelegate> r10 = this.mDelegates;
        if (r10 != null) goto L5;
    L43:
        return null;
    L5:
        if (r10.isEmpty() == true) goto L43;
        SparseArrayCompat<String> r13 = this.mKnownDrawableIdTags;
        if (r13 == null) goto L14;
        String r14 = r13.get(r12);
        if (SKIP_DRAWABLE_TAG.equals(r14) == true) goto L13;
        if (r14 == null) goto L16;
        if (this.mDelegates.get(r14) == null) goto L13;
    L16:
        if (this.mTypedValue != null) goto L18;
        this.mTypedValue = new TypedValue();
    L18:
        TypedValue r15 = this.mTypedValue;
        Resources r16 = r11.getResources();
        r16.getValue(r12, r15, true);
        long r17 = createCacheKey(r15);
        Drawable r18 = getCachedDrawable(r11, r17);
        if (r18 == null) goto L21;
        return r18;
    L21:
        CharSequence r19 = r15.string;
        if (r19 != null) goto L24;
    L40:
        if (r18 != null) goto L42;
        this.mKnownDrawableIdTags.append(r12, SKIP_DRAWABLE_TAG);
    L42:
        return r18;
    L24:
        if (r19.toString().endsWith(".xml") == false) goto L40;
        XmlResourceParser r20 = r16.getXml(r12);     // Catch: Exception -> L38
        AttributeSet r21 = Xml.asAttributeSet(r20);     // Catch: Exception -> L38
    L26:
        int r22 = r20.next();     // Catch: Exception -> L38
        if (r22 == 2) goto L30;
        if (r22 != 1) goto L26;
    L30:
        if (r22 != 2) goto L37;
        String r23 = r20.getName();     // Catch: Exception -> L38
        this.mKnownDrawableIdTags.append(r12, r23);     // Catch: Exception -> L38
        InflateDelegate r24 = this.mDelegates.get(r23);     // Catch: Exception -> L38
        if (r24 == null) goto L34;
        r18 = r24.createFromXmlInner(r11, r20, r21, r11.getTheme());     // Catch: Exception -> L38
    L34:
        if (r18 == null) goto L40;
        r18.setChangingConfigurations(r15.changingConfigurations);     // Catch: Exception -> L38
        addDrawableToCache(r11, r17, r18);     // Catch: Exception -> L38
        goto L40
    L37:
        throw new XmlPullParserException("No start tag found");     // Catch: Exception -> L38
    L38:
        e = move-exception;
        Log.e(TAG, "Exception while inflating drawable", e);
    L13:
        return null;
    L14:
        this.mKnownDrawableIdTags = new SparseArrayCompat();
        goto L16
    }

    private Drawable tintDrawable(@NonNull Context r10, @DrawableRes int r11, boolean r12, @NonNull Drawable r13) {
        ColorStateList r14 = getTintList(r10, r11);
        if (r14 != null) goto L5;
        ResourceManagerHooks r15 = this.mHooks;
        if (r15 == null) goto L16;
        if (r15.tintDrawable(r10, r11, r13) == false) goto L16;
        return r13;
    L16:
        if (tintDrawableUsingColorFilter(r10, r11, r13) == true) goto L22;
        if (r12 == false) goto L23;
        return null;
    L23:
        return r13;
    L22:
        return r13;
    L5:
        if (DrawableUtils.canSafelyMutateDrawable(r13) == false) goto L7;
        r13 = r13.mutate();
    L7:
        Drawable r16 = DrawableCompat.wrap(r13);
        DrawableCompat.setTintList(r16, r14);
        PorterDuff.Mode r17 = getTintMode(r11);
        if (r17 == null) goto L20;
        DrawableCompat.setTintMode(r16, r17);
        return r16;
    L20:
        return r16;
    }

    static void tintDrawable(Drawable r10, TintInfo r11, int[] r12) {
        int[] r13 = r10.getState();
        if (DrawableUtils.canSafelyMutateDrawable(r10) == false) goto L12;
        if (r10.mutate() != r10) goto L7;
        boolean r14 = true;
    L8:
        if (r14 == true) goto L12;
        Log.d(TAG, "Mutated drawable is not the same instance as the input.");
        return;
    L7:
        r14 = false;
    L12:
        if ((r10 instanceof LayerDrawable) == true) goto L14;
    L16:
        boolean r15 = r11.mHasTintList;
        if (r15 == false) goto L19;
    L22:
        if (r15 == false) goto L24;
        ColorStateList r16 = r11.mTintList;
    L26:
        if (r11.mHasTintMode == false) goto L28;
        PorterDuff.Mode r17 = r11.mTintMode;
    L29:
        r10.setColorFilter(createTintFilter(r16, r17, r12));
    L31:
        if (Build.VERSION.SDK_INT > 23) goto L34;
        r10.invalidateSelf();
        return;
    L34:
        return;
    L28:
        r17 = DEFAULT_MODE;
        goto L29
    L24:
        r16 = null;
        goto L26
    L19:
        if (r11.mHasTintMode == true) goto L22;
        r10.clearColorFilter();
        goto L31
    L14:
        if (r10.isStateful() == false) goto L16;
        r10.setState(new int[0]);
        r10.setState(r13);
        goto L16
    }

    public synchronized Drawable getDrawable(@NonNull Context r10, @DrawableRes int r11) {
        monitor-enter(this);
        Drawable r12 = getDrawable(r10, r11, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    synchronized Drawable getDrawable(@NonNull Context r10, @DrawableRes int r11, boolean r12) {
        monitor-enter(this);
        checkVectorDrawableSetup(r10);     // Catch: Throwable -> L14
        Drawable r13 = loadDrawableFromDelegates(r10, r11);     // Catch: Throwable -> L14
        if (r13 != null) goto L6;
        r13 = createDrawableIfNeeded(r10, r11);     // Catch: Throwable -> L14
    L6:
        if (r13 != null) goto L8;
        r13 = ContextCompat.getDrawable(r10, r11);     // Catch: Throwable -> L14
    L8:
        if (r13 == null) goto L10;
        r13 = tintDrawable(r10, r11, r12, r13);     // Catch: Throwable -> L14
    L10:
        if (r13 == null) goto L12;
        DrawableUtils.fixDrawable(r13);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r13;
    L14:
        th = move-exception;
        throw th;
    }

    synchronized ColorStateList getTintList(@NonNull Context r10, @DrawableRes int r11) {
        monitor-enter(this);
        ColorStateList r12 = getTintListFromCache(r10, r11);     // Catch: Throwable -> L13
        if (r12 != null) goto L11;
        ResourceManagerHooks r13 = this.mHooks;     // Catch: Throwable -> L13
        if (r13 != null) goto L8;
        r12 = null;
    L9:
        if (r12 == null) goto L11;
        addTintListToCache(r10, r11, r12);     // Catch: Throwable -> L13
        goto L11
    L8:
        r12 = r13.getTintListForDrawableRes(r10, r11);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return r12;
    L13:
        th = move-exception;
        throw th;
    }

    PorterDuff.Mode getTintMode(int r10) {
        ResourceManagerHooks r11 = this.mHooks;
        if (r11 != null) goto L6;
        return null;
    L6:
        return r11.getTintModeForDrawableRes(r10);
    }

    public synchronized void onConfigurationChanged(@NonNull Context r10) {
        monitor-enter(this);
        LongSparseArray<WeakReference<Drawable.ConstantState>> r11 = this.mDrawableCaches.get(r10);     // Catch: Throwable -> L8
        if (r11 == null) goto L6;
        r11.clear();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized Drawable onDrawableLoadedFromResources(@NonNull Context r10, @NonNull VectorEnabledTintResources r11, @DrawableRes int r12) {
        monitor-enter(this);
        Drawable r13 = loadDrawableFromDelegates(r10, r12);     // Catch: Throwable -> L13
        if (r13 != null) goto L6;
        r13 = r11.getDrawableCanonical(r12);     // Catch: Throwable -> L13
    L6:
        if (r13 == null) goto L11;
        Drawable r14 = tintDrawable(r10, r12, false, r13);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r14;
    L11:
        monitor-exit(this);
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void setHooks(ResourceManagerHooks r10) {
        monitor-enter(this);
        this.mHooks = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    boolean tintDrawableUsingColorFilter(@NonNull Context r10, @DrawableRes int r11, @NonNull Drawable r12) {
        ResourceManagerHooks r13 = this.mHooks;
        if (r13 != null) goto L5;
    L7:
        return false;
    L5:
        if (r13.tintDrawableUsingColorFilter(r10, r11, r12) == false) goto L7;
        return true;
    }
}
