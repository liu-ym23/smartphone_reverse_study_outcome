package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ev0 extends SSettingKey<Boolean> {
    public static final ev0 a = null;

    static {
        a = new ev0();
    }

    public ev0() {
        Boolean r4 = Boolean.FALSE;
        super("live_toolbar_permission_check_enable", "toolbar组件挂载校验开关", r4, r4, true);
    }
}
