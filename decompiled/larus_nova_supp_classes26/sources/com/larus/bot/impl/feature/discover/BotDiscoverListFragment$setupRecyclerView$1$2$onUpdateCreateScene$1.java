package com.larus.bot.impl.feature.discover;

import android.content.Context;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.utils.a4;
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
@DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListFragment$setupRecyclerView$1$2$onUpdateCreateScene$1", f = "BotDiscoverListFragment.kt", i = {}, l = {514}, m = "invokeSuspend", n = {}, s = {})
public final class BotDiscoverListFragment$setupRecyclerView$1$2$onUpdateCreateScene$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $data;
    final /* synthetic */ int $position;
    int label;
    final /* synthetic */ BotDiscoverListFragment this$0;

    public BotDiscoverListFragment$setupRecyclerView$1$2$onUpdateCreateScene$1(RecommendBot r1, BotDiscoverListFragment r2, int r3, Continuation<? super BotDiscoverListFragment$setupRecyclerView$1$2$onUpdateCreateScene$1> r4) {
        this.$data = r1;
        this.this$0 = r2;
        this.$position = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BotDiscoverListFragment$setupRecyclerView$1$2$onUpdateCreateScene$1(this.$data, this.this$0, this.$position, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r3 = "";
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L18:
        if (((Boolean) r8).booleanValue() == true) goto L25;
        BotStatusCacheDelegate r9 = BotStatusCacheDelegate.b;
        String r2 = this.$data.o();
        if (r2 == null) goto L23;
        r3 = r2;
    L23:
        r9.d(r3, true);
        BotDiscoverListFragment r10 = this.this$0;
        int r4 = BotDiscoverListFragment.A;
        r10.Z90().notifyItemChanged(this.$position);
        t19.s r11 = t19.s.a;
        Context r5 = this.this$0.getContext();
        r11.getClass();
        t19.s.b(r5, 2131908080, false);
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        a4.a.getClass();
        a4.a(a4.b);
        BotStatusCacheDelegate r12 = BotStatusCacheDelegate.b;
        String r6 = this.$data.o();
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r12.d(r6, false);
        BotDiscoverListFragment r13 = this.this$0;
        int r7 = BotDiscoverListFragment.A;
        r13.Z90().notifyItemChanged(this.$position);
        BotDiscoverListFragment.T90(this.this$0, this.$data);
        IConversationRepoService r14 = RepoDispatcherDelegate.b.f();
        String r15 = this.$data.E();
        if (r15 != null) goto L14;
        r15 = "";
    L14:
        this.label = 1;
        r8 = r14.s(r15, this);
        if (r8 != r0) goto L18;
        return r0;
    }
}
