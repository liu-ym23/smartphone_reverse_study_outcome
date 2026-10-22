package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yh extends SSettingKey<Boolean> {
    public static final yh a = null;

    static {
        a = new yh();
    }

    public yh() {
        Boolean r4 = Boolean.FALSE;
        super("live_broadcast_shared_for_audience_from_impl", "主看播解耦代码抽离", r4, r4, true);
    }
}
