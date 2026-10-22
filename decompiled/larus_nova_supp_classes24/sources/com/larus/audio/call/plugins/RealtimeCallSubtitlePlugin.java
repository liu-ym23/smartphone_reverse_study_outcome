package com.larus.audio.call.plugins;

import android.os.SystemClock;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.mgr.MajorState;
import com.larus.audio.call.mgr.StateTriggerEvent;
import com.larus.im.service.audio.cmd.TriggerMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class RealtimeCallSubtitlePlugin extends com.larus.audio.call.arch.a<com.larus.audio.call.arch.c> implements a1 {
    public final String f;
    public boolean g;
    public boolean h;
    public boolean i;
    public final List<Function1<a78.a, Unit>> j;
    public Function1<? super a78.b, Unit> k;
    public Function0<Unit> l;
    public boolean m;
    public Boolean n;
    public Function0<Unit> o;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "RemoteTTSSubtitleBlockData(contentBlock=" + this.a + ", littleSubtitleContent=" + this.b + ')';
        }

        public b(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final boolean f;
        public final String g;
        public final String h;
        public final b i;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
            if (this.f == false) goto L5;
            int r1 = 1231;
        L6:
            int r2 = (((((r0 + r1) * 31) + this.g.hashCode()) * 31) + this.h.hashCode()) * 31;
            b r3 = this.i;
            if (r3 != null) goto L9;
            int r4 = 0;
        L11:
            return r2 + r4;
        L9:
            r4 = r3.hashCode();
            goto L11
        L5:
            r1 = 1237;
            goto L6
        }

        public final String toString() {
            return "RemoteTTSSubtitleData(ttsTaskId=" + this.a + ", sectionId=" + this.b + ", messageId=" + this.c + ", text=" + this.d + ", withdrawText=" + this.e + ", flushed=" + this.f + ", queryRound=" + this.g + ", questionId=" + this.h + ", blockContent=" + this.i + ')';
        }

        public c(String r2, String r3, String r4, String r5, String r6, boolean r7, String r8, String r9, b r10) {
            Intrinsics.checkNotNullParameter(r2, "ttsTaskId");
            Intrinsics.checkNotNullParameter(r3, "sectionId");
            Intrinsics.checkNotNullParameter(r4, "messageId");
            Intrinsics.checkNotNullParameter(r5, "text");
            Intrinsics.checkNotNullParameter(r6, "withdrawText");
            Intrinsics.checkNotNullParameter(r8, "queryRound");
            Intrinsics.checkNotNullParameter(r9, "questionId");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
        }
    }

    public static final class d extends com.larus.im.service.audio.z0 {
        public final String a;
        public final /* synthetic */ RealtimeCallSubtitlePlugin b;

        public final String g() {
            return this.a;
        }

        public d(RealtimeCallSubtitlePlugin r1) {
            this.b = r1;
            this.a = r1.f;
        }

        /* JADX WARN: Type inference failed for: r6v18, types: [com.larus.audio.call.plugins.g1, java.lang.Object] */
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
        public final void n(com.larus.im.service.audio.z0.a r32) {
            Intrinsics.checkNotNullParameter(r32, "event");
            boolean r3 = false;
            if ((r32 instanceof pf9.z) == false) goto L5;
            RealtimeCallSubtitlePlugin r0 = this.b;
            r0.g = false;
            r0.l.invoke();
            return;
        L5:
            boolean r4 = true;
            String r7 = "";
            String r8 = null;
            c r9 = null;
            Object r10 = null;
            r9 = null;
            r9 = null;
            c r11 = null;
            String r12 = null;
            r11 = null;
            if ((r32 instanceof pf9.f0) == false) goto L173;
            final RealtimeCallSubtitlePlugin r2 = this.b;
            pf9.f0 r13 = (pf9.f0) r32;
            r2.getClass();
            if (pf9.i.d(r13) == false) goto L28;
            if (r2.m == true) goto L19;
            pf9.k0 r1 = r13.b;
            if (r1 == null) goto L16;
            Map r5 = r1.n;
            if (r5 == null) goto L16;
            String r6 = (String) r5.get("model_type");
        L18:
            if (Intrinsics.areEqual(r6, "v3") == false) goto L28;
        L16:
            r6 = null;
        L19:
            String r14 = pf9.i.a(r13);
            if (pf9.i.e(r14) == true) goto L28;
            if (r14.length() <= 0) goto L24;
            boolean r15 = true;
        L25:
            if (r15 == false) goto L28;
            pf9.i.g(r14);
            com.larus.audio.call.util.e.a.i(r2.f, "[onReplyUpdate] putV3, identifier:".concat(r14));
            goto L28
        L24:
            r15 = false;
        L28:
            if (r2.m == true) goto L31;
            r2.k3(pf9.i.e(pf9.i.a(r13)));
        L31:
            if (r2.m == true) goto L91;
            if (r2.getContext().params().p.D == true) goto L91;
            if (pf9.i.i(r13) == false) goto L276;
            com.larus.audio.call.util.e.a.i(r2.f, "[parseSentenceDataFromRemote] start, event:" + r13);
            String r16 = pf9.i.k(r13);
            if (r16 != null) goto L40;
        L43:
            if (r4 == false) goto L53;
            StringBuilder r17 = new StringBuilder();
            pf9.m r19 = r13.c;
            if (r19 == null) goto L52;
            Map r20 = r19.a;
            if (r20 == null) goto L52;
            Iterator r21 = r20.entrySet().iterator();
        L50:
            if (r21.hasNext() == false) goto L52;
            Map.Entry r22 = (Map.Entry) r21.next();
            r17.append(((String) r22.getKey()) + ':' + ((String) r22.getValue()));
            r17.append('\n');
        L52:
            com.larus.audio.call.util.e.a.e(r2.f, "[parseSentenceDataFromRemote] ttsTaskId is null, " + r17);
        L88:
            if (r9 == null) goto L277;
            r2.j3(r9, false);
            return;
        L277:
            return;
        L53:
            pf9.m r23 = r13.c;
            if (r23 == null) goto L88;
            Map r24 = r23.a;
            if (r24 == null) goto L88;
            String r25 = (String) r24.get("sentence_id");
            if (r25 != null) goto L60;
            String r110 = "";
        L61:
            String r26 = (String) r24.get("text");
            if (r26 != null) goto L64;
            r26 = "";
        L64:
            String r27 = (String) r24.get("with_draw_content");
            if (r27 != null) goto L67;
            String r111 = "";
        L68:
            String r29 = (String) r24.get("silence_context");
            if (r29 == null) goto L247;
            r7 = r29;
        L247:
            Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L74
            Object r31 = Result.constructor-impl(Boolean.valueOf(com.larus.audio.call.util.m.a(b78.g.a(r7))));     // Catch: Throwable -> L74
        L76:
            Throwable r33 = Result.exceptionOrNull-impl(r31);
            if (r33 == null) goto L80;
            com.larus.audio.call.util.e.a.e(r2.f, "[handleSentenceData] get flushed failed, " + r33);
        L80:
            if (Result.isFailure-impl(r31) == true) goto L83;
            r10 = r31;
        L83:
            Boolean r34 = (Boolean) r10;
            if (r34 == null) goto L86;
            boolean r112 = r34.booleanValue();
        L87:
            r9 = new c(r16, r110, pf9.i.f(r13), r26, r111, r112, "", pf9.i.h(r13), null);
            com.larus.audio.call.util.e.a.i(r2.f, "[parseSentenceDataFromRemote] success, " + r9);
            r2.getContext().k().T(pf9.i.f(r13), r26);
            goto L88
        L86:
            r112 = false;
        L74:
            th = move-exception;
            Result.Companion r35 = Result.Companion;
            r31 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L76
        L67:
            r111 = r27;
            goto L68
        L60:
            r110 = r25;
            goto L61
        L40:
            if (StringsKt.isBlank(r16) == true) goto L43;
            r4 = false;
            goto L43
        L276:
            return;
        L91:
            if (pf9.i.b(r13) == true) goto L167;
            String r113 = pf9.i.a(r13);
            pf9.k0 r36 = r13.b;
            if (r36 == null) goto L96;
            String r37 = r36.a;
        L97:
            if (r37 != null) goto L99;
            String r114 = "";
        L100:
            if (r36 == null) goto L102;
            final boolean r38 = r36.d;
        L103:
            if (r36 == null) goto L105;
            String r115 = r36.b;
        L106:
            if (r36 == null) goto L108;
            String r116 = r36.c;
        L109:
            if (r36 == null) goto L113;
            Map r39 = r36.n;
            if (r39 == null) goto L113;
            String r40 = (String) r39.get("with_draw_content");
        L114:
            if (r40 != null) goto L116;
            String r117 = "";
        L117:
            pf9.k0 r41 = r13.b;
            if (r41 == null) goto L122;
            Map r42 = r41.n;
            if (r42 == null) goto L122;
            String r43 = (String) r42.get("query_round");
        L123:
            if (r43 != null) goto L125;
            String r118 = "";
        L126:
            String r119 = pf9.i.h(r13);
            if (r114.length() != 0) goto L129;
            boolean r44 = true;
        L130:
            if (r44 == false) goto L150;
            if (r115 != null) goto L133;
        L136:
            boolean r45 = true;
        L137:
            if (r45 == false) goto L150;
            if (r116 != null) goto L140;
        L143:
            boolean r46 = true;
        L144:
            if (r46 == false) goto L150;
            if (r117.length() != 0) goto L148;
            r3 = true;
        L148:
            if (r3 == false) goto L150;
            com.larus.audio.call.util.e.a.e(r2.f, "[parseSentenceDataFromRemoteV3] failed, ttsTaskId:" + r113);
            goto L167
        L140:
            if (r116.length() == 0) goto L143;
            r46 = false;
            goto L144
        L133:
            if (r115.length() == 0) goto L136;
            r45 = false;
        L150:
            final Ref.ObjectRef r47 = new Ref.ObjectRef();
            c r48 = new c(r113, r113, pf9.i.f(r13), r114, r117, false, r118, r119, null);
            r47.element = r48;
            if (r38 == false) goto L159;
            pf9.k0 r49 = r13.b;
            if (r49 == null) goto L155;
            String r120 = r49.b;
        L156:
            if (r49 == null) goto L158;
            r12 = r49.c;
        L158:
            b r50 = new b(r120, r12);
            String r51 = r48.a;
            String r52 = r48.b;
            String r121 = r48.c;
            String r122 = r48.d;
            String r123 = r48.e;
            boolean r124 = r48.f;
            String r125 = r48.g;
            String r53 = r48.h;
            Intrinsics.checkNotNullParameter(r51, "ttsTaskId");
            Intrinsics.checkNotNullParameter(r52, "sectionId");
            Intrinsics.checkNotNullParameter(r121, "messageId");
            Intrinsics.checkNotNullParameter(r122, "text");
            Intrinsics.checkNotNullParameter(r123, "withdrawText");
            Intrinsics.checkNotNullParameter(r125, "queryRound");
            Intrinsics.checkNotNullParameter(r53, "questionId");
            r47.element = new c(r51, r52, r121, r122, r123, r124, r125, r53, r50);
            goto L159
        L155:
            r120 = null;
        L159:
            String r54 = r2.f + "-parseV3-success";
            ?? r55 = new g1(r2, r47, r38);
            Map<String, Long> r56 = com.larus.audio.call.util.f.a;
            Intrinsics.checkNotNullParameter(r54, "uniTag");
            Intrinsics.checkNotNullParameter(r55, "block");
            Map<String, Long> r57 = com.larus.audio.call.util.f.a;
            Long r59 = (Long) ((LinkedHashMap) r57).get(r54);
            if (r59 == null) goto L162;
            long r60 = r59.longValue();
        L163:
            long r61 = SystemClock.elapsedRealtime();
            if ((r61 - r60) < 300) goto L166;
            r55.invoke();
            r57.put(r54, Long.valueOf(r61));
        L166:
            r11 = (c) r47.element;
            goto L167
        L162:
            r60 = 0;
            goto L163
        L129:
            r44 = false;
            goto L130
        L125:
            r118 = r43;
        L122:
            r43 = null;
            goto L123
        L116:
            r117 = r40;
        L113:
            r40 = null;
            goto L114
        L108:
            r116 = null;
            goto L109
        L105:
            r115 = null;
            goto L106
        L102:
            r38 = false;
            goto L103
        L99:
            r114 = r37;
            goto L100
        L96:
            r37 = null;
        L167:
            if (r11 != null) goto L169;
            return;
        L169:
            if (com.larus.audio.call.util.p.a(r11.e) == false) goto L171;
            com.larus.audio.call.arch.b.a(r2.getContext()).e0().h();
        L171:
            r2.j3(r11, true);
            return;
        L173:
            if ((r32 instanceof pf9.e0) == false) goto L176;
            RealtimeCallSubtitlePlugin r62 = this.b;
            r62.h = false;
            r62.g = false;
            return;
        L176:
            if ((r32 instanceof pf9.v) == false) goto L184;
            com.larus.audio.call.n r63 = com.larus.audio.call.f.c().g();
            if (r63 == null) goto L181;
            r8 = r63.a;
        L181:
            if (Intrinsics.areEqual(r8, "interpret_v2") == false) goto L282;
            RealtimeCallSubtitlePlugin r64 = this.b;
            r64.h = false;
            r64.g = false;
            return;
        L282:
            return;
        L184:
            if ((r32 instanceof pf9.d0) == false) goto L187;
            this.b.k3(Intrinsics.areEqual(((pf9.d0) r32).a, "v3"));
            return;
        L187:
            if ((r32 instanceof pf9.q) == false) goto L242;
            RealtimeCallSubtitlePlugin r65 = this.b;
            r65.getClass();
            Iterator r66 = ((pf9.q) r32).a.iterator();
        L190:
            if (r66.hasNext() == false) goto L287;
            pf9.p r67 = (pf9.p) r66.next();
            Long r68 = r67.a;
            if (r68 == null) goto L190;
            long r69 = r68.longValue();
            Map r70 = r67.b;
            if (r70 == null) goto L190;
            String r71 = (String) r70.get("action");
            if (r69 == 200) goto L198;
            if (r69 != 202) goto L190;
            if (Intrinsics.areEqual(r71, "WITHDRAW") == false) goto L190;
            String r72 = (String) r70.get("uri");
            if (r72 != null) goto L218;
            String r73 = "";
        L220:
            if (StringsKt.isBlank(r73) == false) goto L249;
            List r74 = CollectionsKt.emptyList();
        L238:
            com.larus.audio.call.util.e.a.i(r65.f, "[handleCommandReplyEvent] cmd=202 Image withdraw, uris=" + r74);
            if (r74.isEmpty() == true) goto L190;
            r65.k.invoke(new a78.b.a(r74));
            goto L190
        L249:
            Result.Companion r75 = Result.Companion;     // Catch: Throwable -> L228
            ouc.b r76 = ouc.k.m(ouc.a.d.e(r73));     // Catch: Throwable -> L228
            ArrayList r77 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r76, 10));     // Catch: Throwable -> L228
            Iterator r79 = r76.iterator();     // Catch: Throwable -> L228
        L224:
            if (r79.hasNext() == false) goto L226;
            r77.add(ouc.k.o((ouc.i) r79.next()).a());     // Catch: Throwable -> L228
            goto L224
        L226:
            Object r80 = Result.constructor-impl(r77);     // Catch: Throwable -> L228
        L230:
            Throwable r81 = Result.exceptionOrNull-impl(r80);
            if (r81 == null) goto L234;
            com.larus.audio.call.util.e.a.e(r65.f, "[parseImageUris] parse failed, raw=" + r73 + ", err=" + r81);
        L234:
            if (Result.exceptionOrNull-impl(r80) == null) goto L237;
            r80 = CollectionsKt.listOf(r73);
        L237:
            r74 = (List) r80;
        L228:
            th = move-exception;
            Result.Companion r82 = Result.Companion;
            r80 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L230
        L218:
            r73 = r72;
            goto L220
        L198:
            String r83 = (String) r70.get("question_id");
            if (r83 != null) goto L201;
            r83 = "";
        L201:
            String r84 = (String) r70.get("withdraw_content");
            if (r84 != null) goto L204;
            r84 = "";
        L204:
            com.larus.audio.call.arch.b.a(r65.getContext()).e0().h();
            if (Intrinsics.areEqual(r71, "WITHDRAW_ROUND") == true) goto L206;
            if (Intrinsics.areEqual(r71, "WITHDRAW") == true) goto L209;
            com.larus.audio.call.util.e.a.w(r65.f, "[handleCommandReplyEvent] cmd=200 unknown action=" + r71 + ", skip");
            goto L190
        L209:
            com.larus.audio.call.util.e.a.i(r65.f, "[handleCommandReplyEvent] cmd=200 WITHDRAW, questionId=".concat(r83));
            r65.k.invoke(new a78.b.C0003b(r83, r84));
            goto L190
        L206:
            com.larus.audio.call.util.e.a.i(r65.f, "[handleCommandReplyEvent] cmd=200 WITHDRAW_ROUND, questionId=".concat(r83));
            r65.k.invoke(new a78.b.c(r83, r84));
            goto L190
        L287:
            return;
        L242:
            if ((r32 instanceof pf9.r) == false) goto L285;
            int r85 = sf9.b.a;
            if (sf9.b.a(((pf9.r) r32).getType()) == false) goto L286;
            com.larus.audio.call.util.e.a.i(this.b.f, "[FlowLLMTransparentEvent] duringBotTrigger=true");
            this.b.h = true;
            return;
        L286:
            return;
        }
    }

    static {
    }

    @Override // com.larus.audio.call.arch.a
    public final com.larus.im.service.audio.z0 S2() {
        return new d(this);
    }

    @Override // com.larus.audio.call.arch.a
    public final void X2() {
        com.larus.audio.call.util.e.a.i(this.f, "onInterrupt was called");
        this.o.invoke();
    }

    @Override // com.larus.audio.call.arch.a
    public final void b3() {
        ((ArrayList) this.j).clear();
    }

    @Override // com.larus.audio.call.arch.a
    public final String T2() {
        return this.f;
    }

    public RealtimeCallSubtitlePlugin(com.larus.audio.call.arch.c r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.f = "RealtimeCallSubtitlePlugin";
        this.j = new ArrayList();
        this.k = new h1();
        this.l = new i1();
        this.o = new j1();
    }

    @Override // com.larus.audio.call.plugins.a1
    public final void D1(com.larus.voicecall.impl.component.subtitle.u r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.o = r2;
    }

    @Override // com.larus.audio.call.plugins.a1
    public final void H0(com.larus.voicecall.impl.v r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((ArrayList) this.j).contains(r2) == true) goto L6;
        ((ArrayList) this.j).add(r2);
        return;
    }

    @Override // com.larus.audio.call.plugins.a1
    public final void e2(boolean r7) {
        if (this.i == false) goto L7;
        com.larus.audio.call.util.e.a.i(this.f, "always show subtitle!");
        return;
    L7:
        if (Intrinsics.areEqual(Boolean.valueOf(r7), this.n) == false) goto L10;
        com.larus.audio.call.util.e.a.i(this.f, "subtitle status not changed! isOpen=" + r7);
        return;
    L10:
        id9.d r0 = getContext().j();
        if (r0 != null) goto L14;
        com.larus.audio.call.util.e.a.w(this.f, "trigger subtitle status change skipped: mediaSession not ready yet, isOpen=" + r7 + ", will be retried on CONNECTED");
        return;
    L14:
        com.larus.audio.call.util.e.a.i(this.f, "trigger subtitle status change. isOpen=" + r7);
        ouc.e0 r1 = new ouc.e0();
        ouc.j.c(r1, "ui_event", "captions_info");
        ouc.j.c(r1, "captions_status", String.valueOf(r7 ? 1 : 0));
        ouc.d0 r2 = r1.a();
        TriggerMode r3 = TriggerMode.UPDATE_UI_CONTEXT;
        LinkedHashMap r4 = new LinkedHashMap();
        Intrinsics.checkNotNullParameter("applet_payload", "key");
        Intrinsics.checkNotNullParameter(r2, "element");
        ouc.i r5 = (ouc.i) r4.put("applet_payload", r2);
        Unit r6 = Unit.INSTANCE;
        r0.p(r3, new ouc.d0(r4).toString());
        this.n = Boolean.valueOf(r7);
    }

    @Override // com.larus.audio.call.plugins.a1
    public final void h2(boolean r2) {
        if (r2 == false) goto L4;
        e2(true);
    L4:
        this.i = r2;
    }

    public final void k3(boolean r9) {
        if (this.m == r9) goto L10;
        if (r9 == false) goto L6;
        String r0 = "v3";
    L7:
        com.larus.audio.call.util.e.a.i(this.f, "switch modeType to:".concat(r0));
        if (com.larus.audio.call.f.c().appContext().e() == false) goto L10;
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new RealtimeCallSubtitlePlugin$isV3$1(r0, null), 3, null);
        goto L10
    L6:
        r0 = "v1";
    L10:
        getContext().k().G(r9);
        this.m = r9;
    }

    @Override // com.larus.audio.call.plugins.a1
    public final void t2(com.larus.voicecall.impl.component.subtitle.w r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.k = r2;
    }

    @Override // com.larus.audio.call.plugins.a1
    public final void w2(com.larus.voicecall.impl.component.subtitle.v r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.l = r2;
    }

    @Override // com.larus.audio.call.plugins.a1
    public final void j2(RealtimeCallParam r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "params");
        Intrinsics.checkNotNullParameter(r6, "extra");
        MajorState r7 = getContext().a().s1();
        com.larus.audio.call.util.e.a.i(this.f, "sendSubtitleImageTrigger, currentState:" + r7);
        if (i3() == true) goto L5;
        return;
    L5:
        getContext().a().t();
        com.larus.audio.call.n r8 = com.larus.audio.call.f.c().g();
        if (r8 == null) goto L8;
        String r9 = r8.a;
    L10:
        if (Intrinsics.areEqual(r9, "interview_v2") == false) goto L12;
        TriggerMode r10 = TriggerMode.INTERVIEW_IMAGE;
    L13:
        id9.d r0 = getContext().j();
        if (r0 == null) goto L17;
        r0.p(r10, b78.g.a(r6).toString());
    L17:
        if (Intrinsics.areEqual(getContext().a().s1(), MajorState.h.c) == false) goto L20;
        com.larus.audio.call.arch.b.a(getContext()).e0().d(true, true, "trigger_image");
        getContext().a().a1(new MajorState.i(), this.f);
        getContext().a().n2(StateTriggerEvent.RequestThinking.a);
        return;
    L20:
        return;
    L12:
        r10 = TriggerMode.IMAGE;
        goto L13
    L8:
        r9 = null;
        goto L10
    }

    public final void j3(c r29, boolean r210) {
        if (this.g == false) goto L5;
        return;
    L5:
        if (com.larus.audio.call.util.p.a(r29.e) == false) goto L7;
        this.g = true;
        a78.a r2 = new a78.a(r29.b, r29.c, r29.e, r29.a, 0, true, r210, r29.g, r29.h, r29.i, 16);
    L9:
        if (r29.f == false) goto L15;
        String r1 = r2.c;
        if (r1 == null) goto L13;
        String r3 = StringsKt.trimEnd(r1, new char[]{'\n', '\r'});
    L14:
        String r4 = r2.a;
        String r5 = r2.b;
        String r7 = r2.d;
        int r8 = r2.e;
        boolean r9 = r2.f;
        boolean r10 = r2.g;
        String r11 = r2.h;
        String r12 = r2.i;
        b r13 = r2.j;
        Intrinsics.checkNotNullParameter(r11, "queryRound");
        Intrinsics.checkNotNullParameter(r12, "questionId");
        r2 = new a78.a(r4, r5, r3, r7, r8, r9, r10, r11, r12, r13);
        goto L15
    L13:
        r3 = null;
    L15:
        Iterator r6 = ((ArrayList) this.j).iterator();
    L17:
        if (r6.hasNext() == false) goto L21;
        ((Function1) r6.next()).invoke(r2);
        goto L17
    L21:
        return;
    L7:
        String r14 = r29.b;
        String r15 = r29.c;
        String r16 = r29.d;
        String r17 = r29.a;
        boolean r19 = this.h;
        String r20 = r29.g;
        String r21 = r29.h;
        b r110 = r29.i;
        r2 = new a78.a(r14, r15, r16, r17, r19 ? 1 : 0, false, r210, r20, r21, r110, 32);
        goto L9
    }
}
