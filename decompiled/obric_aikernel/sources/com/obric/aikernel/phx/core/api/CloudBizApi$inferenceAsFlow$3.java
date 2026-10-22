package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.obric.aikernel.phx.core.conn.ServiceConnector;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.api.AIKernelApi;
import f8.a;
import java.io.Closeable;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.api.CloudBizApi$inferenceAsFlow$3", f = "CloudBizApi.kt", i = {0}, l = {50, 52, 56}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
final class CloudBizApi$inferenceAsFlow$3 extends SuspendLambda implements Function2<d<? super a<Object>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $args;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CloudBizApi this$0;

    CloudBizApi$inferenceAsFlow$3(CloudBizApi r10, Bundle r11, Continuation<? super CloudBizApi$inferenceAsFlow$3> r12) {
        this.this$0 = r10;
        this.$args = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CloudBizApi$inferenceAsFlow$3 r12 = new CloudBizApi$inferenceAsFlow$3(this.this$0, this.$args, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(d<? super a<Object>> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(d<? super a<Object>> r10, Continuation<? super Unit> r11) {
        return ((CloudBizApi$inferenceAsFlow$3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.Closeable] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r23) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r11 = this.label;
        if (r11 == 0) goto L16;
        if (r11 == 1) goto L15;
        if (r11 == 2) goto L14;
        if (r11 != 3) goto L13;
        Closeable r12 = (Closeable) this.L$0;
        ResultKt.throwOnFailure(r23);     // Catch: Throwable -> L10
        r11 = r12;
    L30:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r11, null);
        return r13;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r23);
    L25:
        return Unit.INSTANCE;
    L15:
        d r14 = (d) this.L$0;
        ResultKt.throwOnFailure(r23);
        d r15 = r14;
        Object r16 = r23;
    L19:
        ServiceConnector.b r17 = (ServiceConnector.b) r16;
        if (r17 != null) goto L26;
        a r18 = new a(102, null, null, false, false, null, null, 126, null);
        this.L$0 = null;
        this.label = 2;
        if (r15.emit(r18, this) != r10) goto L25;
        return r10;
    L26:
        CloudBizApi r19 = this.this$0;
        Bundle r20 = this.$args;
        final c<Bundle> r21 = r19.c(r17.a(), r20);     // Catch: Throwable -> L10
        c<a<Object>> r22 = new CloudBizApi$inferenceAsFlow$3$invokeSuspend$lambda$1$$inlined$map$1(r21);     // Catch: Throwable -> L10
        this.L$0 = r17;     // Catch: Throwable -> L10
        this.label = 3;     // Catch: Throwable -> L10
        r11 = r17;
        if (e.n(r15, r22, this) != r10) goto L30;
        return r10;
    L16:
        ResultKt.throwOnFailure(r23);
        r15 = (d) this.L$0;
        AIKernelApi r24 = AIKernelManager.INSTANCE.getInstance$sdk_release();
        this.L$0 = r15;
        this.label = 1;
        r16 = AIKernelApi.m(r24, 0, this, 1, null);
        if (r16 != r10) goto L19;
        return r10;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    }
}
