package com.obric.memorydata.markdown.stream;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.channels.z;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.markdown.stream.MarkdownStreamEngine$launchProducer$1", f = "MarkdownStreamEngine.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
final class MarkdownStreamEngine$launchProducer$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.channels.i<String> $channel;
    final /* synthetic */ StringBuilder $fullContent;
    int label;
    final /* synthetic */ MarkdownStreamEngine this$0;

    /* JADX INFO: renamed from: com.obric.memorydata.markdown.stream.MarkdownStreamEngine$launchProducer$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "e", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.markdown.stream.MarkdownStreamEngine$launchProducer$1$1", f = "MarkdownStreamEngine.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.j<? super String>, Throwable, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MarkdownStreamEngine this$0;

        /* JADX INFO: renamed from: com.obric.memorydata.markdown.stream.MarkdownStreamEngine$launchProducer$1$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.markdown.stream.MarkdownStreamEngine$launchProducer$1$1$1", f = "MarkdownStreamEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C04861 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ Throwable $e;
            int label;
            final /* synthetic */ MarkdownStreamEngine this$0;

            C04861(MarkdownStreamEngine r3, Throwable r4, Continuation<? super C04861> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.this$0 = r3;
                this.$e = r4;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C04861(this.this$0, this.$e, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C04861) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C04861.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                MarkdownStreamEngine.d(this.this$0).a(this.$e);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        AnonymousClass1(MarkdownStreamEngine r3, Continuation<? super AnonymousClass1> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(3, r5);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(kotlinx.coroutines.flow.j<? super String> r3, Throwable r4, Continuation<? super Unit> r5) {
            return invoke2((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.j<? super String> r3, Throwable r4, Continuation<? super Unit> r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r8 = new AnonymousClass1(this.this$0, r7);
            r8.L$0 = r4;
            return r8.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            Throwable r12 = (Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin");
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownStreamEngine", "source error: " + r12.getMessage(), null, 4, null);
            CoroutineContext r2 = (CoroutineContext) ZeusTransformUtils.preCheckCast(MarkdownStreamEngine.c(this.this$0), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r13 = (Function2) ZeusTransformUtils.preCheckCast(new C04861(this.this$0, r12, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            if (kotlinx.coroutines.i.a(r2, r13, r3) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.markdown.stream.MarkdownStreamEngine$launchProducer$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "cause", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.markdown.stream.MarkdownStreamEngine$launchProducer$1$2", f = "MarkdownStreamEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.j<? super String>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.channels.i<String> $channel;
        final /* synthetic */ Ref.IntRef $count;
        final /* synthetic */ StringBuilder $fullContent;
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(kotlinx.coroutines.channels.i<String> r3, Ref.IntRef r4, StringBuilder r5, Continuation<? super AnonymousClass2> r6) {
            kotlinx.coroutines.channels.i<String> r7 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$channel = r7;
            this.$count = r4;
            this.$fullContent = r5;
            super(3, r8);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* synthetic */ Object invoke(kotlinx.coroutines.flow.j<? super String> r3, Throwable r4, Continuation<? super Unit> r5) {
            return invoke2((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), (Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.j<? super String> r3, Throwable r4, Continuation<? super Unit> r5) {
            kotlinx.coroutines.flow.j r6 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass2 r8 = new AnonymousClass2(this.$channel, this.$count, this.$fullContent, r7);
            r8.L$0 = r4;
            return r8.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r7);
            if (((Throwable) ZeusTransformUtils.preCheckCast(this.L$0, Throwable.class, "com.obric.memorydata.plugin")) != null) goto L8;
            z.a.a((z) ZeusTransformUtils.preCheckCast(this.$channel, z.class, "com.obric.memorydata.plugin"), null, 1, null);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownStreamEngine", "producer done, chunks=" + this.$count.element + ", len=" + this.$fullContent.length(), false, 4, null);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    MarkdownStreamEngine$launchProducer$1(MarkdownStreamEngine r3, kotlinx.coroutines.channels.i<String> r4, StringBuilder r5, Continuation<? super MarkdownStreamEngine$launchProducer$1> r6) {
        kotlinx.coroutines.channels.i<String> r7 = (kotlinx.coroutines.channels.i) ZeusTransformUtils.wrapperContextForParams(r4, kotlinx.coroutines.channels.i.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$channel = r7;
        this.$fullContent = r5;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MarkdownStreamEngine$launchProducer$1(this.this$0, this.$channel, this.$fullContent, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MarkdownStreamEngine$launchProducer$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MarkdownStreamEngine$launchProducer$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v6, types: [java.lang.Object, kotlin.Unit] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r12);     // Catch: CancellationException -> L7
    L15:
        MarkdownStreamEngine$launchProducer$1 this = Unit.INSTANCE;
        return this;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r12);
        final Ref.IntRef r13 = new Ref.IntRef();
        kotlinx.coroutines.flow.i r2 = kotlinx.coroutines.flow.k.a(kotlinx.coroutines.flow.k.b(MarkdownStreamEngine.e(this.this$0).a(), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0, null), Function3.class, "com.obric.memorydata.plugin")), (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass2(this.$channel, r13, this.$fullContent, null), Function3.class, "com.obric.memorydata.plugin"));     // Catch: CancellationException -> L7
        final MarkdownStreamEngine r6 = this.this$0;     // Catch: CancellationException -> L7
        final StringBuilder r7 = this.$fullContent;     // Catch: CancellationException -> L7
        final kotlinx.coroutines.channels.i<String> r8 = this.$channel;     // Catch: CancellationException -> L7
        kotlinx.coroutines.flow.j r14 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r13, r6, r7, r8), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");     // Catch: CancellationException -> L7
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: CancellationException -> L7
        this.label = 1;     // Catch: CancellationException -> L7
        if (r2.collect(r14, r5) != r0) goto L15;
        return r0;
    L7:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MarkdownStreamEngine", "producer cancelled", false, 4, null);
        z.a.a((z) ZeusTransformUtils.preCheckCast(this.$channel, z.class, "com.obric.memorydata.plugin"), null, 1, null);
        throw e;
    }
}
