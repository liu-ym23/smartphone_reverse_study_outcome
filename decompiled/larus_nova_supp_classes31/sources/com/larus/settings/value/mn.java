package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class mn implements Function0 {
    public /* synthetic */ mn() {
    }

    public final Object invoke() {
        return ((INovaSetting) SettingsManager.obtain(INovaSetting.class)).newUserLaunchPage();
    }
}
