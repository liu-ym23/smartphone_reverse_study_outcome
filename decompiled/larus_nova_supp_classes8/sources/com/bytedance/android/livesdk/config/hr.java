package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hr extends SSettingKey<Boolean> {
    public static final hr a = null;

    static {
        a = new hr();
    }

    public hr() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_control_client_mix_stream", "是否支持配置端上选择合流方式", r1, r1);
    }
}
