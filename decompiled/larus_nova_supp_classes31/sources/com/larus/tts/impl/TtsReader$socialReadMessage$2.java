package com.larus.tts.impl;

import com.larus.audio.bean.CacheConfig;
import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.utils.o0;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.TtsReader$socialReadMessage$2", f = "TtsReader.kt", i = {}, l = {271}, m = "invokeSuspend", n = {}, s = {})
final class TtsReader$socialReadMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $autoTts;
    final /* synthetic */ String $chatType;
    final /* synthetic */ Message $message;
    final /* synthetic */ SpeakerVoice $speakerVoice;
    final /* synthetic */ String $startReadMessageReason;
    int label;
    final /* synthetic */ TtsReader this$0;

    public TtsReader$socialReadMessage$2(TtsReader r1, Message r2, SpeakerVoice r3, boolean r4, String r5, String r6, Continuation<? super TtsReader$socialReadMessage$2> r7) {
        this.this$0 = r1;
        this.$message = r2;
        this.$speakerVoice = r3;
        this.$autoTts = r4;
        this.$startReadMessageReason = r5;
        this.$chatType = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new TtsReader$socialReadMessage$2(this.this$0, this.$message, this.$speakerVoice, this.$autoTts, this.$startReadMessageReason, this.$chatType, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r21);
        return r21;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        this.this$0.i6("perform socialReadMessage", false);
        TextContent r1 = (TextContent) d.t(this.$message);
        if (r1 == null) goto L14;
        String r2 = r1.text;
        if (r2 == null) goto L14;
        String r4 = r2;
    L15:
        SpeakerVoice r3 = this.$speakerVoice;
        if (r3 == null) goto L18;
        String r5 = r3.getId();
    L19:
        if (r5 != null) goto L21;
        String r8 = "";
    L22:
        SpeakerVoice r6 = this.$speakerVoice;
        if (r6 == null) goto L28;
        String r7 = r6.getStyleId();
        if (r7 == null) goto L28;
        String r9 = r7;
    L29:
        SpeakerVoice r10 = this.$speakerVoice;
        if (r10 == null) goto L35;
        String r11 = r10.getName();
        if (r11 == null) goto L35;
        String r12 = r11;
    L36:
        SpeakerVoice r13 = this.$speakerVoice;
        if (r13 == null) goto L42;
        String r15 = r13.getAudioMetrics();
        if (r15 == null) goto L42;
        String r16 = r15;
    L43:
        p68.i r17 = new p68.i(r9, r12, r8, null, r16, 8);
        String r18 = m58.x.a;
        Intrinsics.checkNotNullParameter("true", "<set-?>");
        m58.x.a = "true";
        TtsReader r19 = this.this$0;
        Message r20 = this.$message;
        boolean r22 = !this.$autoTts;
        if (d.z0(r20) == true) goto L46;
    L48:
        boolean r23 = false;
    L49:
        String r24 = this.$startReadMessageReason;
        CacheConfig r25 = TtsReader.a(this.this$0, this.$message);
        String r110 = this.$chatType;
        this.label = 1;
        Object r26 = TtsReader.i(r19, r20, r4, r22, r23, r17, r24, r25, false, null, null, r110, null, null, this, 14080);
        if (r26 != r14) goto L53;
        return r14;
    L53:
        return r26;
    L46:
        if (o0.d(this.$message.getConversationId()) == false) goto L48;
        r23 = true;
    L42:
        r16 = "";
    L35:
        r12 = "";
    L28:
        r9 = "";
        goto L29
    L21:
        r8 = r5;
        goto L22
    L18:
        r5 = null;
    L14:
        r4 = "";
        goto L15
    }
}
