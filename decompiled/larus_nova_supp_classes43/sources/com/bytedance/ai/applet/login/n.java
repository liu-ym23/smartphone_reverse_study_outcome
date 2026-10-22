package com.bytedance.ai.applet.login;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n implements k5.j {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ u2.c d;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.f("current_page", this.a);
        r10.f("login_type", this.b);
        r10.f("success", this.c);
        r10.f("app_key", this.d.a);
        r10.f("app_name", this.d.b);
    }

    public n(String r1, String r10, String r11, u2.c r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
