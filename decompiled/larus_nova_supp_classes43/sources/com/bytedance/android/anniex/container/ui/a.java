package com.bytedance.android.anniex.container.ui;

import android.content.DialogInterface;
import android.view.KeyEvent;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements DialogInterface.OnKeyListener {
    public final /* synthetic */ AnnieXDialog a;

    public a(AnnieXDialog r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public final boolean onKey(DialogInterface r10, int r11, KeyEvent r12) {
        Intrinsics.checkNotNullParameter(r10, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(r12, "keyEvent");
        if (r11 == 4) goto L5;
    L15:
        return false;
    L5:
        if (r12.getAction() != 1) goto L15;
        ia.f r13 = this.a.d;
        if (r13 != null) goto L9;
    L11:
        boolean r14 = false;
    L12:
        if (r14 == false) goto L15;
        HybridLogger.m("AnnieXDialog", "====intercept backPress=====", null, null, 12);
        return true;
    L9:
        if (r13.canBackPress() == true) goto L11;
        r14 = true;
        goto L12
    }
}
