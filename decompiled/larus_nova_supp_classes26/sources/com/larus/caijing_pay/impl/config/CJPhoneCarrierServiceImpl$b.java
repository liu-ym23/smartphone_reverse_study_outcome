package com.larus.caijing_pay.impl.config;

import android.os.Bundle;
import ce4.a;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;
import com.bytedance.sdk.account.platform.base.OnekeyLoginErrorResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CJPhoneCarrierServiceImpl$b implements AuthorizeCallback {
    public final /* synthetic */ a a;

    public CJPhoneCarrierServiceImpl$b(a r1) {
        this.a = r1;
    }

    public final void onError(AuthorizeErrorResponse r7) {
        a r0 = this.a;
        if ((r7 instanceof OnekeyLoginErrorResponse) == false) goto L5;
        OnekeyLoginErrorResponse r2 = (OnekeyLoginErrorResponse) r7;
    L6:
        if (r2 == null) goto L8;
        String r3 = r2.netType;
    L10:
        if (r7 == null) goto L12;
        String r5 = r7.platformErrorCode;
    L13:
        if (r7 == null) goto L15;
        String r8 = r7.platformErrorMsg;
    L16:
        r0.onResult(null, r3, null, r5, r8);
        return;
    L15:
        r8 = null;
        goto L16
    L12:
        r5 = null;
        goto L13
    L8:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public final void onSuccess(Bundle r7) {
        a r0 = this.a;
        if (r7 == null) goto L5;
        String r2 = r7.getString("access_token");
    L6:
        if (r7 == null) goto L8;
        String r8 = r7.getString("net_type");
    L9:
        r0.onResult(r2, r8, null, null, null);
        return;
    L8:
        r8 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }
}
