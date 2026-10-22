package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class jr implements Function0 {
    public /* synthetic */ jr() {
    }

    public final Object invoke() {
        String r0 = ((INovaSetting) SettingsManager.obtain(INovaSetting.class)).oDiaryBetaUrl();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }
}
