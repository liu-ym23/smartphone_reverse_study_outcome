package gm0;

import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public abstract class a implements g71.b {
    public final List<u71.b> a;
    public g71.a b;
    public final DataCenter c;

    public final void c() {
        Iterator r0 = b().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        u71.b r1 = (u71.b) r0.next();
        r1.c(this);
        r1.a();
        goto L4
    }

    public final void reset() {
        Iterator r0 = b().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((u71.b) r0.next()).reset();
        goto L4
    }

    public a(DataCenter r1) {
        this.c = r1;
        this.a = new ArrayList();
    }

    public final void a(Integer r2) {
        g71.a r0 = this.b;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
