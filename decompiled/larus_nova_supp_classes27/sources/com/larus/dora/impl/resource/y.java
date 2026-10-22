package com.larus.dora.impl.resource;

import com.bytedance.keva.Keva;
import com.larus.dora.api.DoraServerDeviceType;
import com.larus.platform.service.AccountService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(DoraServerDeviceType r4) {
        Intrinsics.checkNotNullParameter(r4, "deviceType");
        AccountService r0 = AccountService.a;
        String r1 = r0.getUserId();
        if (r0.isLogin().booleanValue() == false) goto L7;
        boolean r3 = true;
        if ((!StringsKt.isBlank(r1)) == false) goto L7;
    L8:
        if (r3 == true) goto L11;
        r1 = null;
    L11:
        if (r1 != null) goto L14;
        return false;
    L14:
        return Keva.getRepo("dora_resource_mocks_".concat(r1), 0).getBoolean("mock_" + r4.name(), false);
    L7:
        r3 = false;
        goto L8
    }
}
