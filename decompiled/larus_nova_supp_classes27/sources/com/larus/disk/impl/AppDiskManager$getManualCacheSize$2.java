package com.larus.disk.impl;

import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager$getManualCacheSize$2", f = "AppDiskManager.kt", i = {0}, l = {3551}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class AppDiskManager$getManualCacheSize$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    Object L$0;
    int label;

    public AppDiskManager$getManualCacheSize$2(Continuation<? super AppDiskManager$getManualCacheSize$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AppDiskManager$getManualCacheSize$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Long> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r4 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        kotlinx.coroutines.sync.a r3 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r10);
    L29:
        AppDiskManager.a.getClass();     // Catch: Throwable -> L26
        boolean r11 = AppDiskManager.a0();     // Catch: Throwable -> L26
        boolean r5 = false;
        if (r11 == true) goto L16;
        r4 = false;
    L16:
        boolean r6 = AppDiskManager.h0();     // Catch: Throwable -> L26
        if (r11 == true) goto L20;
        r5 = r6;
    L20:
        if (r4 == false) goto L22;
        AppDiskManager$c r12 = AppDiskManager.B(new j(), new k());     // Catch: Throwable -> L26
    L23:
        long r7 = r12.a;     // Catch: Throwable -> L26
        FLogger.a.i("AppDiskManager", "getManualCacheSize total cacheSize " + AppDiskManager.E0(r7));     // Catch: Throwable -> L26
        Long r13 = Boxing.boxLong(r7);     // Catch: Throwable -> L26
        r3.unlock(null);
        return r13;
    L22:
        r12 = AppDiskManager.C(r5);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        r3.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.sync.a r14 = AppDiskManager.s;
        this.L$0 = r14;
        this.label = 1;
        if (r14.a(null, this) != r1) goto L11;
        return r1;
    L11:
        r3 = r14;
        goto L29
    }
}
