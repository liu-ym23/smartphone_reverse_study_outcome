package com.obric.aikernel.res.update;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater", f = "PackageUpdater.kt", i = {0, 0}, l = {473}, m = "update", n = {"constriction", "$this$update_u24lambda_u2415"}, s = {"L$0", "L$1"})
final class PackageUpdater$update$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PackageUpdater this$0;

    PackageUpdater$update$1(PackageUpdater r10, Continuation<? super PackageUpdater$update$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.y(null, null, null, this);
    }
}
