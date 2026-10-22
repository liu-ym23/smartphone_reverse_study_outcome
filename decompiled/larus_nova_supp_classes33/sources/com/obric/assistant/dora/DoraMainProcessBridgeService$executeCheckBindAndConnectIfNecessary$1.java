package com.obric.assistant.dora;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.dora.DoraMainProcessBridgeService", f = "DoraMainProcessBridgeService.kt", i = {0, 0}, l = {374}, m = "executeCheckBindAndConnectIfNecessary", n = {"deviceInfo", "requestId"}, s = {"L$0", "L$1"})
final class DoraMainProcessBridgeService$executeCheckBindAndConnectIfNecessary$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraMainProcessBridgeService this$0;

    public DoraMainProcessBridgeService$executeCheckBindAndConnectIfNecessary$1(DoraMainProcessBridgeService r1, Continuation<? super DoraMainProcessBridgeService$executeCheckBindAndConnectIfNecessary$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DoraMainProcessBridgeService.a(this.this$0, null, null, this);
    }
}
