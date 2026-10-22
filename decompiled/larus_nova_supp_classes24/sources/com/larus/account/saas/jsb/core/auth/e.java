package com.larus.account.saas.jsb.core.auth;

import android.os.Bundle;
import b48.i;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.larus.account.saas.jsb.core.FlowAccountThirdPartyAuthCore;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e implements AuthorizeCallback {
    public final /* synthetic */ ActivityResultAuthProxyActivity a;
    public final /* synthetic */ x38.g<FlowAccountThirdPartyAuthCore.a> b;
    public final /* synthetic */ i.b c;

    public final void onError(AuthorizeErrorResponse r13) {
        this.a.b();
        com.larus.account.saas.runtime.internal.delegate.a r0 = com.larus.account.saas.runtime.internal.delegate.a.a;
        StringBuilder r1 = new StringBuilder("google auth error, errorCode=");
        String r2 = null;
        if (r13 == null) goto L5;
        String r3 = r13.platformErrorCode;
    L6:
        r1.append(r3);
        r1.append(", errorMsg=");
        if (r13 == null) goto L9;
        r2 = r13.platformErrorMsg;
    L9:
        r1.append(r2);
        r0.d("FlowAccountThirdPartyAuthCore", r1.toString());
        x38.g<FlowAccountThirdPartyAuthCore.a> r4 = this.b;
        String r5 = this.c.a;
        if (r13 == null) goto L16;
        String r14 = r13.platformErrorCode;
        if (r14 == null) goto L16;
        Integer r15 = StringsKt.toIntOrNull(r14);
        if (r15 == null) goto L16;
        int r16 = r15.intValue();
    L17:
        r4.onSuccess(new FlowAccountThirdPartyAuthCore.a("google", r5, null, null, null, "", null, Integer.valueOf(r16), 348));
        return;
    L16:
        r16 = -1;
        goto L17
    L5:
        r3 = null;
        goto L6
    }

    public final void onSuccess(Bundle r19) {
        this.a.b();
        String r2 = null;
        if (r19 == null) goto L5;
        String r3 = r19.getString("idToken");
    L6:
        String r4 = "";
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        boolean r6 = false;
        if (r3.length() != 0) goto L12;
        boolean r5 = true;
    L13:
        if (r5 == false) goto L21;
        if (r19 == null) goto L16;
        String r7 = r19.getString("id_token");
    L17:
        if (r7 == null) goto L20;
        r4 = r7;
    L20:
        String r14 = r4;
    L23:
        if (r19 != null) goto L25;
    L27:
        boolean r8 = false;
    L28:
        if (r8 == false) goto L32;
        r2 = String.valueOf(r19.getLong("expire_in"));
    L38:
        this.b.onSuccess(new FlowAccountThirdPartyAuthCore.a("google", this.c.a, null, null, null, r14, r2, null, 412));
        return;
    L32:
        if (r19 != null) goto L34;
    L36:
        if (r6 == false) goto L38;
        r2 = String.valueOf(r19.getLong("access_token_expiration_time"));
        goto L38
    L34:
        if (r19.containsKey("access_token_expiration_time") != true) goto L36;
        r6 = true;
        goto L36
    L25:
        if (r19.containsKey("expire_in") != true) goto L27;
        r8 = true;
        goto L28
    L16:
        r7 = null;
        goto L17
    L21:
        r14 = r3;
        goto L23
    L12:
        r5 = false;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    public e(ActivityResultAuthProxyActivity r1, x38.g<FlowAccountThirdPartyAuthCore.a> r2, i.b r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
