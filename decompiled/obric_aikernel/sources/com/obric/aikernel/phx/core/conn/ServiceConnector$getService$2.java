package com.obric.aikernel.phx.core.conn;

import android.os.IBinder;
import com.obric.aikernel.core.log.AIKLog;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2", f = "ServiceConnector.kt", i = {}, l = {278}, m = "invokeSuspend", n = {}, s = {})
final class ServiceConnector$getService$2 extends SuspendLambda implements Function2<l0, Continuation<? super com.obric.aikernel.a>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ServiceConnector this$0;

    ServiceConnector$getService$2(ServiceConnector r10, Continuation<? super ServiceConnector$getService$2> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ServiceConnector$getService$2 r12 = new ServiceConnector$getService$2(this.this$0, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super com.obric.aikernel.a> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super com.obric.aikernel.a> r11) {
        return ((ServiceConnector$getService$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        IBinder r13 = null;
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L10;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L7
    L56:
        Object r14 = Result.m32constructorimpl((com.obric.aikernel.a) r12);     // Catch: Throwable -> L7
    L59:
        Throwable r15 = Result.m35exceptionOrNullimpl(r14);
        if (r15 == null) goto L63;
        AIKLog.INSTANCE.w("ServiceConnector", "connectTask failed by " + r15);
    L63:
        if (Result.m38isFailureimpl(r14) == false) goto L65;
        r14 = null;
    L65:
        com.obric.aikernel.a r16 = (com.obric.aikernel.a) r14;
        if (r16 == null) goto L80;
        ServiceConnector r17 = this.this$0;
        AIKLog r18 = AIKLog.INSTANCE;
        StringBuilder r19 = new StringBuilder();
        r19.append("await finished ");
        com.obric.aikernel.a r110 = ServiceConnector.h(r17);
        if (r110 == null) goto L70;
        r13 = r110.asBinder();
    L70:
        r19.append(r13);
        r18.v("ServiceConnector", r19.toString());
        return r16;
    L80:
        return null;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r12);
        l0 r111 = (l0) this.L$0;
        ServiceConnector r112 = this.this$0;
        monitor-enter(r112);
        com.obric.aikernel.a r20 = ServiceConnector.h(r112);     // Catch: Throwable -> L72
        boolean r21 = false;
        if (r20 == null) goto L20;
        IBinder r22 = r20.asBinder();     // Catch: Throwable -> L72
        if (r22 == null) goto L20;
        if (r22.isBinderAlive() != true) goto L20;
        boolean r23 = true;
    L22:
        if (r23 == true) goto L39;
        AIKLog r24 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
        StringBuilder r25 = new StringBuilder();     // Catch: Throwable -> L72
        r25.append("should rebind ");     // Catch: Throwable -> L72
        com.obric.aikernel.a r26 = ServiceConnector.h(r112);     // Catch: Throwable -> L72
        if (r26 == null) goto L26;
        IBinder r27 = r26.asBinder();     // Catch: Throwable -> L72
    L27:
        r25.append(r27);     // Catch: Throwable -> L72
        r25.append(' ');     // Catch: Throwable -> L72
        r25.append(ServiceConnector.f(r112));     // Catch: Throwable -> L72
        r25.append(' ');     // Catch: Throwable -> L72
        r0 r28 = ServiceConnector.f(r112);     // Catch: Throwable -> L72
        if (r28 == null) goto L30;
        Boolean r29 = Boxing.boxBoolean(r28.a());     // Catch: Throwable -> L72
    L31:
        r25.append(r29);     // Catch: Throwable -> L72
        r24.d("ServiceConnector", r25.toString());     // Catch: Throwable -> L72
        r0 r30 = ServiceConnector.f(r112);     // Catch: Throwable -> L72
        if (r30 != null) goto L34;
    L36:
        if (r21 == false) goto L39;
        ServiceConnector.k(r112, null);     // Catch: Throwable -> L72
        goto L39
    L34:
        if (r30.a() != true) goto L36;
        r21 = true;
        goto L36
    L30:
        r29 = null;
        goto L31
    L26:
        r27 = null;
    L39:
        if (ServiceConnector.f(r112) != null) goto L45;
        AIKLog r31 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
        StringBuilder r32 = new StringBuilder();     // Catch: Throwable -> L72
        r32.append("new task ");     // Catch: Throwable -> L72
        com.obric.aikernel.a r33 = ServiceConnector.h(r112);     // Catch: Throwable -> L72
        if (r33 == null) goto L43;
        IBinder r34 = r33.asBinder();     // Catch: Throwable -> L72
    L44:
        r32.append(r34);     // Catch: Throwable -> L72
        r31.i("ServiceConnector", r32.toString());     // Catch: Throwable -> L72
        ServiceConnector.k(r112, h.b(m0.a(z0.b()), null, null, new ServiceConnector$getService$2$1$1(r112, null), 3, null));     // Catch: Throwable -> L72
        h.d(m0.a(z0.b()), null, null, new ServiceConnector$getService$2$1$2(ServiceConnector.f(r112), null), 3, null);     // Catch: Throwable -> L72
    L50:
        r0 r35 = ServiceConnector.f(r112);     // Catch: Throwable -> L72
        monitor-exit(r112);
        if (r35 == null) goto L79;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r12 = r35.r(this);     // Catch: Throwable -> L7
        if (r12 != r10) goto L56;
        return r10;
    L79:
        return null;
    L43:
        r34 = null;
        goto L44
    L45:
        AIKLog r36 = AIKLog.INSTANCE;     // Catch: Throwable -> L72
        StringBuilder r37 = new StringBuilder();     // Catch: Throwable -> L72
        r37.append("reuse task ");     // Catch: Throwable -> L72
        r37.append(ServiceConnector.f(r112));     // Catch: Throwable -> L72
        r37.append(' ');     // Catch: Throwable -> L72
        r0 r38 = ServiceConnector.f(r112);     // Catch: Throwable -> L72
        if (r38 == null) goto L48;
        Boolean r39 = Boxing.boxBoolean(r38.a());     // Catch: Throwable -> L72
    L49:
        r37.append(r39);     // Catch: Throwable -> L72
        r36.d("ServiceConnector", r37.toString());     // Catch: Throwable -> L72
        goto L50
    L48:
        r39 = null;
    L20:
        r23 = false;
    L72:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        Result.Companion r40 = Result.Companion;
        r14 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L59
    }
}
