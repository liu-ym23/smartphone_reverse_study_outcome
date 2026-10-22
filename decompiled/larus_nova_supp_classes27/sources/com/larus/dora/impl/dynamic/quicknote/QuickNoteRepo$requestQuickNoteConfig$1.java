package com.larus.dora.impl.dynamic.quicknote;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo", f = "QuickNoteRepo.kt", i = {}, l = {143}, m = "requestQuickNoteConfig", n = {}, s = {})
public final class QuickNoteRepo$requestQuickNoteConfig$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuickNoteRepo this$0;

    public QuickNoteRepo$requestQuickNoteConfig$1(QuickNoteRepo r1, Continuation<? super QuickNoteRepo$requestQuickNoteConfig$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        QuickNoteRepo r3 = this.this$0;
        QuickNoteRepo r0 = QuickNoteRepo.a;
        return r3.g(null, this);
    }
}
