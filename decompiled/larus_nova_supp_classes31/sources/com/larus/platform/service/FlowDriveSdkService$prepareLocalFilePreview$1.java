package com.larus.platform.service;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.platform.service.FlowDriveSdkService", f = "FlowDriveSdkService.kt", i = {}, l = {41}, m = "prepareLocalFilePreview", n = {}, s = {})
public final class FlowDriveSdkService$prepareLocalFilePreview$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowDriveSdkService this$0;

    public FlowDriveSdkService$prepareLocalFilePreview$1(FlowDriveSdkService r1, Continuation<? super FlowDriveSdkService$prepareLocalFilePreview$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.v(this);
    }
}
