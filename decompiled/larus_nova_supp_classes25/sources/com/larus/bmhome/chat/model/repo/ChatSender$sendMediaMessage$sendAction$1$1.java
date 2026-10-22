package com.larus.bmhome.chat.model.repo;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import java.util.ArrayList;
import java.util.Iterator;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$sendMediaMessage$sendAction$1$1", f = "ChatSender.kt", i = {}, l = {995, 1002}, m = "invokeSuspend", n = {}, s = {})
public final class ChatSender$sendMediaMessage$sendAction$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $msgId;
    final /* synthetic */ boolean $needInterrupt;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $sendFuncChannel;
    final /* synthetic */ List<ic8.w> $strategies;
    int label;
    final /* synthetic */ ChatSender this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatSender$sendMediaMessage$sendAction$1$1(String r1, String r2, List<? extends ic8.w> r3, ChatSender r4, wc9.e r5, String r6, boolean r7, Continuation<? super ChatSender$sendMediaMessage$sendAction$1$1> r8) {
        this.$msgId = r1;
        this.$scene = r2;
        this.$strategies = r3;
        this.this$0 = r4;
        this.$conversation = r5;
        this.$sendFuncChannel = r6;
        this.$needInterrupt = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new ChatSender$sendMediaMessage$sendAction$1$1(this.$msgId, this.$scene, this.$strategies, this.this$0, this.$conversation, this.$sendFuncChannel, this.$needInterrupt, r11);
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
        ResultKt.throwOnFailure(r11);
    L37:
        com.larus.bmhome.chat.model.strategy.g0.a.d((com.larus.bmhome.chat.model.strategy.g0) r11, this.$conversation, (ic8.w) ListProtector.get(this.$strategies, 0), null, this.$needInterrupt, this.$sendFuncChannel, 4);
    L39:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L31:
        com.larus.bmhome.chat.model.strategy.g0.a.a((com.larus.bmhome.chat.model.strategy.g0) r11, this.$conversation, this.$strategies, this.$sendFuncChannel, this.$needInterrupt, 4);
        goto L39
    L10:
        ResultKt.throwOnFailure(r11);
        ChatControlTrace r12 = ChatControlTrace.b;
        r12.getClass();
        if (ChatControlTrace.A == false) goto L13;
        r12.Ma(this.$msgId, "share_send");
        ChatControlTrace.A = false;
    L27:
        if (this.$strategies.size() <= 1) goto L33;
        ChatSender r13 = this.this$0;
        wc9.e r2 = this.$conversation;
        this.label = 1;
        int r3 = ChatSender.j;
        r11 = r13.C(r2, this);
        if (r11 != r0) goto L31;
        return r0;
    L33:
        if ((!this.$strategies.isEmpty()) == false) goto L39;
        ChatSender r14 = this.this$0;
        wc9.e r4 = this.$conversation;
        this.label = 2;
        int r5 = ChatSender.j;
        r11 = r14.C(r4, this);
        if (r11 != r0) goto L37;
        return r0;
    L13:
        r12.Ma(this.$msgId, this.$scene);
        List<ic8.w> r15 = this.$strategies;
        String r6 = this.$msgId;
        ArrayList r7 = new ArrayList();
        Iterator<T> r16 = r15.iterator();
    L15:
        if (r16.hasNext() == false) goto L19;
        Object r8 = r16.next();
        if (Intrinsics.areEqual(((ic8.w) r8).b(), r6) == true) goto L15;
        r7.add(r8);
        goto L15
    L19:
        String r17 = this.$scene;
        Iterator r9 = r7.iterator();
    L21:
        if (r9.hasNext() == false) goto L27;
        ic8.w r10 = (ic8.w) r9.next();
        ChatControlTrace r18 = ChatControlTrace.b;
        String r19 = r10.b();
        if (r19 != null) goto L25;
        r19 = "";
    L25:
        r18.Ma(r19, r17);
        goto L21
    }
}
