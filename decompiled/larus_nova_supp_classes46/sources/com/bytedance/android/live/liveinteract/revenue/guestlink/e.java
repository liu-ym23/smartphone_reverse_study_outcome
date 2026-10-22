package com.bytedance.android.live.liveinteract.revenue.guestlink;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.widget.x0;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements Runnable {
    public final /* synthetic */ GuestLinkWidget a;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ e a;

        public a(e r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            ALogger.i("GuestLinkWidget", "applyTalkRoom, onClick negative button");
            Dialog r5 = this.a.a.i;
            if (r5 == null) goto L21;
            Handler r6 = DialogLancet.resolveDialogHandler(r5);
            if (r6 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            return;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r7 == null) goto L18;
            com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L7:
            if (Looper.myLooper() == r6.getLooper()) goto L9;
            r6.post(DialogLancet.createDismissRunnable(r5));
            return;
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public final /* synthetic */ e a;

        public b(e r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r3, int r4) {
            ALogger.i("GuestLinkWidget", "applyTalkRoom, onClick positive button");
            Dialog r5 = this.a.a.i;
            if (r5 == null) goto L21;
            Handler r6 = DialogLancet.resolveDialogHandler(r5);
            if (r6 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            goto L21
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r7 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r7 == null) goto L18;
            com.bytedance.crash.d.d(r7, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L7:
            if (Looper.myLooper() == r6.getLooper()) goto L9;
            r6.post(DialogLancet.createDismissRunnable(r5));
        L21:
            this.a.a.getClass();
            GuestLinkWidget.zq();
        }
    }

    public e(GuestLinkWidget r1) {
        this.a = r1;
    }

    public final void a() {
        ALogger.i("GuestLinkWidget", "applyTalkRoom");
        String r0 = vm2.i.e().getReapplyDoubleCheckTitle();
        if (r0 != null) goto L5;
        r0 = s1.B(2131917265);
    L5:
        String r1 = vm2.i.e().getReapplyDoubleCheckCancelButtonText();
        if (r1 != null) goto L8;
        r1 = s1.B(2131917266);
    L8:
        String r2 = vm2.i.e().getReapplyDoubleCheckConfirmButtonText();
        if (r2 != null) goto L11;
        r2 = s1.B(2131917267);
    L11:
        GuestLinkWidget r3 = this.a;
        Context r4 = ((Widget) r3).context;
        x0.d r5 = new x0.d();
        r5.b = r4;
        r5.a = 0;
        r5.c = r0;
        r5.m = Float.valueOf(16.0f);
        a r6 = new a(this);
        x0.c[] r7 = r5.g;
        x0.c r8 = r7[0];
        if (r8 != null) goto L14;
        r8 = new x0.c();
        r7[0] = r8;
    L14:
        r8.a = r1;
        r8.b = r6;
        b r9 = new b(this);
        x0.c r10 = r7[1];
        if (r10 != null) goto L17;
        r10 = new x0.c();
        r7[1] = r10;
    L17:
        r10.a = r2;
        r10.b = r9;
        r3.i = new x0(r5.b, r5);
        Dialog r11 = this.a.i;
        if (r11 != null) goto L20;
        return;
    L20:
        if (DialogLancet.shouldBlockDialogShow(r11) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(r11);
        return;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L23:
        DialogLancet.beforeDialogShow(r11);
        r11.show();
        DialogLancet.afterDialogShow(r11);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
