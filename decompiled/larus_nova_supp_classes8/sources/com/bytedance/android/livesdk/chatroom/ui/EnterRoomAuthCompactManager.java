package com.bytedance.android.livesdk.chatroom.ui;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.message.model.sj;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.RoomKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class EnterRoomAuthCompactManager implements vlc.l {
    public final String a;
    public List<u8> b;
    public final DataCenter c;

    public EnterRoomAuthCompactManager(DataCenter r5) {
        Intrinsics.checkNotNullParameter(r5, "dataCenter");
        this.c = r5;
        this.a = "RoomAuthMsgV2";
        RoomContext r6 = RoomContext.a.c(RoomContext.Companion, r5, 0, 2);
        if (r6 == null) goto L8;
        com.bytedance.live.datacontext.j r7 = r6.getMessageManager();
        if (r7 == null) goto L9;
        r7.c(new AnonymousClass1(this));
        return;
    L9:
        return;
    }

    public final void a(Room r54) {
        Intrinsics.checkNotNullParameter(r54, "room");
        int r3 = h6.a;
        final DataCenter r4 = this.c;
        Intrinsics.checkNotNullParameter(r54, "room");
        ArrayList r5 = new ArrayList();
        final RoomAuthStatus r6 = r54.getRoomAuthStatus();
        if (r6 != null) goto L5;
        ALogger.e("EnterRoomAuthKeyMapping", "enter roomAuth is null");
    L25:
        this.b = r5;
        DataCenter r7 = this.c;
        Intrinsics.checkNotNullParameter(r7, "dataCenter");
        Intrinsics.checkNotNullParameter(r54, "room");
        final Ref.ObjectRef r2 = new Ref.ObjectRef();
        r2.element = r54.getRoomAuthStatus();
        if (RoomKt.hasMultiCamera(r54) == true) goto L28;
    L44:
        long r8 = ((RoomAuthStatus) r2.element).getCastScreen();
        Function2<Long, RoomAuthStatus.Style, Unit> r9 = new EnterRoomAuthKeyMapping$handleMultiCameraAuthList$2(r2);
        RoomAuthStatus.RoomAuthSpecialStyle r10 = ((RoomAuthStatus) r2.element).roomAuthSpecialStyle;
        if (r10 == null) goto L47;
        IRoomAuthStatusStyle r17 = r10.getCastScreenAuth();
    L48:
        r5.add(new u8("room_auth_cast_screen", r8, r9, (RoomAuthStatus.Style) r17, 16));
    L49:
        List<u8> r1 = this.b;
        if (r1 == null) goto L55;
        Iterator<T> r11 = r1.iterator();
    L53:
        if (r11.hasNext() == false) goto L57;
        u8 r12 = (u8) r11.next();
        lk1.c.a r13 = lk1.c.i2;
        DataCenter r14 = this.c;
        r13.getClass();
        lk1.c.a.a(r14).addComponentRule(r12.a, new g6((int) r12.b, r12.d));
        goto L53
    L57:
        return;
    L55:
        return;
    L47:
        r17 = null;
        goto L48
    L28:
        if (RoomContext.a.c(RoomContext.Companion, r7, 0, 2) == null) goto L49;
        nm1.m r15 = pm1.f.l();
        if (r15 == null) goto L44;
        if (r15.a(r7) != true) goto L44;
        nm1.m r16 = pm1.f.l();
        if (r16 == null) goto L37;
        VSCameraInfo r18 = r16.K(r7);
    L38:
        if (r18 == null) goto L44;
        IRoomAuthStatus r19 = r18.cameraRoomAuth;
        if (r19 == null) goto L44;
        RoomAuthStatus r20 = (RoomAuthStatus) com.bytedance.android.live.base.model.m.b(r19, RoomAuthStatus.class);
        if (r20 == null) goto L44;
        r2.element = r20;
        goto L44
    L37:
        r18 = null;
        goto L38
    L5:
        r5.add(new u8("room_auth_dou_plus_popularity_gem", r6.douPlusPopularityGem, new EnterRoomAuthKeyMapping$getRoomAuthList$1(r6), null, 24));
        r5.add(new u8("room_auth_mission_center", r6.missionCenter, new EnterRoomAuthKeyMapping$getRoomAuthList$2(r6), null, 24));
        r5.add(new u8("room_auth_fans_group", r6.fansGroup, new EnterRoomAuthKeyMapping$getRoomAuthList$3(r6), null, 24));
        r5.add(new u8("room_auth_topic", r6.topic, new EnterRoomAuthKeyMapping$getRoomAuthList$4(r6), null, 24));
        r5.add(new u8("room_auth_anchor_mission", r6.anchorMission, new EnterRoomAuthKeyMapping$getRoomAuthList$5(r6), null, 24));
        r5.add(new u8("room_auth_chat_guide_emoji", r6.chatGuideEmoji, new EnterRoomAuthKeyMapping$getRoomAuthList$6(r6), null, 24));
        r5.add(new u8("room_auth_chat_guide_image", r6.chatGuideImage, new EnterRoomAuthKeyMapping$getRoomAuthList$7(r6), null, 24));
        com.bytedance.android.livesdk.interactivity.service.model.c r21 = r6.castToOrNull(com.bytedance.android.livesdk.interactivity.service.model.c.class);
        if (r21 == null) goto L8;
        long r22 = r21.getAudioChatToText();
    L9:
        r5.add(new u8("room_auth_audio_chat_to_text", r22, new EnterRoomAuthKeyMapping$getRoomAuthList$8(r6), null, 24));
        r5.add(new u8("room_auth_teleprompter", r6.teleprompter, new EnterRoomAuthKeyMapping$getRoomAuthList$9(r6), null, 24));
        r5.add(new u8("room_auth_media_linkmic", r6.mediaRoomLinkmic, new EnterRoomAuthKeyMapping$getRoomAuthList$10(r6), null, 24));
        r5.add(new u8("room_auth_share", r6.getShowShare(), new EnterRoomAuthKeyMapping$getRoomAuthList$11(r6), null, 24));
        long r110 = r6.like;
        Function2<Long, RoomAuthStatus.Style, Unit> r111 = new EnterRoomAuthKeyMapping$getRoomAuthList$12(r6);
        RoomAuthStatus.RoomAuthSpecialStyle r23 = r6.roomAuthSpecialStyle;
        if (r23 == null) goto L12;
        RoomAuthStatus.Style r112 = r23.likeStyle;
    L13:
        r5.add(new u8("room_auth_digg", r110, r111, r112, 16));
        r5.add(new u8("room_auth_landscape", r6.landscape, new EnterRoomAuthKeyMapping$getRoomAuthList$13(r6), null, 24));
        r5.add(new u8("room_auth_fans_club", r6.getFansClubAuth(), new EnterRoomAuthKeyMapping$getRoomAuthList$14(r6), null, 24));
        if (r6.getPcPlay() != 1) goto L16;
    L19:
        long r113 = 1;
    L20:
        r5.add(new u8("room_auth_pc_play", r113, new EnterRoomAuthKeyMapping$getRoomAuthList$15(r6), null, 24));
        r5.add(new u8("room_auth_pad_play", r6.getPadPlay(), new EnterRoomAuthKeyMapping$getRoomAuthList$16(r6), null, 24));
        r5.add(new u8("room_auth_show_qualification", r6.showQualification, new EnterRoomAuthKeyMapping$getRoomAuthList$17(r6), null, 24));
        r5.add(new u8("room_auth_common_card", r6.getCommonCard(), new EnterRoomAuthKeyMapping$getRoomAuthList$18(r6, r4), null, 24));
        r5.add(new u8("room_auth_highlight_area_container", r6.getHighlightAreaContainer(), new EnterRoomAuthKeyMapping$getRoomAuthList$19(r6, r4), null, 24));
        r5.add(new u8("room_auth_host_team_channel", r6.teamChannel, new EnterRoomAuthKeyMapping$getRoomAuthList$20(r6), null, 24));
        r5.add(new u8("room_auth_screen_projection_barrage", r6.projectScreenBarrage, new EnterRoomAuthKeyMapping$getRoomAuthList$21(r6), null, 24));
        r5.add(new u8("room_auth_projection_btn", r6.getProjectionBtn(), new EnterRoomAuthKeyMapping$getRoomAuthList$22(r6), null, 24));
        r5.add(new u8("room_auth_toolbar_bubble", r6.toolbarBubble, new EnterRoomAuthKeyMapping$getRoomAuthList$23(r6), null, 24));
        if (r6.getEnableGift() == false) goto L23;
        long r29 = 1;
    L24:
        r5.add(new u8("room_auth_gift", r29, new EnterRoomAuthKeyMapping$getRoomAuthList$24(r6), null, 24));
        r5.add(new u8("room_auth_long_touch", r6.longTouch, new EnterRoomAuthKeyMapping$getRoomAuthList$25(r6), null, 24));
        r5.add(new u8("room_auth_landscape_screen_recording", r6.landscapeScreenRecording, new EnterRoomAuthKeyMapping$getRoomAuthList$26(r6), null, 24));
        r5.add(new u8("room_auth_cast_screen_explicit", r6.getCastScreenExplicit(), new EnterRoomAuthKeyMapping$getRoomAuthList$27(r6), null, 24));
        r5.add(new u8("room_auth_interactive_component", r6.interactiveComponent, new EnterRoomAuthKeyMapping$getRoomAuthList$28(r6), null, 24));
        r5.add(new u8("room_auth_player_rank_list", r6.getPlayerRankList(), new EnterRoomAuthKeyMapping$getRoomAuthList$29(r6), null, 24));
        goto L25
    L23:
        r29 = 0;
        goto L24
    L16:
        if (r6.getPadPlay() == 1) goto L19;
        r113 = r6.getPcPlay();
        goto L20
    L12:
        r112 = null;
        goto L13
    L8:
        r22 = 0;
        goto L9
    }

    public final void onMessage(tlc.d r10) {
        if ((r10 instanceof sj) == false) goto L28;
        sj r11 = (sj) r10;
        String r0 = r11.E();
        String r1 = "";
        if (r0 != null) goto L7;
        r0 = "";
    L7:
        long r2 = r11.G();
        RoomAuthStatus.Style r4 = new RoomAuthStatus.Style();
        r4.setUnableStyle(r11.Q());
        String r5 = r11.get_content();
        if (r5 == null) goto L11;
        r1 = r5;
    L11:
        r4.setContent(r1);
        r4.setSwitchStatusAnchorTipMsg(r11.H());
        r4.setSwitchStatusTipMsg(r11.P());
        ALogger.i(this.a, "receive msg: " + r0 + " status:" + r2 + "  style:" + r4.getUnableStyle());
        List<u8> r12 = this.b;
        if (r12 == null) goto L23;
        Iterator r13 = ((ArrayList) r12).iterator();
    L15:
        if (r13.hasNext() == false) goto L19;
        Object r3 = r13.next();
        if (Intrinsics.areEqual(((u8) r3).a, r0) == false) goto L15;
    L20:
        u8 r6 = (u8) r3;
        if (r6 == null) goto L23;
        ALogger.i(this.a, "update roomAuth " + r0 + " status:" + r2 + "  style:" + r4.getUnableStyle());
        r6.c.invoke(Long.valueOf(r2), r4);
        goto L23
    L19:
        r3 = null;
    L23:
        lk1.c.a r14 = lk1.c.i2;
        DataCenter r7 = this.c;
        r14.getClass();
        lk1.c.a.a(r7).updateComponentRule(r0, new g6((int) r2, r4));
        return;
    }
}
