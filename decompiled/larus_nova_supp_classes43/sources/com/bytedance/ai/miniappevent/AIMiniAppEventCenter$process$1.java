package com.bytedance.ai.miniappevent;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.miniappevent.AIMiniAppEventCenter", f = "AIMiniAppEventCenter.kt", i = {0, 0, 0}, l = {145}, m = "process", n = {"eventNotify", "dispatchContext", "payload"}, s = {"L$0", "L$1", "L$2"})
final class AIMiniAppEventCenter$process$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIMiniAppEventCenter this$0;

    public AIMiniAppEventCenter$process$1(AIMiniAppEventCenter r1, Continuation<? super AIMiniAppEventCenter$process$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return AIMiniAppEventCenter.a(this.this$0, null, null, this);
    }
}
