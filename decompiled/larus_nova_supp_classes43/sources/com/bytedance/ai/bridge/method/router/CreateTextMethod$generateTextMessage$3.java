package com.bytedance.ai.bridge.method.router;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.router.CreateTextMethod", f = "CreateTextMethod.kt", i = {0, 0, 0, 0}, l = {158}, m = "generateTextMessage", n = {"questionId", "botId", "conversationId", "callback"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class CreateTextMethod$generateTextMessage$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreateTextMethod this$0;

    public CreateTextMethod$generateTextMessage$3(CreateTextMethod r1, Continuation<? super CreateTextMethod$generateTextMessage$3> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        return CreateTextMethod.b(this.this$0, null, null, null, null, null, null, null, null, null, this);
    }
}
