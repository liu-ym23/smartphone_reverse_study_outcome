package com.obric.memorydata.migration.sdk.internal.transfer;

import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.MigrationStep;
import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.m;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.p;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.w;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$send$2", f = "EncryptedTcpTransfer.kt", i = {0, 0, 0}, l = {579}, m = "invokeSuspend", n = {"sentBytes", "lastEmitPercent", "startMs"}, s = {"L$0", "L$1", "J$0"})
final class EncryptedTcpTransfer$send$2 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends Unit>>, Object> {
    final /* synthetic */ m $callback;
    final /* synthetic */ e $connection;
    final /* synthetic */ w $pkg;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ EncryptedTcpTransfer this$0;

    EncryptedTcpTransfer$send$2(w r3, e r4, EncryptedTcpTransfer r5, m r6, Continuation<? super EncryptedTcpTransfer$send$2> r7) {
        m r8 = (m) ZeusTransformUtils.wrapperContextForParams(r6, m.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        this.$pkg = r3;
        this.$connection = r4;
        this.this$0 = r5;
        this.$callback = r8;
        super(2, r9);
    }

    public static final /* synthetic */ void access$invokeSuspend$maybeEmitProgress(w r2, Ref.LongRef r3, Ref.IntRef r4, m r5) {
        invokeSuspend$maybeEmitProgress(r2, r3, r4, (m) ZeusTransformUtils.wrapperContextForParams(r5, m.class, "com.obric.memorydata.plugin"));
    }

    private static final void invokeSuspend$maybeEmitProgress(w r8, Ref.LongRef r9, Ref.IntRef r10, m r11) {
        m r12 = (m) ZeusTransformUtils.wrapperContextForParams(r11, m.class, "com.obric.memorydata.plugin");
        long r6 = r8.b();
        if (r6 > 0) goto L5;
        return;
    L5:
        int r13 = RangesKt.coerceIn((int) ((r9.element * ((long) 100)) / r6), 0, 100);
        if (r13 == r10.element) goto L9;
        r10.element = r13;
        r12.onEvent((p) ZeusTransformUtils.preCheckCast(new p.c(MigrationStep.TRANSFERRING, r9.element, r6), p.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new EncryptedTcpTransfer$send$2(this.$pkg, this.$connection, this.this$0, this.$callback, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends Unit>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<Unit>> r4) {
        return ((EncryptedTcpTransfer$send$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EncryptedTcpTransfer$send$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r23) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 != 1) goto L9;
        long r3 = this.J$0;
        Ref.IntRef r1 = (Ref.IntRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.IntRef.class, "com.obric.memorydata.plugin");
        Ref.LongRef r5 = (Ref.LongRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.LongRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r23);     // Catch: Throwable -> L20
    L18:
        invokeSuspend$maybeEmitProgress(this.$pkg, r5, r1, this.$callback);     // Catch: Throwable -> L20
        t.f11981a.a("tcp: send done, bytes=" + r5.element + ", costMs=" + (System.currentTimeMillis() - r3));     // Catch: Throwable -> L20
        return (z) ZeusTransformUtils.preCheckCast(new z.b(Unit.INSTANCE), z.class, "com.obric.memorydata.plugin");
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r23);
        long r6 = System.currentTimeMillis();
        Ref.LongRef r4 = new Ref.LongRef();     // Catch: Throwable -> L20
        Ref.IntRef r15 = new Ref.IntRef();     // Catch: Throwable -> L20
        r15.element = -1;     // Catch: Throwable -> L20
        t.f11981a.a("tcp: send start, bytes=" + this.$pkg.b());     // Catch: Throwable -> L20
        OutputStream r16 = this.$connection.a();     // Catch: Throwable -> L20
        EncryptedTcpTransfer.a(this.this$0, this.$connection, this.$pkg);     // Catch: Throwable -> L20
        t.f11981a.a("tcp: send header sent, bytes=" + this.$pkg.b());     // Catch: Throwable -> L20
        z r7 = EncryptedTcpTransfer.a(this.this$0, this.$connection, "READY", 5000, this.$callback);     // Catch: Throwable -> L20
        if (ZeusTransformUtils.instanceOf(r7, z.a.class) == false) goto L14;
        return r7;
    L14:
        t.f11981a.a("tcp: send ready ack received");     // Catch: Throwable -> L20
        invokeSuspend$maybeEmitProgress(this.$pkg, r4, r15, this.$callback);     // Catch: Throwable -> L20
        Function2 r8 = (Function2) ZeusTransformUtils.preCheckCast(new EncryptedTcpTransfer$send$2$invokeSuspend$$inlined$withTransferInactivityWatchdog$default$1(7000, "send", this.$connection, null, this.$pkg, this.this$0, r16, r4, r15, this.$callback), Function2.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        this.L$0 = r4;     // Catch: Throwable -> L20
        this.L$1 = r15;     // Catch: Throwable -> L20
        this.J$0 = r6;     // Catch: Throwable -> L20
        this.label = 1;     // Catch: Throwable -> L20
        if (am.a(r8, r9) != r0) goto L17;
        return r0;
    L17:
        r1 = r15;
        r5 = r4;
        r3 = r6;
    L20:
        th = move-exception;
        t.f11981a.a("tcp: send failed", th);
        o r10 = new o(MigrationErrorCode.DISCONNECTED, "传输中断: " + th.getMessage(), th);
        this.$callback.onEvent((p) ZeusTransformUtils.preCheckCast(new p.b(MigrationStep.TRANSFERRING, r10), p.class, "com.obric.memorydata.plugin"));
        return (z) ZeusTransformUtils.preCheckCast(new z.a(r10), z.class, "com.obric.memorydata.plugin");
    }
}
