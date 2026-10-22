package com.larus.uaigc.creation.detail.image;

import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.ParticipantModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.model.SlashMentionConfig;
import com.larus.platform.service.AccountService;
import com.tencent.open.log.TraceLevel;
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
import tx9.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment$reportPicClickAddCreation$1", f = "BigImageDetailFragment.kt", i = {1, 2, 2, 3, 3}, l = {680, 683, 685, 689}, m = "invokeSuspend", n = {"cvsId", "cvsId", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "botId"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
final class BigImageDetailFragment$reportPicClickAddCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $messageId;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ BigImageDetailFragment this$0;

    public BigImageDetailFragment$reportPicClickAddCreation$1(String r1, BigImageDetailFragment r2, Continuation<? super BigImageDetailFragment$reportPicClickAddCreation$1> r3) {
        this.$messageId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BigImageDetailFragment$reportPicClickAddCreation$1(this.$messageId, this.this$0, r4);
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
        String r11 = "0";
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
    L95:
        String r17 = r9;
        BigImageDetailFragment r10 = this.this$0;
        String r12 = r10.F.C;
        String r20 = r10.ba0();
        Integer r13 = this.this$0.aa0();
        if (r13 == null) goto L100;
        String r15 = zp9.y.a(r13.intValue());
    L101:
        m0.b(this.$messageId, r16, r17, "chat", "picture_detail", r20, r15, r12, null, 768);
        return Unit.INSTANCE;
    L100:
        r15 = "";
        goto L101
    L78:
        if (r6.intValue() != 2) goto L96;
        if (r5 == null) goto L86;
        Integer r18 = r5.getBotType();
        if (r18 == null) goto L86;
        if (r18.intValue() != 2) goto L86;
        r8 = true;
    L86:
        if (r8 == false) goto L88;
        r9 = "other_default";
        goto L95
    L88:
        if (r5 == null) goto L93;
        BotCreatorInfo r19 = r5.getBotCreatorInfo();
        if (r19 == null) goto L93;
        r14 = r19.getId();
    L93:
        if (Intrinsics.areEqual(r14, AccountService.a.getUserId()) == false) goto L96;
        r9 = "self_created";
        goto L95
    L73:
        if (r6.intValue() != 3) goto L75;
        r9 = "default_new";
        goto L95
    L68:
        if (r6.intValue() != 1) goto L70;
        r9 = "default";
        goto L95
    L64:
        r6 = null;
        goto L65
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r3 = (wc9.e) this.L$1;
        String r21 = (String) this.L$0;
        ResultKt.throwOnFailure(r26);
        Object r22 = r26;
    L45:
        wc9.k r23 = (wc9.k) r22;
        if (r23 == null) goto L52;
        List r24 = r23.b;
        if (r24 == null) goto L52;
        ParticipantModel r25 = (ParticipantModel) CollectionsKt.firstOrNull(r24);
        if (r25 == null) goto L52;
        String r27 = r25.getParticipantId();
    L53:
        IBotRepoService r28 = RepoDispatcherDelegate.b.b();
        if (r21 == null) goto L57;
        r11 = r21;
    L57:
        this.L$0 = r3;
        this.L$1 = r27;
        this.label = 4;
        r4 = r28.j1(r11, false, this);
        if (r4 != r7) goto L60;
        return r7;
    L60:
        r16 = r27;
    L52:
        r27 = null;
        goto L53
    L12:
        String r29 = (String) this.L$0;
        ResultKt.throwOnFailure(r26);
        String r110 = r29;
        Object r30 = r26;
    L35:
        r3 = (wc9.e) r30;
    L36:
        r21 = r110;
        IConversationRepoService r31 = RepoDispatcherDelegate.b.f();
        if (r21 != null) goto L41;
        String r32 = "0";
    L42:
        this.L$0 = r21;
        this.L$1 = r3;
        this.label = 3;
        r22 = IConversationRepoService.a.d(r31, r32, this);
        if (r22 != r7) goto L45;
        return r7;
    L41:
        r32 = r21;
        goto L42
    L13:
        ResultKt.throwOnFailure(r26);
        Object r33 = r26;
    L22:
        Message r34 = (Message) r33;
    L24:
        if (r34 == null) goto L26;
        r110 = r34.getConversationId();
    L27:
        IConversationRepoService r35 = RepoDispatcherDelegate.b.f();
        if (r35 == null) goto L37;
        if (r110 != null) goto L31;
        String r36 = "0";
    L32:
        this.L$0 = r110;
        this.label = 2;
        r30 = IConversationRepoService.a.c(r35, r36, false, null, this, 6);
        if (r30 != r7) goto L35;
        return r7;
    L31:
        r36 = r110;
        goto L32
    L37:
        r3 = null;
        goto L36
    L26:
        r110 = null;
        goto L27
    L14:
        ResultKt.throwOnFailure(r26);
        IChatRepoService r37 = RepoDispatcherDelegate.b.e();
        if (r37 == null) goto L23;
        String r38 = this.$messageId;
        if (r38 != null) goto L19;
        r38 = "0";
    L19:
        this.label = 1;
        r33 = r37.E1(r38, this);
        if (r33 != r7) goto L22;
        return r7;
    L23:
        r34 = null;
        goto L24
    }
}
