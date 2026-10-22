package com.larus.bmhome.taskskill.network;

import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.network.TaskSkillRepository", f = "TaskSkillRepository.kt", i = {0, 0, 0}, l = {280}, m = "addRecentlyUsedSkill-yxL6bBk", n = {"skillName", MusicAppletPage.KEY_PATH, "skillType"}, s = {"L$0", "L$1", "I$0"})
public final class TaskSkillRepository$addRecentlyUsedSkill$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TaskSkillRepository this$0;

    public TaskSkillRepository$addRecentlyUsedSkill$1(TaskSkillRepository r1, Continuation<? super TaskSkillRepository$addRecentlyUsedSkill$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        Object r8 = this.this$0.c(null, 0, null, null, this);
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r8;
    L6:
        return Result.box-impl(r8);
    }
}
