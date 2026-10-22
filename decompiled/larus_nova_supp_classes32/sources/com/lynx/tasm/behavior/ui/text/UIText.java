package com.lynx.tasm.behavior.ui.text;

import android.content.Context;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.ILynxUIMeaningfulContent$MeaningfulContentStatus;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.accessibility.CustomAccessibilityDelegateCompat;
import com.lynx.tasm.behavior.ui.e;
import com.lynx.tasm.behavior.ui.utils.h;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.service.ILynxTextService;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Map;
import z6a.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class UIText extends UIGroup<AndroidText> {
    private boolean mDisplayNone;
    private Map<Integer, t7a.a> mGestureHandlers;
    private w mTextUpdateBundle;
    private ILynxTextService.a mTextraPage;

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public boolean canConsumeGesture(float r1, float r2) {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public int getMemberScrollX() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public int getMemberScrollY() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public int getScrollContainerDirection() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public boolean isAtBorder(boolean r1) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public void onGestureScrollBy(float r1, float r2) {
    }

    public void setColor(int r1) {
    }

    public void setColor(f6a.a r1) {
    }

    public void setTextGradient(ReadableArray r1) {
    }

    private void dispatchLayoutEventIfNeeded() {
        if (this.mContext.isLayoutInElementModeOn() == true) goto L5;
        return;
    L5:
        if (this.mTextUpdateBundle == null) goto L16;
        Map<String, EventsListener> r0 = this.mEvents;
        if (r0 != null) goto L10;
        return;
    L10:
        if (r0.containsKey("layout") == false) goto L17;
        com.lynx.tasm.behavior.shadow.text.b.c(this.mContext, getSign(), this.mTextUpdateBundle);
        return;
    L17:
        return;
    }

    private void updateSelectionChangeBinding() {
        T r0 = this.mView;
        if (r0 != 0) goto L5;
        return;
    L5:
        AndroidText r1 = (AndroidText) r0;
        Map<String, EventsListener> r2 = this.mEvents;
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        r1.setBindSelectionChange(r3, getSign());
        return;
    L8:
        if (r2.containsKey("selectionchange") == false) goto L10;
        r3 = true;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public ILynxUIMeaningfulContent$MeaningfulContentStatus getMeaningfulContentStatus() {
        T r0 = this.mView;
        if (r0 == 0) goto L9;
        if (((AndroidText) r0).getTextLayout() != null) goto L11;
        if (((AndroidText) this.mView).hasTextraPage() == false) goto L9;
    L11:
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PRESENTED;
    L9:
        if (this.mTextraPage != null) goto L11;
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PENDING;
    }

    public CharSequence getOriginText() {
        T r0 = this.mView;
        if (r0 != 0) goto L6;
        return NameKeys.UnloadStrategy_No_Strategy;
    L6:
        return ((AndroidText) r0).getOriginText();
    }

    public Layout getTextLayout() {
        T r0 = this.mView;
        if (r0 != 0) goto L7;
        return null;
    L7:
        return ((AndroidText) r0).getTextLayout();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((AndroidText) r0).release();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public void didEnsureCreateView() {
        super.didEnsureCreateView();
        T r0 = this.mView;
        if (r0 == 0) goto L5;
        ((AndroidText) r0).setDisplayNone(this.mDisplayNone);
    L5:
        ILynxTextService.a r1 = this.mTextraPage;
        if (r1 == null) goto L8;
        ((AndroidText) this.mView).setTextBundle(r1);
        updateSelectionChangeBinding();
        return;
    L8:
        w r2 = this.mTextUpdateBundle;
        if (r2 == null) goto L13;
        ((AndroidText) this.mView).setTextBundle(r2);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public CharSequence getAccessibilityLabel() {
        CharSequence r0 = super.getAccessibilityLabel();
        if (TextUtils.isEmpty(r0) == true) goto L6;
        return r0;
    L6:
        return ((AndroidText) this.mView).getText();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public Map<Integer, t7a.a> getGestureHandlers() {
        return super.getGestureHandlers();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ViewCompat.setAccessibilityDelegate(r0, new CustomAccessibilityDelegateCompat(this));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public void onInvalidate() {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r0 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r1 = this.mPaddingRight + this.mBorderRightWidth;
        int r2 = this.mPaddingTop + this.mBorderTopWidth;
        int r3 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((AndroidText) this.mView).setPadding(r0, r2, r1, r3);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        if (this.mContext.isLayoutInElementModeOn() == false) goto L5;
        updateExtraData(this.mContext.getLynxUIOwner().takeTextLayout(getSign()));
    L5:
        T r0 = this.mView;
        if (((AndroidText) r0).mTextUpdateBundle == null) goto L9;
        b.a(((AndroidText) r0).mTextUpdateBundle, this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
    }

    public UIText(Context r1) {
        this((LynxContext) r1);
    }

    private void alignOverflowForTextSelection(boolean r2) {
        if (r2 == true) goto L4;
        return;
    L4:
        if (this.mContext.isTextOverflowEnabled() == true) goto L6;
        return;
    L6:
        if (this.mContext.isLayoutInElementModeOn() == true) goto L9;
        return;
    L9:
        if (getOverflow() != 3) goto L11;
        return;
    L11:
        setOverflow(0);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void copyPropFromOldUiInUpdateFlatten(LynxBaseUI r2) {
        super.copyPropFromOldUiInUpdateFlatten(r2);
        if ((r2 instanceof FlattenUIText) == true) goto L5;
        return;
    L5:
        updateExtraData(((FlattenUIText) r2).getTextBundle());
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public AndroidText createView(Context r2) {
        return new AndroidText(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "accessibility-label")
    public void setAccessibilityLabel(f6a.a r2) {
        super.setAccessibilityLabel(r2);
        T r3 = this.mView;
        if (r3 == 0) goto L6;
        ((AndroidText) r3).setFocusable(true);
        ((AndroidText) this.mView).setContentDescription(getAccessibilityLabel());
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setConsumeHoverEvent(boolean r2) {
        super.setConsumeHoverEvent(r2);
        T r3 = this.mView;
        if (r3 == 0) goto L6;
        ((AndroidText) r3).setConsumeHoverEvent(this.mConsumeHoverEvent);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "custom-context-menu")
    public void setCustomContextMenu(boolean r2) {
        ((AndroidText) this.mView).setCustomContextMenu(r2);
    }

    @LynxProp(defaultBoolean = false, name = "custom-text-selection")
    public void setCustomTextSelection(boolean r2) {
        ((AndroidText) this.mView).setCustomTextSelection(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setDisplayNone(boolean r2) {
        super.setDisplayNone(r2);
        this.mDisplayNone = r2;
        T r0 = this.mView;
        if (r0 == 0) goto L6;
        ((AndroidText) r0).setDisplayNone(r2);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "text-selection")
    public void setEnableTextSelection(boolean r2) {
        ((AndroidText) this.mView).setEnableTextSelection(r2);
        alignOverflowForTextSelection(r2);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> r1) {
        super.setEvents(r1);
        if (this.mTextraPage == null) goto L6;
        updateSelectionChangeBinding();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setGestureDetectors(Map<Integer, s7a.a> r2) {
        super.setGestureDetectors(r2);
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isEmpty() == true) goto L10;
        ((AndroidText) this.mView).setGestureManager(getGestureArenaManager());
        return;
    }

    @LynxProp(defaultInt = 0, name = "selection-background-color")
    public void setSelectionBackgroundColor(int r2) {
        ((AndroidText) this.mView).updateSelectionBackgroundColor(r2);
    }

    @LynxProp(defaultInt = 0, name = "selection-handle-color")
    public void setSelectionHandleColor(int r2) {
        ((AndroidText) this.mView).updateSelectionHandleColor(r2);
    }

    @LynxProp(defaultInt = 0, name = "selection-handle-size")
    public void setSelectionHandleSize(int r2) {
        ((AndroidText) this.mView).updateSelectionHandleSize(r2);
    }

    public void setTextGradient(String r2) {
        LLog.e("UIText", "setTextGradient(String) is deprecated");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updateExtraData(Object r3) {
        if ((r3 instanceof w) == false) goto L9;
        w r4 = (w) r3;
        this.mTextUpdateBundle = r4;
        this.mTextraPage = null;
        ((AndroidText) this.mView).setTextBundle(r4);
        Map<String, EventsListener> r5 = this.mEvents;
        if (r5 == null) goto L7;
        ((AndroidText) this.mView).setBindSelectionChange(r5.containsKey("selectionchange"), getSign());
    L7:
        dispatchLayoutEventIfNeeded();
        return;
    L9:
        if ((r3 instanceof ILynxTextService.a) == false) goto L16;
        this.mTextUpdateBundle = null;
        ILynxTextService.a r6 = (ILynxTextService.a) r3;
        this.mTextraPage = r6;
        T r0 = this.mView;
        if (r0 == 0) goto L13;
        ((AndroidText) r0).setTextBundle(r6);
    L13:
        updateSelectionChangeBinding();
        return;
    }

    public UIText(LynxContext r2) {
        this(r2, null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r1) {
        return createView(r1);
    }

    public UIText(LynxContext r1, Object r2) {
        super(r1, r2);
        this.mDisplayNone = false;
        this.mAccessibilityElementStatus = 1;
        if (this.mContext.isTextOverflowEnabled() == true) goto L5;
        return;
    L5:
        if (this.mContext.isLayoutInElementModeOn() == true) goto L9;
        this.mOverflow = 3;
        return;
    }

    private JavaOnlyMap getHandleMap(ArrayList<Float> r6, RectF r7) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        float r1 = getLynxContext().getScreenMetrics().density;
        r0.putDouble("x", (((r7.left + getPaddingLeft()) + getBorderLeftWidth()) + ((Float) ListProtector.get(r6, 0)).floatValue()) / r1);
        r0.putDouble("y", (((r7.top + getPaddingTop()) + getBorderTopWidth()) + ((Float) ListProtector.get(r6, 1)).floatValue()) / r1);
        r0.putDouble("radius", ((Float) ListProtector.get(r6, 2)).floatValue() / r1);
        return r0;
    }

    private JavaOnlyMap getMapFromRect(RectF r6, RectF r7) {
        JavaOnlyMap r0 = new JavaOnlyMap();
        float r1 = getLynxContext().getScreenMetrics().density;
        r0.putDouble("left", (((r6.left + getPaddingLeft()) + getBorderLeftWidth()) + r7.left) / r1);
        r0.putDouble("top", (((r6.top + getPaddingTop()) + getBorderTopWidth()) + r7.top) / r1);
        r0.putDouble("right", (((r6.left + getPaddingLeft()) + getBorderLeftWidth()) + r7.right) / r1);
        r0.putDouble("bottom", (((r6.top + getPaddingTop()) + getBorderTopWidth()) + r7.bottom) / r1);
        r0.putDouble("width", r7.width() / r1);
        r0.putDouble("height", r7.height() / r1);
        return r0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public e convertToMeaningfulPaintingArea(int r4, int r5) {
        if (getMeaningfulContentStatus() != ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT) goto L6;
        return null;
    L6:
        e r0 = new e(r4 + getOriginLeft(), r5 + getOriginTop(), getWidth(), getHeight());
        T r6 = this.mView;
        if (r6 == 0) goto L9;
        ((AndroidText) r6).getAlpha();
    L10:
        T r7 = this.mView;
        if (r7 == 0) goto L13;
        ((AndroidText) r7).getScaleX();
    L14:
        T r8 = this.mView;
        if (r8 == 0) goto L17;
        ((AndroidText) r8).getScaleY();
    L18:
        T r9 = this.mView;
        if (r9 == 0) goto L21;
        ((AndroidText) r9).getVisibility();
    L22:
        r0.e = getMeaningfulContentStatus();
        r0.f = getFirstMeaningfulContentPresentedTimestampMicros();
        return r0;
    L21:
        getVisibility();
        goto L22
    L17:
        getScaleY();
        goto L18
    L13:
        getScaleX();
        goto L14
    L9:
        getAlpha();
        goto L10
    }

    @LynxUIMethod
    public void getSelectedText(ReadableMap r5, Callback r6) {
        T r7 = this.mView;
        if (r7 == 0) goto L5;
        String r8 = ((AndroidText) r7).getSelectedText();
        JavaOnlyMap r2 = new JavaOnlyMap();
        r2.put("selectedText", r8);
        r6.invoke(new Object[]{0, r2});
        return;
    L5:
        r6.invoke(new Object[]{6});
    }

    @LynxUIMethod
    public void getTextBoundingRect(ReadableMap r7, Callback r8) {
        int r3 = r7.getInt("start");     // Catch: Exception -> L17
        int r4 = r7.getInt("end");     // Catch: Exception -> L17
        if (r3 > r4) goto L15;
        if (r3 < 0) goto L15;
        if (r4 < 0) goto L15;
        T r5 = this.mView;     // Catch: Exception -> L17
        if (r5 == 0) goto L14;
        ArrayList<RectF> r6 = ((AndroidText) r5).getTextBoundingBoxes(r3, r4);     // Catch: Exception -> L17
        if (r6.size() <= 0) goto L14;
        r8.invoke(new Object[]{0, getTextBoundingRectFromBoxes(r6, r7, h.g(this, r7))});     // Catch: Exception -> L17
        return;
    L14:
        r8.invoke(new Object[]{1, "Can not find text bounding rect."});     // Catch: Exception -> L17
        return;
    L15:
        r8.invoke(new Object[]{4, "parameter is invalid"});     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        r8.invoke(new Object[]{1, e.getMessage()});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float r2, float r3) {
        return hitTest(r2, r3, false);
    }

    @LynxUIMethod
    public void setTextSelection(ReadableMap r24, Callback r25) {
        double r11 = getLynxContext().getScreenMetrics().density;     // Catch: Exception -> L35
        double r9 = ((r24.getDouble("startX") * r11) - ((double) getPaddingLeft())) - ((double) getBorderLeftWidth());     // Catch: Exception -> L35
        double r13 = ((r24.getDouble("startY") * r11) - ((double) getPaddingTop())) - ((double) getBorderTopWidth());     // Catch: Exception -> L35
        double r7 = ((r24.getDouble("endX") * r11) - ((double) getPaddingLeft())) - ((double) getBorderLeftWidth());     // Catch: Exception -> L35
        double r5 = ((r24.getDouble("endY") * r11) - ((double) getPaddingTop())) - ((double) getBorderTopWidth());     // Catch: Exception -> L35
        if (r24.hasKey("showStartHandle") == true) goto L6;
    L9:
        boolean r21 = true;
    L11:
        if (r24.hasKey("showEndHandle") == true) goto L13;
    L16:
        boolean r22 = true;
    L17:
        T r3 = this.mView;     // Catch: Exception -> L35
        if (r3 == 0) goto L33;
        ArrayList<RectF> r4 = ((AndroidText) r3).setTextSelection((float) r9, (float) r13, (float) r7, (float) r5, r21, r22);     // Catch: Exception -> L35
        if (r4.size() != 0) goto L22;
        r25.invoke(new Object[]{0});     // Catch: Exception -> L35
        return;
    L22:
        RectF r6 = h.g(this, r24);     // Catch: Exception -> L35
        JavaOnlyMap r0 = getTextBoundingRectFromBoxes(r4, r24, r6);     // Catch: Exception -> L35
        ArrayList<Float>[] r8 = ((AndroidText) this.mView).getHandlesInfo();     // Catch: Exception -> L35
        JavaOnlyArray r10 = new JavaOnlyArray();     // Catch: Exception -> L35
        int r12 = 0;
    L24:
        if (r12 >= r8.length) goto L26;
        r10.add(getHandleMap(r8[r12], r6));     // Catch: Exception -> L35
        r12 = r12 + 1;     // Catch: Exception -> L35
        goto L24
    L26:
        r0.putArray("handles", r10);     // Catch: Exception -> L35
        int r14 = 2;
        Object[] r15 = new Object[2];     // Catch: Exception -> L31
        r15[0] = 0;     // Catch: Exception -> L35
        r15[1] = r0;     // Catch: Exception -> L35
        r25.invoke(r15);     // Catch: Exception -> L35
        return;
    L31:
        e = e;
    L37:
        Object[] r16 = new Object[r14];
        r16[0] = 1;
        r16[1] = e.getMessage();
        r25.invoke(r16);
        return;
    L33:
        r25.invoke(new Object[]{6});     // Catch: Exception -> L35
        return;
    L13:
        if (r24.getBoolean("showEndHandle") == true) goto L16;
        r22 = false;
        goto L17
    L6:
        if (r24.getBoolean("showStartHandle") == true) goto L9;
        r21 = false;
    L35:
        e = e;
        r14 = 2;
        goto L37
    }

    private JavaOnlyMap getTextBoundingRectFromBoxes(ArrayList<RectF> r4, ReadableMap r5, RectF r6) {
        int r0 = 0;
        RectF r7 = new RectF((RectF) ListProtector.get(r4, 0));
        int r1 = 1;
    L4:
        if (r1 >= r4.size()) goto L6;
        r7.union((RectF) ListProtector.get(r4, r1));
        r1 = r1 + 1;
        goto L4
    L6:
        JavaOnlyMap r2 = new JavaOnlyMap();
        r2.putMap("boundingRect", getMapFromRect(r6, r7));
        JavaOnlyArray r8 = new JavaOnlyArray();
    L8:
        if (r0 >= r4.size()) goto L10;
        r8.add(getMapFromRect(r6, (RectF) ListProtector.get(r4, r0)));
        r0 = r0 + 1;
        goto L8
    L10:
        r2.putArray("boxes", r8);
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float r12, float r13, boolean r14) {
        T r0 = this.mView;
        if (r0 != 0) goto L5;
        return this;
    L5:
        float r3 = r12 - (this.mPaddingLeft + this.mBorderLeftWidth);
        float r4 = r13 - (this.mPaddingTop + this.mBorderTopWidth);
        Layout r6 = ((AndroidText) r0).mTextLayout;
        AndroidText r1 = (AndroidText) r0;
        Spanned r15 = null;
        if (r1 != null) goto L9;
    L12:
        return b.c(this, r3, r4, this, r6, r15, ((AndroidText) getView()).mTextTranslateOffset, ((AndroidText) this.mView).mTextraPage, r14);
    L9:
        if ((r1.getText() instanceof Spanned) == false) goto L12;
        r15 = (Spanned) r1.getText();
        goto L12
    }
}
