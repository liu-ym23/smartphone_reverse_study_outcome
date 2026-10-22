package ac2;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends p<Iterable<Object>> {
    public final /* synthetic */ p a;

    public m(p r1) {
        this.a = r1;
    }

    @Override // ac2.p
    public final void a(w r3, Iterable<Object> r4) throws IOException {
        Iterable<Object> r5 = r4;
        if (r5 == null) goto L9;
        Iterator<Object> r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Object r0 = r6.next();
        this.a.a(r3, r0);
        goto L7
    L11:
        return;
    }
}
