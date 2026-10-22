package com.larus.dora.impl.core;

import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.network.o;
import com.larus.platform.service.AccountService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraSyncManager$sync$1", f = "DoraSyncManager.kt", i = {}, l = {188}, m = "invokeSuspend", n = {}, s = {})
final class DoraSyncManager$sync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $serialNumber;
    final /* synthetic */ String $syncEvent;
    final /* synthetic */ int $syncType;
    int label;

    public DoraSyncManager$sync$1(String r1, int r2, String r3, Continuation<? super DoraSyncManager$sync$1> r4) {
        this.$serialNumber = r1;
        this.$syncType = r2;
        this.$syncEvent = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraSyncManager$sync$1(this.$serialNumber, this.$syncType, this.$syncEvent, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
        Object r10 = ((Result) r9).unbox-impl();
    L16:
        if (Result.isSuccess-impl(r10) == false) goto L26;
        o r2 = (o) r10;
        g49.d.d("DoraSyncManager", "sync: success " + r2);
        com.larus.dora.impl.util.b0 r3 = com.larus.dora.impl.util.b0.a;
        long r4 = ((long) r2.a()) * 1000;
        r3.getClass();
        com.larus.dora.impl.util.b0.j().storeLong("dora_sync_status_heartbeat_interval", r4);
        if (r2.a() > 0) goto L24;
        Job r5 = DoraSyncManager.b;
        if (r5 == null) goto L22;
        Job.DefaultImpls.cancel$default(r5, null, 1, null);
    L22:
        DoraSyncManager.b = null;
        DoraSyncManager.d.set(false);
        goto L26
    L24:
        if (kj4.a.g().getDoraLinkState(DoraAdapterExtKt.h(kj4.a.g())) != 2) goto L26;
        DoraSyncManager.a();
    L26:
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L30;
        g49.d.c("DoraSyncManager", "sync: failed", r11);
    L30:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        g49.d.a("DoraSyncManager", "sync: device=" + this.$serialNumber + ", syncType=" + this.$syncType + ", syncEvent=" + this.$syncEvent);
        if (AccountService.a.isLogin().booleanValue() == true) goto L12;
        g49.d.a("DoraSyncManager", "sync: account not login");
        return Unit.INSTANCE;
    L12:
        DoraNetworkApi r12 = DoraNetworkApi.a;
        String r6 = this.$serialNumber;
        int r7 = this.$syncType;
        String r8 = this.$syncEvent;
        this.label = 1;
        r10 = r12.C(r6, r7, r8, this);
        if (r10 != r0) goto L16;
        return r0;
    }
}
