package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import java.util.List;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$prepareBatchUploadImageMsgNew$1", f = "ChatSender.kt", i = {}, l = {785, 786}, m = "invokeSuspend", n = {}, s = {})
final class ChatSender$prepareBatchUploadImageMsgNew$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cvsId;
    final /* synthetic */ ic8.w $imageStrategy;
    final /* synthetic */ Function1<List<Message>, Unit> $prepareResult;
    final /* synthetic */ ic8.w $textStrategy;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ChatSender this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatSender$prepareBatchUploadImageMsgNew$1(ChatSender r1, String r2, ic8.w r3, ic8.w r4, Function1<? super List<Message>, Unit> r5, Continuation<? super ChatSender$prepareBatchUploadImageMsgNew$1> r6) {
        this.this$0 = r1;
        this.$cvsId = r2;
        this.$imageStrategy = r3;
        this.$textStrategy = r4;
        this.$prepareResult = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatSender$prepareBatchUploadImageMsgNew$1(this.this$0, this.$cvsId, this.$imageStrategy, this.$textStrategy, this.$prepareResult, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        Function1<List<Message>, Unit> r2 = (Function1) this.L$3;
        ic8.w r3 = (ic8.w) this.L$2;
        ic8.w r5 = (ic8.w) this.L$1;
        String r6 = (String) this.L$0;
        ResultKt.throwOnFailure(r11);
    L19:
        ((com.larus.bmhome.chat.model.strategy.g0) r11).i(r6, 0, CollectionsKt.listOf(new ic8.w[]{r5, r3}), r2);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L13:
        wc9.e r12 = (wc9.e) r11;
        if (r12 == null) goto L21;
        ChatSender r4 = this.this$0;
        r6 = this.$cvsId;
        r5 = this.$imageStrategy;
        ic8.w r7 = this.$textStrategy;
        Function1<List<Message>, Unit> r8 = this.$prepareResult;
        this.L$0 = r6;
        this.L$1 = r5;
        this.L$2 = r7;
        this.L$3 = r8;
        this.label = 2;
        int r9 = ChatSender.j;
        r11 = r4.C(r12, this);
        if (r11 != r0) goto L18;
        return r0;
    L18:
        r3 = r7;
        r2 = r8;
        goto L19
    L10:
        ResultKt.throwOnFailure(r11);
        this.this$0.a.d.d.i6("prepareBatchUploadImageMsgNew", false);
        ChatSender r13 = this.this$0;
        String r10 = this.$cvsId;
        this.label = 1;
        r11 = ChatSender.y(r13, r10, this);
        if (r11 != r0) goto L13;
        return r0;
    }
}
