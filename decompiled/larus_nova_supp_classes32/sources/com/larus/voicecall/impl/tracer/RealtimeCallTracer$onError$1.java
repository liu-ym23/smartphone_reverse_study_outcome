package com.larus.voicecall.impl.tracer;

import com.larus.audio.call.RealtimeCallParam;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.c3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.RealtimeCallTracer$onError$1", f = "RealtimeCallTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RealtimeCallTracer$onError$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $bizScene;
    final /* synthetic */ int $errorCode;
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ long $fromStatus;
    final /* synthetic */ Boolean $isSessionStarted;
    final /* synthetic */ boolean $isV2;
    final /* synthetic */ RealtimeCallParam $params;
    int label;
    final /* synthetic */ RealtimeCallTracer this$0;

    public RealtimeCallTracer$onError$1(RealtimeCallTracer r1, int r2, String r3, long r4, RealtimeCallParam r6, Boolean r7, String r8, boolean r9, Continuation<? super RealtimeCallTracer$onError$1> r10) {
        this.this$0 = r1;
        this.$errorCode = r2;
        this.$errorMsg = r3;
        this.$fromStatus = r4;
        this.$params = r6;
        this.$isSessionStarted = r7;
        this.$bizScene = r8;
        this.$isV2 = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new RealtimeCallTracer$onError$1(this.this$0, this.$errorCode, this.$errorMsg, this.$fromStatus, this.$params, this.$isSessionStarted, this.$bizScene, this.$isV2, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r42) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L53;
        ResultKt.throwOnFailure(r42);
        RealtimeCallTracer r1 = this.this$0;
        int r2 = this.$errorCode;
        String r14 = this.$errorMsg;
        long r10 = this.$fromStatus;
        RealtimeCallParam r13 = this.$params;
        Boolean r9 = this.$isSessionStarted;
        String r7 = this.$bizScene;
        boolean r3 = this.$isV2;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r13, LynxResourceModule.PARAMS_KEY);
        long r22 = 0;
        if (r3 == false) goto L31;
        String r4 = r13.o.h;
        String r8 = r13.e;
        String r6 = r13.l.c;
        long r11 = r2;
        Function0<String> r0 = r1.M;
        if (r0 == null) goto L10;
        String r5 = (String) r0.invoke();
        if (r5 == null) goto L10;
    L11:
        RealtimeCallParam.d r12 = r13.l;
        String r15 = r12.a;
        String r16 = r12.p;
        String r43 = r5;
        long r17 = r12.h;
        if (r12.m == false) goto L14;
        long r20 = 1;
    L15:
        String r18 = r13.o.d;
        boolean r32 = Intrinsics.areEqual(r9, Boolean.TRUE);
        JSONObject r19 = new JSONObject();
        Boolean r33 = r9;
        Iterator r21 = ((LinkedHashMap) r1.Y).entrySet().iterator();
    L17:
        if (r21.hasNext() == false) goto L19;
        Map.Entry r34 = (Map.Entry) r21.next();
        Iterator r36 = r21;
        r19.put((String) r34.getKey(), r34.getValue());
        r18 = r18;
        r21 = r36;
        goto L17
    L19:
        String r35 = r18;
        RealtimeCallParam r23 = (RealtimeCallParam) r1.b.invoke();
        r1.v0(r19);
        RealtimeCallTracer.C0(r23, r19);
        r19.put("enter_method", ((RealtimeCallParam) r1.b.invoke()).p.i);
        r19.put("enter_from", ((RealtimeCallParam) r1.b.invoke()).p.c);
        if (r13.p.q == false) goto L22;
    L25:
        Object r24 = "1";
    L26:
        r19.put("is_continuous_speak", r24);
        if (r13.b == false) goto L29;
        Object r25 = "1";
    L30:
        r19.put("is_obric_continuous_talk", r25);
        Long r26 = Long.valueOf(r11);
        Long r27 = Long.valueOf(r10);
        Long r28 = Long.valueOf(r20);
        Long r29 = Long.valueOf(r17);
        Integer r110 = Integer.valueOf(r32 ? 1 : 0);
        String r30 = "enter_method";
        String r31 = r7;
        String r37 = "is_obric_continuous_talk";
        String r38 = "enter_from";
        c3.e(r4, r8, r6, r26, r14, r27, 0L, 0L, r16, r28, r43, r15, r29, r35, r110, r31, r19, null, 13860865);
    L32:
        String r39 = r13.o.h;
        String r40 = r13.e;
        String r41 = r13.d;
        String r44 = r13.l.c;
        long r45 = r2;
        String r111 = r1.z0();
        RealtimeCallParam.d r46 = r13.l;
        String r112 = r46.a;
        String r113 = r46.p;
        long r114 = r46.h;
        if (r46.m == false) goto L35;
        r22 = 1;
    L35:
        String r115 = r13.o.d;
        boolean r116 = Intrinsics.areEqual(r33, Boolean.TRUE);
        JSONObject r117 = new JSONObject();
        if (r13.p.q == false) goto L38;
    L41:
        Object r47 = "1";
    L42:
        r117.put("is_continuous_speak", r47);
        if (r13.b == false) goto L45;
        Object r48 = "1";
    L46:
        r117.put(r37, r48);
        RealtimeCallParam r49 = (RealtimeCallParam) r1.b.invoke();
        r1.v0(r117);
        RealtimeCallTracer.C0(r49, r117);
        Iterator r50 = ((LinkedHashMap) r1.Y).entrySet().iterator();
    L48:
        if (r50.hasNext() == false) goto L50;
        Map.Entry r51 = (Map.Entry) r50.next();
        r117.put((String) r51.getKey(), r51.getValue());
        goto L48
    L50:
        r117.put(r30, ((RealtimeCallParam) r1.b.invoke()).p.i);
        r117.put(r38, ((RealtimeCallParam) r1.b.invoke()).p.c);
        c3.d(r39, r40, r41, r44, Long.valueOf(r45), r14, null, null, null, Long.valueOf(r10), 0L, 0L, r113, Long.valueOf(r22), r111, r112, Long.valueOf(r114), r115, null, null, null, Integer.valueOf(r116 ? 1 : 0), r31, null, null, null, null, r117, 792200065);
        return Unit.INSTANCE;
    L45:
        r48 = "0";
        goto L46
    L38:
        if (r13.a == true) goto L41;
        r47 = "0";
        goto L42
    L29:
        r25 = "0";
        goto L30
    L22:
        if (r13.a == true) goto L25;
        r24 = "0";
        goto L26
    L14:
        r20 = 0;
    L10:
        r5 = "realtime_call";
        goto L11
    L31:
        r30 = "enter_method";
        r38 = "enter_from";
        r31 = r7;
        r33 = r9;
        r37 = "is_obric_continuous_talk";
        goto L32
    L53:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
