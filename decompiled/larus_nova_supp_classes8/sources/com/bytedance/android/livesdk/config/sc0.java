package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sc0 extends SSettingKey<Boolean> {
    public static final sc0 a = null;

    static {
        a = new sc0();
    }

    public sc0() {
        Boolean r1 = Boolean.TRUE;
        super("live_new_chat_channel_enable_egg_anim", "是否允许播放氛围彩蛋动效", r1, r1);
    }
}
