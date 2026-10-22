package com.larus.common.account.platform.larkauth;

import a09.a;
import com.larus.applog.api.IApplog;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.utils.logger.FLogger;
import kotlin.Result;
import kotlin.Unit;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import org.json.JSONObject;
import ua7.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c extends sa7.h<xa7.c> {
    public final /* synthetic */ i<a> a;

    public c(j r1) {
        this.a = r1;
    }

    public final void onSuccess(b r11) {
        xa7.c r12 = (xa7.c) r11;
        IApplog.Companion r0 = IApplog.a;
        JSONObject r1 = new JSONObject();
        r1.put(FlowDoraConnectReason.SUCCESS, 1);
        Unit r2 = Unit.INSTANCE;
        r0.reportEvent("lark_auth_act_result", r1);
        if (r12 == null) goto L8;
        JSONObject r3 = r12.z;
        if (r3 == null) goto L8;
        String r4 = r3.optString("access_token");
        if (r4 == null) goto L8;
    L9:
        String r5 = r4;
        if (r12 == null) goto L15;
        JSONObject r6 = r12.z;
        if (r6 == null) goto L15;
        String r7 = r6.optString("auth_scheme");
        if (r7 == null) goto L15;
    L16:
        String r8 = r7;
        if (r12 == null) goto L21;
        JSONObject r13 = r12.z;
        if (r13 == null) goto L21;
        Long r14 = Long.valueOf(r13.optLong("expires_in"));
    L22:
        a r9 = new a(r5, r8, r14, Long.valueOf(System.currentTimeMillis()), null, 36);
        if (this.a.isActive() == false) goto L26;
        this.a.resumeWith(Result.constructor-impl(r9));
        return;
    L26:
        return;
    L21:
        r14 = null;
    L15:
        r7 = "DPoP";
    L8:
        r4 = "";
        goto L9
    }

    public final void onError(b r9, int r10) {
        xa7.c r11 = (xa7.c) r9;
        FLogger.a.e("LarkAuthTokenFetcher", "enterprise account get access token error: " + r10);
        IApplog.Companion r12 = IApplog.a;
        JSONObject r0 = new JSONObject();
        r0.put(FlowDoraConnectReason.SUCCESS, 0);
        r0.put("error_code", r10);
        Unit r1 = Unit.INSTANCE;
        r12.reportEvent("lark_auth_act_result", r0);
        if (this.a.isActive() == false) goto L6;
        i<a> r13 = this.a;
        Result.Companion r2 = Result.Companion;
        r13.resumeWith(Result.constructor-impl(new a(null, null, null, null, Integer.valueOf(r10), 31)));
        return;
    }
}
