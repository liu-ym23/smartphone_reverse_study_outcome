package com.larus.voicecall.impl.tracer;

import com.larus.audio.call.RealtimeCallParam;
import com.larus.audio.call.tracer.IRealtimeCallTracer;
import com.larus.im.bean.bot.SceneModel;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.RealtimeCallTracer$onEnterCallFailed$1", f = "RealtimeCallTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallTracer$onEnterCallFailed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $duration;
    final /* synthetic */ Integer $errorCode;
    final /* synthetic */ boolean $isV2;
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ String $reason;
    final /* synthetic */ IRealtimeCallTracer.EnterCallSessionStatus $sessionStatus;
    int label;
    final /* synthetic */ RealtimeCallTracer this$0;

    public RealtimeCallTracer$onEnterCallFailed$1(RealtimeCallTracer r1, RealtimeCallParam r2, String r3, IRealtimeCallTracer.EnterCallSessionStatus r4, Integer r5, long r6, boolean r8, Continuation<? super RealtimeCallTracer$onEnterCallFailed$1> r9) {
        this.this$0 = r1;
        this.$params = r2;
        this.$reason = r3;
        this.$sessionStatus = r4;
        this.$errorCode = r5;
        this.$duration = r6;
        this.$isV2 = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new RealtimeCallTracer$onEnterCallFailed$1(this.this$0, this.$params, this.$reason, this.$sessionStatus, this.$errorCode, this.$duration, this.$isV2, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r37) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r37);
        RealtimeCallTracer r1 = this.this$0;
        RealtimeCallParam r2 = this.$params;
        String r15 = this.$reason;
        IRealtimeCallTracer.EnterCallSessionStatus r14 = this.$sessionStatus;
        Integer r13 = this.$errorCode;
        long r11 = this.$duration;
        boolean r10 = this.$isV2;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r15, "reason");
        Intrinsics.checkNotNullParameter(r14, "sessionStatus");
        String r3 = r2.o.h;
        String r4 = r2.e;
        String r5 = r2.l.c;
        int r6 = r14.getValue();
        String r9 = r2.w;
        RealtimeCallParam.p r7 = r2.o;
        String r8 = r7.f;
        String r0 = r7.d;
        String r12 = r7.g;
        RealtimeCallParam.k r16 = r2.p;
        String r17 = r16.i;
        String r18 = r16.d;
        RealtimeCallParam r19 = (RealtimeCallParam) r1.b.invoke();
        JSONObject r110 = new JSONObject();
        r1.w0(r110);
        r1.v0(r110);
        RealtimeCallTracer.C0(r19, r110);
        RealtimeCallTracerReporterKt.a(r110, r2.r);
        RealtimeCallParam.k r20 = r2.p;
        boolean r21 = r20.q;
        String r22 = "1";
        if (r21 == false) goto L7;
    L10:
        String r24 = "1";
    L12:
        if (r2.b == true) goto L16;
        r22 = "0";
    L16:
        if (r21 == false) goto L18;
        String r27 = null;
    L19:
        RealtimeCallParam.c r23 = r20.o;
        if (r23 == null) goto L22;
        String r28 = r23.d;
    L23:
        if (r23 == null) goto L25;
        String r29 = r23.a;
    L26:
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r25 = RealtimeCallUtil.l;
        if (r25 == null) goto L31;
        SceneModel r26 = r25.a;
        if (r26 == null) goto L31;
        String r30 = r26.getKey();
    L32:
        a1.a(r3, r4, r5, r15, "0", Integer.valueOf(r6), r17, r18, r8, r0, r12, r13, r9, r110, null, r24, r22, r27, null, r28, r29, r30, null, 286787464);
        if (r10 == false) goto L36;
        String r31 = r2.o.h;
        String r32 = r2.e;
        String r33 = r2.l.c;
        int r34 = r14.getValue();
        RealtimeCallParam.p r35 = r2.o;
        String r111 = r35.f;
        String r112 = r35.d;
        String r113 = r35.g;
        String r36 = r2.p.i;
        String r114 = r2.k.t;
        RealtimeCallParam r38 = (RealtimeCallParam) r1.b.invoke();
        JSONObject r115 = new JSONObject();
        r1.w0(r115);
        r1.v0(r115);
        RealtimeCallTracer.C0(r38, r115);
        RealtimeCallTracerReporterKt.a(r115, r2.r);
        a1.b(r31, r32, r33, r15, "0", Integer.valueOf(r34), r36, r111, r112, r113, r13, r115, Long.valueOf(r11), r114, null, 1181576);
    L36:
        return Unit.INSTANCE;
    L31:
        r30 = null;
        goto L32
    L25:
        r29 = null;
        goto L26
    L22:
        r28 = null;
        goto L23
    L18:
        r27 = r20.v;
        goto L19
    L7:
        if (r2.a == true) goto L10;
        r24 = "0";
        goto L12
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
