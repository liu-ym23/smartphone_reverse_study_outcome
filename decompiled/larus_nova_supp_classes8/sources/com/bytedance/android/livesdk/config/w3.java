package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w3 extends SSettingKey<Boolean> {
    public static final w3 a = null;

    static {
        a = new w3();
    }

    public w3() {
        Boolean r1 = Boolean.TRUE;
        super("enable_lynx_share_group", "开启 Lynx 共享 Runtime", r1, r1);
    }
}
