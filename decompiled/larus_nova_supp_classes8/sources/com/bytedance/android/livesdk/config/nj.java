package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nj extends SSettingKey<Boolean> {
    public static final nj a = null;

    static {
        a = new nj();
    }

    public nj() {
        Boolean r4 = Boolean.TRUE;
        super("live_sdk_cast_screen_phone_adapter_type_setting", "直播间投屏弹窗部分机型跳动问题（黑名单开关）", r4, r4, true);
    }
}
