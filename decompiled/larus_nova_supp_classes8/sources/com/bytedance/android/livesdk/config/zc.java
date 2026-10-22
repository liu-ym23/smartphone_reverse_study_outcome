package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class zc extends SSettingKey<Integer> {
    public static final zc a = null;

    static {
        a = new zc();
    }

    public zc() {
        super("live_anchor_status_center_gesture_trigger_threshold", "手势触发阈值，默认50", 50, 50);
    }
}
