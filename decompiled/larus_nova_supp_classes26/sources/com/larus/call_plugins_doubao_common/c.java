package com.larus.call_plugins_doubao_common;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.util.q;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements j {
    public final String f;

    public final boolean j3() {
        MajorState r0 = getContext().a().s1();
        if ((r0 instanceof MajorState.c) == false) goto L5;
    L9:
        return false;
    L5:
        if ((r0 instanceof MajorState.a) == true) goto L9;
        if ((r0 instanceof MajorState.f) == true) goto L9;
        return true;
    }

    public final String T2() {
        return this.f;
    }

    public final void e3() {
        super.e3();
    }

    public c(com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "CommonAuthPlugin";
    }

    @Override // com.larus.call_plugins_doubao_common.j
    public final void o2(RealtimeCallParam r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "extra");
        boolean r0 = j3();
        FLogger.a.d(this.f, "sendLocationAuthFailTrigger() called with: params = " + r6 + ", extra = " + r7 + ", canTriggerAuthEvent = " + r0);
        if (r0 == true) goto L5;
        return;
    L5:
        JSONObject r8 = q.a(r7);
        id9.d r9 = getContext().j();
        if (r9 == null) goto L13;
        TriggerMode r1 = TriggerMode.AUTH_DENY;
        if (r8 == null) goto L10;
        String r10 = r8.toString();
    L11:
        r9.p(r1, r10);
        return;
    L10:
        r10 = null;
        goto L11
    }

    @Override // com.larus.call_plugins_doubao_common.j
    public final void x1(RealtimeCallParam r6, String r7) {
        Intrinsics.checkNotNullParameter(r6, "params");
        Intrinsics.checkNotNullParameter(r7, "extra");
        boolean r0 = j3();
        FLogger.a.d(this.f, "sendLocationAuthSucceedTrigger() called with: params = " + r6 + ", extra = " + r7 + ", canTriggerAuthEvent: " + r0);
        if (r0 == true) goto L5;
        return;
    L5:
        JSONObject r8 = q.a(r7);
        id9.d r9 = getContext().j();
        if (r9 == null) goto L13;
        TriggerMode r1 = TriggerMode.AUTH_SUCCESS;
        if (r8 == null) goto L10;
        String r10 = r8.toString();
    L11:
        r9.p(r1, r10);
        return;
    L10:
        r10 = null;
        goto L11
    }

    @Override // com.larus.call_plugins_doubao_common.j
    public final void V0(RealtimeCallParam r6, String r7, String r8) {
        Intrinsics.checkNotNullParameter(r6, "params");
        boolean r0 = j3();
        FLogger.a.d(this.f, "sendAuthDenyTrigger() called with: params = " + r6 + ", refuseText = " + r7 + ", questionId = " + r8 + ", canTriggerAuthEvent: " + r0);
        if (r0 == true) goto L5;
        return;
    L5:
        JSONObject r9 = new JSONObject();
        r9.putOpt("vui_auth_refuse_text", r7);
        r9.putOpt("vui_auth_question_id", r8);
        id9.d r10 = getContext().j();
        if (r10 == null) goto L9;
        r10.p(TriggerMode.AUTH_DENY, r9.toString());
        return;
    }

    @Override // com.larus.call_plugins_doubao_common.j
    public final void Y1(RealtimeCallParam r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r5, "params");
        FLogger.a.d(this.f, "sendAuthSuccessTrigger() called with: params = " + r5 + ", questionId = " + r6 + ", answerId = " + r7);
        JSONObject r8 = new JSONObject();
        r8.put("vui_auth_question_id", r6);
        r8.put("vui_auth_answer_id", r7);
        id9.d r9 = getContext().j();
        if (r9 == null) goto L6;
        r9.p(TriggerMode.AUTH_SUCCESS, r8.toString());
        return;
    }
}
