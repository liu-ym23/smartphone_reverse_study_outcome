package com.bytedance.android.livesdk.coupon.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e extends g<JSONObject, JSONObject> {
    public final f a;

    public e(f r2) {
        Intrinsics.checkNotNullParameter(r2, "iExpandCouponJsb");
        this.a = r2;
    }

    public final Object invoke(Object r2, CallContext r3) {
        Intrinsics.checkNotNullParameter((JSONObject) r2, "params");
        Intrinsics.checkNotNullParameter(r3, "context");
        ct1.b r4 = this.a.b();
        return b.a(this.a.a(), r4);
    }
}
