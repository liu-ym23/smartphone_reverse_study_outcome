package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qc0 extends SSettingKey<Boolean> {
    public static final qc0 a = null;

    static {
        a = new qc0();
    }

    public qc0() {
        Boolean r1 = Boolean.TRUE;
        super("live_network_skip_url_end_check", "网络APM开关配置", r1, r1);
    }
}
