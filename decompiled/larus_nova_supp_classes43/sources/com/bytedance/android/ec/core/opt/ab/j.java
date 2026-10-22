package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.local.api.ab.ECLiveSettingPanel;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class j {
    @ECLiveSettingPanel(desc = "电商基础优化二期", key = "live_ecom_base_optv2")
    public static k a() {
        k r0 = new k();
        Intrinsics.checkNotNullParameter("live_ecom_base_optv2", "key");
        Intrinsics.checkNotNullParameter(r0, "defaultValue");
        int r10 = ECSdk.a;
        IAdapterService r11 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r11 == null) goto L8;
        k r1 = (k) r11.getLiveSettingsValue("live_ecom_base_optv2", r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new k();
    L8:
        return r0;
    }

    static {
    }
}
