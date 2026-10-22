package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xw extends SSettingKey<Boolean> {
    public static final xw a = null;

    static {
        a = new xw();
    }

    public xw() {
        Boolean r4 = Boolean.TRUE;
        super("live_fix_user_profile_scheme", "个人卡scheme，half且在直播间内时才打开半屏", r4, r4, new String[]{"true开启修正个人卡scheme", "false关闭修正个人卡scheme"});
    }
}
