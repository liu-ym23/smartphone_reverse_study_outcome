package com.ss.android.lark.flow.passport.ui.widget.common;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.officesdk.utils.RomUtils;
import com.ss.android.lark.utils.Contexts;
import uzb.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f extends Dialog {
    public final boolean a;

    public final boolean a() {
        Context r0 = getContext();
        if ((r0 instanceof Activity) == false) goto L6;
        Activity r1 = Contexts.requireActivity(r0);
    L12:
        if (r1 != null) goto L15;
        return false;
    L15:
        if (r1.isFinishing() == false) goto L17;
        return false;
    L17:
        if (r1.isDestroyed() == true) goto L21;
        return true;
    L21:
        return false;
    L6:
        if ((r0 instanceof ContextWrapper) == false) goto L10;
        Context r2 = ((ContextWrapper) r0).getBaseContext();
        if ((r2 instanceof Activity) == false) goto L10;
        r1 = Contexts.requireActivity(r2);
    L10:
        r1 = null;
        goto L12
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        if (a() == false) goto L21;
        Handler r0 = DialogLancet.resolveDialogHandler(this);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        goto L18
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    @Override // android.app.Dialog
    public final void show() {
        if (a() == true) goto L5;
        return;
    L5:
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L21;
        DialogLancet.handleBlockedDialogShow(this);
    L10:
        if (this.a == false) goto L24;
        Context r0 = getContext();
        Window r1 = getWindow();
        int r2 = l.b(r0, 2131106784);
        if (h18.f.a(r0) == false) goto L17;
        if (RomUtils.g(false, r0, r1) == false) goto L25;
        r1.addFlags(Target.SIZE_ORIGINAL);
        r1.clearFlags(67108864);
        r1.setStatusBarColor(r2);
        return;
    L25:
        return;
    L17:
        if (RomUtils.g(true, r0, r1) == false) goto L27;
        r1.addFlags(Target.SIZE_ORIGINAL);
        r1.clearFlags(67108864);
        r1.setStatusBarColor(r2);
        return;
    L27:
        return;
    L24:
        return;
    L21:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L20
    L8:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L10
    }

    public f(Context r2, boolean r3) {
        super(r2, 2131952047);
        this.a = false;
        this.a = r3;
        setContentView(2131564875);
        setCanceledOnTouchOutside(false);
        getWindow().setGravity(17);
    }
}
