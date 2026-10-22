package com.larus.canvas.feature.component.logic;

import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.PausingDispatcherKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImageInitComponent$doOnceOnResume$1", f = "GenImageInitComponent.kt", i = {}, l = {261}, m = "invokeSuspend", n = {}, s = {})
final class GenImageInitComponent$doOnceOnResume$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Ref.BooleanRef $hasJob;
    int label;
    final /* synthetic */ GenImageInitComponent this$0;

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.logic.GenImageInitComponent$doOnceOnResume$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImageInitComponent$doOnceOnResume$1$1", f = "GenImageInitComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Ref.BooleanRef $hasJob;
        int label;
        final /* synthetic */ GenImageInitComponent this$0;

        /* JADX INFO: renamed from: com.larus.canvas.feature.component.logic.GenImageInitComponent$doOnceOnResume$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImageInitComponent$doOnceOnResume$1$1$1", f = "GenImageInitComponent.kt", i = {}, l = {265}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
            int label;

            public C00911(Function1<? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super C00911> r2) {
                this.$block = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new C00911(this.$block, r3);
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
                Function1<Continuation<? super Unit>, Object> r5 = this.$block;
                this.label = 1;
                if (r5.invoke(this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(Ref.BooleanRef r1, GenImageInitComponent r2, Function1<? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super AnonymousClass1> r4) {
            this.$hasJob = r1;
            this.this$0 = r2;
            this.$block = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            return new AnonymousClass1(this.$hasJob, this.this$0, this.$block, r5);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r7);
            Ref.BooleanRef r8 = this.$hasJob;
            if (r8.element == false) goto L8;
            r8.element = false;
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), null, null, new C00911(this.$block, null), 3, null);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public GenImageInitComponent$doOnceOnResume$1(GenImageInitComponent r1, Ref.BooleanRef r2, Function1<? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super GenImageInitComponent$doOnceOnResume$1> r4) {
        this.this$0 = r1;
        this.$hasJob = r2;
        this.$block = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GenImageInitComponent$doOnceOnResume$1(this.this$0, this.$hasJob, this.$block, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        GenImageInitComponent r8 = this.this$0;
        AnonymousClass1 r2 = new AnonymousClass1(this.$hasJob, r8, this.$block, null);
        this.label = 1;
        if (PausingDispatcherKt.whenResumed(r8, r2, this) != r0) goto L12;
        return r0;
    }
}
