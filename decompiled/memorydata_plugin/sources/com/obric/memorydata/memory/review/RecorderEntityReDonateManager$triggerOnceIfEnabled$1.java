package com.obric.memorydata.memory.review;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.review.RecorderEntityReDonateManager", f = "RecorderEntityReDonateManager.kt", i = {0, 0, 0, 0}, l = {89}, m = "triggerOnceIfEnabled", n = {AILabCheckPermissionTask.KEY_SOURCE, "store", "triggered", "retryCount"}, s = {"L$0", "L$1", "I$0", "I$1"})
final class RecorderEntityReDonateManager$triggerOnceIfEnabled$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    RecorderEntityReDonateManager$triggerOnceIfEnabled$1(d r3, Continuation<? super RecorderEntityReDonateManager$triggerOnceIfEnabled$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return d.a(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
