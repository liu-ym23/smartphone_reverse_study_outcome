package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class yj extends SSettingKey<String> {
    public static final yj a = null;

    static {
        a = new yj();
    }

    public yj() {
        boolean r0 = tb1.c.a;
        String r4 = "";
        if (r0 == false) goto L5;
        Object r5 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/h5/security_live_report_h5_douyin/template/pages/AudioCommentReport.html";
    L6:
        if (r0 == false) goto L8;
        r4 = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/h5/security_live_report_h5_douyin/template/pages/AudioCommentReport.html";
    L8:
        super("live_channel_link_report_url", "频道房语音用户举报页的url", r5, r4, false);
        return;
    L5:
        r5 = "";
        goto L6
    }
}
