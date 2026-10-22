package com.larus.update;

import com.ss.android.update.d;
import f09.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class IBitsUpdateImpl$b implements a.b {
    public final /* synthetic */ d a;
    public final /* synthetic */ IBitsUpdateImpl b;

    public final void onAppForeground() {
    }

    public final void onAllActivityDestroyed() {
        this.a.W();
        this.b.c = true;
        this.a.W = false;
    }

    public final void onAppBackground() {
        if (this.a.P() == false) goto L6;
        this.b.c = true;
        return;
    }

    public IBitsUpdateImpl$b(d r1, IBitsUpdateImpl r2) {
        this.a = r1;
        this.b = r2;
    }
}
