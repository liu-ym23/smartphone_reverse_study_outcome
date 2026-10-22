package com.larus.uaigc.creation.gallery.providers;

import com.larus.bmhome.chat.model.repo.IBotRepoService;
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
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationBottomView$reportPicClickAddCreation$1", f = "CreationBottomView.kt", i = {0, 1, 1, 2, 2}, l = {505, 507, 511}, m = "invokeSuspend", n = {"cvsId", "cvsId", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "botId"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
final class CreationBottomView$reportPicClickAddCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Message $message;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ CreationBottomView this$0;

    public CreationBottomView$reportPicClickAddCreation$1(Message r1, CreationBottomView r2, Continuation<? super CreationBottomView$reportPicClickAddCreation$1> r3) {
        this.$message = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationBottomView$reportPicClickAddCreation$1(this.$message, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r8 = false;
        String r9 = "0";
        String r13 = null;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        String r1 = (String) this.L$1;
        wc9.e r2 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r25);
        String r15 = r1;
        wc9.e r3 = r2;
        Object r4 = r25;
    L50:
        BotModel r5 = (BotModel) r4;
        if (r3 == null) goto L53;
        Integer r6 = r3.v;
    L54:
        if (r6 != null) goto L57;
    L59:
        if (r6 != null) goto L62;
    L64:
        if (r6 != null) goto L67;
    L86:
        String r10 = "others_created";
    L85:
        String r16 = r10;
        Message r11 = this.$message;
        if (r11 == null) goto L90;
        String r14 = r11.getMessageId();
    L91:
        CreationBottomView r12 = this.this$0;
        sz9.a r17 = r12.d;
        if (r17 == null) goto L94;
        r13 = r17.p;
    L94:
        m0.b(r14, r15, r16, "chat", "picture_detail", CreationBottomView.S5(r12), CreationBottomView.U5(this.this$0), r13, null, 768);
        return Unit.INSTANCE;
    L90:
        r14 = null;
        goto L91
    L67:
        if (r6.intValue() != 2) goto L86;
        if (r5 == null) goto L75;
        Integer r18 = r5.getBotType();
        if (r18 == null) goto L75;
        if (r18.intValue() != 2) goto L75;
        r8 = true;
    L75:
        if (r8 == false) goto L77;
        r10 = "other_default";
        goto L85
    L77:
        if (r5 == null) goto L81;
        BotCreatorInfo r19 = r5.getBotCreatorInfo();
        if (r19 == null) goto L81;
        String r20 = r19.getId();
    L83:
        if (Intrinsics.areEqual(r20, AccountService.a.getUserId()) == false) goto L86;
        r10 = "self_created";
    L81:
        r20 = null;
        goto L83
    L62:
        if (r6.intValue() != 3) goto L64;
        r10 = "default_new";
        goto L85
    L57:
        if (r6.intValue() != 1) goto L59;
        r10 = "default";
        goto L85
    L53:
        r6 = null;
        goto L54
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r3 = (wc9.e) this.L$1;
        String r21 = (String) this.L$0;
        ResultKt.throwOnFailure(r25);
        Object r22 = r25;
    L34:
        wc9.k r23 = (wc9.k) r22;
        if (r23 == null) goto L41;
        List r24 = r23.b;
        if (r24 == null) goto L41;
        ParticipantModel r26 = (ParticipantModel) CollectionsKt.firstOrNull(r24);
        if (r26 == null) goto L41;
        String r27 = r26.getParticipantId();
    L42:
        IBotRepoService r28 = RepoDispatcherDelegate.b.b();
        if (r21 == null) goto L46;
        r9 = r21;
    L46:
        this.L$0 = r3;
        this.L$1 = r27;
        this.label = 3;
        r4 = r28.j1(r9, false, this);
        if (r4 != r7) goto L49;
        return r7;
    L49:
        r15 = r27;
    L41:
        r27 = null;
        goto L42
    L11:
        String r29 = (String) this.L$0;
        ResultKt.throwOnFailure(r25);
        String r110 = r29;
        Object r30 = r25;
    L24:
        r3 = (wc9.e) r30;
    L25:
        r21 = r110;
        IConversationRepoService r31 = RepoDispatcherDelegate.b.f();
        if (r21 != null) goto L30;
        String r32 = "0";
    L31:
        this.L$0 = r21;
        this.L$1 = r3;
        this.label = 2;
        r22 = IConversationRepoService.a.d(r31, r32, this);
        if (r22 != r7) goto L34;
        return r7;
    L30:
        r32 = r21;
        goto L31
    L12:
        ResultKt.throwOnFailure(r25);
        Message r33 = this.$message;
        if (r33 == null) goto L15;
        r110 = r33.getConversationId();
    L16:
        IConversationRepoService r34 = RepoDispatcherDelegate.b.f();
        if (r34 == null) goto L26;
        if (r110 != null) goto L20;
        String r35 = "0";
    L21:
        this.L$0 = r110;
        this.label = 1;
        r30 = IConversationRepoService.a.c(r34, r35, false, null, this, 6);
        if (r30 != r7) goto L24;
        return r7;
    L20:
        r35 = r110;
        goto L21
    L26:
        r3 = null;
        goto L25
    L15:
        r110 = null;
        goto L16
    }
}
