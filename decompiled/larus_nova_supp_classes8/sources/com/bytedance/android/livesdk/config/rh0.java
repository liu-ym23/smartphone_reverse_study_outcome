package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rh0 extends SSettingKey<Boolean> {
    public static final rh0 a = null;

    static {
        a = new rh0();
    }

    public rh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_to_video_camera_dynamic_video_state_bugifx", "关闭PK回到动态浮窗布局videoState修复", r1, r1);
    }
}
