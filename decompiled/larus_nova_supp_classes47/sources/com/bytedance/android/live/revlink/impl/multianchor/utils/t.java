package com.bytedance.android.live.revlink.impl.multianchor.utils;

import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revlink.impl.multianchor.connect.AnchorRtcConnectUtilsKt;
import com.bytedance.android.live.revlink.impl.multianchor.vm.MultiLinkAnchorControlContext;
import com.bytedance.android.livesdk.link.model.bridge.h1;
import com.bytedance.android.livesdk.link.model.bridge.i1;
import com.bytedance.android.livesdk.link.model.e6;
import com.bytedance.android.livesdk.link.model.f6;
import com.bytedance.android.livesdk.link.model.i6;
import com.bytedance.android.livesdk.link.model.j5;
import com.bytedance.android.livesdk.link.model.k6;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.android.livesdk.link.model.v4;
import com.bytedance.android.livesdk.message.model.qj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class t implements com.bytedance.android.live.revenuelink.connect.p {
    public final com.bytedance.android.live.revlink.impl.global.c a;

    @Override // com.bytedance.android.live.revenuelink.connect.p
    public final void b(d11.d r2, v4 r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r2, "params");
        Intrinsics.checkNotNullParameter(r3, "result");
        Intrinsics.checkNotNullParameter(r4, "extra");
    }

    @Override // com.bytedance.android.live.revenuelink.connect.p
    public final void c(JSONObject r2, LiveTracingMonitorKt.EventModule r3) {
        Intrinsics.checkNotNullParameter(r2, "extra");
        Intrinsics.checkNotNullParameter(r3, "eventModule");
    }

    public final s f() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.a;
        if (r0 == null) goto L5;
        MultiLinkAnchorControlContext r1 = r0.ua();
    L6:
        if (r1 != null) goto L8;
        return null;
    L8:
        return r1.getConnectMonitor();
    L5:
        r1 = null;
        goto L6
    }

    public t(com.bytedance.android.live.revlink.impl.global.c r1) {
        this.a = r1;
    }

    public final g h(i6 r22) {
        Intrinsics.checkNotNullParameter(r22, "message");
        Intrinsics.checkNotNullParameter(r22, "$this$typeExt");
        ArrayList r2 = null;
        if (((int) r22.getType2()) == 5) goto L7;
        Intrinsics.checkNotNullParameter(r22, "$this$typeExt");
        if (((int) r22.getType2()) == 8) goto L7;
        return null;
    L7:
        final s r3 = f();
        if (r3 == null) goto L134;
        Intrinsics.checkNotNullParameter(r22, "$this$typeExt");
        int r1 = (int) r22.getType2();
        k6 r6 = r22.getReply();
        Intrinsics.checkNotNullParameter(r22, "$this$sceneExt");
        int r8 = (int) r22.getScene();
        String r0 = String.valueOf(qj.a(r22));
        Intrinsics.checkNotNullParameter(r0, "bindID");
        if (u41.d.n.a() == true) goto L13;
        return null;
    L13:
        if (r8 != 7) goto L137;
        if (r6 != null) goto L17;
        return null;
    L17:
        if (((int) r6.getReplyStatus()) != 1) goto L138;
        i97.a r9 = i97.a.a;
        long r12 = System.currentTimeMillis();
        com.bytedance.android.live.revlink.impl.global.c r10 = r3.c;
        if (com.bytedance.android.live.revenuelink.connect.b.b((int) r6.getMatchType()) == false) goto L23;
        h r13 = h.d.c;
    L22:
        h r14 = r13;
        StringBuilder r15 = new StringBuilder();
        r15.append(r3.d());
        r15.append('_');
        r15.append(r12);
        r15.append('_');
        r15.append(r3.c());
        String r16 = r15.toString();
        com.bytedance.android.live.revlink.impl.global.c r17 = r3.c;
        if (r17 == null) goto L51;
        w r18 = r17.getMultiLinkUtil();
    L53:
        if (r18 != null) goto L55;
    L58:
        boolean r19 = true;
    L59:
        if (r1 == 5) goto L72;
        if (r1 != 8) goto L73;
        com.bytedance.android.live.revlink.impl.global.c r4 = r3.c;
        if (r4 == null) goto L67;
        com.bytedance.android.live.revlink.impl.utils.s r5 = r4.getRevLinkCommonUtil();
        if (r5 == null) goto L67;
        String r7 = r5.e();
    L69:
        if (Intrinsics.areEqual(r7, r6.getFromUid()) == false) goto L73;
    L74:
        boolean r110 = false;
    L75:
        final g r20 = new g(r10, r14, r12, r16, r19, r110, r0, false);
        if ((r20.e instanceof h.f) == false) goto L83;
        j5 r23 = r6.getFromLinkmicInfo();
        if (r23 == null) goto L105;
        String r24 = r23.getInteractIdStr();
        if (r24 == null) goto L105;
        r20.a(r24);
    L105:
        if ((!r20.b.isEmpty()) == false) goto L107;
        ((ArrayList) r3.a).add(r20);
    L107:
        com.bytedance.android.live.revenuelink.rtc.i r25 = r3.e();
        if (r25 == null) goto L123;
        com.bytedance.android.live.revenuelink.rtc.p r26 = r25.L();
        if (r26 == null) goto L123;
        List<com.bytedance.android.live.revenuelink.rtc.o> r27 = r26.l();
        if (r27 == null) goto L123;
        final ArrayList r28 = new ArrayList();
        Iterator<T> r29 = r27.iterator();
    L115:
        if (r29.hasNext() == false) goto L120;
        Object r30 = r29.next();
        if (((com.bytedance.android.live.revenuelink.rtc.o) r30).d == false) goto L115;
        r28.add(r30);
        goto L115
    L120:
        if ((!r28.isEmpty()) == false) goto L123;
        p0.a(0, true, true, new MultiConnectMonitor$replyAndPermitMessage$$inlined$let$lambda$1(r28, r3, r20), 1);
    L123:
        return r20;
    L83:
        if (AnchorRtcConnectUtilsKt.a(r3.c) == true) goto L85;
    L99:
        j5 r32 = r6.getToLinkmicInfo();
        if (r32 == null) goto L105;
        String r33 = r32.getInteractIdStr();
        if (r33 == null) goto L105;
        r20.a(r33);
        goto L105
    L85:
        if ((r20.e instanceof h.a) == false) goto L99;
        List r34 = r6.getLinkUsers();
        if (r34 == null) goto L97;
        r2 = new ArrayList();
        Iterator r35 = r34.iterator();
    L90:
        if (r35.hasNext() == false) goto L97;
        Object r36 = r35.next();
        if (((com.bytedance.android.livesdk.link.model.p) r36).getStatus() != 2) goto L94;
        boolean r37 = true;
    L95:
        if (r37 == false) goto L90;
        r2.add(r36);
        goto L90
    L94:
        r37 = false;
    L97:
        if (r2 == null) goto L105;
        r20.b(CollectionsKt.toList(r2));
    L67:
        r7 = null;
    L73:
        r110 = true;
        goto L75
    L72:
        if (com.bytedance.android.live.revenuelink.connect.b.b((int) r6.getMatchType()) == true) goto L74;
    L55:
        if (r18.c() != true) goto L58;
        r19 = false;
        goto L59
    L51:
        r18 = null;
        goto L53
    L23:
        if (r1 == 5) goto L37;
        if (r1 == 8) goto L26;
        r13 = h.d.c;
        goto L22
    L26:
        String r38 = r6.getFromUid();
        com.bytedance.android.live.revlink.impl.global.c r111 = r3.c;
        if (r111 == null) goto L29;
        com.bytedance.android.live.revlink.impl.utils.s r112 = r111.getRevLinkCommonUtil();
    L30:
        if (r112 == null) goto L32;
        String r113 = r112.e();
    L34:
        if (Intrinsics.areEqual(r38, r113) == false) goto L36;
        r13 = h.a.c;
        goto L22
    L36:
        r13 = h.f.c;
        goto L22
    L32:
        r113 = null;
        goto L34
    L29:
        r112 = null;
        goto L30
    L37:
        String r39 = r6.getFromUid();
        com.bytedance.android.live.revlink.impl.global.c r114 = r3.c;
        if (r114 == null) goto L40;
        com.bytedance.android.live.revlink.impl.utils.s r115 = r114.getRevLinkCommonUtil();
    L41:
        if (r115 == null) goto L43;
        String r116 = r115.e();
    L45:
        if (Intrinsics.areEqual(r39, r116) == false) goto L47;
        r13 = h.b.c;
        goto L22
    L47:
        r13 = h.c.c;
        goto L22
    L43:
        r116 = null;
        goto L45
    L40:
        r115 = null;
        goto L41
    L138:
        return null;
    L137:
        return null;
    L134:
        return null;
    }

    public static String g(long r1, q5 r3) {
        Intrinsics.checkNotNullParameter(r3, "replyResult");
        StringBuilder r0 = new StringBuilder();
        r0.append(r1);
        r0.append('#');
        r0.append(r3.getLinkMicId());
        return r0.toString();
    }

    @Override // com.bytedance.android.live.revenuelink.connect.p
    public final void e(h1 r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "_message");
        Intrinsics.checkNotNullParameter(r4, "extra");
        i6 r5 = r3.castTo(i6.class);
        if (((int) i1.c(r5)) == 5) goto L7;
        Intrinsics.checkNotNullParameter(r5, "$this$typeExt");
        if (((int) r5.getType2()) == 8) goto L7;
        return;
    L7:
        s r0 = f();
        if (r0 == null) goto L13;
        g r6 = r0.b(String.valueOf(qj.a(r5)));
        if (r6 == null) goto L14;
        int r1 = y50.b.a;
        y50.b.a.d(r4, "connection_id", r6.g);
        y50.b.a.b(r4, "from_status", !r6.h ? 1 : 0);
        y50.b.a.b(r4, "opposite_status", !r6.i ? 1 : 0);
        y50.b.a.b(r4, "is_pk_to_multi", r6.k ? 1 : 0);
        y50.b.a.b(r4, "connect_build_role", r6.e.b);
        y50.b.a.b(r4, "is_first_frame_optimize", AnchorRtcConnectUtilsKt.a(this.a) ? 1 : 0);
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.revenuelink.connect.p
    public final void a(d11.f r16, com.bytedance.android.livesdk.link.model.v r17, long r18, JSONObject r20) {
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r17, "permitData");
        Intrinsics.checkNotNullParameter(r20, "extra");
        int r2 = y50.b.a;
        y50.b.a.b(r20, "is_first_frame_optimize", AnchorRtcConnectUtilsKt.a(this.a) ? 1 : 0);
        y50.b.a.d(r20, "permit_type", String.valueOf(r16.c));
        if (r16.c == 1) goto L5;
        return;
    L5:
        final s r12 = f();
        if (r12 == null) goto L40;
        int r3 = r16.a;
        String r0 = r16.g;
        if (r0 != null) goto L10;
        r0 = "";
    L10:
        String r13 = r0;
        com.bytedance.android.livesdk.link.model.v r1 = r17.castTo(com.bytedance.android.livesdk.link.model.v.class);
        StringBuilder r4 = new StringBuilder();
        r4.append(r18);
        r4.append('#');
        r4.append(r1.getChannelId());
        String r8 = r4.toString();
        Intrinsics.checkNotNullParameter(r13, "applyInteractId");
        Intrinsics.checkNotNullParameter(r8, "bindID");
        if (u41.d.n.a() == true) goto L14;
    L15:
        g r5 = null;
    L32:
        if (r5 == null) goto L41;
        int r6 = y50.b.a;
        y50.b.a.d(r20, "connection_id", r5.g);
        y50.b.a.b(r20, "from_status", !r5.h ? 1 : 0);
        y50.b.a.b(r20, "opposite_status", !r5.i ? 1 : 0);
        y50.b.a.b(r20, "connect_build_role", r5.e.b);
        return;
    L41:
        return;
    L14:
        if (r3 != 7) goto L15;
        com.bytedance.android.live.revlink.impl.global.c r7 = r12.c;
        h.e r9 = h.e.c;
        StringBuilder r10 = new StringBuilder();
        r10.append(r12.d());
        r10.append('_');
        r10.append(r18);
        r10.append('_');
        r10.append(r12.c());
        final g r14 = new g(r7, r9, r18, r10.toString(), false, true, r8);
        r14.a(r13);
        ((ArrayList) r12.a).add(r14);
        com.bytedance.android.live.revenuelink.rtc.i r15 = r12.e();
        if (r15 == null) goto L31;
        com.bytedance.android.live.revenuelink.rtc.p r19 = r15.L();
        if (r19 == null) goto L31;
        List<com.bytedance.android.live.revenuelink.rtc.o> r22 = r19.l();
        if (r22 == null) goto L31;
        final ArrayList r23 = new ArrayList();
        Iterator<T> r24 = r22.iterator();
    L24:
        if (r24.hasNext() == false) goto L29;
        Object r25 = r24.next();
        if (((com.bytedance.android.live.revenuelink.rtc.o) r25).d == false) goto L24;
        r23.add(r25);
        goto L24
    L29:
        if ((!r23.isEmpty()) == false) goto L31;
        p0.a(0, true, true, new MultiConnectMonitor$permitSuccess$$inlined$let$lambda$1(r23, r12, r14), 1);
    L31:
        r5 = r14;
        goto L32
    }

    @Override // com.bytedance.android.live.revenuelink.connect.p
    public final void d(d11.g r19, q5 r20, long r22, JSONObject r23) {
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r20, "replyResult");
        Intrinsics.checkNotNullParameter(r23, "extra");
        int r5 = y50.b.a;
        y50.b.a.b(r23, "is_first_frame_optimize", AnchorRtcConnectUtilsKt.a(this.a) ? 1 : 0);
        if (r19.e == 1) goto L5;
        return;
    L5:
        final s r12 = f();
        if (r12 == null) goto L94;
        int r6 = r19.a;
        q5 r13 = r20.castTo(q5.class);
        vh7.c r0 = r19.j.k;
        if (r0 == null) goto L10;
        e6 r15 = (e6) r0.castTo(e6.class);
    L11:
        String r8 = g(r22, r20.castTo(q5.class));
        Intrinsics.checkNotNullParameter(r13, "replyResult");
        Intrinsics.checkNotNullParameter(r8, "bindID");
        if (u41.d.n.a() == true) goto L15;
    L80:
        final g r14 = null;
    L81:
        if (r14 == null) goto L95;
        int r1 = y50.b.a;
        y50.b.a.d(r23, "connection_id", r14.g);
        y50.b.a.b(r23, "from_status", !r14.h ? 1 : 0);
        y50.b.a.b(r23, "opposite_status", !r14.i ? 1 : 0);
        y50.b.a.b(r23, "connect_build_role", r14.e.b);
        return;
    L95:
        return;
    L15:
        if (r6 != 7) goto L80;
        if (r15 == null) goto L80;
        h r2 = h.g.c;
        if (r15.getInviteSource() != 2) goto L21;
        r2 = h.d.c;
    L21:
        h r3 = r2;
        com.bytedance.android.live.revlink.impl.global.c r4 = r12.c;
        StringBuilder r7 = new StringBuilder();
        r7.append(r12.d());
        r7.append('_');
        r7.append(r22);
        r7.append('_');
        r7.append(r12.c());
        String r9 = r7.toString();
        com.bytedance.android.live.revlink.impl.global.c r10 = r12.c;
        if (r10 == null) goto L24;
        w r16 = r10.getMultiLinkUtil();
    L26:
        if (r16 != null) goto L28;
    L31:
        boolean r17 = true;
    L33:
        if (r15.getInviteSource() != 0) goto L35;
        boolean r18 = true;
    L36:
        r14 = r6;
        g r24 = new g(r4, r3, r22, r9, r17, r18, r8);
        if (AnchorRtcConnectUtilsKt.a(r12.c) == false) goto L53;
        List r25 = r13.getLinkUsers();
        if (r25 == null) goto L50;
        ArrayList r26 = new ArrayList();
        Iterator r27 = r25.iterator();
    L42:
        if (r27.hasNext() == false) goto L49;
        Object r28 = r27.next();
        if (((com.bytedance.android.livesdk.link.model.p) r28).getStatus() != 2) goto L46;
        boolean r29 = true;
    L47:
        if (r29 == false) goto L42;
        r26.add(r28);
        goto L42
    L46:
        r29 = false;
        goto L47
    L49:
        ArrayList r110 = r26;
    L51:
        if (r110 == null) goto L63;
        r14.b(CollectionsKt.toList(r110));
    L63:
        if ((!r14.b.isEmpty()) == false) goto L65;
        ((ArrayList) r12.a).add(r14);
    L65:
        com.bytedance.android.live.revenuelink.rtc.i r30 = r12.e();
        if (r30 == null) goto L81;
        com.bytedance.android.live.revenuelink.rtc.p r32 = r30.L();
        if (r32 == null) goto L81;
        List<com.bytedance.android.live.revenuelink.rtc.o> r33 = r32.l();
        if (r33 == null) goto L81;
        final ArrayList r34 = new ArrayList();
        Iterator<T> r35 = r33.iterator();
    L73:
        if (r35.hasNext() == false) goto L78;
        Object r36 = r35.next();
        if (((com.bytedance.android.live.revenuelink.rtc.o) r36).d == false) goto L73;
        r34.add(r36);
        goto L73
    L78:
        if ((!r34.isEmpty()) == false) goto L81;
        p0.a(0, true, true, new MultiConnectMonitor$replyAgree$$inlined$let$lambda$1(r34, r12, r14), 1);
        goto L81
    L50:
        r110 = null;
        goto L51
    L53:
        List r37 = f6.b(r15);
        if (r37 == null) goto L56;
        List<? extends com.bytedance.android.livesdk.link.model.p> r38 = CollectionsKt.toList(r37);
    L57:
        r14.b(r38);
        j5 r39 = r15.getFromLinkMicInfo();
        if (r39 == null) goto L63;
        String r40 = r39.getInteractIdStr();
        if (r40 == null) goto L63;
        r14.a(r40);
        goto L63
    L56:
        r38 = null;
        goto L57
    L35:
        r18 = false;
        goto L36
    L28:
        if (r16.c() != true) goto L31;
        r17 = false;
        goto L33
    L24:
        r16 = null;
        goto L26
    L10:
        r15 = null;
        goto L11
    }
}
