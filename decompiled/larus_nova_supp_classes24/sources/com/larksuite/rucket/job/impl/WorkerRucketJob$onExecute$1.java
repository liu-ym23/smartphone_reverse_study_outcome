package com.larksuite.rucket.job.impl;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.extension.EmptyResultException;
import com.larus.audio.call.dora.CommandStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larksuite.rucket.job.impl.WorkerRucketJob$onExecute$1", f = "WorkerRucketJob.kt", i = {0}, l = {CommandStatus.DORA_WEARABLE_INTERACT_INTENTION, 33, CommandStatus.DORA_NOTIFICATION_SUMMARY_NEED_REPLY}, m = "invokeSuspend", n = {"errorResult"}, s = {"L$0"})
final class WorkerRucketJob$onExecute$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ a<Object> this$0;

    /* JADX INFO: renamed from: com.larksuite.rucket.job.impl.WorkerRucketJob$onExecute$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.impl.WorkerRucketJob$onExecute$1$1", f = "WorkerRucketJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<Object>, Object> {
        int label;
        final /* synthetic */ a<Object> this$0;

        public AnonymousClass1(a<Object> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<Object> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            return this.this$0.a.invoke();
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public WorkerRucketJob$onExecute$1(a<Object> r1, Continuation<? super WorkerRucketJob$onExecute$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new WorkerRucketJob$onExecute$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r9);
    L28:
        return Unit.INSTANCE;
    L11:
        ErrorResult r2 = (ErrorResult) this.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L18
    L29:
    L20:
        if (r9 == null) goto L24;
        a<Object> r3 = this.this$0;
        this.L$0 = null;
        this.label = 2;
        if (r3.setResult(r9, this) != r0) goto L28;
        return r0;
    L24:
        a<Object> r10 = this.this$0;
        this.L$0 = null;
        this.label = 3;
        if (r10.setError(r2, this) != r0) goto L28;
        return r0;
    L14:
        ResultKt.throwOnFailure(r9);
        r2 = new EmptyResultException();
        CoroutineDispatcher r11 = Dispatchers.getIO();     // Catch: Exception -> L18
        AnonymousClass1 r6 = new AnonymousClass1(this.this$0, null);     // Catch: Exception -> L18
        this.L$0 = r2;     // Catch: Exception -> L18
        this.label = 1;     // Catch: Exception -> L18
        r9 = BuildersKt.withContext(r11, r6, this);     // Catch: Exception -> L18
        if (r9 != r0) goto L29;
        return r0;
    L18:
        e = move-exception;
        r2 = new ErrorResult(e);
        r9 = null;
        goto L20
    }
}
