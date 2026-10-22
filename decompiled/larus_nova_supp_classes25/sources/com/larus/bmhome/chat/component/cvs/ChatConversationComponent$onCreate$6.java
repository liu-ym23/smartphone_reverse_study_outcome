package com.larus.bmhome.chat.component.cvs;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.conversation.ConversationDeleteMode;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.im.internal.delegate.y0;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/im/bean/conversation/Conversation;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.cvs.ChatConversationComponent$onCreate$6", f = "ChatConversationComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatConversationComponent$onCreate$6 extends SuspendLambda implements Function2<e, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ChatConversationComponent this$0;

    public static final class a implements IIMCallback<Boolean> {
        public a() {
        }

        public final boolean mustInMain() {
            return !y0.a();
        }

        public final void onFailure(IIMError r3) {
            Intrinsics.checkNotNullParameter(r3, "error");
            Intrinsics.checkNotNullParameter(r3, "error");
            FLogger.a.i("ChatConversationComponent", "conversation RealDelete onFailure");
        }

        public final void onSuccess(Object r3) {
            ((Boolean) r3).booleanValue();
            FLogger.a.i("ChatConversationComponent", "conversation RealDelete onSuccess");
        }
    }

    public ChatConversationComponent$onCreate$6(ChatConversationComponent r1, Continuation<? super ChatConversationComponent$onCreate$6> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ChatConversationComponent$onCreate$6 r0 = new ChatConversationComponent$onCreate$6(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((e) r1, (Continuation) r2);
    }

    public final Object invoke(e r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L39;
        ResultKt.throwOnFailure(r6);
        e r7 = (e) this.L$0;
        boolean r0 = false;
        if (r7 == null) goto L12;
        Integer r8 = r7.t;
        if (r8 == null) goto L12;
        if (r8.intValue() != 2) goto L12;
        boolean r9 = true;
    L13:
        if (r9 == false) goto L37;
        FLogger.a.i("ChatConversationComponent", "conversation Status:DELETED performBack");
        ChatConversationComponent r10 = this.this$0;
        int r2 = ChatConversationComponent.r;
        de8.c r11 = r10.f1();
        String r3 = "";
        if (r11 == null) goto L18;
        String r12 = r11.h();
        if (r12 == null) goto L18;
    L19:
        de8.c r4 = this.this$0.f1();
        if (r4 == null) goto L26;
        String r5 = r4.f();
        if (r5 == null) goto L26;
        r3 = r5;
    L26:
        if (r12.length() <= 0) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == true) goto L31;
    L35:
        this.this$0.N2(true);
        goto L37
    L31:
        if (r3.length() <= 0) goto L33;
        r0 = true;
    L33:
        if (r0 == false) goto L35;
        com.larus.im.d.d().deleteConversation(r12, ConversationDeleteMode.DeleteMode_RealDelete, r3, new a());
        goto L35
    L28:
        r13 = false;
    L18:
        r12 = "";
    L37:
        return Unit.INSTANCE;
    L12:
        r9 = false;
        goto L13
    L39:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
