package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kq extends SSettingKey<Boolean> {
    public static final kq a = null;

    static {
        a = new kq();
    }

    public kq() {
        Boolean r1 = Boolean.FALSE;
        super("enable_live_online_resources", "直播特效拉取线上资源", r1, r1);
    }
}
