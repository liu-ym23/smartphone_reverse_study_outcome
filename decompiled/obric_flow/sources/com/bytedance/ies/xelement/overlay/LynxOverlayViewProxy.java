package com.bytedance.ies.xelement.overlay;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.lynx.base.log.LynxLog;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.LynxUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.a0;
import com.lynx.tasm.behavior.ui.n;
import com.lynx.tasm.behavior.ui.z;
import com.lynx.tasm.behavior.y0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/ies/xelement/overlay/LynxOverlayViewProxy;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Lcom/lynx/tasm/behavior/ui/view/b;", "Lcom/lynx/tasm/behavior/ui/n;", "x-element-overlay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LynxOverlayViewProxy extends UIGroup<com.lynx.tasm.behavior.ui.view.b> implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LynxOverlayView f6485a;

    public LynxOverlayViewProxy(b0 r5, z r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r10);
        LynxOverlayView r11 = new LynxOverlayView(r5, this);
        this.f6485a = r11;
        super.insertChild(r11, 0);
        DisplayMetrics r12 = new DisplayMetrics();
        Activity r13 = kk.a.c(r5);
        if (r13 == null) goto L6;
        r13.getWindowManager().getDefaultDisplay().getMetrics(r12);
        return;
    L6:
        LynxLog.b(4, "LynxOverlayViewProxy", "context is not Activity!");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void afterPropsUpdated(y0 r5) {
        this.f6485a.afterPropsUpdated(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new h(r5, this);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final LynxBaseUI getChildAt(int r5) {
        return this.f6485a.getChildAt(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final int getChildCount() {
        return this.f6485a.getChildCount();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final List getChildren() {
        return this.f6485a.getChildren();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final LynxUI getTransitionUI() {
        return this.f6485a;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void insertChild(LynxBaseUI r5, int r10) {
        this.f6485a.insertChild(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final void insertDrawList(LynxBaseUI r5, LynxBaseUI r10) {
        this.f6485a.insertDrawList(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void insertView(LynxUI r5) {
        this.f6485a.insertView(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean isUserInteractionEnabled() {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void layout() {
        super.layout();
        this.f6485a.layout();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void measure() {
        super.measure();
        this.f6485a.measure();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onAnimationUpdated() {
        this.f6485a.onAnimationUpdated();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void onDetach() {
        this.f6485a.onDetach();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void removeChild(LynxBaseUI r5) {
        this.f6485a.removeChild(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup
    public final void removeView(LynxBaseUI r5) {
        this.f6485a.removeView(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setBackgroundColor(int r5) {
        this.f6485a.setBackgroundColor(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setParent(a0 r5) {
        super.setParent(r5);
        this.f6485a.setParent(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void setSign(int r5, String r10) {
        super.setSign(r5, r10);
        this.f6485a.setSign(r5, r10);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final boolean updateDrawingLayoutInfo(int r5, int r10, Rect r11) {
        super.updateDrawingLayoutInfo(r5, r10, r11);
        return this.f6485a.updateDrawingLayoutInfo(r5, r10, r11);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateExtraData(Object r5) {
        this.f6485a.updateExtraData(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayout(int r19, int r20, int r21, int r22, int r23, int r24, int r25, int r26, int r27, int r28, int r29, int r30, int r31, int r32, int r33, int r34, Rect r35) {
        super.updateLayout(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35);
        this.f6485a.updateLayout(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updateLayoutInfo(LynxBaseUI r5) {
        super.updateLayoutInfo(r5);
        this.f6485a.updateLayoutInfo(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public final void updatePropertiesInterval(y0 r5) {
        this.f6485a.updatePropertiesInterval(r5);
    }
}
