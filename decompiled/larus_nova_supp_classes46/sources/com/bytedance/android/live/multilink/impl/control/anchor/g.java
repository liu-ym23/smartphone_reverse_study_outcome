package com.bytedance.android.live.multilink.impl.control.anchor;

import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.i;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.live.multilink.impl.LinkMultiControlPresenter;
import com.bytedance.android.live.multilink.impl.s0;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import java.util.LinkedHashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ MultiControlAnchorService a;
    public final /* synthetic */ long b;
    public final /* synthetic */ c c;

    public g(MultiControlAnchorService r1, long r2, LinkMultiControlPresenter.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }

    public final void accept(Object r22) {
        ExtraResponse r1 = (ExtraResponse) r22;
        this.a.a = false;
        com.bytedance.android.livesdk.message.linker.h r2 = (com.bytedance.android.livesdk.message.linker.h) r1.data;
        TalkRoomBusinessFullLinkMonitor r3 = TalkRoomBusinessFullLinkMonitor.a;
        long r4 = this.b;
        r3.getClass();
        Intrinsics.checkNotNullParameter(r1, "response");
        TalkRoomBusinessFullLinkMonitor.Z(LinkMonitorData.GetLinkMicInfoWithRtcInfoApiMonitorData, TalkRoomBusinessFullLinkMonitor.h(r4), r1.logId, new JSONObject());
        String r5 = ((com.bytedance.android.livesdk.message.linker.h) r1.data).getLiveCoreExtInfo();
        com.bytedance.android.livesdk.message.linker.b r6 = ((com.bytedance.android.livesdk.message.linker.h) r1.data).getMainAnchorLinkmicInfo();
        IRoom r7 = null;
        if (r6 == null) goto L5;
        String r8 = r6.getRtcExtInfo();
    L6:
        InteractLinkFullLinkMonitor.t0("resume_live_success", r5, r8, null, null);
        MultiControlAnchorService r9 = this.a;
        r9.getClass();
        if (r2.getScene() != 5) goto L9;
    L15:
        Intrinsics.checkNotNullParameter(r2, "$this$checkIsLegalExt");
        if (r2.checkIsLegal() == true) goto L33;
        HashMap r10 = new HashMap();
        r10.put("error", "rtcResponse.data checkIsLegal is false");
        if (r2.getMainAnchorLinkmicInfo() != null) goto L20;
        r10.put("errorMsg", "mainAnchorLinkmicInfo is null");
    L32:
        j0 r14 = null;
    L42:
        int r20 = this.a.b(r2.getScene());
        c r11 = this.c;
        if (r11 == null) goto L69;
        String r12 = r1.logId;
        LinkMultiControlPresenter.a r13 = (LinkMultiControlPresenter.a) r11;
        if (r13.a.j == false) goto L48;
        ((IInteractService) k.f(IInteractService.class)).updateVideoTalkRoomOpenSource(r2.getFunctionType());
    L48:
        if (vm2.d.v0() == false) goto L52;
        int r15 = i.a;
        Intrinsics.checkNotNullParameter(r2, "rtcResponse");
        Intrinsics.checkNotNullParameter(r12, "logId");
        LinkedHashMap r16 = new LinkedHashMap();
        r16.put("reason", "get_linkmic_info_with_rtc_info_api");
        r16.put("log_id", r12);
        if (vm2.d.v0() == false) goto L52;
        i.h(r2.getFunctionType(), r16);
    L52:
        String r17 = r2.toString();
        int r18 = x.a;
        Intrinsics.checkNotNullParameter(r17, "continueInfo");
        LinkedHashMap r19 = new LinkedHashMap();
        r19.put("continue_info", r17);
        x.t0("anchor_continue_room_linkmic_success", r19);
        int r21 = s0.a;
        u r23 = r13.a.m;
        if (r23 == null) goto L57;
        j r24 = r23.getVideoTalkRoomSubScene();
        if (r24 == null) goto L57;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r25 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r24.getValue();
    L58:
        if (r25 == null) goto L60;
        ((com.bytedance.android.livesdk.chatroom.viewmodel.e) r13.a.m.getVideoTalkRoomSubScene().getValue()).e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(r2.getScene(), r2.getPlayModes(), r2.getUiLayout(), false, r2.getClientUIInfo()));
    L60:
        o r26 = r13.a.w;
        if (r26 == null) goto L65;
        m r27 = r26.getRoom();
        if (r27 == null) goto L65;
        r7 = (IRoom) r27.getValue();
    L65:
        if (r7 == null) goto L67;
        ((IRoom) r13.a.w.getRoom().getValue()).setLinkInitResult(r14);
    L67:
        LinkMultiControlPresenter.k0(r13.a, r14, true, r2.getScene(), true, true, "", r20);
        ((q46.b) r13.a).a.JT(r2);
        return;
    L57:
        r25 = null;
        goto L58
    L69:
        return;
    L20:
        com.bytedance.android.livesdk.message.linker.b r28 = r2.getMainAnchorLinkmicInfo();
        String r29 = "";
        if (r28 == null) goto L24;
        String r30 = r28.getRtcExtInfo();
        if (r30 == null) goto L24;
    L25:
        r10.put("rtcExtInfo", r30);
        com.bytedance.android.livesdk.message.linker.b r31 = r2.getMainAnchorLinkmicInfo();
        if (r31 == null) goto L31;
        String r32 = r31.getLinkmicIdStr();
        if (r32 == null) goto L31;
        r29 = r32;
    L31:
        r10.put("linkmicIdStr", r29);
    L24:
        r30 = "";
        goto L25
    L33:
        j0 r33 = (j0) vh7.f.c(j0.class);
        com.bytedance.android.livesdk.message.linker.b r34 = r2.getMainAnchorLinkmicInfo();
        if (r34 == null) goto L36;
        String r35 = r34.getLinkmicIdStr();
    L37:
        r33.setLinkMicIdStr(r35);
        r33.setVendor(r2.getVendor());
        com.bytedance.android.livesdk.message.linker.b r36 = r2.getMainAnchorLinkmicInfo();
        if (r36 == null) goto L40;
        String r37 = r36.getRtcExtInfo();
    L41:
        r33.setRtcExtInfo(r37);
        String r38 = r2.getSubRtcExtInfo();
        Intrinsics.checkNotNullParameter(r33, "$this$setSubRtcExtInfoExt");
        r33.setSubRoomToken(r38);
        r33.setChorusCDNInfo(r2.getChorusCDNInfo());
        r33.setLiveCoreExtInfo(r2.getLiveCoreExtInfo());
        r33.setSupportVideo(r2.isSupportUpdateLinkType());
        r33.setPlayModes(r2.getPlayModes());
        r33.setUiLayout(r2.getUiLayout());
        r33.setMultiRtcInfo(r2.getMultiRtcInfo());
        r33.setMultiLiveCoreInfo(r2.getMultiLiveCoreInfo());
        r9.c(r33, true, r2.getScene(), true, true);
        r14 = r33;
        goto L42
    L40:
        r37 = null;
        goto L41
    L36:
        r35 = null;
        goto L37
    L9:
        if (r2.getScene() == 8) goto L15;
        if (r2.getScene() == 9) goto L15;
        if (r2.getScene() == 12) goto L15;
    L5:
        r8 = null;
        goto L6
    }
}
