package com.larus.bmhome.chat.model.strategy;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.ChatRepo;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.ReferenceInfo;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatRetryStrategy$resendAudioText$2", f = "ChatRetryStrategy.kt", i = {1, 3}, l = {811, 842, 852, 854}, m = "invokeSuspend", n = {"req", "asrResult"}, s = {"L$0", "L$0"})
public final class ChatRetryStrategy$resendAudioText$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ChatPageContext $chatPageContext;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ Message $data;
    final /* synthetic */ String $path;
    Object L$0;
    int label;
    final /* synthetic */ ChatRetryStrategy this$0;

    public ChatRetryStrategy$resendAudioText$2(wc9.e r1, Message r2, ChatPageContext r3, ChatRetryStrategy r4, String r5, Continuation<? super ChatRetryStrategy$resendAudioText$2> r6) {
        this.$conversation = r1;
        this.$data = r2;
        this.$chatPageContext = r3;
        this.this$0 = r4;
        this.$path = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatRetryStrategy$resendAudioText$2(this.$conversation, this.$data, this.$chatPageContext, this.this$0, this.$path, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r23) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L14;
        if (r0 == 1) goto L13;
        if (r0 == 2) goto L12;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        p68.a r1 = (p68.a) this.L$0;
        ResultKt.throwOnFailure(r23);
        Object r2 = r23;
    L69:
        p68.a.a r3 = (p68.a.a) r1;
        ((g0) r2).a(this.$data, r3.b, r3.c);
        Unit r4 = Unit.INSTANCE;
    L71:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r23);
        goto L71
    L12:
        ai8.b r5 = (ai8.b) this.L$0;
        ResultKt.throwOnFailure(r23);
        ai8.b r6 = r5;
        Object r8 = r23;
    L51:
        ((g0) r8).b(this.$conversation, r6, null, true);
        goto L71
    L13:
        ResultKt.throwOnFailure(r23);
        Object r9 = r23;
    L17:
        r1 = (p68.a) r9;
        String r10 = "";
        if ((r1 instanceof p68.a.b) == false) goto L54;
        FLogger r11 = FLogger.a;
        StringBuilder r12 = new StringBuilder("retry: LoadAudio #");
        p68.a.b r13 = (p68.a.b) r1;
        r12.append(r13.a);
        r12.append(' ');
        if (r13.b.length() <= 0) goto L22;
        boolean r14 = true;
    L23:
        r12.append(r14);
        r11.i("ChatRetryStrategy", r12.toString());
        if (r13.b.length() <= 0) goto L26;
        boolean r15 = true;
    L27:
        if (r15 == false) goto L52;
        Map r16 = this.$data.getExt();
        if (r16 == null) goto L32;
        Map r17 = MapsKt.toMutableMap(r16);
        if (r17 == null) goto L32;
    L33:
        r17.remove("asr_log_id");
        String r18 = r13.e;
        if (r18 != null) goto L36;
    L41:
        StringBuilder r19 = new StringBuilder("retry: sendAudioText #");
        r19.append(r13.a);
        r19.append(", asrLogId=");
        String r110 = r13.e;
        if (r110 == null) goto L45;
        r10 = r110;
    L45:
        r19.append(r10);
        r19.append(", hasAsrLogId=");
        r19.append(r17.containsKey("asr_log_id"));
        r11.i("ChatRetryStrategy", r19.toString());
        String r111 = r13.b;
        String r112 = this.$data.getLocalMessageId();
        ReferenceInfo r113 = com.larus.bmhome.chat.bean.d.b1(this.$data);
        Map r20 = this.$data.getBusinessExt();
        if (r20 != null) goto L48;
        r20 = new LinkedHashMap();
    L48:
        r6 = new ai8.b(r111, r112, r113, r17, com.larus.utils.h.c(r20, new Pair[]{TuplesKt.to("send_loading", ic8.j.f(this.$data))}), true, this.$chatPageContext, null, 128);
        ChatRetryStrategy r21 = this.this$0;
        wc9.e r22 = this.$conversation;
        this.L$0 = r6;
        this.label = 2;
        int r24 = ChatRetryStrategy.e;
        r8 = r21.h(r22, this);
        if (r8 != r7) goto L51;
        return r7;
    L36:
        if ((!StringsKt.isBlank(r18)) == true) goto L39;
        r18 = null;
    L39:
        if (r18 == null) goto L41;
        r17.put("asr_log_id", r18);
    L32:
        r17 = new LinkedHashMap();
        goto L33
    L52:
        ChatRetryStrategy r25 = this.this$0;
        String r26 = this.$conversation.a;
        List r27 = CollectionsKt.listOf(this.$data);
        int r28 = ChatRetryStrategy.e;
        r25.getClass();
        ChatRetryStrategy.f(r26, r27);
        t0.e(new i());
        goto L71
    L26:
        r15 = false;
        goto L27
    L22:
        r14 = false;
        goto L23
    L54:
        if ((r1 instanceof p68.a.a) == false) goto L71;
        FLogger r29 = FLogger.a;
        StringBuilder r30 = new StringBuilder("retry: FailAudio #");
        p68.a.a r31 = (p68.a.a) r1;
        r30.append(r31.a);
        r29.w("ChatRetryStrategy", r30.toString());
        Integer r32 = r31.d;
        if (r32 != null) goto L59;
    L66:
        ChatRetryStrategy r33 = this.this$0;
        wc9.e r34 = this.$conversation;
        this.L$0 = r1;
        this.label = 4;
        int r35 = ChatRetryStrategy.e;
        r2 = r33.h(r34, this);
        if (r2 != r7) goto L69;
        return r7;
    L59:
        if (r32.intValue() != (-1001)) goto L66;
        ChatRepo r36 = this.this$0.a;
        String r37 = this.$data.getConversationId();
        if (r37 != null) goto L63;
        r37 = "";
    L63:
        List r38 = CollectionsKt.listOf(this.$data);
        this.label = 3;
        if (r36.C1(r37, r38, true, false, this) != r7) goto L71;
        return r7;
    L14:
        ResultKt.throwOnFailure(r23);
        boolean r39 = ve8.c.a(this.$conversation);
        MainCoroutineDispatcher r40 = Dispatchers.getMain().getImmediate();
        ChatRetryStrategy$resendAudioText$2$asrResult$1 r41 = new ChatRetryStrategy$resendAudioText$2$asrResult$1(this.$data, this.$path, r39, null);
        this.label = 1;
        r9 = BuildersKt.withContext(r40, r41, this);
        if (r9 != r7) goto L17;
        return r7;
    }
}
