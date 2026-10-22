package com.larus.dora.impl.onboarding.othersmart;

import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment$navigateToFragment$1", f = "DoraExternalOnboardingBaseFragment.kt", i = {0, 1}, l = {206, 60}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class DoraExternalOnboardingBaseFragment$navigateToFragment$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ DoraExternalOnboardingBaseFragment this$0;

    public DoraExternalOnboardingBaseFragment$navigateToFragment$1(DoraExternalOnboardingBaseFragment r1, Fragment r2, Continuation<? super DoraExternalOnboardingBaseFragment$navigateToFragment$1> r3) {
        this.this$0 = r1;
        this.$fragment = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraExternalOnboardingBaseFragment$navigateToFragment$1(this.this$0, this.$fragment, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L9 Exception -> L11
    L29:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r3.unlock(null);
        return Unit.INSTANCE;
    L11:
        Exception e = e;
    L28:
        g49.d.e("DoraExternalOnboardingBaseFragment", "navigate to next fragment failed: " + e.getMessage());     // Catch: Throwable -> L9
    L9:
        Throwable th = th;
    L32:
        r3.unlock(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Fragment r4 = (Fragment) this.L$2;
        DoraExternalOnboardingBaseFragment r5 = (DoraExternalOnboardingBaseFragment) this.L$1;
        kotlinx.coroutines.sync.a r6 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.sync.a r12 = r6;
    L37:
        MainCoroutineDispatcher r7 = Dispatchers.getMain();     // Catch: Throwable -> L24 Exception -> L26
        DoraExternalOnboardingBaseFragment$navigateToFragment$1$1$1 r8 = new DoraExternalOnboardingBaseFragment$navigateToFragment$1$1$1(r5, r4, null);     // Catch: Throwable -> L24 Exception -> L26
        this.L$0 = r12;     // Catch: Throwable -> L24 Exception -> L26
        this.L$1 = null;     // Catch: Throwable -> L24 Exception -> L26
        this.L$2 = null;     // Catch: Throwable -> L24 Exception -> L26
        this.label = 2;     // Catch: Throwable -> L24 Exception -> L26
        if (BuildersKt.withContext(r7, r8, this) != r1) goto L23;
        return r1;
    L23:
        r3 = r12;
        goto L29
    L26:
        e = move-exception;
        r3 = r12;
        e = e;
    L24:
        th = move-exception;
        r3 = r12;
        th = th;
        goto L32
    L16:
        ResultKt.throwOnFailure(r10);
        r12 = this.this$0.ca0().getMutex();
        DoraExternalOnboardingBaseFragment r9 = this.this$0;
        Fragment r13 = this.$fragment;
        this.L$0 = r12;
        this.L$1 = r9;
        this.L$2 = r13;
        this.label = 1;
        if (r12.a(null, this) != r1) goto L19;
        return r1;
    L19:
        r5 = r9;
        r4 = r13;
        goto L37
    }
}
