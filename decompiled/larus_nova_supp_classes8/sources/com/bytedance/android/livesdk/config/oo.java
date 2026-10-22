package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class oo extends SSettingKey<Boolean> {
    public static final oo a = null;

    static {
        a = new oo();
    }

    public oo() {
        Boolean r1 = Boolean.FALSE;
        super("live_dispatcher_schema_enable", "协议化调用框架启用的开关", r1, r1);
    }
}
