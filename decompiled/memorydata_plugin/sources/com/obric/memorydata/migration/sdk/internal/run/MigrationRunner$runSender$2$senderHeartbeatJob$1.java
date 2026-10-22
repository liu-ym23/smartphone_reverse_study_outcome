package com.obric.memorydata.migration.sdk.internal.run;

import com.obric.memorydata.migration.sdk.e;
import com.obric.memorydata.migration.sdk.internal.transfer.EncryptedTcpTransfer;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
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
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.run.MigrationRunner$runSender$2$senderHeartbeatJob$1", f = "MigrationRunner.kt", i = {0, 1}, l = {187, 193}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class MigrationRunner$runSender$2$senderHeartbeatJob$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $conn;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    MigrationRunner$runSender$2$senderHeartbeatJob$1(a r3, e r4, Continuation<? super MigrationRunner$runSender$2$senderHeartbeatJob$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$conn = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        MigrationRunner$runSender$2$senderHeartbeatJob$1 r0 = new MigrationRunner$runSender$2$senderHeartbeatJob$1(this.this$0, this.$conn, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MigrationRunner$runSender$2$senderHeartbeatJob$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MigrationRunner$runSender$2$senderHeartbeatJob$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00d1 -> B:8:0x0020). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L11;
        if (r1 != 2) goto L10;
        al r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14
    L8:
        al r12 = r2;
    L18:
        if (am.a(r12) == true) goto L20;
    L35:
        t.f11981a.a("sender: heartbeat stop, cancelled=" + a.c(this.this$0));
        return Unit.INSTANCE;
    L20:
        if (a.c(this.this$0) == true) goto L35;
        EncryptedTcpTransfer r3 = a.e(this.this$0);     // Catch: Throwable -> L14
        e r6 = this.$conn;     // Catch: Throwable -> L14
        Continuation<? super z<Unit>> r8 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        this.L$0 = r12;     // Catch: Throwable -> L14
        this.label = 1;     // Catch: Throwable -> L14
        Object r4 = r3.b(r6, "sender_backup", r8);     // Catch: Throwable -> L14
        if (r4 != r0) goto L24;
        return r0;
    L24:
        r2 = r12;
        r11 = r4;
    L25:
        z r13 = (z) ZeusTransformUtils.preCheckCast(r11, z.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (ZeusTransformUtils.instanceOf(r13, z.a.class) == false) goto L32;
        t.f11981a.a("sender: heartbeat failed", ((z.a) ZeusTransformUtils.preCheckCast(r13, z.a.class, "com.obric.memorydata.plugin")).a().c());     // Catch: Throwable -> L14
        e r14 = this.$conn;     // Catch: Throwable -> L14
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L30
        r14.d();     // Catch: Throwable -> L30
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
        Result.m1421constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L14
        goto L35
    L32:
        Continuation r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        this.L$0 = r2;     // Catch: Throwable -> L14
        this.label = 2;     // Catch: Throwable -> L14
        if (au.a(2000, r15) != r0) goto L8;
        return r0;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L14
        goto L25
    L16:
        ResultKt.throwOnFailure(r11);
        r12 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        t.f11981a.a("sender: heartbeat start, intervalMs=2000");
    L14:
        th = move-exception;
        t.f11981a.a("sender: heartbeat stop, cancelled=" + a.c(this.this$0));
        throw th;
    }
}
