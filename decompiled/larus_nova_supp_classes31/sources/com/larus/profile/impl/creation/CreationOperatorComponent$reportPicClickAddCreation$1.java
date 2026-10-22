package com.larus.profile.impl.creation;

import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.im.bean.conversation.ParticipantModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.creation.UserCreation;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationOperatorComponent$reportPicClickAddCreation$1", f = "CreationOperatorComponent.kt", i = {}, l = {120, 123}, m = "invokeSuspend", n = {}, s = {})
final class CreationOperatorComponent$reportPicClickAddCreation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $messageId;
    final /* synthetic */ String $pageName;
    int label;
    final /* synthetic */ CreationOperatorComponent this$0;

    public CreationOperatorComponent$reportPicClickAddCreation$1(String r1, CreationOperatorComponent r2, String r3, Continuation<? super CreationOperatorComponent$reportPicClickAddCreation$1> r4) {
        this.$messageId = r1;
        this.this$0 = r2;
        this.$pageName = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CreationOperatorComponent$reportPicClickAddCreation$1(this.$messageId, this.this$0, this.$pageName, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r3 = "0";
        String r6 = null;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r18);
        Object r4 = r18;
    L30:
        wc9.k r5 = (wc9.k) r4;
        if (r5 == null) goto L37;
        List r7 = r5.b;
        if (r7 == null) goto L37;
        ParticipantModel r8 = (ParticipantModel) CollectionsKt.firstOrNull(r7);
        if (r8 == null) goto L37;
        String r9 = r8.getParticipantId();
    L38:
        Integer r10 = this.this$0.g;
        if (r10 != null) goto L42;
    L44:
        String r11 = "creation_list";
    L45:
        String r12 = r11;
        String r13 = this.$pageName;
        if (r13 != null) goto L48;
        r13 = "creation_detail";
    L48:
        String r14 = r13;
        UserCreation r15 = this.this$0.d;
        if (r15 == null) goto L51;
        String r16 = r15.a;
    L52:
        if (r15 == null) goto L54;
        Integer r17 = Integer.valueOf(r15.b);
    L55:
        if (r17 != null) goto L58;
    L59:
        if (r17 != null) goto L62;
    L64:
        if (r17 != null) goto L67;
    L68:
        if (r17 != null) goto L71;
    L72:
        if (r17 != null) goto L75;
    L76:
        if (r17 != null) goto L79;
    L80:
        if (r17 != null) goto L83;
    L84:
        if (r17 != null) goto L87;
    L88:
        if (r17 != null) goto L91;
    L93:
        if (r17 != null) goto L96;
    L98:
        String r19 = "";
    L101:
        String r110 = r19;
        UserCreation r20 = this.this$0.d;
        if (r20 == null) goto L104;
        r6 = zp9.y.a(r20.b);
    L104:
        tx9.m0.b(this.$messageId, r9, "default", r12, r14, r110, r6, r16, null, 768);
        return Unit.INSTANCE;
    L96:
        if (r17.intValue() != 3) goto L98;
        r19 = "replica";
        goto L101
    L91:
        if (r17.intValue() != 12) goto L93;
    L99:
        r19 = "video";
        goto L101
    L87:
        if (r17.intValue() == 11) goto L99;
    L83:
        if (r17.intValue() == 10) goto L99;
    L79:
        if (r17.intValue() == 9) goto L99;
    L75:
        if (r17.intValue() == 8) goto L99;
    L71:
        if (r17.intValue() == 6) goto L99;
    L67:
        if (r17.intValue() == 7) goto L99;
    L62:
        if (r17.intValue() != 5) goto L64;
    L100:
        r19 = "pic";
        goto L101
    L58:
        if (r17.intValue() == 2) goto L100;
    L54:
        r17 = null;
        goto L55
    L51:
        r16 = null;
        goto L52
    L42:
        if (r10.intValue() != 2) goto L44;
        r11 = "creation_private";
    L37:
        r9 = null;
        goto L38
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
        Object r21 = r18;
    L18:
        Message r22 = (Message) r21;
    L20:
        if (r22 == null) goto L22;
        String r23 = r22.getConversationId();
    L23:
        IConversationRepoService r24 = RepoDispatcherDelegate.b.f();
        if (r23 == null) goto L27;
        r3 = r23;
    L27:
        this.label = 2;
        r4 = IConversationRepoService.a.d(r24, r3, this);
        if (r4 != r1) goto L30;
        return r1;
    L22:
        r23 = null;
        goto L23
    L10:
        ResultKt.throwOnFailure(r18);
        IChatRepoService r25 = RepoDispatcherDelegate.b.e();
        if (r25 == null) goto L19;
        String r26 = this.$messageId;
        if (r26 != null) goto L15;
        r26 = "0";
    L15:
        this.label = 1;
        r21 = r25.E1(r26, this);
        if (r21 != r1) goto L18;
        return r1;
    L19:
        r22 = null;
        goto L20
    }
}
