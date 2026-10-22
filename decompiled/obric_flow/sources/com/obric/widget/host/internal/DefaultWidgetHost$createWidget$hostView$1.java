package com.obric.widget.host.internal;

import android.view.View;
import com.obric.widget.host.runtime.WidgetDefinitionMetadata;
import com.obric.widget.host.runtime.WidgetInstanceSnapshot;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/widget/host/internal/DefaultWidgetHostView;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.widget.host.internal.DefaultWidgetHost$createWidget$hostView$1", f = "DefaultWidgetHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nDefaultWidgetHost.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DefaultWidgetHost.kt\ncom/obric/widget/host/internal/DefaultWidgetHost$createWidget$hostView$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,359:1\n1#2:360\n*E\n"})
public final class DefaultWidgetHost$createWidget$hostView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DefaultWidgetHostView>, Object> {
    final /* synthetic */ WidgetInstanceSnapshot $snapshot;
    final /* synthetic */ WidgetDefinitionMetadata $widgetMetadata;
    final /* synthetic */ View $widgetView;
    int label;
    final /* synthetic */ DefaultWidgetHost this$0;

    public DefaultWidgetHost$createWidget$hostView$1(DefaultWidgetHost r5, WidgetDefinitionMetadata r10, WidgetInstanceSnapshot r11, View r12, Continuation<? super DefaultWidgetHost$createWidget$hostView$1> r13) {
        this.this$0 = r5;
        this.$widgetMetadata = r10;
        this.$snapshot = r11;
        this.$widgetView = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DefaultWidgetHost$createWidget$hostView$1(this.this$0, this.$widgetMetadata, this.$snapshot, this.$widgetView, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super DefaultWidgetHostView> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        DefaultWidgetHostView r11 = new DefaultWidgetHostView(DefaultWidgetHost.access$getViewContext$p(this.this$0), this.this$0.getHostId(), this.$widgetMetadata, this.$snapshot, DefaultWidgetHost.access$getRuntimeServices$p(this.this$0), DefaultWidgetHost.access$getContract$p(this.this$0), DefaultWidgetHost.access$getScope$p(this.this$0));
        r11.setWidgetView(this.$widgetView);
        return r11;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super DefaultWidgetHostView> r10) {
        return ((DefaultWidgetHost$createWidget$hostView$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
