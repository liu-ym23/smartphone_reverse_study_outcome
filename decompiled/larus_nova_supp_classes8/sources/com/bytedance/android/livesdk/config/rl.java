package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rl extends SSettingKey<Boolean> {
    public static final rl a = null;

    static {
        a = new rl();
    }

    public rl() {
        Boolean r1 = Boolean.TRUE;
        super("live_commerce_mini_window_start_fix", "兜底修复店铺页进入直播间偶现异常吊起小窗逻辑", r1, r1);
    }
}
