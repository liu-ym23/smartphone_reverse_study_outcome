package com.larus.avlink.plugins;

import android.os.SystemClock;
import com.google.gson.Gson;
import com.larus.audio.bean.AppeaseType;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.dora.DoraEMessageType;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.play.abs.TtsPlayEndType;
import com.larus.avlink.dora.DoraType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.dora.api.IDoraService;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.DataType;
import com.larus.im.service.audio.cmd.ReplyStage;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.l;
import com.larus.trace.tracespan.span.SpanWrapImpl;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.bean.DoraTraceParam;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class DoraIsolatedCallSessionMonitor extends com.larus.audio.call.arch.a<n4> implements u4, com.larus.im.service.audio.v, o4 {
    public long A;
    public long B;
    public long C;
    public int D;
    public final Map<String, Object> E;
    public final Map<String, Object> F;
    public final com.larus.audio.call.play.j G;
    public boolean H;
    public String I;
    public String J;
    public final Lazy K;
    public String L;
    public String M;
    public String N;
    public final f O;
    public boolean P;
    public int Q;
    public String R;
    public String S;
    public String T;
    public long U;
    public long V;
    public boolean W;
    public boolean X;
    public String Y;
    public String Z;
    public boolean a0;
    public int b0;
    public Job c0;
    public String d0;
    public boolean e0;
    public final String f;
    public boolean f0;
    public final String g;
    public boolean g0;
    public DoraIsolatedEnterCallSessionStatus h;
    public final c h0;
    public jd9.c i;
    public final e i0;
    public long j;
    public long k;
    public boolean l;
    public volatile boolean m;
    public volatile boolean n;
    public o1 o;
    public long p;
    public int q;
    public int r;
    public long s;
    public String t;
    public int u;
    public int v;
    public boolean w;
    public boolean x;
    public boolean y;
    public long z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/avlink/plugins/DoraIsolatedCallSessionMonitor$ProactiveIndexType;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "PROMPT", "RESPONSE", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    public static final enum ProactiveIndexType extends Enum<ProactiveIndexType> {
        public static final ProactiveIndexType NONE = null;
        public static final ProactiveIndexType PROMPT = null;
        public static final ProactiveIndexType RESPONSE = null;
        public static final /* synthetic */ ProactiveIndexType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<ProactiveIndexType> getEntries() {
            return b;
        }

        static {
            ProactiveIndexType r0 = new ProactiveIndexType("NONE", 0);
            NONE = r0;
            ProactiveIndexType r1 = new ProactiveIndexType("PROMPT", 1);
            PROMPT = r1;
            ProactiveIndexType r3 = new ProactiveIndexType("RESPONSE", 2);
            RESPONSE = r3;
            ProactiveIndexType[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static ProactiveIndexType[] values() {
            return (ProactiveIndexType[]) a.clone();
        }

        public static ProactiveIndexType valueOf(String r1) {
            return (ProactiveIndexType) r27.a.a(ProactiveIndexType.class, r1);
        }

        public ProactiveIndexType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ProactiveIndexType.values().length];
            r0[ProactiveIndexType.PROMPT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ProactiveIndexType.RESPONSE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ProactiveIndexType.NONE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public static final class c extends com.larus.audio.call.play.e {
        public final /* synthetic */ DoraIsolatedCallSessionMonitor a;
        public final /* synthetic */ n4 b;

        public final void a() {
            int r0 = c68.b.a;
            c68.b.a(this.a.f, "onTTSEnded");
            DoraIsolatedCallSessionMonitor r1 = this.a;
            if (r1.f0 == false) goto L8;
            r1.f0 = false;
            if (r1.e0 == false) goto L9;
            r1.e0 = false;
            return;
        L9:
            return;
        }

        public final void c() {
            int r0 = c68.b.a;
            c68.b.a(this.a.f, "onPlayFirstFrame");
            this.a.f0 = true;
            SystemClock.elapsedRealtime();
            DoraIsolatedCallSessionMonitor r1 = this.a;
            r1.U = System.currentTimeMillis();
        }

        public final void onPlayComplete() {
            int r0 = c68.b.a;
            c68.b.a(this.a.f, "onPlayComplete");
            MajorState.d r1 = this.b.a().s1();
            DoraIsolatedCallSessionMonitor r2 = this.a;
            if (r2.W == true) goto L5;
        L9:
            RealtimeCallUtil.a.getClass();
            String r3 = RealtimeCallUtil.g();
            DoraIsolatedCallSessionMonitor r4 = this.a;
            r2.y3(r3, r4.G.a, r4.X, r4.W, r4.P, r4.U, System.currentTimeMillis(), this.a.d0, "response");
            return;
        L5:
            if ((r1 instanceof MajorState.d) == false) goto L9;
            if (r1.d != MajorState.InterruptType.NOTHING) goto L9;
            r2.X = true;
            goto L9
        }

        public c(DoraIsolatedCallSessionMonitor r1, n4 r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class d implements com.larus.im.service.audio.x {
        public final String a;
        public final DataType b;
        public final /* synthetic */ DoraIsolatedCallSessionMonitor c;

        public final String getName() {
            return this.a;
        }

        public DataType getType() {
            return this.b;
        }

        public d(DoraIsolatedCallSessionMonitor r1) {
            this.c = r1;
            this.a = r1.f;
            this.b = DataType.PLAYER;
        }

        public final void a(l r4) {
            Intrinsics.checkNotNullParameter(r4, "frame");
            o1 r0 = this.c.o;
            if (r0 == null) goto L6;
            int r5 = r4.a.length;
            int r1 = r0.z;
            int r2 = c4a.a.a;
            r0.z = r1 + ((int) (((r5 / 24000) / 2) * 1000));
            return;
        }
    }

    public static final class e extends com.larus.im.service.audio.a1 {
        public final String a;
        public String b;
        public String c;
        public final /* synthetic */ DoraIsolatedCallSessionMonitor d;
        public final /* synthetic */ n4 e;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TriggerMode.values().length];
                r0[TriggerMode.CLIM_IN_STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[TriggerMode.CLIM_IN_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                a = r0;
            }
        }

        public final String g() {
            return this.a;
        }

        public final void n(com.larus.im.service.audio.z0.a r28) {
            String r2 = "event";
            Intrinsics.checkNotNullParameter(r28, "event");
            String r4 = "";
            if ((r28 instanceof pf9.o) == false) goto L9;
            DoraIsolatedCallSessionMonitor r3 = this.d;
            if (r3.o != null) goto L7;
            r3.o = r3.q3("");
        L7:
            this.d.D3(((pf9.o) r28).j);
            return;
        L9:
            if ((r28 instanceof pf9.o0) == false) goto L12;
            this.d.D3(((pf9.o0) r28).b);
            return;
        L12:
            if ((r28 instanceof pf9.i0) == false) goto L15;
            this.d.C3("");
            return;
        L15:
            if ((r28 instanceof pf9.z) == false) goto L33;
            if (this.d.o == null) goto L19;
            Intrinsics.checkNotNullParameter((pf9.z) r28, "event");
        L19:
            this.d.getClass();
            RealtimeCallUtil.a.getClass();
            if (RealtimeCallUtil.v == false) goto L24;
            MajorState.d r5 = this.e.a().s1();
            if ((r5 instanceof MajorState.d) == false) goto L24;
            yp9.d r6 = yp9.d.b;
            String r7 = this.d.f;
            StringBuilder r8 = new StringBuilder("listening,from:");
            MajorState.d r9 = r5;
            r8.append(r9.c);
            r8.append(",interruptType:");
            r8.append(r9.d);
            r6.a(r7, r8.toString());
        L24:
            DoraIsolatedCallSessionMonitor r10 = this.d;
            pf9.z r1 = (pf9.z) r28;
            String r11 = r1.a;
            if (r11 == null) goto L28;
            r4 = r11;
        L28:
            r10.S = r4;
            r10.C3(r4);
            final o1 r12 = this.d.o;
            if (r12 == null) goto L31;
            Intrinsics.checkNotNullParameter(r1, "event");
            r12.i = System.currentTimeMillis();
            r12.j = r1.d;
            com.larus.utils.l0.b(new h1(r12));
        L31:
            this.b = r1.b;
            this.d.a0 = true;
            return;
        L33:
            if ((r28 instanceof pf9.c0) == true) goto L35;
            String r13 = "dora_mode";
            if ((r28 instanceof pf9.a0) == false) goto L199;
            o1 r14 = this.d.o;
            if (r14 == null) goto L79;
            pf9.a0 r15 = (pf9.a0) r28;
            Intrinsics.checkNotNullParameter(r15, "event");
            long r16 = r15.i;
            Long r17 = r15.b;
            if (r17 == null) goto L66;
            long r21 = r17.longValue();
        L67:
            int r18 = o1.S;
            if (r16 > 0) goto L70;
        L72:
            long r19 = -1;
        L73:
            r14.F = r19;
            Long r20 = r15.b;
            if (r20 == null) goto L76;
            long r110 = r20.longValue();
        L77:
            r14.E = r110;
            goto L79
        L76:
            r110 = 0;
            goto L77
        L70:
            if (r21 <= 0) goto L72;
            r19 = r21 - r16;
            goto L73
        L66:
            r21 = 0;
        L79:
            DoraIsolatedCallSessionMonitor r22 = this.d;
            pf9.a0 r23 = (pf9.a0) r28;
            r22.Y = null;
            r22.Z = null;
            r22.I = null;
            r22.J = null;
            com.larus.audio.call.play.j r24 = r22.G;
            r24.a = 0;
            r24.b = 0;
            r22.P = false;
            if (r22.o != null) goto L82;
            r22.o = r22.q3("");
        L82:
            RealtimeCallParam r25 = ((n4) r22.getContext()).params();
            int r26 = (int) r23.a;
            Long r27 = r23.b;
            if (r27 == null) goto L85;
            long r111 = r27.longValue();
        L86:
            boolean r29 = r23.c;
            String r0 = r22.S;
            Integer r112 = StringsKt.toIntOrNull(r22.d0);
            if (r112 == null) goto L89;
            Integer.valueOf(r112.intValue() + 1).getClass();
        L89:
            Intrinsics.checkNotNullParameter(r25, "params");
            r22.z = System.currentTimeMillis();
            if (r29 == true) goto L165;
            r22.C = r111;
            if (r26 <= 0) goto L95;
        L97:
            LinkedHashMap r30 = new LinkedHashMap();
            r30.put("is_mentioned", "0");
            r30.put("group_type", "private");
            r30.put("previous_page", r25.p.b);
            r30.put("current_page", r25.p.d);
            r30.put("bot_id", r25.o.h);
            r30.put("item_id", r25.o.h);
            r30.put("conversation_id", r25.l.c);
            r30.put("message_type", ChatDraftItem.TYPE_TEXT);
            r30.put("voice_id", r25.o.f);
            r30.put("speaker_id", r25.o.d);
            r30.put("speaker_name", r25.o.g);
            r30.put("dora_mode", r25.k.t);
            r30.put("success", 1);
            String r31 = r25.p.e;
            if (r31 == null) goto L100;
            r30.put("recommend_from", r31);
        L100:
            String r32 = r25.p.f;
            if (r32 == null) goto L103;
            r30.put("req_id", r32);
        L103:
            String r33 = r25.p.g;
            if (r33 == null) goto L106;
            r30.put("chat_type", r33);
        L106:
            RealtimeCallParam.n r34 = r25.p.h;
            if (r34 == null) goto L111;
            String r35 = r34.a;
            if (r35 == null) goto L111;
            r30.put("query", r35);
        L111:
            RealtimeCallParam.n r36 = r25.p.h;
            if (r36 == null) goto L116;
            String r37 = r36.b;
            if (r37 == null) goto L116;
            r30.put("query_id", r37);
        L116:
            RealtimeCallParam.n r38 = r25.p.h;
            if (r38 == null) goto L121;
            String r39 = r38.c;
            if (r39 == null) goto L121;
            r30.put("search_id", r39);
        L121:
            RealtimeCallParam.n r40 = r25.p.h;
            if (r40 == null) goto L126;
            String r41 = r40.d;
            if (r41 == null) goto L126;
            r30.put("search_request_id", r41);
        L126:
            RealtimeCallParam.n r42 = r25.p.h;
            if (r42 == null) goto L131;
            String r43 = r42.e;
            if (r43 == null) goto L131;
            r30.put("search_result_id", r43);
        L131:
            RealtimeCallParam.n r44 = r25.p.h;
            if (r44 == null) goto L136;
            String r45 = r44.f;
            if (r45 == null) goto L136;
            r30.put("rank", r45);
        L136:
            String r46 = r25.p.k;
            if (r46 == null) goto L139;
            r30.put("sec_scene", r46);
        L139:
            String r47 = r25.p.l;
            if (r47 == null) goto L142;
            r30.put("from_activity_name", r47);
        L142:
            String r48 = r25.p.m;
            if (r48 == null) goto L146;
            r30.put("from_activity_module", r48);
        L146:
            if (Intrinsics.areEqual(r25.l.r, "1") == false) goto L155;
            String r49 = r25.p.k;
            if (Intrinsics.areEqual(r49, "dora_new_onboarding_voicewakeup_example") == false) goto L150;
        L153:
            r30.put("sec_scene", r49);
        L157:
            if (r0 == null) goto L159;
            r30.put("message_id", r0);
            r22.t = r0;
        L159:
            r30.put("dora_message_mode", y.a(r25));
            r22.p3(r30, r25);
            r30.put("dora_mode", r25.k.t);
            r22.l3(r30, r25, ProactiveIndexType.PROMPT);
            IDoraService r50 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r50 == null) goto L162;
            r50.A0("send_message", r30);
        L162:
            IDoraService r51 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r51 == null) goto L165;
            r51.A0("send_message_status", r30);
            goto L165
        L150:
            if (Intrinsics.areEqual(r49, "dora_new_onboarding_voicewakeup_continue") == true) goto L153;
            r49 = "dora_onboarding";
            goto L153
        L155:
            if (r25.p.R == false) goto L157;
            r30.put("sec_scene", "dora_natural_wakeup");
            goto L157
        L95:
            if (Intrinsics.areEqual(r25.k.o, "dora_half_duplex") == true) goto L97;
        L165:
            o1 r52 = r22.o;
            if (r52 == null) goto L191;
            Integer r53 = StringsKt.toIntOrNull(r22.d0);
            if (r53 == null) goto L170;
            Integer.valueOf(r53.intValue() + 1).getClass();
        L170:
            pf9.a0 r54 = r23;
            Intrinsics.checkNotNullParameter(r54, "asrEndData");
            r52.D = null;
            r52.q = false;
            r52.h = System.currentTimeMillis();
            Long r55 = r54.b;
            if (r55 == null) goto L173;
            long r56 = 0;
            RangesKt.coerceAtLeast(r55.longValue(), 0);
        L174:
            long r57 = r54.a;
            boolean r58 = r54.c;
            if (r58 == false) goto L177;
        L180:
            if (r58 == true) goto L182;
        L184:
            boolean r59 = false;
        L185:
            r52.v = r59;
            if (r52.B == false) goto L189;
            r52.w = 0;
            r52.x = 0;
        L189:
            if (((Boolean) r52.d.invoke()).booleanValue() == false) goto L192;
            com.larus.utils.l0.b(new g1(r52, r52.w, r52.v, false, r52.x));
            com.larus.audio.call.tracer.b.b(r52.a.i(), "asr_phase", null, 6);
            r52.a.i().f("llm_phase", "realcall_message");
            FLogger.a.i("DoraIsolatedCallQueryMonitor", "startExpResponseTimer timeoutDuration = 15000");
            q1 r60 = new q1(r52);
            r52.s = r60;
            r60.d();
            long r61 = 0;
            r52.A = 0;
        L194:
            if (r22.i.a == false) goto L198;
            long r62 = r54.a;
            if (r62 < r61) goto L198;
            r22.s += r62;
        L198:
            r22.H = true;
            return;
        L192:
            r61 = 0;
            goto L194
        L182:
            if (r54.d == false) goto L184;
        L183:
            r59 = true;
            goto L185
        L177:
            if (r57 > r56) goto L183;
            if (Intrinsics.areEqual(r52.e, "dora_radio") == true) goto L183;
        L173:
            r56 = 0;
            goto L174
        L191:
            r54 = r23;
            goto L192
        L85:
            r111 = 0;
            goto L86
        L199:
            String r63 = "realcall_message";
            String r64 = "tts_delay";
            if ((r28 instanceof pf9.d0) == false) goto L213;
            if (this.d.o == null) goto L204;
            Intrinsics.checkNotNullParameter((pf9.d0) r28, "event");
        L204:
            DoraIsolatedCallSessionMonitor r65 = this.d;
            pf9.d0 r66 = (pf9.d0) r28;
            boolean r67 = r66.b;
            if (r65.x == false) goto L207;
            r65.x = false;
            r65.A = System.currentTimeMillis();
        L207:
            o1 r68 = this.d.o;
            if (r68 == null) goto L493;
            Intrinsics.checkNotNullParameter(r66, "event");
            r68.C = Intrinsics.areEqual(r66.a, "v3");
            if (r68.m == false) goto L494;
            r68.m = false;
            com.larus.utils.l0.b(new j1(r68, 0, false));
            com.larus.audio.call.tracer.b.b(r68.a.i(), "llm_phase", null, 6);
            r68.a.i().f("tts_delay", r63);
            return;
        L494:
            return;
        L493:
            return;
        L213:
            if ((r28 instanceof pf9.q) == false) goto L219;
            if (this.d.o == null) goto L217;
            Intrinsics.checkNotNullParameter((pf9.q) r28, "event");
        L217:
            DoraIsolatedCallSessionMonitor.j3(this.d, (pf9.q) r28);
            return;
        L219:
            if ((r28 instanceof pf9.f0) == false) goto L447;
            o1 r69 = this.d.o;
            if (r69 == null) goto L269;
            pf9.f0 r113 = (pf9.f0) r28;
            Intrinsics.checkNotNullParameter(r113, "event");
            if (r69.N == false) goto L225;
        L245:
            r13 = "dora_mode";
            r63 = r63;
        L247:
            if (r69.O == false) goto L249;
        L268:
            r2 = "event";
            r64 = "tts_delay";
            r63 = r63;
        L270:
            pf9.f0 r70 = (pf9.f0) r28;
            String r71 = pf9.i.k(r70);
            if (r71.length() <= 0) goto L273;
            boolean r72 = true;
        L274:
            if (r72 == false) goto L285;
            if (Intrinsics.areEqual(this.d.T, r71) == true) goto L285;
            DoraIsolatedCallSessionMonitor r73 = this.d;
            r73.T = r71;
            r73.W = false;
            r73.X = false;
            RealtimeCallUtil r74 = RealtimeCallUtil.a;
            pf9.m r75 = r70.c;
            if (r75 == null) goto L282;
            Map r76 = r75.a;
            if (r76 == null) goto L282;
            String r77 = (String) r76.get("speech_hello_tech_type");
        L283:
            r74.getClass();
            RealtimeCallUtil.I = r77;
        L282:
            r77 = null;
        L285:
            if (pf9.i.j(r70) == false) goto L296;
            com.larus.audio.call.play.j r78 = this.d.G;
            r78.getClass();
            r78.b = System.currentTimeMillis();
            pf9.m r79 = r70.c;
            if (r79 == null) goto L291;
            Map r80 = r79.a;
            if (r80 == null) goto L291;
            String r81 = (String) r80.get("tts_content_scene");
        L293:
            if (Intrinsics.areEqual(r81, "pacify") == false) goto L296;
            this.d.P = true;
        L291:
            r81 = null;
        L296:
            if (pf9.i.c(r70) == false) goto L333;
            ReplyStage r82 = r70.d;
            if (r82 != ReplyStage.Begin) goto L300;
        L301:
            pf9.k0 r83 = r70.b;
            if (r83 == null) goto L319;
            String r84 = r83.f;
            if (r84 == null) goto L319;
            if (r84.length() <= 0) goto L308;
            boolean r85 = true;
        L309:
            if (r85 == true) goto L311;
        L313:
            boolean r86 = false;
        L314:
            if (r86 == true) goto L317;
            r84 = null;
        L317:
            if (r84 == null) goto L319;
            this.d.Y = r84;
            goto L319
        L311:
            if (Intrinsics.areEqual(r84, "0") == true) goto L313;
            r86 = true;
            goto L314
        L308:
            r85 = false;
        L319:
            ReplyStage r87 = r70.d;
            if (r87 != ReplyStage.Update) goto L331;
            DoraIsolatedCallSessionMonitor r88 = this.d;
            pf9.k0 r89 = r70.b;
            if (r89 == null) goto L326;
            Map r90 = r89.n;
            if (r90 == null) goto L326;
            String r91 = (String) r90.get("query_round");
        L327:
            if (r91 != null) goto L329;
            r91 = "";
        L329:
            r88.d0 = r91;
        L326:
            r91 = null;
            goto L327
        L331:
            if (r87 != ReplyStage.End) goto L333;
            DoraIsolatedCallSessionMonitor.k3(this.d);
            goto L333
        L300:
            if (r82 != ReplyStage.Update) goto L319;
        L333:
            DoraIsolatedCallSessionMonitor r92 = this.d;
            if (r92.i.a == false) goto L497;
            ReplyStage r93 = r70.d;
            ReplyStage r114 = ReplyStage.Update;
            String r115 = "mute";
            if (r93 == r114) goto L339;
            ReplyStage r210 = r114;
            r115 = "mute";
            String r116 = r64;
        L401:
            o1 r94 = this.d.o;
            if (r94 == null) goto L498;
            Intrinsics.checkNotNullParameter(r70, r2);
            if (r70.d == r210) goto L407;
            return;
        L407:
            if (pf9.i.c(r70) == false) goto L416;
            if (r70.b == null) goto L416;
            if (pf9.i.c(r70) == false) goto L416;
            if (r70.d != ReplyStage.End) goto L416;
            com.larus.utils.l0.b(new j1(r94, 1, false));
        L416:
            if (pf9.i.j(r70) == false) goto L444;
            pf9.m r95 = r70.c;
            if (r95 == null) goto L444;
            Map r96 = r95.a;
            if (r96 == null) goto L422;
            String r97 = (String) r96.get("tts_content_scene");
        L424:
            if (Intrinsics.areEqual(r97, "pacify") == false) goto L429;
            if (r94.l == false) goto L441;
            r94.l = false;
            com.larus.utils.l0.b(new n1(r94, 2));
        L441:
            if (r94.A <= 0) goto L444;
            r94.A = 0;
            goto L444
        L429:
            if (Intrinsics.areEqual(r97, r115) == true) goto L441;
            if (r94.k == false) goto L433;
            r94.k = false;
            com.larus.audio.call.tracer.b.b(r94.a.i(), r116, null, 6);
            com.larus.audio.call.tracer.b.b(r94.a.i(), r63, null, 6);
            r94.n = System.currentTimeMillis();
            r94.p = false;
            o1.e(r94, 0, -2, null, null, 12);
            com.larus.utils.l0.b(new n1(r94, 0));
            s1 r99 = new s1(r94);
            r94.u = r99;
            r99.d();
        L433:
            r1 r100 = r94.t;
            if (r100 == null) goto L436;
            r100.a();
        L436:
            r94.t = null;
            if (r94.r == true) goto L441;
            r1 r101 = new r1(r94);
            r94.t = r101;
            r101.d();
            goto L441
        L422:
            r97 = null;
        L444:
            if (r94.C == true) goto L499;
            r94.C = pf9.i.e(pf9.i.a(r70));
            return;
        L499:
            return;
        L498:
            return;
        L339:
            if (pf9.i.j(r70) == false) goto L379;
            RealtimeCallParam r102 = ((n4) r92.getContext()).params();
            com.larus.audio.call.arch.c r117 = r92.getContext();
            String r211 = "";
            Intrinsics.checkNotNullParameter(r117, "<this>");
            String r212 = r13;
            Long r103 = Long.valueOf(r117.b(Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.k.class), null).B2());
            String r118 = r92.Y;
            String r119 = r92.S;
            Intrinsics.checkNotNullParameter(r102, "params");
            r210 = r114;
            if (r92.y == true) goto L343;
        L357:
            r116 = r64;
            r92.w = true;
        L358:
            pf9.m r104 = r70.c;
            if (r104 == null) goto L363;
            Map r105 = r104.a;
            if (r105 == null) goto L363;
            String r106 = (String) r105.get("tts_content_scene");
        L365:
            if (Intrinsics.areEqual(r106, r115) == false) goto L371;
            String r107 = AppeaseType.PEOPLE.getScene();
            o1 r108 = r92.o;
            if (r108 == null) goto L369;
            int r109 = r108.z;
        L370:
            r92.v3(r107, r109);
        L381:
            if (pf9.i.c(r70) == false) goto L401;
            pf9.k0 r120 = r70.b;
            if (r120 == null) goto L385;
            String r121 = r120.a;
        L386:
            if (r121 != null) goto L388;
            r121 = r211;
        L388:
            if (r120 == null) goto L392;
            Map r122 = r120.n;
            if (r122 == null) goto L392;
            String r123 = (String) r122.get("agent_intention");
        L393:
            if (r123 != null) goto L395;
            r123 = r211;
        L395:
            Intrinsics.checkNotNullParameter(r121, "txt");
            Intrinsics.checkNotNullParameter(r123, "serverParamJson");
            if (r123.length() <= 0) goto L398;
            boolean r124 = true;
        L399:
            if (r124 == false) goto L401;
            r92.D3(r123);
            goto L401
        L398:
            r124 = false;
        L392:
            r123 = null;
            goto L393
        L385:
            r121 = null;
            goto L386
        L369:
            r109 = 0;
            goto L370
        L371:
            o1 r125 = r92.o;
            if (r125 == null) goto L381;
            if (r125.A > 0) goto L376;
            Integer r126 = null;
        L377:
            if (r126 == null) goto L381;
            r92.v3(AppeaseType.VOICE.getScene(), r126.intValue());
            goto L381
        L376:
            int r127 = (int) (System.currentTimeMillis() - r125.A);
            r125.A = 0;
            r126 = Integer.valueOf(r127);
        L363:
            r106 = null;
            goto L365
        L343:
            if (r92.z == (-1)) goto L357;
            r92.y = false;
            r92.B = System.currentTimeMillis();
            r92.r++;
            LinkedHashMap r128 = new LinkedHashMap();
            r128.put("reply_id", r118);
            r128.put("query_id", r119);
            r128.put("asr_tail", Long.valueOf(r92.C));
            r128.put("bot_id", r102.o.h);
            r128.put("call_id", r102.e);
            r128.put("conversation_id", r102.l.c);
            r128.put("llm", Long.valueOf(r92.A - r92.z));
            r128.put("task_id", r102.l.a);
            r116 = r64;
            r128.put(r116, Long.valueOf(r92.B - r92.A));
            r128.put("total", Long.valueOf(r92.B - r92.z));
            r128.put("appease_play_duration", r103);
            if (ia8.e.b().d() == false) goto L348;
            AppeaseType r129 = AppeaseType.VOICE;
        L349:
            r128.put("comfort_scene", r129.getScene());
            r128.put("is_mock_chat", 0L);
            r128.put("llm_model", r102.i);
            r128.put("user_interrupt", Long.valueOf(r102.l.h));
            if (r102.l.m == false) goto L352;
            long r130 = 1;
        L353:
            r128.put("pre_query", Long.valueOf(r130));
            r128.put("voice_style", r102.o.d);
            r128.put("if_proactive", Long.valueOf(r92.D));
            r128.put("is_ai_in_motion", 0L);
            r128.put("is_ai_motion_support", 0);
            r128.put("is_avatar_can_drive", 0);
            r128.put("is_algorithm_model_downloaded", 0);
            r128.put("call_scene", "other");
            r92.p3(r128, r102);
            r128.put(r212, r102.k.t);
            r128.put("is_rtc", Boolean.valueOf(com.larus.im.service.audio.y0.e(r102.s)));
            IDoraService r131 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r131 == null) goto L356;
            r131.A0("realtime_call_message", r128);
        L356:
            r92.w = true;
            goto L358
        L352:
            r130 = 0;
            goto L353
        L348:
            r129 = AppeaseType.PEOPLE;
            goto L349
        L379:
            r211 = "";
            r210 = r114;
            r115 = "mute";
            r116 = r64;
            goto L381
        L497:
            return;
        L273:
            r72 = false;
            goto L274
        L249:
            if (pf9.i.j(r113) == false) goto L268;
            r69.O = true;
            r69.H = System.currentTimeMillis();
            pf9.m r132 = r113.c;
            if (r132 == null) goto L253;
            long r133 = r132.d;
        L254:
            if (r132 == null) goto L256;
            long r134 = r132.e;
        L258:
            if (r133 > 0) goto L260;
        L262:
            long r135 = -1;
        L263:
            r69.L = r135;
            r69.J = r135 - r69.K;
            if (r132 == null) goto L266;
            long r136 = r132.b;
        L267:
            r69.M = r136;
            goto L270
        L266:
            r136 = -1;
            goto L267
        L260:
            if (r134 <= 0) goto L262;
            r135 = r134 - r133;
            goto L263
        L256:
            r134 = 0;
            goto L258
        L253:
            r133 = 0;
            goto L254
        L225:
            if (pf9.i.d(r113) == false) goto L245;
            pf9.k0 r137 = r113.b;
            if (r137 == null) goto L229;
            String r138 = r137.a;
        L231:
            if (com.larus.utils.o0.d(r138) == false) goto L245;
            r69.N = true;
            pf9.k0 r139 = r113.b;
            if (r139 != null) goto L235;
        L237:
            boolean r140 = false;
        L238:
            r69.G = Boolean.valueOf(r140);
            pf9.k0 r141 = r113.b;
            if (r141 == null) goto L243;
            Long r142 = r141.h;
            if (r142 == null) goto L243;
            long r143 = r142.longValue();
        L244:
            r69.K = r143;
        L243:
            r143 = -1;
            goto L244
        L235:
            if (r139.m != true) goto L237;
            r140 = true;
            goto L238
        L229:
            r138 = null;
            goto L231
        L269:
            r2 = "event";
            r64 = "tts_delay";
            r13 = "dora_mode";
            goto L270
        L447:
            if ((r28 instanceof pf9.e0) == false) goto L461;
            o1 r144 = this.d.o;
            if (r144 == null) goto L451;
            Intrinsics.checkNotNullParameter((pf9.e0) r28, "event");
            o1.e(r144, 0, 0, null, "reply_end", 6);
        L451:
            DoraIsolatedCallSessionMonitor r145 = this.d;
            r145.W = true;
            if (r145.i.a == false) goto L459;
            o1 r146 = r145.o;
            if (r146 == null) goto L459;
            FLogger.a.i("DoraIsolatedCallQueryMonitor", "onTTSEnded");
            r1 r147 = r146.t;
            if (r147 == null) goto L458;
            r147.a();
        L458:
            r146.t = null;
            r146.y = true;
            com.larus.utils.l0.b(new n1(r146, 1));
        L459:
            this.d.getClass();
            o1 r148 = this.d.o;
            return;
        L461:
            if ((r28 instanceof pf9.r) == false) goto L482;
            int r149 = sf9.b.a;
            pf9.r r150 = (pf9.r) r28;
            if (sf9.b.a(r150.getType()) == false) goto L469;
            DoraIsolatedCallSessionMonitor r151 = this.d;
            int r152 = 1;
            r151.D = 1;
            if (r151.w == false) goto L468;
            r151.w = false;
            r151.A = -1;
            r151.B = -1;
            r151.x = true;
            r151.y = true;
            r151.q++;
        L468:
            r151.y = true;
        L470:
            int r153 = a.a[r150.getType().ordinal()];
            if (r153 != r152) goto L473;
            this.d.V = System.currentTimeMillis();
            int r154 = c68.b.a;
            c68.b.a(this.d.f, "CLIM_IN_STARTED");
            this.d.getClass();
            this.d.e0 = true;
            return;
        L473:
            if (r153 != 2) goto L506;
            DoraIsolatedCallSessionMonitor r155 = this.d;
            r155.getClass();
            RealtimeCallUtil.a.getClass();
            String r156 = RealtimeCallUtil.g();
            boolean r157 = r155.X;
            boolean r158 = r155.W;
            boolean r159 = r155.P;
            long r160 = r155.V;
            long r161 = System.currentTimeMillis();
            Integer r162 = StringsKt.toIntOrNull(r155.d0);
            if (r162 == null) goto L478;
            int r163 = r162.intValue();
        L479:
            r155.y3(r156, 0, r157, r158, r159, r160, r161, String.valueOf(r163 + 1), "chime");
            int r164 = c68.b.a;
            c68.b.a(this.d.f, "CLIM_IN_STARTED");
            this.d.getClass();
            return;
        L478:
            r163 = 0;
            goto L479
        L506:
            return;
        L469:
            r152 = 1;
            goto L470
        L482:
            if ((r28 instanceof pf9.n0) == false) goto L504;
            this.d.r3(((pf9.n0) r28).a);
            return;
        L504:
            return;
        L35:
            if (this.d.o == null) goto L37;
            Intrinsics.checkNotNullParameter((pf9.c0) r28, "event");
        L37:
            DoraIsolatedCallSessionMonitor r165 = this.d;
            if (r165.w == false) goto L40;
            r165.w = false;
            r165.z = -1;
            r165.C = 0;
            r165.A = -1;
            r165.B = -1;
            r165.x = true;
            r165.y = true;
            r165.q++;
        L40:
            r165.y = true;
            o1 r166 = r165.o;
            if (r166 == null) goto L43;
            Intrinsics.checkNotNullParameter((pf9.c0) r28, "event");
            r166.w++;
            r166.x = System.currentTimeMillis();
        L43:
            String r167 = this.b;
            pf9.c0 r168 = (pf9.c0) r28;
            pf9.a r169 = r168.a;
            if (r169 == null) goto L46;
            String r170 = r169.c;
        L48:
            if (Intrinsics.areEqual(r167, r170) == false) goto L54;
            pf9.a r171 = r168.a;
            if (r171 == null) goto L52;
            String r172 = r171.a;
        L53:
            this.c = r172;
            FLogger.a.i(this.d.f, "[ASR_currentAsrText]: " + g2a.d.b(String.valueOf(this.c)));
            goto L54
        L52:
            r172 = null;
        L54:
            DoraIsolatedCallSessionMonitor r173 = this.d;
            if (r173.a0 == false) goto L489;
            r173.a0 = false;
            final o1 r174 = r173.o;
            if (r174 == null) goto L490;
            com.larus.utils.l0.b(new i1(r174));
            return;
        L490:
            return;
        L489:
            return;
        L46:
            r170 = null;
            goto L48
        }

        public e(DoraIsolatedCallSessionMonitor r1, n4 r2) {
            this.d = r1;
            this.e = r2;
            this.a = r1.f;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void q(String r9, Object r10) {
            Intrinsics.checkNotNullParameter(r9, "event");
            Intrinsics.checkNotNullParameter(r9, "event");
            DoraIsolatedCallSessionMonitor r0 = this.d;
            r0.getClass();
            boolean r3 = false;
            String r5 = null;
            DoraIsolatedEnterCallSessionStatus r6 = null;
            String r7 = null;
            String r8 = null;
            switch(r9.hashCode()) {
                case -1324092820: goto L49;
                case -1129772621: goto L42;
                case 748880164: goto L29;
                case 1003482296: goto L22;
                case 1517194242: goto L6;
                default: goto L66;
            };
        L66:
            return;
        L6:
            if (r9.equals("OTHER_UPDATE_SESSION_STATUS") == true) goto L9;
            return;
        L9:
            if ((r10 instanceof Integer) == false) goto L58;
            DoraIsolatedEnterCallSessionStatus.a r11 = DoraIsolatedEnterCallSessionStatus.Companion;
            int r12 = ((Number) r10).intValue();
            r11.getClass();
            DoraIsolatedEnterCallSessionStatus[] r13 = DoraIsolatedEnterCallSessionStatus.values();
            int r1 = r13.length;
            int r2 = 0;
        L11:
            if (r2 >= r1) goto L19;
            DoraIsolatedEnterCallSessionStatus r14 = r13[r2];
            if (r14.getValue() != r12) goto L15;
            boolean r15 = true;
        L16:
            if (r15 == true) goto L17;
            r2 = r2 + 1;
            goto L11
        L17:
            r6 = r14;
            goto L19
        L15:
            r15 = false;
        L19:
            if (r6 == null) goto L59;
            r0.E3(r6);
            return;
        L59:
            return;
        L58:
            return;
        L22:
            if (r9.equals("OTHER_EVENT_POST_BACK_AUDIO_CONFIG") == true) goto L25;
            return;
        L25:
            if ((r10 instanceof String) == false) goto L27;
            r7 = (String) r10;
        L27:
            r0.r3(r7);
            return;
        L29:
            if (r9.equals("OTHER_EVENT_RTC_ROOM_ID_GET") == false) goto L69;
            if (r10 != null) goto L33;
            return;
        L33:
            if ((r10 instanceof String) == false) goto L35;
            r8 = (String) r10;
        L35:
            if (r8 != null) goto L37;
        L38:
            r3 = true;
        L39:
            if (r3 == true) goto L63;
            RealtimeCallParam r16 = ((n4) r0.getContext()).params();
            r16.getClass();
            Intrinsics.checkNotNullParameter(r8, "<set-?>");
            r16.d = r8;
            return;
        L63:
            return;
        L37:
            if (StringsKt.isBlank(r8) == false) goto L39;
        L69:
            return;
        L42:
            if (r9.equals("OTHER_EVENT_CALL_SERVER_START") == true) goto L45;
            return;
        L45:
            if (((n4) r0.getContext()).params().s != AudioSessionType.SAMI) goto L47;
            System.currentTimeMillis();
        L47:
            ((n4) r0.getContext()).i().f("create_call", "connecting");
            return;
        L49:
            if (r9.equals("OTHER_EVENT_CALL_SERVER_END") == false) goto L71;
            com.larus.audio.call.tracer.b r17 = ((n4) r0.getContext()).i();
            if (Intrinsics.areEqual(r10, Boolean.TRUE) == false) goto L54;
            r5 = "create call failed";
        L54:
            com.larus.audio.call.tracer.b.b(r17, "create_call", r5, 4);
            return;
        }
    }

    public static final class f extends com.larus.audio.call.play.e {
        public final /* synthetic */ DoraIsolatedCallSessionMonitor a;

        public final void c() {
            o1 r0 = this.a.o;
            if (r0 == null) goto L6;
            r0.c();
            return;
        }

        public f(DoraIsolatedCallSessionMonitor r1) {
            this.a = r1;
        }

        public final void f(TtsPlayEndType r2) {
            Intrinsics.checkNotNullParameter(r2, "endType");
            o1 r3 = this.a.o;
            if (r3 == null) goto L6;
            r3.d();
            return;
        }
    }

    public final com.larus.im.service.audio.v R2() {
        return this;
    }

    public final void X2() {
    }

    public final void Y2() {
    }

    public final void Z2() {
    }

    public final void c3() {
    }

    public final void h3() {
    }

    static {
        new Regex("code(\\d+)desc(.*?)$");
    }

    public final com.larus.im.service.audio.x Q2() {
        return new d(this);
    }

    public final void b3() {
        if (this.X == false) goto L5;
    L7:
        o1 r0 = this.o;
        if (r0 != null) goto L10;
    L33:
        RealtimeCallParam r4 = ((n4) getContext()).params();
        DoraIsolatedEnterCallSessionStatus r1 = this.h;
        String r5 = ((n4) getContext()).params().p.j;
        int r6 = this.Q;
        String r7 = this.R;
        Boolean r9 = Boolean.valueOf(t3());
        if (v88.a.b(Integer.valueOf(r4.k.s)) == true) goto L36;
        if (r1 == null) goto L46;
        int r10 = r1.getValue();
    L47:
        int r8 = r10;
        w3(r4, r6, r7, r8, r9, MapsKt.emptyMap());
    L48:
        Job r2 = this.c0;
        if (r2 == null) goto L51;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L51:
        this.c0 = null;
        return;
    L46:
        r10 = 0;
        goto L47
    L36:
        if (this.p <= 0) goto L48;
        LinkedHashMap r3 = new LinkedHashMap();
        r3.put("duration", Long.valueOf(System.currentTimeMillis() - this.p));
        String r11 = r4.e;
        if (r11 == null) goto L41;
        r3.put("task_id", r11);
    L41:
        IDoraService r12 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r12 == null) goto L48;
        r12.A0("dora_g_observation_end", r3);
        goto L48
    L10:
        if (this.Q == 0) goto L12;
        boolean r13 = true;
    L14:
        if (r0.s == null) goto L16;
        o1.e(r0, 3, 0, null, "onCallEnd", 6);
    L16:
        s1 r14 = r0.u;
        if (r14 == null) goto L19;
        r14.a();
        r0.u = null;
    L19:
        r1 r15 = r0.t;
        if (r15 == null) goto L23;
        r15.a();
        r0.t = null;
    L23:
        if (r0.p == true) goto L28;
        if (r0.v == false) goto L28;
        r0.f(3, o1.b(r0.n), r0.o - r0.n, o1.b(r0.h), -111);
    L28:
        if (r0.h != 0) goto L33;
        long r16 = r0.x;
        if (r16 <= 0) goto L33;
        if (r13 == true) goto L33;
        com.larus.utils.l0.b(new g1(r0, r0.w, false, true, r16));
        goto L33
    L12:
        r13 = false;
        goto L14
    L5:
        if (this.m == false) goto L7;
        RealtimeCallUtil.a.getClass();
        y3(RealtimeCallUtil.g(), this.G.a, this.X, this.W, this.P, this.U, System.currentTimeMillis(), this.d0, "response");
        goto L7
    }

    public final String s3() {
        int r0 = ia8.n.a;
        String r1 = ia8.n.b(((n4) getContext()).params().k.t);
        if (r1 != null) goto L6;
        return "dora_call";
    L6:
        return r1;
    }

    public final void a3() {
        ((n4) getContext()).i().f("connecting", "call");
        ((n4) getContext()).i().f("create_audio_session", "connecting");
    }

    public final void e3() {
        super.e3();
        long r0 = SystemClock.elapsedRealtime();
        this.j = r0;
        this.k = r0;
        RealtimeCallUtil r1 = RealtimeCallUtil.a;
        String r2 = ((n4) getContext()).params().o.h;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        RealtimeCallUtil.w = r2;
        RealtimeCallUtil.x = ((n4) getContext()).params().o.c;
        RealtimeCallUtil.y = ((n4) getContext()).params().e;
        RealtimeCallUtil.G = true;
        RealtimeCallUtil.H = ((n4) getContext()).params().P;
        ((n4) getContext()).i().f("create_audio_session", "connecting");
        E3(DoraIsolatedEnterCallSessionStatus.CREATE_HANDLE);
        if (this.c0 != null) goto L8;
        CoroutineScope r3 = ((n4) getContext()).r();
        Job r4 = null;
        if (r3 == null) goto L7;
        r4 = BuildersKt.launch$default(r3, null, null, new DoraIsolatedCallSessionMonitor$observerUIStateChange$1(this, null), 3, null);
    L7:
        this.c0 = r4;
    L8:
        Iterator r5 = CollectionsKt.mutableListOf(new com.larus.audio.call.play.e[]{this.G, this.h0}).iterator();
    L10:
        if (r5.hasNext() == false) goto L13;
        com.larus.audio.call.arch.b.a(getContext()).e0().i((com.larus.audio.call.play.e) r5.next());
        goto L10
    L13:
        if (v88.a.b(Integer.valueOf(((n4) getContext()).q())) == false) goto L17;
        RealtimeCallUtil.a.getClass();
        RealtimeCallUtil.G = false;
        return;
    }

    public final void g3() {
        super.g3();
        RealtimeCallUtil.a.getClass();
        RealtimeCallUtil.G = false;
        RealtimeCallUtil.H = false;
        ((n4) getContext()).i().c();
    }

    @Override // com.larus.avlink.plugins.u4
    public final void s0() {
        x3(((n4) getContext()).params(), 0, 0);
    }

    public final boolean t3() {
        MajorState.d r0 = ((n4) getContext()).a().s1();
        if ((r0 instanceof MajorState.h) == false) goto L6;
        return false;
    L6:
        if ((r0 instanceof MajorState.d) == true) goto L8;
        return true;
    L8:
        if (r0.c != MajorState.From.TTS_ENDED) goto L12;
        return false;
    L12:
        return true;
    }

    @Override // com.larus.avlink.plugins.u4
    public final void v() {
        RealtimeCallParam r0 = ((n4) getContext()).params();
        if (Intrinsics.areEqual(((n4) getContext()).params().k.o, "dora_half_duplex") == false) goto L5;
        DoraType r1 = DoraType.DORA_RADIO;
    L6:
        A3(r0, r1.getValue(), AppeaseType.VOICE.getScene());
        o1 r2 = this.o;
        if (r2 == null) goto L10;
        r2.A = System.currentTimeMillis();
        return;
    L10:
        return;
    L5:
        r1 = DoraType.DORA;
        goto L6
    }

    @Override // com.larus.avlink.plugins.u4
    public final u68.a.b D() {
        return this.O;
    }

    public final com.larus.im.service.audio.z0 S2() {
        return this.i0;
    }

    public final String T2() {
        return this.f;
    }

    public final String getName() {
        return this.g;
    }

    public DoraIsolatedCallSessionMonitor(final n4 r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.f = "DoraIsolatedCallSessionMonitor";
        this.g = "DoraIsolatedCallSessionMonitor";
        this.h = DoraIsolatedEnterCallSessionStatus.INITIAL;
        this.i = jd9.c.f.c;
        this.n = true;
        this.p = -1;
        this.t = "";
        this.w = true;
        this.x = true;
        this.y = true;
        this.z = -1;
        this.A = -1;
        this.B = -1;
        this.C = -1;
        this.E = new LinkedHashMap();
        this.F = new LinkedHashMap();
        this.G = new com.larus.audio.call.play.j();
        this.H = true;
        this.K = LazyKt.lazy(new t1(r5));
        this.O = new f(this);
        this.R = "";
        this.S = "";
        this.b0 = -1;
        this.d0 = "0";
        this.h0 = new c(this, r5);
        this.i0 = new e(this, r5);
    }

    public static final void k3(DoraIsolatedCallSessionMonitor r10) {
        r10.getClass();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L17
        String r2 = r10.I;     // Catch: Throwable -> L17
        if (r2 == null) goto L8;
        String r3 = new JSONObject(r2).optString("agent_intention");     // Catch: Throwable -> L17
    L9:
        if (r3 == null) goto L39;
    L13:
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L20:
        String r7 = r3;
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L23;
        FLogger.a.e(r10.f, r5.getMessage());
    L23:
        RealtimeCallParam r6 = ((n4) r10.getContext()).params();
        String r8 = r10.Y;
        String r9 = r10.Z;
        LinkedHashMap r11 = new LinkedHashMap();
        if (r8 == null) goto L35;
        if (Intrinsics.areEqual(r8, r10.L) == false) goto L35;
        String r0 = r10.M;
        if (r0 == null) goto L30;
        String r12 = r11.put("deep_research_id", r0);
    L30:
        String r13 = r10.N;
        if (r13 == null) goto L33;
        String r14 = r11.put("deep_research_phase", r13);
    L33:
        FLogger.a.i(r10.f, "getResearchExtra for messageId: " + r8 + ", returning cached researchId: " + r10.M + ", researchPhase: " + r10.N);
    L37:
        r10.B3(r6, r8, r9, r7, r11);
        return;
    L35:
        if (r10.L == null) goto L37;
        FLogger.a.i(r10.f, "getResearchExtra for messageId: " + r8 + ", cached messageId: " + r10.L + " doesn't match, clearing cache");
        r10.L = null;
        r10.M = null;
        r10.N = null;
    L15:
        Throwable th = th;
    L19:
        Result.Companion r15 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    L39:
        String r16 = r10.J;     // Catch: Throwable -> L15
        if (r16 == null) goto L13;
        r3 = new JSONObject(r16).optString("agent_intention");     // Catch: Throwable -> L15
        goto L13
    L8:
        r3 = null;
    L17:
        th = move-exception;
        th = th;
        r3 = null;
        goto L19
    }

    public final void C3(String r11) {
        Intrinsics.checkNotNullParameter(r11, "questionId");
        o1 r0 = this.o;
        if (r0 == null) goto L18;
        r1 r1 = r0.t;
        if (r1 == null) goto L7;
        r1.a();
    L7:
        r0.t = null;
        if (r0.p == true) goto L15;
        long r2 = r0.o;
        if (r2 <= 0) goto L12;
        long r5 = r2 - r0.n;
    L13:
        r0.f(3, o1.b(r0.n), r5, o1.b(r0.h), -222);
        goto L15
    L12:
        r5 = 0;
    L15:
        if (r0.s == null) goto L17;
        o1.e(r0, 3, 0, null, "interrupt", 6);
    L17:
        FLogger.a.i("DoraIsolatedCallQueryMonitor", "trigger interrupt qid = " + r0.b + " callId =" + r0.f + " roomId=" + r0.g + "scene = " + r0.e + " hasSendExpResponseEvent = " + r0.q + " isFirstPacifyResponse = " + r0.l + " ttsPlayComplete = " + r0.p + " isFirstTTSResponse = " + r0.k + "isFirstChatResponse = " + r0.m);
    L18:
        o1 r3 = this.o;
        if (r3 == null) goto L21;
        com.larus.audio.call.arch.b.a(r3.a).e0().j(r3.R);
    L21:
        this.o = q3(r11);
    }

    public final void D3(String r5) {
        if (r5 != null) goto L21;
        return;
    L21:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L6
        Object r6 = Result.constructor-impl(new JSONObject(r5));     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r6) == false) goto L11;
        r6 = null;
    L11:
        JSONObject r7 = (JSONObject) r6;
        if (r7 != null) goto L14;
        return;
    L14:
        Iterator<String> r1 = r7.keys();
    L16:
        if (r1.hasNext() == false) goto L20;
        String r2 = r1.next();
        Intrinsics.checkNotNull(r2);
        if ((!StringsKt.isBlank(r2)) == false) goto L16;
        this.E.put(r2, r7.opt(r2));
        goto L16
    L20:
        return;
    L6:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // com.larus.avlink.plugins.u4
    public final void E1(long r8) {
        LinkedHashMap r6 = new LinkedHashMap();
        r6.put("duration", Integer.valueOf((int) r8));
        w3(((n4) getContext()).params(), this.Q, this.R, this.h.getValue(), Boolean.valueOf(t3()), r6);
    }

    public final void E3(DoraIsolatedEnterCallSessionStatus r5) {
        FLogger.a.i(this.f, "SessionStatus: " + this.h + ", status: " + r5);
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

    @Override // com.larus.avlink.plugins.o4
    public final void Q0(int r1) {
        this.g0 = false;
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [com.larus.avlink.plugins.u1] */
    public final o1 q3(String r5) {
        com.larus.audio.call.arch.c r1 = getContext();
        l4 r2 = (l4) this.K.getValue();
        if (r2 == null) goto L5;
        boolean r3 = r2.d1();
    L7:
        return new o1(r1, r5, r3, new u1(this));
    L5:
        r3 = false;
        goto L7
    }

    public final void r3(String r3) {
        LinkedHashMap r0 = new LinkedHashMap();
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (r3 == null) goto L6;
        Map r4 = com.larus.audio.call.tracer.d.a(r3, this.f);     // Catch: Throwable -> L11
    L7:
        if (r4 != null) goto L9;
        r4 = MapsKt.emptyMap();     // Catch: Throwable -> L11
    L9:
        r0.putAll(r4);     // Catch: Throwable -> L11
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Intrinsics.checkNotNullParameter(r0, "serverInfo");
        ((LinkedHashMap) this.F).clear();
        this.F.putAll(r0);
        return;
    L6:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public static final void j3(DoraIsolatedCallSessionMonitor r26, pf9.q r27) {
        boolean r1 = r26.i.a;
        int r9 = 8;
        String r12 = "is_pacity";
        String r13 = "agent_intention";
        String r15 = "tea_tags_time_cost";
        String r6 = ChatDraftItem.TYPE_REPLY;
        String r5 = "query";
        String r4 = "received FlowLLMCommandReplyEvent DORA_TRACE: ";
        if (r1 == false) goto L143;
        final o1 r2 = r26.o;
        if (r2 == null) goto L143;
        Intrinsics.checkNotNullParameter(r27, "serverEvent");
        if (r2.m == false) goto L9;
        r2.m = false;
        com.larus.utils.l0.b(new j1(r2, 0, true));
    L9:
        List r3 = r27.a;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator r7 = r3.iterator();
    L11:
        if (r7.hasNext() == false) goto L96;
        pf9.p r8 = (pf9.p) r7.next();
        Long r11 = r8.a;
        if (r11 == null) goto L15;
        Integer r14 = Integer.valueOf((int) r11.longValue());
    L16:
        if (r14 != null) goto L19;
    L20:
        if (r14 != null) goto L23;
    L24:
        if (r14 != null) goto L27;
    L28:
        if (r14 != null) goto L31;
    L32:
        if (r14 != null) goto L35;
    L37:
        if (r14 != null) goto L40;
    L72:
        Iterator r23 = r7;
        String r25 = r13;
        String r24 = r15;
        String r16 = r12;
        if (r14 != null) goto L76;
    L77:
        if (r14 != null) goto L80;
    L82:
        List r17 = com.larus.platform.service.z2.a.o1();
        Long r18 = r8.a;
        if (r18 == null) goto L85;
        Integer r19 = Integer.valueOf((int) r18.longValue());
    L87:
        if (CollectionsKt.contains(r17, r19) == false) goto L95;
        Long r20 = r8.a;
        if (r20 == null) goto L91;
        int r110 = (int) r20.longValue();
    L92:
        o1.e(r2, 0, r110, null, null, 12);
        goto L95
    L91:
        r110 = -1;
    L95:
        r10.add(r8);
        r12 = r16;
        r7 = r23;
        r15 = r24;
        r13 = r25;
        r9 = 8;
        goto L11
    L85:
        r19 = null;
        goto L87
    L80:
        if (r14.intValue() != 24) goto L82;
    L93:
        o1.e(r2, 0, 0, null, null, 14);
        goto L95
    L76:
        if (r14.intValue() == 23) goto L93;
    L40:
        if (r14.intValue() != r9) goto L72;
        Map r21 = r8.b;
        if (r21 == null) goto L48;
        String r22 = (String) r21.get(r15);
        if (r22 == null) goto L48;
        String r111 = new JSONObject(r22).optString(r13);
        if (com.larus.utils.o0.d(r111) == false) goto L48;
        Intrinsics.checkNotNull(r111);
        o1.e(r2, 0, 0, r111, null, 10);
    L48:
        JSONObject r28 = new JSONObject();
        int r112 = z2a.g.a;
        SpanWrapImpl r113 = z2a.g.c(r2.a.i().d(), "realcall_message");
        r23 = r7;
        SpanWrapImpl r29 = z2a.g.c(r2.a.i().d(), "llm_phase");
        r24 = r15;
        Map r114 = r8.b;
        r25 = r13;
        if (r114 == null) goto L53;
        String r115 = (String) r114.get("intention");
        if (r115 == null) goto L53;
        r28.put("intention", r115);
    L53:
        Map r116 = r8.b;
        r16 = r12;
        if (r116 != null) goto L56;
    L58:
        if (r113 == null) goto L60;
        r113.b(r28);
    L60:
        if (r29 == null) goto L62;
        r29.b(r28);
    L62:
        Map r30 = r8.b;
        if (r30 == null) goto L65;
        String r31 = (String) r30.get("is_chat_resp_first");
    L67:
        if (Intrinsics.areEqual(r31, "1") == false) goto L95;
        if (r2.m == false) goto L95;
        r2.m = false;
        com.larus.audio.call.tracer.b.b(r2.a.i(), "llm_phase", null, 6);
        r2.a.i().f("tts_delay", "realcall_message");
        goto L95
    L65:
        r31 = null;
        goto L67
    L56:
        if (((String) r116.get(r16)) == null) goto L58;
        r28.put(r16, "1");
        goto L58
    L35:
        if (r14.intValue() != 21) goto L37;
    L94:
        r23 = r7;
        r25 = r13;
        r24 = r15;
        r16 = r12;
        goto L95
    L31:
        if (r14.intValue() == 5) goto L94;
    L27:
        if (r14.intValue() == 14) goto L94;
    L23:
        if (r14.intValue() == 12) goto L94;
    L19:
        if (r14.intValue() == 13) goto L94;
    L15:
        r14 = null;
        goto L16
    L96:
        String r210 = r13;
        String r211 = r15;
        String r117 = r12;
        Iterator r32 = r27.a.iterator();
    L98:
        if (r32.hasNext() == false) goto L144;
        pf9.p r33 = (pf9.p) r32.next();
        Long r34 = r33.a;
        if (r34 == null) goto L98;
        int r35 = (int) r34.longValue();
        FLogger.a.i("DoraIsolatedCallQueryMonitor", "FlowLLMCommandReplyEvent cmd: " + r35 + ", param: " + r33.b);
        JSONObject r36 = new JSONObject();
        Map r118 = r33.b;
        if (r118 == null) goto L108;
        Iterator r119 = r118.entrySet().iterator();
    L105:
        if (r119.hasNext() == false) goto L108;
        Map.Entry r120 = (Map.Entry) r119.next();
        r36.putOpt((String) r120.getKey(), r120.getValue());
    L108:
        if (r35 != 8) goto L110;
        Map r37 = r33.b;
        if (r37 == null) goto L98;
        final String r38 = (String) r37.get("tea_tags_intent");
        if (r38 == null) goto L98;
        if (com.larus.utils.o0.d(r38) == false) goto L98;
        com.larus.utils.l0.b(new k1(r38, r2));
        goto L98
    L110:
        if (r35 != 1000) goto L98;
        Gson r39 = ha8.a.a;
        DoraTraceParam r40 = (DoraTraceParam) ha8.a.a(r36.toString(), DoraTraceParam.class);
        if (r40 == null) goto L98;
        FLogger.a.i("DoraIsolatedCallQueryMonitor", "received FlowLLMCommandReplyEvent DORA_TRACE: " + r40);
        String r41 = r40.getTraceTime();
        if (Intrinsics.areEqual(r41, "query") == false) goto L125;
        String r42 = r40.getQueryInfo();
        if (r42 == null) goto L98;
        DoraTraceParam.a r43 = (DoraTraceParam.a) ha8.a.a(r42, DoraTraceParam.a.class);
        if (r43 == null) goto L98;
        DoraETracer.DoraEMessageType.a r44 = DoraETracer.DoraEMessageType.Companion;
        Integer r45 = r43.c();
        r44.getClass();
        r2.D = DoraETracer.DoraEMessageType.a.a(r45);
        goto L98
    L125:
        if (Intrinsics.areEqual(r41, ChatDraftItem.TYPE_REPLY) == false) goto L98;
        String r46 = r40.getReplyInfo();
        if (r46 == null) goto L98;
        DoraTraceParam.b r47 = (DoraTraceParam.b) ha8.a.a(r46, DoraTraceParam.b.class);
        if (r47 == null) goto L98;
        if (r47.l() == null) goto L98;
        r2.K = r47.h();
        r2.J = (r47.i() - r47.h()) - r47.m();
    L144:
        Iterator r48 = r27.a.iterator();
    L146:
        if (r48.hasNext() == false) goto L281;
        pf9.p r0 = (pf9.p) r48.next();
        Long r49 = r0.a;
        if (r49 == null) goto L279;
        int r50 = (int) r49.longValue();
        JSONObject r51 = new JSONObject();
        Map r52 = r0.b;
        if (r52 == null) goto L156;
        Iterator r53 = r52.entrySet().iterator();
    L153:
        if (r53.hasNext() == false) goto L156;
        Map.Entry r54 = (Map.Entry) r53.next();
        r51.putOpt((String) r54.getKey(), r54.getValue());
    L156:
        if (r50 != 8) goto L158;
        String r55 = r4;
        String r121 = r5;
        String r122 = r6;
        String r123 = r210;
        Map r56 = r0.b;
        if (r56 == null) goto L264;
        String r57 = (String) r56.get(r117);
        if (r57 == null) goto L264;
        new JSONObject().put(r117, "1");
        if (Intrinsics.areEqual(r57, "1") == false) goto L264;
        if (r26.H == false) goto L264;
        r26.H = false;
        RealtimeCallParam r58 = ((n4) r26.getContext()).params();
        if (Intrinsics.areEqual(((n4) r26.getContext()).params().k.o, "dora_half_duplex") == false) goto L261;
        DoraType r59 = DoraType.DORA_RADIO;
    L262:
        r26.A3(r58, r59.getValue(), AppeaseType.PEOPLE.getScene());
        goto L264
    L261:
        r59 = DoraType.DORA;
    L264:
        Map r60 = r0.b;
        String r61 = r211;
        if (r60 == null) goto L274;
        String r62 = (String) r60.get(r61);
        if (r62 == null) goto L274;
        r26.I = r62;
        String r63 = com.larus.utils.p0.b(r62).optString("agent_id");
        Intrinsics.checkNotNull(r63);
        if (r63.length() <= 0) goto L271;
        boolean r64 = true;
    L272:
        if (r64 == false) goto L274;
        FLogger.a.i(r26.f, "traceAgentId is ".concat(r63));
        r26.Z = r63;
        goto L274
    L271:
        r64 = false;
    L274:
        Map r65 = r0.b;
        if (r65 == null) goto L280;
        String r66 = (String) r65.get("fpa_common_param");
        if (r66 == null) goto L280;
        r26.J = r66;
    L280:
        r211 = r61;
        r4 = r55;
        r6 = r122;
        r210 = r123;
        r5 = r121;
        goto L146
    L158:
        if (r50 == 1000) goto L188;
        switch(r50) {
            case 12: goto L284;
            case 13: goto L284;
            case 14: goto L284;
            default: goto L160;
        };
    L160:
        r55 = r4;
        r121 = r5;
        r122 = r6;
        r123 = r210;
        r61 = r211;
        goto L280
    L284:
        Result.Companion r67 = Result.Companion;     // Catch: Throwable -> L178
        String r68 = r26.I;     // Catch: Throwable -> L178
        if (r68 == null) goto L167;
        JSONObject r69 = com.larus.utils.p0.b(r68);     // Catch: Throwable -> L178
        if (r69 == null) goto L167;
        r123 = r210;
        String r70 = r69.optString(r123);     // Catch: Throwable -> L176
    L168:
        if (r70 != null) goto L187;
        String r71 = r26.J;     // Catch: Throwable -> L176
        if (r71 == null) goto L175;
        JSONObject r72 = com.larus.utils.p0.b(r71);     // Catch: Throwable -> L176
        if (r72 == null) goto L175;
        r70 = r72.optString(r123);     // Catch: Throwable -> L176
    L175:
        r70 = null;
    L187:
        r55 = r4;
        r121 = r5;
        r122 = r6;
        r26.B3(((n4) r26.getContext()).params(), r26.Y, r26.Z, r70, null);
    L248:
        r61 = r211;
    L176:
        th = th;
    L180:
        Result.Companion r73 = Result.Companion;
        Object r74 = Result.constructor-impl(ResultKt.createFailure(th));
        Throwable r75 = Result.exceptionOrNull-impl(r74);
        if (r75 == null) goto L184;
        FLogger.a.e(r26.f, r75.getMessage());
    L184:
        if (Result.isFailure-impl(r74) == false) goto L186;
        r74 = null;
    L186:
        r70 = (String) r74;
    L167:
        r123 = r210;
        r70 = null;
    L178:
        th = th;
        r123 = r210;
        goto L180
    L188:
        r55 = r4;
        r121 = r5;
        r122 = r6;
        r123 = r210;
        JSONObject r76 = new JSONObject();
        Map r77 = r0.b;
        if (r77 == null) goto L194;
        Iterator r78 = r77.entrySet().iterator();
    L192:
        if (r78.hasNext() == false) goto L194;
        Map.Entry r79 = (Map.Entry) r78.next();
        r76.putOpt((String) r79.getKey(), r79.getValue());
    L194:
        String r80 = r76.toString();
        Gson r81 = ha8.a.a;
        DoraTraceParam r82 = (DoraTraceParam) ha8.a.a(r80, DoraTraceParam.class);
        if (r82 == null) goto L248;
        FLogger r83 = FLogger.a;
        r83.i(r26.f, r55 + r80);
        String r84 = r82.getTraceTime();
        if (Intrinsics.areEqual(r84, r121) == false) goto L230;
        String r85 = r82.getQueryInfo();
        if (r85 == null) goto L248;
        DoraTraceParam.a r86 = (DoraTraceParam.a) ha8.a.a(r85, DoraTraceParam.a.class);
        if (r86 == null) goto L248;
        String r87 = r86.a();
        if (r87 != null) goto L208;
    L211:
        boolean r88 = true;
    L212:
        if (r88 == false) goto L214;
        r87 = r86.b();
    L214:
        String r89 = r26.s3();
        String r90 = "";
        if (r87 != null) goto L217;
        r87 = "";
    L217:
        Integer r91 = r86.c();
        String r92 = r86.d();
        String r93 = r86.e();
        LinkedHashMap r94 = new LinkedHashMap();
        r94.put("scene", r89);
        r94.put("conversation_id", ((n4) r26.getContext()).params().G);
        r94.put("bot_id", ((n4) r26.getContext()).params().o.h);
        r94.put("message_id", r87);
        r94.put("chat_type", "default");
        r94.put("success", 1);
        r94.put("dora_message_affiliation", "dora_e");
        DoraEMessageType.Companion.getClass();
        String r95 = DoraEMessageType.a.a(r91);
        if (r95 == null) goto L221;
        r90 = r95;
    L221:
        r94.put("dora_message_type", r90);
        if (r92 == null) goto L224;
        r94.put("deep_research_id", r92);
    L224:
        if (r93 == null) goto L226;
        r94.put("deep_research_phase", r93);
    L226:
        r94.put("dora_message_mode", y.a(((n4) r26.getContext()).params()));
        IDoraService r96 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r96 == null) goto L248;
        r96.A0("dora_send_message_update", r94);
        goto L248
    L208:
        if (r87.length() == 0) goto L211;
        r88 = false;
        goto L212
    L230:
        if (Intrinsics.areEqual(r84, r122) == false) goto L248;
        String r97 = r82.getReplyInfo();
        if (r97 == null) goto L248;
        DoraTraceParam.b r99 = (DoraTraceParam.b) ha8.a.a(r97, DoraTraceParam.b.class);
        if (r99 == null) goto L248;
        String r100 = r99.l();
        if (r100 == null) goto L248;
        r26.L = r100;
        List r101 = r99.n();
        if (r101 == null) goto L242;
        String r102 = (String) CollectionsKt.firstOrNull(r101);
    L243:
        r26.M = r102;
        List r103 = r99.o();
        if (r103 == null) goto L246;
        String r104 = (String) CollectionsKt.firstOrNull(r103);
    L247:
        r26.N = r104;
        r83.i(r26.f, "Cached deep research data for messageId: " + r100 + ", researchId: " + r26.M + ", researchPhase: " + r26.N);
        goto L248
    L246:
        r104 = null;
        goto L247
    L242:
        r102 = null;
        goto L243
    L279:
        r55 = r4;
        r121 = r5;
        r122 = r6;
        r61 = r211;
        r123 = r210;
        goto L280
    L281:
        return;
    L143:
        r210 = "agent_intention";
        r211 = "tea_tags_time_cost";
        r117 = "is_pacity";
        goto L144
    }

    public static void z3(RealtimeCallParam r3, boolean r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        String r1 = r3.e;
        if (r1 == null) goto L5;
        r0.put("task_id", r1);
    L5:
        r0.put("fail_type", "");
        if (r4 == false) goto L8;
        String r5 = "success";
    L9:
        r0.put("status", r5);
        r0.put("is_rtc", Boolean.valueOf(com.larus.im.service.audio.y0.e(r3.s)));
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L13;
        r6.A0("dora_g_observation_start", r0);
        return;
    L13:
        return;
    L8:
        r5 = "failure";
        goto L9
    }

    @Override // com.larus.avlink.plugins.u4
    public final void B(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errMsg");
        u3(this, r2, r3);
    }

    public final void O1(jd9.c r13, jd9.c r14) {
        Intrinsics.checkNotNullParameter(r13, "oldState");
        Intrinsics.checkNotNullParameter(r14, "newState");
        ouc.d0 r15 = r14.b;
        if (r15 == null) goto L16;
        String r16 = sf9.a.c(r15, "roomId", "");
        if (r16 != null) goto L8;
    L11:
        boolean r3 = true;
    L12:
        if (r3 == true) goto L16;
        RealtimeCallParam r4 = ((n4) getContext()).params();
        r4.getClass();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r4.d = r16;
        goto L16
    L8:
        if (StringsKt.isBlank(r16) == true) goto L11;
        r3 = false;
    L16:
        if ((r14 instanceof jd9.c.d) == false) goto L32;
        jd9.c.d r17 = (jd9.c.d) r14;
        String r5 = r17.f;
        if (StringsKt.isBlank(r5) == false) goto L20;
        r5 = r17.e;
    L20:
        int r18 = r17.c;
        ue9.c.u r6 = ue9.c.u.c;
        if (r18 == 20010) goto L30;
        ue9.c.q r7 = ue9.c.q.c;
        if (r18 == 20011) goto L30;
        ue9.c.w r8 = ue9.c.w.c;
        if (r18 == 20006) goto L29;
        ue9.c.v r9 = ue9.c.v.c;
        if (r18 == 20007) goto L29;
    L31:
        u3(this, r18, r5);
    L29:
        r18 = -1;
    L30:
        r18 = -3;
    L32:
        boolean r19 = r14 instanceof jd9.c.a;
        if (r19 == false) goto L38;
        if (((jd9.c.a) r14).c == false) goto L38;
        SystemClock.elapsedRealtime();
    L38:
        if (this.m == true) goto L62;
        if (r19 == false) goto L62;
        if (((jd9.c.a) r14).c == true) goto L62;
        this.m = true;
        E3(DoraIsolatedEnterCallSessionStatus.SESSION_STARTED);
        boolean r110 = this.n;
        RealtimeCallParam r10 = ((n4) getContext()).params();
        long r11 = SystemClock.elapsedRealtime() - this.j;
        if (r110 == false) goto L50;
        long r12 = System.currentTimeMillis() - r10.c;
        if (v88.a.b(Integer.valueOf(r10.k.s)) == false) goto L48;
        z3(r10, true);
        goto L50
    L48:
        x3(r10, r12, r11);
    L50:
        if (this.l == true) goto L61;
        this.l = true;
        long r20 = 0;
        if (this.k <= 0) goto L54;
        long r111 = SystemClock.elapsedRealtime() - this.k;
    L55:
        RealtimeCallParam r21 = ((n4) getContext()).params();
        if (r21 == null) goto L58;
        r20 = System.currentTimeMillis() - r21.c;
    L58:
        long r22 = r20;
        IDoraService r112 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r112 == null) goto L61;
        r112.A0("flow_dora_session_start", o3(r21, r22, r111));
        goto L61
    L54:
        r111 = 0;
    L61:
        this.p = System.currentTimeMillis();
        com.larus.audio.call.tracer.b.b(((n4) getContext()).i(), "create_audio_session", null, 6);
        com.larus.audio.call.tracer.b.b(((n4) getContext()).i(), "connecting", null, 6);
        this.Q = 0;
        this.R = "";
        this.n = false;
    L62:
        this.i = r14;
    }

    public final void p3(Map<String, Object> r4, RealtimeCallParam r5) {
        r4.put("scene", s3());
        r4.put("call_id", r5.e);
        r4.put("room_id", r5.d);
        r4.put("task_id", r5.l.a);
        if (Intrinsics.areEqual(s3(), "call") == false) goto L5;
    L7:
        LinkedHashMap r0 = (LinkedHashMap) r4;
        Object r2 = r0.get("dora_message_mode");
        if (r2 != null) goto L10;
        r2 = y.a(r5);
    L10:
        r4.put("dora_message_mode", r2);
        Object r1 = r0.get("dora_conversation_type");
        if (r1 != null) goto L13;
        r1 = s3();
    L13:
        r4.put("dora_conversation_type", r1);
        r4.put("dora_wake_up_mode", Integer.valueOf(r5.k.s));
        r4.put("is_rtc", Boolean.valueOf(com.larus.im.service.audio.y0.e(r5.s)));
        r4.put("is_quic", Boolean.valueOf(com.larus.im.service.audio.y0.d(r5.s)));
        r4.put("is_mmt", Integer.valueOf(com.larus.im.service.audio.y0.b(r5.s) ? 1 : 0));
        r4.put("is_client_pre_connect", Integer.valueOf(r5.t));
        r4.put("av_session_type", Integer.valueOf(r5.s.getType()));
        r4.put("is_dora_si", Integer.valueOf(Intrinsics.areEqual(r5.k.o, "dora_si") ? 1 : 0));
        boolean r3 = true;
        if (BaseDoraLiteLiveAiPlugin.l == false) goto L16;
    L19:
        r4.put("is_live_ai", Boolean.valueOf(r3));
        r4.putAll(this.E);
        r4.putAll(this.F);
        return;
    L16:
        if (b98.b.b(1) == true) goto L19;
        r3 = false;
        goto L19
    L5:
        if (Intrinsics.areEqual(s3(), "assistant_scene_mode_click_talk") == true) goto L7;
        r4.put("dora_mode", s3());
        goto L7
    }

    public final void v3(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "comfortType");
        RealtimeCallParam r0 = ((n4) getContext()).params();
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("comfort_scene", r4);
        r1.put("total", Integer.valueOf(r5));
        p3(r1, r0);
        IDoraService r6 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r6 == null) goto L6;
        r6.A0("appease_play_duration", r1);
        return;
    }

    public static void u3(DoraIsolatedCallSessionMonitor r16, int r17, String r18) {
        r16.Q = r17;
        if (r18 != null) goto L5;
        String r1 = "";
    L6:
        r16.R = r1;
        if (r16.m == false) goto L20;
        Pair r0 = TuplesKt.to(0, "");
        int r10 = ((Number) r0.component1()).intValue();
        String r11 = (String) r0.component2();
        long r12 = r16.b0;
        RealtimeCallParam r5 = ((n4) r16.getContext()).params();
        Boolean r14 = Boolean.valueOf(r16.m);
        JSONObject r6 = new JSONObject();
        r6.put("sub_error_code", r10);
        if (r11 == null) goto L11;
        r6.put("sub_error_msg", r11);
    L11:
        Unit r2 = Unit.INSTANCE;
        Map<String, Object> r3 = r16.m3(r17, r18, r12, r5, r6);
        r3.put("is_session_started", Integer.valueOf(Intrinsics.areEqual(r14, Boolean.TRUE) ? 1 : 0));
        r3.put("biz_scene", "call");
        IDoraService r4 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r4 == null) goto L14;
        r4.A0("realtime_call_error", r3);
    L14:
        RealtimeCallParam r7 = ((n4) r16.getContext()).params();
        JSONObject r8 = new JSONObject();
        r8.putOpt("current_stage", Integer.valueOf(r16.g0 ? 1 : 0));
        r8.put("sub_error_code", r10);
        if (r11 == null) goto L17;
        r8.put("sub_error_msg", r11);
    L17:
        IDoraService r9 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r9 == null) goto L39;
        r9.A0("flow_dora_call_error", r16.m3(r17, r18, r12, r7, r8));
    L39:
        r16.n = false;
        return;
    L20:
        RealtimeCallParam r13 = ((n4) r16.getContext()).params();
        if (r18 != null) goto L23;
        String r15 = "un_know_error";
    L24:
        boolean r19 = r16.n;
        DoraIsolatedEnterCallSessionStatus r20 = r16.h;
        Integer r21 = Integer.valueOf(r17);
        SystemClock.elapsedRealtime();
        if (r19 == false) goto L39;
        if (v88.a.b(Integer.valueOf(r13.k.s)) == false) goto L30;
        z3(r13, false);
        goto L39
    L30:
        Map<String, Object> r22 = r16.n3(r13, r15, r21, Integer.valueOf(r20.getValue()));
        IDoraService r23 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r23 == null) goto L33;
        r23.A0("dora_conversation_start", r22);
    L33:
        IDoraService r24 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r24 == null) goto L36;
        r24.A0("flow_dora_conversation_start", r22);
    L36:
        Integer r25 = Integer.valueOf(r20.getValue());
        IDoraService r26 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r26 == null) goto L39;
        r26.A0("flow_dora_session_start", r16.n3(r13, r15, r21, r25));
        goto L39
    L23:
        r15 = r18;
        goto L24
    L5:
        r1 = r18;
        goto L6
    }

    public final void A3(RealtimeCallParam r3, String r4, String r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("scene", r4);
        r0.put("comfort_scene", r5);
        if (r3 == null) goto L9;
        RealtimeCallParam.p r6 = r3.o;
        if (r6 == null) goto L9;
        String r7 = r6.h;
        if (r7 == null) goto L9;
        r0.put("bot_id", r7);
    L9:
        if (r3 == null) goto L15;
        RealtimeCallParam.p r8 = r3.o;
        if (r8 == null) goto L15;
        String r9 = r8.c;
        if (r9 == null) goto L15;
        r0.put("conversation_id", r9);
    L15:
        if (r3 == null) goto L19;
        String r10 = r3.e;
        if (r10 == null) goto L19;
        r0.put("call_id", r10);
    L19:
        if (r3 == null) goto L25;
        RealtimeCallParam.h r11 = r3.k;
        if (r11 == null) goto L25;
        String r12 = r11.t;
        if (r12 == null) goto L25;
        r0.put("dora_mode", r12);
    L25:
        r0.put("trigger", "invoke_plugin");
        if (r3 == null) goto L28;
        p3(r0, r3);
    L28:
        IDoraService r13 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r13 == null) goto L32;
        r13.A0("latency_comfort", r0);
        return;
    }

    @Override // com.larus.avlink.plugins.o4
    public final void i0(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "caller");
        Intrinsics.checkNotNullParameter(r1, "caller");
        this.g0 = true;
    }

    public final void l3(Map<String, Object> r3, RealtimeCallParam r4, ProactiveIndexType r5) {
        int r0 = ia8.n.a;
        String r1 = ia8.n.a(r4.p.x);
        if (r1 == null) goto L5;
        r3.put("dora_proactive_type", r1);
    L5:
        String r2 = r4.p.y;
        if (r2 == null) goto L8;
        r3.put("dora_proactive_sub_type", r2);
    L8:
        String r6 = r4.p.w;
        if (r6 == null) goto L22;
        r3.put("dora_proactive_id", r6);
        r3.put("scene", "dora_proactive");
        r3.put("dora_conversation_type", "dora_proactive");
        int r7 = b.a[r5.ordinal()];
        if (r7 != 1) goto L13;
        int r8 = this.u + 1;
        this.u = r8;
        r3.put("dora_proactive_prompt_index", Integer.valueOf(r8));
        return;
    L13:
        if (r7 != 2) goto L15;
        int r9 = this.v + 1;
        this.v = r9;
        r3.put("dora_proactive_response_index", Integer.valueOf(r9));
        return;
    L15:
        if (r7 != 3) goto L18;
        return;
    L18:
        throw new NoWhenBranchMatchedException();
    }

    public final Map<String, Object> o3(RealtimeCallParam r6, long r7, long r9) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("scene", s3());
        if (r6 == null) goto L5;
        String r1 = r6.f;
    L6:
        boolean r2 = false;
        if (r1 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == false) goto L26;
        if (r6 == null) goto L20;
        RealtimeCallParam.p r4 = r6.o;
        if (r4 == null) goto L20;
        String r5 = r4.h;
        if (r5 == null) goto L20;
        r0.put("bot_id", r5);
    L20:
        if (r6 == null) goto L26;
        RealtimeCallParam.p r8 = r6.o;
        if (r8 == null) goto L26;
        String r10 = r8.c;
        if (r10 == null) goto L26;
        r0.put("conversation_id", r10);
    L26:
        if (r6 == null) goto L30;
        String r11 = r6.e;
        if (r11 == null) goto L30;
        r0.put("call_id", r11);
    L30:
        if (r6 == null) goto L36;
        RealtimeCallParam.h r12 = r6.k;
        if (r12 == null) goto L36;
        String r13 = r12.t;
        if (r13 == null) goto L36;
        r0.put("dora_mode", r13);
    L36:
        r0.put("dora_conversation_type", s3());
        if (r6 == null) goto L43;
        RealtimeCallParam.k r14 = r6.p;
        if (r14 == null) goto L43;
        if (r14.R != true) goto L43;
        r2 = true;
    L43:
        if (r2 == false) goto L45;
        r0.put("dora_conversation_sec_type", "dora_natural_wakeup");
    L45:
        r0.put("fail_type", "");
        r0.put("status", "success");
        r0.put("start_session_exp_duration", Long.valueOf(r7));
        r0.put("start_session_duration", Long.valueOf(r9));
        if (r6 == null) goto L48;
        r0.put("dora_message_mode", y.a(r6));
        p3(r0, r6);
        l3(r0, r6, ProactiveIndexType.NONE);
    L48:
        return r0;
    L9:
        if (r1.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public final void x3(RealtimeCallParam r4, long r5, long r7) {
        IDoraService r0 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r0 == null) goto L5;
        r0.A0("dora_conversation_start", o3(r4, r5, r7));
    L5:
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L9;
        r1.A0("flow_dora_conversation_start", o3(r4, r5, r7));
        return;
    }

    public final Map<String, Object> n3(RealtimeCallParam r7, String r8, Integer r9, Integer r10) {
        Map<String, Object> r11 = o3(r7, -1, -1);
        r11.put("status", "failure");
        r11.put("fail_type", r8);
        if (r9 == null) goto L5;
        r11.put("error_code", Integer.valueOf(r9.intValue()));
    L5:
        if (r10 == null) goto L7;
        r11.put("session_status", Integer.valueOf(r10.intValue()));
    L7:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final void B3(RealtimeCallParam r6, String r7, String r8, String r9, Map<String, String> r10) {
        Intrinsics.checkNotNullParameter(r6, "params");
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("group_type", "private");
        r0.put("success", 1);
        ?? r2 = 0;
        if (r7 == null) goto L14;
        r0.put("message_id", r7);
        this.t = r7;
        Pair<String, Boolean> r4 = DoraETracer.a;
        if (r4 == null) goto L7;
        String r5 = (String) r4.getFirst();
    L9:
        if (Intrinsics.areEqual(r5, r7) == false) goto L14;
        Pair<String, Boolean> r11 = DoraETracer.a;
        if (r11 == null) goto L13;
        r2 = ((Boolean) r11.getSecond()).booleanValue();
    L13:
        r0.put("is_dora_exploration_active_message", Integer.valueOf(r2));
        goto L14
    L7:
        r5 = null;
    L14:
        if (r8 == null) goto L16;
        r0.put("agent_id", r8);
    L16:
        if (r9 == null) goto L18;
        r0.put("agent_intention", r9);
    L18:
        if (r10 == null) goto L23;
        Iterator<Map.Entry<String, String>> r12 = r10.entrySet().iterator();
    L21:
        if (r12.hasNext() == false) goto L23;
        Map.Entry<String, String> r13 = r12.next();
        r0.put(r13.getKey(), r13.getValue());
    L23:
        r0.put("conversation_id", r6.o.c);
        r0.put("bot_id", r6.o.h);
        r0.put("voice_id", StringsKt.toLongOrNull(r6.o.f));
        r0.put("speaker_name", r6.o.g);
        r0.put("speaker_id", r6.o.d);
        r0.put("current_page", r6.p.d);
        r0.put("previous_page", r6.p.b);
        r0.put("voice_type", "default");
        r0.put("type", ChatDraftItem.TYPE_TEXT);
        r0.put("is_tts_open", 1);
        r0.put("is_onboarding", 0);
        r0.put("is_soft_link", 0);
        r0.put("message_type", ChatDraftItem.TYPE_TEXT);
        r0.put("is_cache", -1);
        r0.put("use_nickname", "0");
        r0.put("is_baike_link", "0");
        if (Intrinsics.areEqual(r6.l.r, "1") == false) goto L33;
        String r14 = r6.p.k;
        if (Intrinsics.areEqual(r14, "dora_new_onboarding_voicewakeup_example") == false) goto L28;
    L31:
        r0.put("sec_scene", r14);
    L35:
        r0.put("dora_mode", r6.k.t);
        r0.put("dora_message_mode", y.a(r6));
        p3(r0, r6);
        l3(r0, r6, ProactiveIndexType.RESPONSE);
        IDoraService r15 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r15 == null) goto L40;
        r15.A0("vui_receive_stream", r0);
        return;
    L40:
        return;
    L28:
        if (Intrinsics.areEqual(r14, "dora_new_onboarding_voicewakeup_continue") == true) goto L31;
        r14 = "dora_onboarding";
        goto L31
    L33:
        if (r6.p.R == false) goto L35;
        r0.put("sec_scene", "dora_natural_wakeup");
        goto L35
    }

    public final Map<String, Object> m3(int r5, String r6, long r7, RealtimeCallParam r9, JSONObject r10) {
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<String> r1 = r10.keys();
    L4:
        if (r1.hasNext() == false) goto L6;
        String r2 = r1.next();
        r0.put(r2, r10.opt(r2));
        goto L4
    L6:
        r0.put("bot_id", r9.o.h);
        r0.put("call_id", r9.e);
        r0.put("room_id", r9.d);
        r0.put("conversation_id", r9.l.c);
        r0.put("error_code", Long.valueOf(r5));
        if (r6 == null) goto L9;
        r0.put("error_msg", r6);
    L9:
        r0.put("is_ai_in_motion", 0L);
        r0.put("from_status", Long.valueOf(r7));
        r0.put("scene", s3());
        r0.put("task_id", r9.l.a);
        r0.put("is_mock_chat", 0);
        r0.put("llm_model", r9.l.p);
        r0.put("user_interrupt", Long.valueOf(r9.l.h));
        r0.put("pre_query", Integer.valueOf(r9.l.m ? 1 : 0));
        r0.put("voice_style", r9.o.d);
        r0.put("is_ai_motion_support", 0);
        r0.put("is_avatar_can_drive", 0);
        r0.put("is_algorithm_model_downloaded", 0);
        p3(r0, r9);
        r0.put("dora_mode", r9.k.t);
        r0.put("is_rtc", Boolean.valueOf(com.larus.im.service.audio.y0.e(r9.s)));
        return r0;
    }

    public final void w3(RealtimeCallParam r9, int r10, String r11, int r12, Boolean r13, Map<String, ? extends Object> r14) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (this.p > 0) goto L7;
        return;
    L7:
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("duration", Integer.valueOf((int) (System.currentTimeMillis() - this.p)));
        r0.put("bot_id", r9.o.h);
        r0.put("conversation_id", r9.o.c);
        r0.put("question_cnt", Integer.valueOf(this.q));
        r0.put("answer_cnt", Integer.valueOf(this.r));
        r0.put("user_speaking_duration", Integer.valueOf((int) this.s));
        r0.put("message_id", this.t);
        r0.put("error_code", Integer.valueOf(r10));
        r0.put("error_message", r11);
        r0.put("session_status", Integer.valueOf(r12));
        if (r13 == null) goto L10;
        r0.put("is_last_message_read", Integer.valueOf(r13.booleanValue() ? 1 : 0));
    L10:
        RealtimeCallParam.DoraEndType r15 = r9.p.C;
        if (r15 == null) goto L13;
        r0.put("dora_end_type", r15.getType());
    L13:
        Integer r16 = r9.n.a;
        if (r16 == null) goto L17;
        int r17 = r16.intValue();
        r0.put("end_code", Integer.valueOf(r17));
        DoraETracePlugin r18 = DoraETracePlugin.p;
        r0.put("unexpected", Integer.valueOf(DoraETracePlugin.a.b(Integer.valueOf(r17)) ? 1 : 0));
    L17:
        if (r9.p.R == false) goto L19;
        r0.put("dora_conversation_sec_type", "dora_natural_wakeup");
    L19:
        p3(r0, r9);
        l3(r0, r9, ProactiveIndexType.NONE);
        r0.putAll(r14);
        this.q = 0;
        this.r = 0;
        this.s = 0;
        IDoraService r19 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r19 == null) goto L23;
        r19.A0("dora_conversation_end", r0);
        return;
    }

    public final void y3(String r6, long r7, boolean r9, boolean r10, boolean r11, long r12, long r14, String r16, String r17) {
        Intrinsics.checkNotNullParameter(r6, "audioRoute");
        RealtimeCallParam r1 = ((n4) getContext()).params();
        LinkedHashMap r2 = new LinkedHashMap();
        r2.put("task_id", r1.l.a);
        r2.put("scene", s3());
        r2.put("current_route", r6);
        r2.put("first_tts_duration", Long.valueOf(r7));
        r2.put("is_finish", Boolean.valueOf(r9));
        r2.put("is_tts_end", Boolean.valueOf(r10));
        r2.put("is_pacify", Boolean.valueOf(r11));
        r2.put("dora_mode", r1.k.t);
        r2.put("answer_start_time", Long.valueOf(r12));
        r2.put("answer_end_time", Long.valueOf(r14));
        r2.put("answer_type", r17);
        r2.put("call_round", r16);
        p3(r2, r1);
        r2.put("dora_mode", r1.k.t);
        r2.put("is_rtc", Boolean.valueOf(com.larus.im.service.audio.y0.e(r1.s)));
        IDoraService r3 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r3 == null) goto L6;
        r3.A0("realtime_call_tts_play", r2);
        return;
    }
}
