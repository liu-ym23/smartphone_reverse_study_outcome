package com.larus.dora.impl.onboarding2;

import com.larus.dora.impl.onboarding.OnboardingAvatarProvider;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding2.DoraOnboardingNotificationGuideFragment$setupAvatar$2$avatarUrl$1", f = "DoraOnboardingNotificationGuideFragment.kt", i = {}, l = {119}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOnboardingNotificationGuideFragment$setupAvatar$2$avatarUrl$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    public DoraOnboardingNotificationGuideFragment$setupAvatar$2$avatarUrl$1(Continuation<? super DoraOnboardingNotificationGuideFragment$setupAvatar$2$avatarUrl$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new DoraOnboardingNotificationGuideFragment$setupAvatar$2$avatarUrl$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r2) {
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
        OnboardingAvatarProvider r5 = OnboardingAvatarProvider.a;
        this.label = 1;
        r4 = r5.a(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
