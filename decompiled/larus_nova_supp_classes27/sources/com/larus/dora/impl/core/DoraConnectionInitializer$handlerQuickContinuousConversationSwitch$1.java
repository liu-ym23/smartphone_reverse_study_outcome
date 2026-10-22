package com.larus.dora.impl.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraConnectionInitializer", f = "DoraConnectionInitializer.kt", i = {}, l = {84}, m = "handlerQuickContinuousConversationSwitch", n = {}, s = {})
final class DoraConnectionInitializer$handlerQuickContinuousConversationSwitch$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ v this$0;

    public DoraConnectionInitializer$handlerQuickContinuousConversationSwitch$1(v r1, Continuation<? super DoraConnectionInitializer$handlerQuickContinuousConversationSwitch$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return v.a(this.this$0, this);
    }
}
