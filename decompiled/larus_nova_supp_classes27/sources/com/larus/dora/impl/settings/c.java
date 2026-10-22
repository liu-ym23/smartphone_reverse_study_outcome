package com.larus.dora.impl.settings;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c implements Function0 {
    public /* synthetic */ c() {
    }

    public final Object invoke() {
        DoraPushSummaryConfig r0 = ((IDoraSettings) SettingsManager.obtain(IDoraSettings.class)).doraPushSummaryConfig();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return new DoraPushSummaryConfig(false, false, 3, null);
    }
}
