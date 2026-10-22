package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.image.FlattenUIImage;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public abstract class UIGroup<T extends ViewGroup> extends LynxUI<T> implements IDrawChildHook {
    private static final String TAG = "UIGroup";
    private static final float[] mEventCoords = null;
    private static final Matrix mInverseMatrix = null;
    private static final float[] mMatrixTransformCoords = null;
    private static final PointF mTempPoint = null;
    private static WeakHashMap<View, Integer> mZIndexHash;
    private final ArrayList<LynxFlattenUI> mActiveFlattenRendererHosts;
    private int mCurrentDrawIndex;
    private LynxBaseUI mCurrentDrawUI;
    private l mDrawingOrderHelper;
    private boolean mIsInsertViewCalled;
    private Rect mOverflowClipRect;

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void afterDraw(Canvas r1) {
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void afterDrawChild(Canvas r1, View r2, long r3) {
    }

    public boolean enableAutoClipRadius() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r1) {
        return null;
    }

    public void layoutChildren() {
        int r0 = 0;
    L4:
        if (r0 >= this.mChildren.size()) goto L15;
        LynxBaseUI r1 = (LynxBaseUI) ListProtector.get(this.mChildren, r0);
        if (needCustomLayout() == true) goto L12;
        if (r1.isFlatten() == true) goto L10;
        ((LynxUI) r1).layout();
    L14:
        r0 = r0 + 1;
        goto L4
    L10:
        ((LynxFlattenUI) r1).layout(r1.getOriginLeft(), r1.getOriginTop(), null);
        goto L14
    L12:
        if ((r1 instanceof UIGroup) == false) goto L14;
        ((UIGroup) r1).layoutChildren();
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean needCustomLayout() {
        return false;
    }

    static {
        mZIndexHash = new WeakHashMap();
        mEventCoords = new float[2];
        mTempPoint = new PointF();
        mMatrixTransformCoords = new float[2];
        mInverseMatrix = new Matrix();
    }

    public void dispatchOnAttach() {
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onAttach();
        goto L4
    }

    public void dispatchOnDetach() {
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().onDetach();
        goto L4
    }

    public int getChildCount() {
        return this.mChildren.size();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void layout() {
        if (((ViewGroup) this.mView).isLayoutRequested() == true) goto L5;
        return;
    L5:
        super.layout();
        layoutChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void measure() {
        if (((ViewGroup) this.mView).isLayoutRequested() == true) goto L5;
        return;
    L5:
        measureChildren();
        super.measure();
    }

    public void measureChildren() {
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().measure();
        goto L4
    }

    public void removeAll() {
        LynxBaseUI r0 = this.mDrawHead;
    L4:
        if (r0 == null) goto L6;
        r0.setDrawParent(null);
        r0 = r0.mNextDrawUI;
        goto L4
    L6:
        this.mDrawHead = null;
        Iterator<LynxBaseUI> r1 = this.mChildren.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        r1.next().setParent(null);
        goto L8
    L10:
        this.mChildren.clear();
        T r2 = this.mView;
        if (r2 == 0) goto L16;
        ((ViewGroup) r2).removeAllViews();
        return;
    }

    public void updateDrawingOrder() {
        this.mDrawingOrderHelper.update();
        if (this.mDrawingOrderHelper.b <= 0) goto L5;
        boolean r0 = true;
    L6:
        setChildrenDrawingOrderEnabledHelper(r0);
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().destroy();
        goto L4
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public boolean hasOverlappingRendering() {
        return hasOverlappingRenderingEnabled();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void initialize() {
        super.initialize();
        this.mDrawingOrderHelper = new l(getView());
        T r0 = this.mView;
        if ((r0 instanceof IDrawChildHook.IDrawChildHookBinding) == false) goto L6;
        ((IDrawChildHook.IDrawChildHookBinding) r0).bindDrawChildHook(this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        dispatchOnAttach();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDetach() {
        super.onDetach();
        dispatchOnDetach();
    }

    public View getAccessibilityHostView() {
        return this.mView;
    }

    public View getRealParentView() {
        return this.mView;
    }

    public boolean isInsertViewCalled() {
        return this.mIsInsertViewCalled;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void performLayoutChildrenUI() {
        layoutChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void performMeasureChildrenUI() {
        measureChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public void processLayoutChildren() {
        performLayoutChildrenUI();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public void processMeasureChildren() {
        performMeasureChildrenUI();
    }

    public UIGroup(LynxContext r2) {
        this(r2, null);
    }

    public static Integer getViewZIndex(View r1) {
        return mZIndexHash.get(r1);
    }

    private void onRemoveChildUI(LynxUI r2) {
        if (LynxUI.ENABLE_ZINDEX == true) goto L5;
        return;
    L5:
        l r0 = this.mDrawingOrderHelper;
        View r3 = r2.getView();
        r0.getClass();
        if (getViewZIndex(r3) == null) goto L8;
        r0.b--;
    L8:
        r0.c = null;
        if (this.mDrawingOrderHelper.b <= 0) goto L11;
        boolean r4 = true;
    L12:
        setChildrenDrawingOrderEnabledHelper(r4);
        return;
    L11:
        r4 = false;
        goto L12
    }

    private void setChildrenDrawingOrderEnabledHelper(boolean r3) {
        T r0 = this.mView;
        if ((r0 instanceof com.lynx.tasm.behavior.ui.view.a) == false) goto L6;
        ((com.lynx.tasm.behavior.ui.view.a) r0).setChildrenDrawingOrderEnabled(r3);
        return;
    L6:
        if ((r0 instanceof UIBody.UIBodyView) == false) goto L10;
        ((UIBody.UIBodyView) r0).setChildrenDrawingOrderEnabled(r3);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void afterDispatchDraw(Canvas r3) {
        LynxBaseUI r0 = this.mCurrentDrawUI;
    L3:
        if (r0 == null) goto L10;
        if (r0.isFlatten() == false) goto L9;
        if ((r0 instanceof UIShadowProxy) == true) goto L9;
        drawChild((LynxFlattenUI) r0, r3);
    L9:
        r0 = r0.mNextDrawUI;
        goto L3
    L10:
        finishInactiveFlattenRendererHosts(null, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public void afterDispatchProcessViewInfo(m r12) {
        super.afterDispatchProcessViewInfo(r12);
        LynxBaseUI r0 = this.mCurrentDrawUI;
    L3:
        if (r0 == null) goto L10;
        if (r0.isFlatten() == false) goto L9;
        if ((r0 instanceof UIShadowProxy) == true) goto L9;
        m.a r1 = new m.a(false, r0.getBound(), r0.getLynxBackground());
        int r2 = r0.getLeft();
        int r3 = r0.getTop();
        int r4 = r0.getWidth();
        int r5 = r0.getHeight();
        int r6 = r0.getPaddingLeft();
        int r7 = r0.getPaddingTop();
        int r8 = r0.getPaddingRight();
        int r9 = r0.getPaddingBottom();
        float r10 = ((LynxFlattenUI) r0).getAlpha();
        r1.g = r2;
        r1.h = r3;
        r1.i = r4;
        r1.j = r5;
        r1.k = r6;
        r1.l = r8;
        r1.m = r7;
        r1.n = r9;
        r1.o = r10;
        r1.s = r0.needGenerateMeaningfulPaintingArea();
        tryAddInfoForSubDraw(r1, r0);
        r12.a(this.mCurrentDrawIndex, r1);
    L9:
        r0 = r0.mNextDrawUI;
        this.mCurrentDrawIndex++;
        goto L3
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void beforeDispatchDraw(Canvas r4) {
        this.mCurrentDrawUI = this.mDrawHead;
        boolean r0 = false;
        this.mCurrentDrawIndex = 0;
        this.mActiveFlattenRendererHosts.clear();
        if (getSkewX() == 0.0f) goto L5;
    L6:
        r0 = true;
    L8:
        if (getClipToRadius() == true) goto L16;
        if (this.mContext.getDefaultOverflowVisible() == true) goto L12;
        return;
    L12:
        if (this.mOverflow == 0) goto L14;
        return;
    L14:
        if (enableAutoClipRadius() == true) goto L16;
        return;
    L16:
        if (getLynxBackground() == null) goto L18;
        BackgroundDrawable r1 = (BackgroundDrawable) getLynxBackground().b;
    L19:
        if (r1 == null) goto L29;
        Path r2 = r1.l();
        if (r2 == null) goto L23;
        r4.clipPath(r2);
        return;
    L23:
        if (r0 == false) goto L31;
        r4.clipRect(getClipBounds());
        return;
    L31:
        return;
    L29:
        return;
    L18:
        r1 = null;
        goto L19
    L5:
        if (getSkewY() == 0.0f) goto L8;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public void beforeDispatchProcessViewInfo(m r7) {
        super.beforeDispatchProcessViewInfo(r7);
        this.mCurrentDrawUI = this.mDrawHead;
        boolean r0 = false;
        this.mCurrentDrawIndex = 0;
        r7.p.clear();
        if (getClipToRadius() == false) goto L5;
    L12:
        boolean r1 = true;
    L13:
        r7.k = r1;
        if (r1 == true) goto L16;
    L32:
        r7.n = null;
        return;
    L16:
        if (getLynxBackground() == null) goto L18;
        BackgroundDrawable r2 = (BackgroundDrawable) getLynxBackground().b;
    L19:
        if (r2 == null) goto L21;
        Path r3 = r2.l();
    L23:
        if (getSkewX() == 0.0f) goto L25;
    L26:
        r0 = true;
    L27:
        if (r3 == null) goto L29;
        r7.l = r3;
        r7.m = null;
        goto L32
    L29:
        if (r0 == false) goto L31;
        r7.l = null;
        r7.m = getClipBounds();
        goto L32
    L31:
        r7.l = null;
        r7.m = null;
        goto L32
    L25:
        if (getSkewY() == 0.0f) goto L27;
    L21:
        r3 = null;
        goto L23
    L18:
        r2 = null;
        goto L19
    L5:
        if (this.mContext.getDefaultOverflowVisible() == true) goto L7;
    L11:
        r1 = false;
        goto L13
    L7:
        if (this.mOverflow != 0) goto L11;
        if (enableAutoClipRadius() == false) goto L11;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public void beforeDraw(Canvas r4) {
        if (getSkewX() == 0.0f) goto L5;
    L6:
        r4.skew(getSkewX(), getSkewY());
        r4.translate((-((ViewGroup) this.mView).getPivotY()) * getSkewX(), (-((ViewGroup) this.mView).getPivotX()) * getSkewY());
    L7:
        i7a.a r0 = this.mClipPath;
        if (r0 == null) goto L13;
        Path r1 = r0.c(getWidth(), getHeight());
        if (r1 == null) goto L14;
        r4.clipPath(r1);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (getSkewY() == 0.0f) goto L7;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public void beforeProcessViewInfo(m r2) {
        super.beforeProcessViewInfo(r2);
        l r0 = this.mDrawingOrderHelper;
        if (r0 == null) goto L5;
        r0.a();
        r2.h = this.mDrawingOrderHelper.c;
    L5:
        r2.i = hasOverlappingRendering();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public LynxBaseUI getChildAt(int r2) {
        return (LynxBaseUI) ListProtector.get(this.mChildren, r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public int getIndex(LynxBaseUI r2) {
        return this.mChildren.indexOf(r2);
    }

    public void insertChildWhenRebuildView(LynxBaseUI r4) {
        if ((r4 instanceof LynxUI) == true) goto L5;
        return;
    L5:
        LynxBaseUI r0 = this.mDrawHead;
        int r1 = 0;
    L6:
        if (r0 == null) goto L12;
        if (r4 == r0) goto L12;
        if ((r0 instanceof LynxUI) == false) goto L11;
        r1 = r1 + 1;
    L11:
        r0 = r0.mNextDrawUI;
    L12:
        View r5 = ((LynxUI) r4).getView();
        if (r5.getParent() != null) goto L15;
    L19:
        ((ViewGroup) this.mView).addView(r5, r1);
        return;
    L15:
        if (r5.getParent() != this.mView) goto L18;
        r5.requestLayout();
        return;
    L18:
        ((ViewGroup) r5.getParent()).removeView(r5);
        goto L19
    }

    public void insertView(LynxUI r4) {
        LynxContext r0 = this.mContext;
        if (r0 != null) goto L5;
    L10:
        LynxBaseUI r1 = this.mDrawHead;
        int r2 = -1;
    L11:
        if (r1 == null) goto L19;
        if ((r1 instanceof LynxUI) == false) goto L15;
        r2 = r2 + 1;
    L15:
        if (r1 == r4) goto L19;
        r1 = r1.mNextDrawUI;
    L19:
        if (r4.mView.getParent() != null) goto L21;
    L23:
        ((ViewGroup) this.mView).addView(r4.mView, r2);
        onAddChildUI(r4, r2);
        return;
    L21:
        if ((r4.mView.getParent() instanceof ViewGroup) == false) goto L23;
        ((ViewGroup) r4.mView.getParent()).removeView(r4.mView);
        onRemoveChildUI(r4);
        goto L23
    L5:
        if (r0.isFallbackProcess() == false) goto L10;
        if (r4.getView().getParent() != getView()) goto L10;
        r4.getView().requestLayout();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void markDetachWithViewRecursively(boolean r3) {
        if (r3 == false) goto L6;
        m r0 = new m(this, this.mView);
        this.mViewInfo = r0;
        r0.j = needGenerateMeaningfulPaintingArea();
        T r1 = this.mView;
        if ((r1 instanceof IDrawChildHook.IDrawChildHookBinding) == false) goto L6;
        ((IDrawChildHook.IDrawChildHookBinding) r1).bindDrawChildHook(this.mViewInfo);
    L6:
        super.markDetachWithViewRecursively(r3);
    }

    public boolean onRemoveChild(LynxBaseUI r2) {
        if (this.mChildren.remove(r2) == true) goto L6;
        return false;
    L6:
        r2.setParent(null);
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void removeChild(LynxBaseUI r2) {
        if (onRemoveChild(r2) == false) goto L6;
        removeView(r2);
        return;
    }

    public void removeView(LynxBaseUI r4) {
        if ((r4 instanceof LynxUI) == false) goto L8;
        LynxUI r1 = (LynxUI) r4;
        ((ViewGroup) this.mView).removeView(r1.mView);
        if ((r4 instanceof UIList) == false) goto L7;
        ((ViewGroup) this.mView).removeView(((UIList) r4).q);
    L7:
        onRemoveChildUI(r1);
        return;
    L8:
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setTranslationZ(float r1) {
        super.setTranslationZ(r1);
    }

    public UIGroup(LynxContext r1, Object r2) {
        super(r1, r2);
        this.mCurrentDrawIndex = 0;
        this.mCurrentDrawUI = this.mDrawHead;
        this.mOverflowClipRect = new Rect();
        this.mIsInsertViewCalled = false;
        this.mActiveFlattenRendererHosts = new ArrayList();
    }

    private void drawFlattenRendererContentBeforeUI(LynxBaseUI r3, Canvas r4) {
        finishInactiveFlattenRendererHosts(r3, r4);
        if (this.mActiveFlattenRendererHosts.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayList<LynxFlattenUI> r0 = this.mActiveFlattenRendererHosts;
        LynxFlattenUI r1 = (LynxFlattenUI) ListProtector.get(r0, r0.size() - 1);
        if (r3 != r1) goto L8;
        return;
    L8:
        if (isDescendantOf(r3, r1) == false) goto L12;
        r1.drawRendererContentUntilNextView(r4);
        return;
    }

    private void finishInactiveFlattenRendererHosts(LynxBaseUI r4, Canvas r5) {
        int r0 = this.mActiveFlattenRendererHosts.size() - 1;
    L3:
        if (r0 < 0) goto L10;
        LynxFlattenUI r1 = (LynxFlattenUI) ListProtector.get(this.mActiveFlattenRendererHosts, r0);
        if (r4 == null) goto L9;
        if (isDescendantOf(r4, r1) == false) goto L9;
        return;
    L9:
        r1.drawRendererHostEnd(r5);
        ListProtector.remove(this.mActiveFlattenRendererHosts, r0);
        r0 = r0 - 1;
        goto L3
    }

    private boolean isDescendantOf(LynxBaseUI r1, LynxBaseUI r2) {
    L2:
        if (r1 == null) goto L7;
        if (r1 == r2) goto L4;
        r1 = r1.getParentBaseUI();
        goto L2
    L4:
        return true;
    L7:
        return false;
    }

    private void onAddChildUI(LynxUI r2, int r3) {
        if (LynxUI.ENABLE_ZINDEX == true) goto L5;
        return;
    L5:
        l r4 = this.mDrawingOrderHelper;
        View r5 = r2.getView();
        r4.getClass();
        boolean r0 = true;
        if (getViewZIndex(r5) == null) goto L8;
        r4.b++;
    L8:
        r4.c = null;
        if (this.mDrawingOrderHelper.b > 0) goto L12;
        r0 = false;
    L12:
        setChildrenDrawingOrderEnabledHelper(r0);
    }

    public static void setViewZIndex(View r1, int r2) {
        mZIndexHash.put(r1, Integer.valueOf(r2));
    }

    private void tryAddInfoForSubDraw(m.a r2, LynxBaseUI r3) {
        if ((r3 instanceof FlattenUIImage) == false) goto L10;
        FlattenUIImage r0 = (FlattenUIImage) r3;
        r0.M();
        d7a.f r1 = r0.a;
        if (r1 != null) goto L8;
        r1 = null;
    L8:
        r2.e = r1;
    L10:
        if ((r3 instanceof FlattenUIText) == false) goto L13;
        FlattenUIText r4 = (FlattenUIText) r3;
        r2.f = r4.getTextLayout();
        int r5 = r4.getDrawOffsetLeft();
        int r6 = r4.getDrawOffsetTop();
        r2.p = r5;
        r2.q = r6;
        return;
    }

    public void drawChild(LynxFlattenUI r2, Canvas r3) {
        drawFlattenRendererContentBeforeUI(r2, r3);
        if (r2.isRendererHost() == false) goto L6;
        r2.innerDraw(r3);
        this.mActiveFlattenRendererHosts.add(r2);
        return;
    L6:
        Rect r0 = r2.getBound();
        r3.save();
        if (r0 == null) goto L9;
        r3.clipRect(r0);
    L9:
        r2.innerDraw(r3);
        r3.restore();
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public int getChildDrawingOrder(int r1, int r2) {
        l r3 = this.mDrawingOrderHelper;
        if (r3 == null) goto L6;
        r3.a();
        return r3.c[r2];
    L6:
        return r2;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void insertChild(LynxBaseUI r1, int r2) {
        onInsertChild(r1, r2);
        this.mIsInsertViewCalled = true;
    }

    public void onInsertChild(LynxBaseUI r2, int r3) {
        r2.setOffsetDescendantRectToLynxView(getOffsetDescendantRectToLynxView());
        ListProtector.add(this.mChildren, r3, r2);
        r2.setParent(this);
    }

    private Rect drawFlattenUIBefore(Canvas r1, View r2, long r3) {
        LynxBaseUI r4 = this.mCurrentDrawUI;
    L3:
        if (r4 == null) goto L13;
        if (r4.isFlatten() == true) goto L10;
        if (((LynxUI) r4).getView() != r2) goto L12;
        drawFlattenRendererContentBeforeUI(r4, r1);
        Rect r5 = r4.getBound();
        this.mCurrentDrawUI = r4.mNextDrawUI;
        return r5;
    L12:
        r4 = r4.mNextDrawUI;
        goto L3
    L10:
        if (r4.isFlatten() == false) goto L12;
        drawChild((LynxFlattenUI) r4, r1);
        goto L12
    L13:
        return null;
    }

    private LynxUI findTouchTargetOnViewChian(float[] r13, ViewGroup r14, Map<View, LynxUI> r15) {
        int r0 = r14.getChildCount() - 1;
        LynxUI r2 = null;
    L3:
        if (r0 < 0) goto L31;
        View r9 = r14.getChildAt(r0);
        if (this.mContext.getEnableEventRefactor() == false) goto L19;
        float[] r11 = new float[2];
        if (isTransformedTouchPointInView(r13, r14, r9, r11, r15) == false) goto L30;
        if (r15.containsKey(r9) == false) goto L12;
        r2 = r15.get(r9);
        r13[0] = r11[0];
        r13[1] = r11[1];
    L16:
        if (r2 == null) goto L30;
        return r2;
    L12:
        if ((r9 instanceof ViewGroup) == false) goto L16;
        r2 = findTouchTargetOnViewChian(r11, (ViewGroup) r9, r15);
        if (r2 == null) goto L16;
        r13[0] = r11[0];
        r13[1] = r11[1];
    L30:
        r0 = r0 - 1;
        goto L3
    L19:
        PointF r12 = mTempPoint;
        if (isTransformedTouchPointInView(r13[0], r13[1], r14, r9, r12) == false) goto L30;
        float r3 = r13[0];
        float r4 = r13[1];
        r13[0] = r12.x;
        r13[1] = r12.y;
        if (r15.containsKey(r9) == false) goto L25;
        r2 = r15.get(r9);
    L27:
        if (r2 != null) goto L29;
        r13[0] = r3;
        r13[1] = r4;
        goto L30
    L29:
        return r2;
    L25:
        if ((r9 instanceof ViewGroup) == false) goto L27;
        r2 = findTouchTargetOnViewChian(r13, (ViewGroup) r9, r15);
        goto L27
    L31:
        return r2;
    }

    @Override // com.lynx.tasm.behavior.ui.IDrawChildHook
    public Rect beforeDrawChild(Canvas r1, View r2, long r3) {
        return drawFlattenUIBefore(r1, r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.a
    public void beforeProcessChildViewInfo(m r10, View r11, long r12) {
        super.beforeProcessChildViewInfo(r10, r11, r12);
        LynxBaseUI r13 = this.mCurrentDrawUI;
    L3:
        if (r13 == null) goto L23;
        if (r13.isFlatten() == true) goto L14;
        LynxUI r14 = (LynxUI) r13;
        if (r14.getView() != r11) goto L16;
        this.mCurrentDrawUI = r13.mNextDrawUI;
        m.a r0 = new m.a(r13.getBound(), r14.mViewInfo, r14.getView());
        r0.s = r13.needGenerateMeaningfulPaintingArea();
        r10.a(this.mCurrentDrawIndex, r0);
        if ((r13 instanceof LynxUI) == false) goto L12;
        r0.b = r11;
        r0.g = r14.getLeft();
        r0.h = r14.getTop();
        r0.i = r14.getWidth();
        r0.j = r14.getHeight();
        r14.getSkewX();
        r14.getSkewY();
        r14.getOverflow();
    L12:
        this.mCurrentDrawIndex++;
        return;
    L16:
        r13 = r13.mNextDrawUI;
        this.mCurrentDrawIndex++;
        goto L3
    L14:
        if (r13.isFlatten() == false) goto L16;
        m.a r15 = new m.a(false, r13.getBound(), r13.getLynxBackground());
        int r1 = r13.getLeft();
        int r2 = r13.getTop();
        int r3 = r13.getWidth();
        int r4 = r13.getHeight();
        int r5 = r13.getPaddingLeft();
        int r6 = r13.getPaddingTop();
        int r7 = r13.getPaddingRight();
        int r8 = r13.getPaddingBottom();
        float r9 = ((LynxFlattenUI) r13).getAlpha();
        r15.g = r1;
        r15.h = r2;
        r15.i = r3;
        r15.j = r4;
        r15.k = r5;
        r15.l = r7;
        r15.m = r6;
        r15.n = r8;
        r15.o = r9;
        r15.s = r13.needGenerateMeaningfulPaintingArea();
        tryAddInfoForSubDraw(r15, r13);
        r10.a(this.mCurrentDrawIndex, r15);
        goto L16
    }

    public EventTarget findUIWithCustomLayout(float r5, float r6, UIGroup r7) {
        HashMap r0 = new HashMap();
        int r1 = r7.getChildCount() - 1;
    L3:
        if (r1 < 0) goto L13;
        LynxBaseUI r2 = r7.getChildAt(r1);
        if ((r2 instanceof UIShadowProxy) == false) goto L8;
        r2 = ((UIShadowProxy) r2).a;
    L8:
        if ((r2 instanceof LynxUI) == false) goto L10;
        LynxUI r3 = (LynxUI) r2;
        r0.put(r3.getView(), r3);
    L11:
        r1 = r1 - 1;
        goto L3
    L10:
        LLog.DTHROW(new RuntimeException("ui that need custom layout should not have flatten child!"));
        goto L11
    L13:
        return findUIWithCustomLayoutByChildren(r5, r6, r7, r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventTarget findUIWithCustomLayoutByChildren(float r3, float r4, UIGroup r5, Map<View, LynxUI> r6) {
        float[] r0 = {r3, r4};
        LynxUI r7 = findTouchTargetOnViewChian(r0, (ViewGroup) r5.getView(), r6);
        if (r7 != null) goto L6;
        return r5;
    L6:
        if (r7.needCustomLayout() == false) goto L12;
        if ((r7 instanceof UIGroup) == false) goto L12;
        UIGroup r8 = (UIGroup) r7;
        return r8.findUIWithCustomLayout(r0[0], r0[1], r8);
    L12:
        if (this.mContext.getEnableEventRefactor() == false) goto L16;
        return r7.hitTest(r0[0], r0[1]);
    L16:
        return r7.hitTest(r0[0] + r7.getScrollX(), r0[1] + r7.getScrollY());
    }

    private boolean isTransformedTouchPointInView(float r5, float r6, ViewGroup r7, View r8, PointF r9) {
        float r10 = (r5 + r7.getScrollX()) - r8.getLeft();
        float r11 = (r6 + r7.getScrollY()) - r8.getTop();
        Matrix r12 = r8.getMatrix();
        if (r12.isIdentity() == true) goto L6;
        float[] r0 = mMatrixTransformCoords;
        r0[0] = r10;
        r0[1] = r11;
        Matrix r13 = mInverseMatrix;
        r12.invert(r13);
        r13.mapPoints(r0);
        r10 = r0[0];
        r11 = r0[1];
    L6:
        if (r10 >= 0.0f) goto L8;
    L15:
        return false;
    L8:
        if (r10 >= (r8.getRight() - r8.getLeft())) goto L15;
        if (r11 < 0.0f) goto L15;
        if (r11 >= (r8.getBottom() - r8.getTop())) goto L15;
        r9.set(r10, r11);
        return true;
    }

    public boolean isTransformedTouchPointInView(float[] r9, View r10, View r11, float[] r12, Map<View, LynxUI> r13) {
        float[] r14 = getTargetPoint(r9[0], r9[1], r10.getScrollX(), r10.getScrollY(), r11, r11.getMatrix());
        float r15 = r14[0];
        r12[0] = r15;
        r12[1] = r14[1];
        if (r15 >= 0.0f) goto L5;
    L11:
        return false;
    L5:
        if (r15 >= (r11.getRight() - r11.getLeft())) goto L11;
        float r16 = r12[1];
        if (r16 < 0.0f) goto L11;
        if (r16 >= (r11.getBottom() - r11.getTop())) goto L11;
        return true;
    }
}
