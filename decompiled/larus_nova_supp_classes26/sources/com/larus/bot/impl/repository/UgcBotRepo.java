package com.larus.bot.impl.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.keva.Keva;
import com.larus.bmhome.chat.bean.RecommendBot;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.share.panel.ShareType;
import com.larus.bot.api.IUgcBotRepoService;
import com.larus.bot.impl.feature.edit.feature.autofill.model.BotEnrichParam;
import ic8.o0;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000¾\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 Q2\u00020\u0001:\u0003OPQB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@¢\u0006\u0002\u0010\u0016J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0086@¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$H\u0086@¢\u0006\u0002\u0010%J\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010\u0014\u001a\u00020)H\u0086@¢\u0006\u0002\u0010*J\"\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0'2\u0006\u0010\u0014\u001a\u00020)H\u0086@¢\u0006\u0002\u0010*J(\u0010.\u001a\b\u0012\u0004\u0012\u00020/0'2\u0006\u0010\u0014\u001a\u00020)2\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u00101J\u001c\u00102\u001a\b\u0012\u0004\u0012\u0002030'2\u0006\u0010\u0014\u001a\u000204H\u0086@¢\u0006\u0002\u00105J\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002070'2\u0006\u0010\u0014\u001a\u000208H\u0086@¢\u0006\u0002\u00109J\u0018\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010=J\u0006\u0010>\u001a\u00020?J\u0012\u0010@\u001a\u00020?2\b\u0010A\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010B\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\fJ\u0010\u0010C\u001a\u0004\u0018\u00010\fH\u0096@¢\u0006\u0002\u0010DJ\u0010\u0010E\u001a\u0004\u0018\u00010\fH\u0086@¢\u0006\u0002\u0010DJ&\u0010F\u001a\u00020;2\u0006\u0010G\u001a\u00020H2\u000e\u0010I\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010,H\u0086@¢\u0006\u0002\u0010KJ\u0014\u0010L\u001a\b\u0012\u0004\u0012\u00020J0,2\u0006\u0010G\u001a\u00020HJ\b\u0010M\u001a\u00020NH\u0002R#\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006R"}, d2 = {"Lcom/larus/bot/impl/repository/UgcBotRepo;", "Lcom/larus/bot/api/IUgcBotRepoService;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "firstPageDataCache", "Lcom/larus/bmhome/chat/bean/RecommendBotData;", "botCreateEventLive", "Landroidx/lifecycle/MutableLiveData;", "", "getBotCreateEventLive", "()Landroidx/lifecycle/MutableLiveData;", "requireCreateBot", "Lcom/larus/bmhome/bot/bean/BotInfoUpdateResult;", "param", "Lcom/larus/im/bean/bot/BotCreateParam;", "(Lcom/larus/im/bean/bot/BotCreateParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireUpdateBot", "Lcom/larus/im/bean/bot/BotUpdateParam;", "(Lcom/larus/im/bean/bot/BotUpdateParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateLanguage", "Lcom/larus/bmhome/bot/bean/LanguageUpdateResult;", "oldBotInfo", "Lcom/larus/im/bean/bot/BotModel;", "botLanguage", "Lcom/larus/bmhome/bot/bean/BotLanguage;", "(Lcom/larus/im/bean/bot/BotModel;Lcom/larus/bmhome/bot/bean/BotLanguage;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateModel", "Lcom/larus/bmhome/bot/bean/ModelUpdateResult;", "newModelItem", "Lcom/larus/im/bean/bot/ModelItem;", "(Lcom/larus/im/bean/bot/BotModel;Lcom/larus/im/bean/bot/ModelItem;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireEnrichBot", "Lcom/larus/network/http/Async;", "Lcom/larus/bot/impl/bean/BotEnrichRespData;", "Lcom/larus/bot/impl/feature/edit/feature/autofill/model/BotEnrichParam;", "(Lcom/larus/bot/impl/feature/edit/feature/autofill/model/BotEnrichParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireBotEnrichCheck", "", "Lcom/larus/bot/impl/bean/EnrichBotData;", "requireBotPolishDesc", "Lcom/larus/bot/impl/bean/BotPolishDescResp;", "botId", "(Lcom/larus/bot/impl/feature/edit/feature/autofill/model/BotEnrichParam;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireGenBotIcon", "Lcom/larus/bot/impl/bean/BotAvatarIconData;", "Lcom/larus/bot/impl/repository/UgcBotRepo$GenBotIconParam;", "(Lcom/larus/bot/impl/repository/UgcBotRepo$GenBotIconParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireGenAvatarList", "Lcom/larus/bot/impl/bean/BotGenAvatarByPromptResult;", "Lcom/larus/bot/impl/repository/UgcBotRepo$GenBotAvatarListParam;", "(Lcom/larus/bot/impl/repository/UgcBotRepo$GenBotAvatarListParam;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveDiscoverFirstPageData", "", "recommendData", "(Lcom/larus/bmhome/chat/bean/RecommendBotData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasDiscoverFirstPageData", "", "urlExpireOrEmpty", ShareType.URL, "saveRecommendBotFirstPageData", "getRecommendBotFirstPageData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDiscoverFirstPageData", "saveRecommendBotList", "tagId", "", "recommendBotList", "Lcom/larus/bmhome/chat/bean/RecommendBot;", "(JLjava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedRecommendBotList", "ugcBotApi", "Lcom/larus/bot/impl/repository/UgcBotApi;", "GenBotIconParam", "GenBotAvatarListParam", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UgcBotRepo implements IUgcBotRepoService {
    public static final Lazy<UgcBotRepo> d = null;
    public final Lazy a;
    public o0 b;
    public final MutableLiveData<String> c;

    public static final class a {
        public static UgcBotRepo a() {
            return (UgcBotRepo) UgcBotRepo.d.getValue();
        }
    }

    public static final class b {
        public final String a;
        public final int b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b;
        }

        public final String toString() {
            return "GenBotAvatarListParam(prompt=" + this.a + ", num=" + this.b + ')';
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "prompt");
            this.a = r2;
            this.b = 4;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = ((r2 * 31) + this.b.hashCode()) * 31;
            String r4 = this.c;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "GenBotIconParam(name=" + this.a + ", botLang=" + this.b + ", description=" + this.c + ')';
        }

        public c(String r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "botLang");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    static {
        d = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new com.larus.bot.impl.repository.c());
    }

    public static UgcBotRepo c() {
        return new UgcBotRepo();
    }

    public static com.larus.bot.impl.repository.b m() {
        return (com.larus.bot.impl.repository.b) com.larus.bot.impl.repository.b.a.getValue();
    }

    public final Keva e() {
        return (Keva) this.a.getValue();
    }

    private UgcBotRepo() {
        this.a = LazyKt.lazy(new d());
        this.c = new MutableLiveData();
    }

    @Override // com.larus.bot.api.IUgcBotRepoService
    public final LiveData b() {
        return this.c;
    }

    @Override // com.larus.bot.api.IUgcBotRepoService
    public final Object a(Continuation<? super o0> r1) {
        return this.b;
    }

    public final Object d(Continuation<? super o0> r4) {
        return BuildersKt.withContext(RepoDispatcherDelegate.b.g(), new UgcBotRepo$getDiscoverFirstPageData$2(this, null), r4);
    }

    public static Object f(BotEnrichParam r3, Continuation r4) {
        m().getClass();
        return BuildersKt.withContext(Dispatchers.getIO(), new UgcBotApi$requireBotEnrichCheck$2(r3, null), r4);
    }

    public static Object h(BotEnrichParam r3, Continuation r4) {
        m().getClass();
        return BuildersKt.withContext(Dispatchers.getIO(), new UgcBotApi$requireEnrichBot$2(r3, null), r4);
    }

    public static Object i(b r3, Continuation r4) {
        m().getClass();
        return BuildersKt.withContext(Dispatchers.getIO(), new UgcBotApi$requireGenBotAvatarList$2(r3, null), r4);
    }

    public static Object j(c r3, Continuation r4) {
        m().getClass();
        return BuildersKt.withContext(Dispatchers.getIO(), new UgcBotApi$requireGenBotIcon$2(r3, null), r4);
    }

    public final Object k(o0 r4, Continuation<? super Unit> r5) {
        Object r6 = BuildersKt.withContext(RepoDispatcherDelegate.b.g(), new UgcBotRepo$saveDiscoverFirstPageData$2(r4, this, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public static Object g(BotEnrichParam r3, String r4, Continuation r5) {
        m().getClass();
        return BuildersKt.withContext(Dispatchers.getIO(), new UgcBotApi$requireBotPolishDesc$2(r4, r3, null), r5);
    }

    public final Object l(long r9, List<RecommendBot> r11, Continuation<? super Unit> r12) {
        Object r10 = BuildersKt.withContext(RepoDispatcherDelegate.b.g(), new UgcBotRepo$saveRecommendBotList$2(r11, this, r9, null), r12);
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r10;
    L6:
        return Unit.INSTANCE;
    }
}
