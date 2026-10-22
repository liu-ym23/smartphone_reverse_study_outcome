package com.obric.assistant.complex_task;

import com.larus.multitask_management.api.CancelFrom;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.complex_task.MultiComplexTaskManager$sourceListener$1$onTaskUpdated$3", f = "MultiComplexTaskManager.kt", i = {}, l = {127, 129}, m = "invokeSuspend", n = {}, s = {})
public final class MultiComplexTaskManager$sourceListener$1$onTaskUpdated$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $newScene;
    final /* synthetic */ String $targetTaskId;
    int label;

    public MultiComplexTaskManager$sourceListener$1$onTaskUpdated$3(String r1, String r2, Continuation<? super MultiComplexTaskManager$sourceListener$1$onTaskUpdated$3> r3) {
        this.$newScene = r1;
        this.$targetTaskId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MultiComplexTaskManager$sourceListener$1$onTaskUpdated$3(this.$newScene, this.$targetTaskId, r4);
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
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L22:
        Boolean r7 = (Boolean) r6;
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L17:
        pd6.b r8 = pd6.c.a;
        il9.a r9 = pd6.c.a(Reflection.getOrCreateKotlinClass(il9.a.class));
        if (r9 == null) goto L24;
        String r2 = this.$targetTaskId;
        CancelFrom r3 = CancelFrom.KEEP_TIMEOUT;
        this.label = 2;
        r6 = r9.a1(r2, r3, this);
        if (r6 != r0) goto L22;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        if (Intrinsics.areEqual(this.$newScene, "finish_task") == false) goto L13;
    L14:
        this.label = 1;
        if (DelayKt.delay(5000, this) != r0) goto L17;
        return r0;
    L13:
        if (Intrinsics.areEqual(this.$newScene, "fail_task") == false) goto L17;
        goto L14
    }
}
