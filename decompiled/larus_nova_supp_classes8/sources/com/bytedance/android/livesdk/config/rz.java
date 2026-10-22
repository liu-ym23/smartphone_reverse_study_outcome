package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class rz extends SSettingKey<Boolean> {
    public static final rz a = null;

    static {
        a = new rz();
    }

    public rz() {
        Boolean r1 = Boolean.TRUE;
        super("live_h5_share_with_im_extra", "h5分享是否透传imExtra字段", r1, r1);
    }
}
