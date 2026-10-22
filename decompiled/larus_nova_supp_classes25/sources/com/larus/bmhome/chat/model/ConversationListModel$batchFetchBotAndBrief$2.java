package com.larus.bmhome.chat.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
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
@DebugMetadata(c = "com.larus.bmhome.chat.model.ConversationListModel$batchFetchBotAndBrief$2", f = "ConversationListModel.kt", i = {0, 0, 0, 0, 1, 1}, l = {988, 992}, m = "invokeSuspend", n = {"chunkSource", "index", "start", "end", "index", "end"}, s = {"L$3", "I$2", "I$3", "I$4", "I$2", "I$3"})
public final class ConversationListModel$batchFetchBotAndBrief$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $convSize;
    final /* synthetic */ List<wc9.e> $conversationList;
    final /* synthetic */ int $firstLoadSize;
    final /* synthetic */ List<Message> $messageBodyList;
    final /* synthetic */ String $source;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    public ConversationListModel$batchFetchBotAndBrief$2(String r1, int r2, int r3, List<wc9.e> r4, List<Message> r5, Continuation<? super ConversationListModel$batchFetchBotAndBrief$2> r6) {
        this.$source = r1;
        this.$convSize = r2;
        this.$firstLoadSize = r3;
        this.$conversationList = r4;
        this.$messageBodyList = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        ConversationListModel$batchFetchBotAndBrief$2 r7 = new ConversationListModel$batchFetchBotAndBrief$2(this.$source, this.$convSize, this.$firstLoadSize, this.$conversationList, this.$messageBodyList, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00f6 -> B:26:0x00fa). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L10;
        int r3 = this.I$3;
        int r5 = this.I$2;
        int r6 = this.I$1;
        int r7 = this.I$0;
        List<Message> r8 = (List) this.L$2;
        List<wc9.e> r9 = (List) this.L$1;
        String r10 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L34
        ConversationListModel$batchFetchBotAndBrief$2 r4 = this;
        int r11 = r5;
        int r12 = r6;
    L26:
        if (r3 < r12) goto L29;
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L30
    L37:
        String r13 = r4.$source;
        Throwable r14 = Result.exceptionOrNull-impl(r1);
        if (r14 == null) goto L40;
        FLogger.a.i("ConversationListModel", "batchFetchBotAndBrief source=" + r13 + ", handled conversations exception: " + r14);
    L40:
        FLogger.a.i("ConversationListModel", "batchFetchBotAndBrief source=" + r4.$source + ", handled all conversations size: " + r4.$convSize);
        return Unit.INSTANCE;
    L30:
        th = th;
        ConversationListModel$batchFetchBotAndBrief$2 r15 = r4;
    L36:
        Result.Companion r16 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        r4 = r15;
        goto L37
    L29:
        int r17 = r11 + 1;
        String r19 = r10;
        r15 = r4;
        List<wc9.e> r110 = r9;
        int r20 = r17;
        int r21 = r7;
        List<wc9.e> r22 = r110;
    L17:
        int r111 = (r20 * 50) + r21;
        int r112 = Math.min(r111 + 50, r12);     // Catch: Throwable -> L32
        ConversationListModel r113 = ConversationListModel.a;     // Catch: Throwable -> L32
        r113.getClass();     // Catch: Throwable -> L32
        String r114 = ConversationListModel.k(r19, "chunk" + r111 + '_' + r112);     // Catch: Throwable -> L32
        List<wc9.e> r115 = r22.subList(r111, r112);     // Catch: Throwable -> L32
        String r23 = ConversationListModel.k(r114, "findConversationBotsNew");     // Catch: Throwable -> L32
        r15.L$0 = r19;     // Catch: Throwable -> L32
        r15.L$1 = r22;     // Catch: Throwable -> L32
        r15.L$2 = r8;     // Catch: Throwable -> L32
        r15.L$3 = r114;     // Catch: Throwable -> L32
        r15.I$0 = r21;     // Catch: Throwable -> L32
        r15.I$1 = r12;     // Catch: Throwable -> L32
        r15.I$2 = r20;     // Catch: Throwable -> L32
        r15.I$3 = r111;     // Catch: Throwable -> L32
        r15.I$4 = r112;     // Catch: Throwable -> L32
        r15.label = 1;     // Catch: Throwable -> L32
        if (r113.p(r115, r23, r15) != r0) goto L21;
        return r0;
    L21:
        r4 = r15;
        List<Message> r116 = r8;
        int r24 = r21;
        r3 = r112;
        String r117 = r19;
        r11 = r20;
        r9 = r22;
        int r25 = r12;
        int r26 = r111;
    L42:
        ConversationListModel r118 = ConversationListModel.a;     // Catch: Throwable -> L30
        List<wc9.e> r119 = r9.subList(r26, r3);     // Catch: Throwable -> L30
        List<Message> r27 = r116.subList(r26, r3);     // Catch: Throwable -> L30
        r118.getClass();     // Catch: Throwable -> L30
        String r120 = ConversationListModel.k(r114, "handleConversationMessageNew");     // Catch: Throwable -> L30
        r4.L$0 = r117;     // Catch: Throwable -> L30
        r4.L$1 = r9;     // Catch: Throwable -> L30
        r4.L$2 = r116;     // Catch: Throwable -> L30
        r4.L$3 = null;     // Catch: Throwable -> L30
        r4.I$0 = r24;     // Catch: Throwable -> L30
        r4.I$1 = r25;     // Catch: Throwable -> L30
        r4.I$2 = r11;     // Catch: Throwable -> L30
        r4.I$3 = r3;     // Catch: Throwable -> L30
        r4.label = 2;     // Catch: Throwable -> L30
        if (r118.u(r119, r27, r120, r4) != r0) goto L25;
        return r0;
    L25:
        r12 = r25;
        r7 = r24;
        r8 = r116;
        r10 = r117;
    L32:
        th = th;
        goto L36
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r3 = this.I$4;
        r26 = this.I$3;
        r11 = this.I$2;
        r25 = this.I$1;
        r24 = this.I$0;
        String r28 = (String) this.L$3;
        r116 = (List) this.L$2;
        List<wc9.e> r121 = (List) this.L$1;
        r117 = (String) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L34
        r4 = this;
        r114 = r28;
        r9 = r121;
        goto L42
    L14:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r29 = (CoroutineScope) this.L$0;
        r21 = this.$firstLoadSize;
        r12 = this.$convSize;
        r19 = this.$source;
        r22 = this.$conversationList;
        r8 = this.$messageBodyList;
        Result.Companion r30 = Result.Companion;     // Catch: Throwable -> L34
        r20 = 0;
        r15 = this;
    L34:
        th = th;
        r15 = this;
        goto L36
    }
}
