package com.obric.capabilitykit;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import wia.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/obric/capabilitykit/AbstractCapabilityManager;", "it", "", "invoke", "(Lcom/obric/capabilitykit/AbstractCapabilityManager;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class AtomicCapabilitySdk$f extends Lambda implements Function1<n, Unit> {
    public final /* synthetic */ Continuation<Boolean> a;

    /* JADX WARN: Multi-variable type inference failed */
    public AtomicCapabilitySdk$f(Continuation<? super Boolean> r1) {
        this.a = r1;
        super(1);
    }

    public final void a(n r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        this.a.resumeWith(Result.constructor-impl(Boolean.valueOf(AtomicCapabilitySdk.access$getApi(AtomicCapabilitySdk.INSTANCE).a())));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        a((n) r1);
        return Unit.INSTANCE;
    }
}
