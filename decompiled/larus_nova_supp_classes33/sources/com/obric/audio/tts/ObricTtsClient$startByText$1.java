package com.obric.audio.tts;

import com.larus.utils.t0;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.tts.ObricTtsClient$startByText$1", f = "ObricTtsClient.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
final class ObricTtsClient$startByText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $allowDuringDora;
    final /* synthetic */ String $conversationId;
    final /* synthetic */ String $messageId;
    final /* synthetic */ long $requestId;
    final /* synthetic */ String $ttsText;
    int label;

    public ObricTtsClient$startByText$1(long r1, String r3, String r4, String r5, boolean r6, Continuation<? super ObricTtsClient$startByText$1> r7) {
        this.$requestId = r1;
        this.$ttsText = r3;
        this.$conversationId = r4;
        this.$messageId = r5;
        this.$allowDuringDora = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ObricTtsClient$startByText$1(this.$requestId, this.$ttsText, this.$conversationId, this.$messageId, this.$allowDuringDora, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        final f.a r6 = (f.a) r9;
        if (r6 == null) goto L14;
        long r2 = this.$requestId;
        AtomicLong r10 = f.c;
        if (r2 == r10.get()) goto L19;
        int r3 = c68.b.a;
        c68.b.d("ObricTtsClient", "[OBRIC_TTS] resolveMainBotVoice skip stale requestId=" + this.$requestId + " latestRequestId=" + r10.get());
        return Unit.INSTANCE;
    L19:
        final String r4 = this.$ttsText;
        final String r5 = this.$conversationId;
        final String r7 = this.$messageId;
        final long r8 = this.$requestId;
        final boolean r11 = this.$allowDuringDora;
        t0.e(new l(r4, r5, r7, r8, r6, r11));
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        f r12 = f.a;
        long r13 = this.$requestId;
        this.label = 1;
        r9 = f.b(r12, r13, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
