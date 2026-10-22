package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pp0 extends SSettingKey<Boolean> {
    public static final pp0 a = null;

    static {
        a = new pp0();
    }

    public pp0() {
        Boolean r1 = Boolean.TRUE;
        super("live_safe_create_live_core_client", "临时: 保护LiveClientClient被创建多次的情况", r1, r1);
    }
}
