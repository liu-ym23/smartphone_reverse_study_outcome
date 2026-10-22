package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class sd1 extends SSettingKey<Boolean> {
    public static final sd1 a = null;

    static {
        a = new sd1();
    }

    public sd1() {
        Boolean r1 = Boolean.TRUE;
        super("prefetch_disable_local_storage", "prefetch 是否禁用本地 storage", r1, r1);
    }
}
