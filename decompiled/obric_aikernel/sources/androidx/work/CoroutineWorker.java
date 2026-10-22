package androidx.work;

import android.content.Context;
import androidx.work.impl.utils.futures.SettableFuture;
import java.util.concurrent.ExecutionException;
import kotlin.Deprecated;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.y1;
import kotlinx.coroutines.z;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    private final CoroutineDispatcher coroutineContext;
    private final SettableFuture<ListenableWorker.Result> future;
    private final z job;

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$getForegroundInfoAsync$1, reason: invalid class name */
    @DebugMetadata(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ JobListenableFuture<ForegroundInfo> $jobFuture;
        Object L$0;
        int label;
        final /* synthetic */ CoroutineWorker this$0;

        AnonymousClass1(JobListenableFuture<ForegroundInfo> r10, CoroutineWorker r11, Continuation<? super AnonymousClass1> r12) {
            this.$jobFuture = r10;
            this.this$0 = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$jobFuture, this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            JobListenableFuture r13 = (JobListenableFuture) this.L$0;
            ResultKt.throwOnFailure(r10);
        L12:
            r13.complete(r10);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            JobListenableFuture<ForegroundInfo> r14 = this.$jobFuture;
            CoroutineWorker r15 = this.this$0;
            this.L$0 = r14;
            this.label = 1;
            Object r16 = r15.getForegroundInfo(this);
            if (r16 != r11) goto L11;
            return r11;
        L11:
            r10 = r16;
            r13 = r14;
            goto L12
        }
    }

    /* JADX INFO: renamed from: androidx.work.CoroutineWorker$startWork$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    static final class C03421 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoroutineWorker this$0;

        C03421(CoroutineWorker r10, Continuation<? super C03421> r11) {
            this.this$0 = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C03421(this.this$0, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((C03421) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L11;
            if (r12 != 1) goto L10;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L7
        L15:
            SettableFuture<ListenableWorker.Result> r13 = this.this$0.getFuture$work_runtime_ktx_release();     // Catch: Throwable -> L7
            r13.set((ListenableWorker.Result) r10);     // Catch: Throwable -> L7
        L19:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r10);
            CoroutineWorker r14 = this.this$0;     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r10 = r14.doWork(this);     // Catch: Throwable -> L7
            if (r10 != r11) goto L15;
            return r11;
        L7:
            th = move-exception;
            this.this$0.getFuture$work_runtime_ktx_release().setException(th);
            goto L19
        }
    }

    public CoroutineWorker(Context r10, WorkerParameters r11) {
        Intrinsics.checkNotNullParameter(r10, "appContext");
        Intrinsics.checkNotNullParameter(r11, "params");
        super(r10, r11);
        this.job = y1.b(null, 1, null);
        SettableFuture<ListenableWorker.Result> r12 = SettableFuture.create();
        Intrinsics.checkNotNullExpressionValue(r12, "create()");
        this.future = r12;
        r12.addListener(new b(this), getTaskExecutor().getSerialTaskExecutor());
        this.coroutineContext = z0.a();
    }

    private static final void _init_$lambda$0(CoroutineWorker r10) {
        Intrinsics.checkNotNullParameter(r10, "this$0");
        if (r10.future.isCancelled() == false) goto L6;
        v1.a.a(r10.job, null, 1, null);
        return;
    }

    public static /* synthetic */ void a(CoroutineWorker r10) {
        _init_$lambda$0(r10);
    }

    @Deprecated(message = "use withContext(...) inside doWork() instead.")
    public static /* synthetic */ void getCoroutineContext$annotations() {
    }

    static /* synthetic */ Object getForegroundInfo$suspendImpl(CoroutineWorker r10, Continuation<? super ForegroundInfo> r11) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object doWork(Continuation<? super ListenableWorker.Result> r10);

    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object getForegroundInfo(Continuation<? super ForegroundInfo> r10) {
        return getForegroundInfo$suspendImpl(this, r10);
    }

    @Override // androidx.work.ListenableWorker
    public final c6.a<ForegroundInfo> getForegroundInfoAsync() {
        z r10 = y1.b(null, 1, null);
        l0 r11 = m0.a(getCoroutineContext().plus(r10));
        JobListenableFuture r12 = new JobListenableFuture(r10, null, 2, null);
        h.d(r11, null, null, new AnonymousClass1(r12, this, null), 3, null);
        return r12;
    }

    public final SettableFuture<ListenableWorker.Result> getFuture$work_runtime_ktx_release() {
        return this.future;
    }

    public final z getJob$work_runtime_ktx_release() {
        return this.job;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    public final Object setForeground(ForegroundInfo r10, Continuation<? super Unit> r11) {
        c6.a<Void> r12 = setForegroundAsync(r10);
        Intrinsics.checkNotNullExpressionValue(r12, "setForegroundAsync(foregroundInfo)");
        if (r12.isDone() == true) goto L20;
        o r13 = new o(IntrinsicsKt.intercepted(r11), 1);
        r13.F();
        r12.addListener(new ListenableFutureKt$await$2$1(r13, r12), DirectExecutor.INSTANCE);
        r13.h(new ListenableFutureKt$await$2$2(r12));
        Object r14 = r13.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L16:
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        return r14;
    L19:
        return Unit.INSTANCE;
    L20:
        r12.get();     // Catch: ExecutionException -> L6
    L6:
        e = move-exception;
        Throwable r15 = e.getCause();
        if (r15 != null) goto L11;
        throw e;
    L11:
        throw r15;
    }

    public final Object setProgress(Data r10, Continuation<? super Unit> r11) {
        c6.a<Void> r12 = setProgressAsync(r10);
        Intrinsics.checkNotNullExpressionValue(r12, "setProgressAsync(data)");
        if (r12.isDone() == true) goto L20;
        o r13 = new o(IntrinsicsKt.intercepted(r11), 1);
        r13.F();
        r12.addListener(new ListenableFutureKt$await$2$1(r13, r12), DirectExecutor.INSTANCE);
        r13.h(new ListenableFutureKt$await$2$2(r12));
        Object r14 = r13.B();
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        DebugProbesKt.probeCoroutineSuspended(r11);
    L16:
        if (r14 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        return r14;
    L19:
        return Unit.INSTANCE;
    L20:
        r12.get();     // Catch: ExecutionException -> L6
    L6:
        e = move-exception;
        Throwable r15 = e.getCause();
        if (r15 != null) goto L11;
        throw e;
    L11:
        throw r15;
    }

    @Override // androidx.work.ListenableWorker
    public final c6.a<ListenableWorker.Result> startWork() {
        h.d(m0.a(getCoroutineContext().plus(this.job)), null, null, new C03421(this, null), 3, null);
        return this.future;
    }
}
