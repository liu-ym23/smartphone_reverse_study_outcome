package com.larus.bmhome.chat.model.repo;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.picture.LocalTakePictureImpl;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.ReferenceInfo;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Pair;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.repo.ChatSender$prepareTxtAndNestedFileMsg$1", f = "ChatSender.kt", i = {0, 0}, l = {1318}, m = "invokeSuspend", n = {"nestedFileMessageReq", "strategies"}, s = {"L$0", "L$1"})
public final class ChatSender$prepareTxtAndNestedFileMsg$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $bizExtras;
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ NestedFileContent $content;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ Map<String, String> $extras;
    final /* synthetic */ String $nestedFileLocalMsgId;
    final /* synthetic */ Function1<List<Message>, Unit> $prepareResult;
    final /* synthetic */ ReferenceInfo $referenceInfo;
    final /* synthetic */ String $txtContext;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ChatSender this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatSender$prepareTxtAndNestedFileMsg$1(Map<String, String> r1, NestedFileContent r2, String r3, Map<String, String> r4, ChatPageContext r5, String r6, ReferenceInfo r7, ChatSender r8, wc9.e r9, Function1<? super List<Message>, Unit> r10, Continuation<? super ChatSender$prepareTxtAndNestedFileMsg$1> r11) {
        this.$extras = r1;
        this.$content = r2;
        this.$nestedFileLocalMsgId = r3;
        this.$bizExtras = r4;
        this.$chatPageContext = r5;
        this.$txtContext = r6;
        this.$referenceInfo = r7;
        this.this$0 = r8;
        this.$conversation = r9;
        this.$prepareResult = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        return new ChatSender$prepareTxtAndNestedFileMsg$1(this.$extras, this.$content, this.$nestedFileLocalMsgId, this.$bizExtras, this.$chatPageContext, this.$txtContext, this.$referenceInfo, this.this$0, this.$conversation, this.$prepareResult, r14);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        List<? extends ic8.w> r3 = (List) this.L$1;
        ai8.f r4 = (ai8.f) this.L$0;
        ResultKt.throwOnFailure(r25);
        ai8.f r6 = r4;
        Object r5 = r25;
    L25:
        ((com.larus.bmhome.chat.model.strategy.g0) r5).i(this.$conversation.a, 0, r3, this.$prepareResult);
        Pair<String, String> r7 = r6.h();
        LocalTakePictureImpl r8 = this.this$0.g;
        if (r8 == null) goto L29;
        r8.e(r6.a(), CollectionsKt.listOf(r7));
    L29:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r25);
        Map<String, String> r9 = this.$extras;
        String r10 = this.$txtContext;
        wc9.e r11 = this.$conversation;
        if (com.larus.utils.o0.d(r10) == false) goto L12;
        r9.put("collection_id", UUID.randomUUID().toString());
    L12:
        if (r11.i == false) goto L14;
        r9.put("tts", "1");
    L14:
        NestedFileContent r12 = this.$content;
        String r13 = this.$nestedFileLocalMsgId;
        Map r14 = com.larus.utils.h.c(this.$bizExtras, new Pair[0]);
        r14.put("send_loading", "1");
        Unit r15 = Unit.INSTANCE;
        ai8.f r16 = new ai8.f(r12, r13, null, null, r9, r14, false, null, this.$chatPageContext, null, 716);
        List<? extends ic8.w> r17 = CollectionsKt.mutableListOf(new ic8.w[]{r16});
        if (this.$txtContext.length() <= 0) goto L17;
        boolean r18 = true;
    L18:
        if (r18 == false) goto L20;
        Map r19 = com.larus.utils.h.c(this.$bizExtras, new Pair[0]);
        r19.put("send_loading", "1");
        r19.put("is_mock_text", "1");
        List<? extends ic8.w> r20 = r17;
        r20.add(new ai8.h(this.$txtContext, null, null, this.$referenceInfo, r9, r19, false, false, this.$chatPageContext, null, 710));
    L21:
        this.this$0.a.d.d.i6("prepareTxtAndNestedFileMsg", false);
        ChatSender r21 = this.this$0;
        wc9.e r22 = this.$conversation;
        r6 = r16;
        this.L$0 = r6;
        this.L$1 = r20;
        this.label = 1;
        r5 = r21.C(r22, this);
        if (r5 != r1) goto L24;
        return r1;
    L24:
        r3 = r20;
        goto L25
    L20:
        r20 = r17;
        goto L21
    L17:
        r18 = false;
        goto L18
    }
}
