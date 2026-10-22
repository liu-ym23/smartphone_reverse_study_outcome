package com.larus.bmhome.chat.model.strategy;

import com.larus.asr.b2;
import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.l0;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/audio/bean/AsrResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.model.strategy.ChatRetryStrategy$resendAudioText$2$asrResult$1", f = "ChatRetryStrategy.kt", i = {}, l = {812}, m = "invokeSuspend", n = {}, s = {})
public final class ChatRetryStrategy$resendAudioText$2$asrResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super p68.a>, Object> {
    final /* synthetic */ Message $data;
    final /* synthetic */ boolean $isSocial;
    final /* synthetic */ String $path;
    int label;

    public ChatRetryStrategy$resendAudioText$2$asrResult$1(Message r1, String r2, boolean r3, Continuation<? super ChatRetryStrategy$resendAudioText$2$asrResult$1> r4) {
        this.$data = r1;
        this.$path = r2;
        this.$isSocial = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ChatRetryStrategy$resendAudioText$2$asrResult$1(this.$data, this.$path, this.$isSocial, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super p68.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L25:
        return r15;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        l0 r3 = AudioServiceDelegate.a.T();
        Message r4 = this.$data;
        String r16 = r4.getLocalMessageId();
        if (r16 != null) goto L11;
        String r5 = "";
    L12:
        String r17 = this.$data.getConversationId();
        if (r17 != null) goto L15;
        String r6 = "";
    L16:
        String r7 = this.$path;
        Message r18 = this.$data;
        Regex r2 = com.larus.bmhome.chat.bean.d.a;
        Intrinsics.checkNotNullParameter(r18, "<this>");
        Map r19 = r18.getBusinessExt();
        if (r19 == null) goto L21;
        String r110 = (String) r19.get("biz_audio_duration");
        if (r110 == null) goto L21;
        Long r111 = StringsKt.toLongOrNull(r110);
    L22:
        boolean r9 = this.$isSocial;
        b2 r12 = new b2();
        this.label = 1;
        r15 = r3.a(r4, r5, r6, r7, r111, r9, null, false, r12, this);
        if (r15 != r0) goto L25;
        return r0;
    L21:
        r111 = null;
        goto L22
    L15:
        r6 = r17;
        goto L16
    L11:
        r5 = r16;
        goto L12
    }
}
