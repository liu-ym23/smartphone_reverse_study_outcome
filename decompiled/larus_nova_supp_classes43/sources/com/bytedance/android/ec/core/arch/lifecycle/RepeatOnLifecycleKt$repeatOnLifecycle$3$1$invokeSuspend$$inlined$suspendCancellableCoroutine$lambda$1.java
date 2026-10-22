package com.bytedance.android.ec.core.arch.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.j;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1 implements LifecycleEventObserver {
    public final /* synthetic */ Lifecycle.Event a;
    public final /* synthetic */ kotlinx.coroutines.sync.a b;
    public final /* synthetic */ Lifecycle.Event c;
    public final /* synthetic */ kotlinx.coroutines.i d;
    public final /* synthetic */ RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1 e;
    public final /* synthetic */ Ref.ObjectRef f;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.arch.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/ec/core/arch/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.ec.core.arch.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", i = {0, 1}, l = {177, 103}, m = "invokeSuspend", n = {"$this$withLock$iv", "$this$withLock$iv"}, s = {"L$0", "L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1 this$0;

        /* JADX INFO: renamed from: com.bytedance.android.ec.core.arch.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/ec/core/arch/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", "com/bytedance/android/ec/core/arch/lifecycle/RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$invokeSuspend$$inlined$withLock$lambda$1"}, k = 3, mv = {1, 4, 3})
        @DebugMetadata(c = "com.bytedance.android.ec.core.arch.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1", f = "RepeatOnLifecycle.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
        public static final class C01271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ AnonymousClass1 this$0;

            public C01271(Continuation r1, AnonymousClass1 r10) {
                this.this$0 = r10;
                super(2, r1);
            }

            public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
                Intrinsics.checkNotNullParameter(r11, "completion");
                C01271 r0 = new C01271(r11, this.this$0);
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
                Function2 r12 = this.this$0.this$0.e.this$0.$block;
                this.label = 1;
                InlineMarker.mark(6);
                InlineMarker.mark(6);
                Object r13 = r12.invoke(r11, this);
                InlineMarker.mark(7);
                InlineMarker.mark(7);
                if (r13 != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1 r1, Continuation r10) {
            this.this$0 = r1;
            super(2, r10);
        }

        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Intrinsics.checkNotNullParameter(r11, "completion");
            return new AnonymousClass1(this.this$0, r11);
        }

        public final Object invoke(Object r1, Object r10) {
            return create(r1, (Continuation) r10).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r10) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L14;
            if (r1 == 1) goto L13;
            if (r1 != 2) goto L12;
            kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L9
        L21:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L9
            r11.unlock(null);
            return Unit.INSTANCE;
        L9:
            Throwable th2 = th;
        L26:
            r11.unlock(null);
            throw th2;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            kotlinx.coroutines.sync.a r13 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r10);
            kotlinx.coroutines.sync.a r14 = r13;
        L28:
            C01271 r15 = new C01271(null, this);     // Catch: Throwable -> L24
            this.L$0 = r14;     // Catch: Throwable -> L24
            this.label = 2;     // Catch: Throwable -> L24
            if (CoroutineScopeKt.coroutineScope(r15, this) != r0) goto L20;
            return r0;
        L20:
            r11 = r14;
        L24:
            th = move-exception;
            r11 = r14;
            th2 = th;
            goto L26
        L14:
            ResultKt.throwOnFailure(r10);
            r14 = this.this$0.b;
            this.L$0 = r14;
            this.label = 1;
            if (r14.a(null, this) != r0) goto L28;
            return r0;
        }
    }

    public RepeatOnLifecycleKt$repeatOnLifecycle$3$1$invokeSuspend$$inlined$suspendCancellableCoroutine$lambda$1(Lifecycle.Event r1, MutexImpl r10, Lifecycle.Event r11, j r12, RepeatOnLifecycleKt$repeatOnLifecycle$3.AnonymousClass1 r13, Ref.ObjectRef r14) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
        this.e = r13;
        this.f = r14;
    }

    public final void onStateChanged(LifecycleOwner r10, Lifecycle.Event r11) {
        Intrinsics.checkNotNullParameter(r10, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r11, "event");
        if (r11 != this.a) goto L7;
        Ref.ObjectRef r12 = this.f;
        r12.element = BuildersKt.launch$default(this.e.$this_coroutineScope, null, null, new AnonymousClass1(this, null), 3, null);
        return;
    L7:
        if (r11 != this.c) goto L13;
        Job r13 = (Job) this.f.element;
        if (r13 == null) goto L11;
        Job.DefaultImpls.cancel$default(r13, null, 1, null);
    L11:
        this.f.element = null;
    L13:
        if (r11 != Lifecycle.Event.ON_DESTROY) goto L16;
        this.d.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        return;
    }
}
