package com.obric.aikernel.res.update;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.res.update.PackageUpdater", f = "PackageUpdater.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {537, 639, 650}, m = "updateWithExecutionResult$resource_manager_release", n = {"this", "bizs", "constriction", "loraType", "rootCoroutine", "addNewTaskConfig", "targets", "metadataOutcome", "requestTimestamp", "cachedPackageCount", "this", "constriction", "metadataOutcome", "cachedPackageCount", "this", "constriction", "metadataOutcome", "destination$iv$iv", "element$iv$iv", "cachedPackageCount"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "J$0", "I$0", "L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "L$5", "I$0"})
final class PackageUpdater$updateWithExecutionResult$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PackageUpdater this$0;

    PackageUpdater$updateWithExecutionResult$1(PackageUpdater r10, Continuation<? super PackageUpdater$updateWithExecutionResult$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.A(null, null, null, this);
    }
}
