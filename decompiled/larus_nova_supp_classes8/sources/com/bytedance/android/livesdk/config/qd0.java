package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qd0 extends SSettingKey<Boolean> {
    public static final qd0 a = null;

    static {
        a = new qd0();
    }

    public qd0() {
        Boolean r1 = Boolean.TRUE;
        super("live_old_long_press_panel_support_show_and_dismiss_callback", "旧版长按面板支持Item的onShow和onDismiss回调", r1, r1);
    }
}
