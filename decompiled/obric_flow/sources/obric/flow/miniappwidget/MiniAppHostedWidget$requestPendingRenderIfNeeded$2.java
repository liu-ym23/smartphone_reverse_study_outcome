package obric.flow.miniappwidget;

import ai.j0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "obric.flow.miniappwidget.MiniAppHostedWidget$requestPendingRenderIfNeeded$2", f = "MiniAppHostedWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppHostedWidget$requestPendingRenderIfNeeded$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $renderDataKey;
    final /* synthetic */ String $renderReason;
    final /* synthetic */ String $trigger;
    int label;
    final /* synthetic */ a this$0;

    public MiniAppHostedWidget$requestPendingRenderIfNeeded$2(a r5, String r10, String r11, String r12, Continuation<? super MiniAppHostedWidget$requestPendingRenderIfNeeded$2> r13) {
        this.this$0 = r5;
        this.$trigger = r10;
        this.$renderReason = r11;
        this.$renderDataKey = r12;
        super(1, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new MiniAppHostedWidget$requestPendingRenderIfNeeded$2(this.this$0, this.$trigger, this.$renderReason, this.$renderDataKey, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r5) {
        return invoke2(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r10);
        a r11 = this.this$0;
        String r5 = r11.f20456a;
        String r12 = this.$trigger;
        String r13 = this.$renderReason;
        StringBuilder r14 = j0.x("invalidate pending render hostId=", r5, " instanceId=");
        r14.append(r11.f20457b);
        r14.append(" cardId=");
        r14.append(r11.f20458c);
        r14.append(" appletId=");
        r14.append(r11.d);
        r14.append(" widgetId=");
        androidx.constraintlayout.motion.widget.a.C(r14, r11.e, " trigger=", r12, " reason=");
        String r15 = androidx.room.jarjarred.org.antlr.runtime.a.w(r14, r13, "MiniAppHostedWidget", "tag", "msg");
        org.koin.core.a r16 = su.a.f22013b;
        if (r16 == null) goto L9;
        ((ju.b) r16.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(ju.b.class), null)).i("MiniAppHostedWidget", r15);
        a r17 = this.this$0;
        r17.f20460i.invoke(r17, this.$renderReason, this.$renderDataKey);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("KoinApplication has not been started");
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r5) {
        return ((MiniAppHostedWidget$requestPendingRenderIfNeeded$2) create(r5)).invokeSuspend(Unit.INSTANCE);
    }
}
