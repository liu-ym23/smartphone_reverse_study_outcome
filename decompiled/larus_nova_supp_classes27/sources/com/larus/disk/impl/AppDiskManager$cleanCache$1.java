package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager", f = "AppDiskManager.kt", i = {}, l = {1724}, m = "cleanCache$impl_mainlandRelease", n = {}, s = {})
public final class AppDiskManager$cleanCache$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public AppDiskManager$cleanCache$1(Continuation<? super AppDiskManager$cleanCache$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AppDiskManager.E(null, null, this);
    }
}
