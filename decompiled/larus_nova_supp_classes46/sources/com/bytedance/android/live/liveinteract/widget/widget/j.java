package com.bytedance.android.live.liveinteract.widget.widget;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.r3;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ LinkDistributeSettingDialog a;

    public j(LinkDistributeSettingDialog r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r6v4, types: [android.app.Dialog, com.bytedance.android.live.liveinteract.widget.widget.LinkDistributeSettingDialog, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        Intrinsics.checkNotNullParameter(r6, "curItemView");
        LinkDistributeSettingDialog r0 = this.a;
        int r1 = LinkDistributeSettingDialog.i;
        r0.getClass();
        ImageView r2 = (ImageView) r6.findViewById(2131375834);
        Iterator r3 = ((ArrayList) r0.b).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((ImageView) ((View) r3.next()).findViewById(2131375834)).setImageResource(0);
        goto L4
    L6:
        r2.setImageResource(2131237694);
        this.a.getClass();
        View r4 = r6.findViewById(2131390870);
        String r5 = null;
        if ((r4 instanceof TextView) == true) goto L9;
        r4 = null;
    L9:
        TextView r7 = (TextView) r4;
        if (r7 == null) goto L14;
        CharSequence r8 = r7.getText();
        if (r8 == null) goto L14;
        r5 = r8.toString();
    L14:
        if (r5 == null) goto L16;
        this.a.getContext().getString(2131915929);
        r3.g(r6, r5);
        Objects.toString(Unit.INSTANCE);
    L16:
        int r9 = r6.getId();
        if (r9 != 2131377980) goto L20;
        this.a.N0(ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_DELEGATED_TO_EVERYONE);
    L25:
        ?? r10 = this.a;
        Handler r11 = DialogLancet.resolveDialogHandler(r10);
        if (r11 != null) goto L28;
    L30:
        DialogLancet.beforeDialogDismiss(r10);
        r10.dismiss();     // Catch: Throwable -> L33 Exception -> L35
    L39:
        DialogLancet.afterDialogDismiss(r10);
        return;
    L35:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L33
        Throwable r12 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L33
        if (r12 == null) goto L39;
        com.bytedance.crash.d.d(r12, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r10);
        throw th;
    L28:
        if (Looper.myLooper() == r11.getLooper()) goto L30;
        r11.post(DialogLancet.createDismissRunnable(r10));
        return;
    L20:
        if (r9 != 2131377981) goto L23;
        this.a.N0(ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN);
        goto L25
    L23:
        if (r9 != 2131377982) goto L25;
        this.a.N0(ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF);
        goto L25
    }
}
