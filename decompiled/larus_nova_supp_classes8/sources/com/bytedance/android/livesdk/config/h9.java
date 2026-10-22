package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h9 extends SSettingKey<Boolean> {
    public static final h9 a = null;

    static {
        a = new h9();
    }

    public h9() {
        Boolean r1 = Boolean.TRUE;
        super("link_interact_audience_opt_enable", "是否开启观众连线异常处理", r1, r1);
    }
}
