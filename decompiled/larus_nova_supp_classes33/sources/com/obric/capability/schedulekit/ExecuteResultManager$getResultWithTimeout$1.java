package com.obric.capability.schedulekit;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.capability.schedulekit.ExecuteResultManager", f = "ExecuteResultManager.kt", i = {0}, l = {71}, m = "getResultWithTimeout", n = {"questionId"}, s = {"J$0"})
final class ExecuteResultManager$getResultWithTimeout$1 extends ContinuationImpl {
    long J$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ExecuteResultManager this$0;

    public ExecuteResultManager$getResultWithTimeout$1(ExecuteResultManager r1, Continuation<? super ExecuteResultManager$getResultWithTimeout$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        ExecuteResultManager r8 = this.this$0;
        r8.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        ExecuteResultManager$getResultWithTimeout$1 r0 = this;
    L6:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L12;
        if (r3 != 1) goto L11;
        long r4 = r0.J$0;
        ResultKt.throwOnFailure(r9);
    L18:
        JobResultWrapper r10 = (JobResultWrapper) r9;
        ExecuteResultManager.a.remove(Boxing.boxLong(r4));
        return r10;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r9);
        if (ExecuteResultManager.b == true) goto L20;
        ExecuteResultManager$getResultWithTimeout$result$1 r11 = new ExecuteResultManager$getResultWithTimeout$result$1(0, null);
        r0.J$0 = 0;
        r0.label = 1;
        r9 = TimeoutKt.c(0, r11, r0);
        if (r9 == r2) goto L22;
        r4 = 0;
        goto L18
    L22:
        return r2;
    L20:
        ExecuteResultManager.b = false;
        CoroutineScope r12 = b.a;
        ExecuteResultManager$resultReceiver$1 r13 = ExecuteResultManager.c;
        Intrinsics.checkNotNullParameter(r13, "receiver");
        new CapabilityScheduleSdk.registerActionsResultReceiver.1(r13);
        b.a();
        throw null;
    L5:
        r0 = new ExecuteResultManager$getResultWithTimeout$1(r8, this);
        goto L6
    }
}
