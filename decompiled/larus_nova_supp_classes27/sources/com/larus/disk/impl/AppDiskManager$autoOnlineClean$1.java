package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager", f = "AppDiskManager.kt", i = {0, 0, 0, 0, 0, 0}, l = {3019}, m = "autoOnlineClean", n = {"expectedAccountScope", "config", "useExtendedPolicy", "requireAccountConsistency", "requireAppBackground", "handlerOperationsLocked"}, s = {"L$0", "L$1", "Z$0", "Z$1", "Z$2", "I$0"})
final class AppDiskManager$autoOnlineClean$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppDiskManager this$0;

    public AppDiskManager$autoOnlineClean$1(AppDiskManager r1, Continuation<? super AppDiskManager$autoOnlineClean$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AppDiskManager.a(this.this$0, null, this);
    }
}
