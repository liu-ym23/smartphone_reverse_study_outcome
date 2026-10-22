package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$prepareNestedFileMsg$1", f = "ChatSender.kt", i = {0, 1, 1}, l = {1261, 1262}, m = "invokeSuspend", n = {"strategy", "strategy", "cvs"}, s = {"L$0", "L$0", "L$2"})
final class ChatSender$prepareNestedFileMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ NestedFileContent $content;
    final /* synthetic */ String $cvsId;
    final /* synthetic */ Function1<Message, Unit> $prepareResult;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$prepareNestedFileMsg$1(ChatSender r1, NestedFileContent r2, ChatPageContext r3, String r4, Function1<? super Message, Unit> r5, Continuation<? super ChatSender$prepareNestedFileMsg$1> r6) {
        this.this$0 = r1;
        this.$content = r2;
        this.$chatPageContext = r3;
        this.$cvsId = r4;
        this.$prepareResult = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatSender$prepareNestedFileMsg$1(this.this$0, this.$content, this.$chatPageContext, this.$cvsId, this.$prepareResult, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        wc9.e r3 = (wc9.e) this.L$2;
        Function1<Message, Unit> r4 = (Function1) this.L$1;
        ai8.f r5 = (ai8.f) this.L$0;
        ResultKt.throwOnFailure(r20);
        Function1<Message, Unit> r10 = r4;
        ai8.f r7 = r5;
        Object r6 = r20;
    L22:
        com.larus.bmhome.chat.model.strategy.g0.a.b((com.larus.bmhome.chat.model.strategy.g0) r6, r3.a, 0, r7, false, r3.v, r10, 10);
    L24:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ai8.f r8 = (ai8.f) this.L$0;
        ResultKt.throwOnFailure(r20);
        ai8.f r9 = r8;
        Object r11 = r20;
    L16:
        wc9.e r12 = (wc9.e) r11;
        if (r12 == null) goto L24;
        ChatSender r13 = this.this$0;
        Function1<Message, Unit> r14 = this.$prepareResult;
        this.L$0 = r9;
        this.L$1 = r14;
        this.L$2 = r12;
        this.label = 2;
        int r15 = ChatSender.j;
        r6 = r13.C(r12, this);
        if (r6 != r1) goto L21;
        return r1;
    L21:
        r3 = r12;
        r7 = r9;
        r10 = r14;
        goto L22
    L10:
        ResultKt.throwOnFailure(r20);
        this.this$0.a.d.d.i6("prepareNestedFileMsg", false);
        NestedFileContent r16 = this.$content;
        LinkedHashMap r17 = new LinkedHashMap();
        Map r18 = this.$content.getFileExt();
        if (r18 == null) goto L13;
        r17.putAll(r18);
    L13:
        Unit r19 = Unit.INSTANCE;
        r9 = new ai8.f(r16, null, null, null, r17, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("send_loading", "1")}), false, null, this.$chatPageContext, null, 718);
        ChatSender r21 = this.this$0;
        String r22 = this.$cvsId;
        this.L$0 = r9;
        this.label = 1;
        r11 = ChatSender.y(r21, r22, this);
        if (r11 != r1) goto L16;
        return r1;
    }
}
