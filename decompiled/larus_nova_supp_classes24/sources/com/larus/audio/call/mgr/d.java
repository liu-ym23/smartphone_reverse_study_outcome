package com.larus.audio.call.mgr;

import com.larus.audio.call.plugins.y0;
import com.larus.im.service.audio.cmd.ReplyStage;
import com.larus.im.service.audio.cmd.ReplyType;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.v;
import com.larus.im.service.audio.z0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.i1;
import pf9.a0;
import pf9.d0;
import pf9.e0;
import pf9.f0;
import pf9.i0;
import pf9.k0;
import pf9.m;
import pf9.r;
import pf9.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class d extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements f {
    public final String f;
    public final String g;
    public final ReentrantLock h;
    public volatile MajorState i;
    public final Set<f.a> j;
    public volatile String k;
    public final a l;
    public boolean m;
    public final com.larus.audio.call.mgr.b n;
    public boolean o;

    public static final class a extends com.larus.audio.call.play.e {
        public final /* synthetic */ d a;

        @Override // com.larus.audio.call.play.e, u68.a.b
        public final void onPlayComplete() {
            h(null);
        }

        public a(d r1) {
            this.a = r1;
        }

        @Override // com.larus.audio.call.play.e
        public final void h(String r8) {
            boolean r0 = com.larus.audio.call.f.f();
            if (r0 == false) goto L26;
            AVKitDuplexState r3 = (AVKitDuplexState) this.a.n.g.getValue();
            AVKitDuplexState.DownState r4 = r3.getDownState();
            if ((r4 instanceof AVKitCoreStates$Paused) == false) goto L7;
            AVKitCoreStates$Paused r5 = (AVKitCoreStates$Paused) r4;
        L8:
            if (r5 == null) goto L11;
            AVKitDuplexState.DownState r6 = r5.b;
            if (r6 == null) goto L11;
        L12:
            if (r8 != null) goto L14;
        L17:
            boolean r7 = true;
        L18:
            if (r7 == false) goto L20;
        L22:
            boolean r9 = false;
        L23:
            if (r9 == false) goto L25;
            StateTriggerEvent r10 = new StateTriggerEvent.CurrentReplyPlayEnd(r6);
        L28:
            if ((this.a.i instanceof MajorState.f) == false) goto L30;
        L45:
            if (r0 == true) goto L47;
            return;
        L47:
            if ((this.a.i instanceof MajorState.b) == true) goto L51;
            this.a.n.a(r10);
            return;
        L51:
            return;
        L30:
            if ((this.a.i instanceof MajorState.b) == true) goto L45;
            MajorState r11 = this.a.i;
            if ((r11 instanceof MajorState.d) == true) goto L34;
        L36:
            boolean r12 = false;
        L37:
            if (r12 == true) goto L45;
            d r13 = this.a;
            MajorState.From r14 = MajorState.From.PLAY_COMPLETE;
            if (d.j3(r13, r13.i, true) == false) goto L41;
            MajorState.InterruptType r2 = MajorState.InterruptType.AUTO;
        L42:
            r13.k3(new MajorState.d(r14, r2), false);
            if (r0 == true) goto L45;
            this.a.n.a(r10);
            goto L45
        L41:
            r2 = MajorState.InterruptType.NOTHING;
            goto L42
        L34:
            if (((MajorState.d) r11).d != MajorState.InterruptType.USER) goto L36;
            r12 = true;
            goto L37
        L25:
            r10 = StateTriggerEvent.PlayEnd.a;
            goto L28
        L20:
            if (Intrinsics.areEqual(r8, this.a.k) == false) goto L22;
            r9 = true;
            goto L23
        L14:
            if (StringsKt.isBlank(r8) == true) goto L17;
            r7 = false;
        L11:
            r6 = r3.getDownState();
            goto L12
        L7:
            r5 = null;
            goto L8
        L26:
            r10 = StateTriggerEvent.PlayEnd.a;
            goto L28
        }
    }

    public static final class b implements v {
        public final /* synthetic */ d a;

        public final String getName() {
            return this.a.g;
        }

        public b(d r1) {
            this.a = r1;
        }

        public final void O1(jd9.c r8, jd9.c r9) {
            Intrinsics.checkNotNullParameter(r8, "oldState");
            Intrinsics.checkNotNullParameter(r9, "newState");
            if ((r9 instanceof jd9.c.a) == false) goto L6;
            this.a.k3(MajorState.j.c, false);
            this.a.n.a(StateTriggerEvent.Connect.a);
            this.a.n.a(StateTriggerEvent.Connected.a);
            return;
        L6:
            if (Intrinsics.areEqual(r9, jd9.c.b.c) == false) goto L9;
            this.a.k3(MajorState.a.c, false);
            this.a.n.a(StateTriggerEvent.Connect.a);
            return;
        L9:
            if ((r9 instanceof jd9.c.d) == false) goto L26;
            d r10 = this.a;
            jd9.c.d r11 = (jd9.c.d) r9;
            int r1 = r11.c;
            int r2 = r11.d;
            String r3 = r11.f;
            if (r3.length() != 0) goto L13;
            boolean r4 = true;
        L14:
            if (r4 == false) goto L16;
            r3 = r11.e;
        L16:
            r10.k3(new MajorState.f(r1, r2, r3, r11.g), false);
            com.larus.audio.call.mgr.b r12 = this.a.n;
            int r5 = r11.c;
            String r6 = r11.f;
            if (r6.length() != 0) goto L19;
            boolean r7 = true;
        L20:
            if (r7 == false) goto L22;
            r6 = r11.e;
        L22:
            r12.a(new StateTriggerEvent.Error(r5, r6, MapsKt.mapOf(new Pair[]{TuplesKt.to("sub_error_code", r11.g), TuplesKt.to("vui_error_code", Integer.valueOf(r11.d))})));
            com.larus.audio.call.util.e.a.e(this.a.f, "[CALL] onConnectionStateChanged DISCONNECT, errorCode = " + r11.c + ", subCode = " + r11.g + ", vuiErrorCode = " + r11.d + ", detailErrorMsg = " + r11.f);
            return;
        L19:
            r7 = false;
            goto L20
        L13:
            r4 = false;
            goto L14
        }
    }

    public static final class c extends z0 {
        public final /* synthetic */ d a;

        public final String g() {
            return this.a.f;
        }

        public c(d r1) {
            this.a = r1;
        }

        public final void n(z0.a r10) {
            Intrinsics.checkNotNullParameter(r10, "event");
            boolean r1 = true;
            String r3 = null;
            if ((r10 instanceof z) == false) goto L19;
            d r0 = this.a;
            Long r11 = Long.valueOf(((z) r10).c);
            if (r11.longValue() <= 0) goto L7;
            boolean r4 = true;
        L8:
            if (r4 == true) goto L11;
            r11 = null;
        L11:
            if (r11 == null) goto L13;
            r3 = r11.toString();
        L13:
            r0.k = r3;
            d r12 = this.a;
            r12.o = true;
            MajorState.From r2 = MajorState.From.ASR;
            if (d.j3(r12, r12.i, false) == false) goto L16;
            MajorState.InterruptType r5 = MajorState.InterruptType.AUTO;
        L17:
            r12.k3(new MajorState.d(r2, r5), false);
            this.a.n.a(StateTriggerEvent.QueryBegin.a);
            return;
        L16:
            r5 = MajorState.InterruptType.NOTHING;
            goto L17
        L7:
            r4 = false;
            goto L8
        L19:
            if ((r10 instanceof a0) == false) goto L24;
            d r6 = this.a;
            if (r6.o == false) goto L101;
            r6.o = false;
            r6.k3(new MajorState.i(), false);
            this.a.n.a(new StateTriggerEvent.QueryEnd(((a0) r10).c));
            return;
        L101:
            return;
        L24:
            if ((r10 instanceof d0) == false) goto L29;
            if (Intrinsics.areEqual(((d0) r10).c, "interpret_v2") == false) goto L103;
            com.larus.audio.call.util.e.a.i(this.a.f, "FlowLLMReplyBeginEvent with link state interpret_v2 moveTo(MajorState.ListeningAndSpeaking)");
            this.a.k3(MajorState.e.c, false);
            this.a.n.a(StateTriggerEvent.ReplyStart.a);
            return;
        L103:
            return;
        L29:
            if ((r10 instanceof f0) == false) goto L77;
            if (this.a.k != null) goto L49;
            d r7 = this.a;
            f0 r8 = (f0) r10;
            k0 r9 = r8.b;
            if (r9 == null) goto L38;
            Map r13 = r9.n;
            if (r13 == null) goto L38;
            String r14 = (String) r13.get("query_round");
            if (r14 == null) goto L38;
        L44:
            if (r14 != null) goto L46;
        L48:
            r7.k = r3;
            goto L49
        L46:
            if ((!StringsKt.isBlank(r14)) == false) goto L48;
            r3 = r14;
        L38:
            m r15 = r8.c;
            if (r15 == null) goto L43;
            Map r16 = r15.a;
            if (r16 == null) goto L43;
            r14 = (String) r16.get("query_round");
        L43:
            r14 = null;
        L49:
            f0 r17 = (f0) r10;
            LinkedHashMap r19 = pf9.i.a;
            Intrinsics.checkNotNullParameter(r17, "<this>");
            Intrinsics.checkNotNullParameter(r17, "<this>");
            ReplyType r20 = r17.getType();
            ReplyType r21 = ReplyType.Think;
            if (r20 != r21) goto L52;
            boolean r22 = true;
        L53:
            if (r22 == true) goto L55;
        L57:
            boolean r23 = false;
        L58:
            if (r23 == false) goto L60;
            this.a.k3(new MajorState.i.a(), false);
            this.a.n.a(StateTriggerEvent.DeepThinkStart.a);
            return;
        L60:
            Intrinsics.checkNotNullParameter(r17, "<this>");
            Intrinsics.checkNotNullParameter(r17, "<this>");
            if (r17.getType() != r21) goto L63;
            boolean r24 = true;
        L64:
            if (r24 == true) goto L66;
        L68:
            r1 = false;
        L69:
            if (r1 == false) goto L72;
            this.a.k3(new MajorState.i(), false);
            this.a.n.a(StateTriggerEvent.DeepThinkEnd.a);
            return;
        L72:
            if (pf9.i.i(r17) == true) goto L74;
            return;
        L74:
            if ((this.a.s1() instanceof MajorState.e) == true) goto L108;
            this.a.k3(MajorState.h.c, false);
            this.a.n.a(StateTriggerEvent.ReplyStart.a);
            return;
        L108:
            return;
        L66:
            if (r17.d != ReplyStage.End) goto L68;
        L63:
            r24 = false;
            goto L64
        L55:
            if (r17.d != ReplyStage.Begin) goto L57;
            r23 = true;
            goto L58
        L52:
            r22 = false;
            goto L53
        L77:
            if ((r10 instanceof e0) == false) goto L92;
            MajorState r110 = this.a.i;
            if ((r110 instanceof MajorState.d) == true) goto L81;
        L83:
            r1 = false;
        L84:
            if (r1 == false) goto L87;
            return;
        L87:
            if ((this.a.s1() instanceof MajorState.b) == false) goto L90;
            com.larus.audio.call.util.e.a.i(this.a.f, "ignore FlowLLMReplyEndEvent because current state is Ending");
            return;
        L90:
            this.a.k3(new MajorState.d(MajorState.From.TTS_ENDED, MajorState.InterruptType.NOTHING), false);
            this.a.n.a(StateTriggerEvent.TtsStreamEnd.a);
            return;
        L81:
            if (((MajorState.d) r110).d != MajorState.InterruptType.USER) goto L83;
        L92:
            if ((r10 instanceof i0) == false) goto L95;
            this.a.k3(MajorState.j.c, false);
            this.a.n.a(StateTriggerEvent.Connected.a);
            return;
        L95:
            if ((r10 instanceof r) == true) goto L97;
            return;
        L97:
            if (((r) r10).getType() != TriggerMode.INTERPRET_ASR_STARTED) goto L113;
            com.larus.audio.call.util.e.a.i(this.a.f, "UI FlowLLMCustomEvent INTERPRET_ASR_STARTED");
            this.a.k3(new MajorState.d(MajorState.From.ASR, MajorState.InterruptType.NOTHING), false);
            this.a.n.a(StateTriggerEvent.QueryBegin.a);
            return;
        }
    }

    @Override // com.larus.audio.call.arch.a
    public final void d3() {
        this.m = true;
        k3(MajorState.a.c, false);
        this.n.a(StateTriggerEvent.Connect.a);
    }

    @Override // com.larus.audio.call.arch.a
    public final void e3() {
        this.k = null;
        super.e3();
        if (this.m == true) goto L22;
        id9.d r1 = getContext().j();
        if (r1 == null) goto L8;
        jd9.c r2 = r1.state();
        if (r2 == null) goto L8;
    L10:
        if ((r2 instanceof jd9.c.d) == false) goto L19;
        k3(new MajorState.f(0, 0, null, 15), false);
        com.larus.audio.call.mgr.b r0 = this.n;
        jd9.c.d r3 = (jd9.c.d) r2;
        int r4 = r3.c;
        String r5 = r3.f;
        if (r5.length() != 0) goto L14;
        boolean r6 = true;
    L15:
        if (r6 == false) goto L17;
        r5 = r3.e;
    L17:
        r0.a(new StateTriggerEvent.Error(r4, r5, MapsKt.mapOf(new Pair[]{TuplesKt.to("sub_error_code", r3.g), TuplesKt.to("vui_error_code", Integer.valueOf(r3.d))})));
    L23:
        this.m = false;
        return;
    L14:
        r6 = false;
        goto L15
    L19:
        if ((r2 instanceof jd9.c.a) == false) goto L21;
        k3(MajorState.j.c, false);
        this.n.a(StateTriggerEvent.Connect.a);
        this.n.a(StateTriggerEvent.Connected.a);
        goto L23
    L21:
        k3(MajorState.a.c, false);
        this.n.a(StateTriggerEvent.Connect.a);
    L8:
        r2 = jd9.c.f.c;
        goto L10
    L22:
        k3(MajorState.a.c, false);
        this.n.a(StateTriggerEvent.Connect.a);
        goto L23
    }

    @Override // com.larus.audio.call.mgr.f
    public final void t() {
        this.k = null;
        this.o = true;
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
        k3(new MajorState.d(MajorState.From.PLAY_COMPLETE, MajorState.InterruptType.USER), false);
        this.n.a(StateTriggerEvent.Interrupt.a);
    }

    @Override // com.larus.audio.call.arch.a
    public final void b3() {
        this.n.a(StateTriggerEvent.Stop.a);
    }

    @Override // com.larus.audio.call.arch.a
    public final void c3() {
        MajorState r0 = this.i;
        if ((r0 instanceof MajorState.g) == false) goto L6;
        k3(((MajorState.g) r0).c, true);
    L8:
        this.n.a(StateTriggerEvent.Resume.a);
        return;
    L6:
        if (com.larus.audio.call.f.f() == true) goto L8;
    }

    @Override // com.larus.audio.call.mgr.f
    public final MajorState s1() {
        ReentrantLock r0 = this.h;
        r0.lock();
        MajorState r1 = this.i;     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // com.larus.audio.call.mgr.f
    public final i1<AVKitDuplexState> y() {
        return this.n.g;
    }

    @Override // com.larus.audio.call.mgr.f
    public final void z() {
        k3(new MajorState.g(this.i), false);
        this.n.a(StateTriggerEvent.Pause.a);
    }

    @Override // com.larus.audio.call.mgr.f
    public final MajorState A0() {
        return this.i;
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f;
    }

    @Override // com.larus.audio.call.arch.a
    public final void Z2() {
        z();
    }

    @Override // com.larus.audio.call.arch.a
    public final void g3() {
        super.g3();
    }

    public d(com.larus.audio.call.arch.c r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = "CallStateManager";
        this.g = "CallStateManager";
        this.h = new ReentrantLock();
        this.i = MajorState.c.c;
        this.j = new CopyOnWriteArraySet();
        this.l = new a(this);
        com.larus.audio.call.mgr.b r4 = new com.larus.audio.call.mgr.b();
        CallDuplexReducer r0 = new CallDuplexReducer();
        ReducerPosition r1 = ReducerPosition.APPEND;
        r4.h(r0, r1);
        r4.h(new CallDeepThinkReducer(), r1);
        this.n = r4;
    }

    @Override // com.larus.audio.call.mgr.f
    public final void M0(f.a r4) {
        Intrinsics.checkNotNullParameter(r4, "observer");
        if (((CopyOnWriteArraySet) this.j).contains(r4) == false) goto L5;
        return;
    L5:
        MajorState r0 = s1();
        MajorState.c r1 = MajorState.c.c;
        if (Intrinsics.areEqual(r0, r1) == true) goto L8;
        r4.Q(r1, r0);
    L8:
        ((CopyOnWriteArraySet) this.j).add(r4);
    }

    @Override // com.larus.audio.call.mgr.f
    public final void V(f.a r2) {
        Intrinsics.checkNotNullParameter(r2, "observer");
        if (((CopyOnWriteArraySet) this.j).contains(r2) == true) goto L5;
        return;
    L5:
        ((CopyOnWriteArraySet) this.j).remove(r2);
    }

    @Override // com.larus.audio.call.mgr.f
    public final void n2(StateTriggerEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        if (com.larus.audio.call.f.f() == true) goto L5;
    L7:
        this.n.a(r2);
        return;
    L5:
        if (Intrinsics.areEqual(r2, StateTriggerEvent.RequestThinking.a) == false) goto L7;
        this.k = null;
        goto L7
    }

    @Override // com.larus.audio.call.mgr.f
    public final void t1(u68.c r3) {
        Intrinsics.checkNotNullParameter(r3, "controller");
        k3(MajorState.c.c, false);
        r3.i(this.l);
    }

    @Override // com.larus.audio.call.mgr.f
    public final void F2(DownStateReducer r2, ReducerPosition r3) {
        Intrinsics.checkNotNullParameter(r2, "reducer");
        Intrinsics.checkNotNullParameter(r3, "position");
        this.n.h(r2, r3);
    }

    @Override // com.larus.audio.call.mgr.f
    public final boolean a1(MajorState r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "majorState");
        Intrinsics.checkNotNullParameter(r4, "caller");
        if ((this.i instanceof MajorState.c) == false) goto L5;
    L9:
        boolean r5 = false;
    L10:
        if (r5 == false) goto L13;
        k3(r3, false);
        return true;
    L13:
        return false;
    L5:
        if ((this.i instanceof MajorState.a) == true) goto L9;
        if ((this.i instanceof MajorState.f) == true) goto L9;
        r5 = true;
        goto L10
    }

    @Override // com.larus.audio.call.mgr.f
    public final void error(int r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "errorMsg");
        k3(new MajorState.f(r5, r5, r6, 8), false);
        this.n.a(new StateTriggerEvent.Error(r5, r6, MapsKt.mapOf(TuplesKt.to("vui_error_code", Integer.valueOf(r5)))));
    }

    public final void k3(MajorState r7, boolean r8) {
        MajorState.CheckResult r0 = MajorState.CheckResult.NORMAL;
        ReentrantLock r1 = this.h;
        r1.lock();
        final MajorState r2 = this.i;     // Catch: Throwable -> L16
        if (r8 == false) goto L6;
    L8:
        final MajorState r9 = r7;
    L9:
        MajorState.CheckResult r3 = r2.a(r9);     // Catch: Throwable -> L16
        if (r3.getMove() == false) goto L12;
        this.i = r9;     // Catch: Throwable -> L16
    L12:
        r1.unlock();
        com.larus.audio.call.util.e.a.i(this.f, "[state_move]: prev=" + r2 + ", request=" + r7 + ", next=" + r9 + ", check=" + r3);
        if (r3.getDispatch() == false) goto L21;
        q68.b.a(this.j, new s68.g(r2, r9));
        return;
    L21:
        return;
    L6:
        if ((r2 instanceof MajorState.g) == false) goto L8;
        r9 = new MajorState.g(r7);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r1.unlock();
        throw th;
    }

    public static final boolean j3(d r3, MajorState r4, boolean r5) {
        r3.getClass();
        if ((r4 instanceof MajorState.i) == false) goto L5;
    L13:
        boolean r6 = true;
    L14:
        if (r5 == true) goto L26;
        if (r6 == false) goto L18;
        return true;
    L18:
        if ((r4 instanceof MajorState.h) == false) goto L20;
        return true;
    L20:
        if ((r4 instanceof MajorState.d) == true) goto L22;
    L24:
        return false;
    L22:
        if (((MajorState.d) r4).c != MajorState.From.TTS_ENDED) goto L24;
        return true;
    L26:
        return r6;
    L5:
        if ((r4 instanceof MajorState.j) == false) goto L12;
        y0 r7 = com.larus.audio.call.arch.b.d(r3.getContext());
        if (r7 == null) goto L9;
        boolean r8 = r7.b1();
    L10:
        if (r8 == false) goto L12;
    L9:
        r8 = false;
    L12:
        r6 = false;
        goto L14
    }
}
