package com.larus.dora.impl.settings;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class v implements Function0 {
    public /* synthetic */ v() {
    }

    public final Object invoke() {
        String r0 = ((IDoraSettings) SettingsManager.obtain(IDoraSettings.class)).doraHealthAgentWebUrl();
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }
}
