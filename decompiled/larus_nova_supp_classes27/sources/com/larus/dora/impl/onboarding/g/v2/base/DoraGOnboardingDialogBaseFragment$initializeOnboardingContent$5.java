package com.larus.dora.impl.onboarding.g.v2.base;

import com.larus.dora.impl.onboarding.o0;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.g.v2.base.DoraGOnboardingDialogBaseFragment$initializeOnboardingContent$5", f = "DoraGOnboardingDialogBaseFragment.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGOnboardingDialogBaseFragment$initializeOnboardingContent$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraGOnboardingDialogBaseFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ DoraGOnboardingDialogBaseFragment a;

        public a(DoraGOnboardingDialogBaseFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            DoraGOnboardingDialogBaseFragment r3 = this.a;
            r3.ca0((o0) r1);
            return Unit.INSTANCE;
        }
    }

    public DoraGOnboardingDialogBaseFragment$initializeOnboardingContent$5(DoraGOnboardingDialogBaseFragment r1, Continuation<? super DoraGOnboardingDialogBaseFragment$initializeOnboardingContent$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraGOnboardingDialogBaseFragment$initializeOnboardingContent$5(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        d1<o0> r6 = this.this$0.X90().getActionSharedFlow();
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
