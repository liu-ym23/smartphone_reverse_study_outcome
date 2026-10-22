package com.larus.bot.impl.feature.discover;

import android.content.Context;
import com.larus.bmhome.ConversationChangeModel;
import com.larus.bmhome.bot.BotStatusCacheDelegate;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.platform.model.RecommendFrom;
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
@DebugMetadata(c = "com.larus.bot.impl.feature.discover.BotDiscoverListFragment$setupRecyclerView$1$2$onBotRemove$1$1$confirm$1", f = "BotDiscoverListFragment.kt", i = {0}, l = {532}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class BotDiscoverListFragment$setupRecyclerView$1$2$onBotRemove$1$1$confirm$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RecommendBot $data;
    final /* synthetic */ int $position;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BotDiscoverListFragment this$0;

    public BotDiscoverListFragment$setupRecyclerView$1$2$onBotRemove$1$1$confirm$1(BotDiscoverListFragment r1, RecommendBot r2, int r3, Continuation<? super BotDiscoverListFragment$setupRecyclerView$1$2$onBotRemove$1$1$confirm$1> r4) {
        this.this$0 = r1;
        this.$data = r2;
        this.$position = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        BotDiscoverListFragment$setupRecyclerView$1$2$onBotRemove$1$1$confirm$1 r0 = new BotDiscoverListFragment$setupRecyclerView$1$2$onBotRemove$1$1$confirm$1(this.this$0, this.$data, this.$position, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r3 = "";
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L17:
        Boolean r13 = (Boolean) r12;
        if (r13 == null) goto L39;
        r13.booleanValue();
        ConversationChangeModel r14 = (ConversationChangeModel) this.this$0.g.getValue();
        String r4 = this.$data.o();
        if (r4 != null) goto L22;
        r4 = "";
    L22:
        r14.sendConversationListChangeEvent(r4);
        this.$data.G0("");
        BotStatusCacheDelegate r15 = BotStatusCacheDelegate.b;
        String r5 = this.$data.o();
        if (r5 == null) goto L26;
        r3 = r5;
    L26:
        r15.a(r3, false);
        this.this$0.Z90().notifyItemChanged(this.$position);
        BotDiscoverListFragment r9 = this.this$0;
        RecommendBot r16 = this.$data;
        r9.getClass();
        String r6 = r16.o();
        if (com.larus.utils.o0.d(r16.e()) == false) goto L29;
        String r7 = "1";
    L30:
        String r8 = r7;
        RecommendFrom r17 = r16.a;
        if (r17 == null) goto L33;
        String r10 = r17.b;
    L34:
        if (r17 == null) goto L36;
        String r11 = r17.a;
    L37:
        tx9.g0.a(r6, r8, null, r11, r10, null, null, null, r9, 31988);
        return Unit.INSTANCE;
    L36:
        r11 = null;
        goto L37
    L33:
        r10 = null;
        goto L34
    L29:
        r7 = TriggerSendLoading.NO_LOADING;
        goto L30
    L39:
        BotDiscoverListFragment r18 = this.this$0;
        t19.s r19 = t19.s.a;
        Context r110 = r18.getContext();
        r19.getClass();
        t19.s.b(r110, 2131901588, false);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        CoroutineScope r111 = (CoroutineScope) this.L$0;
        BotDiscoverListFragment r20 = this.this$0;
        int r21 = BotDiscoverListFragment.A;
        BotDiscoverListModel r22 = r20.Y90();
        String r23 = this.$data.E();
        if (r23 != null) goto L11;
        r23 = "";
    L11:
        String r24 = this.$data.o();
        if (r24 != null) goto L14;
        r24 = "";
    L14:
        this.L$0 = r111;
        this.label = 1;
        r12 = r22.removeConversationByBot(r23, r24, this);
        if (r12 != r0) goto L17;
        return r0;
    }
}
