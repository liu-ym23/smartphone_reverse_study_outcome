package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dv extends SSettingKey<Boolean> {
    public static final dv a = null;

    static {
        a = new dv();
    }

    public dv() {
        Boolean r4 = Boolean.FALSE;
        super("live_external_default_remove_container", "接入层容器移除时机fix", r4, r4, true);
    }
}
