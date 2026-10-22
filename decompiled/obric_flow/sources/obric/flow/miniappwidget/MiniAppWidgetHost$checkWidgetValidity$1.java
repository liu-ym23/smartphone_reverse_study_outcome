package obric.flow.miniappwidget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "obric.flow.miniappwidget.MiniAppWidgetHost", f = "MiniAppWidgetHost.kt", i = {0, 0}, l = {232}, m = "checkWidgetValidity", n = {"this", "request"}, s = {"L$0", "L$1"})
final class MiniAppWidgetHost$checkWidgetValidity$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ l this$0;

    public MiniAppWidgetHost$checkWidgetValidity$1(l r5, Continuation<? super MiniAppWidgetHost$checkWidgetValidity$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
