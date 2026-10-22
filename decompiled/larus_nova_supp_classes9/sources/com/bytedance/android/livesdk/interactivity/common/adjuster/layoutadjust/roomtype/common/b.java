package com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.roomtype.common;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.j;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.adapter.LiveRoomEnvStateHolder;
import com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.i;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import kotlin.jvm.internal.Intrinsics;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class b implements i {
    public static final int c = 0;
    public static final int d = 0;
    public static final boolean e = false;
    public static final b f = null;

    public b() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.f
    public final String d() {
        return "CommonAnchorWidthAdjust";
    }

    static {
        f = new b();
        Integer r0 = Integer.valueOf(s1.j(2131168920));
        if (r0.intValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        int r2 = r0.intValue();
    L12:
        c = r2;
        d = s1.f(8.0f);
        e = h.Q();
        return;
    L11:
        r2 = s1.f(12.0f);
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.bytedance.android.livesdk.interactivity.common.adjuster.layoutadjust.i
    public final k b(com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster.e r3, Room r4, LiveRoomEnvStateHolder r5) {
        Intrinsics.checkNotNullParameter(r3, "uiContext");
        Intrinsics.checkNotNullParameter(r4, "room");
        Intrinsics.checkNotNullParameter(r5, "roomStatus");
        if (r3.g1() == true) goto L7;
        return new k(0, 0, 7);
    L7:
        if (r5.y() == false) goto L9;
    L47:
        int r6 = r5.r0();
        boolean r0 = us1.e.a;
        if (r5.e0() == true) goto L50;
    L52:
        if (r6 <= 0) goto L55;
        int r7 = s1.f(r6 * 1.0f);
    L59:
        if (e == false) goto L64;
        if (r5.a0() == false) goto L64;
        r7 = Math.max(r7, (r5.o0() + c) + d);
    L64:
        if (r5.k == false) goto L66;
        boolean r8 = j.a;
        Intrinsics.checkNotNullParameter("adjust width by bottomRightCardShown", "msg");
        r7 = Math.max(r7, (r5.l + c) + d);
    L66:
        Integer r9 = h72.b.a();
        if (r9 == null) goto L71;
        return new k(-1, Math.max(r9.intValue(), r7), 2);
    L71:
        if (r5.o == false) goto L76;
        if (r5.U() == false) goto L76;
        r7 = Math.max(r7, r5.s);
    L76:
        if (r5.f0() == false) goto L79;
        r7 = Math.max(r7, (c + r5.p()) + d);
    L79:
        if (r5.K() == false) goto L82;
        r7 = Math.max(r7, (c + r5.l()) + d);
    L82:
        if (r5.y == false) goto L84;
        r7 = Math.max(r7, (c + r5.n()) + d);
    L84:
        if (r7 > 0) goto L88;
        r7 = -10086;
    L88:
        return g.a(r7);
    L55:
        if (r5.I() == false) goto L57;
        r7 = s1.f(28.0f);
        goto L59
    L57:
        r7 = s1.f(128.0f);
        goto L59
    L50:
        if (r5.k0() == false) goto L52;
        r7 = s1.f(28.0f);
        goto L59
    L9:
        if (r5.c == true) goto L47;
        if (r5.k0() == true) goto L47;
        if (r5.s() == true) goto L47;
        if (r5.m0() == true) goto L47;
        if (r5.v() == true) goto L47;
        if (r5.q() == true) goto L47;
        if (r5.F() == true) goto L47;
        if (r5.L() == true) goto L47;
        if (r5.z() == false) goto L29;
        r7 = s1.f(132.0f);
        goto L59
    L29:
        if (r5.l0() == false) goto L31;
    L43:
        int r10 = r5.r0();
        if (r10 <= 0) goto L46;
        r7 = s1.f(r10 * 1.0f);
        goto L59
    L46:
        r7 = c;
        goto L59
    L31:
        if (r5.Y() == true) goto L43;
        if (r5.C() == false) goto L40;
        int r11 = r5.r0();
        if (r11 <= 0) goto L38;
        r7 = s1.f(r11 * 1.0f);
        goto L59
    L38:
        r7 = c;
        goto L59
    L40:
        if (PublicScreenStyleHelper.b().e() == false) goto L42;
        r7 = c;
        goto L59
    L42:
        r7 = s1.f(60.0f);
        goto L59
    }
}
