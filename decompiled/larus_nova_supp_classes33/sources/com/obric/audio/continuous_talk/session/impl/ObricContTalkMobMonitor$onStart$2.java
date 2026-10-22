package com.obric.audio.continuous_talk.session.impl;

import com.ixigua.lib.track.TrackParams;
import com.larus.audio.call.RealtimeCallParam;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.audio.continuous_talk.d0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONObject;
import tx9.d3;
import tx9.l3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.continuous_talk.session.impl.ObricContTalkMobMonitor$onStart$2", f = "ObricContTalkMobMonitor.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
public final class ObricContTalkMobMonitor$onStart$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ObricContTalkMobMonitor this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ ObricContTalkMobMonitor a;

        public a(ObricContTalkMobMonitor r1) {
            this.a = r1;
        }

        public final Object emit(Object r191, Continuation r192) {
            hia.b r0 = (hia.b) r191;
            ObricContTalkMobMonitor r2 = this.a;
            r2.getClass();
            if ((r0 instanceof hia.b.C0059b) == false) goto L9;
            if (r2.t == false) goto L7;
            iia.b r3 = r2.h;
            RealtimeCallParam r9 = ((com.obric.audio.continuous_talk.session.impl.a) r2.getContext()).params();
            String r10 = r2.j3();
            r3.getClass();
            iia.b.c(r9, true, r10);
        L7:
            iia.b r4 = r2.h;
            RealtimeCallParam r11 = ((com.obric.audio.continuous_talk.session.impl.a) r2.getContext()).params();
            r4.getClass();
            Intrinsics.checkNotNullParameter(r11, "params");
            com.obric.audio.continuous_talk.a r5 = iia.b.b(r11);
            Intrinsics.checkNotNullParameter(r5, "commonTraceParams");
            JSONObject r7 = new JSONObject();
            d0.a(r7, r5);
            TrackParams r6 = new TrackParams().merge(r7);
            by7.a r8 = new by7.a("obric_continuous_talk_asr_begin");
            r8.a.merge(r6);
            r8.b();
            FLogger.a.i("mobObricContinuousTalkAsrBegin", "params:" + r7);
            r2.j = System.currentTimeMillis();
            r2.l = ((hia.b.C0059b) r0).a;
            r2.q = true;
            r2.u = true;
            r2.t = false;
            r2.r = false;
        L165:
            return Unit.INSTANCE;
        L9:
            if ((r0 instanceof hia.b.e) == false) goto L15;
            if (r2.q == false) goto L165;
            r2.q = false;
            r2.m = System.currentTimeMillis();
            goto L165
        L15:
            if ((r0 instanceof hia.b.c) == false) goto L153;
            hia.b.c r1 = (hia.b.c) r0;
            r2.v = r1.i;
            if (r1.a == true) goto L19;
            r2.k = System.currentTimeMillis();
            r2.r = true;
            r2.t = true;
        L19:
            iia.b r12 = r2.h;
            RealtimeCallParam r13 = ((com.obric.audio.continuous_talk.session.impl.a) r2.getContext()).params();
            boolean r14 = r1.a;
            long r15 = r2.m;
            long r16 = r2.j;
            long r19 = r15 - r16;
            long r17 = r2.l;
            long r18 = r16 - r17;
            long r110 = r15 - r17;
            boolean r111 = r2.u;
            r12.getClass();
            Intrinsics.checkNotNullParameter(r13, "params");
            com.obric.audio.continuous_talk.a r20 = iia.b.b(r13);
            Long r21 = Long.valueOf(r19);
            Long r22 = Long.valueOf(r18);
            Long r23 = Long.valueOf(r110);
            Boolean r112 = Boolean.valueOf(r111);
            Intrinsics.checkNotNullParameter(r20, "commonTraceParams");
            JSONObject r24 = new JSONObject();
            d0.a(r24, r20);
            r24.put("is_no_content", r14);
            if (r21 == null) goto L22;
            r24.put("duration", r21.longValue());
        L22:
            if (r22 == null) goto L24;
            r24.put("audio_begin_duration", r22.longValue());
        L24:
            if (r23 == null) goto L26;
            r24.put("total_duration", r23.longValue());
        L26:
            if (r112 == null) goto L28;
            r24.put("has_query_begin", r112.booleanValue());
        L28:
            TrackParams r25 = new TrackParams().merge(r24);
            by7.a r26 = new by7.a("obric_continuous_talk_asr_end");
            r26.a.merge(r25);
            r26.b();
            FLogger.a.i("mobObricContinuousTalkAsrEnd", "params:" + r24);
            String r27 = r1.f;
            if (r27 == null) goto L36;
            boolean r28 = true;
            if ((!StringsKt.isBlank(r27)) == true) goto L34;
            r27 = null;
        L34:
            if (r27 != null) goto L51;
        L37:
            r27 = r1.d;
            if (r27 != null) goto L40;
        L42:
            r27 = null;
        L43:
            if (r27 != null) goto L51;
            r27 = r1.e;
            if (r27 != null) goto L47;
        L49:
            r27 = null;
            goto L51
        L47:
            if ((StringsKt.isBlank(r27) ^ r28) == false) goto L49;
        L40:
            if ((StringsKt.isBlank(r27) ^ r28) == false) goto L42;
        L51:
            if (r1.a == true) goto L151;
            if (r27 == null) goto L151;
            iia.b r29 = r2.h;
            RealtimeCallParam r30 = ((com.obric.audio.continuous_talk.session.impl.a) r2.getContext()).params();
            Long r31 = r1.g;
            Long r32 = r1.h;
            String r33 = r1.i;
            r29.getClass();
            Intrinsics.checkNotNullParameter(r30, "params");
            RealtimeCallParam.k r34 = r30.p;
            String r35 = r34.b;
            String r36 = r34.d;
            RealtimeCallParam.p r113 = r30.o;
            String r114 = r113.h;
            String r115 = r30.l.c;
            String r116 = r30.w;
            String r117 = r113.f;
            String r37 = r113.d;
            String r118 = r113.g;
            String r38 = r34.e;
            if (r38 != null) goto L56;
            r38 = r34.J;
        L56:
            String r41 = r38;
            String r39 = r34.f;
            String r40 = r34.g;
            RealtimeCallParam.n r42 = r34.h;
            if (r42 == null) goto L59;
            String r310 = r42.a;
        L60:
            if (r42 == null) goto L62;
            String r311 = r42.b;
        L63:
            if (r42 == null) goto L65;
            String r44 = r42.c;
        L66:
            if (r42 == null) goto L68;
            String r45 = r42.d;
        L69:
            if (r42 == null) goto L71;
            String r46 = r42.e;
        L72:
            if (r42 == null) goto L74;
            String r43 = r42.f;
        L75:
            String r47 = r34.k;
            String r48 = r34.l;
            String r119 = r34.m;
            String r49 = r34.i;
            String r50 = r30.e;
            String r51 = r34.n;
            RealtimeCallParam.c r52 = r34.o;
            if (r52 == null) goto L78;
            String r95 = r52.b;
        L79:
            if (r52 == null) goto L81;
            String r96 = r52.c;
        L82:
            if (r52 == null) goto L86;
            String r53 = r52.a;
            if (r53 == null) goto L86;
            Long r94 = StringsKt.toLongOrNull(r53);
        L87:
            RealtimeCallParam.k r54 = r30.p;
            RealtimeCallParam.c r55 = r54.o;
            if (r55 == null) goto L90;
            String r120 = r55.d;
        L92:
            if (r120 != null) goto L94;
            String r80 = "";
        L95:
            if (r55 == null) goto L97;
            String r56 = r55.d;
        L99:
            if (r56 == null) goto L101;
            String r81 = "1";
        L102:
            String r57 = r54.H;
            String r58 = r54.I;
            JSONObject r59 = new JSONObject();
            r59.put("is_continuous_speak", "1");
            r59.put("is_obric_continuous_talk", "1");
            r59.put("conversation_mode", iia.b.a(r30));
            l3.b(r114, r40, null, null, r115, r36, "private", r116, null, null, "0", r27, "text", null, r35, r310, r311, r43, r41, r39, "continuous", r44, r45, r46, null, null, r48, r119, null, null, null, null, null, null, r59, r47, null, null, null, null, null, null, null, r117, r37, r118, null, null, null, null, null, IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, r49, null, null, null, null, r80, r81, r50, r51, null, null, null, null, null, null, null, null, null, null, r94, r95, r96, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r57, r58, null, null, null, null, null, null, null, null, null, null, null, r31, r32, r33, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -2046530763, -812652569, -458813, -234893313, -1, 255);
            RealtimeCallParam.k r60 = r30.p;
            String r61 = r60.d;
            String r62 = r60.b;
            RealtimeCallParam.p r63 = r30.o;
            String r64 = r63.h;
            String r65 = r30.l.c;
            String r66 = r30.w;
            String r121 = r63.f;
            String r122 = r63.d;
            String r67 = r63.g;
            String r123 = r60.e;
            if (r123 != null) goto L105;
            r123 = r60.J;
        L105:
            String r410 = r123;
            String r124 = r60.f;
            String r125 = r60.g;
            RealtimeCallParam.n r126 = r60.h;
            if (r126 == null) goto L108;
            String r312 = r126.a;
        L109:
            if (r126 == null) goto L111;
            String r313 = r126.b;
        L112:
            if (r126 == null) goto L114;
            String r411 = r126.c;
        L115:
            if (r126 == null) goto L117;
            String r412 = r126.d;
        L118:
            if (r126 == null) goto L120;
            String r413 = r126.e;
        L121:
            if (r126 == null) goto L123;
            String r414 = r126.f;
        L124:
            String r68 = r60.k;
            String r127 = r60.l;
            String r128 = r60.m;
            String r129 = r60.i;
            String r130 = r30.e;
            String r131 = r60.n;
            RealtimeCallParam.c r69 = r60.o;
            if (r69 == null) goto L127;
            String r90 = r69.b;
        L128:
            if (r69 == null) goto L130;
            String r91 = r69.c;
        L131:
            if (r69 == null) goto L135;
            String r70 = r69.a;
            if (r70 == null) goto L135;
            Long r89 = StringsKt.toLongOrNull(r70);
        L136:
            RealtimeCallParam.k r71 = r30.p;
            RealtimeCallParam.c r132 = r71.o;
            if (r132 == null) goto L139;
            String r133 = r132.d;
        L140:
            if (r133 != null) goto L142;
            String r82 = "";
        L143:
            if (r132 == null) goto L145;
            String r134 = r132.d;
        L146:
            if (r134 == null) goto L148;
            String r83 = "1";
        L149:
            String r135 = r71.H;
            String r72 = r71.I;
            JSONObject r73 = new JSONObject();
            r73.put("is_continuous_speak", "1");
            r73.put("is_obric_continuous_talk", "1");
            r73.put("conversation_mode", iia.b.a(r30));
            l3.d(r64, r125, null, null, r65, r61, null, "private", r66, null, "0", r27, "text", null, r62, r312, r313, r414, r410, r124, null, "continuous", r411, r412, r413, null, 1L, null, r68, r127, r128, null, null, null, null, null, null, r73, null, null, null, null, null, null, r121, r122, r67, null, null, null, null, IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, null, null, null, null, null, r129, r82, r83, null, null, null, r131, r130, null, r89, r90, r91, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r135, r72, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1585375847, 1056046065, -946, -193, Integer.MAX_VALUE);
            goto L151
        L148:
            r83 = "0";
            goto L149
        L145:
            r134 = null;
            goto L146
        L142:
            r82 = r133;
            goto L143
        L139:
            r133 = null;
        L135:
            r89 = null;
            goto L136
        L130:
            r91 = null;
            goto L131
        L127:
            r90 = null;
            goto L128
        L123:
            r414 = null;
            goto L124
        L120:
            r413 = null;
            goto L121
        L117:
            r412 = null;
            goto L118
        L114:
            r411 = null;
            goto L115
        L111:
            r313 = null;
            goto L112
        L108:
            r312 = null;
            goto L109
        L101:
            r81 = "0";
            goto L102
        L97:
            r56 = null;
            goto L99
        L94:
            r80 = r120;
            goto L95
        L90:
            r120 = null;
        L86:
            r94 = null;
            goto L87
        L81:
            r96 = null;
            goto L82
        L78:
            r95 = null;
            goto L79
        L74:
            r43 = null;
            goto L75
        L71:
            r46 = null;
            goto L72
        L68:
            r45 = null;
            goto L69
        L65:
            r44 = null;
            goto L66
        L62:
            r311 = null;
            goto L63
        L59:
            r310 = null;
        L151:
            r2.u = false;
            goto L165
        L36:
            r28 = true;
            goto L37
        L153:
            if (Intrinsics.areEqual(r0, hia.b.f.a) == false) goto L158;
            if (r2.t == false) goto L165;
            iia.b r74 = r2.h;
            RealtimeCallParam r75 = ((com.obric.audio.continuous_talk.session.impl.a) r2.getContext()).params();
            String r76 = r2.j3();
            r74.getClass();
            iia.b.c(r75, false, r76);
            r2.t = false;
            goto L165
        L158:
            if ((r0 instanceof hia.b.g) == false) goto L165;
            iia.b r77 = r2.h;
            RealtimeCallParam r78 = ((com.obric.audio.continuous_talk.session.impl.a) r2.getContext()).params();
            String r79 = ((hia.b.g) r0).a;
            r77.getClass();
            Intrinsics.checkNotNullParameter(r78, "params");
            RealtimeCallParam.p r84 = r78.o;
            String r85 = r84.c;
            String r86 = r84.h;
            String r87 = r84.f;
            if (r87 == null) goto L162;
            Long r415 = StringsKt.toLongOrNull(r87);
        L163:
            RealtimeCallParam.p r88 = r78.o;
            String r92 = r88.g;
            String r93 = r88.d;
            RealtimeCallParam.k r97 = r78.p;
            String r98 = r97.d;
            String r99 = r97.b;
            String r100 = r78.e;
            JSONObject r101 = new JSONObject();
            r101.put("is_continuous_speak", "1");
            r101.put("is_obric_continuous_talk", "1");
            r101.put("conversation_mode", iia.b.a(r78));
            d3.b(r86, null, null, r85, null, r98, null, "private", -1L, 0L, 0L, null, 1L, r79, "text", null, r99, null, null, null, null, null, 1L, "text", "0", r415, "default", "0", r93, r92, null, r101, null, null, null, "continuous", null, null, null, null, null, null, null, null, null, null, "0", "vui_receive_stream", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, r100, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, false, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 265378477, -3146288, -129, 1023);
            goto L165
        L162:
            r415 = null;
            goto L163
        }
    }

    public ObricContTalkMobMonitor$onStart$2(ObricContTalkMobMonitor r1, Continuation<? super ObricContTalkMobMonitor$onStart$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ObricContTalkMobMonitor$onStart$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MutableSharedFlow r6 = ((com.obric.audio.continuous_talk.session.impl.plugin.b) this.this$0.getContext().b(Reflection.getOrCreateKotlinClass(com.obric.audio.continuous_talk.session.impl.plugin.b.class), null)).s();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
