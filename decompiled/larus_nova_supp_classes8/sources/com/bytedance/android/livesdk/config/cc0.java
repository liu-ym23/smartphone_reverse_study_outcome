package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class cc0 extends SSettingKey<Boolean> {
    public static final cc0 a = null;

    static {
        a = new cc0();
    }

    public cc0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_lint_room_fight_stream_manager_fix", "跨房对战订阅对方直播间静音问题修复", r1, r1);
    }
}
