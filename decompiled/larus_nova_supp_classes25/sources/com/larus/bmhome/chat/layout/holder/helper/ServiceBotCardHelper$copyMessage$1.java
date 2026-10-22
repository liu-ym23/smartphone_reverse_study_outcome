package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import com.larus.bmhome.chat.ChatFragment;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.message.Message;
import com.larus.platform.spi.IAIChatControlTraceService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.holder.helper.ServiceBotCardHelper$copyMessage$1", f = "ServiceBotCardHelper.kt", i = {}, l = {195}, m = "invokeSuspend", n = {}, s = {})
final class ServiceBotCardHelper$copyMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $content;
    final /* synthetic */ Context $context;
    final /* synthetic */ ChatFragment $fragment;
    final /* synthetic */ Message $message;
    int label;

    public ServiceBotCardHelper$copyMessage$1(Context r1, String r2, Message r3, ChatFragment r4, Continuation<? super ServiceBotCardHelper$copyMessage$1> r5) {
        this.$context = r1;
        this.$content = r2;
        this.$message = r3;
        this.$fragment = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ServiceBotCardHelper$copyMessage$1(this.$context, this.$content, this.$message, this.$fragment, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r19);
    L11:
        ChatControlTrace r5 = ChatControlTrace.b;
        Message r7 = this.$message;
        by7.e r3 = this.$fragment;
        if ((r3 instanceof by7.e) == false) goto L14;
        by7.e r8 = r3;
    L15:
        IAIChatControlTraceService.a.d(r5, "long_press_answer", r7, r8, r3.getChatUniqueKey(), CollectionsKt.emptyList(), null, null, null, ChatDraftItem.TYPE_TEXT, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("bot_type", Boxing.boxInt(4))}), 192);
        t19.s r4 = t19.s.a;
        Context r6 = this.$context;
        r4.getClass();
        t19.s.o(r6, 2131910467, false);
        return Unit.INSTANCE;
    L14:
        r8 = null;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r19);
        MessageCopyHelper r9 = MessageCopyHelper.a;
        Context r10 = this.$context;
        String r11 = this.$content;
        this.label = 1;
        r9.getClass();
        MessageCopyHelper.n(r10, r11, null, "bpea-message-copy");
        if (Unit.INSTANCE != r1) goto L11;
        return r1;
    }
}
