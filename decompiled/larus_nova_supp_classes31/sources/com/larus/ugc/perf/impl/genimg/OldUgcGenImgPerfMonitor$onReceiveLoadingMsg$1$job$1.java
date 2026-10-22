package com.larus.ugc.perf.impl.genimg;

import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor$onReceiveLoadingMsg$1$job$1", f = "UgcGenImgPerfMonitor.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
public final class OldUgcGenImgPerfMonitor$onReceiveLoadingMsg$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msgId;
    final /* synthetic */ com.larus.ugc.perf.impl.e $source;
    int label;
    final /* synthetic */ OldUgcGenImgPerfMonitor this$0;

    public OldUgcGenImgPerfMonitor$onReceiveLoadingMsg$1$job$1(com.larus.ugc.perf.impl.e r1, OldUgcGenImgPerfMonitor r2, String r3, Continuation<? super OldUgcGenImgPerfMonitor$onReceiveLoadingMsg$1$job$1> r4) {
        this.$source = r1;
        this.this$0 = r2;
        this.$msgId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new OldUgcGenImgPerfMonitor$onReceiveLoadingMsg$1$job$1(this.$source, this.this$0, this.$msgId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        if (Intrinsics.areEqual(this.this$0.a.get(this.$msgId), Boxing.boxBoolean(false)) == false) goto L14;
        this.this$0.j(this.$source, 30012);
    L14:
        FLogger.a.d("OldUgcGenImgPerfMonitor", "onReceiveLoadingMsg:" + this.$source.b() + " executed job end");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        FLogger.a.d("OldUgcGenImgPerfMonitor", "onReceiveLoadingMsg:" + this.$source.b() + " executed job start");
        this.label = 1;
        if (DelayKt.delay(60000, this) != r0) goto L12;
        return r0;
    }
}
