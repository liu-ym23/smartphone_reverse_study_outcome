package com.bytedance.android.live.recharge.utils;

import com.bytedance.android.live.link.data.RevPkState;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class k {
    public static final /* synthetic */ int a = 0;

    public static String a() {
        int r0 = p.a;
        JsonObject r1 = new JsonObject();
        JsonObject r2 = new JsonObject();
        p11.h r3 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r3 == null) goto L5;
        q11.d r4 = r3.k();
    L6:
        int r5 = -1;
        if (r4 == null) goto L9;
        int r6 = r4.a;
    L10:
        r2.addProperty("play_mode", Integer.valueOf(r6));
        if (r4 == null) goto L13;
        int r7 = r4.b;
    L14:
        r2.addProperty("team_mode", Integer.valueOf(r7));
        if (r4 == null) goto L17;
        r5 = r4.c;
    L17:
        r2.addProperty("activity_mode", Integer.valueOf(r5));
        r1.add("pk_scene", r2);
        return r1.toString();
    L13:
        r7 = -1;
        goto L14
    L9:
        r6 = -1;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    public static String b() {
        int r0 = p.a;
        com.bytedance.android.live.revenue.core.util.j.a r1 = com.bytedance.android.live.revenue.core.util.j.C0;
        com.bytedance.android.livesdk.revenue.service.room.c r2 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r1.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        RevPkState r3 = null;
        if (r2 == null) goto L5;
        com.bytedance.android.livesdk.revenue.room.a r4 = r2.getRoomContext();
    L6:
        com.bytedance.android.livesdk.revenue.service.room.c r5 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r1.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r5 == null) goto L9;
        DataCenter r6 = r5.getDataCenter();
    L10:
        boolean r7 = false;
        int r8 = 1;
        if (y3.m(r6).n(ToolbarButton.GROUP_PURCHASE) == false) goto L13;
    L16:
        boolean r9 = true;
    L17:
        if (r4 != null) goto L19;
    L21:
        boolean r10 = false;
    L22:
        ILinkService r12 = (ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class);
        p11.h r13 = r12.mo470getPkService();
        p11.e r14 = r12.mo468getMultiAnchorService();
        if (r14 == null) goto L25;
        p11.g r15 = r14.k();
    L26:
        if (r13 == null) goto L28;
        RevPkState r16 = r13.d();
    L29:
        RevPkState r17 = RevPkState.PK;
        if (r16 != r17) goto L33;
        if (r15 == null) goto L33;
        boolean r18 = true;
    L34:
        if (r13 == null) goto L36;
        r3 = r13.d();
    L36:
        if (r3 != r17) goto L39;
        if (r15 != null) goto L39;
        boolean r19 = true;
    L40:
        if (r4 == null) goto L48;
        com.bytedance.live.datacontext.m r20 = r4.getRoom();
        if (r20 == null) goto L48;
        IRoom r22 = (IRoom) r20.getValue();
        if (r22 == null) goto L48;
        if (r22.isGameRoom() != 1) goto L48;
        boolean r23 = true;
    L49:
        if (r4 != null) goto L51;
    L53:
        boolean r24 = false;
    L54:
        if (r4 == null) goto L62;
        com.bytedance.live.datacontext.m r25 = r4.getRoom();
        if (r25 == null) goto L62;
        IRoom r26 = (IRoom) r25.getValue();
        if (r26 == null) goto L62;
        if (r26.isVsRoom() != true) goto L62;
        boolean r27 = true;
    L63:
        int r28 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentScene();
        if (r28 != 5) goto L66;
        boolean r110 = true;
    L68:
        if (r28 != 8) goto L70;
    L73:
        boolean r111 = true;
    L75:
        if (r28 != 9) goto L77;
        r7 = true;
    L77:
        if (r9 == true) goto L99;
        if (r23 == false) goto L81;
        r8 = 2;
        goto L99
    L81:
        if (r24 == false) goto L83;
        r8 = 3;
        goto L99
    L83:
        if (r27 == false) goto L85;
        r8 = 4;
        goto L99
    L85:
        if (r18 == false) goto L87;
        r8 = 5;
        goto L99
    L87:
        if (r19 == false) goto L89;
        r8 = 6;
        goto L99
    L89:
        if (r110 == false) goto L91;
        r8 = 7;
        goto L99
    L91:
        if (r111 == false) goto L93;
        r8 = 8;
        goto L99
    L93:
        if (r7 == false) goto L95;
        r8 = 9;
        goto L99
    L95:
        if (r10 == false) goto L97;
        r8 = 10;
        goto L99
    L97:
        r8 = -1;
    L99:
        return String.valueOf(r8);
    L70:
        if (r28 == 12) goto L73;
        r111 = false;
        goto L75
    L66:
        r110 = false;
    L62:
        r27 = false;
        goto L63
    L51:
        if (r4.isGameCp() != true) goto L53;
        r24 = true;
    L48:
        r23 = false;
    L39:
        r19 = false;
    L33:
        r18 = false;
        goto L34
    L28:
        r16 = null;
        goto L29
    L25:
        r15 = null;
        goto L26
    L19:
        if (r4.isHasCommerceGoods() != true) goto L21;
        r10 = true;
        goto L22
    L13:
        if (y3.m(r6).n(ToolbarButton.GROUP_PURCHASE_MORE) == true) goto L16;
        r9 = false;
        goto L17
    L9:
        r6 = null;
        goto L10
    L5:
        r4 = null;
        goto L6
    }

    static {
    }
}
