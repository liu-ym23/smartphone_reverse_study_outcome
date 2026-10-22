package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class xi0 extends SSettingKey<String> {
    public static final xi0 a = null;

    static {
        a = new xi0();
    }

    public xi0() {
        if (tb1.c.a == false) goto L5;
        String r0 = "https://webcast.amemv.com/falcon/webcast_douyin/page/popularity_card/popularity_card_effective/index.html";
    L6:
        super("live_popularity_card_url", "人气卡入口url", r0, "https://webcast.amemv.com/falcon/webcast_douyin/page/popularity_card/popularity_card_effective/index.html", false);
        return;
    L5:
        r0 = "https://webcast.ixigua.com/falcon/webcast_xigua/page/popularity_card/popularity_card_effective/index.html";
        goto L6
    }
}
