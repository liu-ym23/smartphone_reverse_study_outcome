package com.obric.assistant.interaction.impl.essentialtask;

import android.os.SystemClock;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.obric.assistant.interaction.api.essentialtask.ExecuteState;
import com.obric.assistant.interaction.api.essentialtask.ExecuteState$Failed;
import com.obric.assistant.interaction.impl.essentialtask.base.EssentialTask;
import com.obric.assistant.interaction.impl.essentialtask.base.ExecuteResult;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.EssentialTaskManager$startExecuteRootTask$1", f = "EssentialTaskManager.kt", i = {0}, l = {70}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
public final class EssentialTaskManager$startExecuteRootTask$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EssentialTask $task;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    public EssentialTaskManager$startExecuteRootTask$1(EssentialTask r1, Continuation<? super EssentialTaskManager$startExecuteRootTask$1> r2) {
        this.$task = r1;
        super(2, r2);
    }

    public static /* synthetic */ void a(ExecuteResult r0) {
        invokeSuspend$lambda$4$lambda$3(r0);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        EssentialTaskManager$startExecuteRootTask$1 r0 = new EssentialTaskManager$startExecuteRootTask$1(this.$task, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    private static final void invokeSuspend$lambda$4$lambda$3(ExecuteResult r3) {
        EssentialTaskManager.access$getExecuteSucceedState$p().setValue(Boolean.valueOf(r3.isSuccess()));
        if (r3.isSuccess() == false) goto L5;
        EssentialTaskManager.access$getExecuteStateFlow$p().setValue(new ExecuteState.Succeed());
        return;
    L5:
        z0 r4 = EssentialTaskManager.access$getExecuteStateFlow$p();
        final String r1 = AppHost.a.getApplication().getString(2131912400);
        r4.setValue(new ExecuteState$Failed(r1));
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        long r2 = this.J$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L8
    L17:
        Object r13 = Result.constructor-impl((ExecuteResult) r12);     // Catch: Throwable -> L8
    L22:
        Throwable r3 = Result.exceptionOrNull-impl(r13);
        if (r3 == null) goto L26;
        FLogger.a.w("EssentialTaskManager", "startExecuteRootTask: execute failed: " + r3.getMessage() + ", cost time " + (SystemClock.elapsedRealtime() - r2) + " ms", r3);
        TaskUtils r5 = TaskUtils.INSTANCE;
        StringBuilder r6 = new StringBuilder("execute failed: ");
        r6.append(r3.getMessage());
        r5.systemLog("EssentialTaskManager", r6.toString(), r3);
    L26:
        if (Result.isSuccess-impl(r13) == false) goto L30;
        ExecuteResult r4 = (ExecuteResult) r13;
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, "EssentialTaskManager", "execute succeed, cost time " + (SystemClock.elapsedRealtime() - r2) + " ms", null, 4, null);
        if (r4.isSuccess() == true) goto L30;
        FLogger.a.w("EssentialTaskManager", "startExecuteRootTask: execute not succeed: " + r4.getErrorInfo());
    L30:
        ExecuteResult r7 = new ExecuteResult(false, null, 2, null);
        if (Result.isFailure-impl(r13) == false) goto L33;
        r13 = r7;
    L33:
        final ExecuteResult r14 = (ExecuteResult) r13;
        t0.e(new b(r14));
        return Unit.INSTANCE;
    L8:
        th = th;
    L21:
        Result.Companion r8 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, "EssentialTaskManager", "start", null, 4, null);
        long r9 = SystemClock.elapsedRealtime();
        EssentialTask r16 = this.$task;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L19
        this.J$0 = r9;     // Catch: Throwable -> L19
        this.label = 1;     // Catch: Throwable -> L19
        r12 = r16.execute(this);     // Catch: Throwable -> L19
        if (r12 != r0) goto L16;
        return r0;
    L16:
        r2 = r9;
    L19:
        th = th;
        r2 = r9;
        goto L21
    }
}
