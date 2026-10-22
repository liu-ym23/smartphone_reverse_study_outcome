package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k0 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public final int a;

    public k0(int r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4, CallContext r5) throws Exception {
        xs2.b.a().post(new zg1.v(this.a, ((JSONObject) r4).optInt("type"), null));
        return null;
    }
}
