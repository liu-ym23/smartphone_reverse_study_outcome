package com.obric.memorydata.aikernelcore;

import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller", f = "AiKernelRunModelCaller.kt", i = {0, 0, 0, 0, 0, 1, 1}, l = {122, 136}, m = "preloadModels", n = {"loraNames", "callingPkg", TrackerImpl.PARAMS, "$this$forEach$iv", "loadLora", "callingPkg", "$this$forEach$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "L$0", "L$1"})
final class AiKernelRunModelCaller$preloadModels$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    AiKernelRunModelCaller$preloadModels$1(a r3, Continuation<? super AiKernelRunModelCaller$preloadModels$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, null, false, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
