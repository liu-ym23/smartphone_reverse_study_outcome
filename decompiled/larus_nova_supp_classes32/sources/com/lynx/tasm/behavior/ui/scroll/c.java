package com.lynx.tasm.behavior.ui.scroll;

import android.view.View;
import com.lynx.react.bridge.Callback;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.q1;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c implements AndroidScrollView.b {
    public final /* synthetic */ AndroidScrollView a;
    public final /* synthetic */ UIScrollView b;

    @Override // com.lynx.tasm.behavior.ui.scroll.AndroidScrollView.b
    public final void a() {
        this.b.getLynxContext().getFluencyTraceHelper().b(this.b.getSign(), this.b.getScrollMonitorTag());
        UIScrollView r0 = this.b;
        if (r0.l == false) goto L5;
        UIScrollView.X(r0);
    L5:
        UIScrollView r2 = this.b;
        if (r2.h == false) goto L9;
        r2.B0(r2.getScrollX(), this.b.getScrollY(), this.b.getScrollX(), this.b.getScrollY(), "scrollstart");
    L9:
        if (this.b.isEnableScrollMonitor() == false) goto L12;
        this.b.getLynxContext().getLynxViewClient().onScrollStart(new q1.b(this.a, this.b.getTagName(), this.b.getScrollMonitorTag()));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AndroidScrollView.b
    public final void b() {
        this.b.getLynxContext().getFluencyTraceHelper().c(this.b.getSign());
        UIScrollView r2 = this.b;
        if (r2.i == false) goto L6;
        r2.B0(r2.getScrollX(), this.b.getScrollY(), this.b.getScrollX(), this.b.getScrollY(), "scrollend");
    L6:
        if (this.b.isEnableScrollMonitor() == true) goto L8;
        return;
    L8:
        if (this.b.getLynxContext().getLynxViewClient() == null) goto L12;
        this.b.getLynxContext().getLynxViewClient().onScrollStop(new q1.b(this.a, this.b.getTagName(), this.b.getScrollMonitorTag()));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AndroidScrollView.b
    public final void onFling() {
        View r0 = UIScrollView.Q(this.b);
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.b.isEnableScrollMonitor() == false) goto L9;
        this.b.getLynxContext().getLynxViewClient().onFling(new q1.b(r0, this.b.getTagName(), this.b.getScrollMonitorTag()));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AndroidScrollView.b
    public final void onScrollStateChanged(int r6) {
        LLog.i("LynxUIScrollView", "onScrollStateChanged: " + r6);
        UIScrollView r0 = this.b;
        if (r0.j == true) goto L7;
        if (r6 == 0) goto L11;
        if (r6 == 3) goto L11;
        r0.recognizeGesturere();
    L11:
        UIScrollView r1 = this.b;
        if (r1.E == null) goto L18;
        if (r6 == 0) goto L15;
        return;
    L15:
        if (((AndroidScrollView) UIScrollView.R(r1)).P != 3) goto L20;
        UIScrollView r7 = this.b;
        Callback r2 = r7.E;
        String r3 = r7.F;
        r7.E = null;
        r7.F = NameKeys.UnloadStrategy_No_Strategy;
        r2.invoke(new Object[]{0, r3});
        return;
    L20:
        return;
    L18:
        return;
    L7:
        if (r6 != 1) goto L9;
    L10:
        r0.recognizeGesturere();
        goto L11
    L9:
        if (r6 != 4) goto L11;
        goto L10
    }

    public c(UIScrollView r1, AndroidScrollView r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // com.lynx.tasm.behavior.ui.scroll.AndroidScrollView.b
    public final void onScrollChanged(int r9, int r10, int r11, int r12) {
        UIScrollView r0 = this.b;
        if (r0.l == false) goto L5;
        UIScrollView.X(r0);
    L5:
        UIScrollView r2 = this.b;
        if (r2.g == false) goto L8;
        r2.B0(r9, r10, r11, r12, "scroll");
    L8:
        UIScrollView r13 = this.b;
        if (r13.d == false) goto L11;
    L12:
        int r14 = r13.G0(r9, r10, r13.s, r13.r);
        UIScrollView r1 = this.b;
        boolean r15 = true;
        if (r1.d == false) goto L26;
        if ((r14 & 2) == 0) goto L17;
        boolean r16 = true;
    L18:
        if (r16 == false) goto L26;
        if ((r1.t & 2) == 0) goto L22;
        boolean r17 = true;
    L23:
        if (r17 == true) goto L26;
        r1.B0(r1.getScrollX(), this.b.getScrollY(), this.b.getScrollX(), this.b.getScrollY(), "scrolltolower");
    L38:
        this.b.t = r14;
        return;
    L22:
        r17 = false;
        goto L23
    L17:
        r16 = false;
    L26:
        if (r1.b == false) goto L38;
        if ((r14 & 1) == 0) goto L30;
        boolean r18 = true;
    L31:
        if (r18 == false) goto L38;
        if ((r1.t & 1) != 0) goto L36;
        r15 = false;
    L36:
        if (r15 == true) goto L38;
        r1.B0(r1.getScrollX(), this.b.getScrollY(), this.b.getScrollX(), this.b.getScrollY(), "scrolltoupper");
        goto L38
    L30:
        r18 = false;
        goto L31
    L11:
        if (r13.b == true) goto L12;
    }
}
