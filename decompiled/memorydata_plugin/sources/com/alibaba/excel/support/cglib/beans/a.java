package com.alibaba.excel.support.cglib.beans;

import com.alibaba.excel.support.asm.f;
import com.alibaba.excel.support.cglib.core.ae;
import com.alibaba.excel.support.cglib.core.s;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.ProtectionDomain;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Map {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Object f343a;

    /* JADX INFO: renamed from: com.alibaba.excel.support.cglib.beans.a$a, reason: collision with other inner class name */
    public static class C0048a extends com.alibaba.excel.support.cglib.core.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final com.alibaba.excel.support.cglib.core.a.b f344a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final InterfaceC0049a f345b = null;
        private Object c;
        private Class d;
        private int e;

        /* JADX INFO: renamed from: com.alibaba.excel.support.cglib.beans.a$a$a, reason: collision with other inner class name */
        interface InterfaceC0049a {
            Object a(Class r1, int r2);
        }

        static {
            f344a = new com.alibaba.excel.support.cglib.core.a.b(a.class.getName());
            f345b = (InterfaceC0049a) ZeusTransformUtils.preCheckCast(s.a(InterfaceC0049a.class, s.f423a), InterfaceC0049a.class, "com.obric.memorydata.plugin");
        }

        public C0048a() {
            super(f344a);
        }

        @Override // com.alibaba.excel.support.cglib.core.a
        public ClassLoader a() {
            return this.d.getClassLoader();
        }

        @Override // com.alibaba.excel.support.cglib.core.a
        public Object a(Class r3) {
            return ((a) ZeusTransformUtils.preCheckCast(ae.b(r3), a.class, "com.obric.memorydata.plugin")).a(this.c);
        }

        @Override // com.alibaba.excel.support.cglib.core.e
        public void a(f r4) {
            new b(r4, d(), this.d, this.e);
        }

        public void a(Object r1) {
            this.c = r1;
            if (r1 == null) goto L6;
            Class<?> r2 = r1.getClass();
            this.d = r2;
            c(r2);
            return;
        }

        @Override // com.alibaba.excel.support.cglib.core.a
        public Object b(Object r3) {
            return ((a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin")).a(this.c);
        }

        @Override // com.alibaba.excel.support.cglib.core.a
        public ProtectionDomain b() {
            return ae.a(this.d);
        }

        public a c() {
            Class r0 = this.d;
            if (r0 == null) goto L7;
            a(r0.getName());
            return (a) ZeusTransformUtils.preCheckCast(super.d(f345b.a(this.d, this.e)), a.class, "com.obric.memorydata.plugin");
        L7:
            throw new IllegalArgumentException("Class of bean unknown");
        }
    }

    public a() {
    }

    public abstract a a(Object r1);

    public Object a() {
        return this.f343a;
    }

    public abstract Object a(Object r1, Object r2);

    public abstract Object a(Object r1, Object r2, Object r3);

    @Override // java.util.Map
    public boolean equals(Object r5) {
        if (r5 != null) goto L5;
    L25:
        return false;
    L5:
        if (ZeusTransformUtils.instanceOf(r5, Map.class) == false) goto L25;
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin");
        if (size() == r6.size()) goto L10;
        return false;
    L10:
        Iterator r1 = keySet().iterator();
    L12:
        if (r1.hasNext() == false) goto L23;
        Object r2 = r1.next();
        if (r6.containsKey(r2) == false) goto L15;
        Object r3 = get(r2);
        Object r4 = r6.get(r2);
        if (r3 == null) goto L18;
        if (r3.equals(r4) == true) goto L12;
    L22:
        return false;
    L18:
        if (r4 != null) goto L22;
    L15:
        return false;
    L23:
        return true;
    }

    @Override // java.util.Map
    public Object get(Object r2) {
        return a(this.f343a, r2);
    }

    @Override // java.util.Map
    public int hashCode() {
        Iterator r0 = keySet().iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L13;
        Object r3 = r0.next();
        Object r4 = get(r3);
        if (r3 != null) goto L8;
        int r5 = 0;
    L9:
        if (r4 != null) goto L11;
        int r6 = 0;
    L12:
        r2 = r2 + (r5 ^ r6);
        goto L4
    L11:
        r6 = r4.hashCode();
        goto L12
    L8:
        r5 = r3.hashCode();
        goto L9
    L13:
        return r2;
    }

    @Override // java.util.Map
    public Object put(Object r2, Object r3) {
        return a(this.f343a, r2, r3);
    }

    @Override // java.util.Map
    public int size() {
        return keySet().size();
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer();
        r0.append('{');
        Iterator r1 = keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L8;
        Object r2 = r1.next();
        r0.append(r2);
        r0.append('=');
        r0.append(get(r2));
        if (r1.hasNext() == false) goto L4;
        r0.append(", ");
        goto L4
    L8:
        r0.append('}');
        return r0.toString();
    }
}
