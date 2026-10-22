package com.obric.widget.host.runtime;

import android.view.View;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController$createWidgetWithSnapshotPrime$updated$1", f = "WidgetRenderSessionController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetRenderSessionController$createWidgetWithSnapshotPrime$updated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ View $effectiveView;
    final /* synthetic */ String $inlinePayload;
    final /* synthetic */ WidgetDefinitionMetadata $widget;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WidgetRenderSessionController this$0;

    public WidgetRenderSessionController$createWidgetWithSnapshotPrime$updated$1(WidgetRenderSessionController r5, View r10, WidgetDefinitionMetadata r11, String r12, Continuation<? super WidgetRenderSessionController$createWidgetWithSnapshotPrime$updated$1> r13) {
        this.this$0 = r5;
        this.$effectiveView = r10;
        this.$widget = r11;
        this.$inlinePayload = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        WidgetRenderSessionController$createWidgetWithSnapshotPrime$updated$1 r12 = new WidgetRenderSessionController$createWidgetWithSnapshotPrime$updated$1(this.this$0, this.$effectiveView, this.$widget, this.$inlinePayload, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Boolean> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        WidgetRenderSessionController r11 = this.this$0;
        View r12 = this.$effectiveView;
        WidgetDefinitionMetadata r13 = this.$widget;
        String r14 = this.$inlinePayload;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L7
        Object r16 = Result.m124constructorimpl(Boxing.boxBoolean(r11.updateWidgetView(r12, r13, r14)));     // Catch: Throwable -> L7
    L9:
        Boolean r17 = Boxing.boxBoolean(false);
        if (Result.m130isFailureimpl(r16) == true) goto L12;
        return r16;
    L12:
        return r17;
    L7:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L9
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Boolean> r10) {
        return ((WidgetRenderSessionController$createWidgetWithSnapshotPrime$updated$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
