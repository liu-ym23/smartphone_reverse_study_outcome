package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager", f = "AppDiskManager.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {3551, 3561}, m = "scanAppFileAndReport", n = {"snapshotId", "$this$withLock_u24default$iv", "scanSampleRate", "isLowDisk", "fileInfoList", "fileTypeSummary", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "F$0", "Z$0", "L$0", "L$1", "L$2"})
final class AppDiskManager$scanAppFileAndReport$1 extends ContinuationImpl {
    float F$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppDiskManager this$0;

    public AppDiskManager$scanAppFileAndReport$1(AppDiskManager r1, Continuation<? super AppDiskManager$scanAppFileAndReport$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        return AppDiskManager.o(this.this$0, null, 0.0f, false, this);
    }
}
