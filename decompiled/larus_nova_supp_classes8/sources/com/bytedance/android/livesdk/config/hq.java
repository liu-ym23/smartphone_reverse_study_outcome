package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hq extends SSettingKey<Boolean> {
    public static final hq a = null;

    static {
        a = new hq();
    }

    public hq() {
        Boolean r1 = Boolean.TRUE;
        super("live_ec_enable_saas_downgrade_old_live_annie_fragment", "SaaS ec是否降级最老的Annie容器", r1, r1);
    }
}
