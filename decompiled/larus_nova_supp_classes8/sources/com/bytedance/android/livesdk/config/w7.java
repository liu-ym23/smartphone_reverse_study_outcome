package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w7 extends SSettingKey<Boolean> {
    public static final w7 a = null;

    static {
        a = new w7();
    }

    public w7() {
        Boolean r1 = Boolean.TRUE;
        super("live_intimatechat_switch_camera_supported", "是否允许切换摄像头", r1, r1);
    }
}
