package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class ee<T> implements Consumer {
    public final /* synthetic */ ge a;

    public ee(ge r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        b30.h0 r6 = (b30.h0) r5;
        ge r0 = this.a;
        boolean r1 = r6.a;
        CallContext r2 = r0.getCallContext();
        JSONObject r3 = new JSONObject();
        r3.put("code", r1 ? 1 : 0);
        Unit r4 = Unit.INSTANCE;
        r2.b("H5_zmCertStatus", r3);
        if (r6.a == false) goto L5;
        this.a.finishWithSuccess();
        return;
    L5:
        this.a.finishWithFailure();
    }
}
