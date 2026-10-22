package jd8;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ g a;
    public final /* synthetic */ ViewTreeObserver.OnPreDrawListener b;
    public final /* synthetic */ int c;
    public final /* synthetic */ View d;

    public /* synthetic */ e(g r1, ViewTreeObserver.OnPreDrawListener r2, int r3, View r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g r0 = this.a;
        ViewTreeObserver.OnPreDrawListener r1 = this.b;
        int r2 = this.c;
        View r3 = this.d;
        if (r0.y == r1) goto L5;
        return;
    L5:
        if (r0.E != r2) goto L9;
        r0.A = true;
        r0.D = SystemClock.uptimeMillis();
        r0.F = -1;
        r3.requestLayout();
        return;
    }
}
