package com.obric.widget.host.runtime;

import android.content.Context;
import android.util.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Lcom/obric/widget/host/runtime/WidgetRendererCreateResult;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController$createWidgetWithSnapshotPrime$rendererCreateResult$1", f = "WidgetRenderSessionController.kt", i = {}, l = {314}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetRenderSessionController$createWidgetWithSnapshotPrime$rendererCreateResult$1 extends SuspendLambda implements Function1<Continuation<? super WidgetRendererCreateResult>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $initialPayload;
    final /* synthetic */ String $initialPayloadSource;
    final /* synthetic */ int $instanceId;
    final /* synthetic */ String $logTag;
    final /* synthetic */ String $renderReason;
    final /* synthetic */ WidgetDefinitionMetadata $widget;
    final /* synthetic */ WidgetRenderSessionController.WidgetLifeObserver $widgetLifeObserver;
    int label;
    final /* synthetic */ WidgetRenderSessionController this$0;

    /* JADX INFO: renamed from: com.obric.widget.host.runtime.WidgetRenderSessionController$createWidgetWithSnapshotPrime$rendererCreateResult$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/widget/host/runtime/WidgetRendererCreateResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController$createWidgetWithSnapshotPrime$rendererCreateResult$1$1", f = "WidgetRenderSessionController.kt", i = {}, l = {316}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WidgetRendererCreateResult>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ String $initialPayload;
        final /* synthetic */ String $initialPayloadSource;
        final /* synthetic */ int $instanceId;
        final /* synthetic */ String $logTag;
        final /* synthetic */ String $renderReason;
        final /* synthetic */ WidgetDefinitionMetadata $widget;
        final /* synthetic */ WidgetRenderSessionController.WidgetLifeObserver $widgetLifeObserver;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ WidgetRenderSessionController this$0;

        public AnonymousClass1(WidgetRenderSessionController r5, Context r10, WidgetDefinitionMetadata r11, int r12, String r13, String r14, WidgetRenderSessionController.WidgetLifeObserver r15, String r16, String r17, Continuation<? super AnonymousClass1> r18) {
            this.this$0 = r5;
            this.$context = r10;
            this.$widget = r11;
            this.$instanceId = r12;
            this.$initialPayload = r13;
            this.$initialPayloadSource = r14;
            this.$widgetLifeObserver = r15;
            this.$logTag = r16;
            this.$renderReason = r17;
            super(2, r18);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
            AnonymousClass1 r11 = new AnonymousClass1(this.this$0, this.$context, this.$widget, this.$instanceId, this.$initialPayload, this.$initialPayloadSource, this.$widgetLifeObserver, this.$logTag, this.$renderReason, r14);
            r11.L$0 = r13;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super WidgetRendererCreateResult> r10) {
            return invoke2(r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L11;
            if (r10 != 1) goto L10;
            ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L7
        L15:
            Object r14 = Result.m124constructorimpl((WidgetRendererCreateResult) r13);     // Catch: Throwable -> L7
        L18:
            String r11 = this.$logTag;
            String r12 = this.$renderReason;
            int r15 = this.$instanceId;
            Throwable r16 = Result.m127exceptionOrNullimpl(r14);
            if (r16 == null) goto L22;
            Log.e(r11, "createWidget failed: reason=" + r12 + ", instance=" + r15, r16);
        L22:
            if (Result.m130isFailureimpl(r14) == false) goto L27;
            return null;
        L27:
            return r14;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L11:
            ResultKt.throwOnFailure(r13);
            CoroutineScope r17 = (CoroutineScope) this.L$0;
            WidgetRenderSessionController r18 = this.this$0;
            Context r19 = this.$context;
            WidgetDefinitionMetadata r20 = this.$widget;
            int r21 = this.$instanceId;
            String r22 = this.$initialPayload;
            String r23 = this.$initialPayloadSource;
            WidgetRenderSessionController.WidgetLifeObserver r110 = this.$widgetLifeObserver;
            Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L7
            WidgetRendererEngine r25 = WidgetRenderSessionController.access$getRendererEngine$p(r18);     // Catch: Throwable -> L7
            Integer r26 = Boxing.boxInt(r21);     // Catch: Throwable -> L7
            this.label = 1;     // Catch: Throwable -> L7
            r13 = r25.createWidgetDetailed(r19, r20, r26, r22, r23, true, r110, this);     // Catch: Throwable -> L7
            if (r13 != r5) goto L15;
            return r5;
        L7:
            th = move-exception;
            Result.Companion r27 = Result.Companion;
            r14 = Result.m124constructorimpl(ResultKt.createFailure(th));
            goto L18
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r5, Continuation<? super WidgetRendererCreateResult> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public WidgetRenderSessionController$createWidgetWithSnapshotPrime$rendererCreateResult$1(WidgetRenderSessionController r5, Context r10, WidgetDefinitionMetadata r11, int r12, String r13, String r14, WidgetRenderSessionController.WidgetLifeObserver r15, String r16, String r17, Continuation<? super WidgetRenderSessionController$createWidgetWithSnapshotPrime$rendererCreateResult$1> r18) {
        this.this$0 = r5;
        this.$context = r10;
        this.$widget = r11;
        this.$instanceId = r12;
        this.$initialPayload = r13;
        this.$initialPayloadSource = r14;
        this.$widgetLifeObserver = r15;
        this.$logTag = r16;
        this.$renderReason = r17;
        super(1, r18);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r13) {
        return new WidgetRenderSessionController$createWidgetWithSnapshotPrime$rendererCreateResult$1(this.this$0, this.$context, this.$widget, this.$instanceId, this.$initialPayload, this.$initialPayloadSource, this.$widgetLifeObserver, this.$logTag, this.$renderReason, r13);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super WidgetRendererCreateResult> r5) {
        return invoke2(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r15) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.label;
        if (r10 == 0) goto L8;
        if (r10 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L11:
        return r15;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        MainCoroutineDispatcher r16 = Dispatchers.getMain().getImmediate();
        AnonymousClass1 r11 = new AnonymousClass1(this.this$0, this.$context, this.$widget, this.$instanceId, this.$initialPayload, this.$initialPayloadSource, this.$widgetLifeObserver, this.$logTag, this.$renderReason, null);
        this.label = 1;
        r15 = BuildersKt.withContext(r16, r11, this);
        if (r15 != r5) goto L11;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super WidgetRendererCreateResult> r5) {
        return ((WidgetRenderSessionController$createWidgetWithSnapshotPrime$rendererCreateResult$1) create(r5)).invokeSuspend(Unit.INSTANCE);
    }
}
