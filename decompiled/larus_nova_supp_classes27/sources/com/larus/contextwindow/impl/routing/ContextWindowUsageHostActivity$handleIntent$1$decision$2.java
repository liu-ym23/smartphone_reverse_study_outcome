package com.larus.contextwindow.impl.routing;

import com.larus.contextwindow.api.ContextWindowEntryRequest;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/contextwindow/api/ContextWindowEntryDecision;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.contextwindow.impl.routing.ContextWindowUsageHostActivity$handleIntent$1$decision$2", f = "ContextWindowUsageHostActivity.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
public final class ContextWindowUsageHostActivity$handleIntent$1$decision$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.contextwindow.api.a>, Object> {
    final /* synthetic */ ContextWindowEntryRequest $request;
    int label;
    final /* synthetic */ ContextWindowUsageHostActivity this$0;

    public ContextWindowUsageHostActivity$handleIntent$1$decision$2(ContextWindowUsageHostActivity r1, ContextWindowEntryRequest r2, Continuation<? super ContextWindowUsageHostActivity$handleIntent$1$decision$2> r3) {
        this.this$0 = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ContextWindowUsageHostActivity$handleIntent$1$decision$2(this.this$0, this.$request, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.contextwindow.api.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        ContextWindowColdStartResolver r5 = this.this$0.g;
        ContextWindowEntryRequest r2 = this.$request;
        this.label = 1;
        r4 = r5.a(r2, this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
