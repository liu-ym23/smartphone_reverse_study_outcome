package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e extends SSettingKey<Boolean> {
    public static final e a = null;

    static {
        a = new e();
    }

    public e() {
        Boolean r4 = Boolean.TRUE;
        super("live_decouple_digg_and_userinfo", "DiggWidget和主播头像组件解耦", r4, r4, true);
    }
}
