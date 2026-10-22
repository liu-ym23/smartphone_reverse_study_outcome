package ac2;

import java.io.IOException;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n extends p<Object> {
    public final /* synthetic */ p a;

    public n(p r1) {
        this.a = r1;
    }

    @Override // ac2.p
    public final void a(w r5, Object r6) throws IOException {
        if (r6 != null) goto L4;
        return;
    L4:
        int r0 = Array.getLength(r6);
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L7;
        this.a.a(r5, Array.get(r6, r1));
        r1 = r1 + 1;
        goto L5
    }
}
