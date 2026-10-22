package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i40 extends SSettingKey<Boolean> {
    public static final i40 a = null;

    static {
        a = new i40();
    }

    public i40() {
        Boolean r1 = Boolean.TRUE;
        super("live_ktv_enter_info_clear_fix", "KTV预进房数据清理修复", r1, r1);
    }
}
