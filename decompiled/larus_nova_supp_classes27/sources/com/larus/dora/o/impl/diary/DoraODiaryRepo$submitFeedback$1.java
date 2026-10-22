package com.larus.dora.o.impl.diary;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.diary.DoraODiaryRepo", f = "DoraODiaryRepo.kt", i = {0, 0}, l = {132}, m = "submitFeedback", n = {"diaryId", "actionType"}, s = {"L$0", "I$0"})
public final class DoraODiaryRepo$submitFeedback$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraODiaryRepo this$0;

    public DoraODiaryRepo$submitFeedback$1(DoraODiaryRepo r1, Continuation<? super DoraODiaryRepo$submitFeedback$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(null, 0, null, null, null, null, this);
    }
}
