package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class s7 implements Function0 {
    public /* synthetic */ s7() {
    }

    public final Object invoke() {
        Boolean r0 = ((INovaSetting) SettingsManager.obtain(INovaSetting.class)).getAudioTechConfig().a();
        if (r0 == null) goto L5;
        boolean r1 = r0.booleanValue();
    L7:
        return Boolean.valueOf(r1);
    L5:
        r1 = false;
        goto L7
    }
}
