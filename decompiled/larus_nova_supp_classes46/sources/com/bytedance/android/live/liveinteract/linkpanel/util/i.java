package com.bytedance.android.live.liveinteract.linkpanel.util;

import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.live.datacontext.DataContext;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i {
    public static void a(IMiddlewareHostSocial.InviteFriendsConfig r8, IRoom r9, boolean r10, boolean r11, boolean r12, boolean r13, String r14, int r15) {
        Long r1 = null;
        if ((r15 & 1) == 0) goto L5;
        String r0 = jc1.k.n(IMiddlewareUserService.class).user().b().getNickName();
    L7:
        if ((r15 & 32) == 0) goto L9;
        r13 = false;
    L9:
        String r2 = "";
        if ((r15 & 64) == 0) goto L12;
        r14 = "";
    L12:
        Intrinsics.checkNotNullParameter(r8, "$this$setupCommonWith");
        Intrinsics.checkNotNullParameter(r0, "inviterNickname");
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 4) goto L15;
        boolean r16 = true;
    L16:
        DataContext r4 = com.bytedance.live.datacontext.d.d(com.bytedance.android.live.liveinteract.revenue.fight.a.class);
        if ((r4 instanceof com.bytedance.android.live.liveinteract.revenue.fight.a) == true) goto L19;
        r4 = null;
    L19:
        com.bytedance.android.live.liveinteract.revenue.fight.a r5 = (com.bytedance.android.live.liveinteract.revenue.fight.a) r4;
        if (r5 != null) goto L22;
    L24:
        boolean r6 = false;
    L25:
        r8.setTitlePart1(r0);
        if (r12 == true) goto L28;
        if (r6 == false) goto L33;
        String r7 = s1.B(2131922770);
    L34:
        r8.setTitlePart2(r7);
        Object[] r17 = new Object[1];
        if (r9 == null) goto L40;
        IBaseUser r18 = r9.getOwner();
        if (r18 == null) goto L40;
        String r19 = r18.getNickName();
        if (r19 == null) goto L40;
    L41:
        r17[0] = r19;
        r8.setSubtitlePart1(s1.C(2131918030, r17));
        r8.setSubtitlePart2(s1.B(2131918031));
        if (r12 == true) goto L44;
        if (r6 == false) goto L49;
        String r3 = s1.B(2131922770);
    L50:
        r8.setHint(r3);
        if (r12 == false) goto L53;
        String r20 = s1.B(2131918026);
    L54:
        r8.setJoinBtnTextEnabled(r20);
        r8.setJoinBtnTextDisabled(s1.B(2131918035));
        r8.setInviteBtnTextEnabled(s1.B(2131919316));
        r8.setInviteBtnTextDisabled(s1.B(2131919321));
        r8.setPanelTitle(s1.B(2131917558));
        r8.setRoom(r9);
        String r21 = "audience";
        if (r12 == false) goto L57;
        String r22 = "ktv";
    L60:
        r8.setFunctionType(r22);
        LinkedHashMap r23 = new LinkedHashMap();
        j0.l().c(am2.x.class).a(r23);
        j0.l().c(IRoom.class).a(r23);
        if (r9 == null) goto L63;
        LiveMode r24 = r9.getStreamType();
    L64:
        int r25 = h1.a;
        r8.setLiveType(i1.a(r24));
        r8.setEnterFrom("live_detail");
        String r26 = (String) r23.get("enter_from_merge");
        if (r26 != null) goto L67;
        r26 = "";
    L67:
        r8.setEnterFromMerge(r26);
        String r27 = (String) r23.get("enter_method");
        if (r27 != null) goto L70;
        r27 = "";
    L70:
        r8.setEnterMethod(r27);
        String r28 = (String) r23.get("action_type");
        if (r28 != null) goto L73;
        r28 = "";
    L73:
        r8.setActionType(r28);
        String r29 = (String) r23.get("video_id");
        if (r29 != null) goto L76;
        r29 = "";
    L76:
        r8.setVideoId(r29);
        if (r9 == null) goto L79;
        String r30 = r9.getRequestId();
    L80:
        if (r30 != null) goto L82;
        r30 = "";
    L82:
        r8.setRequestId(r30);
        if (r9 == null) goto L85;
        String r31 = r9.getLog_pb();
    L86:
        if (r31 == null) goto L89;
        r2 = r31;
    L89:
        r8.setLogPb(r2);
        r8.setShowInnerPush(Boolean.valueOf(r13));
        String r110 = "anchor";
        if (r11 == true) goto L92;
    L95:
        r8.setUserType(r21);
        if (r12 == false) goto L98;
        IMiddlewareHostSocial.InviteFriendsConfig.RoomType r111 = IMiddlewareHostSocial.InviteFriendsConfig.RoomType.KTV;
    L103:
        r8.setRoomType(r111);
        Uri.Builder r112 = new Uri.Builder();
        Uri.Builder r113 = r112.scheme("sslocal").authority("webcast_room").appendQueryParameter("enter_from_merge", "chat").appendQueryParameter("enter_method", "live_cover");
        if (r9 == null) goto L106;
        r1 = Long.valueOf(r9.getId());
    L106:
        Uri.Builder r32 = r113.appendQueryParameter("room_id", String.valueOf(r1)).appendQueryParameter("auto_link_mic", "true").appendQueryParameter("action", r14).appendQueryParameter("is_strong_reach", "true").appendQueryParameter("from_user_id", jc1.k.n(IMiddlewareUserService.class).user().n()).appendQueryParameter("from_sec_uid", com.bytedance.android.live.base.model.user.o.a(jc1.k.n(IMiddlewareUserService.class).user().b()));
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L110;
    L113:
        r32.appendQueryParameter("from_user_type", r110);
        if (jc0.a.a() == false) goto L116;
        r112.appendQueryParameter("apply_type", String.valueOf(LinkApplyType.REAL_TIME_CHORUS_INVITE.getValue()));
    L116:
        r8.setSchema(r112.build().toString());
        return;
    L110:
        if (o.I() == false) goto L112;
        r110 = "admin";
        goto L113
    L112:
        r110 = "link_user";
        goto L113
    L98:
        if (r10 == false) goto L100;
        r111 = IMiddlewareHostSocial.InviteFriendsConfig.RoomType.VOICE_CHAT;
        goto L103
    L100:
        if (r16 == false) goto L102;
        r111 = IMiddlewareHostSocial.InviteFriendsConfig.RoomType.AUDIENCE;
        goto L103
    L102:
        r111 = IMiddlewareHostSocial.InviteFriendsConfig.RoomType.VIDEO_CHAT;
        goto L103
    L92:
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L94;
        r21 = "anchor";
        goto L95
    L94:
        r21 = "link_user";
        goto L95
    L85:
        r31 = null;
        goto L86
    L79:
        r30 = null;
        goto L80
    L63:
        r24 = null;
        goto L64
    L57:
        if (r16 == false) goto L59;
        r22 = "audience";
        goto L60
    L59:
        r22 = "radio";
        goto L60
    L53:
        r20 = s1.B(2131918027);
        goto L54
    L49:
        r3 = s1.B(2131918029);
        goto L50
    L44:
        if (jc0.a.a() == false) goto L46;
        r3 = s1.B(2131918034);
        goto L50
    L46:
        r3 = s1.B(2131918028);
    L40:
        r19 = "Unknown";
        goto L41
    L33:
        r7 = s1.B(2131918033);
        goto L34
    L28:
        if (jc0.a.a() == false) goto L30;
        r7 = s1.B(2131918034);
        goto L34
    L30:
        r7 = s1.B(2131918032);
        goto L34
    L22:
        if (r5.isFightShowing() != true) goto L24;
        r6 = true;
        goto L25
    L15:
        r16 = false;
        goto L16
    L5:
        r0 = null;
        goto L7
    }
}
