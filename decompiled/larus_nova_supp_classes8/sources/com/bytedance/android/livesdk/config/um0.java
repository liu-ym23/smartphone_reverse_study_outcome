package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class um0 extends SSettingKey<Boolean> {
    public static final um0 a = null;

    static {
        a = new um0();
    }

    public um0() {
        Boolean r1 = Boolean.FALSE;
        super("live_remove_dumplicate_msg_id_intercept", "移除直播间重复消息id拦截", r1, r1);
    }
}
