package com.larus.bmhome.chat.model;

import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.api.BotApi;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.BotRepo;
import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel$requireRecommendTagBot$1", f = "ConversationListModel.kt", i = {0}, l = {1433, 1479}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class ConversationListModel$requireRecommendTagBot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DowngradeSource $downgradeSource;
    private /* synthetic */ Object L$0;
    int label;

    public ConversationListModel$requireRecommendTagBot$1(DowngradeSource r1, Continuation<? super ConversationListModel$requireRecommendTagBot$1> r2) {
        this.$downgradeSource = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ConversationListModel$requireRecommendTagBot$1 r0 = new ConversationListModel$requireRecommendTagBot$1(this.$downgradeSource, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L10;
        if (r1 != 2) goto L9;
        ResultKt.throwOnFailure(r20);     // Catch: ConcurrentModificationException -> L54
    L58:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r20);     // Catch: ConcurrentModificationException -> L54
        Object r3 = r20;
        String r18 = "ConversationListModel";
    L19:
        ic8.o0 r4 = (ic8.o0) r3;     // Catch: ConcurrentModificationException -> L52
        if (r4 == null) goto L22;
        List<RecommendBot> r5 = r4.b();     // Catch: ConcurrentModificationException -> L52
        if (r5 != null) goto L27;
        r5 = CollectionsKt.emptyList();     // Catch: ConcurrentModificationException -> L52
    L27:
        ArrayList r11 = new ArrayList(r5);     // Catch: ConcurrentModificationException -> L52
        FLogger r12 = FLogger.a;     // Catch: ConcurrentModificationException -> L52
        String r10 = r18;
        r12.i(r10, "requireRecommendTagBotImpl, dataSize(" + r11.size() + "), bots(" + CollectionsKt.joinToString$default(r11, ", ", null, null, 0, null, new b1(), 30, null) + ')');     // Catch: ConcurrentModificationException -> L50
        if (r11.isEmpty() == false) goto L33;
        r12.i(r10, "requireRecommendTagBotImpl, data is empty");     // Catch: ConcurrentModificationException -> L50
        return Unit.INSTANCE;
    L33:
        Lazy<BotApi> r6 = BotApi.a;     // Catch: ConcurrentModificationException -> L50
        r4.i(BotApi.a.a(9));     // Catch: ConcurrentModificationException -> L50
        ArrayList r7 = new ArrayList();     // Catch: ConcurrentModificationException -> L50
        Iterator r8 = r11.iterator();     // Catch: ConcurrentModificationException -> L50
    L35:
        if (r8.hasNext() == false) goto L44;
        final RecommendBot r9 = (RecommendBot) r8.next();     // Catch: ConcurrentModificationException -> L50
        if (com.larus.utils.h.g(ConversationListModel.q, new c1(r9)) < 0) goto L39;
        boolean r13 = true;
    L40:
        if (r13 == true) goto L41;
        Boxing.boxBoolean(r7.add(r9));     // Catch: ConcurrentModificationException -> L50
        goto L35
    L41:
        FLogger.a.i(r10, "refresh bot(" + r9.o() + ") has appeared in conversation list");     // Catch: ConcurrentModificationException -> L50
        tx9.z.b(r9.o(), r4.d());     // Catch: ConcurrentModificationException -> L50
        goto L35
    L39:
        r13 = false;
        goto L40
    L44:
        if (r7.isEmpty() == false) goto L47;
        FLogger.a.i(r10, "requireRecommendTagBotImpl, data is all appeared in conversation list, bots(" + CollectionsKt.joinToString$default(r11, ", ", null, null, 0, null, new d1(), 30, null) + ')');     // Catch: ConcurrentModificationException -> L50
        return Unit.INSTANCE;
    L47:
        FLogger.a.i(r10, "requireRecommendTagBotImpl, data size(" + r7.size() + "), start parseBotList");     // Catch: ConcurrentModificationException -> L50
        ConversationListModel r0 = ConversationListModel.a;     // Catch: ConcurrentModificationException -> L50
        String r14 = r4.d();     // Catch: ConcurrentModificationException -> L50
        this.L$0 = null;     // Catch: ConcurrentModificationException -> L50
        this.label = 2;     // Catch: ConcurrentModificationException -> L50
        if (r0.y(r7, r14, 9, null, this) != r15) goto L58;
        return r15;
    L50:
        e = e;
    L56:
        FLogger.a.e(r10, "concurrent exception handle", e);
        goto L58
    L22:
        return Unit.INSTANCE;
    L13:
        ResultKt.throwOnFailure(r20);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        BotRepo r17 = ConversationListModel.g;     // Catch: ConcurrentModificationException -> L54
        DowngradeSource r19 = this.$downgradeSource;     // Catch: ConcurrentModificationException -> L54
        this.L$0 = r16;     // Catch: ConcurrentModificationException -> L54
        this.label = 1;     // Catch: ConcurrentModificationException -> L54
        r18 = "ConversationListModel";
        r3 = IBotRepoService.b.b(r17, 9, 0, 20, null, false, null, null, null, null, r19, this, 504);     // Catch: ConcurrentModificationException -> L52
        if (r3 != r15) goto L19;
        return r15;
    L52:
        e = e;
        r10 = r18;
    L54:
        e = e;
        r10 = "ConversationListModel";
        goto L56
    }
}
