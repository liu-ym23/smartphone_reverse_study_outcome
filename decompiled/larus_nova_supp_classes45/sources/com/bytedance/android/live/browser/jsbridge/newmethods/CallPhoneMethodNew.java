package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "callPhone")
public final class CallPhoneMethodNew extends com.bytedance.ies.web.jsbridge2.f<JSONObject, Object> {
    public final Function1<Throwable, Unit> a;
    public final Function1<Object, Unit> b;

    public final void onTerminate() {
    }

    public CallPhoneMethodNew() {
        this.a = new CallPhoneMethodNew$onFailed$1(this);
        this.b = new CallPhoneMethodNew$onSuccess$1(this);
    }

    public final void invoke(Object r3, CallContext r4) {
        JSONObject r5 = (JSONObject) r3;
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = m1.a;
        m1.a(r5, r4, this.a, this.b);
    }
}
