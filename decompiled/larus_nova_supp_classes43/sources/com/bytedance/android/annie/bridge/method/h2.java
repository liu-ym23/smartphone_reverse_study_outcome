package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@XBridgeMethod(biz = "webcast_sdk", name = "setSideslip")
public final class h2 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Object> {
    public final HybridFragment a;

    public h2(m16.b r10) {
        Intrinsics.checkNotNullParameter(r10, "providerFactory");
        HybridFragment r11 = (HybridFragment) r10.c(HybridFragment.class);
        if (r11 == null) goto L6;
        this.a = r11;
        return;
    }

    public h2(HybridFragment r10) {
        Intrinsics.checkNotNullParameter(r10, "hybridFragment");
        this.a = r10;
    }

    public final Object invoke(Object r10, CallContext r11) {
        JSONObject r12 = (JSONObject) r10;
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r11, "context");
        String r13 = r12.optString("forbid_right_back", "");
        if (Intrinsics.areEqual(r13, "0") == false) goto L8;
        HybridFragment r14 = this.a;
        if (r14 == null) goto L13;
        r14.setCloseByGesture(true);
    L13:
        return Unit.INSTANCE;
    L8:
        if (Intrinsics.areEqual(r13, "1") == false) goto L13;
        HybridFragment r15 = this.a;
        if (r15 == null) goto L13;
        r15.setCloseByGesture(false);
        goto L13
    }
}
