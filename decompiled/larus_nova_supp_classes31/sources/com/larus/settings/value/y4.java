package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import com.larus.common.apphost.AppHost;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class y4 implements Function0 {
    public /* synthetic */ y4() {
    }

    public final Object invoke() {
        List r0 = CollectionsKt.toMutableList(((INovaSetting) SettingsManager.obtain(INovaSetting.class)).getEnterVideoCallWhiteList());
        if (r0.isEmpty() == true) goto L5;
    L7:
        return r0;
    L5:
        if (AppHost.a.isOversea() == true) goto L7;
        r0.add("coco_call");
        goto L7
    }
}
