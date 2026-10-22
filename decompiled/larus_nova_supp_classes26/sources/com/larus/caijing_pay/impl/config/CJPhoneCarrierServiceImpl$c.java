package com.larus.caijing_pay.impl.config;

import android.os.Bundle;
import ce4.b;
import com.bytedance.sdk.account.platform.base.AuthorizeCallback;
import com.bytedance.sdk.account.platform.base.AuthorizeErrorResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CJPhoneCarrierServiceImpl$c implements AuthorizeCallback {
    public final /* synthetic */ b a;

    public CJPhoneCarrierServiceImpl$c(b r1) {
        this.a = r1;
    }

    public final void onError(AuthorizeErrorResponse r4) {
        b r0 = this.a;
        if (r4 == null) goto L5;
        String r2 = r4.platformErrorCode;
    L6:
        if (r4 == null) goto L8;
        String r5 = r4.platformErrorMsg;
    L9:
        r0.onResult(null, r2, r5);
        return;
    L8:
        r5 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public final void onSuccess(Bundle r4) {
        b r0 = this.a;
        if (r4 == null) goto L5;
        String r5 = r4.getString("security_phone");
    L6:
        r0.onResult(r5, null, null);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
