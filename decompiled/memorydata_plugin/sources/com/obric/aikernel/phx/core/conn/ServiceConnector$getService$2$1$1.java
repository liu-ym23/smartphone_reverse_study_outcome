package com.obric.aikernel.phx.core.conn;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcelable;
import com.obric.aikernel.a;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.sdk.data.ExtraAppInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/AIKBinder;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2$1$1", f = "ServiceConnector.kt", i = {}, l = {243, 245}, m = "invokeSuspend", n = {}, s = {})
final class ServiceConnector$getService$2$1$1 extends SuspendLambda implements Function2<al, Continuation<? super a>, Object> {
    int label;
    final /* synthetic */ ServiceConnector this$0;

    ServiceConnector$getService$2$1$1(ServiceConnector r3, Continuation<? super ServiceConnector$getService$2$1$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ServiceConnector$getService$2$1$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super a> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super a> r4) {
        return ((ServiceConnector$getService$2$1$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ServiceConnector$getService$2$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L18:
        a r9 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.memorydata.plugin");
        ServiceConnector r7 = this.this$0;
        monitor-enter(r7);
        ServiceConnector.access$setConnectTask$p(r7, null);     // Catch: Throwable -> L38
        ServiceConnector.access$setContinuation$p(r7, null);     // Catch: Throwable -> L38
        if (r9 == null) goto L32;
        IBinder r2 = r9.asBinder();     // Catch: Throwable -> L38
        if (r2 == null) goto L32;
        if (r2.isBinderAlive() != true) goto L32;
    L33:
        if (r3 == false) goto L35;
        ServiceConnector.access$scheduleIdleReleaseLocked(r7);     // Catch: Throwable -> L38
    L35:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r7);
        return r9;
    L32:
        r3 = false;
    L38:
        th = move-exception;
        throw th;
    L10:
        ResultKt.throwOnFailure(r8);
        Intent r10 = new Intent();
        r10.setComponent(ServiceConnector.access$getConnName$p(this.this$0));
        r10.addFlags(1);
        ExtraAppInfo r5 = ServiceConnector.access$getAiKernelConfig$p(this.this$0).getExtraBindInfo();
        if (r5 == null) goto L14;
        r10.putExtra(IdlKeys.Args_BindExtraInfo, (Parcelable) ZeusTransformUtils.preCheckCast(r5, Parcelable.class, "com.obric.memorydata.plugin"));
    L14:
        if (com.obric.aikernel.core.a.f5987a.c() == false) goto L19;
        ServiceConnector r6 = this.this$0;
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r8 = ServiceConnector.access$connectViaAuthProvider(r6, r10, r11);
        if (r8 != r0) goto L18;
        return r0;
    L19:
        ServiceConnector r12 = this.this$0;
        Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        r8 = ServiceConnector.access$connectViaBindService(r12, r10, r13);
        if (r8 != r0) goto L18;
        return r0;
    }
}
