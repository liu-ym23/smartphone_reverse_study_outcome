package com.larksuite.framework.ui;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class BaseDialog extends AppCompatDialog {
    private final String TAG;
    a mDismissListenner;

    public interface a {
    }

    public static /* synthetic */ void access$000(AppCompatDialog r0) {
        super/*android.app.Dialog*/.show();
    }

    public static /* synthetic */ void access$001(AppCompatDialog r0) {
        super.dismiss();
    }

    public void setDismissListenner(a r1) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void dismiss() {
        if (checkContext(getContext()) == false) goto L6;
        INVOKESPECIAL_com_larksuite_framework_ui_BaseDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(this);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void show() {
        if (checkContext(getContext()) == false) goto L6;
        INVOKESPECIAL_com_larksuite_framework_ui_BaseDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this);
        return;
    }

    public BaseDialog(Context r1) {
        super(r1);
        this.TAG = "BaseDialog";
    }

    public static void INVOKESPECIAL_com_larksuite_framework_ui_BaseDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AppCompatDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        access$001(r3);     // Catch: Throwable -> L11 Exception -> L13
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

    public static void INVOKESPECIAL_com_larksuite_framework_ui_BaseDialog_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AppCompatDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        access$000(r1);
        DialogLancet.afterDialogShow(r1);
    }

    private boolean checkContext(Context r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((r3 instanceof ContextWrapper) == false) goto L11;
        if ((r3 instanceof Activity) == true) goto L9;
        r3 = ((ContextWrapper) r3).getBaseContext();
        goto L6
    L9:
        Activity r4 = (Activity) r3;
    L12:
        if (r4 != null) goto L15;
        return false;
    L15:
        if (c.a(r4) == true) goto L17;
        return false;
    L17:
        return true;
    L11:
        r4 = null;
        goto L12
    }

    public BaseDialog(Context r1, int r2) {
        super(r1, r2);
        this.TAG = "BaseDialog";
    }

    public BaseDialog(Context r1, boolean r2, DialogInterface.OnCancelListener r3) {
        super(r1, r2, r3);
        this.TAG = "BaseDialog";
    }
}
