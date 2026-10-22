package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class c5 extends SSettingKey<Boolean> {
    public static final c5 a = null;

    static {
        a = new c5();
    }

    public c5() {
        Boolean r1 = Boolean.TRUE;
        super("fix_live_room_fragment_destroy", "修复混排场景LiveRoomFragment泄漏", r1, r1);
    }
}
