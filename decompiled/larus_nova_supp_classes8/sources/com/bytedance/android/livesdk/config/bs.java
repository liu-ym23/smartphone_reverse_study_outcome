package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class bs extends SSettingKey<Boolean> {
    public static final bs a = null;

    static {
        a = new bs();
    }

    public bs() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_linkmic_apply_float_window", "多人连线等待小窗是否全量", r1, r1);
    }
}
