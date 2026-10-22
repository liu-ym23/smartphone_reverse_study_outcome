package com.larus.asr.session.clicktalk;

import com.larus.audio.call.mgr.MajorState;
import com.larus.im.service.audio.z0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import pf9.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class ClickTalkComponentBizPlugin extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> {
    public final Function0<CoroutineScope> f;
    public final k g;
    public final String h;
    public Job i;
    public boolean j;

    public static final class a implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ ClickTalkComponentBizPlugin a;

        public a(ClickTalkComponentBizPlugin r1) {
            this.a = r1;
        }

        @Override // com.larus.audio.call.mgr.f.a
        public final void Q(MajorState r3, MajorState r4) {
            Intrinsics.checkNotNullParameter(r3, "prev");
            Intrinsics.checkNotNullParameter(r4, "current");
            this.a.g.onEvent(new j.f(r3, r4));
        }
    }

    public static final class b extends z0 {
        public final String a;
        public final /* synthetic */ ClickTalkComponentBizPlugin b;

        public final String g() {
            return this.a;
        }

        public b(ClickTalkComponentBizPlugin r1) {
            this.b = r1;
            this.a = r1.h;
        }

        public final void n(z0.a r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            if ((r3 instanceof pf9.q) == false) goto L6;
            this.b.g.onEvent(new j.b(((pf9.q) r3).a));
            return;
        L6:
            if ((r3 instanceof pf9.z) == false) goto L9;
            this.b.g.onEvent(new j.g(((pf9.z) r3).b));
            return;
        L9:
            if ((r3 instanceof c0) == false) goto L12;
            this.b.g.onEvent(new j.i(((c0) r3).a));
            return;
        L12:
            if ((r3 instanceof pf9.a0) == false) goto L18;
            this.b.g.onEvent(j.h.a);
            return;
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.audio.call.mgr.f.a P2() {
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final z0 S2() {
        return new b(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void b3() {
        Job r0 = this.i;
        if (r0 == null) goto L6;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        this.i = BuildersKt.launch$default((CoroutineScope) this.f.invoke(), null, null, new ClickTalkComponentBizPlugin$onStart$1(this, null), 3, null);
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        this.g.onEvent(new j.f(new MajorState.i(), MajorState.c.c));
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.h;
    }

    public ClickTalkComponentBizPlugin(com.larus.audio.call.arch.c r2, Function0<? extends CoroutineScope> r3, k r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "lifecycleScope");
        Intrinsics.checkNotNullParameter(r4, "eventListener");
        super(r2);
        this.f = r3;
        this.g = r4;
        this.h = "ClickTalkComponentBizPlugin";
        this.j = true;
    }
}
