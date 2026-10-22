package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class nh extends SSettingKey<Boolean> {
    public static final nh a = null;

    static {
        a = new nh();
    }

    public nh() {
        Boolean r1 = Boolean.TRUE;
        super("live_broadcast_new_link_no_pause_when_jump", "跳厅不pause直播间", r1, r1);
    }
}
