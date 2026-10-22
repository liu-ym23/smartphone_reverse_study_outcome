package com.larksuite.rucket.job;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.job.base.a;
import com.larksuite.rucket.job.compat.b;
import com.larksuite.rucket.job.compat.c;
import com.larksuite.rucket.job.compat.d;
import com.larksuite.rucket.job.compat.e;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class RucketJob<T> implements a<RucketJob<?>> {

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJob$error$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larksuite/framework/callback/Entity/ErrorResult;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJob$error$1", f = "RucketJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ErrorResult, Continuation<? super Unit>, Object> {
        final /* synthetic */ b<T> $h;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ RucketJob<T> this$0;

        public AnonymousClass1(b<T> r1, RucketJob<T> r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(null, this.this$0, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(ErrorResult r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((ErrorResult) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L5;
            ResultKt.throwOnFailure(r2);
            ErrorResult r3 = (ErrorResult) this.L$0;
            throw null;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V] */
    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJob$flatMap$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larksuite/rucket/job/RucketJob;", "V", "T", "it"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJob$flatMap$1", f = "RucketJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02331<V> extends SuspendLambda implements Function2<T, Continuation<? super RucketJob<V>>, Object> {
        final /* synthetic */ d<T, V> $h;
        /* synthetic */ Object L$0;
        int label;

        public C02331(d<T, V> r1, Continuation<? super C02331> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02331 r0 = new C02331(null, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(r1, (Continuation) r2);
        }

        public final Object invoke(T r1, Continuation<? super RucketJob<V>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L5;
            ResultKt.throwOnFailure(r2);
            throw null;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.RucketJob$then$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "", "T", "it"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    @DebugMetadata(c = "com.larksuite.rucket.job.RucketJob$then$1", f = "RucketJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02351 extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
        final /* synthetic */ e<T> $h;
        /* synthetic */ Object L$0;
        int label;

        public C02351(e<T> r1, Continuation<? super C02351> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            C02351 r0 = new C02351(null, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(r1, (Continuation) r2);
        }

        public final Object invoke(T r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L5;
            ResultKt.throwOnFailure(r2);
            throw null;
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public RucketJob() {
    }

    public abstract Object awaitGet(Continuation<? super com.larksuite.rucket.job.base.b<? extends T>> r1);

    public abstract void cancel();

    public final RucketJob<T> error(b<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "h");
        return error$default(this, null, r3, 1, null);
    }

    public abstract RucketJob<T> error(CoroutineContext r1, Function2<? super ErrorResult, ? super Continuation<? super Unit>, ? extends Object> r2);

    public final <V> RucketJob<V> flatMap(d<T, V> r3) {
        Intrinsics.checkNotNullParameter(r3, "h");
        return flatMap$default(this, null, r3, 1, null);
    }

    public abstract <U> RucketJob<U> flatMap(CoroutineContext r1, Function2<? super T, ? super Continuation<? super RucketJob<U>>, ? extends Object> r2);

    public abstract com.larksuite.rucket.job.base.b<T> get();

    public abstract boolean isCanceled();

    public abstract com.larksuite.rucket.job.extension.a<com.larksuite.rucket.job.base.b<T>> iterator();

    public final <D> RucketJob<D> map(c<T, D> r3) {
        Intrinsics.checkNotNullParameter(r3, "h");
        return map$default(this, null, r3, 1, null);
    }

    public abstract <D> RucketJob<D> map(CoroutineContext r1, Function1<? super T, ? extends D> r2);

    public abstract Object setError(ErrorResult r1, Continuation<? super Unit> r2);

    public abstract Object setResult(T r1, Continuation<? super Unit> r2);

    public final RucketJob<T> then(e<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "h");
        return then$default(this, null, r3, 1, null);
    }

    public abstract RucketJob<T> then(CoroutineContext r1, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> r2);

    public abstract Flow<T> toFlow();

    public final RucketJob<T> error(CoroutineContext r3, b<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "h");
        return error(r3, new AnonymousClass1(r4, this, null));
    }

    public final <V> RucketJob<V> flatMap(CoroutineContext r3, d<T, V> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "h");
        return (RucketJob<V>) flatMap(r3, new C02331(r4, null));
    }

    public final <D> RucketJob<D> map(CoroutineContext r2, final c<T, D> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "h");
        return map(r2, new C02341(r3));
    }

    public final RucketJob<T> then(CoroutineContext r3, e<T> r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "h");
        return then(r3, new C02351(r4, null));
    }

    public static /* synthetic */ RucketJob error$default(RucketJob r0, CoroutineContext r1, b r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r1 = Dispatchers.getUnconfined();
    L7:
        return r0.error(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
    }

    public static /* synthetic */ RucketJob flatMap$default(RucketJob r0, CoroutineContext r1, d r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r1 = Dispatchers.getUnconfined();
    L7:
        return r0.flatMap(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatMap");
    }

    public static /* synthetic */ RucketJob map$default(RucketJob r0, CoroutineContext r1, c r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r1 = Dispatchers.getUnconfined();
    L7:
        return r0.map(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: map");
    }

    public static /* synthetic */ RucketJob then$default(RucketJob r0, CoroutineContext r1, e r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r1 = Dispatchers.getUnconfined();
    L7:
        return r0.then(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: then");
    }

    public static /* synthetic */ RucketJob error$default(RucketJob r0, CoroutineContext r1, Function2 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r1 = Dispatchers.getUnconfined();
    L7:
        return r0.error(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: error");
    }

    public static /* synthetic */ RucketJob flatMap$default(RucketJob r0, CoroutineContext r1, Function2 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r1 = Dispatchers.getUnconfined();
    L7:
        return r0.flatMap(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: flatMap");
    }

    public static /* synthetic */ RucketJob map$default(RucketJob r0, CoroutineContext r1, Function1 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r1 = Dispatchers.getUnconfined();
    L7:
        return r0.map(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: map");
    }

    public static /* synthetic */ RucketJob then$default(RucketJob r0, CoroutineContext r1, Function2 r2, int r3, Object r4) {
        if (r4 != null) goto L9;
        if ((r3 & 1) == 0) goto L7;
        r1 = Dispatchers.getUnconfined();
    L7:
        return r0.then(r1, r2);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: then");
    }
}
