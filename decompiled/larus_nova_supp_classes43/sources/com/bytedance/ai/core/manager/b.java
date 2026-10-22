package com.bytedance.ai.core.manager;

import com.bytedance.ai.model.AppletRuntime;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import k5.j;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements j {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ long d;
    public final /* synthetic */ Ref.ObjectRef<AppletRuntime> e;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        r10.f = this.a;
        String r0 = this.b;
        if (r0 == null) goto L5;
        r10.f("message_id", r0);
    L5:
        String r1 = this.c;
        if (r1 == null) goto L8;
        r10.f("replyFor", r1);
    L8:
        r10.d("isNew", 1);
        r10.e("cost", this.d);
        if (this.e.element == null) goto L11;
        r10.f("content", "update applet from debug");
    L11:
        r10.g("success", true);
    }

    public b(String r1, String r10, String r11, long r12, Ref.ObjectRef<AppletRuntime> r13) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
    }
}
