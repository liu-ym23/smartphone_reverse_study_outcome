package com.alibaba.excel.metadata.a;

import com.alibaba.excel.enums.HeadKindEnum;
import com.alibaba.excel.i.o;
import com.alibaba.excel.metadata.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f252a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Class<?> f253b;
    private HeadKindEnum c;
    private int d;
    private Map<Integer, k> e;

    static {
        f252a = org.slf4j.d.a(d.class);
    }

    public d(com.alibaba.excel.metadata.g r13, Class<?> r14, List<List<String>> r15) {
        com.alibaba.excel.metadata.g r16 = (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r13, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin");
        List r17 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        this.f253b = r14;
        this.e = new TreeMap();
        this.c = HeadKindEnum.NONE;
        int r18 = 0;
        this.d = 0;
        if (r17 != null) goto L5;
    L17:
        a(r16);
        f();
        org.slf4j.c r19 = f252a;
        if (r19.isDebugEnabled() == false) goto L24;
        r19.debug("The initialization sheet/table 'ExcelHeadProperty' is complete , head kind is {}", this.c);
        return;
    L24:
        return;
    L5:
        if (r17.isEmpty() == true) goto L17;
        int r0 = 0;
    L8:
        if (r18 >= r17.size()) goto L16;
        if (ZeusTransformUtils.instanceOf(r16, com.alibaba.excel.j.b.a.a.class) == true) goto L12;
    L14:
        this.e.put(Integer.valueOf(r0), new k(Integer.valueOf(r0), null, null, (List) ZeusTransformUtils.preCheckCast(r17.get(r18), List.class, "com.obric.memorydata.plugin"), Boolean.FALSE, Boolean.TRUE));
        r0 = r0 + 1;
    L15:
        r18 = r18 + 1;
        goto L8
    L12:
        if (((com.alibaba.excel.j.b.a.a) ZeusTransformUtils.preCheckCast(r16, com.alibaba.excel.j.b.a.a.class, "com.obric.memorydata.plugin")).a(null, Integer.valueOf(r18)) == false) goto L14;
    L16:
        this.c = HeadKindEnum.STRING;
        goto L17
    }

    private void a(int r9, com.alibaba.excel.metadata.i r10, Boolean r11) {
        ArrayList r4 = new ArrayList();
        boolean r1 = false;
        if (r10.c() != null) goto L5;
    L10:
        r1 = true;
    L12:
        if (this.e.containsKey(Integer.valueOf(r9)) == false) goto L14;
        r4.addAll(((k) ZeusTransformUtils.preCheckCast(this.e.get(Integer.valueOf(r9)), k.class, "com.obric.memorydata.plugin")).d());
    L17:
        this.e.put(Integer.valueOf(r9), new k(Integer.valueOf(r9), r10.a(), r10.b(), r4, r11, Boolean.valueOf(!r1)));
        return;
    L14:
        if (r1 == false) goto L16;
        r4.add(r10.b());
        goto L17
    L16:
        Collections.addAll(r4, r10.c());
        goto L17
    L5:
        if (r10.c().length == 0) goto L10;
        if (r10.c().length != 1) goto L12;
        if (o.a(r10.c()[0]) == false) goto L12;
        goto L10
    }

    private void a(com.alibaba.excel.metadata.g r7) {
        com.alibaba.excel.metadata.g r8 = (com.alibaba.excel.metadata.g) ZeusTransformUtils.wrapperContextForParams(r7, com.alibaba.excel.metadata.g.class, "com.obric.memorydata.plugin");
        Class<?> r0 = this.f253b;
        if (r0 != null) goto L5;
        return;
    L5:
        com.alibaba.excel.metadata.h r9 = com.alibaba.excel.i.c.a(r0, r8);
        Iterator<Map.Entry<Integer, com.alibaba.excel.metadata.i>> r1 = r9.a().entrySet().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        a(((Integer) ZeusTransformUtils.preCheckCast(r2.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue(), (com.alibaba.excel.metadata.i) ZeusTransformUtils.preCheckCast(r2.getValue(), com.alibaba.excel.metadata.i.class, "com.obric.memorydata.plugin"), Boolean.valueOf(r9.b().containsKey(r2.getKey())));
        goto L7
    L9:
        this.c = HeadKindEnum.CLASS;
    }

    private void f() {
        this.d = 0;
        Iterator<k> r1 = this.e.values().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        List<String> r2 = ((k) ZeusTransformUtils.preCheckCast(r1.next(), k.class, "com.obric.memorydata.plugin")).d();
        if (r2 == null) goto L4;
        if (r2.size() <= this.d) goto L4;
        this.d = r2.size();
        goto L4
    L10:
        Iterator<k> r3 = this.e.values().iterator();
    L12:
        if (r3.hasNext() == false) goto L22;
        List<String> r4 = ((k) ZeusTransformUtils.preCheckCast(r3.next(), k.class, "com.obric.memorydata.plugin")).d();
        if (r4 == null) goto L12;
        if (r4.isEmpty() == true) goto L12;
        int r5 = r4.size();
        int r6 = this.d;
        if (r5 >= r6) goto L12;
        int r7 = r6 - r4.size();
        int r8 = r4.size() - 1;
        int r9 = 0;
    L20:
        if (r9 >= r7) goto L12;
        r4.add(r4.get(r8));
        r9 = r9 + 1;
        goto L20
    }

    public void a(Map<Integer, k> r3) {
        this.e = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public boolean a() {
        if (this.c == HeadKindEnum.NONE) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean a(Object r1) {
        return ZeusTransformUtils.instanceOf(r1, d.class);
    }

    public Class<?> b() {
        return this.f253b;
    }

    public HeadKindEnum c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public Map<Integer, k> e() {
        return this.e;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
        return false;
    L8:
        d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.memorydata.plugin");
        if (r6.a(this) == true) goto L12;
        return false;
    L12:
        if (d() == r6.d()) goto L14;
        return false;
    L14:
        Class<?> r0 = b();
        Class<?> r2 = r6.b();
        if (r0 != null) goto L19;
        if (r2 != null) goto L20;
    L21:
        HeadKindEnum r1 = c();
        HeadKindEnum r3 = r6.c();
        if (r1 != null) goto L26;
        if (r3 != null) goto L27;
    L28:
        Map<Integer, k> r4 = e();
        Map<Integer, k> r7 = r6.e();
        if (r4 != null) goto L33;
        if (r7 != null) goto L34;
    L35:
        return true;
    L34:
        return false;
    L33:
        if (r4.equals(r7) == true) goto L35;
    L27:
        return false;
    L26:
        if (r1.equals(r3) == true) goto L28;
    L20:
        return false;
    L19:
        if (r0.equals(r2) == true) goto L21;
        goto L20
    }

    public int hashCode() {
        int r0 = d() + 59;
        Class<?> r2 = b();
        int r1 = r0 * 59;
        int r3 = 43;
        if (r2 != null) goto L5;
        int r4 = 43;
    L6:
        int r5 = r1 + r4;
        HeadKindEnum r6 = c();
        int r7 = r5 * 59;
        if (r6 != null) goto L9;
        int r8 = 43;
    L10:
        Map<Integer, k> r9 = e();
        int r10 = (r7 + r8) * 59;
        if (r9 == null) goto L15;
        r3 = r9.hashCode();
    L15:
        return r10 + r3;
    L9:
        r8 = r6.hashCode();
        goto L10
    L5:
        r4 = r2.hashCode();
        goto L6
    }
}
