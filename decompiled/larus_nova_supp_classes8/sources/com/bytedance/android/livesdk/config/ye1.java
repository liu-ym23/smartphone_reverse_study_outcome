package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ye1 extends SSettingKey<Boolean> {
    public static final ye1 a = null;

    static {
        a = new ye1();
    }

    public ye1() {
        Boolean r1 = Boolean.TRUE;
        super("release_av_permission_when_close_notification_on_background", "手动在后台关闭通知栏权限，释放音视频采集权限", r1, r1);
    }
}
