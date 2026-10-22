package com.larus.disk.impl;

import com.larus.utils.logger.FLogger;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/disk/impl/AppDiskManager$RegisteredCacheUsageReport;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager$getDiskDataAndReport$2$registeredCacheDeferred$1", f = "AppDiskManager.kt", i = {}, l = {736}, m = "invokeSuspend", n = {}, s = {})
public final class AppDiskManager$getDiskDataAndReport$2$registeredCacheDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppDiskManager$g>, Object> {
    final /* synthetic */ boolean $isLowDisk;
    int label;

    public AppDiskManager$getDiskDataAndReport$2$registeredCacheDeferred$1(boolean r1, Continuation<? super AppDiskManager$getDiskDataAndReport$2$registeredCacheDeferred$1> r2) {
        this.$isLowDisk = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AppDiskManager$getDiskDataAndReport$2$registeredCacheDeferred$1(this.$isLowDisk, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AppDiskManager$g> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r18);     // Catch: Exception -> L15 CancellationException -> L18
        Object r3 = r18;
    L13:
    L22:
        return (AppDiskManager$g) r3;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
        AppDiskManager r4 = AppDiskManager.a;     // Catch: Exception -> L15 CancellationException -> L18
        boolean r5 = this.$isLowDisk;     // Catch: Exception -> L15 CancellationException -> L18
        this.label = 1;     // Catch: Exception -> L15 CancellationException -> L18
        r3 = r4.s0(r5, this);     // Catch: Exception -> L15 CancellationException -> L18
        if (r3 != r0) goto L13;
        return r0;
    L18:
        e = move-exception;
        throw e;
    L15:
        e = move-exception;
        FLogger.a.e("AppDiskManager", "collect registered cache usage failed", e);
        final long r6 = 0;
        final long r8 = 0;
        final long r10 = 0;
        final List r12 = CollectionsKt.emptyList();
        AppDiskManager.a.getClass();
        final int r13 = AppDiskManager.Q().size();
        final int r14 = AppDiskManager.Q().size();
        final int r15 = 0;
        final boolean r16 = true;
        return new AppDiskManager$g(r6, r8, r10, r12, r13, r14, r15, r16);
    }
}
