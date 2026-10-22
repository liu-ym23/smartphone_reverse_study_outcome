package com.larus.bmhome.chat.component.bottom.core;

import com.larus.bmhome.chat.component.doubletab.IChatDoubleTabAbility;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import uaa.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class u7 implements y8 {
    public final Lazy A;
    public final Lazy B;
    public final /* synthetic */ v7 C;
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;
    public final Lazy j;
    public final Lazy k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final Lazy o;
    public final Lazy p;
    public final Lazy q;
    public final Lazy r;
    public final Lazy s;
    public volatile com.larus.asr.e2 t;
    public final Lazy u;
    public final Lazy v;
    public final Lazy w;
    public final Lazy x;
    public final Lazy y;
    public final Lazy z;

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final a AV() {
        return (a) this.z.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.chat.component.bottom.core.speaker.l Ak() {
        return (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.p.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final maa.e C9() {
        return (maa.e) this.q.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final ys8.a DC() {
        return (ys8.a) this.j.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.chat.component.fastsend.e0 I50() {
        return (com.larus.bmhome.chat.component.fastsend.e0) this.v.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.chat.component.bottom.multimodal.latest.a KN() {
        return (com.larus.bmhome.chat.component.bottom.multimodal.latest.a) this.w.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final zb8.e P8() {
        return (zb8.e) this.s.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.asr.e2 Vl() {
        com.larus.asr.e2 r0 = this.t;
        if (r0 != null) goto L5;
        r0 = (com.larus.asr.e2) this.C.a.getAbility(com.larus.asr.e2.class);
    L5:
        this.t = r0;
        return this.t;
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.chat.model.j1 Y3() {
        return (com.larus.bmhome.chat.model.j1) this.b.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final fx9.a Z60() {
        return (fx9.a) this.B.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final xa8.d Z8() {
        return (xa8.d) this.u.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.chat.component.bottom.voice.a Zd() {
        return (com.larus.bmhome.chat.component.bottom.voice.a) this.x.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final bc8.a aE() {
        return (bc8.a) this.n.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.chat.component.bottom.p1 cr() {
        return (com.larus.bmhome.chat.component.bottom.p1) this.g.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final de8.c f1() {
        return (de8.c) this.a.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.chat.component.bottom.attachment.g1 f70() {
        return (com.larus.bmhome.chat.component.bottom.attachment.g1) this.l.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.chat.component.bottom.reference.a g5() {
        return (com.larus.bmhome.chat.component.bottom.reference.a) this.m.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final gd8.g h2() {
        return (gd8.g) this.h.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final va8.f0 oA() {
        return (va8.f0) this.y.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.chat.component.bottom.multimodal.g r5() {
        return (com.larus.bmhome.chat.component.bottom.multimodal.g) this.o.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.chat.component.cvs.y u0() {
        return (com.larus.bmhome.chat.component.cvs.y) this.d.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.chat.component.list.u7 u3() {
        return (com.larus.bmhome.chat.component.list.u7) this.f.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.chat.model.b0 u5() {
        return (com.larus.bmhome.chat.model.b0) this.c.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final va8.m vU() {
        return (va8.m) this.A.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.instruction.g vc() {
        return (com.larus.bmhome.instruction.g) this.i.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final IChatDoubleTabAbility wh() {
        return (IChatDoubleTabAbility) this.r.getValue();
    }

    @Override // com.larus.bmhome.chat.component.bottom.core.y8
    public final com.larus.bmhome.instruction.h yJ() {
        return (com.larus.bmhome.instruction.h) this.k.getValue();
    }

    public u7(final v7 r22) {
        this.C = r22;
        final Class<de8.c> r2 = de8.c.class;
        final de8.c r15 = new de8.c(null, null, false, null, null, false, null, null, null, null, false, false, null, 0, 32767);
        Intrinsics.checkNotNullParameter(de8.c.class, "clazz");
        Intrinsics.checkNotNullParameter(r15, "default");
        this.a = LazyKt.lazy(new com.larus.bmhome.chat.component.bottom.n1(r22, r2, r15));
        this.b = LazyKt.lazy(new s7(this));
        this.c = LazyKt.lazy(new t7(this));
        this.d = com.larus.bmhome.chat.component.bottom.o1.a(r22, com.larus.bmhome.chat.component.cvs.y.class);
        this.e = com.larus.bmhome.chat.component.bottom.o1.a(r22, va8.s.class);
        this.f = com.larus.bmhome.chat.component.bottom.o1.a(r22, com.larus.bmhome.chat.component.list.u7.class);
        this.g = com.larus.bmhome.chat.component.bottom.o1.a(r22, com.larus.bmhome.chat.component.bottom.p1.class);
        this.h = com.larus.bmhome.chat.component.bottom.o1.a(r22, gd8.g.class);
        this.i = com.larus.bmhome.chat.component.bottom.o1.a(r22, com.larus.bmhome.instruction.g.class);
        this.j = com.larus.bmhome.chat.component.bottom.o1.a(r22, ys8.a.class);
        this.k = com.larus.bmhome.chat.component.bottom.o1.a(r22, com.larus.bmhome.instruction.h.class);
        this.l = com.larus.bmhome.chat.component.bottom.o1.a(r22, com.larus.bmhome.chat.component.bottom.attachment.g1.class);
        this.m = com.larus.bmhome.chat.component.bottom.o1.a(r22, com.larus.bmhome.chat.component.bottom.reference.a.class);
        this.n = com.larus.bmhome.chat.component.bottom.o1.a(r22, bc8.a.class);
        this.o = com.larus.bmhome.chat.component.bottom.o1.a(r22, com.larus.bmhome.chat.component.bottom.multimodal.g.class);
        this.p = com.larus.bmhome.chat.component.bottom.o1.a(r22, com.larus.bmhome.chat.component.bottom.core.speaker.l.class);
        this.q = com.larus.bmhome.chat.component.bottom.o1.a(r22, maa.e.class);
        this.r = com.larus.bmhome.chat.component.bottom.o1.a(r22, IChatDoubleTabAbility.class);
        this.s = com.larus.bmhome.chat.component.bottom.o1.a(r22, zb8.e.class);
        this.u = com.larus.bmhome.chat.component.bottom.o1.a(r22, xa8.d.class);
        this.v = com.larus.bmhome.chat.component.bottom.o1.a(r22, com.larus.bmhome.chat.component.fastsend.e0.class);
        this.w = com.larus.bmhome.chat.component.bottom.o1.a(r22, com.larus.bmhome.chat.component.bottom.multimodal.latest.a.class);
        this.x = com.larus.bmhome.chat.component.bottom.o1.a(r22, com.larus.bmhome.chat.component.bottom.voice.a.class);
        this.y = com.larus.bmhome.chat.component.bottom.o1.a(r22, va8.f0.class);
        this.z = com.larus.bmhome.chat.component.bottom.o1.a(r22, a.class);
        this.A = com.larus.bmhome.chat.component.bottom.o1.a(r22, va8.m.class);
        this.B = com.larus.bmhome.chat.component.bottom.o1.a(r22, fx9.a.class);
    }
}
