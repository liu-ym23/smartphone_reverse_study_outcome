package com.obric.memorydata.migration.sdk.internal.net;

import com.obric.memorydata.migration.sdk.MigrationErrorCode;
import com.obric.memorydata.migration.sdk.d;
import com.obric.memorydata.migration.sdk.o;
import com.obric.memorydata.migration.sdk.t;
import com.obric.memorydata.migration.sdk.z;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.ServerSocket;
import java.net.Socket;
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

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/obric/memorydata/migration/sdk/MigrationResult;", "Ljava/net/Socket;", "kotlin.jvm.PlatformType", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.net.LanConnector$acceptTcp$2", f = "LanConnector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LanConnector$acceptTcp$2 extends SuspendLambda implements Function2<al, Continuation<? super z<? extends Socket>>, Object> {
    final /* synthetic */ d $request;
    final /* synthetic */ ServerSocket $server;
    private /* synthetic */ Object L$0;
    int label;

    LanConnector$acceptTcp$2(d r3, ServerSocket r4, Continuation<? super LanConnector$acceptTcp$2> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$request = r3;
        this.$server = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        LanConnector$acceptTcp$2 r0 = new LanConnector$acceptTcp$2(this.$request, this.$server, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super z<? extends Socket>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super z<? extends Socket>> r4) {
        return ((LanConnector$acceptTcp$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), LanConnector$acceptTcp$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r8);
        al r9 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        long r2 = System.currentTimeMillis();
        t r10 = t.f11981a;
        StringBuilder r0 = new StringBuilder().append("lan: accept wait, protocol=");
        String r4 = this.$request.a().getProtocolVersion();
        String r5 = "";
        if (r4 != null) goto L7;
        r4 = "";
    L7:
        r10.a(r0.append(r4).append(", port=").append(this.$server.getLocalPort()).toString());
        ServerSocket r11 = this.$server;
        d r7 = this.$request;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L14
        Socket r12 = r11.accept();     // Catch: Throwable -> L14
        t r3 = t.f11981a;     // Catch: Throwable -> L14
        StringBuilder r6 = new StringBuilder().append("lan: accept success, protocol=");     // Catch: Throwable -> L14
        String r13 = r7.a().getProtocolVersion();     // Catch: Throwable -> L14
        if (r13 == null) goto L12;
        r5 = r13;
    L12:
        r3.a(r6.append(r5).append(", costMs=").append(System.currentTimeMillis() - r2).toString());     // Catch: Throwable -> L14
        Object r14 = Result.m1421constructorimpl(new z.b(r12));     // Catch: Throwable -> L14
    L16:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r14);
        if (r15 == null) goto L25;
        t.f11981a.a("lan: accept failed, costMs=" + (System.currentTimeMillis() - r2), r15);
        return (z) ZeusTransformUtils.preCheckCast(new z.a(new o(MigrationErrorCode.CONNECT_FAILED, "接受连接失败: " + r15.getMessage(), r15)), z.class, "com.obric.memorydata.plugin");
    L25:
        return r14;
    L14:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L16
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
