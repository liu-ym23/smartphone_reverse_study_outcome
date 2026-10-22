package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class qh extends SSettingKey<Boolean> {
    public static final qh a = null;

    static {
        a = new qh();
    }

    public qh() {
        Boolean r1 = Boolean.FALSE;
        super("live_broadcast_pause_enable", "主播主动暂停功能开关", r1, r1);
    }
}
