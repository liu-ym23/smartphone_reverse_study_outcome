package androidx.lifecycle;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.l;
import kotlinx.coroutines.channels.n;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes.dex */
public final class FlowExtKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1, reason: invalid class name */
    @DebugMetadata(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", i = {0}, l = {91}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"})
    static final class AnonymousClass1<T> extends SuspendLambda implements Function2<l<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ Lifecycle.State $minActiveState;
        final /* synthetic */ kotlinx.coroutines.flow.c<T> $this_flowWithLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1, reason: invalid class name and collision with other inner class name */
        @DebugMetadata(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
        static final class C00171 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
            final /* synthetic */ l<T> $$this$callbackFlow;
            final /* synthetic */ kotlinx.coroutines.flow.c<T> $this_flowWithLifecycle;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            C00171(kotlinx.coroutines.flow.c<? extends T> r10, l<? super T> r11, Continuation<? super C00171> r12) {
                this.$this_flowWithLifecycle = r10;
                this.$$this$callbackFlow = r11;
                super(2, r12);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                return new C00171(this.$this_flowWithLifecycle, this.$$this$callbackFlow, r11);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
                return invoke2(r10, r11);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
                return ((C00171) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
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
                kotlinx.coroutines.flow.c<T> r13 = this.$this_flowWithLifecycle;
                final l<T> r14 = this.$$this$callbackFlow;
                kotlinx.coroutines.flow.d<? super T> r15 = new C00181(r14);
                this.label = 1;
                if (r13.a(r15, this) != r11) goto L12;
                return r11;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Lifecycle r10, Lifecycle.State r11, kotlinx.coroutines.flow.c<? extends T> r12, Continuation<? super AnonymousClass1> r13) {
            this.$lifecycle = r10;
            this.$minActiveState = r11;
            this.$this_flowWithLifecycle = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$lifecycle, this.$minActiveState, this.$this_flowWithLifecycle, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
            return invoke((l) r10, r11);
        }

        public final Object invoke(l<? super T> r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            l r13 = (l) this.L$0;
            ResultKt.throwOnFailure(r10);
        L12:
            n.a.a(r13, null, 1, null);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            l r14 = (l) this.L$0;
            Lifecycle r15 = this.$lifecycle;
            Lifecycle.State r16 = this.$minActiveState;
            C00171 r17 = new C00171(this.$this_flowWithLifecycle, r14, null);
            this.L$0 = r14;
            this.label = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(r15, r16, r17, this) != r11) goto L11;
            return r11;
        L11:
            r13 = r14;
            goto L12
        }
    }

    public static final <T> kotlinx.coroutines.flow.c<T> flowWithLifecycle(kotlinx.coroutines.flow.c<? extends T> r10, Lifecycle r11, Lifecycle.State r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "lifecycle");
        Intrinsics.checkNotNullParameter(r12, "minActiveState");
        return kotlinx.coroutines.flow.e.d(new AnonymousClass1(r11, r12, r10, null));
    }

    public static /* synthetic */ kotlinx.coroutines.flow.c flowWithLifecycle$default(kotlinx.coroutines.flow.c r10, Lifecycle r11, Lifecycle.State r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r12 = Lifecycle.State.STARTED;
    L6:
        return flowWithLifecycle(r10, r11, r12);
    }
}
