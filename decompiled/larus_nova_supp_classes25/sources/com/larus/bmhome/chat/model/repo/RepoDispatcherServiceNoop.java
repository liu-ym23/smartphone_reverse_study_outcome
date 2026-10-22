package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J=\u0010\u0012\u001a\u0002H\u0013\"\u0004\b\u0000\u0010\u00132'\u0010\u0014\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0015¢\u0006\u0002\b\u0019H\u0096@¢\u0006\u0002\u0010\u001aJ2\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c2\u001c\u0010\u0014\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001c0\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u001dH\u0096@¢\u0006\u0002\u0010\u001eJ\b\u0010\b\u001a\u00020\u001fH\u0016J\b\u0010\n\u001a\u00020 H\u0016J\b\u0010\f\u001a\u00020!H\u0016J\b\u0010\u000e\u001a\u00020\"H\u0016J\b\u0010\u0010\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0090\u0001\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0016\u0010,\u001a\u0012\u0012\u0004\u0012\u00020)0-j\b\u0012\u0004\u0012\u00020)`.2\u0006\u0010/\u001a\u00020+2\u0006\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020+2\u0006\u00102\u001a\u00020)2\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020+\u0018\u0001042\u0014\u00105\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+\u0018\u0001062\u0012\u00107\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020%0\u001dH\u0096@¢\u0006\u0002\u00108R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/larus/bmhome/chat/model/repo/RepoDispatcherServiceNoop;", "Lcom/larus/bmhome/chat/model/repo/IRepoDispatcherService;", "<init>", "()V", "messageDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "getMessageDispatcher", "()Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "chatRepo", "Lcom/larus/bmhome/chat/model/repo/ChatRepoServiceNoop;", "conversationRepo", "Lcom/larus/bmhome/chat/model/repo/ConversationRepoServiceNoop;", "settingRepo", "Lcom/larus/bmhome/chat/model/repo/SettingRepoServiceNoop;", "userSettingRepo", "Lcom/larus/bmhome/chat/model/repo/UserSettingRepoServiceNoop;", "botRepo", "Lcom/larus/bmhome/chat/model/repo/BotRepoServiceNoop;", "dispatch", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTransaction", "R", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/larus/bmhome/chat/model/repo/IChatRepoService;", "Lcom/larus/bmhome/chat/model/repo/IConversationRepoService;", "Lcom/larus/bmhome/chat/model/repo/ISettingRepoService;", "Lcom/larus/bmhome/chat/model/repo/IUserSettingRepoService;", "Lcom/larus/bmhome/chat/model/repo/IBotRepoService;", "clearAllRepo", "", "requireTipOff", "", "reportType", "", "entityId", "", "reasonIds", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "reasonDetail", "serverIndex", "conversationId", "reportSource", "batchIds", "", "extra", "", "callback", "(ILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class RepoDispatcherServiceNoop implements IRepoDispatcherService {
    public final ExecutorCoroutineDispatcher a;
    public final ChatRepoServiceNoop b;
    public final ConversationRepoServiceNoop c;
    public final SettingRepoServiceNoop d;
    public final UserSettingRepoServiceNoop e;
    public final BotRepoServiceNoop f;

    public RepoDispatcherServiceNoop() {
        this.a = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new e2()));
        this.b = new ChatRepoServiceNoop();
        this.c = new ConversationRepoServiceNoop();
        this.d = new SettingRepoServiceNoop();
        this.e = new UserSettingRepoServiceNoop();
        this.f = new BotRepoServiceNoop();
    }

    public final IBotRepoService b() {
        return this.f;
    }

    public final ISettingRepoService c() {
        return this.d;
    }

    public final IChatRepoService e() {
        return this.b;
    }

    public final IConversationRepoService f() {
        return this.c;
    }

    public final ExecutorCoroutineDispatcher g() {
        return this.a;
    }

    public final IUserSettingRepoService h() {
        return this.e;
    }

    public final <T> Object d(Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> r4, Continuation<? super T> r5) {
        return BuildersKt.withContext(this.a, new RepoDispatcherServiceNoop$dispatch$2(r4, null), r5);
    }

    public final Object a(int r1, String r2, ArrayList<Integer> r3, String r4, String r5, String r6, int r7, List<String> r8, Map<String, String> r9, Function1<? super Integer, Unit> r10, Continuation<? super Boolean> r11) {
        r10.invoke(Boxing.boxInt(0));
        return Boxing.boxBoolean(false);
    }
}
