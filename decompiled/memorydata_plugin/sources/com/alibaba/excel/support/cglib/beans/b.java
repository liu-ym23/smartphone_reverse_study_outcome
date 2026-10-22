package com.alibaba.excel.support.cglib.beans;

import com.alibaba.excel.support.asm.aa;
import com.alibaba.excel.support.asm.f;
import com.alibaba.excel.support.cglib.core.ae;
import com.alibaba.excel.support.cglib.core.ag;
import com.alibaba.excel.support.cglib.core.ai;
import com.alibaba.excel.support.cglib.core.d;
import com.alibaba.excel.support.cglib.core.g;
import com.alibaba.excel.support.cglib.core.i;
import com.alibaba.excel.support.cglib.core.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class b extends d {
    private static final aa c = null;
    private static final aa d = null;
    private static final ag e = null;
    private static final ag f = null;
    private static final ag g = null;
    private static final ag h = null;
    private static final ag i = null;
    private static final ag j = null;
    private static final ag k = null;

    static {
        aa r0 = ai.d("com.alibaba.excel.support.cglib.beans.BeanMap");
        c = r0;
        d = ai.d("com.alibaba.excel.support.cglib.beans.FixedKeySet");
        e = ai.e("Object");
        f = ai.e("String[]");
        g = ai.c("Object get(Object, Object)");
        h = ai.c("Object put(Object, Object, Object)");
        i = ai.c("java.util.Set keySet()");
        j = new ag("newInstance", r0, new aa[]{i.o});
        k = ai.c("Class getPropertyType(String)");
    }

    public b(f r8, String r9, Class r10, int r11) {
        super(r8);
        a(52, 1, r9, c, null, "<generated>");
        o.a(this);
        o.a(this, j);
        j();
        Map r12 = a(ae.d(r10));
        Map r13 = a(ae.e(r10));
        HashMap r0 = new HashMap();
        r0.putAll(r12);
        r0.putAll(r13);
        if (r11 == 0) goto L16;
        Iterator r1 = r0.keySet().iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if ((r11 & 1) == 0) goto L12;
        if (r12.containsKey(r2) == true) goto L12;
    L15:
        r1.remove();
        r12.remove(r2);
        r13.remove(r2);
    L12:
        if ((r11 & 2) == 0) goto L6;
        if (r13.containsKey(r2) == true) goto L6;
    L16:
        a(r10, r12);
        b(r10, r13);
        String[] r14 = a(r0);
        a(r14);
        a(r0, r14);
        h();
    }

    private Map a(PropertyDescriptor[] r4) {
        HashMap r3 = new HashMap();
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r3.put(r4[r0].getName(), r4[r0]);
        r0 = r0 + 1;
        goto L4
    L6:
        return r3;
    }

    private void a(Class r4, Map r5) {
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        final g r0 = a(1, g, null);
        r0.c(0);
        r0.f(aa.getType(r4));
        r0.c(1);
        r0.f(i.A);
        o.a(r0, a(r6), 1, new AnonymousClass1(this, r6, r0));
        r0.g();
    }

    private void a(Map r4, String[] r5) {
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        final g r0 = a(1, k, null);
        r0.c(0);
        o.a(r0, r5, 1, new AnonymousClass3(this, r6, r0));
        r0.g();
    }

    private void a(String[] r5) {
        aa r0 = d;
        a(10, "keys", r0, null);
        g r1 = i();
        r1.d(r0);
        r1.k();
        o.a(r1, r5);
        r1.d(r0, f);
        r1.c("keys");
        r1.w();
        r1.g();
        g r4 = a(1, i, null);
        r4.u();
        r4.b("keys");
        r4.w();
        r4.g();
    }

    private String[] a(Map r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
        return (String[]) ZeusTransformUtils.preCheckCast((String[]) ZeusTransformUtils.preCheckCast(r1.keySet().toArray(new String[r1.size()]), String[].class, "com.obric.memorydata.plugin"), String[].class, "com.obric.memorydata.plugin");
    }

    private void b(Class r4, Map r5) {
        final Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        final g r0 = a(1, h, null);
        r0.c(0);
        r0.f(aa.getType(r4));
        r0.c(1);
        r0.f(i.A);
        o.a(r0, a(r6), 1, new AnonymousClass2(this, r6, r0));
        r0.r();
        r0.w();
        r0.g();
    }

    private void j() {
        ag r0 = e;
        g r3 = a(1, r0, null);
        r3.u();
        r3.c(0);
        r3.e(r0);
        r3.w();
        r3.g();
    }
}
