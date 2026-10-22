package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class am0 extends SSettingKey<Boolean> {
    public static final am0 a = null;

    static {
        a = new am0();
    }

    public am0() {
        Boolean r1 = Boolean.FALSE;
        super("live_real_time_chorus_concert_first_frame_visible_enable", "实时合唱演唱会首帧渲染回调可见性设置", r1, r1);
    }
}
