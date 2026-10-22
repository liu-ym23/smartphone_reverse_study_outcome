package obric.flow.miniappwidget;

import android.os.Messenger;
import com.obric.widget.host.runtime.WidgetRuntimeServices;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "obric.flow.miniappwidget.MiniAppWidgetHost$registerAllMessengers$1$1$1", f = "MiniAppWidgetHost.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppWidgetHost$registerAllMessengers$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $hostInstanceId;
    final /* synthetic */ a $widget;
    int label;
    final /* synthetic */ l this$0;

    public MiniAppWidgetHost$registerAllMessengers$1$1$1(l r5, a r10, Integer r11, Continuation<? super MiniAppWidgetHost$registerAllMessengers$1$1$1> r12) {
        this.this$0 = r5;
        this.$widget = r10;
        this.$hostInstanceId = r11;
        super(1, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r5) {
        return new MiniAppWidgetHost$registerAllMessengers$1$1$1(this.this$0, this.$widget, this.$hostInstanceId, r5);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r5) {
        return invoke2(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        WidgetRuntimeServices r10 = l.a(this.this$0);
        a r11 = this.$widget;
        String r12 = r11.d;
        int r13 = this.$hostInstanceId.intValue();
        Messenger r14 = this.this$0.f20497k;
        r10.registerWidgetMessenger(r12, r11.e, r13, r14);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r5) {
        return ((MiniAppWidgetHost$registerAllMessengers$1$1$1) create(r5)).invokeSuspend(Unit.INSTANCE);
    }
}
