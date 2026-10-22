package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m3 extends SSettingKey<Boolean> {
    public static final m3 a = null;

    static {
        a = new m3();
    }

    public m3() {
        Boolean r1 = Boolean.TRUE;
        super("enable_live_core_effect", "是否开启livecore effect相关能力", r1, r1);
    }
}
