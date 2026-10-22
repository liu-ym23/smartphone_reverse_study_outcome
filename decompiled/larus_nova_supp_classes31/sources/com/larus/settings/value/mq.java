package com.larus.settings.value;

import com.bytedance.news.common.settings.SettingsManager;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class mq implements Function0 {
    public /* synthetic */ mq() {
    }

    public final Object invoke() {
        List r0 = ((INovaSetting) SettingsManager.obtain(INovaSetting.class)).getNoClearInputActionBarWhitelist();
        if (r0 != null) goto L6;
        e10 r1 = e10.a;
        return e10.I0();
    L6:
        return r0;
    }
}
