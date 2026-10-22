package com.lynx.tasm.behavior.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.ui.utils.BackgroundDrawable;
import com.lynx.tasm.rendernode.compat.RenderNodeCompat;
import com.lynx.tasm.rendernode.compat.RenderNodeFactory;
import java.lang.reflect.Method;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class LynxFlattenUI extends LynxBaseUI {
    public static Method sSetUsageHint;
    private float mAlpha;
    private RenderNodeCompat mBackgroundRenderNode;
    private boolean mIsValidate;
    private RenderNodeCompat mRenderNode;

    public LynxFlattenUI(LynxContext r5, Object r10) {
        super(r5, r10);
        this.mAlpha = 1.0f;
        this.mIsValidate = false;
        if (enableRenderNode() == false) goto L6;
        this.mRenderNode = RenderNodeFactory.getInstance().createRenderNodeCompat();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void detachWithViewInfo(g0 r5) {
        if (enableRenderNode() == false) goto L5;
        this.mRenderNode = RenderNodeFactory.getInstance().createRenderNodeCompat();
    L5:
        super.detachWithViewInfo(r5);
    }

    public void draw(Canvas r14) {
        TraceEvent.c("LynxFlattenUI.draw.");
        if (this.mAlpha > 0.0f) goto L6;
        TraceEvent.a(0, "LynxFlattenUI.draw.");
        return;
    L6:
        int r5 = getLeft();
        int r10 = getTop();
        int r11 = r14.save();
        if ((r5 | r10) == 0) goto L10;
        r14.translate(r5, r10);
    L10:
        if (this.mAlpha >= 1.0f) goto L12;
        r14.saveLayerAlpha(0.0f, 0.0f, getWidth(), getHeight(), (int) (this.mAlpha * 255.0f), 31);
    L12:
        onDraw(r14);
        r14.restoreToCount(r11);
        TraceEvent.a(0, "LynxFlattenUI.draw.");
    }

    public boolean enableRenderNode() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getAlpha() {
        return this.mAlpha;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public int getInitialOverflowType() {
        if (this.mContext.g() == true) goto L5;
        return 1;
    L5:
        if ("view".equals(getTagName()) == false) goto L7;
        return 0;
    L7:
        if ("component".equals(getTagName()) == false) goto L13;
        return 0;
    L13:
        return 1;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public float getRealTimeTranslationZ() {
        return 0.0f;
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

    public final void innerDraw(Canvas r5) {
        if (this.mRenderNode != null) goto L5;
    L17:
        draw(r5);
        return;
    L5:
        if (r5.isHardwareAccelerated() == false) goto L17;
        boolean r10 = this.mIsValidate;
        this.mIsValidate = true;
        if (r10 == true) goto L10;
    L11:
        updateRenderNode(this.mRenderNode);
    L13:
        if (this.mRenderNode.hasDisplayList() == true) goto L15;
        return;
    L15:
        this.mRenderNode.drawRenderNode(r5);
        return;
    L10:
        if (this.mRenderNode.hasDisplayList() == true) goto L13;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.a0
    public void invalidate() {
        this.mIsValidate = false;
        a0 r5 = this.mDrawParent;
        if (r5 == null) goto L6;
        r5.invalidate();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean isFlatten() {
        return true;
    }

    public void layout(int r10, int r11, Rect r12) {
        updateDrawingLayoutInfo(r10, r11, r12);
        Rect r5 = new Rect(getLeft(), getTop(), getWidth() + getLeft(), getHeight() + getTop());
        int r13 = getOverflow();
        boolean r14 = false;
        if ((r13 & 1) == 0) goto L5;
        boolean r15 = true;
    L7:
        if ((r13 & 2) == 0) goto L9;
        r14 = true;
    L9:
        DisplayMetrics r16 = getLynxContext().f10152u;
        if (r15 == false) goto L14;
        if (r14 == false) goto L14;
        if (r12 != null) goto L14;
        r5 = null;
    L42:
        Iterator<LynxBaseUI> r17 = this.mChildren.iterator();
    L44:
        if (r17.hasNext() == false) goto L51;
        LynxBaseUI r18 = r17.next();
        int r19 = r18.getOriginLeft() + r10;
        int r20 = r18.getOriginTop() + r11;
        if (r18.isFlatten() == false) goto L47;
        if (r18.isFlatten() == false) goto L44;
        ((LynxFlattenUI) r18).layout(r19, r20, r5);
        goto L44
    L47:
        r18.updateDrawingLayoutInfo(r19, r20, r5);
        ((LynxUI) r18).layout();
        goto L44
    L51:
        return;
    L14:
        if (r15 == false) goto L18;
        if (r12 != null) goto L17;
        int r21 = r16.widthPixels;
        r5.left = -r21;
        r5.right = r21 * 2;
    L28:
        if (r14 == false) goto L32;
        if (r12 != null) goto L31;
        int r22 = r16.heightPixels;
        r5.top = -r22;
        r5.bottom = r22 * 2;
        goto L42
    L31:
        r5.top = r12.top;
        r5.bottom = r12.bottom;
        goto L42
    L32:
        if (r12 == null) goto L42;
        int r23 = r5.top;
        int r24 = r12.top;
        if (r23 > r24) goto L37;
        r23 = r24;
    L37:
        r5.top = r23;
        int r25 = r5.bottom;
        int r26 = r12.bottom;
        if (r25 < r26) goto L41;
        r25 = r26;
    L41:
        r5.bottom = r25;
        goto L42
    L17:
        r5.left = r12.left;
        r5.right = r12.right;
        goto L28
    L18:
        if (r12 == null) goto L28;
        int r27 = r5.left;
        int r28 = r12.left;
        if (r27 > r28) goto L23;
        r27 = r28;
    L23:
        r5.left = r27;
        int r29 = r5.right;
        int r30 = r12.right;
        if (r29 < r30) goto L27;
        r29 = r30;
    L27:
        r5.right = r29;
        goto L28
    L5:
        r15 = false;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void measure() {
        Iterator<LynxBaseUI> r5 = this.mChildren.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r5.next().measure();
        goto L4
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onAttach() {
        super.onAttach();
        invalidate();
    }

    public void onDraw(Canvas r5) {
        BackgroundDrawable r10 = (BackgroundDrawable) this.mLynxBackground.f10750b;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setBounds(0, 0, getWidth(), getHeight());
        this.mContext.getClass();
        r10.draw(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onDrawingPositionChanged() {
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.ui.a0
    public void requestLayout() {
        this.mIsValidate = false;
        a0 r5 = this.mDrawParent;
        if (r5 == null) goto L6;
        r5.requestLayout();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @com.lynx.tasm.behavior.c0(defaultFloat = 1.0f, name = "opacity")
    public void setAlpha(float r5) {
        this.mAlpha = r5;
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setPosition(int r5, int r10) {
        if (getOriginTop() == r10) goto L6;
        setOriginTop(r10);
        setTop(r10);
    L6:
        if (getOriginLeft() == r5) goto L9;
        setOriginLeft(r5);
        setLeft(r5);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setSign(int r5, String r10) {
        super.setSign(r5, r10);
        if (this.mContext.g() == true) goto L5;
        return;
    L5:
        if (r10.equals("view") == false) goto L7;
    L8:
        this.mOverflow = 3;
        return;
    L7:
        if (r10.equals("component") == true) goto L8;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    @com.lynx.tasm.behavior.c0(name = "transform")
    public void setTransform(@Nullable ReadableArray r5) {
        super.setTransform(r5);
        invalidate();
    }

    public final RenderNodeCompat updateRenderNode() {
        boolean r5 = this.mIsValidate;
        this.mIsValidate = true;
        if (r5 == true) goto L5;
    L6:
        updateRenderNode(this.mRenderNode);
    L8:
        return this.mRenderNode;
    L5:
        if (this.mRenderNode.hasDisplayList() == true) goto L8;
        goto L6
    }

    public void updateRenderNode(RenderNodeCompat r10) {
        int r5 = getWidth();
        int r11 = getHeight();
        int r12 = getLeft();
        int r13 = getTop();
        int r14 = r12 + r5;
        int r15 = r13 + r11;
        if (getOverflow() == 0) goto L5;
        Rect r16 = getClipBounds();
        r14 = r16.right + r12;
        r15 = r16.bottom + r13;
        r12 = r12 + r16.left;
        r13 = r13 + r16.top;
        r5 = r14 - r12;
        r11 = r15 - r13;
    L5:
        r10.setPosition(r12, r13, r14, r15);
        Canvas r17 = r10.beginRecording(r5, r11);
        r17.translate(-r12, -r13);     // Catch: Throwable -> L9
        draw(r17);     // Catch: Throwable -> L9
        r10.endRecording(r17);
        return;
    L9:
        th = move-exception;
        r10.endRecording(r17);
        throw th;
    }
}
