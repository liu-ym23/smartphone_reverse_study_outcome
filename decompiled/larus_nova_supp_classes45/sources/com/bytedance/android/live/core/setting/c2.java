package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c2 extends SSettingKey<Boolean> {
    public static final c2 a = null;

    static {
        a = new c2();
    }

    public c2() {
        super("live_interact_pc_stream_reset", Boolean.TRUE, "pc直播间PK结束后重置流比例");
    }
}
