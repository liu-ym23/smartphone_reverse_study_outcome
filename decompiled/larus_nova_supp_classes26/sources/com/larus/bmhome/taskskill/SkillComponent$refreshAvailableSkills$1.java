package com.larus.bmhome.taskskill;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.SkillComponent", f = "SkillComponent.kt", i = {0, 0, 0, 0, 0, 1}, l = {1760, 1768}, m = "refreshAvailableSkills-IoAF18A", n = {"conversationId", "requestParam", "requestOwnerUserId", "generation", "hasPendingDraftSkills", "result"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "L$0"})
public final class SkillComponent$refreshAvailableSkills$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SkillComponent this$0;

    public SkillComponent$refreshAvailableSkills$1(SkillComponent r1, Continuation<? super SkillComponent$refreshAvailableSkills$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.Xr(this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
