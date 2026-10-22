package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fr0 extends SSettingKey<Boolean> {
    public static final fr0 a = null;

    static {
        a = new fr0();
    }

    public fr0() {
        Boolean r4 = Boolean.FALSE;
        super("live_security_container_force_native", "直播安全容器强制使用原生", r4, r4, false);
    }
}
