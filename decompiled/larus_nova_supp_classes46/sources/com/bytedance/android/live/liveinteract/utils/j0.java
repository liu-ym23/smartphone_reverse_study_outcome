package com.bytedance.android.live.liveinteract.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.seat.layer.base.MicSeatScene;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureContext;
import com.bytedance.android.live.liveinteract.revenue.adventure.AdventureState;
import com.bytedance.android.live.liveinteract.view.SeatPosTagLabelTextView;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0 {
    public static final /* synthetic */ int a = 0;

    public j0() {
    }

    static {
    }

    public static void d(com.bytedance.android.live.liveinteract.plantform.model.g0 r6) {
        Intrinsics.checkNotNullParameter("seat", "showPageName");
        Intrinsics.checkNotNullParameter(r6, "tagInfo");
        com.bytedance.live.datacontext.m r0 = com.bytedance.android.live.liveinteract.api.utils.m.i().getRoom();
        Long r2 = null;
        if (r0 == null) goto L5;
        IRoom r1 = (IRoom) r0.getValue();
    L6:
        LinkedHashMap r3 = new LinkedHashMap();
        if (r1 == null) goto L9;
        r2 = Long.valueOf(r1.getId());
    L9:
        r3.put("room_id", String.valueOf(r2));
        if (r1 == null) goto L13;
        String r4 = r1.getOwnerUserIdString();
        if (r4 == null) goto L13;
    L14:
        r3.put("anchor_id", r4);
        r3.put("function_type", TalkRoomLogUtils.g());
        if (r1 != null) goto L17;
    L19:
        String r5 = "video_live";
    L20:
        r3.put("live_type", r5);
        if (Intrinsics.areEqual(com.bytedance.android.live.liveinteract.api.utils.m.i().isAnchor(), Boolean.TRUE) == false) goto L24;
        String r7 = "anchor";
    L33:
        r3.put("user_type", r7);
        r3.put("play_mode", com.bytedance.android.live.liveinteract.plantform.utils.u0.b());
        r3.put("show_page_name", "seat");
        r3.put("tag_type", String.valueOf(r6.getTagType()));
        r3.put("resource_name", String.valueOf(r6.getPositionTagName()));
        r3.put("resource_type", "ksong");
        r3.put("midi_id", "");
        TalkRoomLogUtils.P0(r3, Integer.valueOf(je0.d.f()));
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_connection_audience_tag_show", r3, new Object[]{IRoom.class});
        return;
    L24:
        if (jc1.k.n(IMiddlewareUserService.class).user().c() == false) goto L26;
        r7 = "admin";
        goto L33
    L26:
        Integer r8 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r8 != null) goto L30;
    L32:
        r7 = "audience";
        goto L33
    L30:
        if (r8.intValue() != 2) goto L32;
        r7 = "guest";
        goto L33
    L17:
        if (r1.isLiveTypeAudio() != true) goto L19;
        r5 = "voice_live";
    L13:
        r4 = "";
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(SeatPosTagLabelTextView r17, com.bytedance.android.live.liveinteract.plantform.model.g0 r18, ILinkPlayerInfoBridge r19, Context r20, boolean r21) {
        Intrinsics.checkNotNullParameter(r18, "tagInfo");
        ai0.e r4 = ((IInteractService) jc1.k.n(IInteractService.class)).getAdventureService();
        if (r4 == null) goto L154;
        if (r19 == null) goto L9;
        IBaseUser r5 = r19.getUser();
        if (r5 == null) goto L9;
        String r6 = r5.getIdString();
        if (r6 == null) goto L9;
    L10:
        ai0.c r7 = (ai0.c) r4;
        Intrinsics.checkNotNullParameter(r18, "tagInfo");
        Intrinsics.checkNotNullParameter(r6, "micSeatUid");
        if (r21 == true) goto L158;
        if (r20 == null) goto L159;
        if (r17 == 0) goto L160;
        AdventureContext.Companion.getClass();
        boolean r3 = AdventureContext.a.a();
        AdventureState r8 = r7.a(null);
        ALogger.i("AdventureOutService", "updateTagExtInfo tagInfo:" + r6 + "--" + r18.getTagTypeId() + ',' + r18.getPositionTagName() + ',' + r18.getSchema() + ";isAdventureShowing:" + r3);
        if (r3 == false) goto L132;
        if (r8 == null) goto L132;
        String r9 = je0.d.b0();
        com.bytedance.android.livesdk.chatroom.model.interact.h r10 = r8.adventureInfo;
        if (r10 == null) goto L37;
        List r11 = r10.getLinkedUserList();
        if (r11 == null) goto L37;
        Iterator r12 = r11.iterator();
    L27:
        if (r12.hasNext() == false) goto L35;
        Object r13 = r12.next();
        com.bytedance.android.livesdk.chatroom.model.interact.k r14 = (com.bytedance.android.livesdk.chatroom.model.interact.k) r13;
        if (r14 == null) goto L31;
        String r15 = r14.getUserIdString();
    L33:
        if (Intrinsics.areEqual(r15, r9) == false) goto L27;
    L36:
        com.bytedance.android.livesdk.chatroom.model.interact.k r16 = (com.bytedance.android.livesdk.chatroom.model.interact.k) r13;
    L38:
        long r110 = r18.getTagTypeId();
        if (r110 != 9) goto L63;
        if (Intrinsics.areEqual(r9, r6) == false) goto L48;
        if (r16 == null) goto L47;
        List r22 = r16.getInviteUsersString();
        if (r22 != null) goto L46;
    L122:
        Ref.ObjectRef r23 = new Ref.ObjectRef();
        String r1 = r18.getSchema();
        r23.element = r1;
        if (r1 != null) goto L125;
    L131:
        r17.setClickable(false);
        r17.setOnClickListener(null);
        return;
    L125:
        if (r1.length() != 0) goto L127;
        boolean r2 = true;
    L128:
        if (r2 == true) goto L131;
        r17.setClickable(true);
        r17.setOnClickListener(new ai0.b(r20, r23));
        return;
    L127:
        r2 = false;
        goto L128
    L46:
        if (r22.isEmpty() != true) goto L122;
    L47:
        UtilityKotlinExtentionsKt.t(r17);
        r18.setSchema(null);
        goto L122
    L48:
        if (r16 == null) goto L59;
        List r24 = r16.getInviteUsersString();
        if (r24 == null) goto L59;
        Iterator r25 = r24.iterator();
    L53:
        if (r25.hasNext() == false) goto L57;
        Object r26 = r25.next();
        if (Intrinsics.areEqual((String) r26, r6) == false) goto L53;
    L58:
        String r27 = (String) r26;
    L60:
        if (r27 == null) goto L122;
        r17.setText("已邀请你");
        ai0.c.d(r17, "#80000000");
        goto L122
    L57:
        r26 = null;
    L59:
        r27 = null;
        goto L60
    L63:
        if (r110 != 10) goto L122;
        if (Intrinsics.areEqual(r9, r6) == true) goto L122;
        com.bytedance.android.livesdk.chatroom.model.interact.h r28 = r8.adventureInfo;
        if (r28 == null) goto L82;
        List r29 = r28.getLinkedUserList();
        if (r29 == null) goto L82;
        Iterator r30 = r29.iterator();
    L72:
        if (r30.hasNext() == false) goto L80;
        Object r31 = r30.next();
        com.bytedance.android.livesdk.chatroom.model.interact.k r111 = (com.bytedance.android.livesdk.chatroom.model.interact.k) r31;
        if (r111 == null) goto L76;
        String r112 = r111.getUserIdString();
    L78:
        if (Intrinsics.areEqual(r112, r6) == false) goto L72;
    L81:
        com.bytedance.android.livesdk.chatroom.model.interact.k r32 = (com.bytedance.android.livesdk.chatroom.model.interact.k) r31;
    L83:
        if (r32 == null) goto L121;
        List r33 = r32.getInviteUsersString();
        if (r33 == null) goto L87;
        int r34 = r33.size();
    L88:
        List r35 = r32.getInviteUsersString();
        if (r35 == null) goto L98;
        Iterator r36 = r35.iterator();
    L92:
        if (r36.hasNext() == false) goto L96;
        Object r37 = r36.next();
        if (Intrinsics.areEqual(String.valueOf((String) r37), r9) == false) goto L92;
    L97:
        String r38 = (String) r37;
    L100:
        if (r34 >= 50) goto L118;
        if (r38 != null) goto L122;
        if (r16 == null) goto L113;
        List r39 = r16.getInviteUsersString();
        if (r39 == null) goto L113;
        Iterator r40 = r39.iterator();
    L107:
        if (r40.hasNext() == false) goto L111;
        Object r41 = r40.next();
        if (Intrinsics.areEqual(String.valueOf((String) r41), r6) == false) goto L107;
    L112:
        String r42 = (String) r41;
    L114:
        if (r42 != null) goto L116;
        r17.setText("待奇遇");
        ai0.c.d(r17, "#BF44AEFF");
    L117:
        UtilityKotlinExtentionsKt.w(r17);
        r18.setSchema(null);
        goto L122
    L116:
        r17.setText("已邀请你");
        ai0.c.d(r17, "#80000000");
        goto L117
    L111:
        r41 = null;
    L113:
        r42 = null;
        goto L114
    L118:
        if (r34 < 50) goto L122;
        if (r38 != null) goto L122;
        UtilityKotlinExtentionsKt.t(r17);
        r18.setSchema(null);
        goto L122
    L96:
        r37 = null;
        goto L97
    L98:
        r38 = null;
        goto L100
    L87:
        r34 = 0;
        goto L88
    L121:
        ALogger.e("AdventureOutService", "adventureState not contains micseat user:".concat(r6));
        goto L122
    L76:
        r112 = null;
        goto L78
    L80:
        r31 = null;
    L82:
        r32 = null;
        goto L83
    L31:
        r15 = null;
        goto L33
    L35:
        r13 = null;
    L37:
        r16 = null;
    L132:
        long r43 = r18.getTagTypeId();
        if (9 <= r43) goto L136;
        return;
    L136:
        if (11 < r43) goto L157;
        UtilityKotlinExtentionsKt.t(r17);
        return;
    L157:
        return;
    L160:
        return;
    L159:
        return;
    L158:
        return;
    L9:
        r6 = "";
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void b(SeatPosTagLabelTextView r8, com.bytedance.android.live.liveinteract.plantform.model.g0 r9, ILinkPlayerInfoBridge r10, boolean r11, MicSeatScene r12) {
        Intrinsics.checkNotNullParameter(r9, "tagInfo");
        Drawable r7 = null;
        if (r11 == true) goto L5;
    L9:
        if (r8 == 0) goto L11;
        SeatPosTagLabelTextView.z(r8, 0, r10, r12, null, 8);
    L11:
        if (r8 == 0) goto L46;
        r8.setText(r9.getPositionTagName());
    L46:
        int r0 = Color.parseColor(r9.getTextColor());     // Catch: Exception -> L17
        if (r8 == 0) goto L19;
        r8.setTextColor(r0);     // Catch: Exception -> L17
    L19:
        if (r9.getBgColorImg() == null) goto L44;
        py.k r1 = r9.getBgColorImg();
        if (r1 == null) goto L44;
        List r2 = r1.getUrls();
        if (r2 == null) goto L44;
        if ((!r2.isEmpty()) != true) goto L44;
        py.k r3 = r9.getBgColorImg();
        if (r3 == null) goto L31;
        if (r8 == 0) goto L49;
        r8.post(new i0(r3, r8));
        return;
    L49:
        return;
    L31:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.api.IImageModel");
    L44:
        int r4 = Color.parseColor(r9.getBgColor());     // Catch: Exception -> L42
        if (r8 == 0) goto L35;
        r8.setBackground(s1.m(2131253474));     // Catch: Exception -> L42
    L35:
        if (r8 == 0) goto L37;
        r7 = r8.getBackground();     // Catch: Exception -> L42
    L37:
        if (r7 == null) goto L39;
        r7.setColorFilter(r4, PorterDuff.Mode.SRC);     // Catch: Exception -> L42
    L39:
        if (r8 == 0) goto L51;
        r8.setBackground(r7);     // Catch: Exception -> L42
        return;
    L51:
        return;
    L42:
        ALogger.i("LinkMicPosTag", "text background color parse error: " + r9.getBgColor());
        return;
    L17:
        ALogger.i("LinkMicPosTag", "text color parse error: " + r9.getTextColor());
        goto L19
    L5:
        if (((Boolean) vm2.d.I5.getValue(null, vm2.d.a[344(0x158, float:4.82E-43)])).booleanValue() == true) goto L9;
        if (r8 == 0) goto L48;
        SeatPosTagLabelTextView.z(r8, 8, null, null, null, 12);
        return;
    }

    public static /* synthetic */ void c(SeatPosTagLabelTextView r0, com.bytedance.android.live.liveinteract.plantform.model.g0 r1, ILinkPlayerInfoBridge r2, boolean r3, Context r4, MicSeatScene r5, int r6) {
        if ((r6 & 8) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 32) == 0) goto L8;
        r5 = null;
    L8:
        b(r0, r1, r2, r3, r5);
    }
}
