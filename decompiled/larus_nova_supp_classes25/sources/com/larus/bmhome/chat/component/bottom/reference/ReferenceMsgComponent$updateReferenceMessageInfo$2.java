package com.larus.bmhome.chat.component.bottom.reference;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.attachment.g1;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.bmhome.chat.model.repo.RepoDispatcher;
import com.larus.bmhome.utils.ReferenceMessage;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.utils.o0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.reference.ReferenceMsgComponent$updateReferenceMessageInfo$2", f = "ReferenceMsgComponent.kt", i = {0}, l = {257}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
public final class ReferenceMsgComponent$updateReferenceMessageInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotModel $bot;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ReferenceMsgComponent this$0;

    public ReferenceMsgComponent$updateReferenceMessageInfo$2(ReferenceMsgComponent r1, BotModel r2, Continuation<? super ReferenceMsgComponent$updateReferenceMessageInfo$2> r3) {
        this.this$0 = r1;
        this.$bot = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ReferenceMsgComponent$updateReferenceMessageInfo$2(this.this$0, this.$bot, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ReferenceMessage r3 = (ReferenceMessage) this.L$1;
        ReferenceMsgComponent r4 = (ReferenceMsgComponent) this.L$0;
        ResultKt.throwOnFailure(r17);
        ReferenceMsgComponent r6 = r4;
        Object r5 = r17;
    L44:
        Message r7 = (Message) r5;
        ReferenceMessage r8 = r3;
    L45:
        final ReferenceMsgComponent r9 = r6;
        List r10 = yc9.d0.a(r7);
        int r11 = ReferenceMsgComponent.N;
        g1 r12 = r9.f70();
        if (r12 == null) goto L51;
        String r13 = r12.uM();
        if (r13 == null) goto L51;
        String r14 = r13;
    L52:
        ReferenceMsgComponent.E3(r9, r8, new g0(r9), false, r10, false, r14, null, false, null, false, 960);
    L54:
        return Unit.INSTANCE;
    L51:
        r14 = "";
        goto L52
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        ReferenceMsgComponent r15 = this.this$0;
        int r16 = ReferenceMsgComponent.N;
        r8 = r15.C3().b;
        r7 = null;
        if (r8 == null) goto L11;
        String r18 = r8.getSenderName();
    L13:
        if (o0.d(r18) == false) goto L37;
        BotModel r19 = this.$bot;
        if (r19 == null) goto L17;
        String r20 = r19.getName();
    L19:
        if (o0.d(r20) == false) goto L37;
        if (r8 == null) goto L22;
        String r21 = r8.getSenderName();
    L23:
        BotModel r22 = this.$bot;
        if (r22 == null) goto L26;
        String r23 = r22.getName();
    L28:
        if (Intrinsics.areEqual(r21, r23) == true) goto L37;
        if (r8 == null) goto L36;
        BotModel r24 = this.$bot;
        if (r24 == null) goto L34;
        String r25 = r24.getName();
        if (r25 == null) goto L34;
    L35:
        r8 = ReferenceMessage.copy$default(r8, null, null, r25, false, false, 0, null, null, 251, null);
    L34:
        r25 = "";
        goto L35
    L36:
        r8 = null;
        goto L37
    L26:
        r23 = null;
        goto L28
    L22:
        r21 = null;
        goto L23
    L17:
        r20 = null;
    L37:
        if (r8 == null) goto L54;
        r6 = this.this$0;
        String r26 = r8.getMessageId();
        if (r26 == null) goto L45;
        RepoDispatcher.a.getClass();
        ChatRepo r27 = RepoDispatcher.d;
        this.L$0 = r6;
        this.L$1 = r8;
        this.label = 1;
        r5 = r27.E1(r26, this);
        if (r5 != r1) goto L43;
        return r1;
    L43:
        r3 = r8;
        goto L44
    L11:
        r18 = null;
        goto L13
    }
}
