package com.larus.voicecall.impl.tracer;

import android.os.SystemClock;
import com.larus.audio.bean.AppeaseType;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.arch.c;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.im.service.audio.AudioSessionType;
import com.larus.im.service.audio.DataType;
import com.larus.im.service.audio.a1;
import com.larus.im.service.audio.cmd.ReplyStage;
import com.larus.im.service.audio.cmd.TriggerMode;
import com.larus.im.service.audio.z0;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.i1;
import org.json.JSONArray;
import org.json.JSONObject;
import pf9.n0;
import pf9.o0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public class CommonCallSessionMonitor<C extends com.larus.audio.call.arch.c> extends com.larus.audio.call.arch.a<C> implements o, com.larus.im.service.audio.v {
    public static final Regex T = null;
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public boolean F;
    public int G;
    public Job H;
    public String I;
    public final com.larus.voicecall.impl.tracer.a J;
    public boolean K;
    public boolean L;
    public boolean M;
    public long N;
    public final Lazy O;
    public final b P;
    public final d Q;
    public long R;
    public boolean S;
    public final String f;
    public final String g;
    public IRealtimeCallTracer.EnterCallSessionStatus h;
    public jd9.c i;
    public long j;
    public long k;
    public volatile boolean l;
    public volatile boolean m;
    public j n;
    public final com.larus.audio.call.play.j o;
    public boolean p;
    public int q;
    public String r;
    public String s;
    public String t;
    public long u;
    public long v;
    public long w;
    public boolean x;
    public boolean y;
    public String z;

    public static final class a {
    }

    public static final class b extends com.larus.audio.call.play.e {
        public final /* synthetic */ CommonCallSessionMonitor<C> a;
        public final /* synthetic */ C b;

        public final void a() {
            int r0 = c68.b.a;
            c68.b.a(this.a.f, "onTTSEnded");
            CommonCallSessionMonitor<C> r1 = this.a;
            if (r1.M == false) goto L33;
            boolean r2 = false;
            r1.M = false;
            MajorState.InterruptType r3 = null;
            String r4 = "normal";
            if (r1.L == false) goto L10;
            r1.L = false;
            c68.b.a(r1.f, "onTTSEnded isReceivingChime event = 2");
            VoiceCallTraceLogger r5 = this.a.o3();
            if (r5 == null) goto L9;
            r5.a(ReplyAudioEventType.CHIME_IN_END, "normal", this.a.n3(), "inner_play_tail");
        L9:
            this.a.J.a(new com.larus.voicecall.impl.tracer.b(2, System.currentTimeMillis(), null));
            return;
        L10:
            c68.b.a(r1.f, "onTTSEnded normal audio event = 4 , markTTSEnd = " + this.a.x + " , currentState() = " + this.b.a().s1());
            if (this.a.x == false) goto L21;
            MajorState.d r6 = this.b.a().s1();
            if ((r6 instanceof MajorState.d) == false) goto L15;
            MajorState.d r7 = r6;
        L16:
            if (r7 == null) goto L19;
            r3 = r7.d;
        L19:
            if (r3 != MajorState.InterruptType.NOTHING) goto L21;
            r2 = true;
            goto L21
        L15:
            r7 = null;
        L21:
            VoiceCallTraceLogger r8 = this.a.o3();
            if (r8 == null) goto L28;
            ReplyAudioEventType r9 = ReplyAudioEventType.REPLY_END;
            if (r2 == true) goto L27;
            r4 = "interrupt";
        L27:
            r8.a(r9, r4, this.a.n3(), "player_status_end");
        L28:
            VoiceCallTraceLogger r10 = this.a.o3();
            if (r10 == null) goto L31;
            z r11 = this.a.n3();
            Intrinsics.checkNotNullParameter(r11, "baseContext");
            r10.h(new c0(r10, r11));
        L31:
            this.a.J.a(new com.larus.voicecall.impl.tracer.b(4, System.currentTimeMillis(), Boolean.valueOf(r2)));
            this.a.s3();
            return;
        }

        public final void c() {
            int r0 = c68.b.a;
            c68.b.a(this.a.f, "onPlayFirstFrame");
            CommonCallSessionMonitor<C> r1 = this.a;
            r1.M = true;
            r1.u = SystemClock.elapsedRealtime();
            CommonCallSessionMonitor<C> r2 = this.a;
            r2.v = System.currentTimeMillis();
            CommonCallSessionMonitor<C> r3 = this.a;
            if (r3.L == false) goto L8;
            c68.b.a(r3.f, "onPlayFirstFrame，is receiving chime，event = 1");
            VoiceCallTraceLogger r4 = this.a.o3();
            if (r4 == null) goto L7;
            r4.a(ReplyAudioEventType.CHIME_IN_START, "normal", this.a.n3(), "audio_first_frame");
        L7:
            this.a.J.a(new com.larus.voicecall.impl.tracer.b(1, System.currentTimeMillis(), null));
            return;
        L8:
            c68.b.a(r3.f, "onPlayFirstFrame，not receive chime，event = 3");
            VoiceCallTraceLogger r5 = this.a.o3();
            if (r5 == null) goto L11;
            r5.a(ReplyAudioEventType.REPLY_BEGIN, "normal", this.a.n3(), "audio_first_frame");
        L11:
            this.a.J.a(new com.larus.voicecall.impl.tracer.b(3, System.currentTimeMillis(), null));
        }

        public final void onPlayComplete() {
            int r0 = c68.b.a;
            c68.b.a(this.a.f, "onPlayComplete");
            MajorState.d r1 = this.b.a().s1();
            CommonCallSessionMonitor<C> r2 = this.a;
            if (r2.x == true) goto L5;
        L9:
            IRealtimeCallTracer r3 = this.b.k();
            RealtimeCallUtil.a.getClass();
            String r4 = RealtimeCallUtil.g();
            CommonCallSessionMonitor<C> r5 = this.a;
            r3.o(r4, r5.o.a, r5.y, r5.x, r5.p, r5.v, System.currentTimeMillis(), this.a.I, "response");
            return;
        L5:
            if ((r1 instanceof MajorState.d) == false) goto L9;
            if (r1.d != MajorState.InterruptType.NOTHING) goto L9;
            r2.y = true;
            goto L9
        }

        public b(CommonCallSessionMonitor<C> r1, C r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements com.larus.im.service.audio.x {
        public final String a;
        public final DataType b;
        public final /* synthetic */ CommonCallSessionMonitor<C> c;

        public final String getName() {
            return this.a;
        }

        public DataType getType() {
            return this.b;
        }

        public c(CommonCallSessionMonitor<C> r1) {
            this.c = r1;
            this.a = r1.f;
            this.b = DataType.PLAYER;
        }

        public final void a(com.larus.im.service.audio.l r4) {
            Intrinsics.checkNotNullParameter(r4, "frame");
            j r0 = this.c.n;
            if (r0 == null) goto L6;
            int r5 = r4.a.length;
            int r1 = r0.B;
            int r2 = c4a.a.a;
            r0.B = r1 + ((int) (((r5 / 24000) / 2) * 1000));
            return;
        }
    }

    public static final class d extends a1 {
        public final String a;
        public final /* synthetic */ CommonCallSessionMonitor<C> b;
        public final /* synthetic */ C c;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[TriggerMode.values().length];
                r0[TriggerMode.CLIM_IN_STARTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
            L11:
                r0[TriggerMode.CLIM_IN_END.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
            L15:
                r0[TriggerMode.INTERPRET_ASR_STARTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
            L6:
                a = r0;
            }
        }

        public final String g() {
            return this.a;
        }

        public final void n(z0.a r26) {
            Intrinsics.checkNotNullParameter(r26, "event");
            boolean r3 = r26 instanceof pf9.o;
            String r4 = NameKeys.UnloadStrategy_No_Strategy;
            if (r3 == false) goto L9;
            CommonCallSessionMonitor<C> r2 = this.b;
            if (r2.n != null) goto L7;
            r2.n = r2.k3(NameKeys.UnloadStrategy_No_Strategy);
        L7:
            this.c.k().m0(((pf9.o) r26).j);
            return;
        L9:
            if ((r26 instanceof o0) == false) goto L12;
            this.c.k().m0(((o0) r26).b);
            return;
        L12:
            if ((r26 instanceof pf9.i0) == false) goto L24;
            final VoiceCallTraceLogger r0 = this.b.o3();
            if (r0 == null) goto L16;
            final z r5 = this.b.n3();
            final boolean r6 = this.b.K;
            Intrinsics.checkNotNullParameter(r5, "baseContext");
            r0.h(new h0(r0, r6, r5));
        L16:
            CommonCallSessionMonitor<C> r1 = this.b;
            r1.getClass();
            Intrinsics.checkNotNullParameter(NameKeys.UnloadStrategy_No_Strategy, "questionId");
            j r7 = r1.n;
            if (r7 == null) goto L19;
            r7.s();
        L19:
            j r8 = r1.n;
            if (r8 == null) goto L22;
            com.larus.audio.call.arch.b.a(r8.a).e0().j(r8.I);
        L22:
            r1.n = r1.k3(NameKeys.UnloadStrategy_No_Strategy);
            return;
        L24:
            if ((r26 instanceof pf9.z) == false) goto L59;
            final VoiceCallTraceLogger r9 = this.b.o3();
            if (r9 == null) goto L28;
            final z r10 = this.b.n3();
            final boolean r11 = this.b.K;
            Intrinsics.checkNotNullParameter(r10, "baseContext");
            r9.h(new h0(r9, r11, r10));
        L28:
            j r12 = this.b.n;
            if (r12 == null) goto L31;
            r12.h((pf9.z) r26);
        L31:
            RealtimeCallUtil.a.getClass();
            if (RealtimeCallUtil.v == false) goto L42;
            MajorState.d r13 = this.c.a().s1();
            if ((r13 instanceof MajorState.d) == false) goto L41;
            MajorState.d r14 = r13;
            if (r14.c != MajorState.From.PLAY_COMPLETE) goto L38;
        L40:
            yp9.d.b.a(this.b.f, "listening,from:" + r14.c + ",interruptType:" + r14.d);
            goto L41
        L38:
            if (r14.d != MajorState.InterruptType.AUTO) goto L40;
            IRealtimeCallTracer r15 = this.c.k();
            RealtimeCallParam r16 = this.c.params();
            CommonCallSessionMonitor<C> r17 = this.b;
            r15.w(r16, r17.G, true, ((pf9.z) r26).b, r17.t, r17.u, r17.z);
        L41:
            this.c.k().Q(IRealtimeCallTracer.HelloStatus.INTERRUPT, "speak_interrupt");
        L42:
            CommonCallSessionMonitor<C> r18 = this.b;
            pf9.z r19 = (pf9.z) r26;
            String r20 = r19.a;
            if (r20 == null) goto L46;
            r4 = r20;
        L46:
            r18.s = r4;
            final VoiceCallTraceLogger r21 = r18.o3();
            if (r21 == null) goto L49;
            final z r110 = this.b.n3();
            final long r111 = r19.c;
            final Long r112 = Long.valueOf(r19.d);
            final long r113 = r19.c;
            final String r22 = r19.e;
            Intrinsics.checkNotNullParameter(r110, "baseContext");
            r21.h(new i0(r21, r110, r111, r113, r112, r22));
        L49:
            CommonCallSessionMonitor<C> r23 = this.b;
            String r24 = r23.s;
            Intrinsics.checkNotNullParameter(r24, "questionId");
            j r25 = r23.n;
            if (r25 == null) goto L52;
            r25.s();
        L52:
            j r27 = r23.n;
            if (r27 == null) goto L55;
            com.larus.audio.call.arch.b.a(r27.a).e0().j(r27.I);
        L55:
            r23.n = r23.k3(r24);
            final j r28 = this.b.n;
            if (r28 == null) goto L58;
            Intrinsics.checkNotNullParameter(r19, "event");
            r28.j = System.currentTimeMillis();
            r28.k = r19.d;
            com.larus.utils.l0.b(new g(r28));
            r28.a.k().I();
        L58:
            CommonCallSessionMonitor<C> r29 = this.b;
            r29.B = r19.b;
            r29.F = true;
            return;
        L59:
            String r30 = null;
            if ((r26 instanceof pf9.c0) == false) goto L82;
            j r31 = this.b.n;
            if (r31 == null) goto L64;
            r31.j((pf9.c0) r26);
        L64:
            j r32 = this.b.n;
            if (r32 == null) goto L67;
            Intrinsics.checkNotNullParameter((pf9.c0) r26, "event");
            r32.a.k().s0();
            r32.a.k().Q(IRealtimeCallTracer.HelloStatus.HELLO_RESET, null);
            r32.y++;
            r32.z = System.currentTimeMillis();
        L67:
            String r33 = this.b.B;
            pf9.c0 r34 = (pf9.c0) r26;
            pf9.a r35 = r34.a;
            if (r35 == null) goto L70;
            String r36 = r35.c;
        L72:
            if (Intrinsics.areEqual(r33, r36) == false) goto L77;
            CommonCallSessionMonitor<C> r37 = this.b;
            pf9.a r38 = r34.a;
            if (r38 == null) goto L76;
            r30 = r38.a;
        L76:
            r37.C = r30;
            FLogger.a.i(r37.f, "[ASR_currentAsrText]: " + g2a.d.b(String.valueOf(this.b.C)));
        L77:
            CommonCallSessionMonitor<C> r39 = this.b;
            if (r39.F == false) goto L414;
            r39.F = false;
            final j r40 = r39.n;
            if (r40 == null) goto L415;
            com.larus.utils.l0.b(new i(r40));
            return;
        L415:
            return;
        L414:
            return;
        L70:
            r36 = null;
            goto L72
        L82:
            long r41 = 0;
            if ((r26 instanceof pf9.a0) == false) goto L102;
            j r42 = this.b.n;
            if (r42 == null) goto L87;
            r42.i((pf9.a0) r26);
        L87:
            CommonCallSessionMonitor<C> r43 = this.b;
            pf9.a0 r44 = (pf9.a0) r26;
            r43.q3(r44, r43.C);
            final VoiceCallTraceLogger r45 = this.b.o3();
            if (r45 == null) goto L417;
            final z r114 = this.b.n3();
            Long r46 = r44.b;
            if (r46 == null) goto L92;
            final long r115 = r46.longValue();
        L93:
            Long r47 = r44.b;
            if (r47 == null) goto L97;
            r41 = r47.longValue();
        L97:
            if (r41 <= 1400) goto L99;
            final boolean r116 = true;
        L100:
            final boolean r48 = r44.c;
            Intrinsics.checkNotNullParameter(r114, "baseContext");
            r45.h(new j0(r45, r114, r115, r116, r48));
            return;
        L99:
            r116 = false;
            goto L100
        L92:
            r115 = 0;
            goto L93
        L417:
            return;
        L102:
            if ((r26 instanceof pf9.d0) == false) goto L129;
            j r49 = this.b.n;
            if (r49 == null) goto L106;
            r49.k((pf9.d0) r26);
        L106:
            j r50 = this.b.n;
            if (r50 == null) goto L111;
            pf9.d0 r51 = (pf9.d0) r26;
            Intrinsics.checkNotNullParameter(r51, "event");
            r50.F = Intrinsics.areEqual(r51.a, "v3");
            r50.a.k().F(r51.b);
            if (r50.o == false) goto L111;
            r50.o = false;
            com.larus.utils.l0.b(new f(r50, 0, false));
            com.larus.audio.call.tracer.b.b(r50.a.i(), "llm_phase", null, 6);
            r50.a.i().f("tts_delay", "realcall_message");
        L111:
            VoiceCallTraceLogger r52 = this.b.o3();
            if (r52 == null) goto L114;
            ((ArrayList) r52.j).clear();
            r52.k = null;
        L114:
            final VoiceCallTraceLogger r53 = this.b.o3();
            if (r53 == null) goto L117;
            final z r54 = this.b.n3();
            final boolean r55 = ((pf9.d0) r26).b;
            Intrinsics.checkNotNullParameter(r54, "baseContext");
            Intrinsics.checkNotNullParameter("reply_begin_event", "source");
            r53.h(new b0(r53, r55, r54));
        L117:
            pf9.d0 r56 = (pf9.d0) r26;
            if (r56.b == false) goto L122;
            final VoiceCallTraceLogger r57 = this.b.o3();
            if (r57 == null) goto L122;
            final z r58 = this.b.n3();
            Intrinsics.checkNotNullParameter(r58, "baseContext");
            r57.h(new k0(r57, r58));
        L122:
            String r59 = r56.c;
            String r60 = u3a.f.a;
            if (Intrinsics.areEqual(r59, "interpret_v2") == false) goto L125;
            this.c.k().L(this.c.params(), (int) (System.currentTimeMillis() - this.b.N), null, null, null, null, null);
        L125:
            CommonCallSessionMonitor<C> r61 = this.b;
            if (r61.N == 0) goto L419;
            JSONObject r62 = new JSONObject();
            r62.put("duration", System.currentTimeMillis() - r61.N);
            r62.put("call_scene", "interpret_v2");
            r62.put("from_language", u3a.f.c());
            r62.put("to_language", u3a.f.d());
            com.larus.platform.service.o.a.reportEvent("interpret_first_packet_time", r62);
            this.b.N = 0;
            return;
        L419:
            return;
        L129:
            if ((r26 instanceof pf9.q) == false) goto L135;
            j r63 = this.b.n;
            if (r63 == null) goto L133;
            r63.g((pf9.q) r26);
        L133:
            this.b.p3((pf9.q) r26);
            return;
        L135:
            if ((r26 instanceof pf9.f0) == false) goto L357;
            j r64 = this.b.n;
            if (r64 == null) goto L139;
            r64.m((pf9.f0) r26);
        L139:
            pf9.f0 r65 = (pf9.f0) r26;
            String r66 = pf9.i.k(r65);
            if (r66.length() <= 0) goto L142;
            boolean r117 = true;
        L143:
            if (r117 == false) goto L154;
            if (Intrinsics.areEqual(this.b.t, r66) == true) goto L154;
            CommonCallSessionMonitor<C> r118 = this.b;
            r118.t = r66;
            r118.u = 0;
            r118.x = false;
            r118.y = false;
            RealtimeCallUtil r67 = RealtimeCallUtil.a;
            pf9.m r119 = r65.c;
            if (r119 == null) goto L151;
            Map r120 = r119.a;
            if (r120 == null) goto L151;
            String r68 = (String) r120.get("speech_hello_tech_type");
        L152:
            r67.getClass();
            RealtimeCallUtil.I = r68;
        L151:
            r68 = null;
        L154:
            if (pf9.i.j(r65) == false) goto L165;
            com.larus.audio.call.play.j r69 = this.b.o;
            r69.getClass();
            r69.b = System.currentTimeMillis();
            pf9.m r70 = r65.c;
            if (r70 == null) goto L160;
            Map r71 = r70.a;
            if (r71 == null) goto L160;
            String r72 = (String) r71.get("tts_content_scene");
        L162:
            if (Intrinsics.areEqual(r72, "pacify") == false) goto L165;
            this.b.p = true;
        L160:
            r72 = null;
        L165:
            if (pf9.i.c(r65) == false) goto L268;
            ReplyStage r73 = r65.d;
            if (r73 != ReplyStage.Begin) goto L169;
        L170:
            pf9.k0 r74 = r65.b;
            if (r74 == null) goto L188;
            String r75 = r74.f;
            if (r75 == null) goto L188;
            if (r75.length() <= 0) goto L177;
            boolean r121 = true;
        L178:
            if (r121 == true) goto L180;
        L182:
            boolean r122 = false;
        L183:
            if (r122 == true) goto L186;
            r75 = null;
        L186:
            if (r75 == null) goto L188;
            this.b.z = r75;
            goto L188
        L180:
            if (Intrinsics.areEqual(r75, "0") == true) goto L182;
            r122 = true;
            goto L183
        L177:
            r121 = false;
        L188:
            ReplyStage r76 = r65.d;
            if (r76 != ReplyStage.Update) goto L239;
            CommonCallSessionMonitor<C> r77 = this.b;
            pf9.k0 r78 = r65.b;
            if (r78 == null) goto L195;
            Map r79 = r78.n;
            if (r79 == null) goto L195;
            String r80 = (String) r79.get("query_round");
        L196:
            if (r80 != null) goto L198;
            r80 = NameKeys.UnloadStrategy_No_Strategy;
        L198:
            r77.I = r80;
            CommonCallSessionMonitor<C> r81 = this.b;
            Result.Companion r82 = Result.Companion;     // Catch: Throwable -> L211
            Long r83 = StringsKt.toLongOrNull(r81.I);     // Catch: Throwable -> L211
            if (r83 == null) goto L207;
            Object r210 = "tts_content_scene";
            final long r84 = r83.longValue();     // Catch: Throwable -> L205
            final VoiceCallTraceLogger r85 = r81.o3();     // Catch: Throwable -> L205
            if (r85 == null) goto L208;
            r85.h(new f0(r85, r84));     // Catch: Throwable -> L205
            Unit r86 = Unit.INSTANCE;     // Catch: Throwable -> L205
        L209:
            Result.constructor-impl(r86);     // Catch: Throwable -> L205
        L214:
            VoiceCallTraceLogger r87 = this.b.o3();
            if (r87 == null) goto L269;
            Intrinsics.checkNotNullParameter(r65, "event");
            pf9.k0 r88 = r65.b;
            if (r88 == null) goto L269;
            if (r88.d == false) goto L230;
            r87.k = Boolean.TRUE;
            String r89 = r88.b;
            if (r89 != null) goto L224;
        L227:
            boolean r90 = true;
        L228:
            if (r90 == true) goto L269;
            ((ArrayList) r87.j).add(r89);
            goto L269
        L224:
            if (r89.length() == 0) goto L227;
            r90 = false;
            goto L228
        L230:
            r87.k = Boolean.FALSE;
            String r91 = r88.a;
            if (r91 != null) goto L233;
        L236:
            boolean r92 = true;
        L237:
            if (r92 == true) goto L269;
            ((ArrayList) r87.j).add(r91);
            goto L269
        L233:
            if (r91.length() == 0) goto L236;
            r92 = false;
        L269:
            CommonCallSessionMonitor<C> r93 = this.b;
            if (r93.i.a == false) goto L422;
            j r94 = r93.n;
            if (r94 == null) goto L423;
            String r95 = r93.D;
            Intrinsics.checkNotNullParameter(r65, "event");
            if (pf9.i.c(r65) == false) goto L298;
            ReplyStage r96 = r65.d;
            if (r96 != ReplyStage.Begin) goto L278;
        L279:
            pf9.k0 r97 = r65.b;
            if (r97 == null) goto L298;
            String r123 = r97.f;
            if (r123 == null) goto L298;
            if (r123.length() <= 0) goto L286;
            boolean r98 = true;
        L287:
            if (r98 == true) goto L289;
        L291:
            boolean r99 = false;
        L292:
            if (r99 == true) goto L295;
            r123 = null;
        L295:
            if (r123 == null) goto L298;
            r94.D = r123;
            goto L298
        L289:
            if (Intrinsics.areEqual(r123, "0") == true) goto L291;
            r99 = true;
            goto L292
        L286:
            r98 = false;
            goto L287
        L278:
            if (r96 == ReplyStage.Update) goto L279;
        L298:
            if (r65.d == ReplyStage.Update) goto L301;
            return;
        L301:
            if (pf9.i.c(r65) == false) goto L325;
            if (r65.b == null) goto L325;
            if (pf9.i.c(r65) == true) goto L307;
        L309:
            IRealtimeCallTracer r100 = r94.a.k();
            pf9.k0 r101 = r65.b;
            if (r101 == null) goto L312;
            String r124 = r101.a;
        L313:
            if (r124 != null) goto L315;
            r124 = NameKeys.UnloadStrategy_No_Strategy;
        L315:
            if (r101 == null) goto L319;
            Map r102 = r101.n;
            if (r102 == null) goto L319;
            String r103 = (String) r102.get("agent_intention");
        L320:
            if (r103 == null) goto L323;
            r4 = r103;
        L323:
            r100.H(r124, r4);
        L319:
            r103 = null;
            goto L320
        L312:
            r124 = null;
            goto L313
        L307:
            if (r65.d != ReplyStage.End) goto L309;
            com.larus.utils.l0.b(new f(r94, 1, false));
        L325:
            if (pf9.i.j(r65) == false) goto L354;
            pf9.m r104 = r65.c;
            if (r104 == null) goto L354;
            Map r105 = r104.a;
            if (r105 == null) goto L331;
            String r106 = (String) r105.get(r210);
        L332:
            IRealtimeCallTracer r125 = r94.a.k();
            RealtimeCallParam r211 = r94.a.params();
            com.larus.audio.call.arch.c r107 = r94.a;
            Intrinsics.checkNotNullParameter(r107, "<this>");
            r125.P(r211, Long.valueOf(r107.b(Reflection.getOrCreateKotlinClass(com.larus.call_plugins_doubao_common.k.class), null).B2()), r95, r94.D, r94.b);
            if (Intrinsics.areEqual(r106, "pacify") == false) goto L338;
            if (r94.n == false) goto L351;
            r94.n = false;
            com.larus.utils.l0.b(new h(r94, 2));
        L351:
            if (r94.C <= 0) goto L354;
            r94.a.k().a(AppeaseType.VOICE.getScene(), (int) (System.currentTimeMillis() - r94.C));
            r94.C = 0;
            goto L354
        L338:
            if (Intrinsics.areEqual(r106, "mute") == false) goto L341;
            r94.a.k().a(AppeaseType.PEOPLE.getScene(), r94.B);
            goto L351
        L341:
            if (r94.m == false) goto L343;
            r94.m = false;
            r94.a.k().Q(IRealtimeCallTracer.HelloStatus.PLAY_HELLO, null);
            com.larus.audio.call.tracer.b.b(r94.a.i(), "tts_delay", null, 6);
            com.larus.audio.call.tracer.b.b(r94.a.i(), "realcall_message", null, 6);
            r94.p = System.currentTimeMillis();
            r94.r = false;
            j.q(r94, 0, -2, null, null, 12);
            com.larus.utils.l0.b(new h(r94, 0));
            l r108 = new l(r94);
            r94.w = r108;
            r108.d();
        L343:
            k r109 = r94.v;
            if (r109 == null) goto L346;
            r109.a();
        L346:
            r94.v = null;
            if (r94.t == true) goto L351;
            k r126 = new k(r94);
            r94.v = r126;
            r126.d();
            goto L351
        L331:
            r106 = null;
        L354:
            if (r94.F == true) goto L424;
            r94.F = pf9.i.e(pf9.i.a(r65));
            return;
        L424:
            return;
        L423:
            return;
        L422:
            return;
        L208:
            r86 = null;
        L205:
            th = th;
        L213:
            Result.Companion r127 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
            goto L214
        L207:
            r210 = "tts_content_scene";
        L211:
            th = th;
            r210 = "tts_content_scene";
        L195:
            r80 = null;
            goto L196
        L239:
            r210 = "tts_content_scene";
            if (r76 != ReplyStage.End) goto L269;
            CommonCallSessionMonitor<C> r128 = this.b;
            r128.getClass();
            Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L255
            String r130 = r128.D;     // Catch: Throwable -> L255
            if (r130 == null) goto L246;
            String r131 = new JSONObject(r130).optString("agent_intention");     // Catch: Throwable -> L255
        L247:
            if (r131 == null) goto L402;
        L251:
            Object r132 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L253
        L258:
            Throwable r133 = Result.exceptionOrNull-impl(r132);
            if (r133 == null) goto L261;
            FLogger.a.e(r128.f, r133.getMessage());
        L261:
            IRealtimeCallTracer r134 = r128.getContext().k();
            RealtimeCallParam r135 = r128.getContext().params();
            String r136 = r128.z;
            String r137 = r128.A;
            r128.m3(r136);
            r134.A(r135, r136, r137, r131);
            final VoiceCallTraceLogger r138 = this.b.o3();
            if (r138 == null) goto L269;
            final z r139 = this.b.n3();
            pf9.k0 r140 = r65.b;
            if (r140 == null) goto L266;
            final String r141 = r140.f;
        L267:
            final String r142 = this.b.t;
            Intrinsics.checkNotNullParameter(r139, "baseContext");
            r138.h(new g0(r138, r139, r141, r142));
            goto L269
        L266:
            r141 = null;
        L253:
            th = th;
            String r143 = r131;
        L257:
            Result.Companion r144 = Result.Companion;
            r132 = Result.constructor-impl(ResultKt.createFailure(th));
            r131 = r143;
            goto L258
        L402:
            String r145 = r128.E;     // Catch: Throwable -> L253
            if (r145 == null) goto L251;
            r131 = new JSONObject(r145).optString("agent_intention");     // Catch: Throwable -> L253
            goto L251
        L246:
            r131 = null;
        L255:
            th = th;
            r143 = null;
            goto L257
        L169:
            if (r73 != ReplyStage.Update) goto L188;
        L268:
            r210 = "tts_content_scene";
            goto L269
        L142:
            r117 = false;
            goto L143
        L357:
            if ((r26 instanceof pf9.e0) == false) goto L380;
            j r146 = this.b.n;
            if (r146 == null) goto L361;
            r146.l((pf9.e0) r26);
        L361:
            CommonCallSessionMonitor<C> r147 = this.b;
            r147.x = true;
            final VoiceCallTraceLogger r148 = r147.o3();
            if (r148 == null) goto L368;
            final z r149 = this.b.n3();
            if (((pf9.e0) r26).b == false) goto L366;
            final String r150 = "reply_end_no_reply";
        L367:
            Intrinsics.checkNotNullParameter(r149, "baseContext");
            Intrinsics.checkNotNullParameter(r150, "source");
            r148.h(new e0(r148, r149, r150));
            goto L368
        L366:
            r150 = "reply_end_generated";
        L368:
            CommonCallSessionMonitor<C> r151 = this.b;
            if (r151.i.a == false) goto L376;
            j r152 = r151.n;
            if (r152 == null) goto L376;
            FLogger.a.i("RealtimeCallQueryMonitor", "onTTSEnded");
            k r153 = r152.v;
            if (r153 == null) goto L375;
            r153.a();
        L375:
            r152.v = null;
            r152.A = true;
            com.larus.utils.l0.b(new h(r152, 1));
        L376:
            j r154 = this.b.n;
            if (r154 == null) goto L426;
            r154.a.k().t0();
            return;
        L426:
            return;
        L380:
            if ((r26 instanceof pf9.r) == false) goto L399;
            int r155 = sf9.b.a;
            pf9.r r156 = (pf9.r) r26;
            if (sf9.b.a(r156.getType()) == false) goto L384;
            this.c.k().W();
            this.c.k().t();
        L384:
            int r157 = a.a[r156.getType().ordinal()];
            if (r157 != 1) goto L387;
            this.b.w = System.currentTimeMillis();
            int r158 = c68.b.a;
            c68.b.a(this.b.f, "CLIM_IN_STARTED");
            CommonCallSessionMonitor<C> r159 = this.b;
            r159.K = true;
            r159.L = true;
            return;
        L387:
            if (r157 != 2) goto L389;
            CommonCallSessionMonitor<C> r160 = this.b;
            IRealtimeCallTracer r161 = r160.getContext().k();
            RealtimeCallUtil.a.getClass();
            String r162 = RealtimeCallUtil.g();
            boolean r163 = r160.y;
            boolean r164 = r160.x;
            boolean r165 = r160.p;
            long r166 = r160.w;
            long r167 = System.currentTimeMillis();
            Integer r168 = StringsKt.toIntOrNull(r160.I);
            if (r168 == null) goto L395;
            int r169 = r168.intValue();
        L396:
            r161.o(r162, 0, r163, r164, r165, r166, r167, String.valueOf(r169 + 1), "chime");
            int r170 = c68.b.a;
            c68.b.a(this.b.f, "CLIM_IN_STARTED");
            this.b.K = false;
            return;
        L395:
            r169 = 0;
            goto L396
        L389:
            if (r157 != 3) goto L433;
            int r171 = c68.b.a;
            c68.b.a(this.b.f, "INTERPRET_ASR_STARTED");
            this.b.N = System.currentTimeMillis();
            return;
        L433:
            return;
        L399:
            if ((r26 instanceof n0) == false) goto L431;
            CommonCallSessionMonitor.j3(this.b, ((n0) r26).a);
            return;
        }

        public d(CommonCallSessionMonitor<C> r1, C r2) {
            this.b = r1;
            this.c = r2;
            this.a = r1.f;
        }

        public final void q(String r2, Object r3) {
            Intrinsics.checkNotNullParameter(r2, "event");
            Intrinsics.checkNotNullParameter(r2, "event");
            this.b.r3(r2, r3);
        }
    }

    public final com.larus.im.service.audio.v R2() {
        return this;
    }

    public final void Y2() {
    }

    @Override // com.larus.voicecall.impl.tracer.o
    public final void d0() {
        this.S = true;
    }

    public Map<String, String> m3(String r1) {
        return null;
    }

    static {
        T = new Regex("code(\\d+)desc(.*?)$");
    }

    public final com.larus.im.service.audio.x Q2() {
        return new c(this);
    }

    public final void b3() {
        if (this.y == false) goto L5;
    L13:
        getContext().k().Q(IRealtimeCallTracer.HelloStatus.HELLO_RESET, null);
        j r0 = this.n;
        boolean r1 = false;
        if (r0 != null) goto L16;
    L20:
        IRealtimeCallTracer r4 = getContext().k();
        RealtimeCallParam r5 = getContext().params();
        IRealtimeCallTracer.EnterCallSessionStatus r6 = this.h;
        String r7 = getContext().params().p.j;
        int r8 = this.q;
        String r9 = this.r;
        MajorState.d r2 = getContext().a().s1();
        if ((r2 instanceof MajorState.h) == false) goto L24;
    L29:
        r4.p0(r5, r6, r7, r8, r9, Boolean.valueOf(r1));
        Job r3 = this.H;
        if (r3 == null) goto L32;
        Job.DefaultImpls.cancel$default(r3, null, 1, null);
    L32:
        this.H = null;
        return;
    L24:
        if ((r2 instanceof MajorState.d) == true) goto L26;
    L28:
        r1 = true;
        goto L29
    L26:
        if (r2.c != MajorState.From.TTS_ENDED) goto L28;
    L16:
        if (this.q == 0) goto L18;
        boolean r10 = true;
    L19:
        r0.e(r10);
        goto L20
    L18:
        r10 = false;
        goto L19
    L5:
        if (this.l == false) goto L13;
        VoiceCallTraceLogger r11 = o3();
        if (r11 == null) goto L9;
        r11.a(ReplyAudioEventType.REPLY_END, "interrupt", n3(), "auto_end_on_release");
    L9:
        VoiceCallTraceLogger r12 = o3();
        if (r12 == null) goto L12;
        z r13 = n3();
        Intrinsics.checkNotNullParameter(r13, "baseContext");
        r12.h(new c0(r12, r13));
    L12:
        this.J.a(new com.larus.voicecall.impl.tracer.b(4, System.currentTimeMillis(), Boolean.FALSE));
        s3();
        IRealtimeCallTracer r14 = getContext().k();
        RealtimeCallUtil.a.getClass();
        r14.o(RealtimeCallUtil.g(), this.o.a, this.y, this.x, this.p, this.v, System.currentTimeMillis(), this.I, "response");
        goto L13
    }

    public final z n3() {
        String r0 = getContext().params().e;
        if (r0 != null) goto L5;
        String r2 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        String r3 = getContext().params().d;
        String r4 = this.s;
        String r1 = this.B;
        if (r1 != null) goto L9;
        String r5 = NameKeys.UnloadStrategy_No_Strategy;
    L10:
        String r6 = this.t;
        if (r6 != null) goto L13;
        String r7 = NameKeys.UnloadStrategy_No_Strategy;
    L15:
        return new z(r2, r3, r4, r5, r7);
    L13:
        r7 = r6;
        goto L15
    L9:
        r5 = r1;
        goto L10
    L5:
        r2 = r0;
        goto L6
    }

    public final VoiceCallTraceLogger o3() {
        return (VoiceCallTraceLogger) this.O.getValue();
    }

    public final void s3() {
        if (Intrinsics.areEqual(this.I, "0") == false) goto L5;
        return;
    L5:
        if (this.J.a.size() == 0) goto L22;
        JSONObject r0 = new JSONObject();
        r0.put("round", this.I);
        com.larus.voicecall.impl.tracer.a r1 = this.J;
        r1.getClass();
        JSONArray r2 = new JSONArray();
        ArrayList r3 = new ArrayList();
        r1.a.drainTo(r3);
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L13;
        com.larus.voicecall.impl.tracer.b r5 = (com.larus.voicecall.impl.tracer.b) r4.next();
        JSONObject r6 = new JSONObject();
        r6.put("event_type", r5.a);
        r6.put("event_millis", r5.b);
        if (CollectionsKt.listOf(new Integer[]{4, 2}).contains(Integer.valueOf(r5.a)) == false) goto L12;
        r6.put("end_type", !Intrinsics.areEqual(r5.c, Boolean.TRUE) ? 1 : 0);
    L12:
        r2.put(r6);
        goto L8
    L13:
        r0.put("events", r2);
        id9.d r7 = getContext().j();
        if (r7 == null) goto L16;
        r7.p(TriggerMode.AUDIO_ROUND_TRACE, r0.toString());
    L16:
        this.J.a.clear();
        int r8 = c68.b.a;
        c68.b.d(this.f, "handleRoundTrace takeAllAndConvertToJson and trigger PlayStatusTrace: " + HttpExtKt.p(r0));
        return;
    }

    @Override // com.larus.voicecall.impl.tracer.o
    public final void v() {
        j r0 = this.n;
        if (r0 == null) goto L6;
        r0.C = System.currentTimeMillis();
        return;
    }

    public final void X2() {
        getContext().k().w(getContext().params(), this.G, false, null, this.t, this.u, this.z);
        getContext().k().Q(IRealtimeCallTracer.HelloStatus.INTERRUPT, "manual_interrupt");
    }

    public final void Z2() {
        getContext().k().Z(getContext().params(), this.G);
    }

    public final void a3() {
        getContext().i().f("connecting", "call");
        getContext().i().f("create_audio_session", "connecting");
    }

    public final void c3() {
        getContext().k().C(getContext().params());
    }

    public void e3() {
        super.e3();
        this.j = SystemClock.elapsedRealtime();
        RealtimeCallUtil r0 = RealtimeCallUtil.a;
        String r1 = getContext().params().o.h;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        RealtimeCallUtil.w = r1;
        RealtimeCallUtil.x = getContext().params().o.c;
        RealtimeCallUtil.y = getContext().params().e;
        RealtimeCallUtil.G = true;
        RealtimeCallUtil.H = getContext().params().P;
        getContext().i().f("create_audio_session", "connecting");
        if (this.m == false) goto L5;
        getContext().k().r();
    L5:
        Job r3 = null;
        getContext().k().Q(IRealtimeCallTracer.HelloStatus.START_SESSION, null);
        if (com.larus.audio.call.f.f() == false) goto L8;
        final i1 r2 = d3a.a.c(getContext()).y();
        Flow<Integer> r4 = kotlinx.coroutines.flow.e.n(new CommonCallSessionMonitor$onStart$$inlined$map$1(r2));
    L9:
        getContext().k().a0(r4, getContext().r(), getContext().params());
        w3(IRealtimeCallTracer.EnterCallSessionStatus.CREATE_HANDLE);
        if (this.H != null) goto L15;
        CoroutineScope r5 = getContext().r();
        if (r5 == null) goto L14;
        r3 = BuildersKt.launch$default(r5, null, null, new CommonCallSessionMonitor$observerUIStateChange$1(this, null), 3, null);
    L14:
        this.H = r3;
    L15:
        Iterator r6 = CollectionsKt.mutableListOf(new com.larus.audio.call.play.e[]{this.o, this.P}).iterator();
    L17:
        if (r6.hasNext() == false) goto L19;
        com.larus.audio.call.arch.b.a(getContext()).e0().i((com.larus.audio.call.play.e) r6.next());
        goto L17
    L19:
        return;
    L8:
        final MutableSharedFlow r7 = d3a.a.c(getContext()).i1();
        r4 = new CommonCallSessionMonitor$onStart$$inlined$map$2(r7);
        goto L9
    }

    public final void f3() {
        com.larus.audio.call.tracer.b.b(getContext().i(), "create_audio_session", "start aborted", 4);
        com.larus.audio.call.tracer.b.b(getContext().i(), "connecting", "start aborted", 4);
        getContext().i().c();
    }

    public final void g3() {
        super.g3();
        RealtimeCallUtil.a.getClass();
        RealtimeCallUtil.G = false;
        RealtimeCallUtil.H = false;
        getContext().k().Q(IRealtimeCallTracer.HelloStatus.INTERRUPT, "end_call");
        getContext().i().c();
    }

    public final void h3() {
        getContext().k().o0();
    }

    public final z0 S2() {
        return this.Q;
    }

    public final String T2() {
        return this.f;
    }

    public final String getName() {
        return this.g;
    }

    public CommonCallSessionMonitor(C r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3);
        this.f = "CommonCallSessionMonitor";
        this.g = "CommonCallSessionMonitor";
        this.h = IRealtimeCallTracer.EnterCallSessionStatus.INITIAL;
        this.i = jd9.c.f.c;
        this.k = -1;
        this.m = true;
        this.o = new com.larus.audio.call.play.j();
        this.r = NameKeys.UnloadStrategy_No_Strategy;
        this.s = NameKeys.UnloadStrategy_No_Strategy;
        this.G = -1;
        this.I = "0";
        this.J = new com.larus.voicecall.impl.tracer.a();
        this.O = LazyKt.lazy(new m());
        this.P = new b(this, r3);
        this.Q = new d(this, r3);
    }

    private final void l3(String r3) {
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
        getContext().k().K(r0);
        return;
    L6:
        r4 = null;
    L11:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    private final void w3(IRealtimeCallTracer.EnterCallSessionStatus r5) {
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

    public j k3(String r5) {
        Intrinsics.checkNotNullParameter(r5, "questionId");
        return new j(getContext(), r5, false, new n(this));
    }

    public void p3(pf9.q r6) {
        Intrinsics.checkNotNullParameter(r6, "event");
        if (this.i.a == false) goto L7;
        j r0 = this.n;
        if (r0 == null) goto L7;
        r0.f(r6);
    L7:
        pf9.p r1 = (pf9.p) CollectionsKt.firstOrNull(r6.a);
        if (r1 == null) goto L16;
        Map r2 = r1.b;
        if (r2 == null) goto L16;
        String r3 = (String) r2.get("tea_tags_time_cost");
        if (r3 == null) goto L16;
        this.D = r3;
        String r4 = p0.b(r3).optString("agent_id");
        if (com.larus.utils.o0.d(r4) == false) goto L16;
        FLogger.a.i(this.f, "traceAgentId is " + r4);
        this.A = r4;
    L16:
        pf9.p r7 = (pf9.p) CollectionsKt.firstOrNull(r6.a);
        if (r7 == null) goto L24;
        Map r8 = r7.b;
        if (r8 == null) goto L25;
        String r9 = (String) r8.get("fpa_common_param");
        if (r9 == null) goto L26;
        this.E = r9;
        return;
    L26:
        return;
    L25:
        return;
    }

    public void v3(boolean r12) {
        getContext().k().j(getContext().params(), r12, this.h, this.k, SystemClock.elapsedRealtime() - this.j, true);
    }

    public static final /* synthetic */ void j3(CommonCallSessionMonitor r0, String r1) {
        r0.l3(r1);
    }

    @Override // com.larus.voicecall.impl.tracer.o
    public final void B(int r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "errMsg");
        t3(r2, r3, null);
    }

    public final void O1(jd9.c r10, jd9.c r11) {
        Intrinsics.checkNotNullParameter(r10, "oldState");
        Intrinsics.checkNotNullParameter(r11, "newState");
        ouc.d0 r12 = r11.b;
        if (r12 == null) goto L16;
        String r13 = sf9.a.c(r12, "roomId", NameKeys.UnloadStrategy_No_Strategy);
        if (r13 != null) goto L8;
    L11:
        boolean r4 = true;
    L12:
        if (r4 == true) goto L16;
        RealtimeCallParam r5 = getContext().params();
        r5.getClass();
        Intrinsics.checkNotNullParameter(r13, "<set-?>");
        r5.d = r13;
        goto L16
    L8:
        if (StringsKt.isBlank(r13) == true) goto L11;
        r4 = false;
    L16:
        if ((r11 instanceof jd9.c.d) == false) goto L37;
        jd9.c.d r14 = (jd9.c.d) r11;
        int r6 = r14.c;
        if (r6 != 20006) goto L20;
        getContext().k().Q(IRealtimeCallTracer.HelloStatus.INTERRUPT, "disconnect_2");
    L22:
        String r7 = r14.f;
        if (StringsKt.isBlank(r7) == false) goto L25;
        r7 = r14.e;
    L25:
        int r8 = r14.c;
        ue9.c.u r9 = ue9.c.u.c;
        if (r8 == 20010) goto L35;
        ue9.c.q r15 = ue9.c.q.c;
        if (r8 == 20011) goto L35;
        ue9.c.w r16 = ue9.c.w.c;
        if (r8 == 20006) goto L34;
        ue9.c.v r17 = ue9.c.v.c;
        if (r8 == 20007) goto L34;
    L36:
        t3(r8, r7, r14.f);
    L34:
        r8 = -1;
    L35:
        r8 = -3;
        goto L36
    L20:
        if (r6 != 20007) goto L22;
        getContext().k().Q(IRealtimeCallTracer.HelloStatus.INTERRUPT, "disconnect_3");
    L37:
        boolean r18 = r11 instanceof jd9.c.a;
        if (r18 == true) goto L73;
    L61:
        if (r18 == false) goto L66;
        if (((jd9.c.a) r11).c == false) goto L66;
        this.k = SystemClock.elapsedRealtime() - this.j;
    L66:
        if (this.l == true) goto L71;
        if (r18 == false) goto L71;
        if (((jd9.c.a) r11).c == true) goto L71;
        this.l = true;
        w3(IRealtimeCallTracer.EnterCallSessionStatus.SESSION_STARTED);
        v3(this.m);
        getContext().k().Q(IRealtimeCallTracer.HelloStatus.SESSION_SUCCESS, null);
        com.larus.audio.call.tracer.b.b(getContext().i(), "create_audio_session", null, 6);
        com.larus.audio.call.tracer.b.b(getContext().i(), "connecting", null, 6);
        this.q = 0;
        this.r = NameKeys.UnloadStrategy_No_Strategy;
        this.m = false;
    L71:
        this.i = r11;
        return;
    L73:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L55
        ouc.d0 r20 = r11.b;     // Catch: Throwable -> L55
        if (r20 == null) goto L42;
        String r21 = sf9.a.c(r20, "taskId", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L55
    L43:
        if (r21 != null) goto L46;
        r21 = NameKeys.UnloadStrategy_No_Strategy;
    L46:
        if (StringsKt.isBlank(r21) == false) goto L53;
        ouc.d0 r22 = r11.b;     // Catch: Throwable -> L55
        if (r22 == null) goto L50;
        r21 = sf9.a.c(r22, "roomId", NameKeys.UnloadStrategy_No_Strategy);     // Catch: Throwable -> L55
    L51:
        if (r21 != null) goto L53;
        r21 = NameKeys.UnloadStrategy_No_Strategy;
        goto L53
    L50:
        r21 = null;
    L53:
        Object r2 = Result.constructor-impl(r21);     // Catch: Throwable -> L55
    L58:
        if (Result.isFailure-impl(r2) == false) goto L60;
        r2 = NameKeys.UnloadStrategy_No_Strategy;
    L60:
        getContext().k().p((String) r2);
        goto L61
    L42:
        r21 = null;
    L55:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L58
    }

    public void q3(pf9.a0 r9, final String r10) {
        Intrinsics.checkNotNullParameter(r9, "event");
        final VoiceCallTraceLogger r0 = o3();
        if (r0 == null) goto L5;
        final z r3 = n3();
        final String r5 = this.s;
        final String r6 = this.B;
        Intrinsics.checkNotNullParameter(r3, "baseContext");
        r0.h(new d0(r0, r3, r10, r5, r6));
    L5:
        String r1 = null;
        this.z = null;
        this.A = null;
        this.D = null;
        this.E = null;
        com.larus.audio.call.play.j r2 = this.o;
        r2.a = 0;
        r2.b = 0;
        this.p = false;
        if (this.n != null) goto L8;
        this.n = k3(NameKeys.UnloadStrategy_No_Strategy);
    L8:
        j r4 = this.n;
        if (r4 == null) goto L14;
        boolean r7 = this.S;
        Integer r8 = StringsKt.toIntOrNull(this.I);
        if (r8 == null) goto L13;
        r1 = Integer.valueOf(r8.intValue() + 1).toString();
    L13:
        r4.d(r9, r10, r7, r1);
    L14:
        this.S = false;
    }

    public final void r3(String r8, Object r9) {
        Intrinsics.checkNotNullParameter(r8, "event");
        String r2 = null;
        switch(r8.hashCode()) {
            case -1324092820: goto L43;
            case -1129772621: goto L36;
            case 748880164: goto L21;
            case 1003482296: goto L14;
            case 1517194242: goto L6;
            default: goto L61;
        };
    L61:
        return;
    L6:
        if (r8.equals("OTHER_UPDATE_SESSION_STATUS") == true) goto L9;
        return;
    L9:
        if ((r9 instanceof Integer) == false) goto L53;
        IRealtimeCallTracer.EnterCallSessionStatus.a r10 = IRealtimeCallTracer.EnterCallSessionStatus.Companion;
        int r11 = ((Number) r9).intValue();
        r10.getClass();
        IRealtimeCallTracer.EnterCallSessionStatus r12 = IRealtimeCallTracer.EnterCallSessionStatus.a.a(r11);
        if (r12 == null) goto L54;
        w3(r12);
        return;
    L54:
        return;
    L53:
        return;
    L14:
        if (r8.equals("OTHER_EVENT_POST_BACK_AUDIO_CONFIG") == true) goto L17;
        return;
    L17:
        if ((r9 instanceof String) == false) goto L19;
        r2 = (String) r9;
    L19:
        l3(r2);
        return;
    L21:
        if (r8.equals("OTHER_EVENT_RTC_ROOM_ID_GET") == false) goto L64;
        if (r9 != null) goto L25;
        return;
    L25:
        if ((r9 instanceof String) == false) goto L27;
        r2 = (String) r9;
    L27:
        if (r2 != null) goto L29;
    L32:
        boolean r13 = true;
    L33:
        if (r13 == true) goto L58;
        RealtimeCallParam r14 = getContext().params();
        r14.getClass();
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        r14.d = r2;
        return;
    L58:
        return;
    L29:
        if (StringsKt.isBlank(r2) == true) goto L32;
        r13 = false;
        goto L33
    L64:
        return;
    L36:
        if (r8.equals("OTHER_EVENT_CALL_SERVER_START") == true) goto L39;
        return;
    L39:
        if (getContext().params().s != AudioSessionType.SAMI) goto L41;
        this.R = System.currentTimeMillis();
    L41:
        getContext().i().f("create_call", "connecting");
        return;
    L43:
        if (r8.equals("OTHER_EVENT_CALL_SERVER_END") == true) goto L46;
        return;
    L46:
        if (getContext().params().s != AudioSessionType.SAMI) goto L48;
        getContext().k().k(System.currentTimeMillis() - this.R);
    L48:
        com.larus.audio.call.tracer.b r15 = getContext().i();
        if (Intrinsics.areEqual(r9, Boolean.TRUE) == false) goto L51;
        r2 = "create call failed";
    L51:
        com.larus.audio.call.tracer.b.b(r15, "create_call", r2, 4);
    }

    private final void t3(int r13, String r14, String r15) {
        this.q = r13;
        String r0 = NameKeys.UnloadStrategy_No_Strategy;
        if (r14 != null) goto L5;
        String r1 = NameKeys.UnloadStrategy_No_Strategy;
    L6:
        this.r = r1;
        if (this.l == true) goto L9;
        IRealtimeCallTracer r3 = getContext().k();
        RealtimeCallParam r4 = getContext().params();
        if (r14 != null) goto L49;
        r14 = "un_know_error";
    L49:
        r3.f(r4, r14, this.m, this.h, Integer.valueOf(r13), SystemClock.elapsedRealtime() - this.j, true);
    L50:
        this.m = false;
        return;
    L9:
        if (r15 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == false) goto L52;
        Pair r2 = TuplesKt.to(0, NameKeys.UnloadStrategy_No_Strategy);
    L45:
        u3(r13, r14, this.G, ((Number) r2.component1()).intValue(), (String) r2.component2(), r15);
        goto L50
    L52:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L19
        Object r7 = Result.constructor-impl(new JSONObject(r15));     // Catch: Throwable -> L19
    L21:
        String r8 = null;
        if (Result.isFailure-impl(r7) == false) goto L24;
        r7 = null;
    L24:
        JSONObject r9 = (JSONObject) r7;
        if (r9 == null) goto L27;
        r2 = TuplesKt.to(Integer.valueOf(r9.optInt("sub_code", 0)), r9.optString("sub_message", NameKeys.UnloadStrategy_No_Strategy));
        goto L45
    L27:
        MatchResult r10 = Regex.find$default(T, r15, 0, 2, null);
        if (r10 == null) goto L36;
        List r11 = r10.getGroupValues();
        if (r11 == null) goto L36;
        String r12 = (String) CollectionsKt.getOrNull(r11, 1);
        if (r12 == null) goto L36;
        Integer r16 = StringsKt.toIntOrNull(r12);
        if (r16 == null) goto L36;
        int r17 = r16.intValue();
    L37:
        if (r10 == null) goto L41;
        List r18 = r10.getGroupValues();
        if (r18 == null) goto L41;
        r8 = (String) CollectionsKt.getOrNull(r18, 2);
    L41:
        if (r8 == null) goto L44;
        r0 = r8;
    L44:
        r2 = TuplesKt.to(Integer.valueOf(r17), StringsKt.trim(StringsKt.removeSuffix(r0, "bizerror")).toString());
    L36:
        r17 = 0;
    L19:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L11:
        if (StringsKt.isBlank(r15) == true) goto L14;
        r5 = false;
        goto L15
    L5:
        r1 = r14;
        goto L6
    }

    public void u3(int r12, String r13, long r14, int r16, String r17, String r18) {
        getContext().k().U(r12, r13, r14, getContext().params(), Boolean.valueOf(this.l), r16, r17, r18);
    }
}
