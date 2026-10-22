package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class zt implements Function0 {
    public /* synthetic */ zt() {
    }

    public final Object invoke() {
        Integer r0 = ((INovaSetting) SettingsManager.obtain(INovaSetting.class)).ZGuideShowConfig().a();
        if (r0 == null) goto L8;
        boolean r1 = true;
        if (r0.intValue() != 1) goto L8;
    L10:
        return Boolean.valueOf(r1);
    L8:
        r1 = false;
        goto L10
    }
}
