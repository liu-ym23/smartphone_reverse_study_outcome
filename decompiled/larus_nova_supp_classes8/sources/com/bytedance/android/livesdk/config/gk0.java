package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gk0 extends SSettingKey<Boolean> {
    public static final gk0 a = null;

    static {
        a = new gk0();
    }

    public gk0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pre_danmaku_stop_clear_only_running", "直播预览流stop时只在引擎running和非空时清理", r1, r1);
    }
}
