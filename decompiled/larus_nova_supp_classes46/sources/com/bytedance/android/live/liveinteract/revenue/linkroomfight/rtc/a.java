package com.bytedance.android.live.liveinteract.revenue.linkroomfight.rtc;

import com.bytedance.android.live.liveinteract.api.fulllink.InteractLinkFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.core.k;
import com.bytedance.android.live.liveinteract.revenue.linkroomfight.core.LinkRoomFightContext;
import com.bytedance.android.live.liveinteract.utils.x0;
import hg6.g;
import java.nio.ByteBuffer;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import zf2.s0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a extends vb6.a {
    public final /* synthetic */ LinkRoomFightRtcManager a;

    public a(LinkRoomFightRtcManager r1) {
        this.a = r1;
    }

    public final void vc(ei6.a r8, int r9, long r10, Object... r12) {
        Intrinsics.checkNotNullParameter(r12, "params");
        if (r9 != 5) goto L5;
        this.a.b = false;
        jy0.b.d("multi_rtc", "RtcManager MSG_INFO_END_SUCCEED rtc msg_info_end_succeed");
        return;
    L5:
        switch(r9) {
            case 301: goto L11;
            case 302: goto L10;
            case 303: goto L9;
            default: goto L6;
        };
    L6:
        Object r2 = null;
        switch(r9) {
            case 501: goto L110;
            case 502: goto L97;
            case 503: goto L33;
            case 504: goto L21;
            case 505: goto L12;
            default: goto L150;
        };
    L12:
        int r11 = LinkRoomFightRtcManager.i;
        jy0.b.d(LinkRoomFightContext.TAG, "on push public stream first audio frame " + r12[0]);
        Iterator<k> r13 = this.a.d.iterator();
    L14:
        if (r13.hasNext() == false) goto L151;
        k r14 = r13.next();
        if (r14 == null) goto L14;
        Object r15 = r12[0];
        if ((r15 instanceof String) == true) goto L20;
        r15 = null;
    L20:
        r14.wf((String) r15);
        goto L14
    L151:
        return;
    L21:
        int r16 = LinkRoomFightRtcManager.i;
        jy0.b.d(LinkRoomFightContext.TAG, "on push public stream first video frame decode " + r12[0] + ' ' + r12[1]);
        Iterator<k> r17 = this.a.d.iterator();
    L23:
        if (r17.hasNext() == false) goto L152;
        k r18 = r17.next();
        if (r18 == null) goto L23;
        Object r19 = r12[0];
        if ((r19 instanceof String) == true) goto L29;
        r19 = null;
    L29:
        String r110 = (String) r19;
        Object r1 = r12[1];
        if ((r1 instanceof s0) == true) goto L32;
        r1 = null;
    L32:
        r18.T6(r110, (s0) r1);
        goto L23
    L152:
        return;
    L33:
        Object r20 = r12[1];
        if ((r20 instanceof ByteBuffer) == false) goto L66;
        int r21 = LinkRoomFightRtcManager.i;
        jy0.b.d(LinkRoomFightContext.TAG, "on push public stream sei msg " + r12[0] + ' ' + r12[1] + ' ' + r12[2]);
        Iterator<k> r22 = this.a.d.iterator();
    L37:
        if (r22.hasNext() == false) goto L51;
        k r23 = r22.next();
        if (r23 == null) goto L37;
        Object r111 = r12[0];
        if ((r111 instanceof String) == true) goto L43;
        r111 = null;
    L43:
        String r112 = (String) r111;
        Object r3 = r12[1];
        if ((r3 instanceof ByteBuffer) == true) goto L46;
        r3 = null;
    L46:
        ByteBuffer r4 = (ByteBuffer) r3;
        Object r5 = r12[2];
        if (r5 == null) goto L50;
        r23.D1(r112, r4, ((Integer) r5).intValue());
        goto L37
    L50:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L51:
        g r24 = this.a.g;
        if (r24 == null) goto L144;
        Object r25 = r12[0];
        if ((r25 instanceof String) == true) goto L56;
        r25 = null;
    L56:
        String r26 = (String) r25;
        Object r113 = r12[1];
        if ((r113 instanceof ByteBuffer) == false) goto L60;
        r2 = r113;
    L60:
        ByteBuffer r6 = (ByteBuffer) r2;
        Object r114 = r12[2];
        if (r114 == null) goto L64;
        r24.D1(r26, r6, ((Integer) r114).intValue());
        return;
    L64:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L144:
        return;
    L66:
        if ((r20 instanceof String) == false) goto L146;
        int r27 = LinkRoomFightRtcManager.i;
        jy0.b.d(LinkRoomFightContext.TAG, "on push public stream sei msg " + r12[0] + ' ' + r12[1] + ' ' + r12[2]);
        Iterator<k> r28 = this.a.d.iterator();
    L69:
        if (r28.hasNext() == false) goto L83;
        k r29 = r28.next();
        if (r29 == null) goto L69;
        Object r115 = r12[0];
        if ((r115 instanceof String) == true) goto L75;
        r115 = null;
    L75:
        String r116 = (String) r115;
        Object r117 = r12[1];
        if ((r117 instanceof String) == true) goto L78;
        r117 = null;
    L78:
        String r118 = (String) r117;
        Object r119 = r12[2];
        if (r119 == null) goto L82;
        ((Integer) r119).intValue();
        r29.f4();
        goto L69
    L82:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L83:
        g r30 = this.a.g;
        if (r30 == null) goto L147;
        Object r31 = r12[0];
        if ((r31 instanceof String) == true) goto L88;
        r31 = null;
    L88:
        String r32 = (String) r31;
        Object r33 = r12[1];
        if ((r33 instanceof String) == false) goto L92;
        r2 = r33;
    L92:
        String r7 = (String) r2;
        Object r34 = r12[2];
        if (r34 == null) goto L96;
        ((Integer) r34).intValue();
        r30.f4();
        return;
    L96:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L147:
        return;
    L146:
        return;
    L97:
        int r35 = LinkRoomFightRtcManager.i;
        jy0.b.d(LinkRoomFightContext.TAG, "on play public stream result " + r12[0] + ' ' + r12[1]);
        Iterator<k> r36 = this.a.d.iterator();
    L99:
        if (r36.hasNext() == false) goto L153;
        k r37 = r36.next();
        if (r37 == null) goto L99;
        Object r120 = r12[0];
        if ((r120 instanceof String) == true) goto L105;
        r120 = null;
    L105:
        String r121 = (String) r120;
        Object r38 = r12[1];
        if (r38 == null) goto L109;
        r37.al(r121, ((Integer) r38).intValue());
        goto L99
    L109:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    L153:
        return;
    L110:
        int r39 = LinkRoomFightRtcManager.i;
        jy0.b.d(LinkRoomFightContext.TAG, "on push public stream MSG_INFO_PUBLIC_STREAM_PUSH_RESULT result " + r12[0] + ' ' + r12[1]);
        return;
    L150:
        return;
    L9:
        LinkRoomFightRtcManager r40 = this.a;
        r40.b = false;
        r40.a = 0;
        InteractLinkFullLinkMonitor.a0(String.valueOf(r12[0]), String.valueOf(r12[1]));
        zi0.a.b(r12[0], r12[1]);
        int r41 = LinkRoomFightRtcManager.i;
        jy0.b.d(LinkRoomFightContext.TAG, "on cross room rtc info MSG_INFO_FORWARD_STREAM_STATE_FAILURE " + r12[0] + ' ' + r12[1]);
        return;
    L10:
        LinkRoomFightRtcManager r42 = this.a;
        r42.b = true;
        Object r43 = r12[0];
        Object r44 = r12[1];
        int r45 = x0.a;
        long r46 = r42.a;
        i97.a r47 = i97.a.a;
        InteractLinkFullLinkMonitor.b0(r43, r44, System.currentTimeMillis() - r46);
        zi0.a.b(r12[0], r12[1]);
        int r48 = LinkRoomFightRtcManager.i;
        jy0.b.d(LinkRoomFightContext.TAG, "on cross room rtc info MSG_INFO_FORWARD_STREAM_STATE_SUCCESS " + r12[0] + ' ' + r12[1]);
        return;
    L11:
        this.a.b = false;
        zi0.a.b(r12[0], r12[1]);
        int r49 = LinkRoomFightRtcManager.i;
        jy0.b.d(LinkRoomFightContext.TAG, "on cross room rtc info MSG_INFO_FORWARD_STREAM_STATE_IDLE " + r12[0] + ' ' + r12[1]);
    }
}
