package com.obric.aiagent.messenger.stub;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.stub.FlowNetworkIDLStub", f = "FlowNetworkIDLStub.kt", i = {0, 0, 0, 0, 0}, l = {258}, m = "injectScreenshotIntoPassThroughIfNeeded", n = {"passThrough", "questionIdKey", "messageIdKey", "root", "contentStr"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class FlowNetworkIDLStub$injectScreenshotIntoPassThroughIfNeeded$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowNetworkIDLStub this$0;

    public FlowNetworkIDLStub$injectScreenshotIntoPassThroughIfNeeded$1(FlowNetworkIDLStub r1, Continuation<? super FlowNetworkIDLStub$injectScreenshotIntoPassThroughIfNeeded$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return FlowNetworkIDLStub.access$injectScreenshotIntoPassThroughIfNeeded(this.this$0, null, this);
    }
}
