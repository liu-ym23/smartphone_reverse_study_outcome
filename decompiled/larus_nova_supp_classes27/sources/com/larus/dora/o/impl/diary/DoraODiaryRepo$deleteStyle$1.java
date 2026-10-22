package com.larus.dora.o.impl.diary;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.o.impl.diary.DoraODiaryRepo", f = "DoraODiaryRepo.kt", i = {}, l = {269}, m = "deleteStyle", n = {}, s = {})
public final class DoraODiaryRepo$deleteStyle$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraODiaryRepo this$0;

    public DoraODiaryRepo$deleteStyle$1(DoraODiaryRepo r1, Continuation<? super DoraODiaryRepo$deleteStyle$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, this);
    }
}
