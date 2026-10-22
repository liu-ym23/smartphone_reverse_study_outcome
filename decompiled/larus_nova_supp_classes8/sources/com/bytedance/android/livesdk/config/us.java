package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class us extends SSettingKey<Boolean> {
    public static final us a = null;

    static {
        a = new us();
    }

    public us() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_saas_downgrade_old_live_annie_fragment", "SaaS是否降级最老的Annie容器", r1, r1);
    }
}
