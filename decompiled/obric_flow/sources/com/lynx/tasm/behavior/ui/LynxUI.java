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
import android.os.Build;
import android.renderscript.Matrix4f;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.lynx.base.log.LynxLog;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.react.bridge.ReadableType;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.animation.keyframe.LynxKeyframeAnimator$LynxKFAnimatorState;
import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxUIRenderer;
import com.lynx.tasm.behavior.a1;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.text.AndroidText;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.featurecount.LynxFeatureCounter;
import com.lynx.tasm.utils.DeviceUtils;
import com.lynx.tasm.utils.LRUHashMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class LynxUI<T extends View> extends LynxBaseUI implements c {
    protected static final boolean ENABLE_ZINDEX = false;
    private static final float OFFSET_ROTATE_AUTO = -1024.0f;
    private static final String TAG = "LynxUI";
    protected float mAlpha;
    private tm.b[] mAnimationInfos;
    private com.lynx.tasm.behavior.ui.utils.b mBackgroundManager;
    protected in.b mClipPath;
    protected LynxBaseUI mDrawHead;
    private boolean mEnableReuseAnimationState;
    protected boolean mFirstRender;
    private float mGrayscaleAmount;
    private xm.d mHeroAnimOwner;
    protected boolean mIsAutoOffsetRotate;

    @Nullable
    private com.lynx.tasm.animation.keyframe.a mKeyframeManager;
    protected float mLastOffsetEffectRotate;
    protected float mLastOffsetEffectX;
    protected float mLastOffsetEffectY;

    @Nullable
    private um.e mLayoutAnimator;
    protected float mOffsetDistance;
    protected boolean mOffsetHasChanged;
    protected in.b mOffsetPath;
    protected float mOffsetRotate;
    protected com.lynx.tasm.base.g mOnceTask;
    private boolean mOverlappingRendering;
    protected ReadableArray mRawOffsetShape;
    private boolean mSetVisibleByCSS;

    @Nullable
    private vm.i mTransitionAnimator;
    protected T mView;
    protected g0 mViewInfo;

    static {
        ENABLE_ZINDEX = false;
    }

    public LynxUI(LynxContext r5, Object r10) {
        super(r5, r10);
        this.mGrayscaleAmount = 1.0f;
        this.mSetVisibleByCSS = true;
        this.mLayoutAnimator = null;
        this.mOverlappingRendering = true;
        this.mEnableReuseAnimationState = true;
        this.mAnimationInfos = null;
        this.mFirstRender = true;
        this.mAlpha = 1.0f;
        this.mDrawHead = null;
        this.mOffsetRotate = OFFSET_ROTATE_AUTO;
        this.mIsAutoOffsetRotate = true;
        this.mOffsetHasChanged = false;
    }

    @Override // com.lynx.tasm.behavior.ui.c
    public void afterDispatchProcessViewInfo(g0 r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.c
    public void afterProcessChildViewInfo(g0 r5, View r10, long r11) {
    }

    @Override // com.lynx.tasm.behavior.ui.c
    public void afterProcessViewInfo(g0 r5) {
    }

    public void applyOffsetAndRotate(float r12, float r13, float r14) {
        ArrayList r5 = new ArrayList();
        float r10 = 0.0f;
        r5.add(new com.lynx.tasm.behavior.ui.utils.o(1, new com.lynx.tasm.behavior.ui.utils.k(r12 - this.mLastOffsetEffectX), 0, new com.lynx.tasm.behavior.ui.utils.k(r13 - this.mLastOffsetEffectY), 0, new com.lynx.tasm.behavior.ui.utils.k(0.0f), 0));
        r5.add(new com.lynx.tasm.behavior.ui.utils.o(r14 - this.mLastOffsetEffectRotate, 0.0f, 32, 0, 0, 0));
        this.mLastOffsetEffectX = r12;
        this.mLastOffsetEffectY = r13;
        this.mLastOffsetEffectRotate = r14;
        com.lynx.tasm.behavior.ui.utils.b r11 = this.mBackgroundManager;
        if (r11.g != null) goto L6;
        r11.o(r5);
        return;
    L6:
        LynxUI r15 = (LynxUI) r11.f.get();
        if (r15 == null) goto L18;
        LynxContext r16 = r11.f10749a;
        r16.f10145m.getFontSize();
        r16.f10145m.getLatestWidth();
        r16.f10145m.getLatestHeight();
        com.lynx.tasm.behavior.ui.utils.n r17 = com.lynx.tasm.behavior.ui.utils.n.n(r5, r15.getLatestWidth(), r15.getLatestHeight());
        Matrix4f r18 = r11.g.x();
        r18.multiply(r17.x());
        com.lynx.tasm.behavior.ui.utils.n r19 = r11.g;
        jk.a r20 = new jk.a(3);
        jk.a.h((double[]) r20.f18349a);
        jk.a.h((double[]) r20.f18350b);
        jk.a.h((double[]) r20.f18351c);
        jk.a.h((double[]) r20.d);
        jk.a.h((double[]) r20.e);
        com.lynx.tasm.utils.f.c(com.lynx.tasm.behavior.ui.utils.n.r(r18.getArray()), r20);
        r19.q(r20);
        r11.p();
        r15.getView().setOutlineProvider(null);
        ViewCompat.setTranslationZ(r15.getView(), r11.g.w());
        r15.getView().setRotation(r11.g.f());
        r15.getView().setRotationX(r11.g.s());
        r15.getView().setRotationY(r11.g.t());
        r15.getView().setScaleX(r11.g.u());
        r15.getView().setScaleY(r11.g.v());
        Float r110 = (Float) ((LinkedHashMap) r11.g.f10761a).get("skewX");
        if (r110 == null) goto L12;
        float r111 = r110.floatValue();
    L13:
        r15.setSkewX(r111);
        Float r112 = (Float) ((LinkedHashMap) r11.g.f10761a).get("skewY");
        if (r112 == null) goto L16;
        r10 = r112.floatValue();
    L16:
        r15.setSkewY(r10);
        r15.getView().invalidate();
        return;
    L12:
        r111 = 0.0f;
        goto L13
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void attachToView(LynxContext r5) {
        this.mContext = r5;
        if (this.mView != null) goto L8;
        T r10 = (T) r5.l().obtainViewAccordingToNodeIndex(this.mNodeIndex);
        if (r10 == null) goto L7;
        this.mView = r10;
        goto L8
    L7:
        createViewAsync();
    L8:
        this.mContext.f10145m.getClass();
        LynxLog.b(3, "UIBody", "UIBody.appendUIWithCreateViewAsync failed since mCreateViewUI is null.");
        super.attachToView(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.c
    public void beforeDispatchProcessViewInfo(g0 r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.c
    public void beforeProcessChildViewInfo(g0 r5, View r10, long r11) {
    }

    @Override // com.lynx.tasm.behavior.ui.c
    public void beforeProcessViewInfo(g0 r5) {
        r5.e = getSkewX();
        r5.f = getSkewY();
        r5.g = this.mClipPath;
        r5.f10477c = getWidth();
        r5.d = getHeight();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean checkStickyOnParentScroll(int r5, int r10) {
        boolean r11 = super.checkStickyOnParentScroll(r5, r10);
        if (this.mSticky == null) goto L5;
        LynxBaseUI.Sticky r12 = this.mSticky;
        PointF r13 = new PointF(r12.f10380a, r12.f10381b);
    L6:
        com.lynx.tasm.behavior.ui.utils.b r14 = this.mBackgroundManager;
        r14.f10738h = r13;
        r14.p();
        return r11;
    L5:
        r13 = null;
        goto L6
    }

    public View createView(Context r5) {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void createViewAsync() {
        super.createViewAsync();
        com.lynx.tasm.base.g r5 = new com.lynx.tasm.base.g(new j(this), new k(this));
        this.mOnceTask = r5;
        LynxEnv.runJavaTaskOnConcurrentLoop(new l(r5, 0), 0);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        vm.i r5 = this.mTransitionAnimator;
        if (r5 == null) goto L5;
        r5.b();
    L5:
        com.lynx.tasm.animation.keyframe.a r10 = this.mKeyframeManager;
        if (r10 == null) goto L17;
        HashMap r11 = r10.f10083c;
        if (r11 == null) goto L18;
        Iterator r12 = r11.values().iterator();
    L12:
        if (r12.hasNext() == false) goto L14;
        ((com.lynx.tasm.animation.keyframe.g) r12.next()).f();
        goto L12
    L14:
        r10.f10083c = null;
        r10.f10082b = null;
        return;
    L18:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void detachWithViewInfo(g0 r5) {
        registerViewAccordingToNodeIndex();
        g0 r10 = this.mViewInfo;
        if (r10 == null) goto L5;
        r5 = r10;
    L5:
        super.detachWithViewInfo(r5);
        g0 r11 = this.mViewInfo;
        if (r11 != null) goto L8;
    L11:
        this.mView = null;
        return;
    L8:
        if (this.mKeyframeManager == null) goto L10;
        this.mKeyframeManager = null;
    L10:
        r11.f10475a = null;
        this.mViewInfo = null;
        goto L11
    }

    public void didEnsureCreateView() {
        com.lynx.tasm.behavior.ui.utils.b r5 = this.mBackgroundManager;
        if (r5 == null) goto L8;
        BackgroundDrawable r10 = (BackgroundDrawable) r5.f10750b;
        if (r10 == null) goto L8;
        this.mView.setBackground(r10);
    L8:
        if (this.mAlpha == this.mView.getAlpha()) goto L11;
        this.mView.setAlpha(this.mAlpha);
    L11:
        if (this.mAnimationInfos != null) goto L13;
        return;
    L13:
        if (this.mKeyframeManager != null) goto L15;
        this.mKeyframeManager = new com.lynx.tasm.animation.keyframe.a(this);
    L15:
        com.lynx.tasm.animation.keyframe.a r11 = this.mKeyframeManager;
        r11.f10082b = this.mAnimationInfos;
        r11.a();
    }

    public void dispatchProcessViewInfo() {
        LynxBaseUI r5 = this.mDrawHead;
    L3:
        if (r5 == null) goto L8;
        if ((r5 instanceof LynxUI) == false) goto L7;
        processChildViewInfo((LynxUI) r5);
    L7:
        r5 = r5.mNextDrawUI;
        goto L3
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean enableLayoutAnimation() {
        um.e r5 = this.mLayoutAnimator;
        if (r5 == null) goto L18;
        um.f r10 = r5.f22390t;
        if (r10 != null) goto L7;
    L8:
        um.g r11 = r5.f22392v;
        if (r11 != null) goto L11;
    L12:
        um.i r12 = r5.f22391u;
        if (r12 != null) goto L15;
        return false;
    L15:
        if (r12.k() == false) goto L23;
        return true;
    L23:
        return false;
    L11:
        if (r11.k() == false) goto L12;
        return true;
    L7:
        if (r10.k() == false) goto L8;
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void ensureCreateView() {
        com.lynx.tasm.base.g r5 = this.mOnceTask;
        if (r5 == null) goto L14;
        r5.run();
        com.lynx.tasm.base.g r10 = this.mOnceTask;
        r10.getClass();
        Object r11 = r10.f10129b.get();     // Catch: Exception -> L7
    L12:
        this.mView = (T) r11;
        this.mOnceTask = null;
    L7:
        e = move-exception;
        LynxLog.b(4, "OnceTask", "Get result from OnceTask failed since: " + e.toString());
        Consumer r12 = r10.f10130c;
        if (r12 == null) goto L11;
        r12.accept(e);
    L11:
        r11 = null;
    L14:
        if (this.mView != null) goto L18;
        T r13 = (T) createView(this.mContext, this.mParam);
        this.mView = r13;
        if (r13 != null) goto L18;
        this.mView = (T) createView(this.mContext);
    L18:
        T r14 = this.mView;
        if ((r14 instanceof a) == false) goto L24;
        if ((this instanceof b) == false) goto L24;
        ((a) r14).bindDrawChildHook((b) this);
    L24:
        if ((this.mDrawParent instanceof UIGroup) == true) goto L26;
    L28:
        didEnsureCreateView();
        this.mView.requestLayout();
        this.mView.invalidate();
        return;
    L26:
        if (this.mView.getParent() != null) goto L28;
        ((UIGroup) this.mDrawParent).insertChildWhenRebuildView(this);
        goto L28
    }

    public void execEnterAnim(xm.g r11) {
        xm.d r10 = this.mHeroAnimOwner;
        r10.getClass();
        xm.i r5 = xm.f.f23173a;
        if (r5.g == true) goto L5;
        return;
    L5:
        if (r10.f23169j == false) goto L7;
        return;
    L7:
        if (r10.f23170k == true) goto L72;
        tm.b r12 = r10.e;
        if (r12 != null) goto L12;
        return;
    L12:
        if (r10.f23168i == null) goto L53;
        r10.f23169j = true;
        String r13 = r10.f23168i;
        LynxUI r14 = r10.f23164a;
        monitor-enter(r5);
        WeakReference r15 = (WeakReference) r5.f23174a.get(r13);     // Catch: Throwable -> L18
        if (r15 == null) goto L20;
        View r16 = (View) r15.get();     // Catch: Throwable -> L18
    L21:
        if (r16 != null) goto L32;
        Iterator r17 = r5.f.entrySet().iterator();     // Catch: Throwable -> L18
    L24:
        if (r17.hasNext() == false) goto L32;
        Map.Entry r18 = (Map.Entry) r17.next();     // Catch: Throwable -> L18
        LynxUI r19 = (LynxUI) r18.getKey();     // Catch: Throwable -> L18
        if (r14 == r19) goto L24;
        if (((String) r18.getValue()).equals(r13) == false) goto L24;
        r16 = r19.getView();     // Catch: Throwable -> L18
        monitor-exit(r5);     // Catch: Throwable -> L18
    L33:
        UIBody.UIBodyView r20 = r10.f23164a.getLynxContext().f10145m.f10385a;
        if (r20 == null) goto L50;
        View r21 = r10.f23164a.getView();
        if (r16 == null) goto L49;
        r21.setVisibility(r16.getVisibility());
        r21.setAlpha(r16.getAlpha());
        r21.setTranslationX(r16.getTranslationX());
        r21.setTranslationY(r16.getTranslationY());
        r21.setRotation(r16.getRotation());
        r21.setRotationX(r16.getRotationX());
        r21.setRotationY(r16.getRotationY());
        r21.setScaleX(r16.getScaleX());
        r21.setScaleY(r16.getScaleY());
        int r22 = r16.getWidth();
        int r23 = r16.getHeight();
        if ((r20.getRootView() instanceof ViewGroup) == false) goto L50;
        ViewGroup r24 = (ViewGroup) r20.getRootView();
        if (r21.getParent() == null) goto L48;
        ViewGroup r25 = (ViewGroup) r21.getParent();
        r10.f23166c = r25;
        int r26 = r25.getChildCount();
        int r27 = 0;
    L42:
        if (r27 >= r26) goto L47;
        if (r21 == r10.f23166c.getChildAt(r27)) goto L45;
        r27 = r27 + 1;
        goto L42
    L45:
        r10.f23165b = r27;
    L47:
        r10.f23166c.removeView(r21);
        r10.d = (UIGroup) r10.f23164a.getParent();
    L48:
        ViewGroup.MarginLayoutParams r28 = new ViewGroup.MarginLayoutParams(r22, r23);
        int[] r29 = new int[2];
        r16.getLocationInWindow(r29);
        r28.setMargins(r29[0], r29[1], 0, 0);
        r24.addView(r21, r28);
        com.lynx.tasm.utils.j.a().post(new xm.a(r10, 0));
        goto L50
    L49:
        com.lynx.tasm.utils.j.a().post(new xm.a(r10, 1));
    L50:
        r10.f23171l.put(r10.e.f22140a, new xm.c(r10, r11));
        return;
    L32:
        monitor-exit(r5);
        goto L33
    L20:
        r16 = null;
    L18:
        th = move-exception;
        throw th;
    L53:
        r10.f23164a.setAnimation(r12);
        if (r10.f23164a.getKeyframeManager() == null) goto L71;
        r10.f23164a.getKeyframeManager().a();
        return;
    L71:
        return;
    }

    public void execExitAnim(xm.h r5) {
        xm.d r10 = this.mHeroAnimOwner;
        r10.getClass();
        if (xm.f.f23173a.g == true) goto L5;
        return;
    L5:
        if (r10.f23169j == false) goto L7;
        return;
    L7:
        if (r10.f23170k == true) goto L29;
        tm.b r11 = r10.f;
        if (r11 == null) goto L25;
        String r12 = r11.f22140a;
        r10.f23171l.put(r12, new xm.b(r10));
        if (r10.f23168i == null) goto L19;
        r10.f23170k = true;
        ViewGroup r13 = (ViewGroup) r10.f23164a.getLynxContext().f10145m.f10385a.getRootView();
        View r14 = r10.f23164a.getView();
        r14.getLocationInWindow(new int[2]);
        ViewParent r15 = r14.getParent();
        if (r15 == null) goto L16;
        ((ViewGroup) r15).removeView(r14);
    L16:
        r13.addView(r14);
        r10.f23164a.setAnimation(r10.f);
        if (r10.f23164a.getKeyframeManager() == null) goto L26;
        r10.f23164a.getKeyframeManager().a();
        return;
    L26:
        return;
    L19:
        r10.f23164a.setAnimation(r10.f);
        if (r10.f23164a.getKeyframeManager() == null) goto L28;
        r10.f23164a.getKeyframeManager().a();
        return;
    L28:
        return;
    L25:
        return;
    }

    public void execPauseAnim() {
        xm.d r5 = this.mHeroAnimOwner;
        r5.getClass();
        if (xm.f.f23173a.g == true) goto L5;
        return;
    L5:
        if (r5.f23169j == false) goto L7;
        return;
    L7:
        if (r5.f23170k == true) goto L19;
        tm.b r10 = r5.g;
        if (r10 == null) goto L17;
        r5.f23164a.setAnimation(r10);
        if (r5.f23164a.getKeyframeManager() == null) goto L18;
        r5.f23164a.getKeyframeManager().a();
        return;
    L18:
        return;
    L17:
        return;
    }

    public void execResumeAnim() {
        xm.d r5 = this.mHeroAnimOwner;
        r5.getClass();
        if (xm.f.f23173a.g == true) goto L5;
        return;
    L5:
        if (r5.f23169j == false) goto L7;
        return;
    L7:
        if (r5.f23170k == true) goto L19;
        tm.b r10 = r5.f23167h;
        if (r10 == null) goto L17;
        r5.f23164a.setAnimation(r10);
        if (r5.f23164a.getKeyframeManager() == null) goto L18;
        r5.f23164a.getKeyframeManager().a();
        return;
    L18:
        return;
    L17:
        return;
    }

    public RecyclerView g() {
        return (RecyclerView) getView();
    }

    public int getBackgroundColor() {
        return this.mBackgroundManager.e;
    }

    public com.lynx.tasm.behavior.ui.utils.b getBackgroundManager() {
        return this.mBackgroundManager;
    }

    public LynxBaseUI getDrawHead() {
        return this.mDrawHead;
    }

    public xm.d getFakeSharedElementManager() {
        return this.mHeroAnimOwner;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @Nullable
    public com.lynx.tasm.animation.keyframe.a getKeyframeManager() {
        return this.mKeyframeManager;
    }

    @Nullable
    public ReadableMap getKeyframes(String r5) {
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L11;
        JavaOnlyMap r11 = r10.e;
        if (r11 != null) goto L8;
        return null;
    L8:
        if (r11.containsKey(r5) == false) goto L11;
        return r10.e.getMap(r5);
    L11:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @Nullable
    public um.e getLayoutAnimator() {
        return this.mLayoutAnimator;
    }

    public T getOrCreateView(Context r5, Object r10) {
        LynxContext r11 = this.mContext;
        if (r11 == null) goto L15;
        if (r11.L == false) goto L15;
        if (r11.l() == null) goto L15;
        if ((r10 instanceof z) == false) goto L15;
        setNodeIndex(((z) r10).f10785b);
        T r12 = (T) this.mContext.l().obtainViewAccordingToNodeIndex(this.mNodeIndex);
        if (r12 == null) goto L15;
        r12.setBackground(null);
        return r12;
    L15:
        return (T) createView(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getRealTimeTranslationZ() {
        return this.mView.getTranslationZ();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getScaleX() {
        T r5 = this.mView;
        if (r5 != null) goto L7;
        return 1.0f;
    L7:
        return r5.getScaleX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getScaleY() {
        T r5 = this.mView;
        if (r5 != null) goto L7;
        return 1.0f;
    L7:
        return r5.getScaleY();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public Matrix getTransformMatrix() {
        T r5 = this.mView;
        if (r5 == null) goto L10;
        if (r5.getMatrix() == null) goto L10;
        return this.mView.getMatrix();
    L10:
        return super.getTransformMatrix();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public vm.i getTransitionAnimator() {
        return this.mTransitionAnimator;
    }

    public LynxUI getTransitionUI() {
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getTranslationX() {
        return this.mView.getTranslationX();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getTranslationY() {
        return this.mView.getTranslationY();
    }

    public T getView() {
        return this.mView;
    }

    public g0 getViewInfo() {
        return this.mViewInfo;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean getVisibility() {
        return this.mSetVisibleByCSS;
    }

    public final void h() {
        if (this.mLayoutAnimator != null) goto L6;
        this.mLayoutAnimator = new um.e();
        return;
    }

    public void handleLayout() {
        if (isDetachedWithView() == false) goto L6;
        return;
    L6:
        if (TraceController.g == false) goto L8;
        String r5 = "LynxUI.layout." + getTagName();
        TraceEvent.c(r5);
    L9:
        this.mView.layout(getLeft(), getTop(), getWidth() + getLeft(), getHeight() + getTop());
        if ((getParent() instanceof UIShadowProxy) == false) goto L13;
        ((UIShadowProxy) getParent()).f10388a.getTransformRaws();
    L13:
        if ((this.mView.getParent() instanceof ViewGroup) == false) goto L28;
        ViewGroup r10 = (ViewGroup) this.mView.getParent();
        if (getSkewX() == 0.0f) goto L17;
    L20:
        boolean r11 = true;
    L22:
        if (getOverflow() != 0) goto L24;
        if (r11 == true) goto L24;
    L25:
        if (r11 == true) goto L28;
        ViewCompat.setClipBounds(this.mView, getBoundRectForOverflow());
    L24:
        r10.setClipChildren(false);
        goto L25
    L17:
        if (getSkewY() != 0.0f) goto L20;
        r11 = false;
    L28:
        if (getOverflow() == 0) goto L37;
        if (getWidth() != 0) goto L32;
    L33:
        T r12 = this.mView;
        if ((r12 instanceof AndroidText) == false) goto L37;
        ((AndroidText) r12).setOverflow(getOverflow());
        goto L37
    L32:
        if (getHeight() == 0) goto L33;
    L37:
        if (TraceController.g == false) goto L40;
        TraceEvent.a(0, r5);
        return;
    L40:
        return;
    L8:
        r5 = null;
        goto L9
    }

    public boolean hasAnimationRunning() {
        com.lynx.tasm.animation.keyframe.a r5 = this.mKeyframeManager;
        if (r5 == null) goto L12;
        HashMap r10 = r5.f10083c;
        if (r10 == null) goto L12;
        Iterator r11 = r10.values().iterator();
    L8:
        if (r11.hasNext() == false) goto L12;
        if (((com.lynx.tasm.animation.keyframe.g) r11.next()).f10103h != LynxKeyframeAnimator$LynxKFAnimatorState.f10079b) goto L8;
        return true;
    L12:
        vm.i r12 = this.mTransitionAnimator;
        if (r12 != null) goto L15;
    L16:
        T r13 = this.mView;
        if (r13 != null) goto L19;
        return false;
    L19:
        if (r13.getAnimation() == null) goto L29;
        return true;
    L29:
        return false;
    L15:
        if (r12.f22603h.isEmpty() == true) goto L16;
        return true;
    }

    public boolean hasOverlappingRenderingEnabled() {
        if ("HUAWEI".equals(Build.MANUFACTURER) == false) goto L9;
        if (DeviceUtils.is64BitDevice() == true) goto L9;
        LynxLog.b(2, TAG, "Disable overlap rendering for Huawei 32bit machine");
        return false;
    L9:
        return this.mOverlappingRendering;
    }

    public boolean hasTranslateDiff(@Nullable ReadableArray r5) {
        ArrayList r10 = com.lynx.tasm.behavior.ui.utils.o.b(r5);
        if (Float.compare(com.lynx.tasm.behavior.ui.utils.o.a(this.mTransformRaw), com.lynx.tasm.behavior.ui.utils.o.a(r10)) == 0) goto L5;
        boolean r11 = true;
    L7:
        if (Float.compare(com.lynx.tasm.behavior.ui.utils.o.c(this.mTransformRaw), com.lynx.tasm.behavior.ui.utils.o.c(r10)) == 0) goto L9;
        boolean r12 = true;
    L10:
        if (r11 == true) goto L14;
        if (r12 == true) goto L14;
        return false;
    L14:
        return true;
    L9:
        r12 = false;
        goto L10
    L5:
        r11 = false;
        goto L7
    }

    public void initAccessibilityDelegate() {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void initTransitionAnimator(ReadableMap r17) {
        if (this.mTransitionAnimator != null) goto L5;
        this.mTransitionAnimator = new vm.i(getTransitionUI());
    L5:
        vm.i r5 = this.mTransitionAnimator;
        r5.getClass();
        if (r17 == null) goto L63;
        ReadableArray r10 = r17.getArray("transition");
        if (r10 != null) goto L11;
        r5.b();
        goto L63
    L11:
        SparseArray r11 = r5.f22605j;
        r5.f22605j = new SparseArray();
        int r12 = 0;
        int r13 = 0;
    L13:
        if (r13 >= r10.size()) goto L37;
        ReadableArray r14 = r10.getArray(r13);
        int r15 = r14.getInt(0);
        int[] r16 = tm.a.f22139a;
        if (r15 == 8177) goto L26;
        if (r15 == 16369) goto L26;
        if (r15 == 262129) goto L26;
        if (r15 == 262144) goto L26;
        int r18 = 0;
    L21:
        if (r18 >= 10) goto L33;
        if (r15 == r16[r18]) goto L26;
        r18 = r18 + 1;
    L33:
        r13 = r13 + 1;
    L26:
        tm.b r19 = new tm.b();
        r19.d = r15;
        r19.f22141b = (long) r14.getDouble(1);
        r19.f22142c = (long) r14.getDouble(r19.a(2, r14));
        r19.f22150o = r13;
        int r20 = r19.d;
        if (r20 == 8177) goto L34;
        if (r20 == 16369) goto L34;
        if (r20 == 262129) goto L34;
        if (r20 == 262144) goto L34;
        r5.f22605j.put(r20, r19);
    L34:
        r5.f22605j.clear();
        int r21 = 0;
        int r22 = 0;
    L35:
        if (r21 >= 10) goto L37;
        int r23 = r16[r21];
        tm.b r24 = new tm.b();
        r24.f22147l = -1;
        r24.f22149n = -1;
        r24.f22150o = -1;
        r24.f22140a = r19.f22140a;
        r24.f22141b = r19.f22141b;
        r24.f22142c = r19.f22142c;
        r24.e = r19.e;
        r24.f = r19.f;
        r24.g = r19.g;
        r24.f22143h = r19.f22143h;
        r24.f22144i = r19.f22144i;
        r24.f22145j = r19.f22145j;
        r24.f22146k = r19.f22146k;
        r24.f22147l = r19.f22147l;
        r24.f22148m = r19.f22148m;
        r24.f22149n = r19.f22149n;
        r24.f22150o = r22;
        r24.d = r23;
        r5.f22605j.put(r23, r24);
        r21 = r21 + 1;
        r22 = r22 + 1;
    L37:
        SparseArray r25 = r5.f22605j;
        if (r25.indexOfKey(256) >= 0) goto L40;
    L45:
        SparseArray r26 = r5.f22605j;
        if (r26.indexOfKey(512) >= 0) goto L48;
    L53:
        if (r11 == null) goto L61;
    L55:
        if (r12 >= r11.size()) goto L61;
        int r27 = r11.keyAt(r12);
        if (r5.f22605j.indexOfKey(r27) >= 0) goto L59;
        r5.d(Integer.valueOf(r27));
    L59:
        r12 = r12 + 1;
    L61:
        if (r5.f22605j.size() == 0) goto L63;
        return;
    L48:
        if (r26.indexOfKey(2048) < 0) goto L53;
        if (((tm.b) r26.get(512)).f22150o >= ((tm.b) r26.get(2048)).f22150o) goto L52;
        r26.remove(512);
        goto L53
    L52:
        r26.remove(2048);
        goto L53
    L40:
        if (r25.indexOfKey(1024) < 0) goto L45;
        if (((tm.b) r25.get(256)).f22150o >= ((tm.b) r25.get(1024)).f22150o) goto L44;
        r25.remove(256);
        goto L45
    L44:
        r25.remove(1024);
    L63:
        this.mTransitionAnimator = null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void initialize() {
        super.initialize();
        T r5 = (T) getOrCreateView(this.mContext, this.mParam);
        this.mView = r5;
        if (r5 == null) goto L13;
        this.mHeroAnimOwner = new xm.d(this);
        com.lynx.tasm.behavior.ui.utils.b r10 = new com.lynx.tasm.behavior.ui.utils.b(this, getLynxContext());
        this.mBackgroundManager = r10;
        setLynxBackground(r10);
        com.lynx.tasm.behavior.ui.utils.b r11 = this.mBackgroundManager;
        r11.f10751c = this.mDrawableCallback;
        com.lynx.tasm.behavior.ui.accessibility.d r12 = this.mContext.j();
        if (r12 != null) goto L8;
        return;
    L8:
        if (r12.g() == false) goto L12;
        initAccessibilityDelegate();
        return;
    L12:
        return;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void insertDrawList(LynxBaseUI r5, LynxBaseUI r10) {
        r10.setDrawParent(this);
        if (r5 != null) goto L9;
        LynxBaseUI r11 = this.mDrawHead;
        if (r11 == null) goto L7;
        r11.mPreviousDrawUI = r10;
        r10.mNextDrawUI = r11;
    L7:
        this.mDrawHead = r10;
        return;
    L9:
        LynxBaseUI r12 = r5.mNextDrawUI;
        if (r12 == null) goto L12;
        r12.mPreviousDrawUI = r10;
        r10.mNextDrawUI = r12;
    L12:
        r10.mPreviousDrawUI = r5;
        r5.mNextDrawUI = r10;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.a0
    public void invalidate() {
        T r5 = this.mView;
        if (r5 != null) goto L5;
        return;
    L5:
        r5.invalidate();
    }

    public boolean isRtl() {
        if (this.mLynxDirection != 2) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean isUserInteractionEnabled() {
        if (this.userInteractionEnabled == false) goto L10;
        T r5 = this.mView;
        if (r5 != null) goto L7;
        return false;
    L7:
        if (r5.getVisibility() != 0) goto L13;
        return true;
    L13:
        return false;
    L10:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean isVisible() {
        T r5 = this.mView;
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5.getVisibility() == 0) goto L9;
        return false;
    L9:
        if (this.mView.getAlpha() >= 0.01d) goto L12;
        return false;
    L12:
        return this.mView.isAttachedToWindow();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void layout() {
        handleLayout();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void measure() {
        if (TraceController.g == false) goto L5;
        String r5 = "LynxUI.measure." + getTagName();
        TraceEvent.c(r5);
    L7:
        if (isDetachedWithView() == true) goto L10;
        setLayoutParamsInternal();
        this.mView.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(getHeight(), BasicMeasure.EXACTLY));
    L10:
        if (TraceController.g == false) goto L13;
        TraceEvent.a(0, r5);
        return;
    L13:
        return;
    L5:
        r5 = null;
        goto L7
    }

    public void onAnimationEnd(String r5) {
        xm.d r10 = this.mHeroAnimOwner;
        com.lynx.tasm.animation.keyframe.d r11 = (com.lynx.tasm.animation.keyframe.d) r10.f23171l.get(r5);
        if (r11 == null) goto L6;
        r11.a(r5);
        r10.f23171l.remove(r5);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAnimationNodeReady() {
        super.onAnimationNodeReady();
        updatePerspectiveToView();
        if (shouldDoTransform() == false) goto L47;
        com.lynx.tasm.behavior.ui.utils.b r5 = this.mBackgroundManager;
        com.lynx.tasm.behavior.ui.utils.m r10 = this.mTransformOrigin;
        LynxUI r11 = (LynxUI) r5.f.get();
        if (r11 == null) goto L28;
        if (r11.getView() == null) goto L28;
        if (r10 == null) goto L28;
        float r12 = r11.getLatestWidth();
        float r13 = r11.getLatestHeight();
        new LinkedHashMap().clear();
        float r14 = r12 * 0.5f;
        float r15 = r13 * 0.5f;
        if (r10 == com.lynx.tasm.behavior.ui.utils.m.e) goto L26;
        float r16 = r10.f10758a;
        int r17 = r10.f10759b;
        if (r16 != 0.5f) goto L17;
        if (r17 != 1) goto L17;
    L20:
        float r18 = r10.f10760c;
        int r19 = r10.d;
        if (r18 != 0.5f) goto L23;
        if (r19 == 1) goto L26;
    L23:
        if (r19 != 1) goto L25;
        r15 = r13 * r18;
        goto L26
    L25:
        r15 = r18;
    L17:
        if (r17 != 1) goto L19;
        r14 = r12 * r16;
        goto L20
    L19:
        r14 = r16;
    L26:
        r11.getView().setPivotX(r14);
        r11.getView().setPivotY(r15);
        r11.getView().invalidate();
    L28:
        if (this.mIsFirstAnimatedReady == false) goto L30;
    L42:
        vm.i r20 = this.mTransitionAnimator;
        if (r20 == null) goto L45;
        r20.d(4096);
    L45:
        this.mBackgroundManager.o(this.mTransformRaw);
        goto L47
    L30:
        if (this.hasTransformChanged == false) goto L42;
        vm.i r21 = this.mTransitionAnimator;
        if (r21 == null) goto L42;
        if (r21.f22605j.size() == 0) goto L42;
        if (r21.f22605j.get(4096) == null) goto L42;
        vm.i r22 = this.mTransitionAnimator;
        LynxUI<T> r23 = r22.g;
        if (r23 != null) goto L41;
        r23 = this;
    L41:
        r22.c(r23, 4096, r23.getTransformRaws());
    L47:
        if (this.mOffsetHasChanged == false) goto L76;
        in.b r24 = this.mOffsetPath;
        if (r24 == null) goto L75;
        Path r25 = r24.b(getWidth(), getHeight());
        float r26 = this.mOffsetDistance;
        LRUHashMap r27 = in.d.f17601a;
        float r28 = 0.0f;
        if (r25 != null) goto L53;
        float[] r29 = {0.0f, 0.0f, 0.0f};
    L72:
        if (this.mIsAutoOffsetRotate == false) goto L74;
        applyOffsetAndRotate(r29[0], r29[1], r29[2]);
        goto L75
    L74:
        applyOffsetAndRotate(r29[0], r29[1], this.mOffsetRotate);
        goto L75
    L53:
        float r30 = Math.max(0.0f, Math.min(1.0f, r26));
        LRUHashMap r31 = in.d.f17601a;
        in.c r32 = (in.c) r31.get(r25);
        if (r32 != null) goto L59;
        in.c r33 = new in.c();
        PathMeasure r110 = new PathMeasure(r25, false);
    L56:
        float r34 = r110.getLength();
        r33.f17600b.add(Float.valueOf(r34));
        r33.f17599a += r34;
        if (r110.nextContour() == true) goto L56;
        r31.put(r25, r33);
        r32 = r33;
    L59:
        float r35 = r32.f17599a * r30;
        int r36 = 0;
    L60:
        ArrayList r37 = r32.f17600b;
        if (r36 >= r37.size()) goto L66;
        float r38 = ((Float) r37.get(r36)).floatValue() + r28;
        if (r35 <= r38) goto L67;
        r36 = r36 + 1;
        r28 = r38;
    L67:
        PathMeasure r39 = new PathMeasure(r25, false);
        int r40 = 0;
    L68:
        if (r40 >= r36) goto L70;
        r39.nextContour();
        r40 = r40 + 1;
        goto L68
    L70:
        float[] r41 = new float[2];
        float[] r42 = new float[2];
        r39.getPosTan(r35 - r28, r41, r42);
        r29 = new float[]{r41[0], r41[1], (float) ((Math.toDegrees(Math.atan2(r42[0], r42[1])) + 360.0d) % 180.0d)};
        goto L72
    L66:
        r36 = 0;
    L75:
        this.mOffsetHasChanged = false;
    L76:
        vm.i r43 = this.mTransitionAnimator;
        if (r43 == null) goto L95;
        HashMap r44 = r43.f22604i;
        if (r44.isEmpty() == true) goto L95;
        Iterator r45 = r44.entrySet().iterator();
    L83:
        if (r45.hasNext() == false) goto L94;
        Map.Entry r46 = (Map.Entry) r45.next();
        HashMap r47 = r43.f22603h;
        Animator r48 = (Animator) r47.get(r46.getKey());
        if (r48 == null) goto L87;
        r48.cancel();
    L87:
        Animator r49 = ((Animator) r46.getValue()).clone();
        r49.setDuration(10000000);
        r49.setStartDelay(0);
        if ((r49 instanceof AnimatorSet) == false) goto L93;
        Iterator<Animator> r50 = ((AnimatorSet) r49).getChildAnimations().iterator();
    L91:
        if (r50.hasNext() == false) goto L93;
        r50.next().removeAllListeners();
    L93:
        r49.removeAllListeners();
        r49.addListener(new com.lynx.tasm.animation.keyframe.f(1));
        r49.start();
        ((Animator) r46.getValue()).start();
        r47.put(r46.getKey(), r46.getValue());
        goto L83
    L94:
        r44.clear();
    L95:
        com.lynx.tasm.animation.keyframe.a r51 = this.mKeyframeManager;
        if (r51 == null) goto L98;
        r51.a();
    L98:
        LynxContext r52 = this.mContext;
        if (r52 == null) goto L111;
        a1 r53 = r52.f10140h;
        if (r53 == null) goto L103;
        boolean r54 = r53.f10187o;
    L104:
        if (r54 == false) goto L111;
        if (this.mHasTranslateDiff == false) goto L111;
        if (r53 == null) goto L111;
        HashSet r55 = r53.f10191t;
        if (r55 == null) goto L111;
        r55.add(Integer.valueOf(getSign()));
        goto L111
    L103:
        r54 = false;
    L111:
        this.mHasTranslateDiff = false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        com.lynx.tasm.animation.keyframe.a r5 = this.mKeyframeManager;
        if (r5 == null) goto L16;
        HashMap r10 = r5.f10083c;
        if (r10 == null) goto L24;
        Iterator r11 = r10.values().iterator();
    L9:
        if (r11.hasNext() == false) goto L25;
        com.lynx.tasm.animation.keyframe.g r12 = (com.lynx.tasm.animation.keyframe.g) r11.next();
        ObjectAnimator[] r13 = r12.g;
        if (r13 == null) goto L9;
        int r14 = r13.length;
        if (r14 <= 0) goto L9;
        r13[r14 - 1].addListener(new com.lynx.tasm.animation.keyframe.b(r12));
        goto L9
    L25:
        return;
    L24:
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        com.lynx.tasm.animation.keyframe.a r5 = this.mKeyframeManager;
        if (r5 == null) goto L15;
        HashMap r10 = r5.f10083c;
        if (r10 == null) goto L15;
        Iterator r11 = r10.values().iterator();
    L9:
        if (r11.hasNext() == false) goto L15;
        ObjectAnimator[] r12 = ((com.lynx.tasm.animation.keyframe.g) r11.next()).g;
        if (r12 == null) goto L9;
        int r13 = r12.length;
        int r14 = 0;
    L13:
        if (r14 >= r13) goto L9;
        r12[r14].removeAllListeners();
        r14 = r14 + 1;
    L15:
        um.e r15 = this.mLayoutAnimator;
        if (r15 == null) goto L24;
        r15.d();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDrawingPositionChanged() {
        if (this.mView.isLayoutRequested() == true) goto L6;
        handleLayout();
        invalidate();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, wm.a
    public void onFocusChanged(boolean r5, boolean r10) {
        if (r10 == true) goto L12;
        InputMethodManager r11 = LynxEnv.inst().getInputMethodManager();
        if (r11 != null) goto L7;
        LynxLog.b(3, TAG, "Failed to get InputMethodManager");
        return;
    L7:
        if (r5 == false) goto L10;
        r11.showSoftInput(this.mView, 1);
        return;
    L10:
        r11.hideSoftInputFromWindow(this.mView.getWindowToken(), 0);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        if (getBound() != null) goto L5;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == true) goto L13;
    L16:
        if (r5 == true) goto L19;
        this.mView.setVisibility(8);
        return;
    L19:
        return;
    L13:
        if (this.mSetVisibleByCSS == false) goto L16;
        this.mView.setVisibility(0);
        return;
    L5:
        if (getBound().width() > 0) goto L7;
    L9:
        r5 = false;
        goto L11
    L7:
        if (getBound().height() <= 0) goto L9;
        goto L9
    }

    public void onListCellAppear(String r5, UIList r10) {
        super.onListCellAppear(r5, r10);
        if (this.mEnableReuseAnimationState == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == false) goto L8;
        return;
    L8:
        if (this.mAnimationInfos == null) goto L37;
        String r11 = "Animation_" + constructListStateCacheKey(getTagName(), r5, getIdSelector());
        com.lynx.tasm.animation.keyframe.a r12 = (com.lynx.tasm.animation.keyframe.a) r10.f10522t.get(r11);
        if (r12 == null) goto L30;
        r10.f10522t.remove(r11);
        com.lynx.tasm.animation.keyframe.a r13 = this.mKeyframeManager;
        if (r13 == null) goto L21;
        r13.f10081a = null;
        HashMap r14 = r13.f10083c;
        if (r14 == null) goto L20;
        Iterator r15 = r14.values().iterator();
    L18:
        if (r15.hasNext() == false) goto L20;
        com.lynx.tasm.animation.keyframe.g r16 = (com.lynx.tasm.animation.keyframe.g) r15.next();
        r16.d();
        r16.j();
        r16.f10101b = null;
        r16.f10102c = null;
    L20:
        this.mKeyframeManager = null;
    L21:
        r12.f10081a = new WeakReference(this);
        HashMap r17 = r12.f10083c;
        if (r17 == null) goto L28;
        Iterator r18 = r17.values().iterator();
    L26:
        if (r18.hasNext() == false) goto L28;
        com.lynx.tasm.animation.keyframe.g r19 = (com.lynx.tasm.animation.keyframe.g) r18.next();
        r19.getClass();
        r19.f10101b = new WeakReference(this);
        r19.f10102c = new WeakReference(getView());
        r19.e(r19.f10104i);
    L28:
        this.mKeyframeManager = r12;
    L32:
        com.lynx.tasm.animation.keyframe.a r20 = this.mKeyframeManager;
        r20.f10082b = this.mAnimationInfos;
        r20.a();
        return;
    L30:
        if (this.mKeyframeManager != null) goto L32;
        this.mKeyframeManager = new com.lynx.tasm.animation.keyframe.a(this);
        goto L32
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onListCellDisAppear(String r5, LynxBaseUI r10, boolean r11) {
        super.onListCellDisAppear(r5, r10, r11);
        if (this.mEnableReuseAnimationState == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5) == true) goto L29;
        if (r11 == true) goto L9;
    L10:
        if (r11 == true) goto L28;
    L11:
        String r12 = "Animation_" + constructListStateCacheKey(getTagName(), r5, getIdSelector());
        if (r11 == true) goto L14;
        r10.removeKeyFromNativeStorage(r12);
    L15:
        com.lynx.tasm.animation.keyframe.a r13 = this.mKeyframeManager;
        if (r13 == null) goto L24;
        r13.f10081a = null;
        HashMap r14 = r13.f10083c;
        if (r14 == null) goto L24;
        Iterator r15 = r14.values().iterator();
    L22:
        if (r15.hasNext() == false) goto L24;
        com.lynx.tasm.animation.keyframe.g r16 = (com.lynx.tasm.animation.keyframe.g) r15.next();
        r16.d();
        r16.j();
        r16.f10101b = null;
        r16.f10102c = null;
    L24:
        this.mKeyframeManager = null;
        return;
    L14:
        r10.storeKeyToNativeStorage(r12, this.mKeyframeManager);
        goto L15
    L28:
        return;
    L9:
        if (this.mKeyframeManager != null) goto L11;
    }

    public void processChildViewInfo(c r5) {
        LynxUI r10 = (LynxUI) r5;
        beforeProcessChildViewInfo(this.mViewInfo, r10.getView(), 0);
        r10.processViewInfo();
        afterProcessChildViewInfo(this.mViewInfo, r10.getView(), 0);
    }

    @Override // com.lynx.tasm.behavior.ui.c
    public void processLayoutChildren() {
    }

    @Override // com.lynx.tasm.behavior.ui.c
    public void processMeasureChildren() {
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
        LynxContext r5 = this.mContext;
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.l() == null) goto L10;
        this.mContext.l().registerViewAccordingToNodeIndex(this.mNodeIndex, this.mView);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.a0
    public void requestLayout() {
        this.mView.requestLayout();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setAccessibilityElement(@Nullable pm.a r5) {
        super.setAccessibilityElement(r5);
        com.lynx.tasm.behavior.ui.accessibility.d r10 = this.mContext.j();
        if (this.mView != null) goto L5;
        return;
    L5:
        if (this.mAccessibilityElementStatus == (-1)) goto L16;
        if (r10 != null) goto L8;
        return;
    L8:
        if (r10.g() == false) goto L18;
        T r11 = this.mView;
        int r12 = 1;
        if (this.mAccessibilityElementStatus == 1) goto L13;
        r12 = 2;
    L13:
        ViewCompat.setImportantForAccessibility(r11, r12);
        return;
    L18:
        return;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = false, name = "accessibility-elements-hidden")
    public void setAccessibilityElementsHidden(boolean r5) {
        T r10 = this.mView;
        if (r5 == false) goto L5;
        int r11 = 4;
    L6:
        r10.setImportantForAccessibility(r11);
        return;
    L5:
        r11 = 0;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setAccessibilityHeading(boolean r5) {
        this.mView.setAccessibilityHeading(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @com.lynx.tasm.behavior.c0(name = "accessibility-label")
    public void setAccessibilityLabel(@Nullable pm.a r5) {
        super.setAccessibilityLabel(r5);
        T r10 = this.mView;
        if (r10 == null) goto L6;
        r10.setFocusable(true);
        this.mView.setContentDescription(getAccessibilityLabel());
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setAccessibilityValue(String r5) {
        this.mView.setStateDescription(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @com.lynx.tasm.behavior.c0(defaultFloat = 1.0f, name = "opacity")
    public void setAlpha(float r5) {
        super.setAlpha(r5);
        if (getKeyframeManager() == null) goto L5;
        getKeyframeManager().b("Alpha", Float.valueOf(r5));
    L5:
        vm.i r10 = this.mTransitionAnimator;
        if (r10 == null) goto L14;
        if (r10.f22605j.size() == 0) goto L14;
        if (r10.f22605j.get(1) == null) goto L14;
        this.mTransitionAnimator.c(this, 1, Float.valueOf(r5));
        return;
    L14:
        if (r5 == this.mView.getAlpha()) goto L16;
        this.mView.setAlpha(r5);
    L16:
        um.e r11 = this.mLayoutAnimator;
        if (r11 == null) goto L20;
        r11.f22394x = r5;
        return;
    }

    public void setAnimation(@NonNull tm.b r5) {
        if (this.mKeyframeManager != null) goto L5;
        this.mKeyframeManager = new com.lynx.tasm.animation.keyframe.a(this);
    L5:
        tm.b[] r10 = {r5};
        this.mKeyframeManager.f10082b = r10;
    }

    @com.lynx.tasm.behavior.c0(name = "clip-path")
    public void setClipPath(@Nullable ReadableArray r5) {
        this.mClipPath = in.b.c(r5, this.mContext.f10152u.scaledDensity);
    }

    public void setDrawHead(LynxBaseUI r5) {
        this.mDrawHead = r5;
    }

    @com.lynx.tasm.behavior.c0(defaultBoolean = true, name = "enable-reuse-animation-state")
    public void setEnableReuseAnimationState(boolean r5) {
        this.mEnableReuseAnimationState = r5;
        if (r5 == true) goto L8;
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L9;
        LynxFeatureCounter.a(72, r10.A);
        return;
    L9:
        return;
    }

    public void setEnterAnim(tm.b r5) {
        this.mHeroAnimOwner.e = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "enter-transition-name")
    public void setEnterTransitionName(@Nullable ReadableArray r5) {
        tm.b r10 = tm.b.b(r5);
        if (r10 == null) goto L15;
        LynxContext r11 = this.mContext;
        if (r11 == null) goto L7;
        LynxFeatureCounter.a(67, r11.A);
    L7:
        xm.i r12 = xm.f.f23173a;
        monitor-enter(r12);
        r12.f23176c.put(this, r10);     // Catch: Throwable -> L12
        setEnterAnim(r10);     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void setExitAnim(tm.b r5) {
        this.mHeroAnimOwner.f = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "exit-transition-name")
    public void setExitTransitionName(@Nullable ReadableArray r5) {
        tm.b r10 = tm.b.b(r5);
        if (r10 == null) goto L15;
        LynxContext r11 = this.mContext;
        if (r11 == null) goto L7;
        LynxFeatureCounter.a(68, r11.A);
    L7:
        xm.i r12 = xm.f.f23173a;
        monitor-enter(r12);
        r12.f23175b.put(this, r10);     // Catch: Throwable -> L12
        setExitAnim(r10);     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @com.lynx.tasm.behavior.c0(name = "filter")
    public void setFilter(@Nullable ReadableArray r10) {
        if (this.mView != null) goto L6;
        return;
    L6:
        if (r10 != null) goto L8;
    L10:
        double r5 = 0.0d;
        int r11 = 0;
    L11:
        if (r11 != 0) goto L13;
        this.mView.setLayerType(0, null);
        T r12 = this.mView;
        if ((r12 instanceof com.lynx.tasm.behavior.ui.view.b) == false) goto L33;
        ((com.lynx.tasm.behavior.ui.view.b) r12).removeBlur();
    L33:
        this.mGrayscaleAmount = 1.0f;
        return;
    L13:
        if (r11 == 1) goto L20;
        if (r11 != 2) goto L38;
        T r13 = this.mView;
        if ((r13 instanceof com.lynx.tasm.behavior.ui.view.b) == false) goto L35;
        ((com.lynx.tasm.behavior.ui.view.b) r13).setBlur((float) r5);
        return;
    L35:
        return;
    L38:
        return;
    L20:
        Double r14 = Double.valueOf(1.0d - r5);
        Double r15 = Double.valueOf(0.0d);
        Double r16 = Double.valueOf(1.0d);
        if (r14.compareTo(r15) >= 0) goto L24;
        r14 = r15;
    L26:
        float r17 = (float) r14.doubleValue();
        if (com.lynx.tasm.utils.a.k(this.mGrayscaleAmount, r17) == true) goto L36;
        ColorMatrix r18 = new ColorMatrix();
        r18.setSaturation(r17);
        Paint r19 = new Paint(1);
        r19.setColorFilter(new ColorMatrixColorFilter(r18));
        this.mView.setLayerType(2, r19);
        this.mGrayscaleAmount = r17;
        return;
    L36:
        return;
    L24:
        if (r14.compareTo(r16) <= 0) goto L26;
        r14 = r16;
        goto L26
    L8:
        if (r10.size() != 3) goto L10;
        r11 = r10.getInt(0);
        r5 = r10.getDouble(1);
        goto L11
    }

    @com.lynx.tasm.behavior.c0(name = "layout-animation-create-delay")
    public void setLayoutAnimationCreateDelay(@Nullable double r5) {
        h();
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(64, r10.A);
    L5:
        um.e r11 = this.mLayoutAnimator;
        if (r11.f22390t != null) goto L8;
        r11.f22390t = new um.f(0);
    L8:
        ((tm.b) r11.f22390t.f22372b).f22142c = (long) r5;
    }

    @com.lynx.tasm.behavior.c0(name = "layout-animation-create-duration")
    public void setLayoutAnimationCreateDuration(@Nullable double r5) {
        h();
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(64, r10.A);
    L5:
        um.e r11 = this.mLayoutAnimator;
        if (r11.f22390t != null) goto L8;
        r11.f22390t = new um.f(0);
    L8:
        um.f r12 = r11.f22390t;
        ((tm.b) r12.f22372b).f22141b = (long) r5;
        if (r12.k() == true) goto L12;
        r11.b("layout-animation-create");
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "layout-animation-create-property")
    public void setLayoutAnimationCreateProperty(@Nullable int r5) {
        h();
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(64, r10.A);
    L5:
        um.e r11 = this.mLayoutAnimator;
        if (r11.f22390t != null) goto L8;
        r11.f22390t = new um.f(0);
    L8:
        ((tm.b) r11.f22390t.f22372b).d = r5;
    }

    public void setLayoutAnimationCreateTimingFunc(@Nullable String r5) {
    }

    @com.lynx.tasm.behavior.c0(name = "layout-animation-delete-delay")
    public void setLayoutAnimationDeleteDelay(@Nullable double r5) {
        h();
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(66, r10.A);
    L5:
        um.e r11 = this.mLayoutAnimator;
        if (r11.f22392v != null) goto L8;
        r11.f22392v = new um.g(0);
    L8:
        ((tm.b) r11.f22392v.f22372b).f22142c = (long) r5;
    }

    @com.lynx.tasm.behavior.c0(name = "layout-animation-delete-duration")
    public void setLayoutAnimationDeleteDuration(@Nullable double r5) {
        h();
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(66, r10.A);
    L5:
        um.e r11 = this.mLayoutAnimator;
        if (r11.f22392v != null) goto L8;
        r11.f22392v = new um.g(0);
    L8:
        um.g r12 = r11.f22392v;
        ((tm.b) r12.f22372b).f22141b = (long) r5;
        if (r12.k() == true) goto L12;
        r11.b("layout-animation-delete");
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "layout-animation-delete-property")
    public void setLayoutAnimationDeleteProperty(@Nullable int r5) {
        h();
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(66, r10.A);
    L5:
        um.e r11 = this.mLayoutAnimator;
        if (r11.f22392v != null) goto L8;
        r11.f22392v = new um.g(0);
    L8:
        ((tm.b) r11.f22392v.f22372b).d = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "layout-animation-delete-timing-function")
    public void setLayoutAnimationDeleteTimingFunc(@Nullable ReadableArray r5) {
        h();
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(66, r10.A);
    L5:
        um.e r11 = this.mLayoutAnimator;
        if (r11.f22392v != null) goto L8;
        r11.f22392v = new um.g(0);
    L8:
        ((tm.b) r11.f22392v.f22372b).a(0, r5);
    }

    @com.lynx.tasm.behavior.c0(name = "layout-animation-update-delay")
    public void setLayoutAnimationUpdateDelay(@Nullable double r5) {
        h();
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(65, r10.A);
    L5:
        um.e r11 = this.mLayoutAnimator;
        if (r11.f22391u != null) goto L8;
        r11.f22391u = new um.i(0);
    L8:
        ((tm.b) r11.f22391u.f22372b).f22142c = (long) r5;
    }

    @com.lynx.tasm.behavior.c0(name = "layout-animation-update-duration")
    public void setLayoutAnimationUpdateDuration(@Nullable double r5) {
        h();
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(65, r10.A);
    L5:
        um.e r11 = this.mLayoutAnimator;
        if (r11.f22391u != null) goto L8;
        r11.f22391u = new um.i(0);
    L8:
        um.i r12 = r11.f22391u;
        ((tm.b) r12.f22372b).f22141b = (long) r5;
        if (r12.k() == true) goto L12;
        r11.b("layout-animation-update");
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "layout-animation-update-property")
    public void setLayoutAnimationUpdateProperty(@Nullable int r5) {
        h();
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(65, r10.A);
    L5:
        um.e r11 = this.mLayoutAnimator;
        if (r11.f22391u != null) goto L8;
        r11.f22391u = new um.i(0);
    L8:
        ((tm.b) r11.f22391u.f22372b).d = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "layout-animation-update-timing-function")
    public void setLayoutAnimationUpdateTimingFunc(@Nullable ReadableArray r5) {
        h();
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(65, r10.A);
    L5:
        um.e r11 = this.mLayoutAnimator;
        if (r11.f22391u != null) goto L8;
        r11.f22391u = new um.i(0);
    L8:
        ((tm.b) r11.f22391u.f22372b).a(0, r5);
    }

    public void setLayoutParamsInternal() {
        a0 r5 = this.mParent;
        if (r5 != null) goto L5;
        return;
    L5:
        if ((r5 instanceof UIGroup) == true) goto L7;
        return;
    L7:
        if (((UIGroup) r5).needCustomLayout() == false) goto L15;
        ViewGroup.LayoutParams r10 = this.mView.getLayoutParams();
        ViewGroup.LayoutParams r11 = ((UIGroup) this.mParent).generateLayoutParams(r10);
        if (r11 == null) goto L16;
        if (r10 == r11) goto L17;
        updateLayoutParams(r11);
        return;
    L17:
        return;
    L16:
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "offset-distance")
    public void setOffsetDistance(float r5) {
        if (this.mOffsetDistance == r5) goto L6;
        this.mOffsetDistance = r5;
        this.mOffsetHasChanged = true;
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "offset-path")
    public void setOffsetPath(@Nullable ReadableArray r5) {
        if (this.mRawOffsetShape == r5) goto L6;
        this.mRawOffsetShape = r5;
        this.mOffsetPath = in.b.c(r5, this.mContext.f10152u.scaledDensity);
        this.mOffsetHasChanged = true;
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "offset-rotate")
    public void setOffsetRotate(float r5) {
        if (this.mOffsetRotate == r5) goto L10;
        this.mOffsetRotate = r5;
        this.mOffsetHasChanged = true;
        if (r5 == OFFSET_ROTATE_AUTO) goto L8;
        this.mIsAutoOffsetRotate = false;
        return;
    L8:
        this.mIsAutoOffsetRotate = true;
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "overlap")
    public void setOverlap(@Nullable pm.a r5) {
        if (r5 != null) goto L5;
        this.mOverlappingRendering = true;
        return;
    L5:
        ReadableType r10 = r5.getType();
        if (r10 != ReadableType.Boolean) goto L10;
        this.mOverlappingRendering = r5.asBoolean();
        return;
    L10:
        if (r10 != ReadableType.String) goto L13;
        this.mOverlappingRendering = r5.asString().equalsIgnoreCase("true");
        return;
    }

    public void setPauseAnim(tm.b r5) {
        this.mHeroAnimOwner.g = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "pause-transition-name")
    public void setPauseTransitionName(@Nullable ReadableArray r5) {
        tm.b r10 = tm.b.b(r5);
        if (r10 == null) goto L15;
        LynxContext r11 = this.mContext;
        if (r11 == null) goto L7;
        LynxFeatureCounter.a(69, r11.A);
    L7:
        xm.i r12 = xm.f.f23173a;
        monitor-enter(r12);
        r12.e.put(this, r10);     // Catch: Throwable -> L12
        setPauseAnim(r10);     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @com.lynx.tasm.behavior.c0(name = "hardware-layer")
    public void setRenderToHardwareTexture(boolean r5) {
        if (r5 == false) goto L7;
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L6;
        LynxFeatureCounter.a(62, r10.A);
    L6:
        int r11 = 2;
    L8:
        this.mView.setLayerType(r11, null);
        return;
    L7:
        r11 = 0;
        goto L8
    }

    public void setResumeAnim(tm.b r5) {
        this.mHeroAnimOwner.f23167h = r5;
    }

    @com.lynx.tasm.behavior.c0(name = "resume-transition-name")
    public void setResumeTransitionName(@Nullable ReadableArray r5) {
        tm.b r10 = tm.b.b(r5);
        if (r10 == null) goto L15;
        LynxContext r11 = this.mContext;
        if (r11 == null) goto L7;
        LynxFeatureCounter.a(70, r11.A);
    L7:
        xm.i r12 = xm.f.f23173a;
        monitor-enter(r12);
        r12.d.put(this, r10);     // Catch: Throwable -> L12
        setResumeAnim(r10);     // Catch: Throwable -> L12
        monitor-exit(r12);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @com.lynx.tasm.behavior.c0(name = "shared-element")
    public void setShareElement(@Nullable String r5) {
        xm.d r10 = this.mHeroAnimOwner;
        r10.f23168i = r5;
        xm.i r11 = xm.f.f23173a;
        LynxUI r12 = r10.f23164a;
        monitor-enter(r11);
        r11.f.put(r12, r5);     // Catch: Throwable -> L7
        monitor-exit(r11);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setSign(int r5, String r10) {
        super.setSign(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @com.lynx.tasm.behavior.c0(name = "lynx-test-tag")
    public void setTestID(@Nullable String r5) {
        this.mView.setTag(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @com.lynx.tasm.behavior.c0(name = "transform")
    public void setTransform(@Nullable ReadableArray r5) {
        this.mHasTranslateDiff = hasTranslateDiff(r5);
        super.setTransform(r5);
        if (getKeyframeManager() == null) goto L6;
        getKeyframeManager().b("Transform", this.mTransformRaw);
        return;
    }

    @com.lynx.tasm.behavior.c0(name = "transform-order")
    public void setTransformOrder(@Nullable pm.a r5) {
        if (r5 != null) goto L5;
        this.mBackgroundManager.f10739i = true;
        return;
    L5:
        ReadableType r10 = r5.getType();
        if (r10 != ReadableType.Boolean) goto L10;
        com.lynx.tasm.behavior.ui.utils.b r11 = this.mBackgroundManager;
        r11.f10739i = r5.asBoolean();
        return;
    L10:
        if (r10 != ReadableType.String) goto L13;
        String r12 = r5.asString();
        com.lynx.tasm.behavior.ui.utils.b r13 = this.mBackgroundManager;
        r13.f10739i = r12.equalsIgnoreCase("true");
        return;
    }

    @com.lynx.tasm.behavior.c0(defaultInt = 1, name = "visibility")
    public void setVisibility(int r5) {
        vm.i r10 = this.mTransitionAnimator;
        if (r10 != null) goto L5;
    L10:
        int r11 = this.mView.getVisibility();
        if (r5 != 1) goto L13;
        this.mSetVisibleByCSS = true;
        this.mView.setVisibility(0);
        r11 = 0;
    L16:
        if ((getParent() instanceof UIShadowProxy) == false) goto L19;
        ((UIShadowProxy) getParent()).setVisibilityForView(r11);
        return;
    L19:
        return;
    L13:
        if (r5 != 0) goto L16;
        this.mSetVisibleByCSS = false;
        r11 = 4;
        this.mView.setVisibility(4);
        goto L16
    L5:
        if (r10.f22605j.size() == 0) goto L10;
        if (r10.f22605j.get(128) == null) goto L10;
        this.mTransitionAnimator.c(this, 128, Integer.valueOf(r5));
    }

    public void setVisibilityForView(int r5) {
        if (r5 != 0) goto L7;
        this.mSetVisibleByCSS = true;
        this.mView.setVisibility(0);
        return;
    L7:
        if (r5 != 4) goto L10;
        this.mSetVisibleByCSS = false;
        this.mView.setVisibility(4);
        return;
    }

    @com.lynx.tasm.behavior.f0
    public void takeScreenshot(ReadableMap r10, Callback r11) {
        if (this.mView != null) goto L6;
        r11.invoke(new Object[]{6, new JavaOnlyMap()});
        return;
    L6:
        String r5 = r10.getString("format", "jpeg");
        boolean r12 = r10.getBoolean("androidEnablePixelCopy", false);
        if (r5.equals("png") == false) goto L10;
        Bitmap.Config r13 = Bitmap.Config.ARGB_8888;
        Bitmap.CompressFormat r14 = Bitmap.CompressFormat.PNG;
        String r15 = "data:image/png;base64,";
    L9:
        Bitmap.CompressFormat r16 = r14;
        String r17 = r15;
        float r18 = (float) r10.getDouble("scale", 1.0d);
    L28:
        r11.invoke(new Object[]{1, new JavaOnlyMap()});
        return;
    L13:
        if (ko.r.g().e(ko.h.class) != null) goto L27;
        Bitmap r19 = Bitmap.createBitmap(this.mView.getWidth(), this.mView.getHeight(), r13);     // Catch: Throwable -> L28
        Canvas r20 = new Canvas(r19);     // Catch: Throwable -> L28
        if (r12 == false) goto L21;
        LynxContext r21 = this.mContext;     // Catch: Throwable -> L28
        if (r21 == null) goto L21;
        if (r21.l() == null) goto L21;
        com.lynx.tasm.behavior.i r22 = this.mContext.l().getLynxUIRendererInternal();     // Catch: Throwable -> L28
        T r23 = this.mView;     // Catch: Throwable -> L28
        ((LynxUIRenderer) r22).getClass();     // Catch: Throwable -> L28
        LynxUIRenderer.a(r23, r19, r20);     // Catch: Throwable -> L28
    L24:
        mn.h.i().execute(new m(r18, r19, r16, r17, r11));     // Catch: Throwable -> L28
        return;
    L21:
        boolean r24 = this.mView.isDirty();     // Catch: Throwable -> L28
        this.mView.draw(r20);     // Catch: Throwable -> L28
        if (r24 == false) goto L24;
        this.mView.postInvalidate();     // Catch: Throwable -> L28
        goto L24
    L27:
        throw new ClassCastException();     // Catch: Throwable -> L28
    L10:
        r13 = Bitmap.Config.RGB_565;
        r14 = Bitmap.CompressFormat.JPEG;
        r15 = "data:image/jpeg;base64,";
        goto L9
    }

    public void updateLayoutParams(ViewGroup.LayoutParams r5) {
        if (r5 == null) goto L8;
        r5.width = getWidth();
        r5.height = getHeight();
        if (r5 == this.mView.getLayoutParams()) goto L9;
        this.mView.setLayoutParams(r5);
        return;
    L9:
        return;
    L8:
        throw new RuntimeException("LayoutPrams should not be null");
    }

    public void updatePerspectiveToView() {
        float r5 = this.mContext.f10152u.density;
        ReadableArray r10 = this.mPerspective;
        if (r10 == null) goto L27;
        if (r10.size() <= 1) goto L27;
        if (this.mPerspective.getInt(1) == 3) goto L27;
        if (this.mPerspective.getInt(1) != 0) goto L12;
        double r11 = r5;
        float r12 = (float) (((this.mPerspective.getDouble(0) * r11) * r11) * ((double) LynxBaseUI.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
    L32:
        if (this.mPrePerspectiveValue == r12) goto L35;
        this.mPrePerspectiveValue = r12;
        this.mView.setCameraDistance(r12);
        return;
    L35:
        return;
    L12:
        if (this.mPerspective.getInt(1) == 1) goto L16;
        if (this.mPerspective.getInt(1) == 2) goto L16;
    L23:
        double r13 = this.mPerspective.getDouble(0);
    L24:
        float r14 = ((float) r13) * r5;
        float r15 = LynxBaseUI.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
    L25:
        r12 = r15 * r14;
    L16:
        if (this.mContext.f10145m == null) goto L23;
        if (this.mPerspective.getInt(1) != 1) goto L22;
        double r16 = this.mPerspective.getDouble(0) / 100.0d;
        int r17 = this.mContext.f10145m.getLatestWidth();
    L20:
        r13 = r16 * ((double) r17);
        goto L24
    L22:
        r16 = this.mPerspective.getDouble(0) / 100.0d;
        r17 = this.mContext.f10145m.getLatestHeight();
    L27:
        if (getWidth() <= getHeight()) goto L29;
        int r18 = getWidth();
    L30:
        r14 = (r18 * r5) * LynxBaseUI.CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
        r15 = 100.0f;
        goto L25
    L29:
        r18 = getHeight();
        goto L30
    }

    public T createView(Context r5, Object r10) {
        return (T) createView(r5);
    }

    @com.lynx.tasm.behavior.c0(name = "layout-animation-create-timing-function")
    public void setLayoutAnimationCreateTimingFunc(@Nullable ReadableArray r5) {
        h();
        LynxContext r10 = this.mContext;
        if (r10 == null) goto L5;
        LynxFeatureCounter.a(64, r10.A);
    L5:
        um.e r11 = this.mLayoutAnimator;
        if (r11.f22390t != null) goto L8;
        r11.f22390t = new um.f(0);
    L8:
        ((tm.b) r11.f22390t.f22372b).a(0, r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setAnimation(@Nullable ReadableArray r5) {
        if (r5 != null) goto L17;
        com.lynx.tasm.animation.keyframe.a r10 = this.mKeyframeManager;
        if (r10 == null) goto L14;
        HashMap r11 = r10.f10083c;
        if (r11 == null) goto L13;
        Iterator r12 = r11.values().iterator();
    L10:
        if (r12.hasNext() == false) goto L12;
        ((com.lynx.tasm.animation.keyframe.g) r12.next()).f();
        goto L10
    L12:
        r10.f10083c = null;
        r10.f10082b = null;
    L13:
        this.mKeyframeManager = null;
    L14:
        this.mAnimationInfos = null;
        return;
    L17:
        if (this.mKeyframeManager != null) goto L19;
        this.mKeyframeManager = new com.lynx.tasm.animation.keyframe.a(this);
    L19:
        int r13 = r5.size();
        tm.b[] r14 = new tm.b[r13];
        int r15 = 0;
    L20:
        if (r15 >= r13) goto L22;
        r14[r15] = tm.b.b(r5.getArray(r15));
        r15 = r15 + 1;
        goto L20
    L22:
        this.mAnimationInfos = r14;
        this.mKeyframeManager.f10082b = r14;
    }
}
