package com.obric.aikernel.res.update;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater$updateWithExecutionResult$result$1$1", f = "PackageUpdater.kt", i = {}, l = {625}, m = "invokeSuspend", n = {}, s = {})
final class PackageUpdater$updateWithExecutionResult$result$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super UpdateResult>, Object> {
    final /* synthetic */ PackageUpdater.b $constriction;
    final /* synthetic */ String $name;
    final /* synthetic */ CoroutineContext $rootCoroutine;
    int label;
    final /* synthetic */ PackageUpdater this$0;

    /* JADX INFO: renamed from: com.obric.aikernel.res.update.PackageUpdater$updateWithExecutionResult$result$1$1$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater$updateWithExecutionResult$result$1$1$1", f = "PackageUpdater.kt", i = {}, l = {636}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super UpdateResult>, Object> {
        final /* synthetic */ PackageUpdater.b $constriction;
        final /* synthetic */ String $name;
        final /* synthetic */ CoroutineContext $rootCoroutine;
        final /* synthetic */ UpdateTask $task;
        int label;

        AnonymousClass1(UpdateTask r10, String r11, PackageUpdater.b r12, CoroutineContext r13, Continuation<? super AnonymousClass1> r14) {
            this.$task = r10;
            this.$name = r11;
            this.$constriction = r12;
            this.$rootCoroutine = r13;
            super(1, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r10) {
            return new AnonymousClass1(this.$task, this.$name, this.$constriction, this.$rootCoroutine, r10);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super UpdateResult> r10) {
            return invoke2(r10);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super UpdateResult> r10) {
            return ((AnonymousClass1) create(r10)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r19) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            ResultKt.throwOnFailure(r19);
            Object r12 = r19;
        L16:
            UpdateResult r13 = (UpdateResult) r12;
            if (r13 == null) goto L19;
            return r13;
        L19:
            return new UpdateResult(this.$name, false, 0, null, false, 0, 0, this.$constriction.b(), 0, false, 894, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r19);
            UpdateTask r14 = this.$task;
            if (r14 == null) goto L19;
            PackageUpdater.b r15 = this.$constriction;
            CoroutineContext r16 = this.$rootCoroutine;
            if (r14.H().getCfg() != null) goto L13;
            r14.P(r15);
        L13:
            r14.n(r16, r15);
            this.label = 1;
            r12 = r14.o(this);
            if (r12 != r10) goto L16;
            return r10;
        }
    }

    PackageUpdater$updateWithExecutionResult$result$1$1(PackageUpdater r10, String r11, PackageUpdater.b r12, CoroutineContext r13, Continuation<? super PackageUpdater$updateWithExecutionResult$result$1$1> r14) {
        this.this$0 = r10;
        this.$name = r11;
        this.$constriction = r12;
        this.$rootCoroutine = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PackageUpdater$updateWithExecutionResult$result$1$1(this.this$0, this.$name, this.$constriction, this.$rootCoroutine, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super UpdateResult> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super UpdateResult> r11) {
        return ((PackageUpdater$updateWithExecutionResult$result$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L15:
        return r12;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        UpdateTask r13 = PackageUpdater.e(this.this$0, this.$name);
        if (r13 == null) goto L11;
        UpdateResult r14 = r13.H();
    L12:
        String r15 = this.$name;
        PackageUpdater.b r16 = this.$constriction;
        AnonymousClass1 r17 = new AnonymousClass1(r13, r15, r16, this.$rootCoroutine, null);
        this.label = 1;
        r12 = PackageUpdaterKt.a(r15, r16, r14, "primary", r17, this);
        if (r12 != r10) goto L15;
        return r10;
    L11:
        r14 = null;
        goto L12
    }
}
