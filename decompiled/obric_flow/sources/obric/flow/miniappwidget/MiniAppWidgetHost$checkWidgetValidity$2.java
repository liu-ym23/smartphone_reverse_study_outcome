package obric.flow.miniappwidget;

import com.obric.widget.host.runtime.WidgetDefinitionMetadata;
import com.obric.widget.host.runtime.WidgetRuntimeServices;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lobric/flow/miniappwidget/o;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lobric/flow/miniappwidget/o;"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "obric.flow.miniappwidget.MiniAppWidgetHost$checkWidgetValidity$2", f = "MiniAppWidgetHost.kt", i = {}, l = {233}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppWidgetHost$checkWidgetValidity$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super o>, Object> {
    final /* synthetic */ n $request;
    int label;
    final /* synthetic */ l this$0;

    public MiniAppWidgetHost$checkWidgetValidity$2(l r5, n r10, Continuation<? super MiniAppWidgetHost$checkWidgetValidity$2> r11) {
        this.this$0 = r5;
        this.$request = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new MiniAppWidgetHost$checkWidgetValidity$2(this.this$0, this.$request, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super o> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        if (((WidgetDefinitionMetadata) r10) != null) goto L20;
        String r12 = this.this$0.f20491a;
        n r13 = this.$request;
        StringBuilder r14 = androidx.constraintlayout.motion.widget.a.y("checkWidgetValidity widgetInfo null, hostId=", r12, " appletId=", r13.f20505a, " widgetId=");
        r14.append(r13.f20506b);
        r14.append(" definitionId=");
        String r15 = androidx.room.jarjarred.org.antlr.runtime.a.w(r14, r13.d, "MiniAppWidgetHost", "tag", "msg");
        org.koin.core.a r16 = su.a.f22013b;
        if (r16 == null) goto L19;
        ((ju.b) r16.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).w("MiniAppWidgetHost", r15);
        return ib.d.f("widget_info_missing");
    L19:
        throw new IllegalStateException("KoinApplication has not been started");
    L20:
        return new o(MiniAppWidgetRuntimeValidity.VALID, null, null, null, false);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        WidgetRuntimeServices r17 = l.a(this.this$0);
        n r18 = this.$request;
        String r19 = r18.f20505a;
        this.label = 1;
        r10 = r17.getWidgetInfo(r19, r18.f20506b, this);
        if (r10 != r5) goto L12;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super o> r10) {
        return ((MiniAppWidgetHost$checkWidgetValidity$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
