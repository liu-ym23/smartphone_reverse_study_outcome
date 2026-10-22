package obric.flow.miniappwidget;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "obric.flow.miniappwidget.MiniAppWidgetHost", f = "MiniAppWidgetHost.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2}, l = {750, 570, 572}, m = "createOrRestoreWidget", n = {"this", "card", "hostInstanceId", "creationLock", "$this$withLock_u24default$iv", "restore", "this", "card", "hostInstanceId", "creationLock", "$this$withLock_u24default$iv", "this_$iv", "action$iv", "restore", "this", "card", "hostInstanceId", "creationLock", "$this$withLock_u24default$iv", "this_$iv", "action$iv", "restore"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0"})
final class MiniAppWidgetHost$createOrRestoreWidget$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ l this$0;

    public MiniAppWidgetHost$createOrRestoreWidget$1(l r5, Continuation<? super MiniAppWidgetHost$createOrRestoreWidget$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, false, this);
    }
}
