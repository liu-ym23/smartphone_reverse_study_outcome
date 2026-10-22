package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
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

    public static class AsldcInflateDelegate implements InflateDelegate {
        public AsldcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context r5, @NonNull XmlPullParser r10, @NonNull AttributeSet r11, @Nullable Resources.Theme r12) {
            return AnimatedStateListDrawableCompat.createFromXmlInner(r5, r5.getResources(), r10, r11, r12);
        L4:
            e = move-exception;
            Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
            return null;
        }
    }

    public static class AvdcInflateDelegate implements InflateDelegate {
        public AvdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context r5, @NonNull XmlPullParser r10, @NonNull AttributeSet r11, @Nullable Resources.Theme r12) {
            return AnimatedVectorDrawableCompat.createFromXmlInner(r5, r5.getResources(), r10, r11, r12);
        L4:
            e = move-exception;
            Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
            return null;
        }
    }

    public static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int r5) {
            super(r5);
        }

        private static int generateCacheKey(int r5, PorterDuff.Mode r10) {
            int r11 = r10.hashCode();
            return r11 + ((r5 + 31) * 31);
        }

        public PorterDuffColorFilter get(int r5, PorterDuff.Mode r10) {
            return get(Integer.valueOf(generateCacheKey(r5, r10)));
        }

        public PorterDuffColorFilter put(int r5, PorterDuff.Mode r10, PorterDuffColorFilter r11) {
            return put(Integer.valueOf(generateCacheKey(r5, r10)), r11);
        }
    }

    public static class DrawableDelegate implements InflateDelegate {
        public DrawableDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context r5, @NonNull XmlPullParser r10, @NonNull AttributeSet r11, @Nullable Resources.Theme r12) {
            String r13 = r11.getClassAttribute();
            if (r13 != null) goto L9;
        L8:
            return null;
        L9:
            Drawable r14 = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(r13).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);     // Catch: Exception -> L6
            Compatibility.Api21Impl.inflate(r14, r5.getResources(), r10, r11, r12);     // Catch: Exception -> L6
            return r14;
        L6:
            e = move-exception;
            Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
            goto L8
        }
    }

    public interface InflateDelegate {
        Drawable createFromXmlInner(@NonNull Context r5, @NonNull XmlPullParser r10, @NonNull AttributeSet r11, @Nullable Resources.Theme r12);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ResourceManagerHooks {
        @Nullable
        Drawable createDrawableFor(@NonNull ResourceManagerInternal r5, @NonNull Context r10, @DrawableRes int r11);

        @Nullable
        ColorStateList getTintListForDrawableRes(@NonNull Context r5, @DrawableRes int r10);

        @Nullable
        PorterDuff.Mode getTintModeForDrawableRes(int r5);

        boolean tintDrawable(@NonNull Context r5, @DrawableRes int r10, @NonNull Drawable r11);

        boolean tintDrawableUsingColorFilter(@NonNull Context r5, @DrawableRes int r10, @NonNull Drawable r11);
    }

    public static class VdcInflateDelegate implements InflateDelegate {
        public VdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(@NonNull Context r5, @NonNull XmlPullParser r10, @NonNull AttributeSet r11, @Nullable Resources.Theme r12) {
            return VectorDrawableCompat.createFromXmlInner(r5.getResources(), r10, r11, r12);
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

    private void addDelegate(@NonNull String r5, @NonNull InflateDelegate r10) {
        if (this.mDelegates != null) goto L5;
        this.mDelegates = new SimpleArrayMap();
    L5:
        this.mDelegates.put(r5, r10);
    }

    private synchronized boolean addDrawableToCache(@NonNull Context r5, long r10, @NonNull Drawable r11) {
        monitor-enter(this);
        Drawable.ConstantState r12 = r11.getConstantState();     // Catch: Throwable -> L8
        if (r12 == null) goto L14;
        LongSparseArray<WeakReference<Drawable.ConstantState>> r13 = this.mDrawableCaches.get(r5);     // Catch: Throwable -> L8
        if (r13 != null) goto L10;
        r13 = new LongSparseArray();     // Catch: Throwable -> L8
        this.mDrawableCaches.put(r5, r13);     // Catch: Throwable -> L8
    L10:
        r13.put(r10, new WeakReference(r12));     // Catch: Throwable -> L8
        monitor-exit(this);
        return true;
    L14:
        monitor-exit(this);
        return false;
    L8:
        th = move-exception;
        throw th;
    }

    private void addTintListToCache(@NonNull Context r5, @DrawableRes int r10, @NonNull ColorStateList r11) {
        if (this.mTintLists != null) goto L5;
        this.mTintLists = new WeakHashMap();
    L5:
        SparseArrayCompat<ColorStateList> r12 = this.mTintLists.get(r5);
        if (r12 != null) goto L8;
        r12 = new SparseArrayCompat();
        this.mTintLists.put(r5, r12);
    L8:
        r12.append(r10, r11);
    }

    private void checkVectorDrawableSetup(@NonNull Context r5) {
        if (this.mHasCheckedVectorDrawableSetup == false) goto L5;
        return;
    L5:
        this.mHasCheckedVectorDrawableSetup = true;
        Drawable r10 = getDrawable(r5, R.drawable.abc_vector_test);
        if (r10 != null) goto L8;
    L10:
        this.mHasCheckedVectorDrawableSetup = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    L8:
        if (isVectorDrawable(r10) == false) goto L10;
    }

    private static long createCacheKey(TypedValue r5) {
        return (((long) r5.assetCookie) << 32) | ((long) r5.data);
    }

    private Drawable createDrawableIfNeeded(@NonNull Context r5, @DrawableRes int r10) {
        if (this.mTypedValue != null) goto L5;
        this.mTypedValue = new TypedValue();
    L5:
        TypedValue r11 = this.mTypedValue;
        r5.getResources().getValue(r10, r11, true);
        long r12 = createCacheKey(r11);
        Drawable r13 = getCachedDrawable(r5, r12);
        if (r13 == null) goto L8;
        return r13;
    L8:
        ResourceManagerHooks r14 = this.mHooks;
        if (r14 != null) goto L11;
        Drawable r15 = null;
    L12:
        if (r15 == null) goto L14;
        r15.setChangingConfigurations(r11.changingConfigurations);
        addDrawableToCache(r5, r12, r15);
    L14:
        return r15;
    L11:
        r15 = r14.createDrawableFor(this, r5, r10);
        goto L12
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList r5, PorterDuff.Mode r10, int[] r11) {
        if (r5 == null) goto L7;
        if (r10 != null) goto L6;
        return null;
    L6:
        return getPorterDuffColorFilter(r5.getColorForState(r11, 0), r10);
    L7:
        return null;
    }

    public static synchronized ResourceManagerInternal get() {
        monitor-enter(ResourceManagerInternal.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (INSTANCE != null) goto L9;
        ResourceManagerInternal r5 = new ResourceManagerInternal();     // Catch: Throwable -> L7
        INSTANCE = r5;     // Catch: Throwable -> L7
        installDefaultInflateDelegates(r5);     // Catch: Throwable -> L7
    L9:
        ResourceManagerInternal r10 = INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(ResourceManagerInternal.class);
        return r10;
    }

    private synchronized Drawable getCachedDrawable(@NonNull Context r5, long r10) {
        monitor-enter(this);
        LongSparseArray<WeakReference<Drawable.ConstantState>> r11 = this.mDrawableCaches.get(r5);     // Catch: Throwable -> L15
        if (r11 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        WeakReference<Drawable.ConstantState> r12 = r11.get(r10);     // Catch: Throwable -> L15
        if (r12 == null) goto L18;
        Drawable.ConstantState r13 = r12.get();     // Catch: Throwable -> L15
        if (r13 == null) goto L17;
        Drawable r14 = r13.newDrawable(r5.getResources());     // Catch: Throwable -> L15
        monitor-exit(this);
        return r14;
    L17:
        r11.remove(r10);     // Catch: Throwable -> L15
    L18:
        monitor-exit(this);
        return null;
    L15:
        th = move-exception;
        throw th;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int r5, PorterDuff.Mode r10) {
        monitor-enter(ResourceManagerInternal.class);
        ColorFilterLruCache r11 = COLOR_FILTER_CACHE;     // Catch: Throwable -> L8
        PorterDuffColorFilter r12 = r11.get(r5, r10);     // Catch: Throwable -> L8
        if (r12 != null) goto L10;
        r12 = new PorterDuffColorFilter(r5, r10);     // Catch: Throwable -> L8
        r11.put(r5, r10, r12);     // Catch: Throwable -> L8
    L10:
        monitor-exit(ResourceManagerInternal.class);
        return r12;
    L8:
        th = move-exception;
        throw th;
    }

    private ColorStateList getTintListFromCache(@NonNull Context r5, @DrawableRes int r10) {
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> r11 = this.mTintLists;
        if (r11 == null) goto L8;
        SparseArrayCompat<ColorStateList> r12 = r11.get(r5);
        if (r12 != null) goto L7;
        return null;
    L7:
        return r12.get(r10);
    L8:
        return null;
    }

    private static void installDefaultInflateDelegates(@NonNull ResourceManagerInternal r5) {
    }

    private static boolean isVectorDrawable(@NonNull Drawable r5) {
        if ((r5 instanceof VectorDrawableCompat) == false) goto L5;
    L8:
        return true;
    L5:
        if (PLATFORM_VD_CLAZZ.equals(r5.getClass().getName()) == true) goto L8;
        return false;
    }

    private Drawable loadDrawableFromDelegates(@NonNull Context r11, @DrawableRes int r12) {
        SimpleArrayMap<String, InflateDelegate> r5 = this.mDelegates;
        if (r5 != null) goto L5;
    L44:
        return null;
    L5:
        if (r5.isEmpty() == true) goto L44;
        SparseArrayCompat<String> r10 = this.mKnownDrawableIdTags;
        if (r10 == null) goto L14;
        String r13 = r10.get(r12);
        if (SKIP_DRAWABLE_TAG.equals(r13) == true) goto L13;
        if (r13 == null) goto L16;
        if (this.mDelegates.get(r13) == null) goto L13;
    L16:
        if (this.mTypedValue != null) goto L18;
        this.mTypedValue = new TypedValue();
    L18:
        TypedValue r14 = this.mTypedValue;
        Resources r15 = r11.getResources();
        r15.getValue(r12, r14, true);
        long r16 = createCacheKey(r14);
        Drawable r17 = getCachedDrawable(r11, r16);
        if (r17 == null) goto L21;
        return r17;
    L21:
        CharSequence r18 = r14.string;
        if (r18 != null) goto L24;
    L41:
        if (r17 != null) goto L43;
        this.mKnownDrawableIdTags.append(r12, SKIP_DRAWABLE_TAG);
    L43:
        return r17;
    L24:
        if (r18.toString().endsWith(".xml") == false) goto L41;
        XmlResourceParser r19 = r15.getXml(r12);     // Catch: Exception -> L34
        AttributeSet r20 = Xml.asAttributeSet(r19);     // Catch: Exception -> L34
    L26:
        int r21 = r19.next();     // Catch: Exception -> L34
        if (r21 == 2) goto L30;
        if (r21 != 1) goto L26;
    L30:
        if (r21 != 2) goto L39;
        String r22 = r19.getName();     // Catch: Exception -> L34
        this.mKnownDrawableIdTags.append(r12, r22);     // Catch: Exception -> L34
        InflateDelegate r23 = this.mDelegates.get(r22);     // Catch: Exception -> L34
        if (r23 == null) goto L36;
        r17 = r23.createFromXmlInner(r11, r19, r20, r11.getTheme());     // Catch: Exception -> L34
    L36:
        if (r17 == null) goto L41;
        r17.setChangingConfigurations(r14.changingConfigurations);     // Catch: Exception -> L34
        addDrawableToCache(r11, r16, r17);     // Catch: Exception -> L34
        goto L41
    L39:
        throw new XmlPullParserException("No start tag found");     // Catch: Exception -> L34
    L34:
        e = move-exception;
        Log.e(TAG, "Exception while inflating drawable", e);
    L13:
        return null;
    L14:
        this.mKnownDrawableIdTags = new SparseArrayCompat();
        goto L16
    }

    private Drawable tintDrawable(@NonNull Context r5, @DrawableRes int r10, boolean r11, @NonNull Drawable r12) {
        ColorStateList r13 = getTintList(r5, r10);
        if (r13 != null) goto L5;
        ResourceManagerHooks r14 = this.mHooks;
        if (r14 == null) goto L16;
        if (r14.tintDrawable(r5, r10, r12) == false) goto L16;
        return r12;
    L16:
        if (tintDrawableUsingColorFilter(r5, r10, r12) == true) goto L22;
        if (r11 == false) goto L23;
        return null;
    L23:
        return r12;
    L22:
        return r12;
    L5:
        if (DrawableUtils.canSafelyMutateDrawable(r12) == false) goto L7;
        r12 = r12.mutate();
    L7:
        Drawable r15 = DrawableCompat.wrap(r12);
        DrawableCompat.setTintList(r15, r13);
        PorterDuff.Mode r16 = getTintMode(r10);
        if (r16 == null) goto L20;
        DrawableCompat.setTintMode(r15, r16);
        return r15;
    L20:
        return r15;
    }

    public synchronized Drawable getDrawable(@NonNull Context r5, @DrawableRes int r10) {
        monitor-enter(this);
        Drawable r11 = getDrawable(r5, r10, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized ColorStateList getTintList(@NonNull Context r5, @DrawableRes int r10) {
        monitor-enter(this);
        ColorStateList r11 = getTintListFromCache(r5, r10);     // Catch: Throwable -> L12
        if (r11 != null) goto L14;
        ResourceManagerHooks r12 = this.mHooks;     // Catch: Throwable -> L12
        if (r12 != null) goto L8;
        r11 = null;
    L9:
        if (r11 == null) goto L14;
        addTintListToCache(r5, r10, r11);     // Catch: Throwable -> L12
        goto L14
    L8:
        r11 = r12.getTintListForDrawableRes(r5, r10);     // Catch: Throwable -> L12
    L14:
        monitor-exit(this);
        return r11;
    L12:
        th = move-exception;
        throw th;
    }

    public PorterDuff.Mode getTintMode(int r5) {
        ResourceManagerHooks r10 = this.mHooks;
        if (r10 != null) goto L6;
        return null;
    L6:
        return r10.getTintModeForDrawableRes(r5);
    }

    public synchronized void onConfigurationChanged(@NonNull Context r5) {
        monitor-enter(this);
        LongSparseArray<WeakReference<Drawable.ConstantState>> r10 = this.mDrawableCaches.get(r5);     // Catch: Throwable -> L7
        if (r10 == null) goto L9;
        r10.clear();     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized Drawable onDrawableLoadedFromResources(@NonNull Context r5, @NonNull VectorEnabledTintResources r10, @DrawableRes int r11) {
        monitor-enter(this);
        Drawable r12 = loadDrawableFromDelegates(r5, r11);     // Catch: Throwable -> L6
        if (r12 != null) goto L8;
        r12 = r10.getDrawableCanonical(r11);     // Catch: Throwable -> L6
    L8:
        if (r12 == null) goto L12;
        Drawable r13 = tintDrawable(r5, r11, false, r12);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r13;
    L12:
        monitor-exit(this);
        return null;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void setHooks(ResourceManagerHooks r5) {
        monitor-enter(this);
        this.mHooks = r5;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean tintDrawableUsingColorFilter(@NonNull Context r5, @DrawableRes int r10, @NonNull Drawable r11) {
        ResourceManagerHooks r12 = this.mHooks;
        if (r12 != null) goto L5;
    L7:
        return false;
    L5:
        if (r12.tintDrawableUsingColorFilter(r5, r10, r11) == false) goto L7;
        return true;
    }

    public synchronized Drawable getDrawable(@NonNull Context r5, @DrawableRes int r10, boolean r11) {
        monitor-enter(this);
        checkVectorDrawableSetup(r5);     // Catch: Throwable -> L6
        Drawable r12 = loadDrawableFromDelegates(r5, r10);     // Catch: Throwable -> L6
        if (r12 != null) goto L8;
        r12 = createDrawableIfNeeded(r5, r10);     // Catch: Throwable -> L6
    L8:
        if (r12 != null) goto L10;
        r12 = ContextCompat.getDrawable(r5, r10);     // Catch: Throwable -> L6
    L10:
        if (r12 == null) goto L12;
        r12 = tintDrawable(r5, r10, r11, r12);     // Catch: Throwable -> L6
    L12:
        if (r12 == null) goto L14;
        DrawableUtils.fixDrawable(r12);     // Catch: Throwable -> L6
    L14:
        monitor-exit(this);
        return r12;
    L6:
        th = move-exception;
        throw th;
    }

    public static void tintDrawable(Drawable r5, TintInfo r10, int[] r11) {
        int[] r12 = r5.getState();
        if (DrawableUtils.canSafelyMutateDrawable(r5) == false) goto L10;
        if (r5.mutate() == r5) goto L10;
        Log.d(TAG, "Mutated drawable is not the same instance as the input.");
        return;
    L10:
        if ((r5 instanceof LayerDrawable) == true) goto L12;
    L14:
        boolean r13 = r10.mHasTintList;
        if (r13 == false) goto L17;
    L20:
        if (r13 == false) goto L22;
        ColorStateList r14 = r10.mTintList;
    L24:
        if (r10.mHasTintMode == false) goto L26;
        PorterDuff.Mode r15 = r10.mTintMode;
    L27:
        r5.setColorFilter(createTintFilter(r14, r15, r11));
        return;
    L26:
        r15 = DEFAULT_MODE;
        goto L27
    L22:
        r14 = null;
        goto L24
    L17:
        if (r10.mHasTintMode == true) goto L20;
        r5.clearColorFilter();
        return;
    L12:
        if (r5.isStateful() == false) goto L14;
        r5.setState(new int[0]);
        r5.setState(r12);
        goto L14
    }
}
