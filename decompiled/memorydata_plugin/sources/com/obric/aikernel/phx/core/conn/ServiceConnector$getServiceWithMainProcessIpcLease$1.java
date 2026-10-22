package com.obric.aikernel.phx.core.conn;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.core.conn.ServiceConnector", f = "ServiceConnector.kt", i = {0, 0}, l = {293}, m = "getServiceWithMainProcessIpcLease$sdk_release", n = {"this", "deadlineMs"}, s = {"L$0", "J$0"})
final class ServiceConnector$getServiceWithMainProcessIpcLease$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ServiceConnector this$0;

    ServiceConnector$getServiceWithMainProcessIpcLease$1(ServiceConnector r3, Continuation<? super ServiceConnector$getServiceWithMainProcessIpcLease$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getServiceWithMainProcessIpcLease$sdk_release(0, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
