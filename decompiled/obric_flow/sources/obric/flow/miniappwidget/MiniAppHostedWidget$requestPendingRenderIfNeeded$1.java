package obric.flow.miniappwidget;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "obric.flow.miniappwidget.MiniAppHostedWidget$requestPendingRenderIfNeeded$1", f = "MiniAppHostedWidget.kt", i = {}, l = {216}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppHostedWidget$requestPendingRenderIfNeeded$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ long $remainingDebounceMs;
    final /* synthetic */ String $trigger;
    int label;
    final /* synthetic */ a this$0;

    public MiniAppHostedWidget$requestPendingRenderIfNeeded$1(long r5, a r10, String r11, Continuation<? super MiniAppHostedWidget$requestPendingRenderIfNeeded$1> r12) {
        this.$remainingDebounceMs = r5;
        this.this$0 = r10;
        this.$trigger = r11;
        super(1, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        return new MiniAppHostedWidget$requestPendingRenderIfNeeded$1(this.$remainingDebounceMs, this.this$0, this.$trigger, r10);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r5) {
        return invoke2(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        this.this$0.g("debounced:" + this.$trigger);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        long r12 = this.$remainingDebounceMs;
        this.label = 1;
        if (DelayKt.delay(r12, this) != r5) goto L11;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r5) {
        return ((MiniAppHostedWidget$requestPendingRenderIfNeeded$1) create(r5)).invokeSuspend(Unit.INSTANCE);
    }
}
