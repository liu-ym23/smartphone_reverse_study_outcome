package com.larus.bmhome.chat.model;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.api.BotApi;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel$getRecommendBotList$1", f = "ConversationListModel.kt", i = {0}, l = {257, 279}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class ConversationListModel$getRecommendBotList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $loadMore;
    private /* synthetic */ Object L$0;
    int label;

    public ConversationListModel$getRecommendBotList$1(boolean r1, Continuation<? super ConversationListModel$getRecommendBotList$1> r2) {
        this.$loadMore = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ConversationListModel$getRecommendBotList$1 r0 = new ConversationListModel$getRecommendBotList$1(this.$loadMore, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r19);
    L44:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CoroutineScope r1 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r2 = r19;
        int r17 = 1;
    L17:
        ic8.o0 r3 = (ic8.o0) r2;
        int r4 = 0;
        if (r3 == null) goto L20;
        ConversationListModel.y++;
        ConversationListModel.z = r3.c();
        if (this.$loadMore == false) goto L35;
        Iterator<wh8.b> r5 = ConversationListModel.h.iterator();
    L32:
        if (r5.hasNext() == false) goto L34;
        r5.next().IJ(0);
        goto L32
    L34:
        ConversationListModel.A = false;
    L35:
        Lazy<BotApi> r6 = BotApi.a;
        r3.i(BotApi.a.a(r17));
        FLogger r7 = FLogger.a;
        StringBuilder r8 = new StringBuilder("getRecommendBotList loadMore=");
        r8.append(this.$loadMore);
        r8.append(" result size=");
        List<RecommendBot> r9 = r3.b();
        if (r9 == null) goto L38;
        r4 = r9.size();
    L38:
        r8.append(r4);
        r7.i("ConversationListModel", r8.toString());
        List<RecommendBot> r10 = r3.b();
        if (r10 == null) goto L44;
        ConversationListModel r11 = ConversationListModel.a;
        String r12 = r3.d();
        this.L$0 = null;
        this.label = 2;
        if (r11.y(r10, r12, 1, null, this) != r14) goto L44;
        return r14;
    L20:
        if (this.$loadMore == false) goto L27;
        Iterator<wh8.b> r13 = ConversationListModel.h.iterator();
    L23:
        if (r13.hasNext() == false) goto L25;
        r13.next().IJ(-1);
        goto L23
    L25:
        ConversationListModel.A = false;
    L27:
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r19);
        CoroutineScope r15 = (CoroutineScope) this.L$0;
        BotRepo r16 = ConversationListModel.g;
        int r18 = ConversationListModel.y;
        if (this.$loadMore == false) goto L13;
        DowngradeSource r110 = DowngradeSource.LOAD_MORE;
    L14:
        this.L$0 = r15;
        this.label = 1;
        r17 = 1;
        r2 = IBotRepoService.b.b(r16, 1, r18, 20, null, false, null, null, null, null, r110, this, 504);
        if (r2 != r14) goto L17;
        return r14;
    L13:
        r110 = DowngradeSource.COLD_LAUNCH;
        goto L14
    }
}
