package com.bytedance.android.live.liveinteract.api.utils;

import am2.x;
import android.text.TextUtils;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.utils.w;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.log.filter.r;
import com.bytedance.android.livesdk.log.filter.t;
import com.bytedance.android.livesdk.log.filter.u;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class i {
    static {
    }

    @JvmStatic
    public static final void a(Map<String, String> r9) {
        Intrinsics.checkNotNullParameter(r9, "args");
        String r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getLiveTypeForLog();
        String r1 = "";
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        b(r9, "live_type", r0);
        String r2 = ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionTypeForLog();
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        b(r9, "function_type", r2);
        String r3 = ((IInteractService) jc1.k.n(IInteractService.class)).getFunctionType2();
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        b(r9, "function_type2", r3);
        com.bytedance.live.datacontext.m r4 = m.i().getRoom();
        if (r4 == null) goto L18;
        IRoom r5 = (IRoom) r4.getValue();
        if (r5 == null) goto L18;
        String r6 = r5.getOwnerUserIdString();
        if (r6 == null) goto L18;
    L19:
        b(r9, "anchor_id", r6);
        com.bytedance.live.datacontext.m r7 = m.i().getRoom();
        if (r7 == null) goto L25;
        IRoom r8 = (IRoom) r7.getValue();
        if (r8 == null) goto L25;
        String r10 = String.valueOf(r8.getRoomId());
        if (r10 == null) goto L25;
    L26:
        b(r9, "room_id", r10);
        b(r9, "play_mode", w.a());
        com.bytedance.android.livesdk.log.filter.o r11 = j0.l().c(x.class);
        u r12 = null;
        if ((r11 instanceof t) == true) goto L29;
        r11 = null;
    L29:
        t r13 = (t) r11;
        IInteractService r14 = (IInteractService) jc1.k.f(IInteractService.class);
        if (r14 == null) goto L32;
        Map<String, String> r15 = r14.provideCommonParamsLog();
    L33:
        if (r15 == null) goto L39;
        Iterator<Map.Entry<String, String>> r16 = r15.entrySet().iterator();
    L36:
        if (r16.hasNext() == false) goto L39;
        Map.Entry<String, String> r17 = r16.next();
        b(r9, r17.getKey(), r17.getValue());
    L39:
        if (r13 == null) goto L44;
        Map r18 = r13.getMap();
        if (r18 == null) goto L44;
        String r19 = (String) r18.get("enter_from_merge");
        if (r19 == null) goto L44;
    L45:
        b(r9, "enter_from_merge", r19);
        if (r13 == null) goto L51;
        Map r20 = r13.getMap();
        if (r20 == null) goto L51;
        String r21 = (String) r20.get("enter_method");
        if (r21 == null) goto L51;
    L52:
        b(r9, "enter_method", r21);
        if (r13 == null) goto L58;
        Map r22 = r13.getMap();
        if (r22 == null) goto L58;
        String r23 = (String) r22.get("action_type");
        if (r23 == null) goto L58;
    L59:
        b(r9, "action_type", r23);
        if (r13 == null) goto L63;
        String r24 = r13.h("homepage_hot_scene");
        if (r24 == null) goto L63;
    L64:
        b(r9, "homepage_hot_scene", r24);
        com.bytedance.android.livesdk.log.filter.o r25 = j0.l().c(am2.o.class);
        if ((r25 instanceof r) == true) goto L67;
        r25 = null;
    L67:
        r r26 = (r) r25;
        if (r26 == null) goto L75;
        String[] r27 = am2.o.b;
        int r28 = 0;
    L70:
        if (r28 >= 2) goto L75;
        String r29 = r27[r28];
        String r30 = (String) r26.getMap().get(r29);
        if (r30 != null) goto L74;
        r30 = "";
    L74:
        b(r9, r29, r30);
        r28 = r28 + 1;
    L75:
        String r31 = jc1.k.n(IMiddlewareUserService.class).user().n();
        if (r31 != null) goto L78;
        r31 = "";
    L78:
        b(r9, "user_id", r31);
        com.bytedance.live.datacontext.m r32 = m.i().getRoom();
        if (r32 == null) goto L84;
        IRoom r33 = (IRoom) r32.getValue();
        if (r33 == null) goto L84;
        String r34 = r33.getOwnerUserIdString();
        if (r34 == null) goto L84;
    L86:
        if (Intrinsics.areEqual(r34, jc1.k.n(IMiddlewareUserService.class).user().n()) == false) goto L89;
        String r35 = "anchor";
    L98:
        b(r9, "user_type", r35);
        u r36 = j0.l().c(IRoom.class);
        if ((r36 instanceof u) == false) goto L102;
        r12 = r36;
    L102:
        u r37 = r12;
        String r38 = r9.get("room_id");
        if (r38 == null) goto L106;
        r1 = r38;
    L106:
        if (r37 == null) goto L110;
        String r39 = r37.z(r1);
        if (r39 == null) goto L110;
        b(r9, "request_id", r39);
    L110:
        if (r37 == null) goto L116;
        Map r40 = r37.getMap();
        if (r40 == null) goto L116;
        String r41 = (String) r40.get("is_anchor");
        if (r41 == null) goto L116;
        b(r9, "is_anchor", r41);
    L116:
        com.bytedance.android.livesdk.log.filter.o r42 = j0.l().c(IRoom.class);
        if (r42 == null) goto L126;
        Map r43 = r42.getMap();
        if (r43 == null) goto L126;
        String r44 = (String) r43.get("joint_anchor_id");
        if (r44 == null) goto L123;
        b(r9, "joint_anchor_id", r44);
    L123:
        String r45 = (String) r43.get("is_joint_room");
        if (r45 == null) goto L126;
        b(r9, "is_joint_room", r45);
    L126:
        if (r37 == null) goto L133;
        r37.v(r9);
        return;
    L133:
        return;
    L89:
        if (jc1.k.n(IMiddlewareUserService.class).user().isAdmin() == false) goto L91;
        r35 = "admin";
        goto L98
    L91:
        Integer r46 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r46 != null) goto L95;
    L97:
        r35 = "audience";
        goto L98
    L95:
        if (r46.intValue() != 2) goto L97;
        r35 = "guest";
    L84:
        r34 = "";
    L63:
        r24 = "";
    L58:
        r23 = "";
    L51:
        r21 = "";
    L44:
        r19 = "";
        goto L45
    L32:
        r15 = null;
    L25:
        r10 = "";
    L18:
        r6 = "";
        goto L19
    }

    public static void b(Map r1, String r2, String r3) {
        if (r1.containsKey(r2) == true) goto L5;
    L6:
        r1.put(r2, r3);
        return;
    L5:
        if (TextUtils.isEmpty((CharSequence) r1.get(r2)) == true) goto L6;
    }
}
