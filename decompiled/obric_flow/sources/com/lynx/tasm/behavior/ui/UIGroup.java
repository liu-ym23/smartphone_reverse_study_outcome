package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.image.FlattenUIImage;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.text.FlattenUIText;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public abstract class UIGroup<T extends ViewGroup> extends LynxUI<T> implements b {
    private static final String TAG = "UIGroup";
    private static final float[] mEventCoords = null;
    private static final Matrix mInverseMatrix = null;
    private static final float[] mMatrixTransformCoords = null;
    private static final PointF mTempPoint = null;
    private static WeakHashMap<View, Integer> mZIndexHash;
    private int mCurrentDrawIndex;
    private LynxBaseUI mCurrentDrawUI;
    private e0 mDrawingOrderHelper;
    private boolean mIsInsertViewCalled;
    private Rect mOverflowClipRect;

    static {
        mZIndexHash = new WeakHashMap();
        mEventCoords = new float[2];
        mTempPoint = new PointF();
        mMatrixTransformCoords = new float[2];
        mInverseMatrix = new Matrix();
    }

    public UIGroup(LynxContext r5, Object r10) {
        super(r5, r10);
        this.mCurrentDrawIndex = 0;
        this.mCurrentDrawUI = this.mDrawHead;
        this.mOverflowClipRect = new Rect();
        this.mIsInsertViewCalled = false;
    }

    public static void a(f0 r5, LynxBaseUI r10) {
        if ((r10 instanceof FlattenUIImage) == false) goto L10;
        FlattenUIImage r11 = (FlattenUIImage) r10;
        r11.i();
        dn.f r12 = r11.f10488a;
        if (r12 != null) goto L8;
        r12 = null;
    L8:
        r5.e = r12;
    L10:
        if ((r10 instanceof FlattenUIText) == false) goto L13;
        FlattenUIText r13 = (FlattenUIText) r10;
        r5.f = r13.f10691a;
        int r14 = r13.i();
        int r15 = r13.j();
        r5.f10471p = r14;
        r5.f10472q = r15;
        return;
    }

    @Nullable
    public static Integer getViewZIndex(View r5) {
        return mZIndexHash.get(r5);
    }

    public static void setViewZIndex(View r5, int r10) {
        mZIndexHash.put(r5, Integer.valueOf(r10));
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public void afterDispatchDraw(Canvas r5) {
        LynxBaseUI r10 = this.mCurrentDrawUI;
    L3:
        if (r10 == null) goto L10;
        if (r10.isFlatten() == false) goto L9;
        if ((r10 instanceof UIShadowProxy) == true) goto L9;
        drawChild((LynxFlattenUI) r10, r5);
    L9:
        r10 = r10.mNextDrawUI;
        goto L3
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.c
    public void afterDispatchProcessViewInfo(g0 r12) {
        super.afterDispatchProcessViewInfo(r12);
        LynxBaseUI r5 = this.mCurrentDrawUI;
    L3:
        if (r5 == null) goto L10;
        if (r5.isFlatten() == false) goto L9;
        if ((r5 instanceof UIShadowProxy) == true) goto L9;
        f0 r10 = new f0(false, r5.getBound(), r5.getLynxBackground());
        int r11 = r5.getLeft();
        int r13 = r5.getTop();
        int r14 = r5.getWidth();
        int r15 = r5.getHeight();
        int r16 = r5.getPaddingLeft();
        int r17 = r5.getPaddingTop();
        int r18 = r5.getPaddingRight();
        int r19 = r5.getPaddingBottom();
        float r110 = ((LynxFlattenUI) r5).getAlpha();
        r10.g = r11;
        r10.f10463h = r13;
        r10.f10464i = r14;
        r10.f10465j = r15;
        r10.f10466k = r16;
        r10.f10467l = r18;
        r10.f10468m = r17;
        r10.f10469n = r19;
        r10.f10470o = r110;
        r10.s = r5.needGenerateMeaningfulPaintingArea();
        a(r10, r5);
        r12.c(this.mCurrentDrawIndex, r10);
    L9:
        r5 = r5.mNextDrawUI;
        this.mCurrentDrawIndex++;
        goto L3
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public void afterDraw(Canvas r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public void afterDrawChild(Canvas r5, View r10, long r11) {
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public void beforeDispatchDraw(Canvas r5) {
        this.mCurrentDrawUI = this.mDrawHead;
        boolean r10 = false;
        this.mCurrentDrawIndex = 0;
        if (getSkewX() == 0.0f) goto L5;
    L6:
        r10 = true;
    L8:
        if (getClipToRadius() == true) goto L16;
        if (this.mContext.g() == true) goto L12;
        return;
    L12:
        if (this.mOverflow == 0) goto L14;
        return;
    L14:
        if (enableAutoClipRadius() == true) goto L16;
        return;
    L16:
        if (getLynxBackground() == null) goto L18;
        BackgroundDrawable r11 = (BackgroundDrawable) getLynxBackground().f10750b;
    L19:
        if (r11 == null) goto L29;
        Path r12 = r11.p();
        if (r12 == null) goto L23;
        r5.clipPath(r12);
        return;
    L23:
        if (r10 == false) goto L31;
        r5.clipRect(getClipBounds());
        return;
    L31:
        return;
    L29:
        return;
    L18:
        r11 = null;
        goto L19
    L5:
        if (getSkewY() == 0.0f) goto L8;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.c
    public void beforeDispatchProcessViewInfo(g0 r10) {
        super.beforeDispatchProcessViewInfo(r10);
        this.mCurrentDrawUI = this.mDrawHead;
        boolean r5 = false;
        this.mCurrentDrawIndex = 0;
        r10.f10485o.clear();
        if (getClipToRadius() == false) goto L5;
    L12:
        boolean r11 = true;
    L13:
        r10.f10481k = r11;
        if (r11 == true) goto L16;
        return;
    L16:
        if (getLynxBackground() == null) goto L18;
        BackgroundDrawable r12 = (BackgroundDrawable) getLynxBackground().f10750b;
    L19:
        if (r12 == null) goto L21;
        Path r13 = r12.p();
    L23:
        if (getSkewX() == 0.0f) goto L25;
    L26:
        r5 = true;
    L27:
        if (r13 == null) goto L29;
        r10.f10482l = r13;
        r10.f10483m = null;
        return;
    L29:
        if (r5 == false) goto L31;
        r10.f10482l = null;
        r10.f10483m = getClipBounds();
        return;
    L31:
        r10.f10482l = null;
        r10.f10483m = null;
        return;
    L25:
        if (getSkewY() == 0.0f) goto L27;
    L21:
        r13 = null;
        goto L23
    L18:
        r12 = null;
        goto L19
    L5:
        if (this.mContext.g() == true) goto L7;
    L11:
        r11 = false;
        goto L13
    L7:
        if (this.mOverflow != 0) goto L11;
        if (enableAutoClipRadius() == false) goto L11;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public void beforeDraw(Canvas r5) {
        if (getSkewX() == 0.0f) goto L5;
    L6:
        r5.skew(getSkewX(), getSkewY());
        float r10 = -((ViewGroup) this.mView).getPivotY();
        float r11 = getSkewX() * r10;
        float r12 = -((ViewGroup) this.mView).getPivotX();
        r5.translate(r11, getSkewY() * r12);
    L7:
        in.b r13 = this.mClipPath;
        if (r13 == null) goto L13;
        Path r14 = r13.b(getWidth(), getHeight());
        if (r14 == null) goto L14;
        r5.clipPath(r14);
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (getSkewY() == 0.0f) goto L7;
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public Rect beforeDrawChild(Canvas r5, View r10, long r11) {
        LynxBaseUI r12 = this.mCurrentDrawUI;
    L3:
        if (r12 == null) goto L14;
        if (r12.isFlatten() == true) goto L11;
        if (((LynxUI) r12).getView() != r10) goto L13;
        Rect r13 = r12.getBound();
        this.mCurrentDrawUI = r12.mNextDrawUI;
        return r13;
    L13:
        r12 = r12.mNextDrawUI;
        goto L3
    L11:
        if (r12.isFlatten() == false) goto L13;
        drawChild((LynxFlattenUI) r12, r5);
        goto L13
    L14:
        return null;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.c
    public void beforeProcessChildViewInfo(g0 r11, View r12, long r13) {
        super.beforeProcessChildViewInfo(r11, r12, r13);
        LynxBaseUI r14 = this.mCurrentDrawUI;
    L3:
        if (r14 == null) goto L18;
        if (r14.isFlatten() == true) goto L15;
        LynxUI r15 = (LynxUI) r14;
        if (r15.getView() != r12) goto L17;
        this.mCurrentDrawUI = r14.mNextDrawUI;
        Rect r5 = r14.getBound();
        g0 r10 = r15.mViewInfo;
        View r16 = r15.getView();
        f0 r17 = new f0(true, r5, null);
        r17.f10460a = r10;
        r17.f10461b = r16;
        r17.s = r14.needGenerateMeaningfulPaintingArea();
        r11.c(this.mCurrentDrawIndex, r17);
        if ((r14 instanceof LynxUI) == false) goto L12;
        r17.f10461b = r12;
        r17.g = r15.getLeft();
        r17.f10463h = r15.getTop();
        r17.f10464i = r15.getWidth();
        r17.f10465j = r15.getHeight();
        r15.getSkewX();
        r15.getSkewY();
        r15.getOverflow();
    L12:
        this.mCurrentDrawIndex++;
        return;
    L17:
        r14 = r14.mNextDrawUI;
        this.mCurrentDrawIndex++;
        goto L3
    L15:
        if (r14.isFlatten() == false) goto L17;
        f0 r18 = new f0(false, r14.getBound(), r14.getLynxBackground());
        int r19 = r14.getLeft();
        int r20 = r14.getTop();
        int r21 = r14.getWidth();
        int r22 = r14.getHeight();
        int r23 = r14.getPaddingLeft();
        int r24 = r14.getPaddingTop();
        int r25 = r14.getPaddingRight();
        int r26 = r14.getPaddingBottom();
        float r27 = ((LynxFlattenUI) r14).getAlpha();
        r18.g = r19;
        r18.f10463h = r20;
        r18.f10464i = r21;
        r18.f10465j = r22;
        r18.f10466k = r23;
        r18.f10467l = r25;
        r18.f10468m = r24;
        r18.f10469n = r26;
        r18.f10470o = r27;
        r18.s = r14.needGenerateMeaningfulPaintingArea();
        a(r18, r14);
        r11.c(this.mCurrentDrawIndex, r18);
        goto L17
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.c
    public void beforeProcessViewInfo(g0 r5) {
        super.beforeProcessViewInfo(r5);
        e0 r10 = this.mDrawingOrderHelper;
        if (r10 == null) goto L5;
        r10.a();
        r5.f10478h = this.mDrawingOrderHelper.f10454c;
    L5:
        r5.f10479i = hasOverlappingRendering();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        Iterator<LynxBaseUI> r5 = this.mChildren.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().destroy();
        goto L4
    }

    public void dispatchOnAttach() {
        Iterator<LynxBaseUI> r5 = this.mChildren.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().onAttach();
        goto L4
    }

    public void dispatchOnDetach() {
        Iterator<LynxBaseUI> r5 = this.mChildren.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().onDetach();
        goto L4
    }

    public void drawChild(LynxFlattenUI r5, Canvas r10) {
        Rect r11 = r5.getBound();
        r10.save();
        if (r11 == null) goto L5;
        r10.clipRect(r11);
    L5:
        r5.innerDraw(r10);
        r10.restore();
    }

    public boolean enableAutoClipRadius() {
        return false;
    }

    public wm.a findUIWithCustomLayout(float r5, float r10, UIGroup r11) {
        HashMap r12 = new HashMap();
        int r13 = r11.getChildCount() - 1;
    L3:
        if (r13 < 0) goto L13;
        LynxBaseUI r14 = r11.getChildAt(r13);
        if ((r14 instanceof UIShadowProxy) == false) goto L8;
        r14 = ((UIShadowProxy) r14).f10388a;
    L8:
        if ((r14 instanceof LynxUI) == false) goto L10;
        LynxUI r15 = (LynxUI) r14;
        r12.put(r15.getView(), r15);
    L11:
        r13 = r13 - 1;
        goto L3
    L10:
        new RuntimeException("ui that need custom layout should not have flatten child!");
        goto L11
    L13:
        return findUIWithCustomLayoutByChildren(r5, r10, r11, r12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public wm.a findUIWithCustomLayoutByChildren(float r5, float r10, UIGroup r11, Map<View, LynxUI> r12) {
        float[] r13 = {r5, r10};
        LynxUI r14 = a(r13, (ViewGroup) r11.getView(), r12);
        if (r14 != null) goto L6;
        return r11;
    L6:
        if (r14.needCustomLayout() == false) goto L12;
        if ((r14 instanceof UIGroup) == false) goto L12;
        UIGroup r15 = (UIGroup) r14;
        return r15.findUIWithCustomLayout(r13[0], r13[1], r15);
    L12:
        if (this.mContext.h() == false) goto L16;
        return r14.hitTest(r13[0], r13[1]);
    L16:
        return r14.hitTest(r13[0] + r14.getScrollX(), r13[1] + r14.getScrollY());
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r5) {
        return null;
    }

    public View getAccessibilityHostView() {
        return this.mView;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public LynxBaseUI getChildAt(int r5) {
        return this.mChildren.get(r5);
    }

    public int getChildCount() {
        return this.mChildren.size();
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public int getChildDrawingOrder(int r5, int r10) {
        e0 r11 = this.mDrawingOrderHelper;
        if (r11 == null) goto L6;
        r11.a();
        return r11.f10454c[r10];
    L6:
        return r10;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public int getIndex(LynxBaseUI r5) {
        return this.mChildren.indexOf(r5);
    }

    public View getRealParentView() {
        return this.mView;
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public boolean hasOverlappingRendering() {
        return hasOverlappingRenderingEnabled();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void initialize() {
        super.initialize();
        this.mDrawingOrderHelper = new e0(getView());
        T r5 = this.mView;
        if ((r5 instanceof a) == false) goto L6;
        ((a) r5).bindDrawChildHook(this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void insertChild(LynxBaseUI r5, int r10) {
        onInsertChild(r5, r10);
        this.mIsInsertViewCalled = true;
    }

    public void insertChildWhenRebuildView(LynxBaseUI r5) {
        if ((r5 instanceof LynxUI) == true) goto L5;
        return;
    L5:
        LynxBaseUI r10 = this.mDrawHead;
        int r11 = 0;
    L6:
        if (r10 == null) goto L12;
        if (r5 == r10) goto L12;
        if ((r10 instanceof LynxUI) == false) goto L11;
        r11 = r11 + 1;
    L11:
        r10 = r10.mNextDrawUI;
    L12:
        View r12 = ((LynxUI) r5).getView();
        if (r12.getParent() != null) goto L15;
    L19:
        ((ViewGroup) this.mView).addView(r12, r11);
        return;
    L15:
        if (r12.getParent() != this.mView) goto L18;
        r12.requestLayout();
        return;
    L18:
        ((ViewGroup) r12.getParent()).removeView(r12);
        goto L19
    }

    public void insertView(LynxUI r10) {
        LynxContext r5 = this.mContext;
        if (r5 != null) goto L5;
    L10:
        LynxBaseUI r11 = this.mDrawHead;
        int r12 = -1;
    L11:
        if (r11 == null) goto L18;
        if ((r11 instanceof LynxUI) == false) goto L15;
        r12 = r12 + 1;
    L15:
        if (r11 == r10) goto L18;
        r11 = r11.mNextDrawUI;
    L18:
        boolean r13 = false;
        if (r10.mView.getParent() != null) goto L21;
    L38:
        ((ViewGroup) this.mView).addView(r10.mView, r12);
        if (LynxUI.ENABLE_ZINDEX == false) goto L58;
        e0 r14 = this.mDrawingOrderHelper;
        View r15 = r10.getView();
        r14.getClass();
        if (getViewZIndex(r15) == null) goto L44;
        r14.f10453b++;
    L44:
        r14.f10454c = null;
        if (this.mDrawingOrderHelper.f10453b <= 0) goto L47;
        r13 = true;
    L47:
        T r16 = this.mView;
        if ((r16 instanceof com.lynx.tasm.behavior.ui.view.b) == false) goto L52;
        ((com.lynx.tasm.behavior.ui.view.b) r16).setChildrenDrawingOrderEnabled(r13);
        return;
    L52:
        if ((r16 instanceof UIBody.UIBodyView) == false) goto L57;
        ((UIBody.UIBodyView) r16).setChildrenDrawingOrderEnabled(r13);
        return;
    L57:
        return;
    L58:
        return;
    L21:
        if ((r10.mView.getParent() instanceof ViewGroup) == false) goto L38;
        ((ViewGroup) r10.mView.getParent()).removeView(r10.mView);
        if (LynxUI.ENABLE_ZINDEX == false) goto L38;
        e0 r17 = this.mDrawingOrderHelper;
        View r18 = r10.getView();
        r17.getClass();
        if (getViewZIndex(r18) == null) goto L28;
        r17.f10453b--;
    L28:
        r17.f10454c = null;
        if (this.mDrawingOrderHelper.f10453b <= 0) goto L31;
        boolean r19 = true;
    L32:
        T r20 = this.mView;
        if ((r20 instanceof com.lynx.tasm.behavior.ui.view.b) == false) goto L36;
        ((com.lynx.tasm.behavior.ui.view.b) r20).setChildrenDrawingOrderEnabled(r19);
        goto L38
    L36:
        if ((r20 instanceof UIBody.UIBodyView) == false) goto L38;
        ((UIBody.UIBodyView) r20).setChildrenDrawingOrderEnabled(r19);
        goto L38
    L31:
        r19 = false;
        goto L32
    L5:
        if (r5.L == false) goto L10;
        if (r10.getView().getParent() != getView()) goto L10;
        r10.getView().requestLayout();
    }

    public boolean isInsertViewCalled() {
        return this.mIsInsertViewCalled;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void layout() {
        if (((ViewGroup) this.mView).isLayoutRequested() == true) goto L5;
        return;
    L5:
        super.layout();
        layoutChildren();
    }

    public void layoutChildren() {
        int r5 = 0;
    L4:
        if (r5 >= this.mChildren.size()) goto L15;
        LynxBaseUI r10 = this.mChildren.get(r5);
        if (needCustomLayout() == true) goto L12;
        if (r10.isFlatten() == true) goto L10;
        ((LynxUI) r10).layout();
    L14:
        r5 = r5 + 1;
        goto L4
    L10:
        ((LynxFlattenUI) r10).layout(r10.getOriginLeft(), r10.getOriginTop(), null);
        goto L14
    L12:
        if ((r10 instanceof UIGroup) == false) goto L14;
        ((UIGroup) r10).layoutChildren();
        goto L14
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void markDetachWithViewRecursively(boolean r5) {
        if (r5 == false) goto L6;
        g0 r10 = new g0(this, this.mView);
        this.mViewInfo = r10;
        r10.f10480j = needGenerateMeaningfulPaintingArea();
        T r11 = this.mView;
        if ((r11 instanceof a) == false) goto L6;
        ((a) r11).bindDrawChildHook(this.mViewInfo);
    L6:
        super.markDetachWithViewRecursively(r5);
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
        Iterator<LynxBaseUI> r5 = this.mChildren.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().measure();
        goto L4
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean needCustomLayout() {
        return false;
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

    public void onInsertChild(LynxBaseUI r5, int r10) {
        r5.setOffsetDescendantRectToLynxView(getOffsetDescendantRectToLynxView());
        this.mChildren.add(r10, r5);
        r5.setParent(this);
    }

    public boolean onRemoveChild(LynxBaseUI r5) {
        if (this.mChildren.remove(r5) == true) goto L6;
        return false;
    L6:
        r5.setParent(null);
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public void performLayoutChildrenUI() {
        layoutChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.b
    public void performMeasureChildrenUI() {
        measureChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.c
    public void processLayoutChildren() {
        performLayoutChildrenUI();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.c
    public void processMeasureChildren() {
        performMeasureChildrenUI();
    }

    public void removeAll() {
        LynxBaseUI r5 = this.mDrawHead;
    L4:
        if (r5 == null) goto L6;
        r5.setDrawParent(null);
        r5 = r5.mNextDrawUI;
        goto L4
    L6:
        this.mDrawHead = null;
        Iterator<LynxBaseUI> r10 = this.mChildren.iterator();
    L8:
        if (r10.hasNext() == false) goto L10;
        r10.next().setParent(null);
        goto L8
    L10:
        this.mChildren.clear();
        T r11 = this.mView;
        if (r11 == 0) goto L16;
        ((ViewGroup) r11).removeAllViews();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void removeChild(LynxBaseUI r5) {
        if (onRemoveChild(r5) == false) goto L6;
        removeView(r5);
        return;
    }

    public void removeView(LynxBaseUI r5) {
        if ((r5 instanceof LynxUI) == false) goto L25;
        LynxUI r10 = (LynxUI) r5;
        ((ViewGroup) this.mView).removeView(r10.mView);
        if ((r5 instanceof UIList) == false) goto L8;
        ((ViewGroup) this.mView).removeView(((UIList) r5).f10516m);
    L8:
        if (LynxUI.ENABLE_ZINDEX == false) goto L28;
        e0 r11 = this.mDrawingOrderHelper;
        View r12 = r10.getView();
        r11.getClass();
        boolean r13 = true;
        if (getViewZIndex(r12) == null) goto L13;
        r11.f10453b--;
    L13:
        r11.f10454c = null;
        if (this.mDrawingOrderHelper.f10453b > 0) goto L17;
        r13 = false;
    L17:
        T r14 = this.mView;
        if ((r14 instanceof com.lynx.tasm.behavior.ui.view.b) == false) goto L22;
        ((com.lynx.tasm.behavior.ui.view.b) r14).setChildrenDrawingOrderEnabled(r13);
        return;
    L22:
        if ((r14 instanceof UIBody.UIBodyView) == false) goto L27;
        ((UIBody.UIBodyView) r14).setChildrenDrawingOrderEnabled(r13);
        return;
    L27:
        return;
    L28:
        return;
    L25:
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setTranslationZ(float r5) {
        super.setTranslationZ(r5);
    }

    public void updateDrawingOrder() {
        e0 r5 = this.mDrawingOrderHelper;
        boolean r10 = false;
        r5.f10453b = 0;
        int r11 = 0;
    L3:
        ViewGroup r12 = r5.f10452a;
        if (r11 >= r12.getChildCount()) goto L9;
        if (getViewZIndex(r12.getChildAt(r11)) == null) goto L8;
        r5.f10453b++;
    L8:
        r11 = r11 + 1;
        goto L3
    L9:
        r5.f10454c = null;
        if (this.mDrawingOrderHelper.f10453b <= 0) goto L12;
        r10 = true;
    L12:
        T r13 = this.mView;
        if ((r13 instanceof com.lynx.tasm.behavior.ui.view.b) == false) goto L16;
        ((com.lynx.tasm.behavior.ui.view.b) r13).setChildrenDrawingOrderEnabled(r10);
    L18:
        invalidate();
        return;
    L16:
        if ((r13 instanceof UIBody.UIBodyView) == false) goto L18;
        ((UIBody.UIBodyView) r13).setChildrenDrawingOrderEnabled(r10);
        goto L18
    }

    public final LynxUI a(float[] r18, ViewGroup r19, Map r20) {
        int r12 = r19.getChildCount() - 1;
        LynxUI r13 = null;
    L3:
        if (r12 < 0) goto L46;
        View r15 = r19.getChildAt(r12);
        if (this.mContext.h() == false) goto L25;
        float[] r5 = getTargetPoint(r18[0], r18[1], r19.getScrollX(), r19.getScrollY(), r15, r15.getMatrix());
        float r10 = r5[0];
        float[] r11 = {r10, r5[1]};
        if (r10 < 0.0f) goto L45;
        if (r10 >= (r15.getRight() - r15.getLeft())) goto L45;
        float r14 = r11[1];
        if (r14 < 0.0f) goto L45;
        if (r14 >= (r15.getBottom() - r15.getTop())) goto L45;
        if (r20.containsKey(r15) == false) goto L18;
        r13 = (LynxUI) r20.get(r15);
        r18[0] = r11[0];
        r18[1] = r11[1];
    L22:
        if (r13 == null) goto L45;
        return r13;
    L18:
        if ((r15 instanceof ViewGroup) == false) goto L22;
        r13 = a(r11, (ViewGroup) r15, r20);
        if (r13 == null) goto L22;
        r18[0] = r11[0];
        r18[1] = r11[1];
    L45:
        r12 = r12 - 1;
        goto L3
    L25:
        PointF r16 = mTempPoint;
        float r17 = r18[0];
        float r21 = r18[1];
        float r22 = (r17 + r19.getScrollX()) - r15.getLeft();
        float r23 = (r21 + r19.getScrollY()) - r15.getTop();
        Matrix r24 = r15.getMatrix();
        if (r24.isIdentity() == true) goto L29;
        float[] r25 = mMatrixTransformCoords;
        r25[0] = r22;
        r25[1] = r23;
        Matrix r26 = mInverseMatrix;
        r24.invert(r26);
        r26.mapPoints(r25);
        r22 = r25[0];
        r23 = r25[1];
    L29:
        if (r22 < 0.0f) goto L45;
        if (r22 >= (r15.getRight() - r15.getLeft())) goto L45;
        if (r23 < 0.0f) goto L45;
        if (r23 >= (r15.getBottom() - r15.getTop())) goto L45;
        r16.set(r22, r23);
        float r27 = r18[0];
        float r28 = r18[1];
        r18[0] = r16.x;
        r18[1] = r16.y;
        if (r20.containsKey(r15) == false) goto L40;
        r13 = (LynxUI) r20.get(r15);
    L42:
        if (r13 != null) goto L44;
        r18[0] = r27;
        r18[1] = r28;
        goto L45
    L44:
        return r13;
    L40:
        if ((r15 instanceof ViewGroup) == false) goto L42;
        r13 = a(r18, (ViewGroup) r15, r20);
        goto L42
    L46:
        return r13;
    }
}
