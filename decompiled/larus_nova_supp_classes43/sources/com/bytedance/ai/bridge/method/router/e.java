package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.utils.ConvertUtils;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e implements k5.j {
    public final /* synthetic */ AbsCreateWidgetMethodIDL.a a;
    public final /* synthetic */ AppletRuntime b;
    public final /* synthetic */ String c;
    public final /* synthetic */ PageInfo d;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.m(AppletMonitorableEvent.EventOrigin.MainJS);
        String r0 = ConvertUtils.toJavaOnlyMap(this.a.getContext()).getString("msgId", null);
        if (r0 == null) goto L5;
        r10.f("message_id", r0);
    L5:
        r10.f = this.b.h.o();
        r10.g = this.c;
        r10.h(this.d.buildMonitorEvent());
    }

    public e(AbsCreateWidgetMethodIDL.a r1, AppletRuntime r10, String r11, PageInfo r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
