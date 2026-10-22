package z80;

import com.bytedance.android.livehostapi.business.IHostRealNameAuthorization;
import gu2.g;
import jc1.k;
import v80.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements x80.a {
    public d() {
    }

    @Override // x80.a
    public final void a(h r2) {
        if ((r2 instanceof v80.d) == true) goto L5;
        r2 = null;
    L5:
        v80.d r3 = (v80.d) r2;
        if (r3 != null) goto L8;
        return;
    L8:
        g r0 = g.a;
        if (k.f(IHostRealNameAuthorization.class) == null) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L14;
        g.a(r3);
        return;
    L14:
        y30.b r4 = y30.a.b();
        if (r4 == null) goto L19;
        r4.b(r3);
        return;
    L19:
        return;
    L11:
        r1 = false;
        goto L12
    }
}
