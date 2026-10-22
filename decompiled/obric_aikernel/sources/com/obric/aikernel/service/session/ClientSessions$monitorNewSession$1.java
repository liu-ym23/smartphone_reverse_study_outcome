package com.obric.aikernel.service.session;

import com.bytedance.crash.resource.vmmonitor.VmMonitorConfig;
import com.obric.aikernel.middleware.api.log.AIKLog;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.session.ClientSessions$monitorNewSession$1", f = "ClientSessions.kt", i = {0}, l = {61}, m = "invokeSuspend", n = {"timeout"}, s = {"J$0"})
final class ClientSessions$monitorNewSession$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reqId;
    long J$0;
    int label;
    final /* synthetic */ ClientSessions this$0;

    ClientSessions$monitorNewSession$1(ClientSessions r10, String r11, Continuation<? super ClientSessions$monitorNewSession$1> r12) {
        this.this$0 = r10;
        this.$reqId = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ClientSessions$monitorNewSession$1(this.this$0, this.$reqId, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((ClientSessions$monitorNewSession$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        long r13 = this.J$0;
        ResultKt.throwOnFailure(r10);
    L13:
        ApiRequestSession r14 = this.this$0.d(this.$reqId);
        boolean r15 = false;
        if (r14 != null) goto L16;
    L18:
        if (r15 == false) goto L26;
        AIKLog r16 = AIKLog.INSTANCE;
        StringBuilder r17 = new StringBuilder();
        r17.append("session ");
        ApiRequestSession r18 = this.this$0.d(this.$reqId);
        if (r18 == null) goto L22;
        String r19 = r18.f();
    L23:
        r17.append(r19);
        r17.append(" still active.");
        r16.i("ClientSessionService", r17.toString());
        this.J$0 = r13;
        this.label = 1;
        if (DelayKt.b(r13, this) != r11) goto L13;
        return r11;
    L22:
        r19 = null;
        goto L23
    L26:
        this.this$0.i(this.$reqId);
        return Unit.INSTANCE;
    L16:
        if (r14.l() == true) goto L18;
        r15 = true;
        goto L18
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ApiRequestSession r20 = (ApiRequestSession) ClientSessions.a(this.this$0).get(this.$reqId);
        if (r20 == null) goto L11;
        long r21 = r20.h();
    L12:
        r13 = Math.min(r21, VmMonitorConfig.SLEEP_TIME_BEFORE_RECOVER);
        goto L13
    L11:
        r21 = 60000;
        goto L12
    }
}
