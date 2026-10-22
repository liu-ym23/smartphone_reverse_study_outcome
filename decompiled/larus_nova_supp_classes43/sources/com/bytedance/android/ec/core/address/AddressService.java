package com.bytedance.android.ec.core.address;

import com.bytedance.android.ec.core.utils.UIUtils;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.address.AddressUpdateDialogConfig;
import com.bytedance.android.shopping.api.address.IAddressService;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class AddressService implements IAddressService {
    public final AddressUpdateDialogConfig getAddressUpdateDialogConfig() {
        w r0 = AddressSDK.a;
        w r1 = AddressSDK.a;
        return new AddressUpdateDialogConfig(r1.e, r1.g.e().d());
    }

    public AddressService() {
        Lazy r0 = UIUtils.a;
        UIUtils.c().post(AnonymousClass1.a);
    }

    public final String getBtmCodeInSaas(String r10) {
        Intrinsics.checkNotNullParameter(r10, "bizCode");
        w r1 = AddressSDK.a;
        Intrinsics.checkNotNullParameter(r10, "bizCode");
        Lazy r0 = ECAppInfoService.a;
        if (we.a.a == false) goto L7;
        Map<String, String> r11 = AddressSDK.a.g.f();
        if (r11 == null) goto L7;
        return r11.get(r10);
    L7:
        return null;
    }

    public final void showAddressUpdateDialog(String r10) {
        w r0 = AddressSDK.a;
        AddressSDK.w(r10);
    }

    public final o83.a getAddress(Object r10, String r11, int r12) {
        return AddressSDK.j.k(r10, r11, r12, com.bytedance.android.ec.core.event.a.VALUE_NATIVE);
    }

    public final void setAddress(JSONObject r10, int r11, boolean r12, o83.e r13, o83.d r14) {
        Intrinsics.checkNotNullParameter(r10, "address");
        AddressSDK.j.u(r10, r11, r12, r13, r14);
    }
}
