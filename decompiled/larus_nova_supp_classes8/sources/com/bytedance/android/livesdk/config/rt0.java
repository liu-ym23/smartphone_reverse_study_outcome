package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rt0 extends SSettingKey<Boolean> {
    public static final rt0 a = null;

    static {
        a = new rt0();
    }

    public rt0() {
        Boolean r1 = Boolean.TRUE;
        super("live_stream_scroll_profile_panel_fix", "资料卡流上移时偏移计算修正", r1, r1);
    }
}
