package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p2 extends SSettingKey<Boolean> {
    public static final p2 a = null;

    static {
        a = new p2();
    }

    public p2() {
        Boolean r1 = Boolean.TRUE;
        super("drawer_similar_room_merge", "抽屉内相似直播的类型 false：普通相似直播  true：聚合相似直播", r1, r1);
    }
}
