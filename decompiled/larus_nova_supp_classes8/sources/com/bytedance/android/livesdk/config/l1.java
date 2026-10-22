package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l1 extends SSettingKey<Boolean> {
    public static final l1 a = null;

    static {
        a = new l1();
    }

    public l1() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_cs_consume_ps_click", "忽略此次点击公屏清屏", r1, r1);
    }
}
