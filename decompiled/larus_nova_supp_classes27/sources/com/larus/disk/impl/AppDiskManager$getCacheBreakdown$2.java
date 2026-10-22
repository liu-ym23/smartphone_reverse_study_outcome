package com.larus.disk.impl;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/disk/api/DiskCacheBreakdownSnapshot;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.disk.impl.AppDiskManager$getCacheBreakdown$2", f = "AppDiskManager.kt", i = {0}, l = {3551}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class AppDiskManager$getCacheBreakdown$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.disk.api.f>, Object> {
    Object L$0;
    int label;

    public AppDiskManager$getCacheBreakdown$2(Continuation<? super AppDiskManager$getCacheBreakdown$2> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AppDiskManager$getCacheBreakdown$2(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.disk.api.f> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r10);
    L52:
        boolean r3 = false;
        if (AppDiskManager.h0() == true) goto L15;
        boolean r11 = true;
    L16:
        AppDiskManager r4 = AppDiskManager.a;     // Catch: Throwable -> L49
        r4.getClass();     // Catch: Throwable -> L49
        boolean r5 = AppDiskManager.a0();     // Catch: Throwable -> L49
        if (r5 == false) goto L22;
        AppDiskManager$c r7 = AppDiskManager.B(new n(r11), new o(r11));     // Catch: Exception -> L20 CancellationException -> L25 Throwable -> L49
    L23:
        com.larus.disk.api.e r6 = AppDiskManager.q(r4, r7);     // Catch: Exception -> L20 CancellationException -> L25 Throwable -> L49
    L28:
        AppDiskManager r8 = AppDiskManager.a;     // Catch: Throwable -> L49
        boolean r12 = !r11;
        if (r5 == true) goto L55;
        r3 = r12;
    L55:
        r8.getClass();     // Catch: Exception -> L36 CancellationException -> L38 Throwable -> L49
        if (r5 == false) goto L40;
        AppDiskManager$c r13 = AppDiskManager.B(new j(), new k());     // Catch: Exception -> L36 CancellationException -> L38 Throwable -> L49
    L41:
        com.larus.disk.api.e r14 = AppDiskManager.q(r8, r13);     // Catch: Exception -> L36 CancellationException -> L38 Throwable -> L49
    L44:
        com.larus.disk.api.f r9 = new com.larus.disk.api.f(r6, r14, AppDiskManager.m(AppDiskManager.a));     // Catch: Throwable -> L49
        r2.unlock(null);
        return r9;
    L40:
        r13 = AppDiskManager.C(r3);     // Catch: Exception -> L36 CancellationException -> L38 Throwable -> L49
    L38:
        e = move-exception;
        throw e;     // Catch: Throwable -> L49
    L36:
        e = move-exception;
        FLogger.a.e("AppDiskManager", "getCacheBreakdown manual failed", e);     // Catch: Throwable -> L49
        r14 = null;
        goto L44
    L22:
        r7 = AppDiskManager.C(!r11);     // Catch: Exception -> L20 CancellationException -> L25 Throwable -> L49
    L25:
        e = move-exception;
        throw e;     // Catch: Throwable -> L49
    L20:
        e = move-exception;
        FLogger.a.e("AppDiskManager", "getCacheBreakdown automatic failed", e);     // Catch: Throwable -> L49
        r6 = null;
        goto L28
    L15:
        r11 = false;
    L49:
        th = move-exception;
        r2.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        kotlinx.coroutines.sync.a r15 = AppDiskManager.s;
        this.L$0 = r15;
        this.label = 1;
        if (r15.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r15;
        goto L52
    }
}
