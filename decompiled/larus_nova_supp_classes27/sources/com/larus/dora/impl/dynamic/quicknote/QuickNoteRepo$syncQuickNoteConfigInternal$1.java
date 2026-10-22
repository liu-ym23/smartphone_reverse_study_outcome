package com.larus.dora.impl.dynamic.quicknote;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo", f = "QuickNoteRepo.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4}, l = {190, 194, 199, 202, 207}, m = "syncQuickNoteConfigInternal", n = {"config", "onSuccess", "onFail", "onFinally", "device", "syncGestureSettings", "config", "onSuccess", "onFinally", "device", "syncGestureSettings", "config", "onSuccess", "onFinally", "device", "syncGestureSettings", "config", "onSuccess", "onFinally", "device", "syncGestureSettings", "onSuccess", "onFinally"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1"})
public final class QuickNoteRepo$syncQuickNoteConfigInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ QuickNoteRepo this$0;

    public QuickNoteRepo$syncQuickNoteConfigInternal$1(QuickNoteRepo r1, Continuation<? super QuickNoteRepo$syncQuickNoteConfigInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        QuickNoteRepo r0 = this.this$0;
        QuickNoteRepo r9 = QuickNoteRepo.a;
        return r0.m(null, false, null, null, null, this);
    }
}
