package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h3 extends SSettingKey<Boolean> {
    public static final h3 a = null;

    static {
        a = new h3();
    }

    public h3() {
        Boolean r1 = Boolean.FALSE;
        super("live_not_depend_lucky_sdk", "直播容器不依赖激励SDK", r1, r1);
    }
}
