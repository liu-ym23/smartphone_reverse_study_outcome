package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yy0 extends SSettingKey<Boolean> {
    public static final yy0 a = null;

    static {
        a = new yy0();
    }

    public yy0() {
        Boolean r1 = Boolean.FALSE;
        super("live_widget_sync_preload_enable", "直播widget同步预加载开关", r1, r1);
    }
}
