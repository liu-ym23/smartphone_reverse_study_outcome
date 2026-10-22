package com.lynx.tasm;

import com.lynx.jsbridge.LynxModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class q {
    public Boolean a;
    public String b;
    public LynxGroup c;
    public final List<com.lynx.jsbridge.f> d;
    public final Map<String, d8a.k> e;
    public TemplateData f;
    public TemplateData g;
    public f8a.a h;
    public g8a.a i;
    public h8a.a j;
    public LynxBooleanOption k;
    public Boolean l;
    public LynxModule.a m;

    public static int c(int r0, boolean r1, int r2) {
        if (r1 == false) goto L5;
        return r0 | r2;
    L5:
        return r0 & (~r2);
    }

    public q() {
        this.k = LynxBooleanOption.UNSET;
        this.e = new HashMap();
        this.d = new ArrayList();
    }

    public q(q r3) {
        this.k = LynxBooleanOption.UNSET;
        this.a = r3.a;
        this.b = r3.b;
        this.c = r3.c;
        this.d = new ArrayList(r3.d);
        this.e = new HashMap(r3.e);
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.i = r3.i;
        this.j = r3.j;
        this.k = r3.k;
        this.l = r3.l;
        this.m = r3.m;
    }

    public final int a(boolean r5) {
        boolean r1 = false;
        int r0 = c(0, false, 4);
        LynxGroup r2 = this.c;
        if (r2 != null) goto L5;
    L6:
        r1 = true;
    L7:
        int r6 = c(c(r0, r1, 8), r5, 32);
        Boolean r3 = Boolean.TRUE;
        int r7 = c(r6, r3.equals(this.a), 1);
        LynxGroup r4 = this.c;
        if (r4 == null) goto L11;
        r7 = c(r7, r4.enableJSGroupThread(), 2);
    L11:
        return c(r7, r3.equals(this.l), 16);
    L5:
        if (r2.enableV8() == true) goto L7;
        goto L6
    }

    public final void b(q r4) {
        if (r4 != this) goto L4;
        return;
    L4:
        this.c = r4.c;
        Boolean r0 = r4.a;
        if (r0 != null) goto L8;
        r0 = Boolean.FALSE;
    L8:
        this.a = r0;
        this.b = r4.b;
        this.l = Boolean.FALSE;
        this.d.addAll(r4.d);
        if (this.k != LynxBooleanOption.UNSET) goto L11;
        this.k = r4.k;
    L11:
        f8a.a r1 = this.h;
        if (r1 != null) goto L15;
        r1 = r4.h;
    L15:
        this.h = r1;
        g8a.a r2 = this.i;
        if (r2 != null) goto L19;
        r2 = r4.i;
    L19:
        this.i = r2;
        h8a.a r3 = this.j;
        if (r3 != null) goto L23;
        r3 = r4.j;
    L23:
        this.j = r3;
        Iterator<Map.Entry<String, d8a.k>> r5 = r4.e.entrySet().iterator();
    L25:
        if (r5.hasNext() == false) goto L29;
        Map.Entry<String, d8a.k> r6 = r5.next();
        if (this.e.containsKey(r6.getKey()) == true) goto L25;
        this.e.put(r6.getKey(), r6.getValue());
        goto L25
    }
}
