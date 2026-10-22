package com.larus.community.impl.component;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.larus.common_ui.utils.ViewExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.component.CreationFeedComponent$performNormalScrollToTopAndRefresh$1", f = "CreationFeedComponent.kt", i = {}, l = {1411}, m = "invokeSuspend", n = {}, s = {})
final class CreationFeedComponent$performNormalScrollToTopAndRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $notRefresh;
    final /* synthetic */ RecyclerView $recyclerView;
    final /* synthetic */ SwipeRefreshLayout $refreshLayout;
    final /* synthetic */ Long $smoothScrollDuration;
    int label;
    final /* synthetic */ CreationFeedComponent this$0;

    public CreationFeedComponent$performNormalScrollToTopAndRefresh$1(RecyclerView r1, CreationFeedComponent r2, Long r3, boolean r4, SwipeRefreshLayout r5, Continuation<? super CreationFeedComponent$performNormalScrollToTopAndRefresh$1> r6) {
        this.$recyclerView = r1;
        this.this$0 = r2;
        this.$smoothScrollDuration = r3;
        this.$notRefresh = r4;
        this.$refreshLayout = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CreationFeedComponent$performNormalScrollToTopAndRefresh$1(this.$recyclerView, this.this$0, this.$smoothScrollDuration, this.$notRefresh, this.$refreshLayout, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L16:
        if (this.$notRefresh == true) goto L19;
        this.$refreshLayout.setRefreshing(true);
        CreationFeedComponent r6 = this.this$0;
        int r2 = CreationFeedComponent.K;
        r6.C3().refresh("scrollToTopAndRefresh2", true);
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        if (this.$recyclerView.computeVerticalScrollOffset() <= 0) goto L16;
        CreationFeedComponent r7 = this.this$0;
        Long r3 = this.$smoothScrollDuration;
        int r4 = CreationFeedComponent.K;
        r7.E3(r3);
        RecyclerView r8 = this.this$0.n.a();
        if (r8 == null) goto L16;
        this.label = 1;
        if (ViewExtKt.c(r8, this) != r0) goto L16;
        return r0;
    }
}
