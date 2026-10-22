package com.larus.avlink;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.bean.AppeaseType;
import com.larus.audio.call.RealtimeCallParam;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.c3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.DoraRealtimeCallTracer$onTTSResponse$1", f = "DoraRealtimeCallTracer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraRealtimeCallTracer$onTTSResponse$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Long $appeasePlayDuration;
    final /* synthetic */ JSONObject $extraInfo;
    final /* synthetic */ long $llm;
    final /* synthetic */ RealtimeCallParam $params;
    final /* synthetic */ String $questionId;
    final /* synthetic */ String $replyId;
    final /* synthetic */ long $ttsDelay;
    int label;
    final /* synthetic */ DoraRealtimeCallTracer this$0;

    public DoraRealtimeCallTracer$onTTSResponse$1(DoraRealtimeCallTracer r1, RealtimeCallParam r2, long r3, long r5, Long r7, String r8, String r9, JSONObject r10, Continuation<? super DoraRealtimeCallTracer$onTTSResponse$1> r11) {
        this.this$0 = r1;
        this.$params = r2;
        this.$llm = r3;
        this.$ttsDelay = r5;
        this.$appeasePlayDuration = r7;
        this.$questionId = r8;
        this.$replyId = r9;
        this.$extraInfo = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new DoraRealtimeCallTracer$onTTSResponse$1(this.this$0, this.$params, this.$llm, this.$ttsDelay, this.$appeasePlayDuration, this.$questionId, this.$replyId, this.$extraInfo, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r35) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r35);
        long r1 = this.this$0.h;
        RealtimeCallParam r3 = this.$params;
        String r6 = r3.o.h;
        String r7 = r3.e;
        RealtimeCallParam.d r4 = r3.l;
        String r8 = r4.c;
        String r15 = r4.a;
        long r5 = this.$llm + this.$ttsDelay;
        if (ia8.e.b().d() == false) goto L7;
        AppeaseType r9 = AppeaseType.VOICE;
    L8:
        String r19 = r9.getScene();
        RealtimeCallParam r10 = this.$params;
        String r13 = r10.i;
        RealtimeCallParam.d r11 = r10.l;
        long r12 = r11.h;
        if (r11.m == false) goto L11;
        long r22 = 1;
    L12:
        String r14 = r10.o.d;
        DoraRealtimeCallTracer r16 = this.this$0;
        long r17 = r16.s.D;
        String r25 = r16.z0();
        boolean r29 = com.larus.im.service.audio.y0.e(this.$params.s);
        boolean r30 = Intrinsics.areEqual(this.$params.k.o, "dora_si");
        c3.f(Boxing.boxLong(r1), r6, r7, r8, Boxing.boxLong(r17), Boxing.boxLong(0), Boxing.boxLong(0), Boxing.boxLong(this.$llm), r13, Boxing.boxLong(r22), r15, Boxing.boxLong(r5), Boxing.boxLong(this.$ttsDelay), this.$appeasePlayDuration, r19, Boxing.boxLong(r12), r14, Boxing.boxInt(0), Boxing.boxInt(0), Boxing.boxInt(0), r25, this.$params.k.t, this.$questionId, this.$replyId, Boxing.boxInt(r29 ? 1 : 0), Boxing.boxInt(r30 ? 1 : 0), this.$extraInfo, "other", 1073743881);
        return Unit.INSTANCE;
    L11:
        r22 = 0;
        goto L12
    L7:
        r9 = AppeaseType.PEOPLE;
        goto L8
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
