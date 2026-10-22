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
@DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1", f = "DoraExternalOnboardingBaseFragment.kt", i = {0, 1}, l = {206, 133}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
final class DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Fragment $fragment;
    final /* synthetic */ String $fragmentTag;
    final /* synthetic */ View $sharedElementView;
    final /* synthetic */ String $transitionName;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ DoraExternalOnboardingBaseFragment this$0;

    public DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1(DoraExternalOnboardingBaseFragment r1, View r2, String r3, Fragment r4, String r5, Continuation<? super DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1> r6) {
        this.this$0 = r1;
        this.$sharedElementView = r2;
        this.$transitionName = r3;
        this.$fragment = r4;
        this.$fragmentTag = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1(this.this$0, this.$sharedElementView, this.$transitionName, this.$fragment, this.$fragmentTag, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L9 Exception -> L11
    L30:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r3.unlock(null);
        return Unit.INSTANCE;
    L11:
        Exception e = e;
    L29:
        g49.d.e("DoraExternalOnboardingBaseFragment", "navigate with shared element overlay failed: " + e.getMessage());     // Catch: Throwable -> L9
    L9:
        Throwable th = th;
    L33:
        r3.unlock(null);
        throw th;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        String r4 = (String) this.L$5;
        Fragment r5 = (Fragment) this.L$4;
        String r6 = (String) this.L$3;
        View r7 = (View) this.L$2;
        DoraExternalOnboardingBaseFragment r8 = (DoraExternalOnboardingBaseFragment) this.L$1;
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r15);
        String r11 = r4;
        Fragment r10 = r5;
        kotlinx.coroutines.sync.a r17 = r9;
    L20:
        String r12 = r6;
        DoraExternalOnboardingBaseFragment r13 = r8;
        View r14 = r7;
        MainCoroutineDispatcher r18 = Dispatchers.getMain();     // Catch: Throwable -> L25 Exception -> L27
        DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1$1$1 r20 = new DoraExternalOnboardingBaseFragment$nextWithSharedElementOverlay$1$1$1(r13, r14, r12, r10, r11, null);     // Catch: Throwable -> L25 Exception -> L27
        this.L$0 = r17;     // Catch: Throwable -> L25 Exception -> L27
        this.L$1 = null;     // Catch: Throwable -> L25 Exception -> L27
        this.L$2 = null;     // Catch: Throwable -> L25 Exception -> L27
        this.L$3 = null;     // Catch: Throwable -> L25 Exception -> L27
        this.L$4 = null;     // Catch: Throwable -> L25 Exception -> L27
        this.L$5 = null;     // Catch: Throwable -> L25 Exception -> L27
        this.label = 2;     // Catch: Throwable -> L25 Exception -> L27
        if (BuildersKt.withContext(r18, r20, this) != r1) goto L24;
        return r1;
    L24:
        r3 = r17;
        goto L30
    L27:
        e = move-exception;
        r3 = r17;
        e = e;
    L25:
        th = move-exception;
        r3 = r17;
        th = th;
        goto L33
    L16:
        ResultKt.throwOnFailure(r15);
        r17 = this.this$0.ca0().getMutex();
        r8 = this.this$0;
        r7 = this.$sharedElementView;
        r6 = this.$transitionName;
        Fragment r21 = this.$fragment;
        String r22 = this.$fragmentTag;
        this.L$0 = r17;
        this.L$1 = r8;
        this.L$2 = r7;
        this.L$3 = r6;
        this.L$4 = r21;
        this.L$5 = r22;
        this.label = 1;
        if (r17.a(null, this) != r1) goto L19;
        return r1;
    L19:
        r10 = r21;
        r11 = r22;
        goto L20
    }
}
