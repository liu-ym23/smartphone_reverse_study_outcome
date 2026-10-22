package com.bytedance.ies.xelement.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.lynx.tasm.b0;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.accessibility.LynxAccessibilityDelegate;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends com.lynx.tasm.behavior.ui.view.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UIGroup f6500b;

    public h(Context r5, LynxOverlayView r10) {
        this.f6499a = 0;
        this.f6500b = r10;
        new LinkedHashMap();
        super(r5);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchHoverEvent(MotionEvent r5) {
        switch(this.f6499a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        LynxOverlayView r10 = (LynxOverlayView) this.f6500b;
        com.lynx.tasm.behavior.ui.accessibility.d r11 = r10.getLynxContext().f10145m.d;
        if (r11 != null) goto L9;
    L11:
        boolean r12 = false;
    L13:
        if (r10.f6479m == false) goto L29;
        if (r12 == true) goto L21;
        com.lynx.tasm.behavior.ui.f r13 = r10.f6481o;
        if (r13 == null) goto L21;
        if (r13.g(r5) != true) goto L21;
        return true;
    L21:
        if (r12 == false) goto L28;
        LynxAccessibilityDelegate r14 = r10.f6480n;
        if (r14 == null) goto L28;
        if (r14.c(r5) != true) goto L28;
        return true;
    L28:
        return onHoverEvent(r5);
    L29:
        return super.dispatchHoverEvent(r5);
    L9:
        if (r11.f() == false) goto L11;
        r12 = true;
        goto L13
    L5:
        return super.dispatchHoverEvent(r5);
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        switch(this.f6499a) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.onLayout(r5, r10, r11, r12, r13);
        return;
    L6:
        ((LynxOverlayView) this.f6500b).layout();
    }

    @Override // com.lynx.tasm.behavior.ui.view.b, android.view.View
    public void onMeasure(int r5, int r10) {
        switch(this.f6499a) {
            case 1: goto L6;
            default: goto L4;
        };
    L4:
        super.onMeasure(r5, r10);
        return;
    L6:
        setMeasuredDimension(View.MeasureSpec.getSize(r5), View.MeasureSpec.getSize(r10));
        ((LynxOverlayView) this.f6500b).measureChildren();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r5, int r10) {
        switch(this.f6499a) {
            case 2: goto L6;
            default: goto L4;
        };
    L4:
        super.onVisibilityChanged(r5, r10);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "changedView");
        LynxOverlayViewProxy r11 = (LynxOverlayViewProxy) this.f6500b;
        if (r10 != 0) goto L9;
        r11.onAttach();
        return;
    L9:
        if (r10 != 4) goto L11;
    L13:
        r11.f6485a.onDetach();
        return;
    L11:
        if (r10 == 8) goto L13;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestSendAccessibilityEvent(View r5, AccessibilityEvent r10) {
        switch(this.f6499a) {
            case 0: goto L6;
            default: goto L5;
        };
    L6:
        Intrinsics.checkNotNullParameter(r10, "event");
        if (((LynxOverlayView) this.f6500b).f6479m == false) goto L12;
        if (r10.getEventType() != 2048) goto L12;
        r10.setSource(this);
    L12:
        return super.requestSendAccessibilityEvent(r5, r10);
    L5:
        return super.requestSendAccessibilityEvent(r5, r10);
    }

    public h(Context r5, LynxOverlayViewProxy r10) {
        this.f6499a = 2;
        this.f6500b = r10;
        new LinkedHashMap();
        super(r5);
    }

    public h(b0 r5, LynxOverlayView r10) {
        this.f6499a = 1;
        this.f6500b = r10;
        new LinkedHashMap();
        super(r5);
    }
}
