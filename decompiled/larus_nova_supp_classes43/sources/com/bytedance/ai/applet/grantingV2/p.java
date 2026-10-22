package com.bytedance.ai.applet.grantingV2;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class p implements k5.j {
    public final /* synthetic */ String a;
    public final /* synthetic */ f b;
    public final /* synthetic */ String c;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.f("click_from", this.a);
        r10.f("app_key", this.b.c.a);
        r10.f("app_name", this.b.c.b);
        r10.f("message_id", this.b.c.f.a);
        r10.f(com.bytedance.android.ec.core.event.a.KEY_CARD_TYPE, this.c);
    }

    public p(String r1, f r10, String r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
