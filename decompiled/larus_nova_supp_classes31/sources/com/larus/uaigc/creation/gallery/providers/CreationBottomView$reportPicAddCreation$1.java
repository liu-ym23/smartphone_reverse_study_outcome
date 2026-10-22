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
import java.util.Map;
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
@DebugMetadata(c = "com.larus.uaigc.creation.gallery.providers.CreationBottomView$reportPicAddCreation$1", f = "CreationBottomView.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {463, 465, 469}, m = "invokeSuspend", n = {"cvsId", "creationType", "cvsId", "creationType", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "creationType", SlashMentionConfig.MENTION_CONTENT_CONVERSATION, "botId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class CreationBottomView$reportPicAddCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ Message $message;
    final /* synthetic */ boolean $success;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public CreationBottomView$reportPicAddCreation$1(Message r1, boolean r2, String r3, Continuation<? super CreationBottomView$reportPicAddCreation$1> r4) {
        this.$message = r1;
        this.$success = r2;
        this.$creationId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationBottomView$reportPicAddCreation$1(this.$message, this.$success, this.$creationId, r5);
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
        String r1 = (String) this.L$2;
        wc9.e r2 = (wc9.e) this.L$1;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r25);
        String r15 = r1;
        String r21 = r3;
        Object r4 = r25;
    L70:
        BotModel r5 = (BotModel) r4;
        if (r2 == null) goto L73;
        Integer r6 = r2.v;
    L74:
        if (r6 != null) goto L77;
    L79:
        if (r6 != null) goto L82;
    L84:
        if (r6 != null) goto L87;
    L106:
        String r10 = "others_created";
    L105:
        String r16 = r10;
        Message r11 = this.$message;
        if (r11 == null) goto L110;
        r13 = r11.getMessageId();
    L110:
        m0.a(r13, r15, r16, "chat", "picture_detail", this.$success, this.$creationId, r21, null, 1792);
        return Unit.INSTANCE;
    L87:
        if (r6.intValue() != 2) goto L106;
        if (r5 == null) goto L95;
        Integer r12 = r5.getBotType();
        if (r12 == null) goto L95;
        if (r12.intValue() != 2) goto L95;
        r8 = true;
    L95:
        if (r8 == false) goto L97;
        r10 = "other_default";
        goto L105
    L97:
        if (r5 == null) goto L101;
        BotCreatorInfo r14 = r5.getBotCreatorInfo();
        if (r14 == null) goto L101;
        String r17 = r14.getId();
    L103:
        if (Intrinsics.areEqual(r17, AccountService.a.getUserId()) == false) goto L106;
        r10 = "self_created";
    L101:
        r17 = null;
        goto L103
    L82:
        if (r6.intValue() != 3) goto L84;
        r10 = "default_new";
        goto L105
    L77:
        if (r6.intValue() != 1) goto L79;
        r10 = "default";
        goto L105
    L73:
        r6 = null;
        goto L74
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        wc9.e r18 = (wc9.e) this.L$2;
        String r19 = (String) this.L$1;
        String r20 = (String) this.L$0;
        ResultKt.throwOnFailure(r25);
        String r110 = r19;
        Object r22 = r25;
    L54:
        wc9.k r23 = (wc9.k) r22;
        if (r23 == null) goto L61;
        List r24 = r23.b;
        if (r24 == null) goto L61;
        ParticipantModel r26 = (ParticipantModel) CollectionsKt.firstOrNull(r24);
        if (r26 == null) goto L61;
        String r27 = r26.getParticipantId();
    L62:
        IBotRepoService r28 = RepoDispatcherDelegate.b.b();
        if (r20 == null) goto L66;
        r9 = r20;
    L66:
        this.L$0 = r110;
        this.L$1 = r18;
        this.L$2 = r27;
        this.label = 3;
        r4 = r28.j1(r9, false, this);
        if (r4 != r7) goto L69;
        return r7;
    L69:
        r21 = r110;
        r15 = r27;
        r2 = r18;
    L61:
        r27 = null;
        goto L62
    L11:
        String r29 = (String) this.L$1;
        String r30 = (String) this.L$0;
        ResultKt.throwOnFailure(r25);
        r110 = r29;
        Object r31 = r25;
    L45:
        r18 = (wc9.e) r31;
        r20 = r30;
    L47:
        IConversationRepoService r32 = RepoDispatcherDelegate.b.f();
        if (r20 != null) goto L50;
        String r33 = "0";
    L51:
        this.L$0 = r20;
        this.L$1 = r110;
        this.L$2 = r18;
        this.label = 2;
        r22 = IConversationRepoService.a.d(r32, r33, this);
        if (r22 != r7) goto L54;
        return r7;
    L50:
        r33 = r20;
        goto L51
    L12:
        ResultKt.throwOnFailure(r25);
        Message r34 = this.$message;
        if (r34 == null) goto L15;
        String r111 = r34.getConversationId();
    L16:
        Message r35 = this.$message;
        if (r35 == null) goto L21;
        Map r36 = r35.getExt();
        if (r36 == null) goto L21;
        String r37 = (String) r36.get("creativity_scene");
    L23:
        if (Intrinsics.areEqual(r37, "avatar_image") == false) goto L26;
        String r38 = "replica";
    L25:
        r110 = r38;
        IConversationRepoService r39 = RepoDispatcherDelegate.b.f();
        if (r39 == null) goto L46;
        if (r111 != null) goto L40;
        String r40 = "0";
    L41:
        this.L$0 = r111;
        this.L$1 = r110;
        this.label = 1;
        r31 = IConversationRepoService.a.c(r39, r40, false, null, this, 6);
        if (r31 != r7) goto L44;
        return r7;
    L44:
        r30 = r111;
        goto L45
    L40:
        r40 = r111;
        goto L41
    L46:
        r18 = null;
        r20 = r111;
        goto L47
    L26:
        Message r41 = this.$message;
        if (r41 == null) goto L31;
        Map r42 = r41.getExt();
        if (r42 == null) goto L31;
        String r43 = (String) r42.get("creativity_scene");
    L33:
        if (Intrinsics.areEqual(r43, "ai_beautify_image") == false) goto L35;
        r38 = "image_edit";
        goto L25
    L35:
        r38 = "pic";
    L31:
        r43 = null;
    L21:
        r37 = null;
        goto L23
    L15:
        r111 = null;
        goto L16
    }
}
