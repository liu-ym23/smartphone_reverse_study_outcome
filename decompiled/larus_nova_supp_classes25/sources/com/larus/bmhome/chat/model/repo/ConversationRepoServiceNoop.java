package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u0010J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0006\u0010\u000f\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u0010J\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0096@¢\u0006\u0002\u0010\u0014Jp\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001d\u001a\u0004\u0018\u00010\u00072\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001fH\u0096@¢\u0006\u0002\u0010 J&\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000e2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001fH\u0016J\u0018\u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\u001e\u0010&\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(H\u0096@¢\u0006\u0002\u0010)J(\u0010&\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010*\u001a\u00020(2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010+J\u001e\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010/J(\u00100\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00102J,\u00103\u001a\b\u0012\u0004\u0012\u00020\u000e042\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u00101\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u00102J<\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\u00072\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u001fH\u0096@¢\u0006\u0002\u00109J.\u0010:\u001a\u0004\u0018\u00010\u00072\u0006\u0010;\u001a\u00020<2\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001fH\u0096@¢\u0006\u0002\u0010>J8\u0010:\u001a\u0004\u0018\u00010\u00072\u0006\u0010;\u001a\u00020?2\u0014\u0010=\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001f2\b\u0010@\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010AJ*\u0010B\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\t2\b\u00101\u001a\u0004\u0018\u00010\u0007H\u0096@¢\u0006\u0002\u0010DJ\"\u0010E\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00062\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0096@¢\u0006\u0002\u0010GJ(\u0010H\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020LH\u0016J.\u0010M\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020LH\u0096@¢\u0006\u0002\u0010NJ.\u0010O\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\t2\u0006\u0010J\u001a\u00020\t2\u0006\u0010K\u001a\u00020LH\u0096@¢\u0006\u0002\u0010NJ\u001e\u0010P\u001a\u00020Q2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0017H\u0096@¢\u0006\u0002\u0010SJ&\u0010T\u001a\u00020Q2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u00172\u0006\u0010U\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010VJ!\u0010W\u001a\u00020\"2\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010X\u001a\u0004\u0018\u00010YH\u0016¢\u0006\u0002\u0010ZJ\u0016\u0010[\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\\H\u0016J8\u0010]\u001a\u0004\u0018\u00010^2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\t2\u0006\u0010_\u001a\u00020\u00172\u0006\u0010`\u001a\u00020\u00172\u0006\u0010a\u001a\u00020\tH\u0096@¢\u0006\u0002\u0010bJ\u0010\u0010c\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0016\u0010d\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0096@¢\u0006\u0002\u0010\u0010J\u0010\u0010e\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0007H\u0016R\u001c\u0010\u0004\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/ConversationRepoServiceNoop;", "Lcom/larus/bmhome/chat/model/repo/IConversationRepoService;", "<init>", "()V", "conversationSync", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "", "modifyConversationTts", "", "conversationId", "enable", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLocalConversationByBot", "Lcom/larus/im/bean/conversation/Conversation;", "botId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findConversationListByBot", "findConversationByBot", "getMainConversation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBotConversation", "botConversationType", "", "sourceConversationId", "sourceMessageId", "pinned", "collectionId", "caseId", "caseName", "ext", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateConversationBizExt", "", "conversation", "bizExtra", "updateConversationExt", "removeConversation", "mode", "Lcom/larus/im/bean/conversation/ConversationDeleteMode;", "(Lcom/larus/im/bean/conversation/Conversation;Lcom/larus/im/bean/conversation/ConversationDeleteMode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteMode", "(Ljava/lang/String;Lcom/larus/im/bean/conversation/ConversationDeleteMode;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncConversationInfo", "userId", "conversationResp", "(Ljava/lang/String;Lcom/larus/im/bean/conversation/Conversation;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireConversationInfo", "localConversationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireConversationInfo2", "Lcom/larus/network/http/Async;", "syncConversationBio", "owner", "conversationList", "botBioMap", "(Ljava/lang/String;Ljava/util/List;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalConversation", "bot", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "extraData", "(Lcom/larus/bmhome/chat/bean/RecommendBot;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/larus/im/bean/bot/BotModel;", "projectId", "(Lcom/larus/im/bean/bot/BotModel;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findConversation", "fromLocal", "(Ljava/lang/String;ZLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findConversationListLocalFirst", "cvsIdList", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryInterrupt", "serverInterrupt", "forceInterrupt", "breakReason", "Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "tryInterruptByDb", "(Ljava/lang/String;ZZLcom/larus/im/internal/jni/bean/OmniBreakReason;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryInterruptSuspend", "clearHistory", "Lcom/larus/bmhome/bot/bean/BotInfoUpdateResult;", "conversationType", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearContext", "from", "(Ljava/lang/String;ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markConversationRead", "readIndex", "", "(Ljava/lang/String;Ljava/lang/Long;)V", "conversationSyncFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getParticipants", "Lcom/larus/im/bean/conversation/ConversationParticipantListResponse;", "offset", "limit", "acquireTotal", "(Ljava/lang/String;ZIIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRequiringBotFirstMet", "updateConversationCreateScene", "getConversationType", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ConversationRepoServiceNoop implements IConversationRepoService {
    public final StateFlowImpl a;

    public final Object a(String r1, Continuation<? super wc9.e> r2) {
        return null;
    }

    public final Object b(String r1, int r2, int r3, boolean r4, Continuation r5) {
        return null;
    }

    public final void c(wc9.e r1, Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r1, "conversation");
    }

    public final void e(wc9.e r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "conversation");
        Intrinsics.checkNotNullParameter(r3, "ext");
    }

    public final Object f(Continuation<? super wc9.e> r1) {
        return null;
    }

    public final void h(String r1, Long r2) {
    }

    public final Object k(BotModel r1, Map<String, String> r2, String r3, Continuation<? super String> r4) {
        return null;
    }

    public final Object m(String r1, Continuation<? super wc9.e> r2) {
        return null;
    }

    public final Object r(String r1, String r2, String r3, Continuation<? super wc9.e> r4) {
        return null;
    }

    public final Object t(String r1, int r2, String r3, String r4, boolean r5, String r6, String r7, String r8, Map<String, String> r9, Continuation<? super wc9.e> r10) {
        return null;
    }

    public final Object u(RecommendBot r1, Map<String, String> r2, Continuation<? super String> r3) {
        return null;
    }

    public final Object v(String r1, boolean r2, String r3, Continuation<? super wc9.e> r4) {
        return null;
    }

    public final void w(String r1, boolean r2, boolean r3, OmniBreakReason r4) {
        Intrinsics.checkNotNullParameter(r1, "conversationId");
        Intrinsics.checkNotNullParameter(r4, "breakReason");
    }

    public final int x(String r2) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        return 0;
    }

    public ConversationRepoServiceNoop() {
        this.a = j1.a(null);
    }

    public final kotlinx.coroutines.flow.i1<List<String>> y() {
        return this.a;
    }

    public final Object d(String r1, ContinuationImpl r2) {
        return CollectionsKt.emptyList();
    }

    public final Object g(List<String> r1, Continuation<? super List<wc9.e>> r2) {
        return CollectionsKt.emptyList();
    }

    public final void i(String r1, RecommendBot r2) {
        Intrinsics.checkNotNullParameter(r2, "bot");
    }

    public final void o(String r1, BotModel r2) {
        Intrinsics.checkNotNullParameter(r2, "botModel");
    }

    public final Object q(String r2, Continuation r3) {
        return new ub8.b(null, null, 7);
    }

    public final Object s(String r1, Continuation<? super Boolean> r2) {
        return Boxing.boxBoolean(false);
    }

    public final Object p(String r1, boolean r2, Continuation<? super Boolean> r3) {
        return Boxing.boxBoolean(false);
    }

    public final Object j(String r1, String r2, String r3, Continuation<? super a<wc9.e>> r4) {
        AsyncThrowable.Companion.getClass();
        return new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null);
    }

    public final Object l(String r1, ConversationDeleteMode r2, String r3, Continuation<? super Boolean> r4) {
        return Boxing.boxBoolean(false);
    }

    public final Object n(String r1, int r2, String r3, Continuation<? super ub8.b> r4) {
        return new ub8.b(null, null, 7);
    }
}
