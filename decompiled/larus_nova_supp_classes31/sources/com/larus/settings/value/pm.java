package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class pm implements Function0 {
    public /* synthetic */ pm() {
    }

    public final Object invoke() {
        return Boolean.valueOf(Intrinsics.areEqual(((INovaSetting) SettingsManager.obtain(INovaSetting.class)).asrSessionComponentSplit(), "true"));
    }
}
