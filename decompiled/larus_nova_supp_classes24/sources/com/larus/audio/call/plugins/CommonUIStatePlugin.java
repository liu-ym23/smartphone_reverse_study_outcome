package com.larus.audio.call.plugins;

import com.larus.audio.call.InstanceCallState;
import com.larus.audio.call.arch.c;
import com.larus.audio.call.mgr.AVKitCoreStates$DownWaiting;
import com.larus.audio.call.mgr.AVKitCoreStates$Listening;
import com.larus.audio.call.mgr.AVKitCoreStates$Recognizing;
import com.larus.audio.call.mgr.AVKitCoreStates$Speaking;
import com.larus.audio.call.mgr.AVKitCoreStates$Thinking;
import com.larus.audio.call.mgr.AVKitDuplexState;
import com.larus.audio.call.mgr.MajorState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class CommonUIStatePlugin<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<C> implements c1 {
    public final String f;
    public u68.a g;
    public i0 h;
    public final MutableSharedFlow<Pair<Integer, Integer>> i;
    public int j;
    public final MutableSharedFlow<Pair<Pair<MajorState, Integer>, Pair<MajorState, Integer>>> k;
    public MajorState l;
    public final Lazy m;
    public Integer n;
    public Job o;

    public static final class a implements com.larus.audio.call.mgr.f.a {
        public final /* synthetic */ CommonUIStatePlugin<C> a;

        public a(CommonUIStatePlugin<C> r1) {
            this.a = r1;
        }

        public final void a(final MajorState r7) {
            if ((r7 instanceof MajorState.g) == false) goto L5;
        L37:
            this.a.r3(r7, r7.a);
            return;
        L5:
            if ((r7 instanceof MajorState.h) == true) goto L37;
            if ((r7 instanceof MajorState.i) == true) goto L37;
            if ((r7 instanceof MajorState.d) == false) goto L16;
            if (((MajorState.d) r7).c != MajorState.From.TTS_ENDED) goto L14;
            return;
        L14:
            CommonUIStatePlugin<C> r0 = this.a;
            String r1 = r0.getContext().params().e;
            final CommonUIStatePlugin<C> r2 = this.a;
            r0.n3(r1, new j0(r2, r7), new k0(r2, r7), new l0(r7, r2));
            return;
        L16:
            if ((r7 instanceof MajorState.a) == false) goto L22;
            if (this.a.H() == false) goto L20;
            this.a.r3(r7, 12);
            return;
        L20:
            this.a.r3(r7, r7.a);
            return;
        L22:
            if ((r7 instanceof MajorState.j) == false) goto L31;
            y0 r3 = com.larus.audio.call.arch.b.d(this.a.getContext());
            if (r3 == null) goto L26;
            boolean r4 = r3.b1();
        L27:
            if (r4 == false) goto L29;
            this.a.r3(r7, 9);
            return;
        L29:
            this.a.r3(r7, r7.a);
            return;
        L26:
            r4 = false;
            goto L27
        L31:
            if ((r7 instanceof MajorState.e) == false) goto L34;
            this.a.r3(r7, r7.a);
            return;
        L34:
            if ((r7 instanceof MajorState.f) == false) goto L36;
            this.a.q3((MajorState.f) r7);
            return;
        L36:
            this.a.r3(r7, r7.a);
        }

        @Override // com.larus.audio.call.mgr.f.a
        public final void Q(MajorState r7, MajorState r8) {
            Intrinsics.checkNotNullParameter(r7, "prev");
            Intrinsics.checkNotNullParameter(r8, "current");
            com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
            String r1 = this.a.T2();
            StringBuilder r2 = new StringBuilder("[CALL] createCallStateObserver onStateChanged state changed: prev: ");
            r2.append(r7);
            r2.append(',');
            InstanceCallState.a r4 = InstanceCallState.Companion;
            int r5 = r7.a;
            r4.getClass();
            r2.append(InstanceCallState.a.a(r5));
            r2.append(" --> current: ");
            r2.append(r8);
            r2.append(',');
            r2.append(InstanceCallState.a.a(r8.a));
            r2.append('.');
            r0.i(r1, r2.toString());
            if ((r7 instanceof MajorState.g) == false) goto L43;
            MajorState.g r9 = (MajorState.g) r7;
            MajorState r3 = r9.c;
            boolean r6 = true;
            if ((r3 instanceof MajorState.d) == false) goto L9;
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.larus.audio.call.mgr.MajorState.Listening");
            if (((MajorState.d) r3).c != MajorState.From.PLAY_COMPLETE) goto L9;
            boolean r10 = true;
        L11:
            if (this.a.j3().a0() == false) goto L15;
            if (r10 == false) goto L14;
            a(r8);
        L16:
            CommonUIStatePlugin<C> r11 = this.a;
            r11.getClass();
            if (com.larus.audio.call.f.d().r == false) goto L34;
            MajorState r12 = r9.c;
            if ((r12 instanceof MajorState.d) == false) goto L21;
        L33:
            if (r6 == false) goto L34;
        L42:
            com.larus.audio.call.tracer.b.b(r11.getContext().i(), "realcall_message", null, 6);
            r11.getContext().i().f("realcall_message", "call");
            r11.getContext().i().f("asr_phase", "realcall_message");
            r11.j3().l1();
            return;
        L21:
            if ((r12 instanceof MajorState.h) == true) goto L33;
            if ((r12 instanceof MajorState.i) == true) goto L33;
            if ((r12 instanceof MajorState.j) == false) goto L32;
            y0 r13 = com.larus.audio.call.arch.b.d(r11.getContext());
            if (r13 == null) goto L29;
            boolean r14 = r13.b1();
        L30:
            if (r14 == false) goto L32;
        L29:
            r14 = false;
        L32:
            r6 = false;
        L34:
            MajorState r15 = r9.c;
            if ((r15 instanceof MajorState.d) == false) goto L41;
            if (((MajorState.d) r15).c != MajorState.From.PLAY_COMPLETE) goto L41;
            if (r11.j3().a0() == false) goto L42;
        L41:
            if ((r9.c instanceof MajorState.j) == true) goto L42;
            return;
        L14:
            a(MajorState.h.c);
            goto L16
        L15:
            a(r8);
        L9:
            r10 = false;
            goto L11
        L43:
            a(r8);
        }
    }

    public boolean H() {
        return false;
    }

    public boolean l3() {
        return false;
    }

    public void n3(String r1, Function0<Unit> r2, Function0<Unit> r3, Function0<Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "onIdle");
        Intrinsics.checkNotNullParameter(r3, "onAllEnd");
        Intrinsics.checkNotNullParameter(r4, "onOccupied");
    }

    public void o3() {
    }

    public Integer p3(AVKitDuplexState r2) {
        Intrinsics.checkNotNullParameter(r2, "duplex");
        return null;
    }

    @Override // com.larus.audio.call.arch.a
    public com.larus.audio.call.mgr.f.a P2() {
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void Y2() {
        r3(this.l, 14);
        AVKitDuplexState r0 = (AVKitDuplexState) ((Pair) m3().getValue()).getFirst();
        m3().setValue(TuplesKt.to(r0, 14));
    }

    @Override // com.larus.audio.call.arch.a
    public final void d3() {
        r3(MajorState.a.c, 1);
    }

    @Override // com.larus.audio.call.arch.a
    public void g3() {
        u68.a r0 = this.g;
        this.g = null;
        i0 r2 = this.h;
        if (r2 == null) goto L6;
        if (r0 == null) goto L6;
        r0.j(r2);
    L6:
        this.h = null;
        super.g3();
    }

    @Override // com.larus.audio.call.arch.a
    public final void h3() {
        r3(this.l, 15);
        AVKitDuplexState r0 = (AVKitDuplexState) ((Pair) m3().getValue()).getFirst();
        m3().setValue(TuplesKt.to(r0, 15));
    }

    public final kotlinx.coroutines.flow.z0<Pair<AVKitDuplexState, Integer>> m3() {
        return (kotlinx.coroutines.flow.z0) this.m.getValue();
    }

    @Override // com.larus.audio.call.arch.a
    public final void c3() {
        if (com.larus.audio.call.f.f() == true) goto L6;
        AVKitDuplexState r0 = (AVKitDuplexState) ((Pair) m3().getValue()).getFirst();
        m3().setValue(TuplesKt.to(r0, 8));
    L6:
        if (l3() == true) goto L8;
        return;
    L8:
        if (com.larus.audio.call.f.f() == false) goto L32;
        AVKitDuplexState r1 = (AVKitDuplexState) getContext().a().y().getValue();
        if (m0.a(r1) == false) goto L12;
        o3();
        k3().onComplete();
    L12:
        boolean r2 = com.larus.audio.call.f.d().r;
        boolean r3 = j3().a0();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        boolean r4 = false;
        if ((r1.getUpState() instanceof AVKitCoreStates$Listening) == false) goto L15;
    L16:
        AVKitDuplexState.DownState r5 = r1.getDownState();
        if ((r5 instanceof AVKitCoreStates$DownWaiting) == false) goto L21;
        if (r3 == true) goto L25;
        r2 = true;
    L26:
        if (r2 == false) goto L28;
        r4 = true;
    L28:
        if (r4 == false) goto L33;
        com.larus.audio.call.tracer.b.b(getContext().i(), "realcall_message", null, 6);
        getContext().i().f("realcall_message", "call");
        getContext().i().f("asr_phase", "realcall_message");
        j3().l1();
        return;
    L33:
        return;
    L25:
        r2 = false;
        goto L26
    L21:
        if ((r5 instanceof AVKitCoreStates$Thinking) == true) goto L26;
        if ((r5 instanceof AVKitCoreStates$Speaking) == false) goto L25;
    L15:
        if ((r1.getUpState() instanceof AVKitCoreStates$Recognizing) == false) goto L28;
    }

    @Override // com.larus.audio.call.arch.a
    public void e3() {
        super.e3();
        if (l3() == true) goto L5;
    L15:
        Job r0 = this.o;
        if (r0 != null) goto L18;
    L20:
        this.o = U2(new CommonUIStatePlugin$onStart$1(this, null));
        return;
    L18:
        if (r0.isActive() == false) goto L20;
        return;
    L5:
        if (com.larus.audio.call.f.f() == false) goto L15;
        u68.c r1 = j3().e0();
        u68.a r2 = this.g;
        if (r2 == r1) goto L15;
        this.g = null;
        i0 r3 = this.h;
        if (r3 == null) goto L14;
        if (r2 == null) goto L14;
        r2.j(r3);
    L14:
        this.h = null;
        this.g = r1;
        i0 r4 = new i0(this, r1);
        this.h = r4;
        r1.i(r4);
        goto L15
    }

    public final t0 j3() {
        return (t0) getContext().b(Reflection.getOrCreateKotlinClass(t0.class), null);
    }

    public final b1 k3() {
        return (b1) getContext().b(Reflection.getOrCreateKotlinClass(b1.class), null);
    }

    public final void t3() {
        AVKitDuplexState r0 = (AVKitDuplexState) getContext().a().y().getValue();
        if (Intrinsics.areEqual(((Pair) m3().getValue()).getFirst(), r0) == true) goto L5;
        this.n = 16;
    L5:
        m3().setValue(TuplesKt.to(r0, 16));
    }

    @Override // com.larus.audio.call.plugins.c1
    public final kotlinx.coroutines.flow.i1<Pair<AVKitDuplexState, Integer>> y() {
        return m3();
    }

    @Override // com.larus.audio.call.arch.a
    public String T2() {
        return this.f;
    }

    @Override // com.larus.audio.call.plugins.c1
    public final MutableSharedFlow W() {
        return this.k;
    }

    @Override // com.larus.audio.call.plugins.c1
    public final MutableSharedFlow i1() {
        return this.i;
    }

    public CommonUIStatePlugin(final C r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        super(r6);
        this.f = "CommonUIStatePlugin";
        this.i = SharedFlowKt.MutableSharedFlow$default(1, 3, null, 4, null);
        this.j = -1;
        this.k = SharedFlowKt.MutableSharedFlow$default(1, 3, null, 4, null);
        this.l = MajorState.c.c;
        this.m = LazyKt.lazy(new f0(r6, this));
    }

    public void q3(MajorState.f r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        r3(r2, r2.a);
    }

    public static void s3(CommonUIStatePlugin r1, MajorState r2) {
        r1.r3(r2, r2.a);
    }

    public final void r3(MajorState r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "majorState");
        MajorState r0 = this.l;
        this.l = r5;
        int r1 = this.j;
        this.j = r6;
        this.k.tryEmit(TuplesKt.to(TuplesKt.to(r0, Integer.valueOf(r1)), TuplesKt.to(r5, Integer.valueOf(r6))));
        this.i.tryEmit(TuplesKt.to(Integer.valueOf(r1), Integer.valueOf(r6)));
    }
}
