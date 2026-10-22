package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class q implements k5.j {
    public final /* synthetic */ String a;
    public final /* synthetic */ f b;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.f("auth_type", this.a);
        r10.f("app_key", this.b.c.a);
        r10.f("app_name", this.b.c.b);
        r10.f("message_id", this.b.c.f.a);
    }

    public q(String r1, f r10) {
        this.a = r1;
        this.b = r10;
    }
}
