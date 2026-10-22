package com.ctc.wstx.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    private static final char[] l = null;
    private static final String[] m = null;
    private static final char[] n = null;
    private static final String[] o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.ctc.wstx.a.b f3707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private char[] f3708b;
    private int c;
    private int d;
    private boolean e;
    private ArrayList<char[]> f;
    private int g;
    private char[] h;
    private int i;
    private String j;
    private char[] k;

    static {
        char[] r0 = "\n                                 ".toCharArray();
        l = r0;
        m = new String[r0.length];
        char[] r1 = "\n\t\t\t\t\t\t\t\t\t".toCharArray();
        n = r1;
        o = new String[r1.length];
    }

    private l(com.ctc.wstx.a.b r2) {
        this.e = false;
        this.f3707a = r2;
    }

    public static l a() {
        return new l(null);
    }

    public static l a(com.ctc.wstx.a.b r1) {
        return new l(r1);
    }

    private final char[] c(int r2) {
        int r3 = Math.max(r2, 500);
        com.ctc.wstx.a.b r1 = this.f3707a;
        if (r1 == null) goto L8;
        char[] r4 = r1.k(r3);
        if (r4 == null) goto L8;
        return r4;
    L8:
        return new char[r3];
    }

    private int d(int r1) {
        if (r1 >= 8000) goto L5;
        int r0 = r1;
    L7:
        return Math.min(r1 + r0, 262144);
    L5:
        r0 = r1 >> 1;
        goto L7
    }

    private void e(int r3) {
        if (this.f != null) goto L5;
        this.f = new ArrayList();
    L5:
        char[] r0 = this.h;
        this.e = true;
        this.f.add(r0);
        int r1 = r0.length;
        this.g += r1;
        char[] r4 = new char[Math.max(r3, d(r1))];
        this.i = 0;
        this.h = r4;
    }

    private final void m() {
        this.e = false;
        this.f.clear();
        this.g = 0;
        this.i = 0;
    }

    private char[] n() {
        String r0 = this.j;
        if (r0 != null) goto L5;
        int r1 = this.c;
        if (r1 < 0) goto L13;
        int r3 = this.d;
        if (r3 < 1) goto L11;
        char[] r2 = new char[r3];
        System.arraycopy(this.f3708b, r1, r2, 0, r3);
        return r2;
    L11:
        return c.a();
    L13:
        int r4 = d();
        if (r4 < 1) goto L16;
        char[] r5 = new char[r4];
        ArrayList<char[]> r6 = this.f;
        if (r6 == null) goto L22;
        int r7 = r6.size();
        int r8 = 0;
        int r9 = 0;
    L20:
        if (r8 >= r7) goto L23;
        char[] r10 = (char[]) ZeusTransformUtils.preCheckCast(this.f.get(r8), char[].class, "com.obric.memorydata.plugin");
        int r11 = r10.length;
        System.arraycopy(r10, 0, r5, r9, r11);
        r9 = r9 + r11;
        r8 = r8 + 1;
    L23:
        System.arraycopy(this.h, 0, r5, r9, this.i);
        return r5;
    L22:
        r9 = 0;
        goto L23
    L16:
        return c.a();
    L5:
        return r0.toCharArray();
    }

    public void a(char r4) {
        if (this.c < 0) goto L5;
        b(16);
    L5:
        this.j = null;
        this.k = null;
        char[] r0 = this.h;
        if (this.i < r0.length) goto L8;
        e(1);
        r0 = this.h;
    L8:
        int r1 = this.i;
        this.i = r1 + 1;
        r0[r1] = r4;
    }

    public void a(int r1) {
        this.i = r1;
    }

    public void a(int r4, char r5) {
        this.c = 0;
        int r1 = r4 + 1;
        this.d = r1;
        if (r5 != '\t') goto L7;
        this.f3708b = n;
        String[] r6 = o;
        String r2 = r6[r4];
        if (r2 != null) goto L10;
        r2 = "\n\t\t\t\t\t\t\t\t\t".substring(0, r1);
        r6[r4] = r2;
    L10:
        this.j = r2;
        this.k = null;
        ArrayList<char[]> r7 = this.f;
        if (r7 != null) goto L13;
        return;
    L13:
        if (r7.size() <= 0) goto L17;
        this.f.clear();
        this.g = 0;
        this.i = 0;
        return;
    L17:
        return;
    L7:
        this.f3708b = l;
        String[] r8 = m;
        r2 = r8[r4];
        if (r2 != null) goto L10;
        r2 = "\n                                 ".substring(0, r1);
        r8[r4] = r2;
        goto L10
    }

    public void a(com.ctc.wstx.d.m r3) {
        com.ctc.wstx.d.m r4 = (com.ctc.wstx.d.m) ZeusTransformUtils.wrapperContextForParams(r3, com.ctc.wstx.d.m.class, "com.obric.memorydata.plugin");
        char[] r0 = this.k;
        if (r0 == null) goto L5;
        r4.a(r0, 0, r0.length);
        return;
    L5:
        int r1 = this.c;
        if (r1 < 0) goto L8;
        r4.a(this.f3708b, r1, this.d);
        return;
    L8:
        ArrayList<char[]> r2 = this.f;
        if (r2 != null) goto L11;
    L13:
        r4.a(this.h, 0, this.i);
        return;
    L11:
        if (r2.size() <= 0) goto L13;
        char[] r5 = h();
        r4.a(r5, 0, r5.length);
    }

    public void a(org.codehaus.stax2.validation.g r3, boolean r4) {
        int r0 = this.c;
        if (r0 < 0) goto L5;
        r3.a(this.f3708b, r0, this.d + r0, r4);
        return;
    L5:
        r3.a(g(), r4);
    }

    public void a(boolean r2) {
        if (this.f3707a != null) goto L5;
        return;
    L5:
        if (this.h == null) goto L21;
        if (r2 == false) goto L9;
        b();
    L18:
        char[] r3 = this.h;
        this.h = null;
        this.f3707a.b(r3);
        return;
    L9:
        if (this.c < 0) goto L11;
    L13:
        ArrayList<char[]> r4 = this.f;
        if (r4 == null) goto L18;
        if (r4.size() <= 0) goto L18;
        this.f.clear();
        this.g = 0;
        goto L18
    L11:
        if ((this.g + this.i) <= 0) goto L13;
        return;
    }

    public void a(char[] r1, int r2, int r3) {
        this.f3708b = r1;
        this.c = r2;
        this.d = r3;
        this.j = null;
        this.k = null;
        if (this.e == false) goto L6;
        m();
        return;
    }

    public boolean a(String r8) {
        int r0 = r8.length();
        if (this.c < 0) goto L15;
        if (this.d == r0) goto L7;
        return false;
    L7:
        int r1 = 0;
    L8:
        if (r1 >= r0) goto L13;
        if (r8.charAt(r1) != this.f3708b[this.c + r1]) goto L11;
        r1 = r1 + 1;
        goto L8
    L11:
        return false;
    L13:
        return true;
    L15:
        if (r0 == d()) goto L17;
        return false;
    L17:
        ArrayList<char[]> r2 = this.f;
        if (r2 != null) goto L20;
    L23:
        char[] r7 = this.h;
    L24:
        int r3 = 0;
    L25:
        if (r3 >= r0) goto L30;
        if (r7[r3] != r8.charAt(r3)) goto L28;
        r3 = r3 + 1;
        goto L25
    L28:
        return false;
    L30:
        return true;
    L20:
        if (r2.size() == 0) goto L23;
        r7 = h();
        goto L24
    }

    public void b() {
        this.f3708b = null;
        this.c = -1;
        this.d = 0;
        this.j = null;
        this.k = null;
        if (this.e == false) goto L5;
        m();
    L5:
        this.i = 0;
    }

    public void b(int r6) {
        int r0 = this.d;
        this.d = 0;
        char[] r2 = this.f3708b;
        this.f3708b = null;
        int r3 = this.c;
        this.c = -1;
        int r7 = r6 + r0;
        char[] r4 = this.h;
        if (r4 != null) goto L5;
    L6:
        this.h = c(r7);
    L7:
        if (r0 <= 0) goto L9;
        System.arraycopy(r2, r3, this.h, 0, r0);
    L9:
        this.g = 0;
        this.i = r0;
        return;
    L5:
        if (r7 <= r4.length) goto L7;
        goto L6
    }

    public void b(char[] r3, int r4, int r5) {
        this.f3708b = null;
        this.c = -1;
        this.d = 0;
        this.j = null;
        this.k = null;
        if (this.e == false) goto L6;
        m();
    L6:
        if (this.h != null) goto L8;
        this.h = c(r5);
    L8:
        this.g = 0;
        this.i = 0;
        c(r3, r4, r5);
    }

    public void c() {
        b();
        if (this.h != null) goto L6;
        this.h = c(0);
        return;
    }

    public void c(char[] r4, int r5, int r6) {
        if (this.c < 0) goto L5;
        b(r6);
    L5:
        this.j = null;
        this.k = null;
        char[] r0 = this.h;
        int r1 = r0.length;
        int r2 = this.i;
        int r3 = r1 - r2;
        if (r3 < r6) goto L8;
        System.arraycopy(r4, r5, r0, r2, r6);
        this.i += r6;
        return;
    L8:
        if (r3 <= 0) goto L10;
        System.arraycopy(r4, r5, r0, r2, r3);
        r5 = r5 + r3;
        r6 = r6 - r3;
    L10:
        e(r6);
        System.arraycopy(r4, r5, this.h, 0, r6);
        this.i = r6;
    }

    public int d() {
        if (this.c < 0) goto L7;
        return this.d;
    L7:
        return this.g + this.i;
    }

    public int e() {
        int r0 = this.c;
        if (r0 >= 0) goto L7;
        return 0;
    L7:
        return r0;
    }

    public char[] f() {
        if (this.c >= 0) goto L5;
        ArrayList<char[]> r0 = this.f;
        if (r0 == null) goto L14;
        if (r0.size() == 0) goto L14;
        return h();
    L14:
        return this.h;
    L5:
        return this.f3708b;
    }

    public String g() {
        if (this.j != null) goto L28;
        if (this.k == null) goto L8;
        String r0 = new String(this.k);
    L7:
        this.j = r0;
        goto L28
    L8:
        String r1 = "";
        if (this.c >= 0) goto L11;
        int r2 = this.g;
        int r3 = this.i;
        if (r2 != 0) goto L21;
        if (r3 == 0) goto L20;
        r1 = new String(this.h, 0, r3);
    L20:
        this.j = r1;
        goto L28
    L21:
        StringBuilder r4 = new StringBuilder(r2 + r3);
        ArrayList<char[]> r5 = this.f;
        if (r5 == null) goto L26;
        int r6 = r5.size();
        int r7 = 0;
    L24:
        if (r7 >= r6) goto L26;
        char[] r8 = (char[]) ZeusTransformUtils.preCheckCast(this.f.get(r7), char[].class, "com.obric.memorydata.plugin");
        r4.append(r8, 0, r8.length);
        r7 = r7 + 1;
    L26:
        r4.append(this.h, 0, this.i);
        r0 = r4.toString();
        goto L7
    L11:
        if (this.d >= 1) goto L14;
        this.j = "";
        return "";
    L14:
        r0 = new String(this.f3708b, this.c, this.d);
    L28:
        return this.j;
    }

    public char[] h() {
        char[] r0 = this.k;
        if (r0 != null) goto L6;
        char[] r1 = n();
        this.k = r1;
        return r1;
    L6:
        return r0;
    }

    public void i() {
        if (this.c < 0) goto L6;
        b(16);
        return;
    }

    public char[] j() {
        if (this.c < 0) goto L5;
        b(1);
    L12:
        return this.h;
    L5:
        char[] r0 = this.h;
        if (r0 != null) goto L9;
        this.h = c(0);
        goto L12
    L9:
        if (this.i < r0.length) goto L12;
        e(1);
        goto L12
    }

    public int k() {
        return this.i;
    }

    public char[] l() {
        if (this.f != null) goto L5;
        this.f = new ArrayList();
    L5:
        this.e = true;
        this.f.add(this.h);
        int r0 = this.h.length;
        this.g += r0;
        char[] r1 = new char[d(r0)];
        this.i = 0;
        this.h = r1;
        return r1;
    }

    public String toString() {
        return g();
    }
}
