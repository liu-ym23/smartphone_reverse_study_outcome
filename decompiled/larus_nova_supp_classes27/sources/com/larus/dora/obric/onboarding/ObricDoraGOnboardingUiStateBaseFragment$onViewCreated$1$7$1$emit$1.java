package com.larus.dora.obric.onboarding;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.obric.onboarding.ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1", f = "ObricDoraGOnboardingUiStateBaseFragment.kt", i = {0, 1, 2, 3}, l = {230, 231, 241, 243}, m = "emit", n = {"event", "event", "event", "event"}, s = {"L$0", "L$0", "L$0", "L$0"})
public final class ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1$emit$1(ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1<? super T> r1, Continuation<? super ObricDoraGOnboardingUiStateBaseFragment$onViewCreated$1$7$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation<? super Unit>) this);
    }
}
