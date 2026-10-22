package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager", f = "AppDiskManager.kt", i = {0, 0}, l = {3551}, m = "reportRegisteredCacheUsage", n = {"$this$withLock_u24default$iv", "isLowDisk"}, s = {"L$0", "Z$0"})
public final class AppDiskManager$reportRegisteredCacheUsage$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppDiskManager this$0;

    public AppDiskManager$reportRegisteredCacheUsage$1(AppDiskManager r1, Continuation<? super AppDiskManager$reportRegisteredCacheUsage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        AppDiskManager r3 = this.this$0;
        AppDiskManager r0 = AppDiskManager.a;
        return r3.s0(false, this);
    }
}
