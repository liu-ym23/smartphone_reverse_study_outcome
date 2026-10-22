package com.larus.voicecall.impl.tracer;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.play.abs.TtsPlayEndType;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.im.service.audio.y0;
import com.larus.platform.service.z2;
import com.larus.trace.tracespan.span.SpanWrapImpl;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class j {
    public static final /* synthetic */ int J = 0;
    public volatile boolean A;
    public int B;
    public long C;
    public String D;
    public boolean E;
    public boolean F;
    public long G;
    public String H;
    public final b I;
    public final com.larus.audio.call.arch.c a;
    public final String b;
    public final boolean c;
    public final Function0<Boolean> d;
    public final String e;
    public final String f;
    public final String g;
    public long h;
    public long i;
    public long j;
    public long k;
    public String l;
    public volatile boolean m;
    public volatile boolean n;
    public volatile boolean o;
    public long p;
    public long q;
    public volatile boolean r;
    public volatile boolean s;
    public volatile boolean t;
    public com.larus.audio.call.p u;
    public k v;
    public l w;
    public volatile boolean x;
    public int y;
    public long z;

    public static final class a {
    }

    public static final class b extends com.larus.audio.call.play.e {
        public final /* synthetic */ j a;

        public final void c() {
            this.a.n();
        }

        public b(j r1) {
            this.a = r1;
        }

        public final void b(Map<String, String> r8) {
            if (this.a.m == false) goto L6;
            this.a.m = false;
            this.a.getContext().k().Q(IRealtimeCallTracer.HelloStatus.PLAY_HELLO, null);
            com.larus.audio.call.tracer.b.b(this.a.getContext().i(), "tts_delay", null, 6);
            com.larus.audio.call.tracer.b.b(this.a.getContext().i(), "realcall_message", null, 6);
            j r9 = this.a;
            r9.p = System.currentTimeMillis();
            this.a.r = false;
            j.q(this.a, 0, -2, null, null, 12);
            j r10 = this.a;
            r10.getClass();
            com.larus.utils.l0.b(new h(r10, 0));
            j r11 = this.a;
            r11.getClass();
            l r0 = new l(r11);
            r11.w = r0;
            r0.d();
            return;
        }

        public final void f(TtsPlayEndType r2) {
            Intrinsics.checkNotNullParameter(r2, "endType");
            this.a.o();
        }
    }

    public static final class c extends com.larus.audio.call.p {
        public final /* synthetic */ j g;

        public final void c(long r1) {
        }

        public final void b() {
            j.q(this.g, 2, 0, null, null, 14);
        }

        public c(long r1, j r3) {
            this.g = r3;
            super(r1, r1);
        }
    }

    static {
    }

    public long c() {
        return AutoEndConversationTime.AFTER_60_SECONDS;
    }

    public void n() {
        FLogger.a.i("RealtimeCallQueryMonitor", "onTtsFirstFramePlayed");
        this.q = System.currentTimeMillis();
        l r0 = this.w;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.w = null;
    }

    public final void o() {
        FLogger.a.i("RealtimeCallQueryMonitor", "onTtsPlayFinished");
        if (this.p > 0) goto L5;
    L9:
        this.r = true;
        return;
    L5:
        if (this.A == false) goto L7;
        int r2 = 0;
    L8:
        long r0 = System.currentTimeMillis();
        long r3 = this.p;
        r(r2, r0 - r3, this.q - r3, System.currentTimeMillis() - this.h, 0);
        goto L9
    L7:
        r2 = 3;
        goto L8
    }

    public final void s() {
        k r0 = this.v;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        this.v = null;
        if (this.r == true) goto L12;
        long r1 = this.q;
        long r2 = 0;
        if (r1 <= 0) goto L10;
        r2 = r1 - this.p;
    L10:
        r(3, b(this.p), r2, b(this.h), -222);
    L12:
        if (this.u == null) goto L14;
        q(this, 3, 0, null, "interrupt", 6);
    L14:
        FLogger.a.i("RealtimeCallQueryMonitor", "trigger interrupt qid = " + this.b + " callId =" + this.f + " roomId=" + this.g + "scene = " + this.e + " hasSendExpResponseEvent = " + this.s + " isFirstPacifyResponse = " + this.n + " ttsPlayComplete = " + this.r + " isFirstTTSResponse = " + this.m + "isFirstChatResponse = " + this.o);
    }

    public final com.larus.audio.call.arch.c getContext() {
        return this.a;
    }

    public static long b(long r3) {
        if (r3 != 0) goto L6;
        return 0;
    L6:
        return System.currentTimeMillis() - r3;
    }

    public final void a(Map<String, Object> r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        r4.put("scene", this.e);
        r4.put("call_id", this.f);
        r4.put("room_id", this.g);
        int r0 = com.larus.im.a.a;
        gd9.o r1 = com.larus.im.internal.d.a;
        com.larus.im.internal.audio.u.c.getClass();
        com.larus.im.internal.utils.x r2 = com.larus.im.internal.utils.x.a;
        r4.put("is_mock_test", Boolean.FALSE);
        r4.put("task_id", this.a.params().l.a);
        if (Intrinsics.areEqual(this.e, "call") == false) goto L5;
    L7:
        RealtimeCallParam r3 = this.a.params();
        r4.put("is_rtc", Boolean.valueOf(y0.e(r3.s)));
        r4.put("is_quic", Boolean.valueOf(y0.d(r3.s)));
        r4.put("is_mmt", Integer.valueOf(y0.b(r3.s) ? 1 : 0));
        r4.put("client_pre_connect", Integer.valueOf(r3.t));
        r4.put("av_session_type", Integer.valueOf(r3.s.getType()));
        r4.put("is_dora_si", Integer.valueOf(Intrinsics.areEqual(this.a.params().k.o, "dora_si") ? 1 : 0));
        r4.put("is_v3", Integer.valueOf(this.F ? 1 : 0));
        return;
    L5:
        if (Intrinsics.areEqual(this.e, "assistant_scene_mode_click_talk") == true) goto L7;
        r4.put("dora_mode", this.e);
        goto L7
    }

    public final void e(boolean r13) {
        if (this.u == null) goto L5;
        q(this, 3, 0, null, "onCallEnd", 6);
    L5:
        l r0 = this.w;
        if (r0 == null) goto L8;
        r0.a();
        this.w = null;
    L8:
        k r1 = this.v;
        if (r1 == null) goto L12;
        r1.a();
        this.v = null;
    L12:
        if (this.r == true) goto L17;
        if (this.x == false) goto L17;
        r(3, b(this.p), this.q - this.p, b(this.h), -111);
    L17:
        if (this.h != 0) goto L23;
        long r10 = this.z;
        if (r10 <= 0) goto L24;
        if (r13 == true) goto L25;
        com.larus.utils.l0.b(new com.larus.voicecall.impl.tracer.c(this, this.y, false, true, r10));
        return;
    L25:
        return;
    L24:
        return;
    }

    public void f(pf9.q r14) {
        Intrinsics.checkNotNullParameter(r14, "serverEvent");
        if (this.o == false) goto L5;
        this.o = false;
        com.larus.utils.l0.b(new f(this, 0, true));
    L5:
        List r0 = r14.a;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r8 = r0.iterator();
    L7:
        if (r8.hasNext() == false) goto L88;
        pf9.p r9 = (pf9.p) r8.next();
        Long r1 = r9.a;
        Integer r10 = null;
        if (r1 == null) goto L11;
        Integer r2 = Integer.valueOf((int) r1.longValue());
    L12:
        if (r2 != null) goto L15;
    L16:
        if (r2 != null) goto L19;
    L20:
        if (r2 != null) goto L23;
    L24:
        if (r2 != null) goto L27;
    L28:
        if (r2 != null) goto L31;
    L33:
        if (r2 != null) goto L36;
    L67:
        if (r2 != null) goto L70;
    L71:
        if (r2 != null) goto L74;
    L76:
        List r3 = z2.a.o1();
        Long r4 = r9.a;
        if (r4 == null) goto L80;
        r10 = Integer.valueOf((int) r4.longValue());
    L80:
        if (CollectionsKt.contains(r3, r10) == false) goto L87;
        Long r5 = r9.a;
        if (r5 == null) goto L84;
        int r6 = (int) r5.longValue();
    L85:
        q(this, 0, r6, null, null, 12);
        goto L87
    L84:
        r6 = -1;
    L87:
        r7.add(r9);
        goto L7
    L74:
        if (r2.intValue() != 24) goto L76;
    L86:
        q(this, 0, 0, null, null, 14);
        goto L87
    L70:
        if (r2.intValue() == 23) goto L86;
    L36:
        if (r2.intValue() != 8) goto L67;
        Map r11 = r9.b;
        if (r11 == null) goto L44;
        String r12 = (String) r11.get("tea_tags_time_cost");
        if (r12 == null) goto L44;
        String r13 = new JSONObject(r12).optString("agent_intention");
        if (o0.d(r13) == false) goto L44;
        Intrinsics.checkNotNull(r13);
        q(this, 0, 0, r13, null, 10);
    L44:
        JSONObject r15 = new JSONObject();
        int r16 = z2a.g.a;
        SpanWrapImpl r17 = z2a.g.c(this.a.i().d(), "realcall_message");
        SpanWrapImpl r18 = z2a.g.c(this.a.i().d(), "llm_phase");
        Map r19 = r9.b;
        if (r19 == null) goto L49;
        String r20 = (String) r19.get("intention");
        if (r20 == null) goto L49;
        this.l = r20;
        r15.put("intention", r20);
    L49:
        Map r21 = r9.b;
        if (r21 != null) goto L52;
    L54:
        if (r17 == null) goto L56;
        r17.b(r15);
    L56:
        if (r18 == null) goto L58;
        r18.b(r15);
    L58:
        Map r22 = r9.b;
        if (r22 == null) goto L61;
        String r23 = (String) r22.get("is_chat_resp_first");
    L63:
        if (Intrinsics.areEqual(r23, "1") == false) goto L87;
        if (this.o == false) goto L87;
        this.o = false;
        com.larus.audio.call.tracer.b.b(this.a.i(), "llm_phase", null, 6);
        this.a.i().f("tts_delay", "realcall_message");
        goto L87
    L61:
        r23 = null;
        goto L63
    L52:
        if (((String) r21.get("is_pacity")) == null) goto L54;
        r15.put("is_pacity", "1");
        goto L54
    L31:
        if (r2.intValue() != 21) goto L33;
    L27:
        if (r2.intValue() == 5) goto L87;
    L23:
        if (r2.intValue() == 14) goto L87;
    L19:
        if (r2.intValue() == 12) goto L87;
    L15:
        if (r2.intValue() == 13) goto L87;
    L11:
        r2 = null;
        goto L12
    }

    public void g(pf9.q r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void h(pf9.z r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void i(pf9.a0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void j(pf9.c0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void k(pf9.d0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void l(pf9.e0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public void m(pf9.f0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public j(com.larus.audio.call.arch.c r2, String r3, boolean r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "questionId");
        Intrinsics.checkNotNullParameter(r5, "currentConnectValid");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r2.params().k.a();
        this.f = r2.params().e;
        this.g = r2.params().d;
        this.i = -1;
        this.m = true;
        this.n = true;
        this.o = true;
        this.r = true;
        this.x = true;
        this.D = NameKeys.UnloadStrategy_No_Strategy;
        b r6 = new b(this);
        this.I = r6;
        com.larus.audio.call.arch.b.a(r2).e0().i(r6);
    }

    public final void d(pf9.a0 r28, String r29, boolean r30, String r31) {
        Intrinsics.checkNotNullParameter(r28, "asrEndData");
        this.H = null;
        this.s = false;
        this.l = null;
        this.h = System.currentTimeMillis();
        Long r2 = r28.b;
        if (r2 == null) goto L5;
        long r3 = RangesKt.coerceAtLeast(r2.longValue(), 0);
    L6:
        this.i = r3;
        long r4 = r28.f;
        if (r4 > 0) goto L10;
        r4 = r28.g;
    L10:
        this.G = r4;
        long r11 = r28.a;
        boolean r5 = r28.c;
        if (r5 == false) goto L13;
    L16:
        if (r5 == true) goto L18;
    L20:
        boolean r6 = false;
    L21:
        this.x = r6;
        IRealtimeCallTracer r13 = this.a.k();
        RealtimeCallParam r14 = this.a.params();
        int r15 = (int) r11;
        Long r0 = r28.b;
        if (r0 == null) goto L24;
        long r16 = r0.longValue();
    L25:
        long r7 = this.G;
        String r1 = this.b;
        if (r30 == true) goto L28;
        String r8 = "auto";
    L29:
        r13.d0(r14, r15, r16, r7, r5, r29, r1, r8, Long.valueOf(this.j), Long.valueOf(this.h), r31);
        if (this.E == false) goto L33;
        this.y = 0;
        this.z = 0;
    L33:
        if (((Boolean) this.d.invoke()).booleanValue() == false) goto L36;
        com.larus.utils.l0.b(new com.larus.voicecall.impl.tracer.c(this, this.y, this.x, false, this.z));
        com.larus.audio.call.tracer.b.b(this.a.i(), "asr_phase", null, 6);
        this.a.i().f("llm_phase", "realcall_message");
        this.a.k().c0(r11);
        long r9 = c();
        FLogger.a.i("RealtimeCallQueryMonitor", "startExpResponseTimer timeoutDuration = " + r9);
        c r10 = new c(r9, this);
        this.u = r10;
        r10.d();
        this.C = 0;
        return;
    L36:
        return;
    L28:
        r8 = "click_sound_wave";
        goto L29
    L24:
        r16 = 0;
        goto L25
    L18:
        if (r28.d == false) goto L20;
    L19:
        r6 = true;
        goto L21
    L13:
        if (r11 > 0) goto L19;
        if (Intrinsics.areEqual(this.e, "dora_radio") == true) goto L19;
    L5:
        r3 = 0;
        goto L6
    }

    public void p(final int r8, final int r9, final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "agentIntention");
        Intrinsics.checkNotNullParameter(r11, "bisScene");
        com.larus.utils.l0.b(new d(this, r8, r10, r11, r9));
    }

    public final void r(final int r12, final long r13, final long r15, final long r17, final int r19) {
        com.larus.utils.l0.b(new e(this, r12, r15, r13, r17, r19));
    }

    public static /* synthetic */ void q(j r2, int r3, int r4, String r5, String r6, int r7) {
        if ((r7 & 2) == 0) goto L6;
        r4 = -1;
    L6:
        if ((r7 & 4) == 0) goto L9;
        r5 = NameKeys.UnloadStrategy_No_Strategy;
    L9:
        if ((r7 & 8) == 0) goto L11;
        r6 = NameKeys.UnloadStrategy_No_Strategy;
    L11:
        r2.p(r3, r4, r5, r6);
    }
}
