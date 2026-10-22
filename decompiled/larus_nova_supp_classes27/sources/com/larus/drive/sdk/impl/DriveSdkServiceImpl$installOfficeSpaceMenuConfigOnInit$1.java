package com.larus.drive.sdk.impl;

import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.ee.bear.office.export.space.a;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.DriveSdkServiceImpl$installOfficeSpaceMenuConfigOnInit$1", f = "DriveSdkServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DriveSdkServiceImpl$installOfficeSpaceMenuConfigOnInit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $generation;
    final /* synthetic */ a $officeSpaceSdk;
    final /* synthetic */ String $userId;
    final /* synthetic */ int $userIdHash;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DriveSdkServiceImpl this$0;

    public DriveSdkServiceImpl$installOfficeSpaceMenuConfigOnInit$1(long r1, int r3, DriveSdkServiceImpl r4, String r5, a r6, Continuation<? super DriveSdkServiceImpl$installOfficeSpaceMenuConfigOnInit$1> r7) {
        this.$generation = r1;
        this.$userIdHash = r3;
        this.this$0 = r4;
        this.$userId = r5;
        this.$officeSpaceSdk = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        DriveSdkServiceImpl$installOfficeSpaceMenuConfigOnInit$1 r8 = new DriveSdkServiceImpl$installOfficeSpaceMenuConfigOnInit$1(this.$generation, this.$userIdHash, this.this$0, this.$userId, this.$officeSpaceSdk, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r20);
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        long r4 = SystemClock.elapsedRealtime();
        FLogger r5 = FLogger.a;
        r5.i("DriveSdkServiceImpl", "start office space menu config async install, generation=" + this.$generation + ", userIdHash=" + this.$userIdHash + ", thread=" + ThreadMethodProxy.currentThread().getName() + ", isMainThread=" + Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));
        DriveSdkServiceImpl r6 = this.this$0;
        long r7 = this.$generation;
        int r9 = this.$userIdHash;
        String r10 = this.$userId;
        a r11 = this.$officeSpaceSdk;
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L29
        String r13 = DriveSdkServiceImpl.W(r6, r7);     // Catch: Throwable -> L29
        long r14 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L29
        Object r15 = r6.i;     // Catch: Throwable -> L29
        monitor-enter(r15);     // Catch: Throwable -> L29
        long r16 = r4;
        long r8 = r6.h.get();     // Catch: Throwable -> L21
        String r17 = AccountService.a.getUserId();     // Catch: Throwable -> L21
        if (r7 == r8) goto L12;
    L15:
        r5.i("DriveSdkServiceImpl", "skip stale office space menu config async install, generation=" + r7 + ", currentGeneration=" + r8 + ", userIdHash=" + r9 + ", currentUserIdHash=" + r17.hashCode() + ", thread=" + ThreadMethodProxy.currentThread().getName());     // Catch: Throwable -> L21
        boolean r2 = false;
    L17:
        monitor-exit(r15);     // Catch: Throwable -> L27
        if (r2 == false) goto L20;
        r5.i("DriveSdkServiceImpl", "finish office space menu config async install, generation=" + r7 + ", userIdHash=" + r9 + ", empty=" + StringsKt.isBlank(r13) + ", installCostMs=" + (SystemClock.elapsedRealtime() - r14) + ", totalCostMs=" + (SystemClock.elapsedRealtime() - r16) + ", thread=" + ThreadMethodProxy.currentThread().getName() + ", isMainThread=" + Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()));     // Catch: Throwable -> L27
    L20:
        Object r0 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L32:
        long r18 = this.$generation;
        int r21 = this.$userIdHash;
        Throwable r1 = Result.exceptionOrNull-impl(r0);
        if (r1 == null) goto L36;
        FLogger.a.w("DriveSdkServiceImpl", "office space menu config async install failed, generation=" + r18 + ", userIdHash=" + r21 + ", totalCostMs=" + (SystemClock.elapsedRealtime() - r16) + ", thread=" + ThreadMethodProxy.currentThread().getName(), r1);
    L36:
        return Unit.INSTANCE;
    L12:
        if (Intrinsics.areEqual(r10, r17) == false) goto L15;
        r11.b(r13);     // Catch: Throwable -> L21
        r2 = true;
    L21:
        th = th;
    L25:
        monitor-exit(r15);     // Catch: Throwable -> L27
        throw th;     // Catch: Throwable -> L27
    L23:
        th = th;
    L27:
        th = th;
    L31:
        Result.Companion r22 = Result.Companion;
        r0 = Result.constructor-impl(ResultKt.createFailure(th));
    L29:
        th = th;
        r16 = r4;
        goto L31
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
