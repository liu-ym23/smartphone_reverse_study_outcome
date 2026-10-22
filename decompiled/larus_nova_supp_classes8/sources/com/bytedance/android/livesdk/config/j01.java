package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j01 extends SSettingKey<Boolean> {
    public static final j01 a = null;

    static {
        a = new j01();
    }

    public j01() {
        Boolean r1 = Boolean.TRUE;
        super("location_in_mainland", "是否为大陆地区用户，通过肉身位置判断（获取 geo_name_id 失败时也认为是）", r1, r1);
    }
}
