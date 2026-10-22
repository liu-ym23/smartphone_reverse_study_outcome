package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nk0 extends SSettingKey<Boolean> {
    public static final nk0 a = null;

    static {
        a = new nk0();
    }

    public nk0() {
        Boolean r1 = Boolean.FALSE;
        super("live_pre_stream_danmaku_default_open_enable", "直播预览流弹幕30-&高端机用户默认打开策略开关", r1, r1);
    }
}
