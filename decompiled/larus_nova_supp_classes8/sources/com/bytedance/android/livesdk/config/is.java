package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class is extends SSettingKey<Boolean> {
    public static final is a = null;

    static {
        a = new is();
    }

    public is() {
        Boolean r1 = Boolean.FALSE;
        super("live_enable_multi_link_join_room_in_advance", "多人场景建联提前建联优化", r1, r1);
    }
}
