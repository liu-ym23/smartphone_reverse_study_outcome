package obric.flow.overlay;

import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.f;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.p;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "obric.flow.overlay.AssistantOverlayService$AssistantBinder$onScrollChange$1", f = "AssistantOverlayService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AssistantOverlayService$AssistantBinder$onScrollChange$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ float $progress;
    final /* synthetic */ boolean $rtl;
    final /* synthetic */ AssistantOverlayService $service;
    int label;

    public AssistantOverlayService$AssistantBinder$onScrollChange$1(AssistantOverlayService r5, float r10, boolean r11, Continuation<? super AssistantOverlayService$AssistantBinder$onScrollChange$1> r12) {
        this.$service = r5;
        this.$progress = r10;
        this.$rtl = r11;
        super(1, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r5) {
        return new AssistantOverlayService$AssistantBinder$onScrollChange$1(this.$service, this.$progress, this.$rtl, r5);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r5) {
        return invoke2(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r5);
        CardFeedLayout r10 = this.$service.f20529b;
        if (r10 == null) goto L10;
        float r11 = this.$progress;
        boolean r12 = this.$rtl;
        Intrinsics.checkNotNullParameter("onScrollChange", "desc");
        p r13 = r10.G;
        if (r13 == null) goto L10;
        r13.f(new f(r11, r12, "onScrollChange"));
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r5) {
        return ((AssistantOverlayService$AssistantBinder$onScrollChange$1) create(r5)).invokeSuspend(Unit.INSTANCE);
    }
}
