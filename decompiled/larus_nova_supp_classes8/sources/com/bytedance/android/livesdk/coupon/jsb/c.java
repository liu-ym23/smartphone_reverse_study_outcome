package com.bytedance.android.livesdk.coupon.jsb;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c extends g<JSONObject, JSONObject> {
    public final f a;

    public c(f r2) {
        Intrinsics.checkNotNullParameter(r2, "iExpandCouponJsb");
        this.a = r2;
    }

    public final Object invoke(Object r7, CallContext r8) {
        Intrinsics.checkNotNullParameter((JSONObject) r7, "params");
        Intrinsics.checkNotNullParameter(r8, "context");
        UtilityKotlinExtentionsKt.s(0, false, false, new DoExpandCoupon$invoke$1(this), 7);
        return null;
    }
}
