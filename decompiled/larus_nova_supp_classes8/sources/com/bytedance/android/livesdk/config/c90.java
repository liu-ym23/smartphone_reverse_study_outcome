package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c90 extends SSettingKey<Boolean> {
    public static final c90 a = null;

    static {
        a = new c90();
    }

    public c90() {
        Boolean r1 = Boolean.TRUE;
        super("live_mg_open_camera_capture_enable", "播中挂载小游戏支持开关摄像头", r1, r1);
    }
}
