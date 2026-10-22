package com.obric.aikernel.phx.core.conn;

import android.content.Intent;
import android.os.IBinder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.sdk.data.ExtraAppInfo;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2$1$1", f = "ServiceConnector.kt", i = {}, l = {243, 245}, m = "invokeSuspend", n = {}, s = {})
final class ServiceConnector$getService$2$1$1 extends SuspendLambda implements Function2<l0, Continuation<? super com.obric.aikernel.a>, Object> {
    int label;
    final /* synthetic */ ServiceConnector this$0;

    ServiceConnector$getService$2$1$1(ServiceConnector r10, Continuation<? super ServiceConnector$getService$2$1$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ServiceConnector$getService$2$1$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super com.obric.aikernel.a> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super com.obric.aikernel.a> r11) {
        return ((ServiceConnector$getService$2$1$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        boolean r13 = true;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 == 2) goto L9;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
    L18:
        com.obric.aikernel.a r14 = (com.obric.aikernel.a) r10;
        ServiceConnector r15 = this.this$0;
        monitor-enter(r15);
        ServiceConnector.k(r15, null);     // Catch: Throwable -> L38
        ServiceConnector.l(r15, null);     // Catch: Throwable -> L38
        if (r14 == null) goto L32;
        IBinder r16 = r14.asBinder();     // Catch: Throwable -> L38
        if (r16 == null) goto L32;
        if (r16.isBinderAlive() != true) goto L32;
    L33:
        if (r13 == false) goto L35;
        ServiceConnector.j(r15);     // Catch: Throwable -> L38
    L35:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r15);
        return r14;
    L32:
        r13 = false;
    L38:
        th = move-exception;
        throw th;
    L10:
        ResultKt.throwOnFailure(r10);
        Intent r18 = new Intent();
        r18.setComponent(ServiceConnector.e(this.this$0));
        r18.addFlags(1);
        ExtraAppInfo r19 = ServiceConnector.d(this.this$0).getExtraBindInfo();
        if (r19 == null) goto L14;
        r18.putExtra(IdlKeys.Args_BindExtraInfo, r19);
    L14:
        if (f7.a.f8866a.c() == false) goto L19;
        ServiceConnector r20 = this.this$0;
        this.label = 1;
        r10 = ServiceConnector.b(r20, r18, this);
        if (r10 != r11) goto L18;
        return r11;
    L19:
        ServiceConnector r21 = this.this$0;
        this.label = 2;
        r10 = ServiceConnector.c(r21, r18, this);
        if (r10 != r11) goto L18;
        return r11;
    }
}
