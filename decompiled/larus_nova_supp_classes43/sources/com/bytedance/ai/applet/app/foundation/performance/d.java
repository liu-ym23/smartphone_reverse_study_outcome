package com.bytedance.ai.applet.app.foundation.performance;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements k5.j {
    public final /* synthetic */ Map<String, Object> a;

    public d(Map<String, ? extends Object> r1) {
        this.a = r1;
    }

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.h(this.a);
    }
}
