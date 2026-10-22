package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ok0 extends SSettingKey<Boolean> {
    public static final ok0 a = null;

    static {
        a = new ok0();
    }

    public ok0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pre_stream_danmaku_use_independent_view", "直播预流弹幕使用独立view", r1, r1);
    }
}
