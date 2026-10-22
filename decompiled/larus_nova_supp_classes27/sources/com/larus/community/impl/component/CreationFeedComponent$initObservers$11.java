package com.larus.community.impl.component;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.larus.community.api.tracker.CreationFeedBehaviorTracker;
import com.larus.platform.api.creation.UserCreation;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/community/impl/view/RefreshState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.component.CreationFeedComponent$initObservers$11", f = "CreationFeedComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CreationFeedComponent$initObservers$11 extends SuspendLambda implements Function2<r29.l, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ CreationFeedComponent this$0;

    public CreationFeedComponent$initObservers$11(CreationFeedComponent r1, Continuation<? super CreationFeedComponent$initObservers$11> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        CreationFeedComponent$initObservers$11 r0 = new CreationFeedComponent$initObservers$11(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((r29.l) r1, (Continuation) r2);
    }

    public final Object invoke(r29.l r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        boolean r5 = ((r29.l) this.L$0) instanceof r29.l.b;
        if (r5 == false) goto L7;
        this.this$0.F.a(CreationFeedBehaviorTracker.ExposurePauseReason.DATA_REFRESH);
    L8:
        SwipeRefreshLayout r0 = this.this$0.n.b();
        if (r0 == null) goto L12;
        r0.setRefreshing(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        CreationFeedBehaviorTracker<UserCreation> r1 = this.this$0.F;
        CreationFeedBehaviorTracker.ExposurePauseReason r2 = CreationFeedBehaviorTracker.ExposurePauseReason.DATA_REFRESH;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "reason");
        r1.h.remove(r2);
        this.this$0.G3();
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
