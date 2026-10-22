package com.larus.audio.call.plugins;

import com.larus.audio.call.HangUpState;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.c;
import com.larus.audio.call.dora.CommandStatus;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class CommonCallTimingPlugin<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<C> implements b1 {
    public final String f;
    public c0 g;
    public Job h;
    public long i;
    public final RealtimeCallParam.RealtimeCallAddEventConfig j;
    public final Lazy k;
    public com.larus.audio.call.h l;
    public final x m;
    public final y n;
    public final z o;
    public final a0 p;
    public final com.larus.audio.call.s q;
    public Job r;
    public boolean s;
    public final b0 t;

    public static final class a implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ CommonCallTimingPlugin<C> a;

        public a(CommonCallTimingPlugin<C> r1) {
            this.a = r1;
        }

        @Override // com.larus.audio.call.mgr.f.a
        public final void Q(MajorState r10, MajorState r11) {
            Intrinsics.checkNotNullParameter(r10, "prev");
            Intrinsics.checkNotNullParameter(r11, "current");
            if (com.larus.audio.call.f.d().s == false) goto L34;
            CommonCallTimingPlugin<C> r0 = this.a;
            int r3 = r11.a;
            if ((r11 instanceof MajorState.d) == true) goto L7;
        L9:
            boolean r4 = false;
        L10:
            r0.getClass();
            if (r3 == 2) goto L20;
            if (r3 == 3) goto L20;
            if (r0.s == false) goto L34;
            com.larus.audio.call.util.e.a.i(r0.T2(), "[processHangUp] 2.remove");
            Job r5 = r0.h;
            if (r5 == null) goto L18;
            Job.DefaultImpls.cancel$default(r5, null, 1, null);
        L18:
            r0.s = false;
        L20:
            if (r0.s == true) goto L29;
            if (r3 != 3) goto L23;
            if (r4 == true) goto L23;
        L24:
            com.larus.audio.call.util.e.a.i(r0.T2(), "[processHangUp] post");
            CoroutineScope r6 = com.larus.audio.call.util.r.a;
            Long r7 = com.larus.audio.call.f.d().w;
            if (r7 == null) goto L27;
            long r8 = r7.longValue();
        L28:
            r0.h = com.larus.audio.call.util.r.a(r8 * ((long) CommandStatus.DORA_TRACE), r0.t);
            r0.s = true;
            goto L34
        L27:
            r8 = 0;
        L23:
            if (r3 != 2) goto L34;
        L29:
            if (r4 == false) goto L34;
            com.larus.audio.call.util.e.a.i(r0.T2(), "[processHangUp] 1.remove");
            Job r9 = r0.h;
            if (r9 == null) goto L33;
            Job.DefaultImpls.cancel$default(r9, null, 1, null);
        L33:
            r0.s = false;
            goto L34
        L7:
            if (((MajorState.d) r11).c != MajorState.From.ASR) goto L9;
            r4 = true;
        L34:
            int r1 = r11.a;
            if (r1 == 2) goto L38;
            if (r1 == 3) goto L38;
            return;
        L38:
            com.larus.audio.call.util.e.a.i(this.a.T2(), "[onStateChanged] " + r10 + " -> " + r11 + ", try start wait trigger timer");
            this.a.q.b();
        }
    }

    public static final class b extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ CommonCallTimingPlugin<C> b;

        public final String g() {
            return this.a;
        }

        public b(CommonCallTimingPlugin<C> r1) {
            this.b = r1;
            this.a = r1.T2();
        }

        public final void n(com.larus.im.service.audio.z0.a r4) {
            Intrinsics.checkNotNullParameter(r4, "event");
            Intrinsics.checkNotNullParameter(r4, "event");
            if ((r4 instanceof pf9.z) == false) goto L6;
            CommonCallTimingPlugin<C> r5 = this.b;
            r5.getClass();
            com.larus.audio.call.util.e.a.i(r5.T2(), "[cancelTriggerWaitTimer]");
            r5.q.a();
            return;
        }
    }

    public static final class c extends com.larus.audio.call.h.a {
        public final /* synthetic */ CommonCallTimingPlugin<C> b;

        @Override // com.larus.audio.call.h.a
        public final void a() {
            this.b.o.invoke();
        }

        @Override // com.larus.audio.call.h.a
        public final void b(RealtimeCallParam r3) {
            Intrinsics.checkNotNullParameter(r3, "params");
            CommonCallTimingPlugin<C> r4 = this.b;
            r4.n.invoke("", r4.getContext().params().p.i);
        }

        @Override // com.larus.audio.call.h.a
        public final void c(RealtimeCallParam r2) {
            Intrinsics.checkNotNullParameter(r2, "params");
            com.larus.audio.call.arch.b.a(this.b.getContext()).l1();
        }

        public c(CommonCallTimingPlugin<C> r1, com.larus.audio.call.tracer.b r2) {
            this.b = r1;
            super(r2);
        }
    }

    public static final class d extends com.larus.audio.call.s.a {
        public final /* synthetic */ CommonCallTimingPlugin<C> a;
        public final /* synthetic */ C b;

        @Override // com.larus.audio.call.s.a
        public final HangUpState b() {
            com.larus.audio.call.h r0 = this.a.l;
            if (r0 == null) goto L7;
            HangUpState r1 = (HangUpState) r0.c.c();
            if (r1 == null) goto L7;
            return r1;
        L7:
            return HangUpState.IDLE;
        }

        @Override // com.larus.audio.call.s.a
        public final void c() {
            this.a.m.invoke();
        }

        @Override // com.larus.audio.call.s.a
        public final RealtimeCallParam.WaitingEventConfig d() {
            return this.a.j.getWaitingEvent();
        }

        @Override // com.larus.audio.call.s.a
        public final boolean a() {
            if (com.larus.audio.call.f.f() == true) goto L5;
        L8:
            return true;
        L5:
            if (d0.a((AVKitDuplexState) this.b.a().y().getValue()) == true) goto L8;
            return false;
        }

        public d(CommonCallTimingPlugin<C> r1, C r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public void j3() {
    }

    public void k3(long r1) {
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.z0 S2() {
        return new b(this);
    }

    @Override // com.larus.audio.call.plugins.b1
    public void onComplete() {
        com.larus.audio.call.h r0 = this.l;
        if (r0 == null) goto L19;
        RealtimeCallParam r1 = getContext().params();
        Intrinsics.checkNotNullParameter(r1, "params");
        HangUpState r2 = (HangUpState) r0.c.c();
        int r3 = com.larus.audio.call.h.b.a[r2.ordinal()];
        if (r3 != 1) goto L7;
        r0.b.b(r1);
        r0.c.d(HangUpState.SEND_EVENT);
        return;
    L7:
        if (r3 != 2) goto L9;
        r0.c.d(HangUpState.FINISH);
        r0.b.a();
        return;
    L9:
        if (r3 != 3) goto L11;
        r0.b.a.f("realcall_message", "call");
        r0.b.a.f("asr_phase", "realcall_message");
        r0.b.c(r1);
        r0.a.Q(IRealtimeCallTracer.HelloStatus.PLAY_END, null);
        return;
    L11:
        if (r3 != 4) goto L14;
        return;
    L14:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.audio.call.mgr.f.a P2() {
        if (com.larus.audio.call.f.f() == false) goto L11;
        Job r0 = this.r;
        if (r0 != null) goto L7;
    L8:
        this.r = U2(new CommonCallTimingPlugin$createCallStateObserver$1(this, null));
    L9:
        return null;
    L7:
        if (r0.isActive() == true) goto L9;
    L11:
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        this.l = new com.larus.audio.call.h(getContext().k(), new c(this, getContext().i()));
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        Job r0 = this.r;
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        this.r = null;
        com.larus.audio.call.util.e r1 = com.larus.audio.call.util.e.a;
        r1.i(T2(), "[cancelAll]");
        r1.i(T2(), "[cancelFinishCallTimer]");
        c0 r2 = this.g;
        if (r2 == null) goto L8;
        r2.a();
    L8:
        c0 r3 = this.g;
        if (r3 == null) goto L11;
        long r4 = r3.d;
    L12:
        this.i = r4;
        r1.i(T2(), "[cancelFinishCallTimer] totalTimePast: " + this.i);
        this.g = null;
        this.q.a();
        return;
    L11:
        r4 = 0;
        goto L12
    }

    @Override // com.larus.audio.call.arch.a
    public String T2() {
        return this.f;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [com.larus.audio.call.plugins.b0] */
    public CommonCallTimingPlugin(final C r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = "CommonTimingPlugin";
        this.j = com.larus.audio.call.f.d().t;
        this.k = LazyKt.lazy(new w(this));
        this.m = new x(r3);
        this.n = new y(r3);
        this.o = new z(this);
        this.p = new a0(this);
        this.q = new com.larus.audio.call.s(new d(this, r3));
        this.t = new b0(this, r3);
    }
}
