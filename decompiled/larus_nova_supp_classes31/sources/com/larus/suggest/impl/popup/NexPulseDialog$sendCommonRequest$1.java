package com.larus.suggest.impl.popup;

import com.bytedance.crash.d;
import com.larus.bmhome.chat.bean.PopWindowButton;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.tencent.open.log.TraceLevel;
import dm9.a;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.popup.NexPulseDialog$sendCommonRequest$1", f = "NexPulseDialog.kt", i = {}, l = {434}, m = "invokeSuspend", n = {}, s = {})
final class NexPulseDialog$sendCommonRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PopWindowButton $buttonConfig;
    int label;
    final /* synthetic */ NexPulseDialog this$0;

    public NexPulseDialog$sendCommonRequest$1(NexPulseDialog r1, PopWindowButton r2, Continuation<? super NexPulseDialog$sendCommonRequest$1> r3) {
        this.this$0 = r1;
        this.$buttonConfig = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new NexPulseDialog$sendCommonRequest$1(this.this$0, this.$buttonConfig, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_suggest_impl_popup_NexPulseDialog$sendCommonRequest$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(NexPulseDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L7
    L15:
        NexPulseDialog r2 = this.this$0;     // Catch: Throwable -> L7
        if (NexPulseDialog.T90(r2, (a) r7) == false) goto L18;
        INVOKEVIRTUAL_com_larus_suggest_impl_popup_NexPulseDialog$sendCommonRequest$1_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(this.this$0);     // Catch: Throwable -> L7
    L18:
        this.this$0.v = false;
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r7);
        CoroutineDispatcher r8 = Dispatchers.getIO();     // Catch: Throwable -> L7
        NexPulseDialog$sendCommonRequest$1$result$1 r3 = new NexPulseDialog$sendCommonRequest$1$result$1(this.$buttonConfig, null);     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r7 = BuildersKt.withContext(r8, r3, this);     // Catch: Throwable -> L7
        if (r7 != r0) goto L15;
        return r0;
    L7:
        th = move-exception;
        this.this$0.v = false;
        throw th;
    }
}
