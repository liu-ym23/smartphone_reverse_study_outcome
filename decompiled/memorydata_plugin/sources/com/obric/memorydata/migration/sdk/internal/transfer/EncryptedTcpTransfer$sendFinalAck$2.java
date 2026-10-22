package com.obric.memorydata.migration.sdk.internal.transfer;

import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$sendFinalAck$2", f = "EncryptedTcpTransfer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EncryptedTcpTransfer$sendFinalAck$2 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends Unit>>, Object> {
    final /* synthetic */ e $connection;
    final /* synthetic */ z<Unit> $result;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EncryptedTcpTransfer this$0;

    EncryptedTcpTransfer$sendFinalAck$2(z<Unit> r3, EncryptedTcpTransfer r4, e r5, Continuation<? super EncryptedTcpTransfer$sendFinalAck$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$result = r3;
        this.this$0 = r4;
        this.$connection = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        EncryptedTcpTransfer$sendFinalAck$2 r0 = new EncryptedTcpTransfer$sendFinalAck$2(this.$result, this.this$0, this.$connection, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends Unit>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<Unit>> r4) {
        return ((EncryptedTcpTransfer$sendFinalAck$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EncryptedTcpTransfer$sendFinalAck$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r11);
        al r12 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        z<Unit> r13 = this.$result;
        EncryptedTcpTransfer r0 = this.this$0;
        e r10 = this.$connection;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L14
        if (ZeusTransformUtils.instanceOf(r13, z.b.class) == false) goto L9;
        EncryptedTcpTransfer.Ack r14 = new EncryptedTcpTransfer.Ack("FINAL", true, null, null, 12, null);     // Catch: Throwable -> L14
    L11:
        EncryptedTcpTransfer.a(r0, r10, r14);     // Catch: Throwable -> L14
        Object r15 = Result.m1421constructorimpl(new z.b(Unit.INSTANCE));     // Catch: Throwable -> L14
    L16:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L24;
        t.f11981a.a("tcp: send final ack failed", r16);
        return (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.DISCONNECTED, "发送结果失败: " + r16.getMessage(), r16)), z.class, "com.obric.memorydata.plugin");
    L24:
        return r15;
    L9:
        if (ZeusTransformUtils.instanceOf(r13, z.a.class) == false) goto L13;
        r14 = new EncryptedTcpTransfer.Ack("FINAL", false, ((z.a) ZeusTransformUtils.preCheckCast(r13, z.a.class, "com.obric.memorydata.plugin")).a().a().name(), ((z.a) ZeusTransformUtils.preCheckCast(r13, z.a.class, "com.obric.memorydata.plugin")).a().b());     // Catch: Throwable -> L14
        goto L11
    L13:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
