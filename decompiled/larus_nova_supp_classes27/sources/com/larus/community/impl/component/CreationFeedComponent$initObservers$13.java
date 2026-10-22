package com.larus.community.impl.component;

import com.larus.community.impl.adapter.CreationListAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/profile/api/model/MoreState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.component.CreationFeedComponent$initObservers$13", f = "CreationFeedComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationFeedComponent$initObservers$13 extends SuspendLambda implements Function2<gs9.i, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationFeedComponent this$0;

    public CreationFeedComponent$initObservers$13(CreationFeedComponent r1, Continuation<? super CreationFeedComponent$initObservers$13> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CreationFeedComponent$initObservers$13 r0 = new CreationFeedComponent$initObservers$13(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(gs9.i r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((gs9.i) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r2);
        gs9.i r3 = (gs9.i) this.L$0;
        if (r3 == null) goto L10;
        CreationListAdapter r0 = this.this$0.s;
        if (r0 == null) goto L10;
        r0.B2(r3);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
