package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xk extends SSettingKey<Boolean> {
    public static final xk a = null;

    static {
        a = new xk();
    }

    public xk() {
        Boolean r1 = Boolean.TRUE;
        super("live_clear_screen_fling_exit", "是否支持在清屏状态下右滑退出直播间的兜底开关", r1, r1);
    }
}
