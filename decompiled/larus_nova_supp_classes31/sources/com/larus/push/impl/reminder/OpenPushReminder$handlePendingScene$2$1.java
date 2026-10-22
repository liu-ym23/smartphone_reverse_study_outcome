package com.larus.push.impl.reminder;

import com.larus.platform.api.s4;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.push.impl.reminder.OpenPushReminder$handlePendingScene$2$1", f = "OpenPushReminder.kt", i = {0, 1}, l = {257, 247}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
public final class OpenPushReminder$handlePendingScene$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ s4 $pendingData;
    Object L$0;
    Object L$1;
    int label;

    public OpenPushReminder$handlePendingScene$2$1(s4 r1, Continuation<? super OpenPushReminder$handlePendingScene$2$1> r2) {
        this.$pendingData = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OpenPushReminder$handlePendingScene$2$1(this.$pendingData, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L9
    L22:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r2.unlock(null);
        return Unit.INSTANCE;
    L9:
        th = th;
        kotlinx.coroutines.sync.a r3 = r2;
    L27:
        r3.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        s4 r4 = (s4) this.L$1;
        r3 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r6);
    L31:
        OpenPushReminder r8 = OpenPushReminder.a;     // Catch: Throwable -> L26
        this.L$0 = r3;     // Catch: Throwable -> L26
        this.L$1 = null;     // Catch: Throwable -> L26
        this.label = 2;     // Catch: Throwable -> L26
        if (OpenPushReminder.a(r8, r4, null, this) != r0) goto L21;
        return r0;
    L21:
        r2 = r3;
    L26:
        th = th;
        goto L27
    L14:
        ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.sync.a r9 = OpenPushReminder.e;
        r4 = this.$pendingData;
        this.L$0 = r9;
        this.L$1 = r4;
        this.label = 1;
        if (r9.a(null, this) != r0) goto L17;
        return r0;
    L17:
        r3 = r9;
        goto L31
    }
}
