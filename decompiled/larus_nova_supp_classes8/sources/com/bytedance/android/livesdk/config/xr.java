package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xr extends SSettingKey<Boolean> {
    public static final xr a = null;

    static {
        a = new xr();
    }

    public xr() {
        Boolean r1 = Boolean.TRUE;
        super("live_enable_insert_room_business", "是否开启强插直播间能力", r1, r1);
    }
}
