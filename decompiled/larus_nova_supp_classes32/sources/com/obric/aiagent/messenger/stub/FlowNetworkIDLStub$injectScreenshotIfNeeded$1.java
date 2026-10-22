package com.obric.aiagent.messenger.stub;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FlowNetworkIDLStub", f = "FlowNetworkIDLStub.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {93}, m = "injectScreenshotIfNeeded", n = {"event", "stats", "action", "messageIdKey", "questionIdKey", "contentObj", "mpParamsObj", "actionResultDataStr"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
public final class FlowNetworkIDLStub$injectScreenshotIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowNetworkIDLStub this$0;

    public FlowNetworkIDLStub$injectScreenshotIfNeeded$1(FlowNetworkIDLStub r1, Continuation<? super FlowNetworkIDLStub$injectScreenshotIfNeeded$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return FlowNetworkIDLStub.access$injectScreenshotIfNeeded(this.this$0, null, null, this);
    }
}
