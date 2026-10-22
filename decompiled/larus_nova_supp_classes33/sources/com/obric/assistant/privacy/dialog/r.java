package com.obric.assistant.privacy.dialog;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.sheet.v2.OSheet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ com.obric.oui.sheet.v2.i b;
    public final /* synthetic */ OSheet c;

    public r(RadiusLayout r1, com.obric.oui.sheet.v2.i r2, OSheet r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.obric.oui.sheet.v2.i r0 = this.b;     // Catch: Throwable -> L4
        r0.i = this.c.q.getHeight();     // Catch: Throwable -> L4
        this.b.e();     // Catch: Throwable -> L4
        this.b.a();     // Catch: Throwable -> L4
        this.b.c.setRadius(0.0f);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
