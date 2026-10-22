package com.obric.memorydata.memory.intent;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.intent.MobileMemAppFcExecutor", f = "MobileMemAppFcExecutor.kt", i = {0}, l = {78}, m = "executePackage", n = {"toolName"}, s = {"L$0"})
final class MobileMemAppFcExecutor$executePackage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MobileMemAppFcExecutor this$0;

    MobileMemAppFcExecutor$executePackage$1(MobileMemAppFcExecutor r3, Continuation<? super MobileMemAppFcExecutor$executePackage$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return MobileMemAppFcExecutor.a(this.this$0, null, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
