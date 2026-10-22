package com.larus.bmhome.taskskill.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.network.TaskSkillRepository", f = "TaskSkillRepository.kt", i = {0, 0, 0, 0}, l = {777}, m = "requestLocalPcMeta-BWLJW6A", n = {"pcDeviceId", "workspace", "needSkills", "targetAppId"}, s = {"L$0", "L$1", "Z$0", "I$0"})
public final class TaskSkillRepository$requestLocalPcMeta$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskSkillRepository this$0;

    public TaskSkillRepository$requestLocalPcMeta$1(TaskSkillRepository r1, Continuation<? super TaskSkillRepository$requestLocalPcMeta$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        TaskSkillRepository r4 = this.this$0;
        TaskSkillRepository r0 = TaskSkillRepository.a;
        Object r5 = r4.q(null, false, null, this);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r5;
    L6:
        return Result.box-impl(r5);
    }
}
