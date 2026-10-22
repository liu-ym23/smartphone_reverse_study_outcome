package obric.flow.overlay;

import com.obric.flow.cardlistpage.ui.CardFeedLayout;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.p;
import com.obric.flow.cardlistpage.ui.component.overlayanimator.w;
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
@DebugMetadata(c = "obric.flow.overlay.AssistantOverlayService$AssistantBinder$onOverlayHidden$1", f = "AssistantOverlayService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AssistantOverlayService$AssistantBinder$onOverlayHidden$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $animate;
    int label;
    final /* synthetic */ b this$0;

    public AssistantOverlayService$AssistantBinder$onOverlayHidden$1(boolean r5, b r10, Continuation<? super AssistantOverlayService$AssistantBinder$onOverlayHidden$1> r11) {
        this.$animate = r5;
        this.this$0 = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r5) {
        return new AssistantOverlayService$AssistantBinder$onOverlayHidden$1(this.$animate, this.this$0, r5);
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
        String r10 = "onOverlayHidden: animate=" + this.$animate;
        Intrinsics.checkNotNullParameter("AssistantOverlayService", "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        org.koin.core.a r11 = su.a.f22013b;
        if (r11 == null) goto L16;
        ((ju.b) r11.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).d("AssistantOverlayService", r10);
        AssistantOverlayService r12 = (AssistantOverlayService) this.this$0.f20532a.get();
        if (r12 == null) goto L14;
        CardFeedLayout r13 = r12.f20529b;
        if (r13 == null) goto L14;
        boolean r14 = this.$animate;
        r13.h();
        p r15 = r13.G;
        if (r15 == null) goto L14;
        w r16 = new w(r14);
        Intrinsics.checkNotNullParameter(r16, "intent");
        r15.d(r16);
    L14:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("KoinApplication has not been started");
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r5) {
        return ((AssistantOverlayService$AssistantBinder$onOverlayHidden$1) create(r5)).invokeSuspend(Unit.INSTANCE);
    }
}
