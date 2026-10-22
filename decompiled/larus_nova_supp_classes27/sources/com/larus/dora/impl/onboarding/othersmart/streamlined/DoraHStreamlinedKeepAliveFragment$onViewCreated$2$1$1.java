package com.larus.dora.impl.onboarding.othersmart.streamlined;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedKeepAliveFragment$onViewCreated$2$1$1", f = "DoraHStreamlinedKeepAliveFragment.kt", i = {}, l = {126, 129}, m = "invokeSuspend", n = {}, s = {})
public final class DoraHStreamlinedKeepAliveFragment$onViewCreated$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DoraHStreamlinedKeepAliveFragment this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedKeepAliveFragment$onViewCreated$2$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.onboarding.othersmart.streamlined.DoraHStreamlinedKeepAliveFragment$onViewCreated$2$1$1$1", f = "DoraHStreamlinedKeepAliveFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Boolean>, Object> {
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(r3);
            r0.Z$0 = ((Boolean) r2).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Boolean> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return Boxing.boxBoolean(this.Z$0);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DoraHStreamlinedKeepAliveFragment$onViewCreated$2$1$1(DoraHStreamlinedKeepAliveFragment r1, Continuation<? super DoraHStreamlinedKeepAliveFragment$onViewCreated$2$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraHStreamlinedKeepAliveFragment$onViewCreated$2$1$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L17:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        DoraHStreamlinedKeepAliveFragment r2 = this.this$0;
        ((Boolean) r7).booleanValue();
        g49.d.d("DoraHStreamlinedKeepAliveFragment", "cdm auth success, go to next page");
        int r8 = DoraHStreamlinedKeepAliveFragment.u;
        r2.fa0().reportOnboardingKeepAliveSetting(true);
        MainCoroutineDispatcher r9 = Dispatchers.getMain();
        DoraHStreamlinedKeepAliveFragment$onViewCreated$2$1$1$2$1 r4 = new DoraHStreamlinedKeepAliveFragment$onViewCreated$2$1$1$2$1(r2, null);
        this.label = 2;
        if (BuildersKt.withContext(r9, r4, this) != r0) goto L17;
        return r0;
    L10:
        ResultKt.throwOnFailure(r7);
        DoraHStreamlinedKeepAliveFragment r10 = this.this$0;
        int r3 = DoraHStreamlinedKeepAliveFragment.u;
        d1<Boolean> r11 = r10.fa0().getKeepAliveCdmToggleStateFlow();
        AnonymousClass1 r5 = new AnonymousClass1(null);
        this.label = 1;
        r7 = kotlinx.coroutines.flow.e.t(r11, r5, this);
        if (r7 != r0) goto L13;
        return r0;
    }
}
