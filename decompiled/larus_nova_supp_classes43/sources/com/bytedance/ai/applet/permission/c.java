package com.bytedance.ai.applet.permission;

import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import k5.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c implements j {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ AppletPermissionDetail c;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.f("current_page", "doubao_apps_detail");
        r10.f("auth_type", this.a);
        r10.f("app_key", this.b);
        String r0 = this.c.getAppletName();
        if (r0 != null) goto L5;
        r0 = this.b;
    L5:
        r10.f("app_name", r0);
    }

    public c(String r1, String r10, AppletPermissionDetail r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
