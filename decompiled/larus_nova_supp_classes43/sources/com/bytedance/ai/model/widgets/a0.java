package com.bytedance.ai.model.widgets;

import com.lynx.tasm.q1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a0 extends q1 {
    public final /* synthetic */ LynxViewFloatingPage a;

    public final void onLynxViewAndJSRuntimeDestroy() {
        com.bytedance.ai.applet.base.log.a.a("LynxViewFloatingPage", "onLynxViewAndJSRuntimeDestroy");
        d3.w r0 = this.a.g;
        if (r0 == null) goto L15;
        e3.a r1 = r0.i;
        if (r1 == null) goto L15;
        c4.a r10 = c4.b.a(r1);
        if (r10 == null) goto L9;
        r10.f(r1);
    L9:
        d4.b r11 = d4.c.c(r1);
        if (r11 == null) goto L12;
        r11.b(r1);
    L12:
        com.bytedance.ai.bridge.method.net.download.a r12 = com.bytedance.ai.bridge.method.net.download.n.a(r1);
        if (r12 == null) goto L15;
        r12.i(r1);
    L15:
        d3.w r13 = this.a.g;
        if (r13 == null) goto L19;
        r13.g();
        return;
    }

    public a0(LynxViewFloatingPage r1) {
        this.a = r1;
    }
}
