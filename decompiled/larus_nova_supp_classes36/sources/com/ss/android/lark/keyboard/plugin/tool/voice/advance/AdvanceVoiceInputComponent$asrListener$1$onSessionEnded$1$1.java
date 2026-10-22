package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.plugin.tool.voice.advance.AdvanceVoiceInputComponent$asrListener$1$onSessionEnded$1$1", f = "AdvanceVoiceInputComponent.kt", i = {}, l = {202}, m = "invokeSuspend", n = {}, s = {})
final class AdvanceVoiceInputComponent$asrListener$1$onSessionEnded$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.ss.android.lark.audio.voiceinput.c $asrResult;
    int label;
    final /* synthetic */ b this$0;

    public AdvanceVoiceInputComponent$asrListener$1$onSessionEnded$1$1(b r1, com.ss.android.lark.audio.voiceinput.c r2, Continuation<? super AdvanceVoiceInputComponent$asrListener$1$onSessionEnded$1$1> r3) {
        this.this$0 = r1;
        this.$asrResult = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AdvanceVoiceInputComponent$asrListener$1$onSessionEnded$1$1(this.this$0, this.$asrResult, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L9;
        if (r0 != 1) goto L8;
        ResultKt.throwOnFailure(r3);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r3);
        this.this$0.getClass();
        String r4 = this.$asrResult.c;
        boolean r1 = false;
        if (r4 != null) goto L12;
    L14:
        Boxing.boxBoolean(r1);
        this.label = 1;
        throw null;
    L12:
        if (StringsKt.isBlank(r4) == true) goto L14;
        r1 = true;
        goto L14
    }
}
