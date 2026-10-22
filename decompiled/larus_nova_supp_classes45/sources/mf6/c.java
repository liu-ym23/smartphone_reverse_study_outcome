package mf6;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c extends b {
    @Override // mf6.a
    public final void d(float r1) {
    }

    @Override // mf6.a
    public final void a(float r3) {
        if (((ArrayList) this.d).size() == 0) goto L17;
        Iterator r0 = ((ArrayList) this.d).iterator();
    L6:
        if (r0.hasNext() == false) goto L10;
        if (((a) r0.next()).b() == true) goto L6;
        boolean r1 = false;
    L11:
        if (r1 == true) goto L22;
        Iterator r2 = ((ArrayList) this.d).iterator();
    L15:
        if (r2.hasNext() == false) goto L23;
        ((a) r2.next()).a(r3);
        goto L15
    L23:
        return;
    L22:
        return;
    L10:
        r1 = true;
        this.e = true;
        c();
        goto L11
    }

    public c(long r1, Function0 r3) {
        super(r1, r3);
    }
}
