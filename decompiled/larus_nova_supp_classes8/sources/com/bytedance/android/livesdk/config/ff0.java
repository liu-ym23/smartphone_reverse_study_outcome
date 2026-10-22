package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ff0 extends SSettingKey<Boolean> {
    public static final ff0 a = null;

    static {
        a = new ff0();
    }

    public ff0() {
        Boolean r1 = Boolean.FALSE;
        super("live_paid_live_enable_video_talk_room", "付费直播间支持开启聊天室", r1, r1);
    }
}
