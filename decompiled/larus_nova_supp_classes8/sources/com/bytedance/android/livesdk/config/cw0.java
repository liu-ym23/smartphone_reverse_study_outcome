package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cw0 extends SettingKey<Boolean> {
    public static final cw0 a = null;

    static {
        a = new cw0();
    }

    public cw0() {
        Boolean r1 = Boolean.TRUE;
        super("live_usercenter_change_account_trace_enable", "UserCenter账号切换更新currentUser时增加trace", r1, r1);
    }
}
