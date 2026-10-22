package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class mh0 extends SSettingKey<Boolean> {
    public static final mh0 a = null;

    static {
        a = new mh0();
    }

    public mh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_security_check_enable", "PK场景音视频在线检测开关", r1, r1);
    }
}
