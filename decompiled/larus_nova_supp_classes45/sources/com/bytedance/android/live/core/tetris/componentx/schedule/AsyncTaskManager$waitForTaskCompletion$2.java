package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.log.ALogger;
import java.util.LinkedHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.core.tetris.componentx.schedule.AsyncTaskManager$waitForTaskCompletion$2", f = "AsyncTaskManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AsyncTaskManager$waitForTaskCompletion$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $taskName;
    int label;
    final /* synthetic */ AsyncTaskManager this$0;

    public AsyncTaskManager$waitForTaskCompletion$2(AsyncTaskManager r1, String r2, Continuation r3) {
        this.this$0 = r1;
        this.$taskName = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new AsyncTaskManager$waitForTaskCompletion$2(this.this$0, this.$taskName, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        Object r3 = ((LinkedHashMap) this.this$0.d).get(this.$taskName);
        Intrinsics.checkNotNull(r3);
        ((CountDownLatch) r3).await();
        Object r4 = ((LinkedHashMap) this.this$0.c).get(this.$taskName);
        Intrinsics.checkNotNull(r4);
        AsyncTaskManager.a r5 = (AsyncTaskManager.a) ((AtomicReference) r4).get();
        if ((r5 instanceof AsyncTaskManager.a.b) == true) goto L9;
        ALogger.i("AsyncTaskManager_Components", "被依赖的任务 " + this.$taskName + " 执行完成");
        return Unit.INSTANCE;
    L9:
        throw ((AsyncTaskManager.a.b) r5).a;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
