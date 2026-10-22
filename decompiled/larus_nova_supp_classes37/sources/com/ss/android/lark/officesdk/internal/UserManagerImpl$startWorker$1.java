package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl$startWorker$1", f = "UserManagerImpl.kt", i = {1, 2}, l = {224, 231, 232}, m = "invokeSuspend", n = {"command", "command"}, s = {"L$0", "L$0"})
final class UserManagerImpl$startWorker$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ UserManagerImpl this$0;

    public UserManagerImpl$startWorker$1(UserManagerImpl r1, Continuation<? super UserManagerImpl$startWorker$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UserManagerImpl$startWorker$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0043 -> B:20:0x0046). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x006f -> B:40:0x0086). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0083 -> B:40:0x0086). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x00b6 -> B:20:0x0046). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        UserManagerImpl.c r2 = (UserManagerImpl.c) this.L$0;
    L77:
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L13
        UserManagerImpl$startWorker$1 r12 = this;
    L40:
        UserManagerImpl r3 = r12.this$0;
        Object r6 = r3.l;
        monitor-enter(r6);
        r3.n = null;     // Catch: Throwable -> L45
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r6);
    L20:
        UserManagerImpl r5 = r12.this$0;
        Object r7 = r5.l;
        monitor-enter(r7);
        UserManagerImpl.c r8 = (UserManagerImpl.c) r5.m.removeFirstOrNull();     // Catch: Throwable -> L70
        if (r8 == null) goto L26;
        r5.n = r8;     // Catch: Throwable -> L70
        UserManagerImpl.c r9 = r8;
    L27:
        monitor-exit(r7);
        if (r9 != null) goto L81;
    L17:
        Channel<Unit> r10 = r12.this$0.o;
        r12.L$0 = null;
        r12.label = 1;
        if (r10.receive(r12) != r0) goto L20;
        return r0;
    L81:
    L50:
        th = move-exception;
        Object r13 = r0;
        UserManagerImpl$startWorker$1 r14 = r12;
        Throwable th = th;
        UserManagerImpl.c r15 = r9;
        Object r16 = r13;
    L85:
        Log.e("UserManagerImpl", "command execution failed unexpectedly", th);     // Catch: Throwable -> L61
        UserManagerImpl.d(r14.this$0, r15, th);     // Catch: Throwable -> L61
        UserManagerImpl r17 = r14.this$0;
        Object r18 = r17.l;
        monitor-enter(r18);
        r17.n = null;     // Catch: Throwable -> L58
        Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L58
        monitor-exit(r18);
        r12 = r14;
        r0 = r16;
    L58:
        th = move-exception;
        throw th;
    L61:
        th = move-exception;
        UserManagerImpl r20 = r14.this$0;
        monitor-enter(r20.l);
        r20.n = null;     // Catch: Throwable -> L67
        Unit r21 = Unit.INSTANCE;     // Catch: Throwable -> L67
        throw th;
    L67:
        th = move-exception;
        throw th;
    L31:
        if ((r9 instanceof UserManagerImpl.c.a) == false) goto L36;
        r12.L$0 = r9;     // Catch: Throwable -> L50
        r12.label = 2;     // Catch: Throwable -> L50
        if (UserManagerImpl.b(r12.this$0, (UserManagerImpl.c.a) r9, r12) != r0) goto L40;
        return r0;
    L36:
        if ((r9 instanceof UserManagerImpl.c.b) == false) goto L49;
        r12.L$0 = r9;     // Catch: Throwable -> L50
        r12.label = 3;     // Catch: Throwable -> L50
        if (UserManagerImpl.c(r12.this$0, (UserManagerImpl.c.b) r9, r12) != r0) goto L40;
        return r0;
    L49:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L50
    L26:
        r9 = null;
    L70:
        th = move-exception;
        throw th;
    L45:
        th = move-exception;
        throw th;
    L13:
        th = th;
        r15 = r2;
        r16 = r0;
        r14 = this;
        goto L85
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r2 = (UserManagerImpl.c) this.L$0;
        goto L77
    L15:
        ResultKt.throwOnFailure(r11);
        r12 = this;
        goto L20
    L16:
        ResultKt.throwOnFailure(r11);
        r12 = this;
        goto L17
    }
}
