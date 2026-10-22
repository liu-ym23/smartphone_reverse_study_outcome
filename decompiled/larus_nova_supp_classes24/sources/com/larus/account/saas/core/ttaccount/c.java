package com.larus.account.saas.core.ttaccount;

import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import org.json.JSONObject;
import wb7.k;
import x38.h;
import yb7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends j {
    public final /* synthetic */ h a;
    public final /* synthetic */ boolean b;

    public final void b(ua7.e<k> r4) {
        this.a.onSendSuccess();
        JSONObject r5 = new JSONObject();
        boolean r0 = this.b;
        r5.put("success", 1);
        r5.put("resend", r0 ? 1 : 0);
        SaasTracking.a.reportEvent("doubao_account_login_send_code_result", r5);
    }

    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r1) {
        b((ua7.e) r1);
    }

    public c(com.larus.account.saas.jsb.core.e r1, boolean r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(ua7.e<k> r6, int r7) {
        h r0 = this.a;
        String r1 = null;
        if (r6 == null) goto L6;
        String r2 = ((ua7.b) r6).i;
        if (r2 == null) goto L6;
    L9:
        r0.a(r7, r2);
        JSONObject r3 = new JSONObject();
        boolean r4 = this.b;
        r3.put("success", 0);
        r3.put("resend", r4 ? 1 : 0);
        r3.put("err_code", r7);
        if (r6 == null) goto L12;
        r1 = ((ua7.b) r6).i;
    L12:
        if (r1 == null) goto L14;
        r3.put("err_tips", ((ua7.b) r6).i);
    L14:
        SaasTracking.a.reportEvent("doubao_account_login_send_code_result", r3);
        return;
    L6:
        if (r6 == null) goto L8;
        r2 = ((ua7.b) r6).j;
        goto L9
    L8:
        r2 = null;
        goto L9
    }

    public final /* bridge */ /* synthetic */ void onError(ua7.b r1, int r2) {
        a((ua7.e) r1, r2);
    }
}
