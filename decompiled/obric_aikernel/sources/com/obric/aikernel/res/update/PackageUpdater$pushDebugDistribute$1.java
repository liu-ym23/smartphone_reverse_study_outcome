package com.obric.aikernel.res.update;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater", f = "PackageUpdater.kt", i = {0, 1, 1, 1, 3, 3}, l = {843, 874, 898, TypedValues.Custom.TYPE_DIMENSION}, m = "pushDebugDistribute", n = {"this", "this", "nativeLibChanged", "bizs", "this", "loggerPushFinished"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1"})
final class PackageUpdater$pushDebugDistribute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PackageUpdater this$0;

    PackageUpdater$pushDebugDistribute$1(PackageUpdater r10, Continuation<? super PackageUpdater$pushDebugDistribute$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.v(null, this);
    }
}
