package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class jf1 extends SSettingKey<Boolean> {
    public static final jf1 a = null;

    static {
        a = new jf1();
    }

    public jf1() {
        Boolean r4 = Boolean.FALSE;
        super("room_stop_opt_not_limit_scene", "直播兜底退房逻辑不限制场景", r4, r4, true);
    }
}
