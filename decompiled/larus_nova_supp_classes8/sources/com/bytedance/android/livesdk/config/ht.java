package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ht extends SSettingKey<Boolean> {
    public static final ht a = null;

    static {
        a = new ht();
    }

    public ht() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_talk_room_pre_load", "是否开启聊天室界面预加载", r1, r1);
    }
}
