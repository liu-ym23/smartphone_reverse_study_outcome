package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dr extends SSettingKey<Boolean> {
    public static final dr a = null;

    static {
        a = new dr();
    }

    public dr() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_brightness_change", "是否允许直播视频亮度调节", r1, r1);
    }
}
