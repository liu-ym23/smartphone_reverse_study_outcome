package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.content.Context;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j {
    public static boolean b(Exception r3) {
        if ((r3 instanceof ApiServerException) == true) goto L5;
        return false;
    L5:
        if (((ApiServerException) r3).getErrorCode() != com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.n().f()) goto L7;
        boolean r4 = true;
    L8:
        if (r4 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r4 = false;
        goto L8
    }

    public static void a(Context r2, String r3, String r4) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(r2);
        r0.setTitle(r2.getResources().getString(2131916050));
        r0.setMessage(r3);
        r0.setPositiveButton(r4, null);
        AlertDialog r5 = r0.create();
        if (DialogLancet.shouldBlockDialogShow(r5) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r5);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r5);
        r5.show();
        DialogLancet.afterDialogShow(r5);
    }
}
