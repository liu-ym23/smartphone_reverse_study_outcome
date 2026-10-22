package com.bytedance.android.live.liveinteract.floatwindow.onlinewindow;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.linksecurity.CheckAudienceLinkersResponse;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.kmp.live.livelink.api.multilink.api.LinkSecurityApi;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l<T> implements Consumer {
    public final /* synthetic */ LinkmicOnlineFloatWindowManager a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;

    public l(LinkmicOnlineFloatWindowManager r1, long r2) {
        this.a = r1;
        this.b = "small_window";
        this.c = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r7) {
        ExtraResponse r8 = (ExtraResponse) r7;
        TalkRoomBusinessFullLinkMonitor r0 = TalkRoomBusinessFullLinkMonitor.a;
        String r1 = this.b;
        long r2 = this.c;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "requestSource");
        Intrinsics.checkNotNullParameter(r8, "response");
        JSONObject r3 = new JSONObject();
        r3.put("request_source", r1);
        r3.put("action_type", ((CheckAudienceLinkersResponse) r8.data).getAction());
        TalkRoomBusinessFullLinkMonitor.Z(LinkMonitorData.LinkOnlineFloatWindowCheckAudienceLinkers, TalkRoomBusinessFullLinkMonitor.h(r2), r8.logId, r3);
        CheckAudienceLinkersResponse r9 = (CheckAudienceLinkersResponse) r8.data;
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.getSleepSecond() <= 1) goto L7;
        this.a.W = r9.getSleepSecond();
    L7:
        LinkmicOnlineFloatWindowManager r4 = this.a;
        int r10 = r9.getAction();
        r4.getClass();
        View r5 = null;
        if (r10 != LinkSecurityApi.CheckAudienceLinkersAction.CheckAudienceLinkersAction_Silence.ordinal()) goto L24;
        LinkmicOnlineFloatWindowManager.t("call handleCheckAudienceLinkersAction, action = " + r10);
        r4.B(2);
        rx1.g r6 = LinkmicOnlineFloatWindowManager.m();
        if (r6 == null) goto L14;
        rx1.f r11 = r6.a;
        if (r11 == null) goto L14;
        View r12 = r11.c;
    L16:
        if ((r12 instanceof b) == false) goto L19;
        r5 = r12;
    L19:
        b r13 = (b) r5;
        if (r13 == null) goto L22;
        r13.a(true);
    L22:
        r4.y(false, "linkFloatWindow check_audience_linkers action=" + r10);
        return;
    L14:
        r12 = null;
        goto L16
    L24:
        if (r10 == LinkSecurityApi.CheckAudienceLinkersAction.CheckAudienceLinkersAction_UnSilence.ordinal()) goto L33;
        LinkSecurityApi.CheckAudienceLinkersAction r14 = LinkSecurityApi.CheckAudienceLinkersAction.CheckAudienceLinkersAction_Leave;
        if (r10 != r14.ordinal()) goto L32;
        LinkmicOnlineFloatWindowManager.t("call handleCheckAudienceLinkersAction, action = " + r10);
        LinkmicOnlineFloatWindowManager.k(r4, Integer.valueOf(r14.ordinal()), null, 2);
        return;
    L32:
        return;
    }
}
