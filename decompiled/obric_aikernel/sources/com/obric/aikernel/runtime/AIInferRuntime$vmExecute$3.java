package com.obric.aikernel.runtime;

import androidx.core.app.NotificationCompat;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime", f = "AIInferRuntime.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4}, l = {241, 244, 248, 249, 259}, m = "vmExecute", n = {"this", "biz", "params", NotificationCompat.CATEGORY_EVENT, "callback", "this", "biz", "params", NotificationCompat.CATEGORY_EVENT, "callback", "this", "biz", "params", NotificationCompat.CATEGORY_EVENT, "callback", "loraType", "this", "biz", "params", NotificationCompat.CATEGORY_EVENT, "callback", "loraType", "pkgWrapper", "biz", "callback", "loraType"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2"})
final class AIInferRuntime$vmExecute$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$vmExecute$3(AIInferRuntime r10, Continuation<? super AIInferRuntime$vmExecute$3> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.L0(null, null, null, null, this);
    }
}
