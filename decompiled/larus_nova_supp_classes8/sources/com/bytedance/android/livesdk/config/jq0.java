package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jq0 extends SettingKey<Boolean> {
    public static final jq0 a = null;

    static {
        a = new jq0();
    }

    public jq0() {
        Boolean r1 = Boolean.TRUE;
        super("live_screencast_stop_live_opt", "录屏关播授权优化", r1, r1);
    }
}
