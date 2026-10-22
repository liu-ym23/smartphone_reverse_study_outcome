package com.larus.dora.impl.ota.check;

import com.larus.dora.impl.ota.g.DoraGOTAFetcher;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dora/api/ota/model/DoraOTAResponseWrapper;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.ota.check.DoraOTACheckRepository$checkUpdate$3$peripheralResponseDeferred$1", f = "DoraOTACheckRepository.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTACheckRepository$checkUpdate$3$peripheralResponseDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e49.a>, Object> {
    int label;

    public DoraOTACheckRepository$checkUpdate$3$peripheralResponseDeferred$1(Continuation<? super DoraOTACheckRepository$checkUpdate$3$peripheralResponseDeferred$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraOTACheckRepository$checkUpdate$3$peripheralResponseDeferred$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super e49.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L7
    L15:
        return (e49.a) r4;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r4);
        DoraGOTAFetcher r5 = DoraGOTAFetcher.a;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r4 = r5.a(this);     // Catch: Throwable -> L7
        if (r4 != r0) goto L15;
        return r0;
    L7:
        th = move-exception;
        g49.d.b("DoraOTACheckRepository", "getPeripheralResponse failed: " + th.getMessage());
        return null;
    }
}
