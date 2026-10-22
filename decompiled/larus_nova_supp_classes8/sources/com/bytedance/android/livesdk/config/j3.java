package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j3 extends SSettingKey<Boolean> {
    public static final j3 a = null;

    static {
        a = new j3();
    }

    public j3() {
        Boolean r1 = Boolean.FALSE;
        super("enable_interpose_similar_room", "false 线上组true 在房间内观看三分钟强插相似直播", r1, r1);
    }
}
