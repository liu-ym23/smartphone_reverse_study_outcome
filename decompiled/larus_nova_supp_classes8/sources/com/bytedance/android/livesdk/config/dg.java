package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class dg extends SSettingKey<Boolean> {
    public static final dg a = null;

    static {
        a = new dg();
    }

    public dg() {
        Boolean r1 = Boolean.FALSE;
        super("live_back_same_room_optimize", "返回同一直播间bugfix", r1, r1);
    }
}
