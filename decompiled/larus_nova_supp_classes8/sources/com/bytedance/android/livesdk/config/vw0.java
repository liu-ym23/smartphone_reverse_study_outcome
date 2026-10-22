package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vw0 extends SSettingKey<Boolean> {
    public static final vw0 a = null;

    static {
        a = new vw0();
    }

    public vw0() {
        Boolean r1 = Boolean.TRUE;
        super("live_video_chorus_feature_enable", "观众加载视频合唱开关", r1, r1);
    }
}
