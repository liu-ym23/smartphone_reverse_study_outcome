package com.obric.widget.host.internal;

import com.obric.widget.host.runtime.WidgetDataSnapshot;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.obric.widget.host.internal.DefaultHostedWidget$refreshInternal$widgetData$1", f = "DefaultHostedWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultHostedWidget$refreshInternal$widgetData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ String $reason;
    int label;
    final /* synthetic */ DefaultHostedWidget this$0;

    public DefaultHostedWidget$refreshInternal$widgetData$1(DefaultHostedWidget r5, String r10, Continuation<? super DefaultHostedWidget$refreshInternal$widgetData$1> r11) {
        this.this$0 = r5;
        this.$reason = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new DefaultHostedWidget$refreshInternal$widgetData$1(this.this$0, this.$reason, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super String> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r5);
        String r10 = DefaultHostedWidget.access$getRuntimeServices$p(this.this$0).updateWidget(DefaultHostedWidget.access$getMetadata$p(this.this$0).getAppletId(), DefaultHostedWidget.access$getMetadata$p(this.this$0).getWidgetId(), DefaultHostedWidget.access$getSnapshot$p(this.this$0).getHostWidgetInstanceId(), this.$reason);
        if (r10 != null) goto L13;
        WidgetDataSnapshot r11 = DefaultHostedWidget.access$getRuntimeServices$p(this.this$0).queryWidgetData(DefaultHostedWidget.access$getMetadata$p(this.this$0).getAppletId(), DefaultHostedWidget.access$getMetadata$p(this.this$0).getWidgetId(), DefaultHostedWidget.access$getSnapshot$p(this.this$0).getHostWidgetInstanceId());
        if (r11 != null) goto L14;
        return null;
    L14:
        return r11.getWidgetData();
    L13:
        return r10;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super String> r10) {
        return ((DefaultHostedWidget$refreshInternal$widgetData$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
