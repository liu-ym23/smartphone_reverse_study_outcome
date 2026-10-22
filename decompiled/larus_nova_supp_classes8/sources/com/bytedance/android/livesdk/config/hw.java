package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hw extends SSettingKey<Boolean> {
    public static final hw a = null;

    static {
        a = new hw();
    }

    public hw() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_detail_enter_method_anable", "修复抖音混滑埋点问题开关", r1, r1);
    }
}
