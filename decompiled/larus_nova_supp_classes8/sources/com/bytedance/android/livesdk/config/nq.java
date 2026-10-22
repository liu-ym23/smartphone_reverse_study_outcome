package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nq extends SSettingKey<Boolean> {
    public static final nq a = null;

    static {
        a = new nq();
    }

    public nq() {
        super("live_enable_adjust_full_display", Boolean.FALSE, "开播预览页是否适配全面屏");
    }
}
