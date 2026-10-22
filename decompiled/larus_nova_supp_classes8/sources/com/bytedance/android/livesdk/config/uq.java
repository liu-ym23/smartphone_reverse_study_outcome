package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class uq extends SSettingKey<Boolean> {
    public static final uq a = null;

    static {
        a = new uq();
    }

    public uq() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_apply_permission_dialog", "是否收敛连麦申请权限开关到独立dialog", r1, r1);
    }
}
