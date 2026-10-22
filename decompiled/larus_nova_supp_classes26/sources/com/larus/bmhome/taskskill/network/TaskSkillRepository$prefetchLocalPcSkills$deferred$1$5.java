package com.larus.bmhome.taskskill.network;

import android.os.SystemClock;
import com.larus.bmhome.taskskill.model.TaskSkill;
import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
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
@DebugMetadata(c = "com.larus.bmhome.taskskill.network.TaskSkillRepository$prefetchLocalPcSkills$deferred$1$5", f = "TaskSkillRepository.kt", i = {}, l = {431}, m = "invokeSuspend", n = {}, s = {})
public final class TaskSkillRepository$prefetchLocalPcSkills$deferred$1$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends List<? extends TaskSkill>>>, Object> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ q $requestParam;
    int label;

    public TaskSkillRepository$prefetchLocalPcSkills$deferred$1$5(q r1, String r2, Continuation<? super TaskSkillRepository$prefetchLocalPcSkills$deferred$1$5> r3) {
        this.$requestParam = r1;
        this.$cacheKey = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TaskSkillRepository$prefetchLocalPcSkills$deferred$1$5(this.$requestParam, this.$cacheKey, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends List<TaskSkill>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
        Object r10 = ((Result) r9).unbox-impl();
    L11:
        String r2 = this.$cacheKey;
        q r3 = this.$requestParam;
        if (Result.isSuccess-impl(r10) == false) goto L14;
        ConcurrentHashMap<String, e> r4 = TaskSkillRepository.h;
        long r5 = SystemClock.elapsedRealtime();
        TaskSkillRepository r7 = TaskSkillRepository.a;
        r4.put(r2, new e((List) r10, r5, TaskSkillRepository.g(r3)));
    L14:
        String r6 = this.$cacheKey;
        Throwable r8 = Result.exceptionOrNull-impl(r10);
        if (r8 == null) goto L18;
        FLogger.a.w("TaskSkillRepository", "local pc prefetch failed, key=" + r6 + ", msg=" + r8.getMessage());
    L18:
        return Result.box-impl(r10);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        TaskSkillRepository r11 = TaskSkillRepository.a;
        q r12 = this.$requestParam;
        this.label = 1;
        r10 = r11.r(r12, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
