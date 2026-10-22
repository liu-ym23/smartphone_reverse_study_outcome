package c4;

import androidx.lifecycle.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class f extends m {
    @Override // c4.c
    public final void r(int r8, int r10, List<String> r11, Throwable r12, String r13, Object... r14) {
        if (j.f3347a.isEmpty() == true) goto L5;
    L7:
        boolean r15 = false;
    L8:
        if (r15 == false) goto L10;
        return;
    L10:
        i.a r16 = i.f3338i;
        Object r17 = new s(3).f2194b;
        ((i) r17).f3342d = r8;
        ((i) r17).f3341c = r10;
        ((i) r17).f3340b = Thread.currentThread().getName();
        ((i) r17).f3346h = r12;
        ArrayList r18 = this.f3329b;
        if (r11 != null) goto L13;
    L15:
        ((i) r17).f3343e = r18;
        ((i) r17).f3344f = c.q(r13, r14);
        i r19 = (i) r17;
        j.a(r19);
        Iterator r20 = j.f3348b.values().iterator();
    L17:
        if (r20.hasNext() == false) goto L19;
        ((h) r20.next()).a(r19);
        goto L17
    L19:
        return;
    L13:
        if (r11.size() <= 0) goto L15;
        ArrayList r21 = new ArrayList();
        r21.addAll(r18);
        r21.addAll(r11);
        r18 = r21;
        goto L15
    L5:
        if (j.f3348b.isEmpty() == false) goto L7;
        r15 = true;
        goto L8
    }

    @Override // c4.c
    public final void s(String r8) {
        b("You should not set appId on global logger instance", new Object[0]);
    }
}
