package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class m4 extends SSettingKey<String> {
    public static final m4 a = null;

    static {
        a = new m4();
    }

    public m4() {
        super("live_exchange_certification_url", "兑换拦截实名认证url", "https://webcast.amemv.com/falcon/webcast_douyin/page/certification/index.html?hide_nav_bar=1&__live_platform__=webcast", "https://webcast.amemv.com/falcon/webcast_douyin/page/certification/index.html?hide_nav_bar=1&__live_platform__=webcast", false);
    }
}
