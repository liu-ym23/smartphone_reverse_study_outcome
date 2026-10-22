package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class pi extends SSettingKey<Boolean> {
    public static final pi a = null;

    static {
        a = new pi();
    }

    public pi() {
        Boolean r1 = Boolean.FALSE;
        super("live_broadcast_use_room_continue_in_go_end_page", "直接进关播页使用room/continue", r1, r1);
    }
}
