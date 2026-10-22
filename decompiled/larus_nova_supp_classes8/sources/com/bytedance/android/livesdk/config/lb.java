package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lb extends SSettingKey<Boolean> {
    public static final lb a = null;

    static {
        a = new lb();
    }

    public lb() {
        Boolean r4 = Boolean.FALSE;
        super("live_anchor_enable_chat_group_live", "群直播需求开关", r4, r4, true);
    }
}
