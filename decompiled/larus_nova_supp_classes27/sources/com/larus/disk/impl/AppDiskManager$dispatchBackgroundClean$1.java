package com.larus.disk.impl;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager$dispatchBackgroundClean$1", f = "AppDiskManager.kt", i = {0, 0}, l = {3284}, m = "invokeSuspend", n = {"shouldResetForAccountChange", "shouldRetryAfterTaskRunning"}, s = {"I$0", "I$1"})
public final class AppDiskManager$dispatchBackgroundClean$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accountScope;
    final /* synthetic */ boolean $requireValidatedEligibility;
    int I$0;
    int I$1;
    int label;

    public AppDiskManager$dispatchBackgroundClean$1(String r1, boolean r2, Continuation<? super AppDiskManager$dispatchBackgroundClean$1> r3) {
        this.$accountScope = r1;
        this.$requireValidatedEligibility = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AppDiskManager$dispatchBackgroundClean$1(this.$accountScope, this.$requireValidatedEligibility, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L9;
        int r3 = this.I$1;
        int r4 = this.I$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L23
    L15:
        AppDiskManager$CleanExecutionStatus r11 = (AppDiskManager$CleanExecutionStatus) r10;     // Catch: Throwable -> L23
        if (r11 != AppDiskManager$CleanExecutionStatus.TASK_RUNNING) goto L18;
        boolean r5 = true;
    L21:
        if (this.$requireValidatedEligibility == true) goto L25;
        Lazy r12 = d.a;     // Catch: Throwable -> L23
        d.d().storeLong("last_low_disk_clean_time", System.currentTimeMillis());     // Catch: Throwable -> L23
    L48:
        if (this.$requireValidatedEligibility == false) goto L52;
        AppDiskManager r13 = AppDiskManager.a;
        AppDiskManager.p = false;
        if (r5 == false) goto L52;
        AppDiskManager.t.c();
    L52:
        if (r4 == 0) goto L55;
        AppDiskManager.n(AppDiskManager.a, this.$accountScope, true, this.$requireValidatedEligibility);
    L55:
        if (this.$requireValidatedEligibility == false) goto L58;
        AppDiskManager.a.getClass();
        AppDiskManager.N();
    L58:
        return Unit.INSTANCE;
    L25:
        String r6 = this.$accountScope;     // Catch: Throwable -> L23
        Lazy r7 = d.a;     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r6, d.c()) == false) goto L46;
        Intrinsics.checkNotNullParameter(r11, "<this>");     // Catch: Throwable -> L23
        if (r11 != AppDiskManager$CleanExecutionStatus.COMPLETED) goto L31;
    L36:
        boolean r8 = true;
    L37:
        if (r8 == false) goto L45;
        if (this.$accountScope == null) goto L45;
        if (Intrinsics.areEqual(AppDiskManager.n, this.$accountScope) == false) goto L43;
        AppDiskManager r14 = AppDiskManager.a;     // Catch: Throwable -> L23
        AppDiskManager.l = false;     // Catch: Throwable -> L23
        AppDiskManager.n = null;     // Catch: Throwable -> L23
    L43:
        String r15 = this.$accountScope;     // Catch: Throwable -> L23
        long r9 = System.currentTimeMillis();     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r15, "accountScope");     // Catch: Throwable -> L23
        d.d().storeLong("last_low_disk_clean_time_" + r15, r9);     // Catch: Throwable -> L23
    L45:
        if (r11 != AppDiskManager$CleanExecutionStatus.ACCOUNT_CHANGED) goto L48;
    L31:
        if (r11 == AppDiskManager$CleanExecutionStatus.PARTIAL) goto L36;
        if (r11 == AppDiskManager$CleanExecutionStatus.FAILED) goto L36;
        r8 = false;
    L46:
        r4 = 1;
        goto L48
    L18:
        r5 = false;
    L23:
        th = th;
    L62:
        if (this.$requireValidatedEligibility == false) goto L66;
        AppDiskManager r0 = AppDiskManager.a;
        AppDiskManager.p = false;
        if (r3 == 0) goto L66;
        AppDiskManager.t.c();
    L66:
        if (r4 == 0) goto L69;
        AppDiskManager.n(AppDiskManager.a, this.$accountScope, true, this.$requireValidatedEligibility);
    L69:
        if (this.$requireValidatedEligibility == false) goto L71;
        AppDiskManager.a.getClass();
        AppDiskManager.N();
    L71:
        throw th;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
        AppDiskManager$CleanScene r16 = AppDiskManager$CleanScene.LOW_DISK;     // Catch: Throwable -> L59
        String r17 = this.$accountScope;     // Catch: Throwable -> L59
        this.I$0 = 0;     // Catch: Throwable -> L59
        this.I$1 = 0;     // Catch: Throwable -> L59
        this.label = 1;     // Catch: Throwable -> L59
        r10 = AppDiskManager.E(r16, r17, this);     // Catch: Throwable -> L59
        if (r10 != r1) goto L14;
        return r1;
    L14:
        r4 = 0;
    L59:
        th = th;
        r3 = 0;
        r4 = 0;
        goto L62
    }
}
