package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class ji implements Function0 {
    public /* synthetic */ ji() {
    }

    public final Object invoke() {
        List r0 = ((INovaSetting) SettingsManager.obtain(INovaSetting.class)).getDoraSimulSupportLangConfigList();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return CollectionsKt.emptyList();
    }
}
