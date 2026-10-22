package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class au0 extends SSettingKey<Boolean> {
    public static final au0 a = null;

    static {
        a = new au0();
    }

    public au0() {
        Boolean r1 = Boolean.FALSE;
        super("live_switch_guest_send_gift", "允许观众给嘉宾送礼规则页按钮开关", r1, r1);
    }
}
