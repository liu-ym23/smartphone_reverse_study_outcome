package com.tom_roush.fontbox.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<a, String> f15937a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<a, String> f15938b = null;
    private a c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int[] f15939a;

        public a(int r3) {
            this.f15939a = null;
            a(new int[]{r3});
        }

        public a(int r3, int r4) {
            this.f15939a = null;
            a(new int[]{r3, r4});
        }

        public a(int[] r2) {
            this.f15939a = null;
            a(r2);
        }

        private void a(int[] r1) {
            this.f15939a = r1;
        }

        public int[] a() {
            return this.f15939a;
        }

        public boolean equals(Object r6) {
            if (ZeusTransformUtils.instanceOf(r6, a.class) == false) goto L26;
            a r7 = (a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.memorydata.plugin");
            int[] r5 = this.f15939a;
            if (r5[0] != 12) goto L21;
            int[] r0 = r7.f15939a;
            if (r0[0] != 12) goto L21;
            if (r5.length <= 1) goto L17;
            if (r0.length <= 1) goto L17;
            if (r5[1] == r0[1]) goto L15;
            return false;
        L15:
            return true;
        L17:
            if (r5.length == r0.length) goto L19;
            return false;
        L19:
            return true;
        L21:
            if (r5[0] == r7.f15939a[0]) goto L23;
            return false;
        L23:
            return true;
        L26:
            return false;
        }

        public int hashCode() {
            int[] r3 = this.f15939a;
            if (r3[0] != 12) goto L9;
            if (r3.length <= 1) goto L9;
            int r0 = r3[0];
            return r3[1] ^ r0;
        L9:
            return r3[0];
        }

        public String toString() {
            return Arrays.toString(a());
        }
    }

    static {
        LinkedHashMap r0 = new LinkedHashMap(26);
        r0.put(new a(1), "hstem");
        r0.put(new a(3), "vstem");
        r0.put(new a(4), "vmoveto");
        r0.put(new a(5), "rlineto");
        r0.put(new a(6), "hlineto");
        r0.put(new a(7), "vlineto");
        r0.put(new a(8), "rrcurveto");
        r0.put(new a(9), "closepath");
        r0.put(new a(10), "callsubr");
        r0.put(new a(11), "return");
        r0.put(new a(12), "escape");
        r0.put(new a(12, 0), "dotsection");
        r0.put(new a(12, 1), "vstem3");
        r0.put(new a(12, 2), "hstem3");
        r0.put(new a(12, 6), "seac");
        r0.put(new a(12, 7), "sbw");
        r0.put(new a(12, 12), "div");
        r0.put(new a(12, 16), "callothersubr");
        r0.put(new a(12, 17), "pop");
        r0.put(new a(12, 33), "setcurrentpoint");
        r0.put(new a(13), "hsbw");
        r0.put(new a(14), "endchar");
        r0.put(new a(21), "rmoveto");
        r0.put(new a(22), "hmoveto");
        r0.put(new a(30), "vhcurveto");
        r0.put(new a(31), "hvcurveto");
        f15937a = Collections.unmodifiableMap(r0);
        LinkedHashMap r1 = new LinkedHashMap(48);
        r1.put(new a(1), "hstem");
        r1.put(new a(3), "vstem");
        r1.put(new a(4), "vmoveto");
        r1.put(new a(5), "rlineto");
        r1.put(new a(6), "hlineto");
        r1.put(new a(7), "vlineto");
        r1.put(new a(8), "rrcurveto");
        r1.put(new a(10), "callsubr");
        r1.put(new a(11), "return");
        r1.put(new a(12), "escape");
        r1.put(new a(12, 3), "and");
        r1.put(new a(12, 4), "or");
        r1.put(new a(12, 5), "not");
        r1.put(new a(12, 9), "abs");
        r1.put(new a(12, 10), "add");
        r1.put(new a(12, 11), "sub");
        r1.put(new a(12, 12), "div");
        r1.put(new a(12, 14), "neg");
        r1.put(new a(12, 15), "eq");
        r1.put(new a(12, 18), "drop");
        r1.put(new a(12, 20), "put");
        r1.put(new a(12, 21), "get");
        r1.put(new a(12, 22), "ifelse");
        r1.put(new a(12, 23), "random");
        r1.put(new a(12, 24), "mul");
        r1.put(new a(12, 26), "sqrt");
        r1.put(new a(12, 27), "dup");
        r1.put(new a(12, 28), "exch");
        r1.put(new a(12, 29), "index");
        r1.put(new a(12, 30), "roll");
        r1.put(new a(12, 34), "hflex");
        r1.put(new a(12, 35), "flex");
        r1.put(new a(12, 36), "hflex1");
        r1.put(new a(12, 37), "flex1");
        r1.put(new a(14), "endchar");
        r1.put(new a(18), "hstemhm");
        r1.put(new a(19), "hintmask");
        r1.put(new a(20), "cntrmask");
        r1.put(new a(21), "rmoveto");
        r1.put(new a(22), "hmoveto");
        r1.put(new a(23), "vstemhm");
        r1.put(new a(24), "rcurveline");
        r1.put(new a(25), "rlinecurve");
        r1.put(new a(26), "vvcurveto");
        r1.put(new a(27), "hhcurveto");
        r1.put(new a(28), "shortint");
        r1.put(new a(29), "callgsubr");
        r1.put(new a(30), "vhcurveto");
        r1.put(new a(31), "hvcurveto");
        f15938b = Collections.unmodifiableMap(r1);
    }

    public p(int r2) {
        this.c = null;
        a(new a(r2));
    }

    public p(int r2, int r3) {
        this.c = null;
        a(new a(r2, r3));
    }

    public p(int[] r2) {
        this.c = null;
        a(new a(r2));
    }

    private void a(a r1) {
        this.c = r1;
    }

    public a a() {
        return this.c;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, p.class) == false) goto L6;
        p r4 = (p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin");
        return a().equals(r4.a());
    L6:
        return false;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public String toString() {
        String r0 = (String) ZeusTransformUtils.preCheckCast(f15938b.get(a()), String.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        r0 = (String) ZeusTransformUtils.preCheckCast(f15937a.get(a()), String.class, "com.obric.memorydata.plugin");
    L6:
        if (r0 != null) goto L10;
        StringBuilder r3 = new StringBuilder().append(a().toString());
    L9:
        return r3.append('|').toString();
    L10:
        r3 = new StringBuilder().append(r0);
        goto L9
    }
}
