package com.lynx.tasm.behavior.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.animation.AnimationConstant;
import com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.text.AndroidText;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.event.LynxTouchEvent;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.utils.BitmapUtils;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import com.lynx.tasm.utils.LRUHashMap;
import com.lynx.tasm.utils.UIThreadUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class LynxUI<T extends View> extends LynxBaseUI implements com.lynx.tasm.behavior.ui.a {
    protected static final boolean ENABLE_ZINDEX = false;
    private static final float OFFSET_ROTATE_AUTO = -1024.0f;
    private static final float OFFSET_ROTATE_AUTO_WITH_ANGLE_BASE = -1000000.0f;
    private static final float OFFSET_ROTATE_AUTO_WITH_ANGLE_RANGE = 360.0f;
    private static final String TAG = "LynxUI";
    protected float mAlpha;
    private s6a.a[] mAnimationInfos;
    private com.lynx.tasm.behavior.ui.utils.a mBackgroundManager;
    private float mBrightnessAmount;
    protected i7a.a mClipPath;
    private float mContrastAmount;
    protected LynxBaseUI mDrawHead;
    private boolean mEnableReuseAnimationState;
    protected boolean mFirstRender;
    private float mGrayscaleAmount;
    private w6a.e mHeroAnimOwner;
    private float mHueRotateAmount;
    protected boolean mIsAutoOffsetRotate;
    private com.lynx.tasm.animation.keyframe.a mKeyframeManager;
    private t6a.c mLayoutAnimator;
    protected float mOffsetDistance;
    protected boolean mOffsetHasChanged;
    protected i7a.a mOffsetPath;
    protected float mOffsetRotate;
    protected float mOffsetRotateAngle;
    protected com.lynx.tasm.base.h<T> mOnceTask;
    private boolean mOverlappingRendering;
    protected ReadableArray mRawOffsetShape;
    private float mSaturateAmount;
    private boolean mSetVisibleByCSS;
    private u6a.a mTransitionAnimator;
    protected T mView;
    protected m mViewInfo;

    public class a implements Callable<T> {
        public final /* synthetic */ LynxUI a;

        @Override // java.util.concurrent.Callable
        public T call() {
            LynxUI r0 = this.a;     // Catch: Throwable -> L6
            if (r0.createView(r0.mContext, r0.mParam) != null) goto L12;
            LynxUI r1 = this.a;     // Catch: Throwable -> L6
            return (T) r1.createView(r1.mContext);
        L12:
            return null;
        L6:
            th = move-exception;
            LLog.e(LynxUI.TAG, th.toString());
            return null;
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Object call() throws Exception {
            return call();
        }

        public a(LynxUI r1) {
            this.a = r1;
        }
    }

    public class b implements Consumer<Exception> {
        public final /* synthetic */ LynxUI a;

        public b(LynxUI r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Exception r3 = (Exception) r2;
            LynxContext r0 = this.a.mContext;
            if (r0 == null) goto L6;
            r0.handleException(r3);
            return;
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ com.lynx.tasm.base.h a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(com.lynx.tasm.base.h r1) {
            this.a = r1;
        }
    }

    public class d implements Runnable {
        public final /* synthetic */ float a;
        public final /* synthetic */ Bitmap b;
        public final /* synthetic */ Bitmap.CompressFormat c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Callback e;

        public final void a() {
            if (this.a == 1.0f) goto L5;
            Matrix r6 = new Matrix();
            float r0 = this.a;
            r6.setScale(r0, r0);
            Bitmap r1 = this.b;
            Bitmap r2 = Bitmap.createBitmap(r1, 0, 0, r1.getWidth(), this.b.getHeight(), r6, true);
            this.b.recycle();
        L6:
            String r3 = BitmapUtils.bitmapToBase64(r2, this.c, 100, 2);
            JavaOnlyMap r4 = new JavaOnlyMap();
            r4.putInt("width", r2.getWidth());
            r4.putInt("height", r2.getHeight());
            r4.putString(LynxResourceModule.DATA_KEY, this.d + r3);
            this.e.invoke(new Object[]{0, r4});
            r2.recycle();
            return;
        L5:
            r2 = this.b;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(float r1, Bitmap r2, Bitmap.CompressFormat r3, String r4, Callback r5) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    static {
        ENABLE_ZINDEX = false;
    }

    private static boolean isEncodedAutoOffsetRotate(float r1) {
        if (r1 <= OFFSET_ROTATE_AUTO_WITH_ANGLE_BASE) goto L5;
    L7:
        return false;
    L5:
        if (r1 <= (-1000360.0f)) goto L7;
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void afterDispatchProcessViewInfo(m r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void afterProcessChildViewInfo(m r1, View r2, long r3) {
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void afterProcessViewInfo(m r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void beforeDispatchProcessViewInfo(m r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void beforeProcessChildViewInfo(m r1, View r2, long r3) {
    }

    public T createView(Context r1) {
        return null;
    }

    public LynxUI getTransitionUI() {
        return null;
    }

    public void initAccessibilityDelegate() {
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void processLayoutChildren() {
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void processMeasureChildren() {
    }

    public void setLayoutAnimationCreateTimingFunc(String r1) {
    }

    private void prepareKeyframeManager() {
        if (this.mKeyframeManager != null) goto L6;
        this.mKeyframeManager = new com.lynx.tasm.animation.keyframe.a(this);
        return;
    }

    private void prepareLayoutAnimator() {
        if (this.mLayoutAnimator != null) goto L6;
        this.mLayoutAnimator = new t6a.c();
        return;
    }

    private boolean shouldDoTransformTransition() {
        if (this.mIsFirstAnimatedReady == false) goto L5;
    L11:
        return false;
    L5:
        if (this.hasTransformChanged == false) goto L11;
        u6a.a r0 = this.mTransitionAnimator;
        if (r0 == null) goto L11;
        if (r0.b(4096) == false) goto L11;
        return true;
    }

    public void didEnsureCreateView() {
        com.lynx.tasm.behavior.ui.utils.a r0 = this.mBackgroundManager;
        if (r0 == null) goto L8;
        Drawable r1 = r0.b;
        if (((BackgroundDrawable) r1) == null) goto L8;
        this.mView.setBackground((BackgroundDrawable) r1);
    L8:
        if (this.mAlpha == this.mView.getAlpha()) goto L11;
        this.mView.setAlpha(this.mAlpha);
    L11:
        if (this.mAnimationInfos == null) goto L14;
        prepareKeyframeManager();
        com.lynx.tasm.animation.keyframe.a r2 = this.mKeyframeManager;
        r2.b = this.mAnimationInfos;
        r2.c();
        return;
    }

    public void dispatchProcessViewInfo() {
        LynxBaseUI r0 = this.mDrawHead;
    L3:
        if (r0 == null) goto L8;
        if ((r0 instanceof LynxUI) == false) goto L7;
        processChildViewInfo((LynxUI) r0);
    L7:
        r0 = r0.mNextDrawUI;
        goto L3
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean enableLayoutAnimation() {
        t6a.c r0 = this.mLayoutAnimator;
        if (r0 == null) goto L21;
        t6a.d r2 = r0.t;
        if (r2 != null) goto L7;
    L8:
        t6a.e r3 = r0.v;
        if (r3 != null) goto L11;
    L12:
        t6a.g r1 = r0.u;
        if (r1 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L22;
        return true;
    L22:
        return false;
    L15:
        if (r1.c() == false) goto L17;
    L16:
        r4 = true;
        goto L18
    L11:
        if (r3.c() == true) goto L16;
    L7:
        if (r2.c() == true) goto L16;
    L21:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ensureCreateView() {
        com.lynx.tasm.base.h<T> r0 = this.mOnceTask;
        if (r0 == null) goto L6;
        r0.run();
        this.mView = this.mOnceTask.a();
        this.mOnceTask = null;
    L6:
        if (this.mView != null) goto L10;
        T r1 = (T) createView(this.mContext, this.mParam);
        this.mView = r1;
        if (r1 != null) goto L10;
        this.mView = (T) createView(this.mContext);
    L10:
        T r2 = this.mView;
        if ((r2 instanceof IDrawChildHook.IDrawChildHookBinding) == false) goto L16;
        if ((this instanceof IDrawChildHook) == false) goto L16;
        ((IDrawChildHook.IDrawChildHookBinding) r2).bindDrawChildHook((IDrawChildHook) this);
    L16:
        if ((this.mDrawParent instanceof UIGroup) == true) goto L18;
    L20:
        didEnsureCreateView();
        this.mView.requestLayout();
        this.mView.invalidate();
        return;
    L18:
        if (this.mView.getParent() != null) goto L20;
        ((UIGroup) this.mDrawParent).insertChildWhenRebuildView(this);
        goto L20
    }

    public void execPauseAnim() {
        w6a.e r0 = this.mHeroAnimOwner;
        r0.getClass();
        if (w6a.h.a.a.g == true) goto L5;
        return;
    L5:
        if (r0.a() == true) goto L16;
        s6a.a r1 = r0.g;
        if (r1 == null) goto L14;
        r0.a.setAnimation(r1);
        if (r0.a.getKeyframeManager() == null) goto L15;
        r0.a.getKeyframeManager().c();
        return;
    L15:
        return;
    L14:
        return;
    }

    public void execResumeAnim() {
        w6a.e r0 = this.mHeroAnimOwner;
        r0.getClass();
        if (w6a.h.a.a.g == true) goto L5;
        return;
    L5:
        if (r0.a() == true) goto L16;
        s6a.a r1 = r0.h;
        if (r1 == null) goto L14;
        r0.a.setAnimation(r1);
        if (r0.a.getKeyframeManager() == null) goto L15;
        r0.a.getKeyframeManager().c();
        return;
    L15:
        return;
    L14:
        return;
    }

    public int getBackgroundColor() {
        return this.mBackgroundManager.e;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getRealTimeTranslationZ() {
        return this.mView.getTranslationZ();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getScaleX() {
        T r0 = this.mView;
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return r0.getScaleX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getScaleY() {
        T r0 = this.mView;
        if (r0 != null) goto L7;
        return 1.0f;
    L7:
        return r0.getScaleY();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public Matrix getTransformMatrix() {
        T r0 = this.mView;
        if (r0 == null) goto L10;
        if (r0.getMatrix() == null) goto L10;
        return this.mView.getMatrix();
    L10:
        return super.getTransformMatrix();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getTranslationX() {
        return this.mView.getTranslationX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getTranslationY() {
        return this.mView.getTranslationY();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean getVisibility() {
        if (this.mSetVisibleByCSS == true) goto L5;
    L7:
        return false;
    L5:
        if (super.getVisibility() == false) goto L7;
        return true;
    }

    public boolean hasAnimationRunning() {
        com.lynx.tasm.animation.keyframe.a r0 = this.mKeyframeManager;
        if (r0 == null) goto L17;
        HashMap<String, LynxKeyframeAnimator> r1 = r0.c;
        if (r1 == null) goto L15;
        Iterator<LynxKeyframeAnimator> r2 = r1.values().iterator();
    L8:
        if (r2.hasNext() == false) goto L15;
        if (r2.next().h != LynxKeyframeAnimator.LynxKFAnimatorState.RUNNING) goto L12;
        boolean r3 = true;
    L13:
        if (r3 == false) goto L8;
        boolean r4 = true;
    L16:
        if (r4 == false) goto L17;
    L25:
        return true;
    L12:
        r3 = false;
    L15:
        r4 = false;
    L17:
        u6a.a r5 = this.mTransitionAnimator;
        if (r5 != null) goto L20;
    L21:
        T r6 = this.mView;
        if (r6 != null) goto L24;
        return false;
    L24:
        if (r6.getAnimation() != null) goto L25;
        return false;
    L20:
        if ((!r5.h.isEmpty()) == true) goto L25;
        goto L21
    }

    public boolean hasOverlappingRenderingEnabled() {
        if ("HUAWEI".equals(Build.MANUFACTURER) == false) goto L9;
        if (DeviceUtils.is64BitDevice() == true) goto L9;
        LLog.i(TAG, "Disable overlap rendering for Huawei 32bit machine");
        return false;
    L9:
        return this.mOverlappingRendering;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public void invalidate() {
        T r0 = this.mView;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.invalidate();
    }

    public boolean isRtl() {
        if (this.mLynxDirection != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public boolean isUserInteractionEnabled() {
        if (this.userInteractionEnabled == false) goto L9;
        T r0 = this.mView;
        if (r0 == null) goto L9;
        if (r0.getVisibility() != 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean isVisible() {
        T r0 = this.mView;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (r0.getVisibility() == 0) goto L9;
        return false;
    L9:
        if (this.mView.getAlpha() >= 0.01d) goto L12;
        return false;
    L12:
        return this.mView.isAttachedToWindow();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDrawingPositionChanged() {
        if (this.mView.isLayoutRequested() == true) goto L6;
        handleLayout();
        invalidate();
        return;
    }

    public void processViewInfo() {
        beforeProcessViewInfo(this.mViewInfo);
        beforeDispatchProcessViewInfo(this.mViewInfo);
        dispatchProcessViewInfo();
        afterDispatchProcessViewInfo(this.mViewInfo);
        afterProcessViewInfo(this.mViewInfo);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void registerViewAccordingToNodeIndex() {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getUIBodyView() == null) goto L10;
        this.mContext.getUIBodyView().registerViewAccordingToNodeIndex(this.mNodeIndex, this.mView);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public void requestLayout() {
        this.mView.requestLayout();
    }

    public void setLayoutParamsInternal() {
        k r0 = this.mParent;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((r0 instanceof UIGroup) == true) goto L7;
        return;
    L7:
        if (((UIGroup) r0).needCustomLayout() == false) goto L15;
        ViewGroup.LayoutParams r1 = this.mView.getLayoutParams();
        ViewGroup.LayoutParams r2 = ((UIGroup) this.mParent).generateLayoutParams(r1);
        if (r2 == null) goto L16;
        if (r1 == r2) goto L17;
        updateLayoutParams(r2);
        return;
    L17:
        return;
    L16:
        return;
    }

    public void updatePerspectiveToView() {
        float r0 = this.mContext.getScreenMetrics().density;
        ReadableArray r1 = this.mPerspective;
        if (r1 == null) goto L25;
        if (r1.size() <= 1) goto L25;
        if (this.mPerspective.getInt(1) == 3) goto L25;
        if (this.mPerspective.getInt(1) != 0) goto L12;
        double r3 = r0;
        float r2 = (float) (((this.mPerspective.getDouble(0) * r3) * r3) * ((double) LynxBaseUI.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
    L31:
        if (this.mPrePerspectiveValue == r2) goto L34;
        this.mPrePerspectiveValue = r2;
        this.mView.setCameraDistance(r2);
        return;
    L34:
        return;
    L12:
        if (this.mPerspective.getInt(1) == 1) goto L16;
        if (this.mPerspective.getInt(1) == 2) goto L16;
    L22:
        double r4 = this.mPerspective.getDouble(0);
    L23:
        float r5 = ((float) r4) * r0;
        float r6 = LynxBaseUI.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    L29:
        r2 = r6 * r5;
    L16:
        if (this.mContext.getUIBody() == null) goto L22;
        if (this.mPerspective.getInt(1) != 1) goto L20;
        double r7 = this.mPerspective.getDouble(0) / 100.0d;
        int r8 = this.mContext.getUIBody().getLatestWidth();
    L21:
        r4 = r7 * ((double) r8);
        goto L23
    L20:
        r7 = this.mPerspective.getDouble(0) / 100.0d;
        r8 = this.mContext.getUIBody().getLatestHeight();
    L25:
        if (getWidth() <= getHeight()) goto L27;
        int r9 = getWidth();
    L28:
        r5 = (r9 * r0) * LynxBaseUI.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        r6 = 100.0f;
        goto L29
    L27:
        r9 = getHeight();
        goto L28
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void createViewAsync() {
        super.createViewAsync();
        com.lynx.tasm.base.h<T> r0 = new com.lynx.tasm.base.h(new a(this), new b(this));
        this.mOnceTask = r0;
        LynxThreadPool.g(new c(r0));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        u6a.a r0 = this.mTransitionAnimator;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        com.lynx.tasm.animation.keyframe.a r1 = this.mKeyframeManager;
        if (r1 == null) goto L9;
        r1.b();
        return;
    }

    public void handleLayout() {
        if (isDetachedWithView() == false) goto L6;
        return;
    L6:
        if (TraceEvent.isTracingStarted() == false) goto L8;
        String r0 = "LynxUI.layout." + getTagName();
        TraceEvent.beginSection(r0);
    L9:
        this.mView.layout(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
        if ((getParent() instanceof UIShadowProxy) == false) goto L13;
        ((UIShadowProxy) getParent()).a.getTransformRaws();
    L13:
        if ((this.mView.getParent() instanceof ViewGroup) == false) goto L28;
        ViewGroup r1 = (ViewGroup) this.mView.getParent();
        if (getSkewX() == 0.0f) goto L17;
    L20:
        boolean r2 = true;
    L22:
        if (getOverflow() != 0) goto L24;
        if (r2 == true) goto L24;
    L25:
        if (r2 == true) goto L28;
        ViewCompat.setClipBounds(this.mView, getBoundRectForOverflow());
    L24:
        r1.setClipChildren(false);
        goto L25
    L17:
        if (getSkewY() != 0.0f) goto L20;
        r2 = false;
    L28:
        if (getOverflow() == 0) goto L37;
        if (getWidth() != 0) goto L32;
    L33:
        T r3 = this.mView;
        if ((r3 instanceof AndroidText) == false) goto L37;
        ((AndroidText) r3).setOverflow(getOverflow());
        goto L37
    L32:
        if (getHeight() == 0) goto L33;
    L37:
        if (TraceEvent.isTracingStarted() == false) goto L40;
        TraceEvent.endSection(r0);
        return;
    L40:
        return;
    L8:
        r0 = null;
        goto L9
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void initialize() {
        super.initialize();
        T r0 = (T) getOrCreateView(this.mContext, this.mParam);
        this.mView = r0;
        if (r0 != null) goto L5;
        return;
    L5:
        this.mHeroAnimOwner = new w6a.e(this);
        com.lynx.tasm.behavior.ui.utils.a r1 = new com.lynx.tasm.behavior.ui.utils.a(this, getLynxContext());
        this.mBackgroundManager = r1;
        setLynxBackground(r1);
        com.lynx.tasm.behavior.ui.utils.a r2 = this.mBackgroundManager;
        r2.c = this.mDrawableCallback;
        com.lynx.tasm.behavior.ui.accessibility.d r3 = this.mContext.getLynxAccessibilityWrapper();
        if (r3 != null) goto L8;
        return;
    L8:
        if (r3.f() == false) goto L12;
        initAccessibilityDelegate();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void measure() {
        if (TraceEvent.isTracingStarted() == false) goto L5;
        String r0 = "LynxUI.measure." + getTagName();
        TraceEvent.beginSection(r0);
    L7:
        if (isDetachedWithView() == true) goto L10;
        setLayoutParamsInternal();
        this.mView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
    L10:
        if (TraceEvent.isTracingStarted() == false) goto L13;
        TraceEvent.endSection(r0);
        return;
    L13:
        return;
    L5:
        r0 = null;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAnimationNodeReady() {
        super.onAnimationNodeReady();
        updatePerspectiveToView();
        if (shouldDoTransform() == false) goto L59;
        com.lynx.tasm.behavior.ui.utils.a r0 = this.mBackgroundManager;
        com.lynx.tasm.behavior.ui.utils.l r3 = this.mTransformOrigin;
        LynxUI r1 = r0.f.get();
        if (r1 == null) goto L46;
        if (r1.getView() == null) goto L46;
        if (r3 == null) goto L46;
        float r4 = r1.getLatestWidth();
        float r5 = r1.getLatestHeight();
        com.lynx.tasm.behavior.ui.utils.m r6 = new com.lynx.tasm.behavior.ui.utils.m();
        r6.a = r4 * 0.5f;
        r6.b = r5 * 0.5f;
        if (r3 == com.lynx.tasm.behavior.ui.utils.l.e) goto L44;
        float r8 = r3.a;
        if (r8 == 0.5f) goto L17;
    L20:
        boolean r9 = true;
    L21:
        if (r9 == true) goto L23;
    L29:
        float r7 = r3.c;
        if (r7 == 0.5f) goto L32;
    L35:
        boolean r10 = true;
    L36:
        if (r10 == false) goto L44;
        if (r3.d != 1) goto L40;
        boolean r11 = true;
    L41:
        if (r11 == false) goto L43;
        r7 = r7 * r5;
    L43:
        r6.b = r7;
        goto L44
    L40:
        r11 = false;
        goto L41
    L32:
        if (r3.d != 1) goto L35;
        r10 = false;
        goto L36
    L23:
        if (r3.b != 1) goto L25;
        boolean r12 = true;
    L26:
        if (r12 == false) goto L28;
        r8 = r8 * r4;
    L28:
        r6.a = r8;
        goto L29
    L25:
        r12 = false;
        goto L26
    L17:
        if (r3.b != 1) goto L20;
        r9 = false;
    L44:
        r1.getView().setPivotX(r6.a);
        r1.getView().setPivotY(r6.b);
        r1.getView().invalidate();
    L46:
        if (shouldDoTransformTransition() == false) goto L52;
        u6a.a r2 = this.mTransitionAnimator;
        LynxBaseUI r13 = r2.g;
        if (r13 != null) goto L51;
        r13 = this;
    L51:
        r2.a(r13, 4096, r13.getTransformRaws());
        goto L59
    L52:
        u6a.a r14 = this.mTransitionAnimator;
        if (r14 == null) goto L55;
        r14.f(4096);
    L55:
        this.mBackgroundManager.t(this.mTransformRaw);
        if (this.mOffsetPath == null) goto L59;
        this.mOffsetHasChanged = true;
    L59:
        if (this.mOffsetHasChanged == false) goto L91;
        i7a.a r15 = this.mOffsetPath;
        if (r15 == null) goto L90;
        Path r16 = r15.c(getWidth(), getHeight());
        float r17 = this.mOffsetDistance;
        LRUHashMap<Path, i7a.b.a> r18 = i7a.b.a;
        if (r16 != null) goto L65;
        float[] r19 = {0.0f, 0.0f, 0.0f};
    L87:
        if (this.mIsAutoOffsetRotate == false) goto L89;
        applyOffsetAndRotate(r19[0], r19[1], r19[2] + this.mOffsetRotateAngle);
        goto L90
    L89:
        applyOffsetAndRotate(r19[0], r19[1], this.mOffsetRotate);
        goto L90
    L65:
        float r20 = Math.max(0.0f, Math.min(1.0f, r17));
        i7a.b.a r21 = i7a.b.a.get(r16);
        if (r21 != null) goto L71;
        i7a.b.a r22 = new i7a.b.a();
        PathMeasure r23 = new PathMeasure(r16, false);
    L68:
        float r24 = r23.getLength();
        ((ArrayList) r22.b).add(Float.valueOf(r24));
        r22.a += r24;
        if (r23.nextContour() == true) goto L68;
        i7a.b.a.put(r16, r22);
        r21 = r22;
    L71:
        float r25 = r21.a * r20;
        int r26 = 0;
        float r27 = 0.0f;
    L73:
        if (r26 >= ((ArrayList) r21.b).size()) goto L78;
        float r110 = ((Float) ListProtector.get(r21.b, r26)).floatValue() + r27;
        if (r25 <= r110) goto L79;
        r26 = r26 + 1;
        r27 = r110;
    L79:
        PathMeasure r28 = new PathMeasure(r16, false);
        int r29 = 0;
    L80:
        if (r29 >= r26) goto L82;
        r28.nextContour();
        r29 = r29 + 1;
        goto L80
    L82:
        float[] r30 = new float[2];
        float[] r31 = new float[2];
        r28.getPosTan(r25 - r27, r30, r31);
        float r32 = (float) Math.toDegrees(Math.atan2(r31[1], r31[0]));
        if (r32 >= 0.0f) goto L85;
        r32 = r32 + OFFSET_ROTATE_AUTO_WITH_ANGLE_RANGE;
    L85:
        r19 = new float[]{r30[0], r30[1], r32};
        goto L87
    L78:
        r26 = 0;
    L90:
        this.mOffsetHasChanged = false;
    L91:
        u6a.a r33 = this.mTransitionAnimator;
        if (r33 != null) goto L94;
    L110:
        com.lynx.tasm.animation.keyframe.a r34 = this.mKeyframeManager;
        if (r34 == null) goto L113;
        r34.c();
    L113:
        LynxContext r35 = this.mContext;
        if (r35 != null) goto L116;
    L120:
        this.mHasTranslateDiff = false;
        return;
    L116:
        if (r35.isTouchMoving() == false) goto L120;
        if (this.mHasTranslateDiff == false) goto L120;
        this.mContext.onPropsChanged(this);
        goto L120
    L94:
        if (r33.i.isEmpty() == true) goto L110;
        Iterator<Map.Entry<Integer, Animator>> r36 = r33.i.entrySet().iterator();
    L98:
        if (r36.hasNext() == false) goto L109;
        Map.Entry<Integer, Animator> r37 = r36.next();
        Animator r38 = r33.h.get(r37.getKey());
        if (r38 == null) goto L102;
        r38.cancel();
    L102:
        Animator r39 = r37.getValue().clone();
        r39.setDuration(10000000);
        r39.setStartDelay(0);
        if ((r39 instanceof AnimatorSet) == false) goto L108;
        Iterator<Animator> r40 = ((AnimatorSet) r39).getChildAnimations().iterator();
    L106:
        if (r40.hasNext() == false) goto L108;
        r40.next().removeAllListeners();
    L108:
        r39.removeAllListeners();
        r39.addListener(new u6a.a.f());
        r39.start();
        r37.getValue().start();
        r33.h.put(r37.getKey(), r37.getValue());
        goto L98
    L109:
        r33.i.clear();
        goto L110
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        com.lynx.tasm.animation.keyframe.a r0 = this.mKeyframeManager;
        if (r0 == null) goto L16;
        HashMap<String, LynxKeyframeAnimator> r1 = r0.c;
        if (r1 == null) goto L24;
        Iterator<LynxKeyframeAnimator> r2 = r1.values().iterator();
    L9:
        if (r2.hasNext() == false) goto L25;
        LynxKeyframeAnimator r3 = r2.next();
        ObjectAnimator[] r4 = r3.g;
        if (r4 == null) goto L9;
        int r5 = r4.length;
        if (r5 <= 0) goto L9;
        r4[r5 - 1].addListener(new LynxKeyframeAnimator.c(r3));
        goto L9
    L25:
        return;
    L24:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        com.lynx.tasm.animation.keyframe.a r0 = this.mKeyframeManager;
        if (r0 == null) goto L15;
        HashMap<String, LynxKeyframeAnimator> r1 = r0.c;
        if (r1 == null) goto L15;
        Iterator<LynxKeyframeAnimator> r2 = r1.values().iterator();
    L9:
        if (r2.hasNext() == false) goto L15;
        ObjectAnimator[] r3 = r2.next().g;
        if (r3 == null) goto L9;
        int r4 = r3.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L9;
        r3[r5].removeAllListeners();
        r5 = r5 + 1;
    L15:
        t6a.c r6 = this.mLayoutAnimator;
        if (r6 == null) goto L24;
        r6.c();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        if (getBound() != null) goto L5;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == true) goto L13;
    L15:
        if (r0 == true) goto L19;
        this.mView.setVisibility(8);
        return;
    L19:
        return;
    L13:
        if (this.mSetVisibleByCSS == false) goto L15;
        this.mView.setVisibility(0);
        return;
    L5:
        if (getBound().width() > 0) goto L7;
    L9:
        r0 = false;
        goto L11
    L7:
        if (getBound().height() <= 0) goto L9;
        goto L9
    }

    public com.lynx.tasm.behavior.ui.utils.a getBackgroundManager() {
        return this.mBackgroundManager;
    }

    public LynxBaseUI getDrawHead() {
        return this.mDrawHead;
    }

    public w6a.e getFakeSharedElementManager() {
        return this.mHeroAnimOwner;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public com.lynx.tasm.animation.keyframe.a getKeyframeManager() {
        return this.mKeyframeManager;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public t6a.c getLayoutAnimator() {
        return this.mLayoutAnimator;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public u6a.a getTransitionAnimator() {
        return this.mTransitionAnimator;
    }

    public T getView() {
        return this.mView;
    }

    public m getViewInfo() {
        return this.mViewInfo;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void layout() {
        handleLayout();
    }

    public LynxUI(Context r1) {
        this((LynxContext) r1);
    }

    private static float decodeAutoOffsetRotateAngle(float r1) {
        if (isEncodedAutoOffsetRotate(r1) == true) goto L7;
        return 0.0f;
    L7:
        return OFFSET_ROTATE_AUTO_WITH_ANGLE_BASE - r1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void attachToView(LynxContext r3) {
        this.mContext = r3;
        if (this.mView != null) goto L8;
        T r0 = (T) r3.getUIBodyView().obtainViewAccordingToNodeIndex(this.mNodeIndex);
        if (r0 == null) goto L7;
        this.mView = r0;
        goto L8
    L7:
        createViewAsync();
    L8:
        this.mContext.getUIBody().appendUIWithCreateViewAsync(this);
        super.attachToView(r3);
    }

    @Override // com.lynx.tasm.behavior.ui.a
    public void beforeProcessViewInfo(m r2) {
        r2.e = getSkewX();
        r2.f = getSkewY();
        r2.g = this.mClipPath;
        r2.c = getWidth();
        r2.d = getHeight();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void detachWithViewInfo(m r3) {
        registerViewAccordingToNodeIndex();
        m r0 = this.mViewInfo;
        if (r0 == null) goto L5;
        r3 = r0;
    L5:
        super.detachWithViewInfo(r3);
        m r4 = this.mViewInfo;
        if (r4 != null) goto L8;
    L11:
        this.mView = null;
        return;
    L8:
        if (this.mKeyframeManager == null) goto L10;
        r4.getClass();
        this.mKeyframeManager = null;
    L10:
        this.mViewInfo.a = null;
        this.mViewInfo = null;
        goto L11
    }

    public void execEnterAnim(w6a.h.b r12) {
        w6a.e r0 = this.mHeroAnimOwner;
        r0.getClass();
        w6a.h r1 = w6a.h.a.a;
        if (r1.g == true) goto L5;
        return;
    L5:
        if (r0.a() == true) goto L68;
        s6a.a r2 = r0.e;
        if (r2 != null) goto L10;
        return;
    L10:
        if (r0.i == null) goto L50;
        r0.j = true;
        String r3 = r0.i;
        LynxUI r4 = r0.a;
        monitor-enter(r1);
        WeakReference<View> r5 = r1.a.get(r3);     // Catch: Throwable -> L47
        if (r5 == null) goto L16;
        View r6 = r5.get();     // Catch: Throwable -> L47
    L17:
        if (r6 != null) goto L28;
        Iterator<Map.Entry<LynxUI, String>> r7 = r1.f.entrySet().iterator();     // Catch: Throwable -> L47
    L20:
        if (r7.hasNext() == false) goto L28;
        Map.Entry<LynxUI, String> r8 = r7.next();     // Catch: Throwable -> L47
        LynxUI r9 = r8.getKey();     // Catch: Throwable -> L47
        if (r4 == r9) goto L20;
        if (r8.getValue().equals(r3) == false) goto L20;
        r6 = r9.getView();     // Catch: Throwable -> L47
        monitor-exit(r1);
    L29:
        UIBody.UIBodyView r10 = r0.a.getLynxContext().getUIBody().getBodyView();
        if (r10 == null) goto L46;
        View r11 = r0.a.getView();
        if (r6 == null) goto L45;
        r11.setVisibility(r6.getVisibility());
        r11.setAlpha(r6.getAlpha());
        r11.setTranslationX(r6.getTranslationX());
        r11.setTranslationY(r6.getTranslationY());
        r11.setRotation(r6.getRotation());
        r11.setRotationX(r6.getRotationX());
        r11.setRotationY(r6.getRotationY());
        r11.setScaleX(r6.getScaleX());
        r11.setScaleY(r6.getScaleY());
        int r13 = r6.getWidth();
        int r14 = r6.getHeight();
        if ((r10.getRootView() instanceof ViewGroup) == false) goto L46;
        ViewGroup r15 = (ViewGroup) r10.getRootView();
        if (r11.getParent() == null) goto L44;
        ViewGroup r16 = (ViewGroup) r11.getParent();
        r0.c = r16;
        int r17 = r16.getChildCount();
        int r18 = 0;
    L38:
        if (r18 >= r17) goto L43;
        if (r11 == r0.c.getChildAt(r18)) goto L41;
        r18 = r18 + 1;
        goto L38
    L41:
        r0.b = r18;
    L43:
        r0.c.removeView(r11);
        r0.d = (UIGroup) r0.a.getParent();
    L44:
        ViewGroup.MarginLayoutParams r19 = new ViewGroup.MarginLayoutParams(r13, r14);
        int[] r20 = new int[2];
        r6.getLocationInWindow(r20);
        r19.setMargins(r20[0], r20[1], 0, 0);
        r15.addView(r11, r19);
        UIThreadUtils.runOnUiThread(new w6a.a(r0));
        goto L46
    L45:
        UIThreadUtils.runOnUiThread(new w6a.b(r0));
    L46:
        String r21 = r0.e.a;
        r0.l.put(r21, new w6a.d(r0, r12));
        return;
    L28:
        monitor-exit(r1);
        goto L29
    L16:
        r6 = null;
    L47:
        th = move-exception;
        throw th;
    L50:
        r0.a.setAnimation(r2);
        if (r0.a.getKeyframeManager() == null) goto L67;
        r0.a.getKeyframeManager().c();
        return;
    L67:
        return;
    }

    public void execExitAnim(w6a.h.c r5) {
        w6a.e r0 = this.mHeroAnimOwner;
        r0.getClass();
        if (w6a.h.a.a.g == true) goto L5;
        return;
    L5:
        if (r0.a() == true) goto L26;
        s6a.a r1 = r0.f;
        if (r1 == null) goto L22;
        String r2 = r1.a;
        r0.l.put(r2, new w6a.c(r0, r5));
        if (r0.i == null) goto L17;
        r0.k = true;
        ViewGroup r3 = (ViewGroup) r0.a.getLynxContext().getUIBody().getBodyView().getRootView();
        View r4 = r0.a.getView();
        r4.getLocationInWindow(new int[2]);
        ViewParent r6 = r4.getParent();
        if (r6 == null) goto L14;
        ((ViewGroup) r6).removeView(r4);
    L14:
        r3.addView(r4);
        r0.a.setAnimation(r0.f);
        if (r0.a.getKeyframeManager() == null) goto L23;
        r0.a.getKeyframeManager().c();
        return;
    L23:
        return;
    L17:
        r0.a.setAnimation(r0.f);
        if (r0.a.getKeyframeManager() == null) goto L25;
        r0.a.getKeyframeManager().c();
        return;
    L25:
        return;
    L22:
        return;
    }

    public ReadableMap getKeyframes(String r2) {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getKeyframes(r2);
    }

    public boolean hasTranslateDiff(ReadableArray r5) {
        List<n> r6 = n.d(r5);
        if (Float.compare(n.b(this.mTransformRaw), n.b(r6)) == 0) goto L5;
        boolean r0 = true;
    L7:
        if (Float.compare(n.c(this.mTransformRaw), n.c(r6)) == 0) goto L9;
        boolean r7 = true;
    L10:
        if (r0 == true) goto L15;
        if (r7 == true) goto L16;
        return false;
    L16:
        return true;
    L15:
        return true;
    L9:
        r7 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void initTransitionAnimator(ReadableMap r17) {
        if (this.mTransitionAnimator != null) goto L5;
        this.mTransitionAnimator = new u6a.a(getTransitionUI());
    L5:
        u6a.a r2 = this.mTransitionAnimator;
        r2.getClass();
        int r3 = 0;
        if (r17 == null) goto L55;
        ReadableArray r1 = r17.getArray("transition");
        if (r1 != null) goto L11;
        r2.e();
        goto L55
    L11:
        SparseArray<s6a.a> r4 = r2.j;
        r2.j = new SparseArray();
        int r5 = 0;
    L13:
        if (r5 >= r1.size()) goto L42;
        ReadableArray r6 = r1.getArray(r5);
        int r8 = r6.getInt(r3);
        int[] r9 = AnimationConstant.a;
        if (r8 == 8177) goto L27;
        if (r8 == 16369) goto L27;
        if (r8 == 262129) goto L27;
        if (r8 == 262144) goto L27;
        int r15 = 0;
    L21:
        if (r15 >= 10) goto L26;
        if (r8 == r9[r15]) goto L27;
        r15 = r15 + 1;
        goto L21
    L26:
        boolean r7 = false;
    L28:
        if (r7 == false) goto L38;
        s6a.a r10 = new s6a.a();
        r10.d = r8;
        r10.b = (long) r6.getDouble(1);
        r10.c = (long) r6.getDouble(r10.c(r6, 2));
        r10.p = r5;
        int r11 = r10.d;
        if (r11 == 8177) goto L39;
        if (r11 == 16369) goto L39;
        if (r11 == 262129) goto L39;
        if (r11 == 262144) goto L39;
        r2.j.put(r11, r10);
    L39:
        r2.j.clear();
        int r12 = 0;
        int r13 = 0;
    L40:
        if (r12 >= 10) goto L42;
        int r14 = r9[r12];
        s6a.a r16 = new s6a.a(r10);
        int r18 = r13 + 1;
        r16.p = r13;
        r16.d = r14;
        r2.j.put(r14, r16);
        r12 = r12 + 1;
        r13 = r18;
    L38:
        r5 = r5 + 1;
        r3 = 0;
    L27:
        r7 = true;
    L42:
        s6a.a.b(r2.j, 256, 1024);
        s6a.a.b(r2.j, 512, 2048);
        if (r4 == null) goto L52;
        int r19 = 0;
    L46:
        if (r19 >= r4.size()) goto L52;
        int r20 = r4.keyAt(r19);
        if (r2.j.indexOfKey(r20) >= 0) goto L50;
        r2.f(Integer.valueOf(r20));
    L50:
        r19 = r19 + 1;
    L52:
        if (r2.j.size() == 0) goto L54;
        r3 = 1;
        goto L55
    L54:
        r3 = 0;
    L55:
        if (r3 != 0) goto L71;
        this.mTransitionAnimator = null;
        return;
    }

    public void onAnimationEnd(String r3) {
        w6a.e r0 = this.mHeroAnimOwner;
        LynxKeyframeAnimator.e r1 = r0.l.get(r3);
        if (r1 == null) goto L6;
        r1.a(r3);
        r0.l.remove(r3);
        return;
    }

    public void processChildViewInfo(com.lynx.tasm.behavior.ui.a r5) {
        LynxUI r6 = (LynxUI) r5;
        beforeProcessChildViewInfo(this.mViewInfo, r6.getView(), 0);
        r6.processViewInfo();
        afterProcessChildViewInfo(this.mViewInfo, r6.getView(), 0);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setAccessibilityElement(f6a.a r3) {
        super.setAccessibilityElement(r3);
        com.lynx.tasm.behavior.ui.accessibility.d r4 = this.mContext.getLynxAccessibilityWrapper();
        if (this.mView != null) goto L5;
        return;
    L5:
        if (this.mAccessibilityElementStatus == (-1)) goto L16;
        if (r4 != null) goto L8;
        return;
    L8:
        if (r4.f() == false) goto L18;
        T r5 = this.mView;
        int r1 = 1;
        if (this.mAccessibilityElementStatus == 1) goto L13;
        r1 = 2;
    L13:
        ViewCompat.setImportantForAccessibility(r5, r1);
        return;
    L18:
        return;
    }

    @LynxProp(defaultBoolean = false, name = "accessibility-elements-hidden")
    public void setAccessibilityElementsHidden(boolean r2) {
        T r0 = this.mView;
        if (r2 == false) goto L5;
        int r3 = 4;
    L6:
        r0.setImportantForAccessibility(r3);
        return;
    L5:
        r3 = 0;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setAccessibilityHeading(boolean r3) {
        if (Build.VERSION.SDK_INT < 28) goto L6;
        this.mView.setAccessibilityHeading(r3);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "accessibility-label")
    public void setAccessibilityLabel(f6a.a r2) {
        super.setAccessibilityLabel(r2);
        T r3 = this.mView;
        if (r3 == null) goto L6;
        r3.setFocusable(true);
        this.mView.setContentDescription(getAccessibilityLabel());
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setAccessibilityValue(String r3) {
        if (Build.VERSION.SDK_INT < 30) goto L6;
        this.mView.setStateDescription(r3);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(defaultFloat = DisplayMetricsHolder.DEFAULT_SCREEN_SCALE, name = "opacity")
    public void setAlpha(float r4) {
        super.setAlpha(r4);
        if (getKeyframeManager() == null) goto L5;
        getKeyframeManager().d("Alpha", Float.valueOf(r4));
    L5:
        u6a.a r0 = this.mTransitionAnimator;
        if (r0 == null) goto L12;
        if (r0.b(1) == false) goto L12;
        this.mTransitionAnimator.a(this, 1, Float.valueOf(r4));
        return;
    L12:
        if (r4 == this.mView.getAlpha()) goto L14;
        this.mView.setAlpha(r4);
    L14:
        t6a.c r1 = this.mLayoutAnimator;
        if (r1 == null) goto L18;
        r1.x = r4;
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setAnimation(ReadableArray r5) {
        if (r5 != null) goto L8;
        com.lynx.tasm.animation.keyframe.a r6 = this.mKeyframeManager;
        if (r6 == null) goto L6;
        r6.b();
        this.mKeyframeManager = null;
    L6:
        this.mAnimationInfos = null;
        return;
    L8:
        prepareKeyframeManager();
        int r0 = r5.size();
        s6a.a[] r1 = new s6a.a[r0];
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L11;
        r1[r2] = s6a.a.d(r5.getArray(r2));
        r2 = r2 + 1;
        goto L9
    L11:
        this.mAnimationInfos = r1;
        this.mKeyframeManager.b = r1;
    }

    @LynxProp(name = "clip-path")
    public void setClipPath(ReadableArray r2) {
        this.mClipPath = i7a.a.a(r2, this.mContext.getScreenMetrics().density);
    }

    public void setDrawHead(LynxBaseUI r1) {
        this.mDrawHead = r1;
    }

    @LynxProp(defaultBoolean = true, name = "enable-reuse-animation-state")
    public void setEnableReuseAnimationState(boolean r2) {
        this.mEnableReuseAnimationState = r2;
        if (r2 == true) goto L8;
        LynxContext r3 = this.mContext;
        if (r3 == null) goto L9;
        LynxFeatureCounter.a(82, r3.getInstanceId());
        return;
    L9:
        return;
    }

    public void setEnterAnim(s6a.a r2) {
        this.mHeroAnimOwner.e = r2;
    }

    @LynxProp(name = "enter-transition-name")
    public void setEnterTransitionName(ReadableArray r3) {
        s6a.a r4 = s6a.a.d(r3);
        if (r4 == null) goto L15;
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L7;
        LynxFeatureCounter.a(77, r0.getInstanceId());
    L7:
        w6a.h r1 = w6a.h.a.a;
        monitor-enter(r1);
        r1.c.put(this, r4);     // Catch: Throwable -> L12
        setEnterAnim(r4);     // Catch: Throwable -> L12
        monitor-exit(r1);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void setExitAnim(s6a.a r2) {
        this.mHeroAnimOwner.f = r2;
    }

    @LynxProp(name = "exit-transition-name")
    public void setExitTransitionName(ReadableArray r3) {
        s6a.a r4 = s6a.a.d(r3);
        if (r4 == null) goto L15;
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L7;
        LynxFeatureCounter.a(78, r0.getInstanceId());
    L7:
        w6a.h r1 = w6a.h.a.a;
        monitor-enter(r1);
        r1.b.put(this, r4);     // Catch: Throwable -> L12
        setExitAnim(r4);     // Catch: Throwable -> L12
        monitor-exit(r1);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @LynxProp(name = "filter")
    public void setFilter(ReadableArray r18) {
        if (this.mView != null) goto L6;
        return;
    L6:
        if (r18 != null) goto L8;
    L10:
        double r8 = 0.0d;
        int r7 = 0;
    L12:
        if (r7 != 0) goto L14;
        this.mView.setLayerType(0, null);
        T r2 = this.mView;
        if ((r2 instanceof com.lynx.tasm.behavior.ui.view.a) == false) goto L63;
        ((com.lynx.tasm.behavior.ui.view.a) r2).removeBlur();
    L63:
        this.mGrayscaleAmount = 1.0f;
        return;
    L14:
        if (r7 == 1) goto L51;
        if (r7 == 2) goto L48;
        if (r7 != 3) goto L18;
        Double r3 = Double.valueOf(r8);
        Double r4 = Double.valueOf(0.0d);
        Double r5 = Double.valueOf(2.0d);
        if (r3.compareTo(r4) >= 0) goto L43;
        r3 = r4;
    L45:
        float r6 = (float) r3.doubleValue();
        if (com.lynx.tasm.utils.b.a(this.mBrightnessAmount, r6) == true) goto L69;
        ColorMatrix r9 = new ColorMatrix();
        r9.setScale(r6, r6, r6, 1.0f);
        Paint r1 = new Paint(1);
        r1.setColorFilter(new ColorMatrixColorFilter(r9));
        this.mView.setLayerType(2, r1);
        this.mBrightnessAmount = r6;
        return;
    L69:
        return;
    L43:
        if (r3.compareTo(r5) <= 0) goto L45;
        r3 = r5;
        goto L45
    L18:
        if (r7 == 4) goto L30;
        if (r7 == 5) goto L22;
        return;
    L22:
        if (r8 >= 0.0d) goto L25;
        r8 = 1.0d;
    L27:
        float r10 = (float) r8;
        if (com.lynx.tasm.utils.b.a(this.mSaturateAmount, r10) == true) goto L65;
        ColorMatrix r11 = new ColorMatrix();
        r11.setSaturation(r10);
        Paint r12 = new Paint(1);
        r12.setColorFilter(new ColorMatrixColorFilter(r11));
        this.mView.setLayerType(2, r12);
        this.mSaturateAmount = r10;
        return;
    L65:
        return;
    L25:
        if (r8 <= 3.0d) goto L27;
        r8 = 3.0d;
        goto L27
    L30:
        Double r13 = Double.valueOf(r8);
        Double r14 = Double.valueOf(0.0d);
        Double r15 = Double.valueOf(3.0d);
        if (r13.compareTo(r14) >= 0) goto L34;
        r13 = r14;
    L36:
        float r16 = (float) r13.doubleValue();
        if (com.lynx.tasm.utils.b.a(this.mContrastAmount, r16) == true) goto L67;
        ColorMatrix r17 = new ColorMatrix();
        float r19 = (1.0f - r16) * 128.0f;
        r17.set(new float[]{r16, 0.0f, 0.0f, 0.0f, r19, 0.0f, r16, 0.0f, 0.0f, r19, 0.0f, 0.0f, r16, 0.0f, r19, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        Paint r20 = new Paint(1);
        r20.setColorFilter(new ColorMatrixColorFilter(r17));
        this.mView.setLayerType(2, r20);
        this.mContrastAmount = r16;
        return;
    L67:
        return;
    L34:
        if (r13.compareTo(r15) <= 0) goto L36;
        r13 = r15;
        goto L36
    L48:
        T r21 = this.mView;
        if ((r21 instanceof com.lynx.tasm.behavior.ui.view.a) == false) goto L71;
        ((com.lynx.tasm.behavior.ui.view.a) r21).setBlur((float) r8);
        return;
    L71:
        return;
    L51:
        Double r22 = Double.valueOf(1.0d - r8);
        Double r23 = Double.valueOf(0.0d);
        Double r24 = Double.valueOf(1.0d);
        if (r22.compareTo(r23) >= 0) goto L55;
        r22 = r23;
    L57:
        float r25 = (float) r22.doubleValue();
        if (com.lynx.tasm.utils.b.a(this.mGrayscaleAmount, r25) == true) goto L73;
        ColorMatrix r26 = new ColorMatrix();
        r26.setSaturation(r25);
        Paint r27 = new Paint(1);
        r27.setColorFilter(new ColorMatrixColorFilter(r26));
        this.mView.setLayerType(2, r27);
        this.mGrayscaleAmount = r25;
        return;
    L73:
        return;
    L55:
        if (r22.compareTo(r24) <= 0) goto L57;
        r22 = r24;
        goto L57
    L8:
        if (r18.size() != 3) goto L10;
        r7 = r18.getInt(0);
        r8 = r18.getDouble(1);
        goto L12
    }

    @LynxProp(name = "layout-animation-create-delay")
    public void setLayoutAnimationCreateDelay(double r3) {
        prepareLayoutAnimator();
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(74, r0.getInstanceId());
    L5:
        this.mLayoutAnimator.e().a.c = (long) r3;
    }

    @LynxProp(name = "layout-animation-create-duration")
    public void setLayoutAnimationCreateDuration(double r3) {
        prepareLayoutAnimator();
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(74, r0.getInstanceId());
    L5:
        t6a.c r1 = this.mLayoutAnimator;
        r1.e().a.b = (long) r3;
        if (r1.e().c() == true) goto L9;
        r1.d("layout-animation-create");
        return;
    }

    @LynxProp(name = "layout-animation-create-property")
    public void setLayoutAnimationCreateProperty(int r3) {
        prepareLayoutAnimator();
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(74, r0.getInstanceId());
    L5:
        this.mLayoutAnimator.e().a.d = r3;
    }

    @LynxProp(name = "layout-animation-create-timing-function")
    public void setLayoutAnimationCreateTimingFunc(ReadableArray r3) {
        prepareLayoutAnimator();
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(74, r0.getInstanceId());
    L5:
        this.mLayoutAnimator.e().a.c(r3, 0);
    }

    @LynxProp(name = "layout-animation-delete-delay")
    public void setLayoutAnimationDeleteDelay(double r3) {
        prepareLayoutAnimator();
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(76, r0.getInstanceId());
    L5:
        this.mLayoutAnimator.f().a.c = (long) r3;
    }

    @LynxProp(name = "layout-animation-delete-duration")
    public void setLayoutAnimationDeleteDuration(double r3) {
        prepareLayoutAnimator();
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(76, r0.getInstanceId());
    L5:
        t6a.c r1 = this.mLayoutAnimator;
        r1.f().a.b = (long) r3;
        if (r1.f().c() == true) goto L9;
        r1.d("layout-animation-delete");
        return;
    }

    @LynxProp(name = "layout-animation-delete-property")
    public void setLayoutAnimationDeleteProperty(int r3) {
        prepareLayoutAnimator();
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(76, r0.getInstanceId());
    L5:
        this.mLayoutAnimator.f().a.d = r3;
    }

    @LynxProp(name = "layout-animation-delete-timing-function")
    public void setLayoutAnimationDeleteTimingFunc(ReadableArray r3) {
        prepareLayoutAnimator();
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(76, r0.getInstanceId());
    L5:
        this.mLayoutAnimator.f().a.c(r3, 0);
    }

    @LynxProp(name = "layout-animation-update-delay")
    public void setLayoutAnimationUpdateDelay(double r3) {
        prepareLayoutAnimator();
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(75, r0.getInstanceId());
    L5:
        this.mLayoutAnimator.g().a.c = (long) r3;
    }

    @LynxProp(name = "layout-animation-update-duration")
    public void setLayoutAnimationUpdateDuration(double r3) {
        prepareLayoutAnimator();
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(75, r0.getInstanceId());
    L5:
        t6a.c r1 = this.mLayoutAnimator;
        r1.g().a.b = (long) r3;
        if (r1.g().c() == true) goto L9;
        r1.d("layout-animation-update");
        return;
    }

    @LynxProp(name = "layout-animation-update-property")
    public void setLayoutAnimationUpdateProperty(int r3) {
        prepareLayoutAnimator();
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(75, r0.getInstanceId());
    L5:
        this.mLayoutAnimator.g().a.d = r3;
    }

    @LynxProp(name = "layout-animation-update-timing-function")
    public void setLayoutAnimationUpdateTimingFunc(ReadableArray r3) {
        prepareLayoutAnimator();
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L5;
        LynxFeatureCounter.a(75, r0.getInstanceId());
    L5:
        this.mLayoutAnimator.g().a.c(r3, 0);
    }

    @LynxProp(name = "offset-distance")
    public void setOffsetDistance(float r2) {
        if (this.mOffsetDistance == r2) goto L6;
        this.mOffsetDistance = r2;
        this.mOffsetHasChanged = true;
        return;
    }

    @LynxProp(name = "offset-path")
    public void setOffsetPath(ReadableArray r2) {
        if (this.mRawOffsetShape == r2) goto L6;
        this.mRawOffsetShape = r2;
        this.mOffsetPath = i7a.a.a(r2, this.mContext.getScreenMetrics().density);
        this.mOffsetHasChanged = true;
        return;
    }

    @LynxProp(name = "offset-rotate")
    public void setOffsetRotate(float r4) {
        if (this.mOffsetRotate == r4) goto L12;
        this.mOffsetRotate = r4;
        this.mOffsetHasChanged = true;
        if (r4 != OFFSET_ROTATE_AUTO) goto L8;
        this.mIsAutoOffsetRotate = true;
        this.mOffsetRotateAngle = 0.0f;
        return;
    L8:
        if (isEncodedAutoOffsetRotate(r4) == false) goto L10;
        this.mIsAutoOffsetRotate = true;
        this.mOffsetRotateAngle = decodeAutoOffsetRotateAngle(this.mOffsetRotate);
        return;
    L10:
        this.mIsAutoOffsetRotate = false;
        this.mOffsetRotateAngle = 0.0f;
        return;
    }

    @LynxProp(name = "overlap")
    public void setOverlap(f6a.a r3) {
        if (r3 != null) goto L5;
        this.mOverlappingRendering = true;
        return;
    L5:
        ReadableType r0 = r3.getType();
        if (r0 != ReadableType.Boolean) goto L9;
        this.mOverlappingRendering = r3.asBoolean();
        return;
    L9:
        if (r0 != ReadableType.String) goto L13;
        this.mOverlappingRendering = r3.asString().equalsIgnoreCase("true");
        return;
    }

    public void setPauseAnim(s6a.a r2) {
        this.mHeroAnimOwner.g = r2;
    }

    @LynxProp(name = "pause-transition-name")
    public void setPauseTransitionName(ReadableArray r3) {
        s6a.a r4 = s6a.a.d(r3);
        if (r4 == null) goto L15;
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L7;
        LynxFeatureCounter.a(79, r0.getInstanceId());
    L7:
        w6a.h r1 = w6a.h.a.a;
        monitor-enter(r1);
        r1.e.put(this, r4);     // Catch: Throwable -> L12
        setPauseAnim(r4);     // Catch: Throwable -> L12
        monitor-exit(r1);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @LynxProp(name = "hardware-layer")
    public void setRenderToHardwareTexture(boolean r3) {
        if (r3 == false) goto L7;
        LynxContext r4 = this.mContext;
        if (r4 == null) goto L6;
        LynxFeatureCounter.a(72, r4.getInstanceId());
    L6:
        int r5 = 2;
    L8:
        this.mView.setLayerType(r5, null);
        return;
    L7:
        r5 = 0;
        goto L8
    }

    public void setResumeAnim(s6a.a r2) {
        this.mHeroAnimOwner.h = r2;
    }

    @LynxProp(name = "resume-transition-name")
    public void setResumeTransitionName(ReadableArray r3) {
        s6a.a r4 = s6a.a.d(r3);
        if (r4 == null) goto L15;
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L7;
        LynxFeatureCounter.a(80, r0.getInstanceId());
    L7:
        w6a.h r1 = w6a.h.a.a;
        monitor-enter(r1);
        r1.d.put(this, r4);     // Catch: Throwable -> L12
        setResumeAnim(r4);     // Catch: Throwable -> L12
        monitor-exit(r1);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @LynxProp(name = "shared-element")
    public void setShareElement(String r4) {
        w6a.e r0 = this.mHeroAnimOwner;
        r0.i = r4;
        w6a.h r1 = w6a.h.a.a;
        LynxUI r2 = r0.a;
        monitor-enter(r1);
        r1.f.put(r2, r4);     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setStickyTranslate(PointF r2) {
        super.setStickyTranslate(r2);
        com.lynx.tasm.behavior.ui.utils.a r0 = this.mBackgroundManager;
        if (r0 == null) goto L6;
        r0.h = r2;
        r0.u();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "lynx-test-tag")
    public void setTestID(String r2) {
        this.mView.setTag(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "transform")
    public void setTransform(ReadableArray r3) {
        this.mHasTranslateDiff = hasTranslateDiff(r3);
        super.setTransform(r3);
        if (getKeyframeManager() == null) goto L6;
        getKeyframeManager().d("Transform", this.mTransformRaw);
        return;
    }

    @LynxProp(name = "transform-order")
    public void setTransformOrder(f6a.a r3) {
        if (r3 != null) goto L5;
        this.mBackgroundManager.j = true;
        return;
    L5:
        ReadableType r0 = r3.getType();
        if (r0 != ReadableType.Boolean) goto L9;
        com.lynx.tasm.behavior.ui.utils.a r1 = this.mBackgroundManager;
        r1.j = r3.asBoolean();
        return;
    L9:
        if (r0 != ReadableType.String) goto L13;
        String r4 = r3.asString();
        com.lynx.tasm.behavior.ui.utils.a r2 = this.mBackgroundManager;
        r2.j = r4.equalsIgnoreCase("true");
        return;
    }

    @LynxProp(defaultInt = 1, name = "visibility")
    public void setVisibility(int r4) {
        u6a.a r0 = this.mTransitionAnimator;
        if (r0 != null) goto L5;
    L8:
        int r1 = this.mView.getVisibility();
        if (r4 != 1) goto L11;
        this.mSetVisibleByCSS = true;
        this.mView.setVisibility(0);
        r1 = 0;
    L14:
        if ((getParent() instanceof UIShadowProxy) == false) goto L17;
        ((UIShadowProxy) getParent()).setVisibilityForView(r1);
        return;
    L17:
        return;
    L11:
        if (r4 != 0) goto L14;
        this.mSetVisibleByCSS = false;
        r1 = 4;
        this.mView.setVisibility(4);
        goto L14
    L5:
        if (r0.b(LynxTouchEvent.kPseudoStateFocusTransition) == false) goto L8;
        this.mTransitionAnimator.a(this, LynxTouchEvent.kPseudoStateFocusTransition, Integer.valueOf(r4));
    }

    public void setVisibilityForView(int r3) {
        if (r3 != 0) goto L6;
        this.mSetVisibleByCSS = true;
        this.mView.setVisibility(0);
        return;
    L6:
        if (r3 != 4) goto L10;
        this.mSetVisibleByCSS = false;
        this.mView.setVisibility(4);
        return;
    }

    public void updateLayoutParams(ViewGroup.LayoutParams r2) {
        if (r2 == null) goto L8;
        r2.width = getWidth();
        r2.height = getHeight();
        if (r2 == this.mView.getLayoutParams()) goto L9;
        this.mView.setLayoutParams(r2);
        return;
    L9:
        return;
    L8:
        throw new RuntimeException("LayoutPrams should not be null");
    }

    public LynxUI(LynxContext r2) {
        this(r2, null);
    }

    public void setAnimation(s6a.a r4) {
        prepareKeyframeManager();
        com.lynx.tasm.animation.keyframe.a r0 = this.mKeyframeManager;
        r0.getClass();
        r0.b = new s6a.a[]{r4};
    }

    public LynxUI(LynxContext r3, Object r4) {
        super(r3, r4);
        this.mGrayscaleAmount = 1.0f;
        this.mBrightnessAmount = 1.0f;
        this.mContrastAmount = 1.0f;
        this.mSaturateAmount = 1.0f;
        this.mHueRotateAmount = 0.0f;
        this.mSetVisibleByCSS = true;
        this.mLayoutAnimator = null;
        this.mOverlappingRendering = true;
        this.mEnableReuseAnimationState = true;
        this.mAnimationInfos = null;
        this.mFirstRender = true;
        this.mAlpha = 1.0f;
        this.mDrawHead = null;
        this.mOffsetRotate = OFFSET_ROTATE_AUTO;
        this.mOffsetRotateAngle = 0.0f;
        this.mIsAutoOffsetRotate = true;
        this.mOffsetHasChanged = false;
    }

    private void restoreKeyframeStateFromStorage(String r4, UIList r5) {
        if (this.mEnableReuseAnimationState == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return;
    L8:
        if (this.mAnimationInfos == null) goto L27;
        String r6 = "Animation_" + constructListStateCacheKey(getTagName(), r4, getIdSelector());
        com.lynx.tasm.animation.keyframe.a r0 = (com.lynx.tasm.animation.keyframe.a) ((HashMap) r5.y).get(r6);
        if (r0 == null) goto L22;
        ((HashMap) r5.y).remove(r6);
        com.lynx.tasm.animation.keyframe.a r7 = this.mKeyframeManager;
        if (r7 == null) goto L14;
        r7.a();
        this.mKeyframeManager = null;
    L14:
        r0.a = new WeakReference(this);
        HashMap<String, LynxKeyframeAnimator> r8 = r0.c;
        if (r8 == null) goto L21;
        Iterator<LynxKeyframeAnimator> r9 = r8.values().iterator();
    L19:
        if (r9.hasNext() == false) goto L21;
        LynxKeyframeAnimator r10 = r9.next();
        r10.getClass();
        r10.b = new WeakReference(this);
        r10.c = new WeakReference(getView());
        r10.b(r10.i);
    L21:
        this.mKeyframeManager = r0;
    L23:
        com.lynx.tasm.animation.keyframe.a r11 = this.mKeyframeManager;
        r11.b = this.mAnimationInfos;
        r11.c();
        return;
    L22:
        prepareKeyframeManager();
        goto L23
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean checkStickyOnParentScroll(int r3, int r4) {
        boolean r5 = super.checkStickyOnParentScroll(r3, r4);
        if (this.mSticky == null) goto L5;
        LynxBaseUI.Sticky r0 = this.mSticky;
        PointF r6 = new PointF(r0.a, r0.b);
    L6:
        com.lynx.tasm.behavior.ui.utils.a r1 = this.mBackgroundManager;
        if (r1 == null) goto L9;
        r1.h = r6;
        r1.u();
    L9:
        return r5;
    L5:
        r6 = null;
        goto L6
    }

    public T createView(Context r1, Object r2) {
        return (T) createView(r1);
    }

    public T getOrCreateView(Context r3, Object r4) {
        LynxContext r0 = this.mContext;
        if (r0 == null) goto L15;
        if (r0.isFallbackProcess() == false) goto L15;
        if (this.mContext.getUIBodyView() == null) goto L15;
        if ((r4 instanceof j) == false) goto L15;
        setNodeIndex(((j) r4).b);
        T r1 = (T) this.mContext.getUIBodyView().obtainViewAccordingToNodeIndex(this.mNodeIndex);
        if (r1 == null) goto L15;
        r1.setBackground(null);
        return r1;
    L15:
        return (T) createView(r3, r4);
    }

    public void insertDrawList(LynxBaseUI r2, LynxBaseUI r3) {
        r3.setDrawParent(this);
        if (r2 != null) goto L8;
        LynxBaseUI r4 = this.mDrawHead;
        if (r4 == null) goto L7;
        r4.mPreviousDrawUI = r3;
        r3.mNextDrawUI = r4;
    L7:
        this.mDrawHead = r3;
        return;
    L8:
        LynxBaseUI r0 = r2.mNextDrawUI;
        if (r0 == null) goto L11;
        r0.mPreviousDrawUI = r3;
        r3.mNextDrawUI = r0;
    L11:
        r3.mPreviousDrawUI = r2;
        r2.mNextDrawUI = r3;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public void onFocusChanged(boolean r2, boolean r3) {
        if (r3 == true) goto L11;
        InputMethodManager r4 = LynxEnv.inst().getInputMethodManager();
        if (r4 != null) goto L7;
        LLog.w(TAG, "Failed to get InputMethodManager");
        return;
    L7:
        if (r2 == false) goto L9;
        r4.showSoftInput(this.mView, 1);
        return;
    L9:
        r4.hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
        return;
    }

    public void onListCellAppear(String r1, UIList r2) {
        super.onListCellAppear(r1, r2);
        restoreKeyframeStateFromStorage(r1, r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setSign(int r1, String r2) {
        super.setSign(r1, r2);
    }

    @LynxUIMethod
    public void takeScreenshot(ReadableMap r12, Callback r13) {
        if (this.mView != null) goto L6;
        r13.invoke(new Object[]{6, new JavaOnlyMap()});
        return;
    L6:
        String r0 = r12.getString("format", "jpeg");
        boolean r4 = r12.getBoolean("androidEnablePixelCopy", false);
        if (r0.equals("png") == false) goto L9;
        Bitmap.Config r1 = Bitmap.Config.ARGB_8888;
        Bitmap.CompressFormat r5 = Bitmap.CompressFormat.PNG;
        String r6 = "data:image/png;base64,";
    L10:
        Bitmap.CompressFormat r8 = r5;
        String r9 = r6;
        float r7 = (float) r12.getDouble("scale", 1.0d);
        i8a.h r14 = (i8a.h) i8a.n.c().a(i8a.h.class);     // Catch: Throwable -> L27
        if (r14 == null) goto L15;
        Bitmap r15 = r14.c(this.mView, r1);     // Catch: Throwable -> L27
    L25:
        LynxThreadPool.b().execute(new d(r7, r15, r8, r9, r13));     // Catch: Throwable -> L27
        return;
    L15:
        r15 = Bitmap.createBitmap(this.mView.getWidth(), this.mView.getHeight(), r1);     // Catch: Throwable -> L27
        Canvas r2 = new Canvas(r15);     // Catch: Throwable -> L27
        if (r4 == false) goto L22;
        LynxContext r10 = this.mContext;     // Catch: Throwable -> L27
        if (r10 == null) goto L22;
        if (r10.getUIBodyView() == null) goto L22;
        ((LynxUIRenderer) this.mContext.getUIBodyView().getLynxUIRendererInternal()).d(this.mView, r2);     // Catch: Throwable -> L27
    L22:
        boolean r11 = this.mView.isDirty();     // Catch: Throwable -> L27
        this.mView.draw(r2);     // Catch: Throwable -> L27
        if (r11 == false) goto L25;
        this.mView.postInvalidate();     // Catch: Throwable -> L27
    L27:
        r13.invoke(new Object[]{1, new JavaOnlyMap()});
        return;
    L9:
        r1 = Bitmap.Config.RGB_565;
        r5 = Bitmap.CompressFormat.JPEG;
        r6 = "data:image/jpeg;base64,";
        goto L10
    }

    private void saveKeyframeStateToStorage(String r4, LynxBaseUI r5, boolean r6) {
        if (this.mEnableReuseAnimationState == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L22;
        if (r6 == true) goto L9;
    L10:
        if (r6 == true) goto L21;
    L11:
        String r7 = "Animation_" + constructListStateCacheKey(getTagName(), r4, getIdSelector());
        if (r6 == true) goto L14;
        r5.removeKeyFromNativeStorage(r7);
    L15:
        com.lynx.tasm.animation.keyframe.a r8 = this.mKeyframeManager;
        if (r8 == null) goto L18;
        r8.a();
    L18:
        this.mKeyframeManager = null;
        return;
    L14:
        r5.storeKeyToNativeStorage(r7, this.mKeyframeManager);
        goto L15
    L21:
        return;
    L9:
        if (this.mKeyframeManager != null) goto L11;
    }

    public void applyOffsetAndRotate(float r8, float r9, float r10) {
        com.lynx.tasm.behavior.ui.utils.a r0 = this.mBackgroundManager;
        r0.i = new PointF(r8, r9);
        r0.u();
        ArrayList r11 = new ArrayList();
        r11.add(new n(32, r10, 0, 0.0f, 0, 0));
        List<n> r12 = this.mTransformRaw;
        if (r12 == null) goto L5;
        r11.addAll(r12);
    L5:
        this.mBackgroundManager.t(r11);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onListCellDisAppear(String r1, LynxBaseUI r2, boolean r3) {
        super.onListCellDisAppear(r1, r2, r3);
        saveKeyframeStateToStorage(r1, r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean calculateStickyTranslateWithOffset(int r1, boolean r2, int r3, int r4) {
        boolean r5 = super.calculateStickyTranslateWithOffset(r1, r2, r3, r4);
        if (r5 == true) goto L5;
    L7:
        PointF r6 = null;
    L8:
        com.lynx.tasm.behavior.ui.utils.a r7 = this.mBackgroundManager;
        if (r7 == null) goto L11;
        r7.h = r6;
        r7.u();
    L11:
        return r5;
    L5:
        if (this.mSticky == null) goto L7;
        LynxBaseUI.Sticky r8 = this.mSticky;
        r6 = new PointF(r8.a, r8.b);
        goto L8
    }
}
