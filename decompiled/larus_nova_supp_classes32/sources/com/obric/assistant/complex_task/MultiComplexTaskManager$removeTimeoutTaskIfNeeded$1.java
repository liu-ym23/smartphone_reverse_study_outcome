package com.obric.assistant.complex_task;

import com.larus.multitask_management.api.CancelFrom;
import com.obric.aivoice.core.data.NameKeys;
import kl9.u;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.complex_task.MultiComplexTaskManager$removeTimeoutTaskIfNeeded$1", f = "MultiComplexTaskManager.kt", i = {}, l = {191}, m = "invokeSuspend", n = {}, s = {})
public final class MultiComplexTaskManager$removeTimeoutTaskIfNeeded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancelFrom $cancelFrom;
    final /* synthetic */ u $task;
    int label;

    public MultiComplexTaskManager$removeTimeoutTaskIfNeeded$1(u r1, CancelFrom r2, Continuation<? super MultiComplexTaskManager$removeTimeoutTaskIfNeeded$1> r3) {
        this.$task = r1;
        this.$cancelFrom = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MultiComplexTaskManager$removeTimeoutTaskIfNeeded$1(this.$task, this.$cancelFrom, r4);
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
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L18
    L15:
        Boolean r6 = (Boolean) r5;     // Catch: Throwable -> L18
    L16:
        MultiComplexTaskManager.c.remove(this.$task.a);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        pd6.b r7 = pd6.c.a;     // Catch: Throwable -> L18
        il9.a r8 = pd6.c.a(Reflection.getOrCreateKotlinClass(il9.a.class));     // Catch: Throwable -> L18
        if (r8 == null) goto L16;
        String r2 = this.$task.a;     // Catch: Throwable -> L18
        CancelFrom r3 = this.$cancelFrom;     // Catch: Throwable -> L18
        this.label = 1;     // Catch: Throwable -> L18
        r5 = r8.a1(r2, r3, this);     // Catch: Throwable -> L18
        if (r5 != r0) goto L15;
        return r0;
    L18:
        th = move-exception;
        MultiComplexTaskManager.c.remove(this.$task.a);
        throw th;
    }
}
