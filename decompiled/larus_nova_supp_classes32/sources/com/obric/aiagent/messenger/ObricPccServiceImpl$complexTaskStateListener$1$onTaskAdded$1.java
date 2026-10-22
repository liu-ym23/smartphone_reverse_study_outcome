package com.obric.aiagent.messenger;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.bean.DMTaskInfo;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.aiagent.messenger.ObricPccServiceImpl$complexTaskStateListener$1$onTaskAdded$1", f = "ObricPccServiceImpl.kt", i = {0, 0, 1}, l = {360, 264}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "currentTaskCount", "$this$withLock_u24default$iv"}, s = {"L$0", "I$0", "L$0"})
public final class ObricPccServiceImpl$complexTaskStateListener$1$onTaskAdded$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DMTaskInfo $taskInfo;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ObricPccServiceImpl this$0;

    public ObricPccServiceImpl$complexTaskStateListener$1$onTaskAdded$1(DMTaskInfo r1, ObricPccServiceImpl r2, Continuation<? super ObricPccServiceImpl$complexTaskStateListener$1$onTaskAdded$1> r3) {
        this.$taskInfo = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricPccServiceImpl$complexTaskStateListener$1$onTaskAdded$1(this.$taskInfo, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 != 2) goto L12;
        kotlinx.coroutines.sync.a r0 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L9
    L31:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r0.unlock(null);
        return Unit.INSTANCE;
    L9:
        th = th;
        kotlinx.coroutines.sync.a r9 = r0;
    L36:
        r9.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        int r3 = this.I$0;
        DMTaskInfo r7 = (DMTaskInfo) this.L$2;
        ObricPccServiceImpl r8 = (ObricPccServiceImpl) this.L$1;
        r9 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r11);
    L38:
        r8.j = r3;     // Catch: Throwable -> L35
        FLogger r13 = FLogger.a;     // Catch: Throwable -> L35
        StringBuilder r4 = new StringBuilder("onTaskAdded currSessionId=");     // Catch: Throwable -> L35
        r4.append(r8.i);     // Catch: Throwable -> L35
        r4.append(", taskCount=");     // Catch: Throwable -> L35
        r4.append(r8.j);     // Catch: Throwable -> L35
        r4.append(", taskId=");     // Catch: Throwable -> L35
        if (r7 == null) goto L24;
        String r5 = r7.getTaskId();     // Catch: Throwable -> L35
    L25:
        r4.append(r5);     // Catch: Throwable -> L35
        r13.i("ObricPccServiceImpl", r4.toString());     // Catch: Throwable -> L35
        if (r8.j > 1) goto L30;
        this.L$0 = r9;     // Catch: Throwable -> L35
        this.L$1 = null;     // Catch: Throwable -> L35
        this.L$2 = null;     // Catch: Throwable -> L35
        this.label = 2;     // Catch: Throwable -> L35
        if (ObricPccServiceImpl.e(r8, this) != r1) goto L30;
        return r1;
    L30:
        r0 = r9;
        goto L31
    L24:
        r5 = null;
    L35:
        th = th;
        goto L36
    L14:
        ResultKt.throwOnFailure(r11);
        FLogger r14 = FLogger.a;
        StringBuilder r6 = new StringBuilder("onTaskAdded taskId=");
        DMTaskInfo r10 = this.$taskInfo;
        if (r10 == null) goto L17;
        String r15 = r10.getTaskId();
    L18:
        r6.append(r15);
        r6.append(" waiting lock");
        r14.i("ObricPccServiceImpl", r6.toString());
        r3 = ObricPccServiceImpl.d(this.this$0);
        r8 = this.this$0;
        r9 = r8.k;
        r7 = this.$taskInfo;
        this.L$0 = r9;
        this.L$1 = r8;
        this.L$2 = r7;
        this.I$0 = r3;
        this.label = 1;
        if (r9.a(null, this) != r1) goto L38;
        return r1;
    L17:
        r15 = null;
        goto L18
    }
}
