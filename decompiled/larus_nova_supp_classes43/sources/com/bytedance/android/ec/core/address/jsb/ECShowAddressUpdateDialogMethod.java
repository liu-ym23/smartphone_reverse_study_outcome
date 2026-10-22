package com.bytedance.android.ec.core.address.jsb;

import com.bytedance.android.ec.core.address.AddressSDK;
import com.bytedance.android.ec.core.address.w;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/ec/core/address/jsb/ECShowAddressUpdateDialogMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShowAddressUpdateDialogMethod extends ECBaseBridgeMethod {
    public final String e;

    public ECShowAddressUpdateDialogMethod() {
        this.e = "ecShowAddressUpdateDialog";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r10, ECBaseBridgeMethod.a r11) {
        Intrinsics.checkNotNullParameter(r10, "params");
        Intrinsics.checkNotNullParameter(r11, "iReturn");
        String r12 = r10.optString("btm");
        w r0 = AddressSDK.a;
        AddressSDK.w(r12);
        r11.onSuccess(null);
    }
}
