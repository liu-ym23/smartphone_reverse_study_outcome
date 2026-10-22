package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tu extends SSettingKey<Boolean> {
    public static final tu a = null;

    static {
        a = new tu();
    }

    public tu() {
        Boolean r1 = Boolean.FALSE;
        super("live_enter_split_except_ec", "内流进房接口拆分去除电商", r1, r1);
    }
}
