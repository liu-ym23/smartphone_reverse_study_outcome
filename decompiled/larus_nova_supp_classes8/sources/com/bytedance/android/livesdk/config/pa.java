package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pa extends SSettingKey<Boolean> {
    public static final pa a = null;

    static {
        a = new pa();
    }

    public pa() {
        Boolean r1 = Boolean.FALSE;
        super("live_ambient_light_listener_enable", "直播启用环境光传感器", r1, r1);
    }
}
