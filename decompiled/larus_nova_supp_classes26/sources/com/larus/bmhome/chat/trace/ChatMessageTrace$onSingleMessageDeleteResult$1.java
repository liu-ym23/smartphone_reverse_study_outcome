package com.larus.bmhome.chat.trace;

import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.z1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatMessageTrace$onSingleMessageDeleteResult$1", f = "ChatMessageTrace.kt", i = {0, 1}, l = {162, 163, 164}, m = "invokeSuspend", n = {"isTTSReading", "isTTSReading"}, s = {"Z$0", "Z$0"})
final class ChatMessageTrace$onSingleMessageDeleteResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Integer $botType;
    final /* synthetic */ Message $data;
    final /* synthetic */ String $errMsg;
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ JSONObject $traceInfo;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    boolean Z$0;
    int label;

    public ChatMessageTrace$onSingleMessageDeleteResult$1(Message r1, JSONObject r2, boolean r3, String r4, Integer r5, String r6, Continuation<? super ChatMessageTrace$onSingleMessageDeleteResult$1> r7) {
        this.$data = r1;
        this.$traceInfo = r2;
        this.$isSuccess = r3;
        this.$botId = r4;
        this.$botType = r5;
        this.$errMsg = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatMessageTrace$onSingleMessageDeleteResult$1(this.$data, this.$traceInfo, this.$isSuccess, this.$botId, this.$botType, this.$errMsg, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r36) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        long r3 = this.J$0;
        String r4 = (String) this.L$8;
        Long r5 = (Long) this.L$7;
        String r6 = (String) this.L$6;
        String r7 = (String) this.L$5;
        String r8 = (String) this.L$4;
        String r9 = (String) this.L$3;
        String r10 = (String) this.L$2;
        String r11 = (String) this.L$1;
        JSONObject r12 = (JSONObject) this.L$0;
        ResultKt.throwOnFailure(r36);
        Long r13 = r5;
        JSONObject r14 = r12;
        String r15 = r10;
        String r16 = r8;
        String r17 = r6;
        long r18 = r3;
        Object r19 = r36;
    L54:
        SpeakerVoice r20 = (SpeakerVoice) r19;
        if (r20 == null) goto L57;
        String r29 = r20.getName();
        Long r27 = r13;
        String r28 = r4;
        String r25 = r7;
        String r26 = r17;
        String r23 = r9;
        String r24 = r16;
        String r110 = r11;
        String r21 = r15;
        JSONObject r31 = r14;
    L58:
        Map r30 = com.larus.bmhome.chat.bean.d.l(this.$data);
        z1.c(this.$botId, this.$botType, "long_press_answer", r110, this.$errMsg, r21, Boxing.boxLong(r18), r23, r24, r25, r26, r27, r28, r29, r30, r31, 65536);
        return Unit.INSTANCE;
    L57:
        r27 = r13;
        r28 = r4;
        r25 = r7;
        r26 = r17;
        r23 = r9;
        r24 = r16;
        r110 = r11;
        r21 = r15;
        r31 = r14;
        r29 = null;
        goto L58
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r18 = this.J$0;
        boolean r22 = this.Z$0;
        Long r32 = (Long) this.L$7;
        r17 = (String) this.L$6;
        String r33 = (String) this.L$5;
        r16 = (String) this.L$4;
        String r111 = (String) this.L$3;
        r15 = (String) this.L$2;
        String r112 = (String) this.L$1;
        r14 = (JSONObject) this.L$0;
        ResultKt.throwOnFailure(r36);
        Object r34 = r36;
    L45:
        SpeakerVoice r35 = (SpeakerVoice) r34;
        if (r35 == null) goto L48;
        r4 = r35.getStyleId();
        r13 = r32;
        r7 = r33;
        r9 = r111;
        r11 = r112;
    L50:
        if (r22 == false) goto L57;
        ChatMessageTrace r37 = ChatMessageTrace.a;
        String r113 = this.$botId;
        this.L$0 = r14;
        this.L$1 = r11;
        this.L$2 = r15;
        this.L$3 = r9;
        this.L$4 = r16;
        this.L$5 = r7;
        this.L$6 = r17;
        this.L$7 = r13;
        this.L$8 = r4;
        this.J$0 = r18;
        this.label = 3;
        r19 = ChatMessageTrace.b(r37, r113, this);
        if (r19 != r1) goto L54;
        return r1;
    L48:
        r13 = r32;
        long r38 = r18;
    L49:
        r18 = r38;
        r7 = r33;
        r9 = r111;
        r11 = r112;
        r4 = null;
        goto L50
    L11:
        r38 = this.J$0;
        r22 = this.Z$0;
        r17 = (String) this.L$6;
        r33 = (String) this.L$5;
        r16 = (String) this.L$4;
        r111 = (String) this.L$3;
        r15 = (String) this.L$2;
        r112 = (String) this.L$1;
        r14 = (JSONObject) this.L$0;
        ResultKt.throwOnFailure(r36);
        Object r39 = r36;
    L32:
        SpeakerVoice r40 = (SpeakerVoice) r39;
        if (r40 == null) goto L35;
        String r41 = r40.getId();
    L36:
        if (r41 != null) goto L38;
        r41 = "";
    L38:
        r13 = StringsKt.toLongOrNull(r41);
    L40:
        if (r22 == false) goto L49;
        ChatMessageTrace r42 = ChatMessageTrace.a;
        String r114 = this.$botId;
        this.L$0 = r14;
        this.L$1 = r112;
        this.L$2 = r15;
        this.L$3 = r111;
        this.L$4 = r16;
        this.L$5 = r33;
        this.L$6 = r17;
        this.L$7 = r13;
        this.Z$0 = r22;
        this.J$0 = r38;
        this.label = 2;
        r34 = ChatMessageTrace.b(r42, r114, this);
        if (r34 != r1) goto L44;
        return r1;
    L44:
        r18 = r38;
        r32 = r13;
        goto L45
    L35:
        r41 = null;
        goto L36
    L12:
        ResultKt.throwOnFailure(r36);
        int r43 = com.larus.bmhome.chat.model.a0.a;
        r22 = com.larus.bmhome.chat.model.a0.b(this.$data);
        r14 = yc9.c0.c(this.$data, this.$traceInfo);
        r112 = this.$data.getConversationId();
        String r44 = "1";
        if (com.larus.bmhome.chat.bean.d.z0(this.$data) == false) goto L15;
        r15 = "1";
    L16:
        if (r22 == false) goto L18;
        long r115 = 1;
    L20:
        if (this.$isSuccess == true) goto L23;
        r44 = TriggerSendLoading.NO_LOADING;
    L23:
        String r45 = this.$data.getMessageId();
        r33 = com.larus.bmhome.chat.bean.d.B(this.$data);
        if (com.larus.bmhome.chat.bean.d.G0(this.$data) == false) goto L26;
        String r116 = "user";
    L27:
        if (r22 == false) goto L39;
        ChatMessageTrace r46 = ChatMessageTrace.a;
        String r47 = this.$botId;
        this.L$0 = r14;
        this.L$1 = r112;
        this.L$2 = r15;
        this.L$3 = r44;
        this.L$4 = r45;
        this.L$5 = r33;
        this.L$6 = r116;
        this.Z$0 = r22;
        this.J$0 = r115;
        this.label = 1;
        r39 = ChatMessageTrace.b(r46, r47, this);
        if (r39 != r1) goto L31;
        return r1;
    L31:
        long r310 = r115;
        r16 = r45;
        r111 = r44;
        r38 = r310;
        r17 = r116;
        goto L32
    L39:
        r13 = null;
        long r311 = r115;
        r16 = r45;
        r111 = r44;
        r38 = r311;
        r17 = r116;
        goto L40
    L26:
        r116 = "bot";
        goto L27
    L18:
        r115 = 0;
        goto L20
    L15:
        r15 = TriggerSendLoading.NO_LOADING;
        goto L16
    }
}
