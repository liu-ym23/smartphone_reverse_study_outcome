package com.obric.widget.host.runtime;

import android.util.Log;
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
@DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController$updateRenderedWidget$updated$1", f = "WidgetRenderSessionController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetRenderSessionController$updateRenderedWidget$updated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $instanceId;
    final /* synthetic */ String $logTag;
    final /* synthetic */ String $payload;
    final /* synthetic */ String $renderReason;
    final /* synthetic */ WidgetDefinitionMetadata $widget;
    final /* synthetic */ View $widgetView;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WidgetRenderSessionController this$0;

    public WidgetRenderSessionController$updateRenderedWidget$updated$1(WidgetRenderSessionController r5, View r10, WidgetDefinitionMetadata r11, String r12, String r13, String r14, int r15, Continuation<? super WidgetRenderSessionController$updateRenderedWidget$updated$1> r16) {
        this.this$0 = r5;
        this.$widgetView = r10;
        this.$widget = r11;
        this.$payload = r12;
        this.$logTag = r13;
        this.$renderReason = r14;
        this.$instanceId = r15;
        super(2, r16);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        WidgetRenderSessionController$updateRenderedWidget$updated$1 r10 = new WidgetRenderSessionController$updateRenderedWidget$updated$1(this.this$0, this.$widgetView, this.$widget, this.$payload, this.$logTag, this.$renderReason, this.$instanceId, r12);
        r10.L$0 = r11;
        return r10;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super Boolean> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        WidgetRenderSessionController r12 = this.this$0;
        View r5 = this.$widgetView;
        WidgetDefinitionMetadata r13 = this.$widget;
        String r14 = this.$payload;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L7
        Object r16 = Result.m124constructorimpl(Boxing.boxBoolean(r12.updateWidgetView(r5, r13, r14)));     // Catch: Throwable -> L7
    L9:
        String r17 = this.$logTag;
        String r18 = this.$renderReason;
        int r19 = this.$instanceId;
        Throwable r20 = Result.m127exceptionOrNullimpl(r16);
        if (r20 == null) goto L12;
        Log.w(r17, "updateRenderedWidget failed: reason=" + r18 + ", instance=" + r19, r20);
    L12:
        Boolean r21 = Boxing.boxBoolean(false);
        if (Result.m130isFailureimpl(r16) == true) goto L15;
        return r16;
    L15:
        return r21;
    L7:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L9
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super Boolean> r10) {
        return ((WidgetRenderSessionController$updateRenderedWidget$updated$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
