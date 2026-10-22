package com.lynx.tasm.behavior.ui.text;

import android.content.Context;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.bytedance.ai.bridge.method.router.OpenPageMethod;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.f0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.accessibility.CustomAccessibilityDelegateCompat;
import com.lynx.tasm.behavior.ui.p;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.u0;
import java.util.ArrayList;
import java.util.Map;
import zm.d0;

/* JADX INFO: loaded from: classes2.dex */
public class UIText extends UIGroup<AndroidText> implements rn.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d0 f10694a;

    public UIText(b0 r5, z r10) {
        super(r5, r10);
        this.mAccessibilityElementStatus = 1;
        u0 r11 = this.mContext.K;
        if (r11 == null) goto L5;
        boolean r12 = r11.f10981t;
    L6:
        if (r12 == false) goto L9;
        this.mOverflow = 3;
        return;
    L9:
        return;
    L5:
        r12 = false;
        goto L6
    }

    public final JavaOnlyMap b(RectF r10, RectF r11) {
        JavaOnlyMap r5 = new JavaOnlyMap();
        float r12 = getLynxContext().f10152u.density;
        r5.putDouble(OpenPageMethod.ALIGN_LEFT, (((r10.left + getPaddingLeft()) + getBorderLeftWidth()) + r11.left) / r12);
        r5.putDouble("top", (((r10.top + getPaddingTop()) + getBorderTopWidth()) + r11.top) / r12);
        r5.putDouble("right", (((r10.left + getPaddingLeft()) + getBorderLeftWidth()) + r11.right) / r12);
        r5.putDouble("bottom", (((r10.top + getPaddingTop()) + getBorderTopWidth()) + r11.bottom) / r12);
        r5.putDouble("width", r11.width() / r12);
        r5.putDouble("height", r11.height() / r12);
        return r5;
    }

    public final JavaOnlyMap c(ArrayList r10, RectF r11) {
        JavaOnlyMap r5 = new JavaOnlyMap();
        float r12 = getLynxContext().f10152u.density;
        r5.putDouble("x", (((Float) r10.get(0)).floatValue() + ((r11.left + getPaddingLeft()) + getBorderLeftWidth())) / r12);
        r5.putDouble("y", (((Float) r10.get(1)).floatValue() + ((r11.top + getPaddingTop()) + getBorderTopWidth())) / r12);
        r5.putDouble("radius", ((Float) r10.get(2)).floatValue() / r12);
        return r5;
    }

    @Override // rn.a
    public final boolean canConsumeGesture(float r5, float r10) {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final p convertToMeaningfulPaintingArea(int r5, int r10) {
        T r11 = this.mView;
        if (r11 != 0) goto L5;
        Layout r12 = null;
    L6:
        if (r12 != null) goto L8;
        return null;
    L8:
        getOriginLeft();
        getOriginTop();
        getWidth();
        getHeight();
        p r13 = new p();
        T r14 = this.mView;
        if (r14 == 0) goto L11;
        ((AndroidText) r14).getAlpha();
    L12:
        T r15 = this.mView;
        if (r15 == 0) goto L15;
        ((AndroidText) r15).getScaleX();
    L16:
        T r16 = this.mView;
        if (r16 == 0) goto L19;
        ((AndroidText) r16).getScaleY();
    L20:
        T r17 = this.mView;
        if (r17 == 0) goto L24;
        ((AndroidText) r17).getVisibility();
        return r13;
    L24:
        getVisibility();
        return r13;
    L19:
        getScaleY();
        goto L20
    L15:
        getScaleX();
        goto L16
    L11:
        getAlpha();
        goto L12
    L5:
        r12 = ((AndroidText) r11).getTextLayout();
        goto L6
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void copyPropFromOldUiInUpdateFlatten(LynxBaseUI r5) {
        super.copyPropFromOldUiInUpdateFlatten(r5);
        if ((r5 instanceof FlattenUIText) == true) goto L5;
        return;
    L5:
        updateExtraData(((FlattenUIText) r5).f);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r5) {
        return j(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void destroy() {
        super.destroy();
        T r5 = this.mView;
        if (r5 == 0) goto L6;
        ((AndroidText) r5).release();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final void didEnsureCreateView() {
        super.didEnsureCreateView();
        ((AndroidText) this.mView).setTextBundle(this.f10694a);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final CharSequence getAccessibilityLabel() {
        CharSequence r5 = super.getAccessibilityLabel();
        if (TextUtils.isEmpty(r5) == true) goto L6;
        return r5;
    L6:
        return ((AndroidText) this.mView).getText();
    }

    @Override // rn.a
    public final int getMemberScrollX() {
        return 0;
    }

    @Override // rn.a
    public final int getMemberScrollY() {
        return 0;
    }

    @Override // rn.a
    public final int getScrollContainerDirection() {
        return 0;
    }

    @f0
    public void getSelectedText(ReadableMap r5, Callback r10) {
        T r11 = this.mView;
        if (r11 == 0) goto L6;
        String r12 = ((AndroidText) r11).getSelectedText();
        JavaOnlyMap r13 = new JavaOnlyMap();
        r13.put("selectedText", r12);
        r10.invoke(new Object[]{0, r13});
        return;
    L6:
        r10.invoke(new Object[]{6});
    }

    @f0
    public void getTextBoundingRect(ReadableMap r5, Callback r10) {
        int r11 = r5.getInt("start");     // Catch: Exception -> L14
        int r12 = r5.getInt("end");     // Catch: Exception -> L14
        if (r11 > r12) goto L18;
        if (r11 < 0) goto L18;
        if (r12 < 0) goto L18;
        T r13 = this.mView;     // Catch: Exception -> L14
        if (r13 == 0) goto L16;
        ArrayList<RectF> r14 = ((AndroidText) r13).getTextBoundingBoxes(r11, r12);     // Catch: Exception -> L14
        if (r14.size() <= 0) goto L16;
        r10.invoke(new Object[]{0, i(r14, i.a.e(this, r5))});     // Catch: Exception -> L14
        return;
    L16:
        r10.invoke(new Object[]{1, "Can not find text bounding rect."});     // Catch: Exception -> L14
        return;
    L18:
        r10.invoke(new Object[]{4, "parameter is invalid"});     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        r10.invoke(new Object[]{1, e.getMessage()});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final wm.a hitTest(float r5, float r10) {
        return hitTest(r5, r10, false);
    }

    public final JavaOnlyMap i(ArrayList r5, RectF r10) {
        int r11 = 0;
        RectF r12 = new RectF((RectF) r5.get(0));
        int r13 = 1;
    L4:
        if (r13 >= r5.size()) goto L6;
        r12.union((RectF) r5.get(r13));
        r13 = r13 + 1;
        goto L4
    L6:
        JavaOnlyMap r14 = new JavaOnlyMap();
        r14.putMap("boundingRect", b(r10, r12));
        JavaOnlyArray r15 = new JavaOnlyArray();
    L8:
        if (r11 >= r5.size()) goto L10;
        r15.add(b(r10, (RectF) r5.get(r11)));
        r11 = r11 + 1;
        goto L8
    L10:
        r14.putArray("boxes", r15);
        return r14;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        T r5 = this.mView;
        if (r5 == 0) goto L6;
        ViewCompat.setAccessibilityDelegate(r5, new CustomAccessibilityDelegateCompat(this));
        return;
    }

    @Override // rn.a
    public final boolean isAtBorder(boolean r5) {
        return false;
    }

    public AndroidText j(Context r5) {
        return new AndroidText(r5);
    }

    public final CharSequence k() {
        T r5 = this.mView;
        if (r5 != 0) goto L7;
        return "";
    L7:
        return ((AndroidText) r5).getOriginText();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean needGenerateMeaningfulPaintingArea() {
        return true;
    }

    @Override // rn.a
    public final void onGestureScrollBy(float r5, float r10) {
    }

    @Override // rn.a
    public final void onInvalidate() {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r5 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r10 = this.mPaddingRight + this.mBorderRightWidth;
        int r11 = this.mPaddingTop + this.mBorderTopWidth;
        int r12 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((AndroidText) this.mView).setPadding(r5, r11, r10, r12);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onNodeReady() {
        onAnimationNodeReady();
        afterAnimationNodeReady();
        this.mContext.getClass();
        d0 r5 = ((AndroidText) this.mView).mTextUpdateBundle;
        if (r5 == null) goto L6;
        fj.a.f(r5, this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    @c0(name = "accessibility-label")
    public void setAccessibilityLabel(@Nullable pm.a r5) {
        super.setAccessibilityLabel(r5);
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((AndroidText) r10).setFocusable(true);
        ((AndroidText) this.mView).setContentDescription(getAccessibilityLabel());
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setConsumeHoverEvent(boolean r5) {
        super.setConsumeHoverEvent(r5);
        T r10 = this.mView;
        if (r10 == 0) goto L6;
        ((AndroidText) r10).setConsumeHoverEvent(this.mConsumeHoverEvent);
        return;
    }

    @c0(defaultBoolean = false, name = "custom-context-menu")
    public void setCustomContextMenu(boolean r5) {
        ((AndroidText) this.mView).setCustomContextMenu(r5);
    }

    @c0(defaultBoolean = false, name = "custom-text-selection")
    public void setCustomTextSelection(boolean r5) {
        ((AndroidText) this.mView).setCustomTextSelection(r5);
    }

    @c0(defaultBoolean = false, name = "text-selection")
    public void setEnableTextSelection(boolean r5) {
        ((AndroidText) this.mView).setEnableTextSelection(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setGestureDetectors(Map r5) {
        super.setGestureDetectors(r5);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L10;
        ((AndroidText) this.mView).setGestureManager(getGestureArenaManager());
        return;
    }

    @c0(defaultInt = 0, name = "selection-background-color")
    public void setSelectionBackgroundColor(int r5) {
        ((AndroidText) this.mView).updateSelectionBackgroundColor(r5);
    }

    @c0(defaultInt = 0, name = "selection-handle-color")
    public void setSelectionHandleColor(int r5) {
        ((AndroidText) this.mView).updateSelectionHandleColor(r5);
    }

    @c0(defaultInt = 0, name = "selection-handle-size")
    public void setSelectionHandleSize(int r5) {
        ((AndroidText) this.mView).updateSelectionHandleSize(r5);
    }

    @f0
    public void setTextSelection(ReadableMap r23, Callback r24) {
        double r10 = getLynxContext().f10152u.density;     // Catch: Exception -> L9
        double r11 = ((r23.getDouble("startX") * r10) - ((double) getPaddingLeft())) - ((double) getBorderLeftWidth());     // Catch: Exception -> L9
        double r12 = ((r23.getDouble("startY") * r10) - ((double) getPaddingTop())) - ((double) getBorderTopWidth());     // Catch: Exception -> L9
        double r13 = ((r23.getDouble("endX") * r10) - ((double) getPaddingLeft())) - ((double) getBorderLeftWidth());     // Catch: Exception -> L9
        double r5 = ((r23.getDouble("endY") * r10) - ((double) getPaddingTop())) - ((double) getBorderTopWidth());     // Catch: Exception -> L9
        if (r23.hasKey("showStartHandle") == true) goto L6;
    L11:
        boolean r20 = true;
    L13:
        if (r23.hasKey("showEndHandle") == true) goto L15;
    L18:
        boolean r21 = true;
    L19:
        T r14 = this.mView;     // Catch: Exception -> L9
        if (r14 == 0) goto L31;
        ArrayList<RectF> r15 = ((AndroidText) r14).setTextSelection((float) r11, (float) r12, (float) r13, (float) r5, r20, r21);     // Catch: Exception -> L9
        if (r15.size() != 0) goto L25;
        r24.invoke(new Object[]{0});     // Catch: Exception -> L9
        return;
    L25:
        RectF r16 = i.a.e(this, r23);     // Catch: Exception -> L9
        JavaOnlyMap r17 = i(r15, r16);     // Catch: Exception -> L9
        ArrayList<Float>[] r18 = ((AndroidText) this.mView).getHandlesInfo();     // Catch: Exception -> L9
        JavaOnlyArray r19 = new JavaOnlyArray();     // Catch: Exception -> L9
        int r22 = 0;
    L27:
        if (r22 >= r18.length) goto L29;
        r19.add(c(r18[r22], r16));     // Catch: Exception -> L9
        r22 = r22 + 1;     // Catch: Exception -> L9
        goto L27
    L29:
        r17.putArray("handles", r19);     // Catch: Exception -> L9
        r24.invoke(new Object[]{0, r17});     // Catch: Exception -> L9
        return;
    L31:
        r24.invoke(new Object[]{6});     // Catch: Exception -> L9
        return;
    L15:
        if (r23.getBoolean("showEndHandle") == true) goto L18;
        r21 = false;
        goto L19
    L6:
        if (r23.getBoolean("showStartHandle") == true) goto L11;
        r20 = false;
    L9:
        e = move-exception;
        r24.invoke(new Object[]{1, e.getMessage()});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateExtraData(Object r5) {
        if ((r5 instanceof d0) == false) goto L8;
        d0 r10 = (d0) r5;
        this.f10694a = r10;
        ((AndroidText) this.mView).setTextBundle(r10);
        Map<String, on.a> r11 = this.mEvents;
        if (r11 == null) goto L9;
        ((AndroidText) this.mView).setBindSelectionChange(r11.containsKey("selectionchange"), getSign());
        return;
    L9:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final wm.a hitTest(float r11, float r12, boolean r13) {
        T r5 = this.mView;
        if (r5 != 0) goto L5;
        return this;
    L5:
        float r10 = r11 - (this.mPaddingLeft + this.mBorderLeftWidth);
        float r14 = r12 - (this.mPaddingTop + this.mBorderTopWidth);
        AndroidText r15 = (AndroidText) r5;
        Layout r16 = r15.mTextLayout;
        if ((r15.getText() instanceof Spanned) == false) goto L9;
        Spanned r17 = (Spanned) r15.getText();
    L11:
        return fj.a.c(this, r10, r14, this, r16, r17, ((AndroidText) getView()).mTextTranslateOffset, r13);
    L9:
        r17 = null;
        goto L11
    }
}
