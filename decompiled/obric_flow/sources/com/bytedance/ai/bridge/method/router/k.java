package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.ContainerType;
import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.model.objects.Applet;
import com.bytedance.ai.model.objects.PageInfo;
import com.bytedance.ai.monitor.AppletMonitorableEvent$EventOrigin;
import com.google.gson.JsonElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements z2.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n1.c f1961a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsOpenPageMethodIDL.OpenPageParamModel f1962b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AppletRuntime f1963c;
    public final /* synthetic */ PageInfo d;

    public k(n1.c r5, AbsOpenPageMethodIDL.OpenPageParamModel r10, AppletRuntime r11, PageInfo r12) {
        this.f1961a = r5;
        this.f1962b = r10;
        this.f1963c = r11;
        this.d = r12;
    }

    @Override // z2.g
    public final void b(z2.f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        m1.j r10 = (m1.j) ((n1.a) this.f1961a).b(m1.j.class);
        String r11 = null;
        if (r10 == null) goto L5;
        ContainerType r12 = r10.d();
    L7:
        if (r12 != ContainerType.d) goto L9;
        AppletMonitorableEvent$EventOrigin r13 = AppletMonitorableEvent$EventOrigin.f2386c;
    L10:
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r5.f23385c = r13;
        JsonElement r14 = this.f1962b.getContext().get("msgId");
        if (r14 == null) goto L15;
        String r15 = r14.getAsString();
        if (r15 == null) goto L15;
        r5.c("message_id", r15);
    L15:
        AppletRuntime r16 = this.f1963c;
        Applet r17 = r16.f2197h;
        if (r17 == null) goto L18;
        String r18 = r17.i();
    L19:
        r5.f = r18;
        Applet r19 = r16.f2197h;
        if (r19 == null) goto L22;
        r11 = r19.i();
    L22:
        r5.g = r11;
        r5.e(this.d.buildMonitorEvent());
        return;
    L18:
        r18 = null;
        goto L19
    L9:
        r13 = AppletMonitorableEvent$EventOrigin.d;
        goto L10
    L5:
        r12 = null;
        goto L7
    }
}
