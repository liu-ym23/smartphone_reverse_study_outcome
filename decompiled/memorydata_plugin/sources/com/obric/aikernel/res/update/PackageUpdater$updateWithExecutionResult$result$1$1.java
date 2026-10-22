package com.obric.aikernel.res.update;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/res/update/UpdateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater$updateWithExecutionResult$result$1$1", f = "PackageUpdater.kt", i = {}, l = {642}, m = "invokeSuspend", n = {}, s = {})
final class PackageUpdater$updateWithExecutionResult$result$1$1 extends SuspendLambda implements Function2<al, Continuation<? super UpdateResult>, Object> {
    final /* synthetic */ n.b $constriction;
    final /* synthetic */ String $name;
    final /* synthetic */ CoroutineContext $rootCoroutine;
    int label;
    final /* synthetic */ n this$0;

    /* JADX INFO: renamed from: com.obric.aikernel.res.update.PackageUpdater$updateWithExecutionResult$result$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/res/update/UpdateResult;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater$updateWithExecutionResult$result$1$1$1", f = "PackageUpdater.kt", i = {}, l = {653}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super UpdateResult>, Object> {
        final /* synthetic */ n.b $constriction;
        final /* synthetic */ String $name;
        final /* synthetic */ CoroutineContext $rootCoroutine;
        final /* synthetic */ s $task;
        int label;

        AnonymousClass1(s r3, String r4, n.b r5, CoroutineContext r6, Continuation<? super AnonymousClass1> r7) {
            CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r6, CoroutineContext.class, "com.obric.memorydata.plugin");
            Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.$task = r3;
            this.$name = r4;
            this.$constriction = r5;
            this.$rootCoroutine = r8;
            super(1, r9);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r9) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$task, this.$name, this.$constriction, this.$rootCoroutine, r7), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Object invoke(Continuation<? super UpdateResult> r3) {
            return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super UpdateResult> r3) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r18);
            Object r3 = r18;
        L16:
            UpdateResult r4 = (UpdateResult) ZeusTransformUtils.preCheckCast(r3, UpdateResult.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L19;
            return r4;
        L19:
            return new UpdateResult(this.$name, false, 0, null, false, 0, 0, this.$constriction.a(), 0, false, 894, null);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r18);
            s r5 = this.$task;
            if (r5 == null) goto L19;
            n.b r6 = this.$constriction;
            CoroutineContext r7 = this.$rootCoroutine;
            if (r5.a().getCfg() != null) goto L13;
            r5.a(r6);
        L13:
            r5.a(r7, r6);
            Continuation<? super UpdateResult> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r3 = r5.a(r8);
            if (r3 != r1) goto L16;
            return r1;
        }
    }

    PackageUpdater$updateWithExecutionResult$result$1$1(n r3, String r4, n.b r5, CoroutineContext r6, Continuation<? super PackageUpdater$updateWithExecutionResult$result$1$1> r7) {
        CoroutineContext r8 = (CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r6, CoroutineContext.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$name = r4;
        this.$constriction = r5;
        this.$rootCoroutine = r8;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new PackageUpdater$updateWithExecutionResult$result$1$1(this.this$0, this.$name, this.$constriction, this.$rootCoroutine, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super UpdateResult> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super UpdateResult> r4) {
        return ((PackageUpdater$updateWithExecutionResult$result$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PackageUpdater$updateWithExecutionResult$result$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L15:
        return r12;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        s r4 = n.a(this.this$0, this.$name);
        if (r4 == null) goto L11;
        UpdateResult r13 = r4.a();
    L12:
        String r2 = this.$name;
        n.b r9 = this.$constriction;
        Function1 r3 = (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r4, this.$name, this.$constriction, this.$rootCoroutine, null), Function1.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r12 = o.a(r2, r9, r13, "primary", r3, r10);
        if (r12 != r0) goto L15;
        return r0;
    L11:
        r13 = null;
        goto L12
    }
}
