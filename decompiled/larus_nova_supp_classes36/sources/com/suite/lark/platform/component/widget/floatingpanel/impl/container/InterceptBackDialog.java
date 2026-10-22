package com.suite.lark.platform.component.widget.floatingpanel.impl.container;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Window;
import androidx.appcompat.app.AppCompatDialog;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\r\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\bH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/suite/lark/platform/component/widget/floatingpanel/impl/container/InterceptBackDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "onBack", "Lkotlin/Function0;", "", "getOnBack", "()Lkotlin/jvm/functions/Function0;", "setOnBack", "(Lkotlin/jvm/functions/Function0;)V", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onBackPressed", "dismiss", "getActivity", "Landroid/app/Activity;", "widget-biz-dinghelper_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class InterceptBackDialog extends AppCompatDialog {
    public Function0<Unit> a;

    /* JADX WARN: Multi-variable type inference failed */
    public final void dismiss() {
        Activity r0 = getActivity(getContext());
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L9;
        return;
    L9:
        Handler r2 = DialogLancet.resolveDialogHandler(this);
        if (r2 != null) goto L12;
    L14:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L17 Exception -> L19
    L23:
        DialogLancet.afterDialogDismiss(this);
        return;
    L17:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L19:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
        if (r3 == null) goto L23;
        d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        goto L23
    L12:
        if (Looper.myLooper() == r2.getLooper()) goto L14;
        r2.post(DialogLancet.createDismissRunnable(this));
        return;
    L5:
        if (r0.isDestroyed() != true) goto L7;
        r1 = true;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onBackPressed() {
        super/*android.app.Dialog*/.onBackPressed();
        Function0<Unit> r0 = this.a;
        if (r0 == null) goto L6;
        r0.invoke();
        return;
    }

    public InterceptBackDialog(Context r1) {
        super(r1);
    }

    private final Activity getActivity(Context r2) {
        if (r2 == null) goto L13;
        if ((r2 instanceof Activity) == true) goto L13;
        if ((r2 instanceof ContextWrapper) == true) goto L11;
        return null;
    L11:
        return getActivity(((ContextWrapper) r2).getBaseContext());
    L13:
        return (Activity) r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onCreate(Bundle r3) {
        Window r0 = getWindow();
        if (r0 == null) goto L5;
        r0.addFlags(16);
    L5:
        Window r1 = getWindow();
        if (r1 == null) goto L8;
        r1.addFlags(32);
    L8:
        Window r2 = getWindow();
        if (r2 == null) goto L11;
        r2.clearFlags(2);
    L11:
        Window r4 = getWindow();
        if (r4 == null) goto L14;
        r4.requestFeature(1);
    L14:
        super.onCreate(r3);
    }
}
