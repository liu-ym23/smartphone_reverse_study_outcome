package com.bytedance.ai.bridge.method.router;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.router.CreateWidgetMethod", f = "CreateWidgetMethod.kt", i = {0, 0, 0, 0}, l = {181}, m = "generateWidgetMessage", n = {"questionId", "pageInfo", "conversationId", "callback"}, s = {"L$0", "L$1", "L$2", "L$3"})
final class CreateWidgetMethod$generateWidgetMessage$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreateWidgetMethod this$0;

    public CreateWidgetMethod$generateWidgetMessage$3(CreateWidgetMethod r1, Continuation<? super CreateWidgetMethod$generateWidgetMessage$3> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        return CreateWidgetMethod.b(this.this$0, null, null, null, null, null, null, null, null, this);
    }
}
