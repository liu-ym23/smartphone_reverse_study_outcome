package com.larus.drive.biz.impl.sdk;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.sdk.DriveSdkService", f = "DriveSdkService.kt", i = {}, l = {293}, m = "validateDriveFileInLarkSecurityControl", n = {}, s = {})
final class DriveSdkService$validateDriveFileInLarkSecurityControl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveSdkService this$0;

    public DriveSdkService$validateDriveFileInLarkSecurityControl$1(DriveSdkService r1, Continuation<? super DriveSdkService$validateDriveFileInLarkSecurityControl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.w(this);
    }
}
