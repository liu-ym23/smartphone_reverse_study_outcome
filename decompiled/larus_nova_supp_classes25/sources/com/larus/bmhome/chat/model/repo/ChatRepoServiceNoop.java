package com.larus.bmhome.chat.model.repo;

import androidx.lifecycle.MutableLiveData;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.network.http.AsyncThrowable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import te8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0096@¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020\tH\u0016J\u0018\u0010$\u001a\u0004\u0018\u00010\u001f2\u0006\u0010%\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010&J@\u0010'\u001a\u0004\u0018\u00010\u001f2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020!2\b\u0010,\u001a\u0004\u0018\u00010\u000f2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020!0\u001eH\u0096@¢\u0006\u0002\u0010.J\u0018\u0010/\u001a\u0004\u0018\u00010\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010&J\u0018\u00100\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010&J \u00101\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u00102\u001a\u000203H\u0096@¢\u0006\u0002\u00104JH\u00105\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00172\u0006\u0010\u000e\u001a\u00020\u000f2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H\u0096@¢\u0006\u0002\u0010:J\u0018\u0010;\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010&J\u0018\u0010<\u001a\u0004\u0018\u00010\u001f2\u0006\u0010=\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010>J\u0010\u0010?\u001a\u0004\u0018\u00010@H\u0096@¢\u0006\u0002\u0010AJ<\u0010B\u001a\u00020\r2\u0006\u0010%\u001a\u00020\u000f2*\u0010C\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0E\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0E0DH\u0016J\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010=\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010>J(\u0010G\u001a\u00020\r2\u0006\u0010H\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u000f2\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010KH\u0016J$\u0010L\u001a\b\u0012\u0004\u0012\u00020\u000f0M2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010OJ\u0018\u0010P\u001a\u0004\u0018\u00010\u001f2\u0006\u0010H\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010&J\u001c\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010=\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010>J\u0018\u0010R\u001a\u00020\r2\u0006\u0010S\u001a\u00020\u000f2\u0006\u0010T\u001a\u00020!H\u0016J\u0018\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010H\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010&JZ\u0010W\u001a\u0002082\u0006\u0010X\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010Y\u001a\u00020\u000f2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u001e2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001e2\u0006\u0010]\u001a\u0002082\u000e\u0010^\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001eH\u0096@¢\u0006\u0002\u0010_J,\u0010`\u001a\b\u0012\u0004\u0012\u00020\u000f0M2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010N\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010bJ8\u0010c\u001a\b\u0012\u0004\u0012\u00020\u000f0M2\u0006\u0010(\u001a\u00020\u000f2\u0006\u0010d\u001a\u00020!2\b\u0010e\u001a\u0004\u0018\u00010!2\b\u0010f\u001a\u0004\u0018\u000103H\u0096@¢\u0006\u0002\u0010gR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R*\u0010\u0016\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u00170\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006h"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/ChatRepoServiceNoop;", "Lcom/larus/bmhome/chat/model/repo/IChatRepoService;", "<init>", "()V", "sender", "Lcom/larus/bmhome/chat/model/repo/IChatSender;", "getSender", "()Lcom/larus/bmhome/chat/model/repo/IChatSender;", "receiver", "Lcom/larus/bmhome/chat/model/repo/IChatReceiver;", "getReceiver", "()Lcom/larus/bmhome/chat/model/repo/IChatReceiver;", "breakAnswer", "", "conversationId", "", "breakReason", "Lcom/larus/im/internal/jni/bean/OmniBreakReason;", "touristReachMessageLimit", "Landroidx/lifecycle/MutableLiveData;", "getTouristReachMessageLimit", "()Landroidx/lifecycle/MutableLiveData;", "tabChangeEvent", "Lkotlin/Pair;", "getTabChangeEvent", "conversationIdChangeEvent", "Lcom/larus/bmhome/chat/event/ConversationIdChangeEvent;", "getConversationIdChangeEvent", "getISender", "getMessageListLocal", "", "Lcom/larus/im/bean/message/Message;", "limit", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIReceiver", "findMessageById", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "messageFeedback", "messageId", "feedbackType", "Lcom/larus/im/bean/message/MsgFeedbackType;", "feedbackDislikeDetailType", "feedbackDetailContent", "feedbackDislikeDetailTypes", "(Ljava/lang/String;Lcom/larus/im/bean/message/MsgFeedbackType;ILjava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMessageExt", "getLatestSubtitleMessage", "requireOneMessageRecord", "msgServerIndex", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reportDeleteMessage", "messages", "local", "", "delByUser", "(Ljava/lang/String;Ljava/util/List;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findLastIndexMessage", "findQuestion", "message", "(Lcom/larus/im/bean/message/Message;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireCheckLimit", "Lcom/larus/bmhome/chat/resp/ChatLimit;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMessageBizExtOnly", "action", "Lkotlin/Function1;", "", "findMessagesByCollectionId", "updateMessageContentOnly", "msgId", "newContent", "callback", "Lcom/larus/im/callback/IIMCallback;", "updateMessage", "Lcom/larus/network/http/Async;", "content", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLastMessage", "findQuestionByCollectionId", "updateMessageStatusLocalOnly", "localMessageId", "newStatus", "findBotByMessageId", "Lcom/larus/im/bean/bot/BotModel;", "requestSaveBotReply", "botId", "questionId", "messageContentList", "Lcom/larus/bmhome/chat/model/repo/MessageContent;", "suggests", "forHistoricalQuestion", "suggestsV2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateMessageResponseForModel", "responseForModel", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecordMessage", "status", "duration", "meetingId", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ChatRepoServiceNoop implements IChatRepoService {
    public final i1 a;
    public final o0 b;
    public final MutableLiveData<Unit> c;
    public final MutableLiveData<Pair<String, String>> d;
    public final MutableLiveData<a> e;

    public final Object D1(String r1, Continuation<? super Message> r2) {
        return null;
    }

    public final Object E1(String r1, Continuation<? super Message> r2) {
        return null;
    }

    public final Object F1(String r1, Continuation<? super BotModel> r2) {
        return null;
    }

    public final void J1(String r1, String r2, IIMCallback<Message> r3) {
        Intrinsics.checkNotNullParameter(r1, "msgId");
        Intrinsics.checkNotNullParameter(r2, "newContent");
    }

    public final Object K1(String r1, Continuation<? super Message> r2) {
        return null;
    }

    public final void n1(String r2, OmniBreakReason r3) {
        Intrinsics.checkNotNullParameter(r2, "conversationId");
        Intrinsics.checkNotNullParameter(r3, "breakReason");
    }

    public final void r1(String r2, Function1<? super Map<String, String>, ? extends Map<String, String>> r3) {
        Intrinsics.checkNotNullParameter(r2, "id");
        Intrinsics.checkNotNullParameter(r3, "action");
    }

    public final void t1(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "localMessageId");
    }

    public final Object v1(String r1, long r2, Continuation<? super Message> r4) {
        return null;
    }

    public final Object w1(String r1, Continuation<? super String> r2) {
        return null;
    }

    public final Object y1(Message r1, Continuation<? super Message> r2) {
        return null;
    }

    public ChatRepoServiceNoop() {
        this.a = i1.a;
        this.b = o0.a;
        this.c = new MutableLiveData();
        this.d = new MutableLiveData();
        this.e = new MutableLiveData(null);
    }

    public final MutableLiveData<Pair<String, String>> B1() {
        return this.d;
    }

    public final MutableLiveData<Unit> G1() {
        return this.c;
    }

    public final MutableLiveData<a> H1() {
        return this.e;
    }

    public final t1 getReceiver() {
        return this.b;
    }

    public final u1 getSender() {
        return this.a;
    }

    public final u1 u1() {
        return this.a;
    }

    public final t1 x1() {
        return this.b;
    }

    public final Object s1(Message r1, Continuation<? super List<Message>> r2) {
        return CollectionsKt.emptyList();
    }

    public final Object z1(Message r1, Continuation<? super List<Message>> r2) {
        return CollectionsKt.emptyList();
    }

    public final Object A1(String r1, String r2, Continuation<? super com.larus.network.http.a<String>> r3) {
        AsyncThrowable.Companion.getClass();
        return new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null);
    }

    public final Object o1(String r1, int r2, Continuation<? super List<Message>> r3) {
        return CollectionsKt.emptyList();
    }

    public final Object I1(String r1, String r2, String r3, Continuation<? super com.larus.network.http.a<String>> r4) {
        AsyncThrowable.Companion.getClass();
        return new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null);
    }

    public final Object C1(String r1, List<Message> r2, boolean r3, boolean r4, Continuation<? super Pair<? extends List<Message>, String>> r5) {
        return TuplesKt.to(CollectionsKt.emptyList(), null);
    }

    public final Object q1(String r1, int r2, Integer r3, Long r4, Continuation<? super com.larus.network.http.a<String>> r5) {
        AsyncThrowable.Companion.getClass();
        return new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null);
    }

    public final Object p1(String r1, String r2, String r3, List<a2> r4, List<String> r5, boolean r6, List<String> r7, Continuation<? super Boolean> r8) {
        return Boxing.boxBoolean(false);
    }
}
