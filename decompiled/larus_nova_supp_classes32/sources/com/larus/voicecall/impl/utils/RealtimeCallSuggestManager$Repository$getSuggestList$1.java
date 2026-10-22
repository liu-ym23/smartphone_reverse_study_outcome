package com.larus.voicecall.impl.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voicecall.impl.utils.RealtimeCallSuggestManager$Repository", f = "RealtimeCallSuggestManager.kt", i = {}, l = {168}, m = "getSuggestList", n = {}, s = {})
public final class RealtimeCallSuggestManager$Repository$getSuggestList$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealtimeCallSuggestManager.Repository this$0;

    public RealtimeCallSuggestManager$Repository$getSuggestList$1(RealtimeCallSuggestManager.Repository r1, Continuation<? super RealtimeCallSuggestManager$Repository$getSuggestList$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
