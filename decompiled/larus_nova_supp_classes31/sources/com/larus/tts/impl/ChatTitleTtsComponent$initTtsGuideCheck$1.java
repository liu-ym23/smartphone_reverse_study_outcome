package com.larus.tts.impl;

import android.widget.PopupWindow;
import com.larus.audio.ttsV2.TtsGuideDelegate;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent$initTtsGuideCheck$1", f = "ChatTitleTtsComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatTitleTtsComponent$initTtsGuideCheck$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ChatTitleTtsComponent this$0;

    public ChatTitleTtsComponent$initTtsGuideCheck$1(ChatTitleTtsComponent r1, Continuation<? super ChatTitleTtsComponent$initTtsGuideCheck$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ChatTitleTtsComponent$initTtsGuideCheck$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_tts_impl_ChatTitleTtsComponent$initTtsGuideCheck$1_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(PopupWindow r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.tts.impl.t] */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.larus.tts.impl.u] */
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        TtsGuideDelegate r5 = TtsGuideDelegate.b;
        ?? r0 = new t();
        final ChatTitleTtsComponent r1 = this.this$0;
        r5.b(r0, new u(r1));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
