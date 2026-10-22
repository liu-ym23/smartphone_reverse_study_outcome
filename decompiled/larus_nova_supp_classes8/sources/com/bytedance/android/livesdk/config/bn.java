package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bn extends SSettingKey<Boolean> {
    public static final bn a = null;

    static {
        a = new bn();
    }

    public bn() {
        Boolean r4 = Boolean.FALSE;
        super("live_detail_enable_multi_player", "混滑场景多播放器", r4, r4, new String[]{"true:支持多播放器", "false:不支持多播放器"});
    }
}
