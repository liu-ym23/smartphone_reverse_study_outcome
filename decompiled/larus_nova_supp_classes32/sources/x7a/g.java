package x7a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public static final g d = null;
    public final Stack<d> a;
    public final Map<f, d> b;
    public final int c;

    static {
        d = new g();
    }

    public final d a() {
        Stack<d> r0 = this.a;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0.isEmpty() == false) goto L7;
        return null;
    L7:
        return this.a.peek();
    }

    public g() {
        this.a = new Stack();
        this.b = new WeakHashMap();
        this.c = Integer.MAX_VALUE;
    }

    public final void b() {
        d r0 = a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.b.isEmpty() == true) goto L7;
        h r1 = r0.b.pop();
        r0.c(r0.d.remove(r1));
        return;
    L7:
        f r2 = r0.b();
        if (r2 == null) goto L13;
        r2.quit();
        return;
    }

    public final void c(String r4, Map<String, Object> r5) {
        if (TextUtils.isEmpty(r4) == true) goto L16;
        d r0 = a();
        if (r0 == null) goto L17;
        HashMap<String, Object> r1 = r0.c;
        if (r1 == null) goto L11;
        Object r2 = r1.get(r4);
        if ((r2 instanceof String) == false) goto L11;
        String r3 = (String) r2;
    L12:
        h r6 = new h(r3, r5);
        a r7 = new a(r0, r6, r4);
        f r8 = r0.b();
        if (r8 == null) goto L18;
        r8.j(r6, new c(r0, r6, r7));
        return;
    L18:
        return;
    L11:
        r3 = r4;
        goto L12
    L17:
        return;
    }
}
