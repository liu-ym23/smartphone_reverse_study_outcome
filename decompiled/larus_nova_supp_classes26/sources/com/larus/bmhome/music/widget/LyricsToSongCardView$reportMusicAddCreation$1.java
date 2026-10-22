package com.larus.bmhome.music.widget;

import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.ParticipantModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.widget.LyricsToSongCardView$reportMusicAddCreation$1", f = "LyricsToSongCardView.kt", i = {1, 2, 2, 3, 3}, l = {506, 508, 509, 515}, m = "invokeSuspend", n = {"cvsId", "cvsId", "conversation", "conversation", "botId"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
final class LyricsToSongCardView$reportMusicAddCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ boolean $success;
    Object L$0;
    Object L$1;
    int label;

    public LyricsToSongCardView$reportMusicAddCreation$1(String r1, boolean r2, String r3, Continuation<? super LyricsToSongCardView$reportMusicAddCreation$1> r4) {
        this.$messageId = r1;
        this.$success = r2;
        this.$creationId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new LyricsToSongCardView$reportMusicAddCreation$1(this.$messageId, this.$success, this.$creationId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r26) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r8 = false;
        String r11 = TriggerSendLoading.NO_LOADING;
        String r14 = null;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        String r1 = (String) this.L$1;
        wc9.e r2 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r26);
        String r16 = r1;
        wc9.e r3 = r2;
        Object r4 = r26;
    L61:
        BotModel r5 = (BotModel) r4;
        if (r3 == null) goto L64;
        Integer r6 = r3.v;
    L65:
        if (r6 != null) goto L68;
    L70:
        if (r6 != null) goto L73;
    L75:
        if (r6 != null) goto L78;
    L96:
        String r9 = "others_created";
    L97:
        tx9.m0.a(this.$messageId, r16, r9, "chat_list", "chat", this.$success, this.$creationId, "music", null, 1792);
        return Unit.INSTANCE;
    L78:
        if (r6.intValue() != 2) goto L96;
        if (r5 == null) goto L86;
        Integer r10 = r5.getBotType();
        if (r10 == null) goto L86;
        if (r10.intValue() != 2) goto L86;
        r8 = true;
    L86:
        if (r8 == false) goto L88;
        r9 = "other_default";
        goto L97
    L88:
        if (r5 == null) goto L93;
        BotCreatorInfo r12 = r5.getBotCreatorInfo();
        if (r12 == null) goto L93;
        r14 = r12.getId();
    L93:
        if (Intrinsics.areEqual(r14, AccountService.a.getUserId()) == false) goto L96;
        r9 = "self_created";
        goto L97
    L73:
        if (r6.intValue() != 3) goto L75;
        r9 = "default_new";
        goto L97
    L68:
        if (r6.intValue() != 1) goto L70;
        r9 = "default";
        goto L97
    L64:
        r6 = null;
        goto L65
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r3 = (wc9.e) this.L$1;
        String r13 = (String) this.L$0;
        ResultKt.throwOnFailure(r26);
        Object r15 = r26;
    L45:
        wc9.k r17 = (wc9.k) r15;
        if (r17 == null) goto L52;
        List r18 = r17.b;
        if (r18 == null) goto L52;
        ParticipantModel r19 = (ParticipantModel) CollectionsKt.firstOrNull(r18);
        if (r19 == null) goto L52;
        String r20 = r19.getParticipantId();
    L53:
        IBotRepoService r21 = RepoDispatcherDelegate.b.b();
        if (r13 == null) goto L57;
        r11 = r13;
    L57:
        this.L$0 = r3;
        this.L$1 = r20;
        this.label = 4;
        r4 = r21.j1(r11, false, this);
        if (r4 != r7) goto L60;
        return r7;
    L60:
        r16 = r20;
    L52:
        r20 = null;
        goto L53
    L12:
        String r22 = (String) this.L$0;
        ResultKt.throwOnFailure(r26);
        String r110 = r22;
        Object r23 = r26;
    L35:
        r3 = (wc9.e) r23;
    L36:
        r13 = r110;
        IConversationRepoService r24 = RepoDispatcherDelegate.b.f();
        if (r13 != null) goto L41;
        String r25 = TriggerSendLoading.NO_LOADING;
    L42:
        this.L$0 = r13;
        this.L$1 = r3;
        this.label = 3;
        r15 = IConversationRepoService.a.d(r24, r25, this);
        if (r15 != r7) goto L45;
        return r7;
    L41:
        r25 = r13;
        goto L42
    L13:
        ResultKt.throwOnFailure(r26);
        Object r27 = r26;
    L22:
        Message r28 = (Message) r27;
    L24:
        if (r28 == null) goto L26;
        r110 = r28.getConversationId();
    L27:
        IConversationRepoService r29 = RepoDispatcherDelegate.b.f();
        if (r29 == null) goto L37;
        if (r110 != null) goto L31;
        String r30 = TriggerSendLoading.NO_LOADING;
    L32:
        this.L$0 = r110;
        this.label = 2;
        r23 = IConversationRepoService.a.c(r29, r30, false, null, this, 6);
        if (r23 != r7) goto L35;
        return r7;
    L31:
        r30 = r110;
        goto L32
    L37:
        r3 = null;
        goto L36
    L26:
        r110 = null;
        goto L27
    L14:
        ResultKt.throwOnFailure(r26);
        IChatRepoService r31 = RepoDispatcherDelegate.b.e();
        if (r31 == null) goto L23;
        String r32 = this.$messageId;
        if (r32 != null) goto L19;
        r32 = TriggerSendLoading.NO_LOADING;
    L19:
        this.label = 1;
        r27 = r31.E1(r32, this);
        if (r27 != r7) goto L22;
        return r7;
    L23:
        r28 = null;
        goto L24
    }
}
