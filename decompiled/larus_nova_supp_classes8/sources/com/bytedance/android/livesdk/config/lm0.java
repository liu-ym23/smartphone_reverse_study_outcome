package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class lm0 extends SSettingKey<Boolean> {
    public static final lm0 a = null;

    static {
        a = new lm0();
    }

    public lm0() {
        Boolean r1 = Boolean.TRUE;
        super("live_recommend_insert_room_enable", "推荐完成后强插直播间开关", r1, r1);
    }
}
