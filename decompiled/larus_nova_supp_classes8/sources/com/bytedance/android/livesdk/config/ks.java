package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ks extends SSettingKey<Boolean> {
    public static final ks a = null;

    static {
        a = new ks();
    }

    public ks() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_multi_video_talk_sync", "MultiLinkVideoTalkRoomGuestWidget同步加载方式", r1, r1);
    }
}
