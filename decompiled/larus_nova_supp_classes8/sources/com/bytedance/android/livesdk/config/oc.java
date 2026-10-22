package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class oc extends SSettingKey<String> {
    public static final oc a = null;

    static {
        a = new oc();
    }

    public oc() {
        boolean r0 = tb1.c.a;
        String r4 = "";
        if (r0 == false) goto L5;
        Object r5 = "https://webcast.amemv.com/falcon/webcast_douyin/page/report_live/main/index.html";
    L6:
        if (r0 == false) goto L8;
        r4 = "https://webcast.amemv.com/falcon/webcast_douyin/page/report_live/main/index.html";
    L8:
        super("live_anchor_report_url", "中台主播举报页的url", r5, r4, false);
        return;
    L5:
        r5 = "";
        goto L6
    }
}
