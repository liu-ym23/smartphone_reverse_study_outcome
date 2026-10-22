package com.obric.assistant.interaction.impl.essentialtask;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$2$1$1", f = "EssentialTaskServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Runnable $task;
    int label;

    public EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$2$1$1(Runnable r1, Continuation<? super EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$2$1$1> r2) {
        this.$task = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EssentialTaskServiceImpl$executePendingTaskWhenFinished$1$2$1$1(this.$task, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        FLogger r11 = FLogger.a;
        r11.i("EssentialTaskService", "start execute io pending task: " + this.$task);
        TaskUtils r0 = TaskUtils.INSTANCE;
        TaskUtils.systemLog$default(r0, "EssentialTaskService", "start execute io pending task: " + this.$task, null, 4, null);
        long r3 = SystemClock.elapsedRealtime();
        this.$task.run();
        long r5 = SystemClock.elapsedRealtime() - r3;
        r11.i("EssentialTaskService", "finish execute io pending task: " + this.$task + ", usedTime: " + r5);
        TaskUtils.systemLog$default(r0, "EssentialTaskService", "finish execute io pending task: " + this.$task + ", usedTime: " + r5, null, 4, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
