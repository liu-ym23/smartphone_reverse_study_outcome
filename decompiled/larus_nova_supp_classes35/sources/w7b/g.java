package w7b;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v7b.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g {
    public final List<f> a;

    public final String a() {
        StringBuilder r0 = new StringBuilder();
        int r1 = 0;
    L4:
        if (r1 >= ((ArrayList) this.a).size()) goto L9;
        if (r1 == 0) goto L7;
        r0.append('\n');
    L7:
        r0.append(((f) ListProtector.get(this.a, r1)).a);
        r1 = r1 + 1;
        goto L4
    L9:
        return r0.toString();
    }

    public final List<x> b() {
        ArrayList r0 = new ArrayList();
        Iterator r1 = ((ArrayList) this.a).iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        x r2 = ((f) r1.next()).b;
        if (r2 == null) goto L4;
        r0.add(r2);
        goto L4
    L8:
        return r0;
    }

    public g() {
        this.a = new ArrayList();
    }
}
