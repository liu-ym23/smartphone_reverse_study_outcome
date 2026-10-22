package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class fd1 extends SSettingKey<Boolean> {
    public static final fd1 a = null;

    static {
        a = new fd1();
    }

    public fd1() {
        Boolean r1 = Boolean.TRUE;
        super("paidlive_enable_ticket_creation_in_room", "是否支持直播间内创建预售门票", r1, r1);
    }
}
