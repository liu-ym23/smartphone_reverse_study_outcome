package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class du0 extends SSettingKey<Boolean> {
    public static final du0 a = null;

    static {
        a = new du0();
    }

    public du0() {
        Boolean r1 = Boolean.TRUE;
        super("live_system_ui_transparent_fix_video_position", "直播沉浸式systemui下，视频下移", r1, r1);
    }
}
