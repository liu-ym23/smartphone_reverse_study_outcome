package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class kw extends SSettingKey<Boolean> {
    public static final kw a = null;

    static {
        a = new kw();
    }

    public kw() {
        Boolean r4 = Boolean.FALSE;
        super("live_fix_end_room_with_init", "init状态执行退房问题修复", r4, r4, true);
    }
}
