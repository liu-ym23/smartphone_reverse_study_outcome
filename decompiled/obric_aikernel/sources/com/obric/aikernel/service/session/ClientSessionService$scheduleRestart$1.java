package com.obric.aikernel.service.session;

import android.os.Process;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.Iterator;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.session.ClientSessionService$scheduleRestart$1", f = "ClientSessionService.kt", i = {0}, l = {119}, m = "invokeSuspend", n = {"lastRoundIdleState"}, s = {"I$0"})
final class ClientSessionService$scheduleRestart$1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    int I$0;
    int label;
    final /* synthetic */ ClientSessionService this$0;

    ClientSessionService$scheduleRestart$1(ClientSessionService r10, Continuation<? super ClientSessionService$scheduleRestart$1> r11) {
        this.this$0 = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ClientSessionService$scheduleRestart$1(this.this$0, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((ClientSessionService$scheduleRestart$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00f4 -> B:6:0x0011). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        int r13 = this.I$0;
        ResultKt.throwOnFailure(r12);
        ?? r14 = r13;
    L6:
        ?? r15 = r14;
    L10:
        Iterator r16 = ClientSessionService.e(this.this$0).values().iterator();
    L11:
        Integer r17 = null;
        if (r16.hasNext() == false) goto L16;
        Object r18 = r16.next();
        if (((ClientSessions) r18).f() == false) goto L11;
    L17:
        ClientSessions r19 = (ClientSessions) r18;
        if (r19 != null) goto L20;
        ?? r20 = 1;
    L22:
        if (r15 == 0) goto L25;
        if (r20 == 0) goto L25;
        AIKLog.INSTANCE.i("ClientSessionService", "scheduleRestart terminal process " + Process.myPid() + ' ' + Process.myProcessName());
        Process.sendSignal(Process.myPid(), 15);
    L25:
        AIKLog r21 = AIKLog.INSTANCE;
        ?? r22 = new StringBuilder();
        r22.append("scheduleRestart ");
        r22.append(Process.myPid());
        r22.append(' ');
        r22.append(Process.myProcessName());
        r22.append(" lastRoundIdleState:");
        if (r15 == 0) goto L28;
        boolean r110 = true;
    L29:
        r22.append(r110);
        r22.append(" currentIdleState:");
        r22.append(r20);
        r22.append(". Client ");
        if (r19 == null) goto L32;
        String r111 = r19.c();
    L33:
        r22.append(r111);
        r22.append(" has ");
        if (r19 == null) goto L38;
        Map<String, ApiRequestSession> r112 = r19.e();
        if (r112 == null) goto L38;
        r17 = Boxing.boxInt(r112.size());
    L38:
        r22.append(r17);
        r22.append(" active sessions!");
        r21.i("ClientSessionService", r22.toString());
        long r23 = ClientSessionService.d(this.this$0);
        this.I$0 = r20;
        this.label = 1;
        r14 = r20;
        if (DelayKt.b(r23, this) != r10) goto L6;
        return r10;
    L32:
        r111 = null;
        goto L33
    L28:
        r110 = false;
        goto L29
    L20:
        r20 = 0;
        goto L22
    L16:
        r18 = null;
        goto L17
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
        r15 = 0;
        goto L10
    }
}
