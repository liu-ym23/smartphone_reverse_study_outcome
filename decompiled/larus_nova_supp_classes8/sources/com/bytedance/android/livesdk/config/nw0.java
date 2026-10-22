package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nw0 extends SSettingKey<Boolean> {
    public static final nw0 a = null;

    static {
        a = new nw0();
    }

    public nw0() {
        Boolean r1 = Boolean.FALSE;
        super("live_video_talk_avatar_enabled_anchor", "主播是否可以开启视频聊天室avatar虚拟形象", r1, r1);
    }
}
