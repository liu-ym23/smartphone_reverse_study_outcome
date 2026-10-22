package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yg0 extends SSettingKey<String> {
    public static final yg0 a = null;

    static {
        a = new yg0();
    }

    public yg0() {
        Object r0 = bi1.a(Boolean.valueOf(tb1.c.a), "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_bottom_bg_denoise2.png");
        Boolean r3 = Boolean.FALSE;
        Object r4 = bi1.a(r3, "https://lf1-webcastcdn-tos.huoshanstatic.com/obj/live-android/ttlive_pk_bottom_bg_denoise2.png");
        Object r5 = bi1.a(r3, "https://lf1-webcastcdn-tos.bdxiguastatic.com/obj/live-android/ttlive_pk_bottom_bg_denoise2.png");
        if (r5 != null) goto L5;
        r5 = "https://lf1-webcastcdn-tos.toutiaostatic.com/obj/live-android/ttlive_pk_bottom_bg_denoise2.png";
    L5:
        if (r4 != null) goto L7;
        r4 = r5;
    L7:
        if (r0 != null) goto L9;
        Object r6 = r4;
    L10:
        super("live_pk_denoise_bottom_bg_url", "降噪后的pk观众端底部背景图", r6, "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_pk_bottom_bg_denoise2.png", false);
        return;
    L9:
        r6 = r0;
        goto L10
    }
}
