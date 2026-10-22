package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nr extends SSettingKey<Boolean> {
    public static final nr a = null;

    static {
        a = new nr();
    }

    public nr() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_enterunsuccess_eventtrack", "进入房间失败或者首帧读取失败时是否停止发送duration埋点信息", r1, r1);
    }
}
