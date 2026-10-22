package com.larus.project;

import com.larus.bmhome.taskskill.service.IProjectListDataSource;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.project.TaskProjectFragment$loadNextPage$1", f = "TaskProjectFragment.kt", i = {}, l = {409}, m = "invokeSuspend", n = {}, s = {})
public final class TaskProjectFragment$loadNextPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IProjectListDataSource $dataSource;
    int label;
    final /* synthetic */ TaskProjectFragment this$0;

    public TaskProjectFragment$loadNextPage$1(IProjectListDataSource r1, TaskProjectFragment r2, Continuation<? super TaskProjectFragment$loadNextPage$1> r3) {
        this.$dataSource = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TaskProjectFragment$loadNextPage$1(this.$dataSource, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
        Object r6 = ((Result) r5).unbox-impl();
    L11:
        TaskProjectFragment r2 = this.this$0;
        r2.l = false;
        if (Result.isSuccess-impl(r6) == false) goto L14;
        TaskProjectFragment.X90(r2, (com.larus.bmhome.taskskill.service.i) r6, false, true);
    L14:
        TaskProjectFragment r3 = this.this$0;
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L18;
        FLogger.a.e("TaskProjectFragment", "load project page failed", r7);
        r3.ca0();
    L18:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        IProjectListDataSource r8 = this.$dataSource;
        this.label = 1;
        r6 = r8.d(this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
