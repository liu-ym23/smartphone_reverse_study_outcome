package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z60 extends SSettingKey<Boolean> {
    public static final z60 a = null;

    static {
        a = new z60();
    }

    public z60() {
        Boolean r1 = Boolean.FALSE;
        super("live_loading_new_style", "直播Loading是否采用骨架屏样式", r1, r1);
    }
}
