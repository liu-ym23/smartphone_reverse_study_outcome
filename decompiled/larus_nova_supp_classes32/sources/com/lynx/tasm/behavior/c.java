package com.lynx.tasm.behavior;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class c {
    public final Map<String, a> a;
    public Map<String, a> b;

    public c() {
        this.b = null;
        this.a = new HashMap();
    }

    public c(Map<String, a> r2) {
        this.b = null;
        if (r2 != null) goto L5;
        this.a = new HashMap();
        return;
    L5:
        this.a = new HashMap(r2);
    }

    public final void a(a r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        String r0 = r4.getName();
        a r1 = this.a.get(r0);
        if (r1 == null) goto L7;
        r1.toString();
    L7:
        this.a.put(r0, r4);
    }

    public final void b(List<a> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Iterator<a> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        a(r3.next());
        goto L6
    }

    public final a c(String r4) {
        Map<String, a> r0 = this.b;
        if (r0 == null) goto L5;
        a r1 = r0.get(r4);
    L6:
        if (r1 != null) goto L8;
        r1 = this.a.get(r4);
    L8:
        if (r1 == null) goto L11;
        return r1;
    L11:
        throw new RuntimeException("No BehaviorController defined for class " + r4);
    L5:
        r1 = null;
        goto L6
    }
}
