package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import com.larus.dora.device.api.IDoraDeviceInfo;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class ei implements Function0 {
    public /* synthetic */ ei() {
    }

    public final Object invoke() {
        boolean r1 = true;
        if (((INovaSetting) SettingsManager.obtain(INovaSetting.class)).enableDoraLarkRecord() == true) goto L14;
        IDoraDeviceInfo r0 = (IDoraDeviceInfo) ServiceManager.get().getService(IDoraDeviceInfo.class);
        if (r0 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == true) goto L14;
        r1 = false;
        goto L14
    L7:
        if (r0.b() != true) goto L9;
        r2 = true;
    L14:
        return Boolean.valueOf(r1);
    }
}
