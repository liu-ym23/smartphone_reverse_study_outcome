package com.bytedance.ai.bridge.method.net.download;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements k5.j {
    public final /* synthetic */ a.j a;
    public final /* synthetic */ long b;
    public final /* synthetic */ a.b c;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.e("file_size", this.a.c);
        r10.e(com.bytedance.android.ec.core.event.a.KEY_DURATION, this.b);
        r10.f("applet_id", this.c.b.a);
        r10.f("container_type", this.c.c);
        r10.d("status_code", this.a.a);
    }

    public k(a.j r1, long r10, a.b r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
