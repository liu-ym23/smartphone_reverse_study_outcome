package obric.flow.overlay;

import com.obric.flow.cardlistpage.ui.CardFeedLayout;
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
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "obric.flow.overlay.AssistantOverlayService$AssistantBinder$onFlingVelocity$1", f = "AssistantOverlayService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AssistantOverlayService$AssistantBinder$onFlingVelocity$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ AssistantOverlayService $service;
    final /* synthetic */ float $velocity;
    int label;
    final /* synthetic */ b this$0;

    public AssistantOverlayService$AssistantBinder$onFlingVelocity$1(float r5, b r10, AssistantOverlayService r11, Continuation<? super AssistantOverlayService$AssistantBinder$onFlingVelocity$1> r12) {
        this.$velocity = r5;
        this.this$0 = r10;
        this.$service = r11;
        super(1, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r5) {
        return new AssistantOverlayService$AssistantBinder$onFlingVelocity$1(this.$velocity, this.this$0, this.$service, r5);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r5) {
        return invoke2(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r5);
        String r10 = "onFlingVelocity: velocity=" + this.$velocity + " isBeingDragged：" + this.this$0.f20533b + " after";
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        org.koin.core.a r11 = su.a.f22013b;
        if (r11 == null) goto L14;
        ((ju.b) r11.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("AssistantOverlayService", r10);
        CardFeedLayout r12 = this.$service.f20529b;
        if (r12 == null) goto L12;
        float r13 = this.$velocity;
        p r14 = r12.G;
        if (r14 == null) goto L12;
        r14.f(new com.obric.flow.cardlistpage.ui.component.overlayanimator.b(r13, false));
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("KoinApplication has not been started");
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r5) {
        return ((AssistantOverlayService$AssistantBinder$onFlingVelocity$1) create(r5)).invokeSuspend(Unit.INSTANCE);
    }
}
