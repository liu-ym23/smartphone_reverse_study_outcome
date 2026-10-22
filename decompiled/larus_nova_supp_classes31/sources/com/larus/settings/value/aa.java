package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class aa implements Function0 {
    public /* synthetic */ aa() {
    }

    public final Object invoke() {
        return Integer.valueOf(((INovaSetting) SettingsManager.obtain(INovaSetting.class)).continuousTalkClickAlignment());
    }
}
