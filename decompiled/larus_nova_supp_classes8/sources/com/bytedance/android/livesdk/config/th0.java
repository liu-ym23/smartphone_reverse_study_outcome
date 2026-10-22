package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class th0 extends SSettingKey<Boolean> {
    public static final th0 a = null;

    static {
        a = new th0();
    }

    public th0() {
        Boolean r1 = Boolean.TRUE;
        super("live_pk_update_is_engine_on_enable", "兜底修复聊天室嘉宾侧提前进房badcase导致的crash", r1, r1);
    }
}
