package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaGrantingManager", f = "MoaGrantingManager.kt", i = {0, 0, 0, 1, 1, 1}, l = {486, 489}, m = "runExecution", n = {"execution", "context", "step", "execution", "context", "step"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class MoaGrantingManager$runExecution$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ k this$0;

    public MoaGrantingManager$runExecution$1(k r1, Continuation<? super MoaGrantingManager$runExecution$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return k.a(this.this$0, null, this);
    }
}
