package com.larus.avlink.plugins;

import com.larus.avlink.e.DoraImageEvent;
import com.larus.avlink.e.l;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d0 extends com.larus.audio.call.arch.a<n4> implements com.larus.avlink.e.s {
    public a f;
    public c g;

    public static final class a {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;

        public a() {
        }
    }

    public static final class b extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ d0 b;

        public final String g() {
            return this.a;
        }

        public b(d0 r1) {
            this.b = r1;
            this.a = r1.T2();
        }

        public final void n(com.larus.im.service.audio.z0.a r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            if ((r2 instanceof pf9.z) == false) goto L6;
            com.larus.avlink.n1.d(this.b.T2(), "asr start.");
            this.b.f = null;
            return;
        }
    }

    public static final class c extends com.larus.audio.call.play.e {
        public boolean a;
        public final /* synthetic */ d0 b;

        public final void onPlayComplete() {
            com.larus.avlink.n1.d(this.b.T2(), "onPlayComplete.");
            if (this.a == false) goto L8;
            this.a = false;
            d0 r0 = this.b;
            a r1 = r0.f;
            if (r1 == null) goto L9;
            com.larus.avlink.n1.d(r0.T2(), "high quality intent, ttsEnd need send trigger.");
            l r2 = l.a;
            int r3 = r1.a;
            int r4 = r1.b;
            int r5 = r1.d;
            l.h(r3, r4, r1.c, r5, r1.e);
            r0.f = null;
            return;
        L9:
            return;
        }

        public c(d0 r1) {
            this.b = r1;
        }

        public final void b(Map<String, String> r2) {
            com.larus.avlink.n1.d(this.b.T2(), "onTTSStart.");
            this.a = true;
        }
    }

    @Override // com.larus.avlink.e.s
    public final void M() {
    }

    @Override // com.larus.avlink.e.s
    public final void j(boolean r1, int r2, byte r3) {
    }

    public final com.larus.im.service.audio.z0 S2() {
        return new b(this);
    }

    public final String T2() {
        return d0.class.getSimpleName();
    }

    public final void b3() {
        l r0 = l.a;
        l.c.remove(this);
    }

    public final void e3() {
        super.e3();
        c r0 = new c(this);
        this.g = r0;
        com.larus.audio.call.plugins.t0 r1 = getContext().c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.t0.class), null);
        if (r1 == null) goto L8;
        u68.c r2 = r1.e0();
        if (r2 == null) goto L9;
        r2.i(r0);
        return;
    L9:
        return;
    }

    public final void g3() {
        super.g3();
        c r0 = this.g;
        if (r0 == null) goto L10;
        com.larus.audio.call.plugins.t0 r1 = getContext().c(Reflection.getOrCreateKotlinClass(com.larus.audio.call.plugins.t0.class), null);
        if (r1 == null) goto L11;
        u68.c r2 = r1.e0();
        if (r2 == null) goto L12;
        r2.j(r0);
        return;
    L12:
        return;
    L11:
        return;
    }

    public d0(n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        l r3 = l.a;
        l.c.add(this);
    }

    @Override // com.larus.avlink.e.s
    public final void w(b49.k r2) {
        Intrinsics.checkNotNullParameter(r2, "info");
    }

    @Override // com.larus.avlink.e.s
    public final void p1(com.larus.avlink.model.a r1, DoraImageEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    @Override // com.larus.avlink.e.s
    public final boolean D0(int r4, int r5, int r6, int r7, int r8) {
        if (r6 == 7) goto L5;
        return false;
    L5:
        if (r8 != 1) goto L12;
        com.larus.avlink.n1.d(T2(), "high quality intent, cache param and will send trigger on ttsEnd.");
        a r1 = new a();
        r1.a = r4;
        r1.b = r5;
        r1.c = r6;
        r1.d = r7;
        r1.e = r8;
        this.f = r1;
        n3 r9 = (n3) getContext().c(Reflection.getOrCreateKotlinClass(n3.class), null);
        if (r9 == null) goto L9;
        r9.N0();
    L9:
        return true;
    L12:
        return false;
    }
}
