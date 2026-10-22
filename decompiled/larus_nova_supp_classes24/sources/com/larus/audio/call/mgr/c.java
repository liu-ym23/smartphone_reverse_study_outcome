package com.larus.audio.call.mgr;

import com.larus.im.service.audio.v;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements f {
    public final String f;
    public final ReentrantLock g;
    public final Set<f.a> h;
    public final b i;
    public volatile MajorState j;
    public boolean k;

    public static final class a implements v {
        public final String a;
        public final /* synthetic */ c b;

        public final String getName() {
            return this.a;
        }

        public a(c r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void O1(jd9.c r2, jd9.c r3) {
            Intrinsics.checkNotNullParameter(r2, "oldState");
            Intrinsics.checkNotNullParameter(r3, "newState");
            if ((r3 instanceof jd9.c.a) == false) goto L6;
            this.b.n2(StateTriggerEvent.Connected.a);
            return;
        L6:
            if (Intrinsics.areEqual(r3, jd9.c.b.c) == false) goto L9;
            this.b.n2(StateTriggerEvent.Connect.a);
            return;
        L9:
            if ((r3 instanceof jd9.c.d) == false) goto L14;
            c r4 = this.b;
            r4.getClass();
            r4.n2(c.k3((jd9.c.d) r3));
            return;
        }
    }

    @Override // com.larus.audio.call.mgr.f
    public final boolean a1(MajorState r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "majorState");
        Intrinsics.checkNotNullParameter(r3, "caller");
        return false;
    }

    @Override // com.larus.audio.call.arch.a
    public final void d3() {
        this.k = true;
        n2(StateTriggerEvent.Connect.a);
    }

    @Override // com.larus.audio.call.mgr.f
    public final void t1(u68.c r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
    }

    @Override // com.larus.audio.call.arch.a
    public final v R2() {
        return new a(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void X2() {
        n2(StateTriggerEvent.Interrupt.a);
    }

    @Override // com.larus.audio.call.arch.a
    public final void b3() {
        n2(StateTriggerEvent.Stop.a);
    }

    @Override // com.larus.audio.call.arch.a
    public final void c3() {
        n2(StateTriggerEvent.Resume.a);
    }

    @Override // com.larus.audio.call.mgr.f
    public final MajorState s1() {
        ReentrantLock r0 = this.g;
        r0.lock();
        MajorState r1 = this.j;     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // com.larus.audio.call.mgr.f
    public final void t() {
        n2(StateTriggerEvent.QueryBegin.a);
    }

    @Override // com.larus.audio.call.mgr.f
    public final i1<AVKitDuplexState> y() {
        return this.i.g;
    }

    @Override // com.larus.audio.call.mgr.f
    public final void z() {
        n2(StateTriggerEvent.Pause.a);
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        if (this.k == false) goto L6;
        n2(StateTriggerEvent.Connect.a);
        this.k = false;
        return;
    L6:
        id9.d r0 = getContext().j();
        if (r0 == null) goto L10;
        jd9.c r1 = r0.state();
        if (r1 == null) goto L10;
    L12:
        if ((r1 instanceof jd9.c.a) == false) goto L15;
        n2(StateTriggerEvent.Connect.a);
        n2(StateTriggerEvent.Connected.a);
        return;
    L15:
        if ((r1 instanceof jd9.c.d) == false) goto L17;
        n2(k3((jd9.c.d) r1));
        return;
    L17:
        n2(StateTriggerEvent.Connect.a);
        return;
    L10:
        r1 = jd9.c.f.c;
        goto L12
    }

    @Override // com.larus.audio.call.mgr.f
    public final MajorState A0() {
        return this.j;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f;
    }

    @Override // com.larus.audio.call.arch.a
    public final void Z2() {
        z();
    }

    public c(com.larus.audio.call.arch.c r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = "AutoStopAsrStatePlugin";
        this.g = new ReentrantLock();
        this.h = new CopyOnWriteArraySet();
        b r4 = new b();
        r4.h(new AutoStopAsrDuplexReducer(), ReducerPosition.APPEND);
        this.i = r4;
        this.j = MajorState.c.c;
    }

    public static StateTriggerEvent.Error k3(jd9.c.d r7) {
        int r0 = r7.c;
        String r1 = r7.f;
        if (r1.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L9;
        r1 = r7.e;
    L9:
        return new StateTriggerEvent.Error(r0, r1, MapsKt.mapOf(new Pair[]{TuplesKt.to("sub_error_code", r7.g), TuplesKt.to("vui_error_code", Integer.valueOf(r7.d))}));
    L5:
        r2 = false;
        goto L6
    }

    public static MajorState.f l3(AVKitCoreStates$Error r6) {
        int r1 = r6.a;
        Object r2 = r6.c.get("vui_error_code");
        Integer r4 = null;
        if ((r2 instanceof Integer) == false) goto L5;
        Integer r3 = (Integer) r2;
    L6:
        if (r3 == null) goto L8;
        int r5 = r3.intValue();
    L9:
        String r7 = r6.b;
        Object r8 = r6.c.get("sub_error_code");
        if ((r8 instanceof Integer) == false) goto L13;
        r4 = (Integer) r8;
    L13:
        return new MajorState.f(r1, r5, r7, r4);
    L8:
        r5 = -1;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.larus.audio.call.mgr.f
    public final void M0(f.a r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        if (((CopyOnWriteArraySet) this.h).contains(r4) == false) goto L5;
        return;
    L5:
        MajorState r0 = s1();
        MajorState.c r1 = MajorState.c.c;
        if (Intrinsics.areEqual(r0, r1) == true) goto L8;
        r4.Q(r1, r0);
    L8:
        ((CopyOnWriteArraySet) this.h).add(r4);
    }

    @Override // com.larus.audio.call.mgr.f
    public final void V(f.a r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        ((CopyOnWriteArraySet) this.h).remove(r2);
    }

    @Override // com.larus.audio.call.mgr.f
    public final void n2(StateTriggerEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        ReentrantLock r0 = this.g;
        r0.lock();
        MajorState r1 = this.j;     // Catch: Throwable -> L11
        this.i.a(r4);     // Catch: Throwable -> L11
        MajorState r5 = j3((AVKitDuplexState) this.i.g.getValue(), r1);     // Catch: Throwable -> L11
        this.j = r5;     // Catch: Throwable -> L11
        if (Intrinsics.areEqual(r1, r5) == false) goto L6;
        Pair r6 = null;
    L7:
        r0.unlock();
        if (r6 == null) goto L16;
        final MajorState r2 = (MajorState) r6.component1();
        final MajorState r7 = (MajorState) r6.component2();
        q68.b.a(this.h, new s68.f(r2, r7));
        return;
    L16:
        return;
    L6:
        r6 = TuplesKt.to(r1, r5);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public static MajorState j3(AVKitDuplexState r2, MajorState r3) {
        AVKitDuplexState.DownState r0 = r2.getDownState();
        if ((r0 instanceof AVKitCoreStates$Invalid) == false) goto L6;
        return MajorState.c.c;
    L6:
        if ((r0 instanceof AVKitCoreStates$Connecting) == false) goto L9;
        return MajorState.a.c;
    L9:
        if ((r0 instanceof AVKitCoreStates$Error) == false) goto L12;
        return l3((AVKitCoreStates$Error) r0);
    L12:
        if ((r0 instanceof AVKitCoreStates$Paused) == false) goto L15;
        return new MajorState.g(r3);
    L15:
        if ((r0 instanceof AVKitCoreStates$Finished) == true) goto L44;
        AVKitDuplexState.UpState r4 = r2.getUpState();
        if ((r4 instanceof AVKitCoreStates$Invalid) == false) goto L21;
        return MajorState.c.c;
    L21:
        if ((r4 instanceof AVKitCoreStates$Connecting) == false) goto L24;
        return MajorState.a.c;
    L24:
        if ((r4 instanceof AVKitCoreStates$Listening) == false) goto L27;
        return MajorState.j.c;
    L27:
        if ((r4 instanceof AVKitCoreStates$Recognizing) == false) goto L30;
        return new MajorState.d(MajorState.From.ASR, MajorState.InterruptType.NOTHING);
    L30:
        if ((r4 instanceof AVKitCoreStates$Error) == false) goto L33;
        return l3((AVKitCoreStates$Error) r4);
    L33:
        if ((r4 instanceof AVKitCoreStates$Paused) == false) goto L36;
        return new MajorState.g(r3);
    L36:
        if ((r4 instanceof AVKitCoreStates$Finished) == false) goto L39;
        return MajorState.c.c;
    L39:
        return MajorState.j.c;
    L44:
        return MajorState.c.c;
    }

    @Override // com.larus.audio.call.mgr.f
    public final void F2(DownStateReducer r2, ReducerPosition r3) {
        Intrinsics.checkNotNullParameter(r2, "reducer");
        Intrinsics.checkNotNullParameter(r3, "position");
        this.i.h(r2, r3);
    }

    @Override // com.larus.audio.call.mgr.f
    public final void error(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        n2(new StateTriggerEvent.Error(r4, r5, MapsKt.mapOf(TuplesKt.to("vui_error_code", Integer.valueOf(r4)))));
    }
}
