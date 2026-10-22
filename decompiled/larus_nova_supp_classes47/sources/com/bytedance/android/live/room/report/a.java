package com.bytedance.android.live.room.report;

import com.bytedance.android.live.room.api.report.ReportObject;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final /* synthetic */ class a {
    public static final /* synthetic */ int[] a = null;
    public static final /* synthetic */ int[] b = null;
    public static final /* synthetic */ int[] c = null;
    public static final /* synthetic */ int[] d = null;

    static {
        int[] r0 = new int[LiveMode.values().length];
        a = r0;
        LiveMode r1 = LiveMode.AUDIO;
        r0[r1.ordinal()] = 1;
        LiveMode r2 = LiveMode.THIRD_PARTY;
        r0[r2.ordinal()] = 2;
        int[] r3 = new int[ReportObject.values().length];
        b = r3;
        r3[ReportObject.DHXT_Link_OR_PK.ordinal()] = 1;
        r3[ReportObject.XT_Anchor_OR_XT_No_Link_PK.ordinal()] = 2;
        r3[ReportObject.DH_Anchor.ordinal()] = 3;
        r3[ReportObject.Comment.ordinal()] = 4;
        r3[ReportObject.ChannelLink.ordinal()] = 5;
        r3[ReportObject.PPX.ordinal()] = 6;
        r3[ReportObject.XT.ordinal()] = 7;
        r3[ReportObject.Hotsoon_Or_Vigo.ordinal()] = 8;
        r3[ReportObject.User.ordinal()] = 9;
        int[] r4 = new int[LiveMode.values().length];
        c = r4;
        r4[r1.ordinal()] = 1;
        r4[r2.ordinal()] = 2;
        r4[LiveMode.SCREEN_RECORD.ordinal()] = 3;
        int[] r5 = new int[LiveMode.values().length];
        d = r5;
        r5[r1.ordinal()] = 1;
        r5[r2.ordinal()] = 2;
    }
}
