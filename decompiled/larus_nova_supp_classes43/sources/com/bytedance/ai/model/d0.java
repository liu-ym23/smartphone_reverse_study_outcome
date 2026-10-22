package com.bytedance.ai.model;

import com.bytedance.ai.model.objects.LLMData;
import com.bytedance.ai.monitor.AppletMonitorableEvent;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d0 implements k5.j {
    public final /* synthetic */ LLMData a;
    public final /* synthetic */ String b;
    public final /* synthetic */ h5.g c;

    @Override // k5.j
    public final void a(AppletMonitorableEvent r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        LLMData r0 = this.a;
        if (r0 == null) goto L19;
        String r1 = r0.getMsgId();
        if (r1 == null) goto L7;
        r10.f("message_id", r1);
    L7:
        String r11 = r0.getRealJSONData();
        if (r11 == null) goto L10;
        r10.f("realJSONData", r11);
    L10:
        String r12 = r0.getQuestionId();
        if (r12 == null) goto L13;
        r10.f("questionId", r12);
    L13:
        Boolean r13 = r0.isSystemAgent();
        if (r13 == null) goto L16;
        r10.f("isSystemAgent", String.valueOf(r13.booleanValue()));
    L16:
        Boolean r14 = r0.getFinished();
        if (r14 == null) goto L19;
        r10.f("finished", String.valueOf(r14.booleanValue()));
    L19:
        r10.f("fromBotId", this.b);
        String r15 = this.c.i;
        if (r15 != null) goto L22;
        r15 = "";
    L22:
        r10.f("applet_id", r15);
    }

    public d0(LLMData r1, String r10, h5.g r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }
}
