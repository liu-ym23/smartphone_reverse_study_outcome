package com.larus.bmhome.chat.component.list;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonSyntaxException;
import com.larus.bmhome.chat.bean.PromptContent;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.manager.PromptCacheManager;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.ConversationRepo;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.MessageTag;
import com.larus.im.d;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import ub8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$clearSection$1", f = "ChatListComponentViewModel.kt", i = {1}, l = {1804, 1808, 1834}, m = "invokeSuspend", n = {"conversation"}, s = {"L$0"})
public final class ChatListComponentViewModel$clearSection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $conversationId;
    Object L$0;
    int label;
    final /* synthetic */ ChatListComponentViewModel this$0;

    public ChatListComponentViewModel$clearSection$1(String r1, ChatListComponentViewModel r2, Continuation<? super ChatListComponentViewModel$clearSection$1> r3) {
        this.$conversationId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatListComponentViewModel$clearSection$1(this.$conversationId, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r47) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        ResultKt.throwOnFailure(r47);
        Object r1 = r47;
    L97:
        this.this$0.getContextClearSuccess().postValue((b) r1);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        wc9.e r2 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r47);
        Object r3 = r47;
    L22:
        Message r4 = (Message) r3;
        boolean r5 = false;
        if (r4 != null) goto L25;
    L27:
        boolean r6 = false;
    L28:
        if (r6 == true) goto L94;
        if (r4 != null) goto L31;
    L33:
        boolean r8 = false;
    L34:
        if (r8 == true) goto L94;
        Keva r9 = PromptCacheManager.b;
        String r10 = r9.getString(PromptCacheManager.c(), "");
        if (r10 != null) goto L38;
    L41:
        boolean r11 = true;
    L43:
        if (r11 == false) goto L45;
        FLogger.a.i("PromptCacheManager", "cachedTopicsStr is empty, get topic from Tcc");
        List r12 = CollectionsKt.take(CollectionsKt.shuffled(ArraysKt.toList(r9.getStringArray("key_cached_tcc_prompt", new String[0]))), 15);
    L72:
        if (r12.isEmpty() == false) goto L74;
        ArrayList r13 = null;
    L81:
        if (r13 != null) goto L83;
    L84:
        r5 = true;
    L85:
        if (r5 == true) goto L94;
        if (r2 == null) goto L92;
        String r14 = r2.B;
        if (r14 == null) goto L92;
        Long r15 = StringsKt.toLongOrNull(r14);
        if (r15 == null) goto L92;
        long r16 = r15.longValue();
    L93:
        String r24 = String.valueOf(r16 + 1);
        MessageStatus r33 = MessageStatus.MessageStatus_AVAILABLE;
        List r28 = CollectionsKt.listOf(Boxing.boxInt(MessageTag.MessageTag_Onboarding_WELCOMEBACK.value));
        Map r25 = MapsKt.mapOf(TuplesKt.to("suggest_items", GsonProtectorUtils.toJson(HttpExtKt.f, r13)));
        int r17 = wf9.b.a;
        d.e().addMessage(new yc9.f0(this.$conversationId, null, "sender_from_prompt_cache", 0, 2, "new_topic", com.larus.bmhome.social.userchat.model.b0.k(com.flow.kmp.common.util.i.a(), 1), null, 21, null, false, r24, r25, null, null, r28, null, null, null, null, r33, 502061770), null);
    L92:
        r16 = System.currentTimeMillis();
        goto L93
    L83:
        if (r13.isEmpty() == false) goto L85;
    L74:
        List r18 = r12;
        r13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r18, 10));
        Iterator r19 = r18.iterator();
        int r20 = 0;
    L76:
        if (r19.hasNext() == false) goto L81;
        Object r21 = r19.next();
        int r22 = r20 + 1;
        if (r20 >= 0) goto L80;
        CollectionsKt.throwIndexOverflow();
    L80:
        r13.add(new PromptContent.SuggestItem((String) r21, "", "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, null, 2147483640, null));
        r20 = r22;
        goto L76
    L45:
        LinkedHashSet r23 = new LinkedHashSet();
        List r26 = (List) GsonProtectorUtils.fromJson(PromptCacheManager.a, r10, new com.larus.bmhome.chat.manager.q0().getType());     // Catch: JsonSyntaxException -> L48
    L49:
        Intrinsics.checkNotNull(r26);
        Iterator r27 = r26.iterator();
    L51:
        if (r27.hasNext() == false) goto L56;
        List<String> r29 = ((PromptCacheManager.a) r27.next()).b();
        if (r29 == null) goto L51;
        r23.addAll(r29);
        goto L51
    L56:
        if (r23.size() < 15) goto L58;
        List r30 = CollectionsKt.toMutableList(r23);
        Collections.shuffle(r30);
        r12 = r30.subList(0, 15);
        goto L72
    L58:
        String[] r31 = PromptCacheManager.b.getStringArray("key_cached_tcc_prompt", new String[0]);
        if (r31.length != 0) goto L61;
        boolean r32 = true;
    L63:
        if ((!r32) == false) goto L70;
        int r34 = 0;
    L66:
        if (r23.size() >= 15) goto L70;
        if (r34 >= r31.length) goto L70;
        r23.add(r31[r34]);
        r34 = r34 + 1;
    L70:
        r12 = CollectionsKt.toList(r23);
        goto L72
    L61:
        r32 = false;
    L48:
        r26 = CollectionsKt.emptyList();
        goto L49
    L38:
        if (r10.length() == 0) goto L41;
        r11 = false;
        goto L43
    L31:
        if (com.larus.bmhome.chat.bean.d.k0(r4) != true) goto L33;
        r8 = true;
    L94:
        RepoDispatcher.a.getClass();
        ConversationRepo r35 = RepoDispatcher.f;
        String r36 = this.$conversationId;
        this.L$0 = null;
        this.label = 3;
        r1 = r35.n(r36, 3, "chat_settings", this);
        if (r1 != r7) goto L97;
        return r7;
    L25:
        if (com.larus.bmhome.chat.bean.d.W0(r4) != true) goto L27;
        r6 = true;
        goto L28
    L11:
        ResultKt.throwOnFailure(r47);
        Object r37 = r47;
    L17:
        r2 = (wc9.e) r37;
        if (com.larus.bmhome.utils.i.f(r2) == false) goto L94;
        RepoDispatcher.a.getClass();
        ChatRepo r38 = RepoDispatcher.d;
        String r39 = this.$conversationId;
        this.L$0 = r2;
        this.label = 2;
        r3 = r38.K1(r39, this);
        if (r3 != r7) goto L22;
        return r7;
    L12:
        ResultKt.throwOnFailure(r47);
        if (z2.a.showNewTopicMainBotEnable() == false) goto L94;
        RepoDispatcher.a.getClass();
        ConversationRepo r40 = RepoDispatcher.f;
        String r41 = this.$conversationId;
        this.label = 1;
        r37 = IConversationRepoService$a.c(r40, r41, false, null, this, 6);
        if (r37 != r7) goto L17;
        return r7;
    }
}
