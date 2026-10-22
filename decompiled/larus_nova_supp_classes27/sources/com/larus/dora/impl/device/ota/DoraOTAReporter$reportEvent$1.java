package com.larus.dora.impl.device.ota;

import com.bytedance.dora.device.DoraDevice;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAReporter$reportEvent$1", f = "DoraOTAReporter.kt", i = {}, l = {149}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTAReporter$reportEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $body;
    int label;

    public DoraOTAReporter$reportEvent$1(JSONObject r1, Continuation<? super DoraOTAReporter$reportEvent$1> r2) {
        this.$body = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraOTAReporter$reportEvent$1(this.$body, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L14:
        com.larus.network.http.y r10 = (com.larus.network.http.a) r9;
        if ((r10 instanceof com.larus.network.http.y) == false) goto L18;
        g49.d.d("DoraOTAReporter", "report success, code: " + r10.g);
    L21:
        return Unit.INSTANCE;
    L18:
        if ((r10 instanceof com.larus.network.http.f) == false) goto L21;
        g49.d.c("DoraOTAReporter", "report fail ", ((com.larus.network.http.f) r10).d);
        goto L21
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        com.larus.dora.api.network.a r2 = com.larus.dora.api.network.a.a;
        k0 r3 = DoraOTAReporter.a;
        DoraDevice r4 = kj4.a.g().c();
        if (r4 == null) goto L11;
        o59.a.p(r4);
    L11:
        JSONObject r5 = this.$body;
        this.label = 1;
        r9 = com.larus.dora.api.network.a.c(r2, Object.class, "https://ocean-ota.obriccloud.com/open/v3/ota/event", r5, null, this, 248);
        if (r9 != r0) goto L14;
        return r0;
    }
}
