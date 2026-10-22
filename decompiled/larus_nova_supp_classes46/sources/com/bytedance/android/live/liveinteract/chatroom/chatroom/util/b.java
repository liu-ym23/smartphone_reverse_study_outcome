package com.bytedance.android.live.liveinteract.chatroom.chatroom.util;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.link.IMultiLinkServiceExternal;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.bytedance.android.live.liveinteract.plantform.core.y;
import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.MessageBoardInfo;
import com.bytedance.android.live.liveinteract.plantform.model.f0;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import jc1.k;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    public b() {
    }

    static {
    }

    public static Pair a(boolean r2) {
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L5;
        String r3 = "anchor";
    L9:
        return TuplesKt.to("user_type", r3);
    L5:
        if (r2 == false) goto L7;
        r3 = "link_user";
        goto L9
    L7:
        r3 = "audience";
        goto L9
    }

    public static void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "inviteeId");
        Map r5 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("live_type", "voice_live"), a(true), TuplesKt.to("invitee_id", r4)});
        TalkRoomLogUtils.B0(r5, null, null, 6);
        TalkRoomLogUtils.V0(r5);
        Unit r0 = Unit.INSTANCE;
        f("anchor_audience_connection_mutual_online_info_show", r5, new Object[0]);
    }

    public static void b(boolean r9, boolean r10, int r11) {
        y r0 = (y) ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r0 == null) goto L20;
        CopyOnWriteArrayList<LinkmicPositionItem> r4 = r0.e;
        if (r4 == null) goto L20;
        Iterator<LinkmicPositionItem> r5 = r4.iterator();
    L8:
        if (r5.hasNext() == false) goto L15;
        LinkmicPositionItem r6 = r5.next();
        if (((int) r6.getPosition()) != r11) goto L12;
        boolean r7 = true;
    L13:
        if (r7 == false) goto L8;
    L16:
        LinkmicPositionItem r8 = r6;
        if (r8 == null) goto L20;
        String r12 = r8.getActiveName();
        if (r12 == null) goto L20;
    L21:
        Pair[] r13 = new Pair[6];
        r13[0] = TuplesKt.to("live_type", "voice_live");
        r13[1] = a(r9);
        r13[2] = TuplesKt.to("icon_type", "empty");
        if (r10 == false) goto L24;
        String r14 = "on";
    L25:
        r13[3] = TuplesKt.to("is_guide_on", r14);
        if (r0 == null) goto L28;
        Integer r15 = Integer.valueOf(r0.n());
    L29:
        r13[4] = TuplesKt.to("seat_num", String.valueOf(r15));
        r13[5] = TuplesKt.to("seat_name", r12);
        Map r16 = MapsKt.mutableMapOf(r13);
        TalkRoomLogUtils.B0(r16, null, null, 6);
        String r17 = u0.i(je0.d.h(), je0.d.d(), Integer.valueOf(TalkRoomLogUtils.b.a));
        if (r17 == null) goto L33;
        r16.put("layout_type", r17);
    L33:
        if (r11 == (-1)) goto L35;
        com.bytedance.android.live.liveinteract.linkpanel.util.m.C(r11, r16);
    L35:
        f("anchor_audience_connection_empty_seat_click", r16, new Object[0]);
        return;
    L28:
        r15 = null;
        goto L29
    L24:
        r14 = "off";
        goto L25
    L12:
        r7 = false;
        goto L13
    L15:
        r6 = null;
    L20:
        r12 = "";
        goto L21
    }

    public static void f(String r4, Map r5, Object... r6) {
        boolean r0 = tb1.d.a;
        j0.l().sendLog(r4, r5, new Object[]{IRoom.class, x.class, r6});
    }

    public static /* synthetic */ void e(boolean r7, String r8, String r9, boolean r10) {
        d(r7, r8, true, r9, r10, null, null);
    }

    public static void d(boolean r5, String r6, boolean r7, String r8, boolean r9, String r10, IMessageBoardInfo r11) {
        Intrinsics.checkNotNullParameter(r6, "inviteeId");
        HashMap r0 = new HashMap();
        Integer r2 = null;
        TalkRoomLogUtils.B0(r0, Integer.valueOf(((IInteractService) k.n(IInteractService.class)).getCurrentScene()), null, 4);
        if (r5 == false) goto L5;
        String r12 = "voice_live";
    L6:
        r0.put("live_type", r12);
        if (r7 == false) goto L9;
        String r13 = "online";
    L10:
        r0.put("online_status", r13);
        r0.put("enter_from", "live_detail");
        r0.put("request_page", r8);
        if (Intrinsics.areEqual(m.i().isAnchor(), Boolean.TRUE) == false) goto L14;
        String r14 = "anchor";
    L17:
        r0.put("user_type", r14);
        r0.put("invitee_id", r6.toString());
        String r15 = "1";
        if (TextUtils.isEmpty(r10) == true) goto L20;
        r0.put("is_task", "1");
        Intrinsics.checkNotNull(r10);
        r0.put("activity_name", r10);
    L20:
        TalkRoomLogUtils.V0(r0);
        if (r9 == false) goto L23;
        Object r16 = "1";
    L24:
        r0.put("if_invitee_subscribe", r16);
        boolean r17 = true;
        if (k.n(IMultiLinkServiceExternal.class).getPkServiceExternal().getPkState() == 1) goto L28;
        r17 = false;
    L28:
        String r18 = "";
        if (r17 == false) goto L31;
        String r19 = String.valueOf(k.n(IMultiLinkServiceExternal.class).getMultiDataHolderExternal().getPkId());
    L32:
        r0.put("pk_id", r19);
        if (r17 == false) goto L35;
        Object r20 = "1";
    L36:
        r0.put("is_in_pk", r20);
        if (r11 == null) goto L46;
        r0.put("message_text", f0.a(r11));
        r0.put("gift_id", String.valueOf(r11.getGiftId()));
        if ((r11 instanceof MessageBoardInfo) == true) goto L41;
        r11 = null;
    L41:
        MessageBoardInfo r110 = (MessageBoardInfo) r11;
        if (r110 == null) goto L44;
        r2 = Integer.valueOf(r110.getGiftMoney());
    L44:
        r0.put("gift_money", String.valueOf(r2));
    L46:
        if (je0.d.Y() == false) goto L48;
        r18 = je0.d.b0().toString();
    L48:
        r0.put("admin_id", r18);
        if (je0.d.Y() == false) goto L51;
        Object r21 = "1";
    L52:
        r0.put("is_admin", r21);
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.c.s1.getValue()).booleanValue() == true) goto L56;
        r15 = "0";
    L56:
        r0.put("is_invite_only", r15);
        if (((IInteractService) k.n(IInteractService.class)).dynamicFromAudience() == false) goto L59;
        r0.put("function_type2", "new_audience");
    L59:
        f("livesdk_anchor_friend_connection_invite", r0, new Object[0]);
        return;
    L51:
        r21 = "0";
        goto L52
    L35:
        r20 = "0";
        goto L36
    L31:
        r19 = "";
        goto L32
    L23:
        r16 = "0";
        goto L24
    L14:
        if (je0.d.Y() == false) goto L16;
        r14 = "admin";
        goto L17
    L16:
        r14 = "link_user";
        goto L17
    L9:
        r13 = "offline";
        goto L10
    L5:
        r12 = "video_live";
        goto L6
    }
}
