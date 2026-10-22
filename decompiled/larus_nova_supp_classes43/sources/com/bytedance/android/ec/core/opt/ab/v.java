package com.bytedance.android.ec.core.opt.ab;

import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.local.api.ab.ECLiveSettingPanel;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class v {
    @ECLiveSettingPanel(desc = "电商Jit compile抑制", key = "ecom_block_jit_compile")
    public static x a() {
        x r0 = new x();
        Intrinsics.checkNotNullParameter("ecom_block_jit_compile", "key");
        Intrinsics.checkNotNullParameter(r0, "defaultValue");
        int r10 = ECSdk.a;
        IAdapterService r11 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r11 == null) goto L8;
        x r1 = (x) r11.getLiveSettingsValue("ecom_block_jit_compile", r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new x();
    L8:
        return r0;
    }

    static {
    }
}
