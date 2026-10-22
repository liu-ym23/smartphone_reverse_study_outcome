package com.bytedance.awemeopen.share.serviceapi;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/share/serviceapi/AoShareChannel;", "", "Wechat", "WechatTimeline", "QQ", "QQZone", "Weibo", "FeiShu", "Copy", "Cancel", "ao_share_service_api_release"}, k = 1, mv = {1, 7, 1})
public final enum AoShareChannel extends Enum<AoShareChannel> {
    public static final AoShareChannel Cancel = null;
    public static final AoShareChannel Copy = null;
    public static final AoShareChannel FeiShu = null;
    public static final AoShareChannel QQ = null;
    public static final AoShareChannel QQZone = null;
    public static final AoShareChannel Wechat = null;
    public static final AoShareChannel WechatTimeline = null;
    public static final AoShareChannel Weibo = null;
    public static final /* synthetic */ AoShareChannel[] a = null;

    public static AoShareChannel valueOf(String r1) {
        return (AoShareChannel) a.a(AoShareChannel.class, r1);
    }

    public static AoShareChannel[] values() {
        return (AoShareChannel[]) a.clone();
    }

    static {
        AoShareChannel r0 = new AoShareChannel("Wechat", 0);
        Wechat = r0;
        AoShareChannel r1 = new AoShareChannel("WechatTimeline", 1);
        WechatTimeline = r1;
        AoShareChannel r3 = new AoShareChannel("QQ", 2);
        QQ = r3;
        AoShareChannel r5 = new AoShareChannel("QQZone", 3);
        QQZone = r5;
        AoShareChannel r7 = new AoShareChannel("Weibo", 4);
        Weibo = r7;
        AoShareChannel r9 = new AoShareChannel("FeiShu", 5);
        FeiShu = r9;
        AoShareChannel r11 = new AoShareChannel("Copy", 6);
        Copy = r11;
        AoShareChannel r13 = new AoShareChannel("Cancel", 7);
        Cancel = r13;
        a = new AoShareChannel[]{r0, r1, r3, r5, r7, r9, r11, r13};
    }

    public AoShareChannel(String r1, int r2) {
        super(r1, r2);
    }
}
