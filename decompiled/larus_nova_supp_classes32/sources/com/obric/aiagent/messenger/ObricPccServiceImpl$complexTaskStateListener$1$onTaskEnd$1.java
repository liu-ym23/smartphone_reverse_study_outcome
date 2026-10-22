package com.obric.aiagent.messenger;

import com.bytedance.privacy.pcc.PccManager;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aivoice.core.data.NameKeys;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.ObricPccServiceImpl$complexTaskStateListener$1$onTaskEnd$1", f = "ObricPccServiceImpl.kt", i = {0, 0, 1}, l = {360, 279}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "currentTaskCount", "$this$withLock_u24default$iv"}, s = {"L$0", "I$0", "L$0"})
public final class ObricPccServiceImpl$complexTaskStateListener$1$onTaskEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DMTaskInfo $taskInfo;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ObricPccServiceImpl this$0;

    public ObricPccServiceImpl$complexTaskStateListener$1$onTaskEnd$1(DMTaskInfo r1, ObricPccServiceImpl r2, Continuation<? super ObricPccServiceImpl$complexTaskStateListener$1$onTaskEnd$1> r3) {
        this.$taskInfo = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricPccServiceImpl$complexTaskStateListener$1$onTaskEnd$1(this.$taskInfo, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L14;
        if (r3 == 1) goto L13;
        if (r3 != 2) goto L12;
        ObricPccServiceImpl r1 = (ObricPccServiceImpl) this.L$1;
        kotlinx.coroutines.sync.a r4 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L9
    L32:
        String r12 = r1.i;     // Catch: Throwable -> L9
        if (r12 == null) goto L39;
        PccManager r5 = r1.g;     // Catch: Throwable -> L9
        if (r5 == null) goto L37;
        Integer r13 = Boxing.boxInt(r5.closeSecuritySession(r12));     // Catch: Throwable -> L9
    L38:
        FLogger.a.i("ObricPccServiceImpl", "closeSecuritySession res=" + r13);     // Catch: Throwable -> L9
        goto L39
    L37:
        r13 = null;
    L39:
        r1.i = null;     // Catch: Throwable -> L9
    L41:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r4.unlock(null);
        return Unit.INSTANCE;
    L9:
        th = th;
        kotlinx.coroutines.sync.a r9 = r4;
    L46:
        r9.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        int r6 = this.I$0;
        DMTaskInfo r7 = (DMTaskInfo) this.L$2;
        ObricPccServiceImpl r8 = (ObricPccServiceImpl) this.L$1;
        r9 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r11);
        ObricPccServiceImpl r15 = r8;
    L50:
        r15.j = r6;     // Catch: Throwable -> L45
        FLogger r10 = FLogger.a;     // Catch: Throwable -> L45
        StringBuilder r16 = new StringBuilder("onTaskEnd currSessionId=");     // Catch: Throwable -> L45
        r16.append(r15.i);     // Catch: Throwable -> L45
        r16.append(", taskCount=");     // Catch: Throwable -> L45
        r16.append(r15.j);     // Catch: Throwable -> L45
        r16.append(", taskId=");     // Catch: Throwable -> L45
        if (r7 == null) goto L25;
        String r17 = r7.getTaskId();     // Catch: Throwable -> L45
    L26:
        r16.append(r17);     // Catch: Throwable -> L45
        r10.i("ObricPccServiceImpl", r16.toString());     // Catch: Throwable -> L45
        if (r15.j != 0) goto L40;
        CopyOnWriteArrayList r18 = r15.l;     // Catch: Throwable -> L45
        this.L$0 = r9;     // Catch: Throwable -> L45
        this.L$1 = r15;     // Catch: Throwable -> L45
        this.L$2 = null;     // Catch: Throwable -> L45
        this.label = 2;     // Catch: Throwable -> L45
        if (AwaitKt.c(r18, this) != r2) goto L31;
        return r2;
    L31:
        r1 = r15;
        r4 = r9;
        goto L32
    L40:
        r4 = r9;
        goto L41
    L25:
        r17 = null;
    L45:
        th = th;
        goto L46
    L14:
        ResultKt.throwOnFailure(r11);
        FLogger r19 = FLogger.a;
        StringBuilder r20 = new StringBuilder("onTaskEnd taskId=");
        DMTaskInfo r21 = this.$taskInfo;
        if (r21 == null) goto L17;
        String r22 = r21.getTaskId();
    L18:
        r20.append(r22);
        r20.append(" waiting lock");
        r19.i("ObricPccServiceImpl", r20.toString());
        r6 = ObricPccServiceImpl.d(this.this$0);
        r15 = this.this$0;
        r9 = r15.k;
        DMTaskInfo r23 = this.$taskInfo;
        this.L$0 = r9;
        this.L$1 = r15;
        this.L$2 = r23;
        this.I$0 = r6;
        this.label = 1;
        if (r9.a(null, this) != r2) goto L21;
        return r2;
    L21:
        r7 = r23;
        goto L50
    L17:
        r22 = null;
        goto L18
    }
}
