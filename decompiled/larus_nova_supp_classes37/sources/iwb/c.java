package iwb;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ a a;

    public c(a r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        d r4 = this.a.i;
        if (r4.a.isLaidOut() == false) goto L6;
        r4.b();
        r4.d = false;
        r4.e = false;
        r4.a.c(false, false);
        r4.d(true);
    L6:
        a r5 = this.a;
        r5.l = false;
        r5.removeCallbacks(r5.p);
        d r0 = r5.i;
        if (r0.c == true) goto L10;
        r5.b(r0.c());
        return;
    }
}
