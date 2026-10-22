package com.ss.android.lark.conditional.access.nopermission.ui.custom;

import android.view.KeyEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements Runnable {
    public final /* synthetic */ CustomNoPermissionFragment a;
    public final /* synthetic */ ConstraintLayout b;
    public final /* synthetic */ String c;

    public h(CustomNoPermissionFragment r1, ConstraintLayout r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L12:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L20;
        throw th;
    L20:
        return;
    L3:
        if (this.a.isAdded() == false) goto L15;
        KeyEvent.Callback r0 = this.b.findViewWithTag(this.c);     // Catch: Throwable -> L12
        if ((r0 instanceof u8b.b) == false) goto L8;
        u8b.b r1 = (u8b.b) r0;     // Catch: Throwable -> L12
    L9:
        if (r1 == null) goto L19;
        r1.endLoading();     // Catch: Throwable -> L12
        return;
    L19:
        return;
    L8:
        r1 = null;
        goto L9
    }
}
