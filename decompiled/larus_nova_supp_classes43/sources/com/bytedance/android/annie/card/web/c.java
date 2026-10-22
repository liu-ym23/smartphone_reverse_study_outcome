package com.bytedance.android.annie.card.web;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.GeolocationPermissions;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends e {
    public final Context b;
    public WeakReference<AlertDialog> c;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ GeolocationPermissions.Callback a;
        public final /* synthetic */ String b;

        public a(GeolocationPermissions.Callback r1, String r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "dialog");
            if (r11 != (-2)) goto L5;
            GeolocationPermissions.Callback r12 = this.a;
            if (r12 == null) goto L14;
            r12.invoke(this.b, false, false);
        L14:
            r10.dismiss();
            return;
        L5:
            if (r11 != (-1)) goto L17;
            GeolocationPermissions.Callback r13 = this.a;
            if (r13 == null) goto L10;
            r13.invoke(this.b, true, true);
        L10:
            r10.dismiss();
            return;
        }
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void o() {
        WeakReference<AlertDialog> r0 = this.c;
        if (r0 == null) goto L13;
        AlertDialog r1 = r0.get();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isShowing() == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L15;
        D(r1);
        return;
    L15:
        return;
    }

    public c(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(null);
        this.b = r10;
    }

    public static void D(AlertDialog r10) {
        Handler r0 = DialogLancet.resolveDialogHandler(r10);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r10);
        r10.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r10);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r10);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r10));
    }

    @Override // com.bytedance.android.annie.card.web.e
    public final void p(String r10, GeolocationPermissions.Callback r11) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        WeakReference<AlertDialog> r0 = this.c;
        if (r0 == null) goto L15;
        AlertDialog r1 = r0.get();
        if (r1 == null) goto L15;
        if (r1.isShowing() == true) goto L13;
        r1 = null;
    L13:
        if (r1 == null) goto L15;
        D(r1);
    L15:
        AlertDialog.Builder r12 = new AlertDialog.Builder(this.b);
        r12.setTitle(2131894115);
        r12.setMessage(r12.getContext().getString(2131894114, new Object[]{r10}));
        a r13 = new a(r11, r10);
        r12.setNegativeButton(2131894113, r13);
        r12.setPositiveButton(2131894112, r13);
        r12.setCancelable(false);
        this.c = new WeakReference(r12.show());
    }
}
