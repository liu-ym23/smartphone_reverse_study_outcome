package com.larus.settings.value;

import android.os.Build;
import com.bytedance.news.common.settings.SettingsManager;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final /* synthetic */ class rr implements Function0 {
    public /* synthetic */ rr() {
    }

    public final Object invoke() {
        if (Build.VERSION.SDK_INT < 37) goto L5;
        boolean r0 = ((INovaSetting) SettingsManager.obtain(INovaSetting.class)).enableTtsMediaSessionAfterAndroid17();
    L7:
        return Boolean.valueOf(r0);
    L5:
        r0 = ((INovaSetting) SettingsManager.obtain(INovaSetting.class)).enableTtsMediaSession();
        goto L7
    }
}
