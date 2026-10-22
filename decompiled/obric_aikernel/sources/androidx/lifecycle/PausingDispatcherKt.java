package androidx.lifecycle;

import com.obric.aikernel.core.data.IdlErrors;
import kotlin.Deprecated;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.v1;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes.dex */
public final class PausingDispatcherKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2, reason: invalid class name */
    @DebugMetadata(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0}, l = {IdlErrors.E_InstalledModelDecryptFailed}, m = "invokeSuspend", n = {"controller"}, s = {"L$0"})
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<l0, Continuation<? super T>, Object> {
        final /* synthetic */ Function2<l0, Continuation<? super T>, Object> $block;
        final /* synthetic */ Lifecycle.State $minState;
        final /* synthetic */ Lifecycle $this_whenStateAtLeast;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Lifecycle r10, Lifecycle.State r11, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r12, Continuation<? super AnonymousClass2> r13) {
            this.$this_whenStateAtLeast = r10;
            this.$minState = r11;
            this.$block = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass2 r12 = new AnonymousClass2(this.$this_whenStateAtLeast, this.$minState, this.$block, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Object r11) {
            return invoke(r10, (Continuation) r11);
        }

        public final Object invoke(l0 r10, Continuation<? super T> r11) {
            return ((AnonymousClass2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L12;
            if (r12 != 1) goto L11;
            LifecycleController r13 = (LifecycleController) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L8
        L19:
            r13.finish();
            return r10;
        L8:
            th = th;
        L23:
            r13.finish();
            throw th;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r10);
            v1 r14 = (v1) ((l0) this.L$0).getCoroutineContext().get(v1.f10723e);
            if (r14 == null) goto L26;
            PausingDispatcher r15 = new PausingDispatcher();
            LifecycleController r16 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, r15.dispatchQueue, r14);
            Function2<l0, Continuation<? super T>, Object> r17 = this.$block;     // Catch: Throwable -> L21
            this.L$0 = r16;     // Catch: Throwable -> L21
            this.label = 1;     // Catch: Throwable -> L21
            r10 = h.g(r15, r17, this);     // Catch: Throwable -> L21
            if (r10 != r11) goto L18;
            return r11;
        L18:
            r13 = r16;
        L21:
            th = th;
            r13 = r16;
            goto L23
        L26:
            throw new IllegalStateException("when[State] methods should have a parent job".toString());
        }
    }

    @Deprecated(message = "whenCreated has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withCreated for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenCreated(Lifecycle r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11, Continuation<? super T> r12) {
        return whenStateAtLeast(r10, Lifecycle.State.CREATED, r11, r12);
    }

    @Deprecated(message = "whenCreated has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withCreated for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenCreated(LifecycleOwner r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11, Continuation<? super T> r12) {
        return whenCreated(r10.getLifecycle(), r11, r12);
    }

    @Deprecated(message = "whenResumed has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withResumed for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenResumed(Lifecycle r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11, Continuation<? super T> r12) {
        return whenStateAtLeast(r10, Lifecycle.State.RESUMED, r11, r12);
    }

    @Deprecated(message = "whenResumed has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withResumed for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenResumed(LifecycleOwner r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11, Continuation<? super T> r12) {
        return whenResumed(r10.getLifecycle(), r11, r12);
    }

    @Deprecated(message = "whenStarted has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStarted for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenStarted(Lifecycle r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11, Continuation<? super T> r12) {
        return whenStateAtLeast(r10, Lifecycle.State.STARTED, r11, r12);
    }

    @Deprecated(message = "whenStarted has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStarted for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenStarted(LifecycleOwner r10, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r11, Continuation<? super T> r12) {
        return whenStarted(r10.getLifecycle(), r11, r12);
    }

    @Deprecated(message = "whenStateAtLeast has been deprecated because it runs the block on a pausing dispatcher that suspends, rather than cancels work when the lifecycle state goes below the given state. Use withStateAtLeast for non-suspending work that needs to run only once when the Lifecycle changes.")
    public static final <T> Object whenStateAtLeast(Lifecycle r10, Lifecycle.State r11, Function2<? super l0, ? super Continuation<? super T>, ? extends Object> r12, Continuation<? super T> r13) {
        return h.g(z0.c().c0(), new AnonymousClass2(r10, r11, r12, null), r13);
    }
}
