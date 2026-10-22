package com.larus.community.impl.component;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.larus.community.impl.adapter.CreationListAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/community/impl/view/PageState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.component.CreationFeedComponent$initObservers$9", f = "CreationFeedComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationFeedComponent$initObservers$9 extends SuspendLambda implements Function2<r29.k, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationFeedComponent this$0;

    public CreationFeedComponent$initObservers$9(CreationFeedComponent r1, Continuation<? super CreationFeedComponent$initObservers$9> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CreationFeedComponent$initObservers$9 r0 = new CreationFeedComponent$initObservers$9(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((r29.k) r1, (Continuation) r2);
    }

    public final Object invoke(r29.k r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r3);
        r29.k r4 = (r29.k) this.L$0;
        if ((r4 instanceof r29.k.e) == false) goto L7;
    L8:
        SwipeRefreshLayout r0 = this.this$0.n.b();
        if (r0 == null) goto L11;
        r0.setEnabled(true);
    L11:
        CreationListAdapter r1 = this.this$0.s;
        if (r1 == null) goto L15;
        Intrinsics.checkNotNullParameter(r4, "state");
        r1.q = r4;
        m29.a.a("CreationListAdapter", new g29.a(r4));
        r1.notifyDataSetChanged();
    L15:
        return Unit.INSTANCE;
    L7:
        if ((r4 instanceof r29.k.a) == false) goto L11;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
