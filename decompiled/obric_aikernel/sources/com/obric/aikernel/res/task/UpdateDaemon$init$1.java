package com.obric.aikernel.res.task;

import kotlin.KotlinNothingValueException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.task.UpdateDaemon$init$1", f = "UpdateDaemon.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
final class UpdateDaemon$init$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ UpdateDaemon this$0;

    UpdateDaemon$init$1(UpdateDaemon r10, Continuation<? super UpdateDaemon$init$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UpdateDaemon$init$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((UpdateDaemon$init$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L6;
        ResultKt.throwOnFailure(r10);
    L14:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        g1<String> r13 = UpdateDaemon.b(this.this$0).getConfig().getAppConfig().getAutoUpdateTrigger();
        if (r13 == null) goto L16;
        final UpdateDaemon r14 = this.this$0;
        d<? super String> r15 = new AnonymousClass1(r14);
        this.label = 1;
        if (r13.a(r15, this) != r11) goto L14;
        return r11;
    L16:
        return Unit.INSTANCE;
    }
}
