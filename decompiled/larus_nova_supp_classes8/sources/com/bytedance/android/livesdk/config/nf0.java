package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nf0 extends SSettingKey<Boolean> {
    public static final nf0 a = null;

    static {
        a = new nf0();
    }

    public nf0() {
        Boolean r1 = Boolean.TRUE;
        super("live_parse_panel_type_on_click", "是否在onclick时获取分享面板类型", r1, r1);
    }
}
