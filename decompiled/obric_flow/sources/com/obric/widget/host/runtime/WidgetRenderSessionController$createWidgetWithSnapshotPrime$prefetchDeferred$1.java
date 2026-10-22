package com.obric.widget.host.runtime;

import ai.j0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController$createWidgetWithSnapshotPrime$prefetchDeferred$1", f = "WidgetRenderSessionController.kt", i = {}, l = {293}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetRenderSessionController$createWidgetWithSnapshotPrime$prefetchDeferred$1 extends SuspendLambda implements Function1<Continuation<? super String>, Object> {
    final /* synthetic */ int $instanceId;
    final /* synthetic */ String $logTag;
    final /* synthetic */ String $renderReason;
    final /* synthetic */ WidgetDefinitionMetadata $widget;
    int label;
    final /* synthetic */ WidgetRenderSessionController this$0;

    public WidgetRenderSessionController$createWidgetWithSnapshotPrime$prefetchDeferred$1(WidgetRenderSessionController r5, WidgetDefinitionMetadata r10, int r11, String r12, String r13, Continuation<? super WidgetRenderSessionController$createWidgetWithSnapshotPrime$prefetchDeferred$1> r14) {
        this.this$0 = r5;
        this.$widget = r10;
        this.$instanceId = r11;
        this.$renderReason = r12;
        this.$logTag = r13;
        super(1, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new WidgetRenderSessionController$createWidgetWithSnapshotPrime$prefetchDeferred$1(this.this$0, this.$widget, this.$instanceId, this.$renderReason, this.$logTag, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super String> r5) {
        return invoke2(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return ((WidgetRemoteUpdateResult) r10).getPayload();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        WidgetRenderSessionController r12 = this.this$0;
        WidgetDefinitionMetadata r13 = this.$widget;
        int r14 = this.$instanceId;
        String r15 = j0.j(this.$renderReason, ":coldStart");
        String r16 = this.$logTag;
        this.label = 1;
        r10 = r12.requestLatestWidgetPayload(r13, r14, r15, r16, this);
        if (r10 != r5) goto L12;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super String> r5) {
        return ((WidgetRenderSessionController$createWidgetWithSnapshotPrime$prefetchDeferred$1) create(r5)).invokeSuspend(Unit.INSTANCE);
    }
}
