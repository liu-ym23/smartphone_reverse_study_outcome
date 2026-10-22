package com.obric.memorydata.memory.utils;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.utils.SmartMemoryUtils", f = "SmartMemoryUtils.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {57}, m = "takeSmartMemory", n = {ObricMemoryConstants.KEY_PACKAGE_NAME, "appName", "screenshot", "type", "pageContextHandle", "buildControl", "inAppAssociation", "logContext", "topActivity", "useCloudModel", "pageContextCaptureDisabled"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "Z$0", "Z$1"})
final class SmartMemoryUtils$takeSmartMemory$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ t this$0;

    SmartMemoryUtils$takeSmartMemory$1(t r3, Continuation<? super SmartMemoryUtils$takeSmartMemory$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        this.result = r15;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, null, null, null, false, false, null, null, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
