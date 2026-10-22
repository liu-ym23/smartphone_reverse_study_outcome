package com.larus.avlink.plugins;

import com.larus.avlink.business.api.DoraAvlinkSessionState;
import com.larus.avlink.platform.AndroidPlatformKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d extends com.larus.audio.call.arch.a<n4> implements y2 {
    public final List<com.larus.audio.call.arch.a<n4>> f;
    public final a g;

    public static final class a implements a3 {
        public final /* synthetic */ d a;

        @Override // com.larus.avlink.plugins.a3
        public final void b() {
            this.a.getClass();
            y88.f r0 = d.l3();
            if (r0 == null) goto L6;
            r0.e3();
            return;
        }

        public a(d r1) {
            this.a = r1;
        }

        @Override // com.larus.avlink.plugins.a3
        public final void a(DoraAvlinkSessionState r2) {
            Intrinsics.checkNotNullParameter(r2, "next");
            this.a.getClass();
            d.k3(new y88.e.f(r2));
        }

        @Override // com.larus.avlink.plugins.a3
        public final void c(y88.g r2) {
            Intrinsics.checkNotNullParameter(r2, "config");
            this.a.getClass();
            d.j3(r2);
        }

        @Override // com.larus.avlink.plugins.a3
        public final void e(y88.e r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            this.a.getClass();
            d.k3(r2);
        }

        @Override // com.larus.avlink.plugins.a3
        public final void d(y88.g r2, y88.c r3) {
            Intrinsics.checkNotNullParameter(r2, "config");
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a.getClass();
            d.j3(r2);
            y88.f r4 = d.l3();
            if (r4 == null) goto L6;
            r4.f2(r3);
            return;
        }
    }

    public final String T2() {
        return "DoraSessionKMPPlugin";
    }

    public final void b3() {
    }

    public static y88.f l3() {
        pd6.b r0 = pd6.c.a;
        return pd6.c.a(Reflection.getOrCreateKotlinClass(y88.f.class));
    }

    public final void V2() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r0.next()).V2();
        goto L4
    }

    public final void W2() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r0.next()).W2();
        goto L4
    }

    public final void X2() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r0.next()).X2();
        goto L4
    }

    public final void Y2() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r0.next()).Y2();
        goto L4
    }

    public final void a3() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r0.next()).a3();
        goto L4
    }

    public final void g3() {
        Iterator r0 = ((ArrayList) this.f).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r0.next()).g3();
        goto L4
    L6:
        super.g3();
        Iterator r1 = ((ArrayList) this.f).iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        ((com.larus.audio.call.arch.a) r1.next()).b3();
        goto L8
    L10:
        y88.f r2 = l3();
        if (r2 == null) goto L13;
        r2.release();
    L13:
        d r3 = b3.a;
        if (b3.a != this) goto L19;
        b3.a = null;
        return;
    }

    public final void h3() {
        Iterator<T> r0 = this.f.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r0.next()).h3();
        goto L4
    }

    public final void e3() {
        super.e3();
        Iterator r0 = ((ArrayList) this.f).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((com.larus.audio.call.arch.a) r0.next()).e3();
        goto L4
    }

    public d(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = new ArrayList();
        this.g = new a(this);
    }

    public static void j3(y88.g r1) {
        y88.f r0 = l3();
        if (r0 != null) goto L6;
        com.larus.avlink.n1.e("DoraSessionKMPPlugin", "DoraAvlinkSessionService unavailable");
        return;
    L6:
        AndroidPlatformKt.a();
        r0.I(r1.a);
    }

    public static void k3(y88.e r2) {
        y88.f r0 = l3();
        if (r0 != null) goto L6;
        return;
    L6:
        if ((r2 instanceof y88.e.f) == false) goto L9;
        r0.c2(((y88.e.f) r2).a.ordinal());
        return;
    L9:
        if (Intrinsics.areEqual(r2, y88.e.h.a) == false) goto L12;
        r0.s1();
        return;
    L12:
        if (Intrinsics.areEqual(r2, y88.e.b.a) == false) goto L15;
        r0.B0();
        return;
    L15:
        if ((r2 instanceof y88.e.e) == false) goto L18;
        r0.I2(((y88.e.e) r2).a);
        return;
    L18:
        if (Intrinsics.areEqual(r2, y88.e.a.a) == false) goto L21;
        r0.D();
        return;
    L21:
        if ((r2 instanceof y88.e.c) == false) goto L24;
        r0.R0(((y88.e.c) r2).a);
        return;
    L24:
        if ((r2 instanceof y88.e.d) == false) goto L27;
        r0.r(((y88.e.d) r2).a);
        return;
    L27:
        if ((r2 instanceof y88.e.g) == false) goto L31;
        y88.e.g r3 = (y88.e.g) r2;
        r0.u0(r3.a, r3.b.ordinal());
        return;
    L31:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.avlink.plugins.y2
    public final void r(boolean r2) {
        k3(new y88.e.d(r2));
    }
}
