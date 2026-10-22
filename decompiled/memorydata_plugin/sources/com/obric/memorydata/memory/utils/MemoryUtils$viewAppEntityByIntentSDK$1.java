package com.obric.memorydata.memory.utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.utils.MemoryUtils", f = "MemoryUtils.kt", i = {}, l = {321}, m = "viewAppEntityByIntentSDK", n = {}, s = {})
final class MemoryUtils$viewAppEntityByIntentSDK$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ f this$0;

    MemoryUtils$viewAppEntityByIntentSDK$1(f r3, Continuation<? super MemoryUtils$viewAppEntityByIntentSDK$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
