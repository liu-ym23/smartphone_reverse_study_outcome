package com.larus.bmhome.video.fragment;

import com.larus.bmhome.chat.model.repo.IBotRepoService;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.trace.ReeditType;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.bot.BotCreatorInfo;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.conversation.ParticipantModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$reportPicAddCreation$1", f = "AiGenVideoDetailFragment.kt", i = {1, 1, 2, 2, 2, 3, 3, 3}, l = {528, 538, 540, 544}, m = "invokeSuspend", n = {"cvsId", "creationType", "cvsId", "creationType", "conversation", "creationType", "conversation", "botId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
final class AiGenVideoDetailFragment$reportPicAddCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ boolean $success;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public AiGenVideoDetailFragment$reportPicAddCreation$1(String r1, boolean r2, String r3, Continuation<? super AiGenVideoDetailFragment$reportPicAddCreation$1> r4) {
        this.$messageId = r1;
        this.$success = r2;
        this.$creationId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AiGenVideoDetailFragment$reportPicAddCreation$1(this.$messageId, this.$success, this.$creationId, r5);
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
        String r1 = (String) this.L$2;
        wc9.e r2 = (wc9.e) this.L$1;
        String r3 = (String) this.L$0;
        ResultKt.throwOnFailure(r26);
        String r16 = r1;
        String r22 = r3;
        Object r4 = r26;
    L80:
        BotModel r5 = (BotModel) r4;
        if (r2 == null) goto L83;
        Integer r6 = r2.v;
    L84:
        if (r6 != null) goto L87;
    L89:
        if (r6 != null) goto L92;
    L94:
        if (r6 != null) goto L97;
    L115:
        String r9 = "others_created";
    L116:
        m0.a(this.$messageId, r16, r9, "chat", "picture_detail", this.$success, this.$creationId, r22, null, 1792);
        return Unit.INSTANCE;
    L97:
        if (r6.intValue() != 2) goto L115;
        if (r5 == null) goto L105;
        Integer r10 = r5.getBotType();
        if (r10 == null) goto L105;
        if (r10.intValue() != 2) goto L105;
        r8 = true;
    L105:
        if (r8 == false) goto L107;
        r9 = "other_default";
        goto L116
    L107:
        if (r5 == null) goto L112;
        BotCreatorInfo r12 = r5.getBotCreatorInfo();
        if (r12 == null) goto L112;
        r14 = r12.getId();
    L112:
        if (Intrinsics.areEqual(r14, AccountService.a.getUserId()) == false) goto L115;
        r9 = "self_created";
        goto L116
    L92:
        if (r6.intValue() != 3) goto L94;
        r9 = "default_new";
        goto L116
    L87:
        if (r6.intValue() != 1) goto L89;
        r9 = "default";
        goto L116
    L83:
        r6 = null;
        goto L84
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        wc9.e r13 = (wc9.e) this.L$2;
        String r15 = (String) this.L$1;
        String r17 = (String) this.L$0;
        ResultKt.throwOnFailure(r26);
        String r18 = r15;
        Object r19 = r26;
    L64:
        wc9.k r20 = (wc9.k) r19;
        if (r20 == null) goto L71;
        List r21 = r20.b;
        if (r21 == null) goto L71;
        ParticipantModel r23 = (ParticipantModel) CollectionsKt.firstOrNull(r21);
        if (r23 == null) goto L71;
        String r24 = r23.getParticipantId();
    L72:
        IBotRepoService r25 = RepoDispatcherDelegate.b.b();
        if (r17 == null) goto L76;
        r11 = r17;
    L76:
        this.L$0 = r18;
        this.L$1 = r13;
        this.L$2 = r24;
        this.label = 4;
        r4 = r25.j1(r11, false, this);
        if (r4 != r7) goto L79;
        return r7;
    L79:
        r16 = r24;
        r22 = r18;
        r2 = r13;
    L71:
        r24 = null;
        goto L72
    L12:
        String r27 = (String) this.L$1;
        String r28 = (String) this.L$0;
        ResultKt.throwOnFailure(r26);
        String r110 = r27;
        Object r29 = r26;
    L55:
        r13 = (wc9.e) r29;
        r17 = r28;
        r18 = r110;
    L57:
        IConversationRepoService r30 = RepoDispatcherDelegate.b.f();
        if (r17 != null) goto L60;
        String r31 = TriggerSendLoading.NO_LOADING;
    L61:
        this.L$0 = r17;
        this.L$1 = r18;
        this.L$2 = r13;
        this.label = 3;
        r19 = IConversationRepoService.a.d(r30, r31, this);
        if (r19 != r7) goto L64;
        return r7;
    L60:
        r31 = r17;
        goto L61
    L13:
        ResultKt.throwOnFailure(r26);
        Object r32 = r26;
    L22:
        Message r33 = (Message) r32;
    L24:
        if (r33 == null) goto L26;
        String r111 = r33.getConversationId();
    L28:
        if (r33 == null) goto L32;
        Map r34 = r33.getExt();
        if (r34 == null) goto L32;
        String r35 = (String) r34.get("creativity_scene");
    L34:
        if (Intrinsics.areEqual(r35, CreativeScene.AVATAR_IMAGE) == false) goto L37;
        String r36 = "replica";
    L36:
        r18 = r36;
        IConversationRepoService r37 = RepoDispatcherDelegate.b.f();
        if (r37 == null) goto L56;
        if (r111 != null) goto L50;
        String r38 = TriggerSendLoading.NO_LOADING;
    L51:
        this.L$0 = r111;
        this.L$1 = r18;
        this.label = 2;
        r110 = r18;
        r29 = IConversationRepoService.a.c(r37, r38, false, null, this, 6);
        if (r29 != r7) goto L54;
        return r7;
    L54:
        r28 = r111;
        goto L55
    L50:
        r38 = r111;
        goto L51
    L56:
        r13 = null;
        r17 = r111;
        goto L57
    L37:
        if (r33 == null) goto L41;
        Map r39 = r33.getExt();
        if (r39 == null) goto L41;
        String r40 = (String) r39.get("creativity_scene");
    L43:
        if (Intrinsics.areEqual(r40, CreativeScene.AI_BEAUTIFY_IMAGE) == false) goto L45;
        r36 = "image_edit";
        goto L36
    L45:
        r36 = ReeditType.IMAGE;
    L41:
        r40 = null;
    L32:
        r35 = null;
        goto L34
    L26:
        r111 = null;
        goto L28
    L14:
        ResultKt.throwOnFailure(r26);
        IChatRepoService r41 = RepoDispatcherDelegate.b.e();
        if (r41 == null) goto L23;
        String r42 = this.$messageId;
        if (r42 != null) goto L19;
        r42 = TriggerSendLoading.NO_LOADING;
    L19:
        this.label = 1;
        r32 = r41.E1(r42, this);
        if (r32 != r7) goto L22;
        return r7;
    L23:
        r33 = null;
        goto L24
    }
}
