package com.lynx.tasm.behavior;

import com.lynx.tasm.base.TraceController;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIShadowProxy;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f10272b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LynxBaseUI[] f10273c;
    public final /* synthetic */ UIShadowProxy d;
    public final /* synthetic */ y0 e;
    public final /* synthetic */ int f;
    public final /* synthetic */ n0 g;

    public /* synthetic */ k0(n0 r5, String r10, LynxBaseUI[] r11, UIShadowProxy r12, y0 r13, int r14, int r15) {
        this.f10271a = r15;
        this.g = r5;
        this.f10272b = r10;
        this.f10273c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10271a) {
            case 0: goto L15;
            default: goto L4;
        };
    L4:
        boolean r5 = TraceController.g;
        String r10 = this.f10272b;
        n0 r11 = this.g;
        if (r5 == false) goto L10;
        String r12 = ai.j0.C("UIOwner.AfterCreateViewAsync.", r10);
        if (r11.f10289c == null) goto L9;
        HashMap r13 = new HashMap();
        r13.put("instance_id", String.valueOf(r11.f10289c.A));
        TraceEvent.b(0, r12, r13);
    L11:
        LynxBaseUI[] r14 = this.f10273c;
        LynxBaseUI r15 = r14[0];
        UIShadowProxy r16 = this.d;
        y0 r17 = this.e;
        r14[0] = r11.b(r15, r16, r17);
        r11.G(r10);
        int r18 = this.f;
        r11.m(r18, r10, r17);
        r11.g.put(Integer.valueOf(r18), r14[0]);
        if (TraceController.g == false) goto L23;
        TraceEvent.a(0, r12);
        return;
    L23:
        return;
    L9:
        TraceEvent.c(r12);
        goto L11
    L10:
        r12 = null;
        goto L11
    L15:
        boolean r19 = TraceController.g;
        String r20 = this.f10272b;
        if (r19 == false) goto L18;
        String r21 = "UIOwner.AfterCreateAsyncViewRunnable." + r20;
        TraceEvent.c(r21);
    L19:
        LynxBaseUI[] r22 = this.f10273c;
        LynxBaseUI r23 = r22[0];
        UIShadowProxy r24 = this.d;
        n0 r25 = this.g;
        y0 r26 = this.e;
        r22[0] = r25.b(r23, r24, r26);
        r25.G(r20);
        int r110 = this.f;
        r25.m(r110, r20, r26);
        r25.g.put(Integer.valueOf(r110), r22[0]);
        if (TraceController.g == false) goto L24;
        TraceEvent.a(0, r21);
        return;
    L24:
        return;
    L18:
        r21 = null;
        goto L19
    }
}
