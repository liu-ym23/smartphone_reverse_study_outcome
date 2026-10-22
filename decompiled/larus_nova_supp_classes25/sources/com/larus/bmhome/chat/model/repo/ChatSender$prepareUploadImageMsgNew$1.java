package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.im.bean.message.Message;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$prepareUploadImageMsgNew$1", f = "ChatSender.kt", i = {1}, l = {764, 765}, m = "invokeSuspend", n = {"cvs"}, s = {"L$3"})
public final class ChatSender$prepareUploadImageMsgNew$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Function1<Message, Unit> $prepareResult;
    final /* synthetic */ int $status;
    final /* synthetic */ ic8.w $strategy;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$prepareUploadImageMsgNew$1(ChatSender r1, String r2, ic8.w r3, int r4, Function1<? super Message, Unit> r5, Continuation<? super ChatSender$prepareUploadImageMsgNew$1> r6) {
        this.this$0 = r1;
        this.$cvsId = r2;
        this.$strategy = r3;
        this.$status = r4;
        this.$prepareResult = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatSender$prepareUploadImageMsgNew$1(this.this$0, this.$cvsId, this.$strategy, this.$status, this.$prepareResult, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$0;
        wc9.e r3 = (wc9.e) this.L$3;
        Function1<Message, Unit> r4 = (Function1) this.L$2;
        ic8.w r5 = (ic8.w) this.L$1;
        String r6 = (String) this.L$0;
        ResultKt.throwOnFailure(r9);
        Function1<Message, Unit> r7 = r4;
        int r8 = r2;
    L19:
        Integer r10 = r3.v;
        com.larus.bmhome.chat.model.strategy.g0.a.b((com.larus.bmhome.chat.model.strategy.g0) r9, r6, r8, r5, false, r10, r7, 8);
    L20:
        LocalTakePictureImpl r11 = this.this$0.g;
        if (r11 == null) goto L24;
        r11.e(this.$strategy.a(), CollectionsKt.listOf(this.$strategy.h()));
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r9);
    L13:
        r3 = (wc9.e) r9;
        if (r3 == null) goto L20;
        ChatSender r12 = this.this$0;
        r6 = this.$cvsId;
        int r13 = this.$status;
        ic8.w r14 = this.$strategy;
        r7 = this.$prepareResult;
        this.L$0 = r6;
        this.L$1 = r14;
        this.L$2 = r7;
        this.L$3 = r3;
        this.I$0 = r13;
        this.label = 2;
        int r15 = ChatSender.j;
        r9 = r12.C(r3, this);
        if (r9 != r0) goto L18;
        return r0;
    L18:
        r8 = r13;
        r5 = r14;
        goto L19
    L10:
        ResultKt.throwOnFailure(r9);
        this.this$0.a.d.d.i6("prepareUploadImageMsgNew", false);
        ChatSender r16 = this.this$0;
        String r17 = this.$cvsId;
        this.label = 1;
        r9 = ChatSender.y(r16, r17, this);
        if (r9 != r0) goto L13;
        return r0;
    }
}
