package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sg1 extends SSettingKey<Boolean> {
    public static final sg1 a = null;

    static {
        a = new sg1();
    }

    public sg1() {
        Boolean r1 = Boolean.TRUE;
        super("support_private_data_selection", "支持private类型文件的选择", r1, r1);
    }
}
