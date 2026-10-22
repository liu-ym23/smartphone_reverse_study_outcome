package com.larus.dora.impl.onboarding;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.OnboardingAvatarProvider", f = "OnboardingAvatarProvider.kt", i = {0}, l = {69}, m = "requestAvatarUrl", n = {"result"}, s = {"L$0"})
public final class OnboardingAvatarProvider$requestAvatarUrl$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OnboardingAvatarProvider this$0;

    public OnboardingAvatarProvider$requestAvatarUrl$1(OnboardingAvatarProvider r1, Continuation<? super OnboardingAvatarProvider$requestAvatarUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        OnboardingAvatarProvider r3 = this.this$0;
        OnboardingAvatarProvider r0 = OnboardingAvatarProvider.a;
        return r3.b(this);
    }
}
