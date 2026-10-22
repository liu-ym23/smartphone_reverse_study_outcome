package com.larus.bmhome.social.page.datasource.diff;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.CoroutineExtKt$launchChild$2", f = "CoroutineExt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CoroutineExtKt$launchChild$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Ref.ObjectRef<Job> $launchJob;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.diff.CoroutineExtKt$launchChild$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.CoroutineExtKt$launchChild$2$1", f = "CoroutineExt.kt", i = {}, l = {29}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
        int label;

        /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.diff.CoroutineExtKt$launchChild$2$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.bmhome.social.page.datasource.diff.CoroutineExtKt$launchChild$2$1$1", f = "CoroutineExt.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
        public static final class C00331 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> $block;
            private /* synthetic */ Object L$0;
            int label;

            public C00331(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super C00331> r2) {
                this.$block = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                C00331 r0 = new C00331(this.$block, r4);
                r0.L$0 = r3;
                return r0;
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
                CoroutineScope r5 = (CoroutineScope) this.L$0;
                Function2<CoroutineScope, Continuation<? super Unit>, Object> r2 = this.$block;
                this.label = 1;
                if (r2.invoke(r5, this) != r0) goto L12;
                return r0;
            }
        }

        public AnonymousClass1(Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r1, Continuation<? super AnonymousClass1> r2) {
            this.$block = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.$block, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r5) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r5);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r5);
            C00331 r6 = new C00331(this.$block, null);
            this.label = 1;
            if (CoroutineScopeKt.coroutineScope(r6, this) != r0) goto L12;
            return r0;
        }
    }

    public CoroutineExtKt$launchChild$2(Ref.ObjectRef<Job> r1, CoroutineContext r2, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> r3, Continuation<? super CoroutineExtKt$launchChild$2> r4) {
        this.$launchJob = r1;
        this.$context = r2;
        this.$block = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        CoroutineExtKt$launchChild$2 r0 = new CoroutineExtKt$launchChild$2(this.$launchJob, this.$context, this.$block, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r7);
        CoroutineScope r0 = (CoroutineScope) this.L$0;
        if (CoroutineScopeKt.isActive(r0) == false) goto L7;
        Ref.ObjectRef<Job> r8 = this.$launchJob;
        r8.element = BuildersKt.launch$default(r0, this.$context, null, new AnonymousClass1(this.$block, null), 2, null);
        return Unit.INSTANCE;
    L7:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
