package com.obric.aikernel.phx.core.api;

import android.os.Bundle;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.phx.compat.ParamsCompat;
import com.obric.aikernel.phx.core.conn.b;
import com.obric.aikernel.sdk.config.RequestParams;
import f8.a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.c;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.api.ScriptBizApi$inferenceAsFlow$2", f = "ScriptBizApi.kt", i = {0, 1}, l = {66, 66}, m = "invokeSuspend", n = {"lifecycleHandle", "lifecycleHandle"}, s = {"L$0", "L$0"})
final class ScriptBizApi$inferenceAsFlow$2 extends SuspendLambda implements Function2<d<? super a<Object>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.obric.aikernel.a $binder;
    final /* synthetic */ RequestParams $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ScriptBizApi this$0;

    ScriptBizApi$inferenceAsFlow$2(ScriptBizApi r10, com.obric.aikernel.a r11, RequestParams r12, Continuation<? super ScriptBizApi$inferenceAsFlow$2> r13) {
        this.this$0 = r10;
        this.$binder = r11;
        this.$params = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ScriptBizApi$inferenceAsFlow$2 r12 = new ScriptBizApi$inferenceAsFlow$2(this.this$0, this.$binder, this.$params, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(d<? super a<Object>> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(d<? super a<Object>> r10, Continuation<? super Unit> r11) {
        return ((ScriptBizApi$inferenceAsFlow$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L18;
        if (r11 == 1) goto L13;
        if (r11 != 2) goto L12;
        b r12 = (b) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L9
    L26:
        r12.close();
        return Unit.INSTANCE;
    L9:
        Throwable th = th;
    L30:
        r12.close();
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        com.obric.aikernel.a r14 = (com.obric.aikernel.a) this.L$3;
        ScriptBizApi r15 = (ScriptBizApi) this.L$2;
        d r16 = (d) this.L$1;
        b r17 = (b) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L16
        Object r18 = r13;
        b r19 = r17;
    L22:
        RequestParams r20 = this.$params;     // Catch: Throwable -> L28
        ScriptBizApi r21 = this.this$0;     // Catch: Throwable -> L28
        Bundle r22 = (Bundle) r18;     // Catch: Throwable -> L28
        e8.a.x(r20.getBackend(), r21.v(), "ScriptBizApi", "inferenceAsFlow").putBoolean(IdlKeys.Args_StreamingCall, true);     // Catch: Throwable -> L28
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L28
        final c<Bundle> r24 = r15.c(r14, (Bundle) r18);     // Catch: Throwable -> L28
        c<a<Object>> r25 = new ScriptBizApi$inferenceAsFlow$2$invokeSuspend$$inlined$map$1(r24);     // Catch: Throwable -> L28
        this.L$0 = r19;     // Catch: Throwable -> L28
        this.L$1 = null;     // Catch: Throwable -> L28
        this.L$2 = null;     // Catch: Throwable -> L28
        this.L$3 = null;     // Catch: Throwable -> L28
        this.label = 2;     // Catch: Throwable -> L28
        if (e.n(r16, r25, this) != r10) goto L25;
        return r10;
    L25:
        r12 = r19;
    L28:
        th = move-exception;
        b r110 = r19;
        th = th;
        r12 = r110;
    L16:
        th = th;
        r12 = r17;
        goto L30
    L18:
        ResultKt.throwOnFailure(r13);
        r16 = (d) this.L$0;
        r19 = ScriptBizApi.l(this.this$0);
        r15 = this.this$0;     // Catch: Throwable -> L28
        r14 = this.$binder;     // Catch: Throwable -> L28
        ParamsCompat r26 = ParamsCompat.f4752a;     // Catch: Throwable -> L28
        RequestParams r27 = this.$params;     // Catch: Throwable -> L28
        this.L$0 = r19;     // Catch: Throwable -> L28
        this.L$1 = r16;     // Catch: Throwable -> L28
        this.L$2 = r15;     // Catch: Throwable -> L28
        this.L$3 = r14;     // Catch: Throwable -> L28
        this.label = 1;     // Catch: Throwable -> L28
        r18 = r26.f(r27, this);     // Catch: Throwable -> L28
        if (r18 != r10) goto L22;
        return r10;
    }
}
