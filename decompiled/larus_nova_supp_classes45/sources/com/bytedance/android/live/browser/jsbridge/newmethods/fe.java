package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class fe<T> implements Consumer {
    public final /* synthetic */ ge a;

    public fe(ge r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        Throwable r5 = (Throwable) r4;
        CallContext r6 = this.a.getCallContext();
        JSONObject r0 = new JSONObject();
        r0.put("code", 0);
        Unit r1 = Unit.INSTANCE;
        r6.b("H5_zmCertStatus", r0);
        this.a.finishWithFailure();
    }
}
