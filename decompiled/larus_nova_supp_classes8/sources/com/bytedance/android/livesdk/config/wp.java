package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class wp extends SSettingKey<Boolean> {
    public static final wp a = null;

    static {
        a = new wp();
    }

    public wp() {
        Boolean r1 = Boolean.TRUE;
        super("live_dynamic_not_send_seat_list", "命中Lynx麦位时屏蔽向动态化发送seat_list", r1, r1);
    }
}
