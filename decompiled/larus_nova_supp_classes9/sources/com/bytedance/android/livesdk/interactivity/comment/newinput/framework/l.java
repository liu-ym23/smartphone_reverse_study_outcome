package com.bytedance.android.livesdk.interactivity.comment.newinput.framework;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.CheckBox;
import com.bytedance.android.livesdk.event.q;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ com.bytedance.android.livesdk.interactivity.comment.input.i a;
    public final /* synthetic */ LiveInputDialogV3 b;
    public final /* synthetic */ com.bytedance.android.live.profit.privilege.model.danmu.b c;
    public final /* synthetic */ String d;
    public final /* synthetic */ com.bytedance.android.livesdk.event.m e;
    public final /* synthetic */ q f;

    public l(com.bytedance.android.livesdk.interactivity.comment.input.i r1, LiveInputDialogV3 r2, com.bytedance.android.live.profit.privilege.model.danmu.b r3, String r4, com.bytedance.android.livesdk.event.m r5, q r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r11) {
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r13 = l42.a.o;
        CheckBox r0 = this.a.c;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("checkBox");
    L5:
        Boolean r1 = Boolean.valueOf(!r0.isChecked());
        r13.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r13, r1);
        this.b.S90(this.d, true, this.c.getStyle(), false, this.b.V90(this.c), this.e, this.f);
        com.bytedance.android.livesdk.interactivity.api.monitor.b.a(true);
        com.bytedance.android.livesdk.interactivity.comment.input.i r14 = this.a;
        Handler r2 = DialogLancet.resolveDialogHandler(r14);
        if (r2 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(r14);
        r14.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(r14);
    L20:
        this.b.dismissInputDialog();
        return;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r3 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r3 == null) goto L19;
        com.bytedance.crash.d.d(r3, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r14);
        throw th;
    L8:
        if (Looper.myLooper() == r2.getLooper()) goto L10;
        r2.post(DialogLancet.createDismissRunnable(r14));
        goto L20
    }
}
