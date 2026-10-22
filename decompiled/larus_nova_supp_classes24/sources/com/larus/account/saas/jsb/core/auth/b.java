package com.larus.account.saas.jsb.core.auth;

import android.os.Bundle;
import b48.i;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.larus.account.saas.jsb.core.FlowAccountThirdPartyAuthCore;
import kotlin.text.StringsKt;
import y38.u;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class b implements AuthorizeCallback {
    public final /* synthetic */ x38.g<FlowAccountThirdPartyAuthCore.a> a;
    public final /* synthetic */ i.a b;

    public final void onError(AuthorizeErrorResponse r13) {
        com.larus.account.saas.runtime.internal.delegate.a r0 = com.larus.account.saas.runtime.internal.delegate.a.a;
        StringBuilder r1 = new StringBuilder("douyin auth error, errorCode=");
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
        x38.g<FlowAccountThirdPartyAuthCore.a> r4 = this.a;
        String r5 = this.b.a;
        if (r13 == null) goto L16;
        String r14 = r13.platformErrorCode;
        if (r14 == null) goto L16;
        Integer r15 = StringsKt.toIntOrNull(r14);
        if (r15 == null) goto L16;
        int r16 = r15.intValue();
    L17:
        r4.onSuccess(new FlowAccountThirdPartyAuthCore.a("douyin", r5, "", null, null, null, null, Integer.valueOf(r16), 376));
        return;
    L16:
        r16 = -1;
        goto L17
    L5:
        r3 = null;
        goto L6
    }

    public final void onSuccess(Bundle r12) {
        if (r12 == null) goto L4;
        String r13 = r12.getString("auth_code");
    L5:
        if (r13 != null) goto L7;
        r13 = "";
    L7:
        String r3 = r13;
        this.a.onSuccess(new FlowAccountThirdPartyAuthCore.a("douyin", this.b.a, r3, null, null, null, null, null, 504));
        return;
    L4:
        r13 = null;
        goto L5
    }

    public b(u r1, i.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
