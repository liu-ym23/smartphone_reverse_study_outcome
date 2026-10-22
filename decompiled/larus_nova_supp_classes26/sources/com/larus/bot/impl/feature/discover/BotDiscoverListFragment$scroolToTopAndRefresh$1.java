package com.larus.bot.impl.feature.discover;

import androidx.recyclerview.widget.RecyclerView;
import com.larus.bot.impl.common.view.BlockBringChildSwipeRefreshLayout;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListFragment$scroolToTopAndRefresh$1", f = "BotDiscoverListFragment.kt", i = {}, l = {908}, m = "invokeSuspend", n = {}, s = {})
public final class BotDiscoverListFragment$scroolToTopAndRefresh$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecyclerView $rv;
    final /* synthetic */ BlockBringChildSwipeRefreshLayout $sl;
    int label;
    final /* synthetic */ BotDiscoverListFragment this$0;

    public BotDiscoverListFragment$scroolToTopAndRefresh$1(RecyclerView r1, BlockBringChildSwipeRefreshLayout r2, BotDiscoverListFragment r3, Continuation<? super BotDiscoverListFragment$scroolToTopAndRefresh$1> r4) {
        this.$rv = r1;
        this.$sl = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotDiscoverListFragment$scroolToTopAndRefresh$1(this.$rv, this.$sl, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L13:
        this.$sl.setRefreshing(true);
        BotDiscoverListFragment r5 = this.this$0;
        int r2 = BotDiscoverListFragment.A;
        r5.aa0("refresh");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        if (this.$rv.computeVerticalScrollOffset() <= 0) goto L13;
        this.$rv.smoothScrollToPosition(0);
        RecyclerView r6 = this.$rv;
        this.label = 1;
        if (ViewExtKt.c(r6, this) != r0) goto L13;
        return r0;
    }
}
