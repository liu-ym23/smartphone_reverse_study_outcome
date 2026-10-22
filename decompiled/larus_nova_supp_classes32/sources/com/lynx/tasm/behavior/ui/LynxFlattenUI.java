package com.lynx.tasm.behavior.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.render.PlatformRendererContext;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.rendernode.compat.RenderNodeCompat;
import com.lynx.tasm.rendernode.compat.RenderNodeFactory;
import com.lynx.tasm.utils.DisplayMetricsHolder;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class LynxFlattenUI extends LynxBaseUI implements x6a.e {
    public static Method sSetUsageHint;
    private float mAlpha;
    private RenderNodeCompat mBackgroundRenderNode;
    private boolean mIsValidate;
    private RenderNodeCompat mRenderNode;
    private x6a.i mRenderer;
    private Rect mRendererClipBounds;
    private int mRendererDrawingScopeSaveCount;
    private float mRendererOpacity;
    private Matrix mRendererTransformMatrix;

    public boolean enableRenderNode() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getRealTimeTranslationZ() {
        return 0.0f;
    }

    @Override // x6a.e
    public int getRendererHostScrollX() {
        return 0;
    }

    @Override // x6a.e
    public int getRendererHostScrollY() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getTranslationX() {
        return 0.0f;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getTranslationY() {
        return 0.0f;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getTranslationZ() {
        return 0.0f;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public void invalidate() {
        this.mIsValidate = false;
        k r0 = this.mDrawParent;
        if (r0 == null) goto L6;
        r0.invalidate();
        return;
    }

    @Override // x6a.e
    public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r1, ReadableMap r2, Callback r3) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean isFlatten() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.k
    public void requestLayout() {
        this.mIsValidate = false;
        k r0 = this.mDrawParent;
        if (r0 == null) goto L6;
        r0.requestLayout();
        return;
    }

    @Override // x6a.e
    public void setClipChildrenForRenderer(boolean r1) {
    }

    @Override // x6a.e
    public void setWillNotDrawForRenderer(boolean r1) {
    }

    private float getEffectiveRendererAlpha() {
        return this.mAlpha * this.mRendererOpacity;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public int getInitialOverflowType() {
        if (this.mContext.getDefaultOverflowVisible() == true) goto L5;
    L9:
        return 1;
    L5:
        if ("view".equals(getTagName()) == false) goto L7;
    L8:
        return 0;
    L7:
        if ("component".equals(getTagName()) == false) goto L9;
        goto L8
    }

    public boolean isRendererHost() {
        if (this.mRenderer == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void measure() {
        Iterator<LynxBaseUI> r0 = this.mChildren.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().measure();
        goto L4
    L6:
        x6a.i r1 = this.mRenderer;
        if (r1 == null) goto L11;
        View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824);
        View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824);
        r1.i();
        return;
    }

    public final RenderNodeCompat updateRenderNode() {
        boolean r0 = this.mIsValidate;
        this.mIsValidate = true;
        if (r0 == true) goto L5;
    L6:
        updateRenderNode(this.mRenderNode);
    L8:
        return this.mRenderNode;
    L5:
        if (this.mRenderNode.hasDisplayList() == true) goto L8;
        goto L6
    }

    @Override // x6a.e
    public int getRendererHostHeight() {
        return getHeight();
    }

    @Override // x6a.e
    public int getRendererHostWidth() {
        return getWidth();
    }

    @Override // x6a.e
    public View getView() {
        LynxBaseUI r0 = getDrawParent();
        if ((r0 instanceof LynxUI) == true) goto L5;
        return null;
    L5:
        return ((LynxUI) r0).getView();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getAlpha() {
        return this.mAlpha;
    }

    @Override // x6a.e
    public x6a.i getRenderer() {
        return this.mRenderer;
    }

    @Override // x6a.e
    public void invalidateForRenderer() {
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDrawingPositionChanged() {
        invalidate();
    }

    @Override // x6a.e
    public void requestLayoutForRenderer() {
        requestLayout();
    }

    public LynxFlattenUI(Context r1) {
        this((LynxContext) r1);
    }

    private boolean beginRendererDrawingScope(Canvas r11) {
        float r0 = getEffectiveRendererAlpha();
        if (this.mRenderer != null) goto L5;
        return false;
    L5:
        if (r0 > 0.0f) goto L8;
        return false;
    L8:
        if (this.mRendererDrawingScopeSaveCount < 0) goto L10;
        return true;
    L10:
        this.mRendererDrawingScopeSaveCount = r11.save();
        Rect r1 = getBound();
        if (r1 == null) goto L13;
        r11.clipRect(r1);
    L13:
        int r2 = getLeft();
        int r3 = getTop();
        if ((r2 | r3) == 0) goto L16;
        r11.translate(r2, r3);
    L16:
        Matrix r4 = this.mRendererTransformMatrix;
        if (r4 == null) goto L19;
        r11.concat(r4);
    L19:
        Rect r5 = this.mRendererClipBounds;
        if (r5 == null) goto L23;
        r11.clipRect(r5);
    L23:
        if (r0 >= 1.0f) goto L25;
        r11.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (r0 * 255.0f), 31);
    L25:
        return true;
    }

    private void endRendererDrawingScope(Canvas r2) {
        int r0 = this.mRendererDrawingScopeSaveCount;
        if (r0 >= 0) goto L5;
        return;
    L5:
        r2.restoreToCount(r0);
        this.mRendererDrawingScopeSaveCount = -1;
    }

    private boolean isHardwareDraw(Canvas r1) {
        return r1.isHardwareAccelerated();
    }

    @Override // x6a.e
    public void applyRendererOpacity(float r1) {
        this.mRendererOpacity = r1;
        invalidate();
    }

    @Override // x6a.e
    public void applyRendererTransform(float[] r2) {
        Matrix r3 = x6a.i.d(r2);
        if (r3.isIdentity() == false) goto L5;
        this.mRendererTransformMatrix = null;
    L6:
        invalidate();
        return;
    L5:
        this.mRendererTransformMatrix = r3;
        goto L6
    }

    @Override // x6a.e
    public PointF convertPointInRendererHostToScreen(PointF r6) {
        PointF r0 = new PointF(r6.x, r6.y);
        Matrix r7 = this.mRendererTransformMatrix;
        if (r7 == null) goto L5;
        float[] r1 = {r0.x, r0.y};
        r7.mapPoints(r1);
        r0.set(r1[0], r1[1]);
    L5:
        k r8 = this.mDrawParent;
        if ((r8 instanceof LynxUI) == true) goto L8;
    L12:
        LLog.e("LynxFlattenUI", "convertPointInRendererHostToScreen failed since draw parent is null.");
        return r0;
    L8:
        if (((LynxUI) r8).getView() == null) goto L12;
        return com.lynx.tasm.behavior.ui.utils.h.c(this, r0);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void detachWithViewInfo(m r2) {
        if (enableRenderNode() == false) goto L5;
        this.mRenderNode = RenderNodeFactory.getInstance().createRenderNodeCompat();
    L5:
        super.detachWithViewInfo(r2);
    }

    public void draw(Canvas r12) {
        TraceEvent.beginSection("LynxFlattenUI.draw.");
        if (this.mAlpha > 0.0f) goto L7;
        TraceEvent.endSection("LynxFlattenUI.draw.");
        return;
    L7:
        if (this.mRenderer == null) goto L10;
        drawRendererHostStart(r12);
        drawRendererHostEnd(r12);
        TraceEvent.endSection("LynxFlattenUI.draw.");
        return;
    L10:
        int r1 = getLeft();
        int r2 = getTop();
        int r3 = r12.save();
        if ((r1 | r2) == 0) goto L14;
        r12.translate(r1, r2);
    L14:
        if (this.mAlpha >= 1.0f) goto L16;
        r12.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (this.mAlpha * 255.0f), 31);
    L16:
        onDraw(r12);
        r12.restoreToCount(r3);
        TraceEvent.endSection("LynxFlattenUI.draw.");
    }

    public void drawRendererContentUntilNextView(Canvas r2) {
        drawRendererContent(r2, false);
    }

    public void drawRendererHostEnd(Canvas r2) {
        drawRendererContent(r2, true);     // Catch: Throwable -> L6
        endRendererDrawingScope(r2);
        return;
    L6:
        th = move-exception;
        endRendererDrawingScope(r2);
        throw th;
    }

    public void drawRendererHostStart(Canvas r2) {
        if (beginRendererDrawingScope(r2) == true) goto L5;
        return;
    L5:
        this.mRenderer.g(r2);
        drawRendererContentUntilNextView(r2);
    }

    public final void innerDraw(Canvas r3) {
        if (this.mRenderer == null) goto L7;
        drawRendererHostStart(r3);
        return;
    L7:
        if (this.mRenderNode != null) goto L9;
    L21:
        draw(r3);
        return;
    L9:
        if (isHardwareDraw(r3) == false) goto L21;
        boolean r0 = this.mIsValidate;
        this.mIsValidate = true;
        if (r0 == true) goto L14;
    L15:
        updateRenderNode(this.mRenderNode);
    L17:
        if (this.mRenderNode.hasDisplayList() == true) goto L19;
        return;
    L19:
        this.mRenderNode.drawRenderNode(r3);
        return;
    L14:
        if (this.mRenderNode.hasDisplayList() == true) goto L17;
        goto L15
    }

    public void onDraw(Canvas r5) {
        BackgroundDrawable r0 = (BackgroundDrawable) this.mLynxBackground.b;
        if (r0 != null) goto L5;
        return;
    L5:
        r0.setBounds(0, 0, getWidth(), getHeight());
        if (this.mContext.getForceDarkAllowed() == true) goto L8;
    L17:
        r0.draw(r5);
        return;
    L8:
        if (sSetUsageHint == null) goto L17;
        if (r5.isHardwareAccelerated() == false) goto L17;
        RenderNodeCompat r1 = getDrawableRenderNode(r0, this.mBackgroundRenderNode);     // Catch: Exception -> L16
        this.mBackgroundRenderNode = r1;     // Catch: Exception -> L16
        if (r1.hasDisplayList() == false) goto L14;
        r1.drawRenderNode(r5);     // Catch: Exception -> L16
    L19:
        return;
    L14:
        r0.draw(r5);     // Catch: Exception -> L16
    L16:
        r0.draw(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(defaultFloat = DisplayMetricsHolder.DEFAULT_SCREEN_SCALE, name = "opacity")
    public void setAlpha(float r1) {
        this.mAlpha = r1;
        invalidate();
    }

    @Override // x6a.e
    public void setRenderer(x6a.i r1) {
        this.mRenderer = r1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "transform")
    public void setTransform(ReadableArray r1) {
        super.setTransform(r1);
        invalidate();
    }

    public void updateRenderNode(RenderNodeCompat r8) {
        int r0 = getWidth();
        int r1 = getHeight();
        int r2 = getLeft();
        int r3 = getTop();
        int r4 = r2 + r0;
        int r5 = r3 + r1;
        if (getOverflow() == 0) goto L5;
        Rect r6 = getClipBounds();
        r4 = r6.right + r2;
        r5 = r6.bottom + r3;
        r2 = r2 + r6.left;
        r3 = r3 + r6.top;
        r0 = r4 - r2;
        r1 = r5 - r3;
    L5:
        r8.setPosition(r2, r3, r4, r5);
        Canvas r7 = r8.beginRecording(r0, r1);
        r7.translate(-r2, -r3);     // Catch: Throwable -> L9
        draw(r7);     // Catch: Throwable -> L9
        r8.endRecording(r7);
        return;
    L9:
        th = move-exception;
        r8.endRecording(r7);
        throw th;
    }

    public LynxFlattenUI(LynxContext r2) {
        this(r2, null);
    }

    public LynxFlattenUI(LynxContext r1, Object r2) {
        super(r1, r2);
        this.mAlpha = 1.0f;
        this.mIsValidate = false;
        this.mRendererOpacity = 1.0f;
        this.mRendererDrawingScopeSaveCount = -1;
        if (enableRenderNode() == false) goto L6;
        this.mRenderNode = RenderNodeFactory.getInstance().createRenderNodeCompat();
        return;
    }

    private void drawRendererContent(Canvas r3, boolean r4) {
        if (this.mRenderer != null) goto L5;
        return;
    L5:
        if (getEffectiveRendererAlpha() > 0.0f) goto L7;
        return;
    L7:
        if (this.mRendererDrawingScopeSaveCount < 0) goto L16;
        if (r4 == false) goto L11;
        this.mRenderer.a(r3);
        return;
    L11:
        this.mRenderer.c(r3);
        return;
    }

    private RenderNodeCompat getDrawableRenderNode(Drawable r6, RenderNodeCompat r7) throws InvocationTargetException, IllegalAccessException {
        if (r7 != null) goto L4;
        r7 = RenderNodeFactory.getInstance().createRenderNodeCompat();
        sSetUsageHint.invoke(r7.getRenderNode(), new Object[]{1});
    L4:
        Rect r0 = r6.getBounds();
        Canvas r1 = r7.beginRecording(r0.width(), r0.height());
        r1.translate(-r0.left, -r0.top);
        r6.draw(r1);     // Catch: Throwable -> L8
        r7.endRecording(r1);
        r7.setPosition(r0.left, r0.top, r0.right, r0.bottom);
        return r7;
    L8:
        th = move-exception;
        r7.endRecording(r1);
        throw th;
    }

    @Override // x6a.e
    public void applyRendererClipBounds(boolean r1, Rect r2) {
        if (r1 == false) goto L8;
        if (r2 == null) goto L8;
        if (this.mRendererClipBounds != null) goto L7;
        this.mRendererClipBounds = new Rect();
    L7:
        this.mRendererClipBounds.set(r2);
    L9:
        invalidate();
        return;
    L8:
        this.mRendererClipBounds = null;
        goto L9
    }

    @Override // x6a.e
    public x6a.i createRenderer(PlatformRendererContext r2, int r3) {
        return new x6a.i(r2, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setPosition(int r2, int r3) {
        if (getOriginTop() == r3) goto L6;
        setOriginTop(r3);
        setTop(r3);
    L6:
        if (getOriginLeft() == r2) goto L9;
        setOriginLeft(r2);
        setLeft(r2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setSign(int r1, String r2) {
        super.setSign(r1, r2);
        if (this.mContext.getDefaultOverflowVisible() == true) goto L5;
        return;
    L5:
        if (r2.equals("view") == false) goto L7;
    L8:
        this.mOverflow = 3;
        return;
    L7:
        if (r2.equals("component") == true) goto L8;
    }

    public void layout(int r7, int r8, Rect r9) {
        updateDrawingLayoutInfo(r7, r8, r9);
        Rect r0 = new Rect(getLeft(), getTop(), getLeft() + getWidth(), getTop() + getHeight());
        int r1 = getOverflow();
        boolean r3 = true;
        if ((r1 & 1) == 0) goto L5;
        boolean r2 = true;
    L7:
        if ((r1 & 2) != 0) goto L10;
        r3 = false;
    L10:
        DisplayMetrics r4 = getLynxContext().getScreenMetrics();
        if (r2 == false) goto L15;
        if (r3 == false) goto L15;
        if (r9 != null) goto L15;
        r0 = null;
    L43:
        Iterator<LynxBaseUI> r10 = this.mChildren.iterator();
    L45:
        if (r10.hasNext() == false) goto L52;
        LynxBaseUI r5 = r10.next();
        int r6 = r5.getOriginLeft() + r7;
        int r11 = r5.getOriginTop() + r8;
        if (r5.isFlatten() == false) goto L48;
        if (r5.isFlatten() == false) goto L45;
        ((LynxFlattenUI) r5).layout(r6, r11, r0);
        goto L45
    L48:
        r5.updateDrawingLayoutInfo(r6, r11, r0);
        ((LynxUI) r5).layout();
        goto L45
    L52:
        x6a.i r12 = this.mRenderer;
        if (r12 == null) goto L64;
        getLeft();
        getTop();
        getLeft();
        getWidth();
        getTop();
        getHeight();
        r12.h();
        return;
    L64:
        return;
    L15:
        if (r2 == false) goto L19;
        if (r9 != null) goto L18;
        int r13 = r4.widthPixels;
        r0.left = -r13;
        r0.right = r13 * 2;
    L29:
        if (r3 == false) goto L33;
        if (r9 != null) goto L32;
        int r14 = r4.heightPixels;
        r0.top = -r14;
        r0.bottom = r14 * 2;
        goto L43
    L32:
        r0.top = r9.top;
        r0.bottom = r9.bottom;
        goto L43
    L33:
        if (r9 == null) goto L43;
        int r15 = r0.top;
        int r16 = r9.top;
        if (r15 > r16) goto L38;
        r15 = r16;
    L38:
        r0.top = r15;
        int r17 = r0.bottom;
        int r18 = r9.bottom;
        if (r17 < r18) goto L42;
        r17 = r18;
    L42:
        r0.bottom = r17;
        goto L43
    L18:
        r0.left = r9.left;
        r0.right = r9.right;
        goto L29
    L19:
        if (r9 == null) goto L29;
        int r19 = r0.left;
        int r20 = r9.left;
        if (r19 > r20) goto L24;
        r19 = r20;
    L24:
        r0.left = r19;
        int r21 = r0.right;
        int r22 = r9.right;
        if (r21 < r22) goto L28;
        r21 = r22;
    L28:
        r0.right = r21;
        goto L29
    L5:
        r2 = false;
        goto L7
    }
}
