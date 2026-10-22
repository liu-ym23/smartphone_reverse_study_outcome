package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ja1 extends SSettingKey<Boolean> {
    public static final ja1 a = null;

    static {
        a = new ja1();
    }

    public ja1() {
        Boolean r1 = Boolean.TRUE;
        super("multi_anchor_leave_msg_opt_enable", "多人主播连线消费leave消息不请求list", r1, r1);
    }
}
