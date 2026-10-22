package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ow extends SSettingKey<Boolean> {
    public static final ow a = null;

    static {
        a = new ow();
    }

    public ow() {
        Boolean r4 = Boolean.TRUE;
        super("live_fix_in_live_room_condition", "修改直播间内场景判断", r4, r4, true);
    }
}
