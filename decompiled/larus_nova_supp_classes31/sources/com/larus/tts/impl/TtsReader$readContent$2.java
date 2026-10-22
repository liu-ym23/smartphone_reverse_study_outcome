package com.larus.tts.impl;

import com.larus.audio.bean.CacheConfig;
import com.larus.im.bean.message.Message;
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
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.TtsReader$readContent$2", f = "TtsReader.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
public final class TtsReader$readContent$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ String $chatType;
    final /* synthetic */ String $content;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ Message $data;
    final /* synthetic */ boolean $hideToast;
    final /* synthetic */ String $startReadMessageReason;
    final /* synthetic */ JSONObject $traceInfo;
    int label;
    final /* synthetic */ TtsReader this$0;

    public TtsReader$readContent$2(TtsReader r1, String r2, Message r3, String r4, boolean r5, String r6, String r7, JSONObject r8, String r9, Continuation<? super TtsReader$readContent$2> r10) {
        this.this$0 = r1;
        this.$startReadMessageReason = r2;
        this.$data = r3;
        this.$content = r4;
        this.$hideToast = r5;
        this.$botId = r6;
        this.$chatType = r7;
        this.$traceInfo = r8;
        this.$conversationId = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new TtsReader$readContent$2(this.this$0, this.$startReadMessageReason, this.$data, this.$content, this.$hideToast, this.$botId, this.$chatType, this.$traceInfo, this.$conversationId, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        Object r14 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L8;
        if (r0 != 1) goto L7;
        ResultKt.throwOnFailure(r20);
        return r20;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r20);
        this.this$0.i6("perform readContent", false);
        String r1 = m58.x.a;
        Intrinsics.checkNotNullParameter("false", "<set-?>");
        m58.x.a = "false";
        if (Intrinsics.areEqual(this.$startReadMessageReason, "click_play") == false) goto L11;
    L14:
        boolean r8 = true;
    L15:
        TtsReader r2 = this.this$0;
        Message r3 = this.$data;
        String r4 = this.$content;
        boolean r5 = !this.$hideToast;
        String r7 = this.$startReadMessageReason;
        CacheConfig r9 = TtsReader.a(r2, r3);
        String r11 = this.$botId;
        String r12 = this.$chatType;
        JSONObject r13 = this.$traceInfo;
        String r10 = this.$conversationId;
        this.label = 1;
        Object r6 = TtsReader.i(r2, r3, r4, r5, true, null, r7, r9, r8, null, r11, r12, r13, r10, this, 512);
        if (r6 != r14) goto L19;
        return r14;
    L19:
        return r6;
    L11:
        if (Intrinsics.areEqual(this.$startReadMessageReason, "long_press_play") == true) goto L14;
        r8 = false;
        goto L15
    }
}
