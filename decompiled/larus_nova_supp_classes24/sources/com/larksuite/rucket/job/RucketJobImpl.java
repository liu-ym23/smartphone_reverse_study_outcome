package com.larksuite.rucket.job;

import android.os.Looper;
import com.larksuite.component.ui.toast.LKUIToast;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.base.b;
import com.larksuite.rucket.job.extension.EmptyResultException;
import com.larksuite.rucket.job.extension.JobItrImpl;
import com.larksuite.rucket.job.impl.DataHolderRucketJob;
import com.larksuite.rucket.job.impl.ErrorHolderRucketJob;
import com.larksuite.rucket.job.impl.FutureRucketJob;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class RucketJobImpl<T> extends RucketJob<T> implements CoroutineScope {
    public static final a Companion = null;
    private static final String TAG = "RucketJob";
    private final Channel<b<T>> channel;
    private final ConcurrentLinkedQueue<Function2<b<? extends T>, Continuation<? super Unit>, Object>> consumerQueue;
    private final CoroutineContext coroutineContext;
    private Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> errorHandler;
    private final AtomicInteger idleConsumers;
    private int lastProduceIndex;
    private final ReentrantLock lock;
    private RucketJob<?> next;
    private ConcurrentLinkedQueue<b> pendingErrorBuffer;
    private ConcurrentLinkedQueue<b<T>> pendingResultBuffer;
    private RucketJob<?> prev;
    private Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> resolver;
    private final AtomicBoolean terminalFlag;

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$1", f = "RucketJobImpl.kt", i = {}, l = {72}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public AnonymousClass1(RucketJobImpl<T> r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            RucketJobImpl<T> r5 = this.this$0;
            this.label = 1;
            if (RucketJobImpl.access$consumeChannelData(r5, this) != r0) goto L12;
            return r0;
        }
    }

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$consumeChannelData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl", f = "RucketJobImpl.kt", i = {}, l = {446, 453, 457, 458}, m = "consumeChannelData", n = {}, s = {})
    public static final class C02361 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C02361(RucketJobImpl<T> r1, Continuation<? super C02361> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
            return RucketJobImpl.access$consumeChannelData(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$flatMap$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "data"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$flatMap$1", f = "RucketJobImpl.kt", i = {}, l = {235}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02371 extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super RucketJob<V>>, Object> $h;
        final /* synthetic */ FutureRucketJob<V> $nextJobDelegate;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C02371(Function2<? super T, ? super Continuation<? super RucketJob<V>>, ? extends Object> r1, FutureRucketJob<V> r2, Continuation<? super C02371> r3) {
            this.$h = r1;
            this.$nextJobDelegate = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            C02371 r0 = new C02371(this.$h, this.$nextJobDelegate, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(r1, (Continuation) r2);
        }

        public final Object invoke(T r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L11;
            if (r1 != 1) goto L10;
            ResultKt.throwOnFailure(r4);     // Catch: Exception -> L7
        L15:
            RucketJob r5 = (RucketJob) r4;     // Catch: Exception -> L7
        L18:
            this.$nextJobDelegate.b((RucketJob<V>) r5);
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r4);
            Object r6 = this.L$0;
            Function2<T, Continuation<? super RucketJob<V>>, Object> r2 = this.$h;     // Catch: Exception -> L7
            this.label = 1;     // Catch: Exception -> L7
            r4 = r2.invoke(r6, this);     // Catch: Exception -> L7
            if (r4 != r0) goto L15;
            return r0;
        L7:
            e = move-exception;
            Log.i(RucketJobImpl.TAG, "flatMap: there is an error occurred in IFlatMapHandler#invoke");
            r5 = new ErrorHolderRucketJob(e);
            goto L18
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$get$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larksuite/rucket/job/base/RucketResult;", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$get$1", f = "RucketJobImpl.kt", i = {}, l = {122}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02381 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super b<? extends T>>, Object> {
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C02381(RucketJobImpl<T> r1, Continuation<? super C02381> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02381(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super b<? extends T>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            RucketJobImpl<T> r5 = this.this$0;
            this.label = 1;
            r4 = r5.awaitGet(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [D] */
    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$map$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larksuite/rucket/job/RucketJob;", "D", "T", "data"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$map$1", f = "RucketJobImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02391<D> extends SuspendLambda implements Function2<T, Continuation<? super RucketJob<D>>, Object> {
        final /* synthetic */ Function1<T, D> $h;
        /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C02391(Function1<? super T, ? extends D> r1, Continuation<? super C02391> r2) {
            this.$h = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02391 r0 = new C02391(this.$h, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(r1, (Continuation) r2);
        }

        public final Object invoke(T r1, Continuation<? super RucketJob<D>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            Object r3 = this.L$0;
            return new DataHolderRucketJob(this.$h.invoke(r3));
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$onDataPrepared$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "it"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$onDataPrepared$1", f = "RucketJobImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02401 extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $action;
        final /* synthetic */ CoroutineContext $context;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$onDataPrepared$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$onDataPrepared$1$1", f = "RucketJobImpl.kt", i = {}, l = {426}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<T, Continuation<? super Unit>, Object> $action;
            final /* synthetic */ T $it;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public C00601(Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r1, T r2, Continuation<? super C00601> r3) {
                this.$action = r1;
                this.$it = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00601(this.$action, this.$it, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                Function2<T, Continuation<? super Unit>, Object> r5 = this.$action;
                T r2 = this.$it;
                this.label = 1;
                if (r5.invoke(r2, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C02401(RucketJobImpl<T> r1, CoroutineContext r2, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super C02401> r4) {
            this.this$0 = r1;
            this.$context = r2;
            this.$action = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C02401 r0 = new C02401(this.this$0, this.$context, this.$action, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(r1, (Continuation) r2);
        }

        public final Object invoke(T r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r7);
            Object r8 = this.L$0;
            BuildersKt.launch$default(this.this$0, this.$context, null, new C00601(this.$action, r8, null), 2, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$onDataPrepared$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$onDataPrepared$2", f = "RucketJobImpl.kt", i = {}, l = {430}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public AnonymousClass2(RucketJobImpl<T> r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass2(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            RucketJobImpl<T> r5 = this.this$0;
            this.label = 1;
            if (RucketJobImpl.access$produceAllResults(r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$onErrorOccurred$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$onErrorOccurred$1", f = "RucketJobImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02411 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<ErrorResult, Continuation<? super Unit>, Object> $action;
        final /* synthetic */ CoroutineContext $context;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$onErrorOccurred$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
        @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$onErrorOccurred$1$1", f = "RucketJobImpl.kt", i = {}, l = {438}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<ErrorResult, Continuation<? super Unit>, Object> $action;
            final /* synthetic */ ErrorResult $it;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public C00611(Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r1, ErrorResult r2, Continuation<? super C00611> r3) {
                this.$action = r1;
                this.$it = r2;
                super(2, r3);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                return new C00611(this.$action, this.$it, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r4) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r4);
            L12:
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r4);
                Function2<ErrorResult, Continuation<? super Unit>, Object> r5 = this.$action;
                ErrorResult r2 = this.$it;
                this.label = 1;
                if (r5.invoke(r2, this) != r0) goto L12;
                return r0;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C02411(RucketJobImpl<T> r1, CoroutineContext r2, Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super C02411> r4) {
            this.this$0 = r1;
            this.$context = r2;
            this.$action = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            C02411 r0 = new C02411(this.this$0, this.$context, this.$action, r6);
            r0.L$0 = r5;
            return r0;
        }

        public final Object invoke(ErrorResult r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ErrorResult) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r7);
            ErrorResult r8 = (ErrorResult) this.L$0;
            BuildersKt.launch$default(this.this$0, this.$context, null, new C00611(this.$action, r8, null), 2, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$onErrorOccurred$2, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$onErrorOccurred$2", f = "RucketJobImpl.kt", i = {}, l = {442}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02422 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C02422(RucketJobImpl<T> r1, Continuation<? super C02422> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new C02422(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            RucketJobImpl<T> r5 = this.this$0;
            this.label = 1;
            if (RucketJobImpl.access$produceAllErrors(r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$produceAllErrors$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl", f = "RucketJobImpl.kt", i = {}, l = {374}, m = "produceAllErrors", n = {}, s = {})
    public static final class C02431 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C02431(RucketJobImpl<T> r1, Continuation<? super C02431> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
            return RucketJobImpl.access$produceAllErrors(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$produceAllResults$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl", f = "RucketJobImpl.kt", i = {}, l = {359}, m = "produceAllResults", n = {}, s = {})
    public static final class C02441 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C02441(RucketJobImpl<T> r1, Continuation<? super C02441> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
            return RucketJobImpl.access$produceAllResults(this.this$0, this);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$setError$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl", f = "RucketJobImpl.kt", i = {0}, l = {337, 350}, m = "setError$suspendImpl", n = {"$this"}, s = {"L$0"})
    public static final class C02451<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C02451(RucketJobImpl<T> r1, Continuation<? super C02451> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
            return RucketJobImpl.setError$suspendImpl(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$setResult$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl", f = "RucketJobImpl.kt", i = {1}, l = {304, 315, 327}, m = "setResult$suspendImpl", n = {"$this"}, s = {"L$0"})
    public static final class C02461<T> extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C02461(RucketJobImpl<T> r1, Continuation<? super C02461> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= LKBaseResponseModel.DEFAULT_ERROR_CODE;
            return RucketJobImpl.setResult$suspendImpl(this.this$0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJobImpl$toFlow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJobImpl$toFlow$1", f = "RucketJobImpl.kt", i = {0, 1}, l = {268, 270}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
    public static final class C02471 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ RucketJobImpl<T> this$0;

        public C02471(RucketJobImpl<T> r1, Continuation<? super C02471> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02471 r0 = new C02471(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((FlowCollector) r1, (Continuation) r2);
        }

        public final Object invoke(FlowCollector<? super T> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0075 -> B:12:0x0041). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            com.larksuite.rucket.job.extension.a<b<T>> r2 = (com.larksuite.rucket.job.extension.a) this.L$1;
            FlowCollector r4 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r9);
        L11:
            C02471 r10 = this;
        L12:
            r10.L$0 = r4;
            r10.L$1 = r2;
            r10.label = 1;
            Object r5 = r2.hasNext(r10);
            if (r5 != r0) goto L15;
            return r0;
        L15:
            Object r7 = r0;
            C02471 r3 = r10;
            r9 = r5;
            FlowCollector r6 = r4;
            com.larksuite.rucket.job.extension.a<b<T>> r8 = r2;
            Object r11 = r7;
        L17:
            if (((Boolean) r9).booleanValue() == false) goto L31;
            b r12 = r8.a();
            if ((r12 instanceof b.c) == false) goto L25;
            T r13 = ((b.c) r12).b;
            r3.L$0 = r6;
            r3.L$1 = r8;
            r3.label = 2;
            if (r6.emit(r13, r3) != r11) goto L23;
            return r11;
        L23:
            r10 = r3;
            r0 = r11;
            r2 = r8;
            r4 = r6;
            goto L12
        L25:
            if ((r12 instanceof b.C0062b) == false) goto L29;
            throw ((b.C0062b) r12).b;
        L29:
            throw new NoWhenBranchMatchedException();
        L31:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            com.larksuite.rucket.job.extension.a<b<T>> r14 = (com.larksuite.rucket.job.extension.a) this.L$1;
            FlowCollector r15 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r9);
            r6 = r15;
            r8 = r14;
            r11 = r0;
            r3 = this;
            goto L17
        L10:
            ResultKt.throwOnFailure(r9);
            r4 = (FlowCollector) this.L$0;
            r2 = this.this$0.iterator();
            goto L11
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public Object awaitGet(Continuation<? super b<? extends T>> r1) {
        return awaitGet$suspendImpl(this, r1);
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public Object setError(ErrorResult r1, Continuation<? super Unit> r2) {
        return setError$suspendImpl(this, r1, r2);
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public Object setResult(T r1, Continuation<? super Unit> r2) {
        return setResult$suspendImpl(this, r1, r2);
    }

    private final boolean distributeAnIleConsumer() {
        int r0 = this.idleConsumers.get();
        if (r0 > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.idleConsumers.compareAndSet(r0, r0 - 1) == false) goto L7;
        return true;
    }

    private final b<T> produceNext() {
        int r0 = (this.lastProduceIndex + 1) % 2;
        this.lastProduceIndex = r0;
        if ((r0 % 2) != 0) goto L6;
        return this.pendingResultBuffer.poll();
    L6:
        return this.pendingErrorBuffer.poll();
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public void cancel() {
        if (this.terminalFlag.compareAndSet(false, true) == false) goto L11;
        Log.d(TAG, "rucketJob invoke cancel");
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineScope");
        CoroutineScopeKt.cancel$default(this, null, 1, null);
        this.resolver = null;
        this.errorHandler = null;
        this.pendingResultBuffer.clear();
        this.pendingErrorBuffer.clear();
        this.consumerQueue.clear();
        this.idleConsumers.set(0);
        RucketJob<?> r0 = nextJob();
        if (r0 == null) goto L7;
        r0.cancel();
    L7:
        RucketJob<?> r1 = prevJob();
        if (r1 == null) goto L12;
        r1.cancel();
        return;
    L12:
        return;
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public boolean isCanceled() {
        return this.terminalFlag.get();
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public com.larksuite.rucket.job.extension.a<b<T>> iterator() {
        return new JobItrImpl(this);
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public Flow<T> toFlow() {
        return new c1(new C02471(this, null));
    }

    public RucketJobImpl() {
        this.consumerQueue = new ConcurrentLinkedQueue();
        this.idleConsumers = new AtomicInteger(0);
        this.pendingResultBuffer = new ConcurrentLinkedQueue();
        this.pendingErrorBuffer = new ConcurrentLinkedQueue();
        this.terminalFlag = new AtomicBoolean(false);
        this.lock = new ReentrantLock();
        this.channel = ChannelKt.Channel$default(LKUIToast.DURATION_MAX, null, null, 6, null);
        this.coroutineContext = Dispatchers.getUnconfined().plus(SupervisorKt.SupervisorJob$default(null, 1, null));
        BuildersKt.launch$default(this, null, null, new AnonymousClass1(this, null), 3, null);
        this.lastProduceIndex = 1;
    }

    private final b<T> tryProduceImmediately() {
        b<T> r0 = produceNext();
        if (r0 == null) goto L5;
        return r0;
    L5:
        return produceNext();
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public b<T> get() {
        if (Intrinsics.areEqual(ThreadMethodProxy.currentThread(), ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) == true) goto L7;
        return (b) BuildersKt.runBlocking$default(null, new C02381(this, null), 1, null);
    L7:
        throw new Error("You should not call method 'get' on main thread , this action may block thw main thread and will cause ANR !!!");
    }

    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    public RucketJob<?> nextJob() {
        return this.next;
    }

    public RucketJob<?> prevJob() {
        return this.prev;
    }

    public static final /* synthetic */ ConcurrentLinkedQueue access$getConsumerQueue$p(RucketJobImpl r0) {
        return r0.consumerQueue;
    }

    public static final /* synthetic */ AtomicInteger access$getIdleConsumers$p(RucketJobImpl r0) {
        return r0.idleConsumers;
    }

    public static final /* synthetic */ ReentrantLock access$getLock$p(RucketJobImpl r0) {
        return r0.lock;
    }

    public static final /* synthetic */ b access$tryProduceImmediately(RucketJobImpl r0) {
        return r0.tryProduceImmediately();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008c -> B:21:0x0053). Please report as a decompilation issue!!! */
    private final Object consumeChannelData(Continuation<? super Unit> r13) {
        if ((r13 instanceof C02361) == false) goto L7;
        C02361 r0 = (C02361) r13;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L17;
        if (r3 == 3) goto L17;
        if (r3 == 4) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ChannelIterator r4 = (ChannelIterator) r0.L$0;
        ResultKt.throwOnFailure(r14);
        ChannelIterator r15 = r4;
    L20:
        RucketJobImpl<T> r5 = this;
    L21:
        r0.L$0 = r15;
        r0.label = 1;
        Object r7 = r15.hasNext(r0);
        if (r7 != r2) goto L24;
        return r2;
    L24:
        RucketJobImpl<T> r11 = r5;
        ChannelIterator r6 = r15;
        r14 = r7;
        RucketJobImpl<T> r8 = r11;
    L26:
        if (((Boolean) r14).booleanValue() == false) goto L46;
        b r16 = (b) r6.next();
        Function2<b<? extends T>, Continuation<? super Unit>, Object> r9 = r8.consumerQueue.poll();
        if (r9 == null) goto L34;
        Log.d(TAG, "consumeChannelData: There is a suspended coroutine is waiting for the result, now resume this coroutine");
        r0.L$0 = r6;
        r0.label = 2;
        if (r9.invoke(r16, r0) != r2) goto L32;
        return r2;
    L32:
        r15 = r6;
        r5 = r8;
        goto L21
    L34:
        if ((r16 instanceof b.c) == false) goto L39;
        T r17 = ((b.c) r16).b;
        r0.L$0 = r6;
        r0.label = 3;
        if (r8.handleConsumeResult(r17, r0) != r2) goto L32;
        return r2;
    L39:
        if ((r16 instanceof b.C0062b) == false) goto L44;
        ErrorResult r19 = ((b.C0062b) r16).b;
        r0.L$0 = r6;
        r0.label = 4;
        if (r8.handleConsumeError(r19, r0) != r2) goto L32;
        return r2;
    L44:
        throw new NoWhenBranchMatchedException();
    L46:
        return Unit.INSTANCE;
    L18:
        r6 = (ChannelIterator) r0.L$0;
        ResultKt.throwOnFailure(r14);
        r8 = this;
        goto L26
    L19:
        ResultKt.throwOnFailure(r14);
        r15 = this.channel.iterator();
    L7:
        r0 = new C02361(this, r13);
        goto L8
    }

    private final Object produceAllErrors(Continuation<? super Unit> r5) {
        if ((r5 instanceof C02431) == false) goto L7;
        C02431 r0 = (C02431) r5;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 == 1) goto L14;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
    L16:
        if (this.pendingErrorBuffer.isEmpty() == true) goto L21;
        r0.label = 1;
        if (produceErrorOnce(r0) != r2) goto L16;
        return r2;
    L21:
        return Unit.INSTANCE;
    L7:
        r0 = new C02431(this, r5);
        goto L8
    }

    private final Object produceAllResults(Continuation<? super Unit> r5) {
        if ((r5 instanceof C02441) == false) goto L7;
        C02441 r0 = (C02441) r5;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 == 1) goto L14;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
    L16:
        if (this.pendingResultBuffer.isEmpty() == true) goto L21;
        distributeAnIleConsumer();
        r0.label = 1;
        if (produceResultOnce(r0) != r2) goto L16;
        return r2;
    L21:
        return Unit.INSTANCE;
    L7:
        r0 = new C02441(this, r5);
        goto L8
    }

    private final Object produceErrorOnce(Continuation<? super Unit> r3) {
        b r0 = this.pendingErrorBuffer.poll();
        if (r0 == null) goto L8;
        Object r4 = this.channel.send(r0, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r4;
    L8:
        return Unit.INSTANCE;
    }

    private final Object produceResultOnce(Continuation<? super Unit> r3) {
        b<T> r0 = this.pendingResultBuffer.poll();
        if (r0 == null) goto L8;
        Object r4 = this.channel.send(r0, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r4;
    L8:
        return Unit.INSTANCE;
    }

    @Override // com.larksuite.rucket.job.base.a
    public void setNextJob(RucketJob<?> r1) {
        this.next = r1;
    }

    @Override // com.larksuite.rucket.job.base.a
    public void setPrevJob(RucketJob<?> r1) {
        this.prev = r1;
    }

    public static final /* synthetic */ Object access$consumeChannelData(RucketJobImpl r0, Continuation r1) {
        return r0.consumeChannelData(r1);
    }

    public static final /* synthetic */ Object access$produceAllErrors(RucketJobImpl r0, Continuation r1) {
        return r0.produceAllErrors(r1);
    }

    public static final /* synthetic */ Object access$produceAllResults(RucketJobImpl r0, Continuation r1) {
        return r0.produceAllResults(r1);
    }

    public static final /* synthetic */ Object access$produceErrorOnce(RucketJobImpl r0, Continuation r1) {
        return r0.produceErrorOnce(r1);
    }

    public static final /* synthetic */ Object access$produceResultOnce(RucketJobImpl r0, Continuation r1) {
        return r0.produceResultOnce(r1);
    }

    public static <T> Object awaitGet$suspendImpl(final RucketJobImpl<T> r5, Continuation<? super b<? extends T>> r6) {
        if (r5.isCanceled() == false) goto L6;
        int r7 = b.a;
        return new b.C0062b(new ErrorResult("RucketJob has been canceled!"));
    L6:
        final j r0 = new j(IntrinsicsKt.intercepted(r6), 1);
        r0.C();
        access$getLock$p(r5).lock();     // Catch: Throwable -> L20
        final b r1 = access$tryProduceImmediately(r5);     // Catch: Throwable -> L20
        if (r1 == null) goto L11;
        Log.d(TAG, "awaitGet: pending result is not null, now return it directly.");     // Catch: Throwable -> L20
        Function0<Unit> r2 = new RucketJobImpl$awaitGet$2$1(r0, r1);     // Catch: Throwable -> L20
    L13:
        access$getLock$p(r5).unlock();
        if (r2 == null) goto L16;
        r2.invoke();
    L16:
        Object r8 = r0.B();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L19;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L19:
        return r8;
    L11:
        access$getIdleConsumers$p(r5).incrementAndGet();     // Catch: Throwable -> L20
        access$getConsumerQueue$p(r5).add(new RucketJobImpl$awaitGet$2$2(r0, null));     // Catch: Throwable -> L20
        r0.i(new RucketJobImpl$awaitGet$2$3(r5));     // Catch: Throwable -> L20
        Log.d(TAG, "awaitGet: pending result is null, now suspend current coroutine.");     // Catch: Throwable -> L20
        r2 = null;
    L20:
        th = move-exception;
        access$getLock$p(r5).unlock();
        throw th;
    }

    private final Object handleConsumeError(ErrorResult r2, Continuation<? super Unit> r3) {
        Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r0 = this.errorHandler;
        if (r0 == null) goto L10;
        if (r0 == null) goto L18;
        Object r4 = r0.invoke(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L9;
        return r4;
    L9:
        return Unit.INSTANCE;
    L18:
        return Unit.INSTANCE;
    L10:
        RucketJob<?> r1 = nextJob();
        if (r1 == null) goto L18;
        Object r5 = r1.setError(r2, r3);
        if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L16;
        return r5;
    L16:
        return Unit.INSTANCE;
    }

    private final Object handleConsumeResult(T r2, Continuation<? super Unit> r3) {
        Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r0 = this.resolver;
        if (r0 == null) goto L10;
        Object r4 = r0.invoke(r2, r3);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r4;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    private final void onDataPrepared(CoroutineContext r9, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r10) {
        if (isCanceled() == false) goto L5;
        return;
    L5:
        this.resolver = new C02401(this, r9, r10, null);
        BuildersKt.launch$default(this, null, null, new AnonymousClass2(this, null), 3, null);
    }

    private final void onErrorOccurred(CoroutineContext r9, Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r10) {
        if (isCanceled() == false) goto L5;
        return;
    L5:
        this.errorHandler = new C02411(this, r9, r10, null);
        BuildersKt.launch$default(this, null, null, new C02422(this, null), 3, null);
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public RucketJob<T> error(CoroutineContext r3, Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "h");
        onErrorOccurred(r3, new RucketJobImpl$error$1$1(r4, null));
        return this;
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public <V> RucketJob<V> flatMap(CoroutineContext r4, Function2<? super T, ? super Continuation<? super RucketJob<V>>, ? extends Object> r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "h");
        FutureRucketJob r0 = new FutureRucketJob();
        setNextJob(r0);
        r0.setPrevJob(this);
        onDataPrepared(r4, new C02371(r5, r0, null));
        return r0;
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public <D> RucketJob<D> map(CoroutineContext r3, Function1<? super T, ? extends D> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "h");
        return (RucketJob<D>) flatMap(r3, new C02391(r4, null));
    }

    @Override // com.larksuite.rucket.job.RucketJob
    public RucketJob<T> then(CoroutineContext r3, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "h");
        onDataPrepared(r3, new RucketJobImpl$then$1$1(r4, null));
        return this;
    }

    public static final /* synthetic */ Object access$handleConsumeError(RucketJobImpl r0, ErrorResult r1, Continuation r2) {
        return r0.handleConsumeError(r1, r2);
    }

    public static final /* synthetic */ Object access$handleConsumeResult(RucketJobImpl r0, Object r1, Continuation r2) {
        return r0.handleConsumeResult(r1, r2);
    }

    public static /* synthetic */ <T> Object setError$suspendImpl(RucketJobImpl<T> r5, ErrorResult r6, Continuation<? super Unit> r7) {
        if ((r7 instanceof C02451) == false) goto L7;
        C02451 r0 = (C02451) r7;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r8);
    L41:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r5 = (RucketJobImpl) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L42
    L28:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L42
        ((RucketJobImpl) r5).lock.unlock();
        return r9;
    L18:
        ResultKt.throwOnFailure(r8);
        if (r5.isCanceled() == true) goto L21;
        ((RucketJobImpl) r5).lock.lock();     // Catch: Throwable -> L42
        ((RucketJobImpl) r5).pendingErrorBuffer.add(new b.C0062b(r6));     // Catch: Throwable -> L42
        if (r5.distributeAnIleConsumer() == false) goto L31;
        Log.d(TAG, "setResult: There is a suspended coroutine is waiting for the error, produce once.");     // Catch: Throwable -> L42
        r0.L$0 = r5;     // Catch: Throwable -> L42
        r0.label = 1;     // Catch: Throwable -> L42
        if (r5.produceErrorOnce(r0) != r2) goto L28;
        return r2;
    L31:
        ((RucketJobImpl) r5).lock.unlock();
        if (((RucketJobImpl) r5).errorHandler == null) goto L34;
    L37:
        r0.label = 2;
        if (r5.produceAllErrors(r0) != r2) goto L41;
        return r2;
    L34:
        if (r5.nextJob() != null) goto L37;
        Log.d(TAG, "setError: There is no resolver and also next job is null, just return.");
        return Unit.INSTANCE;
    L21:
        return Unit.INSTANCE;
    L42:
        th = move-exception;
        ((RucketJobImpl) r5).lock.unlock();
        throw th;
    L7:
        r0 = new C02451(r5, r7);
        goto L8
    }

    public static /* synthetic */ <T> Object setResult$suspendImpl(RucketJobImpl<T> r7, T r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof C02461) == false) goto L7;
        C02461 r0 = (C02461) r9;
        int r1 = r0.label;
        if ((r1 & LKBaseResponseModel.DEFAULT_ERROR_CODE) == 0) goto L7;
        r0.label = r1 - LKBaseResponseModel.DEFAULT_ERROR_CODE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L21;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        ResultKt.throwOnFailure(r10);
    L46:
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r7 = (RucketJobImpl) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L19
    L38:
        ((RucketJobImpl) r7).lock.unlock();
        if (((RucketJobImpl) r7).resolver != null) goto L42;
        Log.d(TAG, "setResult: There is no resolver, just return.");
        return Unit.INSTANCE;
    L42:
        r0.L$0 = null;
        r0.label = 3;
        if (r7.produceAllResults(r0) != r2) goto L46;
        return r2;
    L21:
        ResultKt.throwOnFailure(r10);
    L28:
        return Unit.INSTANCE;
    L22:
        ResultKt.throwOnFailure(r10);
        if (r8 != null) goto L30;
        EmptyResultException r11 = new EmptyResultException();
        r0.label = 1;
        if (r7.setError(r11, r0) != r2) goto L28;
        return r2;
    L30:
        if (r7.isCanceled() == true) goto L32;
        ((RucketJobImpl) r7).lock.lock();     // Catch: Throwable -> L19
        ((RucketJobImpl) r7).pendingResultBuffer.add(new b.c(r8));     // Catch: Throwable -> L19
        if (r7.distributeAnIleConsumer() == false) goto L38;
        Log.d(TAG, "setResult: There is a suspended coroutine is waiting for the result, produce once.");     // Catch: Throwable -> L19
        r0.L$0 = r7;     // Catch: Throwable -> L19
        r0.label = 2;     // Catch: Throwable -> L19
        if (r7.produceResultOnce(r0) != r2) goto L38;
        return r2;
    L32:
        return Unit.INSTANCE;
    L19:
        th = move-exception;
        ((RucketJobImpl) r7).lock.unlock();
        throw th;
    L7:
        r0 = new C02461(r7, r9);
        goto L8
    }
}
