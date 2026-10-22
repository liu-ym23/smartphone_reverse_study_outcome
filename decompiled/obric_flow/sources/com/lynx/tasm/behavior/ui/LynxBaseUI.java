package com.lynx.tasm.behavior.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableMapKeySetIterator;
import com.lynx.react.bridge.ReadableType;
import com.lynx.react.bridge.WritableMap;
import com.lynx.react.bridge.mapbuffer.ReadableMapBuffer;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.a1;
import com.lynx.tasm.behavior.event.EventTarget$EnableStatus;
import com.lynx.tasm.behavior.event.EventTarget$PointerEventsValue;
import com.lynx.tasm.behavior.n0;
import com.lynx.tasm.behavior.u0;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityHelper$LynxAccessibilityTraits;
import com.lynx.tasm.behavior.ui.accessibility.LynxNodeProvider;
import com.lynx.tasm.behavior.ui.list.AbsLynxList;
import com.lynx.tasm.behavior.ui.scroll.AbsLynxUIScroll;
import com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal;
import com.lynx.tasm.behavior.ui.scroll.UIScrollView;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.BorderStyle;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import com.lynx.tasm.behavior.utils.LynxUISetter;
import com.lynx.tasm.behavior.y0;
import com.lynx.tasm.core.LynxEngineProxy;
import com.lynx.tasm.utils.CallStackUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@com.lynx.tasm.behavior.e0
public abstract class LynxBaseUI implements a0, wm.a, Cloneable, rn.b {
    private static final Set<String> BACKGROUND_PROPS = null;
    protected static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = 0.0f;
    protected static final int DEFAULT_PERSPECTIVE_FACTOR = 100;
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
    private LynxAccessibilityHelper$LynxAccessibilityTraits mAccessibilityTraits;
    private float mAlpha;
    protected int mBackgroundColor;
    protected Bitmap.Config mBitmapConfig;
    private boolean mBlockListEvent;
    private boolean mBlockNativeEvent;
    private ArrayList<ArrayList<com.lynx.tasm.utils.i>> mBlockNativeEventAreas;
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
    protected a0 mDrawParent;
    protected h mDrawableCallback;
    private boolean mEnableBitmapGradient;
    private EventTarget$EnableStatus mEnableExposureUIClip;
    private Boolean mEnableExposureUIMargin;
    private boolean mEnableScrollMonitor;
    protected boolean mEnableTouchPseudoPropagation;
    protected EventTarget$EnableStatus mEventThrough;
    protected ArrayList<ArrayList<com.lynx.tasm.utils.i>> mEventThroughActiveRegions;
    protected Map<String, on.a> mEvents;
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
    protected Map<Integer, un.a> mGestureDetectors;
    protected Map<Integer, vn.a> mGestureHandlers;
    private boolean mHasRadius;
    protected boolean mHasTranslateDiff;
    private int mHeight;
    private float mHitSlopBottom;
    private float mHitSlopLeft;
    private float mHitSlopRight;
    private float mHitSlopTop;
    private Matrix mHitTestMatrix;
    private String mIdSelector;
    protected EventTarget$EnableStatus mIgnoreFocus;
    protected int mImageRendering;
    protected boolean mIncludeNativeGesture;
    private boolean mIsDetachedWithView;
    protected boolean mIsFirstAnimatedReady;
    protected boolean mIsTransformNode;

    @NonNull
    private final Point mLastSize;
    private float mLastTranslateZ;

    @NonNull
    private final Point mLatestSize;
    private int mLeft;
    protected com.lynx.tasm.behavior.ui.utils.g mLynxBackground;
    protected int mLynxDirection;

    @Nullable
    protected com.lynx.tasm.behavior.ui.utils.i mLynxMask;
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
    private WeakReference<int[]> mOffsetDescendantRectToLynxView;
    private boolean mOnResponseChain;
    private int mOriginLeft;
    private int mOriginTop;
    protected int mOverflow;
    protected int mPaddingBottom;
    protected int mPaddingLeft;
    protected int mPaddingRight;
    protected int mPaddingTop;
    protected Object mParam;
    protected a0 mParent;

    @Nullable
    protected ReadableArray mPerspective;
    protected EventTarget$PointerEventsValue mPointerEvents;
    protected float mPrePerspectiveValue;
    protected LynxBaseUI mPreviousDrawUI;
    protected final JavaOnlyMap mProps;
    private int mPseudoStatus;
    private String mRefId;
    private String mScrollMonitorTag;
    private volatile q mScrollStateChangeListener;
    private boolean mShouldAttachChildrenView;
    private int mSign;
    private float mSkewX;
    private float mSkewY;
    private boolean mSkipLayoutUpdated;
    private boolean mSkipRedirection;
    private volatile Set<q> mStateChangeListeners;
    protected Sticky mSticky;
    private String mTagName;
    private String mTestTagName;
    private int mTop;
    private float mTouchSlop;
    private Matrix mTransformMatrix;

    @Nullable
    protected com.lynx.tasm.behavior.ui.utils.m mTransformOrigin;
    protected List<com.lynx.tasm.behavior.ui.utils.o> mTransformRaw;
    protected float mTranslationZ;
    private com.lynx.tasm.behavior.e mUIPaintStyles;
    private pm.a mUseLocalCache;
    private int mWidth;
    protected boolean nativeInteractionEnabled;
    protected boolean userInteractionEnabled;

    public class Sticky extends RectF {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f10380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f10381b;
    }

    static {
        SPACING_TYPES = new int[]{8, 0, 2, 1, 3, 4, 5};
        sDefaultOffsetToLynxView = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = (float) Math.sqrt(5.0d);
        BACKGROUND_PROPS = new HashSet(Arrays.asList(new String[]{"background-color", "background-image", "background-origin", "background-position", "background-repeat", "background-size", "border-bottom-left-radius", "border-bottom-right-radius", "border-top-left-radius", "border-top-right-radius", "border-radius"}));
    }

    public LynxBaseUI(LynxContext r10, Object r11) {
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
        this.mHasRadius = false;
        this.mSkipLayoutUpdated = false;
        this.mOverflow = 0;
        this.mClipToRadius = false;
        this.mFocusable = false;
        EventTarget$EnableStatus r5 = EventTarget$EnableStatus.f10246c;
        this.mIgnoreFocus = r5;
        this.mPerspective = null;
        this.mPrePerspectiveValue = 0.0f;
        this.hasTransformChanged = false;
        this.userInteractionEnabled = true;
        this.nativeInteractionEnabled = false;
        this.mSticky = null;
        this.mMaxHeight = -1.0f;
        this.mBackgroundColor = 0;
        this.mEnableExposureUIMargin = null;
        this.mEnableExposureUIClip = r5;
        this.mIsDetachedWithView = false;
        this.mNeedsBackgroundRecreation = false;
        this.mAlpha = 1.0f;
        this.mSkewX = 0.0f;
        this.mSkewY = 0.0f;
        this.mShouldAttachChildrenView = false;
        this.mExtraOffsetX = 0.0f;
        this.mExtraOffsetY = 0.0f;
        this.mAccessibilityLabel = "";
        this.mAccessibilityId = "";
        this.mAccessibilityElementStatus = -1;
        this.mAccessibilityEnableTap = false;
        this.mAccessibilityKeepFocused = false;
        this.mConsumeHoverEvent = false;
        this.mAccessibilityTraits = LynxAccessibilityHelper$LynxAccessibilityTraits.f10397a;
        this.mDrawableCallback = new h(this);
        this.mBitmapConfig = null;
        this.mCSSPosition = 1;
        this.mTouchSlop = 8.0f;
        this.mOnResponseChain = false;
        this.mBlockNativeEvent = false;
        this.mBlockNativeEventAreas = null;
        this.mEventThrough = r5;
        this.mEventThroughActiveRegions = null;
        this.mPointerEvents = EventTarget$PointerEventsValue.f10249c;
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
        this.mImageRendering = -1;
        this.mBoundingClientRectCallbacks = new ArrayList();
        this.mIsFirstAnimatedReady = true;
        this.mHasTranslateDiff = false;
        this.mLynxDirection = 3;
        this.mContext = r10;
        this.mParam = r11;
        com.lynx.tasm.behavior.ui.utils.g r12 = new com.lynx.tasm.behavior.ui.utils.g(r10);
        this.mLynxBackground = r12;
        r12.f10751c = this.mDrawableCallback;
        float r13 = com.lynx.tasm.utils.g.a(14.0f, r10.f10152u.density);
        this.mFontSize = r13;
        this.mLynxBackground.d = r13;
        this.mLatestSize = new Point();
        this.mLastSize = new Point();
        initialize();
    }

    public static /* synthetic */ void access$100(LynxBaseUI r5, ReadableMap r10, Callback r11) {
        r5.a(r10, r11);
    }

    public static /* synthetic */ Set access$200(LynxBaseUI r5) {
        return r5.mStateChangeListeners;
    }

    public final void a(ReadableMap r5, Callback r10) {
        RectF r11 = i.a.e(this, r5);
        float r12 = getLynxContext().f10152u.density;
        JavaOnlyMap r13 = new JavaOnlyMap();
        r13.putString("id", getIdSelector());
        r13.putMap("dataset", (WritableMap) getDataset());
        r13.putDouble(OpenPageMethod.ALIGN_LEFT, r11.left / r12);
        r13.putDouble("top", r11.top / r12);
        r13.putDouble("right", r11.right / r12);
        r13.putDouble("bottom", r11.bottom / r12);
        r13.putDouble("width", r11.width() / r12);
        r13.putDouble("height", r11.height() / r12);
        r10.invoke(new Object[]{0, r13});
    }

    public void afterAnimationNodeReady() {
        if (this.mIsFirstAnimatedReady == false) goto L5;
        this.mIsFirstAnimatedReady = false;
    L5:
        Point r5 = this.mLastSize;
        Point r10 = this.mLatestSize;
        r5.x = r10.x;
        r5.y = r10.y;
        this.hasTransformChanged = false;
    }

    public void afterPropsUpdated(y0 r5) {
        if (r5 != null) goto L4;
    L6:
        onPropsUpdated();
        onAnimationUpdated();
        com.lynx.tasm.behavior.ui.accessibility.d r10 = this.mContext.j();
        if (r10 != null) goto L9;
        return;
    L9:
        if (r10.f10411k != null) goto L11;
        return;
    L11:
        if (r10.i() == false) goto L20;
        if (r5 == null) goto L21;
        ReadableMapKeySetIterator r11 = r5.f10815a.keySetIterator();
    L15:
        if (r11.hasNextKey() == false) goto L22;
        String r12 = r11.nextKey();
        r10.f10411k.j(4, this, r12);
        goto L15
    L22:
        return;
    L21:
        return;
    L20:
        return;
    L4:
        if (r5.d() == true) goto L6;
        invalidate();
        goto L6
    }

    public void applyUIPaintStylesToTarget(LynxBaseUI r10) {
        com.lynx.tasm.behavior.e r11 = this.mUIPaintStyles;
        if (r10 == null) goto L10;
        if (r11 == null) goto L12;
        r10.setBackgroundClip(r11.f10216a);
        r10.setBackgroundColor(r11.f10218b);
        r10.setBackgroundImage(r11.f10220c);
        r10.setBackgroundOrigin(r11.d);
        r10.setBackgroundPosition(r11.e);
        r10.setBackgroundRepeat(r11.f);
        r10.setBackgroundSize(r11.g);
        r10.setMaskImage(r11.f10225h);
        r10.setMaskOrigin(r11.f10227i);
        r10.setMaskRepeat(r11.f10228j);
        r10.setMaskSize(r11.f10229k);
        r10.setMaskPosition(r11.f10230l);
        r10.setMaskClip(r11.f10231m);
        r10.setBorderRadius(0, r11.f10232n);
        r10.setBorderRadius(1, r11.f10233o);
        r10.setBorderRadius(2, r11.f10234p);
        r10.setBorderRadius(3, r11.f10235q);
        r10.setBorderRadius(4, r11.f10236r);
        r10.setOverflow(r11.G);
        r10.setOverflowX(r11.H);
        r10.setOverflowY(r11.I);
        r10.setBorderStyle(0, r11.s);
        r10.setBorderStyle(1, r11.f10237t);
        r10.setBorderStyle(2, r11.f10238u);
        r10.setBorderStyle(3, r11.f10239v);
        r10.setBorderStyle(4, r11.f10240w);
        r10.setBorderWidth(0, r11.f10241x);
        r10.setBorderWidth(1, r11.f10242y);
        r10.setBorderWidth(2, r11.f10243z);
        r10.setBorderWidth(3, r11.A);
        r10.setBorderWidth(4, r11.B);
        r10.setBorderColor(0, r11.C);
        r10.setBorderColor(1, r11.D);
        r10.setBorderColor(2, r11.E);
        r10.setBorderColor(3, r11.F);
        r10.setOutlineColor(r11.J);
        r10.setOutlineWidth(r11.K);
        r10.setOutlineStyle(r11.L);
        r10.setFontSize(r11.M);
        r10.setLynxDirection(r11.N);
        r10.setTransformOrigin(r11.O);
        r10.setPerspective(r11.P);
        r10.setBoxShadow(r11.Q);
        r10.setImageRendering(r11.S);
        if ((r10 instanceof LynxUI) == false) goto L11;
        LynxUI r12 = (LynxUI) r10;
        r12.setClipPath(r11.T);
        r12.setFilter(r11.U);
        r12.setLayoutAnimationCreateDelay(r11.V);
        r12.setLayoutAnimationCreateDuration(r11.W);
        r12.setLayoutAnimationCreateProperty(r11.X);
        r12.setLayoutAnimationCreateTimingFunc(r11.Y);
        r12.setLayoutAnimationDeleteDelay(r11.Z);
        r12.setLayoutAnimationDeleteDuration(r11.f10217a0);
        r12.setLayoutAnimationDeleteProperty(r11.f10219b0);
        r12.setLayoutAnimationDeleteTimingFunc(r11.f10221c0);
        r12.setLayoutAnimationUpdateDelay(r11.f10222d0);
        r12.setLayoutAnimationUpdateDuration(r11.f10223e0);
        r12.setLayoutAnimationUpdateTimingFunc(r11.f10224f0);
        r12.setAlpha(r11.g0);
        r12.setVisibility(r11.f10226h0);
        r12.setTransform(r11.R);
        return;
    L11:
        return;
    L12:
        return;
    }

    public void attachToView(LynxContext r5) {
        this.mContext = r5;
        Iterator<LynxBaseUI> r10 = this.mChildren.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().attachToView(r5);
        goto L4
    }

    @Override // wm.a
    public boolean blockNativeEvent(MotionEvent r13) {
        if (this.mBlockNativeEvent == false) goto L6;
        return true;
    L6:
        if (this.mBlockNativeEventAreas != null) goto L8;
        return false;
    L8:
        Rect r5 = getLynxContext().f10145m.getBoundingClientRect();
        Rect r10 = getBoundingClientRect();
        float r11 = r13.getX();
        float r14 = r13.getY();
        float r12 = (r5.left - r10.left) + r11;
        float r15 = (r5.top - r10.top) + r14;
        int r16 = 0;
        boolean r17 = false;
    L10:
        if (r16 >= this.mBlockNativeEventAreas.size()) goto L29;
        ArrayList<com.lynx.tasm.utils.i> r18 = this.mBlockNativeEventAreas.get(r16);
        if (r18 == null) goto L28;
        if (r18.size() != 4) goto L28;
        float r19 = r18.get(0).a(r10.right - r10.left);
        float r20 = r18.get(1).a(r10.bottom - r10.top);
        float r21 = r18.get(2).a(r10.right - r10.left) + r19;
        float r22 = r18.get(3).a(r10.bottom - r10.top) + r20;
        if (r12 >= r19) goto L18;
    L24:
        r17 = false;
    L25:
        if (r17 == false) goto L28;
        LynxLog.b(2, TAG, "blocked this point!");
        return r17;
    L18:
        if (r12 >= r21) goto L24;
        if (r15 < r20) goto L24;
        if (r15 >= r22) goto L24;
        r17 = true;
    L28:
        r16 = r16 + 1;
        goto L10
    L29:
        return r17;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [android.view.View] */
    @com.lynx.tasm.behavior.f0
    public void boundingClientRect(ReadableMap r10, Callback r11) {
        n0 r5 = (n0) this.mContext.f10147o.get();
        if (r5 != null) goto L6;
        a(r10, r11);
        return;
    L6:
        UIBody r12 = r5.f10288b;
        if (r12 != null) goto L10;
        a(r10, r11);
        return;
    L10:
        ?? r13 = r12.getView();
        if (r13 != 0) goto L15;
        a(r10, r11);
        return;
    L15:
        if (r13.isLayoutRequested() == true) goto L18;
        a(r10, r11);
        return;
    L18:
        ((n0) this.mContext.f10147o.get()).f10290h.add(this);
        this.mBoundingClientRectCallbacks.add(new com.bytedance.android.anniex.scene.core.i(this, r10, r11, 13, false));
    }

    public boolean canHaveFlattenChild() {
        return true;
    }

    public boolean checkStickyOnParentScroll(int r11, int r12) {
        if (this.mSticky != null) goto L5;
        return false;
    L5:
        float r13 = getLeft() - r11;
        float r14 = getTop() - r12;
        Sticky r5 = this.mSticky;
        float r10 = ((RectF) r5).left;
        if (r13 >= r10) goto L9;
        r5.f10380a = r10 - r13;
    L16:
        Sticky r15 = this.mSticky;
        float r16 = ((RectF) r15).top;
        if (r14 >= r16) goto L20;
        r15.f10381b = r16 - r14;
        return true;
    L20:
        if (getParentBaseUI() != null) goto L23;
        LynxLog.b(4, TAG, "checkStickyOnParentScroll failed, parent is null.");
        return false;
    L23:
        int r17 = getParentBaseUI().getHeight();
        float r18 = getHeight() + r14;
        Sticky r19 = this.mSticky;
        float r20 = ((RectF) r19).bottom;
        float r110 = r17;
        if ((r18 + r20) <= r110) goto L26;
        r19.f10381b = Math.max((r110 - r18) - r20, ((RectF) r19).top - r14);
        return true;
    L26:
        r19.f10381b = 0.0f;
        return true;
    L9:
        if (getParentBaseUI() != null) goto L12;
        LynxLog.b(4, TAG, "checkStickyOnParentScroll failed, parent is null.");
        return false;
    L12:
        int r21 = getParentBaseUI().getWidth();
        float r22 = getWidth() + r13;
        Sticky r23 = this.mSticky;
        float r24 = ((RectF) r23).right;
        float r25 = r21;
        if ((r22 + r24) <= r25) goto L15;
        r23.f10380a = Math.max((r25 - r22) - r24, ((RectF) r23).left - r13);
        goto L16
    L15:
        r23.f10380a = 0.0f;
        goto L16
    }

    public boolean childrenContainPoint(float r5, float r10) {
        return childrenContainPoint(r5, r10, false);
    }

    @NonNull
    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m99clone() {
        return clone();
    }

    public String constructListStateCacheKey(String r5, String r10, String r11) {
        StringBuilder r12 = new StringBuilder();
        r12.append(r5);
        r12.append("_");
        r12.append(r10);
        r12.append("_");
        if (r11 != null) goto L6;
        r11 = "";
    L6:
        r12.append(r11);
        return r12.toString();
    }

    public void consumeGesture(boolean r5) {
    }

    @Override // wm.a
    public boolean consumeSlideEvent(float r5) {
        ArrayList<ArrayList<Float>> r10 = this.mConsumeSlideEventAngles;
        if (r10 != null) goto L5;
        return false;
    L5:
        Iterator<ArrayList<Float>> r11 = r10.iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        ArrayList<Float> r12 = r11.next();
        if (r5 < r12.get(0).floatValue()) goto L7;
        if (r5 > r12.get(1).floatValue()) goto L7;
        return true;
    L13:
        return false;
    }

    public boolean containsPoint(float r5, float r10) {
        return containsPoint(r5, r10, false);
    }

    public p convertToMeaningfulPaintingArea(int r5, int r10) {
        return null;
    }

    public void convertToMeaningfulPaintingAreaRecursive(int r5, int r10, ArrayList<p> r11) {
        p r12 = convertToMeaningfulPaintingArea(r5, r10);
        if (r12 == null) goto L5;
        r11.add(r12);
    L5:
        int r13 = getOriginLeft() + r5;
        int r14 = getOriginTop() + r10;
        Iterator<LynxBaseUI> r15 = this.mChildren.iterator();
    L7:
        if (r15.hasNext() == false) goto L12;
        LynxBaseUI r16 = r15.next();
        if (r16 == null) goto L7;
        r16.convertToMeaningfulPaintingAreaRecursive(r13, r14, r11);
        goto L7
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void copyPropFromOldUiInUpdateFlatten(LynxBaseUI r5) {
        this.mIsFirstAnimatedReady = r5.mIsFirstAnimatedReady;
        this.mLastSize.set(r5.getLastSize().x, r5.getLastSize().y);
        this.mLatestSize.set(r5.getLatestSize().x, r5.getLatestSize().y);
        this.mFlattenChildrenCount = r5.mFlattenChildrenCount;
        setEvents(r5.getEvents());
    }

    public void createViewAsync() {
    }

    public final void d() {
        if (this.mLynxBackground != null) goto L5;
    L6:
        com.lynx.tasm.behavior.ui.utils.g r5 = new com.lynx.tasm.behavior.ui.utils.g(this.mContext);
        this.mLynxBackground = r5;
        r5.f10751c = this.mDrawableCallback;
        r5.d = this.mFontSize;
        this.mNeedsBackgroundRecreation = false;
        ReadableMapKeySetIterator r10 = this.mProps.keySetIterator();
        y0 r11 = null;
        LynxUISetter r12 = null;
    L8:
        if (r10.hasNextKey() == false) goto L23;
        String r13 = r10.nextKey();
        if (BACKGROUND_PROPS.contains(r13) == false) goto L8;
        if (r11 != null) goto L13;
        r11 = new y0(this.mProps);
        ConcurrentHashMap r14 = com.lynx.tasm.behavior.utils.l.f10800a;
        r12 = com.lynx.tasm.behavior.utils.l.c(getClass());
    L13:
        if (r12 == null) goto L8;
        r12.a(this, r13, r11);
        goto L8
    L23:
        return;
    L5:
        if (this.mNeedsBackgroundRecreation == true) goto L6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void destroy() {
        if ((this instanceof u0) == false) goto L8;
        u0 r5 = (u0) this;
        ArrayList r10 = this.mContext.f10154w;
        if (r10 == null) goto L8;
        r10.remove(r5);
    L8:
        if ((this instanceof com.lynx.tasm.behavior.g) == false) goto L15;
        n0 r11 = (n0) this.mContext.f10147o.get();
        if (r11 == null) goto L15;
        com.lynx.tasm.behavior.g r12 = (com.lynx.tasm.behavior.g) this;
        ArrayList r13 = r11.f;
        if (r13 == null) goto L15;
        r13.remove(r12);
    L15:
        if (this.mContext.i() == null) goto L17;
        com.lynx.tasm.behavior.w r14 = this.mContext.i();
        r14.getClass();
        com.lynx.tasm.utils.j.f(new ab.b(28, r14, false, this));
    L17:
        com.lynx.tasm.behavior.ui.utils.g r15 = this.mLynxBackground;
        if (r15 == null) goto L20;
        r15.f();
    L20:
        com.lynx.tasm.behavior.ui.utils.i r16 = this.mLynxMask;
        if (r16 == null) goto L23;
        r16.f();
    L23:
        com.lynx.tasm.behavior.ui.accessibility.d r17 = this.mContext.j();
        if (r17 == null) goto L26;
        r17.b(this, false);
    L26:
        sn.a r18 = getGestureArenaManager();
        if (r18 != null) goto L29;
    L60:
        Map<Integer, vn.a> r19 = this.mGestureHandlers;
        if (r19 == null) goto L77;
        r19.clear();
        return;
    L77:
        return;
    L29:
        if ((this instanceof rn.a) == false) goto L60;
        rn.a r20 = (rn.a) this;
        if (r18.f == false) goto L60;
        HashMap r21 = r18.f21956a;
        if (r21 == null) goto L60;
        r21.remove(Integer.valueOf(r20.getGestureArenaMemberId()));
        int r22 = r20.getGestureArenaMemberId();
        Map r23 = r20.getGestureDetectorMap();
        if (r18.f == false) goto L60;
        if (r23 == null) goto L60;
        if (r23.isEmpty() == true) goto L60;
        if (r18.e == null) goto L60;
        Iterator r24 = r23.entrySet().iterator();
    L46:
        if (r24.hasNext() == false) goto L60;
        un.a r25 = (un.a) ((Map.Entry) r24.next()).getValue();
        s6.c r26 = r18.e;
        r26.getClass();
        if (r25 == null) goto L46;
        HashMap r27 = (HashMap) r26.f21828b;
        int r28 = r25.f22417a;
        Set r29 = (Set) r27.get(Integer.valueOf(r28));
        if (r29 == null) goto L46;
        if (r29.isEmpty() == true) goto L46;
        if (r29.contains(Integer.valueOf(r22)) == false) goto L46;
        r29.remove(Integer.valueOf(r22));
        if (r29.isEmpty() == false) goto L46;
        r27.remove(Integer.valueOf(r28));
        goto L46
    }

    public void detachWithViewInfo(g0 r5) {
        Iterator<LynxBaseUI> r10 = this.mChildren.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().detachWithViewInfo(r5);
        goto L4
    }

    @Override // wm.a
    public boolean dispatchEvent(on.d r5) {
        return false;
    }

    public void dispatchProperties(y0 r5) {
    }

    public boolean dispatchTouch(MotionEvent r5) {
        return false;
    }

    public final com.lynx.tasm.behavior.ui.utils.i e() {
        if (this.mLynxMask != null) goto L8;
        com.lynx.tasm.behavior.ui.utils.i r5 = new com.lynx.tasm.behavior.ui.utils.i(this.mContext);
        this.mLynxMask = r5;
        r5.f10751c = this.mDrawableCallback;
        r5.d = this.mFontSize;
        boolean r10 = this.mEnableBitmapGradient;
        com.lynx.tasm.behavior.ui.utils.f r11 = r5.d();
        r11.e.f349j = r10;
        r11.invalidateSelf();
        this.mLynxMask.b(this.mBitmapConfig);
        com.lynx.tasm.behavior.ui.utils.i r12 = this.mLynxMask;
        r12.d().b(SPACING_TYPES[this.mBorderSpacingIndex], this.mBorderWidth);
        com.lynx.tasm.behavior.ui.utils.i r13 = this.mLynxMask;
        float r14 = this.mPaddingTop;
        float r15 = this.mPaddingRight;
        float r16 = this.mPaddingBottom;
        float r17 = this.mPaddingLeft;
        com.lynx.tasm.behavior.ui.utils.f r18 = r13.f10750b;
        if (r18 == null) goto L8;
        r18.c(r14, r15, r16, r17);
    L8:
        return this.mLynxMask;
    }

    public boolean enableLayoutAnimation() {
        return false;
    }

    @Override // wm.a
    public boolean enableTouchPseudoPropagation() {
        return this.mEnableTouchPseudoPropagation;
    }

    public void ensureCreateView(View r5) {
    }

    public boolean eventThrough(float r11, float r12) {
        EventTarget$EnableStatus r5 = this.mEventThrough;
        if (r5 != EventTarget$EnableStatus.f10244a) goto L6;
        boolean r10 = true;
    L19:
        if (this.mEventThroughActiveRegions == null) goto L42;
        int r13 = 0;
        boolean r14 = false;
    L23:
        if (r13 >= this.mEventThroughActiveRegions.size()) goto L41;
        ArrayList<com.lynx.tasm.utils.i> r15 = this.mEventThroughActiveRegions.get(r13);
        if (r15 == null) goto L40;
        if (r15.size() != 4) goto L40;
        float r16 = r15.get(0).a(this.mWidth);
        float r17 = r15.get(1).a(this.mHeight);
        float r18 = r15.get(2).a(this.mWidth) + r16;
        float r19 = r15.get(3).a(this.mHeight) + r17;
        if (r11 >= r16) goto L31;
    L37:
        r14 = false;
    L38:
        if (r14 == false) goto L40;
        LynxLog.b(2, TAG, "hit the event through active regions!");
        goto L41
    L31:
        if (r11 >= r18) goto L37;
        if (r12 < r17) goto L37;
        if (r12 >= r19) goto L37;
        r14 = true;
    L40:
        r13 = r13 + 1;
    L41:
        if (r14 == true) goto L42;
        if (r10 == true) goto L45;
        return true;
    L45:
        return false;
    L42:
        return r10;
    L6:
        if (r5 != EventTarget$EnableStatus.f10245b) goto L9;
    L12:
        r10 = false;
        goto L19
    L9:
        if (parent() == null) goto L12;
        wm.a r20 = parent();
        if ((r20 instanceof UIBody) == true) goto L12;
        if ((r20 instanceof LynxBaseUI) == false) goto L16;
        LynxBaseUI r21 = (LynxBaseUI) r20;
        RectF r22 = i.a.f(this, r21, new RectF(0.0f, 0.0f, r21.getWidth(), r21.getHeight()));
        float r23 = r11 - r22.left;
        float r24 = r12 - r22.top;
    L17:
        r10 = r20.eventThrough(r23, r24);
        goto L19
    L16:
        r23 = r11;
        r24 = r12;
        goto L17
    }

    public final synchronized void f() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mScrollStateChangeListener == null) goto L7;
        monitor-exit(this);
        return;
    L7:
        this.mScrollStateChangeListener = new g(this);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @com.lynx.tasm.behavior.f0
    public void fetchAccessibilityTargets(ReadableMap r5, Callback r10) {
        if (this.mContext.j() == null) goto L13;
        com.lynx.tasm.behavior.ui.accessibility.d r11 = this.mContext.j();
        if (r11.f() == false) goto L7;
    L11:
        JavaOnlyArray r12 = new JavaOnlyArray();
        com.lynx.tasm.behavior.ui.accessibility.d.c(this, false, r12);
        r10.invoke(new Object[]{0, r12});
        return;
    L7:
        if (r11.g() == true) goto L11;
        r10.invoke(new Object[]{1, "fetch accessibility targets fail!"});
        return;
    }

    public int flattenChildrenCount() {
        return this.mFlattenChildrenCount;
    }

    public void flattenChildrenCountDecrement() {
        this.mFlattenChildrenCount--;
    }

    public void flattenChildrenCountIncrement() {
        this.mFlattenChildrenCount++;
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return null;
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

    public LynxAccessibilityHelper$LynxAccessibilityTraits getAccessibilityTraits() {
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

    public Rect getBoundRectForOverflow() {
        if (getOverflow() != 3) goto L7;
        return null;
    L7:
        return getClipBounds();
    }

    public Rect getBoundingClientRect() {
        UIBody r5 = this.mContext.f10145m;
        ViewGroup r10 = r5.f10385a;
        int r11 = 0;
        if (r10 != null) goto L7;
        return new Rect(0, 0, getWidth(), getHeight());
    L7:
        if ((this instanceof LynxUI) == false) goto L24;
        View r12 = ((LynxUI) this).mView;
        if ((r12 instanceof d0) == false) goto L13;
        d0 r13 = (d0) r12;
        if (r13.getChildCount() <= 0) goto L13;
        r12 = r13.getChildAt(0);
    L13:
        Rect r14 = new Rect();
        View r15 = r12.getRootView();
        if (r10.getRootView() != r15) goto L16;
    L41:
        r10.offsetDescendantRectToMyCoords(r12, r14);     // Catch: IllegalArgumentException -> L40
        r14.offset(r12.getScrollX(), r12.getScrollY());     // Catch: IllegalArgumentException -> L40
    L19:
        int[] r16 = getOffsetDescendantRectToLynxView();
        int r17 = r16[0];
        if (r17 == Integer.MIN_VALUE) goto L22;
        r14.offset(r17, r16[1]);
    L22:
        int r18 = r14.top;
        r11 = r14.left;
        int r19 = r18;
    L39:
        return new Rect(r11, r19, getWidth() + r11, getHeight() + r19);
    L16:
        if ((r15 instanceof ViewGroup) == false) goto L41;
        r10 = (ViewGroup) r15;
        goto L41
    L24:
        if ((this instanceof LynxFlattenUI) == false) goto L37;
        a0 r20 = this.mParent;
        if (r20 == null) goto L36;
        if (r20 == r5) goto L36;
        LynxBaseUI r21 = this;
        r19 = 0;
    L30:
        if ((r21 instanceof LynxFlattenUI) == false) goto L34;
        if (r21 == this.mContext.f10145m) goto L34;
        r11 = r11 + r21.getOriginLeft();
        r19 = r19 + r21.getOriginTop();
        r21 = r21.getParentBaseUI();
    L34:
        if (r21 == null) goto L39;
        Rect r22 = r21.getBoundingClientRect();
        r11 = r11 + (r22.left - r21.getScrollX());
        r19 = r19 + (r22.top - r21.getScrollY());
    L36:
        r11 = this.mLeft;
        r19 = this.mTop;
        goto L39
    L37:
        r19 = 0;
        goto L39
    }

    public int getCSSPositionType() {
        return this.mCSSPosition;
    }

    public LynxBaseUI getChildAt(int r5) {
        return this.mChildren.get(r5);
    }

    public List<LynxBaseUI> getChildren() {
        return this.mChildren;
    }

    @Override // wm.a
    public HashMap<String, wm.a> getChildrenLynxPageUI() {
        LynxContext r5 = this.mContext;
        if (r5 == null) goto L9;
        UIBody r10 = r5.f10145m;
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.f10387c;
    L9:
        return null;
    }

    public Rect getClipBounds() {
        int r5 = getWidth();
        int r10 = getHeight();
        DisplayMetrics r11 = getLynxContext().f10152u;
        int r12 = 0;
        if ((getOverflow() & 1) == 0) goto L5;
        int r13 = r11.widthPixels;
        int r14 = 0 - r13;
        r5 = r5 + (r13 * 2);
    L7:
        if ((getOverflow() & 2) == 0) goto L10;
        int r15 = r11.heightPixels;
        r12 = 0 - r15;
        r10 = r10 + (r15 * 2);
    L10:
        return new Rect(r14, r12, r5 + r14, r10 + r12);
    L5:
        r14 = 0;
        goto L7
    }

    public boolean getClipToRadius() {
        return this.mClipToRadius;
    }

    public ReadableMap getDataset() {
        return this.mDataset;
    }

    public LynxBaseUI getDrawParent() {
        return (LynxBaseUI) this.mDrawParent;
    }

    public EventTarget$EnableStatus getEnableExposureUIClip() {
        return this.mEnableExposureUIClip;
    }

    public boolean getEnableExposureUIMargin() {
        Boolean r5 = this.mEnableExposureUIMargin;
        if (r5 != null) goto L5;
        com.lynx.tasm.u0 r10 = this.mContext.K;
        if (r10 != null) goto L9;
        return false;
    L9:
        return r10.I;
    L5:
        return r5.booleanValue();
    }

    public pm.a getEnableLocalCache() {
        return this.mUseLocalCache;
    }

    @Override // wm.a
    public Map<String, on.a> getEvents() {
        return this.mEvents;
    }

    public LynxBaseUI getExposeReceiveTarget() {
        return this;
    }

    public String getExposeUniqueID() {
        return String.valueOf(this.mSign);
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

    @Nullable
    public sn.a getGestureArenaManager() {
        LynxContext r5 = this.mContext;
        if (r5 != null) goto L5;
        return null;
    L5:
        n0 r10 = (n0) r5.f10147o.get();
        if (r10 != null) goto L9;
        return null;
    L9:
        return r10.f10297o;
    }

    @Override // wm.a
    public int getGestureArenaMemberId() {
        return this.mGestureArenaMemberId;
    }

    public Map<Integer, un.a> getGestureDetectorMap() {
        return this.mGestureDetectors;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public Map<Integer, vn.a> getGestureHandlers() {
        if (isEnableNewGesture() == true) goto L7;
        return null;
    L7:
        if (this.mGestureHandlers != null) goto L12;
        if ((this instanceof rn.a) == false) goto L12;
        this.mGestureHandlers = vn.a.b(getSign(), getLynxContext(), (rn.a) this, getGestureDetectorMap());
    L12:
        return this.mGestureHandlers;
    }

    public boolean getHasRadius() {
        return this.mHasRadius;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Matrix getHitTestMatrix() {
        this.mHitTestMatrix.reset();
        return this.mHitTestMatrix;
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

    public int getIndex(LynxBaseUI r5) {
        return this.mChildren.indexOf(r5);
    }

    public int getInitialOverflowType() {
        return 1;
    }

    @Nullable
    public com.lynx.tasm.animation.keyframe.a getKeyframeManager() {
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Point getLastSize() {
        return this.mLastSize;
    }

    public float getLastTranslateZ() {
        return this.mLastTranslateZ;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final int getLatestHeight() {
        return this.mLatestSize.y;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Point getLatestSize() {
        return this.mLatestSize;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final int getLatestWidth() {
        return this.mLatestSize.x;
    }

    @Nullable
    public um.e getLayoutAnimator() {
        return null;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public float[] getLocationOnScreen(float[] r10) {
        int[] r5 = new int[2];
        if (isFlatten() == false) goto L6;
        r10[0] = r10[0] + getLeft();
        r10[1] = r10[1] + getTop();
    L6:
        if (isFlatten() == false) goto L12;
        a0 r11 = this.mDrawParent;
        if (r11 != null) goto L11;
        LynxLog.b(4, TAG, "mDrawParent of flattenUI is null, which causes the value getLocationOnScreen returns is not the correct coordinates relative to the screen!");
        return r10;
    L11:
        View r12 = ((LynxUI) r11).getView();
        r10[0] = r10[0] - r12.getScrollX();
        r10[1] = r10[1] - r12.getScrollY();
    L13:
        r12.getRootView().getLocationOnScreen(r5);
        transformFromViewToRootView(r12, r10);
        r10[0] = r10[0] + r5[0];
        r10[1] = r10[1] + r5[1];
        return r10;
    L12:
        r12 = ((LynxUI) this).getView();
        goto L13
    }

    public com.lynx.tasm.behavior.ui.utils.g getLynxBackground() {
        return this.mLynxBackground;
    }

    public LynxContext getLynxContext() {
        return this.mContext;
    }

    public com.lynx.tasm.behavior.ui.utils.i getLynxMask() {
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

    public long getMemoryUsageBytes() {
        return 0;
    }

    public Map<String, String> getMemoryUsageDetail() {
        return null;
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

    public int[] getOffsetDescendantRectToLynxView() {
        int[] r5 = this.mOffsetDescendantRectToLynxView.get();
        if (r5 == null) goto L6;
        return r5;
    L6:
        return sDefaultOffsetToLynxView;
    }

    public com.lynx.tasm.behavior.e getOrCreateUIPaintStyles() {
        if (this.mUIPaintStyles != null) goto L6;
        com.lynx.tasm.behavior.e r5 = new com.lynx.tasm.behavior.e();
        r5.f10218b = 0;
        r5.s = -1;
        r5.f10237t = -1;
        r5.f10238u = -1;
        r5.f10239v = -1;
        r5.f10240w = -1;
        r5.J = ViewCompat.MEASURED_STATE_MASK;
        r5.N = 3;
        this.mUIPaintStyles = r5;
    L6:
        return this.mUIPaintStyles;
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

    public a0 getParent() {
        return this.mParent;
    }

    public LynxBaseUI getParentBaseUI() {
        a0 r5 = this.mParent;
        if ((r5 instanceof UIShadowProxy) == false) goto L7;
        return (LynxBaseUI) ((UIShadowProxy) r5).getParent();
    L7:
        return (LynxBaseUI) r5;
    }

    @Override // wm.a
    public wm.a getParentLynxPageUI() {
        LynxContext r5 = this.mContext;
        if (r5 == null) goto L9;
        UIBody r10 = r5.f10145m;
        if (r10 != null) goto L8;
        return null;
    L8:
        return r10.f10386b;
    L9:
        return null;
    }

    public JSONObject getPlatformCustomInfo() {
        return new JSONObject();
    }

    public LynxBaseUI getPreviousDrawUI() {
        return this.mPreviousDrawUI;
    }

    public JavaOnlyMap getProps() {
        return this.mProps;
    }

    @Override // wm.a
    public int getPseudoStatus() {
        return this.mPseudoStatus;
    }

    public float getRealTimeTranslationZ() {
        return this.mTranslationZ;
    }

    public Rect getRect() {
        float r5 = (getWidth() / 2.0f) + getOriginLeft();
        float r10 = (getHeight() / 2.0f) + getOriginTop();
        float r11 = getScaleX() * getWidth();
        float r12 = getScaleY() * getHeight();
        float r13 = getTranslationX() + (r5 - (r11 / 2.0f));
        float r14 = getTranslationY() + (r10 - (r12 / 2.0f));
        return new Rect((int) r13, (int) r14, (int) (r13 + r11), (int) (r14 + r12));
    }

    public Rect getRectToWindow() {
        UIBody.UIBodyView r5 = this.mContext.f10145m.f10385a;
        if (r5 == null) goto L5;
        int[] r10 = new int[2];
        r5.getLocationOnScreen(r10);
        Rect r11 = getBoundingClientRect();
        r11.offset(r10[0], r10[1]);
        return r11;
    L5:
        return new Rect();
    }

    public Rect getRectWithoutTransform() {
        float r5 = getOriginLeft();
        float r10 = getOriginTop();
        return new Rect((int) r5, (int) r10, (int) (r5 + getWidth()), (int) (r10 + getHeight()));
    }

    public String getRefIdSelector() {
        return this.mRefId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [wm.a] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    @Override // wm.a
    public wm.a getRootLynxPageUI() {
    L2:
        if (r1 == 0) goto L6;
        if (r1.getParentLynxPageUI() == null) goto L6;
        ?? r5 = r5.getParentLynxPageUI();
    L6:
        return r5;
    }

    public float getScaleX() {
        return 1.0f;
    }

    public float getScaleY() {
        return 1.0f;
    }

    public String getScrollMonitorTag() {
        return this.mScrollMonitorTag;
    }

    public int getScrollX() {
        return 0;
    }

    public int getScrollY() {
        return 0;
    }

    @Override // wm.a
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

    public float[] getTargetPoint(float r5, float r10, int r11, int r12, Rect r13, Matrix r14) {
        float[] r15 = {(r5 + r11) - r13.left, (r10 + r12) - r13.top};
        Matrix r16 = getHitTestMatrix();
        if (r14.invert(r16) == false) goto L6;
        float[] r17 = {r15[0], r15[1]};
        r16.mapPoints(r17);
        r15[0] = r17[0];
        r15[1] = r17[1];
        return r15;
    L6:
        r15[0] = Float.MAX_VALUE;
        r15[1] = Float.MAX_VALUE;
        return r15;
    }

    public String getTestID() {
        String r5 = this.mTestTagName;
        if (r5 != null) goto L6;
        return "";
    L6:
        return r5;
    }

    public int getTop() {
        return this.mTop;
    }

    public a1 getTouchEventDispatcher() {
        LynxContext r5 = this.mContext;
        if (r5 != null) goto L5;
        return null;
    L5:
        return r5.f10140h;
    }

    public Matrix getTransformMatrix() {
        this.mTransformMatrix.reset();
        return this.mTransformMatrix;
    }

    @Nullable
    public com.lynx.tasm.behavior.ui.utils.m getTransformOriginStr() {
        return this.mTransformOrigin;
    }

    public List<com.lynx.tasm.behavior.ui.utils.o> getTransformRaws() {
        return this.mTransformRaw;
    }

    public i getTransformValue(float r10, float r11, float r12, float r13) {
        i r5 = new i();
        getLocationOnScreen(new float[]{r10, r12});
        getLocationOnScreen(new float[]{this.mWidth + r11, r12});
        getLocationOnScreen(new float[]{this.mWidth + r11, this.mHeight + r13});
        getLocationOnScreen(new float[]{r10, this.mHeight + r13});
        return r5;
    }

    public vm.i getTransitionAnimator() {
        return null;
    }

    public float getTranslationX() {
        return 0.0f;
    }

    public float getTranslationY() {
        return 0.0f;
    }

    public float getTranslationZ() {
        return this.mTranslationZ;
    }

    public Object getValueFromNativeStorage(String r5) {
        return null;
    }

    public boolean getVisibility() {
        return true;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public Window getWindow() {
        Context r5 = this.mContext;
    L4:
        if ((r5 instanceof ContextWrapper) == false) goto L10;
        if ((r5 instanceof Activity) == true) goto L8;
        r5 = ((ContextWrapper) r5).getBaseContext();
        goto L4
    L8:
        return ((Activity) r5).getWindow();
    L10:
        return null;
    }

    @Override // wm.a
    public boolean hasConsumeSlideEventAngles() {
        ArrayList<ArrayList<Float>> r5 = this.mConsumeSlideEventAngles;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.isEmpty() == true) goto L10;
        return true;
    L10:
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean hasSizeChanged() {
        return !this.mLastSize.equals(this.mLatestSize);
    }

    public wm.a hitTest(float r5, float r10) {
        return hitTest(r5, r10, false);
    }

    public boolean ignoreFocus() {
        EventTarget$EnableStatus r5 = this.mIgnoreFocus;
        if (r5 != EventTarget$EnableStatus.f10244a) goto L7;
        return true;
    L7:
        if (r5 != EventTarget$EnableStatus.f10245b) goto L10;
        return false;
    L10:
        if (parent() != null) goto L12;
        return false;
    L12:
        return parent().ignoreFocus();
    }

    public void initTransitionAnimator(ReadableMap r5) {
    }

    public boolean initialPropsFlushed(String r5, String r10) {
        return true;
    }

    public void initialize() {
    }

    @com.lynx.tasm.behavior.f0
    public void innerText(ReadableMap r5, Callback r10) {
        if (this.mContext.j() == null) goto L13;
        com.lynx.tasm.behavior.ui.accessibility.d r11 = this.mContext.j();
        if (r11.f() == false) goto L7;
    L11:
        JavaOnlyArray r12 = new JavaOnlyArray();
        com.lynx.tasm.behavior.ui.accessibility.d.c(this, true, r12);
        r10.invoke(new Object[]{0, r12});
        return;
    L7:
        if (r11.g() == true) goto L11;
        r10.invoke(new Object[]{1, "fetch accessibility inner text fail!"});
        return;
    }

    public void insertChild(LynxBaseUI r5, int r10) {
        this.mChildren.add(r10, r5);
        r5.setParent(this);
    }

    public void interceptGesture(boolean r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.a0
    public void invalidate() {
    }

    public void invalidateMeaningfulPaintingArea() {
        if (getLynxContext() != null) goto L6;
        return;
    L6:
        if (getLynxContext().l() != null) goto L8;
        return;
    L8:
        getLynxContext().l().invalidateMeaningfulPaintingArea();
    }

    public boolean isAccessibilityDirectionVertical() {
        return true;
    }

    public boolean isAccessibilityHostUI() {
        return false;
    }

    public boolean isClickable() {
        Map<String, on.a> r5 = this.mEvents;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.containsKey("tap") == false) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isCustomHittest() {
        return false;
    }

    public boolean isDetachedWithView() {
        return this.mIsDetachedWithView;
    }

    public boolean isEnableNewGesture() {
        if (this.mGestureArenaMemberId <= 0) goto L6;
        return true;
    L6:
        return false;
    }

    public boolean isEnableScrollMonitor() {
        return this.mEnableScrollMonitor;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean isFirstAnimatedReady() {
        return this.mIsFirstAnimatedReady;
    }

    public boolean isFlatten() {
        return false;
    }

    public boolean isFocusable() {
        return this.mFocusable;
    }

    public boolean isLongClickable() {
        Map<String, on.a> r5 = this.mEvents;
        if (r5 != null) goto L5;
        return false;
    L5:
        if (r5.containsKey("longpress") == false) goto L10;
        return true;
    L10:
        return false;
    }

    public boolean isOnResponseChain() {
        return this.mOnResponseChain;
    }

    public boolean isOverlay() {
        return false;
    }

    public boolean isScrollContainer() {
        return false;
    }

    public boolean isScrollable() {
        return false;
    }

    public boolean isUserInteractionEnabled() {
        return this.userInteractionEnabled;
    }

    public boolean isVisible() {
        return true;
    }

    public void layout() {
        Iterator<LynxBaseUI> r5 = this.mChildren.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().layout();
        goto L4
    }

    public void markDetachWithViewRecursively(boolean r5) {
        this.mIsDetachedWithView = r5;
        this.mNeedsBackgroundRecreation = r5;
        Iterator<LynxBaseUI> r10 = this.mChildren.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r10.next().markDetachWithViewRecursively(r5);
        goto L4
    }

    public void measure() {
        Iterator<LynxBaseUI> r5 = this.mChildren.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().measure();
        goto L4
    }

    public boolean needCustomLayout() {
        return false;
    }

    public boolean needGenerateMeaningfulPaintingArea() {
        return false;
    }

    public void notifyScrollStateChanged(int r5) {
        if (this.mStateChangeListeners == null) goto L11;
        monitor-enter(this);
        q[] r10 = (q[]) this.mStateChangeListeners.toArray(new q[this.mStateChangeListeners.size()]);     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        int r11 = r10.length;
        int r12 = 0;
    L9:
        if (r12 >= r11) goto L18;
        r10[r12].a(r5);
        r12 = r12 + 1;
        goto L9
    L18:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // wm.a
    public void offResponseChain() {
        this.mOnResponseChain = false;
    }

    public void onAnimationNodeReady() {
    }

    @Deprecated
    public void onAnimationUpdated() {
    }

    public void onAttach() {
        com.lynx.tasm.behavior.ui.utils.g r5 = this.mLynxBackground;
        if (r5 == null) goto L11;
        com.lynx.tasm.behavior.ui.utils.f r10 = r5.f10750b;
        if (r10 == null) goto L11;
        Iterator r11 = r10.e.f344a.iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        ((an.c) r11.next()).h();
    L11:
        com.lynx.tasm.behavior.ui.utils.i r12 = this.mLynxMask;
        if (r12 == null) goto L20;
        com.lynx.tasm.behavior.ui.utils.f r13 = r12.f10750b;
        if (r13 == null) goto L23;
        Iterator r14 = r13.e.f344a.iterator();
    L18:
        if (r14.hasNext() == false) goto L24;
        ((an.c) r14.next()).h();
        goto L18
    L24:
        return;
    L23:
        return;
    }

    public void onBeforeAnimation(int r5, int r10, int r11, int r12, int r13, int r14, int r15, int r16) {
    }

    public void onBorderRadiusUpdated(int r5) {
    }

    public void onDetach() {
        com.lynx.tasm.behavior.ui.utils.g r5 = this.mLynxBackground;
        if (r5 == null) goto L5;
        r5.f();
    L5:
        com.lynx.tasm.behavior.ui.utils.i r10 = this.mLynxMask;
        if (r10 == null) goto L9;
        r10.f();
        return;
    }

    public void onDrawingPositionChanged() {
    }

    @Override // wm.a
    public void onEventBubble(boolean r5, long r10) {
        if (r5 == false) goto L9;
        if (getRootLynxPageUI() == null) goto L14;
        getRootLynxPageUI().startEventFire(false, r10);
        return;
    L14:
        return;
    L9:
        if (getParentLynxPageUI() == null) goto L12;
        getParentLynxPageUI().startEventBubble(r10);
        return;
    L12:
        startEventFire(false, r10);
    }

    @Override // wm.a
    public void onEventCapture(boolean r5, long r10) {
        if (r5 == false) goto L8;
        if (getRootLynxPageUI() == null) goto L24;
        getRootLynxPageUI().startEventFire(false, r10);
        return;
    L24:
        return;
    L8:
        if (getChildrenLynxPageUI() == null) goto L10;
        LynxBaseUI r11 = (LynxBaseUI) getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this)));
    L11:
        if (r11 != null) goto L13;
        startEventBubble(r10);
        return;
    L13:
        if (r11.getLynxContext() != null) goto L15;
        return;
    L15:
        if (r11.getLynxContext().g == null) goto L26;
        com.lynx.tasm.i r12 = r11.getLynxContext().g.e;
        if (r12 == null) goto L27;
        LynxEngineProxy r13 = (LynxEngineProxy) r12.f10879a;
        if (r13 == null) goto L28;
        com.lynx.tasm.utils.j.f(new mn.a(r13, r10, 0));
        return;
    L28:
        return;
    L27:
        return;
    L26:
        return;
    L10:
        r11 = null;
        goto L11
    }

    @Override // wm.a
    public void onEventFire(boolean r5, long r10) {
        if (getChildrenLynxPageUI() == null) goto L5;
        LynxBaseUI r11 = (LynxBaseUI) getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this)));
    L6:
        if (r11 != null) goto L8;
        return;
    L8:
        if (r11.getLynxContext() != null) goto L10;
        return;
    L10:
        if (r11.getLynxContext().g == null) goto L19;
        com.lynx.tasm.i r12 = r11.getLynxContext().g.e;
        if (r12 == null) goto L20;
        LynxEngineProxy r13 = (LynxEngineProxy) r12.f10879a;
        if (r13 == null) goto L21;
        com.lynx.tasm.utils.j.f(new mn.b(r13, r5, r10));
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r11 = null;
        goto L6
    }

    public void onFocusChanged(boolean r5, boolean r10) {
    }

    @Deprecated
    public void onLayoutFinish(long r5) {
    }

    public void onLayoutUpdated() {
        if (this.mSkipLayoutUpdated == false) goto L5;
        return;
    L5:
        com.lynx.tasm.behavior.ui.utils.g r5 = this.mLynxBackground;
        if (r5 == null) goto L10;
        float r10 = this.mPaddingTop;
        float r11 = this.mPaddingRight;
        float r12 = this.mPaddingBottom;
        float r13 = this.mPaddingLeft;
        com.lynx.tasm.behavior.ui.utils.f r14 = r5.f10750b;
        if (r14 == null) goto L10;
        r14.c(r10, r11, r12, r13);
    L10:
        com.lynx.tasm.behavior.ui.utils.i r15 = this.mLynxMask;
        if (r15 == null) goto L15;
        float r16 = this.mPaddingTop;
        float r17 = this.mPaddingRight;
        float r18 = this.mPaddingBottom;
        float r19 = this.mPaddingLeft;
        com.lynx.tasm.behavior.ui.utils.f r20 = r15.f10750b;
        if (r20 == null) goto L15;
        r20.c(r16, r17, r18, r19);
    L15:
        invalidate();
        requestLayout();
    }

    public void onListCellAppear(String r5, LynxBaseUI r10) {
        if (this.mBlockListEvent == true) goto L9;
        Iterator<LynxBaseUI> r11 = this.mChildren.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        r11.next().onListCellAppear(r5, r10);
        goto L7
    L11:
        return;
    }

    public void onListCellDisAppear(String r5, LynxBaseUI r10, boolean r11) {
        if (this.mBlockListEvent == true) goto L9;
        Iterator<LynxBaseUI> r12 = this.mChildren.iterator();
    L7:
        if (r12.hasNext() == false) goto L11;
        r12.next().onListCellDisAppear(r5, r10, r11);
        goto L7
    L11:
        return;
    }

    public void onListCellPrepareForReuse(String r5, LynxBaseUI r10) {
        if (this.mBlockListEvent == true) goto L9;
        Iterator<LynxBaseUI> r11 = this.mChildren.iterator();
    L7:
        if (r11.hasNext() == false) goto L11;
        r11.next().onListCellPrepareForReuse(r5, r10);
        goto L7
    L11:
        return;
    }

    public void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
    }

    public void onNodeReload() {
    }

    @CallSuper
    public void onNodeRemoved() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onPropsUpdated() {
        LynxContext r5 = this.mContext;
        if (r5 == null) goto L21;
        if (getEvents() == null) goto L15;
        if (getEvents().containsKey("uiappear") == true) goto L11;
        if (getEvents().containsKey("uidisappear") == false) goto L15;
    L11:
        if (r5.f10155x != null) goto L13;
        r5.m();
    L13:
        JavaOnlyMap r10 = new JavaOnlyMap();
        r10.put("sendCustom", Boolean.TRUE);
        r5.f10155x.i(this, String.valueOf(getSign()), r10);
    L15:
        if (getExposureID() == null) goto L21;
        if (r5.f10155x != null) goto L19;
        r5.m();
    L19:
        r5.f10155x.i(this, null, null);
    L21:
        if (this.mGestureHandlers != null) goto L23;
        return;
    L23:
        if ((this instanceof rn.a) == false) goto L67;
        sn.a r11 = getGestureArenaManager();
        if (r11 == null) goto L68;
        int r12 = getGestureArenaMemberId();
        int r13 = 0;
        if (r11.f == false) goto L32;
        HashMap r14 = r11.f21956a;
        if (r14 == null) goto L32;
        boolean r15 = r14.containsKey(Integer.valueOf(r12));
    L33:
        if (r15 == true) goto L69;
        rn.a r16 = (rn.a) this;
        if (r11.f == false) goto L59;
        HashMap r17 = r11.f21956a;
        if (r17 == null) goto L59;
        r17.put(Integer.valueOf(r16.getSign()), new WeakReference(r16));
        int r18 = r16.getSign();
        Map r19 = r16.getGestureDetectorMap();
        if (r11.f == false) goto L58;
        if (r19 == null) goto L58;
        if (r19.isEmpty() == true) goto L58;
        if (r11.e == null) goto L58;
        Iterator r20 = r19.entrySet().iterator();
    L50:
        if (r20.hasNext() == false) goto L58;
        un.a r21 = (un.a) ((Map.Entry) r20.next()).getValue();
        s6.c r22 = r11.e;
        r22.getClass();
        if (r21 == null) goto L50;
        HashMap r23 = (HashMap) r22.f21828b;
        int r24 = r21.f22417a;
        if (r23.get(Integer.valueOf(r24)) != null) goto L57;
        r23.put(Integer.valueOf(r24), new HashSet());
    L57:
        ((Set) r23.get(Integer.valueOf(r24))).add(Integer.valueOf(r18));
    L58:
        r13 = r16.getSign();
    L59:
        this.mGestureArenaMemberId = r13;
        return;
    L69:
        return;
    L32:
        r15 = false;
        goto L33
    L68:
        return;
    }

    @Override // wm.a
    public void onPseudoStatusChanged(int r5, int r10) {
        this.mPseudoStatus = r10;
    }

    @Override // wm.a
    public void onResponseChain() {
        this.mOnResponseChain = true;
    }

    @Override // wm.a
    public wm.a parent() {
        a0 r5 = this.mParent;
        if ((r5 instanceof wm.a) == true) goto L5;
        return null;
    L5:
        return (wm.a) r5;
    }

    public wm.b parentResponder() {
        a0 r5 = this.mParent;
        if ((r5 instanceof wm.b) == true) goto L5;
        return null;
    L5:
        return (wm.b) r5;
    }

    public EventTarget$PointerEventsValue pointerEvents() {
        Log.d("hxh-debug", "pointerevents");
        EventTarget$PointerEventsValue r5 = this.mPointerEvents;
        if (r5 == EventTarget$PointerEventsValue.f10249c) goto L6;
        return r5;
    L6:
        if (parent() == null) goto L10;
        return parent().pointerEvents();
    L10:
        return EventTarget$PointerEventsValue.f10247a;
    }

    public void recognizeGesturere() {
        LynxContext r5 = this.mContext;
        if (r5 == null) goto L10;
        a1 r10 = r5.f10140h;
        if (r10 == null) goto L11;
        HashSet r11 = r10.s;
        if (r11 == null) goto L12;
        r11.add(Integer.valueOf(getSign()));
        return;
    L12:
        return;
    L11:
        return;
    }

    public void registerScrollStateListener(q r5) {
        if (r5 == null) goto L23;
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L6:
        if (this.mStateChangeListeners != null) goto L10;
        this.mStateChangeListeners = new HashSet();     // Catch: Throwable -> L8
    L10:
        this.mStateChangeListeners.add(r5);     // Catch: Throwable -> L8
        if (this.mStateChangeListeners.size() == 1) goto L14;
        monitor-exit(this);     // Catch: Throwable -> L8
        return;
    L14:
        monitor-exit(this);     // Catch: Throwable -> L8
        f();
        a0 r10 = getParent();
        if ((r10 instanceof LynxBaseUI) == false) goto L22;
        ((LynxBaseUI) r10).registerScrollStateListener(this.mScrollStateChangeListener);
        return;
    L22:
        return;
    }

    public void registerViewAccordingToNodeIndex() {
    }

    public void removeChild(LynxBaseUI r5) {
        this.mChildren.remove(r5);
        r5.setParent(null);
    }

    public void removeChildrenExposureUI() {
    }

    public void removeKeyFromNativeStorage(String r5) {
    }

    public void renderIfNeeded() {
    }

    @com.lynx.tasm.behavior.f0
    public void requestAccessibilityFocus(ReadableMap r10, Callback r11) {
        if (this.mContext.j() == null) goto L54;
        com.lynx.tasm.behavior.ui.accessibility.d r12 = this.mContext.j();
        if (r12.h() == true) goto L9;
        r11.invoke(new Object[]{1, "System accessibility is disable!"});
        return;
    L9:
        if (r12.g() == false) goto L20;
        com.lynx.tasm.t r5 = r12.f10414n;
        r5.getClass();
        if ((this instanceof LynxUI) == false) goto L20;
        LynxUI r13 = (LynxUI) this;
        if (r13.getView() == null) goto L20;
        if (r5.e(this) == false) goto L20;
        r13.getView().sendAccessibilityEvent(128);
    L48:
        r11.invoke(new Object[]{0, "Accessibility element on focused"});
        return;
    L20:
        if (r12.f() == false) goto L50;
        LynxAccessibilityDelegate r14 = r12.f10413m;
        UIGroup r15 = r14.f10394a;
        if (r15 != null) goto L24;
    L26:
        com.lynx.tasm.behavior.ui.accessibility.d r16 = null;
    L27:
        if (r16 == null) goto L29;
        boolean r17 = r16.h();
    L30:
        if (r17 == true) goto L32;
    L46:
        boolean r18 = false;
    L47:
        if (r18 == false) goto L50;
    L32:
        if (r14.e.g(this) == false) goto L46;
        LynxNodeProvider r19 = r14.e;
        ArrayList r20 = r19.g;
        if (r20 != null) goto L37;
    L36:
        int r21 = -1;
    L43:
        if (r21 == (-1)) goto L46;
        r18 = r14.b(r21);
        goto L47
    L37:
        r21 = r20.size() - 1;
    L38:
        if (r21 < 0) goto L36;
        if (((com.lynx.tasm.behavior.ui.accessibility.f) r19.g.get(r21)).f10418a == this) goto L43;
        r21 = r21 - 1;
        goto L38
    L29:
        r17 = false;
        goto L30
    L24:
        if (r15.getLynxContext() == null) goto L26;
        r16 = r14.f10394a.getLynxContext().j();
    L50:
        r11.invoke(new Object[]{1, "Request accessibility focus fail!"});
        return;
    }

    public boolean requestChildUIRectangleOnScreen(LynxBaseUI r5, Rect r10, boolean r11) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.a0
    public void requestLayout() {
    }

    @com.lynx.tasm.behavior.f0
    public void requestUIInfo(ReadableMap r10, Callback r11) {
        ArrayList r5 = new ArrayList();
        if (r10 == null) goto L10;
        ReadableMapKeySetIterator r12 = r10.keySetIterator();
    L6:
        if (r12.hasNextKey() == false) goto L10;
        String r13 = r12.nextKey();
        if (r10.getBoolean(r13, false) == false) goto L6;
        r5.add(r13);
    L10:
        if (r10 != null) goto L12;
    L14:
        boolean r14 = false;
    L15:
        JavaOnlyMap r15 = a(r14);
        JavaOnlyMap r16 = new JavaOnlyMap();
        if (r5.contains("id") == false) goto L19;
        r16.put("id", getIdSelector());
    L19:
        if (r5.contains("dataset") == false) goto L22;
        r16.put("dataset", getDataset());
    L22:
        if (r5.contains(SVGRenderEngine.RECT) == false) goto L25;
        r16.put(OpenPageMethod.ALIGN_LEFT, r15.get(OpenPageMethod.ALIGN_LEFT));
        r16.put("top", r15.get("top"));
        r16.put("right", r15.get("right"));
        r16.put("bottom", r15.get("bottom"));
    L25:
        if (r5.contains("size") == false) goto L28;
        r16.put("width", r15.get("width"));
        r16.put("height", r15.get("height"));
    L28:
        if (r5.contains("scrollOffset") == false) goto L31;
        float r17 = getLynxContext().f10152u.density;
        r16.put("scrollLeft", Float.valueOf(getScrollX() / r17));
        r16.put("scrollTop", Float.valueOf(getScrollY() / r17));
    L31:
        if (r5.contains("node") == false) goto L33;
        r16.put("node", new JavaOnlyMap());
    L33:
        r11.invoke(new Object[]{0, r16});
        return;
    L12:
        if (r10.getBoolean("androidEnableTransformProps", false) == false) goto L14;
        r14 = true;
        goto L15
    }

    public float[] scrollBy(float r5, float r10) {
        return new float[]{0.0f, 0.0f, r5, r10};
    }

    @Deprecated
    public void scrollIntoView(ReadableMap r5) {
        scrollIntoView(r5, null);
    }

    @com.lynx.tasm.behavior.c0(name = "a11y-id")
    public void setA11yId(@Nullable pm.a r5) {
        if (r5 != null) goto L4;
    L6:
        String r10 = "";
    L7:
        this.mAccessibilityId = r10;
        return;
    L4:
        if (ReadableType.String != r5.getType()) goto L6;
        r10 = r5.asString();
        goto L7
    }

    @com.lynx.tasm.behavior.c0(name = "accessibility-actions")
    public void setAccessibilityActions(ReadableArray r5) {
        this.mAccessibilityActions = r5.asArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    @com.lynx.tasm.behavior.c0(name = "accessibility-element")
    public void setAccessibilityElement(@Nullable pm.a r5) {
        ?? r10 = 1;
        r10 = 1;
        r10 = 1;
        if (r5 == null) goto L21;
        ReadableType r11 = r5.getType();
        if (r11 != ReadableType.String) goto L8;
        r10 = Boolean.parseBoolean(r5.asString());
        goto L21
    L8:
        if (r11 == ReadableType.Int) goto L18;
        if (r11 == ReadableType.Number) goto L18;
        if (r11 == ReadableType.Long) goto L18;
        if (r11 != ReadableType.Boolean) goto L21;
        r10 = r5.asBoolean();
    L18:
        if (r5.asInt() != 0) goto L21;
        r10 = 0;
    L21:
        this.mAccessibilityElementStatus = r10;
    }

    @com.lynx.tasm.behavior.c0(name = "accessibility-elements")
    public void setAccessibilityElements(@Nullable pm.a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getType() != ReadableType.String) goto L21;
        String[] r10 = r5.asString().split(",");
        if (r10.length > 0) goto L8;
        return;
    L8:
        if (this.mAccessibilityElements != null) goto L10;
        this.mAccessibilityElements = new ArrayList();
    L10:
        this.mAccessibilityElements.clear();
        int r11 = r10.length;
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L13;
        String r13 = r10[r12];
        this.mAccessibilityElements.add(r13);
        r12 = r12 + 1;
        goto L11
    L13:
        com.lynx.tasm.behavior.ui.accessibility.d r14 = this.mContext.j();
        if (r14 != null) goto L16;
        return;
    L16:
        if (r14.g() == false) goto L24;
        ((ArrayList) r14.f10414n.d).add(new WeakReference(this));
        return;
    L24:
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "accessibility-elements-a11y")
    public void setAccessibilityElementsA11y(@Nullable pm.a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getType() != ReadableType.String) goto L21;
        String[] r10 = r5.asString().split(",");
        if (r10.length > 0) goto L8;
        return;
    L8:
        if (this.mAccessibilityElementsA11y != null) goto L10;
        this.mAccessibilityElementsA11y = new ArrayList();
    L10:
        this.mAccessibilityElementsA11y.clear();
        int r11 = r10.length;
        int r12 = 0;
    L11:
        if (r12 >= r11) goto L13;
        String r13 = r10[r12];
        this.mAccessibilityElementsA11y.add(r13);
        r12 = r12 + 1;
        goto L11
    L13:
        com.lynx.tasm.behavior.ui.accessibility.d r14 = this.mContext.j();
        if (r14 != null) goto L16;
        return;
    L16:
        if (r14.g() == false) goto L24;
        ((ArrayList) r14.f10414n.e).add(new WeakReference(this));
        return;
    L24:
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "accessibility-enable-tap")
    public void setAccessibilityEnableTap(@Nullable pm.a r5) {
        if (r5 == null) goto L9;
        ReadableType r10 = r5.getType();
        if (r10 != ReadableType.String) goto L7;
        boolean r11 = Boolean.parseBoolean(r5.asString());
    L10:
        this.mAccessibilityEnableTap = r11;
        return;
    L7:
        if (r10 != ReadableType.Boolean) goto L9;
        r11 = r5.asBoolean();
    L9:
        r11 = false;
        goto L10
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "accessibility-exclusive-focus")
    public void setAccessibilityExclusiveFocus(boolean r5) {
        com.lynx.tasm.behavior.ui.accessibility.d r10 = this.mContext.j();
        if (r10 == null) goto L6;
        r10.b(this, r5);
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "accessibility-heading")
    public void setAccessibilityHeading(boolean r5) {
    }

    @com.lynx.tasm.behavior.c0(name = "android-accessibility-keep-focused")
    public void setAccessibilityKeepFocused(@Nullable pm.a r5) {
        if (r5 == null) goto L9;
        ReadableType r10 = r5.getType();
        if (r10 != ReadableType.String) goto L7;
        boolean r11 = Boolean.parseBoolean(r5.asString());
    L10:
        this.mAccessibilityKeepFocused = r11;
        return;
    L7:
        if (r10 != ReadableType.Boolean) goto L9;
        r11 = r5.asBoolean();
    L9:
        r11 = false;
        goto L10
    }

    @com.lynx.tasm.behavior.c0(name = "accessibility-label")
    public void setAccessibilityLabel(@Nullable pm.a r5) {
        if (r5 == null) goto L17;
        ReadableType r10 = r5.getType();
        if (r10 != ReadableType.String) goto L7;
        String r11 = r5.asString();
    L18:
        this.mAccessibilityLabel = r11;
        return;
    L7:
        if (r10 != ReadableType.Int) goto L9;
    L16:
        r11 = String.valueOf(r5.asInt());
        goto L18
    L9:
        if (r10 == ReadableType.Number) goto L16;
        if (r10 == ReadableType.Long) goto L16;
        if (r10 != ReadableType.Boolean) goto L17;
        r11 = String.valueOf(r5.asBoolean());
    L17:
        r11 = "";
        goto L18
    }

    @com.lynx.tasm.behavior.c0(name = "accessibility-role-description")
    public void setAccessibilityRoleDescription(@Nullable pm.a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getType() != ReadableType.String) goto L8;
        this.mAccessibilityRoleDescription = r5.asString();
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "accessibility-status")
    public void setAccessibilityStatus(@Nullable pm.a r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getType() != ReadableType.String) goto L8;
        this.mAccessibilityStatus = r5.asString();
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "accessibility-traits")
    public void setAccessibilityTraits(@Nullable pm.a r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.getType() != ReadableType.String) goto L19;
        String r11 = r10.asString();
        if (r11 == null) goto L13;
        LynxAccessibilityHelper$LynxAccessibilityTraits[] r5 = LynxAccessibilityHelper$LynxAccessibilityTraits.values();
        int r12 = r5.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L13;
        LynxAccessibilityHelper$LynxAccessibilityTraits r14 = r5[r13];
        if (r14.name().equalsIgnoreCase(r11) == true) goto L14;
        r13 = r13 + 1;
    L14:
        this.mAccessibilityTraits = r14;
        return;
    L13:
        r14 = LynxAccessibilityHelper$LynxAccessibilityTraits.f10397a;
        goto L14
    }

    @com.lynx.tasm.behavior.c0(name = "accessibility-value")
    public void setAccessibilityValue(String r5) {
    }

    public void setAlpha(float r5) {
        this.mAlpha = r5;
    }

    public void setAnimation(@Nullable ReadableArray r5) {
    }

    @com.lynx.tasm.behavior.c0(name = "background-clip")
    public void setBackgroundClip(@Nullable ReadableArray r5) {
        d();
        this.mLynxBackground.c(r5);
    }

    @com.lynx.tasm.behavior.c0(defaultInt = 0, name = "background-color")
    public void setBackgroundColor(int r5) {
        this.mBackgroundColor = r5;
        if (getKeyframeManager() == null) goto L6;
        getKeyframeManager().b("BackgroundColor", Integer.valueOf(r5));
    L6:
        if (getTransitionAnimator() == null) goto L13;
        vm.i r10 = getTransitionAnimator();
        if (r10.f22605j.size() == 0) goto L13;
        if (r10.f22605j.get(64) == null) goto L13;
        getTransitionAnimator().c(this, 64, Integer.valueOf(r5));
        return;
    L13:
        d();
        com.lynx.tasm.behavior.ui.utils.g r11 = this.mLynxBackground;
        r11.e = r5;
        if (r5 == 0) goto L16;
    L18:
        ((BackgroundDrawable) r11.d()).setColor(r5);
    L19:
        invalidate();
        return;
    L16:
        if (r11.f10750b != null) goto L18;
        goto L18
    }

    @com.lynx.tasm.behavior.c0(name = "background-image")
    public void setBackgroundImage(@Nullable ReadableArray r5) {
        d();
        this.mLynxBackground.d().e.b(r5, this);
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(name = "background-origin")
    public void setBackgroundOrigin(@Nullable ReadableArray r5) {
        d();
        this.mLynxBackground.e(r5);
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(name = "background-position")
    public void setBackgroundPosition(@Nullable ReadableArray r5) {
        d();
        this.mLynxBackground.g(r5);
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(name = "background-repeat")
    public void setBackgroundRepeat(@Nullable ReadableArray r5) {
        d();
        this.mLynxBackground.h(r5);
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(name = "background-size")
    public void setBackgroundSize(@Nullable ReadableArray r5) {
        d();
        this.mLynxBackground.i(r5);
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "block-list-event")
    public void setBlockListEvent(boolean r5) {
        this.mBlockListEvent = r5;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "block-native-event")
    public void setBlockNativeEvent(boolean r5) {
        this.mBlockNativeEvent = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "block-native-event-areas")
    public void setBlockNativeEventAreas(@Nullable pm.a r11) {
        this.mBlockNativeEventAreas = null;
        if (r11 != null) goto L5;
    L32:
        LynxLog.b(3, TAG, "setBlockNativeEventAreas input type error");
        return;
    L5:
        if (r11.getType() != ReadableType.Array) goto L32;
        if (r11.asArray() == null) goto L32;
        ReadableArray r12 = r11.asArray();
        ArrayList<ArrayList<com.lynx.tasm.utils.i>> r5 = new ArrayList();
        int r10 = 0;
    L11:
        if (r10 >= r12.size()) goto L27;
        ReadableArray r13 = r12.getArray(r10);
        if (r13 != null) goto L15;
    L24:
        LynxLog.b(3, TAG, "setBlockNativeEventAreas " + r10 + "th type error, size != 4");
    L25:
        r10 = r10 + 1;
        goto L11
    L15:
        if (r13.size() != 4) goto L24;
        com.lynx.tasm.utils.i r14 = com.lynx.tasm.utils.i.b(r13.getString(0));
        com.lynx.tasm.utils.i r15 = com.lynx.tasm.utils.i.b(r13.getString(1));
        com.lynx.tasm.utils.i r16 = com.lynx.tasm.utils.i.b(r13.getString(2));
        com.lynx.tasm.utils.i r17 = com.lynx.tasm.utils.i.b(r13.getString(3));
        if (r14 == null) goto L23;
        if (r15 == null) goto L23;
        if (r16 == null) goto L23;
        if (r17 == null) goto L23;
        ArrayList<com.lynx.tasm.utils.i> r18 = new ArrayList();
        r18.add(r14);
        r18.add(r15);
        r18.add(r16);
        r18.add(r17);
        r5.add(r18);
    L23:
        LynxLog.b(3, TAG, "setBlockNativeEventAreas " + r10 + "th type error");
        goto L25
    L27:
        if (r5.size() <= 0) goto L30;
        this.mBlockNativeEventAreas = r5;
        return;
    L30:
        LynxLog.b(3, TAG, "setBlockNativeEventAreas empty areas");
    }

    @Deprecated
    public void setBorderColor(@Nullable String r5) {
        new RuntimeException("setBorderColor(String) is deprecated.This has no effect.");
    }

    @Deprecated
    public void setBorderRadius(int r5, @Nullable String r10) {
        new RuntimeException("setBorderWidth(int, String) is deprecated.This has no effect.");
    }

    @com.lynx.tasm.behavior.d0(defaultInt = -1, names = {"border-style", "border-left-style", "border-right-style", "border-top-style", "border-bottom-style"})
    public void setBorderStyle(int r5, int r10) {
        d();
        this.mLynxBackground.j(SPACING_TYPES[r5], r10);
    }

    @Deprecated
    public void setBorderWidth(int r5, String r10) {
        new RuntimeException("setBorderWidth(int, String) is deprecated.This has no effect.");
    }

    public void setBound(Rect r5) {
        this.mBound = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "box-shadow")
    public void setBoxShadow(@Nullable ReadableArray r5) {
        a0 r10 = this.mParent;
        if ((r10 instanceof UIShadowProxy) == false) goto L6;
        ((UIShadowProxy) r10).setBoxShadow(r5);
        return;
    }

    @com.lynx.tasm.behavior.c0(defaultFloat = 1.0f, name = "position")
    public final void setCSSPosition(int r5) {
        this.mCSSPosition = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "caret-color")
    public void setCaretColor(@Nullable String r5) {
    }

    public void setChildrenLynxPageUI(HashMap<String, wm.a> r5) {
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L9;
        UIBody r11 = r10.f10145m;
        if (r11 == null) goto L10;
        r11.f10387c = r5;
        return;
    L10:
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "clip-radius")
    public void setClipToRadius(@Nullable pm.a r5) {
        if (r5 == null) goto L20;
        ReadableType r10 = r5.getType();
        if (r10 != ReadableType.Boolean) goto L9;
        this.mClipToRadius = r5.asBoolean();
        return;
    L9:
        if (r10 != ReadableType.String) goto L19;
        String r11 = r5.asString();
        if (r11.equalsIgnoreCase("true") == false) goto L13;
    L16:
        boolean r12 = true;
    L17:
        this.mClipToRadius = r12;
        return;
    L13:
        if (r11.equalsIgnoreCase("yes") == true) goto L16;
        r12 = false;
        goto L17
    L19:
        return;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "android-consume-hover-event")
    public void setConsumeHoverEvent(boolean r5) {
        com.lynx.tasm.behavior.ui.accessibility.d r10 = this.mContext.j();
        if (r10 != null) goto L5;
        return;
    L5:
        if (r10.g() == false) goto L9;
        this.mConsumeHoverEvent = r5;
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "consume-slide-event")
    public void setConsumeSlideEvent(@Nullable ReadableArray r10) {
        if (r10 != null) goto L21;
        this.mConsumeSlideEventAngles = null;
        return;
    L21:
        ArrayList<Object> r11 = r10.toArrayList();     // Catch: Throwable -> L18
        this.mConsumeSlideEventAngles = new ArrayList();     // Catch: Throwable -> L18
        Iterator<Object> r12 = r11.iterator();     // Catch: Throwable -> L18
    L7:
        if (r12.hasNext() == false) goto L34;
        Object r5 = r12.next();     // Catch: Throwable -> L18
        if ((r5 instanceof ArrayList) == false) goto L7;
        if (((ArrayList) r5).size() != 2) goto L7;
        if ((((ArrayList) r5).get(0) instanceof Number) == false) goto L7;
        if ((((ArrayList) r5).get(1) instanceof Number) == false) goto L7;
        ArrayList<Float> r13 = new ArrayList();     // Catch: Throwable -> L18
        r13.add(Float.valueOf(((Number) ((ArrayList) r5).get(0)).floatValue()));     // Catch: Throwable -> L18
        r13.add(Float.valueOf(((Number) ((ArrayList) r5).get(1)).floatValue()));     // Catch: Throwable -> L18
        this.mConsumeSlideEventAngles.add(r13);     // Catch: Throwable -> L18
        goto L7
    L34:
        return;
    L18:
        th = move-exception;
        LynxLog.b(4, TAG, "setConsumeSlideEvent failed since " + th.getMessage());
    }

    @com.lynx.tasm.behavior.c0(name = "dataset")
    public void setDataset(@Nullable ReadableMap r5) {
        this.mDataset = r5;
    }

    public void setDrawParent(a0 r5) {
        this.mDrawParent = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "bitmap-gradient")
    public void setEnableBitmapGradient(boolean r5) {
        this.mEnableBitmapGradient = r5;
        com.lynx.tasm.behavior.ui.utils.f r10 = this.mLynxBackground.d();
        r10.e.f349j = r5;
        r10.invalidateSelf();
        com.lynx.tasm.behavior.ui.utils.i r11 = this.mLynxMask;
        if (r11 == null) goto L5;
        com.lynx.tasm.behavior.ui.utils.f r12 = r11.d();
        r12.e.f349j = r5;
        r12.invalidateSelf();
    L5:
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(name = "enable-exposure-ui-clip")
    public void setEnableExposureUIClip(boolean r5) {
        if (r5 == false) goto L4;
        EventTarget$EnableStatus r10 = EventTarget$EnableStatus.f10244a;
    L5:
        this.mEnableExposureUIClip = r10;
        return;
    L4:
        r10 = EventTarget$EnableStatus.f10245b;
        goto L5
    }

    @com.lynx.tasm.behavior.c0(name = "enable-exposure-ui-margin")
    public void setEnableExposureUIMargin(boolean r5) {
        this.mEnableExposureUIMargin = Boolean.valueOf(r5);
    }

    @com.lynx.tasm.behavior.c0(name = "enable-scroll-monitor")
    public void setEnableScrollMonitor(@Nullable boolean r5) {
        this.mEnableScrollMonitor = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "enable-touch-pseudo-propagation")
    public void setEnableTouchPseudoPropagation(@Nullable pm.a r5) {
        if (r5 != null) goto L11;
        this.mEnableTouchPseudoPropagation = true;
        return;
    L11:
        this.mEnableTouchPseudoPropagation = r5.asBoolean();     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        LynxLog.b(2, TAG, th.toString());
        this.mEnableTouchPseudoPropagation = true;
    }

    @Override // wm.a
    public void setEventID(long r5) {
        if (getChildrenLynxPageUI() == null) goto L16;
        LynxBaseUI r10 = (LynxBaseUI) getChildrenLynxPageUI().get(String.valueOf(System.identityHashCode(this)));
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.getLynxContext() != null) goto L10;
        return;
    L10:
        if (r10.getLynxContext().g == null) goto L15;
        r10.getLynxContext().g.f10939a = r5;
        return;
    L15:
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "event-through")
    public void setEventThrough(@Nullable pm.a r5) {
        if (r5 != null) goto L15;
        this.mEventThrough = EventTarget$EnableStatus.f10246c;
        return;
    L15:
    L8:
        th = move-exception;
        LynxLog.b(2, TAG, th.toString());
        this.mEventThrough = EventTarget$EnableStatus.f10246c;
        return;
    L6:
        if (r5.asBoolean() == false) goto L10;
        EventTarget$EnableStatus r10 = EventTarget$EnableStatus.f10244a;     // Catch: Throwable -> L8
    L11:
        this.mEventThrough = r10;     // Catch: Throwable -> L8
        return;
    L10:
        r10 = EventTarget$EnableStatus.f10245b;     // Catch: Throwable -> L8
        goto L11
    }

    @com.lynx.tasm.behavior.c0(name = "event-through-active-regions")
    public void setEventThroughActiveRegions(@Nullable pm.a r11) {
        this.mEventThroughActiveRegions = null;
        if (r11 != null) goto L5;
    L32:
        LynxLog.b(3, TAG, "setEventThroughActiveRegions input type error");
        return;
    L5:
        if (r11.getType() != ReadableType.Array) goto L32;
        if (r11.asArray() == null) goto L32;
        ReadableArray r12 = r11.asArray();
        ArrayList<ArrayList<com.lynx.tasm.utils.i>> r5 = new ArrayList();
        int r10 = 0;
    L11:
        if (r10 >= r12.size()) goto L27;
        ReadableArray r13 = r12.getArray(r10);
        if (r13 != null) goto L15;
    L24:
        LynxLog.b(3, TAG, "setEventThroughActiveRegions " + r10 + "th type error, size != 4");
    L25:
        r10 = r10 + 1;
        goto L11
    L15:
        if (r13.size() != 4) goto L24;
        com.lynx.tasm.utils.i r14 = com.lynx.tasm.utils.i.b(r13.getString(0));
        com.lynx.tasm.utils.i r15 = com.lynx.tasm.utils.i.b(r13.getString(1));
        com.lynx.tasm.utils.i r16 = com.lynx.tasm.utils.i.b(r13.getString(2));
        com.lynx.tasm.utils.i r17 = com.lynx.tasm.utils.i.b(r13.getString(3));
        if (r14 == null) goto L23;
        if (r15 == null) goto L23;
        if (r16 == null) goto L23;
        if (r17 == null) goto L23;
        ArrayList<com.lynx.tasm.utils.i> r18 = new ArrayList();
        r18.add(r14);
        r18.add(r15);
        r18.add(r16);
        r18.add(r17);
        r5.add(r18);
    L23:
        LynxLog.b(3, TAG, "setEventThroughActiveRegions " + r10 + "th type error");
        goto L25
    L27:
        if (r5.size() <= 0) goto L30;
        this.mEventThroughActiveRegions = r5;
        return;
    L30:
        LynxLog.b(3, TAG, "setEventThroughActiveRegions empty regions");
    }

    public void setEvents(Map<String, on.a> r5) {
        this.mEvents = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "exposure-area")
    public void setExposureArea(String r5) {
        this.mExposureArea = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "exposure-id")
    public void setExposureID(pm.a r5) {
        this.mContext.c(this);
        String r10 = r5.asString();
        if (r10 != null) goto L5;
    L9:
        this.mExposureID = null;
        LynxLog.b(4, TAG, "setExposureID(Dynamic exposureID) failed, since it is not number/string, or it is empty string");
        new RuntimeException("setExposureID(Dynamic exposureID) failed, since it is not number/string, or it is empty string");
        return;
    L5:
        if (r10.isEmpty() == true) goto L9;
        this.mExposureID = r10;
    }

    @com.lynx.tasm.behavior.c0(name = "exposure-scene")
    public void setExposureScene(String r5) {
        this.mContext.c(this);
        this.mExposureScene = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "exposure-screen-margin-bottom")
    public void setExposureScreenMarginBottom(String r5) {
        this.mExposureScreenMarginBottom = com.lynx.tasm.utils.k.b(r5);
    }

    @com.lynx.tasm.behavior.c0(name = "exposure-screen-margin-left")
    public void setExposureScreenMarginLeft(String r5) {
        this.mExposureScreenMarginLeft = com.lynx.tasm.utils.k.b(r5);
    }

    @com.lynx.tasm.behavior.c0(name = "exposure-screen-margin-right")
    public void setExposureScreenMarginRight(String r5) {
        this.mExposureScreenMarginRight = com.lynx.tasm.utils.k.b(r5);
    }

    @com.lynx.tasm.behavior.c0(name = "exposure-screen-margin-top")
    public void setExposureScreenMarginTop(String r5) {
        this.mExposureScreenMarginTop = com.lynx.tasm.utils.k.b(r5);
    }

    @com.lynx.tasm.behavior.c0(name = "exposure-ui-margin-bottom")
    public void setExposureUIMarginBottom(String r5) {
        this.mExposureUIMarginBottom = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "exposure-ui-margin-left")
    public void setExposureUIMarginLeft(String r5) {
        this.mExposureUIMarginLeft = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "exposure-ui-margin-right")
    public void setExposureUIMarginRight(String r5) {
        this.mExposureUIMarginRight = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "exposure-ui-margin-top")
    public void setExposureUIMarginTop(String r5) {
        this.mExposureUIMarginTop = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "focusable")
    public void setFocusable(Boolean r5) {
        if (r5 == null) goto L4;
        boolean r10 = r5.booleanValue();
    L5:
        this.mFocusable = r10;
        return;
    L4:
        r10 = false;
        goto L5
    }

    @com.lynx.tasm.behavior.c0(defaultFloat = 1.0E21f, name = "font-size")
    public void setFontSize(float r5) {
        if (r5 == 1.0E21f) goto L8;
        d();
        this.mFontSize = r5;
        this.mLynxBackground.d = r5;
        com.lynx.tasm.behavior.ui.utils.i r10 = this.mLynxMask;
        if (r10 == null) goto L9;
        r10.d = r5;
        return;
    L9:
        return;
    }

    @Override // rn.b
    public void setGestureDetectorState(int r5, int r10) {
        if (isEnableNewGesture() == false) goto L46;
        sn.a r11 = getGestureArenaManager();
        if (r11 == null) goto L47;
        int r12 = getGestureArenaMemberId();
        if (r11.f == true) goto L11;
        return;
    L11:
        if (r11.f21959h == null) goto L43;
        HashMap r13 = r11.f21956a;
        if (r13 == null) goto L48;
        WeakReference r14 = (WeakReference) r13.get(Integer.valueOf(r12));
        vn.d r15 = r11.f21959h;
        rn.a r16 = (rn.a) r14.get();
        r15.getClass();
        if (r16 == null) goto L49;
        Map r17 = r16.getGestureHandlers();
        if (r17 == null) goto L27;
        Iterator r18 = r17.values().iterator();
    L23:
        if (r18.hasNext() == false) goto L27;
        vn.a r19 = (vn.a) r18.next();
        if (r19.e.f22417a != r5) goto L23;
    L29:
        if (r10 != 2) goto L31;
        if (r19 == null) goto L45;
        r19.g();
        return;
    L45:
        return;
    L31:
        if (r10 != 3) goto L50;
        if (r19 == null) goto L44;
        r19.d();
        return;
    L44:
        return;
    L50:
        return;
    L27:
        r19 = null;
        goto L29
    L49:
        return;
    L48:
        return;
    L43:
        return;
    L47:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setGestureDetectors(Map<Integer, un.a> r5) {
        this.mGestureDetectors = r5;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L41;
        sn.a r10 = getGestureArenaManager();
        if (r10 == null) goto L42;
        int r11 = getGestureArenaMemberId();
        if (r10.f == false) goto L16;
        HashMap r12 = r10.f21956a;
        if (r12 == null) goto L16;
        boolean r13 = r12.containsKey(Integer.valueOf(r11));
    L17:
        if (r13 == false) goto L22;
        Map<Integer, vn.a> r14 = this.mGestureHandlers;
        if (r14 == null) goto L22;
        r14.clear();
        this.mGestureHandlers = null;
    L22:
        if (this.mGestureHandlers == null) goto L24;
        return;
    L24:
        if (getSign() > 0) goto L26;
        return;
    L26:
        if ((this instanceof rn.a) == false) goto L40;
        HashMap r15 = vn.a.b(getSign(), getLynxContext(), (rn.a) this, getGestureDetectorMap());
        this.mGestureHandlers = r15;
        this.mIncludeNativeGesture = false;
        Iterator r16 = r15.keySet().iterator();
    L29:
        if (r16.hasNext() == false) goto L43;
        if (((Integer) r16.next()).intValue() != 7) goto L29;
        this.mIncludeNativeGesture = true;
        return;
    L43:
        return;
    L40:
        return;
    L16:
        r13 = false;
        goto L17
    L42:
        return;
    }

    public void setHeight(int r5) {
        this.mHeight = r5;
        onLayoutUpdated();
    }

    @com.lynx.tasm.behavior.c0(name = "hit-slop")
    public void setHitSlop(@Nullable pm.a r10) {
        if (r10 == null) goto L72;
        ReadableType r5 = r10.getType();
        ReadableType r11 = ReadableType.Map;
        if (r5 == r11) goto L9;
        if (r10.getType() == ReadableType.String) goto L9;
        return;
    L9:
        if (r10.getType() == r11) goto L11;
    L46:
        float r12 = com.lynx.tasm.utils.k.b(r10.asString());
        if (this.mHitSlopTop == r12) goto L49;
    L54:
        this.mHitSlopRight = r12;
        this.mHitSlopLeft = r12;
        this.mHitSlopBottom = r12;
        this.mHitSlopTop = r12;
        return;
    L49:
        if (this.mHitSlopBottom != r12) goto L54;
        if (this.mHitSlopLeft != r12) goto L54;
        if (this.mHitSlopRight != r12) goto L54;
        return;
    L11:
        if (r10.asMap().size() <= 0) goto L46;
        ReadableMap r13 = r10.asMap();
        ReadableMapKeySetIterator r14 = r13.keySetIterator();
        List r15 = Arrays.asList(new String[]{"top", "bottom", OpenPageMethod.ALIGN_LEFT, "right"});
    L14:
        if (r14.hasNextKey() == false) goto L75;
        String r16 = r14.nextKey();
        if (r15.contains(r16) == false) goto L14;
        float r17 = com.lynx.tasm.utils.k.b(r13.getString(r16));
        int r18 = r15.indexOf(r16);
        if (r18 != 0) goto L20;
        float r19 = this.mHitSlopTop;
        if (r19 != r17) goto L45;
        r17 = r19;
    L45:
        this.mHitSlopTop = r17;
        goto L14
    L20:
        if (r18 != 1) goto L22;
        float r20 = this.mHitSlopBottom;
        if (r20 != r17) goto L40;
        r17 = r20;
    L40:
        this.mHitSlopBottom = r17;
        goto L14
    L22:
        if (r18 != 2) goto L24;
        float r21 = this.mHitSlopLeft;
        if (r21 != r17) goto L35;
        r17 = r21;
    L35:
        this.mHitSlopLeft = r17;
        goto L14
    L24:
        if (r18 != 3) goto L14;
        float r22 = this.mHitSlopRight;
        if (r22 != r17) goto L30;
        r17 = r22;
    L30:
        this.mHitSlopRight = r17;
        goto L14
    L75:
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "idSelector")
    public void setIdSelector(@Nullable String r5) {
        this.mIdSelector = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "ignore-focus")
    public void setIgnoreFocus(@Nullable pm.a r5) {
        if (r5 != null) goto L15;
        this.mIgnoreFocus = EventTarget$EnableStatus.f10246c;
        return;
    L15:
    L8:
        th = move-exception;
        LynxLog.b(2, TAG, th.toString());
        this.mIgnoreFocus = EventTarget$EnableStatus.f10246c;
        return;
    L6:
        if (r5.asBoolean() == false) goto L10;
        EventTarget$EnableStatus r10 = EventTarget$EnableStatus.f10244a;     // Catch: Throwable -> L8
    L11:
        this.mIgnoreFocus = r10;     // Catch: Throwable -> L8
        return;
    L10:
        r10 = EventTarget$EnableStatus.f10245b;     // Catch: Throwable -> L8
        goto L11
    }

    @com.lynx.tasm.behavior.c0(name = "image-config")
    public void setImageConfig(@Nullable String r5) {
        if (r5 != null) goto L5;
    L30:
        this.mBitmapConfig = null;
        return;
    L5:
        if (r5.equalsIgnoreCase("") == true) goto L30;
        if (r5.equalsIgnoreCase("ALPHA_8") == false) goto L11;
        this.mBitmapConfig = Bitmap.Config.ALPHA_8;
    L23:
        com.lynx.tasm.behavior.ui.utils.g r10 = this.mLynxBackground;
        if (r10 == null) goto L26;
        r10.b(this.mBitmapConfig);
    L26:
        com.lynx.tasm.behavior.ui.utils.i r11 = this.mLynxMask;
        if (r11 == null) goto L32;
        r11.b(this.mBitmapConfig);
        return;
    L32:
        return;
    L11:
        if (r5.equalsIgnoreCase("RGB_565") == false) goto L14;
        this.mBitmapConfig = Bitmap.Config.RGB_565;
        goto L23
    L14:
        if (r5.equalsIgnoreCase("ARGB_8888") == false) goto L17;
        this.mBitmapConfig = Bitmap.Config.ARGB_8888;
        goto L23
    L17:
        if (r5.equalsIgnoreCase("RGBA_F16") == false) goto L20;
        this.mBitmapConfig = Bitmap.Config.RGBA_F16;
        goto L23
    L20:
        if (r5.equalsIgnoreCase("HARDWARE") == false) goto L22;
        this.mBitmapConfig = Bitmap.Config.HARDWARE;
        goto L23
    L22:
        this.mBitmapConfig = null;
        goto L23
    }

    @com.lynx.tasm.behavior.c0(name = "image-rendering")
    public void setImageRendering(int r5) {
        this.mImageRendering = r5;
    }

    public void setInitialPropsHasFlushed(String r5, String r10) {
    }

    @com.lynx.tasm.behavior.c0(name = "intersection-observers")
    public void setIntersectionObservers(@Nullable ReadableArray r10) {
        com.lynx.tasm.behavior.w r5 = this.mContext.i();
        r5.getClass();
        com.lynx.tasm.utils.j.f(new ab.b(28, r5, false, this));
        if (r10 != null) goto L5;
        return;
    L5:
        if (this.mEvents.containsKey("intersection") == false) goto L18;
        int r11 = 0;
    L9:
        if (r11 >= r10.size()) goto L19;
        ReadableMap r12 = r10.getMap(r11);
        if (r12 == null) goto L13;
        com.lynx.tasm.behavior.t r13 = new com.lynx.tasm.behavior.t(this.mContext.i(), r12, this);
        com.lynx.tasm.behavior.w r14 = this.mContext.i();
        r14.getClass();
        com.lynx.tasm.utils.j.f(new ab.b(27, r14, false, r13));
    L13:
        r11 = r11 + 1;
        goto L9
    L19:
        return;
    }

    public void setLastTranslateZ(float r5) {
        this.mLastTranslateZ = r5;
    }

    public void setLeft(int r5) {
        this.mLeft = r5;
        this.mOriginLeft = r5;
        onLayoutUpdated();
    }

    @com.lynx.tasm.behavior.c0(name = "local-cache")
    public void setLocalCache(@Nullable pm.a r5) {
        this.mUseLocalCache = r5;
    }

    public void setLynxBackground(com.lynx.tasm.behavior.ui.utils.g r5) {
        this.mLynxBackground = r5;
    }

    @com.lynx.tasm.behavior.c0(defaultInt = 3, name = "direction")
    public void setLynxDirection(int r5) {
        this.mLynxDirection = r5;
    }

    public void setLynxMask(com.lynx.tasm.behavior.ui.utils.i r5) {
        this.mLynxMask = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "mask-clip")
    public void setMaskClip(@Nullable ReadableArray r5) {
        e().c(r5);
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(name = "mask-image")
    public void setMaskImage(@Nullable ReadableArray r5) {
        e().d().e.b(r5, this);
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(name = "mask-origin")
    public void setMaskOrigin(@Nullable ReadableArray r5) {
        e().e(r5);
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(name = "mask-position")
    public void setMaskPosition(@Nullable ReadableArray r5) {
        e().g(r5);
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(name = "mask-repeat")
    public void setMaskRepeat(@Nullable ReadableArray r5) {
        e().h(r5);
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(name = "mask-size")
    public void setMaskSize(@Nullable ReadableArray r5) {
        e().i(r5);
        invalidate();
    }

    @com.lynx.tasm.behavior.c0(name = "name")
    public void setName(@Nullable String r5) {
        this.mName = r5;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "native-interaction-enabled")
    public void setNativeInteractionEnabled(boolean r5) {
        this.nativeInteractionEnabled = r5;
    }

    public void setNeedSortChildren(boolean r5) {
        this.mNeedSortChildren = r5;
    }

    public void setNextDrawUI(LynxBaseUI r5) {
        this.mNextDrawUI = r5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void setNodeIndex(int r5) {
        this.mNodeIndex = r5;
    }

    public void setOffsetDescendantRectToLynxView(int[] r5) {
        this.mOffsetDescendantRectToLynxView = new WeakReference(r5);
    }

    public void setOriginLeft(int r5) {
        this.mOriginLeft = r5;
    }

    public void setOriginTop(int r5) {
        this.mOriginTop = r5;
    }

    @com.lynx.tasm.behavior.c0(defaultInt = ViewCompat.MEASURED_STATE_MASK, name = "outline-color")
    public void setOutlineColor(int r5) {
        a0 r10 = this.mParent;
        if ((r10 instanceof UIShadowProxy) == false) goto L6;
        b0 r11 = ((UIShadowProxy) r10).i();
        r11.f10422b = Integer.valueOf(r5);
        return;
    }

    @com.lynx.tasm.behavior.c0(defaultInt = -1, name = "outline-style")
    public void setOutlineStyle(int r5) {
        a0 r10 = this.mParent;
        if ((r10 instanceof UIShadowProxy) == false) goto L13;
        UIShadowProxy r11 = (UIShadowProxy) r10;
        if (r5 >= 0) goto L7;
    L10:
        BorderStyle r12 = null;
    L11:
        r11.i().f10421a = r12;
        return;
    L7:
        if (r5 > 9) goto L10;
        r12 = BorderStyle.values()[r5];
        goto L11
    }

    @com.lynx.tasm.behavior.c0(defaultInt = 0, name = "outline-width")
    public void setOutlineWidth(float r5) {
        a0 r10 = this.mParent;
        if ((r10 instanceof UIShadowProxy) == false) goto L6;
        ((UIShadowProxy) r10).i().f10423c = r5;
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "overflow")
    public void setOverflow(@Nullable Integer r5) {
        if (r5 != null) goto L4;
        int r10 = getInitialOverflowType();
    L5:
        setOverflow(r10);
        return;
    L4:
        r10 = r5.intValue();
        goto L5
    }

    public void setOverflowWithMask(short r5, @Nullable int r10) {
        int r11 = this.mOverflow;
        if (r10 != 0) goto L5;
        int r12 = r5 | r11;
    L6:
        this.mOverflow = r12;
        requestLayout();
        return;
    L5:
        r12 = (~r5) & r11;
        goto L6
    }

    @com.lynx.tasm.behavior.c0(name = "overflow-x")
    public void setOverflowX(@Nullable Integer r5) {
        if (r5 != null) goto L4;
        int r10 = getInitialOverflowType();
    L5:
        setOverflowWithMask(1, r10);
        return;
    L4:
        r10 = r5.intValue();
        goto L5
    }

    @com.lynx.tasm.behavior.c0(name = "overflow-y")
    public void setOverflowY(@Nullable Integer r5) {
        if (r5 != null) goto L4;
        int r10 = getInitialOverflowType();
    L5:
        setOverflowWithMask(2, r10);
        return;
    L4:
        r10 = r5.intValue();
        goto L5
    }

    public void setParent(a0 r10) {
        if (this.mStateChangeListeners != null) goto L6;
        this.mParent = r10;
        return;
    L6:
        int r5 = 0;
        if ((r10 instanceof LynxBaseUI) == false) goto L18;
        monitor-enter(this);
        q[] r11 = (q[]) this.mStateChangeListeners.toArray(new q[this.mStateChangeListeners.size()]);     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        int r12 = r11.length;
    L12:
        if (r5 >= r12) goto L28;
        LynxBaseUI r13 = (LynxBaseUI) r10;
        r13.registerScrollStateListener(r11[r5]);
        r5 = r5 + 1;
    L28:
        this.mParent = r10;
        return;
    L14:
        th = move-exception;
        throw th;
    L18:
        if ((this.mParent instanceof LynxBaseUI) == false) goto L28;
        monitor-enter(this);
        q[] r14 = (q[]) this.mStateChangeListeners.toArray(new q[this.mStateChangeListeners.size()]);     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        int r15 = r14.length;
    L23:
        if (r5 >= r15) goto L28;
        q r16 = r14[r5];
        ((LynxBaseUI) this.mParent).unRegisterScrollStateListener(r16);
        r5 = r5 + 1;
    L25:
        th = move-exception;
        throw th;
    }

    public void setParentLynxPageUI(wm.a r5) {
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L9;
        UIBody r11 = r10.f10145m;
        if (r11 == null) goto L10;
        r11.f10386b = r5;
        return;
    L10:
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "perspective")
    public void setPerspective(@Nullable ReadableArray r5) {
        this.mPerspective = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "pointer-events")
    public void setPointerEvents(int r5) {
        if (r5 >= 0) goto L4;
        return;
    L4:
        if (r5 >= 2) goto L8;
        this.mPointerEvents = EventTarget$PointerEventsValue.values()[r5];
        return;
    }

    public void setPosition(int r5, int r10) {
        this.mLeft = r5;
        this.mTop = r10;
        this.mOriginTop = r10;
        this.mOriginLeft = r5;
    }

    public void setPreviousDrawUI(LynxBaseUI r5) {
        this.mPreviousDrawUI = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "react-ref")
    public void setRefIdSelector(@Nullable String r5) {
        this.mRefId = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "scroll-monitor-tag")
    public void setScrollMonitorTag(@Nullable String r5) {
        this.mScrollMonitorTag = r5;
    }

    public void setSign(int r5, String r10) {
        this.mSign = r5;
        this.mTagName = r10;
    }

    public void setSkewX(float r5) {
        this.mSkewX = r5;
    }

    public void setSkewY(float r5) {
        this.mSkewY = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "skip-redirection")
    public void setSkipRedirection(boolean r5) {
        this.mSkipRedirection = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "lynx-test-tag")
    public void setTestID(@Nullable String r5) {
        this.mTestTagName = r5;
    }

    public void setTop(int r5) {
        this.mTop = r5;
        this.mOriginTop = r5;
        onLayoutUpdated();
    }

    public void setTransform(ReadableArray r5) {
        this.hasTransformChanged = true;
        ArrayList r10 = com.lynx.tasm.behavior.ui.utils.o.b(r5);
        this.mTransformRaw = r10;
        float r11 = 0.0f;
        if (r10 != null) goto L5;
    L17:
        setTranslationZ(r11);
        if ((getParent() instanceof UIShadowProxy) == false) goto L29;
        ((UIShadowProxy) getParent()).f10388a.getTransformRaws();
        return;
    L29:
        return;
    L5:
        if (r10.isEmpty() == true) goto L17;
        Iterator r12 = r10.iterator();
    L9:
        if (r12.hasNext() == false) goto L17;
        com.lynx.tasm.behavior.ui.utils.o r13 = (com.lynx.tasm.behavior.ui.utils.o) r12.next();
        int r14 = r13.f10762a;
        if (r14 != 8) goto L13;
        r11 = r13.f10764c.a();
        goto L9
    L13:
        if (r14 != 16) goto L9;
        r11 = r13.f10765h.a();
        goto L9
    }

    @com.lynx.tasm.behavior.c0(name = "transform-origin")
    public void setTransformOrigin(@Nullable ReadableArray r5) {
        this.hasTransformChanged = true;
        com.lynx.tasm.behavior.ui.utils.m r10 = com.lynx.tasm.behavior.ui.utils.m.e;
        this.mTransformOrigin = r10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (r5.size() >= 2) goto L8;
        com.lynx.tasm.behavior.ui.utils.m r11 = null;
    L9:
        this.mTransformOrigin = r11;
        if (r11 != null) goto L13;
        LynxLog.b(4, TAG, "transform params error.");
        this.mTransformOrigin = r10;
        return;
    L13:
        return;
    L8:
        r11 = new com.lynx.tasm.behavior.ui.utils.m(r5);
        goto L9
    }

    public void setTranslationZ(float r5) {
        this.mTranslationZ = r5;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = true, name = "user-interaction-enabled")
    public void setUserInteractionEnabled(boolean r5) {
        this.userInteractionEnabled = r5;
    }

    public void setWidth(int r5) {
        this.mWidth = r5;
        onLayoutUpdated();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final boolean shouldDoTransform() {
        if (this.hasTransformChanged == true) goto L38;
        List<com.lynx.tasm.behavior.ui.utils.o> r5 = this.mTransformRaw;
        if (r5 != null) goto L7;
    L21:
        com.lynx.tasm.behavior.ui.utils.m r10 = this.mTransformOrigin;
        if (r10 == null) goto L36;
        float r11 = r10.f10758a;
        int r12 = r10.d;
        int r13 = r10.f10759b;
        if (r11 != 0.5f) goto L30;
        if (r13 != 1) goto L30;
        if (r10.f10760c != 0.5f) goto L30;
        if (r12 != 1) goto L30;
        return false;
    L30:
        if (r13 == 1) goto L34;
        if (r12 == 1) goto L34;
        return false;
    L34:
        if (hasSizeChanged() == true) goto L38;
        return false;
    L36:
        return false;
    L7:
        if (r5.isEmpty() == true) goto L21;
        Iterator<com.lynx.tasm.behavior.ui.utils.o> r14 = r5.iterator();
    L11:
        if (r14.hasNext() == false) goto L21;
        com.lynx.tasm.behavior.ui.utils.o r15 = r14.next();
        if (r15.d == 1) goto L34;
        if (r15.g == 1) goto L34;
        if (r15.f10766i != 1) goto L11;
    L38:
        return true;
    }

    @Override // wm.a
    public void startEventBubble(long r5) {
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L13;
        com.lynx.tasm.r r11 = r10.g;
        if (r11 == null) goto L16;
        com.lynx.tasm.i r12 = r11.e;
        if (r12 == null) goto L14;
        LynxEngineProxy r13 = (LynxEngineProxy) r12.f10879a;
        if (r13 == null) goto L15;
        com.lynx.tasm.utils.j.f(new mn.a(r13, r5, 1));
        return;
    L15:
        return;
    L14:
        return;
    L16:
        return;
    }

    @Override // wm.a
    public void startEventCapture(long r5) {
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L13;
        com.lynx.tasm.r r11 = r10.g;
        if (r11 == null) goto L16;
        com.lynx.tasm.i r12 = r11.e;
        if (r12 == null) goto L14;
        LynxEngineProxy r13 = (LynxEngineProxy) r12.f10879a;
        if (r13 == null) goto L15;
        com.lynx.tasm.utils.j.f(new mn.a(r13, r5, 0));
        return;
    L15:
        return;
    L14:
        return;
    L16:
        return;
    }

    @Override // wm.a
    public void startEventFire(boolean r5, long r10) {
        LynxContext r11 = this.mContext;
        if (r11 == null) goto L13;
        com.lynx.tasm.r r12 = r11.g;
        if (r12 == null) goto L16;
        com.lynx.tasm.i r13 = r12.e;
        if (r13 == null) goto L14;
        LynxEngineProxy r14 = (LynxEngineProxy) r13.f10879a;
        if (r14 == null) goto L15;
        com.lynx.tasm.utils.j.f(new mn.b(r14, r5, r10));
        return;
    L15:
        return;
    L14:
        return;
    L16:
        return;
    }

    public void storeKeyToNativeStorage(String r5, Object r10) {
    }

    public void transformFromViewToRootView(View r5, float[] r10) {
        if (r5.getMatrix().isIdentity() == true) goto L5;
        r5.getMatrix().mapPoints(r10);
    L5:
        View r11 = r5.getRootView();
    L6:
        if (r5 == r11) goto L15;
        View r12 = (View) r5.getParent();
        if (r12 == null) goto L9;
        r10[0] = r10[0] + r5.getLeft();
        r10[1] = r10[1] + r5.getTop();
        r10[0] = r10[0] - r12.getScrollX();
        r10[1] = r10[1] - r12.getScrollY();
        if (r12.getMatrix().isIdentity() == true) goto L14;
        r12.getMatrix().mapPoints(r10);
    L14:
        r5 = r12;
        goto L6
    L9:
        LynxLog.b(4, TAG, "transformFromViewToRootView failed, parent is null.");
        return;
    }

    public void uiOwnerDidPerformLayout() {
        if (this.mBoundingClientRectCallbacks.isEmpty() == true) goto L9;
        ArrayList r5 = new ArrayList(this.mBoundingClientRectCallbacks);
        this.mBoundingClientRectCallbacks.clear();
        Iterator r10 = r5.iterator();
    L7:
        if (r10.hasNext() == false) goto L11;
        ((Runnable) r10.next()).run();
        goto L7
    L11:
        return;
    }

    public void unRegisterScrollStateListener(q r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (this.mStateChangeListeners == null) goto L22;
        monitor-enter(this);
        this.mStateChangeListeners.remove(r5);     // Catch: Throwable -> L14
        boolean r10 = this.mStateChangeListeners.isEmpty();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        if (r10 == false) goto L20;
        a0 r11 = getParent();
        if ((r11 instanceof LynxBaseUI) == false) goto L21;
        ((LynxBaseUI) r11).unRegisterScrollStateListener(this.mScrollStateChangeListener);
        return;
    L21:
        return;
    L20:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public boolean updateDrawingLayoutInfo(int r5, int r10, Rect r11) {
        boolean r12 = true;
        if (this.mLeft == r5) goto L5;
        this.mLeft = r5;
        boolean r13 = true;
    L7:
        if (this.mTop == r10) goto L9;
        this.mTop = r10;
    L10:
        this.mBound = r11;
        if (r12 == false) goto L13;
        onDrawingPositionChanged();
    L13:
        return r12;
    L9:
        r12 = r13;
        goto L10
    L5:
        r13 = false;
        goto L7
    }

    public void updateExtraData(Object r5) {
    }

    public void updateLayout(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r110, int r111, int r112, int r113, int r20, int r21, Rect r22) {
        this.mSkipLayoutUpdated = true;
        updateLayoutInfo(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, r111, r112, r113, r20, r21, r22);
        this.mSkipLayoutUpdated = false;
        onLayoutUpdated();
        Map<String, on.a> r5 = this.mEvents;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.containsKey("layoutchange") == false) goto L9;
        JavaOnlyMap r23 = a(LynxEnv.inst().enableTransformForPositionCalculation());
        getLynxContext().g.b(new on.b(getSign(), "layoutchange", r23));
        return;
    }

    public void updateLayoutInfo(int r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19, int r110, int r111, int r112, int r113, int r20, int r21, Rect r22) {
        LynxContext r5 = this.mContext;
        if (r5 == null) goto L25;
        a1 r23 = r5.f10140h;
        if (r23 == null) goto L7;
        boolean r24 = r23.f10187o;
    L8:
        if (r24 == false) goto L25;
        if (Float.compare(this.mWidth, 0.0f) == 0) goto L25;
        if (Float.compare(this.mHeight, 0.0f) == 0) goto L25;
        if (Float.compare(this.mLeft, r10) != 0) goto L19;
        if (Float.compare(this.mTop, r11) == 0) goto L25;
    L19:
        a1 r25 = this.mContext.f10140h;
        if (r25 == null) goto L25;
        HashSet r26 = r25.f10191t;
        if (r26 == null) goto L25;
        r26.add(Integer.valueOf(getSign()));
        goto L25
    L7:
        r24 = false;
    L25:
        setPosition(r10, r11);
        this.mWidth = r12;
        this.mHeight = r13;
        this.mPaddingLeft = r14;
        this.mPaddingRight = r16;
        this.mPaddingBottom = r17;
        this.mPaddingTop = r15;
        this.mMarginLeft = r18;
        this.mMarginTop = r19;
        this.mMarginRight = r110;
        this.mMarginBottom = r111;
        this.mBorderTopWidth = r113;
        this.mBorderBottomWidth = r21;
        this.mBorderLeftWidth = r112;
        this.mBorderRightWidth = r20;
        this.mBound = r22;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void updateLayoutSize(int r5, int r10) {
        Point r11 = this.mLatestSize;
        r11.x = r5;
        r11.y = r10;
    }

    public void updateMaxHeight(float r5) {
        this.mMaxHeight = r5;
    }

    public final void updateProperties(y0 r5) {
        updatePropertiesInterval(r5);
        afterPropsUpdated(r5);
    }

    public void updatePropertiesInterval(y0 r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.d() == true) goto L360;
        JavaOnlyMap r5 = this.mProps;
        r5.getClass();
        ReadableMap r11 = r10.f10815a;
        r5.putAll(r11.asHashMap());
        ConcurrentHashMap r12 = com.lynx.tasm.behavior.utils.l.f10800a;
        LynxUISetter r13 = com.lynx.tasm.behavior.utils.l.c(getClass());
        ReadableMapKeySetIterator r14 = r11.keySetIterator();
    L8:
        if (r14.hasNextKey() == false) goto L14;
        String r15 = r14.nextKey();
        r13.a(this, r15, r10);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        StringBuilder r16 = com.lynx.tasm.utils.e.b("Error while updating property '", r15, "' in ui '");
        r16.append(getTagName());
        r16.append("': ");
        r16.append(th);
        LynxError r17 = new LynxError(130100, r16.toString(), "", "error");
        String r18 = CallStackUtil.getStackTraceStringWithLineTrimmed(th);
        r17.g = null;
        r17.f9999n = r18;
        JSONObject r19 = getPlatformCustomInfo();
        r17.g = null;
        r17.e = r19;
        getLynxContext().b(r17);
        goto L8
    L14:
        ReadableMapBuffer r20 = r10.f10816b;
        if (r20 == null) goto L361;
        com.lynx.tasm.behavior.e r21 = getOrCreateUIPaintStyles();
        if (r21 == null) goto L362;
        Iterator r22 = r20.iterator();
    L22:
        if (r22.hasNext() == false) goto L363;
        qm.c r23 = (qm.c) r22.next();
        ByteBuffer r24 = r23.f21526b.f21527a;
        int r25 = r23.f21525a;
        short r26 = r24.getShort(r25);
        if (r26 != 76) goto L26;
        qm.f r27 = new qm.f(r23.c());
        setBoxShadow(r27);
        r21.Q = r27;
        goto L22
    L26:
        if (r26 != 77) goto L28;
        qm.f r28 = new qm.f(r23.c());
        setTransformOrigin(r28);
        r21.O = r28;
        goto L22
    L28:
        if (r26 != 120) goto L30;
        int r29 = r23.b();
        setOverflowX(Integer.valueOf(r29));
        r21.H = Integer.valueOf(r29);
        goto L22
    L30:
        if (r26 != 121) goto L32;
        int r30 = r23.b();
        setOverflowY(Integer.valueOf(r30));
        r21.I = Integer.valueOf(r30);
        goto L22
    L32:
        if (r26 != 129) goto L34;
        qm.d r31 = r23.f21526b;
        setCaretColor(r31.c(r25 + r31.f21529c));
        goto L22
    L34:
        if (r26 != 130) goto L36;
        int r32 = r23.b();
        setLynxDirection(r32);
        r21.N = r32;
        goto L22
    L36:
        if (r26 != 142) goto L38;
        if ((this instanceof LynxUI) == false) goto L22;
        ((LynxUI) this).setEnterTransitionName(new qm.f(r23.c()));
        goto L22
    L38:
        if (r26 != 143) goto L40;
        if ((this instanceof LynxUI) == false) goto L22;
        ((LynxUI) this).setExitTransitionName(new qm.f(r23.c()));
        goto L22
    L40:
        switch(r26) {
            case 5: goto L146;
            case 23: goto L144;
            case 25: goto L142;
            case 47: goto L141;
            case 63: goto L139;
            case 74: goto L137;
            case 104: goto L135;
            case 123: goto L133;
            case 147: goto L131;
            case 170: goto L129;
            case 190: goto L128;
            case 193: goto L126;
            case 208: goto L124;
            default: goto L42;
        };
    L124:
        int r33 = r23.b();
        setImageRendering(r33);
        r21.S = r33;
        goto L22
    L126:
        if ((this instanceof LynxUI) == false) goto L22;
        qm.f r34 = new qm.f(r23.c());
        ((LynxUI) this).setClipPath(r34);
        r21.T = r34;
        goto L22
    L128:
        qm.f r35 = new qm.f(r23.c());
        setPerspective(r35);
        r21.P = r35;
        goto L22
    L129:
        qm.f r36 = new qm.f(r23.c());
        setMaskImage(r36);
        r21.f10225h = r36;
        goto L22
    L131:
        if ((this instanceof UIComponent) == false) goto L22;
        ((UIComponent) this).setZIndex(r23.b());
        goto L22
    L133:
        qm.f r37 = new qm.f(r23.c());
        setBackgroundClip(r37);
        r21.f10216a = r37;
        goto L22
    L135:
        if ((this instanceof LynxUI) == false) goto L22;
        int r38 = r23.b();
        ((LynxUI) this).setVisibility(r38);
        r21.f10226h0 = r38;
        goto L22
    L137:
        int r39 = r23.b();
        setBorderStyle(0, r39);
        r21.s = r39;
        goto L22
    L139:
        if ((this instanceof LynxUI) == false) goto L22;
        qm.f r40 = new qm.f(r23.c());
        ((LynxUI) this).setTransform(r40);
        r21.R = r40;
        goto L22
    L141:
        float r41 = r23.b();
        setFontSize(r41);
        r21.M = r41;
        goto L22
    L142:
        int r42 = r23.b();
        setOverflow(r42);
        r21.G = Integer.valueOf(r42);
        goto L22
    L144:
        if ((this instanceof LynxUI) == false) goto L22;
        float r43 = r23.b();
        ((LynxUI) this).setAlpha(r43);
        r21.g0 = r43;
        goto L22
    L146:
        setCSSPosition(r23.b());
        goto L22
    L42:
        switch(r26) {
            case 7: goto L123;
            case 8: goto L122;
            case 9: goto L121;
            case 10: goto L120;
            case 11: goto L119;
            case 12: goto L118;
            case 13: goto L117;
            case 14: goto L116;
            case 15: goto L115;
            case 16: goto L114;
            case 17: goto L113;
            case 18: goto L112;
            case 19: goto L111;
            case 20: goto L110;
            case 21: goto L109;
            default: goto L43;
        };
    L109:
        int r44 = (int) r23.a();
        setBorderWidth(4, r44);
        r21.B = r44;
        goto L22
    L110:
        int r45 = (int) r23.a();
        setBorderWidth(3, r45);
        r21.A = r45;
        goto L22
    L111:
        int r46 = (int) r23.a();
        setBorderWidth(2, r46);
        r21.f10243z = r46;
        goto L22
    L112:
        int r47 = (int) r23.a();
        setBorderWidth(1, r47);
        r21.f10242y = r47;
        goto L22
    L113:
        int r48 = (int) r23.a();
        setBorderWidth(0, r48);
        r21.f10241x = r48;
        goto L22
    L114:
        qm.f r49 = new qm.f(r23.c());
        setBorderRadius(3, r49);
        r21.f10235q = r49;
        goto L22
    L115:
        qm.f r50 = new qm.f(r23.c());
        setBorderRadius(2, r50);
        r21.f10234p = r50;
        goto L22
    L116:
        qm.f r51 = new qm.f(r23.c());
        setBorderRadius(4, r51);
        r21.f10236r = r51;
        goto L22
    L117:
        qm.f r52 = new qm.f(r23.c());
        setBorderRadius(1, r52);
        r21.f10233o = r52;
        goto L22
    L118:
        qm.f r53 = new qm.f(r23.c());
        setBorderRadius(0, r53);
        r21.f10232n = r53;
        goto L22
    L119:
        int r54 = r23.b();
        setBorderColor(3, Integer.valueOf(r54));
        r21.F = Integer.valueOf(r54);
        goto L22
    L120:
        int r55 = r23.b();
        setBorderColor(2, Integer.valueOf(r55));
        r21.E = Integer.valueOf(r55);
        goto L22
    L121:
        int r56 = r23.b();
        setBorderColor(1, Integer.valueOf(r56));
        r21.D = Integer.valueOf(r56);
        goto L22
    L122:
        int r57 = r23.b();
        setBorderColor(0, Integer.valueOf(r57));
        r21.C = Integer.valueOf(r57);
        goto L22
    L123:
        int r58 = r23.b();
        setBackgroundColor(r58);
        r21.f10218b = r58;
        goto L22
    L43:
        switch(r26) {
            case 200: goto L108;
            case 201: goto L107;
            case 202: goto L106;
            case 203: goto L105;
            case 204: goto L104;
            default: goto L44;
        };
    L104:
        qm.f r59 = new qm.f(r23.c());
        setMaskSize(r59);
        r21.f10229k = r59;
        goto L22
    L105:
        qm.f r60 = new qm.f(r23.c());
        setMaskOrigin(r60);
        r21.f10227i = r60;
        goto L22
    L106:
        qm.f r61 = new qm.f(r23.c());
        setMaskClip(r61);
        r21.f10231m = r61;
        goto L22
    L107:
        qm.f r62 = new qm.f(r23.c());
        setMaskPosition(r62);
        r21.f10230l = r62;
        goto L22
    L108:
        qm.f r63 = new qm.f(r23.c());
        setMaskRepeat(r63);
        r21.f10228j = r63;
        goto L22
    L44:
        switch(r26) {
            case 83: goto L102;
            case 84: goto L99;
            case 85: goto L96;
            case 86: goto L93;
            case 87: goto L90;
            case 88: goto L87;
            case 89: goto L84;
            case 90: goto L81;
            case 91: goto L78;
            case 92: goto L75;
            case 93: goto L72;
            default: goto L45;
        };
    L72:
        if ((this instanceof LynxUI) == false) goto L22;
        double r64 = r23.a();
        ((LynxUI) this).setLayoutAnimationUpdateDelay(r64);
        r21.f10222d0 = r64;
        goto L22
    L75:
        if ((this instanceof LynxUI) == false) goto L22;
        qm.f r65 = new qm.f(r23.c());
        ((LynxUI) this).setLayoutAnimationUpdateTimingFunc(r65);
        r21.f10224f0 = r65;
        goto L22
    L78:
        if ((this instanceof LynxUI) == false) goto L22;
        double r66 = r23.a();
        ((LynxUI) this).setLayoutAnimationUpdateDuration(r66);
        r21.f10223e0 = r66;
        goto L22
    L81:
        if ((this instanceof LynxUI) == false) goto L22;
        int r67 = r23.b();
        ((LynxUI) this).setLayoutAnimationDeleteProperty(r67);
        r21.f10219b0 = r67;
        goto L22
    L84:
        if ((this instanceof LynxUI) == false) goto L22;
        double r68 = r23.a();
        ((LynxUI) this).setLayoutAnimationDeleteDelay(r68);
        r21.Z = r68;
        goto L22
    L87:
        if ((this instanceof LynxUI) == false) goto L22;
        qm.f r69 = new qm.f(r23.c());
        ((LynxUI) this).setLayoutAnimationDeleteTimingFunc(r69);
        r21.f10221c0 = r69;
        goto L22
    L90:
        if ((this instanceof LynxUI) == false) goto L22;
        double r70 = r23.a();
        ((LynxUI) this).setLayoutAnimationDeleteDuration(r70);
        r21.f10217a0 = r70;
        goto L22
    L93:
        if ((this instanceof LynxUI) == false) goto L22;
        int r71 = r23.b();
        ((LynxUI) this).setLayoutAnimationCreateProperty(r71);
        r21.X = r71;
        goto L22
    L96:
        if ((this instanceof LynxUI) == false) goto L22;
        double r72 = r23.a();
        ((LynxUI) this).setLayoutAnimationCreateDelay(r72);
        r21.V = r72;
        goto L22
    L99:
        if ((this instanceof LynxUI) == false) goto L22;
        qm.f r73 = new qm.f(r23.c());
        ((LynxUI) this).setLayoutAnimationCreateTimingFunc(r73);
        r21.Y = r73;
        goto L22
    L102:
        if ((this instanceof LynxUI) == false) goto L22;
        double r74 = r23.a();
        ((LynxUI) this).setLayoutAnimationCreateDuration(r74);
        r21.W = r74;
        goto L22
    L45:
        switch(r26) {
            case 98: goto L70;
            case 99: goto L69;
            case 100: goto L68;
            case 101: goto L67;
            case 102: goto L66;
            default: goto L46;
        };
    L66:
        qm.f r75 = new qm.f(r23.c());
        setBackgroundSize(r75);
        r21.g = r75;
        goto L22
    L67:
        qm.f r76 = new qm.f(r23.c());
        setBackgroundRepeat(r76);
        r21.f = r76;
        goto L22
    L68:
        qm.f r77 = new qm.f(r23.c());
        setBackgroundOrigin(r77);
        r21.d = r77;
        goto L22
    L69:
        qm.f r78 = new qm.f(r23.c());
        setBackgroundPosition(r78);
        r21.e = r78;
        goto L22
    L70:
        qm.f r79 = new qm.f(r23.c());
        setBackgroundImage(r79);
        r21.f10220c = r79;
        goto L22
    L46:
        switch(r26) {
            case 115: goto L65;
            case 116: goto L64;
            case 117: goto L63;
            case 118: goto L62;
            default: goto L47;
        };
    L62:
        int r80 = r23.b();
        setBorderStyle(4, r80);
        r21.f10240w = r80;
        goto L22
    L63:
        int r81 = r23.b();
        setBorderStyle(3, r81);
        r21.f10239v = r81;
        goto L22
    L64:
        int r82 = r23.b();
        setBorderStyle(2, r82);
        r21.f10238u = r82;
        goto L22
    L65:
        int r83 = r23.b();
        setBorderStyle(1, r83);
        r21.f10237t = r83;
        goto L22
    L47:
        switch(r26) {
            case 125: goto L61;
            case 126: goto L60;
            case 127: goto L59;
            default: goto L48;
        };
    L59:
        float r84 = (float) r23.a();
        setOutlineWidth(r84);
        r21.K = r84;
        goto L22
    L60:
        int r85 = r23.b();
        setOutlineStyle(r85);
        r21.L = r85;
        goto L22
    L61:
        int r86 = r23.b();
        setOutlineColor(r23.b());
        r21.J = r86;
        goto L22
    L48:
        switch(r26) {
            case 186: goto L57;
            case 187: goto L54;
            case 188: goto L51;
            default: goto L22;
        };
    L51:
        if ((this instanceof AbsLynxList) == false) goto L22;
        ((AbsLynxList) this).setCrossAxisGap((float) r23.a());
        goto L22
    L54:
        if ((this instanceof AbsLynxList) == false) goto L22;
        ((AbsLynxList) this).setMainAxisGap((float) r23.a());
        goto L22
    L57:
        if ((this instanceof LynxUI) == false) goto L22;
        qm.f r87 = new qm.f(r23.c());
        ((LynxUI) this).setFilter(r87);
        r21.U = r87;
        goto L22
    L363:
        return;
    L362:
        return;
    L361:
        return;
    }

    public void updateSticky(float[] r5) {
        if (r5 != null) goto L4;
    L10:
        this.mSticky = null;
        return;
    L4:
        if (r5.length < 4) goto L10;
        Sticky r10 = new Sticky();
        this.mSticky = r10;
        ((RectF) r10).left = r5[0];
        ((RectF) r10).top = r5[1];
        ((RectF) r10).right = r5[2];
        ((RectF) r10).bottom = r5[3];
        r10.f10381b = 0.0f;
        r10.f10380a = 0.0f;
        Cloneable r11 = getParentBaseUI();
        if ((r11 instanceof gn.d) == false) goto L12;
        UIScrollView r12 = (UIScrollView) ((gn.d) r11);
        r12.f10643l = true;
        r12.L();
        return;
    }

    public boolean childrenContainPoint(float r12, float r13, boolean r14) {
        if (this.mContext.h() == false) goto L20;
        Iterator<LynxBaseUI> r5 = this.mChildren.iterator();
    L6:
        if (r5.hasNext() == false) goto L19;
        LynxBaseUI r10 = r5.next();
        if ((r10 instanceof UIShadowProxy) == false) goto L10;
        r10 = ((UIShadowProxy) r10).f10388a;
    L10:
        float[] r11 = getTargetPoint(r12, r13, getScrollX(), getScrollY(), r10.getRectWithoutTransform(), r10.getTransformMatrix());
        if (r14 == true) goto L15;
        if (r10.isUserInteractionEnabled() == false) goto L6;
    L15:
        if (r10.getVisibility() == false) goto L6;
        if (r10.containsPoint(r11[0], r11[1], r14) == false) goto L6;
        return true;
    L19:
        return false;
    L20:
        float r15 = ((r12 + getScrollX()) - getOriginLeft()) - getTranslationX();
        float r16 = ((r13 + getScrollY()) - getOriginTop()) - getTranslationY();
        Iterator<LynxBaseUI> r17 = this.mChildren.iterator();
    L22:
        if (r17.hasNext() == false) goto L32;
        LynxBaseUI r18 = r17.next();
        if (r14 == true) goto L28;
        if (r18.isUserInteractionEnabled() == false) goto L22;
    L28:
        if (r18.getVisibility() == false) goto L22;
        if (r18.containsPoint(r15, r16, r14) == false) goto L22;
        return true;
    L32:
        return false;
    }

    @NonNull
    public LynxBaseUI clone() {
        LynxBaseUI r5 = ((n0) this.mContext.f10147o.get()).e(this.mTagName, false, null);
        applyUIPaintStylesToTarget(r5);
        Iterator<LynxBaseUI> r10 = getChildren().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        LynxBaseUI r11 = r10.next().clone();
        r5.insertChild(r11, r5.getChildren().size());
        ((UIGroup) r5).insertView((LynxUI) r11);
        goto L4
    L6:
        r5.updateProperties(new y0(this.mProps));
        r5.updateLayoutSize(getWidth(), getHeight());
        r5.updateLayout(getLeft(), getTop(), getWidth(), getHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), getMarginLeft(), getMarginTop(), getMarginRight(), r5.getMarginBottom(), getBorderLeftWidth(), getBorderTopWidth(), getBorderRightWidth(), getBorderBottomWidth(), getBound());
        r5.onLayoutFinish(0, null);
        r5.onNodeReady();
        return r5;
    }

    @Override // rn.b
    public void consumeGesture(int r5, ReadableMap r10) {
        if (isEnableNewGesture() == false) goto L12;
        if (r10 == null) goto L13;
        boolean r11 = r10.getBoolean("inner", true);
        boolean r12 = r10.getBoolean("consume", true);
        if (r11 == false) goto L10;
        consumeGesture(r12);
        return;
    L10:
        interceptGesture(r12);
        return;
    L13:
        return;
    }

    public boolean containsPoint(float r10, float r11, boolean r12) {
        if (this.mOnResponseChain == false) goto L5;
        float r5 = this.mTouchSlop * this.mContext.getResources().getDisplayMetrics().density;
    L6:
        boolean r13 = false;
        if (this.mContext.h() == false) goto L37;
        float r14 = -r5;
        float r15 = r14 - this.mHitSlopLeft;
        float r16 = (this.mWidth + r5) + this.mHitSlopRight;
        float r17 = r14 - this.mHitSlopTop;
        float r18 = (this.mHeight + r5) + this.mHitSlopBottom;
        if (r15 <= r10) goto L11;
    L17:
        if (r13 == false) goto L19;
    L36:
        return r13;
    L19:
        if (getOverflow() == 0) goto L36;
        if (getOverflow() != 1) goto L28;
        if (r11 < r17) goto L36;
        if (r11 > r18) goto L36;
    L35:
        return childrenContainPoint(r10, r11, r12);
    L28:
        if (getOverflow() != 2) goto L35;
        if (r10 < r15) goto L36;
        if (r10 <= r16) goto L35;
    L11:
        if (r16 < r10) goto L17;
        if (r17 > r11) goto L17;
        if (r18 < r11) goto L17;
        r13 = true;
        goto L17
    L37:
        Rect r19 = getRect();
        if ((r19.left - r5) < r10) goto L40;
    L46:
        if (r13 == false) goto L48;
    L65:
        return r13;
    L48:
        if (getOverflow() == 0) goto L65;
        if (getOverflow() != 1) goto L57;
        if ((r19.top - r5) >= r11) goto L65;
        if ((r19.bottom + r5) <= r11) goto L65;
    L64:
        return childrenContainPoint(r10, r11, r12);
    L57:
        if (getOverflow() != 2) goto L64;
        if ((r19.left - r5) >= r10) goto L65;
        if ((r19.right + r5) > r10) goto L64;
    L40:
        if ((r19.right + r5) <= r10) goto L46;
        if ((r19.top - r5) >= r11) goto L46;
        if ((r19.bottom + r5) <= r11) goto L46;
        r13 = true;
        goto L46
    L5:
        r5 = 0.0f;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public wm.a hitTest(float r22, float r23, boolean r24) {
        Log.d("hxh-debug", "hitTest x: " + r22 + " y: " + r23);
        ArrayList r11 = new ArrayList();
        int r14 = this.mChildren.size() - 1;
        float r16 = r22;
        float r17 = r23;
        LynxBaseUI r15 = null;
    L4:
        if (r14 < 0) goto L37;
        LynxBaseUI r5 = this.mChildren.get(r14);
        if ((r5 instanceof UIShadowProxy) == false) goto L8;
        r5 = ((UIShadowProxy) r5).f10388a;
    L8:
        LynxBaseUI r10 = r5;
        if ((r10 instanceof UIComponent) == false) goto L15;
        UIComponent r12 = (UIComponent) r10;
        if (r12.getView() == 0) goto L15;
        if (((com.lynx.tasm.behavior.ui.view.b) r12.getView()).getParent() != null) goto L15;
        boolean r13 = true;
    L16:
        if (r24 == true) goto L20;
        if (r10.isUserInteractionEnabled() == true) goto L20;
    L42:
        r14 = r14 - 1;
    L20:
        if (r10.getVisibility() == false) goto L42;
        if (r10.getDrawParent() != null) goto L24;
    L27:
        if (r13 == true) goto L42;
        float[] r18 = {r22, r23};
        if (this.mContext.h() == false) goto L32;
        LynxBaseUI r19 = r10;
        r18 = getTargetPoint(r18[0], r18[1], getScrollX(), getScrollY(), r10.getRectWithoutTransform(), r10.getTransformMatrix());
        boolean r20 = r19.containsPoint(r18[0], r18[1], r24);
    L33:
        if (r20 == false) goto L42;
        r11.add(r19);
        if (r19.isOnResponseChain() == true) goto L36;
        if (r15 != null) goto L40;
    L41:
        r16 = r18[0];
        r17 = r18[1];
        r15 = r19;
        goto L42
    L40:
        if (r15.getRealTimeTranslationZ() >= r19.getRealTimeTranslationZ()) goto L42;
    L36:
        r16 = r18[0];
        r17 = r18[1];
        r15 = r19;
        goto L37
    L32:
        r19 = r10;
        r20 = r19.containsPoint(r18[0], r18[1], r24);
        goto L33
    L24:
        if (((LynxUI) r10.getDrawParent()).getView() == null) goto L27;
        if (((LynxUI) r10.getDrawParent()).getView().getParent() == null) goto L42;
    L15:
        r13 = false;
    L37:
        float r21 = r16;
        float r25 = r17;
        if (r15 != null) goto L46;
        wm.a r26 = this;
    L59:
        if (r26 != null) goto L61;
    L64:
        int r110 = 0;
    L66:
        if (r110 >= r11.size()) goto L95;
        LynxBaseUI r111 = (LynxBaseUI) r11.get(r110);
        if (r111 == null) goto L94;
        if (r111 == r15) goto L94;
        if (this.mContext.h() == false) goto L75;
        float[] r27 = getTargetPoint(r22, r23, getScrollX(), getScrollY(), r111.getRectWithoutTransform(), r111.getTransformMatrix());
    L84:
        float r28 = r27[0];
        float r29 = r27[1];
        if (r111.isCustomHittest() == false) goto L87;
    L91:
        r26 = r111.hitTest(r28, r29, r24);
    L92:
        if (r26 == null) goto L94;
    L63:
        wm.a r112 = r26;
    L96:
        if (r112 == null) goto L98;
        return r112;
    L98:
        return this;
    L87:
        if (r111.needCustomLayout() == false) goto L91;
        if ((r111 instanceof UIGroup) == false) goto L91;
        UIGroup r113 = (UIGroup) r111;
        r26 = r113.findUIWithCustomLayout(r28, r29, r113);
        goto L92
    L75:
        if (r111.isCustomHittest() == false) goto L77;
    L82:
        float r30 = ((r111.getScrollX() - r111.getOriginLeft()) - r111.getTranslationX()) + r22;
        float r31 = ((r111.getScrollY() - r111.getOriginTop()) - r111.getTranslationY()) + r23;
    L83:
        r27 = new float[]{r30, r31};
        goto L84
    L77:
        if (r111.needCustomLayout() == false) goto L82;
        if ((r111 instanceof UIGroup) == false) goto L82;
        r30 = r22 - r111.getOriginLeft();
        r31 = r23 - r111.getOriginTop();
    L94:
        r110 = r110 + 1;
        goto L66
    L95:
        r112 = null;
        goto L96
    L61:
        if (r26.pointerEvents() != EventTarget$PointerEventsValue.f10248b) goto L63;
    L46:
        if (r15.isCustomHittest() == true) goto L56;
        if (r15.needCustomLayout() == false) goto L56;
        if ((r15 instanceof UIGroup) == false) goto L56;
        UIGroup r32 = (UIGroup) r15;
        if (this.mContext.h() == false) goto L54;
        r26 = r32.findUIWithCustomLayout(r21, r25, r32);
        goto L59
    L54:
        r26 = r32.findUIWithCustomLayout(r22 - r32.getOriginLeft(), r23 - r32.getOriginTop(), r32);
    L56:
        if (this.mContext.h() == false) goto L58;
        r26 = r15.hitTest(r21, r25, r24);
        goto L59
    L58:
        r26 = r15.hitTest(((r15.getScrollX() + r22) - r15.getOriginLeft()) - r15.getTranslationX(), ((r15.getScrollY() + r23) - r15.getOriginTop()) - r15.getTranslationY(), r24);
        goto L59
    }

    public void onLayoutFinish(long r5, @Nullable LynxBaseUI r10) {
    }

    @com.lynx.tasm.behavior.f0
    public void scrollIntoView(ReadableMap r5, Callback r10) {
        if (r5 != null) goto L7;
        if (r10 == null) goto L25;
        r10.invoke(new Object[]{4, "missing the param of `scrollIntoViewOptions`"});
        return;
    L25:
        return;
    L7:
        HashMap r11 = (HashMap) r5.asHashMap().get("scrollIntoViewOptions");
        if (r11 != null) goto L12;
        r10.invoke(new Object[]{4, "missing the param of `scrollIntoViewOptions`"});
        return;
    L12:
        if (r11.containsKey("behavior") == false) goto L14;
        String r12 = (String) r11.get("behavior");
    L16:
        if (r11.containsKey("block") == false) goto L18;
        String r13 = (String) r11.get("block");
    L20:
        if (r11.containsKey("inline") == false) goto L22;
        String r14 = (String) r11.get("inline");
    L23:
        scrollIntoView(r12.equals("smooth"), r13, r14, r10);
        return;
    L22:
        r14 = "nearest";
        goto L23
    L18:
        r13 = "start";
        goto L20
    L14:
        r12 = "auto";
        goto L16
    }

    @com.lynx.tasm.behavior.d0(customType = "Color", names = {"border-left-color", "border-right-color", "border-top-color", "border-bottom-color"})
    public void setBorderColor(int r5, Integer r10) {
        d();
        com.lynx.tasm.behavior.ui.utils.g r11 = this.mLynxBackground;
        int r12 = SPACING_TYPES[r5 + 1];
        r11.getClass();
        float r13 = 1.0E21f;
        if (r10 != null) goto L5;
        float r14 = 1.0E21f;
    L6:
        if (r10 == null) goto L9;
        r13 = r10.intValue() >>> 24;
    L9:
        BackgroundDrawable r15 = (BackgroundDrawable) r11.d();
        if (r15.f10709i != null) goto L12;
        r15.f10709i = new com.lynx.tasm.behavior.ui.utils.l(0.0f);
    L12:
        r15.f10709i.b(r14, r12);
        if (r15.f10710j != null) goto L15;
        r15.f10710j = new com.lynx.tasm.behavior.ui.utils.l(255.0f);
    L15:
        r15.f10710j.b(r13, r12);
        return;
    L5:
        r14 = r10.intValue() & ViewCompat.MEASURED_SIZE_MASK;
        goto L6
    }

    @com.lynx.tasm.behavior.d0(names = {"border-radius", "border-top-left-radius", "border-top-right-radius", "border-bottom-right-radius", "border-bottom-left-radius"})
    public void setBorderRadius(int r5, @Nullable ReadableArray r10) {
        d();
        this.mHasRadius = false;
        if (this.mLynxBackground.l(r5, r10) == false) goto L5;
        this.mHasRadius = true;
    L5:
        onBorderRadiusUpdated(r5);
    }

    @com.lynx.tasm.behavior.d0(names = {"border-width", "border-left-width", "border-right-width", "border-top-width", "border-bottom-width"})
    public void setBorderWidth(int r5, int r10) {
        d();
        this.mBorderSpacingIndex = r5;
        this.mBorderWidth = r10;
        com.lynx.tasm.behavior.ui.utils.g r11 = this.mLynxBackground;
        int[] r12 = SPACING_TYPES;
        float r13 = r10;
        r11.d().b(r12[r5], r13);
        com.lynx.tasm.behavior.ui.utils.i r14 = this.mLynxMask;
        if (r14 == null) goto L6;
        r14.d().b(r12[r5], r13);
        return;
    }

    public void setOverflow(int r5) {
        setOverflowWithMask(3, r5);
    }

    public float[] getTargetPoint(float r10, float r11, int r12, int r13, View r14, Matrix r15) {
        return getTargetPoint(r10, r11, r12, r13, new Rect(r14.getLeft(), r14.getTop(), 0, 0), r15);
    }

    @Deprecated
    public void setBorderColor(Integer r10) {
        d();
        float r5 = 1.0E21f;
        if (r10 != null) goto L5;
        float r11 = 1.0E21f;
    L6:
        if (r10 == null) goto L9;
        r5 = r10.intValue() >>> 24;
    L9:
        int r12 = 1;
    L11:
        if (r12 > 4) goto L19;
        com.lynx.tasm.behavior.ui.utils.g r13 = this.mLynxBackground;
        int r14 = SPACING_TYPES[r12];
        BackgroundDrawable r15 = (BackgroundDrawable) r13.d();
        if (r15.f10709i != null) goto L15;
        r15.f10709i = new com.lynx.tasm.behavior.ui.utils.l(0.0f);
    L15:
        r15.f10709i.b(r11, r14);
        if (r15.f10710j != null) goto L18;
        r15.f10710j = new com.lynx.tasm.behavior.ui.utils.l(255.0f);
    L18:
        r15.f10710j.b(r5, r14);
        r12 = r12 + 1;
        goto L11
    L19:
        return;
    L5:
        r11 = r10.intValue() & ViewCompat.MEASURED_SIZE_MASK;
        goto L6
    }

    @Deprecated
    public void updateLayout(int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, Rect r31) {
        updateLayoutInfo(r19, r20, r21, r22, r23, r24, r25, r26, 0, 0, 0, 0, r27, r28, r29, r30, r31);
        onLayoutUpdated();
    }

    @Deprecated
    public void scrollIntoView(boolean r5, String r10, String r11) {
        scrollIntoView(r5, r10, r11, null);
    }

    public final JavaOnlyMap a(boolean r5) {
        new RectF();
        if (r5 == false) goto L5;
        RectF r10 = i.a.d(this, new RectF(0.0f, 0.0f, getWidth(), getHeight()));
    L6:
        float r11 = getLynxContext().f10152u.density;
        JavaOnlyMap r12 = new JavaOnlyMap();
        r12.putString("id", getIdSelector());
        r12.putMap("dataset", (WritableMap) getDataset());
        r12.putDouble(OpenPageMethod.ALIGN_LEFT, r10.left / r11);
        r12.putDouble("top", r10.top / r11);
        r12.putDouble("right", r10.right / r11);
        r12.putDouble("bottom", r10.bottom / r11);
        r12.putDouble("width", r10.width() / r11);
        r12.putDouble("height", r10.height() / r11);
        return r12;
    L5:
        r10 = new RectF(getBoundingClientRect());
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void scrollIntoView(boolean r5, String r10, String r11, Callback r12) {
        Boolean r13 = Boolean.FALSE;
        LynxBaseUI r14 = (LynxBaseUI) getParent();
    L3:
        if (r14 == null) goto L16;
        if ((r14 instanceof AbsLynxUIScroll) == true) goto L6;
        if ((r14 instanceof LynxUIScrollViewInternal) == true) goto L9;
        r14 = (LynxBaseUI) r14.getParent();
        goto L3
    L9:
        LynxUIScrollViewInternal r15 = (LynxUIScrollViewInternal) r14;
        if (((LynxBaseScrollView) r15.getView()).f17351c == true) goto L13;
        r10 = r11;
    L13:
        r15.b(r10, this, r5);
        r13 = Boolean.TRUE;
        goto L16
    L6:
        ((AbsLynxUIScroll) r14).b(this, r5, r10, r11);
        r13 = Boolean.TRUE;
    L16:
        if (r13.booleanValue() == true) goto L21;
        LynxLog.b(4, TAG, "scrollIntoView failed for nodeId:" + getSign());
        if (r12 == null) goto L27;
        r12.invoke(new Object[]{8, "scrollIntoView failed for nodeId:" + getSign()});
        return;
    L27:
        return;
    L21:
        if (r12 == null) goto L28;
        r12.invoke(new Object[]{0});
        return;
    }

    public void updateLayoutInfo(LynxBaseUI r19) {
        updateLayoutInfo(r19.getLeft(), r19.getTop(), r19.getWidth(), r19.getHeight(), r19.getPaddingLeft(), r19.getPaddingTop(), r19.getPaddingRight(), r19.getPaddingBottom(), r19.getMarginLeft(), r19.getMarginTop(), r19.getMarginRight(), r19.getMarginBottom(), r19.getBorderLeftWidth(), r19.getBorderTopWidth(), r19.getBorderRightWidth(), r19.getBorderBottomWidth(), r19.getBound());
        this.mOriginLeft = r19.getOriginLeft();
        this.mOriginTop = r19.getOriginTop();
    }
}
