package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class we1 extends SSettingKey<Boolean> {
    public static final we1 a = null;

    static {
        a = new we1();
    }

    public we1() {
        Boolean r1 = Boolean.TRUE;
        super("real_time_chorus_send_sei", "实时合唱sei发送异常修复", r1, r1);
    }
}
