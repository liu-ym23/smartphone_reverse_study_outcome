package com.larus.audio.call.mgr;

import com.larus.audio.call.play.abs.TtsPlayEndType;
import com.larus.im.service.audio.v;
import com.larus.im.service.audio.z0;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import pf9.a0;
import pf9.b0;
import pf9.c0;
import pf9.f0;
import pf9.x;
import pf9.y;
import pf9.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class g extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements f {
    public final String f;
    public final String g;
    public final a h;
    public boolean i;
    public final com.larus.audio.call.mgr.b j;
    public boolean k;

    public static final class a extends com.larus.audio.call.play.e {
        public final /* synthetic */ g a;

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void onPlayComplete() {
            g.j3(this.a, StateTriggerEvent.PlayEnd.a);
        }

        public a(g r1) {
            this.a = r1;
        }

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void f(TtsPlayEndType r2) {
            Intrinsics.checkNotNullParameter(r2, "endType");
            Intrinsics.checkNotNullParameter(r2, "endType");
            if (r2 != TtsPlayEndType.TIMEOUT) goto L6;
            g.j3(this.a, StateTriggerEvent.PlayEnd.a);
            return;
        }
    }

    public static final class b implements v {
        public final /* synthetic */ g a;

        public final String getName() {
            return this.a.g;
        }

        public b(g r1) {
            this.a = r1;
        }

        public final void O1(jd9.c r8, jd9.c r9) {
            Intrinsics.checkNotNullParameter(r8, "oldState");
            Intrinsics.checkNotNullParameter(r9, "newState");
            if ((r9 instanceof jd9.c.a) == false) goto L6;
            g.j3(this.a, StateTriggerEvent.Connected.a);
            return;
        L6:
            if (Intrinsics.areEqual(r9, jd9.c.b.c) == false) goto L9;
            g.j3(this.a, StateTriggerEvent.Connect.a);
            return;
        L9:
            if ((r9 instanceof jd9.c.d) == false) goto L20;
            g r10 = this.a;
            jd9.c.d r11 = (jd9.c.d) r9;
            int r0 = r11.c;
            String r1 = r11.f;
            if (r1.length() != 0) goto L13;
            boolean r2 = true;
        L14:
            if (r2 == false) goto L16;
            r1 = r11.e;
        L16:
            g.j3(r10, new StateTriggerEvent.Error(r0, r1, MapsKt.mapOf(new Pair[]{TuplesKt.to("vui_error_code", Integer.valueOf(r11.d)), TuplesKt.to("sub_error_code", r11.g)})));
            com.larus.audio.call.util.e.a.e(this.a.f, "[CALL] onConnectionStateChanged DISCONNECT, errorCode = " + r11.c + ", subCode = " + r11.g + ", vuiErrorCode = " + r11.d + ", detailErrorMsg = " + r11.f);
            return;
        L13:
            r2 = false;
            goto L14
        }
    }

    public static final class c extends z0 {
        public Boolean a;
        public final /* synthetic */ g b;

        public final String g() {
            return this.b.f;
        }

        public c(g r1) {
            this.b = r1;
        }

        public final void n(z0.a r5) {
            Intrinsics.checkNotNullParameter(r5, "event");
            com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
            r0.i(this.b.f, "onReceiveEvent, event: " + r5);
            if ((r5 instanceof z) == false) goto L6;
            g r6 = this.b;
            r6.k = true;
            this.a = null;
            r6.j.a(StateTriggerEvent.QueryBegin.a);
            return;
        L6:
            if ((r5 instanceof x) == false) goto L11;
            Boolean r7 = this.a;
            Boolean r1 = Boolean.TRUE;
            if (Intrinsics.areEqual(r7, r1) == true) goto L33;
            this.a = r1;
            g.j3(this.b, ObricContTalkStateMachine$TriggerEvent$PrefetchASR.INSTANCE);
            return;
        L33:
            return;
        L11:
            if ((r5 instanceof c0) == false) goto L16;
            Boolean r8 = this.a;
            Boolean r2 = Boolean.FALSE;
            if (Intrinsics.areEqual(r8, r2) == true) goto L35;
            this.a = r2;
            g.j3(this.b, ObricContTalkStateMachine$TriggerEvent$NormalASR.INSTANCE);
            return;
        L35:
            return;
        L16:
            if ((r5 instanceof a0) == false) goto L21;
            g r3 = this.b;
            if (r3.k == false) goto L37;
            r3.k = false;
            String r4 = r3.f;
            StringBuilder r9 = new StringBuilder("QueryEnd received, noContent=");
            a0 r10 = (a0) r5;
            r9.append(r10.c);
            r0.i(r4, r9.toString());
            g.j3(this.b, new StateTriggerEvent.QueryEnd(r10.c));
            return;
        L37:
            return;
        L21:
            if ((r5 instanceof y) == false) goto L24;
            g.j3(this.b, ObricContTalkStateMachine$TriggerEvent$PreInterrupt.INSTANCE);
            return;
        L24:
            if ((r5 instanceof b0) == false) goto L27;
            g r11 = this.b;
            r11.k = false;
            r11.j.a(ObricContTalkStateMachine$TriggerEvent$QueryRejected.INSTANCE);
            return;
        L27:
            if ((r5 instanceof f0) == true) goto L29;
            return;
        L29:
            if (pf9.i.i((f0) r5) == false) goto L42;
            g.j3(this.b, StateTriggerEvent.ReplyStart.a);
            return;
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final void d3() {
        this.i = true;
        k3(StateTriggerEvent.Connect.a);
    }

    @Override // com.larus.audio.call.mgr.f
    public final void t() {
        this.k = true;
        k3(StateTriggerEvent.QueryBegin.a);
    }

    @Override // com.larus.audio.call.arch.a
    public final v R2() {
        return new b(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final z0 S2() {
        return new c(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void X2() {
        k3(StateTriggerEvent.Interrupt.a);
    }

    @Override // com.larus.audio.call.arch.a
    public final void c3() {
        k3(StateTriggerEvent.Resume.a);
    }

    @Override // com.larus.audio.call.mgr.f
    public final MajorState s1() {
        int r0 = com.larus.audio.call.mgr.a.a;
        AVKitDuplexState r1 = (AVKitDuplexState) this.j.g.getValue();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        AVKitDuplexState.DownState r2 = r1.getDownState();
        if ((r2 instanceof AVKitCoreStates$Invalid) == false) goto L6;
        return MajorState.c.c;
    L6:
        if ((r2 instanceof AVKitCoreStates$Connecting) == false) goto L9;
        return MajorState.a.c;
    L9:
        if ((r2 instanceof AVKitCoreStates$Error) == false) goto L12;
        return com.larus.audio.call.mgr.a.a((AVKitCoreStates$Error) r2);
    L12:
        if ((r2 instanceof AVKitCoreStates$Paused) == false) goto L15;
        return new MajorState.g(MajorState.h.c);
    L15:
        if ((r2 instanceof AVKitCoreStates$Speaking) == false) goto L18;
        return MajorState.h.c;
    L18:
        if ((r2 instanceof AVKitCoreStates$Thinking) == false) goto L21;
        return new MajorState.i();
    L21:
        if ((r2 instanceof AVKitCoreStates$Finished) == false) goto L24;
        return MajorState.c.c;
    L24:
        if ((r2 instanceof AVKitCoreStates$DownWaiting) == false) goto L27;
        return com.larus.audio.call.mgr.a.b(r1.getUpState());
    L27:
        return com.larus.audio.call.mgr.a.b(r1.getUpState());
    }

    @Override // com.larus.audio.call.mgr.f
    public final i1<AVKitDuplexState> y() {
        return this.j.g;
    }

    @Override // com.larus.audio.call.mgr.f
    public final void z() {
        k3(StateTriggerEvent.Pause.a);
    }

    @Override // com.larus.audio.call.mgr.f
    public final MajorState A0() {
        return s1();
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        super.e3();
        if (this.i == true) goto L16;
        id9.d r0 = getContext().j();
        if (r0 == null) goto L8;
        jd9.c r1 = r0.state();
        if (r1 == null) goto L8;
    L10:
        if ((r1 instanceof jd9.c.d) == false) goto L13;
        jd9.c.d r2 = (jd9.c.d) r1;
        StateTriggerEvent.Error r3 = new StateTriggerEvent.Error(r2.c, r2.e, MapsKt.emptyMap());
        this.j.a(r3);
    L17:
        this.i = false;
        return;
    L13:
        if ((r1 instanceof jd9.c.a) == false) goto L15;
        k3(StateTriggerEvent.Connected.a);
        goto L17
    L15:
        k3(StateTriggerEvent.Connect.a);
    L8:
        r1 = jd9.c.f.c;
        goto L10
    L16:
        k3(StateTriggerEvent.Connect.a);
        goto L17
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
        k3(StateTriggerEvent.Stop.a);
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f;
    }

    @Override // com.larus.audio.call.arch.a
    public final void Z2() {
        z();
    }

    public g(com.larus.audio.call.arch.c r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = "ObricContTalkStateManager";
        this.g = "ObricContTalkStateManager";
        this.h = new a(this);
        com.larus.audio.call.mgr.b r4 = new com.larus.audio.call.mgr.b();
        r4.h(new ObricContTalkStateMachine.Reducer(), ReducerPosition.APPEND);
        this.j = r4;
    }

    @Override // com.larus.audio.call.mgr.f
    public final void M0(f.a r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        com.larus.audio.call.util.e.a.e(this.f, "Not Allow addObserver");
        com.larus.voicecall.impl.f r4 = com.larus.audio.call.f.c().appContext();
        if (r4.e() == false) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L12;
        return;
    L12:
        throw new IllegalStateException("Not Allow");
    L5:
        if (r4.g() == true) goto L8;
        r5 = false;
        goto L9
    }

    @Override // com.larus.audio.call.mgr.f
    public final void V(f.a r3) {
        Intrinsics.checkNotNullParameter(r3, "observer");
        com.larus.audio.call.util.e.a.e(this.f, "Not Allow removeObserver");
        com.larus.voicecall.impl.f r4 = com.larus.audio.call.f.c().appContext();
        if (r4.e() == false) goto L5;
    L8:
        boolean r5 = true;
    L9:
        if (r5 == true) goto L12;
        return;
    L12:
        throw new IllegalStateException("Not Allow");
    L5:
        if (r4.g() == true) goto L8;
        r5 = false;
        goto L9
    }

    public final void k3(StateTriggerEvent r2) {
        this.j.a(r2);
    }

    @Override // com.larus.audio.call.mgr.f
    public final void n2(StateTriggerEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.j.a(r2);
    }

    @Override // com.larus.audio.call.mgr.f
    public final void t1(u68.c r2) {
        Intrinsics.checkNotNullParameter(r2, "controller");
        k3(StateTriggerEvent.Reset.a);
        r2.i(this.h);
    }

    public static final void j3(g r0, StateTriggerEvent r1) {
        r0.j.a(r1);
    }

    @Override // com.larus.audio.call.mgr.f
    public final void F2(DownStateReducer r2, ReducerPosition r3) {
        Intrinsics.checkNotNullParameter(r2, "reducer");
        Intrinsics.checkNotNullParameter(r3, "position");
        this.j.h(r2, r3);
    }

    @Override // com.larus.audio.call.mgr.f
    public final boolean a1(MajorState r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "majorState");
        Intrinsics.checkNotNullParameter(r4, "caller");
        com.larus.audio.call.util.e.a.e(this.f, "Not Allow");
        com.larus.voicecall.impl.f r5 = com.larus.audio.call.f.c().appContext();
        if (r5.e() == false) goto L5;
    L8:
        boolean r6 = true;
    L9:
        if (r6 == true) goto L12;
        return false;
    L12:
        throw new IllegalStateException("Not Allow");
    L5:
        if (r5.g() == true) goto L8;
        r6 = false;
        goto L9
    }

    @Override // com.larus.audio.call.mgr.f
    public final void error(int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "errorMsg");
        StateTriggerEvent.Error r0 = new StateTriggerEvent.Error(r4, r5, MapsKt.mapOf(TuplesKt.to("vui_error_code", Integer.valueOf(r4))));
        this.j.a(r0);
    }
}
