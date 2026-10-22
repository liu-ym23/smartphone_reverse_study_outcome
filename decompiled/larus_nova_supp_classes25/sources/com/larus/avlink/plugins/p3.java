package com.larus.avlink.plugins;

import com.larus.avlink.model.TimerScene;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class p3 extends com.larus.audio.call.arch.a<n4> implements x3, o4 {
    public final o3 f;
    public final o3 g;
    public final y2 h;
    public final o4 i;
    public final o3 j;
    public final y2 k;

    public final com.larus.im.service.audio.z0 S2() {
        return null;
    }

    public final String T2() {
        return "DoraTimeoutCoordinatorPlugin";
    }

    @Override // com.larus.avlink.plugins.o3
    public final void Z1() {
        this.j.Z1();
    }

    public final void b3() {
        this.f.C2();
    }

    public final void g3() {
        this.f.s2();
        super.g3();
    }

    public final void e3() {
        super.e3();
        this.f.w1();
    }

    @Override // com.larus.avlink.plugins.o3
    public final void C2() {
        b3();
    }

    @Override // com.larus.avlink.plugins.o3
    public final void s2() {
        g3();
    }

    @Override // com.larus.avlink.plugins.o3
    public final void w1() {
        e3();
    }

    @Override // com.larus.avlink.plugins.o3
    public final void G(TimerScene r2) {
        Intrinsics.checkNotNullParameter(r2, "scene");
        this.j.G(r2);
    }

    @Override // com.larus.avlink.plugins.o4
    public final void Q0(int r2) {
        o4 r0 = this.i;
        if (r0 == null) goto L6;
        r0.Q0(r2);
        return;
    }

    @Override // com.larus.avlink.plugins.o3
    public final void g1(String r2) {
        Intrinsics.checkNotNullParameter("wakeup success", "source");
        this.j.g1("wakeup success");
    }

    @Override // com.larus.avlink.plugins.o3
    public final void q1(DoraNotificationSummaryPlugin.c r2) {
        Intrinsics.checkNotNullParameter(r2, "interceptor");
        this.f.q1(r2);
        this.g.q1(r2);
    }

    @Override // com.larus.avlink.plugins.y2
    public final void r(boolean r2) {
        this.k.r(r2);
    }

    public p3(n4 r3, DoraTimerPlugin r4, d r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "legacyController");
        Intrinsics.checkNotNullParameter(r5, "kmpSessionController");
        super(r3);
        this.f = r4;
        Iterator r6 = ((ArrayList) r5.f).iterator();
    L3:
        o3 r0 = null;
        if (r6.hasNext() == false) goto L11;
        o3 r7 = (com.larus.audio.call.arch.a) r6.next();
        if ((r7 instanceof o3) == false) goto L9;
        r0 = r7;
    L9:
        r0 = r0;
        if (r0 == null) goto L3;
    L11:
        if (r0 == null) goto L15;
        this.g = r0;
        this.h = r4;
        this.i = r4;
        this.j = this.f;
        this.k = r4;
        return;
    L15:
        throw new IllegalArgumentException("DoraTimeoutCoordinatorPlugin requires KMP timeout ability".toString());
    }

    @Override // com.larus.avlink.plugins.o4
    public final void i0(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "caller");
        Intrinsics.checkNotNullParameter(r2, "caller");
        o4 r0 = this.i;
        if (r0 == null) goto L6;
        r0.i0(r2, r3, r4);
        return;
    }
}
