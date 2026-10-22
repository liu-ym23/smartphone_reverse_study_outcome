package com.obric.widget.host.runtime;

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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/widget/host/runtime/WidgetDataSnapshot;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.widget.host.runtime.WidgetRendererEngine$createWidgetDetailed$snapshot$1$1", f = "WidgetRendererEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WidgetRendererEngine$createWidgetDetailed$snapshot$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WidgetDataSnapshot>, Object> {
    final /* synthetic */ int $it;
    final /* synthetic */ WidgetDefinitionMetadata $widget;
    int label;
    final /* synthetic */ WidgetRendererEngine this$0;

    public WidgetRendererEngine$createWidgetDetailed$snapshot$1$1(WidgetRendererEngine r5, WidgetDefinitionMetadata r10, int r11, Continuation<? super WidgetRendererEngine$createWidgetDetailed$snapshot$1$1> r12) {
        this.this$0 = r5;
        this.$widget = r10;
        this.$it = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new WidgetRendererEngine$createWidgetDetailed$snapshot$1$1(this.this$0, this.$widget, this.$it, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super WidgetDataSnapshot> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        return WidgetRendererEngine.access$getRuntimeClient$p(this.this$0).queryWidgetData(this.$widget.getAppletId(), this.$widget.getWidgetId(), this.$it);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super WidgetDataSnapshot> r10) {
        return ((WidgetRendererEngine$createWidgetDetailed$snapshot$1$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
