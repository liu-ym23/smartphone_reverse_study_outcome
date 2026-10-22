package com.obric.aikernel.phx.core.conn;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.conn.ServiceConnector", f = "ServiceConnector.kt", i = {0, 0}, l = {293}, m = "getServiceWithMainProcessIpcLease$sdk_release", n = {"this", "deadlineMs"}, s = {"L$0", "J$0"})
final class ServiceConnector$getServiceWithMainProcessIpcLease$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ServiceConnector this$0;

    ServiceConnector$getServiceWithMainProcessIpcLease$1(ServiceConnector r10, Continuation<? super ServiceConnector$getServiceWithMainProcessIpcLease$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.v(0, this);
    }
}
