package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jf0 extends SSettingKey<Boolean> {
    public static final jf0 a = null;

    static {
        a = new jf0();
    }

    public jf0() {
        super("live_paid_room_change_to_scope", "付费直播迁移至scope", Boolean.FALSE, Boolean.TRUE);
    }
}
