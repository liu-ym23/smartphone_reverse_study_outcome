package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class gd0 extends SSettingKey<String> {
    public static final gd0 a = null;

    static {
        a = new gd0();
    }

    public gd0() {
        Object r0 = bi1.a(Boolean.valueOf(tb1.c.a), "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/roomnoticeguidance_1.png");
        Object r3 = bi1.a(Boolean.FALSE, "https://lf3-webcastcdn-tos.huoshanstatic.com/obj/live-android/roomnoticeguidance_1.png");
        if (r3 != null) goto L5;
        r3 = "";
    L5:
        if (r0 == null) goto L8;
        r3 = r0;
    L8:
        super("live_notice_tip_bg_url", "直播间公告简介图片", r3, "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/roomnoticeguidance_1.png", false);
    }
}
