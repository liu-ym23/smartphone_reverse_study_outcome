package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class ds extends SSettingKey<Boolean> {
    public static final ds a = null;

    static {
        a = new ds();
    }

    public ds() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_live_more_float_room_list_fix", "内流直播广场跳转保存列表信息", r1, r1);
    }
}
