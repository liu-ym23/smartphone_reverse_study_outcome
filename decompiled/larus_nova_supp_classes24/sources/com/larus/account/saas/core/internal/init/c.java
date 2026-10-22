package com.larus.account.saas.core.internal.init;

import com.larus.account.saas.runtime.internal.delegate.a;
import org.json.JSONObject;
import qb4.f;
import xqa.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c implements f {
    public final /* synthetic */ b.a a;

    public c(kb7.b r1) {
        this.a = r1;
    }

    public final void onFail(int r4, JSONObject r5) {
        a.a.d("SaaSAccountConfig", "Bdturing handle captcha fail, result = " + r4 + ", extras = " + r5);
        b.a r6 = this.a;
        if (r6 == null) goto L6;
        r6.onFail();
        return;
    }

    public final void onSuccess(int r4, JSONObject r5) {
        a.a.d("SaaSAccountConfig", "Bdturing handle captcha success, result = " + r4 + ", extras = " + r5);
        b.a r6 = this.a;
        if (r6 == null) goto L6;
        r6.onSuccess();
        return;
    }
}
