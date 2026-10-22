package com.larus.bot.impl.feature.discover;

import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bot.impl.common.util.RecommendBotHelper;
import com.larus.bot.impl.feature.discover.adapter.BotDiscoverListAdapter;
import com.larus.common_ui.paging.FPagingAdapter;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListFragment$initViewModel$1", f = "BotDiscoverListFragment.kt", i = {}, l = {701}, m = "invokeSuspend", n = {}, s = {})
final class BotDiscoverListFragment$initViewModel$1 extends SuspendLambda implements Function2<List<? extends String>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BotDiscoverListFragment this$0;

    public BotDiscoverListFragment$initViewModel$1(BotDiscoverListFragment r1, Continuation<? super BotDiscoverListFragment$initViewModel$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotDiscoverListFragment$initViewModel$1 r0 = new BotDiscoverListFragment$initViewModel$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((List) r1, (Continuation) r2);
    }

    public final Object invoke(List<String> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        BotDiscoverListAdapter r2 = (BotDiscoverListAdapter) this.L$0;
        ResultKt.throwOnFailure(r6);
    L12:
        r2.E2((List) r6);
        FLogger.a.i("BotDiscoveryListFragment", "received filterSelectedBotsFlow");
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        List<String> r7 = (List) this.L$0;
        BotDiscoverListFragment r3 = this.this$0;
        int r4 = BotDiscoverListFragment.A;
        BotDiscoverListAdapter r5 = r3.Z90();
        RecommendBotHelper r8 = RecommendBotHelper.a;
        List<RecommendBot> r9 = ((FPagingAdapter) this.this$0.Z90()).b;
        this.L$0 = r5;
        this.label = 1;
        r6 = r8.a(r9, r7, this);
        if (r6 != r0) goto L11;
        return r0;
    L11:
        r2 = r5;
        goto L12
    }
}
