package com.larus.drive.sdk.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.FlowDriveSdkServiceImpl", f = "FlowDriveSdkServiceImpl.kt", i = {}, l = {118}, m = "getDriveStorage", n = {}, s = {})
public final class FlowDriveSdkServiceImpl$getDriveStorage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FlowDriveSdkServiceImpl this$0;

    public FlowDriveSdkServiceImpl$getDriveStorage$1(FlowDriveSdkServiceImpl r1, Continuation<? super FlowDriveSdkServiceImpl$getDriveStorage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(this);
    }
}
