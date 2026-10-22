package com.larus.voicecall.impl.tracer;

import com.larus.audio.call.RealtimeCallParam;
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
import tx9.c3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.tracer.RealtimeCallTracer$onTTSResponse$2", f = "RealtimeCallTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RealtimeCallTracer$onTTSResponse$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $extraInfo;
    final /* synthetic */ long $llm;
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ long $ttsDelay;
    int label;
    final /* synthetic */ RealtimeCallTracer this$0;

    public RealtimeCallTracer$onTTSResponse$2(RealtimeCallTracer r1, RealtimeCallParam r2, long r3, long r5, JSONObject r7, Continuation<? super RealtimeCallTracer$onTTSResponse$2> r8) {
        this.this$0 = r1;
        this.$params = r2;
        this.$ttsDelay = r3;
        this.$llm = r5;
        this.$extraInfo = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new RealtimeCallTracer$onTTSResponse$2(this.this$0, this.$params, this.$ttsDelay, this.$llm, this.$extraInfo, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r37) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r37);
        RealtimeCallTracer r1 = this.this$0;
        RealtimeCallParam r2 = this.$params;
        long r3 = this.$ttsDelay;
        long r5 = this.$llm;
        JSONObject r15 = this.$extraInfo;
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r15, "extraInfo");
        String r10 = r1.U;
        String r9 = r1.T;
        long r7 = r1.A;
        RealtimeCallParam.p r11 = r2.o;
        String r14 = r11.h;
        String r13 = r2.e;
        RealtimeCallParam.d r12 = r2.l;
        String r0 = r12.c;
        String r4 = r12.a;
        long r18 = r3 + r5;
        String r6 = r2.i;
        long r16 = r12.h;
        if (r12.m == false) goto L7;
        long r24 = 1;
    L8:
        String r17 = r11.d;
        long r19 = r1.D;
        r1.v0(r15);
        RealtimeCallUtil.a.getClass();
        com.larus.voicecall.impl.scene.o r8 = RealtimeCallUtil.l;
        if (r8 == null) goto L14;
        SceneModel r20 = r8.a;
        if (r20 == null) goto L14;
        String r21 = r20.getKey();
        if (r21 == null) goto L14;
    L15:
        c3.f(Long.valueOf(r7), r14, r13, r0, Long.valueOf(r19), null, 0L, Long.valueOf(r3), r6, Long.valueOf(r24), r4, Long.valueOf(r18), Long.valueOf(r5), null, null, Long.valueOf(r16), r17, null, null, null, null, null, r9, r10, null, null, r15, r21, 1509099657);
        return Unit.INSTANCE;
    L14:
        r21 = "other";
        goto L15
    L7:
        r24 = 0;
        goto L8
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
