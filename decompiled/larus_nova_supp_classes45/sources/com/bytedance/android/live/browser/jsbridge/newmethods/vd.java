package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class vd extends com.bytedance.ies.web.jsbridge2.f<JSONObject, JSONObject> {
    public final /* synthetic */ zd a;

    public final void onTerminate() {
    }

    public vd(zd r1) {
        this.a = r1;
    }

    public final void invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JSONObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        this.a.getClass();
        zd.b("disconnect message manager");
        zd.a(this.a);
        JSONObject r4 = new JSONObject();
        r4.put("code", 1);
        Unit r5 = Unit.INSTANCE;
        finishWithResult(r4);
    }
}
