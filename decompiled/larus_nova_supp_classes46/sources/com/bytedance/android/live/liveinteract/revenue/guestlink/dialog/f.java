package com.bytedance.android.live.liveinteract.revenue.guestlink.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.p6;
import com.bytedance.kmp.live.livelink.api.guestlink.model.ChannelFinishReason;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f implements DialogInterface.OnClickListener {
    public final /* synthetic */ GuestLinkMainPageDialogForAudience a;
    public final /* synthetic */ Ref.ObjectRef b;

    public f(GuestLinkMainPageDialogForAudience r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r13, int r14) {
        ALogger.i("GuestLinkMainPageDialogForAudience", "click finishChannel, positive button");
        Dialog r15 = (Dialog) this.b.element;
        if (r15 == null) goto L21;
        Handler r0 = DialogLancet.resolveDialogHandler(r15);
        if (r0 != null) goto L7;
    L9:
        DialogLancet.beforeDialogDismiss(r15);
        r15.dismiss();     // Catch: Throwable -> L12 Exception -> L14
    L18:
        DialogLancet.afterDialogDismiss(r15);
        goto L21
    L14:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
        if (r1 == null) goto L18;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r15);
        throw th;
    L7:
        if (Looper.myLooper() == r0.getLooper()) goto L9;
        r0.post(DialogLancet.createDismissRunnable(r15));
    L21:
        com.bytedance.android.live.base.model.message.guestlink.a r16 = this.a.T90();
        if (r16 == null) goto L51;
        ALogger.i("GuestLinkMainPageDialogForAudience", "finishChannel, channelId: " + r16.getChannelId());
        long r2 = (p6.b() - r16.getStartTimeMs()) / ((long) 1000);
        int r3 = tb6.a.a;
        tb6.a.e(false, r16, "double_end", Long.valueOf(r2));
        if (je0.d.D() == false) goto L26;
        String r4 = "anchor";
    L28:
        if (je0.d.D() == false) goto L30;
        String r5 = ChannelFinishReason.ANCHOR.getRequestSource();
    L31:
        String r11 = r5;
        tb6.a.d(false, r16, r4, r2);
        lb6.g r6 = this.a.D;
        if (r6 == null) goto L34;
        r6.h(je0.d.a0(), r16.getChannelId(), r11, r11);
    L34:
        ALogger.i("GuestLinkMainPageDialogForAudience", "click finishChannel, isAnchor: " + je0.d.D() + ", isAdmin: " + vi0.f.a(this.a.L));
        if (je0.d.D() == true) goto L48;
        if (vi0.f.a(this.a.L) == true) goto L48;
        return;
    L48:
        this.a.dismiss();     // Catch: Exception -> L41
        return;
    L41:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r17 = DialogFragmentLancet.sLastShowStack;
        if (r17 == null) goto L53;
        com.bytedance.crash.d.d(r17, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L53:
        return;
    L30:
        r5 = ChannelFinishReason.ADMIN.getRequestSource();
        goto L31
    L26:
        r4 = "admin";
        goto L28
    }
}
