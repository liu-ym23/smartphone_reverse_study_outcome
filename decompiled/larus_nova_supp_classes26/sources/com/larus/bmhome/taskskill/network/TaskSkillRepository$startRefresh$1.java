package com.larus.bmhome.taskskill.network;

import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.utils.logger.FLogger;
import java.util.List;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lcom/larus/bmhome/taskskill/model/TaskSkill;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.network.TaskSkillRepository$startRefresh$1", f = "TaskSkillRepository.kt", i = {}, l = {363}, m = "invokeSuspend", n = {}, s = {})
public final class TaskSkillRepository$startRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends TaskSkill>>>, Object> {
    final /* synthetic */ int $generation;
    final /* synthetic */ boolean $logPrefetchFailure;
    int label;

    public TaskSkillRepository$startRefresh$1(int r1, boolean r2, Continuation<? super TaskSkillRepository$startRefresh$1> r3) {
        this.$generation = r1;
        this.$logPrefetchFailure = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TaskSkillRepository$startRefresh$1(this.$generation, this.$logPrefetchFailure, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends List<TaskSkill>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L11:
        boolean r2 = this.$logPrefetchFailure;
        Throwable r3 = Result.exceptionOrNull-impl(r6);
        if (r3 == null) goto L16;
        if (r2 == false) goto L16;
        FLogger.a.w("TaskSkillRepository", "prefetch failed, msg=" + r3.getMessage());
    L16:
        return Result.box-impl(r6);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        TaskSkillRepository r7 = TaskSkillRepository.a;
        int r4 = this.$generation;
        this.label = 1;
        r6 = TaskSkillRepository.a(r7, r4, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
