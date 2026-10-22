package com.larus.disk.impl;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Lcom/larus/disk/impl/DiskFileTypeSummary;", "Lcom/larus/disk/impl/AppDiskManager$RegisteredCacheUsageReport;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager$getDiskDataAndReport$2", f = "AppDiskManager.kt", i = {0, 1}, l = {719, 753, 753}, m = "invokeSuspend", n = {"$this$coroutineScope", "registeredCacheDeferred"}, s = {"L$0", "L$0"})
final class AppDiskManager$getDiskDataAndReport$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Pair<? extends a0, ? extends AppDiskManager$g>>, Object> {
    final /* synthetic */ boolean $isLowDisk;
    final /* synthetic */ float $sampleRate;
    final /* synthetic */ String $snapshotId;
    private /* synthetic */ Object L$0;
    int label;

    public AppDiskManager$getDiskDataAndReport$2(String r1, float r2, boolean r3, Continuation<? super AppDiskManager$getDiskDataAndReport$2> r4) {
        this.$snapshotId = r1;
        this.$sampleRate = r2;
        this.$isLowDisk = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        AppDiskManager$getDiskDataAndReport$2 r0 = new AppDiskManager$getDiskDataAndReport$2(this.$snapshotId, this.$sampleRate, this.$isLowDisk, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Pair<a0, AppDiskManager$g>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        Object r2 = this.L$0;
        ResultKt.throwOnFailure(r12);
    L23:
        return TuplesKt.to(r2, r12);
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Deferred r3 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r12);
    L18:
        this.L$0 = r12;
        this.label = 3;
        Object r4 = r3.await(this);
        if (r4 != r0) goto L21;
        return r0;
    L21:
        r2 = r12;
        r12 = r4;
        goto L23
    L11:
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L15:
        CoroutineDispatcher r6 = Dispatchers.getIO();
        AppDiskManager$getDiskDataAndReport$2$fileTypeDeferred$1 r7 = new AppDiskManager$getDiskDataAndReport$2$fileTypeDeferred$1(this.$snapshotId, this.$sampleRate, this.$isLowDisk, null);
        Deferred r13 = BuildersKt.async$default(r5, r6, null, r7, 2, null);
        CoroutineDispatcher r8 = Dispatchers.getIO();
        AppDiskManager$getDiskDataAndReport$2$registeredCacheDeferred$1 r9 = new AppDiskManager$getDiskDataAndReport$2$registeredCacheDeferred$1(this.$isLowDisk, null);
        r3 = BuildersKt.async$default(r5, r8, null, r9, 2, null);
        this.L$0 = r3;
        this.label = 2;
        r12 = r13.await(this);
        if (r12 != r0) goto L18;
        return r0;
    L12:
        ResultKt.throwOnFailure(r12);
        r5 = (CoroutineScope) this.L$0;
        this.L$0 = r5;
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L15;
        return r0;
    }
}
