package com.tom_roush.fontbox.c;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f15953a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15954b;
    private String c;
    private int d;
    private String e;
    private String f;
    private int g;
    private int h;
    private int i;
    private final List<d> j;
    private final Map<Integer, String> k;
    private final Map<String, byte[]> l;
    private final Map<Integer, Integer> m;
    private final List<a> n;
    private int o;

    b() {
        this.f15953a = 0;
        this.f15954b = null;
        this.c = null;
        this.d = -1;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.h = 4;
        this.j = new ArrayList();
        this.k = new HashMap();
        this.l = new HashMap();
        this.m = new HashMap();
        this.n = new ArrayList();
        this.o = -1;
    }

    static int a(byte[] r3, int r4) {
        int r0 = 0;
        int r1 = 0;
    L3:
        if (r0 >= r4) goto L5;
        r1 = (r1 << 8) | (r3[r0] & 255);
        r0 = r0 + 1;
        goto L3
    L5:
        return r1;
    }

    private int a(byte[] r3, int r4, int r5) {
        int r2 = 0;
        int r0 = 0;
    L3:
        if (r2 >= r5) goto L5;
        r0 = (r0 << 8) | ((r3[r4 + r2] + 256) % 256);
        r2 = r2 + 1;
        goto L3
    L5:
        return r0;
    }

    public int a(InputStream r9) {
        byte[] r0 = new byte[this.i];
        r9.read(r0, 0, this.h);
        r9.mark(this.i);
        int r1 = this.h - 1;
    L4:
        if (r1 >= this.i) goto L15;
        r1 = r1 + 1;
        Iterator<d> r4 = this.j.iterator();
    L7:
        if (r4.hasNext() == false) goto L13;
        if (((d) ZeusTransformUtils.preCheckCast(r4.next(), d.class, "com.obric.memorydata.plugin")).a(r0, r1) == false) goto L7;
        return a(r0, r1);
    L13:
        if (r1 >= this.i) goto L4;
        r0[r1] = (byte) r9.read();
        goto L4
    L15:
        StringBuilder r2 = new StringBuilder();
        int r5 = 0;
    L17:
        if (r5 >= this.i) goto L19;
        r2.append(String.format("0x%02X (%04o) ", new Object[]{Byte.valueOf(r0[r5]), Byte.valueOf(r0[r5])}));
        r5 = r5 + 1;
        goto L17
    L19:
        Log.w("PdfBox-Android", "Invalid character code sequence " + r2 + "in CMap " + this.f15954b);
        if (r9.markSupported() == false) goto L22;
        r9.reset();
    L24:
        return a(r0, this.h);
    L22:
        Log.w("PdfBox-Android", "mark() and reset() not supported, " + (this.i - 1) + " bytes have been skipped");
        goto L24
    }

    public String a(int r2) {
        return (String) ZeusTransformUtils.preCheckCast(this.k.get(Integer.valueOf(r2)), String.class, "com.obric.memorydata.plugin");
    }

    void a(char r4, char r5, int r6) {
        if (this.n.isEmpty() == true) goto L5;
        List<a> r0 = this.n;
        a r1 = (a) ZeusTransformUtils.preCheckCast(r0.get(r0.size() - 1), a.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L8;
    L9:
        this.n.add(new a(r4, r5, r6));
        return;
    L8:
        if (r1.a(r4, r5, r6) == false) goto L9;
        return;
    L5:
        r1 = null;
        goto L6
    }

    void a(int r1, int r2) {
        this.m.put(Integer.valueOf(r2), Integer.valueOf(r1));
    }

    void a(b r5) {
        Iterator<d> r0 = r5.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        a((d) ZeusTransformUtils.preCheckCast(r0.next(), d.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        this.k.putAll(r5.k);
        this.m.putAll(r5.m);
        this.n.addAll(r5.n);
    }

    void a(d r3) {
        this.j.add(r3);
        this.i = Math.max(this.i, r3.a());
        this.h = Math.min(this.h, r3.a());
    }

    public void a(String r1) {
        this.f15954b = r1;
    }

    void a(byte[] r3, String r4) {
        this.l.put(r4, (byte[]) r3.clone());
        int r5 = a(r3, 0, r3.length);
        this.k.put(Integer.valueOf(r5), r4);
        if (" ".equals(r4) == false) goto L6;
        this.o = r5;
        return;
    }

    public boolean a() {
        if (this.m.isEmpty() == true) goto L5;
    L8:
        return true;
    L5:
        if (this.n.isEmpty() == false) goto L8;
        return false;
    }

    public int b(int r4) {
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.m.get(Integer.valueOf(r4)), Integer.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        Iterator<a> r3 = this.n.iterator();
    L8:
        if (r3.hasNext() == false) goto L12;
        int r1 = ((a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin")).a((char) r4);
        if (r1 == (-1)) goto L8;
        return r1;
    L12:
        return 0;
    L5:
        return r0.intValue();
    }

    public void b(String r1) {
        this.c = r1;
    }

    public boolean b() {
        return !this.k.isEmpty();
    }

    public int c() {
        return this.f15953a;
    }

    public void c(int r1) {
        this.f15953a = r1;
    }

    public void c(String r1) {
        this.e = r1;
    }

    public String d() {
        return this.f15954b;
    }

    public void d(int r1) {
        this.d = r1;
    }

    public void d(String r1) {
        this.f = r1;
    }

    public String e() {
        return this.e;
    }

    public void e(int r1) {
        this.g = r1;
    }

    public String f() {
        return this.f;
    }

    public int g() {
        return this.o;
    }

    public int getType() {
        return this.d;
    }

    public String toString() {
        return this.f15954b;
    }
}
