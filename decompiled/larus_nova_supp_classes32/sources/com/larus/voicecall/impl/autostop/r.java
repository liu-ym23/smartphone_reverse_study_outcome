package com.larus.voicecall.impl.autostop;

import android.os.SystemClock;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.im.service.audio.a1;
import com.larus.im.service.audio.z0;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.d0;
import pf9.a0;
import pf9.c0;
import pf9.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class r extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements com.larus.im.service.audio.v {
    public final String f;
    public final String g;
    public IRealtimeCallTracer.EnterCallSessionStatus h;
    public jd9.c i;
    public long j;
    public long k;
    public boolean l;
    public boolean m;
    public int n;
    public String o;
    public String p;
    public com.larus.voicecall.impl.tracer.j q;

    public static final class a extends a1 {
        public final String a;
        public final /* synthetic */ r b;

        public final String g() {
            return this.a;
        }

        public a(r r1) {
            this.b = r1;
            this.a = r1.f;
        }

        public final void n(z0.a r8) {
            Intrinsics.checkNotNullParameter(r8, "event");
            boolean r0 = r8 instanceof pf9.o;
            String r1 = NameKeys.UnloadStrategy_No_Strategy;
            if (r0 == false) goto L7;
            final r r9 = this.b;
            if (r9.q != null) goto L46;
            r9.q = new com.larus.voicecall.impl.tracer.j(r9.getContext(), NameKeys.UnloadStrategy_No_Strategy, false, new q(r9));
            return;
        L46:
            return;
        L7:
            String r3 = null;
            if ((r8 instanceof z) == false) goto L21;
            this.b.getContext().i().f("realcall_message", "call");
            this.b.getContext().i().f("asr_phase", "realcall_message");
            final r r2 = this.b;
            z r10 = (z) r8;
            r2.p = r10.b;
            r2.o = null;
            String r11 = r10.a;
            if (r11 == null) goto L13;
            r1 = r11;
        L13:
            com.larus.voicecall.impl.tracer.j r12 = r2.q;
            if (r12 == null) goto L16;
            r12.s();
        L16:
            com.larus.voicecall.impl.tracer.j r13 = r2.q;
            if (r13 == null) goto L19;
            com.larus.audio.call.arch.b.a(r13.a).e0().j(r13.I);
        L19:
            r2.q = new com.larus.voicecall.impl.tracer.j(r2.getContext(), r1, false, new q(r2));
            return;
        L21:
            if ((r8 instanceof c0) == false) goto L33;
            String r4 = this.b.p;
            c0 r14 = (c0) r8;
            pf9.a r5 = r14.a;
            if (r5 == null) goto L25;
            String r6 = r5.c;
        L27:
            if (Intrinsics.areEqual(r4, r6) == false) goto L49;
            r r7 = this.b;
            pf9.a r15 = r14.a;
            if (r15 == null) goto L31;
            r3 = r15.a;
        L31:
            r7.o = r3;
            return;
        L49:
            return;
        L25:
            r6 = null;
            goto L27
        L33:
            if ((r8 instanceof a0) == false) goto L41;
            final r r16 = this.b;
            if (r16.q != null) goto L37;
            r16.q = new com.larus.voicecall.impl.tracer.j(r16.getContext(), NameKeys.UnloadStrategy_No_Strategy, false, new q(r16));
        L37:
            r r17 = this.b;
            com.larus.voicecall.impl.tracer.j r18 = r17.q;
            if (r18 == null) goto L51;
            r18.d((a0) r8, r17.o, false, null);
            return;
        L51:
            return;
        L41:
            if ((r8 instanceof pf9.q) == false) goto L53;
            com.larus.voicecall.impl.tracer.j r19 = this.b.q;
            if (r19 == null) goto L54;
            r19.f((pf9.q) r8);
            return;
        L54:
            return;
        }

        public final void q(String r3, Object r4) {
            Intrinsics.checkNotNullParameter(r3, "event");
            Intrinsics.checkNotNullParameter(r3, "event");
            if (Intrinsics.areEqual(r3, "OTHER_UPDATE_SESSION_STATUS") == false) goto L10;
            if ((r4 instanceof Integer) == false) goto L10;
            IRealtimeCallTracer.EnterCallSessionStatus.a r0 = IRealtimeCallTracer.EnterCallSessionStatus.Companion;
            int r5 = ((Number) r4).intValue();
            r0.getClass();
            IRealtimeCallTracer.EnterCallSessionStatus r6 = IRealtimeCallTracer.EnterCallSessionStatus.a.a(r5);
            if (r6 == null) goto L10;
            this.b.j3(r6);
        L10:
            if (Intrinsics.areEqual(r3, "OTHER_EVENT_CALL_SERVER_START") == false) goto L13;
            this.b.getContext().i().f("create_call", "connecting");
            return;
        L13:
            if (Intrinsics.areEqual(r3, "OTHER_EVENT_CALL_SERVER_END") == false) goto L17;
            com.larus.audio.call.tracer.b.b(this.b.getContext().i(), "create_call", null, 6);
            return;
        }
    }

    public final com.larus.im.service.audio.v R2() {
        return this;
    }

    public final z0 S2() {
        return new a(this);
    }

    public final void X2() {
        com.larus.voicecall.impl.tracer.j r0 = this.q;
        if (r0 == null) goto L6;
        r0.s();
        return;
    }

    public final void b3() {
        com.larus.voicecall.impl.tracer.j r0 = this.q;
        if (r0 != null) goto L5;
    L9:
        com.larus.voicecall.impl.tracer.j r1 = this.q;
        if (r1 == null) goto L12;
        com.larus.audio.call.arch.b.a(r1.a).e0().j(r1.I);
    L12:
        this.q = null;
        return;
    L5:
        if (this.n == 0) goto L7;
        boolean r2 = true;
    L8:
        r0.e(r2);
        goto L9
    L7:
        r2 = false;
        goto L8
    }

    public final void a3() {
        getContext().i().f("connecting", "call");
        getContext().i().f("create_audio_session", "connecting");
    }

    public final void e3() {
        super.e3();
        this.j = SystemClock.elapsedRealtime();
        j3(IRealtimeCallTracer.EnterCallSessionStatus.CREATE_HANDLE);
    }

    public final void f3() {
        com.larus.audio.call.tracer.b.b(getContext().i(), "create_audio_session", "start aborted", 4);
        com.larus.audio.call.tracer.b.b(getContext().i(), "connecting", "start aborted", 4);
        getContext().i().c();
    }

    public final void g3() {
        super.g3();
        getContext().i().c();
    }

    public final String T2() {
        return this.f;
    }

    public final String getName() {
        return this.g;
    }

    public r(com.larus.audio.call.arch.c r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = "AutoStopAsrTracePlugin";
        this.g = "AutoStopAsrTracePlugin";
        this.h = IRealtimeCallTracer.EnterCallSessionStatus.INITIAL;
        this.i = jd9.c.f.c;
        this.k = -1;
        this.m = true;
    }

    public final void j3(IRealtimeCallTracer.EnterCallSessionStatus r5) {
        if (r5.getValue() >= 10) goto L8;
        if (r5.getValue() > this.h.getValue()) goto L26;
        return;
    L26:
        this.h = r5;
        return;
    L8:
        if (r5.getValue() >= 20) goto L15;
        if (this.h.getValue() >= 3) goto L12;
        return;
    L12:
        if (this.h.getValue() < 20) goto L26;
        return;
    L15:
        if (r5.getValue() >= 30) goto L22;
        if (this.h.getValue() >= 10) goto L19;
        return;
    L19:
        if (this.h.getValue() < 20) goto L26;
        return;
    L22:
        if (this.h.getValue() >= 20) goto L24;
        return;
    L24:
        if (this.h.getValue() < 30) goto L26;
    }

    public final void O1(jd9.c r18, jd9.c r19) {
        Intrinsics.checkNotNullParameter(r18, "oldState");
        Intrinsics.checkNotNullParameter(r19, "newState");
        d0 r2 = r19.b;
        if (r2 == null) goto L5;
        String r3 = sf9.a.c(r2, "roomId", NameKeys.UnloadStrategy_No_Strategy);
    L7:
        if (r3 != null) goto L9;
    L12:
        boolean r6 = true;
    L13:
        if (r6 == true) goto L16;
        RealtimeCallParam r7 = getContext().params();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r7.d = r3;
    L16:
        if ((r19 instanceof jd9.c.d) == false) goto L43;
        jd9.c.d r4 = (jd9.c.d) r19;
        int r8 = r4.c;
        ue9.c.u r9 = ue9.c.u.c;
        if (r8 == 20010) goto L27;
        ue9.c.q r10 = ue9.c.q.c;
        if (r8 == 20011) goto L27;
        ue9.c.w r11 = ue9.c.w.c;
        if (r8 == 20006) goto L26;
        ue9.c.v r12 = ue9.c.v.c;
        if (r8 == 20007) goto L26;
    L28:
        String r13 = r4.f;
        if (StringsKt.isBlank(r13) == false) goto L32;
        r13 = r4.e;
    L32:
        if (this.l == true) goto L43;
        if (this.m == false) goto L43;
        this.n = r8;
        IRealtimeCallTracer r14 = getContext().k();
        RealtimeCallParam r15 = getContext().params();
        if (r13.length() != 0) goto L39;
        boolean r5 = true;
    L40:
        if (r5 == false) goto L42;
        r13 = "un_know_error";
    L42:
        r14.f(r15, r13, true, this.h, Integer.valueOf(r8), SystemClock.elapsedRealtime() - this.j, false);
        this.m = false;
        goto L43
    L39:
        r5 = false;
    L26:
        r8 = -1;
    L27:
        r8 = -3;
    L43:
        boolean r16 = r19 instanceof jd9.c.a;
        if (r16 == false) goto L49;
        if (((jd9.c.a) r19).c == false) goto L49;
        this.k = SystemClock.elapsedRealtime() - this.j;
    L49:
        if (this.l == true) goto L54;
        if (r16 == false) goto L54;
        if (((jd9.c.a) r19).c == true) goto L54;
        this.l = true;
        j3(IRealtimeCallTracer.EnterCallSessionStatus.SESSION_STARTED);
        getContext().k().j(getContext().params(), this.m, this.h, this.k, SystemClock.elapsedRealtime() - this.j, false);
        com.larus.audio.call.tracer.b.b(getContext().i(), "create_audio_session", null, 6);
        com.larus.audio.call.tracer.b.b(getContext().i(), "connecting", null, 6);
        this.n = 0;
        this.m = false;
    L54:
        this.i = r19;
        return;
    L9:
        if (StringsKt.isBlank(r3) == true) goto L12;
        r6 = false;
        goto L13
    L5:
        r3 = null;
        goto L7
    }
}
