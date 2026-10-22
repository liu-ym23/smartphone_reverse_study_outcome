package i40;

import android.content.Context;
import android.view.ViewGroup;
import j40.t0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class b {
    public a a;
    public List<c> b;

    public b(ViewGroup r4) {
        int r0 = t0.a.getValue().intValue();
        if (r0 != 1) goto L5;
        this.a = new g(false);
        return;
    L5:
        if (r0 == 2) goto L7;
        this.a = new a();
        return;
    L7:
        this.a = new f();
        if (r4 == null) goto L13;
        r4.setWillNotDraw(false);
        return;
    }

    public final void b(c r2) {
        if (this.b != null) goto L5;
        this.b = new ArrayList();
    L5:
        this.b.add(r2);
    }

    public boolean a(Context r2, int r3) {
        d r4 = this.a.b(r2, r3);
        if (r4 != null) goto L5;
        return true;
    L5:
        c(r4.a, r4.b);
        return true;
    }

    public final void c(boolean r4, int r5) {
        List<c> r0 = this.b;
        if (r0 == null) goto L8;
        Iterator r1 = ((ArrayList) r0).iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        ((c) r1.next()).X6(r4, r5);
        goto L6
    L10:
        return;
    }
}
