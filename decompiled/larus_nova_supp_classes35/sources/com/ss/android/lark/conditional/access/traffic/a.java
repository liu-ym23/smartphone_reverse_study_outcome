package com.ss.android.lark.conditional.access.traffic;

import com.bytedance.lark.pb.basic.v1.PushReqRegulateResponse;
import com.google.gson.Gson;
import com.ss.android.lark.conditional.access.network.model.response.DecisionData;
import com.ss.android.lark.passportc.api.g;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.security.compliance.api.model.filepolicy.SecurityAction;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import java.util.LinkedList;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Singleton
public final class a implements g {
    public final j a;
    public final jdb.e b;

    /* JADX INFO: renamed from: com.ss.android.lark.conditional.access.traffic.a$a, reason: collision with other inner class name */
    public static final class C0158a {
    }

    static {
    }

    public final void afterUserChanged(f0c.g r1, f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "currentState");
    }

    public final void afterUserOffline(f0c.e r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.f r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserChanged(f0c.g r1, f0c.b r2) {
        Intrinsics.checkNotNullParameter(r2, "currentState");
    }

    public final void onUserOffline(f0c.e r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.f r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final j getPassport() {
        return this.a;
    }

    @Inject
    public a(j r2, jdb.e r3) {
        Intrinsics.checkNotNullParameter(r2, "passport");
        Intrinsics.checkNotNullParameter(r3, "fgService");
        this.a = r2;
        this.b = r3;
    }

    public static final void a(a r17, byte[] r18) {
        r17.getClass();
        if (r18 != null) goto L5;
        ScsLogger.c("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "onPushReqRegulate: payload = null!");     // Catch: Exception -> L51
        return;
    L5:
        PushReqRegulateResponse r8 = (PushReqRegulateResponse) PushReqRegulateResponse.ADAPTER.decode(r18);     // Catch: Exception -> L51
        if (r8 != null) goto L8;
        int r0 = ScsLogger.a;     // Catch: Exception -> L51
        ScsLogger.e("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "onPushReqRegulate, response is empty, payload:" + r18);     // Catch: Exception -> L51
        return;
    L8:
        int r1 = ScsLogger.a;     // Catch: Exception -> L51
        ScsLogger.d("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "[start receive push], onPushReqRegulate, x_lsc_code:" + r8.x_lsc_code + ", [logId:" + r8.x_tt_logid + "],x_lsc_bizid:" + r8.x_lsc_bizid + ", response.user_id:" + r8.x_user_id);     // Catch: Exception -> L51
        Long r2 = r8.x_user_id;     // Catch: Exception -> L51
        if (r2 == null) goto L16;
        if (r2.longValue() <= 0) goto L16;
        if (Intrinsics.areEqual(r8.x_user_id.toString(), r17.a.g()) == true) goto L16;
        ScsLogger.e("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "response.x_user_id != passport.foregroundUid");     // Catch: Exception -> L51
        return;
    L16:
        if (r17.a.d().b.a == UserState.ONLINE) goto L18;
        ScsLogger.e("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "passport.foregroundState.statePayload.state != UserState.ONLINE");     // Catch: Exception -> L51
        return;
    L18:
        Integer r3 = r8.x_lsc_code;     // Catch: Exception -> L51
        if (r3 != null) goto L22;
    L49:
        ScsLogger.e("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "onPushReqRegulate, response is not conditional access, x_lsc_code:" + r8.x_lsc_code);     // Catch: Exception -> L51
        return;
    L22:
        if (r3.intValue() != 100000) goto L49;
        ByteString r4 = r8.x_lsc_decision;     // Catch: Exception -> L51
        if (r4 == null) goto L29;
        String r5 = r4.utf8();     // Catch: Exception -> L51
        if (r5 == null) goto L29;
    L28:
        String r10 = r5;
        DecisionData r6 = (DecisionData) new Gson().fromJson(r10, DecisionData.class);     // Catch: Exception -> L51
        ScsLogger.d("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "[end receive push], onPushReqRegulate, decision:" + r10);     // Catch: Exception -> L51
        if (r6 == null) goto L33;
        LinkedList<DecisionData.Action> r7 = r6.getActions();     // Catch: Exception -> L51
    L34:
        int r9 = 0;
        if (r7 != null) goto L37;
    L40:
        boolean r11 = true;
    L41:
        if (r11 == true) goto L43;
        InternalSecurityAction r12 = new InternalSecurityAction(new SecurityAction(r10, null, 0, 0, 14, null), r6.getActions().get(0), r6.getActions());     // Catch: Exception -> L51
        r12.getInternalParams().put("SDK_MONITOR_TT_LOG_ID", r8.x_tt_logid);     // Catch: Exception -> L51
        RegulateDispatcher.a(r12, "RESPONSE_HEADER");     // Catch: Exception -> L51
        return;
    L43:
        StringBuilder r13 = new StringBuilder("onPushReqRegulate, action:");     // Catch: Exception -> L51
        if (r6 == null) goto L48;
        LinkedList<DecisionData.Action> r14 = r6.getActions();     // Catch: Exception -> L51
        if (r14 == null) goto L48;
        r9 = r14.size();     // Catch: Exception -> L51
    L48:
        r13.append(r9);     // Catch: Exception -> L51
        r13.append(", decision:");     // Catch: Exception -> L51
        r13.append(r10);     // Catch: Exception -> L51
        ScsLogger.e("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", r13.toString());     // Catch: Exception -> L51
        return;
    L37:
        if (r7.isEmpty() == true) goto L40;
        r11 = false;
        goto L41
    L33:
        r7 = null;
    L29:
        r5 = new DecisionData().toString();     // Catch: Exception -> L51
    L51:
        e = move-exception;
        int r15 = ScsLogger.a;
        ScsLogger.c("SecurityPolicy_GlobalScopeRegulateNetworkTrafficPush", "onPushReqRegulate, encounter exception:" + e);
    }
}
