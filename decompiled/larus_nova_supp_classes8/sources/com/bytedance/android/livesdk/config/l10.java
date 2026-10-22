package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l10 extends SSettingKey<Boolean> {
    public static final l10 a = null;

    static {
        a = new l10();
    }

    public l10() {
        Boolean r4 = Boolean.FALSE;
        super("live_inner_feed_distic_room_for_uniquekey", "内流重建根据uniquekey", r4, r4, true);
    }
}
