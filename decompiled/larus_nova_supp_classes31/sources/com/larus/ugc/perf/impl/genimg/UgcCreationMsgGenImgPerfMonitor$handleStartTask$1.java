package com.larus.ugc.perf.impl.genimg;

import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.perf.impl.genimg.UgcCreationMsgGenImgPerfMonitor$handleStartTask$1", f = "UgcCreationMsgGenImgPerfMonitor.kt", i = {}, l = {332}, m = "invokeSuspend", n = {}, s = {})
final class UgcCreationMsgGenImgPerfMonitor$handleStartTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $index;
    final /* synthetic */ com.larus.ugc.perf.impl.e $source;
    final /* synthetic */ String $taskId;
    final /* synthetic */ Integer $taskType;
    int label;

    public UgcCreationMsgGenImgPerfMonitor$handleStartTask$1(com.larus.ugc.perf.impl.e r1, String r2, Integer r3, Integer r4, Continuation<? super UgcCreationMsgGenImgPerfMonitor$handleStartTask$1> r5) {
        this.$source = r1;
        this.$taskId = r2;
        this.$taskType = r3;
        this.$index = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new UgcCreationMsgGenImgPerfMonitor$handleStartTask$1(this.$source, this.$taskId, this.$taskType, this.$index, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r11);
    L11:
        d r12 = d.d;
        com.larus.ugc.perf.impl.e r4 = this.$source;
        Integer r5 = this.$taskType;
        String r6 = this.$taskId;
        Integer r7 = this.$index;
        r12.getClass();
        d.m(r4, r5, r6, r7, 999);
        FLogger.a.d("UgcCreationMsgGenImgPerfMonitor", "handleStartedTask:" + this.$source.b() + " executed job end, taskId: " + this.$taskId);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r11);
        FLogger.a.d("UgcCreationMsgGenImgPerfMonitor", "handleStartedTask:" + this.$source.b() + " executed job start, taskId: " + this.$taskId);
        this.label = 1;
        if (DelayKt.delay(61000, this) != r0) goto L11;
        return r0;
    }
}
