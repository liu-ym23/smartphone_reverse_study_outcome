package com.larus.bmhome.chat.model;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.api.BotApi;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.im.bean.bot.BotModel;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel$refreshRecommendTagBot$1", f = "ConversationListModel.kt", i = {}, l = {1499, 1524}, m = "invokeSuspend", n = {}, s = {})
public final class ConversationListModel$refreshRecommendTagBot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wh8.a $c;
    final /* synthetic */ DowngradeSource $downgradeSource;
    int label;

    public ConversationListModel$refreshRecommendTagBot$1(wh8.a r1, DowngradeSource r2, Continuation<? super ConversationListModel$refreshRecommendTagBot$1> r3) {
        this.$c = r1;
        this.$downgradeSource = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ConversationListModel$refreshRecommendTagBot$1(this.$c, this.$downgradeSource, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        String r17 = null;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L11;
        ResultKt.throwOnFailure(r21);     // Catch: Exception -> L8
    L79:
        ConversationListModel r2 = ConversationListModel.a;
        ConversationListModel.B = false;
        return Unit.INSTANCE;
    L8:
        e = e;
        String r7 = "ConversationListModel";
    L78:
        FLogger.a.e(r7, "refreshRecommendTagBot parseBotList error, " + e.getMessage());
        goto L79
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r21);
        Object r3 = r21;
        String r19 = "ConversationListModel";
    L31:
        ic8.o0 r4 = (ic8.o0) r3;
        FLogger r5 = FLogger.a;
        StringBuilder r6 = new StringBuilder("refreshRecommendTagBot get result, bot(");
        if (r4 == null) goto L36;
        List<RecommendBot> r8 = r4.b();
        if (r8 == null) goto L36;
        String r9 = CollectionsKt.joinToString$default(r8, ", ", null, null, 0, null, new y0(), 30, null);
    L37:
        r6.append(r9);
        r6.append(')');
        r7 = r19;
        r5.i(r7, r6.toString());
        if (r4 == null) goto L44;
        List<RecommendBot> r10 = r4.b();
        if (r10 == null) goto L44;
        int r11 = 1;
        if (r10.isEmpty() != true) goto L45;
        boolean r12 = true;
    L46:
        if (r12 == false) goto L49;
        ConversationListModel r13 = ConversationListModel.a;
        ConversationListModel.B = false;
        return Unit.INSTANCE;
    L49:
        if (r4 == null) goto L53;
        List<RecommendBot> r14 = r4.b();
        if (r14 == null) goto L53;
        final RecommendBot r15 = (RecommendBot) CollectionsKt.firstOrNull(r14);
    L55:
        if (com.larus.utils.h.g(ConversationListModel.q, new z0(r15)) < 0) goto L57;
        boolean r16 = true;
    L58:
        if (r16 == false) goto L71;
        StringBuilder r18 = new StringBuilder("refreshRecommendTagBot, bot(");
        if (r15 == null) goto L62;
        String r20 = r15.o();
    L63:
        r18.append(r20);
        r18.append(") has appeared in conversation list");
        r5.i(r7, r18.toString());
        if (r15 == null) goto L66;
        String r22 = r15.o();
    L67:
        if (r4 == null) goto L69;
        r17 = r4.d();
    L69:
        tx9.z.b(r22, r17);
        ConversationListModel.B = false;
        return Unit.INSTANCE;
    L66:
        r22 = null;
        goto L67
    L62:
        r20 = null;
        goto L63
    L71:
        if (r4 == null) goto L73;
        Lazy<BotApi> r23 = BotApi.a;
        r4.i(BotApi.a.a(9));
    L73:
        if (r15 == null) goto L79;
        wh8.a r24 = this.$c;     // Catch: Exception -> L77
        ConversationListModel r25 = ConversationListModel.a;     // Catch: Exception -> L77
        RecommendBot[] r26 = new RecommendBot[r11];     // Catch: Exception -> L77
        r26[0] = r15;     // Catch: Exception -> L77
        List<RecommendBot> r27 = ArraysKt.toList(r26);     // Catch: Exception -> L77
        String r28 = r4.d();     // Catch: Exception -> L77
        this.label = 2;     // Catch: Exception -> L77
        if (r25.y(r27, r28, 10, r24, this) != r0) goto L79;
        return r0;
    L77:
        e = e;
        goto L78
    L57:
        r16 = false;
    L53:
        r15 = null;
    L45:
        r12 = false;
    L44:
        r11 = 1;
    L36:
        r9 = null;
        goto L37
    L13:
        ResultKt.throwOnFailure(r21);
        if (ConversationListModel.B == false) goto L22;
        FLogger r29 = FLogger.a;
        StringBuilder r30 = new StringBuilder("refreshRecommendTagBot, isRefreshing(true), can't change bot(");
        wh8.a r31 = this.$c;
        if (r31 == null) goto L20;
        BotModel r32 = r31.b;
        if (r32 == null) goto L20;
        r17 = r32.getName();
    L20:
        r30.append(r17);
        r30.append(')');
        r29.w("ConversationListModel", r30.toString());
        return Unit.INSTANCE;
    L22:
        ConversationListModel r33 = ConversationListModel.a;
        ConversationListModel.B = true;
        BotRepo r34 = ConversationListModel.g;
        wh8.a r35 = this.$c;
        if (r35 == null) goto L27;
        BotModel r36 = r35.b;
        if (r36 == null) goto L27;
        String r37 = r36.getBotId();
    L28:
        DowngradeSource r110 = this.$downgradeSource;
        this.label = 1;
        r19 = "ConversationListModel";
        r3 = IBotRepoService.b.b(r34, 10, 0, 20, null, false, r37, null, null, null, r110, this, 472);
        if (r3 != r0) goto L31;
        return r0;
    L27:
        r37 = null;
        goto L28
    }
}
