package com.bytedance.android.live.liveinteract.videotalk.utils;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.MultiLinkOpenSource;
import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.interact.j0;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.circleinfo.ICircleInfo;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r<T> implements Consumer {
    public final /* synthetic */ o a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;
    public final /* synthetic */ Ref.ObjectRef d;

    public r(o r1, long r2, int r4, Ref.ObjectRef r5) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
    }

    public final void accept(Object r15) {
        com.bytedance.android.live.network.response.e r16 = (com.bytedance.android.live.network.response.e) r15;
        Intrinsics.checkNotNull(r16);
        DATA r0 = r16.data;
        Intrinsics.checkNotNull(r0);
        com.bytedance.android.live.liveinteract.plantform.utils.i.d((j0) r0, r16.logId);
        this.a.b = false;
        tc0.c r1 = tc0.c.h();
        if (r16.data != 0) goto L5;
        f2.b(2131919444, 0);
        Exception r6 = new Exception("response invalid");
        long r4 = System.currentTimeMillis() - this.b;
        com.bytedance.android.live.liveinteract.plantform.utils.x.y0(r6, r4);
        InteractLinkFullLinkMonitor.j("8,12", this.c, r4, r6, "click_bottom_bar_icon");
        return;
    L5:
        ALogger.w("ttlive_link_video", "initV2Success reqScene=" + this.c + " initResult=" + ((j0) r16.data));
        tc0.c r2 = tc0.c.h();
        DATA r3 = r16.data;
        Intrinsics.checkNotNull(r3);
        r2.E = ((j0) r3).isSupportVideo();
        com.bytedance.android.livesdk.chatroom.u r5 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r5 == null) goto L14;
        com.bytedance.live.datacontext.j r7 = r5.getVideoTalkRoomSubScene();
        Intrinsics.checkNotNull(r7);
        if (r7.getValue() == null) goto L14;
        DATA r8 = r16.data;
        Intrinsics.checkNotNull(r8);
        if (((j0) r8).getScene() == 0) goto L12;
        com.bytedance.live.datacontext.j r9 = r5.getVideoTalkRoomSubScene();
        Intrinsics.checkNotNull(r9);
        Object r10 = r9.getValue();
        Intrinsics.checkNotNull(r10);
        DATA r11 = r16.data;
        Intrinsics.checkNotNull(r11);
        int r12 = ((j0) r11).getScene();
        DATA r13 = r16.data;
        Intrinsics.checkNotNull(r13);
        List r14 = ((j0) r13).getPlayModes();
        DATA r17 = r16.data;
        Intrinsics.checkNotNull(r17);
        int r18 = ((j0) r17).getUiLayout();
        DATA r19 = r16.data;
        Intrinsics.checkNotNull(r19);
        ((com.bytedance.android.livesdk.chatroom.viewmodel.e) r10).e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(r12, r14, r18, false, ((j0) r19).getClientUIInfo(), false, 40));
        DATA r20 = r16.data;
        Intrinsics.checkNotNull(r20);
        com.bytedance.android.livesdk.sharedpref.d.q(((j0) r20).getScene());
        goto L14
    L12:
        com.bytedance.live.datacontext.j r21 = r5.getVideoTalkRoomSubScene();
        Intrinsics.checkNotNull(r21);
        Object r22 = r21.getValue();
        Intrinsics.checkNotNull(r22);
        int r23 = this.c;
        DATA r24 = r16.data;
        Intrinsics.checkNotNull(r24);
        List r25 = ((j0) r24).getPlayModes();
        DATA r26 = r16.data;
        Intrinsics.checkNotNull(r26);
        ((com.bytedance.android.livesdk.chatroom.viewmodel.e) r22).e(new com.bytedance.android.livesdk.chatroom.viewmodel.j(r23, r25, ((j0) r26).getUiLayout(), false, null, false, 56));
    L14:
        if (com.bytedance.android.live.liveinteract.api.utils.m.i() != null) goto L16;
    L26:
        ((IRoom) this.d.element).setLinkInitResult((j0) r16.data);
        DATA r27 = r16.data;
        Intrinsics.checkNotNull(r27);
        r1.k = ((j0) r27).getRtcExtInfo();
        DATA r28 = r16.data;
        Intrinsics.checkNotNull(r28);
        r1.m = ((j0) r28).getLiveCoreExtInfo();
        DATA r29 = r16.data;
        Intrinsics.checkNotNull(r29);
        r1.r = ((j0) r29).getMultiLiveCoreInfo();
        DATA r30 = r16.data;
        Intrinsics.checkNotNull(r30);
        r1.n = ((j0) r30).getMultiRtcInfo();
        long r110 = System.currentTimeMillis() - this.b;
        com.bytedance.android.live.liveinteract.plantform.utils.x.z0(r110);
        DATA r31 = r16.data;
        Intrinsics.checkNotNull(r31);
        int r32 = ((j0) r31).getScene();
        DATA r33 = r16.data;
        Intrinsics.checkNotNull(r33);
        InteractLinkFullLinkMonitor.l("8,12", 0, r32, (j0) r33, r110, r16.logId, "click_bottom_bar_icon");
        j0 r34 = (j0) r16.data;
        Intrinsics.checkNotNull(r34);
        if (TextUtils.isEmpty(r34.getLinkMicIdStr()) == false) goto L29;
        r1.f = r34.getLinkMicIdStr();
        r1.e = r34.getLinkMicIdStr();
    L30:
        r1.j = r34.getVendor();
        r1.k = r34.getRtcExtInfo();
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a() == null) goto L33;
        com.bytedance.android.live.liveinteract.plantform.base.f.a().id(32, MultiLinkOpenSource.INIT_V2);
    L33:
        hd0.c.f().k(2);
        IMiddlewareUserService r35 = jc1.k.f(IMiddlewareUserService.class);
        Intrinsics.checkNotNull(r35);
        r35.user().j().subscribe(new com.bytedance.android.livesdk.user.h());
        ALogger.i("ttlive_link", "onInitV2Success " + r34);
        LinkedHashMap r36 = new LinkedHashMap();
        r36.put("live_type", "video_live");
        TalkRoomLogUtils.B0(r36, Integer.valueOf(r34.getScene()), null, 4);
        List r37 = r34.getPlayModes();
        Intrinsics.checkNotNull(r37);
        TalkRoomLogUtils.X0(r36, r37);
        DATA r38 = r16.data;
        Intrinsics.checkNotNull(r38);
        if (((j0) r38).getPlayModes() == null) goto L43;
        j0 r111 = (j0) r16.data;
        if (r111 == null) goto L43;
        List r112 = r111.getPlayModes();
        if (r112 == null) goto L43;
        if (r112.contains(1) != true) goto L43;
        r36.put("play_type", "video_friend");
    L43:
        if (((Boolean) b6.h.getValue()).booleanValue() == false) goto L45;
        String r113 = "on";
    L46:
        r36.put("is_camera_allow", r113);
        if (((IRoom) this.d.element).getCircleInfo() == null) goto L51;
        ICircleInfo r114 = ((IRoom) this.d.element).getCircleInfo();
        Intrinsics.checkNotNull(r114);
        if (r114.getCircleId() <= 0) goto L51;
        ICircleInfo r115 = ((IRoom) this.d.element).getCircleInfo();
        Intrinsics.checkNotNull(r115);
        r36.put("circle_name", String.valueOf(r115.getCircleName()));
    L51:
        r36.put("shoot_way", "null");
        String r116 = TalkRoomLogUtils.d;
        if (r116 == null) goto L55;
        Intrinsics.checkNotNull(r116);
        r36.put("source", r116);
    L55:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == false) goto L57;
        r36.put("is_invite_only", "1");
    L58:
        TalkRoomLogUtils.H0(r36);
        com.bytedance.android.livesdk.log.j0.l().sendLog("anchor_audience_connection_open_success", r36, new Object[]{IRoom.class, am2.x.class});
        return;
    L57:
        r36.put("is_invite_only", "0");
        goto L58
    L45:
        r113 = "off";
        goto L46
    L29:
        r1.e = r34.getLinkMicIdStr();
        r1.f = r34.getLinkMicIdStr();
        goto L30
    L16:
        if (com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom() == null) goto L26;
        com.bytedance.live.datacontext.m r39 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Intrinsics.checkNotNull(r39);
        if (((IRoom) r39.getValue()).getLinkerDetail() == null) goto L26;
        DATA r40 = r16.data;
        Intrinsics.checkNotNull(r40);
        if (((j0) r40).getPlayModes() == null) goto L26;
        ArrayList r41 = new ArrayList();
        DATA r42 = r16.data;
        Intrinsics.checkNotNull(r42);
        List r43 = ((j0) r42).getPlayModes();
        Intrinsics.checkNotNull(r43);
        Iterator r44 = r43.iterator();
    L23:
        if (r44.hasNext() == false) goto L25;
        r41.add(Long.valueOf(((Number) r44.next()).intValue()));
        goto L23
    L25:
        com.bytedance.live.datacontext.m r45 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Intrinsics.checkNotNull(r45);
        z5 r46 = ((IRoom) r45.getValue()).getLinkerDetail();
        Intrinsics.checkNotNull(r46);
        r46.setPlayModes(r41);
        goto L26
    }
}
