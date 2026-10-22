package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sd extends SSettingKey<Boolean> {
    public static final sd a = null;

    static {
        a = new sd();
    }

    public sd() {
        Boolean r1 = Boolean.TRUE;
        super("live_anniex_register_data_share", "AnnieX初始化是否注册DataShare", r1, r1);
    }
}
