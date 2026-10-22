package com.larus.voicecall.impl.quic;

import com.larus.audio.call.arch.LLMCallController;
import com.larus.audio.call.arch.k0;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.voicecall.impl.component.translator.QuicInterpretComponent$b;
import com.larus.voicecall.impl.plugins.c0;
import com.larus.voicecall.impl.plugins.d0;
import com.larus.voicecall.impl.plugins.r;
import com.larus.voicecall.impl.plugins.y;
import com.larus.voicecall.impl.plugins.z;
import com.larus.voicecall.impl.q;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Deferred;
import o3a.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e extends LLMCallController<r> {
    public final Function2<r, com.larus.audio.call.arch.d<r>, Unit> v;
    public final String w;
    public final com.larus.audio.call.e x;
    public q y;

    public final class a extends LLMCallController<r>.a implements r {
        public final /* synthetic */ e b;

        @Override // com.larus.voicecall.impl.plugins.r
        public final q h() {
            return this.b.y;
        }

        public a(e r1) {
            this.b = r1;
            super(r1);
        }
    }

    public final com.larus.audio.call.arch.c K() {
        return new a(this);
    }

    public final Deferred<LLMCallController.b> L() {
        Deferred<LLMCallController.b> r0 = super.L();
        r0.invokeOnCompletion(new d(this));
        return r0;
    }

    public final String A() {
        return this.w;
    }

    public final IRealtimeCallTracer B() {
        return this.x;
    }

    public final void p(com.larus.audio.call.arch.c r4, k0 r5) {
        r r6 = (r) r4;
        Intrinsics.checkNotNullParameter(r6, "context");
        Intrinsics.checkNotNullParameter(r5, "registry");
        r5.a(new y(r6));
        r5.a(new com.larus.audio.call.mgr.d(r6));
        r5.a(new z(r6, ((LLMCallController) this).j));
        r5.a(new c0(r6, ((LLMCallController) this).b.a(), ((LLMCallController) this).i));
        r5.a(new d0(r6));
    }

    public e(b78.e r2, QuicInterpretComponent$b r3, h r4, b r5) {
        Intrinsics.checkNotNullParameter(r2, "sessionCreator");
        Intrinsics.checkNotNullParameter(r3, "traceSpan");
        Intrinsics.checkNotNullParameter(r4, "lifecycleScope");
        super(r2, r3, r4);
        this.v = r5;
        this.w = "QuicLLMController";
        this.x = new com.larus.audio.call.e("empty");
        r5.invoke(x().getContext(), x());
    }
}
