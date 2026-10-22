package com.obric.memorydata.migration.sdk.internal.transfer;

import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataOutputStream;
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
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer$sendHeartbeat$2", f = "EncryptedTcpTransfer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class EncryptedTcpTransfer$sendHeartbeat$2 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends Unit>>, Object> {
    final /* synthetic */ e $connection;
    final /* synthetic */ String $tag;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EncryptedTcpTransfer this$0;

    EncryptedTcpTransfer$sendHeartbeat$2(String r3, EncryptedTcpTransfer r4, e r5, Continuation<? super EncryptedTcpTransfer$sendHeartbeat$2> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$tag = r3;
        this.this$0 = r4;
        this.$connection = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        EncryptedTcpTransfer$sendHeartbeat$2 r0 = new EncryptedTcpTransfer$sendHeartbeat$2(this.$tag, this.this$0, this.$connection, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends Unit>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<Unit>> r4) {
        return ((EncryptedTcpTransfer$sendHeartbeat$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), EncryptedTcpTransfer$sendHeartbeat$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r10);
        al r11 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        String r4 = this.$tag;
        EncryptedTcpTransfer r12 = this.this$0;
        e r9 = this.$connection;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        EncryptedTcpTransfer.Heartbeat r1 = new EncryptedTcpTransfer.Heartbeat(null, r4, System.currentTimeMillis(), 1, null);     // Catch: Throwable -> L7
        DataOutputStream r2 = new DataOutputStream(r9.a());     // Catch: Throwable -> L7
        String r13 = EncryptedTcpTransfer.b(r12).toJson(r1);     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r13, "toJson(...)");     // Catch: Throwable -> L7
        EncryptedTcpTransfer.a(r12, r2, r13);     // Catch: Throwable -> L7
        Object r14 = Result.m1421constructorimpl(new z.b(Unit.INSTANCE));     // Catch: Throwable -> L7
    L9:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r14);
        if (r15 != null) goto L13;
        return r14;
    L13:
        return (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.DISCONNECTED, "心跳发送失败: " + r15.getMessage(), r15)), z.class, "com.obric.memorydata.plugin");
    L7:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
