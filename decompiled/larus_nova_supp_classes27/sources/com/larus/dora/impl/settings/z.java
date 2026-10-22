package com.larus.dora.impl.settings;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class z implements Function0 {
    public /* synthetic */ z() {
    }

    public final Object invoke() {
        return Boolean.valueOf(((IDoraSettings) SettingsManager.obtain(IDoraSettings.class)).isHOnboardingSimplifiedEnabled());
    }
}
