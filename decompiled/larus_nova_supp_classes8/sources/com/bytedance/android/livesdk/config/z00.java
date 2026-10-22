package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z00 extends SSettingKey<Boolean> {
    public static final z00 a = null;

    static {
        a = new z00();
    }

    public z00() {
        Boolean r1 = Boolean.FALSE;
        super("live_im_allow_reconnect_command", "直播消息支持reconnect命令", r1, r1);
    }
}
