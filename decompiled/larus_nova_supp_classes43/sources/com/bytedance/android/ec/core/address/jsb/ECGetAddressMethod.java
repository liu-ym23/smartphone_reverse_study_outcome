package com.bytedance.android.ec.core.address.jsb;

import com.bytedance.android.ec.core.address.AddressSDK;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/address/jsb/ECGetAddressMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGetAddressMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECGetAddressMethod() {
        this.e = "ecGetAddress";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        int r0 = r10.optInt("address_type", -1);
        String r1 = r10.optString("btm", "");
        if (r1.length() <= 0) goto L5;
        boolean r12 = true;
    L7:
        if (r12 == true) goto L10;
        r1 = null;
    L10:
        r11.onSuccess(AddressSDK.j.k(b().a, r1, r0, "jsb").a(!r10.optBoolean("need_detail", false), null, null));
        return;
    L5:
        r12 = false;
        goto L7
    }
}
