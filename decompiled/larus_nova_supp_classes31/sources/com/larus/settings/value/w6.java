package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class w6 implements Function0 {
    public /* synthetic */ w6() {
    }

    public final Object invoke() {
        return Integer.valueOf(((INovaSetting) SettingsManager.obtain(INovaSetting.class)).getEnableModelTrainingBySpecificType());
    }
}
