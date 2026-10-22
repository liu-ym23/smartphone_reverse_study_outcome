package com.bytedance.android.live.revlink.impl.mergepk.pkmulti;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.multianchor.utils.q;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.scope.m;
import cy0.j;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a {
    public boolean a;
    public final com.bytedance.android.livesdk.revenue.service.room.c b;
    public final com.bytedance.android.live.revlink.impl.global.c c;

    /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.mergepk.pkmulti.a$a, reason: collision with other inner class name */
    public static final class C0135a {
    }

    static {
    }

    public final void a(Map<String, String> r7) {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.c;
        String r1 = null;
        if (r0 == null) goto L5;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r2 = r0.getMultiAnchorLinkContextObj();
    L6:
        if (r2 == null) goto L8;
        Long r3 = Long.valueOf(r2.a());
    L9:
        r7.put("channel_id", String.valueOf(r3));
        com.bytedance.android.live.revlink.impl.global.c r4 = this.c;
        if (r4 == null) goto L12;
        w31.c r5 = r4.getPkLinkUtils();
    L13:
        if (r5 == null) goto L15;
        Long r6 = Long.valueOf(r5.i());
    L16:
        r7.put("pk_id", String.valueOf(r6));
        cy0.e.a.getClass();
        j r8 = cy0.e.a.a;
        m.e.getClass();
        Object r9 = m.b(r8).b(com.bytedance.android.livesdk.revenue.service.user.a.class);
        Intrinsics.checkNotNull(r9);
        IBaseUser r10 = ((com.bytedance.live.kmp.core.c) r9).b();
        String r12 = "";
        if (r10 == null) goto L20;
        String r13 = r10.getIdString();
        if (r13 == null) goto L20;
    L21:
        r7.put("user_id", r13);
        com.bytedance.android.live.revlink.impl.global.c r14 = this.c;
        if (r14 == null) goto L24;
        d31.d r15 = r14.getRevLinkLogHelper();
    L25:
        if (r15 == null) goto L28;
        String r16 = r15.a();
        if (r16 == null) goto L28;
    L29:
        r7.put("anchor_connect_status", r16);
        com.bytedance.android.live.revlink.impl.global.c r17 = this.c;
        if (r17 == null) goto L32;
        d31.d r18 = r17.getRevLinkLogHelper();
    L33:
        if (r18 == null) goto L35;
        String r19 = r18.f();
    L36:
        r7.put("invite_mode", r19);
        com.bytedance.android.live.revlink.impl.global.c r20 = this.c;
        if (r20 == null) goto L39;
        q r22 = r20.getMultiAnchorLinkLogUtils();
    L40:
        if (r22 == null) goto L43;
        String r23 = r22.c();
        if (r23 == null) goto L43;
    L44:
        r7.put("connection_type", r23);
        com.bytedance.android.live.revlink.impl.global.c r24 = this.c;
        if (r24 == null) goto L47;
        d31.d r25 = r24.getRevLinkLogHelper();
    L48:
        boolean r26 = false;
        if (r25 == null) goto L59;
        com.bytedance.android.live.revlink.impl.global.c r27 = this.c;
        if (r27 == null) goto L53;
        com.bytedance.android.live.revlink.impl.multianchor.vm.g r28 = r27.getMultiAnchorLinkContextObj();
    L54:
        if (r28 == null) goto L56;
        int r29 = r28.b();
    L57:
        String r30 = r25.p(r29);
        if (r30 == null) goto L59;
    L60:
        r7.put("invitee_list", r30);
        com.bytedance.android.live.revlink.impl.global.c r32 = this.c;
        if (r32 == null) goto L63;
        d31.d r33 = r32.getRevLinkLogHelper();
    L64:
        if (r33 == null) goto L66;
        String r34 = r33.s();
    L67:
        r7.put("room_status", r34);
        com.bytedance.android.live.revlink.impl.global.c r35 = this.c;
        if (r35 == null) goto L70;
        q r36 = r35.getMultiAnchorLinkLogUtils();
    L72:
        if (r36 == null) goto L86;
        LinkCrossRoomDataHolder r37 = r36.f();
        if (r37 == null) goto L86;
        if (r37.l().length() != 0) goto L78;
        r26 = true;
    L78:
        if (r26 != true) goto L86;
        mz0.e<?> r38 = mz0.d.b(LogCommon.ROOM);
        if (r38 == null) goto L85;
        Map<String, String> r39 = ((com.bytedance.android.live.revenue.platform.log.impl.filterimpl.a) r38).getMap();
        if (r39 == null) goto L85;
        r1 = r39.get("request_id");
        if (r1 == null) goto L85;
    L94:
        if (r1 == null) goto L97;
        r12 = r1;
    L97:
        r7.put("request_id", r12);
        return;
    L85:
        r1 = "";
    L86:
        com.bytedance.android.live.revlink.impl.global.c r40 = this.c;
        if (r40 == null) goto L89;
        q r42 = r40.getMultiAnchorLinkLogUtils();
    L90:
        if (r42 == null) goto L94;
        LinkCrossRoomDataHolder r43 = r42.f();
        if (r43 == null) goto L94;
        r1 = r43.l();
        goto L94
    L89:
        r42 = null;
        goto L90
    L70:
        r36 = null;
        goto L72
    L66:
        r34 = "";
        goto L67
    L63:
        r33 = null;
        goto L64
    L56:
        r29 = 0;
        goto L57
    L53:
        r28 = null;
    L59:
        r30 = "";
        goto L60
    L47:
        r25 = null;
    L43:
        r23 = "";
        goto L44
    L39:
        r22 = null;
        goto L40
    L35:
        r19 = "";
        goto L36
    L32:
        r18 = null;
    L28:
        r16 = "";
        goto L29
    L24:
        r15 = null;
    L20:
        r13 = "";
        goto L21
    L15:
        r6 = null;
        goto L16
    L12:
        r5 = null;
        goto L13
    L8:
        r3 = null;
        goto L9
    L5:
        r2 = null;
        goto L6
    }

    public a(com.bytedance.android.livesdk.revenue.service.room.c r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        this.b = r1;
        this.c = r2;
    }
}
