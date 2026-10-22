package com.larus.bmhome.video.fragment;

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
import tx9.m0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.video.fragment.AiGenVideoDetailFragment$reportPicClickAddCreation$1", f = "AiGenVideoDetailFragment.kt", i = {1, 2, 2, 3, 3, 4, 4}, l = {578, 581, 583, 587, 614}, m = "invokeSuspend", n = {"cvsId", "cvsId", "conversation", "conversation", "botId", "botId", "chatType"}, s = {"L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
final class AiGenVideoDetailFragment$reportPicClickAddCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $messageId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ AiGenVideoDetailFragment this$0;

    public AiGenVideoDetailFragment$reportPicClickAddCreation$1(String r1, AiGenVideoDetailFragment r2, Continuation<? super AiGenVideoDetailFragment$reportPicClickAddCreation$1> r3) {
        this.$messageId = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AiGenVideoDetailFragment$reportPicClickAddCreation$1(this.$messageId, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        boolean r8 = false;
        String r12 = TriggerSendLoading.NO_LOADING;
        String r15 = null;
        if (r0 == 0) goto L17;
        if (r0 == 1) goto L16;
        if (r0 == 2) goto L15;
        if (r0 == 3) goto L14;
        if (r0 == 4) goto L13;
        if (r0 != 5) goto L12;
        String r1 = (String) this.L$3;
        String r2 = (String) this.L$2;
        String r3 = (String) this.L$1;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r5 = r19;
    L10:
        String r13 = r1;
        String r14 = r2;
        String r9 = r3;
        String r10 = r4;
        m0.b(this.$messageId, r10, r9, "chat", "video_detail", r13, (String) r5, r14, null, 768);
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        String r6 = (String) this.L$1;
        wc9.e r11 = (wc9.e) this.L$0;
        ResultKt.throwOnFailure(r19);
        r4 = r6;
        wc9.e r16 = r11;
        Object r17 = r19;
    L64:
        BotModel r18 = (BotModel) r17;
        if (r16 == null) goto L67;
        Integer r20 = r16.v;
    L68:
        if (r20 != null) goto L71;
    L73:
        if (r20 != null) goto L76;
    L78:
        if (r20 != null) goto L81;
    L99:
        String r21 = "others_created";
    L98:
        r3 = r21;
        AiGenVideoDetailFragment r22 = this.this$0;
        r2 = r22.P;
        r1 = zp9.y.b(r22.ha0());
        AiGenVideoDetailFragment r23 = this.this$0;
        this.L$0 = r4;
        this.L$1 = r3;
        this.L$2 = r2;
        this.L$3 = r1;
        this.label = 5;
        r5 = r23.na0(this);
        if (r5 != r7) goto L10;
        return r7;
    L81:
        if (r20.intValue() != 2) goto L99;
        if (r18 == null) goto L89;
        Integer r24 = r18.getBotType();
        if (r24 == null) goto L89;
        if (r24.intValue() != 2) goto L89;
        r8 = true;
    L89:
        if (r8 == false) goto L91;
        r21 = "other_default";
        goto L98
    L91:
        if (r18 == null) goto L96;
        BotCreatorInfo r25 = r18.getBotCreatorInfo();
        if (r25 == null) goto L96;
        r15 = r25.getId();
    L96:
        if (Intrinsics.areEqual(r15, AccountService.a.getUserId()) == false) goto L99;
        r21 = "self_created";
        goto L98
    L76:
        if (r20.intValue() != 3) goto L78;
        r21 = "default_new";
        goto L98
    L71:
        if (r20.intValue() != 1) goto L73;
        r21 = "default";
        goto L98
    L67:
        r20 = null;
        goto L68
    L14:
        r16 = (wc9.e) this.L$1;
        String r26 = (String) this.L$0;
        ResultKt.throwOnFailure(r19);
        Object r27 = r19;
    L48:
        wc9.k r28 = (wc9.k) r27;
        if (r28 == null) goto L55;
        List r29 = r28.b;
        if (r29 == null) goto L55;
        ParticipantModel r30 = (ParticipantModel) CollectionsKt.firstOrNull(r29);
        if (r30 == null) goto L55;
        String r31 = r30.getParticipantId();
    L56:
        IBotRepoService r32 = RepoDispatcherDelegate.b.b();
        if (r26 == null) goto L60;
        r12 = r26;
    L60:
        this.L$0 = r16;
        this.L$1 = r31;
        this.label = 4;
        r17 = r32.j1(r12, false, this);
        if (r17 != r7) goto L63;
        return r7;
    L63:
        r4 = r31;
    L55:
        r31 = null;
        goto L56
    L15:
        String r33 = (String) this.L$0;
        ResultKt.throwOnFailure(r19);
        String r110 = r33;
        Object r34 = r19;
    L38:
        r16 = (wc9.e) r34;
    L39:
        r26 = r110;
        IConversationRepoService r35 = RepoDispatcherDelegate.b.f();
        if (r26 != null) goto L44;
        String r36 = TriggerSendLoading.NO_LOADING;
    L45:
        this.L$0 = r26;
        this.L$1 = r16;
        this.label = 3;
        r27 = IConversationRepoService.a.d(r35, r36, this);
        if (r27 != r7) goto L48;
        return r7;
    L44:
        r36 = r26;
        goto L45
    L16:
        ResultKt.throwOnFailure(r19);
        Object r37 = r19;
    L25:
        Message r38 = (Message) r37;
    L27:
        if (r38 == null) goto L29;
        String r39 = r38.getConversationId();
    L30:
        IConversationRepoService r40 = RepoDispatcherDelegate.b.f();
        if (r40 == null) goto L40;
        if (r39 != null) goto L34;
        String r41 = TriggerSendLoading.NO_LOADING;
    L35:
        this.L$0 = r39;
        this.label = 2;
        r110 = r39;
        r34 = IConversationRepoService.a.c(r40, r41, false, null, this, 6);
        if (r34 != r7) goto L38;
        return r7;
    L34:
        r41 = r39;
        goto L35
    L40:
        r110 = r39;
        r16 = null;
        goto L39
    L29:
        r39 = null;
        goto L30
    L17:
        ResultKt.throwOnFailure(r19);
        IChatRepoService r42 = RepoDispatcherDelegate.b.e();
        if (r42 == null) goto L26;
        String r43 = this.$messageId;
        if (r43 != null) goto L22;
        r43 = TriggerSendLoading.NO_LOADING;
    L22:
        this.label = 1;
        r37 = r42.E1(r43, this);
        if (r37 != r7) goto L25;
        return r7;
    L26:
        r38 = null;
        goto L27
    }
}
