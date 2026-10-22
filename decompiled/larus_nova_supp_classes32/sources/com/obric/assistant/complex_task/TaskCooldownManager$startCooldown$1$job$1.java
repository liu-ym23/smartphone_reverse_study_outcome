package com.obric.assistant.complex_task;

import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.complex_task.TaskCooldownManager$startCooldown$1$job$1", f = "TaskCooldownManager.kt", i = {0}, l = {41}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class TaskCooldownManager$startCooldown$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $action;
    final /* synthetic */ String $taskId;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ t this$0;

    public TaskCooldownManager$startCooldown$1$job$1(t r1, String r2, Function0<Unit> r3, Continuation<? super TaskCooldownManager$startCooldown$1$job$1> r4) {
        this.this$0 = r1;
        this.$taskId = r2;
        this.$action = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        TaskCooldownManager$startCooldown$1$job$1 r0 = new TaskCooldownManager$startCooldown$1$job$1(this.this$0, this.$taskId, this.$action, r6);
        r0.L$0 = r5;
        return r0;
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
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L8
    L17:
        this.this$0.b.remove(this.$taskId);
        if (CoroutineScopeKt.isActive(r2) == false) goto L21;
        this.$action.invoke();
    L21:
        return Unit.INSTANCE;
    L8:
        Throwable th = th;
    L24:
        this.this$0.b.remove(this.$taskId);
        if (CoroutineScopeKt.isActive(r2) == false) goto L27;
        this.$action.invoke();
    L27:
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        this.L$0 = r6;     // Catch: Throwable -> L22
        this.label = 1;     // Catch: Throwable -> L22
        if (DelayKt.delay(2000, this) != r0) goto L16;
        return r0;
    L16:
        r2 = r6;
    L22:
        th = move-exception;
        r2 = r6;
        th = th;
        goto L24
    }
}
