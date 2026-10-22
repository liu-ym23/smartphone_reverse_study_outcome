package n4a;

import android.content.Context;
import java.io.File;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c5 extends l1 {
    public final /* synthetic */ Context b;

    public c5(Context r1) {
        this.b = r1;
    }

    @Override // n4a.l1
    public final void a() {
        Iterator<File> r0 = com.loc.u.c(com.loc.u.h(this.b)).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        File r1 = r0.next();
        com.loc.u.a(this.b, r1.getName());
        goto L4
    L6:
        com.loc.u.d(this.b);
    }
}
