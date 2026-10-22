package com.larus.dora.impl.onboarding;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.DoraOnboardingDialogViewModel$authDevice$1", f = "DoraOnboardingDialogViewModel.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2}, l = {747, 749, 754}, m = "invokeSuspend$authFailed", n = {"$device", "this$0", "reason", "t1", "t2", "t3", "this$0", "reason", "t1", "t2", "t3", "reason", "t1", "t2", "t3"}, s = {"L$0", "L$1", "L$2", "J$0", "J$1", "J$2", "L$0", "L$1", "J$0", "J$1", "J$2", "L$0", "J$0", "J$1", "J$2"})
public final class DoraOnboardingDialogViewModel$authDevice$1$authFailed$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    long J$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public DoraOnboardingDialogViewModel$authDevice$1$authFailed$1(Continuation<? super DoraOnboardingDialogViewModel$authDevice$1$authFailed$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        return DoraOnboardingDialogViewModel.AnonymousClass1.access$invokeSuspend$authFailed(null, null, null, 0, 0, 0, this);
    }
}
