package com.larus.dora.impl.onboarding.othersmart;

import android.view.View;
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
@DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment$nextWithSharedElement$1", f = "DoraExternalOnboardingBaseFragment.kt", i = {0, 1}, l = {206, 97}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class DoraExternalOnboardingBaseFragment$nextWithSharedElement$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ View $sharedElementView;
    final /* synthetic */ String $transitionName;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ DoraExternalOnboardingBaseFragment this$0;

    public DoraExternalOnboardingBaseFragment$nextWithSharedElement$1(DoraExternalOnboardingBaseFragment r1, View r2, String r3, Fragment r4, Continuation<? super DoraExternalOnboardingBaseFragment$nextWithSharedElement$1> r5) {
        this.this$0 = r1;
        this.$sharedElementView = r2;
        this.$transitionName = r3;
        this.$fragment = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraExternalOnboardingBaseFragment$nextWithSharedElement$1(this.this$0, this.$sharedElementView, this.$transitionName, this.$fragment, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L9 Exception -> L11
    L30:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r3.unlock(null);
        return Unit.INSTANCE;
    L11:
        Exception e = e;
    L29:
        g49.d.e("DoraExternalOnboardingBaseFragment", "navigate with shared element failed: " + e.getMessage());     // Catch: Throwable -> L9
    L9:
        Throwable th = th;
    L33:
        r3.unlock(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Fragment r4 = (Fragment) this.L$4;
        String r5 = (String) this.L$3;
        View r6 = (View) this.L$2;
        DoraExternalOnboardingBaseFragment r7 = (DoraExternalOnboardingBaseFragment) this.L$1;
        kotlinx.coroutines.sync.a r8 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r14);
        Fragment r10 = r4;
        String r9 = r5;
        kotlinx.coroutines.sync.a r16 = r8;
    L20:
        View r11 = r6;
        MainCoroutineDispatcher r12 = Dispatchers.getMain();     // Catch: Throwable -> L25 Exception -> L27
        DoraExternalOnboardingBaseFragment$nextWithSharedElement$1$1$1 r13 = new DoraExternalOnboardingBaseFragment$nextWithSharedElement$1$1$1(r7, r11, r9, r10, null);     // Catch: Throwable -> L25 Exception -> L27
        this.L$0 = r16;     // Catch: Throwable -> L25 Exception -> L27
        this.L$1 = null;     // Catch: Throwable -> L25 Exception -> L27
        this.L$2 = null;     // Catch: Throwable -> L25 Exception -> L27
        this.L$3 = null;     // Catch: Throwable -> L25 Exception -> L27
        this.L$4 = null;     // Catch: Throwable -> L25 Exception -> L27
        this.label = 2;     // Catch: Throwable -> L25 Exception -> L27
        if (BuildersKt.withContext(r12, r13, this) != r1) goto L24;
        return r1;
    L24:
        r3 = r16;
        goto L30
    L27:
        e = move-exception;
        r3 = r16;
        e = e;
    L25:
        th = move-exception;
        r3 = r16;
        th = th;
        goto L33
    L16:
        ResultKt.throwOnFailure(r14);
        r16 = this.this$0.ca0().getMutex();
        r7 = this.this$0;
        r6 = this.$sharedElementView;
        String r17 = this.$transitionName;
        Fragment r18 = this.$fragment;
        this.L$0 = r16;
        this.L$1 = r7;
        this.L$2 = r6;
        this.L$3 = r17;
        this.L$4 = r18;
        this.label = 1;
        if (r16.a(null, this) != r1) goto L19;
        return r1;
    L19:
        r9 = r17;
        r10 = r18;
        goto L20
    }
}
