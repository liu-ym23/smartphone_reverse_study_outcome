package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yn extends SSettingKey<Boolean> {
    public static final yn a = null;

    static {
        a = new yn();
    }

    public yn() {
        super("live_disable_i18n_db_ab", Boolean.TRUE, "i18n数据库下线实验");
    }
}
