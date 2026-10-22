package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ax extends SSettingKey<Boolean> {
    public static final ax a = null;

    static {
        a = new ax();
    }

    public ax() {
        Boolean r1 = Boolean.TRUE;
        super("live_float_window_exit_resume_normal", "小窗OnClose时是否调用resumeNormal (解决节目直播房间内小窗关闭后不恢复拉流)", r1, r1);
    }
}
