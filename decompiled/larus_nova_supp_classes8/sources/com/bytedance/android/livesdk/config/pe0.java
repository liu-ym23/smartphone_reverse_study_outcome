package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pe0 extends SSettingKey<Boolean> {
    public static final pe0 a = null;

    static {
        a = new pe0();
    }

    public pe0() {
        Boolean r4 = Boolean.FALSE;
        super("live_option_dialog_show_report", "直播间长按中的举报选项开关", r4, r4, new String[]{"true:开启", "false:关闭"});
    }
}
