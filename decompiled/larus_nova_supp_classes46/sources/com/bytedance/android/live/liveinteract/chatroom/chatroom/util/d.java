package com.bytedance.android.live.liveinteract.chatroom.chatroom.util;

import am2.x;
import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.base.k;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.revenue.fight.TeamFightContext;
import com.bytedance.android.live.liveinteract.utils.r;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatAdminService;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.dialog.TalkOnlineGuestClickOptionDialog;
import com.bytedance.android.live.network.annotation.PbRequest;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rj0.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d {
    public static final i<ILinkPlayerInfoBridge> b() {
        k.n0.getClass();
        k r0 = k.a.a();
        if (r0 == null) goto L6;
        i<ILinkPlayerInfoBridge> r1 = r0.getLinkUserInfoCenter();
        if (r1 == null) goto L6;
    L10:
        if (r1 != null) goto L15;
        l.n2.getClass();
        l r2 = l.a.a();
        if (r2 != null) goto L17;
        return null;
    L17:
        return r2.getLinkUserInfoCenter();
    L15:
        return r1;
    L6:
        rj0.k.m2.getClass();
        rj0.k r3 = rj0.k.a.a();
        if (r3 == null) goto L9;
        r1 = r3.getLinkUserInfoCenter();
        goto L10
    L9:
        r1 = null;
        goto L10
    }

    public static final boolean a(boolean r5) {
        boolean r0 = tb1.d.a;
        if (je0.d.f() != 10) goto L5;
        boolean r1 = true;
    L7:
        if (r1 == false) goto L17;
        if (r5 == false) goto L13;
        if (((Number) vm2.d.A0.getValue(null, vm2.d.a[76])).intValue() != 1) goto L29;
    L14:
        return true;
    L29:
        return false;
    L13:
        if (((Number) vm2.d.B0.getValue(null, vm2.d.a[77])).intValue() == 1) goto L14;
        return false;
    L17:
        if (je0.d.f() != 4) goto L24;
        int r6 = r.b;
        if (r6 != 2) goto L21;
    L22:
        return true;
    L21:
        if (r6 == 3) goto L22;
        return false;
    L24:
        if (r5 == false) goto L28;
        return vm2.d.z();
    L28:
        return ((Boolean) vm2.d.D0.getValue(null, vm2.d.a[79])).booleanValue();
    L5:
        r1 = false;
        goto L7
    }

    public static final void e(boolean r3, int r4) {
        if (je0.d.Y() == false) goto L10;
        IVoiceChatAdminService.Companion.getClass();
        IVoiceChatAdminService r0 = IVoiceChatAdminService.a.a();
        if (r0 == null) goto L7;
        r0.showInviteAndPermitDialog(r3, "seat", r4);
        return;
    L7:
        k.n0.getClass();
        k r5 = k.a.a();
        if (r5 == null) goto L18;
        r5.v0(0, "seat", r4, null);
        return;
    L18:
        return;
    L10:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r1 = IVoiceChatGuestService.a.a();
        if (r1 == null) goto L13;
        r1.showInviteDialog(r3, "seat", r4);
        return;
    L13:
        l.n2.getClass();
        l r6 = l.a.a();
        if (r6 == null) goto L21;
        r6.S8("seat", r4, null);
        return;
    }

    public static final void f(Context r8, final IRoom r9, final int r10, final boolean r11, Boolean r12, Boolean r13, final Function1 r14) {
        final boolean r4 = true;
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, PbRequest.SwitchType.ROOM);
        Intrinsics.checkNotNullParameter(r14, "updateLinkedPosition");
        TalkOnlineGuestClickOptionDialog r6 = new TalkOnlineGuestClickOptionDialog(r8, r12, r13, new InviteFriendsUtilKt$showInviteFriendsDialog$1(r14, r9, r10, r4, r11));
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
    }

    public static /* synthetic */ void d(IMiddlewareHostSocial.InviteFriendsConfig r12, IRoom r13, boolean r14, boolean r15, boolean r16, boolean r17, String r18, int r19) {
        if ((r19 & 1) == 0) goto L5;
        String r4 = jc1.k.n(IMiddlewareUserService.class).user().b().getNickName();
    L7:
        if ((r19 & 32) == 0) goto L9;
        boolean r9 = false;
    L11:
        if ((r19 & 64) == 0) goto L13;
        String r10 = "";
    L15:
        if ((r19 & 128) == 0) goto L17;
        String r11 = "";
    L18:
        c(r12, r4, r13, r14, r15, r16, r9, r10, r11);
        return;
    L17:
        r11 = null;
        goto L18
    L13:
        r10 = r18;
        goto L15
    L9:
        r9 = r17;
        goto L11
    L5:
        r4 = null;
        goto L7
    }

    public static final void c(IMiddlewareHostSocial.InviteFriendsConfig r13, String r14, IRoom r15, boolean r16, boolean r17, boolean r18, boolean r19, String r20, String r21) {
        Intrinsics.checkNotNullParameter(r13, "$this$setupCommonWith");
        Intrinsics.checkNotNullParameter(r14, "inviterNickname");
        boolean r6 = true;
        if (((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene() != 4) goto L5;
        boolean r3 = true;
    L6:
        boolean r5 = TeamFightContext.Companion.h();
        r13.setTitlePart1(r14);
        if (r18 == false) goto L9;
        String r8 = s1.B(2131918032);
    L12:
        r13.setTitlePart2(r8);
        Object[] r9 = new Object[1];
        if (r15 == null) goto L18;
        IBaseUser r10 = r15.getOwner();
        if (r10 == null) goto L18;
        String r11 = r10.getNickName();
        if (r11 == null) goto L18;
    L19:
        r9[0] = r11;
        r13.setSubtitlePart1(s1.C(2131918030, r9));
        r13.setSubtitlePart2(s1.B(2131918031));
        if (r18 == false) goto L22;
        String r4 = s1.B(2131918028);
    L25:
        r13.setHint(r4);
        if (r18 == false) goto L28;
        String r7 = s1.B(2131918026);
    L29:
        r13.setJoinBtnTextEnabled(r7);
        r13.setJoinBtnTextDisabled(s1.B(2131918035));
        r13.setInviteBtnTextEnabled(s1.B(2131919316));
        r13.setInviteBtnTextDisabled(s1.B(2131919321));
        r13.setPanelTitle(s1.B(2131917558));
        r13.setRoom(r15);
        String r12 = "audience";
        if (r18 == false) goto L32;
        String r22 = "ktv";
    L35:
        r13.setFunctionType(r22);
        LinkedHashMap r23 = new LinkedHashMap();
        j0.l().c(x.class).a(r23);
        j0.l().c(IRoom.class).a(r23);
        Long r24 = null;
        if (r15 == null) goto L38;
        LiveMode r25 = r15.getStreamType();
    L39:
        int r110 = h1.a;
        r13.setLiveType(i1.a(r25));
        r13.setEnterFrom("live_detail");
        String r111 = (String) r23.get("enter_from_merge");
        String r112 = "";
        if (r111 != null) goto L42;
        r111 = "";
    L42:
        r13.setEnterFromMerge(r111);
        String r113 = (String) r23.get("enter_method");
        if (r113 != null) goto L45;
        r113 = "";
    L45:
        r13.setEnterMethod(r113);
        String r114 = (String) r23.get("action_type");
        if (r114 != null) goto L48;
        r114 = "";
    L48:
        r13.setActionType(r114);
        String r26 = (String) r23.get("video_id");
        if (r26 != null) goto L51;
        r26 = "";
    L51:
        r13.setVideoId(r26);
        if (r15 == null) goto L54;
        String r27 = r15.getRequestId();
    L55:
        if (r27 != null) goto L57;
        r27 = "";
    L57:
        r13.setRequestId(r27);
        if (r15 == null) goto L60;
        String r28 = r15.getLog_pb();
    L61:
        if (r28 == null) goto L64;
        r112 = r28;
    L64:
        r13.setLogPb(r112);
        r13.setShowInnerPush(Boolean.valueOf(r19));
        String r29 = "anchor";
        if (r17 == true) goto L67;
    L70:
        r13.setUserType(r12);
        if (r18 == false) goto L73;
        IMiddlewareHostSocial.InviteFriendsConfig.RoomType r30 = IMiddlewareHostSocial.InviteFriendsConfig.RoomType.KTV;
    L78:
        r13.setRoomType(r30);
        Uri.Builder r31 = new Uri.Builder();
        Uri.Builder r32 = r31.scheme("sslocal").authority("webcast_room").appendQueryParameter("enter_from_merge", "chat").appendQueryParameter("enter_method", "live_cover");
        if (r15 == null) goto L81;
        r24 = Long.valueOf(r15.getId());
    L81:
        Uri.Builder r1 = r32.appendQueryParameter("room_id", String.valueOf(r24)).appendQueryParameter("auto_link_mic", "true").appendQueryParameter("action", r20).appendQueryParameter("is_strong_reach", "true").appendQueryParameter("from_user_id", jc1.k.n(IMiddlewareUserService.class).user().n().toString()).appendQueryParameter("from_sec_uid", o.a(jc1.k.n(IMiddlewareUserService.class).user().b()));
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L85;
    L88:
        r1.appendQueryParameter("from_user_type", r29);
        if (r21 != null) goto L91;
    L94:
        if (r6 == true) goto L96;
        r31.appendQueryParameter("apply_source", r21);
    L96:
        r13.setSchema(r31.build().toString());
        return;
    L91:
        if (r21.length() == 0) goto L94;
        r6 = false;
        goto L94
    L85:
        if (je0.d.Y() == false) goto L87;
        r29 = "admin";
        goto L88
    L87:
        r29 = "link_user";
        goto L88
    L73:
        if (r16 == false) goto L75;
        r30 = IMiddlewareHostSocial.InviteFriendsConfig.RoomType.VOICE_CHAT;
        goto L78
    L75:
        if (r3 == false) goto L77;
        r30 = IMiddlewareHostSocial.InviteFriendsConfig.RoomType.AUDIENCE;
        goto L78
    L77:
        r30 = IMiddlewareHostSocial.InviteFriendsConfig.RoomType.VIDEO_CHAT;
        goto L78
    L67:
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L69;
        r12 = "anchor";
        goto L70
    L69:
        r12 = "link_user";
        goto L70
    L60:
        r28 = null;
        goto L61
    L54:
        r27 = null;
        goto L55
    L38:
        r25 = null;
        goto L39
    L32:
        if (r3 == false) goto L34;
        r22 = "audience";
        goto L35
    L34:
        r22 = "radio";
        goto L35
    L28:
        r7 = s1.B(2131918027);
        goto L29
    L22:
        if (r5 == false) goto L24;
        r4 = s1.B(2131922770);
        goto L25
    L24:
        r4 = s1.B(2131918029);
    L18:
        r11 = "Unknown";
        goto L19
    L9:
        if (r5 == false) goto L11;
        r8 = s1.B(2131922770);
        goto L12
    L11:
        r8 = s1.B(2131918033);
        goto L12
    L5:
        r3 = false;
        goto L6
    }
}
