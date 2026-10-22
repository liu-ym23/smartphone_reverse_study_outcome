package com.obric.widget.host.runtime;

import android.util.Log;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRenderSessionController$requestLatestWidgetPayload$payload$1", f = "WidgetRenderSessionController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetRenderSessionController$requestLatestWidgetPayload$payload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ int $instanceId;
    final /* synthetic */ String $logTag;
    final /* synthetic */ String $renderReason;
    final /* synthetic */ WidgetDefinitionMetadata $widget;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ WidgetRenderSessionController this$0;

    public WidgetRenderSessionController$requestLatestWidgetPayload$payload$1(WidgetRenderSessionController r5, WidgetDefinitionMetadata r10, int r11, String r12, String r13, Continuation<? super WidgetRenderSessionController$requestLatestWidgetPayload$payload$1> r14) {
        this.this$0 = r5;
        this.$widget = r10;
        this.$instanceId = r11;
        this.$renderReason = r12;
        this.$logTag = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        WidgetRenderSessionController$requestLatestWidgetPayload$payload$1 r12 = new WidgetRenderSessionController$requestLatestWidgetPayload$payload$1(this.this$0, this.$widget, this.$instanceId, this.$renderReason, this.$logTag, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super String> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r10);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        WidgetRenderSessionController r12 = this.this$0;
        WidgetDefinitionMetadata r5 = this.$widget;
        int r13 = this.$instanceId;
        String r14 = this.$renderReason;
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L7
        Object r16 = Result.m124constructorimpl(r12.updateWidget(r5, r13, r14));     // Catch: Throwable -> L7
    L9:
        String r17 = this.$logTag;
        String r18 = this.$renderReason;
        int r19 = this.$instanceId;
        Throwable r20 = Result.m127exceptionOrNullimpl(r16);
        if (r20 == null) goto L13;
        Log.w(r17, "requestLatestWidgetPayload failed: reason=" + r18 + ", instance=" + r19, r20);
    L13:
        if (Result.m130isFailureimpl(r16) == false) goto L20;
        return null;
    L20:
        return r16;
    L7:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r16 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L9
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super String> r10) {
        return ((WidgetRenderSessionController$requestLatestWidgetPayload$payload$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
