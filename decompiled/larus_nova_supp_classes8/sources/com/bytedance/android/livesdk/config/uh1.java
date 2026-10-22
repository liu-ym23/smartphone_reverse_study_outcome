package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uh1 extends SSettingKey<Boolean> {
    public static final uh1 a = null;

    static {
        a = new uh1();
    }

    public uh1() {
        Boolean r1 = Boolean.TRUE;
        super("talk_room_rtc_sei_enable", "聊天室开启非关键帧SEI", r1, r1);
    }
}
