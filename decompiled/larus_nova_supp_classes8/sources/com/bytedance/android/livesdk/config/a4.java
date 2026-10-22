package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a4 extends SSettingKey<Boolean> {
    public static final a4 a = null;

    static {
        a = new a4();
    }

    public a4() {
        Boolean r1 = Boolean.TRUE;
        super("enable_ctrl_open_lynx_view_show_hide", "端上手动控制lynxview的onShow和onHide", r1, r1);
    }
}
