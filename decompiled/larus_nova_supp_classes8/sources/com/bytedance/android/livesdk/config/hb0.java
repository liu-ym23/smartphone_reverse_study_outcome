package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class hb0 extends SSettingKey<Boolean> {
    public static final hb0 a = null;

    static {
        a = new hb0();
    }

    public hb0() {
        Boolean r1 = Boolean.TRUE;
        super("live_multi_link_guest_player_view_sei_update_timeout_switch", "多人场景观众seiVersion更新过期开关", r1, r1);
    }
}
