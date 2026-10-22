package obric.flow.miniappwidget;

import com.obric.widget.host.runtime.WidgetRuntimeServices;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "obric.flow.miniappwidget.MiniAppWidgetHost$destroyWidget$1", f = "MiniAppWidgetHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppWidgetHost$destroyWidget$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ Integer $hostInstanceId;
    final /* synthetic */ String $widgetId;
    int label;
    final /* synthetic */ l this$0;

    public MiniAppWidgetHost$destroyWidget$1(l r5, Integer r10, String r11, String r12, Continuation<? super MiniAppWidgetHost$destroyWidget$1> r13) {
        this.this$0 = r5;
        this.$hostInstanceId = r10;
        this.$appletId = r11;
        this.$widgetId = r12;
        super(1, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new MiniAppWidgetHost$destroyWidget$1(this.this$0, this.$hostInstanceId, this.$appletId, this.$widgetId, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r5) {
        return invoke2(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r5);
        WidgetRuntimeServices r10 = l.a(this.this$0);
        r10.unregisterWidgetMessenger(this.$hostInstanceId.intValue(), this.$appletId, this.$widgetId);
        String r11 = this.$appletId;
        if (r11 != null) goto L7;
    L15:
        r10.clearWidgetData(this.$hostInstanceId.intValue(), this.$appletId, this.$widgetId);
        return Unit.INSTANCE;
    L7:
        if (StringsKt.isBlank(r11) == true) goto L15;
        String r12 = this.$widgetId;
        if (r12 == null) goto L15;
        if (StringsKt.isBlank(r12) == true) goto L15;
        r10.dispatchWidgetUnbind(this.$appletId, this.$widgetId, this.$hostInstanceId.intValue());
        goto L15
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r5) {
        return ((MiniAppWidgetHost$destroyWidget$1) create(r5)).invokeSuspend(Unit.INSTANCE);
    }
}
