package com.obric.miniapp.view;

import android.content.DialogInterface;
import android.content.Intent;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.view.MiniAppBaseActivity$showUpdateDialog$2", f = "MiniAppBaseActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiniAppBaseActivity$showUpdateDialog$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppBaseActivity this$0;

    public MiniAppBaseActivity$showUpdateDialog$2(MiniAppBaseActivity r1, Continuation<? super MiniAppBaseActivity$showUpdateDialog$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MiniAppBaseActivity$showUpdateDialog$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public static void INVOKEVIRTUAL_com_obric_miniapp_view_MiniAppBaseActivity$showUpdateDialog$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(com.obric.oui.dialog.alert.f r1) {
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

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r5);
        final Intent r6 = this.this$0.getIntent();
        com.obric.oui.dialog.alert.g r0 = new com.obric.oui.dialog.alert.g(this.this$0);
        r0.p = false;
        String r2 = r0.g.getString(2131911818);
        r0.j = false;
        r0.h = r2;
        r0.i = r0.g.getString(2131911817);
        r0.q = true;
        r0.o = false;
        final MiniAppBaseActivity r3 = this.this$0;
        DialogInterface.OnClickListener r1 = new MiniAppBaseActivity$showUpdateDialog$2$builder$1(r3, r6);
        String r7 = r0.g.getString(2131911805);
        Intrinsics.checkNotNullParameter(r7, "text");
        r0.l = r7;
        r0.m = r1;
        r0.n = null;
        if (this.this$0.isDestroyed() == true) goto L10;
        if (this.this$0.isFinishing() == true) goto L10;
        INVOKEVIRTUAL_com_obric_miniapp_view_MiniAppBaseActivity$showUpdateDialog$2_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r0.a());
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
