package com.lynx.tasm.behavior.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableMap;
import com.lynx.react.bridge.mapbuffer.MapBuffer;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxPropGroup;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.lynx.tasm.behavior.a0;
import com.lynx.tasm.behavior.b1;
import com.lynx.tasm.behavior.d0;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.r0;
import com.lynx.tasm.behavior.u;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityHelper;
import com.lynx.tasm.behavior.ui.list.AbsLynxList;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll;
import com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BorderStyle;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.utils.LynxUISetter;
import com.lynx.tasm.behavior.utils.PropsUpdater;
import com.lynx.tasm.behavior.x0;
import com.lynx.tasm.behavior.y;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.event.LynxEventDetail;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.SizeValue;
import com.lynx.tasm.utils.UIThreadUtils;
import com.miui.easygo.constant.EasyGoDbTable;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class LynxBaseUI implements k, EventTarget, Cloneable, p7a.a, p7a.b {
    private static final Set<String> BACKGROUND_PROPS = null;
    protected static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = 0.0f;
    protected static final int DEFAULT_PERSPECTIVE_FACTOR = 100;
    private static final int INVALID_STICKY_SIGN = -1;
    public static final short OVERFLOW_HIDDEN = 0;
    public static final short OVERFLOW_X = 1;
    public static final short OVERFLOW_XY = 3;
    public static final short OVERFLOW_Y = 2;
    public static final int[] SPACING_TYPES = null;
    private static final String TAG = "LynxBaseUI";
    private static final int[] sDefaultOffsetToLynxView = null;
    protected boolean hasTransformChanged;
    private ArrayList mAccessibilityActions;
    protected int mAccessibilityElementStatus;
    private ArrayList<String> mAccessibilityElements;
    private ArrayList<String> mAccessibilityElementsA11y;
    protected boolean mAccessibilityEnableTap;
    private String mAccessibilityId;
    protected boolean mAccessibilityKeepFocused;
    private String mAccessibilityLabel;
    private String mAccessibilityRoleDescription;
    private String mAccessibilityStatus;
    private LynxAccessibilityHelper.LynxAccessibilityTraits mAccessibilityTraits;
    private float mAlpha;
    protected int mBackgroundColor;
    protected Bitmap.Config mBitmapConfig;
    private boolean mBlockListEvent;
    private boolean mBlockNativeEvent;
    private ArrayList<ArrayList<SizeValue>> mBlockNativeEventAreas;
    protected int mBorderBottomWidth;
    protected int mBorderLeftWidth;
    protected int mBorderRightWidth;
    private int mBorderSpacingIndex;
    protected int mBorderTopWidth;
    private int mBorderWidth;
    private Rect mBound;
    protected ArrayList<Runnable> mBoundingClientRectCallbacks;
    protected int mCSSPosition;
    protected final List<LynxBaseUI> mChildren;
    private boolean mClipToRadius;
    protected boolean mConsumeHoverEvent;
    private ArrayList<ArrayList<Float>> mConsumeSlideEventAngles;
    protected LynxContext mContext;
    private ReadableMap mDataset;
    private boolean mDisableDefaultResize;
    private boolean mDisplayNone;
    protected k mDrawParent;
    protected c mDrawableCallback;
    private boolean mEnableBitmapGradient;
    private EventTarget.EnableStatus mEnableExposureUIClip;
    private Boolean mEnableExposureUIMargin;
    private boolean mEnableScrollMonitor;
    protected boolean mEnableTouchPseudoPropagation;
    protected EventTarget.EnableStatus mEventThrough;
    protected ArrayList<ArrayList<SizeValue>> mEventThroughActiveRegions;
    protected Map<String, EventsListener> mEvents;
    private String mExposureArea;
    private String mExposureID;
    private String mExposureScene;
    private float mExposureScreenMarginBottom;
    private float mExposureScreenMarginLeft;
    private float mExposureScreenMarginRight;
    private float mExposureScreenMarginTop;
    private String mExposureUIMarginBottom;
    private String mExposureUIMarginLeft;
    private String mExposureUIMarginRight;
    private String mExposureUIMarginTop;
    private float mExtraOffsetX;
    private float mExtraOffsetY;
    protected int mFlattenChildrenCount;
    protected boolean mFocusable;
    protected float mFontSize;
    protected int mGestureArenaMemberId;
    protected Map<Integer, s7a.a> mGestureDetectors;
    protected Map<Integer, t7a.a> mGestureHandlers;
    private boolean mHasRadius;
    protected boolean mHasTranslateDiff;
    private int mHeight;
    private float mHitSlopBottom;
    private float mHitSlopLeft;
    private float mHitSlopRight;
    private float mHitSlopTop;
    private Matrix mHitTestMatrix;
    private String mIdSelector;
    protected EventTarget.EnableStatus mIgnoreFocus;
    protected int mImageRendering;
    protected boolean mIncludeNativeGesture;
    private boolean mIsDetachedWithView;
    protected boolean mIsFirstAnimatedReady;
    protected boolean mIsTransformNode;
    private final Point mLastSize;
    private float mLastTranslateZ;
    private final Point mLatestSize;
    private int mLeft;
    protected com.lynx.tasm.behavior.ui.utils.e mLynxBackground;
    protected int mLynxDirection;
    protected com.lynx.tasm.behavior.ui.utils.g mLynxMask;
    protected int mMarginBottom;
    protected int mMarginLeft;
    protected int mMarginRight;
    protected int mMarginTop;
    protected float mMaxHeight;
    private String mName;
    private boolean mNeedSortChildren;
    private boolean mNeedsBackgroundRecreation;
    protected LynxBaseUI mNextDrawUI;
    protected int mNodeIndex;
    protected ArrayList<Runnable> mNodeReadyBlockArray;
    private WeakReference<int[]> mOffsetDescendantRectToLynxView;
    private boolean mOnResponseChain;
    private int mOriginLeft;
    private int mOriginTop;
    protected int mOverflow;
    protected int mPaddingBottom;
    protected int mPaddingLeft;
    protected int mPaddingRight;
    protected int mPaddingTop;
    protected EventTarget.PanInterceptDirection mPanInterceptDirection;
    protected EventTarget.PanInterceptScope mPanInterceptScope;
    protected Object mParam;
    protected k mParent;
    protected ReadableArray mPerspective;
    protected EventTarget.PointerEventsValue mPointerEvents;
    protected float mPrePerspectiveValue;
    protected LynxBaseUI mPreviousDrawUI;
    protected final JavaOnlyMap mProps;
    private int mPseudoStatus;
    private String mRefId;
    private String mScrollMonitorTag;
    private volatile f mScrollStateChangeListener;
    private boolean mShouldAttachChildrenView;
    private int mSign;
    private float mSkewX;
    private float mSkewY;
    private boolean mSkipLayoutUpdated;
    private boolean mSkipRedirection;
    private volatile Set<f> mStateChangeListeners;
    protected Sticky mSticky;
    private int mStickyScrollerSign;
    private String mTagName;
    private String mTestTagName;
    private int mTop;
    private float mTouchSlop;
    private Matrix mTransformMatrix;
    protected com.lynx.tasm.behavior.ui.utils.l mTransformOrigin;
    protected List<n> mTransformRaw;
    protected float mTranslationZ;
    private com.lynx.tasm.behavior.g mUIPaintStyles;
    private f6a.a mUseLocalCache;
    private int mWidth;
    protected boolean nativeInteractionEnabled;
    protected boolean userInteractionEnabled;

    public class Sticky extends RectF {
        public float a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;
        public float g;
        public float h;

        public Sticky() {
        }
    }

    public class TransOffset {
        public float[] left_bottom;
        public float[] left_top;
        public float[] right_bottom;
        public float[] right_top;
        final /* synthetic */ LynxBaseUI this$0;

        public TransOffset(LynxBaseUI r1) {
            this.this$0 = r1;
        }
    }

    public class a implements Runnable {
        public final /* synthetic */ ReadableMap a;
        public final /* synthetic */ Callback b;
        public final /* synthetic */ LynxBaseUI c;

        @Override // java.lang.Runnable
        public final void run() {
            LynxBaseUI.access$100(this.c, this.a, this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(LynxBaseUI r1, ReadableMap r2, Callback r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    public class b implements f {
        public final /* synthetic */ LynxBaseUI a;

        public b(LynxBaseUI r1) {
            this.a = r1;
        }

        @Override // com.lynx.tasm.behavior.ui.f
        public final void onScrollStateChanged(int r5) {
            LynxBaseUI r0 = this.a;
            monitor-enter(r0);
            f[] r1 = (f[]) LynxBaseUI.access$300(this.a).toArray(new f[LynxBaseUI.access$300(this.a).size()]);     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            int r2 = r1.length;
            int r3 = 0;
        L7:
            if (r3 >= r2) goto L9;
            r1[r3].onScrollStateChanged(r5);
            r3 = r3 + 1;
            goto L7
        L9:
            return;
        L10:
            th = move-exception;
            throw th;
        }
    }

    public class c implements Drawable.Callback {
        public final /* synthetic */ LynxBaseUI a;

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable r1, Runnable r2, long r3) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable r1, Runnable r2) {
        }

        public c(LynxBaseUI r1) {
            this.a = r1;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable r1) {
            this.a.invalidate();
        }
    }

    static {
        SPACING_TYPES = new int[]{8, 0, 2, 1, 3, 4, 5};
        sDefaultOffsetToLynxView = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = (float) Math.sqrt(5.0d);
        BACKGROUND_PROPS = new HashSet(Arrays.asList(new String[]{"background-color", "background-image", "background-origin", "background-position", "background-repeat", "background-size", "border-bottom-left-radius", "border-bottom-right-radius", "border-top-left-radius", "border-top-right-radius", "border-radius"}));
    }

    private synchronized void initScrollStateChangeListener() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mScrollStateChangeListener == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mScrollStateChangeListener = new b(this);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // p7a.a
    public boolean canConsumeGesture(float r1, float r2) {
        return false;
    }

    public boolean canHaveFlattenChild() {
        return true;
    }

    public void consumeGesture(boolean r1) {
    }

    public void createViewAsync() {
    }

    public boolean dispatchEvent(LynxEventDetail r1) {
        return false;
    }

    public void dispatchProperties(x0 r1) {
    }

    public boolean dispatchTouch(MotionEvent r1) {
        return false;
    }

    public boolean enableLayoutAnimation() {
        return false;
    }

    public void ensureCreateView(View r1) {
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return null;
    }

    public LynxBaseUI getExposeReceiveTarget() {
        return this;
    }

    public long getFirstMeaningfulContentPresentedTimestampMicros() {
        return -1;
    }

    public int getInitialOverflowType() {
        return 1;
    }

    public com.lynx.tasm.animation.keyframe.a getKeyframeManager() {
        return null;
    }

    public t6a.c getLayoutAnimator() {
        return null;
    }

    @Override // p7a.a
    public int getMemberScrollX() {
        return 0;
    }

    @Override // p7a.a
    public int getMemberScrollY() {
        return 0;
    }

    public long getMemoryUsageBytes() {
        return 0;
    }

    public Map<String, String> getMemoryUsageDetail() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget getRootLynxPageUI() {
        EventTarget r0 = this;
    L3:
        if (r0 == null) goto L7;
        if (r0.getParentLynxPageUI() == null) goto L7;
        r0 = r0.getParentLynxPageUI();
    L7:
        return r0;
    }

    public float getScaleX() {
        return 1.0f;
    }

    public float getScaleY() {
        return 1.0f;
    }

    @Override // p7a.a
    public int getScrollContainerDirection() {
        return 0;
    }

    public int getScrollX() {
        return 0;
    }

    public int getScrollY() {
        return 0;
    }

    public u6a.a getTransitionAnimator() {
        return null;
    }

    public float getTranslationX() {
        return 0.0f;
    }

    public float getTranslationY() {
        return 0.0f;
    }

    public Object getValueFromNativeStorage(String r1) {
        return null;
    }

    public void initTransitionAnimator(ReadableMap r1) {
    }

    public boolean initialPropsFlushed(String r1, String r2) {
        return true;
    }

    public void initialize() {
    }

    public void interceptGesture(boolean r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.k
    public void invalidate() {
    }

    public boolean isAccessibilityDirectionVertical() {
        return true;
    }

    public boolean isAccessibilityHostUI() {
        return false;
    }

    @Override // p7a.a
    public boolean isAtBorder(boolean r1) {
        return true;
    }

    public boolean isCustomHittest() {
        return false;
    }

    public boolean isFlatten() {
        return false;
    }

    public boolean isOverlay() {
        return false;
    }

    public boolean isScrollContainer() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isScrollable() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public boolean needCustomLayout() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void offResponseChain() {
        this.mOnResponseChain = false;
    }

    public void onAnimationNodeReady() {
    }

    public void onAnimationUpdated() {
    }

    public void onBeforeAnimation(int r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8) {
    }

    public void onBorderRadiusUpdated(int r1) {
    }

    public void onDrawingPositionChanged() {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onFocusChanged(boolean r1, boolean r2) {
    }

    @Override // p7a.a
    public void onGestureScrollBy(float r1, float r2) {
    }

    @Override // p7a.a
    public void onInvalidate() {
    }

    public void onLayoutFinish(long r1) {
    }

    public void onLayoutFinish(long r1, LynxBaseUI r3) {
    }

    public void onNodeReload() {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onResponseChain() {
        this.mOnResponseChain = true;
    }

    public void registerViewAccordingToNodeIndex() {
    }

    public void removeChildrenExposureUI() {
    }

    public void removeKeyFromNativeStorage(String r1) {
    }

    public void renderIfNeeded() {
    }

    public boolean requestChildUIRectangleOnScreen(LynxBaseUI r1, Rect r2, boolean r3) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.k
    public void requestLayout() {
    }

    public float[] scrollBy(float r4, float r5) {
        return new float[]{0.0f, 0.0f, r4, r5};
    }

    @LynxProp(name = "accessibility-heading")
    public void setAccessibilityHeading(boolean r1) {
    }

    @LynxProp(name = "accessibility-value")
    public void setAccessibilityValue(String r1) {
    }

    public void setAnimation(ReadableArray r1) {
    }

    @LynxProp(name = "caret-color")
    public void setCaretColor(String r1) {
    }

    public void setInitialPropsHasFlushed(String r1, String r2) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setPanInterceptAncestors(boolean r1) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setPanInterceptDescendants(boolean r1) {
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setPanInterceptSelf(boolean r1) {
    }

    public void setStickyTranslate(PointF r1) {
    }

    public void storeKeyToNativeStorage(String r1, Object r2) {
    }

    public void updateExtraData(Object r1) {
    }

    private void ensureLynxBackground() {
        if (this.mLynxBackground != null) goto L5;
    L6:
        com.lynx.tasm.behavior.ui.utils.e r0 = new com.lynx.tasm.behavior.ui.utils.e(this.mContext);
        this.mLynxBackground = r0;
        r0.c = this.mDrawableCallback;
        r0.d = this.mFontSize;
        this.mNeedsBackgroundRecreation = false;
        restoreBackgroundProps();
        return;
    L5:
        if (this.mNeedsBackgroundRecreation == true) goto L6;
    }

    private com.lynx.tasm.behavior.ui.utils.g getOrCreateLynxMask() {
        if (this.mLynxMask != null) goto L8;
        com.lynx.tasm.behavior.ui.utils.g r0 = new com.lynx.tasm.behavior.ui.utils.g(this.mContext);
        this.mLynxMask = r0;
        r0.c = this.mDrawableCallback;
        r0.d = this.mFontSize;
        boolean r1 = this.mEnableBitmapGradient;
        com.lynx.tasm.behavior.ui.utils.i r2 = r0.b();
        r2.e.j = r1;
        r2.invalidateSelf();
        this.mLynxMask.f(this.mBitmapConfig);
        com.lynx.tasm.behavior.ui.utils.g r3 = this.mLynxMask;
        r3.b().c(SPACING_TYPES[this.mBorderSpacingIndex], this.mBorderWidth);
        com.lynx.tasm.behavior.ui.utils.g r4 = this.mLynxMask;
        float r5 = this.mPaddingTop;
        float r6 = this.mPaddingRight;
        float r7 = this.mPaddingBottom;
        float r8 = this.mPaddingLeft;
        T r9 = r4.b;
        if (r9 == 0) goto L8;
        r9.d(r5, r6, r7, r8);
    L8:
        return this.mLynxMask;
    }

    private float getTouchSlop() {
        if (this.mOnResponseChain == true) goto L5;
        return 0.0f;
    L5:
        return this.mTouchSlop * INVOKEVIRTUAL_com_lynx_tasm_behavior_ui_LynxBaseUI_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources()).density;
    }

    private boolean isImageConfigBadCase() {
        if (Build.VERSION.SDK_INT == 25) goto L5;
    L7:
        return false;
    L5:
        if (isMeizu15() == false) goto L7;
        return true;
    }

    private static boolean isMeizu() {
        String r0 = Build.BRAND;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.toLowerCase(Locale.ENGLISH).indexOf("meizu") <= (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    private void removeSelfFromStickyScrollerIfNeeded() {
        int r0 = this.mStickyScrollerSign;
        if (r0 != (-1)) goto L5;
        return;
    L5:
        LynxContext r2 = this.mContext;
        if (r2 == null) goto L8;
        Cloneable r1 = r2.findLynxUIBySign(r0);
    L10:
        if ((r1 instanceof g7a.c) == false) goto L12;
        ((g7a.c) r1).z(getSign());
    L12:
        this.mStickyScrollerSign = -1;
        return;
    L8:
        r1 = null;
        goto L10
    }

    private void restoreBackgroundProps() {
        ReadableMapKeySetIterator r0 = this.mProps.keySetIterator();
        x0 r1 = null;
        LynxUISetter r2 = null;
    L4:
        if (r0.hasNextKey() == false) goto L11;
        String r3 = r0.nextKey();
        if (BACKGROUND_PROPS.contains(r3) == false) goto L4;
        if (r1 != null) goto L9;
        r1 = new x0(this.mProps);
        Map<Class<?>, LynxUISetter<?>> r4 = PropsUpdater.a;
        r2 = PropsUpdater.c(getClass());
    L9:
        if (r2 == null) goto L4;
        r2.setProperty(this, r3, r1);
        goto L4
    }

    public void afterAnimationNodeReady() {
        if (this.mIsFirstAnimatedReady == false) goto L5;
        this.mIsFirstAnimatedReady = false;
    L5:
        Point r0 = this.mLastSize;
        Point r2 = this.mLatestSize;
        r0.x = r2.x;
        r0.y = r2.y;
        this.hasTransformChanged = false;
    }

    public LynxBaseUI clone() throws CloneNotSupportedException {
        LynxBaseUI r1 = this.mContext.getLynxUIOwner().createUI(this.mTagName, false);
        applyUIPaintStylesToTarget(r1);
        Iterator<LynxBaseUI> r2 = getChildren().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        LynxBaseUI r3 = r2.next().clone();
        r1.insertChild(r3, r1.getChildren().size());
        ((UIGroup) r1).insertView((LynxUI) r3);
        goto L4
    L6:
        r1.updateProperties(new x0(this.mProps));
        r1.updateLayoutSize(getWidth(), getHeight());
        r1.updateLayout(getLeft(), getTop(), getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), getMarginLeft(), getMarginTop(), getMarginRight(), r1.getMarginBottom(), getBorderLeftWidth(), getBorderTopWidth(), getBorderRightWidth(), getBorderBottomWidth(), getBound());
        r1.onLayoutFinish(0, null);
        r1.onNodeReady();
        return r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void destroy() {
        if ((this instanceof r0) == false) goto L6;
        this.mContext.unregisterPatchFinishListener((r0) this);
    L6:
        if ((this instanceof com.lynx.tasm.behavior.j) == false) goto L11;
        LynxUIOwner r0 = this.mContext.getLynxUIOwner();
        if (r0 == null) goto L11;
        r0.unregisterForegroundListener((com.lynx.tasm.behavior.j) this);
    L11:
        if (this.mContext.getIntersectionObserverManager() == null) goto L13;
        d0 r1 = this.mContext.getIntersectionObserverManager();
        r1.getClass();
        UIThreadUtils.runOnUiThreadImmediately(new a0(r1, this));
    L13:
        com.lynx.tasm.behavior.ui.utils.e r2 = this.mLynxBackground;
        if (r2 == null) goto L16;
        r2.d();
    L16:
        com.lynx.tasm.behavior.ui.utils.g r3 = this.mLynxMask;
        if (r3 == null) goto L19;
        r3.d();
    L19:
        com.lynx.tasm.behavior.ui.accessibility.d r4 = this.mContext.getLynxAccessibilityWrapper();
        if (r4 == null) goto L22;
        r4.c(this, false);
    L22:
        q7a.b r5 = getGestureArenaManager();
        if (r5 == null) goto L25;
        r5.f(this);
    L25:
        Map<Integer, t7a.a> r6 = this.mGestureHandlers;
        if (r6 == null) goto L29;
        r6.clear();
        return;
    }

    public void flattenChildrenCountDecrement() {
        this.mFlattenChildrenCount--;
    }

    public void flattenChildrenCountIncrement() {
        this.mFlattenChildrenCount++;
    }

    public Rect getBoundingClientRect() {
        ViewGroup r0 = this.mContext.getUIBody().getBodyView();
        int r1 = 0;
        if (r0 != null) goto L7;
        return new Rect(0, 0, getWidth() + 0, getHeight() + 0);
    L7:
        if ((this instanceof LynxUI) == false) goto L26;
        View r2 = ((LynxUI) this).mView;
        if ((r2 instanceof UIShadowProxy.d) == false) goto L13;
        UIShadowProxy.d r3 = (UIShadowProxy.d) r2;
        if (r3.getChildCount() <= 0) goto L13;
        r2 = r3.getChildAt(0);
    L13:
        Rect r4 = new Rect();
        View r5 = r2.getRootView();
        if (r0.getRootView() != r5) goto L16;
    L43:
        r0.offsetDescendantRectToMyCoords(r2, r4);     // Catch: IllegalArgumentException -> L20
        r4.offset(r2.getScrollX(), r2.getScrollY());     // Catch: IllegalArgumentException -> L20
    L21:
        int[] r6 = getOffsetDescendantRectToLynxView();
        int r7 = r6[0];
        if (r7 == Integer.MIN_VALUE) goto L24;
        r4.offset(r7, r6[1]);
    L24:
        int r8 = r4.top;
        r1 = r4.left;
        int r9 = r8;
    L42:
        return new Rect(r1, r9, getWidth() + r1, getHeight() + r9);
    L16:
        if ((r5 instanceof ViewGroup) == false) goto L43;
        r0 = (ViewGroup) r5;
        goto L43
    L26:
        if ((this instanceof LynxFlattenUI) == false) goto L40;
        k r10 = this.mParent;
        if (r10 != null) goto L30;
    L39:
        r1 = this.mLeft;
        r9 = this.mTop;
        goto L42
    L30:
        if (r10 == this.mContext.getUIBody()) goto L39;
        r9 = 0;
        LynxBaseUI r11 = this;
    L33:
        if ((r11 instanceof LynxFlattenUI) == false) goto L37;
        if (r11 == this.mContext.getUIBody()) goto L37;
        r1 = r1 + r11.getOriginLeft();
        r9 = r9 + r11.getOriginTop();
        r11 = r11.getParentBaseUI();
    L37:
        if (r11 == null) goto L42;
        Rect r12 = r11.getBoundingClientRect();
        r1 = r1 + (r12.left - r11.getScrollX());
        r9 = r9 + (r12.top - r11.getScrollY());
        goto L42
    L40:
        r9 = 0;
        goto L42
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public HashMap<String, EventTarget> getChildrenLynxPageUI() {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getUIBody() != null) goto L8;
        return null;
    L8:
        return this.mContext.getUIBody().getChildrenLynxPageUI();
    }

    public LynxBaseUI getDrawParent() {
        return (LynxBaseUI) this.mDrawParent;
    }

    public boolean getEnableExposureUIMargin() {
        Boolean r0 = this.mEnableExposureUIMargin;
        if (r0 == null) goto L6;
        return r0.booleanValue();
    L6:
        return this.mContext.getEnableExposureUIMargin();
    }

    public String getExposeUniqueID() {
        return String.valueOf(this.mSign);
    }

    public q7a.b getGestureArenaManager() {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return null;
    L5:
        LynxUIOwner r1 = r0.getLynxUIOwner();
        if (r1 != null) goto L9;
        return null;
    L9:
        return r1.getGestureArenaManager();
    }

    public Matrix getHitTestMatrix() {
        this.mHitTestMatrix.reset();
        return this.mHitTestMatrix;
    }

    public final int getLatestHeight() {
        return this.mLatestSize.y;
    }

    public final int getLatestWidth() {
        return this.mLatestSize.x;
    }

    public int[] getOffsetDescendantRectToLynxView() {
        int[] r0 = this.mOffsetDescendantRectToLynxView.get();
        if (r0 == null) goto L6;
        return r0;
    L6:
        return sDefaultOffsetToLynxView;
    }

    public com.lynx.tasm.behavior.g getOrCreateUIPaintStyles() {
        if (this.mUIPaintStyles != null) goto L6;
        this.mUIPaintStyles = new com.lynx.tasm.behavior.g();
    L6:
        return this.mUIPaintStyles;
    }

    public LynxBaseUI getParentBaseUI() {
        k r0 = this.mParent;
        if ((r0 instanceof UIShadowProxy) == false) goto L7;
        return (LynxBaseUI) ((UIShadowProxy) r0).getParent();
    L7:
        return (LynxBaseUI) r0;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget getParentLynxPageUI() {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.getUIBody() != null) goto L8;
        return null;
    L8:
        return this.mContext.getUIBody().getParentLynxPageUI();
    }

    public JSONObject getPlatformCustomInfo() {
        return new JSONObject();
    }

    public Rect getRectToWindow() {
        UIBody.UIBodyView r0 = this.mContext.getUIBody().getBodyView();
        if (r0 == null) goto L5;
        int[] r1 = new int[2];
        r0.getLocationOnScreen(r1);
        Rect r2 = getBoundingClientRect();
        r2.offset(r1[0], r1[1]);
        return r2;
    L5:
        return new Rect();
    }

    public String getTestID() {
        String r0 = this.mTestTagName;
        if (r0 != null) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return r0;
    }

    public b1 getTouchEventDispatcher() {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getTouchEventDispatcher();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public Matrix getTransformMatrix() {
        this.mTransformMatrix.reset();
        return this.mTransformMatrix;
    }

    public boolean getVisibility() {
        return !this.mDisplayNone;
    }

    public Window getWindow() {
        Context r0 = this.mContext;
    L4:
        if ((r0 instanceof ContextWrapper) == false) goto L9;
        if ((r0 instanceof Activity) == true) goto L13;
        r0 = ((ContextWrapper) r0).getBaseContext();
        goto L4
    L13:
        return ((Activity) r0).getWindow();
    L9:
        return null;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean hasConsumeSlideEventAngles() {
        ArrayList<ArrayList<Float>> r0 = this.mConsumeSlideEventAngles;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isEmpty() == true) goto L7;
        return true;
    }

    public final boolean hasSizeChanged() {
        return !this.mLastSize.equals(this.mLatestSize);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean ignoreFocus() {
        EventTarget.EnableStatus r0 = this.mIgnoreFocus;
        if (r0 != EventTarget.EnableStatus.Enable) goto L7;
        return true;
    L7:
        if (r0 != EventTarget.EnableStatus.Disable) goto L10;
        return false;
    L10:
        if (parent() != null) goto L12;
        return false;
    L12:
        return parent().ignoreFocus();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isClickable() {
        Map<String, EventsListener> r0 = this.mEvents;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.containsKey(LynxTouchEvent.EVENT_TAP) == false) goto L7;
        return true;
    }

    public boolean isEnableNewGesture() {
        if (this.mGestureArenaMemberId <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isLongClickable() {
        Map<String, EventsListener> r0 = this.mEvents;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.containsKey(LynxTouchEvent.EVENT_LONG_PRESS) == false) goto L7;
        return true;
    }

    public void layout() {
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().layout();
        goto L4
    }

    public void measure() {
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().measure();
        goto L4
    }

    public void onAttach() {
        com.lynx.tasm.behavior.ui.utils.e r0 = this.mLynxBackground;
        if (r0 == null) goto L5;
        r0.c();
    L5:
        com.lynx.tasm.behavior.ui.utils.g r1 = this.mLynxMask;
        if (r1 == null) goto L9;
        r1.c();
        return;
    }

    public void onDetach() {
        com.lynx.tasm.behavior.ui.utils.e r0 = this.mLynxBackground;
        if (r0 == null) goto L5;
        r0.d();
    L5:
        com.lynx.tasm.behavior.ui.utils.g r1 = this.mLynxMask;
        if (r1 == null) goto L9;
        r1.d();
        return;
    }

    public void onLayoutUpdated() {
        if (this.mSkipLayoutUpdated == false) goto L5;
        return;
    L5:
        com.lynx.tasm.behavior.ui.utils.e r0 = this.mLynxBackground;
        if (r0 == null) goto L10;
        float r1 = this.mPaddingTop;
        float r2 = this.mPaddingRight;
        float r3 = this.mPaddingBottom;
        float r4 = this.mPaddingLeft;
        T r5 = r0.b;
        if (r5 == 0) goto L10;
        r5.d(r1, r2, r3, r4);
    L10:
        com.lynx.tasm.behavior.ui.utils.g r6 = this.mLynxMask;
        if (r6 == null) goto L15;
        float r7 = this.mPaddingTop;
        float r8 = this.mPaddingRight;
        float r9 = this.mPaddingBottom;
        float r10 = this.mPaddingLeft;
        T r11 = r6.b;
        if (r11 == 0) goto L15;
        r11.d(r7, r8, r9, r10);
    L15:
        invalidate();
        requestLayout();
    }

    public void onNodeRemoved() {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getEnableNewSticky() == false) goto L9;
        removeSelfFromStickyScrollerIfNeeded();
        setStickyTranslate(null);
        return;
    }

    public void onPropsUpdated() {
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L6;
        r0.addUIToExposedMap(this);
    L6:
        if (this.mGestureHandlers == null) goto L13;
        q7a.b r1 = getGestureArenaManager();
        if (r1 != null) goto L10;
        return;
    L10:
        if (r1.e(getGestureArenaMemberId()) == true) goto L15;
        this.mGestureArenaMemberId = r1.a(this);
        return;
    L15:
        return;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget parent() {
        k r0 = this.mParent;
        if ((r0 instanceof EventTarget) == true) goto L5;
        return null;
    L5:
        return (EventTarget) r0;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public v6a.a parentResponder() {
        k r0 = this.mParent;
        if ((r0 instanceof v6a.a) == true) goto L5;
        return null;
    L5:
        return (v6a.a) r0;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget.PointerEventsValue pointerEvents() {
        EventTarget.PointerEventsValue r0 = this.mPointerEvents;
        if (r0 == EventTarget.PointerEventsValue.Unset) goto L6;
        return r0;
    L6:
        if (parent() == null) goto L10;
        return parent().pointerEvents();
    L10:
        return EventTarget.PointerEventsValue.Auto;
    }

    public void recognizeGesturere() {
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L6;
        r0.onGestureRecognized(this);
        return;
    }

    public void sendLayoutChangeEvent() {
        Map<String, EventsListener> r0 = this.mEvents;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.containsKey("layoutchange") == false) goto L9;
        Map<String, Object> r1 = buildLayoutChangeEventDetail();
        getLynxContext().getEventEmitter().sendCustomEvent(new com.lynx.tasm.event.a(getSign(), "layoutchange", r1));
        return;
    }

    public final boolean shouldDoTransform() {
        if (this.hasTransformChanged == false) goto L5;
        return true;
    L5:
        if (n.a(this.mTransformRaw) == true) goto L46;
        com.lynx.tasm.behavior.ui.utils.l r0 = this.mTransformOrigin;
        com.lynx.tasm.behavior.ui.utils.l r3 = com.lynx.tasm.behavior.ui.utils.l.e;
        if (r0 != null) goto L9;
    L43:
        boolean r1 = false;
    L44:
        if (r1 == true) goto L46;
    L48:
        return false;
    L9:
        if (r0.a == 0.5f) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == false) goto L17;
    L26:
        boolean r5 = true;
    L27:
        if (r5 == false) goto L43;
        if (r0.b != 1) goto L31;
        boolean r6 = true;
    L32:
        if (r6 == false) goto L34;
    L40:
        boolean r2 = true;
    L41:
        if (r2 == false) goto L43;
        r1 = true;
        goto L44
    L34:
        if (r0.d != 1) goto L36;
        boolean r7 = true;
    L37:
        if (r7 == true) goto L40;
        r2 = false;
        goto L41
    L36:
        r7 = false;
        goto L37
    L31:
        r6 = false;
        goto L32
    L17:
        if (r0.c == 0.5f) goto L19;
    L22:
        boolean r8 = true;
    L23:
        if (r8 == true) goto L26;
        r5 = false;
        goto L27
    L19:
        if (r0.d != 1) goto L22;
        r8 = false;
        goto L23
    L11:
        if (r0.b != 1) goto L14;
        r4 = false;
    L46:
        if (hasSizeChanged() == false) goto L48;
        return true;
    }

    public void uiOwnerDidPerformLayout() {
        if (this.mBoundingClientRectCallbacks.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList r0 = new ArrayList(this.mBoundingClientRectCallbacks);
        this.mBoundingClientRectCallbacks.clear();
        Iterator r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((Runnable) r1.next()).run();
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    private g7a.c getStickyScroller() {
        LynxBaseUI r0 = getParentBaseUI();
    L3:
        if (r0 == 0) goto L9;
        if ((r0 instanceof g7a.c) == true) goto L7;
        r0 = r0.getParentBaseUI();
        goto L3
    L7:
        return (g7a.c) r0;
    L9:
        return null;
    }

    private static boolean isMeizu15() {
        if (isMeizu() == false) goto L8;
        String r0 = Build.DEVICE;
        if (TextUtils.isEmpty(r0) == false) goto L7;
        return false;
    L7:
        return r0.contains("15");
    L8:
        return false;
    }

    public Map<String, Object> buildLayoutChangeEventDetail() {
        return getPositionInfo(LynxEnv.inst().enableTransformForPositionCalculation());
    }

    public Rect getBoundRectForOverflow() {
        if (getOverflow() != 3) goto L7;
        return null;
    L7:
        return getClipBounds();
    }

    public Rect getClipBounds() {
        int r0 = getWidth();
        int r1 = getHeight();
        DisplayMetrics r2 = getLynxContext().getScreenMetrics();
        int r4 = 0;
        if ((getOverflow() & 1) == 0) goto L5;
        int r3 = r2.widthPixels;
        int r5 = 0 - r3;
        r0 = r0 + (r3 * 2);
    L7:
        if ((getOverflow() & 2) == 0) goto L10;
        int r6 = r2.heightPixels;
        r4 = 0 - r6;
        r1 = r1 + (r6 * 2);
    L10:
        return new Rect(r5, r4, r0 + r5, r1 + r4);
    L5:
        r5 = 0;
        goto L7
    }

    @Override // p7a.a
    public Map<Integer, t7a.a> getGestureHandlers() {
        if (isEnableNewGesture() == true) goto L7;
        return null;
    L7:
        if (this.mGestureHandlers != null) goto L10;
        this.mGestureHandlers = t7a.a.c(getSign(), getLynxContext(), this, getGestureDetectorMap());
    L10:
        return this.mGestureHandlers;
    }

    public Rect getRect() {
        float r0 = getOriginLeft() + (getWidth() / 2.0f);
        float r1 = getOriginTop() + (getHeight() / 2.0f);
        float r3 = getWidth() * getScaleX();
        float r4 = getHeight() * getScaleY();
        float r2 = (r0 - (r3 / 2.0f)) + getTranslationX();
        float r5 = (r1 - (r4 / 2.0f)) + getTranslationY();
        return new Rect((int) r2, (int) r5, (int) (r2 + r3), (int) (r5 + r4));
    }

    public Rect getRectWithoutTransform() {
        float r0 = getOriginLeft();
        float r1 = getOriginTop();
        return new Rect((int) r0, (int) r1, (int) (r0 + getWidth()), (int) (r1 + getHeight()));
    }

    public void invalidateMeaningfulPaintingArea() {
        if (getLynxContext() != null) goto L6;
        return;
    L6:
        if (getLynxContext().getUIBodyView() != null) goto L8;
        return;
    L8:
        getLynxContext().getUIBodyView().invalidateMeaningfulPaintingArea();
    }

    public boolean needGenerateMeaningfulPaintingArea() {
        if (getMeaningfulContentStatus() == ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT) goto L5;
        return true;
    L5:
        return false;
    }

    public void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        Iterator<Runnable> r0 = this.mNodeReadyBlockArray.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().run();
        goto L4
    L6:
        this.mNodeReadyBlockArray.clear();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean enableTouchPseudoPropagation() {
        return this.mEnableTouchPseudoPropagation;
    }

    public int flattenChildrenCount() {
        return this.mFlattenChildrenCount;
    }

    public ArrayList<String> getAccessibilityActions() {
        return this.mAccessibilityActions;
    }

    public int getAccessibilityElementStatus() {
        return this.mAccessibilityElementStatus;
    }

    public ArrayList<String> getAccessibilityElements() {
        return this.mAccessibilityElements;
    }

    public ArrayList<String> getAccessibilityElementsA11y() {
        return this.mAccessibilityElementsA11y;
    }

    public boolean getAccessibilityEnableTap() {
        return this.mAccessibilityEnableTap;
    }

    public String getAccessibilityId() {
        return this.mAccessibilityId;
    }

    public boolean getAccessibilityKeepFocused() {
        return this.mAccessibilityKeepFocused;
    }

    public CharSequence getAccessibilityLabel() {
        return this.mAccessibilityLabel;
    }

    public String getAccessibilityRoleDescription() {
        return this.mAccessibilityRoleDescription;
    }

    public String getAccessibilityStatus() {
        return this.mAccessibilityStatus;
    }

    public LynxAccessibilityHelper.LynxAccessibilityTraits getAccessibilityTraits() {
        return this.mAccessibilityTraits;
    }

    public float getAlpha() {
        return this.mAlpha;
    }

    public int getBorderBottomWidth() {
        return this.mBorderBottomWidth;
    }

    public int getBorderLeftWidth() {
        return this.mBorderLeftWidth;
    }

    public int getBorderRightWidth() {
        return this.mBorderRightWidth;
    }

    public int getBorderTopWidth() {
        return this.mBorderTopWidth;
    }

    public Rect getBound() {
        return this.mBound;
    }

    public int getCSSPositionType() {
        return this.mCSSPosition;
    }

    public List<LynxBaseUI> getChildren() {
        return this.mChildren;
    }

    public boolean getClipToRadius() {
        return this.mClipToRadius;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public ReadableMap getDataset() {
        return this.mDataset;
    }

    public boolean getDisableDefaultResize() {
        return this.mDisableDefaultResize;
    }

    public EventTarget.EnableStatus getEnableExposureUIClip() {
        return this.mEnableExposureUIClip;
    }

    public f6a.a getEnableLocalCache() {
        return this.mUseLocalCache;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public Map<String, EventsListener> getEvents() {
        return this.mEvents;
    }

    public String getExposureArea() {
        return this.mExposureArea;
    }

    public String getExposureID() {
        return this.mExposureID;
    }

    public String getExposureScene() {
        return this.mExposureScene;
    }

    public float getExposureScreenMarginBottom() {
        return this.mExposureScreenMarginBottom;
    }

    public float getExposureScreenMarginLeft() {
        return this.mExposureScreenMarginLeft;
    }

    public float getExposureScreenMarginRight() {
        return this.mExposureScreenMarginRight;
    }

    public float getExposureScreenMarginTop() {
        return this.mExposureScreenMarginTop;
    }

    public String getExposureUIMarginBottom() {
        return this.mExposureUIMarginBottom;
    }

    public String getExposureUIMarginLeft() {
        return this.mExposureUIMarginLeft;
    }

    public String getExposureUIMarginRight() {
        return this.mExposureUIMarginRight;
    }

    public String getExposureUIMarginTop() {
        return this.mExposureUIMarginTop;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget, p7a.a
    public int getGestureArenaMemberId() {
        return this.mGestureArenaMemberId;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget, p7a.a
    public Map<Integer, s7a.a> getGestureDetectorMap() {
        return this.mGestureDetectors;
    }

    public boolean getHasRadius() {
        return this.mHasRadius;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getIdSelector() {
        return this.mIdSelector;
    }

    public int getImageRendering() {
        return this.mImageRendering;
    }

    public boolean getIncludeNativeGesture() {
        return this.mIncludeNativeGesture;
    }

    public Point getLastSize() {
        return this.mLastSize;
    }

    public float getLastTranslateZ() {
        return this.mLastTranslateZ;
    }

    public Point getLatestSize() {
        return this.mLatestSize;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public com.lynx.tasm.behavior.ui.utils.e getLynxBackground() {
        return this.mLynxBackground;
    }

    public LynxContext getLynxContext() {
        return this.mContext;
    }

    public com.lynx.tasm.behavior.ui.utils.g getLynxMask() {
        return this.mLynxMask;
    }

    public int getMarginBottom() {
        return this.mMarginBottom;
    }

    public int getMarginLeft() {
        return this.mMarginLeft;
    }

    public int getMarginRight() {
        return this.mMarginRight;
    }

    public int getMarginTop() {
        return this.mMarginTop;
    }

    public ILynxUIMeaningfulContent$MeaningfulContentStatus getMeaningfulContentStatus() {
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT;
    }

    public String getName() {
        return this.mName;
    }

    public boolean getNeedSortChildren() {
        return this.mNeedSortChildren;
    }

    public LynxBaseUI getNextDrawUI() {
        return this.mNextDrawUI;
    }

    public int getNodeIndex() {
        return this.mNodeIndex;
    }

    public int getOriginLeft() {
        return this.mOriginLeft;
    }

    public int getOriginTop() {
        return this.mOriginTop;
    }

    public int getOverflow() {
        return this.mOverflow;
    }

    public int getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public int getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public int getPaddingRight() {
        return this.mPaddingRight;
    }

    public int getPaddingTop() {
        return this.mPaddingTop;
    }

    public k getParent() {
        return this.mParent;
    }

    public LynxBaseUI getPreviousDrawUI() {
        return this.mPreviousDrawUI;
    }

    public JavaOnlyMap getProps() {
        return this.mProps;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public int getPseudoStatus() {
        return this.mPseudoStatus;
    }

    public float getRealTimeTranslationZ() {
        return this.mTranslationZ;
    }

    public String getRefIdSelector() {
        return this.mRefId;
    }

    public String getScrollMonitorTag() {
        return this.mScrollMonitorTag;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget, p7a.a
    public int getSign() {
        return this.mSign;
    }

    public float getSkewX() {
        return this.mSkewX;
    }

    public float getSkewY() {
        return this.mSkewY;
    }

    public boolean getSkipRedirection() {
        return this.mSkipRedirection;
    }

    public String getTagName() {
        return this.mTagName;
    }

    public int getTop() {
        return this.mTop;
    }

    public com.lynx.tasm.behavior.ui.utils.l getTransformOriginStr() {
        return this.mTransformOrigin;
    }

    public List<n> getTransformRaws() {
        return this.mTransformRaw;
    }

    public float getTranslationZ() {
        return this.mTranslationZ;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isDetachedWithView() {
        return this.mIsDetachedWithView;
    }

    public boolean isEnableScrollMonitor() {
        return this.mEnableScrollMonitor;
    }

    public boolean isFirstAnimatedReady() {
        return this.mIsFirstAnimatedReady;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isFocusable() {
        return this.mFocusable;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isOnResponseChain() {
        return this.mOnResponseChain;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean isUserInteractionEnabled() {
        return this.userInteractionEnabled;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget.PanInterceptDirection panInterceptDirection() {
        return this.mPanInterceptDirection;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget.PanInterceptScope panInterceptScope() {
        return this.mPanInterceptScope;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m25clone() throws CloneNotSupportedException {
        return clone();
    }

    public LynxBaseUI(Context r1) {
        this((LynxContext) r1);
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_tasm_behavior_ui_LynxBaseUI_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r1) {
        return WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics());
    }

    public static /* synthetic */ Set access$300(LynxBaseUI r0) {
        return r0.mStateChangeListeners;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void bindStickyScrollerIfNeeded(g7a.c r4) {
        if ((r4 instanceof LynxBaseUI) == false) goto L10;
        int r0 = ((LynxBaseUI) r4).getSign();
        int r1 = this.mStickyScrollerSign;
        if (r1 == (-1)) goto L8;
        if (r1 == r0) goto L8;
        removeSelfFromStickyScrollerIfNeeded();
    L8:
        this.mStickyScrollerSign = r0;
        r4.r(getSign());
        return;
    }

    private void setBorderColorForAllSpacingIndex(Integer r5) {
        ensureLynxBackground();
        float r0 = 1.0E21f;
        if (r5 != null) goto L5;
        float r1 = 1.0E21f;
    L6:
        if (r5 == null) goto L9;
        r0 = r5.intValue() >>> 24;
    L9:
        int r6 = 1;
    L11:
        if (r6 > 4) goto L13;
        this.mLynxBackground.o(SPACING_TYPES[r6], r1, r0);
        r6 = r6 + 1;
        goto L11
    L13:
        return;
    L5:
        r1 = r5.intValue() & 16777215;
        goto L6
    }

    private float toPix(String r9) {
        UIBody r0 = this.mContext.getUIBody();
        return com.lynx.tasm.utils.n.b(r9, r0.getFontSize(), getFontSize(), r0.getWidth(), r0.getHeight(), 1.0E21f, this.mContext.getScreenMetrics());
    }

    public void addNodeReadyBlock(Runnable r2) {
        if (r2 == null) goto L5;
        this.mNodeReadyBlockArray.add(r2);
        return;
    }

    public void afterPropsUpdated(x0 r6) {
        if (r6 != null) goto L4;
    L6:
        onPropsUpdated();
        onAnimationUpdated();
        com.lynx.tasm.behavior.ui.accessibility.d r0 = this.mContext.getLynxAccessibilityWrapper();
        if (r0 != null) goto L9;
    L17:
        if (r6 != null) goto L19;
        return;
    L19:
        if (r6.j() == false) goto L21;
        return;
    L21:
        if (r6.i("background-image") == false) goto L26;
        com.lynx.tasm.behavior.ui.utils.e r1 = this.mLynxBackground;
        if (r1 == null) goto L26;
        r1.e();
    L26:
        if (r6.i("mask-image") == false) goto L34;
        com.lynx.tasm.behavior.ui.utils.g r7 = this.mLynxMask;
        if (r7 == null) goto L35;
        r7.e();
        return;
    L35:
        return;
    L34:
        return;
    L9:
        if (r0.k == null) goto L17;
        if (r0.m() == false) goto L17;
        if (r6 == null) goto L17;
        ReadableMapKeySetIterator r2 = r6.a.keySetIterator();
    L15:
        if (r2.hasNextKey() == false) goto L17;
        String r3 = r2.nextKey();
        r0.k.a(4, this, r3);
        goto L15
    L4:
        if (r6.j() == true) goto L6;
        invalidate();
        goto L6
    }

    public void applyUIPaintStylesToTarget(LynxBaseUI r8) {
        com.lynx.tasm.behavior.g r0 = this.mUIPaintStyles;
        if (r8 == null) goto L10;
        if (r0 == null) goto L12;
        r8.setBackgroundClip(r0.a);
        r8.setBackgroundColor(r0.b);
        r8.setBackgroundImage(r0.c);
        r8.setBackgroundOrigin(r0.d);
        r8.setBackgroundPosition(r0.e);
        r8.setBackgroundRepeat(r0.f);
        r8.setBackgroundSize(r0.g);
        r8.setMaskImage(r0.h);
        r8.setMaskOrigin(r0.i);
        r8.setMaskRepeat(r0.j);
        r8.setMaskSize(r0.k);
        r8.setMaskPosition(r0.l);
        r8.setMaskClip(r0.m);
        r8.setBorderRadius(0, r0.n);
        r8.setBorderRadius(1, r0.o);
        r8.setBorderRadius(2, r0.p);
        r8.setBorderRadius(3, r0.q);
        r8.setBorderRadius(4, r0.r);
        r8.setOverflow(r0.G);
        r8.setOverflowX(r0.H);
        r8.setOverflowY(r0.I);
        r8.setBorderStyle(0, r0.s);
        r8.setBorderStyle(1, r0.t);
        r8.setBorderStyle(2, r0.u);
        r8.setBorderStyle(3, r0.v);
        r8.setBorderStyle(4, r0.w);
        r8.setBorderWidth(0, r0.x);
        r8.setBorderWidth(1, r0.y);
        r8.setBorderWidth(2, r0.z);
        r8.setBorderWidth(3, r0.A);
        r8.setBorderWidth(4, r0.B);
        r8.setBorderColor(0, r0.C);
        r8.setBorderColor(1, r0.D);
        r8.setBorderColor(2, r0.E);
        r8.setBorderColor(3, r0.F);
        r8.setOutlineColor(r0.J);
        r8.setOutlineWidth(r0.K);
        r8.setOutlineStyle(r0.L);
        r8.setFontSize(r0.M);
        r8.setLynxDirection(r0.N);
        r8.setTransformOrigin(r0.O);
        r8.setPerspective(r0.P);
        r8.setBoxShadow(r0.Q);
        r8.setImageRendering(r0.S);
        if ((r8 instanceof LynxUI) == false) goto L11;
        LynxUI r9 = (LynxUI) r8;
        r9.setClipPath(r0.T);
        r9.setFilter(r0.U);
        r9.setLayoutAnimationCreateDelay(r0.V);
        r9.setLayoutAnimationCreateDuration(r0.W);
        r9.setLayoutAnimationCreateProperty(r0.X);
        r9.setLayoutAnimationCreateTimingFunc(r0.Y);
        r9.setLayoutAnimationDeleteDelay(r0.Z);
        r9.setLayoutAnimationDeleteDuration(r0.a0);
        r9.setLayoutAnimationDeleteProperty(r0.b0);
        r9.setLayoutAnimationDeleteTimingFunc(r0.c0);
        r9.setLayoutAnimationUpdateDelay(r0.d0);
        r9.setLayoutAnimationUpdateDuration(r0.e0);
        r9.setLayoutAnimationUpdateTimingFunc(r0.f0);
        r9.setAlpha(r0.g0);
        r9.setVisibility(r0.h0);
        r9.setTransform(r0.R);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void attachToView(LynxContext r3) {
        this.mContext = r3;
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().attachToView(r3);
        goto L4
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean blockNativeEvent(MotionEvent r12) {
        if (this.mBlockNativeEvent == false) goto L6;
        return true;
    L6:
        if (this.mBlockNativeEventAreas != null) goto L8;
        return false;
    L8:
        Rect r0 = getLynxContext().getUIBody().getBoundingClientRect();
        Rect r3 = getBoundingClientRect();
        float r4 = r12.getX();
        float r13 = r12.getY();
        float r5 = (r0.left - r3.left) + r4;
        float r1 = (r0.top - r3.top) + r13;
        int r14 = 0;
        boolean r6 = false;
    L10:
        if (r14 >= this.mBlockNativeEventAreas.size()) goto L28;
        ArrayList r7 = (ArrayList) ListProtector.get(this.mBlockNativeEventAreas, r14);
        if (r7 == null) goto L27;
        if (r7.size() != 4) goto L27;
        float r8 = ((SizeValue) ListProtector.get(r7, 0)).a(r3.right - r3.left);
        float r9 = ((SizeValue) ListProtector.get(r7, 1)).a(r3.bottom - r3.top);
        float r10 = ((SizeValue) ListProtector.get(r7, 2)).a(r3.right - r3.left) + r8;
        float r11 = ((SizeValue) ListProtector.get(r7, 3)).a(r3.bottom - r3.top) + r9;
        if (r5 >= r8) goto L18;
    L24:
        r6 = false;
    L25:
        if (r6 == false) goto L27;
        LLog.i(TAG, "blocked this point!");
        goto L28
    L18:
        if (r5 >= r10) goto L24;
        if (r1 < r9) goto L24;
        if (r1 >= r11) goto L24;
        r6 = true;
    L27:
        r14 = r14 + 1;
    L28:
        return r6;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean consumeSlideEvent(float r5) {
        ArrayList<ArrayList<Float>> r0 = this.mConsumeSlideEventAngles;
        if (r0 != null) goto L5;
        return false;
    L5:
        Iterator<ArrayList<Float>> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L13;
        ArrayList<Float> r2 = r1.next();
        if (r5 < ((Float) ListProtector.get(r2, 0)).floatValue()) goto L7;
        if (r5 > ((Float) ListProtector.get(r2, 1)).floatValue()) goto L7;
        return true;
    L13:
        return false;
    }

    public void copyPropFromOldUiInUpdateFlatten(LynxBaseUI r4) {
        this.mIsFirstAnimatedReady = r4.mIsFirstAnimatedReady;
        this.mLastSize.set(r4.getLastSize().x, r4.getLastSize().y);
        this.mLatestSize.set(r4.getLatestSize().x, r4.getLatestSize().y);
        this.mFlattenChildrenCount = r4.mFlattenChildrenCount;
        setEvents(r4.getEvents());
    }

    public void detachWithViewInfo(m r3) {
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().detachWithViewInfo(r3);
        goto L4
    }

    public LynxBaseUI getChildAt(int r2) {
        return (LynxBaseUI) ListProtector.get(this.mChildren, r2);
    }

    public int getIndex(LynxBaseUI r2) {
        return this.mChildren.indexOf(r2);
    }

    public float[] getLocationOnScreen(float[] r7) {
        int[] r0 = new int[2];
        if (isFlatten() == false) goto L6;
        r7[0] = r7[0] + getLeft();
        r7[1] = r7[1] + getTop();
    L6:
        if (isFlatten() == false) goto L12;
        k r1 = this.mDrawParent;
        if (r1 != null) goto L11;
        LLog.e(TAG, "mDrawParent of flattenUI is null, which causes the value getLocationOnScreen returns is not the correct coordinates relative to the screen!");
        return r7;
    L11:
        View r2 = ((LynxUI) r1).getView();
        r7[0] = r7[0] - r2.getScrollX();
        r7[1] = r7[1] - r2.getScrollY();
    L13:
        r2.getRootView().getLocationOnScreen(r0);
        transformFromViewToRootView(r2, r7);
        r7[0] = r7[0] + r0[0];
        r7[1] = r7[1] + r0[1];
        return r7;
    L12:
        r2 = ((LynxUI) this).getView();
        goto L13
    }

    public JavaOnlyMap getPositionInfo(boolean r6) {
        new RectF();
        if (r6 == false) goto L5;
        RectF r7 = com.lynx.tasm.behavior.ui.utils.h.e(this, new RectF(0.0f, 0.0f, getWidth(), getHeight()));
    L6:
        float r0 = getLynxContext().getScreenMetrics().density;
        JavaOnlyMap r1 = new JavaOnlyMap();
        r1.putString("id", getIdSelector());
        r1.putMap("dataset", (WritableMap) getDataset());
        r1.putDouble("left", r7.left / r0);
        r1.putDouble("top", r7.top / r0);
        r1.putDouble("right", r7.right / r0);
        r1.putDouble("bottom", r7.bottom / r0);
        r1.putDouble("width", r7.width() / r0);
        r1.putDouble("height", r7.height() / r0);
        return r1;
    L5:
        r7 = new RectF(getBoundingClientRect());
        goto L6
    }

    public void markDetachWithViewRecursively(boolean r3) {
        this.mIsDetachedWithView = r3;
        this.mNeedsBackgroundRecreation = r3;
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().markDetachWithViewRecursively(r3);
        goto L4
    }

    public void notifyScrollStateChanged(int r5) {
        if (this.mStateChangeListeners != null) goto L5;
        return;
    L5:
        monitor-enter(this);
        f[] r0 = (f[]) this.mStateChangeListeners.toArray(new f[this.mStateChangeListeners.size()]);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        int r1 = r0.length;
        int r2 = 0;
    L9:
        if (r2 >= r1) goto L11;
        r0[r2].onScrollStateChanged(r5);
        r2 = r2 + 1;
        goto L9
    L11:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // p7a.a
    public void onPlatformGestureStatusChanged(int r3) {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        b1 r1 = r0.getTouchEventDispatcher();
        if (r1 != null) goto L8;
        return;
    L8:
        if (r3 != 2) goto L10;
        boolean r4 = true;
    L11:
        r1.I = r4;
        return;
    L10:
        r4 = false;
        goto L11
    }

    public void registerScrollStateListener(f r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L6:
        if (this.mStateChangeListeners != null) goto L8;
        this.mStateChangeListeners = new HashSet();     // Catch: Throwable -> L17
    L8:
        this.mStateChangeListeners.add(r2);     // Catch: Throwable -> L17
        if (this.mStateChangeListeners.size() == 1) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L17
        return;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L17
        initScrollStateChangeListener();
        k r3 = getParent();
        if ((r3 instanceof LynxBaseUI) == false) goto L21;
        ((LynxBaseUI) r3).registerScrollStateListener(this.mScrollStateChangeListener);
        return;
    }

    public void removeChild(LynxBaseUI r2) {
        this.mChildren.remove(r2);
        r2.setParent(null);
    }

    public void scrollIntoView(ReadableMap r2) {
        scrollIntoView(r2, null);
    }

    @LynxProp(name = "a11y-id")
    public void setA11yId(f6a.a r3) {
        if (r3 != null) goto L4;
    L6:
        String r4 = NameKeys.UnloadStrategy_No_Strategy;
    L7:
        this.mAccessibilityId = r4;
        return;
    L4:
        if (ReadableType.String != r3.getType()) goto L6;
        r4 = r3.asString();
        goto L7
    }

    @LynxProp(name = "accessibility-actions")
    public void setAccessibilityActions(ReadableArray r1) {
        this.mAccessibilityActions = r1.asArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @LynxProp(name = "accessibility-element")
    public void setAccessibilityElement(f6a.a r4) {
        ?? r0 = 1;
        r0 = 1;
        r0 = 1;
        if (r4 == null) goto L21;
        ReadableType r1 = r4.getType();
        if (r1 != ReadableType.String) goto L8;
        r0 = Boolean.parseBoolean(r4.asString());
        goto L21
    L8:
        if (r1 == ReadableType.Int) goto L18;
        if (r1 == ReadableType.Number) goto L18;
        if (r1 == ReadableType.Long) goto L18;
        if (r1 != ReadableType.Boolean) goto L21;
        r0 = r4.asBoolean();
    L18:
        if (r4.asInt() != 0) goto L21;
        r0 = 0;
    L21:
        this.mAccessibilityElementStatus = r0;
    }

    @LynxProp(name = "accessibility-elements")
    public void setAccessibilityElements(f6a.a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getType() != ReadableType.String) goto L21;
        String[] r6 = r5.asString().split(",");
        if (r6.length > 0) goto L8;
        return;
    L8:
        if (this.mAccessibilityElements != null) goto L10;
        this.mAccessibilityElements = new ArrayList();
    L10:
        this.mAccessibilityElements.clear();
        int r0 = r6.length;
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L13;
        String r2 = r6[r1];
        this.mAccessibilityElements.add(r2);
        r1 = r1 + 1;
        goto L11
    L13:
        com.lynx.tasm.behavior.ui.accessibility.d r7 = this.mContext.getLynxAccessibilityWrapper();
        if (r7 != null) goto L16;
        return;
    L16:
        if (r7.f() == false) goto L24;
        r7.n.c.add(new WeakReference(this));
        return;
    L24:
        return;
    }

    @LynxProp(name = "accessibility-elements-a11y")
    public void setAccessibilityElementsA11y(f6a.a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getType() != ReadableType.String) goto L21;
        String[] r6 = r5.asString().split(",");
        if (r6.length > 0) goto L8;
        return;
    L8:
        if (this.mAccessibilityElementsA11y != null) goto L10;
        this.mAccessibilityElementsA11y = new ArrayList();
    L10:
        this.mAccessibilityElementsA11y.clear();
        int r0 = r6.length;
        int r1 = 0;
    L11:
        if (r1 >= r0) goto L13;
        String r2 = r6[r1];
        this.mAccessibilityElementsA11y.add(r2);
        r1 = r1 + 1;
        goto L11
    L13:
        com.lynx.tasm.behavior.ui.accessibility.d r7 = this.mContext.getLynxAccessibilityWrapper();
        if (r7 != null) goto L16;
        return;
    L16:
        if (r7.f() == false) goto L24;
        r7.n.d.add(new WeakReference(this));
        return;
    L24:
        return;
    }

    @LynxProp(name = "accessibility-enable-tap")
    public void setAccessibilityEnableTap(f6a.a r3) {
        if (r3 == null) goto L9;
        ReadableType r0 = r3.getType();
        if (r0 != ReadableType.String) goto L7;
        boolean r4 = Boolean.parseBoolean(r3.asString());
    L10:
        this.mAccessibilityEnableTap = r4;
        return;
    L7:
        if (r0 != ReadableType.Boolean) goto L9;
        r4 = r3.asBoolean();
    L9:
        r4 = false;
        goto L10
    }

    @LynxProp(defaultBoolean = false, name = "accessibility-exclusive-focus")
    public void setAccessibilityExclusiveFocus(boolean r2) {
        com.lynx.tasm.behavior.ui.accessibility.d r0 = this.mContext.getLynxAccessibilityWrapper();
        if (r0 == null) goto L6;
        r0.c(this, r2);
        return;
    }

    @LynxProp(name = "android-accessibility-keep-focused")
    public void setAccessibilityKeepFocused(f6a.a r3) {
        if (r3 == null) goto L9;
        ReadableType r0 = r3.getType();
        if (r0 != ReadableType.String) goto L7;
        boolean r4 = Boolean.parseBoolean(r3.asString());
    L10:
        this.mAccessibilityKeepFocused = r4;
        return;
    L7:
        if (r0 != ReadableType.Boolean) goto L9;
        r4 = r3.asBoolean();
    L9:
        r4 = false;
        goto L10
    }

    @LynxProp(name = "accessibility-label")
    public void setAccessibilityLabel(f6a.a r3) {
        if (r3 == null) goto L17;
        ReadableType r0 = r3.getType();
        if (r0 != ReadableType.String) goto L7;
        String r4 = r3.asString();
    L18:
        this.mAccessibilityLabel = r4;
        return;
    L7:
        if (r0 != ReadableType.Int) goto L9;
    L16:
        r4 = String.valueOf(r3.asInt());
        goto L18
    L9:
        if (r0 == ReadableType.Number) goto L16;
        if (r0 == ReadableType.Long) goto L16;
        if (r0 != ReadableType.Boolean) goto L17;
        r4 = String.valueOf(r3.asBoolean());
    L17:
        r4 = NameKeys.UnloadStrategy_No_Strategy;
        goto L18
    }

    @LynxProp(name = "accessibility-role-description")
    public void setAccessibilityRoleDescription(f6a.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getType() != ReadableType.String) goto L8;
        this.mAccessibilityRoleDescription = r3.asString();
        return;
    }

    @LynxProp(name = "accessibility-status")
    public void setAccessibilityStatus(f6a.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getType() != ReadableType.String) goto L8;
        this.mAccessibilityStatus = r3.asString();
        return;
    }

    @LynxProp(name = "accessibility-traits")
    public void setAccessibilityTraits(f6a.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getType() != ReadableType.String) goto L8;
        this.mAccessibilityTraits = LynxAccessibilityHelper.LynxAccessibilityTraits.fromValue(r3.asString());
        return;
    }

    public void setAlpha(float r1) {
        this.mAlpha = r1;
    }

    @LynxProp(name = "background-clip")
    public void setBackgroundClip(ReadableArray r2) {
        ensureLynxBackground();
        this.mLynxBackground.g(r2);
    }

    @LynxProp(defaultInt = 0, name = "background-color")
    public void setBackgroundColor(int r4) {
        this.mBackgroundColor = r4;
        if (getKeyframeManager() == null) goto L6;
        getKeyframeManager().d("BackgroundColor", Integer.valueOf(r4));
    L6:
        if (getTransitionAnimator() != null) goto L8;
    L10:
        ensureLynxBackground();
        this.mLynxBackground.n(r4);
        invalidate();
        return;
    L8:
        if (getTransitionAnimator().b(64) == false) goto L10;
        getTransitionAnimator().a(this, 64, Integer.valueOf(r4));
    }

    @LynxProp(name = "background-image")
    public void setBackgroundImage(ReadableArray r2) {
        ensureLynxBackground();
        this.mLynxBackground.b().e.d(r2, this);
        invalidate();
    }

    @LynxProp(name = "background-origin")
    public void setBackgroundOrigin(ReadableArray r2) {
        ensureLynxBackground();
        this.mLynxBackground.h(r2);
        invalidate();
    }

    @LynxProp(name = "background-position")
    public void setBackgroundPosition(ReadableArray r2) {
        ensureLynxBackground();
        this.mLynxBackground.i(r2);
        invalidate();
    }

    @LynxProp(name = "background-repeat")
    public void setBackgroundRepeat(ReadableArray r2) {
        ensureLynxBackground();
        this.mLynxBackground.j(r2);
        invalidate();
    }

    @LynxProp(name = "background-size")
    public void setBackgroundSize(ReadableArray r2) {
        ensureLynxBackground();
        this.mLynxBackground.k(r2);
        invalidate();
    }

    @LynxProp(defaultBoolean = false, name = "block-list-event")
    public void setBlockListEvent(boolean r1) {
        this.mBlockListEvent = r1;
    }

    @LynxProp(defaultBoolean = false, name = "block-native-event")
    public void setBlockNativeEvent(boolean r1) {
        this.mBlockNativeEvent = r1;
    }

    @LynxProp(name = "block-native-event-areas")
    public void setBlockNativeEventAreas(f6a.a r11) {
        this.mBlockNativeEventAreas = null;
        if (r11 != null) goto L5;
    L31:
        LLog.w(TAG, "setBlockNativeEventAreas input type error");
        return;
    L5:
        if (r11.getType() != ReadableType.Array) goto L31;
        if (r11.asArray() == null) goto L31;
        ReadableArray r12 = r11.asArray();
        ArrayList<ArrayList<SizeValue>> r1 = new ArrayList();
        int r3 = 0;
    L11:
        if (r3 >= r12.size()) goto L27;
        ReadableArray r4 = r12.getArray(r3);
        if (r4 != null) goto L15;
    L24:
        LLog.w(TAG, "setBlockNativeEventAreas " + r3 + "th type error, size != 4");
    L25:
        r3 = r3 + 1;
        goto L11
    L15:
        if (r4.size() != 4) goto L24;
        SizeValue r6 = SizeValue.b(r4.getString(0));
        SizeValue r7 = SizeValue.b(r4.getString(1));
        SizeValue r8 = SizeValue.b(r4.getString(2));
        SizeValue r5 = SizeValue.b(r4.getString(3));
        if (r6 == null) goto L23;
        if (r7 == null) goto L23;
        if (r8 == null) goto L23;
        if (r5 == null) goto L23;
        ArrayList<SizeValue> r9 = new ArrayList();
        r9.add(r6);
        r9.add(r7);
        r9.add(r8);
        r9.add(r5);
        r1.add(r9);
    L23:
        LLog.w(TAG, "setBlockNativeEventAreas " + r3 + "th type error");
        goto L25
    L27:
        if (r1.size() <= 0) goto L29;
        this.mBlockNativeEventAreas = r1;
        return;
    L29:
        LLog.w(TAG, "setBlockNativeEventAreas empty areas");
    }

    public void setBorderColor(String r2) {
        LLog.DTHROW(new RuntimeException("setBorderColor(String) is deprecated.This has no effect."));
    }

    public void setBound(Rect r1) {
        this.mBound = r1;
    }

    @LynxProp(name = "box-shadow")
    public void setBoxShadow(ReadableArray r3) {
        k r0 = this.mParent;
        if ((r0 instanceof UIShadowProxy) == false) goto L6;
        ((UIShadowProxy) r0).setBoxShadow(r3);
        return;
    }

    @LynxProp(defaultFloat = DisplayMetricsHolder.DEFAULT_SCREEN_SCALE, name = "position")
    public final void setCSSPosition(int r1) {
        this.mCSSPosition = r1;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setChildrenLynxPageUI(HashMap<String, EventTarget> r2) {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getUIBody() == null) goto L10;
        this.mContext.getUIBody().setChildrenLynxPageUI(r2);
        return;
    }

    @LynxProp(name = "clip-radius")
    public void setClipToRadius(f6a.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        ReadableType r0 = r3.getType();
        if (r0 != ReadableType.Boolean) goto L8;
        this.mClipToRadius = r3.asBoolean();
        return;
    L8:
        if (r0 != ReadableType.String) goto L19;
        String r4 = r3.asString();
        if (r4.equalsIgnoreCase("true") == false) goto L12;
    L15:
        boolean r5 = true;
    L16:
        this.mClipToRadius = r5;
        return;
    L12:
        if (r4.equalsIgnoreCase("yes") == true) goto L15;
        r5 = false;
        goto L16
    }

    @LynxProp(defaultBoolean = false, name = "android-consume-hover-event")
    public void setConsumeHoverEvent(boolean r2) {
        com.lynx.tasm.behavior.ui.accessibility.d r0 = this.mContext.getLynxAccessibilityWrapper();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.f() == false) goto L9;
        this.mConsumeHoverEvent = r2;
        return;
    }

    @LynxProp(name = "consume-slide-event")
    public void setConsumeSlideEvent(ReadableArray r6) {
        if (r6 != null) goto L21;
        this.mConsumeSlideEventAngles = null;
        return;
    L21:
        ArrayList<Object> r7 = r6.toArrayList();     // Catch: Throwable -> L18
        this.mConsumeSlideEventAngles = new ArrayList();     // Catch: Throwable -> L18
        Iterator<Object> r8 = r7.iterator();     // Catch: Throwable -> L18
    L7:
        if (r8.hasNext() == false) goto L34;
        Object r0 = r8.next();     // Catch: Throwable -> L18
        if ((r0 instanceof ArrayList) == false) goto L7;
        if (((ArrayList) r0).size() != 2) goto L7;
        if ((ListProtector.get((ArrayList) r0, 0) instanceof Number) == false) goto L7;
        if ((ListProtector.get((ArrayList) r0, 1) instanceof Number) == false) goto L7;
        ArrayList<Float> r1 = new ArrayList();     // Catch: Throwable -> L18
        r1.add(Float.valueOf(((Number) ListProtector.get((ArrayList) r0, 0)).floatValue()));     // Catch: Throwable -> L18
        r1.add(Float.valueOf(((Number) ListProtector.get((ArrayList) r0, 1)).floatValue()));     // Catch: Throwable -> L18
        this.mConsumeSlideEventAngles.add(r1);     // Catch: Throwable -> L18
        goto L7
    L34:
        return;
    L18:
        th = move-exception;
        LLog.e(TAG, "setConsumeSlideEvent failed since " + th.getMessage());
    }

    @LynxProp(name = "dataset")
    public void setDataset(ReadableMap r1) {
        this.mDataset = r1;
    }

    @LynxProp(name = "disable-default-resize")
    public void setDisableDefaultResize(boolean r1) {
        this.mDisableDefaultResize = r1;
    }

    public void setDisplayNone(boolean r1) {
        this.mDisplayNone = r1;
    }

    public void setDrawParent(k r1) {
        this.mDrawParent = r1;
    }

    @LynxProp(name = "bitmap-gradient")
    public void setEnableBitmapGradient(boolean r3) {
        this.mEnableBitmapGradient = r3;
        BackgroundDrawable r0 = this.mLynxBackground.b();
        r0.e.j = r3;
        r0.invalidateSelf();
        com.lynx.tasm.behavior.ui.utils.g r1 = this.mLynxMask;
        if (r1 == null) goto L5;
        com.lynx.tasm.behavior.ui.utils.i r2 = r1.b();
        r2.e.j = r3;
        r2.invalidateSelf();
    L5:
        invalidate();
    }

    @LynxProp(name = "enable-exposure-ui-clip")
    public void setEnableExposureUIClip(boolean r1) {
        if (r1 == false) goto L4;
        EventTarget.EnableStatus r2 = EventTarget.EnableStatus.Enable;
    L5:
        this.mEnableExposureUIClip = r2;
        return;
    L4:
        r2 = EventTarget.EnableStatus.Disable;
        goto L5
    }

    @LynxProp(name = "enable-exposure-ui-margin")
    public void setEnableExposureUIMargin(boolean r1) {
        this.mEnableExposureUIMargin = Boolean.valueOf(r1);
    }

    @LynxProp(name = "enable-scroll-monitor")
    public void setEnableScrollMonitor(boolean r1) {
        this.mEnableScrollMonitor = r1;
    }

    @LynxProp(name = "enable-touch-pseudo-propagation")
    public void setEnableTouchPseudoPropagation(f6a.a r3) {
        if (r3 != null) goto L11;
        this.mEnableTouchPseudoPropagation = true;
        return;
    L11:
        this.mEnableTouchPseudoPropagation = r3.asBoolean();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        LLog.i(TAG, th.toString());
        this.mEnableTouchPseudoPropagation = true;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setEventID(long r3) {
        if (getChildrenLynxPageUI() != null) goto L5;
        return;
    L5:
        LynxBaseUI r0 = (LynxBaseUI) getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this)));
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.getLynxContext() != null) goto L10;
        return;
    L10:
        if (r0.getLynxContext().getEventEmitter() == null) goto L15;
        r0.getLynxContext().getEventEmitter().setEventID(r3);
        return;
    }

    @LynxProp(name = "event-through")
    public void setEventThrough(f6a.a r2) {
        if (r2 != null) goto L14;
        this.mEventThrough = EventTarget.EnableStatus.Undefined;
        return;
    L14:
    L11:
        th = move-exception;
        LLog.i(TAG, th.toString());
        this.mEventThrough = EventTarget.EnableStatus.Undefined;
        return;
    L6:
        if (r2.asBoolean() == false) goto L8;
        EventTarget.EnableStatus r3 = EventTarget.EnableStatus.Enable;     // Catch: Throwable -> L11
    L9:
        this.mEventThrough = r3;     // Catch: Throwable -> L11
        return;
    L8:
        r3 = EventTarget.EnableStatus.Disable;     // Catch: Throwable -> L11
        goto L9
    }

    @LynxProp(name = "event-through-active-regions")
    public void setEventThroughActiveRegions(f6a.a r11) {
        this.mEventThroughActiveRegions = null;
        if (r11 != null) goto L5;
    L31:
        LLog.w(TAG, "setEventThroughActiveRegions input type error");
        return;
    L5:
        if (r11.getType() != ReadableType.Array) goto L31;
        if (r11.asArray() == null) goto L31;
        ReadableArray r12 = r11.asArray();
        ArrayList<ArrayList<SizeValue>> r1 = new ArrayList();
        int r3 = 0;
    L11:
        if (r3 >= r12.size()) goto L27;
        ReadableArray r4 = r12.getArray(r3);
        if (r4 != null) goto L15;
    L24:
        LLog.w(TAG, "setEventThroughActiveRegions " + r3 + "th type error, size != 4");
    L25:
        r3 = r3 + 1;
        goto L11
    L15:
        if (r4.size() != 4) goto L24;
        SizeValue r6 = SizeValue.b(r4.getString(0));
        SizeValue r7 = SizeValue.b(r4.getString(1));
        SizeValue r8 = SizeValue.b(r4.getString(2));
        SizeValue r5 = SizeValue.b(r4.getString(3));
        if (r6 == null) goto L23;
        if (r7 == null) goto L23;
        if (r8 == null) goto L23;
        if (r5 == null) goto L23;
        ArrayList<SizeValue> r9 = new ArrayList();
        r9.add(r6);
        r9.add(r7);
        r9.add(r8);
        r9.add(r5);
        r1.add(r9);
    L23:
        LLog.w(TAG, "setEventThroughActiveRegions " + r3 + "th type error");
        goto L25
    L27:
        if (r1.size() <= 0) goto L29;
        this.mEventThroughActiveRegions = r1;
        return;
    L29:
        LLog.w(TAG, "setEventThroughActiveRegions empty regions");
    }

    public void setEvents(Map<String, EventsListener> r1) {
        this.mEvents = r1;
    }

    @LynxProp(name = "exposure-area")
    public void setExposureArea(String r1) {
        this.mExposureArea = r1;
    }

    @LynxProp(name = "exposure-id")
    public void setExposureID(f6a.a r2) {
        this.mContext.removeUIFromExposedMap(this);
        String r3 = r2.asString();
        if (r3 != null) goto L5;
    L8:
        this.mExposureID = null;
        LLog.e(TAG, "setExposureID(Dynamic exposureID) failed, since it is not number/string, or it is empty string");
        LLog.DTHROW(new RuntimeException("setExposureID(Dynamic exposureID) failed, since it is not number/string, or it is empty string"));
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        this.mExposureID = r3;
    }

    @LynxProp(name = "exposure-scene")
    public void setExposureScene(String r2) {
        this.mContext.removeUIFromExposedMap(this);
        this.mExposureScene = r2;
    }

    @LynxProp(name = "exposure-screen-margin-bottom")
    public void setExposureScreenMarginBottom(String r2) {
        this.mExposureScreenMarginBottom = com.lynx.tasm.utils.n.a(r2, 0.0f);
    }

    @LynxProp(name = "exposure-screen-margin-left")
    public void setExposureScreenMarginLeft(String r2) {
        this.mExposureScreenMarginLeft = com.lynx.tasm.utils.n.a(r2, 0.0f);
    }

    @LynxProp(name = "exposure-screen-margin-right")
    public void setExposureScreenMarginRight(String r2) {
        this.mExposureScreenMarginRight = com.lynx.tasm.utils.n.a(r2, 0.0f);
    }

    @LynxProp(name = "exposure-screen-margin-top")
    public void setExposureScreenMarginTop(String r2) {
        this.mExposureScreenMarginTop = com.lynx.tasm.utils.n.a(r2, 0.0f);
    }

    @LynxProp(name = "exposure-ui-margin-bottom")
    public void setExposureUIMarginBottom(String r1) {
        this.mExposureUIMarginBottom = r1;
    }

    @LynxProp(name = "exposure-ui-margin-left")
    public void setExposureUIMarginLeft(String r1) {
        this.mExposureUIMarginLeft = r1;
    }

    @LynxProp(name = "exposure-ui-margin-right")
    public void setExposureUIMarginRight(String r1) {
        this.mExposureUIMarginRight = r1;
    }

    @LynxProp(name = "exposure-ui-margin-top")
    public void setExposureUIMarginTop(String r1) {
        this.mExposureUIMarginTop = r1;
    }

    @LynxProp(name = "focusable")
    public void setFocusable(Boolean r1) {
        if (r1 == null) goto L4;
        boolean r2 = r1.booleanValue();
    L5:
        this.mFocusable = r2;
        return;
    L4:
        r2 = false;
        goto L5
    }

    @LynxProp(defaultFloat = 1.0E21f, name = "font-size")
    public void setFontSize(float r2) {
        if (r2 == 1.0E21f) goto L8;
        ensureLynxBackground();
        this.mFontSize = r2;
        this.mLynxBackground.d = r2;
        com.lynx.tasm.behavior.ui.utils.g r0 = this.mLynxMask;
        if (r0 == null) goto L9;
        r0.d = r2;
        return;
    L9:
        return;
    }

    public void setGestureDetectors(Map<Integer, s7a.a> r3) {
        this.mGestureDetectors = r3;
        if (r3 != null) goto L5;
        return;
    L5:
        if (r3.isEmpty() == true) goto L32;
        q7a.b r4 = getGestureArenaManager();
        if (r4 != null) goto L11;
        return;
    L11:
        if (r4.e(getGestureArenaMemberId()) == false) goto L16;
        Map<Integer, t7a.a> r5 = this.mGestureHandlers;
        if (r5 == null) goto L16;
        r5.clear();
        this.mGestureHandlers = null;
    L16:
        if (this.mGestureHandlers == null) goto L18;
        return;
    L18:
        if (getSign() <= 0) goto L31;
        Map<Integer, t7a.a> r6 = t7a.a.c(getSign(), getLynxContext(), this, getGestureDetectorMap());
        this.mGestureHandlers = r6;
        this.mIncludeNativeGesture = false;
        Iterator<Integer> r7 = r6.keySet().iterator();
    L21:
        if (r7.hasNext() == false) goto L33;
        if (r7.next().intValue() != 7) goto L21;
        this.mIncludeNativeGesture = true;
        return;
    L33:
        return;
    L31:
        return;
    }

    public void setHeight(int r1) {
        this.mHeight = r1;
        onLayoutUpdated();
    }

    @LynxProp(name = "hit-slop")
    public void setHitSlop(f6a.a r7) {
        if (r7 == null) goto L73;
        ReadableType r0 = r7.getType();
        ReadableType r1 = ReadableType.Map;
        if (r0 == r1) goto L9;
        if (r7.getType() == ReadableType.String) goto L9;
        return;
    L9:
        if (r7.getType() == r1) goto L11;
    L47:
        float r8 = com.lynx.tasm.utils.n.a(r7.asString(), 0.0f);
        if (this.mHitSlopTop == r8) goto L50;
    L55:
        this.mHitSlopRight = r8;
        this.mHitSlopLeft = r8;
        this.mHitSlopBottom = r8;
        this.mHitSlopTop = r8;
        return;
    L50:
        if (this.mHitSlopBottom != r8) goto L55;
        if (this.mHitSlopLeft != r8) goto L55;
        if (this.mHitSlopRight != r8) goto L55;
        return;
    L11:
        if (r7.asMap().size() <= 0) goto L47;
        ReadableMap r9 = r7.asMap();
        ReadableMapKeySetIterator r2 = r9.keySetIterator();
        List r3 = Arrays.asList(new String[]{"top", "bottom", "left", "right"});
    L14:
        if (r2.hasNextKey() == false) goto L46;
        String r4 = r2.nextKey();
        if (r3.contains(r4) == false) goto L14;
        float r5 = com.lynx.tasm.utils.n.a(r9.getString(r4), 0.0f);
        int r6 = r3.indexOf(r4);
        if (r6 != 0) goto L20;
        float r10 = this.mHitSlopTop;
        if (r10 != r5) goto L45;
        r5 = r10;
    L45:
        this.mHitSlopTop = r5;
        goto L14
    L20:
        if (r6 != 1) goto L22;
        float r11 = this.mHitSlopBottom;
        if (r11 != r5) goto L40;
        r5 = r11;
    L40:
        this.mHitSlopBottom = r5;
        goto L14
    L22:
        if (r6 != 2) goto L24;
        float r12 = this.mHitSlopLeft;
        if (r12 != r5) goto L35;
        r5 = r12;
    L35:
        this.mHitSlopLeft = r5;
        goto L14
    L24:
        if (r6 != 3) goto L14;
        float r13 = this.mHitSlopRight;
        if (r13 != r5) goto L30;
        r5 = r13;
    L30:
        this.mHitSlopRight = r5;
        goto L14
    L46:
        return;
    }

    @LynxProp(name = "idSelector")
    public void setIdSelector(String r1) {
        this.mIdSelector = r1;
    }

    @LynxProp(name = "ignore-focus")
    public void setIgnoreFocus(f6a.a r2) {
        if (r2 != null) goto L14;
        this.mIgnoreFocus = EventTarget.EnableStatus.Undefined;
        return;
    L14:
    L11:
        th = move-exception;
        LLog.i(TAG, th.toString());
        this.mIgnoreFocus = EventTarget.EnableStatus.Undefined;
        return;
    L6:
        if (r2.asBoolean() == false) goto L8;
        EventTarget.EnableStatus r3 = EventTarget.EnableStatus.Enable;     // Catch: Throwable -> L11
    L9:
        this.mIgnoreFocus = r3;     // Catch: Throwable -> L11
        return;
    L8:
        r3 = EventTarget.EnableStatus.Disable;     // Catch: Throwable -> L11
        goto L9
    }

    @LynxProp(name = "image-config")
    public void setImageConfig(String r5) {
        if (r5 != null) goto L5;
    L39:
        this.mBitmapConfig = null;
        return;
    L5:
        if (r5.equalsIgnoreCase(NameKeys.UnloadStrategy_No_Strategy) == true) goto L39;
        if (r5.equalsIgnoreCase("ALPHA_8") == false) goto L11;
        this.mBitmapConfig = Bitmap.Config.ALPHA_8;
    L32:
        com.lynx.tasm.behavior.ui.utils.e r6 = this.mLynxBackground;
        if (r6 == null) goto L35;
        r6.f(this.mBitmapConfig);
    L35:
        com.lynx.tasm.behavior.ui.utils.g r7 = this.mLynxMask;
        if (r7 == null) goto L41;
        r7.f(this.mBitmapConfig);
        return;
    L41:
        return;
    L11:
        if (r5.equalsIgnoreCase("RGB_565") == false) goto L17;
        if (isImageConfigBadCase() == true) goto L15;
        this.mBitmapConfig = Bitmap.Config.RGB_565;
        goto L32
    L15:
        LLog.w("LynxBaseUI setImageConfig warn: ", "RGB_565 can't be set on Meizu15");
        this.mBitmapConfig = null;
        goto L32
    L17:
        if (r5.equalsIgnoreCase("ARGB_8888") == false) goto L20;
        this.mBitmapConfig = Bitmap.Config.ARGB_8888;
        goto L32
    L20:
        if (r5.equalsIgnoreCase("RGBA_F16") == false) goto L26;
        if (Build.VERSION.SDK_INT < 26) goto L24;
        this.mBitmapConfig = Bitmap.Config.RGBA_F16;
        goto L32
    L24:
        LLog.w("LynxBaseUI setImageConfig warn: ", "RGBA_F16 requires build version >= VERSION_CODES.O");
        this.mBitmapConfig = null;
        goto L32
    L26:
        if (r5.equalsIgnoreCase("HARDWARE") == true) goto L28;
        this.mBitmapConfig = null;
        goto L32
    L28:
        if (Build.VERSION.SDK_INT < 26) goto L30;
        this.mBitmapConfig = Bitmap.Config.HARDWARE;
        goto L32
    L30:
        this.mBitmapConfig = null;
        LLog.w("LynxBaseUI setImageConfig warn: ", "HARDWARE requires build version >= VERSION_CODES.O");
        goto L32
    }

    @LynxProp(name = "image-rendering")
    public void setImageRendering(int r1) {
        this.mImageRendering = r1;
    }

    @LynxProp(name = "intersection-observers")
    public void setIntersectionObservers(ReadableArray r5) {
        d0 r0 = this.mContext.getIntersectionObserverManager();
        r0.getClass();
        UIThreadUtils.runOnUiThreadImmediately(new a0(r0, this));
        if (r5 != null) goto L5;
        return;
    L5:
        if (this.mEvents.containsKey("intersection") == false) goto L18;
        int r1 = 0;
    L9:
        if (r1 >= r5.size()) goto L19;
        ReadableMap r2 = r5.getMap(r1);
        if (r2 == null) goto L13;
        u r3 = new u(this.mContext.getIntersectionObserverManager(), r2, this);
        d0 r4 = this.mContext.getIntersectionObserverManager();
        r4.getClass();
        UIThreadUtils.runOnUiThreadImmediately(new y(r4, r3));
    L13:
        r1 = r1 + 1;
        goto L9
    L19:
        return;
    }

    public void setLastTranslateZ(float r1) {
        this.mLastTranslateZ = r1;
    }

    public void setLeft(int r1) {
        this.mLeft = r1;
        this.mOriginLeft = r1;
        onLayoutUpdated();
    }

    @LynxProp(name = "local-cache")
    public void setLocalCache(f6a.a r1) {
        this.mUseLocalCache = r1;
    }

    public void setLynxBackground(com.lynx.tasm.behavior.ui.utils.e r1) {
        this.mLynxBackground = r1;
    }

    @LynxProp(defaultInt = 3, name = "direction")
    public void setLynxDirection(int r1) {
        this.mLynxDirection = r1;
    }

    public void setLynxMask(com.lynx.tasm.behavior.ui.utils.g r1) {
        this.mLynxMask = r1;
    }

    @LynxProp(name = "mask-clip")
    public void setMaskClip(ReadableArray r2) {
        getOrCreateLynxMask().g(r2);
        invalidate();
    }

    @LynxProp(name = "mask-image")
    public void setMaskImage(ReadableArray r2) {
        getOrCreateLynxMask().b().e.d(r2, this);
        invalidate();
    }

    @LynxProp(name = "mask-origin")
    public void setMaskOrigin(ReadableArray r2) {
        getOrCreateLynxMask().h(r2);
        invalidate();
    }

    @LynxProp(name = "mask-position")
    public void setMaskPosition(ReadableArray r2) {
        getOrCreateLynxMask().i(r2);
        invalidate();
    }

    @LynxProp(name = "mask-repeat")
    public void setMaskRepeat(ReadableArray r2) {
        getOrCreateLynxMask().j(r2);
        invalidate();
    }

    @LynxProp(name = "mask-size")
    public void setMaskSize(ReadableArray r2) {
        getOrCreateLynxMask().k(r2);
        invalidate();
    }

    @LynxProp(name = EasyGoDbTable.Server.NAME)
    public void setName(String r1) {
        this.mName = r1;
    }

    @LynxProp(defaultBoolean = false, name = "native-interaction-enabled")
    public void setNativeInteractionEnabled(boolean r1) {
        this.nativeInteractionEnabled = r1;
    }

    public void setNeedSortChildren(boolean r1) {
        this.mNeedSortChildren = r1;
    }

    public void setNextDrawUI(LynxBaseUI r1) {
        this.mNextDrawUI = r1;
    }

    public void setNodeIndex(int r1) {
        this.mNodeIndex = r1;
    }

    public void setOffsetDescendantRectToLynxView(int[] r2) {
        this.mOffsetDescendantRectToLynxView = new WeakReference(r2);
    }

    public void setOriginLeft(int r1) {
        this.mOriginLeft = r1;
    }

    public void setOriginTop(int r1) {
        this.mOriginTop = r1;
    }

    @LynxProp(defaultInt = -16777216, name = "outline-color")
    public void setOutlineColor(int r3) {
        k r0 = this.mParent;
        if ((r0 instanceof UIShadowProxy) == false) goto L6;
        ((UIShadowProxy) r0).setOutlineColor(r3);
        return;
    }

    @LynxProp(defaultInt = -1, name = "outline-style")
    public void setOutlineStyle(int r3) {
        k r0 = this.mParent;
        if ((r0 instanceof UIShadowProxy) == false) goto L6;
        ((UIShadowProxy) r0).M().a = BorderStyle.parse(r3);
        return;
    }

    @LynxProp(defaultInt = 0, name = "outline-width")
    public void setOutlineWidth(float r3) {
        k r0 = this.mParent;
        if ((r0 instanceof UIShadowProxy) == false) goto L6;
        ((UIShadowProxy) r0).setOutlineWidth(r3);
        return;
    }

    @LynxProp(name = "overflow")
    public void setOverflow(Integer r1) {
        if (r1 != null) goto L4;
        int r2 = getInitialOverflowType();
    L5:
        setOverflow(r2);
        return;
    L4:
        r2 = r1.intValue();
        goto L5
    }

    @LynxProp(name = "overflow-x")
    public void setOverflowX(Integer r2) {
        if (r2 != null) goto L4;
        int r3 = getInitialOverflowType();
    L5:
        setOverflowWithMask(1, r3);
        return;
    L4:
        r3 = r2.intValue();
        goto L5
    }

    @LynxProp(name = "overflow-y")
    public void setOverflowY(Integer r2) {
        if (r2 != null) goto L4;
        int r3 = getInitialOverflowType();
    L5:
        setOverflowWithMask(2, r3);
        return;
    L4:
        r3 = r2.intValue();
        goto L5
    }

    @LynxProp(name = "pan-intercept-direction")
    public void setPanInterceptDirection(int r2) {
        if (r2 >= EventTarget.PanInterceptDirection.Horizontal.ordinal()) goto L5;
        return;
    L5:
        if (r2 >= EventTarget.PanInterceptDirection.None.ordinal()) goto L9;
        this.mPanInterceptDirection = EventTarget.PanInterceptDirection.values()[r2];
        return;
    }

    @LynxProp(name = "pan-intercept-scope")
    public void setPanInterceptScope(int r2) {
        if (r2 >= EventTarget.PanInterceptScope.Self.ordinal()) goto L5;
        return;
    L5:
        if (r2 >= EventTarget.PanInterceptScope.None.ordinal()) goto L9;
        this.mPanInterceptScope = EventTarget.PanInterceptScope.values()[r2];
        return;
    }

    public void setParent(k r6) {
        if (this.mStateChangeListeners != null) goto L6;
        this.mParent = r6;
        return;
    L6:
        int r1 = 0;
        if ((r6 instanceof LynxBaseUI) == false) goto L18;
        monitor-enter(this);
        f[] r0 = (f[]) this.mStateChangeListeners.toArray(new f[this.mStateChangeListeners.size()]);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        int r2 = r0.length;
    L12:
        if (r1 >= r2) goto L28;
        LynxBaseUI r4 = (LynxBaseUI) r6;
        r4.registerScrollStateListener(r0[r1]);
        r1 = r1 + 1;
    L28:
        this.mParent = r6;
        return;
    L14:
        th = move-exception;
        throw th;
    L18:
        if ((this.mParent instanceof LynxBaseUI) == false) goto L28;
        monitor-enter(this);
        f[] r3 = (f[]) this.mStateChangeListeners.toArray(new f[this.mStateChangeListeners.size()]);     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        int r5 = r3.length;
    L23:
        if (r1 >= r5) goto L28;
        f r7 = r3[r1];
        ((LynxBaseUI) this.mParent).unRegisterScrollStateListener(r7);
        r1 = r1 + 1;
    L25:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void setParentLynxPageUI(EventTarget r2) {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getUIBody() == null) goto L10;
        this.mContext.getUIBody().setParentLynxPageUI(r2);
        return;
    }

    @LynxProp(name = "perspective")
    public void setPerspective(ReadableArray r1) {
        this.mPerspective = r1;
    }

    @LynxProp(name = "pointer-events")
    public void setPointerEvents(int r2) {
        if (r2 >= EventTarget.PointerEventsValue.Auto.ordinal()) goto L5;
        return;
    L5:
        if (r2 >= EventTarget.PointerEventsValue.Unset.ordinal()) goto L9;
        this.mPointerEvents = EventTarget.PointerEventsValue.values()[r2];
        return;
    }

    public void setPreviousDrawUI(LynxBaseUI r1) {
        this.mPreviousDrawUI = r1;
    }

    @LynxProp(name = "react-ref")
    public void setRefIdSelector(String r1) {
        this.mRefId = r1;
    }

    @LynxProp(name = "scroll-monitor-tag")
    public void setScrollMonitorTag(String r1) {
        this.mScrollMonitorTag = r1;
    }

    public void setSkewX(float r1) {
        this.mSkewX = r1;
    }

    public void setSkewY(float r1) {
        this.mSkewY = r1;
    }

    @LynxProp(name = "skip-redirection")
    public void setSkipRedirection(boolean r1) {
        this.mSkipRedirection = r1;
    }

    @LynxProp(name = "lynx-test-tag")
    public void setTestID(String r1) {
        this.mTestTagName = r1;
    }

    public void setTop(int r1) {
        this.mTop = r1;
        this.mOriginTop = r1;
        onLayoutUpdated();
    }

    public void setTransform(ReadableArray r5) {
        this.hasTransformChanged = true;
        List<n> r6 = n.d(r5);
        this.mTransformRaw = r6;
        float r0 = 0.0f;
        if (r6 == null) goto L17;
        ArrayList r7 = (ArrayList) r6;
        if (r7.isEmpty() == true) goto L17;
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L17;
        n r1 = (n) r8.next();
        int r2 = r1.a;
        if (r2 != 8) goto L13;
        r0 = r1.c.a();
        goto L9
    L13:
        if (r2 != 16) goto L9;
        r0 = r1.h.a();
    L17:
        setTranslationZ(r0);
        if ((getParent() instanceof UIShadowProxy) == false) goto L29;
        ((UIShadowProxy) getParent()).a.getTransformRaws();
        return;
    }

    @LynxProp(name = "transform-origin")
    public void setTransformOrigin(ReadableArray r4) {
        this.hasTransformChanged = true;
        com.lynx.tasm.behavior.ui.utils.l r0 = com.lynx.tasm.behavior.ui.utils.l.e;
        this.mTransformOrigin = r0;
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
    L10:
        com.lynx.tasm.behavior.ui.utils.l r1 = null;
    L11:
        this.mTransformOrigin = r1;
        if (r1 != null) goto L15;
        LLog.e(TAG, "transform params error.");
        this.mTransformOrigin = r0;
        return;
    L15:
        return;
    L7:
        if (r4.size() < 2) goto L10;
        r1 = new com.lynx.tasm.behavior.ui.utils.l(r4);
        goto L11
    }

    public void setTranslationZ(float r1) {
        this.mTranslationZ = r1;
    }

    @LynxProp(defaultBoolean = true, name = "user-interaction-enabled")
    public void setUserInteractionEnabled(boolean r1) {
        this.userInteractionEnabled = r1;
    }

    public void setWidth(int r1) {
        this.mWidth = r1;
        onLayoutUpdated();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void startEventBubble(long r2) {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getEventEmitter() == null) goto L10;
        this.mContext.getEventEmitter().startEventBubble(r2);
        return;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void startEventCapture(long r2) {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getEventEmitter() == null) goto L10;
        this.mContext.getEventEmitter().startEventCapture(r2);
        return;
    }

    public void unRegisterScrollStateListener(f r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (this.mStateChangeListeners == null) goto L22;
        monitor-enter(this);
        this.mStateChangeListeners.remove(r2);     // Catch: Throwable -> L14
        boolean r3 = this.mStateChangeListeners.isEmpty();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        if (r3 == false) goto L20;
        k r4 = getParent();
        if ((r4 instanceof LynxBaseUI) == false) goto L21;
        ((LynxBaseUI) r4).unRegisterScrollStateListener(this.mScrollStateChangeListener);
        return;
    L21:
        return;
    L20:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public void updateLayoutInfo(LynxBaseUI r19) {
        updateLayoutInfo(r19.getLeft(), r19.getTop(), r19.getWidth(), r19.getHeight(), r19.getPaddingLeft(), r19.getPaddingTop(), r19.getPaddingRight(), r19.getPaddingBottom(), r19.getMarginLeft(), r19.getMarginTop(), r19.getMarginRight(), r19.getMarginBottom(), r19.getBorderLeftWidth(), r19.getBorderTopWidth(), r19.getBorderRightWidth(), r19.getBorderBottomWidth(), r19.getBound());
        this.mOriginLeft = r19.getOriginLeft();
        this.mOriginTop = r19.getOriginTop();
    }

    public void updateMaxHeight(float r1) {
        this.mMaxHeight = r1;
    }

    public void updateNewSticky(float[] r4) {
        if (r4 != null) goto L5;
    L12:
        removeSelfFromStickyScrollerIfNeeded();
        setStickyTranslate(null);
        this.mSticky = null;
        return;
    L5:
        if (r4.length < 10) goto L12;
        Sticky r1 = new Sticky();
        this.mSticky = r1;
        ((RectF) r1).left = r4[0];
        ((RectF) r1).top = r4[1];
        ((RectF) r1).right = r4[2];
        ((RectF) r1).bottom = r4[3];
        r1.c = r4[4];
        r1.d = r4[5];
        r1.e = r4[6];
        r1.f = r4[7];
        r1.g = r4[8];
        r1.h = r4[9];
        r1.b = 0.0f;
        r1.a = 0.0f;
        g7a.c r5 = getStickyScroller();
        if (r5 == null) goto L10;
        bindStickyScrollerIfNeeded(r5);
        r5.l();
        return;
    L10:
        removeSelfFromStickyScrollerIfNeeded();
        setStickyTranslate(null);
    }

    public final void updateProperties(x0 r1) {
        updatePropertiesInterval(r1);
        afterPropsUpdated(r1);
    }

    public void updatePropertiesInterval(x0 r9) {
        if (r9 != null) goto L4;
        return;
    L4:
        if (r9.j() == true) goto L365;
        this.mProps.merge(r9.a);
        Map<Class<?>, LynxUISetter<?>> r0 = PropsUpdater.a;
        LynxUISetter r1 = PropsUpdater.c(getClass());
        ReadableMapKeySetIterator r2 = r9.a.keySetIterator();
    L8:
        if (r2.hasNextKey() == false) goto L14;
        String r3 = r2.nextKey();
        r1.setProperty(this, r3, r9);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        LynxError r4 = new LynxError(130100, "Error while updating property '" + r3 + "' in ui '" + getTagName() + "': " + th, NameKeys.UnloadStrategy_No_Strategy, "error");
        r4.setCallStack(CallStackUtil.getStackTraceStringWithLineTrimmed(th));
        r4.setUserDefineInfo(getPlatformCustomInfo());
        getLynxContext().handleLynxError(r4);
        goto L8
    L14:
        MapBuffer r10 = r9.b;
        if (r10 == null) goto L366;
        com.lynx.tasm.behavior.g r5 = getOrCreateUIPaintStyles();
        if (r5 == null) goto L367;
        Iterator<MapBuffer.a> r11 = r10.iterator();
    L22:
        if (r11.hasNext() == false) goto L368;
        MapBuffer.a r6 = r11.next();
        int r7 = r6.getKey();
        if (r7 != 5) goto L26;
        setCSSPosition(r6.a());
        goto L22
    L26:
        if (r7 == 7) goto L160;
        if (r7 != 76) goto L30;
        com.lynx.react.bridge.mapbuffer.e r8 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setBoxShadow(r8);
        r5.Q = r8;
        goto L22
    L30:
        if (r7 != 77) goto L32;
        com.lynx.react.bridge.mapbuffer.e r12 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setTransformOrigin(r12);
        r5.O = r12;
        goto L22
    L32:
        if (r7 != 120) goto L34;
        int r13 = r6.a();
        setOverflowX(Integer.valueOf(r13));
        r5.H = Integer.valueOf(r13);
        goto L22
    L34:
        if (r7 != 121) goto L36;
        int r14 = r6.a();
        setOverflowY(Integer.valueOf(r14));
        r5.I = Integer.valueOf(r14);
        goto L22
    L36:
        if (r7 != 129) goto L38;
        setCaretColor(r6.getString());
        goto L22
    L38:
        if (r7 != 130) goto L40;
        int r15 = r6.a();
        setLynxDirection(r15);
        r5.N = r15;
        goto L22
    L40:
        if (r7 != 142) goto L42;
        if ((this instanceof LynxUI) == false) goto L22;
        ((LynxUI) this).setEnterTransitionName(new com.lynx.react.bridge.mapbuffer.e(r6.f()));
        goto L22
    L42:
        if (r7 != 143) goto L44;
        if ((this instanceof LynxUI) == false) goto L22;
        ((LynxUI) this).setExitTransitionName(new com.lynx.react.bridge.mapbuffer.e(r6.f()));
        goto L22
    L44:
        switch(r7) {
            case 7: goto L160;
            case 8: goto L66;
            case 9: goto L65;
            case 10: goto L64;
            case 11: goto L63;
            case 12: goto L62;
            case 13: goto L61;
            case 14: goto L60;
            case 15: goto L59;
            case 16: goto L58;
            case 17: goto L57;
            case 18: goto L56;
            case 19: goto L55;
            case 20: goto L54;
            case 21: goto L53;
            default: goto L45;
        };
    L53:
        int r16 = (int) r6.b();
        setBorderWidth(4, r16);
        r5.B = r16;
        goto L22
    L54:
        int r17 = (int) r6.b();
        setBorderWidth(3, r17);
        r5.A = r17;
        goto L22
    L55:
        int r18 = (int) r6.b();
        setBorderWidth(2, r18);
        r5.z = r18;
        goto L22
    L56:
        int r19 = (int) r6.b();
        setBorderWidth(1, r19);
        r5.y = r19;
        goto L22
    L57:
        int r20 = (int) r6.b();
        setBorderWidth(0, r20);
        r5.x = r20;
        goto L22
    L58:
        com.lynx.react.bridge.mapbuffer.e r21 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setBorderRadius(3, r21);
        r5.q = r21;
        goto L22
    L59:
        com.lynx.react.bridge.mapbuffer.e r22 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setBorderRadius(2, r22);
        r5.p = r22;
        goto L22
    L60:
        com.lynx.react.bridge.mapbuffer.e r23 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setBorderRadius(4, r23);
        r5.r = r23;
        goto L22
    L61:
        com.lynx.react.bridge.mapbuffer.e r24 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setBorderRadius(1, r24);
        r5.o = r24;
        goto L22
    L62:
        com.lynx.react.bridge.mapbuffer.e r25 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setBorderRadius(0, r25);
        r5.n = r25;
        goto L22
    L63:
        int r26 = r6.a();
        setBorderColor(4, Integer.valueOf(r26));
        r5.F = Integer.valueOf(r26);
        goto L22
    L64:
        int r27 = r6.a();
        setBorderColor(3, Integer.valueOf(r27));
        r5.E = Integer.valueOf(r27);
        goto L22
    L65:
        int r28 = r6.a();
        setBorderColor(2, Integer.valueOf(r28));
        r5.D = Integer.valueOf(r28);
        goto L22
    L66:
        int r29 = r6.a();
        setBorderColor(1, Integer.valueOf(r29));
        r5.C = Integer.valueOf(r29);
        goto L22
    L45:
        switch(r7) {
            case 23: goto L87;
            case 25: goto L85;
            case 47: goto L84;
            case 63: goto L82;
            case 74: goto L80;
            case 104: goto L78;
            case 123: goto L76;
            case 147: goto L74;
            case 170: goto L72;
            case 190: goto L71;
            case 193: goto L69;
            case 208: goto L67;
            default: goto L46;
        };
    L67:
        int r30 = r6.a();
        setImageRendering(r30);
        r5.S = r30;
        goto L22
    L69:
        if ((this instanceof LynxUI) == false) goto L22;
        com.lynx.react.bridge.mapbuffer.e r31 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        ((LynxUI) this).setClipPath(r31);
        r5.T = r31;
        goto L22
    L71:
        com.lynx.react.bridge.mapbuffer.e r32 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setPerspective(r32);
        r5.P = r32;
        goto L22
    L72:
        com.lynx.react.bridge.mapbuffer.e r33 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setMaskImage(r33);
        r5.h = r33;
        goto L22
    L74:
        if ((this instanceof UIComponent) == false) goto L22;
        ((UIComponent) this).setZIndex(r6.a());
        goto L22
    L76:
        com.lynx.react.bridge.mapbuffer.e r34 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setBackgroundClip(r34);
        r5.a = r34;
        goto L22
    L78:
        if ((this instanceof LynxUI) == false) goto L22;
        int r35 = r6.a();
        ((LynxUI) this).setVisibility(r35);
        r5.h0 = r35;
        goto L22
    L80:
        int r36 = r6.a();
        setBorderStyle(0, r36);
        r5.s = r36;
        goto L22
    L82:
        if ((this instanceof LynxUI) == false) goto L22;
        com.lynx.react.bridge.mapbuffer.e r37 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        ((LynxUI) this).setTransform(r37);
        r5.R = r37;
        goto L22
    L84:
        float r38 = r6.a();
        setFontSize(r38);
        r5.M = r38;
        goto L22
    L85:
        int r39 = r6.a();
        setOverflow(r39);
        r5.G = Integer.valueOf(r39);
        goto L22
    L87:
        if ((this instanceof LynxUI) == false) goto L22;
        float r40 = r6.a();
        ((LynxUI) this).setAlpha(r40);
        r5.g0 = r40;
        goto L22
    L46:
        switch(r7) {
            case 200: goto L93;
            case 201: goto L92;
            case 202: goto L91;
            case 203: goto L90;
            case 204: goto L89;
            default: goto L47;
        };
    L89:
        com.lynx.react.bridge.mapbuffer.e r41 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setMaskSize(r41);
        r5.k = r41;
        goto L22
    L90:
        com.lynx.react.bridge.mapbuffer.e r42 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setMaskOrigin(r42);
        r5.i = r42;
        goto L22
    L91:
        com.lynx.react.bridge.mapbuffer.e r43 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setMaskClip(r43);
        r5.m = r43;
        goto L22
    L92:
        com.lynx.react.bridge.mapbuffer.e r44 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setMaskPosition(r44);
        r5.l = r44;
        goto L22
    L93:
        com.lynx.react.bridge.mapbuffer.e r45 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setMaskRepeat(r45);
        r5.j = r45;
        goto L22
    L47:
        switch(r7) {
            case 83: goto L125;
            case 84: goto L122;
            case 85: goto L119;
            case 86: goto L116;
            case 87: goto L113;
            case 88: goto L110;
            case 89: goto L107;
            case 90: goto L104;
            case 91: goto L101;
            case 92: goto L98;
            case 93: goto L95;
            default: goto L48;
        };
    L95:
        if ((this instanceof LynxUI) == false) goto L22;
        double r46 = r6.b();
        ((LynxUI) this).setLayoutAnimationUpdateDelay(r46);
        r5.d0 = r46;
        goto L22
    L98:
        if ((this instanceof LynxUI) == false) goto L22;
        com.lynx.react.bridge.mapbuffer.e r47 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        ((LynxUI) this).setLayoutAnimationUpdateTimingFunc(r47);
        r5.f0 = r47;
        goto L22
    L101:
        if ((this instanceof LynxUI) == false) goto L22;
        double r48 = r6.b();
        ((LynxUI) this).setLayoutAnimationUpdateDuration(r48);
        r5.e0 = r48;
        goto L22
    L104:
        if ((this instanceof LynxUI) == false) goto L22;
        int r49 = r6.a();
        ((LynxUI) this).setLayoutAnimationDeleteProperty(r49);
        r5.b0 = r49;
        goto L22
    L107:
        if ((this instanceof LynxUI) == false) goto L22;
        double r50 = r6.b();
        ((LynxUI) this).setLayoutAnimationDeleteDelay(r50);
        r5.Z = r50;
        goto L22
    L110:
        if ((this instanceof LynxUI) == false) goto L22;
        com.lynx.react.bridge.mapbuffer.e r51 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        ((LynxUI) this).setLayoutAnimationDeleteTimingFunc(r51);
        r5.c0 = r51;
        goto L22
    L113:
        if ((this instanceof LynxUI) == false) goto L22;
        double r52 = r6.b();
        ((LynxUI) this).setLayoutAnimationDeleteDuration(r52);
        r5.a0 = r52;
        goto L22
    L116:
        if ((this instanceof LynxUI) == false) goto L22;
        int r53 = r6.a();
        ((LynxUI) this).setLayoutAnimationCreateProperty(r53);
        r5.X = r53;
        goto L22
    L119:
        if ((this instanceof LynxUI) == false) goto L22;
        double r54 = r6.b();
        ((LynxUI) this).setLayoutAnimationCreateDelay(r54);
        r5.V = r54;
        goto L22
    L122:
        if ((this instanceof LynxUI) == false) goto L22;
        com.lynx.react.bridge.mapbuffer.e r55 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        ((LynxUI) this).setLayoutAnimationCreateTimingFunc(r55);
        r5.Y = r55;
        goto L22
    L125:
        if ((this instanceof LynxUI) == false) goto L22;
        double r56 = r6.b();
        ((LynxUI) this).setLayoutAnimationCreateDuration(r56);
        r5.W = r56;
        goto L22
    L48:
        switch(r7) {
            case 98: goto L131;
            case 99: goto L130;
            case 100: goto L129;
            case 101: goto L128;
            case 102: goto L127;
            default: goto L49;
        };
    L127:
        com.lynx.react.bridge.mapbuffer.e r57 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setBackgroundSize(r57);
        r5.g = r57;
        goto L22
    L128:
        com.lynx.react.bridge.mapbuffer.e r58 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setBackgroundRepeat(r58);
        r5.f = r58;
        goto L22
    L129:
        com.lynx.react.bridge.mapbuffer.e r59 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setBackgroundOrigin(r59);
        r5.d = r59;
        goto L22
    L130:
        com.lynx.react.bridge.mapbuffer.e r60 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setBackgroundPosition(r60);
        r5.e = r60;
        goto L22
    L131:
        com.lynx.react.bridge.mapbuffer.e r61 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        setBackgroundImage(r61);
        r5.c = r61;
        goto L22
    L49:
        switch(r7) {
            case 115: goto L135;
            case 116: goto L134;
            case 117: goto L133;
            case 118: goto L132;
            default: goto L50;
        };
    L132:
        int r62 = r6.a();
        setBorderStyle(4, r62);
        r5.w = r62;
        goto L22
    L133:
        int r63 = r6.a();
        setBorderStyle(3, r63);
        r5.v = r63;
        goto L22
    L134:
        int r64 = r6.a();
        setBorderStyle(2, r64);
        r5.u = r64;
        goto L22
    L135:
        int r65 = r6.a();
        setBorderStyle(1, r65);
        r5.t = r65;
        goto L22
    L50:
        switch(r7) {
            case 125: goto L138;
            case 126: goto L137;
            case 127: goto L136;
            default: goto L51;
        };
    L136:
        float r66 = (float) r6.b();
        setOutlineWidth(r66);
        r5.K = r66;
        goto L22
    L137:
        int r67 = r6.a();
        setOutlineStyle(r67);
        r5.L = r67;
        goto L22
    L138:
        int r68 = r6.a();
        setOutlineColor(r6.a());
        r5.J = r68;
        goto L22
    L51:
        switch(r7) {
            case 186: goto L146;
            case 187: goto L143;
            case 188: goto L140;
            default: goto L22;
        };
    L140:
        if ((this instanceof AbsLynxList) == false) goto L22;
        ((AbsLynxList) this).setCrossAxisGap((float) r6.b());
        goto L22
    L143:
        if ((this instanceof AbsLynxList) == false) goto L22;
        ((AbsLynxList) this).setMainAxisGap((float) r6.b());
        goto L22
    L146:
        if ((this instanceof LynxUI) == false) goto L22;
        com.lynx.react.bridge.mapbuffer.e r69 = new com.lynx.react.bridge.mapbuffer.e(r6.f());
        ((LynxUI) this).setFilter(r69);
        r5.U = r69;
    L160:
        int r70 = r6.a();
        setBackgroundColor(r70);
        r5.b = r70;
        goto L22
    L368:
        return;
    L367:
        return;
    L366:
        return;
    }

    public void updateSticky(float[] r3) {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
    L7:
        if (r3 != null) goto L9;
    L15:
        this.mSticky = null;
        return;
    L9:
        if (r3.length < 4) goto L15;
        Sticky r1 = new Sticky();
        this.mSticky = r1;
        ((RectF) r1).left = r3[0];
        ((RectF) r1).top = r3[1];
        ((RectF) r1).right = r3[2];
        ((RectF) r1).bottom = r3[3];
        r1.b = 0.0f;
        r1.a = 0.0f;
        Cloneable r4 = getParentBaseUI();
        if ((r4 instanceof g7a.c) == false) goto L18;
        ((g7a.c) r4).t();
        return;
    L18:
        return;
    L5:
        if (r0.getEnableNewSticky() == false) goto L7;
        updateNewSticky(r3);
    }

    public LynxBaseUI(LynxContext r2) {
        this(r2, null);
    }

    public void setBorderColor(Integer r1) {
        setBorderColorForAllSpacingIndex(r1);
    }

    public void setOverflow(int r2) {
        setOverflowWithMask(3, r2);
    }

    public LynxBaseUI(LynxContext r8, Object r9) {
        this.mPreviousDrawUI = null;
        this.mNextDrawUI = null;
        this.mTranslationZ = 0.0f;
        this.mGestureArenaMemberId = 0;
        this.mIsTransformNode = false;
        this.mChildren = new ArrayList();
        this.mProps = new JavaOnlyMap();
        this.mIncludeNativeGesture = false;
        this.mDataset = new JavaOnlyMap();
        this.mNodeIndex = 0;
        this.mNodeReadyBlockArray = new ArrayList();
        this.mHasRadius = false;
        this.mSkipLayoutUpdated = false;
        this.mDisplayNone = false;
        this.mOverflow = 0;
        this.mClipToRadius = false;
        this.mFocusable = false;
        EventTarget.EnableStatus r3 = EventTarget.EnableStatus.Undefined;
        this.mIgnoreFocus = r3;
        this.mPerspective = null;
        this.mPrePerspectiveValue = 0.0f;
        this.hasTransformChanged = false;
        this.userInteractionEnabled = true;
        this.nativeInteractionEnabled = false;
        this.mSticky = null;
        this.mStickyScrollerSign = -1;
        this.mMaxHeight = -1.0f;
        this.mBackgroundColor = 0;
        this.mEnableExposureUIMargin = null;
        this.mEnableExposureUIClip = r3;
        this.mIsDetachedWithView = false;
        this.mNeedsBackgroundRecreation = false;
        this.mAlpha = 1.0f;
        this.mSkewX = 0.0f;
        this.mSkewY = 0.0f;
        this.mShouldAttachChildrenView = false;
        this.mExtraOffsetX = 0.0f;
        this.mExtraOffsetY = 0.0f;
        this.mAccessibilityLabel = NameKeys.UnloadStrategy_No_Strategy;
        this.mAccessibilityId = NameKeys.UnloadStrategy_No_Strategy;
        this.mAccessibilityElementStatus = -1;
        this.mAccessibilityEnableTap = false;
        this.mAccessibilityKeepFocused = false;
        this.mConsumeHoverEvent = false;
        this.mAccessibilityTraits = LynxAccessibilityHelper.LynxAccessibilityTraits.NONE;
        this.mDrawableCallback = new c(this);
        this.mBitmapConfig = null;
        this.mCSSPosition = 1;
        this.mTouchSlop = 8.0f;
        this.mOnResponseChain = false;
        this.mBlockNativeEvent = false;
        this.mBlockNativeEventAreas = null;
        this.mEventThrough = r3;
        this.mEventThroughActiveRegions = null;
        this.mPointerEvents = EventTarget.PointerEventsValue.Unset;
        this.mPanInterceptDirection = EventTarget.PanInterceptDirection.None;
        this.mPanInterceptScope = EventTarget.PanInterceptScope.None;
        this.mFlattenChildrenCount = 0;
        this.mNeedSortChildren = false;
        this.mLastTranslateZ = 0.0f;
        this.mEnableTouchPseudoPropagation = true;
        this.mTransformMatrix = new Matrix();
        this.mHitTestMatrix = new Matrix();
        this.mConsumeSlideEventAngles = null;
        this.mBlockListEvent = false;
        this.mOffsetDescendantRectToLynxView = new WeakReference(null);
        this.mUseLocalCache = null;
        this.mSkipRedirection = false;
        this.mDisableDefaultResize = false;
        this.mImageRendering = -1;
        this.mBoundingClientRectCallbacks = new ArrayList();
        this.mIsFirstAnimatedReady = true;
        this.mHasTranslateDiff = false;
        this.mLynxDirection = 3;
        this.mContext = r8;
        this.mParam = r9;
        this.nativeInteractionEnabled = r8.getEnableNativeInteraction();
        com.lynx.tasm.behavior.ui.utils.e r10 = new com.lynx.tasm.behavior.ui.utils.e(r8);
        this.mLynxBackground = r10;
        r10.c = this.mDrawableCallback;
        float r11 = com.lynx.tasm.utils.i.b(14.0f, r8.getScreenMetrics().density);
        this.mFontSize = r11;
        this.mLynxBackground.d = r11;
        this.mLatestSize = new Point();
        this.mLastSize = new Point();
        initialize();
    }

    private void boundingClientRectInner(ReadableMap r6, Callback r7) {
        RectF r8 = com.lynx.tasm.behavior.ui.utils.h.g(this, r6);
        float r0 = getLynxContext().getScreenMetrics().density;
        JavaOnlyMap r1 = new JavaOnlyMap();
        r1.putString("id", getIdSelector());
        r1.putMap("dataset", (WritableMap) getDataset());
        r1.putDouble("left", r8.left / r0);
        r1.putDouble("top", r8.top / r0);
        r1.putDouble("right", r8.right / r0);
        r1.putDouble("bottom", r8.bottom / r0);
        r1.putDouble("width", r8.width() / r0);
        r1.putDouble("height", r8.height() / r0);
        r7.invoke(new Object[]{0, r1});
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [android.view.View] */
    @LynxUIMethod
    public void boundingClientRect(ReadableMap r3, Callback r4) {
        LynxUIOwner r0 = this.mContext.getLynxUIOwner();
        if (r0 != null) goto L6;
        boundingClientRectInner(r3, r4);
        return;
    L6:
        UIBody r1 = r0.getRootUI();
        if (r1 != null) goto L10;
        boundingClientRectInner(r3, r4);
        return;
    L10:
        ?? r2 = r1.getView();
        if (r2 != 0) goto L15;
        boundingClientRectInner(r3, r4);
        return;
    L15:
        if (r2.isLayoutRequested() == true) goto L18;
        boundingClientRectInner(r3, r4);
        return;
    L18:
        this.mContext.getLynxUIOwner().registerBoundingClientRectUI(this);
        this.mBoundingClientRectCallbacks.add(new a(this, r3, r4));
    }

    public boolean checkStickyOnParentScroll(int r10, int r11) {
        if (this.mSticky != null) goto L5;
        return false;
    L5:
        float r12 = getLeft() - r10;
        float r13 = getTop() - r11;
        Sticky r0 = this.mSticky;
        float r2 = ((RectF) r0).left;
        if (r12 >= r2) goto L9;
        r0.a = r2 - r12;
    L16:
        Sticky r14 = this.mSticky;
        float r1 = ((RectF) r14).top;
        if (r13 >= r1) goto L20;
        r14.b = r1 - r13;
        return true;
    L20:
        if (getParentBaseUI() != null) goto L23;
        LLog.e(TAG, "checkStickyOnParentScroll failed, parent is null.");
        return false;
    L23:
        int r15 = getParentBaseUI().getHeight();
        float r3 = getHeight() + r13;
        Sticky r4 = this.mSticky;
        float r5 = ((RectF) r4).bottom;
        float r16 = r15;
        if ((r3 + r5) <= r16) goto L26;
        r4.b = Math.max((r16 - r3) - r5, ((RectF) r4).top - r13);
        return true;
    L26:
        r4.b = 0.0f;
        return true;
    L9:
        if (getParentBaseUI() != null) goto L12;
        LLog.e(TAG, "checkStickyOnParentScroll failed, parent is null.");
        return false;
    L12:
        int r6 = getParentBaseUI().getWidth();
        float r7 = getWidth() + r12;
        Sticky r8 = this.mSticky;
        float r9 = ((RectF) r8).right;
        float r17 = r6;
        if ((r7 + r9) <= r17) goto L15;
        r8.a = Math.max((r17 - r7) - r9, ((RectF) r8).left - r12);
        goto L16
    L15:
        r8.a = 0.0f;
        goto L16
    }

    public boolean childrenContainPoint(float r2, float r3) {
        return childrenContainPoint(r2, r3, false);
    }

    @Override // p7a.b
    public void consumeGesture(int r3, ReadableMap r4) {
        if (isEnableNewGesture() == false) goto L11;
        if (r4 == null) goto L13;
        boolean r5 = r4.getBoolean("inner", true);
        boolean r6 = r4.getBoolean("consume", true);
        if (r5 == false) goto L9;
        consumeGesture(r6);
        return;
    L9:
        interceptGesture(r6);
        return;
    L13:
        return;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean containsPoint(float r2, float r3) {
        return containsPoint(r2, r3, false);
    }

    public e convertToMeaningfulPaintingArea(int r4, int r5) {
        if (needGenerateMeaningfulPaintingArea() == true) goto L6;
        return null;
    L6:
        e r0 = new e(r4, r5, getWidth(), getHeight());
        getAlpha();
        getScaleX();
        getScaleY();
        r0.e = getMeaningfulContentStatus();
        r0.f = getFirstMeaningfulContentPresentedTimestampMicros();
        return r0;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean eventThrough(float r10, float r11) {
        EventTarget.EnableStatus r0 = this.mEventThrough;
        if (r0 != EventTarget.EnableStatus.Enable) goto L6;
        boolean r1 = true;
    L20:
        if (this.mEventThroughActiveRegions != null) goto L22;
        return r1;
    L22:
        int r2 = 0;
        boolean r4 = false;
    L24:
        if (r2 >= this.mEventThroughActiveRegions.size()) goto L42;
        ArrayList r5 = (ArrayList) ListProtector.get(this.mEventThroughActiveRegions, r2);
        if (r5 == null) goto L41;
        if (r5.size() != 4) goto L41;
        float r6 = ((SizeValue) ListProtector.get(r5, 0)).a(this.mWidth);
        float r7 = ((SizeValue) ListProtector.get(r5, 1)).a(this.mHeight);
        float r8 = ((SizeValue) ListProtector.get(r5, 2)).a(this.mWidth) + r6;
        float r9 = ((SizeValue) ListProtector.get(r5, 3)).a(this.mHeight) + r7;
        if (r10 >= r6) goto L32;
    L38:
        r4 = false;
    L39:
        if (r4 == false) goto L41;
        LLog.i(TAG, "hit the event through active regions!");
        goto L42
    L32:
        if (r10 >= r8) goto L38;
        if (r11 < r7) goto L38;
        if (r11 >= r9) goto L38;
        r4 = true;
    L41:
        r2 = r2 + 1;
    L42:
        if (r4 == true) goto L53;
        if (r1 == false) goto L54;
        return false;
    L54:
        return true;
    L53:
        return r1;
    L6:
        if (r0 != EventTarget.EnableStatus.Disable) goto L9;
    L18:
        r1 = false;
        goto L20
    L9:
        if (parent() == null) goto L18;
        EventTarget r3 = parent();
        if ((r3 instanceof UIBody) == true) goto L18;
        if ((r3 instanceof LynxBaseUI) == false) goto L16;
        LynxBaseUI r12 = (LynxBaseUI) r3;
        RectF r13 = com.lynx.tasm.behavior.ui.utils.h.d(this, r12, new RectF(0.0f, 0.0f, r12.getWidth(), r12.getHeight()));
        float r14 = r10 - r13.left;
        float r15 = r11 - r13.top;
    L17:
        r1 = r3.eventThrough(r14, r15);
        goto L20
    L16:
        r14 = r10;
        r15 = r11;
        goto L17
    }

    @LynxUIMethod
    public void fetchAccessibilityTargets(ReadableMap r6, Callback r7) {
        if (this.mContext.getLynxAccessibilityWrapper() == null) goto L12;
        com.lynx.tasm.behavior.ui.accessibility.d r8 = this.mContext.getLynxAccessibilityWrapper();
        if (r8.e() == false) goto L7;
    L10:
        JavaOnlyArray r9 = new JavaOnlyArray();
        com.lynx.tasm.behavior.ui.accessibility.d.g(this, false, r9);
        r7.invoke(new Object[]{0, r9});
        return;
    L7:
        if (r8.f() == true) goto L10;
        r7.invoke(new Object[]{1, "fetch accessibility targets fail!"});
        return;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float r2, float r3) {
        return hitTest(r2, r3, false);
    }

    @LynxUIMethod
    public void innerText(ReadableMap r6, Callback r7) {
        if (this.mContext.getLynxAccessibilityWrapper() == null) goto L12;
        com.lynx.tasm.behavior.ui.accessibility.d r8 = this.mContext.getLynxAccessibilityWrapper();
        if (r8.e() == false) goto L7;
    L10:
        JavaOnlyArray r9 = new JavaOnlyArray();
        com.lynx.tasm.behavior.ui.accessibility.d.g(this, true, r9);
        r7.invoke(new Object[]{0, r9});
        return;
    L7:
        if (r8.f() == true) goto L10;
        r7.invoke(new Object[]{1, "fetch accessibility inner text fail!"});
        return;
    }

    public void insertChild(LynxBaseUI r2, int r3) {
        ListProtector.add(this.mChildren, r3, r2);
        r2.setParent(this);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onEventBubble(boolean r2, long r3) {
        if (r2 == false) goto L8;
        if (getRootLynxPageUI() == null) goto L12;
        getRootLynxPageUI().startEventFire(false, r3);
        return;
    L12:
        return;
    L8:
        if (getParentLynxPageUI() == null) goto L10;
        getParentLynxPageUI().startEventBubble(r3);
        return;
    L10:
        startEventFire(false, r3);
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onEventCapture(boolean r2, long r3) {
        if (r2 == false) goto L7;
        if (getRootLynxPageUI() == null) goto L18;
        getRootLynxPageUI().startEventFire(false, r3);
        return;
    L18:
        return;
    L7:
        if (getChildrenLynxPageUI() == null) goto L9;
        LynxBaseUI r4 = (LynxBaseUI) getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this)));
    L10:
        if (r4 != null) goto L12;
        startEventBubble(r3);
        return;
    L12:
        if (r4.getLynxContext() != null) goto L14;
        return;
    L14:
        if (r4.getLynxContext().getEventEmitter() == null) goto L21;
        r4.getLynxContext().getEventEmitter().startEventCapture(r3);
        return;
    L21:
        return;
    L9:
        r4 = null;
        goto L10
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onEventFire(boolean r3, long r4) {
        if (getChildrenLynxPageUI() == null) goto L5;
        LynxBaseUI r0 = (LynxBaseUI) getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this)));
    L6:
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.getLynxContext() != null) goto L10;
        return;
    L10:
        if (r0.getLynxContext().getEventEmitter() == null) goto L15;
        r0.getLynxContext().getEventEmitter().startEventFire(r3, r4);
        return;
    L15:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public void onListCellAppear(String r3, LynxBaseUI r4) {
        if (this.mBlockListEvent == false) goto L5;
        return;
    L5:
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().onListCellAppear(r3, r4);
        goto L7
    }

    public void onListCellPrepareForReuse(String r3, LynxBaseUI r4) {
        if (this.mBlockListEvent == false) goto L5;
        return;
    L5:
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().onListCellPrepareForReuse(r3, r4);
        goto L7
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void onPseudoStatusChanged(int r1, int r2) {
        this.mPseudoStatus = r2;
    }

    @LynxUIMethod
    public void requestAccessibilityFocus(ReadableMap r8, Callback r9) {
        if (this.mContext.getLynxAccessibilityWrapper() == null) goto L36;
        com.lynx.tasm.behavior.ui.accessibility.d r10 = this.mContext.getLynxAccessibilityWrapper();
        if (r10.k() == true) goto L8;
        r9.invoke(new Object[]{1, "System accessibility is disable!"});
        return;
    L8:
        if (r10.f() == false) goto L21;
        LynxAccessibilityHelper r0 = r10.n;
        r0.getClass();
        if ((this instanceof LynxUI) == false) goto L18;
        LynxUI r5 = (LynxUI) this;
        if (r5.getView() == null) goto L18;
        if (r0.a(this) == false) goto L18;
        r5.getView().sendAccessibilityEvent(LynxTouchEvent.kPseudoStateFocusTransition);
        boolean r1 = true;
    L19:
        if (r1 == false) goto L21;
    L33:
        r9.invoke(new Object[]{0, "Accessibility element on focused"});
        return;
    L18:
        r1 = false;
    L21:
        if (r10.e() == false) goto L34;
        LynxAccessibilityDelegate r11 = r10.m;
        if (r11.a() == true) goto L25;
    L31:
        boolean r12 = false;
    L32:
        if (r12 == false) goto L34;
    L25:
        if (r11.e.k(this) == false) goto L31;
        int r2 = r11.e.e(this);
        if (r2 == (-1)) goto L31;
        r12 = r11.requestAccessibilityFocus(r2);
    L34:
        r9.invoke(new Object[]{1, "Request accessibility focus fail!"});
        return;
    }

    @LynxUIMethod
    public void requestUIInfo(ReadableMap r7, Callback r8) {
        ArrayList r0 = new ArrayList();
        if (r7 == null) goto L11;
        ReadableMapKeySetIterator r2 = r7.keySetIterator();
    L6:
        if (r2.hasNextKey() == false) goto L11;
        String r3 = r2.nextKey();
        if (r7.getBoolean(r3, false) == false) goto L6;
        r0.add(r3);
    L11:
        if (r7 != null) goto L13;
    L15:
        boolean r9 = false;
    L16:
        JavaOnlyMap r10 = getPositionInfo(r9);
        JavaOnlyMap r4 = new JavaOnlyMap();
        if (r0.contains("id") == false) goto L20;
        r4.put("id", getIdSelector());
    L20:
        if (r0.contains("dataset") == false) goto L23;
        r4.put("dataset", getDataset());
    L23:
        if (r0.contains(SVGRenderEngine.RECT) == false) goto L26;
        r4.put("left", r10.get("left"));
        r4.put("top", r10.get("top"));
        r4.put("right", r10.get("right"));
        r4.put("bottom", r10.get("bottom"));
    L26:
        if (r0.contains("size") == false) goto L29;
        r4.put("width", r10.get("width"));
        r4.put("height", r10.get("height"));
    L29:
        if (r0.contains("scrollOffset") == false) goto L32;
        float r11 = getLynxContext().getScreenMetrics().density;
        r4.put("scrollLeft", Float.valueOf(getScrollX() / r11));
        r4.put("scrollTop", Float.valueOf(getScrollY() / r11));
    L32:
        if (r0.contains("node") == false) goto L34;
        r4.put("node", new JavaOnlyMap());
    L34:
        r8.invoke(new Object[]{0, r4});
        return;
    L13:
        if (r7.getBoolean("androidEnableTransformProps", false) == false) goto L15;
        r9 = true;
        goto L16
    }

    @LynxUIMethod
    public void scrollIntoView(ReadableMap r7, Callback r8) {
        if (r7 != null) goto L7;
        if (r8 == null) goto L25;
        r8.invoke(new Object[]{4, "missing the param of `scrollIntoViewOptions`"});
        return;
    L25:
        return;
    L7:
        HashMap r9 = (HashMap) r7.asHashMap().get("scrollIntoViewOptions");
        if (r9 != null) goto L12;
        r8.invoke(new Object[]{4, "missing the param of `scrollIntoViewOptions`"});
        return;
    L12:
        if (r9.containsKey("behavior") == false) goto L14;
        String r0 = (String) r9.get("behavior");
    L16:
        if (r9.containsKey("block") == false) goto L18;
        String r1 = (String) r9.get("block");
    L20:
        if (r9.containsKey("inline") == false) goto L22;
        String r10 = (String) r9.get("inline");
    L23:
        scrollIntoView(r0.equals("smooth"), r1, r10, r8);
        return;
    L22:
        r10 = "nearest";
        goto L23
    L18:
        r1 = "start";
        goto L20
    L14:
        r0 = "auto";
        goto L16
    }

    @LynxPropGroup(customType = "Color", names = {"border-color", "border-left-color", "border-right-color", "border-top-color", "border-bottom-color"})
    public void setBorderColor(int r3, Integer r4) {
        ensureLynxBackground();
        this.mLynxBackground.p(SPACING_TYPES[r3], r4);
    }

    @LynxPropGroup(names = {"border-radius", "border-top-left-radius", "border-top-right-radius", "border-bottom-right-radius", "border-bottom-left-radius"})
    public void setBorderRadius(int r2, ReadableArray r3) {
        ensureLynxBackground();
        this.mHasRadius = false;
        if (this.mLynxBackground.q(r2, r3) == false) goto L5;
        this.mHasRadius = true;
    L5:
        onBorderRadiusUpdated(r2);
    }

    @LynxPropGroup(defaultInt = -1, names = {"border-style", "border-left-style", "border-right-style", "border-top-style", "border-bottom-style"})
    public void setBorderStyle(int r3, int r4) {
        ensureLynxBackground();
        this.mLynxBackground.s(SPACING_TYPES[r3], r4);
    }

    @LynxPropGroup(names = {"border-width", "border-left-width", "border-right-width", "border-top-width", "border-bottom-width"})
    public void setBorderWidth(int r4, int r5) {
        ensureLynxBackground();
        this.mBorderSpacingIndex = r4;
        this.mBorderWidth = r5;
        com.lynx.tasm.behavior.ui.utils.e r0 = this.mLynxBackground;
        int[] r1 = SPACING_TYPES;
        float r6 = r5;
        r0.b().c(r1[r4], r6);
        com.lynx.tasm.behavior.ui.utils.g r2 = this.mLynxMask;
        if (r2 == null) goto L6;
        r2.b().c(r1[r4], r6);
        return;
    }

    @Override // p7a.b
    public void setGestureDetectorState(int r4, int r5) {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        q7a.b r0 = getGestureArenaManager();
        if (r0 != null) goto L8;
        return;
    L8:
        int r1 = getGestureArenaMemberId();
        if (r0.d() == true) goto L11;
        return;
    L11:
        if (r0.h == null) goto L42;
        Map<Integer, WeakReference<p7a.a>> r2 = r0.a;
        if (r2 == null) goto L46;
        HashMap r3 = (HashMap) r2;
        WeakReference r6 = (WeakReference) r3.get(Integer.valueOf(r1));
        t7a.d r7 = r0.h;
        p7a.a r8 = (p7a.a) r6.get();
        r7.getClass();
        if (r8 == null) goto L47;
        Map<Integer, t7a.a> r9 = r8.getGestureHandlers();
        if (r9 == null) goto L27;
        Iterator<t7a.a> r10 = r9.values().iterator();
    L23:
        if (r10.hasNext() == false) goto L27;
        t7a.a r11 = r10.next();
        if (r11.e.a != r4) goto L23;
    L29:
        if (r5 != 2) goto L31;
        if (r11 == null) goto L45;
        r11.e();
        return;
    L45:
        return;
    L31:
        if (r5 != 3) goto L48;
        if (r11 == null) goto L43;
        r11.d();
        return;
    L43:
        return;
    L48:
        return;
    L27:
        r11 = null;
        goto L29
    L47:
        return;
    L46:
        return;
    }

    public void setOverflowWithMask(short r2, int r3) {
        int r0 = this.mOverflow;
        if (r3 != 0) goto L5;
        int r4 = r2 | r0;
    L6:
        this.mOverflow = r4;
        requestLayout();
        return;
    L5:
        r4 = (~r2) & r0;
        goto L6
    }

    public void setPosition(int r1, int r2) {
        this.mLeft = r1;
        this.mTop = r2;
        this.mOriginTop = r2;
        this.mOriginLeft = r1;
    }

    public void setSign(int r1, String r2) {
        this.mSign = r1;
        this.mTagName = r2;
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public void startEventFire(boolean r2, long r3) {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getEventEmitter() == null) goto L10;
        this.mContext.getEventEmitter().startEventFire(r2, r3);
        return;
    }

    public void transformFromViewToRootView(View r6, float[] r7) {
        if (r6.getMatrix().isIdentity() == true) goto L5;
        r6.getMatrix().mapPoints(r7);
    L5:
        View r0 = r6.getRootView();
    L6:
        if (r6 == r0) goto L19;
        View r1 = (View) r6.getParent();
        if (r1 == null) goto L9;
        r7[0] = r7[0] + r6.getLeft();
        r7[1] = r7[1] + r6.getTop();
        r7[0] = r7[0] - r1.getScrollX();
        r7[1] = r7[1] - r1.getScrollY();
        if (r1.getMatrix().isIdentity() == true) goto L13;
        r1.getMatrix().mapPoints(r7);
    L13:
        r6 = r1;
        goto L6
    L9:
        LLog.e(TAG, "transformFromViewToRootView failed, parent is null.");
        return;
    }

    public final void updateLayoutSize(int r2, int r3) {
        Point r0 = this.mLatestSize;
        r0.x = r2;
        r0.y = r3;
    }

    public void setBorderRadius(int r1, String r2) {
        LLog.DTHROW(new RuntimeException("setBorderWidth(int, String) is deprecated.This has no effect."));
    }

    public void setBorderWidth(int r1, String r2) {
        LLog.DTHROW(new RuntimeException("setBorderWidth(int, String) is deprecated.This has no effect."));
    }

    public static /* synthetic */ void access$100(LynxBaseUI r0, ReadableMap r1, Callback r2) {
        r0.boundingClientRectInner(r1, r2);
    }

    private float[] calculateSiblingCoordinates(LynxBaseUI r9, float r10, float r11) {
        if (this.mContext.getEnableEventRefactor() == false) goto L7;
        return getTargetPoint(r10, r11, getScrollX(), getScrollY(), r9.getRectWithoutTransform(), r9.getTransformMatrix());
    L7:
        if (r9.isCustomHittest() == false) goto L9;
    L13:
        float r12 = r10 + ((r9.getScrollX() - r9.getOriginLeft()) - r9.getTranslationX());
        float r13 = r11 + ((r9.getScrollY() - r9.getOriginTop()) - r9.getTranslationY());
    L15:
        return new float[]{r12, r13};
    L9:
        if (r9.needCustomLayout() == false) goto L13;
        if ((r9 instanceof UIGroup) == false) goto L13;
        r12 = r10 - r9.getOriginLeft();
        r13 = r11 - r9.getOriginTop();
        goto L15
    }

    public boolean childrenContainPoint(float r12, float r13, boolean r14) {
        if (this.mContext.getEnableEventRefactor() == false) goto L20;
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L6:
        if (r0.hasNext() == false) goto L19;
        LynxBaseUI r3 = r0.next();
        if ((r3 instanceof UIShadowProxy) == false) goto L10;
        r3 = ((UIShadowProxy) r3).a;
    L10:
        float[] r4 = getTargetPoint(r12, r13, getScrollX(), getScrollY(), r3.getRectWithoutTransform(), r3.getTransformMatrix());
        if (r14 == true) goto L15;
        if (r3.isUserInteractionEnabled() == false) goto L6;
    L15:
        if (r3.getVisibility() == false) goto L6;
        if (r3.containsPoint(r4[0], r4[1], r14) == false) goto L6;
        return true;
    L19:
        return false;
    L20:
        float r15 = ((r12 + getScrollX()) - getOriginLeft()) - getTranslationX();
        float r16 = ((r13 + getScrollY()) - getOriginTop()) - getTranslationY();
        Iterator<LynxBaseUI> r1 = this.mChildren.iterator();
    L22:
        if (r1.hasNext() == false) goto L32;
        LynxBaseUI r5 = r1.next();
        if (r14 == true) goto L28;
        if (r5.isUserInteractionEnabled() == false) goto L22;
    L28:
        if (r5.getVisibility() == false) goto L22;
        if (r5.containsPoint(r15, r16, r14) == false) goto L22;
        return true;
    L32:
        return false;
    }

    public String constructListStateCacheKey(String r2, String r3, String r4) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2);
        r0.append("_");
        r0.append(r3);
        r0.append("_");
        if (r4 != null) goto L6;
        r4 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        r0.append(r4);
        return r0.toString();
    }

    @Override // com.lynx.tasm.behavior.event.EventTarget
    public boolean containsPoint(float r9, float r10, boolean r11) {
        float r0 = getTouchSlop();
        boolean r3 = false;
        if (this.mContext.getEnableEventRefactor() == false) goto L32;
        float r1 = -r0;
        float r5 = r1 - this.mHitSlopLeft;
        float r6 = (this.mWidth + r0) + this.mHitSlopRight;
        float r2 = r1 - this.mHitSlopTop;
        float r7 = (this.mHeight + r0) + this.mHitSlopBottom;
        if (r5 <= r9) goto L7;
    L13:
        if (r3 == false) goto L15;
        return r3;
    L15:
        if (getOverflow() != 0) goto L17;
        return r3;
    L17:
        if (getOverflow() != 1) goto L24;
        if (r10 >= r2) goto L21;
    L22:
        return r3;
    L21:
        if (r10 > r7) goto L22;
    L31:
        return childrenContainPoint(r9, r10, r11);
    L24:
        if (getOverflow() != 2) goto L31;
        if (r9 >= r5) goto L28;
    L29:
        return r3;
    L28:
        if (r9 <= r6) goto L31;
    L7:
        if (r6 < r9) goto L13;
        if (r2 > r10) goto L13;
        if (r7 < r10) goto L13;
        r3 = true;
        goto L13
    L32:
        Rect r4 = getRect();
        if ((r4.left - r0) < r9) goto L35;
    L41:
        if (r3 == false) goto L43;
        return r3;
    L43:
        if (getOverflow() != 0) goto L45;
        return r3;
    L45:
        if (getOverflow() != 1) goto L52;
        if ((r4.top - r0) < r10) goto L49;
    L50:
        return r3;
    L49:
        if ((r4.bottom + r0) <= r10) goto L50;
    L59:
        return childrenContainPoint(r9, r10, r11);
    L52:
        if (getOverflow() != 2) goto L59;
        if ((r4.left - r0) < r9) goto L56;
    L57:
        return r3;
    L56:
        if ((r4.right + r0) > r9) goto L59;
    L35:
        if ((r4.right + r0) <= r9) goto L41;
        if ((r4.top - r0) >= r10) goto L41;
        if ((r4.bottom + r0) <= r10) goto L41;
        r3 = true;
        goto L41
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.lynx.tasm.behavior.event.EventTarget] */
    /* JADX WARN: Type inference failed for: r0v8, types: [com.lynx.tasm.behavior.event.EventTarget] */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.lynx.tasm.behavior.event.EventTarget, com.lynx.tasm.behavior.ui.LynxBaseUI] */
    @Override // com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float r18, float r19, boolean r20) {
        ArrayList r9 = new ArrayList();
        float r13 = r18;
        float r14 = r19;
        int r11 = this.mChildren.size() - 1;
        LynxBaseUI r12 = null;
    L3:
        if (r11 < 0) goto L41;
        LynxBaseUI r0 = (LynxBaseUI) ListProtector.get(this.mChildren, r11);
        if ((r0 instanceof UIShadowProxy) == false) goto L7;
        r0 = ((UIShadowProxy) r0).a;
    L7:
        LynxBaseUI r15 = r0;
        if ((r15 instanceof UIComponent) == false) goto L14;
        UIComponent r1 = (UIComponent) r15;
        if (r1.getView() == null) goto L14;
        if (((com.lynx.tasm.behavior.ui.view.a) r1.getView()).getParent() != null) goto L14;
        boolean r2 = true;
    L15:
        if (r20 == true) goto L19;
        if (r15.isUserInteractionEnabled() == true) goto L19;
    L40:
        r11 = r11 - 1;
    L19:
        if (r15.getVisibility() == false) goto L40;
        if (r15.getDrawParent() != null) goto L23;
    L26:
        if (r2 == true) goto L40;
        float[] r3 = {r18, r19};
        if (this.mContext.getEnableEventRefactor() == false) goto L31;
        r3 = getTargetPoint(r3[0], r3[1], getScrollX(), getScrollY(), r15.getRectWithoutTransform(), r15.getTransformMatrix());
        boolean r4 = r15.containsPoint(r3[0], r3[1], r20);
    L32:
        if (r4 == false) goto L40;
        r9.add(r15);
        if (r15.isOnResponseChain() == true) goto L35;
        if (r12 != null) goto L38;
    L39:
        r13 = r3[0];
        r14 = r3[1];
        r12 = r15;
        goto L40
    L38:
        if (r12.getRealTimeTranslationZ() >= r15.getRealTimeTranslationZ()) goto L40;
    L35:
        float r5 = r3[0];
        float r6 = r3[1];
        float r7 = r5;
        r12 = r15;
    L42:
        if (r12 != null) goto L44;
        ?? r8 = this;
    L45:
        if (r8 == 0) goto L48;
        EventTarget.PointerEventsValue r10 = r8.pointerEvents();
        ?? r16 = r8;
        if (r10 == EventTarget.PointerEventsValue.None) goto L48;
    L49:
        if (r16 == 0) goto L52;
        return r16;
    L52:
        return this;
    L48:
        r16 = findHitTargetInSiblings(r9, r12, r18, r19, r20);
        goto L49
    L44:
        r8 = performHitTestOnTarget(r12, r18, r19, r7, r6, r20);
        goto L45
    L31:
        r4 = r15.containsPoint(r3[0], r3[1], r20);
        goto L32
    L23:
        if (((LynxUI) r15.getDrawParent()).getView() == null) goto L26;
        if (((LynxUI) r15.getDrawParent()).getView().getParent() == null) goto L40;
    L14:
        r2 = false;
        goto L15
    L41:
        r7 = r13;
        r6 = r14;
        goto L42
    }

    public void onListCellDisAppear(String r3, LynxBaseUI r4, boolean r5) {
        if (this.mBlockListEvent == false) goto L5;
        return;
    L5:
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        r0.next().onListCellDisAppear(r3, r4, r5);
        goto L7
    }

    public void scrollIntoView(boolean r2, String r3, String r4) {
        scrollIntoView(r2, r3, r4, null);
    }

    public boolean updateDrawingLayoutInfo(int r3, int r4, Rect r5) {
        boolean r1 = true;
        if (this.mLeft == r3) goto L5;
        this.mLeft = r3;
        boolean r6 = true;
    L7:
        if (this.mTop == r4) goto L9;
        this.mTop = r4;
    L10:
        this.mBound = r5;
        if (r1 == false) goto L13;
        onDrawingPositionChanged();
    L13:
        return r1;
    L9:
        r1 = r6;
        goto L10
    L5:
        r6 = false;
        goto L7
    }

    private EventTarget performHitTestOnSibling(LynxBaseUI r2, float r3, float r4, boolean r5) {
        float[] r6 = calculateSiblingCoordinates(r2, r3, r4);
        float r7 = r6[0];
        float r8 = r6[1];
        if (r2.isCustomHittest() == true) goto L11;
        if (r2.needCustomLayout() == false) goto L11;
        if ((r2 instanceof UIGroup) == false) goto L11;
        UIGroup r9 = (UIGroup) r2;
        return r9.findUIWithCustomLayout(r7, r8, r9);
    L11:
        return r2.hitTest(r7, r8, r5);
    }

    public boolean calculateStickyTranslateWithOffset(int r18, boolean r19, int r20, int r21) {
        Sticky r2 = this.mSticky;
        boolean r3 = false;
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r19 == false) goto L7;
        float r4 = ((RectF) r2).top;
        float r5 = ((RectF) r2).bottom;
        float r6 = r2.d;
        float r7 = r2.f;
        float r8 = getHeight();
        float r9 = this.mSticky.h;
    L9:
        if (r6 >= 0.0f) goto L11;
        boolean r11 = true;
    L12:
        float r12 = r7 - r4;
        float r13 = r20;
        float r10 = ((r7 + r8) + r5) - r13;
        float r14 = r21;
        if (r12 >= r14) goto L15;
        boolean r15 = true;
    L17:
        if (r10 <= 0.0f) goto L19;
        boolean r16 = true;
    L20:
        if (r15 == true) goto L24;
        if (r16 == true) goto L24;
        Sticky r1 = this.mSticky;
        r1.a = 0.0f;
        r1.b = 0.0f;
        return true;
    L24:
        if (r15 == false) goto L30;
        if (r11 == true) goto L30;
        r14 = Math.min(((r6 + r9) - r4) - r8, r14);
        if (r14 <= r12) goto L29;
        r15 = true;
        goto L30
    L29:
        r15 = false;
    L30:
        if (r16 == false) goto L36;
        if (r11 == true) goto L36;
        float r17 = Math.max(((r9 + r8) + r5) - r13, 0.0f);
        if (r17 >= r10) goto L35;
        r3 = true;
    L35:
        r16 = r3;
    L37:
        if (r15 == false) goto L40;
        if (r16 == false) goto L40;
        r10 = Math.min(r10, r12);
    L40:
        if (r16 == false) goto L44;
        float r22 = r18;
        if (r22 >= r10) goto L44;
        float r23 = Math.max(r22, r17) - r10;
    L49:
        if (r19 == false) goto L51;
        Sticky r24 = this.mSticky;
        r24.a = 0.0f;
        r24.b = r23;
    L52:
        return true;
    L51:
        Sticky r25 = this.mSticky;
        r25.a = r23;
        r25.b = 0.0f;
    L44:
        if (r15 == false) goto L48;
        float r26 = r18;
        if (r26 <= r12) goto L48;
        r23 = Math.min(r26, r14) - r12;
    L48:
        r23 = 0.0f;
    L36:
        r17 = 0.0f;
        goto L37
    L19:
        r16 = false;
        goto L20
    L15:
        r15 = false;
        goto L17
    L11:
        r11 = false;
        goto L12
    L7:
        r4 = ((RectF) r2).left;
        r5 = ((RectF) r2).right;
        r6 = r2.c;
        r7 = r2.e;
        r8 = getWidth();
        r9 = this.mSticky.g;
        goto L9
    }

    public TransOffset getTransformValue(float r7, float r8, float r9, float r10) {
        TransOffset r0 = new TransOffset(this);
        r0.left_top = getLocationOnScreen(new float[]{r7, r9});
        r0.right_top = getLocationOnScreen(new float[]{this.mWidth + r8, r9});
        r0.right_bottom = getLocationOnScreen(new float[]{this.mWidth + r8, this.mHeight + r10});
        r0.left_bottom = getLocationOnScreen(new float[]{r7, this.mHeight + r10});
        return r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void scrollIntoView(boolean r4, String r5, String r6, Callback r7) {
        Boolean r0 = Boolean.FALSE;
        LynxBaseUI r1 = (LynxBaseUI) getParent();
    L3:
        if (r1 == null) goto L16;
        if ((r1 instanceof AbsLynxUIScroll) == true) goto L6;
        if ((r1 instanceof LynxUIScrollViewInternal) == true) goto L9;
        r1 = (LynxBaseUI) r1.getParent();
        goto L3
    L9:
        LynxUIScrollViewInternal r2 = (LynxUIScrollViewInternal) r1;
        if (((LynxBaseScrollView) r2.getView()).c == true) goto L13;
        r5 = r6;
    L13:
        r2.N(this, r4, r5);
        r0 = Boolean.TRUE;
        goto L16
    L6:
        ((AbsLynxUIScroll) r1).M(this, r4, r5, r6);
        r0 = Boolean.TRUE;
    L16:
        if (r0.booleanValue() == true) goto L20;
        LLog.e(TAG, "scrollIntoView failed for nodeId:" + getSign());
        if (r7 == null) goto L26;
        r7.invoke(new Object[]{8, "scrollIntoView failed for nodeId:" + getSign()});
        return;
    L26:
        return;
    L20:
        if (r7 == null) goto L28;
        r7.invoke(new Object[]{0});
        return;
    }

    private EventTarget findHitTargetInSiblings(List<EventTarget> r5, EventTarget r6, float r7, float r8, boolean r9) {
        int r0 = 0;
    L4:
        if (r0 >= r5.size()) goto L16;
        LynxBaseUI r1 = (LynxBaseUI) ListProtector.get(r5, r0);
        if (r1 == null) goto L15;
        if (r1 == r6) goto L15;
        EventTarget r2 = performHitTestOnSibling(r1, r7, r8, r9);
        if (r2 == null) goto L15;
        if (r2.pointerEvents() == EventTarget.PointerEventsValue.None) goto L15;
        return r2;
    L15:
        r0 = r0 + 1;
        goto L4
    L16:
        return null;
    }

    private EventTarget performCustomLayoutHitTest(UIGroup r2, float r3, float r4, float r5, float r6) {
        if (this.mContext.getEnableEventRefactor() == false) goto L7;
        return r2.findUIWithCustomLayout(r5, r6, r2);
    L7:
        return r2.findUIWithCustomLayout(r3 - r2.getOriginLeft(), r4 - r2.getOriginTop(), r2);
    }

    public void convertToMeaningfulPaintingAreaRecursive(int r8, int r9, int r10, int r11, ArrayList<e> r12) {
        int r13 = r8 + getOriginLeft();
        int r14 = r9 + getOriginTop();
        if (r13 >= r10) goto L21;
        if (r14 >= r11) goto L28;
        e r0 = convertToMeaningfulPaintingArea(r13, r14);
        if (r0 == null) goto L9;
        r12.add(r0);
    L9:
        List<LynxBaseUI> r1 = this.mChildren;
        if (r1 != null) goto L12;
        return;
    L12:
        if (r1.size() <= 0) goto L29;
        Iterator<LynxBaseUI> r2 = this.mChildren.iterator();
    L16:
        if (r2.hasNext() == false) goto L30;
        LynxBaseUI r3 = r2.next();
        if (r3 == null) goto L16;
        r3.convertToMeaningfulPaintingAreaRecursive(r13, r14, r10, r11, r12);
        goto L16
    L30:
        return;
    L29:
        return;
    L28:
        return;
    }

    private EventTarget performHitTestOnTarget(LynxBaseUI r8, float r9, float r10, float r11, float r12, boolean r13) {
        if (r8.isCustomHittest() == true) goto L11;
        if (r8.needCustomLayout() == false) goto L11;
        if ((r8 instanceof UIGroup) == false) goto L11;
        return performCustomLayoutHitTest((UIGroup) r8, r9, r10, r11, r12);
    L11:
        return performStandardHitTest(r8, r9, r10, r11, r12, r13);
    }

    private EventTarget performStandardHitTest(LynxBaseUI r2, float r3, float r4, float r5, float r6, boolean r7) {
        if (this.mContext.getEnableEventRefactor() == false) goto L7;
        return r2.hitTest(r5, r6, r7);
    L7:
        return r2.hitTest(((r3 + r2.getScrollX()) - r2.getOriginLeft()) - r2.getTranslationX(), ((r4 + r2.getScrollY()) - r2.getOriginTop()) - r2.getTranslationY(), r7);
    }

    public float[] getTargetPoint(float r3, float r4, int r5, int r6, Rect r7, Matrix r8) {
        float[] r1 = {(r3 + r5) - r7.left, (r4 + r6) - r7.top};
        Matrix r9 = getHitTestMatrix();
        if (r8.invert(r9) == false) goto L5;
        float[] r10 = {r1[0], r1[1]};
        r9.mapPoints(r10);
        r1[0] = r10[0];
        r1[1] = r10[1];
    L6:
        return r1;
    L5:
        r1[0] = Float.MAX_VALUE;
        r1[1] = Float.MAX_VALUE;
        goto L6
    }

    public float[] getTargetPoint(float r8, float r9, int r10, int r11, View r12, Matrix r13) {
        return getTargetPoint(r8, r9, r10, r11, new Rect(r12.getLeft(), r12.getTop(), 0, 0), r13);
    }

    public void updateLayout(int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, Rect r31) {
        updateLayoutInfo(r19, r20, r21, r22, r23, r24, r25, r26, 0, 0, 0, 0, r27, r28, r29, r30, r31);
        onLayoutUpdated();
    }

    public void updateLayout(int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, Rect r19) {
        this.mSkipLayoutUpdated = true;
        updateLayoutInfo(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
        this.mSkipLayoutUpdated = false;
        onLayoutUpdated();
        sendLayoutChangeEvent();
    }

    public void updateLayoutInfo(int r6, int r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r20, int r21, Rect r22) {
        LynxContext r1 = this.mContext;
        if (r1 == null) goto L18;
        if (r1.isTouchMoving() == false) goto L18;
        if (Float.compare(this.mWidth, 0.0f) == 0) goto L18;
        if (Float.compare(this.mHeight, 0.0f) == 0) goto L18;
        if (Float.compare(this.mLeft, r6) != 0) goto L16;
        if (Float.compare(this.mTop, r7) == 0) goto L18;
    L16:
        this.mContext.onPropsChanged(this);
    L18:
        setPosition(r6, r7);
        this.mWidth = r8;
        this.mHeight = r9;
        this.mPaddingLeft = r10;
        this.mPaddingRight = r12;
        this.mPaddingBottom = r13;
        this.mPaddingTop = r11;
        this.mMarginLeft = r14;
        this.mMarginTop = r15;
        this.mMarginRight = r16;
        this.mMarginBottom = r17;
        this.mBorderTopWidth = r19;
        this.mBorderBottomWidth = r21;
        this.mBorderLeftWidth = r18;
        this.mBorderRightWidth = r20;
        this.mBound = r22;
    }
}
