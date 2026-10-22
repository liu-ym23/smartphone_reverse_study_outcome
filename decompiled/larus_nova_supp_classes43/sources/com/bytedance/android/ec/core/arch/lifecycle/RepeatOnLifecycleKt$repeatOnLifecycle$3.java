package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.arch.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.arch.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.ec.core.arch.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", i = {0, 0}, l = {176}, m = "invokeSuspend", n = {"launchedJob", "observer"}, s = {"L$0", "L$1"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CoroutineScope $this_coroutineScope;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ RepeatOnLifecycleKt$repeatOnLifecycle$3 this$0;

        public AnonymousClass1(RepeatOnLifecycleKt$repeatOnLifecycle$3 r1, CoroutineScope r10, Continuation r11) {
            this.this$0 = r1;
            this.$this_coroutineScope = r10;
            super(2, r11);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Intrinsics.checkNotNullParameter(r11, "completion");
            return new AnonymousClass1(this.this$0, this.$this_coroutineScope, r11);
        }

        public final Object invoke(Object r1, Object r10) {
            return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r15) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L12;
            if (r1 != 1) goto L11;
            AnonymousClass1 r10 = (AnonymousClass1) this.L$2;
            Ref.ObjectRef r11 = (Ref.ObjectRef) this.L$1;
            Ref.ObjectRef r12 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L8
        L41:
            Job r16 = (Job) r12.element;
            if (r16 == null) goto L44;
            Job.DefaultImpls.cancel$default(r16, null, 1, null);
        L44:
            LifecycleEventObserver r17 = (LifecycleEventObserver) r11.element;
            if (r17 == null) goto L48;
            this.this$0.$this_repeatOnLifecycle.removeObserver(r17);
        L48:
            return Unit.INSTANCE;
        L8:
            Throwable th2 = th;
        L51:
            Job r13 = (Job) r12.element;
            if (r13 == null) goto L54;
            Job.DefaultImpls.cancel$default(r13, null, 1, null);
        L54:
            LifecycleEventObserver r14 = (LifecycleEventObserver) r11.element;
            if (r14 == null) goto L57;
            this.this$0.$this_repeatOnLifecycle.removeObserver(r14);
        L57:
            throw th2;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r15);
            if (this.this$0.$this_repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) goto L15;
            r12 = new Ref.ObjectRef();
            r12.element = null;
            Ref.ObjectRef r18 = new Ref.ObjectRef();
            r18.element = null;
            this.L$0 = r12;     // Catch: Throwable -> L49
            this.L$1 = r18;     // Catch: Throwable -> L49
            this.L$2 = this;     // Catch: Throwable -> L49
            this.label = 1;     // Catch: Throwable -> L49
            j r19 = new j(IntrinsicsKt.intercepted(this), 1);     // Catch: Throwable -> L49
            int r20 = h.a[this.this$0.$state.ordinal()];     // Catch: Throwable -> L49
            if (r20 == 1) goto L24;
            if (r20 == 2) goto L23;
            if (r20 == 3) goto L22;
            Lifecycle.Event r21 = null;
        L26:
            int r22 = h.b[this.this$0.$state.ordinal()];     // Catch: Throwable -> L49
            if (r22 == 1) goto L33;
            if (r22 == 2) goto L32;
            if (r22 == 3) goto L31;
            Lifecycle.Event r23 = null;
        L35:
            RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1 r110 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1(r21, kotlinx.coroutines.sync.b.a(), r23, r19, this, r12);     // Catch: Throwable -> L49
            r18.element = r110;     // Catch: Throwable -> L49
            this.this$0.$this_repeatOnLifecycle.addObserver(r110);     // Catch: Throwable -> L49
            Object r24 = r19.B();     // Catch: Throwable -> L49
            if (r24 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L38;
            DebugProbesKt.probeCoroutineSuspended(this);     // Catch: Throwable -> L49
        L38:
            if (r24 != r0) goto L40;
            return r0;
        L40:
            r11 = r18;
            goto L41
        L31:
            Lifecycle.Event r25 = Lifecycle.Event.ON_PAUSE;     // Catch: Throwable -> L49
        L34:
            r23 = r25;
            goto L35
        L32:
            r25 = Lifecycle.Event.ON_STOP;     // Catch: Throwable -> L49
            goto L34
        L33:
            r25 = Lifecycle.Event.ON_DESTROY;     // Catch: Throwable -> L49
            goto L34
        L22:
            Lifecycle.Event r26 = Lifecycle.Event.ON_RESUME;     // Catch: Throwable -> L49
        L25:
            r21 = r26;
            goto L26
        L23:
            r26 = Lifecycle.Event.ON_START;     // Catch: Throwable -> L49
            goto L25
        L24:
            r26 = Lifecycle.Event.ON_CREATE;     // Catch: Throwable -> L49
        L49:
            th = move-exception;
            r11 = r18;
            th2 = th;
            goto L51
        L15:
            return Unit.INSTANCE;
        }
    }

    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle r1, Lifecycle.State r10, Function2 r11, Continuation r12) {
        this.$this_repeatOnLifecycle = r1;
        this.$state = r10;
        this.$block = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Intrinsics.checkNotNullParameter(r11, "completion");
        RepeatOnLifecycleKt$repeatOnLifecycle$3 r0 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, r11);
        r0.L$0 = r10;
        return r0;
    }

    public final Object invoke(Object r1, Object r10) {
        return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        MainCoroutineDispatcher r12 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r13 = new AnonymousClass1(this, r11, null);
        this.label = 1;
        if (BuildersKt.withContext(r12, r13, this) != r0) goto L12;
        return r0;
    }
}
