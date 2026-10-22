package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.paas.HostInfoPresenter;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nx extends SSettingKey<String> {
    public static final nx a = null;

    static {
        a = new nx();
    }

    public nx() {
        int r0 = HostInfoPresenter.a;
        kjc.c r1 = new kjc.c();
        if (r1.b == true) goto L5;
        kjc.b r2 = r1.a;
        r2.a = Unit.INSTANCE;
    L5:
        Object r3 = r1.a.a;
        super("live_full_screen_recharge_url", "", "火山全屏充值地址");
    }
}
