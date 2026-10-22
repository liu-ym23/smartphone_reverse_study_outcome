package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ww extends SSettingKey<Boolean> {
    public static final ww a = null;

    static {
        a = new ww();
    }

    public ww() {
        Boolean r4 = Boolean.FALSE;
        super("live_fix_start_room_context_error", "修复StartRoom时Context为null的问题", r4, r4, true);
    }
}
