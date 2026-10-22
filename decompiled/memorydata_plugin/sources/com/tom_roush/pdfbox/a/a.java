package com.tom_roush.pdfbox.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class a extends b implements Iterable<b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<b> f16043a;

    public a() {
        this.f16043a = new ArrayList();
    }

    public int a(int r2, int r3) {
        if (r2 >= b()) goto L8;
        b r1 = this.f16043a.get(r2);
        if (ZeusTransformUtils.instanceOf(r1, k.class) == true) goto L7;
        return r3;
    L7:
        return ((k) ZeusTransformUtils.preCheckCast(r1, k.class, "com.obric.memorydata.plugin")).c();
    L8:
        return r3;
    }

    public b a(int r2) {
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f16043a.get(r2), b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, l.class) == false) goto L6;
        r1 = ((l) ZeusTransformUtils.preCheckCast(r1, l.class, "com.obric.memorydata.plugin")).a();
    L6:
        if (ZeusTransformUtils.instanceOf(r1, j.class) == false) goto L9;
        return null;
    L9:
        return r1;
    }

    public void a() {
        this.f16043a.clear();
    }

    public void a(int r1, b r2) {
        this.f16043a.add(r1, r2);
    }

    public void a(int r1, String r2) {
        b(r1, i.a(r2));
    }

    public void a(int r3, Collection<b> r4) {
        Collection<? extends b> r5 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.memorydata.plugin");
        this.f16043a.addAll(r3, r5);
    }

    public void a(b r1) {
        this.f16043a.add(r1);
    }

    public void a(com.tom_roush.pdfbox.pdmodel.common.c r3) {
        com.tom_roush.pdfbox.pdmodel.common.c r4 = (com.tom_roush.pdfbox.pdmodel.common.c) ZeusTransformUtils.wrapperContextForParams(r3, com.tom_roush.pdfbox.pdmodel.common.c.class, "com.obric.memorydata.plugin");
        this.f16043a.add(r4.e());
    }

    public void a(Collection<b> r3) {
        Collection<? extends b> r4 = (Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.memorydata.plugin");
        this.f16043a.addAll(r4);
    }

    public void a(float[] r5) {
        a();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        a(new f(r5[r1]));
        r1 = r1 + 1;
        goto L3
    }

    public int b() {
        return this.f16043a.size();
    }

    public b b(int r2) {
        return (b) ZeusTransformUtils.preCheckCast(this.f16043a.get(r2), b.class, "com.obric.memorydata.plugin");
    }

    public String b(int r2, String r3) {
        if (r2 >= b()) goto L8;
        b r1 = this.f16043a.get(r2);
        if (ZeusTransformUtils.instanceOf(r1, i.class) == true) goto L7;
        return r3;
    L7:
        return ((i) ZeusTransformUtils.preCheckCast(r1, i.class, "com.obric.memorydata.plugin")).a();
    L8:
        return r3;
    }

    public void b(int r1, b r2) {
        this.f16043a.set(r1, r2);
    }

    public boolean b(b r1) {
        return this.f16043a.remove(r1);
    }

    public int c(int r2) {
        return a(r2, -1);
    }

    public String c(int r2, String r3) {
        if (r2 >= b()) goto L8;
        b r1 = this.f16043a.get(r2);
        if (ZeusTransformUtils.instanceOf(r1, o.class) == true) goto L7;
        return r3;
    L7:
        return ((o) ZeusTransformUtils.preCheckCast(r1, o.class, "com.obric.memorydata.plugin")).a();
    L8:
        return r3;
    }

    public void c(int r2, b r3) {
    L3:
        if (b() >= r2) goto L5;
        a(r3);
        goto L3
    }

    public boolean c(b r6) {
        boolean r0 = b(r6);
        if (r0 == true) goto L14;
        int r1 = 0;
    L6:
        if (r1 >= b()) goto L14;
        b r2 = b(r1);
        if (ZeusTransformUtils.instanceOf(r2, l.class) == false) goto L13;
        if (((l) ZeusTransformUtils.preCheckCast(r2, l.class, "com.obric.memorydata.plugin")).a().equals(r6) == false) goto L13;
        return b(r2);
    L13:
        r1 = r1 + 1;
    L14:
        return r0;
    }

    public float[] c() {
        int r0 = b();
        float[] r1 = new float[r0];
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        b r3 = a(r2);
        if (ZeusTransformUtils.instanceOf(r3, k.class) == false) goto L7;
        float r4 = ((k) ZeusTransformUtils.preCheckCast(r3, k.class, "com.obric.memorydata.plugin")).a();
    L8:
        r1[r2] = r4;
        r2 = r2 + 1;
        goto L3
    L7:
        r4 = 0.0f;
        goto L8
    L9:
        return r1;
    }

    public int d(b r5) {
        int r0 = 0;
    L4:
        if (r0 >= b()) goto L18;
        b r1 = b(r0);
        if (r1 != null) goto L10;
        if (r1 != r5) goto L16;
        return r0;
    L16:
        r0 = r0 + 1;
        goto L4
    L10:
        if (r1.equals(r5) == true) goto L17;
        if (ZeusTransformUtils.instanceOf(r1, l.class) == false) goto L16;
        if (((l) ZeusTransformUtils.preCheckCast(r1, l.class, "com.obric.memorydata.plugin")).a().equals(r5) == false) goto L16;
    L17:
        return r0;
    L18:
        return -1;
    }

    public String d(int r2) {
        return b(r2, null);
    }

    public List<? extends b> d() {
        return new ArrayList(this.f16043a);
    }

    public String e(int r2) {
        return c(r2, null);
    }

    public b f(int r2) {
        return (b) ZeusTransformUtils.preCheckCast(this.f16043a.remove(r2), b.class, "com.obric.memorydata.plugin");
    }

    public void g(int r2) {
        c(r2, null);
    }

    @Override // java.lang.Iterable
    public Iterator<b> iterator() {
        return this.f16043a.iterator();
    }

    public String toString() {
        return "COSArray{" + this.f16043a + "}";
    }
}
