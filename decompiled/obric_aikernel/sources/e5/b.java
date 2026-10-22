package e5;

import n4.c;
import n4.e;
import o2.d;

/* JADX INFO: loaded from: classes.dex */
public class b implements n4.a {
    public b() {
    }

    @Override // n4.a
    public e a(c r10) {
        if ((r10.t() instanceof o2.c) == false) goto L5;
        boolean r11 = ((o2.c) r10.t()).f11430k;
    L6:
        d r12 = com.bytedance.ttnet.c.b(r10.G(), r11);
        if (r12 != null) goto L11;
        return null;
    L11:
        return r12.a(r10);
    L5:
        r11 = false;
        goto L6
    }
}
