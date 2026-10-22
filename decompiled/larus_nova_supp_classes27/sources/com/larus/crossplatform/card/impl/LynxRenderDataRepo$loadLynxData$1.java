package com.larus.crossplatform.card.impl;

import com.larus.bmhome.chat.resp.LynxRenderData;
import com.larus.doc.sdk.impl.v2.plugins.snapshot.DocShotConsts;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.crossplatform.card.impl.LynxRenderDataRepo$loadLynxData$1", f = "LynxRenderDataRepo.kt", i = {}, l = {DocShotConsts.INPUT_VIEW_HEIGHT}, m = "invokeSuspend", n = {}, s = {})
public final class LynxRenderDataRepo$loadLynxData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, String, Unit> $c;
    final /* synthetic */ String $dataUrl;
    final /* synthetic */ Ref.LongRef $delaySeconds;
    final /* synthetic */ String $messageId;
    int label;

    /* JADX INFO: renamed from: com.larus.crossplatform.card.impl.LynxRenderDataRepo$loadLynxData$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/bmhome/chat/resp/LynxRenderData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.crossplatform.card.impl.LynxRenderDataRepo$loadLynxData$1$1", f = "LynxRenderDataRepo.kt", i = {0}, l = {71, 72}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super LynxRenderData>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $dataUrl;
        final /* synthetic */ String $messageId;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(String r1, String r2, Continuation<? super AnonymousClass1> r3) {
            this.$dataUrl = r1;
            this.$messageId = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$dataUrl, this.$messageId, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((FlowCollector) r1, (Continuation) r2);
        }

        public final Object invoke(FlowCollector<? super LynxRenderData> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r8);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            FlowCollector r2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r8);
        L13:
            this.L$0 = null;
            this.label = 2;
            if (r2.emit((LynxRenderData) r8, this) != r0) goto L17;
            return r0;
        L10:
            ResultKt.throwOnFailure(r8);
            r2 = (FlowCollector) this.L$0;
            CoroutineScope r9 = LynxRenderDataRepo.a;
            String r10 = this.$dataUrl;
            String r5 = this.$messageId;
            this.L$0 = r2;
            this.label = 1;
            r8 = BuildersKt.withContext(Dispatchers.getIO(), new LynxRenderDataRepo$fetchLynxRenderData$2(r10, r5, null), this);
            if (r8 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.larus.crossplatform.card.impl.LynxRenderDataRepo$loadLynxData$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/chat/resp/LynxRenderData;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.crossplatform.card.impl.LynxRenderDataRepo$loadLynxData$1$2", f = "LynxRenderDataRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<LynxRenderData, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass2 r0 = new AnonymousClass2(r3);
            r0.L$0 = r2;
            return r0;
        }

        public final Object invoke(LynxRenderData r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((LynxRenderData) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r2);
            if (((LynxRenderData) this.L$0) == null) goto L9;
            return Unit.INSTANCE;
        L9:
            throw new NullPointerException("fetchLynxRenderData error");
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.crossplatform.card.impl.LynxRenderDataRepo$loadLynxData$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.crossplatform.card.impl.LynxRenderDataRepo$loadLynxData$1$3", f = "LynxRenderDataRepo.kt", i = {0}, l = {78}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<Throwable, Continuation<? super Boolean>, Object> {
        final /* synthetic */ Ref.LongRef $delaySeconds;
        /* synthetic */ Object L$0;
        int label;

        public AnonymousClass3(Ref.LongRef r1, Continuation<? super AnonymousClass3> r2) {
            this.$delaySeconds = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass3 r0 = new AnonymousClass3(this.$delaySeconds, r4);
            r0.L$0 = r3;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Throwable) r1, (Continuation) r2);
        }

        public final Object invoke(Throwable r1, Continuation<? super Boolean> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Throwable r2 = (Throwable) this.L$0;
            ResultKt.throwOnFailure(r8);
        L13:
            return Boxing.boxBoolean(r2 instanceof NullPointerException);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            Throwable r9 = (Throwable) this.L$0;
            Ref.LongRef r3 = this.$delaySeconds;
            long r4 = r3.element + 1;
            r3.element = r4;
            this.L$0 = r9;
            this.label = 1;
            if (DelayKt.delay(r4 * ((long) 1000), this) != r0) goto L11;
            return r0;
        L11:
            r2 = r9;
            goto L13
        }
    }

    /* JADX INFO: renamed from: com.larus.crossplatform.card.impl.LynxRenderDataRepo$loadLynxData$1$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/bmhome/chat/resp/LynxRenderData;", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.crossplatform.card.impl.LynxRenderDataRepo$loadLynxData$1$4", f = "LynxRenderDataRepo.kt", i = {0}, l = {81}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
    public static final class AnonymousClass4 extends SuspendLambda implements Function3<FlowCollector<? super LynxRenderData>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<Boolean, String, Unit> $c;
        /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: com.larus.crossplatform.card.impl.LynxRenderDataRepo$loadLynxData$1$4$1, reason: invalid class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.crossplatform.card.impl.LynxRenderDataRepo$loadLynxData$1$4$1", f = "LynxRenderDataRepo.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Function2<Boolean, String, Unit> $c;
            int label;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function2<? super Boolean, ? super String, Unit> r1, Continuation<? super AnonymousClass1> r2) {
                this.$c = r1;
                super(2, r2);
            }

            public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
                return new AnonymousClass1(this.$c, r3);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
                return invoke((CoroutineScope) r1, (Continuation) r2);
            }

            public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
                return create(r1, r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r3) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r3);
                this.$c.invoke(Boxing.boxBoolean(false), null);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass4(Function2<? super Boolean, ? super String, Unit> r1, Continuation<? super AnonymousClass4> r2) {
            this.$c = r1;
            super(3, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((FlowCollector) r1, (Throwable) r2, (Continuation) r3);
        }

        public final Object invoke(FlowCollector<? super LynxRenderData> r2, Throwable r3, Continuation<? super Unit> r4) {
            AnonymousClass4 r5 = new AnonymousClass4(this.$c, r4);
            r5.L$0 = r3;
            return r5.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Throwable r2 = (Throwable) this.L$0;
            ResultKt.throwOnFailure(r7);
        L12:
            FLogger r8 = FLogger.a;
            CoroutineScope r3 = LynxRenderDataRepo.a;
            r8.i("LynxRenderDataRepo", r2.getMessage());
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r7);
            Throwable r9 = (Throwable) this.L$0;
            MainCoroutineDispatcher r4 = Dispatchers.getMain();
            AnonymousClass1 r5 = new AnonymousClass1(this.$c, null);
            this.L$0 = r9;
            this.label = 1;
            if (BuildersKt.withContext(r4, r5, this) != r0) goto L11;
            return r0;
        L11:
            r2 = r9;
            goto L12
        }
    }

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Function2<Boolean, String, Unit> a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super Boolean, ? super String, Unit> r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            Object r7 = BuildersKt.withContext(Dispatchers.getMain(), new LynxRenderDataRepo$loadLynxData$1$5$1((LynxRenderData) r5, this.a, null), r6);
            if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
            return r7;
        L6:
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LynxRenderDataRepo$loadLynxData$1(String r1, String r2, Ref.LongRef r3, Function2<? super Boolean, ? super String, Unit> r4, Continuation<? super LynxRenderDataRepo$loadLynxData$1> r5) {
        this.$dataUrl = r1;
        this.$messageId = r2;
        this.$delaySeconds = r3;
        this.$c = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new LynxRenderDataRepo$loadLynxData$1(this.$dataUrl, this.$messageId, this.$delaySeconds, this.$c, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 r3 = new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(e.B(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(new c1(new AnonymousClass1(this.$dataUrl, this.$messageId, null)), new AnonymousClass2(null)), new AnonymousClass3(this.$delaySeconds, null)), new AnonymousClass4(this.$c, null));
        a r7 = new a(this.$c);
        this.label = 1;
        if (r3.collect(r7, this) != r0) goto L12;
        return r0;
    }
}
