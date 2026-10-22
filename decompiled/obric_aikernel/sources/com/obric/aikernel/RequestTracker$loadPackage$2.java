package com.obric.aikernel;

import com.obric.aikernel.sdk.config.RequestParams;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.RequestTracker$loadPackage$2", f = "RequestTracker.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
final class RequestTracker$loadPackage$2 extends SuspendLambda implements Function1<Continuation<? super Pair<? extends com.obric.aikernel.request.b, ? extends Function1<? super com.obric.aikernel.request.b, ? extends RequestTracker.b>>>, Object> {
    final /* synthetic */ String $biz;
    final /* synthetic */ b $callback;
    final /* synthetic */ RequestParams $params;
    final /* synthetic */ String $tag;
    int label;
    final /* synthetic */ RequestTracker this$0;

    RequestTracker$loadPackage$2(RequestTracker r10, String r11, RequestParams r12, b r13, String r14, Continuation<? super RequestTracker$loadPackage$2> r15) {
        this.this$0 = r10;
        this.$biz = r11;
        this.$params = r12;
        this.$callback = r13;
        this.$tag = r14;
        super(1, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new RequestTracker$loadPackage$2(this.this$0, this.$biz, this.$params, this.$callback, this.$tag, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Pair<? extends com.obric.aikernel.request.b, ? extends Function1<? super com.obric.aikernel.request.b, ? extends RequestTracker.b>>> r10) {
        return invoke2(r10);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Pair<com.obric.aikernel.request.b, ? extends Function1<? super com.obric.aikernel.request.b, RequestTracker.b>>> r10) {
        return ((RequestTracker$loadPackage$2) create(r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        final String r13 = this.$tag;
        final String r14 = this.$biz;
        final RequestParams r15 = this.$params;
        return new Pair(r10, new AnonymousClass1(r13, r14, r15));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        com.obric.aikernel.request.a r16 = RequestTracker.i(this.this$0);
        String r17 = this.$biz;
        RequestParams r18 = this.$params;
        b r19 = this.$callback;
        this.label = 1;
        r10 = r16.h(r17, r18, r19, this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
