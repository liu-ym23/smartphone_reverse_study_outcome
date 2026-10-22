package com.larus.avlink.plugins;

import com.google.gson.Gson;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.DoraTraceParam;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class t extends com.larus.voicecall.impl.tracer.j {
    public long K;
    public long L;
    public Boolean M;
    public long N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public long S;
    public boolean T;
    public boolean U;
    public String V;
    public String W;

    public static final class a {
    }

    static {
    }

    public final long c() {
        return 15000;
    }

    public final void n() {
        this.O = System.currentTimeMillis();
        super.n();
        com.larus.voicecall.impl.tracer.j.q(this, 0, 0, null, "first_frame_play", 6);
    }

    public final void f(pf9.q r9) {
        Intrinsics.checkNotNullParameter(r9, "event");
        super.f(r9);
        List r10 = r9.a;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, 10));
        Iterator r11 = r10.iterator();
    L4:
        if (r11.hasNext() == false) goto L49;
        pf9.p r1 = (pf9.p) r11.next();
        Long r2 = r1.a;
        if (r2 == null) goto L48;
        int r3 = (int) r2.longValue();
        FLogger.a.i("DoraCallQueryMonitor", "FlowLLMCommandReplyEvent cmd: " + r3 + ", param: " + r1.b);
        JSONObject r4 = new JSONObject();
        Map r5 = r1.b;
        if (r5 == null) goto L14;
        Iterator r6 = r5.entrySet().iterator();
    L11:
        if (r6.hasNext() == false) goto L14;
        Map.Entry r7 = (Map.Entry) r6.next();
        r4.putOpt((String) r7.getKey(), r7.getValue());
    L14:
        if (r3 != 8) goto L16;
        Map r8 = r1.b;
        if (r8 == null) goto L48;
        final String r12 = (String) r8.get("tea_tags_intent");
        if (r12 == null) goto L48;
        if (com.larus.utils.o0.d(r12) == false) goto L48;
        com.larus.utils.l0.b(new r(r12, this));
        goto L48
    L16:
        if (r3 != 1000) goto L48;
        Gson r13 = ha8.a.a;
        DoraTraceParam r14 = (DoraTraceParam) ha8.a.a(r4.toString(), DoraTraceParam.class);
        if (r14 == null) goto L48;
        FLogger.a.i("DoraCallQueryMonitor", "received FlowLLMCommandReplyEvent DORA_TRACE: " + r14);
        String r15 = r14.getTraceTime();
        if (Intrinsics.areEqual(r15, "query") == false) goto L31;
        String r16 = r14.getQueryInfo();
        if (r16 == null) goto L48;
        DoraTraceParam.a r17 = (DoraTraceParam.a) ha8.a.a(r16, DoraTraceParam.a.class);
        if (r17 == null) goto L48;
        DoraETracer.DoraEMessageType.a r18 = DoraETracer.DoraEMessageType.Companion;
        Integer r19 = r17.c();
        r18.getClass();
        ((com.larus.voicecall.impl.tracer.j) this).H = DoraETracer.DoraEMessageType.a.a(r19);
        goto L48
    L31:
        if (Intrinsics.areEqual(r15, ChatDraftItem.TYPE_REPLY) == false) goto L48;
        String r20 = r14.getReplyInfo();
        if (r20 == null) goto L48;
        DoraTraceParam.b r21 = (DoraTraceParam.b) ha8.a.a(r20, DoraTraceParam.b.class);
        if (r21 == null) goto L48;
        if (r21.l() == null) goto L48;
        this.Q = r21.h();
        this.P = (r21.i() - r21.h()) - r21.m();
    L48:
        r0.add(r1);
        goto L4
    }

    public final void g(pf9.q r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void h(pf9.z r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void i(pf9.a0 r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r8, "event");
        long r0 = r8.i;
        Long r2 = r8.b;
        long r3 = 0;
        if (r2 == null) goto L5;
        long r5 = r2.longValue();
    L7:
        if (r0 > 0) goto L9;
    L11:
        long r6 = -1;
    L12:
        this.L = r6;
        Long r9 = r8.b;
        if (r9 == null) goto L15;
        r3 = r9.longValue();
    L15:
        this.K = r3;
        return;
    L9:
        if (r5 <= 0) goto L11;
        r6 = r5 - r0;
        goto L12
    L5:
        r5 = 0;
        goto L7
    }

    public final void j(pf9.c0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void k(pf9.d0 r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r2, "event");
    }

    public final void l(pf9.e0 r8) {
        Intrinsics.checkNotNullParameter(r8, "event");
        Intrinsics.checkNotNullParameter(r8, "event");
        com.larus.voicecall.impl.tracer.j.q(this, 0, 0, null, "reply_end", 6);
    }

    public final void m(pf9.f0 r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r10, "event");
        long r1 = -1;
        if (this.T == true) goto L26;
        if (pf9.i.d(r10) == false) goto L26;
        pf9.k0 r0 = r10.b;
        if (r0 == null) goto L9;
        String r2 = r0.a;
    L11:
        if (com.larus.utils.o0.d(r2) == false) goto L26;
        this.T = true;
        pf9.k0 r3 = r10.b;
        if (r3 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        this.M = Boolean.valueOf(r4);
        pf9.k0 r5 = r10.b;
        if (r5 == null) goto L23;
        Long r6 = r5.h;
        if (r6 == null) goto L23;
        long r7 = r6.longValue();
    L24:
        this.Q = r7;
    L23:
        r7 = -1;
        goto L24
    L15:
        if (r3.m != true) goto L17;
        r4 = true;
        goto L18
    L9:
        r2 = null;
    L26:
        if (this.U == false) goto L28;
        return;
    L28:
        if (pf9.i.j(r10) == false) goto L48;
        this.U = true;
        this.N = System.currentTimeMillis();
        pf9.m r11 = r10.c;
        if (r11 == null) goto L32;
        long r8 = r11.d;
    L33:
        if (r11 == null) goto L35;
        long r9 = r11.e;
    L37:
        if (r8 > 0) goto L39;
    L41:
        long r12 = -1;
    L42:
        this.R = r12;
        this.P = r12 - this.Q;
        if (r11 == null) goto L45;
        r1 = r11.b;
    L45:
        this.S = r1;
        return;
    L39:
        if (r9 <= 0) goto L41;
        r12 = r9 - r8;
        goto L42
    L35:
        r9 = 0;
        goto L37
    L32:
        r8 = 0;
        goto L33
    }

    public t(com.larus.audio.call.arch.c r2, String r3, boolean r4, w r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "questionId");
        Intrinsics.checkNotNullParameter(r5, "currentConnectValid");
        super(r2, r3, r4, r5);
        this.K = -1;
        this.L = -1;
        this.P = -1;
        this.Q = -1;
        this.R = -1;
        this.S = -1;
    }

    public final void p(final int r8, final int r9, final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r10, "agentIntention");
        Intrinsics.checkNotNullParameter(r11, "scene");
        com.larus.utils.l0.b(new s(r11, r8, this, r9, r10));
    }
}
