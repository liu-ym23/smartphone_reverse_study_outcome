package com.larus.dora.impl.feedback;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlowTransformLatest;
import kotlinx.coroutines.flow.internal.CombineKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackImageGroup$trackAllImagesReadyState$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {593}, m = "invokeSuspend", n = {}, s = {})
final class DoraFeedbackImageGroup$trackAllImagesReadyState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ h this$0;

    /* JADX INFO: renamed from: com.larus.dora.impl.feedback.DoraFeedbackImageGroup$trackAllImagesReadyState$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "currentImages", "", "Lcom/larus/dora/impl/feedback/DoraFeedbackImage;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.feedback.DoraFeedbackImageGroup$trackAllImagesReadyState$1$1", f = "DoraGFeedbackViewModel.kt", i = {}, l = {583, 590}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super Boolean>, List<? extends g>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;

        /* JADX INFO: renamed from: com.larus.dora.impl.feedback.DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ FlowCollector<Boolean> a;

            /* JADX WARN: Multi-variable type inference failed */
            public a(FlowCollector<? super Boolean> r1) {
                this.a = r1;
            }

            public final Object emit(Object r2, Continuation r3) {
                boolean r4 = ((Boolean) r2).booleanValue();
                Object r5 = this.a.emit(Boxing.boxBoolean(r4), r3);
                if (r5 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r5;
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(3, r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
            return invoke((FlowCollector) r1, (List) r2, (Continuation) r3);
        }

        public final Object invoke(FlowCollector<? super Boolean> r2, List<g> r3, Continuation<? super Unit> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(r4);
            r0.L$0 = r2;
            r0.L$1 = r3;
            return r0.invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r7) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            ResultKt.throwOnFailure(r7);
        L28:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r7);
        L16:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r7);
            FlowCollector r8 = (FlowCollector) this.L$0;
            List r2 = (List) this.L$1;
            if (r2.isEmpty() == false) goto L17;
            Boolean r3 = Boxing.boxBoolean(true);
            this.L$0 = null;
            this.label = 1;
            if (r8.emit(r3, this) != r0) goto L16;
            return r0;
        L17:
            List r4 = r2;
            ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
            Iterator r6 = r4.iterator();
        L19:
            if (r6.hasNext() == false) goto L21;
            r5.add(((g) r6.next()).e);
            goto L19
        L21:
            final Flow[] r9 = (Flow[]) CollectionsKt.toList(r5).toArray(new Flow[0]);
            a r10 = new a(r8);
            this.L$0 = null;
            this.label = 2;
            Object r11 = CombineKt.a(r10, r9, new DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$invokeSuspend$$inlined$combine$1$2(r9), new DoraFeedbackImageGroup$trackAllImagesReadyState$1$1$invokeSuspend$$inlined$combine$1$3(null), this);
            if (r11 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L25;
            r11 = Unit.INSTANCE;
        L25:
            if (r11 != r0) goto L28;
            return r0;
        }
    }

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ h a;

        public a(h r1) {
            this.a = r1;
        }

        public final Object emit(Object r1, Continuation r2) {
            boolean r3 = ((Boolean) r1).booleanValue();
            this.a.c.setValue(Boxing.boxBoolean(r3));
            return Unit.INSTANCE;
        }
    }

    public DoraFeedbackImageGroup$trackAllImagesReadyState$1(h r1, Continuation<? super DoraFeedbackImageGroup$trackAllImagesReadyState$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraFeedbackImageGroup$trackAllImagesReadyState$1(this.this$0, r3);
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
        ChannelFlowTransformLatest r6 = kotlinx.coroutines.flow.e.G(this.this$0.b, new AnonymousClass1(null));
        a r2 = new a(this.this$0);
        this.label = 1;
        if (r6.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
