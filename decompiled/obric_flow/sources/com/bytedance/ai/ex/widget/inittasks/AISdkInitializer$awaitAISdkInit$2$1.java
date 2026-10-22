package com.bytedance.ai.ex.widget.inittasks;

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
import kotlinx.coroutines.flow.h;
import kotlinx.coroutines.flow.p2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.ex.widget.inittasks.AISdkInitializer$awaitAISdkInit$2$1", f = "AISdkInitializer.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
public final class AISdkInitializer$awaitAISdkInit$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Continuation<Unit> $continuation;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AISdkInitializer$awaitAISdkInit$2$1(Continuation<? super Unit> r5, Continuation<? super AISdkInitializer$awaitAISdkInit$2$1> r10) {
        this.$continuation = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        AISdkInitializer$awaitAISdkInit$2$1 r11 = new AISdkInitializer$awaitAISdkInit$2$1(this.$continuation, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L6;
        ResultKt.throwOnFailure(r10);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        final CoroutineScope r12 = (CoroutineScope) this.L$0;
        p2 r13 = AISdkInitializer.INSTANCE.getInitializedFlow();
        final Continuation<Unit> r14 = this.$continuation;
        h r15 = new AnonymousClass1(r14, r12);
        this.label = 1;
        if (r13.collect(r15, this) != r5) goto L12;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AISdkInitializer$awaitAISdkInit$2$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
