package com.lynx.tasm.behavior.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.c0;
import com.lynx.tasm.behavior.ui.accessibility.CustomAccessibilityDelegateCompat;
import com.lynx.tasm.behavior.ui.utils.f;
import com.lynx.tasm.behavior.ui.utils.i;
import com.lynx.tasm.behavior.ui.utils.j;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class UIView extends UISimpleView<b> implements rn.a {
    public UIView(LynxContext r5, Object r10) {
        super(r5, r10);
        if (r5.g() == false) goto L6;
        this.mOverflow = 3;
        return;
    }

    public static /* synthetic */ Map access$000(UIView r5) {
        return r5.mEvents;
    }

    public static /* synthetic */ Map access$100(UIView r5) {
        return r5.mEvents;
    }

    public static /* synthetic */ Map access$200(UIView r5) {
        return r5.mEvents;
    }

    public static /* synthetic */ Map access$300(UIView r5) {
        return r5.mEvents;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.b
    public void afterDraw(Canvas r10) {
        super.afterDraw(r10);
        i r5 = this.mLynxMask;
        j r11 = null;
        if (r5 == null) goto L8;
        f r12 = r5.f10750b;
        if (r12 == null) goto L8;
        j r13 = (j) r12;
    L9:
        if (r13 == null) goto L24;
        if (r5 == null) goto L15;
        f r14 = r5.f10750b;
        if (r14 == null) goto L15;
        j r15 = (j) r14;
    L16:
        r15.setBounds(0, 0, getWidth(), getHeight());
        i r16 = this.mLynxMask;
        if (r16 == null) goto L22;
        f r17 = r16.f10750b;
        if (r17 == null) goto L22;
        r11 = (j) r17;
    L22:
        r11.draw(r10);
        return;
    L15:
        r15 = null;
        goto L16
    L24:
        return;
    L8:
        r13 = null;
        goto L9
    }

    @Override // rn.a
    public boolean canConsumeGesture(float r5, float r10) {
        return true;
    }

    @c0(name = "copyable")
    public void copyable(boolean r5) {
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r5) {
        return createView(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public boolean enableAutoClipRadius() {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, rn.a
    @Nullable
    public Map<Integer, vn.a> getGestureHandlers() {
        return super.getGestureHandlers();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public int getInitialOverflowType() {
        return !this.mContext.g() ? 1 : 0;
    }

    @Override // rn.a
    public int getMemberScrollX() {
        return 0;
    }

    @Override // rn.a
    public int getMemberScrollY() {
        return 0;
    }

    @Override // rn.a
    public int getScrollContainerDirection() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        T r5 = this.mView;
        if (r5 == 0) goto L6;
        ViewCompat.setAccessibilityDelegate(r5, new CustomAccessibilityDelegateCompat(this));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void interceptGesture(boolean r5) {
        super.interceptGesture(r5);
        ((b) this.mView).interceptGesture(r5);
    }

    @Override // rn.a
    public boolean isAtBorder(boolean r5) {
        return false;
    }

    public b onCreateView(Context r5) {
        return new b(r5);
    }

    @Override // rn.a
    public void onGestureScrollBy(float r5, float r10) {
    }

    @Override // rn.a
    public void onInvalidate() {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onPropsUpdated() {
        T r5 = this.mView;
        if (r5 == 0) goto L5;
        ((b) r5).setNativeInteractionEnabled(this.nativeInteractionEnabled);
        ((b) this.mView).setConsumeHoverEvent(this.mConsumeHoverEvent);
    L5:
        super.onPropsUpdated();
    }

    @c0(defaultInt = 0, name = "blur-sampling")
    public void setBlurSampling(int r5) {
        ((b) this.mView).setBlurSampling(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setGestureDetectors(Map<Integer, un.a> r5) {
        super.setGestureDetectors(r5);
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.isEmpty() == true) goto L10;
        ((b) this.mView).setGestureManager(getGestureArenaManager());
        return;
    }

    @c0(name = "impression_id")
    public void setImpressionId(String r5) {
        ((b) this.mView).setImpressionId(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public b createView(Context r5) {
        b r10 = onCreateView(r5);
        r10.addOnAttachStateChangeListener(new bf.b(this, 2));
        return r10;
    }
}
