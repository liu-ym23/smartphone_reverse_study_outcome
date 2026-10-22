package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class n4 implements Function0 {
    public /* synthetic */ n4() {
    }

    public final Object invoke() {
        if (AppHost.a.isDebug() == false) goto L5;
        boolean r0 = true;
    L7:
        return Boolean.valueOf(r0);
    L5:
        r0 = ((INovaSetting) SettingsManager.obtain(INovaSetting.class)).isSubConvCreateOptEnable();
        goto L7
    }
}
