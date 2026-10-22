package com.bytedance.android.livesdk.coupon.jsb;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.g;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d extends g<JSONObject, JSONObject> {
    public final DataCenter a;

    public d(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.a = r2;
    }

    public final Object invoke(Object r8, final CallContext r9) {
        final JSONObject r10 = (JSONObject) r8;
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r9, "context");
        UtilityKotlinExtentionsKt.s(0, false, false, new ExchangeCoupon$invoke$1(this, r9, r10), 7);
        return null;
    }
}
