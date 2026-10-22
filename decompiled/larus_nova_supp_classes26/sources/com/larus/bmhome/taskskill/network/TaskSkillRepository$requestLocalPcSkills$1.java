package com.larus.bmhome.taskskill.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.network.TaskSkillRepository", f = "TaskSkillRepository.kt", i = {0, 0}, l = {514}, m = "requestLocalPcSkills-gIAlu-s", n = {"pcDeviceId", "diskKey"}, s = {"L$0", "L$1"})
public final class TaskSkillRepository$requestLocalPcSkills$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskSkillRepository this$0;

    public TaskSkillRepository$requestLocalPcSkills$1(TaskSkillRepository r1, Continuation<? super TaskSkillRepository$requestLocalPcSkills$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        TaskSkillRepository r3 = this.this$0;
        TaskSkillRepository r0 = TaskSkillRepository.a;
        Object r4 = r3.r(null, this);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Result.box-impl(r4);
    }
}
