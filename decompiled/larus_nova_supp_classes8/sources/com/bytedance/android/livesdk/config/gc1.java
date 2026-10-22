package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gc1 extends SSettingKey<Boolean> {
    public static final gc1 a = null;

    static {
        a = new gc1();
    }

    public gc1() {
        Boolean r1 = Boolean.TRUE;
        super("official_inspector_enable", "官方巡查员主播侧开关", r1, r1);
    }
}
