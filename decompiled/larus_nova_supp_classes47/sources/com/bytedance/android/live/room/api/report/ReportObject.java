package com.bytedance.android.live.room.api.report;

import kotlin.Deprecated;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/room/api/report/ReportObject;", "", "DHXT_Link_OR_PK", "XT_Anchor_OR_XT_No_Link_PK", "DH_Anchor", "Comment", "ChannelLink", "PPX", "XT", "Hotsoon_Or_Vigo", "User", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ReportObject extends Enum<ReportObject> {
    public static final ReportObject ChannelLink = null;
    public static final ReportObject Comment = null;
    public static final ReportObject DHXT_Link_OR_PK = null;
    public static final ReportObject DH_Anchor = null;

    @Deprecated(message = "火山已经融合进抖音")
    public static final ReportObject Hotsoon_Or_Vigo = null;

    @Deprecated(message = "不再支持Ppx")
    public static final ReportObject PPX = null;
    public static final ReportObject User = null;

    @Deprecated(message = "不再支持西头")
    public static final ReportObject XT = null;

    @Deprecated(message = "不再支持西头")
    public static final ReportObject XT_Anchor_OR_XT_No_Link_PK = null;
    public static final /* synthetic */ ReportObject[] a = null;

    static {
        ReportObject r1 = new ReportObject("DHXT_Link_OR_PK", 0);
        DHXT_Link_OR_PK = r1;
        ReportObject r2 = new ReportObject("XT_Anchor_OR_XT_No_Link_PK", 1);
        XT_Anchor_OR_XT_No_Link_PK = r2;
        ReportObject r3 = new ReportObject("DH_Anchor", 2);
        DH_Anchor = r3;
        ReportObject r4 = new ReportObject("Comment", 3);
        Comment = r4;
        ReportObject r5 = new ReportObject("ChannelLink", 4);
        ChannelLink = r5;
        ReportObject r6 = new ReportObject("PPX", 5);
        PPX = r6;
        ReportObject r7 = new ReportObject("XT", 6);
        XT = r7;
        ReportObject r8 = new ReportObject("Hotsoon_Or_Vigo", 7);
        Hotsoon_Or_Vigo = r8;
        ReportObject r9 = new ReportObject("User", 8);
        User = r9;
        a = new ReportObject[]{r1, r2, r3, r4, r5, r6, r7, r8, r9};
    }

    public static ReportObject valueOf(String r1) {
        return (ReportObject) a.a(ReportObject.class, r1);
    }

    public static ReportObject[] values() {
        return (ReportObject[]) a.clone();
    }

    public ReportObject(String r1, int r2) {
        super(r1, r2);
    }
}
