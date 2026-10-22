package x72;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        c r5 = this.a;
        r5.b = 2;
        Iterator r6 = ((ArrayList) r5.a).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        k32.a r0 = (k32.a) r6.next();
        ((v72.c) this.a.d).a(r0);
        goto L4
    }
}
