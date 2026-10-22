package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fh0 extends SSettingKey<Boolean> {
    public static final fh0 a = null;

    static {
        a = new fh0();
    }

    public fh0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_interact_audience_permission_guarantor_enable", "PK中观众连线音视频权限释放白名单页面机制开关", r1, r1);
    }
}
