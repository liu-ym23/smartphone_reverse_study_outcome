package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class tw extends SSettingKey<Boolean> {
    public static final tw a = null;

    static {
        a = new tw();
    }

    public tw() {
        Boolean r1 = Boolean.TRUE;
        super("live_fix_room_id_inner_quick_switch", "修复搜索内流上下划，roomID错误导致直播间信息错误", r1, r1);
    }
}
