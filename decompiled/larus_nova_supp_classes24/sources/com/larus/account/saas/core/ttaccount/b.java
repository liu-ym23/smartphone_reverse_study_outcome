package com.larus.account.saas.core.ttaccount;

import com.larus.account.saas.FlowAccountSdk;
import com.larus.account.saas.model.AccountLoginType;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import wb7.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b extends yb7.f {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ String b;
    public final /* synthetic */ x38.c c;

    public final void b(ua7.e<j> r6) {
        if (this.a == false) goto L6;
        v38.a.a();
    L6:
        if (r6 == null) goto L14;
        j r1 = r6.p;
        if (r1 == null) goto L14;
        com.ss.android.account.d r2 = r1.e;
        if (r2 == null) goto L14;
        if (((sc7.a) r2).g != true) goto L14;
        boolean r3 = true;
    L15:
        JSONObject r4 = new JSONObject();
        r4.put("type", "phone_verify_code");
        r4.put("success", 1);
        SaasTracking.a.reportEvent("doubao_account_login_result", r4);
        if (r6 == null) goto L23;
        j r7 = r6.p;
        if (r7 == null) goto L23;
        com.ss.android.account.d r8 = r7.e;
        if (r8 == null) goto L23;
        String r9 = Long.valueOf(((sc7.a) r8).a).toString();
        if (r9 == null) goto L23;
    L24:
        CopyOnWriteArraySet r0 = com.larus.account.saas.core.internal.b.a;
        Intrinsics.checkNotNullParameter(r9, "uid");
        Iterator r5 = com.larus.account.saas.core.internal.b.a.iterator();
    L26:
        if (r5.hasNext() == false) goto L28;
        ((x38.f) r5.next()).d(r9);
        goto L26
    L28:
        this.c.b(new b48.f(Boolean.valueOf(r3), FlowAccountSdk.f().getAccountInfo(), AccountLoginType.SMS, this.b));
        return;
    L23:
        r9 = "";
    L14:
        r3 = false;
        goto L15
    }

    public final /* bridge */ /* synthetic */ void onSuccess(ua7.b r1) {
        b((ua7.e) r1);
    }

    public b(boolean r1, com.larus.account.saas.jsb.core.f r2) {
        this.a = r1;
        this.b = "mobile_sms_login_jsb";
        this.c = r2;
    }

    public final void a(ua7.e<j> r6, int r7) {
        if (this.a == false) goto L5;
        v38.a.a();
    L5:
        x38.c r0 = this.c;
        String r2 = null;
        if (r6 == null) goto L8;
        String r3 = ((ua7.b) r6).i;
    L9:
        String r4 = "";
        if (r3 != null) goto L16;
        if (r6 == null) goto L13;
        r3 = ((ua7.b) r6).j;
    L14:
        if (r3 != null) goto L16;
        r3 = "";
        goto L16
    L13:
        r3 = null;
    L16:
        r0.a(new b48.c(r7, r3));
        JSONObject r1 = new JSONObject();
        r1.put("type", "phone_verify_code");
        r1.put("success", 0);
        r1.put("err_code", r7);
        if (r6 == null) goto L19;
        r2 = ((ua7.b) r6).i;
    L19:
        if (r2 == null) goto L22;
        r4 = r2;
    L22:
        r1.put("err_tips", r4);
        SaasTracking.a.reportEvent("doubao_account_login_result", r1);
        return;
    L8:
        r3 = null;
        goto L9
    }

    public final /* bridge */ /* synthetic */ void onError(ua7.b r1, int r2) {
        a((ua7.e) r1, r2);
    }
}
