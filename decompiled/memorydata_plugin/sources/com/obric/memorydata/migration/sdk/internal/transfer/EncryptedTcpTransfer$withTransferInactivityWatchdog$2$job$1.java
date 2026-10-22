package com.obric.memorydata.migration.sdk.internal.transfer;

import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.t;
import com.ttnet.org.chromium.base.TimeUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$withTransferInactivityWatchdog$2$job$1", f = "EncryptedTcpTransfer.kt", i = {0}, l = {476}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class EncryptedTcpTransfer$withTransferInactivityWatchdog$2$job$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $connection;
    final /* synthetic */ AtomicLong $lastProgressNs;
    final /* synthetic */ String $phase;
    final /* synthetic */ long $timeoutNs;
    private /* synthetic */ Object L$0;
    int label;

    public EncryptedTcpTransfer$withTransferInactivityWatchdog$2$job$1(AtomicLong r3, long r4, String r6, e r7, Continuation<? super EncryptedTcpTransfer$withTransferInactivityWatchdog$2$job$1> r8) {
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$lastProgressNs = r3;
        this.$timeoutNs = r4;
        this.$phase = r6;
        this.$connection = r7;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        EncryptedTcpTransfer$withTransferInactivityWatchdog$2$job$1 r12 = new EncryptedTcpTransfer$withTransferInactivityWatchdog$2$job$1(this.$lastProgressNs, this.$timeoutNs, this.$phase, this.$connection, r8);
        r12.L$0 = r10;
        return (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((EncryptedTcpTransfer$withTransferInactivityWatchdog$2$job$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EncryptedTcpTransfer$withTransferInactivityWatchdog$2$job$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0049 -> B:14:0x004c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        al r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L14:
        long r4 = System.nanoTime() - this.$lastProgressNs.get();
        if (r4 < this.$timeoutNs) goto L10;
        t.a(t.f11981a, "tcp: " + this.$phase + " timeout, idleMs=" + (r4 / TimeUtils.NANOSECONDS_PER_MILLISECOND) + ", closing socket", null, 2, null);
        e r8 = this.$connection;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L19
        r8.d();     // Catch: Throwable -> L19
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L22:
        return Unit.INSTANCE;
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
    L10:
        if (am.a(r2) == false) goto L22;
        Continuation r12 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.label = 1;
        if (au.a(500, r12) != r0) goto L14;
        return r0;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        goto L10
    }
}
