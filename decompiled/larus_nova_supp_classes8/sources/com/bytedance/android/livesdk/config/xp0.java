package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xp0 extends SSettingKey<Boolean> {
    public static final xp0 a = null;

    static {
        a = new xp0();
    }

    public xp0() {
        Boolean r1 = Boolean.TRUE;
        super("live_schema_reenter_fix", "跳转直播间后重复进房问题修复", r1, r1);
    }
}
