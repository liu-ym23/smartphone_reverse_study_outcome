package com.larus.uaigc.spring.component;

import com.larus.common_ui.dialog.l0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
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
@DebugMetadata(c = "com.larus.uaigc.spring.component.SpringMainVenueLynxComponent$showLoadingRunnable$1$1", f = "SpringMainVenueLynxComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SpringMainVenueLynxComponent$showLoadingRunnable$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SpringMainVenueLynxComponent this$0;

    public SpringMainVenueLynxComponent$showLoadingRunnable$1$1(SpringMainVenueLynxComponent r1, Continuation<? super SpringMainVenueLynxComponent$showLoadingRunnable$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SpringMainVenueLynxComponent$showLoadingRunnable$1$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_larus_uaigc_spring_component_SpringMainVenueLynxComponent$showLoadingRunnable$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        SpringMainVenueLynxComponent r3 = this.this$0;
        int r0 = SpringMainVenueLynxComponent.P;
        ((l0) r3.M.getValue()).setCancelable(true);
        INVOKEVIRTUAL_com_larus_uaigc_spring_component_SpringMainVenueLynxComponent$showLoadingRunnable$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show((l0) this.this$0.M.getValue());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
