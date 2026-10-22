package com.larus.dora.impl.dynamic.quicknote;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteDetailFragment$setupObservers$2$1", f = "QuickNoteDetailFragment.kt", i = {0, 0}, l = {72}, m = "emit", n = {"state", "$this$emit_u24lambda_u240"}, s = {"L$0", "L$3"})
public final class QuickNoteDetailFragment$setupObservers$2$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuickNoteDetailFragment$setupObservers$2$1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public QuickNoteDetailFragment$setupObservers$2$1$emit$1(QuickNoteDetailFragment$setupObservers$2$1<? super T> r1, Continuation<? super QuickNoteDetailFragment$setupObservers$2$1$emit$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation<? super Unit>) this);
    }
}
