package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kk0 extends SSettingKey<Boolean> {
    public static final kk0 a = null;

    static {
        a = new kk0();
    }

    public kk0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pre_mix_interaction_asset_android_enable", "预览流轻交互是否请求点赞icon", r1, r1);
    }
}
