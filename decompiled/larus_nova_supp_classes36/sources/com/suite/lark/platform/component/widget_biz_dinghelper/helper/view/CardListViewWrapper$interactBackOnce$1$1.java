package com.suite.lark.platform.component.widget_biz_dinghelper.helper.view;

import android.os.Handler;
import android.os.Looper;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
final class CardListViewWrapper$interactBackOnce$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BackInteractDialog $dialog;

    public CardListViewWrapper$interactBackOnce$1$1(BackInteractDialog r1) {
        this.$dialog = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1795invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1795invoke() {
        INVOKEVIRTUAL_com_suite_lark_platform_component_widget_biz_dinghelper_helper_view_CardListViewWrapper$interactBackOnce$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this.$dialog);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void INVOKEVIRTUAL_com_suite_lark_platform_component_widget_biz_dinghelper_helper_view_CardListViewWrapper$interactBackOnce$1$1_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(BackInteractDialog r3) {
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
}
