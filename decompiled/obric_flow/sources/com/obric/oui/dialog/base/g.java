package com.obric.oui.dialog.base;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13120a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f13121b;

    public /* synthetic */ g(j r5, int r10) {
        this.f13120a = r10;
        this.f13121b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f13120a) {
            case 0: goto L25;
            case 1: goto L9;
            default: goto L4;
        };
    L4:
        final com.obric.oui.dialog.v2.alert.f r10 = (com.obric.oui.dialog.v2.alert.f) this.f13121b;
        Intrinsics.checkNotNullParameter(r10, "this$0");
        com.obric.oui.animation.easy.d r5 = com.obric.oui.dialog.anim.d.d(r10.getDialogRootView(), null, false, 0.0f, r10.getUseNewDialogAnim(), 4);
        r5.e();
        if (r10.f13130i == false) goto L7;
        r5.c(new AbstractDialogModal$performEnterAnimation$1$1(r10), new AbstractDialogModal$performEnterAnimation$1$2(r10), new AbstractDialogModal$performEnterAnimation$1$3(r10));
        return;
    L7:
        com.obric.oui.animation.easy.d.d(r5, new AbstractDialogModal$performEnterAnimation$1$4(r10), new AbstractDialogModal$performEnterAnimation$1$5(r10));
        return;
    L9:
        j r11 = this.f13121b;
        Intrinsics.checkNotNullParameter(r11, "this$0");
        Size r12 = com.lynx.tasm.utils.j.n(r11.getContext());
        ViewGroup.LayoutParams r13 = r11.getDialogRootView().getLayoutParams();
        if ((r13 instanceof FrameLayout.LayoutParams) == false) goto L12;
        FrameLayout.LayoutParams r14 = (FrameLayout.LayoutParams) r13;
    L13:
        int r15 = -2;
        if (r14 != null) goto L16;
        r14 = new FrameLayout.LayoutParams(-2, -2);
    L16:
        int r16 = Math.min(r12.getWidth(), r12.getHeight()) - (r11.getLayoutMarginHorizontal() * 2);
        r14.width = r16;
        Integer r17 = r11.f13137p;
        if (r17 == null) goto L20;
        r15 = r17.intValue();
    L20:
        r14.height = r15;
        r14.gravity = 81;
        r11.getDialogRootView().measure(View.MeasureSpec.makeMeasureSpec(r16, Integer.MIN_VALUE), 0);
        if (r12.getWidth() >= r12.getHeight()) goto L23;
        int r18 = r12.getHeight() - com.lynx.tasm.utils.a.p(232, r11.getContext());
        r11.f13133l = Math.max(0, r11.getDialogRootView().getMeasuredHeight() - r18);
    L23:
        r11.getDialogRootView().setLayoutParams(r14);
        return;
    L12:
        r14 = null;
        goto L13
    L25:
        j r19 = this.f13121b;
        Intrinsics.checkNotNullParameter(r19, "this$0");
        com.lynx.tasm.utils.d.s(r19.getDimView());
    }
}
