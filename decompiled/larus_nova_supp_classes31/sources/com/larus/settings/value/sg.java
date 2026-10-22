package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class sg implements Function0 {
    public /* synthetic */ sg() {
    }

    public final Object invoke() {
        return Long.valueOf(RangesKt.coerceAtLeast(((INovaSetting) SettingsManager.obtain(INovaSetting.class)).getMessageSearchHighlightConfig().b(), 0));
    }
}
