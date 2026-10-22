package com.larus.voicecall.impl.video;

import android.view.View;
import android.view.ViewGroup;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a0 implements f {
    public final /* synthetic */ y a;

    @Override // com.larus.voicecall.impl.video.f
    public final void onClick() {
        FLogger.a.d("ViewPortSwitcher", "onClick");
        Function0<Unit> r0 = this.a.i;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    @Override // com.larus.voicecall.impl.video.f
    public final void onDragStart() {
        FLogger.a.d("ViewPortSwitcher", "onDragStart");
    }

    public a0(y r1) {
        this.a = r1;
    }

    @Override // com.larus.voicecall.impl.video.f
    public final void f5(float r10, float r11) {
        FLogger r0 = FLogger.a;
        r0.d("ViewPortSwitcher", "onDragEnd, x = " + r10 + ", y = " + r11);
        y r1 = this.a;
        View r3 = r1.b;
        r1.getClass();
        int[] r2 = new int[2];
        r3.getLocationOnScreen(r2);
        View r4 = this.a.b;
        ViewGroup.LayoutParams r5 = r4.getLayoutParams();
        if (r5 == null) goto L7;
        ViewGroup.MarginLayoutParams r6 = (ViewGroup.MarginLayoutParams) r5;
        int r7 = r6.topMargin;
        int r8 = r6.leftMargin;
        int r9 = r6.getMarginStart();
        r6.topMargin = (int) ((r11 - r2[1]) + r7);
        int r12 = r2[0];
        r6.leftMargin = (int) ((r10 - r12) + r8);
        r6.setMarginStart((int) ((r10 - r12) + r9));
        r0.d("ViewPortSwitcher", "update place holder layout params: curTopMargin = " + r7 + ", curLeftMargin = " + r8 + ", curMarginStart = " + r9 + ", topMargin = " + r6.topMargin + ", leftMargin = " + r6.leftMargin + ", marginStart = " + r6.getMarginStart());
        r4.setLayoutParams(r6);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    }
}
