package com.larus.dora.impl.onboarding.othersmart;

import com.larus.dora.impl.onboarding.DoraOnboardingDevice;
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
@DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingKeepAliveFragment$onViewCreated$2$1$2", f = "DoraExternalOnboardingKeepAliveFragment.kt", i = {}, l = {146}, m = "invokeSuspend", n = {}, s = {})
public final class DoraExternalOnboardingKeepAliveFragment$onViewCreated$2$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraExternalOnboardingKeepAliveFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingKeepAliveFragment$onViewCreated$2$1$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.DoraExternalOnboardingKeepAliveFragment$onViewCreated$2$1$2$1", f = "DoraExternalOnboardingKeepAliveFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DoraExternalOnboardingKeepAliveFragment this$0;

        public AnonymousClass1(DoraExternalOnboardingKeepAliveFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            DoraExternalOnboardingKeepAliveFragment r3 = this.this$0;
            int r0 = DoraExternalOnboardingKeepAliveFragment.u;
            r3.ga0();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DoraExternalOnboardingKeepAliveFragment$onViewCreated$2$1$2(DoraExternalOnboardingKeepAliveFragment r1, Continuation<? super DoraExternalOnboardingKeepAliveFragment$onViewCreated$2$1$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraExternalOnboardingKeepAliveFragment$onViewCreated$2$1$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L17:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DoraExternalOnboardingKeepAliveFragment r7 = this.this$0;
        int r2 = DoraExternalOnboardingKeepAliveFragment.u;
        r7.fa0().setOngoingNotification();
        DoraOnboardingDevice r8 = this.this$0.ca0().getDoraOnboardingDevice();
        if (r8 == null) goto L12;
        this.this$0.fa0().setCdm(r8.b, r8.c);
    L12:
        if (this.this$0.fa0().isCdmSwitchOn() == true) goto L17;
        g49.d.d("DoraExternalOnboardingKeepAliveFragment", "cdm not on, go directly to next page");
        this.this$0.fa0().reportOnboardingKeepAliveSetting(false);
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.this$0, null);
        this.label = 1;
        if (BuildersKt.withContext(r9, r3, this) != r0) goto L17;
        return r0;
    }
}
