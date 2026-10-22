package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class h80 extends SSettingKey<Boolean> {
    public static final h80 a = null;

    static {
        a = new h80();
    }

    public h80() {
        super("live_mem_leak_screen_observer", "修复：屏幕监听内存泄漏问题", Boolean.FALSE, Boolean.TRUE);
    }
}
