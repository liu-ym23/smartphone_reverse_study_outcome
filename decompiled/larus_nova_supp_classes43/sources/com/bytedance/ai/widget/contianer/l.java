package com.bytedance.ai.widget.contianer;

import com.bytedance.ai.model.objects.PageType;
import com.bytedance.ai.model.objects.Widget;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l implements k5.j {
    public final /* synthetic */ WidgetContainer a;
    public final /* synthetic */ Map<String, Object> b;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        WidgetContainer r0 = this.a;
        m r1 = r0.g;
        if (r1 == null) goto L10;
        r10.f = r1.a;
        r10.g = r1.b;
        Widget r11 = r0.x();
        if (r11 == null) goto L8;
        String r12 = r11.o;
        if (r12 == null) goto L8;
    L9:
        r10.f("renderType", r12);
        r10.f("botId", r1.d);
        r10.f("message_id", r1.e);
    L8:
        r12 = "";
    L10:
        r10.f("viewType", PageType.WIDGET_PAGE.toString());
        Map<String, ? extends Object> r13 = this.b;
        if (r13 == null) goto L14;
        r10.h(r13);
        return;
    }

    public l(WidgetContainer r1, Map<String, ? extends Object> r10) {
        this.a = r1;
        this.b = r10;
    }
}
