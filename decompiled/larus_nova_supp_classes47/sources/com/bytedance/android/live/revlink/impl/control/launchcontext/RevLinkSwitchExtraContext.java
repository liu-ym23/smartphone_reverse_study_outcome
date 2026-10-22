package com.bytedance.android.live.revlink.impl.control.launchcontext;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revlink.impl.multianchor.utils.u;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAnchorLaunchParam;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAudienceLaunchParam;
import com.bytedance.android.livesdk.link.model.a6;
import com.bytedance.android.livesdk.link.model.bridge.o1;
import com.bytedance.android.livesdk.link.model.bridge.p1;
import com.bytedance.android.livesdk.link.model.bridge.v1;
import com.bytedance.android.livesdk.link.model.d7;
import com.bytedance.android.livesdk.link.model.m;
import com.bytedance.android.livesdk.link.model.p0;
import com.bytedance.android.livesdk.link.model.v3;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class RevLinkSwitchExtraContext {
    public static final /* synthetic */ int g = 0;
    public final sc0.a a;
    public final sc0.b b;
    public final sc0.c c;
    public final sc0.d d;
    public final RevLinkAnchorLaunchParam e;
    public final RevLinkAudienceLaunchParam f;

    public static final class Companion {
        public Companion() {
        }

        public static RevLinkSwitchExtraContext a(u r26, f21.a r27, v3 r28, p0 r29, String r30) {
            a r17 = new a(r26, r27, r28, r29, r30);
            long r1 = 0;
            String r3 = "";
            int r4 = 7;
            if (d51.b.m.b() == true) goto L5;
            b03.a r0 = b03.a.a;
            final int r2 = s1.w();
            final int r9 = s1.y();
            if (r26 == null) goto L67;
            r4 = r26.b();
        L67:
            if (r26 == null) goto L72;
            String r10 = r26.c;
            if (r10 == null) goto L72;
            r3 = r10;
        L72:
            if (r26 == null) goto L74;
            r1 = r26.a;
        L74:
            long r12 = r1;
            Function0<Integer> r6 = new RevLinkSwitchExtraContext$Companion$packetMultiLinkAnchor$3(r9);
            Function0<Integer> r13 = new RevLinkSwitchExtraContext$Companion$packetMultiLinkAnchor$4(r2);
            if (r27 == null) goto L82;
            v1 r5 = r27.q;
            if (r5 == null) goto L82;
            o1 r7 = r5.getMultiAnchorLinkMicRtcInfo();
            if (r7 == null) goto L82;
            Map r8 = r7.getPushStreamModeRTCMap();
            if (r8 == null) goto L82;
        L83:
            Map r14 = r8;
            if (r27 == null) goto L91;
            d7 r15 = r27.p;
            if (r15 == null) goto L91;
            p1 r16 = r15.getMultiAnchorLiveCoreInfo();
            if (r16 == null) goto L91;
            Map r18 = r16.getPushStreamModeLiveCoreMap();
            if (r18 == null) goto L91;
        L92:
            Map r19 = r18;
            if (r27 == null) goto L100;
            v1 r20 = r27.q;
            if (r20 == null) goto L100;
            o1 r22 = r20.getMultiAnchorLinkMicRtcInfo();
            if (r22 == null) goto L100;
            Map r23 = r22.getRtcInfoMap();
            if (r23 == null) goto L100;
        L101:
            Map r110 = r23;
            if (r27 == null) goto L109;
            d7 r24 = r27.p;
            if (r24 == null) goto L109;
            p1 r25 = r24.getMultiAnchorLiveCoreInfo();
            if (r25 == null) goto L109;
            Map r32 = r25.getLiveCoreExtInfoMap();
            if (r32 == null) goto L109;
        L110:
            Map r210 = r32;
            if (r27 != null) goto L113;
        L115:
            boolean r211 = false;
        L116:
            if (r27 != null) goto L118;
        L120:
            boolean r212 = false;
        L122:
            return new RevLinkSwitchExtraContext(r17, null, null, new RevLinkAnchorLaunchParam(r4, r3, r12, r6, r13, r14, r19, r110, r210, r17, null, r211, r212, false, true), null, 46);
        L118:
            if (r27.b() != true) goto L120;
            r212 = true;
            goto L122
        L113:
            if (r27.c() != true) goto L115;
            r211 = true;
        L109:
            r32 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L100:
            r23 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L91:
            r18 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L82:
            r8 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
            goto L83
        L5:
            if (r26 == null) goto L7;
            r4 = r26.b();
        L7:
            if (r26 == null) goto L12;
            String r33 = r26.c;
            if (r33 == null) goto L12;
            r3 = r33;
        L12:
            if (r26 == null) goto L14;
            long r34 = r26.a;
        L15:
            RevLinkSwitchExtraContext$Companion$packetMultiLinkAnchor$1 r35 = RevLinkSwitchExtraContext$Companion$packetMultiLinkAnchor$1.INSTANCE;
            RevLinkSwitchExtraContext$Companion$packetMultiLinkAnchor$2 r111 = RevLinkSwitchExtraContext$Companion$packetMultiLinkAnchor$2.INSTANCE;
            if (r27 == null) goto L23;
            v1 r36 = r27.q;
            if (r36 == null) goto L23;
            o1 r37 = r36.getMultiAnchorLinkMicRtcInfo();
            if (r37 == null) goto L23;
            Map r38 = r37.getPushStreamModeRTCMap();
            if (r38 == null) goto L23;
        L24:
            Map r112 = r38;
            if (r27 == null) goto L32;
            d7 r39 = r27.p;
            if (r39 == null) goto L32;
            p1 r40 = r39.getMultiAnchorLiveCoreInfo();
            if (r40 == null) goto L32;
            Map r42 = r40.getPushStreamModeLiveCoreMap();
            if (r42 == null) goto L32;
        L33:
            Map r113 = r42;
            if (r27 == null) goto L41;
            v1 r43 = r27.q;
            if (r43 == null) goto L41;
            o1 r44 = r43.getMultiAnchorLinkMicRtcInfo();
            if (r44 == null) goto L41;
            Map r45 = r44.getRtcInfoMap();
            if (r45 == null) goto L41;
        L42:
            Map r114 = r45;
            if (r27 == null) goto L50;
            d7 r46 = r27.p;
            if (r46 == null) goto L50;
            p1 r47 = r46.getMultiAnchorLiveCoreInfo();
            if (r47 == null) goto L50;
            Map r48 = r47.getLiveCoreExtInfoMap();
            if (r48 == null) goto L50;
        L51:
            Map r213 = r48;
            if (r27 != null) goto L54;
        L56:
            boolean r214 = false;
        L57:
            if (r27 != null) goto L59;
        L61:
            boolean r215 = false;
        L63:
            return new RevLinkSwitchExtraContext(r17, null, null, new RevLinkAnchorLaunchParam(r4, r3, r34, r35, r111, r112, r113, r114, r213, r17, null, r214, r215, false, true), null, 46);
        L59:
            if (r27.b() != true) goto L61;
            r215 = true;
            goto L63
        L54:
            if (r27.c() != true) goto L56;
            r214 = true;
        L50:
            r48 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L41:
            r45 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L32:
            r42 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L23:
            r38 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
            goto L24
        L14:
            r34 = 0;
            goto L15
        }

        public static RevLinkSwitchExtraContext b(int r15, long r16, com.bytedance.android.live.revlink.impl.audience.c r18, String r19, a6 r20) {
            Intrinsics.checkNotNullParameter(r18, "source");
            b r0 = new b(r16, r18, r19, r20);
            if (d51.b.m.b() == false) goto L6;
            RevLinkSwitchExtraContext$Companion$packetMultiLinkAudience$1 r6 = RevLinkSwitchExtraContext$Companion$packetMultiLinkAudience$1.INSTANCE;
            return new RevLinkSwitchExtraContext(null, r0, null, null, new RevLinkAudienceLaunchParam(r15, r16, RevLinkSwitchExtraContext$Companion$packetMultiLinkAudience$2.INSTANCE, r6, r20, r0, 160), 29);
        L6:
            b03.a r1 = b03.a.a;
            final int r2 = s1.w();
            int r3 = s1.y();
            if (b03.a.c() == false) goto L9;
            int r4 = 0;
        L10:
            final int r5 = r3 + r4;
            Function0<Integer> r7 = new RevLinkSwitchExtraContext$Companion$packetMultiLinkAudience$3(r2);
            return new RevLinkSwitchExtraContext(null, r0, null, null, new RevLinkAudienceLaunchParam(r15, r16, new RevLinkSwitchExtraContext$Companion$packetMultiLinkAudience$4(r5), r7, r20, r0, 160), 29);
        L9:
            r4 = s1.A();
            goto L10
        }

        public static RevLinkSwitchExtraContext c(long r33, String r35, String r36, PkAnchorLaunchType r37, v1 r38, d7 r39, m r40, p0 r42, String r43) {
            Intrinsics.checkNotNullParameter(r35, "selfLinkerID");
            Intrinsics.checkNotNullParameter(r37, "launchType");
            c r32 = new c(r33, r36, r37, r42, r40, r43);
            if (d51.b.m.b() == false) goto L34;
            RevLinkSwitchExtraContext$Companion$packetPkAnchor$1 r5 = RevLinkSwitchExtraContext$Companion$packetPkAnchor$1.INSTANCE;
            RevLinkSwitchExtraContext$Companion$packetPkAnchor$2 r6 = RevLinkSwitchExtraContext$Companion$packetPkAnchor$2.INSTANCE;
            if (r38 == null) goto L10;
            o1 r0 = r38.getMultiAnchorLinkMicRtcInfo();
            if (r0 == null) goto L10;
            Map r1 = r0.getPushStreamModeRTCMap();
            if (r1 == null) goto L10;
        L11:
            Map r7 = r1;
            if (r39 == null) goto L17;
            p1 r2 = r39.getMultiAnchorLiveCoreInfo();
            if (r2 == null) goto L17;
            Map r3 = r2.getPushStreamModeLiveCoreMap();
            if (r3 == null) goto L17;
        L18:
            Map r8 = r3;
            if (r38 == null) goto L24;
            o1 r4 = r38.getMultiAnchorLinkMicRtcInfo();
            if (r4 == null) goto L24;
            Map r9 = r4.getRtcInfoMap();
            if (r9 == null) goto L24;
        L25:
            Map r10 = r9;
            if (r39 == null) goto L31;
            p1 r12 = r39.getMultiAnchorLiveCoreInfo();
            if (r12 == null) goto L31;
            Map r13 = r12.getLiveCoreExtInfoMap();
            if (r13 == null) goto L31;
        L33:
            return new RevLinkSwitchExtraContext(null, null, r32, new RevLinkAnchorLaunchParam(1, r35, r33, r5, r6, r7, r8, r10, r13, null, r32, true, false, false, true), null, 43);
        L31:
            r13 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L24:
            r9 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L17:
            r3 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L10:
            r1 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
            goto L11
        L34:
            b03.a r14 = b03.a.a;
            final int r15 = s1.y();
            final int r16 = s1.w();
            Function0<Integer> r17 = new RevLinkSwitchExtraContext$Companion$packetPkAnchor$3(r15);
            Function0<Integer> r18 = new RevLinkSwitchExtraContext$Companion$packetPkAnchor$4(r16);
            if (r38 == null) goto L40;
            o1 r19 = r38.getMultiAnchorLinkMicRtcInfo();
            if (r19 == null) goto L40;
            Map r20 = r19.getPushStreamModeRTCMap();
            if (r20 == null) goto L40;
        L41:
            Map r22 = r20;
            if (r39 == null) goto L47;
            p1 r23 = r39.getMultiAnchorLiveCoreInfo();
            if (r23 == null) goto L47;
            Map r24 = r23.getPushStreamModeLiveCoreMap();
            if (r24 == null) goto L47;
        L48:
            Map r25 = r24;
            if (r38 == null) goto L54;
            o1 r26 = r38.getMultiAnchorLinkMicRtcInfo();
            if (r26 == null) goto L54;
            Map r27 = r26.getRtcInfoMap();
            if (r27 == null) goto L54;
        L55:
            Map r28 = r27;
            if (r39 == null) goto L63;
            p1 r29 = r39.getMultiAnchorLiveCoreInfo();
            if (r29 == null) goto L63;
            Map r30 = r29.getLiveCoreExtInfoMap();
            if (r30 == null) goto L63;
            Map r210 = r30;
        L65:
            return new RevLinkSwitchExtraContext(null, null, r32, new RevLinkAnchorLaunchParam(1, r35, r33, r17, r18, r22, r25, r28, r210, null, r32, true, false, false, true), null, 43);
        L63:
            r210 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L54:
            r27 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L47:
            r24 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
        L40:
            r20 = com.bytedance.revenue.platform.api.core.d.a(new Pair[0]);
            goto L41
        }
    }

    static {
        new Companion();
    }

    public RevLinkSwitchExtraContext() {
        this(null, null, null, null, null, 63);
    }

    public final int hashCode() {
        sc0.a r0 = this.a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        sc0.b r4 = this.b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        sc0.c r7 = this.c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        sc0.d r10 = this.d;
        if (r10 == null) goto L17;
        int r12 = r10.hashCode();
    L18:
        int r13 = (r9 + r12) * 31;
        RevLinkAnchorLaunchParam r14 = this.e;
        if (r14 == null) goto L21;
        int r15 = r14.hashCode();
    L22:
        int r16 = (r13 + r15) * 31;
        RevLinkAudienceLaunchParam r17 = this.f;
        if (r17 == null) goto L26;
        r1 = r17.hashCode();
    L26:
        return r16 + r1;
    L21:
        r15 = 0;
        goto L22
    L17:
        r12 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "RevLinkSwitchExtraContext(multiLinkAnchorSwitchContext=" + this.a + ", multiLinkAudienceSwitchContext=" + this.b + ", pkAnchorSwitchContext=" + this.c + ", pkAudienceSwitchContext=" + this.d + ", revLinkAnchorLaunchParam=" + this.e + ", revLinkAudienceLaunchParam=" + this.f + ")";
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof RevLinkSwitchExtraContext) == false) goto L18;
        RevLinkSwitchExtraContext r4 = (RevLinkSwitchExtraContext) r3;
        if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.d, r4.d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.e, r4.e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f, r4.f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public RevLinkSwitchExtraContext(a r3, b r4, c r5, RevLinkAnchorLaunchParam r6, RevLinkAudienceLaunchParam r7, int r8) {
        if ((r8 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r8 & 16) == 0) goto L15;
        r6 = null;
    L15:
        if ((r8 & 32) == 0) goto L17;
        r7 = null;
    L17:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = null;
        this.e = r6;
        this.f = r7;
    }
}
