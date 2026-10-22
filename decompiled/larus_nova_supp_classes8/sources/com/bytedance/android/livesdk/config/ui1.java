package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ui1 extends SSettingKey<Boolean> {
    public static final ui1 a = null;

    static {
        a = new ui1();
    }

    public ui1() {
        Boolean r1 = Boolean.TRUE;
        super("vcd_enable_anchor_report", "是否开启VCD主播举报统一化", r1, r1);
    }
}
