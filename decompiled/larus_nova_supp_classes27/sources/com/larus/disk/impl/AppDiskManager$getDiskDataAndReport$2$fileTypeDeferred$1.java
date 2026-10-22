package com.larus.disk.impl;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/disk/impl/DiskFileTypeSummary;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager$getDiskDataAndReport$2$fileTypeDeferred$1", f = "AppDiskManager.kt", i = {}, l = {722}, m = "invokeSuspend", n = {}, s = {})
public final class AppDiskManager$getDiskDataAndReport$2$fileTypeDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super a0>, Object> {
    final /* synthetic */ boolean $isLowDisk;
    final /* synthetic */ float $sampleRate;
    final /* synthetic */ String $snapshotId;
    int label;

    public AppDiskManager$getDiskDataAndReport$2$fileTypeDeferred$1(String r1, float r2, boolean r3, Continuation<? super AppDiskManager$getDiskDataAndReport$2$fileTypeDeferred$1> r4) {
        this.$snapshotId = r1;
        this.$sampleRate = r2;
        this.$isLowDisk = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AppDiskManager$getDiskDataAndReport$2$fileTypeDeferred$1(this.$snapshotId, this.$sampleRate, this.$isLowDisk, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super a0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L7 CancellationException -> L9
    L17:
    L24:
        return (a0) r6;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r6);
        AppDiskManager r7 = AppDiskManager.a;     // Catch: Exception -> L7 CancellationException -> L9
        String r2 = this.$snapshotId;     // Catch: Exception -> L7 CancellationException -> L9
        float r3 = this.$sampleRate;     // Catch: Exception -> L7 CancellationException -> L9
        boolean r4 = this.$isLowDisk;     // Catch: Exception -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Exception -> L7 CancellationException -> L9
        r6 = AppDiskManager.o(r7, r2, r3, r4, this);     // Catch: Exception -> L7 CancellationException -> L9
        if (r6 != r0) goto L17;
        return r0;
    L9:
        e = move-exception;
        throw e;
    L7:
        e = move-exception;
        FLogger.a.e("AppDiskManager", "scan app files for snapshot failed", e);
        int r8 = a0.d;
        return new a0("failed", MapsKt.emptyMap(), 0);
    }
}
