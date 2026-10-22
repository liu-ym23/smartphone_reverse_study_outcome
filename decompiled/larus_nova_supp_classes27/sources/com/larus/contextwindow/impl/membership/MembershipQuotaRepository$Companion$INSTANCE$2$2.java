package com.larus.contextwindow.impl.membership;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class MembershipQuotaRepository$Companion$INSTANCE$2$2 extends FunctionReferenceImpl implements Function1<Continuation<? super e>, Object>, SuspendFunction {
    public MembershipQuotaRepository$Companion$INSTANCE$2$2(Object r8) {
        super(1, r8, MembershipQuotaApi.class, "fetch", "fetch(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
    }

    public final Object invoke(Continuation<? super e> r2) {
        return ((MembershipQuotaApi) ((CallableReference) this).receiver).a(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }
}
