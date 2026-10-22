package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.callback.IIMCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$updateNestedFileMsg$1", f = "ChatSender.kt", i = {}, l = {1354, 1355}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSender$updateNestedFileMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $bizExt;
    final /* synthetic */ IIMCallback<Message> $callback;
    final /* synthetic */ NestedFileContent $content;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ String $localMessageId;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$updateNestedFileMsg$1(ChatSender r1, String r2, String r3, NestedFileContent r4, Map<String, String> r5, IIMCallback<Message> r6, Continuation<? super ChatSender$updateNestedFileMsg$1> r7) {
        this.this$0 = r1;
        this.$cvsId = r2;
        this.$localMessageId = r3;
        this.$content = r4;
        this.$bizExt = r5;
        this.$callback = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatSender$updateNestedFileMsg$1(this.this$0, this.$cvsId, this.$localMessageId, this.$content, this.$bizExt, this.$callback, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        IIMCallback<Message> r2 = (IIMCallback) this.L$3;
        Map<String, String> r3 = (Map) this.L$2;
        NestedFileContent r4 = (NestedFileContent) this.L$1;
        String r5 = (String) this.L$0;
        ResultKt.throwOnFailure(r8);
    L19:
        ((com.larus.bmhome.chat.model.strategy.g0) r8).f(r5, r4, r3, r2);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        wc9.e r9 = (wc9.e) r8;
        if (r9 == null) goto L21;
        ChatSender r6 = this.this$0;
        r5 = this.$localMessageId;
        NestedFileContent r7 = this.$content;
        Map<String, String> r10 = this.$bizExt;
        IIMCallback<Message> r11 = this.$callback;
        this.L$0 = r5;
        this.L$1 = r7;
        this.L$2 = r10;
        this.L$3 = r11;
        this.label = 2;
        int r12 = ChatSender.j;
        r8 = r6.C(r9, this);
        if (r8 != r0) goto L18;
        return r0;
    L18:
        r4 = r7;
        r3 = r10;
        r2 = r11;
        goto L19
    L10:
        ResultKt.throwOnFailure(r8);
        ChatSender r13 = this.this$0;
        String r14 = this.$cvsId;
        this.label = 1;
        r8 = ChatSender.y(r13, r14, this);
        if (r8 != r0) goto L13;
        return r0;
    }
}
