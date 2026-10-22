package com.larus.audio.call.plugins;

import android.os.SystemClock;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.aec.BackTraceRecorderAecImpl;
import com.larus.audio.call.arch.c;
import com.larus.audio.call.extension.WakeupAudioAuthSessionController;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.im.service.audio.AudioSessionType;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class u<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<C> implements t0 {
    public String A;
    public final com.larus.audio.call.util.o B;
    public final Lazy C;
    public final WakeupAudioAuthSessionController D;
    public final d E;
    public boolean F;
    public final com.larus.audio.call.plugins.a G;
    public long H;
    public final String f;
    public final ReentrantLock g;
    public final q0 h;
    public final Object i;
    public final buc.a j;
    public final ue9.g.a k;
    public final Lazy l;
    public final Lazy m;
    public final Lazy n;
    public final int o;
    public final boolean p;
    public BackTraceRecorderAecImpl q;
    public u68.c r;
    public v68.a s;
    public volatile long t;
    public long u;
    public String v;
    public final StateFlowImpl w;
    public final kotlinx.coroutines.flow.b1 x;
    public boolean y;
    public boolean z;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[WakeupAudioAuthSessionController.QueryEndAction.values().length];
            r0[WakeupAudioAuthSessionController.QueryEndAction.END_SESSION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[WakeupAudioAuthSessionController.QueryEndAction.RESET_FOR_NEXT_QUERY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public static final class b implements com.larus.im.service.audio.v {
        public final String a;
        public final /* synthetic */ u<C> b;

        public final String getName() {
            return this.a;
        }

        public b(u<C> r1) {
            this.b = r1;
            this.a = r1.T2();
        }

        public final void O1(jd9.c r3, jd9.c r4) {
            Intrinsics.checkNotNullParameter(r3, "oldState");
            Intrinsics.checkNotNullParameter(r4, "newState");
            if ((r4 instanceof jd9.c.a) == false) goto L13;
            com.larus.audio.call.util.e.a.i(this.b.T2(), "[CALL] CONNECTED wait_hello:" + this.b.b1() + " auto_interrupt:" + this.b.J3());
            u<C> r5 = this.b;
            if (r5.b1() == true) goto L7;
        L10:
            boolean r6 = true;
        L11:
            r5.K3(r6, "session connected");
            return;
        L7:
            if (this.b.J3() == true) goto L10;
            r6 = false;
            goto L11
        }
    }

    public static final class c extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ u<C> b;

        public final String g() {
            return this.a;
        }

        public c(u<C> r1) {
            this.b = r1;
            this.a = r1.T2();
        }

        public final void n(com.larus.im.service.audio.z0.a r8) {
            Intrinsics.checkNotNullParameter(r8, "event");
            com.larus.voicecall.impl.f r0 = com.larus.audio.call.f.c().appContext();
            com.larus.audio.call.util.e r1 = com.larus.audio.call.util.e.a;
            String r2 = this.b.T2();
            StringBuilder r3 = new StringBuilder("[CALL] onReceiveEvent event=");
            boolean r5 = false;
            if (r0.e() == false) goto L5;
        L8:
            boolean r4 = true;
        L9:
            r3.append(pf9.f.a(r8, r4));
            r1.i(r2, r3.toString());
            if ((r8 instanceof pf9.z) == false) goto L25;
            pf9.z r9 = (pf9.z) r8;
            this.b.z3().c(r9.a, Boolean.valueOf(r9.f));
            com.larus.audio.call.aec.w r6 = this.b.q3();
            if (r6 == null) goto L15;
            r6.i("query_begin", true);
        L15:
            if (this.b.getContext().params().b == true) goto L19;
            BackTraceRecorderAecImpl r7 = this.b.q;
            if (r7 == null) goto L19;
            r7.c();
        L19:
            u<C> r10 = this.b;
            r10.u = -1;
            r10.t = -1;
            u<C> r11 = this.b;
            String r12 = "";
            r11.v = "";
            String r13 = r9.a;
            if (r13 == null) goto L23;
            r12 = r13;
        L23:
            Intrinsics.checkNotNullParameter(r12, "<set-?>");
            r11.A = r12;
            this.b.S3();
            return;
        L25:
            if ((r8 instanceof pf9.c0) == false) goto L28;
            pf9.c0 r14 = (pf9.c0) r8;
            this.b.z3().a(r14.a);
            this.b.U3(r14);
            this.b.F3(r14);
            return;
        L28:
            if ((r8 instanceof pf9.a0) == false) goto L38;
            this.b.z3().b();
            pf9.a0 r15 = (pf9.a0) r8;
            this.b.E3(r15);
            this.b.T3(r15);
            if (this.b.getContext().params().l.h != 1) goto L35;
            u<C> r16 = this.b;
            if (r16.s == null) goto L70;
            r16.t3().stopRecord();
            return;
        L70:
            return;
        L35:
            if (Intrinsics.areEqual(this.b.getContext().params().k.t, "assistant_scene_mode_click_talk") == true) goto L72;
            this.b.e0().e(false);
            return;
        L72:
            return;
        L38:
            if ((r8 instanceof pf9.d0) == false) goto L41;
            u<C> r17 = this.b;
            r17.u = SystemClock.elapsedRealtime();
            this.b.V3();
            return;
        L41:
            if ((r8 instanceof pf9.f0) == false) goto L53;
            pf9.f0 r19 = (pf9.f0) r8;
            pf9.k0 r20 = r19.b;
            if (r20 == null) goto L47;
            String r21 = r20.g;
            if (r21 == null) goto L47;
            this.b.P3(r21);
        L47:
            String r22 = pf9.i.k(r19);
            if (r22.length() <= 0) goto L50;
            r5 = true;
        L50:
            if (r5 == false) goto L75;
            this.b.v = r22;
            return;
        L75:
            return;
        L53:
            if ((r8 instanceof pf9.q) == false) goto L56;
            this.b.O3((pf9.q) r8);
            return;
        L56:
            if ((r8 instanceof pf9.e0) == false) goto L59;
            this.b.W3();
            return;
        L59:
            if ((r8 instanceof pf9.i0) == false) goto L62;
            this.b.t = -1;
            this.b.a4();
            return;
        L62:
            if ((r8 instanceof pf9.v) == false) goto L65;
            this.b.Q3((pf9.v) r8);
            return;
        L65:
            if ((r8 instanceof pf9.r) == false) goto L81;
            this.b.R3((pf9.r) r8);
            return;
        L81:
            return;
        L5:
            if (r0.g() == true) goto L8;
            r4 = false;
            goto L9
        }
    }

    public static final class d implements u0 {
        public final /* synthetic */ u<C> a;
        public final /* synthetic */ C b;

        @Override // com.larus.audio.call.plugins.u0
        public final IRealtimeCallTracer U9() {
            return this.b.k();
        }

        @Override // com.larus.audio.call.plugins.u0
        public final u68.a e0() {
            return this.a.A3("mediaControllerContext_common");
        }

        public d(u<C> r1, C r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public Long D3() {
        return null;
    }

    public void M3() {
    }

    public void N3() {
    }

    public void O3(pf9.q r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void P3(String r2) {
        Intrinsics.checkNotNullParameter(r2, "id");
    }

    public void Q3(pf9.v r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void R3(pf9.r r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void S3() {
    }

    public void T3(pf9.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void U3(pf9.c0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void V3() {
    }

    public void W3() {
    }

    public void X3(r58.d r2) {
        Intrinsics.checkNotNullParameter(r2, "audioData");
    }

    @Override // com.larus.audio.call.plugins.t0
    public final void b0() {
        this.F = false;
        this.E.e0().c(false);
    }

    public boolean b1() {
        return false;
    }

    public void c4() {
    }

    @Override // com.larus.audio.call.plugins.t0
    public void d0() {
    }

    public void e4(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "vad");
    }

    @Override // com.larus.audio.call.plugins.t0
    public final void f0() {
        this.F = true;
        this.E.e0().c(true);
    }

    public void f4() {
    }

    @Override // com.larus.audio.call.plugins.t0
    public final v58.a g0() {
        v58.a r0 = com.larus.audio.call.f.b(false);
        if (C3() == true) goto L5;
    L8:
        int r3 = B3().b;
        int r4 = B3().c;
        int r5 = com.larus.audio.call.common.a.a;
        return new v58.a(r3, r4, 2, r0.d);
    L5:
        if (J3() == false) goto L8;
        int r6 = com.larus.audio.call.common.a.a;
        return new v58.a(16000, 2, 2, r0.d);
    }

    public void i(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "audio");
    }

    public void j3(r58.d r1, byte[] r2) {
        Intrinsics.checkNotNullParameter(r1, "audioData");
    }

    public boolean k3() {
        return false;
    }

    public void l3() {
    }

    public boolean w3() {
        return false;
    }

    public boolean x3() {
        return false;
    }

    public Long y3() {
        return null;
    }

    public final boolean C3() {
        if (t68.a.a.c() == false) goto L13;
        int r0 = getContext().params().g;
        if (r0 != 0) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == true) goto L14;
        return true;
    L14:
        return false;
    L7:
        if (r0 == getContext().params().c0) goto L9;
        r1 = true;
        goto L10
    L13:
        return false;
    }

    public boolean J3() {
        return ((Boolean) this.l.getValue()).booleanValue();
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.v R2() {
        return new b(this);
    }

    @Override // com.larus.audio.call.arch.a
    public com.larus.im.service.audio.z0 S2() {
        return new c(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void Y2() {
        this.w.setValue(Boolean.TRUE);
        if (this.s == null) goto L5;
        t3().stopRecord();
    L5:
        com.larus.audio.call.aec.w r0 = q3();
        if (r0 == null) goto L9;
        r0.h("mute", false);
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public void Z2() {
        if (this.s == null) goto L5;
        t3().stopRecord();
    L5:
        e0().pause("pause");
        com.larus.audio.call.aec.w r0 = q3();
        if (r0 == null) goto L9;
        r0.h("pause", true);
        return;
    }

    @Override // com.larus.audio.call.plugins.t0
    public final boolean a0() {
        if (this.r != null) goto L7;
        return false;
    L7:
        return s3().isPlaying();
    }

    @Override // com.larus.audio.call.arch.a
    public void b3() {
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        String r1 = T2();
        StringBuilder r2 = new StringBuilder("initPlayer, aec:");
        if (q3() == null) goto L5;
        boolean r3 = true;
    L6:
        r2.append(r3);
        r0.i(r1, r2.toString());
        r0.i(T2(), "onRelease");
        this.j.d(true);
        if (this.r == null) goto L10;
        s3().release(true);
    L10:
        if (this.s == null) goto L12;
        t3().release();
    L12:
        com.larus.audio.call.aec.w r4 = q3();
        if (r4 == null) goto L15;
        r4.release();
    L15:
        BackTraceRecorderAecImpl r5 = this.q;
        if (r5 == null) goto L18;
        r5.g();
    L18:
        this.D.a();
        return;
    L5:
        r3 = false;
        goto L6
    }

    public final u68.c b4() {
        return A3(T2() + "_playerController()_common");
    }

    @Override // com.larus.audio.call.plugins.t0
    public final u68.c e0() {
        return A3(T2() + "_playerController()_common");
    }

    @Override // com.larus.audio.call.arch.a
    public final void h3() {
        this.w.setValue(Boolean.FALSE);
        com.larus.audio.call.aec.w r0 = q3();
        if ((r0 instanceof com.larus.audio.call.aec.v) == false) goto L5;
        com.larus.audio.call.aec.v r1 = (com.larus.audio.call.aec.v) r0;
    L6:
        if (r1 == null) goto L9;
        r1.R1();
    L9:
        if (getContext().params().l.h != 1) goto L15;
        if ((s1() instanceof MajorState.h) == false) goto L13;
    L17:
        com.larus.audio.call.aec.w r2 = q3();
        if (r2 == null) goto L21;
        r2.f("un_mute");
        return;
    L21:
        return;
    L13:
        if ((s1() instanceof MajorState.i) == true) goto L17;
    L15:
        if ((s1() instanceof MajorState.b) == true) goto L17;
        l1();
        goto L17
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.larus.audio.call.plugins.t0
    public final boolean l1() {
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        r0.i(T2(), "startAudioRecord");
        if (this.y == false) goto L7;
        r0.i(T2(), "startAudioRecord ignored because audio upload is paused");
        return true;
    L7:
        if (this.j.c() == false) goto L10;
        r0.i(T2(), "startAudioRecord ignored because released");
        return true;
    L10:
        com.larus.audio.call.g r1 = com.larus.audio.call.f.d();
        if (r1.D == false) goto L13;
    L16:
        boolean r2 = true;
    L17:
        if (r2 == false) goto L22;
        if (this.s != null) goto L22;
        H3();
    L22:
        if (getContext().n().u == false) goto L24;
        return true;
    L24:
        if (this.s == null) goto L32;
        r0.i(T2(), "startAudioRecord success");
        N3();
        v68.a r3 = t3();
        if (getContext().params() != null) goto L28;
        Function1<? super Exception, Unit> r4 = null;
    L30:
        return r3.start(r4);
    L28:
        r4 = new i(this);
        goto L30
    L32:
        return true;
    L13:
        if (r1.F == true) goto L16;
        r2 = false;
        goto L17
    }

    public u68.c m3() {
        com.larus.audio.call.util.e.a.i(T2(), "createAudioPlayer common");
        return new com.larus.audio.call.play.c(getContext().params(), J3(), J3(), null, 0);
    }

    public v68.a n3() {
        com.larus.audio.call.util.e.a.i(T2(), "createAudioRecorder common");
        return new com.larus.audio.call.record.f(null, 0, J3(), 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v14, types: [com.larus.audio.call.plugins.m] */
    public final void p3() {
        com.larus.audio.call.util.e r0 = com.larus.audio.call.util.e.a;
        String r1 = T2();
        StringBuilder r2 = new StringBuilder("initRecord, aec:");
        boolean r5 = false;
        if (q3() == null) goto L5;
        boolean r4 = true;
    L6:
        r2.append(r4);
        r0.i(r1, r2.toString());
        if (x3() == false) goto L10;
        return;
    L10:
        if (this.j.c() == false) goto L14;
        r0.i(T2(), "initRecord, return cause released");
        return;
    L14:
        if (com.larus.audio.call.f.d().F == false) goto L16;
        v68.a r3 = g4();
    L17:
        if (r3 != null) goto L20;
        r0.e(T2(), "initRecord skipped: audio recorder dependency is not ready");
        return;
    L20:
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.s = r3;
        String r6 = T2();
        StringBuilder r7 = new StringBuilder("initRecord, aec:");
        if (q3() == null) goto L23;
        r5 = true;
    L23:
        r7.append(r5);
        r0.i(r6, r7.toString());
        com.larus.audio.call.aec.w r8 = q3();
        if (r8 == 0) goto L27;
        r8.a(new m(this));
    L27:
        if (w3() == true) goto L29;
    L41:
        t3().setBluetoothForceToMedia(this.z);
        t3().d(null, new o(this));
        com.larus.audio.call.aec.w r9 = q3();
        if (r9 == null) goto L45;
        r9.f("init");
        return;
    L45:
        return;
    L29:
        if (q3() == null) goto L31;
        M3();
    L31:
        BackTraceRecorderAecImpl r10 = new BackTraceRecorderAecImpl();
        this.q = r10;
        r10.e(new n(this));
        BackTraceRecorderAecImpl r11 = this.q;
        if (r11 == null) goto L34;
        r11.h();
    L34:
        Long r12 = y3();
        if (r12 == null) goto L37;
        long r13 = r12.longValue();
    L38:
        t3().c(r13, D3());
        f4();
        if (u3() <= 0) goto L41;
        t3().b(u3());
        goto L41
    L37:
        r13 = 50;
        goto L38
    L16:
        r3 = n3();
        goto L17
    L5:
        r4 = false;
        goto L6
    }

    public final com.larus.audio.call.aec.w q3() {
        if (this.s != null) goto L7;
        return null;
    L7:
        return t3().h();
    }

    public final ouc.d0 r3() {
        ouc.e0 r0 = new ouc.e0();
        r0.b("timestamp", ouc.k.b(Long.valueOf(System.currentTimeMillis())));
        Map<String, Object> r1 = I3();
        LinkedHashMap r2 = new LinkedHashMap();
        Iterator<Map.Entry<String, Object>> r3 = r1.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L15;
        Map.Entry<String, Object> r4 = r3.next();
        String r6 = r4.getKey();
        Object r5 = r4.getValue();
        if ((r5 instanceof Boolean) == true) goto L7;
        if ((r5 instanceof Number) == true) goto L10;
        if ((r5 instanceof String) == true) goto L13;
        com.larus.audio.call.util.e.a.w(T2(), "toJson not support type " + r5);
        Unit r7 = Unit.INSTANCE;
        goto L4
    L13:
        ouc.g0 r8 = ouc.k.c((String) r5);
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r8, "element");
        ouc.i r9 = (ouc.i) r2.put(r6, r8);
        goto L4
    L10:
        ouc.g0 r10 = ouc.k.b((Number) r5);
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r10, "element");
        ouc.i r11 = (ouc.i) r2.put(r6, r10);
        goto L4
    L7:
        ouc.g0 r12 = ouc.k.a((Boolean) r5);
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r12, "element");
        ouc.i r13 = (ouc.i) r2.put(r6, r12);
        goto L4
    L15:
        ouc.d0 r14 = new ouc.d0(r2);
        if (getContext().params().s == AudioSessionType.SAMI) goto L38;
        if (((Boolean) this.n.getValue()).booleanValue() == false) goto L38;
        if (a0() == false) goto L42;
        LinkedHashMap r15 = new LinkedHashMap();
        if (this.t <= 0) goto L24;
        ouc.g0 r16 = ouc.k.b(Long.valueOf(SystemClock.elapsedRealtime() - this.t));
        Intrinsics.checkNotNullParameter("playing_duration", "key");
        Intrinsics.checkNotNullParameter(r16, "element");
        ouc.i r17 = (ouc.i) r15.put("playing_duration", r16);
    L24:
        String r19 = this.v;
        if (r19 != null) goto L27;
    L30:
        boolean r20 = true;
    L31:
        if (r20 == true) goto L33;
        ouc.g0 r21 = ouc.k.c(this.v);
        Intrinsics.checkNotNullParameter("tts_msg_id", "key");
        Intrinsics.checkNotNullParameter(r21, "element");
        ouc.i r22 = (ouc.i) r15.put("tts_msg_id", r21);
    L33:
        ouc.d0 r23 = new ouc.d0(r15);
        if ((SystemClock.elapsedRealtime() - this.H) <= 300) goto L36;
        com.larus.audio.call.util.e.a.i(T2(), "ttsStatus 1111=" + r23);
        this.H = SystemClock.elapsedRealtime();
    L36:
        r0.b("tts_status", r23);
        goto L42
    L27:
        if (StringsKt.isBlank(r19) == true) goto L30;
        r20 = false;
    L42:
        r0.b("asr_status", r14);
        return r0.a();
    L38:
        if (Intrinsics.areEqual(getContext().a().s1(), MajorState.h.c) == false) goto L42;
        LinkedHashMap r24 = new LinkedHashMap();
        ouc.g0 r25 = ouc.k.b(Long.valueOf(SystemClock.elapsedRealtime() - this.u));
        Intrinsics.checkNotNullParameter("playing_duration", "key");
        Intrinsics.checkNotNullParameter(r25, "element");
        ouc.i r26 = (ouc.i) r24.put("playing_duration", r25);
        ouc.g0 r27 = ouc.k.c(this.v);
        Intrinsics.checkNotNullParameter("tts_msg_id", "key");
        Intrinsics.checkNotNullParameter(r27, "element");
        ouc.i r29 = (ouc.i) r24.put("tts_msg_id", r27);
        ouc.d0 r30 = new ouc.d0(r24);
        r0.b("tts_status", r30);
        if ((SystemClock.elapsedRealtime() - this.H) <= 300) goto L42;
        com.larus.audio.call.util.e.a.i(T2(), "ttsStatus2222222=" + r30);
        this.H = SystemClock.elapsedRealtime();
        goto L42
    }

    public final u68.c s3() {
        u68.c r0 = this.r;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("audioPlayer");
        return null;
    }

    public final v68.a t3() {
        v68.a r0 = this.s;
        if (r0 == null) goto L5;
        return r0;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("audioRecorder");
        return null;
    }

    @Override // com.larus.audio.call.plugins.t0
    public final void u() {
        if (this.s == null) goto L6;
        t3().stopRecord();
        return;
    }

    private final MajorState s1() {
        return getContext().a().s1();
    }

    @Override // com.larus.audio.call.plugins.t0
    public final void C1() {
        com.larus.audio.call.arch.b.c(getContext()).cancel("onTriggerHello");
        if (this.r == null) goto L6;
        s3().d(J3(), J3(), "trigger_hello");
    L6:
        if (this.s == null) goto L8;
        t3().stopRecord();
    L8:
        com.larus.audio.call.aec.w r0 = q3();
        if (r0 == null) goto L11;
        r0.i("onTriggerHello", false);
    L11:
        BackTraceRecorderAecImpl r1 = this.q;
        if (r1 == null) goto L15;
        r1.c();
        return;
    }

    public final void H3() {
        if (x3() == false) goto L7;
        com.larus.audio.call.util.e.a.i(T2(), "initRecord skipped because Dora AIS record is enabled");
        return;
    L7:
        if (com.larus.audio.call.f.d().D == false) goto L20;
        Object r0 = this.i;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L11:
        if (this.s == null) goto L14;
        monitor-exit(r0);
        return;
    L14:
        p3();     // Catch: Throwable -> L17
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r0);
        return;
    L20:
        p3();
    }

    public Map<String, Object> I3() {
        return MapsKt.emptyMap();
    }

    @Override // com.larus.audio.call.arch.a
    public void X2() {
        e0().b();
        l1();
    }

    public void a4() {
        if (b1() == true) goto L5;
    L8:
        boolean r0 = true;
    L9:
        K3(r0, "switch_scene");
        return;
    L5:
        if (J3() == true) goto L8;
        r0 = false;
        goto L9
    }

    @Override // com.larus.audio.call.plugins.t0
    public void c0() {
        C r0 = getContext();
        Intrinsics.checkNotNullParameter(r0, "<this>");
        ((r0) r0.b(Reflection.getOrCreateKotlinClass(r0.class), null)).cancel("finishSession");
        com.larus.audio.call.arch.b.c(getContext()).cancel("finishSession");
        if (this.r == null) goto L6;
        s3().d(true, true, "scene_switched");
    L6:
        if (this.s == null) goto L8;
        t3().stopRecord();
    L8:
        com.larus.audio.call.aec.w r1 = q3();
        if (r1 == null) goto L11;
        r1.i("finishSession", false);
    L11:
        BackTraceRecorderAecImpl r2 = this.q;
        if (r2 == null) goto L15;
        r2.c();
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public void c3() {
        e0().resume("resume");
        com.larus.audio.call.aec.w r0 = q3();
        if (r0 == null) goto L6;
        r0.f("resume");
        return;
    }

    @Override // com.larus.audio.call.arch.a
    public void e3() {
        super.e3();
        if (this.j.c() == false) goto L7;
        com.larus.audio.call.util.e.a.i(T2(), "initRecord skipped because released");
        return;
    L7:
        if (v3() == false) goto L9;
        G3(getContext().a(), getContext().params(), getContext().k());
        this.E.e0().c(this.F);
    L9:
        H3();
        WakeupAudioAuthSessionController r0 = this.D;
        Object r1 = r0.d;
        monitor-enter(r1);
        r0.a = false;     // Catch: Throwable -> L16
        r0.b = false;     // Catch: Throwable -> L16
        r0.c = null;     // Catch: Throwable -> L16
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r1);
        this.D.b(w3(), getContext().params().c0, getContext().params().b);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.larus.audio.call.arch.a
    public void g3() {
        super.g3();
        if (this.r == null) goto L6;
        s3().release(false);
    L6:
        if (this.s == null) goto L8;
        t3().stopRecord();
    L8:
        com.larus.audio.call.aec.w r0 = q3();
        if (r0 == null) goto L11;
        r0.i("onStop", false);
    L11:
        BackTraceRecorderAecImpl r1 = this.q;
        if (r1 == null) goto L15;
        r1.c();
        return;
    }

    public v68.a g4() {
        return n3();
    }

    public ue9.g.a B3() {
        return this.k;
    }

    @Override // com.larus.audio.call.arch.a
    public String T2() {
        return this.f;
    }

    @Override // com.larus.audio.call.plugins.t0
    public final kotlinx.coroutines.flow.b1 t0() {
        return this.x;
    }

    public int u3() {
        return this.o;
    }

    public boolean v3() {
        return this.p;
    }

    public com.larus.audio.call.plugins.a z3() {
        return this.G;
    }

    public u(final C r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        this.f = "CommonAudioPlugin";
        this.g = new ReentrantLock();
        this.h = new q0(r4);
        this.i = new Object();
        this.j = buc.b.a(false);
        ue9.g.a.getClass();
        this.k = ue9.g.b.b;
        this.l = LazyKt.lazy(new s(r4));
        this.m = LazyKt.lazy(new t());
        this.n = LazyKt.lazy(new j(this));
        this.o = -1;
        this.p = true;
        this.t = -1;
        this.u = -1;
        StateFlowImpl r0 = kotlinx.coroutines.flow.j1.a(Boolean.FALSE);
        this.w = r0;
        this.x = kotlinx.coroutines.flow.e.b(r0);
        this.A = "";
        this.B = new com.larus.audio.call.util.o(1000);
        this.C = LazyKt.lazy(new k());
        this.D = new WakeupAudioAuthSessionController();
        d r1 = new d(this, r4);
        this.E = r1;
        this.G = new com.larus.audio.call.plugins.a(r1);
    }

    public final u68.c A3(String r6) {
        if (this.r == null) goto L5;
        boolean r0 = true;
    L6:
        com.larus.audio.call.util.e.a.i(T2(), "getPlayer called, caller:" + r6 + ", isAudioInitialed:" + r0);
        if (com.larus.audio.call.f.d().D == false) goto L11;
        if (r0 == true) goto L15;
        G3(getContext().a(), getContext().params(), getContext().k());
    L15:
        return s3();
    L11:
        if (r0 == true) goto L16;
        u68.c r7 = m3();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        this.r = r7;
        return s3();
    L16:
        return s3();
    L5:
        r0 = false;
        goto L6
    }

    public final void E3(pf9.a0 r3) {
        Intrinsics.checkNotNullParameter(r3, "event");
        WakeupAudioAuthSessionController.QueryEndAction r4 = d4(r3);
        int r5 = a.a[r4.ordinal()];
        if (r5 != 1) goto L5;
        this.D.a();
        return;
    L5:
        if (r5 != 2) goto L22;
        WakeupAudioAuthSessionController r6 = this.D;
        Object r0 = r6.d;
        monitor-enter(r0);
    L18:
        th = move-exception;
        throw th;
    L9:
        if (r6.b == true) goto L11;
    L16:
        monitor-exit(r0);
        return;
    L11:
        if (r6.a == true) goto L16;
        r6.c = null;     // Catch: Throwable -> L18
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L18
        monitor-exit(r0);
        r68.b.a.b();
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    }

    public void F1(com.larus.audio.call.play.h.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        v0 r0 = com.larus.audio.call.arch.b.b(getContext());
        if (r0 == null) goto L6;
        r0.F1(r2);
        return;
    }

    public final void F3(pf9.c0 r4) {
        Intrinsics.checkNotNullParameter(r4, "event");
        WakeupAudioAuthSessionController r0 = this.D;
        pf9.a r5 = r4.a;
        if (r5 != null) goto L5;
        r0.getClass();
        return;
    L5:
        Object r1 = r0.d;
        monitor-enter(r1);
    L24:
        th = move-exception;
        throw th;
    L8:
        if (r0.b == true) goto L11;
        monitor-exit(r1);
        return;
    L11:
        String r6 = r5.a;     // Catch: Throwable -> L24
        if (r6 != null) goto L14;
    L22:
        monitor-exit(r1);
        return;
    L14:
        if (r6.length() <= 0) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == true) goto L20;
        r6 = null;
    L20:
        if (r6 == null) goto L22;
        r0.c = r6;     // Catch: Throwable -> L24
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L24
        goto L22
    L16:
        r2 = false;
        goto L17
    }

    @Override // com.larus.audio.call.plugins.t0
    public final void K0(boolean r5) {
        this.y = r5;
        com.larus.audio.call.util.e.a.i(T2(), "setAudioUploadPaused paused=" + r5 + ", isMuted=" + getContext().n().u);
        if (r5 == false) goto L6;
        u();
        return;
    L6:
        if (getContext().n().u == false) goto L8;
        return;
    L8:
        l1();
    }

    public void L3(final r58.d r8) {
        Intrinsics.checkNotNullParameter(r8, "audioData");
        int r0 = RangesKt.coerceAtMost(r8.a, r8.b.length);
        if (C3() == false) goto L5;
        int r1 = com.larus.audio.call.aec.x.a;
        byte[] r2 = com.larus.audio.call.aec.x.a(r8.b, r0);
    L7:
        if (C3() == false) goto L14;
        this.h.q2(r8.b, 18);
        v0 r3 = com.larus.audio.call.arch.b.b(getContext());
        if (r3 == null) goto L12;
        r3.q2(r8.b, 18);
    L12:
        if (getContext().params().b == false) goto L14;
        X3(r8);
    L14:
        WakeupAudioAuthSessionController r4 = this.D;
        r4.getClass();
        Intrinsics.checkNotNullParameter(r2, "pcm");
        if (r4.b == false) goto L18;
        r68.b.a.d(r2);
    L18:
        if (i3() == false) goto L24;
        l3();
        s0 r5 = com.larus.audio.call.arch.b.c(getContext());
        byte[] r6 = r8.b;
        String r7 = r3().toString();
        if (C3() == false) goto L22;
        ue9.g.a r9 = new ue9.g.a(16000, 2);
    L23:
        r5.m2(new com.larus.im.service.audio.l(r6, r7, r9, false));
        this.B.a(new q(this, r8));
        return;
    L22:
        r9 = B3();
        goto L23
    L24:
        j3(r8, null);
        this.B.a(new r(this));
        return;
    L5:
        r2 = r8.b;
        goto L7
    }

    @Override // com.larus.audio.call.plugins.t0
    public final void R0(Function0<Unit> r2) {
        if (this.s == null) goto L6;
        t3().e(r2);
        return;
    }

    @Override // com.larus.audio.call.plugins.t0
    public final void R1(String r4) {
        Intrinsics.checkNotNullParameter(r4, "caller");
        if ((s1() instanceof MajorState.g) == true) goto L6;
        com.larus.audio.call.util.e.a.i(T2(), "prepareToPlay");
        u68.a.C0130a.a(e0(), true, r4, 1);
        return;
    L6:
        if (e0().isPlaying() == false) goto L10;
        com.larus.audio.call.util.e.a.i(T2(), "pause");
        e0().pause(r4);
        return;
    }

    public WakeupAudioAuthSessionController.QueryEndAction d4(pf9.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        return WakeupAudioAuthSessionController.QueryEndAction.END_SESSION;
    }

    @Override // com.larus.audio.call.plugins.t0
    public final void p0(com.larus.audio.call.play.h r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        if ((r2 instanceof com.larus.audio.call.play.h.d) == false) goto L6;
        b4().g(r2);
        return;
    L6:
        if ((r2 instanceof com.larus.audio.call.play.h.a) == false) goto L9;
        b4().g(r2);
        return;
    L9:
        if (Intrinsics.areEqual(r2, com.larus.audio.call.play.h.b.a) == false) goto L12;
        b4().g(r2);
        return;
    L12:
        if ((r2 instanceof com.larus.audio.call.play.h.c) == false) goto L16;
        R1("tts start");
        b4().g(r2);
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.audio.call.plugins.t0
    public final void setBluetoothForceToMedia(boolean r2) {
        this.z = r2;
        if (this.s == null) goto L6;
        t3().setBluetoothForceToMedia(r2);
        return;
    }

    public final void K3(boolean r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "caller");
        com.larus.audio.call.util.e.a.i(T2(), "[CALL] launchMediaResource start:" + r5 + ", caller:" + r6);
        if (r5 == false) goto L6;
        l1();
        return;
    }

    public void Y3(final r58.d r7, byte[] r8) {
        Intrinsics.checkNotNullParameter(r7, "audioData");
        v0 r0 = com.larus.audio.call.arch.b.b(getContext());
        if (r0 == null) goto L6;
        r0.q2(r7.b, 0);
    L6:
        if (J3() == false) goto L11;
        com.larus.audio.call.aec.w r9 = q3();
        if (r9 == null) goto L21;
        r9.b(r7.b, r7.c);
        return;
    L21:
        return;
    L11:
        if (i3() == false) goto L13;
    L16:
        l3();
        com.larus.audio.call.arch.b.c(getContext()).m2(new com.larus.im.service.audio.l(r7.b, r3().toString(), B3(), false));
        if (r8 == null) goto L19;
        e4(r8);
    L19:
        this.B.a(new p(this, r7));
        return;
    L13:
        if (k3() == true) goto L16;
        com.larus.audio.call.util.e.a.i(T2(), "current thread name is >>>" + ThreadMethodProxy.currentThread().getName());
        j3(r7, r8);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.audio.call.plugins.l, java.lang.Object] */
    public final void G3(final com.larus.audio.call.mgr.f r5, final RealtimeCallParam r6, final IRealtimeCallTracer r7) {
        if (com.larus.audio.call.f.d().D == false) goto L19;
        Object r0 = this.i;
        monitor-enter(r0);
        d1 r1 = (d1) this.C.getValue();     // Catch: Throwable -> L16
        if (this.r == null) goto L9;
        boolean r2 = true;
    L10:
        ?? r3 = new l(this, r5, r6, r7);     // Catch: Throwable -> L16
        r1.getClass();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r3, "method");     // Catch: Throwable -> L16
        if (r2 == true) goto L13;
        r3.invoke();     // Catch: Throwable -> L16
    L13:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L16
        monitor-exit(r0);
        return;
    L9:
        r2 = false;
    L16:
        th = move-exception;
        throw th;
    L19:
        o3(r5, r6, r7);
    }

    public final void Z3(r58.d r3, r58.d r4, r58.d r5) {
        Intrinsics.checkNotNullParameter(r3, "originalAudioData");
        Intrinsics.checkNotNullParameter(r4, "micAudioData");
        Intrinsics.checkNotNullParameter(r5, "refAudioData");
        v0 r0 = com.larus.audio.call.arch.b.b(getContext());
        if (r0 == null) goto L5;
        r0.q2(r3.b, 20);
    L5:
        BackTraceRecorderAecImpl r6 = this.q;
        if (r6 == null) goto L9;
        r6.i(r4.b, r5.b);
        return;
    }

    public final void o3(com.larus.audio.call.mgr.f r3, RealtimeCallParam r4, IRealtimeCallTracer r5) {
        if (com.larus.audio.call.f.d().G == false) goto L5;
        u68.c r0 = m3();
    L6:
        if (r0 != null) goto L9;
        com.larus.audio.call.util.e.a.e(T2(), "initPlayer skipped: audio player dependency is not ready");
        return;
    L9:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.r = r0;
        r3.t1(s3());
        s3().i(new v(this));
        s3().i(new com.larus.audio.call.play.i(r5, r4));
        c4();
        s3().init();
        return;
    L5:
        r0 = m3();
        goto L6
    }
}
