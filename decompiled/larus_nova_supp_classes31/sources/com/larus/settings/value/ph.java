package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class ph implements Function0 {
    public /* synthetic */ ph() {
    }

    public final Object invoke() {
        Map r0 = ((INovaSetting) SettingsManager.obtain(INovaSetting.class)).pluginBlackConfig();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return MapsKt.emptyMap();
    }
}
