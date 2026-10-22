package com.larus.dora.impl.dynamic.loader;

import com.larus.utils.logger.FLogger;
import d59.g;
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
@Metadata(d1 = {"\u0000\n\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/dora/impl/dynamic/loader/DoraLaunchProductDataLoader$requestData$2"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.loader.DoraLaunchProductDataLoader$requestData$2", f = "DoraLaunchProductDataLoader.kt", i = {}, l = {171}, m = "invokeSuspend", n = {}, s = {})
public final class DoraLaunchProductDataLoader$requestAndProcessData$$inlined$requestData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g>, Object> {
    int label;
    final /* synthetic */ b this$0;

    public DoraLaunchProductDataLoader$requestAndProcessData$$inlined$requestData$1(b r1, Continuation r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraLaunchProductDataLoader$requestAndProcessData$$inlined$requestData$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super g> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        com.larus.network.http.f r10 = (com.larus.network.http.a) r9;
        if ((r10 instanceof com.larus.network.http.f) == false) goto L15;
        FLogger.a.e("DoraDynamicDataLoader", "Network request failed: " + r10.d.getMessage());
        return null;
    L15:
        return ((com.larus.network.http.a) r10).b;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        com.larus.dora.api.network.a r2 = com.larus.dora.api.network.a.a;
        JSONObject r4 = new JSONObject();
        this.label = 1;
        r9 = com.larus.dora.api.network.a.c(r2, g.class, "/alice/device/product_model_info", r4, null, this, 248);
        if (r9 != r0) goto L11;
        return r0;
    }
}
