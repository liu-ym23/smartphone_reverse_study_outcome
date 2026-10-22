package p6;

import java.util.Enumeration;

/* JADX INFO: loaded from: classes2.dex */
public class k implements o6.b {
    public k() {
    }

    public boolean a(n6.a r10) {
        Enumeration r11 = k6.a.k().l();
        if (r11 != null) goto L5;
        return false;
    L5:
        if (r11.hasMoreElements() == false) goto L20;
        s6.a r12 = (s6.a) r11.nextElement();
        if (r12 == null) goto L5;
        if (r12.a(r10) == false) goto L5;
        u6.a.d(new w6.b(0, false, r10.b(), null));
        return true;
    L20:
        return false;
    }

    @Override // o6.b
    public boolean b(n6.a r10) {
        return a(r10);
    }
}
