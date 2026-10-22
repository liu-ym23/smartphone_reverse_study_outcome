package com.larus.bmhome.chat.model.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.markdown.memory.MemoryActionTag;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.network.http.AsyncThrowable;
import com.larus.network.http.a;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0010H\u0096@¢\u0006\u0002\u0010\u001aJ \u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J \u0010!\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010#J\u001e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010'J\u001e\u0010(\u001a\b\u0012\u0004\u0012\u00020&0%2\b\u0010\u001d\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010'J\u0010\u0010)\u001a\u00020*2\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J8\u0010+\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u00100JB\u00101\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0010\u0018\u0001022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\f042\u0006\u0010,\u001a\u00020\u00182\u0006\u0010-\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u00105J \u00106\u001a\u0004\u0018\u00010\u00102\u0006\u00107\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0018H\u0096@¢\u0006\u0002\u0010#Jl\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u001f2\u0006\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u001f2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020\u00182\b\u0010@\u001a\u0004\u0018\u00010\f2\b\u0010A\u001a\u0004\u0018\u00010\f2\b\u0010B\u001a\u0004\u0018\u00010\f2\b\u0010C\u001a\u0004\u0018\u00010\f2\b\u0010D\u001a\u0004\u0018\u00010EH\u0096@¢\u0006\u0002\u0010FJ/\u0010G\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\f2\u0017\u0010H\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100I¢\u0006\u0002\bJH\u0096@¢\u0006\u0002\u0010KR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006L"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/BotRepoServiceNoop;", "Lcom/larus/bmhome/chat/model/repo/IBotRepoService;", "<init>", "()V", "globalSpeakerVoice", "Lcom/larus/im/bean/bot/SpeakerVoice;", "getGlobalSpeakerVoice", "()Lcom/larus/im/bean/bot/SpeakerVoice;", "setGlobalSpeakerVoice", "(Lcom/larus/im/bean/bot/SpeakerVoice;)V", "botDeleteEventLive", "Landroidx/lifecycle/LiveData;", "", "getBotDeleteEventLive", "()Landroidx/lifecycle/LiveData;", "botUpdateEventLive", "Lcom/larus/im/bean/bot/BotModel;", "getBotUpdateEventLive", "updateBotVoice", "Lcom/larus/bmhome/bot/bean/VoiceUpdateResult;", "oldBotInfo", "newVoice", "(Lcom/larus/im/bean/bot/BotModel;Lcom/larus/im/bean/bot/SpeakerVoice;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBot", "", "bot", "(Lcom/larus/im/bean/bot/BotModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdateBotAccessPermission", "Lcom/larus/im/bean/bot/BotUpdateResult;", "botId", "privateStatus", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdateBotMessagePush", "messagePush", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireSubjectBotInfo", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/bot/bean/BotSubjectResult;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetBotSubject", "saveBot", "", "findBot", "forceNew", "scene", "syncLocal", "useMainBotCache", "(Ljava/lang/String;ZLjava/lang/String;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findBots", "", "botIds", "", "(Ljava/util/List;ZLjava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findBotByConversationId", "conversationId", "requireRecommendBotData", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "recommendType", "pageIndex", "pageSize", "tagId", "", "withOnBoarding", "oldBotId", "triggerType", "tab", "firstBotId", "source", "Lcom/larus/basic/experience/downgrade/api/DowngradeSource;", "(IIILjava/lang/Long;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/basic/experience/downgrade/api/DowngradeSource;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLocalBot", MemoryActionTag.MEMORY_ACTION_TAG_UPDATE, "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class BotRepoServiceNoop implements IBotRepoService {
    public final MutableLiveData a;
    public final MutableLiveData b;

    public final void e1(BotModel r2) {
        Intrinsics.checkNotNullParameter(r2, "bot");
    }

    public final void g1(String r1, String r2) {
    }

    public final void h1() {
    }

    public final Object j1(String r1, boolean r2, Continuation<? super BotModel> r3) {
        return null;
    }

    public final Object k1(int r1, int r2, int r3, Long r4, boolean r5, String r6, String r7, String r8, String r9, DowngradeSource r10, Continuation<? super ic8.o0> r11) {
        return null;
    }

    public final Object m1(String r1, boolean r2, Continuation<? super uc9.t> r3) {
        return null;
    }

    public final Object o1(String r1, int r2, Continuation<? super uc9.t> r3) {
        return null;
    }

    public final Object q1(String r1, boolean r2, String r3, boolean r4, boolean r5, Continuation<? super BotModel> r6) {
        return null;
    }

    public BotRepoServiceNoop() {
        this.a = new MutableLiveData();
        this.b = new MutableLiveData();
    }

    public final LiveData<BotModel> n1() {
        return this.b;
    }

    public final LiveData<String> r1() {
        return this.a;
    }

    public final Object f1(String r2, Continuation<? super a<ub8.c>> r3) {
        AsyncThrowable.Companion.getClass();
        return new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null);
    }

    public final Object p1(String r2, Continuation<? super a<ub8.c>> r3) {
        AsyncThrowable.Companion.getClass();
        return new com.larus.network.http.f(AsyncThrowable.access$getDEFAULT$cp(), null);
    }

    public final Object s1(BotModel r1, Continuation<? super Boolean> r2) {
        return Boxing.boxBoolean(false);
    }

    public final Object l1(String r1, Function1<? super BotModel, BotModel> r2, Continuation<? super Boolean> r3) {
        return Boxing.boxBoolean(false);
    }

    public final Object t1(BotModel r1, SpeakerVoice r2, Continuation<? super ub8.h> r3) {
        return new ub8.h(false, null, null, null);
    }

    public final Object i1(List<String> r1, boolean r2, String r3, boolean r4, Continuation<? super Map<String, BotModel>> r5) {
        return MapsKt.emptyMap();
    }
}
