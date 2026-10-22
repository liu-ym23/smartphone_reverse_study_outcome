package com.obric.widget.host.internal;

import android.content.Context;
import android.view.View;
import com.obric.widget.host.runtime.WidgetDefinitionMetadata;
import com.obric.widget.host.runtime.WidgetRuntimeServices;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/view/View;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.widget.host.internal.DefaultWidgetHost$createWidget$widgetView$1", f = "DefaultWidgetHost.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultWidgetHost$createWidget$widgetView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super View>, Object> {
    final /* synthetic */ int $instanceId;
    final /* synthetic */ WidgetDefinitionMetadata $widgetMetadata;
    int label;
    final /* synthetic */ DefaultWidgetHost this$0;

    public DefaultWidgetHost$createWidget$widgetView$1(DefaultWidgetHost r5, WidgetDefinitionMetadata r10, int r11, Continuation<? super DefaultWidgetHost$createWidget$widgetView$1> r12) {
        this.this$0 = r5;
        this.$widgetMetadata = r10;
        this.$instanceId = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new DefaultWidgetHost$createWidget$widgetView$1(this.this$0, this.$widgetMetadata, this.$instanceId, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super View> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        WidgetRuntimeServices r12 = DefaultWidgetHost.access$getRuntimeServices$p(this.this$0);
        Context r13 = DefaultWidgetHost.access$getViewContext$p(this.this$0);
        WidgetDefinitionMetadata r14 = this.$widgetMetadata;
        Integer r15 = Boxing.boxInt(this.$instanceId);
        this.label = 1;
        r10 = r12.createWidget(r13, r14, r15, this);
        if (r10 != r5) goto L11;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super View> r10) {
        return ((DefaultWidgetHost$createWidget$widgetView$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
