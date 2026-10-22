package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class id1 extends SSettingKey<Boolean> {
    public static final id1 a = null;

    static {
        a = new id1();
    }

    public id1() {
        Boolean r1 = Boolean.TRUE;
        super("paused_live_forbid_auto_play", "暂停状态的直播切后台/前台不自动拉流", r1, r1);
    }
}
