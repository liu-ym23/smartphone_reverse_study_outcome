package com.bytedance.ai.applet.page;

import com.bytedance.ai.bridge.method.net.download.n;
import com.bytedance.ai.event.MessageIndication;
import com.lynx.tasm.q1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l extends q1 {
    public final /* synthetic */ AppletPageFragment a;

    public final void onLynxViewAndJSRuntimeDestroy() {
        com.bytedance.ai.applet.base.log.d r0 = this.a.d;
        r0.getClass();
        Intrinsics.checkNotNullParameter("onLynxViewAndJSRuntimeDestroy", MessageIndication.MESSAGE_TYPE_MSG);
        com.bytedance.ai.applet.base.log.b r1 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.a(r0.a, r0.b("onLynxViewAndJSRuntimeDestroy"));
        e3.a r10 = this.a.o.i;
        c4.a r11 = c4.b.a(r10);
        if (r11 == null) goto L5;
        r11.f(r10);
    L5:
        d4.b r12 = d4.c.c(r10);
        if (r12 == null) goto L8;
        r12.b(r10);
    L8:
        com.bytedance.ai.bridge.method.net.download.a r13 = n.a(r10);
        if (r13 == null) goto L11;
        r13.i(r10);
    L11:
        this.a.o.g();
    }

    public l(AppletPageFragment r1) {
        this.a = r1;
    }
}
