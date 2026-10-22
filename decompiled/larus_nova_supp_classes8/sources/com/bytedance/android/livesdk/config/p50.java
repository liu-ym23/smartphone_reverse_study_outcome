package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p50 extends SettingKey<Boolean> {
    public static final p50 a = null;

    static {
        a = new p50();
    }

    public p50() {
        Boolean r1 = Boolean.FALSE;
        super("live_landscape_refresh_pull_stream", "横屏直播间支持刷新重新拉流", r1, r1);
    }
}
