package com.larus.bmhome.chat.layout.item;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.im.bean.IMMetaInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.service.AccountService;
import com.larus.search.api.event.HybridEventParams;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.item.CitationItemLayout$socialBindData$2$2", f = "CitationItemLayout.kt", i = {1}, l = {97, 98}, m = "invokeSuspend", n = {"conversation"}, s = {"L$0"})
final class CitationItemLayout$socialBindData$2$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ IBotRepoService $botRepo;
    final /* synthetic */ IConversationRepoService $conversationRepo;
    final /* synthetic */ View $it;
    final /* synthetic */ IMMetaInfo.c $ref;
    Object L$0;
    int label;

    public CitationItemLayout$socialBindData$2$2(IConversationRepoService r1, String r2, IBotRepoService r3, View r4, IMMetaInfo.c r5, Continuation<? super CitationItemLayout$socialBindData$2$2> r6) {
        this.$conversationRepo = r1;
        this.$botId = r2;
        this.$botRepo = r3;
        this.$it = r4;
        this.$ref = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CitationItemLayout$socialBindData$2$2(this.$conversationRepo, this.$botId, this.$botRepo, this.$it, this.$ref, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        wc9.e r2 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r13);
    L17:
        BotModel r14 = (BotModel) r13;
        boolean r3 = Intrinsics.areEqual(this.$botId, AccountService.a.getUserId());
        com.larus.platform.service.q r4 = com.larus.platform.service.q.a;
        Context r5 = this.$it.getContext();
        Bundle r6 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("link_url", this.$ref.f()), TuplesKt.to("enable_bottom_share_style", String.valueOf(com.larus.platform.service.z2.a.S2()))});
        LruCache r7 = ko8.a.a;
        Integer r8 = null;
        if (r2 == null) goto L20;
        Integer r9 = r2.v;
    L21:
        if (r14 == null) goto L23;
        r8 = r14.getBotType();
    L23:
        r4.e(r5, r6, new HybridEventParams("index_entrance", "chat", ko8.a.f(r9, r8, r3), null, 120));
        return Unit.INSTANCE;
    L20:
        r9 = null;
        goto L21
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r13);
    L13:
        wc9.e r15 = (wc9.e) r13;
        IBotRepoService r10 = this.$botRepo;
        String r11 = this.$botId;
        this.L$0 = r15;
        this.label = 2;
        Object r12 = IBotRepoService.b.a(r10, r11, false, null, false, this, 30);
        if (r12 != r0) goto L16;
        return r0;
    L16:
        r2 = r15;
        r13 = r12;
        goto L17
    L10:
        ResultKt.throwOnFailure(r13);
        IConversationRepoService r16 = this.$conversationRepo;
        String r17 = this.$botId;
        this.label = 1;
        r13 = r16.m(r17, this);
        if (r13 != r0) goto L13;
        return r0;
    }
}
