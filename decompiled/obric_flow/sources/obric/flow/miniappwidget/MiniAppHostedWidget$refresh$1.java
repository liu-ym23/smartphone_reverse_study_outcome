package obric.flow.miniappwidget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "obric.flow.miniappwidget.MiniAppHostedWidget", f = "MiniAppHostedWidget.kt", i = {0, 0, 0}, l = {70}, m = "refresh", n = {"this_$iv", "action$iv", "fallback$iv"}, s = {"L$0", "L$1", "L$2"})
final class MiniAppHostedWidget$refresh$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a this$0;

    public MiniAppHostedWidget$refresh$1(a r5, Continuation<? super MiniAppHostedWidget$refresh$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(this);
    }
}
