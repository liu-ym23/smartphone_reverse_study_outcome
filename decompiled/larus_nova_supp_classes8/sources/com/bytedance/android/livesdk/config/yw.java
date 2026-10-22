package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yw extends SSettingKey<Boolean> {
    public static final yw a = null;

    static {
        a = new yw();
    }

    public yw() {
        Boolean r1 = Boolean.FALSE;
        super("live_fix_widget_auto_dispose_npe", "修复autoDispose的NPE", r1, r1);
    }
}
