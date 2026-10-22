package com.larus.avlink.plugins;

import android.os.SystemClock;
import com.google.gson.Gson;
import com.larus.audio.bean.AppeaseType;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.dora.DoraEMessageType;
import com.larus.audio.call.play.abs.TtsPlayEndType;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.avlink.DoraRealtimeCallTracer;
import com.larus.avlink.dora.DoraType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.DoraTraceParam;
import com.larus.voicecall.impl.tracer.CommonCallSessionMonitor;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class x extends CommonCallSessionMonitor<n4> implements v4, o4 {
    public long U;
    public boolean V;
    public boolean W;
    public String X;
    public String Y;
    public final Lazy Z;
    public final Lazy a0;
    public boolean b0;
    public String c0;
    public String d0;
    public String e0;
    public final b f0;

    public static final class a {
    }

    public static final class b extends com.larus.audio.call.play.e {
        public final /* synthetic */ x a;

        public final void c() {
            com.larus.voicecall.impl.tracer.j r0 = ((CommonCallSessionMonitor) this.a).n;
            if (r0 == null) goto L6;
            r0.n();
            return;
        }

        public b(x r1) {
            this.a = r1;
        }

        public final void f(TtsPlayEndType r2) {
            Intrinsics.checkNotNullParameter(r2, "endType");
            com.larus.voicecall.impl.tracer.j r3 = ((CommonCallSessionMonitor) this.a).n;
            if (r3 == null) goto L6;
            r3.o();
            return;
        }
    }

    static {
    }

    @Override // com.larus.avlink.plugins.v4
    public final void u2() {
        v3(true);
    }

    @Override // com.larus.avlink.plugins.v4
    public final void X() {
        ((n4) getContext()).k().p0(((n4) getContext()).params(), IRealtimeCallTracer.EnterCallSessionStatus.TASK_STARTED, ((n4) getContext()).params().p.j, 0, "", null);
    }

    public final void e3() {
        this.U = SystemClock.elapsedRealtime();
        super.e3();
        if (v88.a.b(Integer.valueOf(((n4) getContext()).q())) == false) goto L6;
        RealtimeCallUtil.a.getClass();
        RealtimeCallUtil.G = false;
        return;
    }

    @Override // com.larus.avlink.plugins.v4
    public final u68.a.b D() {
        return this.f0;
    }

    public x(final n4 r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.W = true;
        this.Z = LazyKt.lazy(new u(r2));
        this.a0 = LazyKt.lazy(new v(r2));
        this.f0 = new b(this);
    }

    @Override // com.larus.avlink.plugins.o4
    public final void Q0(int r1) {
        this.b0 = false;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.avlink.plugins.w] */
    public final com.larus.voicecall.impl.tracer.j k3(String r5) {
        Intrinsics.checkNotNullParameter(r5, "questionId");
        com.larus.audio.call.arch.c r1 = getContext();
        l4 r2 = (l4) this.a0.getValue();
        if (r2 == null) goto L5;
        boolean r3 = r2.d1();
    L7:
        return new t(r1, r5, r3, new w(this));
    L5:
        r3 = false;
        goto L7
    }

    public final Map<String, String> m3(String r6) {
        LinkedHashMap r0 = new LinkedHashMap();
        if (r6 == null) goto L14;
        if (Intrinsics.areEqual(r6, this.c0) == false) goto L14;
        String r2 = this.d0;
        if (r2 == null) goto L9;
        String r3 = (String) r0.put("deep_research_id", r2);
    L9:
        String r4 = this.e0;
        if (r4 == null) goto L12;
        String r5 = (String) r0.put("deep_research_phase", r4);
    L12:
        FLogger.a.i(((CommonCallSessionMonitor) this).f, "getResearchExtra for messageId: " + r6 + ", returning cached researchId: " + this.d0 + ", researchPhase: " + this.e0);
    L16:
        return r0;
    L14:
        if (this.c0 == null) goto L16;
        FLogger.a.i(((CommonCallSessionMonitor) this).f, "getResearchExtra for messageId: " + r6 + ", cached messageId: " + this.c0 + " doesn't match, clearing cache");
        this.c0 = null;
        this.d0 = null;
        this.e0 = null;
        goto L16
    }

    public final void p3(pf9.q r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        super.p3(r10);
        Iterator r11 = r10.a.iterator();
    L4:
        if (r11.hasNext() == false) goto L125;
        pf9.p r0 = (pf9.p) r11.next();
        Long r1 = r0.a;
        if (r1 == null) goto L4;
        int r2 = (int) r1.longValue();
        JSONObject r3 = new JSONObject();
        Map r4 = r0.b;
        if (r4 == null) goto L13;
        Iterator r5 = r4.entrySet().iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        Map.Entry r6 = (Map.Entry) r5.next();
        r3.putOpt((String) r6.getKey(), r6.getValue());
    L13:
        boolean r7 = false;
        if (r2 != 8) goto L15;
        Map r8 = r0.b;
        if (r8 == null) goto L115;
        String r9 = (String) r8.get("is_pacity");
        if (r9 == null) goto L115;
        new JSONObject().put("is_pacity", "1");
        if (Intrinsics.areEqual(r9, "1") == false) goto L115;
        if (this.W == false) goto L115;
        this.W = false;
        IRealtimeCallTracer r12 = ((n4) getContext()).k();
        RealtimeCallParam r13 = ((n4) getContext()).params();
        if (v88.a.f(Integer.valueOf(((n4) getContext()).params().k.s)) == false) goto L113;
        DoraType r14 = DoraType.DORA_RADIO;
    L114:
        r12.N(r13, r14.getValue(), AppeaseType.PEOPLE.getScene());
        goto L115
    L113:
        r14 = DoraType.DORA;
    L115:
        Map r15 = r0.b;
        if (r15 == null) goto L120;
        String r16 = (String) r15.get("tea_tags_time_cost");
        if (r16 == null) goto L120;
        this.X = r16;
    L120:
        Map r17 = r0.b;
        if (r17 == null) goto L4;
        String r18 = (String) r17.get("fpa_common_param");
        if (r18 == null) goto L4;
        this.Y = r18;
        goto L4
    L15:
        String r19 = null;
        String r20 = null;
        r20 = null;
        Object r21 = null;
        if (r2 != 13) goto L18;
        Result.Companion r22 = Result.Companion;     // Catch: Throwable -> L91
        String r23 = this.X;     // Catch: Throwable -> L91
        if (r23 == null) goto L83;
        JSONObject r24 = com.larus.utils.p0.b(r23);     // Catch: Throwable -> L91
        if (r24 == null) goto L83;
        String r25 = r24.optString("agent_intention");     // Catch: Throwable -> L91
    L84:
        if (r25 != null) goto L100;
        String r26 = this.Y;     // Catch: Throwable -> L91
        if (r26 == null) goto L90;
        JSONObject r27 = com.larus.utils.p0.b(r26);     // Catch: Throwable -> L91
        if (r27 == null) goto L90;
        r20 = r27.optString("agent_intention");     // Catch: Throwable -> L91
    L90:
        r25 = r20;
    L100:
        ((n4) getContext()).k().A(((n4) getContext()).params(), ((CommonCallSessionMonitor) this).z, ((CommonCallSessionMonitor) this).A, r25);
    L83:
        r25 = null;
    L91:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        Object r29 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r30 = Result.exceptionOrNull-impl(r29);
        if (r30 == null) goto L96;
        com.larus.avlink.n1.b(((CommonCallSessionMonitor) this).f, r30.getMessage());
    L96:
        if (Result.isFailure-impl(r29) == true) goto L99;
        r21 = r29;
    L99:
        r25 = (String) r21;
        goto L100
    L18:
        if (r2 != 1000) goto L4;
        JSONObject r31 = new JSONObject();
        Map r32 = r0.b;
        if (r32 == null) goto L26;
        Iterator r33 = r32.entrySet().iterator();
    L24:
        if (r33.hasNext() == false) goto L26;
        Map.Entry r34 = (Map.Entry) r33.next();
        r31.putOpt((String) r34.getKey(), r34.getValue());
    L26:
        String r35 = r31.toString();
        Gson r36 = ha8.a.a;
        DoraTraceParam r37 = (DoraTraceParam) ha8.a.a(r35, DoraTraceParam.class);
        if (r37 == null) goto L4;
        FLogger r38 = FLogger.a;
        r38.i(((CommonCallSessionMonitor) this).f, "received FlowLLMCommandReplyEvent DORA_TRACE: " + r35);
        String r39 = r37.getTraceTime();
        if (Intrinsics.areEqual(r39, "query") == true) goto L31;
        if (Intrinsics.areEqual(r39, ChatDraftItem.TYPE_REPLY) == false) goto L4;
        String r40 = r37.getReplyInfo();
        if (r40 == null) goto L4;
        DoraTraceParam.b r41 = (DoraTraceParam.b) ha8.a.a(r40, DoraTraceParam.b.class);
        if (r41 == null) goto L4;
        String r42 = r41.l();
        if (r42 == null) goto L4;
        this.c0 = r42;
        List r43 = r41.n();
        if (r43 == null) goto L72;
        String r44 = (String) CollectionsKt.firstOrNull(r43);
    L73:
        this.d0 = r44;
        List r45 = r41.o();
        if (r45 == null) goto L76;
        r19 = (String) CollectionsKt.firstOrNull(r45);
    L76:
        this.e0 = r19;
        r38.i(((CommonCallSessionMonitor) this).f, "Cached deep research data for messageId: " + r42 + ", researchId: " + this.d0 + ", researchPhase: " + this.e0);
        goto L4
    L72:
        r44 = null;
        goto L73
    L31:
        String r46 = r37.getQueryInfo();
        if (r46 == null) goto L4;
        DoraTraceParam.a r47 = (DoraTraceParam.a) ha8.a.a(r46, DoraTraceParam.a.class);
        if (r47 == null) goto L4;
        String r48 = r47.a();
        if (r48 != null) goto L40;
    L41:
        r7 = true;
    L42:
        if (r7 == false) goto L44;
        r48 = r47.b();
    L44:
        String r49 = (String) this.Z.getValue();
        String r50 = "";
        if (r48 != null) goto L47;
        r48 = "";
    L47:
        Integer r51 = r47.c();
        String r52 = r47.d();
        String r53 = r47.e();
        LinkedHashMap r54 = new LinkedHashMap();
        r54.put("scene", r49);
        r54.put("conversation_id", ((n4) getContext()).params().G);
        r54.put("bot_id", ((n4) getContext()).params().o.h);
        r54.put("message_id", r48);
        r54.put("chat_type", "default");
        r54.put("success", 1);
        r54.put("dora_message_affiliation", "dora_e");
        DoraEMessageType.Companion.getClass();
        String r55 = DoraEMessageType.a.a(r51);
        if (r55 == null) goto L51;
        r50 = r55;
    L51:
        r54.put("dora_message_type", r50);
        if (r52 == null) goto L54;
        r54.put("deep_research_id", r52);
    L54:
        if (r53 == null) goto L56;
        r54.put("deep_research_phase", r53);
    L56:
        r54.put("dora_message_mode", y.a(((n4) getContext()).params()));
        IDoraService r56 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r56 == null) goto L4;
        r56.A0("dora_send_message_update", r54);
        goto L4
    L40:
        if (r48.length() != 0) goto L42;
    }

    public final void v3(boolean r11) {
        super.v3(r11);
        if (this.V == false) goto L5;
        return;
    L5:
        this.V = true;
        long r2 = 0;
        if (this.U <= 0) goto L8;
        long r8 = SystemClock.elapsedRealtime() - this.U;
    L9:
        DoraRealtimeCallTracer r12 = ((n4) getContext()).k();
        if ((r12 instanceof DoraRealtimeCallTracer) == false) goto L12;
        DoraRealtimeCallTracer r13 = r12;
    L13:
        if (r13 == null) goto L20;
        RealtimeCallParam r5 = ((n4) getContext()).params();
        if (r5 == null) goto L17;
        r2 = System.currentTimeMillis() - r5.c;
    L17:
        Map r0 = r13.w0(r5, r2, r8);
        IDoraService r14 = r13.A0();
        if (r14 == null) goto L20;
        r14.A0("flow_dora_session_start", r0);
    L20:
        ((n4) getContext()).k().onSessionStarted();
        return;
    L12:
        r13 = null;
        goto L13
    L8:
        r8 = 0;
        goto L9
    }

    public final void q3(pf9.a0 r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        super.q3(r2, r3);
        this.W = true;
    }

    @Override // com.larus.avlink.plugins.o4
    public final void i0(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "caller");
        Intrinsics.checkNotNullParameter(r1, "caller");
        this.b0 = true;
    }

    public final void u3(int r9, String r10, long r11, int r13, String r14, String r15) {
        super.u3(r9, r10, r11, r13, r14, r15);
        DoraRealtimeCallTracer r0 = ((n4) getContext()).k();
        if ((r0 instanceof DoraRealtimeCallTracer) == false) goto L5;
        DoraRealtimeCallTracer r1 = r0;
    L6:
        DoraRealtimeCallTracer r2 = r1;
        if (r2 == null) goto L15;
        RealtimeCallParam r6 = ((n4) getContext()).params();
        JSONObject r7 = new JSONObject();
        r7.putOpt("current_stage", Integer.valueOf(this.b0 ? 1 : 0));
        r7.put("sub_error_code", r13);
        if (r14 == null) goto L11;
        r7.put("sub_error_msg", r14);
    L11:
        if (r15 == null) goto L13;
        r7.put("sub_extra_info", r15);
    L13:
        r2.C0(r9, r10, r11, r6, r7);
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
