package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class td1 extends SSettingKey<Boolean> {
    public static final td1 a = null;

    static {
        a = new td1();
    }

    public td1() {
        Boolean r1 = Boolean.FALSE;
        super("prefetch_read_all_local_config_files", "遍历本地所有 channel 下的 configurations", r1, r1);
    }
}
