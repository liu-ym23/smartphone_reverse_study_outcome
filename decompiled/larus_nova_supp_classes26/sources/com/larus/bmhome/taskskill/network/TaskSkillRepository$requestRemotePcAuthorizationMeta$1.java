package com.larus.bmhome.taskskill.network;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.network.TaskSkillRepository", f = "TaskSkillRepository.kt", i = {0}, l = {546}, m = "requestRemotePcAuthorizationMeta-gIAlu-s$impl_mainlandRelease", n = {"pcDeviceId"}, s = {"L$0"})
public final class TaskSkillRepository$requestRemotePcAuthorizationMeta$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskSkillRepository this$0;

    public TaskSkillRepository$requestRemotePcAuthorizationMeta$1(TaskSkillRepository r1, Continuation<? super TaskSkillRepository$requestRemotePcAuthorizationMeta$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.s(null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
