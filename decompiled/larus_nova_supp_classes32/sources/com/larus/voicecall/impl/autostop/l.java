package com.larus.voicecall.impl.autostop;

import com.larus.audio.call.mgr.MajorState;
import com.larus.call_plugins_doubao_common.manager.n0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l extends com.larus.call_plugins_doubao_common.h implements com.larus.voicecall.impl.plugins.q {
    public final String h;
    public final a i;

    public static final class a implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ l a;
        public final /* synthetic */ com.larus.audio.call.arch.c b;

        public a(l r1, com.larus.audio.call.arch.c r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void Q(MajorState r2, MajorState r3) {
            Intrinsics.checkNotNullParameter(r2, "prev");
            Intrinsics.checkNotNullParameter(r3, "current");
            n0 r4 = ((com.larus.call_plugins_doubao_common.h) this.a).g;
            if (r4 == null) goto L6;
            r4.a(r3.a, this.b.params().e);
            return;
        }
    }

    public final void j3() {
        Function0 r5 = new g(this);
        ((com.larus.call_plugins_doubao_common.h) this).g = new n0(new h(this), new i(this), new j(this), new k(), r5, null, null, null, false, true, 992);
    }

    @Override // com.larus.voicecall.impl.plugins.q
    public final void p() {
        n0 r0 = ((com.larus.call_plugins_doubao_common.h) this).g;
        if (r0 == null) goto L6;
        r0.l();
        return;
    }

    public final void g3() {
        getContext().a().V(this.i);
        super.g3();
    }

    public final void k3() {
        getContext().a().M0(this.i);
    }

    public final String T2() {
        return this.h;
    }

    public l(com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.h = "AutoStopAsrMediaFocusPlugin";
        this.i = new a(this, r2);
    }
}
