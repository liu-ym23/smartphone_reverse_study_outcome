package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class vy0 extends SSettingKey<Boolean> {
    public static final vy0 a = null;

    static {
        a = new vy0();
    }

    public vy0() {
        Boolean r1 = Boolean.FALSE;
        super("live_widget_async_preload_enable", "直播widget异步预加载开关", r1, r1);
    }
}
