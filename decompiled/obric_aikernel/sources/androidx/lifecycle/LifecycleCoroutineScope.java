package androidx.lifecycle;

import kotlin.Deprecated;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes.dex */
public abstract class LifecycleCoroutineScope implements l0 {

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1, reason: invalid class name */
    @DebugMetadata(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.kt", i = {}, l = {337}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<l0, Continuation<? super Unit>, Object> $block;
        int label;
        final /* synthetic */ LifecycleCoroutineScope this$0;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(LifecycleCoroutineScope r10, Function2<? super l0, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super AnonymousClass1> r12) {
            this.this$0 = r10;
            this.$block = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.this$0, this.$block, r11);
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
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            Lifecycle r13 = this.this$0.getLifecycle$lifecycle_common();
            Function2<l0, Continuation<? super Unit>, Object> r14 = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.whenCreated(r13, r14, this) != r11) goto L12;
            return r11;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1", f = "Lifecycle.kt", i = {}, l = {375}, m = "invokeSuspend", n = {}, s = {})
    static final class C03361 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<l0, Continuation<? super Unit>, Object> $block;
        int label;
        final /* synthetic */ LifecycleCoroutineScope this$0;

        /* JADX WARN: Multi-variable type inference failed */
        C03361(LifecycleCoroutineScope r10, Function2<? super l0, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super C03361> r12) {
            this.this$0 = r10;
            this.$block = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C03361(this.this$0, this.$block, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((C03361) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            Lifecycle r13 = this.this$0.getLifecycle$lifecycle_common();
            Function2<l0, Continuation<? super Unit>, Object> r14 = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.whenResumed(r13, r14, this) != r11) goto L12;
            return r11;
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, s = {})
    static final class C03371 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<l0, Continuation<? super Unit>, Object> $block;
        int label;
        final /* synthetic */ LifecycleCoroutineScope this$0;

        /* JADX WARN: Multi-variable type inference failed */
        C03371(LifecycleCoroutineScope r10, Function2<? super l0, ? super Continuation<? super Unit>, ? extends Object> r11, Continuation<? super C03371> r12) {
            this.this$0 = r10;
            this.$block = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new C03371(this.this$0, this.$block, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((C03371) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            ResultKt.throwOnFailure(r10);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            Lifecycle r13 = this.this$0.getLifecycle$lifecycle_common();
            Function2<l0, Continuation<? super Unit>, Object> r14 = this.$block;
            this.label = 1;
            if (PausingDispatcherKt.whenStarted(r13, r14, this) != r11) goto L12;
            return r11;
        }
    }

    public LifecycleCoroutineScope() {
    }

    @Override // kotlinx.coroutines.l0
    public abstract /* synthetic */ CoroutineContext getCoroutineContext();

    public abstract Lifecycle getLifecycle$lifecycle_common();

    @Deprecated(message = "launchWhenCreated is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.CREATED.")
    public final v1 launchWhenCreated(Function2<? super l0, ? super Continuation<? super Unit>, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        return h.d(this, null, null, new AnonymousClass1(this, r10, null), 3, null);
    }

    @Deprecated(message = "launchWhenResumed is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.RESUMED.")
    public final v1 launchWhenResumed(Function2<? super l0, ? super Continuation<? super Unit>, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        return h.d(this, null, null, new C03361(this, r10, null), 3, null);
    }

    @Deprecated(message = "launchWhenStarted is deprecated as it can lead to wasted resources in some cases. Replace with suspending repeatOnLifecycle to run the block whenever the Lifecycle state is at least Lifecycle.State.STARTED.")
    public final v1 launchWhenStarted(Function2<? super l0, ? super Continuation<? super Unit>, ? extends Object> r10) {
        Intrinsics.checkNotNullParameter(r10, "block");
        return h.d(this, null, null, new C03371(this, r10, null), 3, null);
    }
}
