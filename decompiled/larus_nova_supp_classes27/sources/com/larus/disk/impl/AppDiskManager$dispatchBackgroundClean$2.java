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
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager$dispatchBackgroundClean$2", f = "AppDiskManager.kt", i = {0, 0}, l = {3331}, m = "invokeSuspend", n = {"shouldResetForAccountChange", "shouldRetryAfterTaskRunning"}, s = {"I$0", "I$1"})
public final class AppDiskManager$dispatchBackgroundClean$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accountScope;
    final /* synthetic */ boolean $requireValidatedEligibility;
    int I$0;
    int I$1;
    int label;

    public AppDiskManager$dispatchBackgroundClean$2(String r1, boolean r2, Continuation<? super AppDiskManager$dispatchBackgroundClean$2> r3) {
        this.$accountScope = r1;
        this.$requireValidatedEligibility = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AppDiskManager$dispatchBackgroundClean$2(this.$accountScope, this.$requireValidatedEligibility, r4);
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
        int r3 = 1;
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L9;
        int r4 = this.I$1;
        int r5 = this.I$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L23
    L15:
        AppDiskManager$CleanExecutionStatus r11 = (AppDiskManager$CleanExecutionStatus) r10;     // Catch: Throwable -> L23
        if (r11 != AppDiskManager$CleanExecutionStatus.TASK_RUNNING) goto L18;
        boolean r6 = true;
    L21:
        if (this.$requireValidatedEligibility == true) goto L25;
        Lazy r12 = d.a;     // Catch: Throwable -> L23
        d.d().storeLong("last_custom_biz_disk_clean_time", System.currentTimeMillis());     // Catch: Throwable -> L23
    L47:
        r3 = r5;
    L49:
        if (this.$requireValidatedEligibility == false) goto L53;
        AppDiskManager r13 = AppDiskManager.a;
        AppDiskManager.p = false;
        if (r6 == false) goto L53;
        AppDiskManager.t.c();
    L53:
        if (r3 == 0) goto L56;
        AppDiskManager.n(AppDiskManager.a, this.$accountScope, false, this.$requireValidatedEligibility);
    L56:
        if (this.$requireValidatedEligibility == false) goto L59;
        AppDiskManager.a.getClass();
        AppDiskManager.N();
    L59:
        return Unit.INSTANCE;
    L25:
        String r7 = this.$accountScope;     // Catch: Throwable -> L23
        Lazy r8 = d.a;     // Catch: Throwable -> L23
        if (Intrinsics.areEqual(r7, d.c()) == false) goto L49;
        Intrinsics.checkNotNullParameter(r11, "<this>");     // Catch: Throwable -> L23
        if (r11 != AppDiskManager$CleanExecutionStatus.COMPLETED) goto L31;
    L36:
        boolean r9 = true;
    L37:
        if (r9 == false) goto L45;
        if (this.$accountScope == null) goto L45;
        if (Intrinsics.areEqual(AppDiskManager.o, this.$accountScope) == false) goto L43;
        AppDiskManager r14 = AppDiskManager.a;     // Catch: Throwable -> L23
        AppDiskManager.m = false;     // Catch: Throwable -> L23
        AppDiskManager.o = null;     // Catch: Throwable -> L23
    L43:
        String r15 = this.$accountScope;     // Catch: Throwable -> L23
        long r16 = System.currentTimeMillis();     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r15, "accountScope");     // Catch: Throwable -> L23
        d.d().storeLong("last_custom_biz_disk_clean_time_" + r15, r16);     // Catch: Throwable -> L23
    L45:
        if (r11 != AppDiskManager$CleanExecutionStatus.ACCOUNT_CHANGED) goto L47;
    L31:
        if (r11 == AppDiskManager$CleanExecutionStatus.PARTIAL) goto L36;
        if (r11 == AppDiskManager$CleanExecutionStatus.FAILED) goto L36;
        r9 = false;
        goto L37
    L18:
        r6 = false;
    L23:
        th = th;
    L63:
        if (this.$requireValidatedEligibility == false) goto L67;
        AppDiskManager r0 = AppDiskManager.a;
        AppDiskManager.p = false;
        if (r4 == 0) goto L67;
        AppDiskManager.t.c();
    L67:
        if (r5 == 0) goto L70;
        AppDiskManager.n(AppDiskManager.a, this.$accountScope, false, this.$requireValidatedEligibility);
    L70:
        if (this.$requireValidatedEligibility == false) goto L72;
        AppDiskManager.a.getClass();
        AppDiskManager.N();
    L72:
        throw th;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
        AppDiskManager$CleanScene r17 = AppDiskManager$CleanScene.REGULAR;     // Catch: Throwable -> L60
        String r18 = this.$accountScope;     // Catch: Throwable -> L60
        this.I$0 = 0;     // Catch: Throwable -> L60
        this.I$1 = 0;     // Catch: Throwable -> L60
        this.label = 1;     // Catch: Throwable -> L60
        r10 = AppDiskManager.E(r17, r18, this);     // Catch: Throwable -> L60
        if (r10 != r1) goto L14;
        return r1;
    L14:
        r5 = 0;
    L60:
        th = th;
        r4 = 0;
        r5 = 0;
        goto L63
    }
}
