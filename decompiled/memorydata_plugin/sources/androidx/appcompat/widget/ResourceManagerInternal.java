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
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
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
        public Drawable createFromXmlInner(Context r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
            return AnimatedStateListDrawableCompat.createFromXmlInner(r1, ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin"), r6, r7, r5);
        L5:
            e = move-exception;
            Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
            return null;
        }
    }

    private static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
            return AnimatedVectorDrawableCompat.createFromXmlInner(r1, ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin"), r6, r7, r5);
        L5:
            e = move-exception;
            Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
            return null;
        }
    }

    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int r1) {
            super(r1);
        }

        private static int generateCacheKey(int r1, PorterDuff.Mode r2) {
            return ((r1 + 31) * 31) + r2.hashCode();
        }

        PorterDuffColorFilter get(int r1, PorterDuff.Mode r2) {
            return (PorterDuffColorFilter) ZeusTransformUtils.preCheckCast(get(Integer.valueOf(generateCacheKey(r1, r2))), PorterDuffColorFilter.class, "com.obric.memorydata.plugin");
        }

        PorterDuffColorFilter put(int r1, PorterDuff.Mode r2, PorterDuffColorFilter r3) {
            return (PorterDuffColorFilter) ZeusTransformUtils.preCheckCast(put(Integer.valueOf(generateCacheKey(r1, r2)), r3), PorterDuffColorFilter.class, "com.obric.memorydata.plugin");
        }
    }

    static class DrawableDelegate implements InflateDelegate {
        DrawableDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context r5, XmlPullParser r6, AttributeSet r7, Resources.Theme r8) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r9 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r6, XmlPullParser.class, "com.obric.memorydata.plugin");
            AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.memorydata.plugin");
            String r11 = r10.getClassAttribute();
            if (r11 != null) goto L12;
        L11:
            return null;
        L12:
            Drawable r12 = (Drawable) ZeusTransformUtils.preCheckCast(DrawableDelegate.class.getClassLoader().loadClass(r11).asSubclass(Drawable.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]), Drawable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L9
            if (Build.VERSION.SDK_INT < 21) goto L7;
            Compatibility.Api21Impl.inflate(r12, ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin"), r9, r10, r8);     // Catch: Exception -> L9
        L8:
            return r12;
        L7:
            r12.inflate(ZeusTransformUtils.getResources(r4, "com.obric.memorydata.plugin"), r9, r10);     // Catch: Exception -> L9
        L9:
            e = move-exception;
            Log.e("DrawableDelegate", "Exception while inflating <drawable>", e);
            goto L11
        }
    }

    private interface InflateDelegate {
        Drawable createFromXmlInner(Context r1, XmlPullParser r2, AttributeSet r3, Resources.Theme r4);
    }

    public interface ResourceManagerHooks {
        Drawable createDrawableFor(ResourceManagerInternal r1, Context r2, int r3);

        ColorStateList getTintListForDrawableRes(Context r1, int r2);

        PorterDuff.Mode getTintModeForDrawableRes(int r1);

        boolean tintDrawable(Context r1, int r2, Drawable r3);

        boolean tintDrawableUsingColorFilter(Context r1, int r2, Drawable r3);
    }

    private static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        @Override // androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate
        public Drawable createFromXmlInner(Context r2, XmlPullParser r3, AttributeSet r4, Resources.Theme r5) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            XmlPullParser r6 = (XmlPullParser) ZeusTransformUtils.wrapperContextForParams(r3, XmlPullParser.class, "com.obric.memorydata.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.memorydata.plugin");
            return VectorDrawableCompat.createFromXmlInner(ZeusTransformUtils.getResources(r1, "com.obric.memorydata.plugin"), r6, r7, r5);
        L5:
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

    private void addDelegate(String r3, InflateDelegate r4) {
        InflateDelegate r5 = (InflateDelegate) ZeusTransformUtils.wrapperContextForParams(r4, InflateDelegate.class, "com.obric.memorydata.plugin");
        if (this.mDelegates != null) goto L5;
        this.mDelegates = new SimpleArrayMap();
    L5:
        this.mDelegates.put(r3, r5);
    }

    private synchronized boolean addDrawableToCache(Context r4, long r5, Drawable r7) {
        monitor-enter(this);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Drawable.ConstantState r8 = r7.getConstantState();     // Catch: Throwable -> L13
        if (r8 == null) goto L12;
        LongSparseArray<WeakReference<Drawable.ConstantState>> r0 = (LongSparseArray) ZeusTransformUtils.preCheckCast(this.mDrawableCaches.get(r6), LongSparseArray.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r0 != null) goto L8;
        r0 = new LongSparseArray();     // Catch: Throwable -> L13
        this.mDrawableCaches.put(r6, r0);     // Catch: Throwable -> L13
    L8:
        r0.put(r5, new WeakReference(r8));     // Catch: Throwable -> L13
        boolean r9 = true;
    L10:
        monitor-exit(this);
        return r9;
    L12:
        r9 = false;
    L13:
        th = move-exception;
        throw th;
    }

    private void addTintListToCache(Context r4, int r5, ColorStateList r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (this.mTintLists != null) goto L5;
        this.mTintLists = new WeakHashMap();
    L5:
        SparseArrayCompat<ColorStateList> r0 = (SparseArrayCompat) ZeusTransformUtils.preCheckCast(this.mTintLists.get(r7), SparseArrayCompat.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        r0 = new SparseArrayCompat();
        this.mTintLists.put(r7, r0);
    L8:
        r0.append(r5, r6);
    }

    private void checkVectorDrawableSetup(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (this.mHasCheckedVectorDrawableSetup == false) goto L5;
        return;
    L5:
        this.mHasCheckedVectorDrawableSetup = true;
        Drawable r6 = getDrawable(r5, ZeusTransformUtils.mapRes(R.drawable.abc_vector_test, "drawable", "abc_vector_test"));
        if (r6 != null) goto L8;
    L10:
        this.mHasCheckedVectorDrawableSetup = false;
        throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
    L8:
        if (isVectorDrawable(r6) == false) goto L10;
    }

    private static long createCacheKey(TypedValue r4) {
        return (((long) r4.assetCookie) << 32) | ((long) r4.data);
    }

    private Drawable createDrawableIfNeeded(Context r5, int r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (this.mTypedValue != null) goto L5;
        this.mTypedValue = new TypedValue();
    L5:
        TypedValue r0 = this.mTypedValue;
        ZeusTransformUtils.getResources(r7, "com.obric.memorydata.plugin").getValue(r6, r0, true);
        long r1 = createCacheKey(r0);
        Drawable r3 = getCachedDrawable(r7, r1);
        if (r3 == null) goto L8;
        return r3;
    L8:
        ResourceManagerHooks r4 = this.mHooks;
        if (r4 != null) goto L11;
        Drawable r8 = null;
    L12:
        if (r8 == null) goto L14;
        r8.setChangingConfigurations(r0.changingConfigurations);
        addDrawableToCache(r7, r1, r8);
    L14:
        return r8;
    L11:
        r8 = r4.createDrawableFor(this, r7, r6);
        goto L12
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList r1, PorterDuff.Mode r2, int[] r3) {
        if (r1 == null) goto L7;
        if (r2 != null) goto L6;
        return null;
    L6:
        return getPorterDuffColorFilter(r1.getColorForState(r3, 0), r2);
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
        ResourceManagerInternal r1 = new ResourceManagerInternal();     // Catch: Throwable -> L10
        INSTANCE = r1;     // Catch: Throwable -> L10
        installDefaultInflateDelegates(r1);     // Catch: Throwable -> L10
    L7:
        ResourceManagerInternal r2 = INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(ResourceManagerInternal.class);
        return r2;
    }

    private synchronized Drawable getCachedDrawable(Context r6, long r7) {
        monitor-enter(this);
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        LongSparseArray r0 = (LongSparseArray) ZeusTransformUtils.preCheckCast(this.mDrawableCaches.get(r8), LongSparseArray.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r0 != null) goto L8;
        monitor-exit(this);
        return null;
    L8:
        WeakReference r2 = (WeakReference) ZeusTransformUtils.preCheckCast(r0.get(r7), WeakReference.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r2 == null) goto L16;
        Drawable.ConstantState r3 = (Drawable.ConstantState) ZeusTransformUtils.preCheckCast(r2.get(), Drawable.ConstantState.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
        if (r3 == null) goto L15;
        Drawable r9 = r3.newDrawable(ZeusTransformUtils.getResources(r8, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L18
        monitor-exit(this);
        return r9;
    L15:
        r0.remove(r7);     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);
        return null;
    L18:
        th = move-exception;
        throw th;
    }

    public static synchronized PorterDuffColorFilter getPorterDuffColorFilter(int r3, PorterDuff.Mode r4) {
        monitor-enter(ResourceManagerInternal.class);
        ColorFilterLruCache r1 = COLOR_FILTER_CACHE;     // Catch: Throwable -> L9
        PorterDuffColorFilter r2 = r1.get(r3, r4);     // Catch: Throwable -> L9
        if (r2 != null) goto L7;
        r2 = new PorterDuffColorFilter(r3, r4);     // Catch: Throwable -> L9
        r1.put(r3, r4, r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(ResourceManagerInternal.class);
        return r2;
    L9:
        th = move-exception;
        throw th;
    }

    private ColorStateList getTintListFromCache(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> r2 = this.mTintLists;
        if (r2 == null) goto L8;
        SparseArrayCompat r6 = (SparseArrayCompat) ZeusTransformUtils.preCheckCast(r2.get(r5), SparseArrayCompat.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L7;
        return null;
    L7:
        return (ColorStateList) ZeusTransformUtils.preCheckCast(r6.get(r4), ColorStateList.class, "com.obric.memorydata.plugin");
    L8:
        return null;
    }

    private static void installDefaultInflateDelegates(ResourceManagerInternal r2) {
        if (Build.VERSION.SDK_INT >= 24) goto L6;
        r2.addDelegate("vector", new VdcInflateDelegate());
        r2.addDelegate("animated-vector", new AvdcInflateDelegate());
        r2.addDelegate("animated-selector", new AsldcInflateDelegate());
        r2.addDelegate("drawable", new DrawableDelegate());
        return;
    }

    private static boolean isVectorDrawable(Drawable r1) {
        if (ZeusTransformUtils.instanceOf(r1, VectorDrawableCompat.class) == false) goto L5;
    L8:
        return true;
    L5:
        if (PLATFORM_VD_CLAZZ.equals(r1.getClass().getName()) == true) goto L8;
        return false;
    }

    private Drawable loadDrawableFromDelegates(Context r12, int r13) {
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        SimpleArrayMap<String, InflateDelegate> r0 = this.mDelegates;
        if (r0 != null) goto L5;
    L43:
        return null;
    L5:
        if (r0.isEmpty() == true) goto L43;
        SparseArrayCompat<String> r1 = this.mKnownDrawableIdTags;
        if (r1 == null) goto L14;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.get(r13), String.class, "com.obric.memorydata.plugin");
        if (SKIP_DRAWABLE_TAG.equals(r2) == true) goto L13;
        if (r2 == null) goto L16;
        if (this.mDelegates.get(r2) == null) goto L13;
    L16:
        if (this.mTypedValue != null) goto L18;
        this.mTypedValue = new TypedValue();
    L18:
        TypedValue r3 = this.mTypedValue;
        Resources r4 = ZeusTransformUtils.getResources(r14, "com.obric.memorydata.plugin");
        r4.getValue(r13, r3, true);
        long r5 = createCacheKey(r3);
        Drawable r7 = getCachedDrawable(r14, r5);
        if (r7 == null) goto L22;
        return r7;
    L22:
        if (r3.string != null) goto L24;
    L40:
        if (r7 != null) goto L42;
        this.mKnownDrawableIdTags.append(r13, SKIP_DRAWABLE_TAG);
    L42:
        return r7;
    L24:
        if (r3.string.toString().endsWith(".xml") == false) goto L40;
        XmlResourceParser r6 = r4.getXml(r13);     // Catch: Exception -> L38
        AttributeSet r8 = Xml.asAttributeSet(r6);     // Catch: Exception -> L38
    L26:
        int r9 = r6.next();     // Catch: Exception -> L38
        if (r9 == 2) goto L30;
        if (r9 != 1) goto L26;
    L30:
        if (r9 != 2) goto L37;
        String r10 = r6.getName();     // Catch: Exception -> L38
        this.mKnownDrawableIdTags.append(r13, r10);     // Catch: Exception -> L38
        InflateDelegate r11 = (InflateDelegate) ZeusTransformUtils.preCheckCast(this.mDelegates.get(r10), InflateDelegate.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L38
        if (r11 == null) goto L34;
        r7 = r11.createFromXmlInner(r14, r6, r8, r14.getTheme());     // Catch: Exception -> L38
    L34:
        if (r7 == null) goto L40;
        r7.setChangingConfigurations(r3.changingConfigurations);     // Catch: Exception -> L38
        addDrawableToCache(r14, r5, r7);     // Catch: Exception -> L38
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

    private Drawable tintDrawable(Context r3, int r4, boolean r5, Drawable r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        ColorStateList r0 = getTintList(r7, r4);
        if (r0 != null) goto L5;
        ResourceManagerHooks r1 = this.mHooks;
        if (r1 == null) goto L16;
        if (r1.tintDrawable(r7, r4, r6) == false) goto L16;
        return r6;
    L16:
        if (tintDrawableUsingColorFilter(r7, r4, r6) == true) goto L22;
        if (r5 == false) goto L23;
        return null;
    L23:
        return r6;
    L22:
        return r6;
    L5:
        if (DrawableUtils.canSafelyMutateDrawable(r6) == false) goto L7;
        r6 = r6.mutate();
    L7:
        Drawable r8 = DrawableCompat.wrap(r6);
        DrawableCompat.setTintList(r8, r0);
        PorterDuff.Mode r2 = getTintMode(r4);
        if (r2 == null) goto L20;
        DrawableCompat.setTintMode(r8, r2);
        return r8;
    L20:
        return r8;
    }

    static void tintDrawable(Drawable r3, TintInfo r4, int[] r5) {
        int[] r0 = r3.getState();
        if (DrawableUtils.canSafelyMutateDrawable(r3) == false) goto L12;
        if (r3.mutate() != r3) goto L7;
        boolean r1 = true;
    L8:
        if (r1 == true) goto L12;
        Log.d(TAG, "Mutated drawable is not the same instance as the input.");
        return;
    L7:
        r1 = false;
    L12:
        if (ZeusTransformUtils.instanceOf(r3, LayerDrawable.class) == false) goto L17;
        if (r3.isStateful() == false) goto L17;
        r3.setState(new int[0]);
        r3.setState(r0);
    L17:
        if (r4.mHasTintList == true) goto L23;
        if (r4.mHasTintMode == true) goto L23;
        r3.clearColorFilter();
    L32:
        if (Build.VERSION.SDK_INT > 23) goto L35;
        r3.invalidateSelf();
        return;
    L35:
        return;
    L23:
        if (r4.mHasTintList == false) goto L25;
        ColorStateList r2 = r4.mTintList;
    L27:
        if (r4.mHasTintMode == false) goto L29;
        PorterDuff.Mode r6 = r4.mTintMode;
    L30:
        r3.setColorFilter(createTintFilter(r2, r6, r5));
        goto L32
    L29:
        r6 = DEFAULT_MODE;
        goto L30
    L25:
        r2 = null;
        goto L27
    }

    public synchronized Drawable getDrawable(Context r3, int r4) {
        monitor-enter(this);
        Drawable r5 = getDrawable((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4, false);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized Drawable getDrawable(Context r3, int r4, boolean r5) {
        monitor-enter(this);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        checkVectorDrawableSetup(r6);     // Catch: Throwable -> L14
        Drawable r0 = loadDrawableFromDelegates(r6, r4);     // Catch: Throwable -> L14
        if (r0 != null) goto L6;
        r0 = createDrawableIfNeeded(r6, r4);     // Catch: Throwable -> L14
    L6:
        if (r0 != null) goto L8;
        r0 = ContextCompat.getDrawable(r6, r4);     // Catch: Throwable -> L14
    L8:
        if (r0 == null) goto L10;
        r0 = tintDrawable(r6, r4, r5, r0);     // Catch: Throwable -> L14
    L10:
        if (r0 == null) goto L12;
        DrawableUtils.fixDrawable(r0);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r0;
    L14:
        th = move-exception;
        throw th;
    }

    synchronized ColorStateList getTintList(Context r3, int r4) {
        monitor-enter(this);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        ColorStateList r0 = getTintListFromCache(r5, r4);     // Catch: Throwable -> L13
        if (r0 != null) goto L11;
        ResourceManagerHooks r1 = this.mHooks;     // Catch: Throwable -> L13
        if (r1 != null) goto L8;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        addTintListToCache(r5, r4, r0);     // Catch: Throwable -> L13
        goto L11
    L8:
        r0 = r1.getTintListForDrawableRes(r5, r4);     // Catch: Throwable -> L13
    L11:
        monitor-exit(this);
        return r0;
    L13:
        th = move-exception;
        throw th;
    }

    PorterDuff.Mode getTintMode(int r1) {
        ResourceManagerHooks r0 = this.mHooks;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.getTintModeForDrawableRes(r1);
    }

    public synchronized void onConfigurationChanged(Context r3) {
        monitor-enter(this);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        LongSparseArray r5 = (LongSparseArray) ZeusTransformUtils.preCheckCast(this.mDrawableCaches.get(r4), LongSparseArray.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        if (r5 == null) goto L6;
        r5.clear();     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    synchronized Drawable onDrawableLoadedFromResources(Context r3, VectorEnabledTintResources r4, int r5) {
        monitor-enter(this);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Drawable r0 = loadDrawableFromDelegates(r6, r5);     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
        r0 = r4.getDrawableCanonical(r5);     // Catch: Throwable -> L13
    L6:
        if (r0 == null) goto L11;
        Drawable r7 = tintDrawable(r6, r5, false, r0);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r7;
    L11:
        monitor-exit(this);
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public synchronized void setHooks(ResourceManagerHooks r3) {
        monitor-enter(this);
        this.mHooks = (ResourceManagerHooks) ZeusTransformUtils.wrapperContextForParams(r3, ResourceManagerHooks.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    boolean tintDrawableUsingColorFilter(Context r3, int r4, Drawable r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        ResourceManagerHooks r2 = this.mHooks;
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.tintDrawableUsingColorFilter(r6, r4, r5) == false) goto L7;
        return true;
    }
}
