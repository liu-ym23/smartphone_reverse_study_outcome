package com.ss.android.lark.filedetail.impl;

import android.content.Context;
import android.content.DialogInterface;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p {
    static {
    }

    @JvmStatic
    public static final void a(Context r2, boolean r3, DialogInterface.OnDismissListener r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        String r0 = y9c.d.i(r2, 2131890330);
        if (r3 == false) goto L5;
        String r5 = y9c.d.i(r2, 2131890329);
        Intrinsics.checkNotNull(r5);
    L6:
        com.larksuite.component.ui.dialog.d r1 = new com.larksuite.component.ui.dialog.d(r2);
        r1.k(r0);
        r1.h(r5);
        r1.a(2131378551, 2131891840, null);
        r1.c.onDismissListener(r4);
        LKUIDialog r6 = r1.c();
        if (DialogLancet.shouldBlockDialogShow(r6) == false) goto L13;
        DialogLancet.handleBlockedDialogShow(r6);
        return;
    L13:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        DialogLancet.beforeDialogShow(r6);
        r6.show();
        DialogLancet.afterDialogShow(r6);
        return;
    L5:
        r5 = y9c.d.i(r2, 2131890331);
        Intrinsics.checkNotNull(r5);
        goto L6
    }
}
