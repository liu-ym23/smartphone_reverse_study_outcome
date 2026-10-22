package com.larus.voicecall.impl.component.feedback;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.praise.IAiChatPraiseTriggerService;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import hq9.n3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q implements o99.a {
    public final /* synthetic */ RealtimeCallFeedbackComponent a;

    public final void d() {
    }

    public final void e(q99.d r1) {
    }

    public final void i() {
    }

    public final void h() {
        RealtimeCallFeedbackComponent r0 = this.a;
        int r1 = RealtimeCallFeedbackComponent.u;
        v.b(r0.m3().e);
    }

    public q(RealtimeCallFeedbackComponent r1) {
        this.a = r1;
    }

    public final Bundle b(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "bundle");
        Intrinsics.checkNotNullParameter(r2, "bundle");
        return r2;
    }

    public final n3 f(n3 r2) {
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        Intrinsics.checkNotNullParameter(r2, "originalRequest");
        return r2;
    }

    public final void a(q99.m r2, q99.l r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "error");
    }

    public final void c(q99.e r1, q99.a r2) {
        o99.a.a.a(r1, r2);
    }

    public final void g(q99.m r2, q99.n r3) {
        Intrinsics.checkNotNullParameter(r2, "request");
        Intrinsics.checkNotNullParameter(r3, "result");
    }

    public final void j(q99.e r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r6, "delivery");
        if (r7 == false) goto L21;
        IAiChatPraiseTriggerService r8 = (IAiChatPraiseTriggerService) ServiceManager.get().getService(IAiChatPraiseTriggerService.class);
        if (r8 != null) goto L7;
    L9:
        boolean r9 = false;
    L10:
        if (r9 == true) goto L12;
    L20:
        t19.s r10 = t19.s.a;
        Context r1 = this.a.getContext();
        r10.getClass();
        t19.s.o(r1, 2131901665, false);
        goto L21
    L12:
        if (u.a().getBoolean("shown_end_call_praise_dialog", false) == true) goto L20;
        FLogger r11 = FLogger.a;
        StringBuilder r0 = new StringBuilder("[onNotificationClicked]: tryShowPraiseDialog, callId = ");
        RealtimeCallFeedbackComponent r3 = this.a;
        int r4 = RealtimeCallFeedbackComponent.u;
        r0.append(r3.m3().e);
        r11.i("RealtimeCallFeedbackComponent", r0.toString());
        IAiChatPraiseTriggerService r12 = (IAiChatPraiseTriggerService) ServiceManager.get().getService(IAiChatPraiseTriggerService.class);
        if (r12 == null) goto L19;
        String r2 = this.a.m3().e;
        if (r2 != null) goto L18;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L18:
        IAiChatPraiseTriggerService.a.a(r12, r2, "phone_call", 8);
    L19:
        u.a().storeBoolean("shown_end_call_praise_dialog", true);
        goto L21
    L7:
        if (r8.a() != true) goto L9;
        r9 = true;
    L21:
        RealtimeCallFeedbackComponent r13 = this.a;
        int r5 = RealtimeCallFeedbackComponent.u;
        String r14 = r13.m3().e;
        if (r7 == false) goto L24;
        String r15 = "like";
    L25:
        v.a(r14, r15);
        return;
    L24:
        r15 = "dislike";
        goto L25
    }
}
