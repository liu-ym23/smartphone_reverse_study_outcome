package o50;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public int a;
    public final HashMap<Integer, a> b;
    public final HashMap<String, Integer> c;
    public int d;

    public final void b() {
        int r0 = this.a;
        if (r0 == (-1)) goto L10;
        a r1 = this.b.get(Integer.valueOf(r0));
        if (r1 == null) goto L8;
        r1.unbind();
    L8:
        this.a = -1;
        return;
    }

    public b() {
        this.a = -1;
        this.b = new HashMap();
        this.c = new HashMap();
    }

    public final int a(u50.a r5) {
        Intrinsics.checkNotNullParameter(r5, "texture");
        boolean r1 = true;
        int r0 = this.d + 1;
        this.d = r0;
        this.b.put(Integer.valueOf(r0), r5);
        if (r5.a.length() > 0) goto L6;
        r1 = false;
    L6:
        if (r1 == false) goto L8;
        this.c.put(r5.a, Integer.valueOf(r0));
    L8:
        return r0;
    }
}
