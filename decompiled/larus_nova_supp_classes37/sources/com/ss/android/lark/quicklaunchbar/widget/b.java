package com.ss.android.lark.quicklaunchbar.widget;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class b implements View.OnLongClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ QuickLaunchBar b;
    public final /* synthetic */ j2c.a c;

    public b(boolean r1, QuickLaunchBar r2, j2c.a r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r2) {
        if (this.a == false) goto L5;
        QuickLaunchBar r3 = this.b;
        int r0 = QuickLaunchBar.g;
        r3.getClass();
    L6:
        this.c.getClass();
        return false;
    L5:
        QuickLaunchBar r4 = this.b;
        int r1 = QuickLaunchBar.g;
        r4.getClass();
        goto L6
    }
}
