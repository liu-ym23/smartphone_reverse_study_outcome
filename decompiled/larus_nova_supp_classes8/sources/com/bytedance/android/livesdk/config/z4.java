package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class z4 extends SSettingKey<Boolean> {
    public static final z4 a = null;

    static {
        a = new z4();
    }

    public z4() {
        Boolean r4 = Boolean.FALSE;
        super("fix_dumplication_room_stop_opt", "优化直播兜底退房逻辑", r4, r4, true);
    }
}
