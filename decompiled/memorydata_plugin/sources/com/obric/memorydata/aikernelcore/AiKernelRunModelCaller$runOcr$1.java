package com.obric.memorydata.aikernelcore;

import com.bytedance.crash.npth_repair.utils.RepairState;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.aikernelcore.AiKernelRunModelCaller", f = "AiKernelRunModelCaller.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1}, l = {RepairState.STATE_RAW, 1120}, m = "runOcr", n = {"this", "img", ObricMemoryConstants.KEY_PACKAGE_NAME, "foregroundCallerPkg", "allWordInSingle", "throwThermalStatusError", "startTime", "ret", "throwThermalStatusError", "startTime"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "Z$1", "J$0", "L$0", "Z$0", "J$0"})
final class AiKernelRunModelCaller$runOcr$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    AiKernelRunModelCaller$runOcr$1(a r3, Continuation<? super AiKernelRunModelCaller$runOcr$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, false, null, false, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
