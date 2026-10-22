package com.larus.contextwindow.impl.membership;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/contextwindow/impl/membership/MembershipQuotaFetchResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.contextwindow.impl.membership.MembershipQuotaRepository$requestMembershipQuota$request$1$selected$1", f = "MembershipQuotaRepository.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
public final class MembershipQuotaRepository$requestMembershipQuota$request$1$selected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e>, Object> {
    int label;
    final /* synthetic */ MembershipQuotaRepository this$0;

    public MembershipQuotaRepository$requestMembershipQuota$request$1$selected$1(MembershipQuotaRepository r1, Continuation<? super MembershipQuotaRepository$requestMembershipQuota$request$1$selected$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MembershipQuotaRepository$requestMembershipQuota$request$1$selected$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super e> r2) {
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
        Function1<Continuation<? super e>, Object> r5 = this.this$0.c;
        this.label = 1;
        r4 = r5.invoke(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
