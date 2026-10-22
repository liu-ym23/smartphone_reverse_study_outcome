package com.larus.tts.impl;

import com.larus.audio.bean.CacheConfig;
import com.larus.bmhome.chat.bean.d;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.im.bean.message.Message;
import com.larus.utils.l0;
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
import m99.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.TtsReader$readMessage$2", f = "TtsReader.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
public final class TtsReader$readMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ boolean $autoTts;
    final /* synthetic */ String $chatType;
    final /* synthetic */ Message $data;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ SpeakerVoice $speakerVoice;
    final /* synthetic */ String $startReadMessageReason;
    int label;
    final /* synthetic */ TtsReader this$0;

    public TtsReader$readMessage$2(TtsReader r1, Message r2, SpeakerVoice r3, String r4, boolean r5, CoroutineScope r6, String r7, Continuation<? super TtsReader$readMessage$2> r8) {
        this.this$0 = r1;
        this.$data = r2;
        this.$speakerVoice = r3;
        this.$startReadMessageReason = r4;
        this.$autoTts = r5;
        this.$scope = r6;
        this.$chatType = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new TtsReader$readMessage$2(this.this$0, this.$data, this.$speakerVoice, this.$startReadMessageReason, this.$autoTts, this.$scope, this.$chatType, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r22);
        return r22;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r22);
        this.this$0.i6("perform readMessage", false);
        if (this.$data.getMessageStatusLocal() != 23) goto L11;
        boolean r1 = true;
    L12:
        SpeakerVoice r2 = this.$speakerVoice;
        if (r2 == null) goto L31;
        String r5 = r2.getStyleId();
        if (r5 != null) goto L17;
        String r6 = "";
    L18:
        String r7 = r2.getName();
        if (r7 != null) goto L21;
        String r8 = "";
    L22:
        String r9 = r2.getExtra();
        if (r9 != null) goto L25;
        String r10 = "";
    L26:
        String r3 = r2.getAudioMetrics();
        if (r3 != null) goto L29;
        String r11 = "";
    L30:
        p68.i r12 = new p68.i(r6, r8, null, r10, r11, 4);
    L32:
        String r4 = m58.x.a;
        Intrinsics.checkNotNullParameter("false", "<set-?>");
        m58.x.a = "false";
        TtsReader r13 = this.this$0;
        final Message r15 = this.$data;
        r13.getClass();
        String r16 = (String) l0.a("", new b0(r15));
        if (Intrinsics.areEqual(this.$startReadMessageReason, "click_play") == false) goto L35;
    L38:
        boolean r17 = true;
    L39:
        TtsReader r18 = this.this$0;
        Message r19 = this.$data;
        boolean r20 = !this.$autoTts;
        if (d.z0(r19) == true) goto L42;
    L43:
        if (r1 == false) goto L45;
    L52:
        boolean r21 = true;
    L53:
        String r110 = this.$startReadMessageReason;
        CacheConfig r111 = TtsReader.a(this.this$0, this.$data);
        CoroutineScope r112 = this.$scope;
        String r23 = this.$chatType;
        this.label = 1;
        Object r24 = TtsReader.i(r18, r19, r16, r20, r21, r12, r110, r111, r17, r112, null, r23, null, null, this, 13312);
        if (r24 != r14) goto L57;
        return r14;
    L57:
        return r24;
    L45:
        if (a.f(this.$data) == true) goto L52;
        if (com.larus.im.bean.message.a.d0(this.$data) == true) goto L52;
        if (com.larus.im.bean.message.a.p0(this.$data) == true) goto L52;
        r21 = false;
        goto L53
    L42:
        if (o0.d(this.$data.getConversationId()) == true) goto L52;
    L35:
        if (Intrinsics.areEqual(this.$startReadMessageReason, "long_press_play") == true) goto L38;
        r17 = false;
        goto L39
    L29:
        r11 = r3;
        goto L30
    L25:
        r10 = r9;
        goto L26
    L21:
        r8 = r7;
        goto L22
    L17:
        r6 = r5;
        goto L18
    L31:
        r12 = null;
        goto L32
    L11:
        r1 = false;
        goto L12
    }
}
