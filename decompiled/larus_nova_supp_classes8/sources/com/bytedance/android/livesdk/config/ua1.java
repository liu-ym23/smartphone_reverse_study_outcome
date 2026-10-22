package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ua1 extends SSettingKey<Boolean> {
    public static final ua1 a = null;

    static {
        a = new ua1();
    }

    public ua1() {
        Boolean r1 = Boolean.FALSE;
        super("multi_link_room_cache_enable", "多人场景是否启用roomCache机制", r1, r1);
    }
}
