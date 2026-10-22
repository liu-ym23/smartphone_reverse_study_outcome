package com.larus.commercemembership.impl.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.commercemembership.impl.utils.CommerceMembershipConfigManager$requestSubscriptionEntryConfig$1", f = "CommerceMembershipConfigManager.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
public final class CommerceMembershipConfigManager$requestSubscriptionEntryConfig$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $from;
    int label;

    public CommerceMembershipConfigManager$requestSubscriptionEntryConfig$1(String r1, Continuation<? super CommerceMembershipConfigManager$requestSubscriptionEntryConfig$1> r2) {
        this.$from = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommerceMembershipConfigManager$requestSubscriptionEntryConfig$1(this.$from, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.larus.commercemembership.impl.utils.a] */
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        final long r3 = System.currentTimeMillis();
        com.larus.commercemembership.impl.model.c r8 = com.larus.commercemembership.impl.model.c.a;
        final String r2 = this.$from;
        ?? r5 = new a(r2, r3);
        this.label = 1;
        if (r8.b(r2, r5, this) != r0) goto L12;
        return r0;
    }
}
