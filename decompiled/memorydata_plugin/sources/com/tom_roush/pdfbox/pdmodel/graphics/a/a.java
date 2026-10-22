package com.tom_roush.pdfbox.pdmodel.graphics.a;

import com.tom_roush.pdfbox.a.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f16257a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f16258b = null;
    public static final c c = null;
    public static final c d = null;
    public static final c e = null;
    public static final c f = null;
    public static final c g = null;
    public static final c h = null;
    public static final c i = null;
    public static final c j = null;
    public static final c k = null;
    public static final c l = null;
    public static final c m = null;
    public static final b n = null;
    public static final b o = null;
    public static final b p = null;
    public static final b q = null;
    private static final Map<i, a> r = null;
    private static final Map<a, i> s = null;

    static {
        c r0 = new AnonymousClass1();
        f16257a = r0;
        f16258b = r0;
        c = new AnonymousClass9();
        d = new AnonymousClass10();
        e = new AnonymousClass11();
        f = new AnonymousClass12();
        g = new AnonymousClass13();
        h = new AnonymousClass14();
        i = new AnonymousClass15();
        j = new AnonymousClass16();
        k = new AnonymousClass2();
        l = new AnonymousClass3();
        m = new AnonymousClass4();
        n = new AnonymousClass5();
        o = new AnonymousClass6();
        p = new AnonymousClass7();
        q = new AnonymousClass8();
        r = a();
        s = b();
    }

    a() {
    }

    public static a a(com.tom_roush.pdfbox.a.b r5) {
        a r3 = null;
        if (ZeusTransformUtils.instanceOf(r5, i.class) == false) goto L6;
        r3 = (a) ZeusTransformUtils.preCheckCast(r.get(r5), a.class, "com.obric.memorydata.plugin");
    L14:
        if (r3 == null) goto L17;
        return r3;
    L17:
        return f16257a;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.a.a.class) == false) goto L14;
        com.tom_roush.pdfbox.a.a r6 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        int r1 = 0;
    L9:
        if (r1 >= r6.b()) goto L14;
        r3 = (a) ZeusTransformUtils.preCheckCast(r.get(r6.a(r1)), a.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L14;
        r1 = r1 + 1;
        goto L9
    }

    private static Map<i, a> a() {
        HashMap r0 = new HashMap(13);
        i r1 = i.fr;
        c r2 = f16257a;
        r0.put(r1, r2);
        r0.put(i.bf, r2);
        r0.put(i.ff, c);
        r0.put(i.hi, d);
        r0.put(i.fU, e);
        r0.put(i.bt, f);
        r0.put(i.ez, g);
        r0.put(i.ba, h);
        r0.put(i.aZ, i);
        r0.put(i.dz, j);
        r0.put(i.hv, k);
        r0.put(i.bP, l);
        r0.put(i.cH, m);
        r0.put(i.dF, n);
        r0.put(i.hg, o);
        r0.put(i.eG, q);
        r0.put(i.aS, p);
        return r0;
    }

    private static Map<a, i> b() {
        HashMap r0 = new HashMap(13);
        r0.put(f16257a, i.fr);
        r0.put(f16258b, i.fr);
        r0.put(c, i.ff);
        r0.put(d, i.hi);
        r0.put(e, i.fU);
        r0.put(f, i.bt);
        r0.put(g, i.ez);
        r0.put(h, i.ba);
        r0.put(i, i.aZ);
        r0.put(j, i.dz);
        r0.put(k, i.hv);
        r0.put(l, i.bP);
        r0.put(m, i.cH);
        r0.put(n, i.dF);
        r0.put(o, i.hg);
        r0.put(q, i.eG);
        r0.put(p, i.aS);
        return r0;
    }
}
