package obric.flow.overlay;

import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.d;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.p;
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
@DebugMetadata(c = "obric.flow.overlay.AssistantOverlayService$AssistantBinder$openOverlay$1", f = "AssistantOverlayService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AssistantOverlayService$AssistantBinder$openOverlay$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ b this$0;

    public AssistantOverlayService$AssistantBinder$openOverlay$1(b r5, Continuation<? super AssistantOverlayService$AssistantBinder$openOverlay$1> r10) {
        this.this$0 = r5;
        super(1, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r5) {
        return new AssistantOverlayService$AssistantBinder$openOverlay$1(this.this$0, r5);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r5) {
        return invoke2(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r5);
        AssistantOverlayService r10 = (AssistantOverlayService) this.this$0.f20532a.get();
        if (r10 == null) goto L12;
        CardFeedLayout r11 = r10.f20529b;
        if (r11 == null) goto L12;
        p r12 = r11.G;
        if (r12 == null) goto L12;
        r12.f(new d(true, true));
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r5) {
        return ((AssistantOverlayService$AssistantBinder$openOverlay$1) create(r5)).invokeSuspend(Unit.INSTANCE);
    }
}
