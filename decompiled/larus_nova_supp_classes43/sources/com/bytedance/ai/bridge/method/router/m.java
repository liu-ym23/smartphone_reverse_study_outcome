package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import com.google.gson.JsonElement;
import d3.a0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class m implements k5.j {
    public final /* synthetic */ e3.d a;
    public final /* synthetic */ AbsOpenPageMethodIDL.a b;
    public final /* synthetic */ AppletRuntime c;
    public final /* synthetic */ PageInfo d;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        a0 r0 = this.a.getContainerContext();
        String r1 = null;
        if (r0 == null) goto L5;
        ContainerType r11 = r0.getContainerType();
    L7:
        if (r11 != ContainerType.WORKER) goto L9;
        AppletMonitorableEvent.EventOrigin r12 = AppletMonitorableEvent.EventOrigin.MainJS;
    L10:
        r10.m(r12);
        JsonElement r13 = this.b.getContext().get("msgId");
        if (r13 == null) goto L15;
        String r14 = r13.getAsString();
        if (r14 == null) goto L15;
        r10.f("message_id", r14);
    L15:
        AppletRuntime r15 = this.c;
        if (r15 == null) goto L20;
        Applet r16 = r15.h;
        if (r16 == null) goto L20;
        String r17 = r16.o();
    L21:
        r10.f = r17;
        AppletRuntime r18 = this.c;
        if (r18 == null) goto L26;
        Applet r19 = r18.h;
        if (r19 == null) goto L26;
        r1 = r19.o();
    L26:
        r10.g = r1;
        r10.h(this.d.buildMonitorEvent());
        return;
    L20:
        r17 = null;
        goto L21
    L9:
        r12 = AppletMonitorableEvent.EventOrigin.UI;
        goto L10
    L5:
        r11 = null;
        goto L7
    }

    public m(e3.d r1, AbsOpenPageMethodIDL.a r10, AppletRuntime r11, PageInfo r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
