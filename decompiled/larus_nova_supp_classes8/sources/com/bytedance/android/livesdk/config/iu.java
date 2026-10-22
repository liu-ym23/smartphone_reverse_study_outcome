package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class iu extends SSettingKey<Boolean> {
    public static final iu a = null;

    static {
        a = new iu();
    }

    public iu() {
        Boolean r1 = Boolean.TRUE;
        super("live_enter_room_comtroller_mem_fix", "进房controller内存泄露修复", r1, r1);
    }
}
