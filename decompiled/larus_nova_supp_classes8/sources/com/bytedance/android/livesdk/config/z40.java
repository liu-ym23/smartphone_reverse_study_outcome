package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z40 extends SSettingKey<Boolean> {
    public static final z40 a = null;

    static {
        a = new z40();
    }

    public z40() {
        Boolean r1 = Boolean.FALSE;
        super("live_ktv_room_memory_leak_fix", "K歌内存泄漏统一修复", r1, r1);
    }
}
