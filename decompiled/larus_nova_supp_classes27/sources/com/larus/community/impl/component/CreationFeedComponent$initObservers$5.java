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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "list", "Lcom/larus/community/impl/component/InvokeNotifyEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.component.CreationFeedComponent$initObservers$5", f = "CreationFeedComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationFeedComponent$initObservers$5 extends SuspendLambda implements Function2<q1, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CreationFeedComponent this$0;

    public CreationFeedComponent$initObservers$5(CreationFeedComponent r1, Continuation<? super CreationFeedComponent$initObservers$5> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CreationFeedComponent$initObservers$5(this.this$0, r3);
    }

    public final Object invoke(q1 r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((q1) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        CreationListAdapter r3 = this.this$0.s;
        if (r3 == null) goto L7;
        r3.notifyDataSetChanged();
    L7:
        this.this$0.G3();
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
