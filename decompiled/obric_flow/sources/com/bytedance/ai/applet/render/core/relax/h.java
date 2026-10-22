package com.bytedance.ai.applet.render.core.relax;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.relax.RelaxView;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends i2.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference f1795c;
    public final l2.a d;

    public h(WeakReference r5, l2.a r10) {
        Intrinsics.checkNotNullParameter(r5, "relaxViewReference");
        Intrinsics.checkNotNullParameter(r10, "remoteMessageCache");
        this.f1795c = r5;
        this.d = r10;
    }

    public static final void e(h r5, j2.a r10) {
        RelaxView r11 = (RelaxView) r5.f1795c.get();
        if (r11 == null) goto L6;
        ProtocolMessage r12 = (ProtocolMessage) r10.f22372b;
        Intrinsics.checkNotNullParameter(r12, "value");
        r11.callRTSFunction("onWebViewMessage", z0.a.a().toJson(r12));
        return;
    }

    @Override // i2.c
    public final void a() {
        super.a();
        this.d.a();
        RelaxView r5 = (RelaxView) this.f1795c.get();
        if (r5 == null) goto L6;
        RelaxViewAIBridgePort$RTSInterface.release(r5);
        return;
    }

    @Override // i2.c
    public final void b(i2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "consumer");
        com.bytedance.ai.applet.render.core.lynx.c r10 = new com.bytedance.ai.applet.render.core.lynx.c(r5, 1);
        this.d.b(r10);
    }

    @Override // i2.c
    public final void d(j2.a r5) {
        Intrinsics.checkNotNullParameter(r5, "messageWrapper");
        c1.b.b(new a2.b(9, this, r5));
    }
}
