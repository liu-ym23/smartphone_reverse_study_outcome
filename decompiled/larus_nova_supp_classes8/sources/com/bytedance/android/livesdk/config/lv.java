package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lv extends SSettingKey<Boolean> {
    public static final lv a = null;

    static {
        a = new lv();
    }

    public lv() {
        Boolean r1 = Boolean.TRUE;
        super("live_feedback_enable_msg_fix", "通过消息触发拉取问卷能力在主看播都生效", r1, r1);
    }
}
