package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class mc implements Function0 {
    public /* synthetic */ mc() {
    }

    public final Object invoke() {
        if (((INovaSetting) SettingsManager.obtain(INovaSetting.class)).botCreateEnable() == false) goto L7;
        e10 r0 = e10.a;
        if (e10.h() == false) goto L7;
        boolean r1 = true;
    L9:
        return Boolean.valueOf(r1);
    L7:
        r1 = false;
        goto L9
    }
}
