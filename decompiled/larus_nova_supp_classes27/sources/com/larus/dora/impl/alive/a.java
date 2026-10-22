package com.larus.dora.impl.alive;

import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.dora.device.DoraDevice;
import com.larus.cdm.IFlowCompanionDeviceManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.util.h0;
import com.larus.platform.service.z2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final boolean a(IFlowCompanionDeviceManager r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (r4.n() == true) goto L9;
        g49.d.e("CompanionDeviceManagerE", "companionDeviceSupport is false.");
        return false;
    L9:
        z2 r5 = z2.a;
        if (r5.getDoraCdmDisableConfig() == false) goto L12;
    L28:
        g49.d.e("CompanionDeviceManagerE", "cdm is disabled or feature is disabled.");
        return false;
    L12:
        if (r5.getDoraCdmFeatureSwitchConfig() == false) goto L28;
        DoraDevice r6 = DoraAdapterExtKt.h(kj4.a.g());
        if (r6 != null) goto L17;
    L19:
        boolean r7 = false;
    L20:
        if (r7 == true) goto L22;
    L27:
        return true;
    L22:
        if (DeviceUtils.isHuawei() == true) goto L27;
        if (h0.a() == false) goto L27;
        g49.d.e("CompanionDeviceManagerE", "H adaption is not permit.");
        return false;
    L17:
        if (r6.vendorId != 4096) goto L19;
        r7 = true;
        goto L20
    }
}
