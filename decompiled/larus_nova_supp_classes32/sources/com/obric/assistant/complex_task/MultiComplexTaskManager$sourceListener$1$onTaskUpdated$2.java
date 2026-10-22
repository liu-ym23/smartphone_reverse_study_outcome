package com.obric.assistant.complex_task;

import com.obric.aivoice.core.data.NameKeys;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.complex_task.MultiComplexTaskManager$sourceListener$1$onTaskUpdated$2", f = "MultiComplexTaskManager.kt", i = {}, l = {109}, m = "invokeSuspend", n = {}, s = {})
public final class MultiComplexTaskManager$sourceListener$1$onTaskUpdated$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $targetTaskId;
    int label;

    public MultiComplexTaskManager$sourceListener$1$onTaskUpdated$2(String r1, Continuation<? super MultiComplexTaskManager$sourceListener$1$onTaskUpdated$2> r2) {
        this.$targetTaskId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MultiComplexTaskManager$sourceListener$1$onTaskUpdated$2(this.$targetTaskId, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        Map r5 = MultiComplexTaskManager.a;
        Map r6 = MultiComplexTaskManager.b;
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6;
        r7.remove(this.$targetTaskId);
        Map r8 = MultiComplexTaskManager.a;
        ConcurrentHashMap r9 = (ConcurrentHashMap) r8;
        r9.remove(this.$targetTaskId);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        this.label = 1;
        if (DelayKt.delay(5000, this) != r0) goto L11;
        return r0;
    }
}
