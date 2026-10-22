package com.larus.bmhome.taskskill.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.network.TaskSkillRepository", f = "TaskSkillRepository.kt", i = {}, l = {117, 125}, m = "getRecommendSkills-0E7RQCE", n = {}, s = {})
public final class TaskSkillRepository$getRecommendSkills$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskSkillRepository this$0;

    public TaskSkillRepository$getRecommendSkills$1(TaskSkillRepository r1, Continuation<? super TaskSkillRepository$getRecommendSkills$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        Object r4 = this.this$0.f(false, null, this);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Result.box-impl(r4);
    }
}
