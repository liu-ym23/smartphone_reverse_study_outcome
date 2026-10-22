package com.larus.bmhome.taskskill.service;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.service.SkillServiceDelegate", f = "ISkillService.kt", i = {}, l = {331}, m = "removeRecentlyUsedSkill-yxL6bBk", n = {}, s = {})
public final class SkillServiceDelegate$removeRecentlyUsedSkill$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SkillServiceDelegate this$0;

    public SkillServiceDelegate$removeRecentlyUsedSkill$1(SkillServiceDelegate r1, Continuation<? super SkillServiceDelegate$removeRecentlyUsedSkill$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        Object r8 = this.this$0.q(null, 0, null, null, this);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Result.box-impl(r8);
    }
}
