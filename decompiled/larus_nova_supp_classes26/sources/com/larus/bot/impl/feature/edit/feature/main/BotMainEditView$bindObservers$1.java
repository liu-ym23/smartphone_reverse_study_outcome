package com.larus.bot.impl.feature.edit.feature.main;

import android.os.Handler;
import android.os.Looper;
import com.larus.bmhome.utils.x1;
import com.larus.common_ui.dialog.l0;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bot/impl/feature/edit/feature/main/MainUIEvent;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.main.BotMainEditView$bindObservers$1", f = "BotMainEditView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotMainEditView$bindObservers$1 extends SuspendLambda implements Function2<e, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    public BotMainEditView$bindObservers$1(a r1, Continuation<? super BotMainEditView$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotMainEditView$bindObservers$1 r0 = new BotMainEditView$bindObservers$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(e r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((e) r1, (Continuation) r2);
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_main_BotMainEditView$bindObservers$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(l0 r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_main_BotMainEditView$bindObservers$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(l0 r1) {
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
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r2);
        e r3 = (e) this.L$0;
        if ((r3 instanceof e.b) == false) goto L15;
        if (((e.b) r3).a == false) goto L11;
        l0 r4 = this.this$0.c;
        if (r4 == null) goto L22;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_main_BotMainEditView$bindObservers$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(r4);
    L22:
        return Unit.INSTANCE;
    L11:
        l0 r5 = this.this$0.c;
        if (r5 == null) goto L22;
        INVOKEVIRTUAL_com_larus_bot_impl_feature_edit_feature_main_BotMainEditView$bindObservers$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r5);
        goto L22
    L15:
        if ((r3 instanceof e.c) == false) goto L17;
        s r0 = s.a;
        this.this$0.a.a.getContext();
        ((e.c) r3).getClass();
        this.this$0.a.a.getContext();
        throw null;
    L17:
        if (Intrinsics.areEqual(r3, e.a.a) == false) goto L24;
        this.this$0.a.z.clearFocus();
        x1 r6 = this.this$0.d;
        if (r6 == null) goto L22;
        Set<String> r1 = x1.d;
        r6.a(false);
        goto L22
    L24:
        throw new NoWhenBranchMatchedException();
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
