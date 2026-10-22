package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class v9 implements Function0 {
    public /* synthetic */ v9() {
    }

    public final Object invoke() {
        boolean r1 = true;
        if (((INovaSetting) SettingsManager.obtain(INovaSetting.class)).getImmerseHistoryEntranceConfig().a() == 1) goto L7;
        r1 = false;
    L7:
        return Boolean.valueOf(r1);
    }
}
