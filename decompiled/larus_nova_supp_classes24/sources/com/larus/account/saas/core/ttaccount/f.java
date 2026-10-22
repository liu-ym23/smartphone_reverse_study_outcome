package com.larus.account.saas.core.ttaccount;

import b48.g;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class f extends ua7.a<ua7.c> {
    public final /* synthetic */ b48.b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ x38.b c;

    public final void onResponse(ua7.b r11) {
        ua7.c r12 = (ua7.c) r11;
        if (r12 == null) goto L27;
        b48.b r0 = this.a;
        String r1 = this.b;
        x38.b r2 = this.c;
        if (((ua7.b) r12).c == false) goto L22;
        com.larus.account.saas.core.internal.a r13 = com.larus.account.saas.core.internal.a.a;
        String r14 = r0.c;
        if (r14 != null) goto L9;
    L15:
        CopyOnWriteArraySet r15 = com.larus.account.saas.core.internal.b.a;
        Intrinsics.checkNotNullParameter(r0, "info");
        Iterator r16 = com.larus.account.saas.core.internal.b.a.iterator();
    L17:
        if (r16.hasNext() == false) goto L19;
        ((x38.f) r16.next()).a(r1, r0);
        goto L17
    L19:
        if (r2 == null) goto L21;
        r2.b(new g(null));
    L21:
        JSONObject r17 = new JSONObject();
        r17.put("success", 1);
        r17.put("scene", r1);
        SaasTracking.a.reportEvent("doubao_account_logout_result", r17);
        return;
    L9:
        if ((!StringsKt.isBlank(r14)) == true) goto L12;
        r14 = null;
    L12:
        if (r14 == null) goto L15;
        com.larus.account.saas.core.internal.a.b.remove(r14);
        com.larus.account.saas.core.internal.a.c().remove("account_saas_user_info_".concat(r14));
        goto L15
    L22:
        if (r2 == null) goto L24;
        r2.a(new b48.c(((ua7.b) r12).h, ((ua7.b) r12).i));
    L24:
        JSONObject r3 = new JSONObject();
        r3.put("success", 0);
        r3.put("scene", r1);
        r3.put("err_code", String.valueOf(((ua7.b) r12).h));
        r3.put("err_msg", ((ua7.b) r12).j);
        r3.put("origin_err_code", String.valueOf(((ua7.b) r12).g));
        r3.put("origin_err_msg", ((ua7.b) r12).i);
        SaasTracking.a.reportEvent("doubao_account_logout_result", r3);
        return;
    }

    public f(b48.b r1, String r2, com.larus.account.saas.jsb.core.d r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
