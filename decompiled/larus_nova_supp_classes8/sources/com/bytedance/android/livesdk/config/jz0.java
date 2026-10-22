package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jz0 extends SSettingKey<Boolean> {
    public static final jz0 a = null;

    static {
        a = new jz0();
    }

    public jz0() {
        Boolean r1 = Boolean.FALSE;
        super("live_ws_private_protocol_enable", "直播长连私有协议开关", r1, r1);
    }
}
