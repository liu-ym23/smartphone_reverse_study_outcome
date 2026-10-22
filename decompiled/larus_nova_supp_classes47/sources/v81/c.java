package v81;

import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import u81.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        String r3 = (String) r2;
        Iterator r4 = ((ArrayList) this.a.a).iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        f.a r0 = (f.a) r4.next();
        if (r0 == null) goto L4;
        r0.a();
        goto L4
    }
}
