package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class f extends SSettingKey<Boolean> {
    public static final f a = null;

    static {
        a = new f();
    }

    public f() {
        Boolean r1 = Boolean.TRUE;
        super("anchor_link_profit_interaction_data_fix", "连线记值/计时数据初始化时机修改", r1, r1);
    }
}
