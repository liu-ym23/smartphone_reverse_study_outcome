package lsc;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class n extends o {
    public final /* synthetic */ m$b a;
    public final /* synthetic */ h b;

    @Override // lsc.o
    public final p a() {
        m$b r0 = this.a;
        h r2 = this.b;
        u r3 = new u();
        p$a r1 = (p$a) r0;
        m$a r4 = r1.b;
        if (r4 != null) goto L5;
        r4 = new b();
    L5:
        y r5 = new y("");
        Map r6 = Collections.unmodifiableMap(r1.a);
        return new p(r2, r3, r5, r6, r4);
    }

    public n(p$a r1, h r2) {
        this.a = r1;
        this.b = r2;
    }
}
