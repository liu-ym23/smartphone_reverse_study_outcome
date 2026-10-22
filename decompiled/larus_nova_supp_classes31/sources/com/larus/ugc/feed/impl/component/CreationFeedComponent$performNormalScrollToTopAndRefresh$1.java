package com.larus.ugc.feed.impl.component;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.larus.common_ui.utils.ViewExtKt;
import com.larus.ugc.feed.impl.ability.CreationFeedAbilityImpl;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.ugc.feed.impl.component.CreationFeedComponent$performNormalScrollToTopAndRefresh$1", f = "CreationFeedComponent.kt", i = {}, l = {1089, 1093}, m = "invokeSuspend", n = {}, s = {})
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

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r6);
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
    L18:
        if (this.$notRefresh == true) goto L25;
        this.$refreshLayout.setRefreshing(true);
        CreationFeedComponent r7 = this.this$0;
        int r2 = CreationFeedComponent.H;
        CreationFeedAbilityImpl r8 = r7.B3();
        if (r8 == null) goto L25;
        this.label = 2;
        if (r8.q("scrollToTopAndRefresh2", true) != r0) goto L25;
        return r0;
    L10:
        ResultKt.throwOnFailure(r6);
        if (this.$recyclerView.computeVerticalScrollOffset() <= 0) goto L18;
        CreationFeedComponent r9 = this.this$0;
        Long r3 = this.$smoothScrollDuration;
        int r4 = CreationFeedComponent.H;
        r9.E3(r3);
        RecyclerView r10 = this.this$0.o.a();
        if (r10 == null) goto L18;
        this.label = 1;
        if (ViewExtKt.c(r10, this) != r0) goto L18;
        return r0;
    }
}
