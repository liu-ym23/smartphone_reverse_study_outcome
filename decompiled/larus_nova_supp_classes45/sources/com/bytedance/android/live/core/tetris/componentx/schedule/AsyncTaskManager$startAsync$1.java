package com.bytedance.android.live.core.tetris.componentx.schedule;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.core.tetris.componentx.schedule.AsyncTaskManager$startAsync$1", f = "AsyncTaskManager.kt", i = {}, l = {55, 58}, m = "invokeSuspend", n = {}, s = {})
final class AsyncTaskManager$startAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $task;
    final /* synthetic */ String $taskName;
    int label;
    final /* synthetic */ AsyncTaskManager this$0;

    public AsyncTaskManager$startAsync$1(AsyncTaskManager r1, String r2, Function1 r3, Continuation r4) {
        this.this$0 = r1;
        this.$taskName = r2;
        this.$task = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Intrinsics.checkNotNullParameter(r5, "completion");
        return new AsyncTaskManager$startAsync$1(this.this$0, this.$taskName, this.$task, r5);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r5);     // Catch: Exception -> L12
    L21:
        Map<String, AtomicReference<AsyncTaskManager.a>> r6 = this.this$0.c;     // Catch: Exception -> L12
        LinkedHashMap r7 = (LinkedHashMap) r6;     // Catch: Exception -> L12
        Object r8 = r7.get(this.$taskName);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L12
        ((AtomicReference) r8).set(AsyncTaskManager.a.C0151a.a);     // Catch: Exception -> L12
        Map<String, CountDownLatch> r9 = this.this$0.d;     // Catch: Exception -> L12
        LinkedHashMap r11 = (LinkedHashMap) r9;     // Catch: Exception -> L12
        Object r12 = r11.get(this.$taskName);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r12);     // Catch: Exception -> L12
        ((CountDownLatch) r12).countDown();     // Catch: Exception -> L12
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r5);     // Catch: Exception -> L12
    L18:
        Function1 r13 = this.$task;     // Catch: Exception -> L12
        this.label = 2;     // Catch: Exception -> L12
        if (r13.invoke(this) != r0) goto L21;
        return r0;
    L14:
        ResultKt.throwOnFailure(r5);
        Map<String, AtomicReference<AsyncTaskManager.a>> r14 = this.this$0.c;     // Catch: Exception -> L12
        LinkedHashMap r15 = (LinkedHashMap) r14;     // Catch: Exception -> L12
        Object r16 = r15.get(this.$taskName);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r16);     // Catch: Exception -> L12
        ((AtomicReference) r16).set(AsyncTaskManager.a.d.a);     // Catch: Exception -> L12
        Map<String, CountDownLatch> r17 = this.this$0.e;     // Catch: Exception -> L12
        LinkedHashMap r18 = (LinkedHashMap) r17;     // Catch: Exception -> L12
        Object r19 = r18.get(this.$taskName);     // Catch: Exception -> L12
        Intrinsics.checkNotNull(r19);     // Catch: Exception -> L12
        ((CountDownLatch) r19).countDown();     // Catch: Exception -> L12
        AsyncTaskManager r21 = this.this$0;     // Catch: Exception -> L12
        String r2 = this.$taskName;     // Catch: Exception -> L12
        this.label = 1;     // Catch: Exception -> L12
        if (r21.a(r2, this) != r0) goto L18;
        return r0;
    L12:
        e = move-exception;
        Map<String, AtomicReference<AsyncTaskManager.a>> r3 = this.this$0.c;
        LinkedHashMap r4 = (LinkedHashMap) r3;
        Object r22 = r4.get(this.$taskName);
        Intrinsics.checkNotNull(r22);
        ((AtomicReference) r22).set(new AsyncTaskManager.a.b(e));
        Map<String, CountDownLatch> r23 = this.this$0.d;
        LinkedHashMap r24 = (LinkedHashMap) r23;
        Object r25 = r24.get(this.$taskName);
        Intrinsics.checkNotNull(r25);
        ((CountDownLatch) r25).countDown();
        Map<String, CountDownLatch> r26 = this.this$0.e;
        LinkedHashMap r27 = (LinkedHashMap) r26;
        Object r28 = r27.get(this.$taskName);
        Intrinsics.checkNotNull(r28);
        ((CountDownLatch) r28).countDown();
        throw e;
    }
}
