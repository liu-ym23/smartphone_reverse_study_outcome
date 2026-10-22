package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager$dispatchBackgroundClean$3", f = "AppDiskManager.kt", i = {0}, l = {3388}, m = "invokeSuspend", n = {"shouldRetryAfterTaskRunning"}, s = {"I$0"})
public final class AppDiskManager$dispatchBackgroundClean$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accountScope;
    final /* synthetic */ boolean $requireValidatedEligibility;
    int I$0;
    int label;

    public AppDiskManager$dispatchBackgroundClean$3(String r1, boolean r2, Continuation<? super AppDiskManager$dispatchBackgroundClean$3> r3) {
        this.$accountScope = r1;
        this.$requireValidatedEligibility = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AppDiskManager$dispatchBackgroundClean$3(this.$accountScope, this.$requireValidatedEligibility, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L8
    L17:
        if (((AppDiskManager$CleanExecutionStatus) r5) == AppDiskManager$CleanExecutionStatus.TASK_RUNNING) goto L22;
        r2 = false;
    L22:
        if (this.$requireValidatedEligibility == false) goto L28;
        AppDiskManager r6 = AppDiskManager.a;
        AppDiskManager.p = false;
        if (r2 == false) goto L26;
        AppDiskManager.t.c();
    L26:
        AppDiskManager.a.getClass();
        AppDiskManager.N();
    L28:
        return Unit.INSTANCE;
    L8:
        th = th;
    L32:
        if (this.$requireValidatedEligibility == false) goto L37;
        AppDiskManager r4 = AppDiskManager.a;
        AppDiskManager.p = false;
        if (r3 == 0) goto L36;
        AppDiskManager.t.c();
    L36:
        AppDiskManager.a.getClass();
        AppDiskManager.N();
    L37:
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r5);
        AppDiskManager r7 = AppDiskManager.a;     // Catch: Throwable -> L29
        String r8 = this.$accountScope;     // Catch: Throwable -> L29
        this.I$0 = 0;     // Catch: Throwable -> L29
        this.label = 1;     // Catch: Throwable -> L29
        r5 = AppDiskManager.a(r7, r8, this);     // Catch: Throwable -> L29
        if (r5 != r0) goto L17;
        return r0;
    L29:
        th = th;
        r3 = 0;
        goto L32
    }
}
