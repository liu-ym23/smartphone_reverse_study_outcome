package com.larus.dora.impl.ota;

import com.larus.dora.impl.ota.g.DoraGOTAFetcher;
import g49.d;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.DoraOTATask$handleSilentOTAStageChanged$2", f = "DoraOTATask.kt", i = {}, l = {1107}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTATask$handleSilentOTAStageChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraOTATask this$0;

    public DoraOTATask$handleSilentOTAStageChanged$2(DoraOTATask r1, Continuation<? super DoraOTATask$handleSilentOTAStageChanged$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraOTATask$handleSilentOTAStageChanged$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        e49.a r5 = (e49.a) r4;
        if (r5 == null) goto L15;
        DoraOTATask r2 = this.this$0;
        d49.a.c r3 = new d49.a.c(r5);
        int r6 = DoraOTATask.z;
        r2.t(r3);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        d.d("DoraOTATask0711", "handleSilentOTAStageChanged: start to getPeripheralResponse");
        DoraGOTAFetcher r7 = DoraGOTAFetcher.a;
        this.label = 1;
        r4 = r7.a(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
