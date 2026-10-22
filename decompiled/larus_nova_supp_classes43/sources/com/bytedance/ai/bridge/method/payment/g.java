package com.bytedance.ai.bridge.method.payment;

import com.bytedance.ai.monitor.AppletMonitorableEvent;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g implements k5.j {
    public final /* synthetic */ String a;
    public final /* synthetic */ Map<String, Object> b;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.f("current_page", this.a);
        Iterator<Map.Entry<String, Object>> r0 = this.b.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L12;
        Map.Entry<String, Object> r1 = r0.next();
        String r11 = r1.getKey();
        Object r12 = r1.getValue();
        if ((r12 instanceof String) == false) goto L8;
        String r13 = (String) r12;
    L9:
        if (r13 != null) goto L11;
        r13 = "";
    L11:
        r10.f(r11, r13);
        goto L4
    L8:
        r13 = null;
        goto L9
    }

    public g(String r1, Map<String, ? extends Object> r10) {
        this.a = r1;
        this.b = r10;
    }
}
