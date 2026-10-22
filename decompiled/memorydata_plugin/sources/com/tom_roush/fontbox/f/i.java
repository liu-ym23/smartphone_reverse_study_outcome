package com.tom_roush.fontbox.f;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class i extends af {
    private LinkedHashMap<String, n> c;
    private d[] d;
    private C0849i[] e;
    private final Map<Integer, Integer> f;
    private final Map<Integer, Integer> g;
    private String h;

    static abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15991a;

        a() {
        }

        abstract int a(int r1);
    }

    static class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int[] f15992b;

        b() {
        }

        @Override // com.tom_roush.fontbox.f.i.a
        int a(int r1) {
            return Arrays.binarySearch(this.f15992b, r1);
        }

        public String toString() {
            return String.format("CoverageTableFormat1[coverageFormat=%d,glyphArray=%s]", new Object[]{Integer.valueOf(this.f15991a), Arrays.toString(this.f15992b)});
        }
    }

    static class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        l[] f15993b;

        c() {
        }

        @Override // com.tom_roush.fontbox.f.i.a
        int a(int r5) {
            l[] r4 = this.f15993b;
            int r0 = r4.length;
            int r1 = 0;
        L3:
            if (r1 >= r0) goto L11;
            l r2 = r4[r1];
            if (r2.f16005a > r5) goto L10;
            if (r5 > r2.f16006b) goto L10;
            return (r2.c + r5) - r2.f16005a;
        L10:
            r1 = r1 + 1;
            goto L3
        L11:
            return -1;
        }

        public String toString() {
            return String.format("CoverageTableFormat2[coverageFormat=%d]", new Object[]{Integer.valueOf(this.f15991a)});
        }
    }

    static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        e f15995b;

        d() {
        }

        public String toString() {
            return String.format("FeatureRecord[featureTag=%s]", new Object[]{this.f15994a});
        }
    }

    static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int[] f15996a;

        e() {
        }

        public String toString() {
            return String.format("FeatureTable[lookupListIndiciesCount=%d]", new Object[]{Integer.valueOf(this.f15996a.length)});
        }
    }

    static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15997a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        g f15998b;

        f() {
        }

        public String toString() {
            return String.format("LangSysRecord[langSysTag=%s]", new Object[]{this.f15997a});
        }
    }

    static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15999a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int[] f16000b;

        g() {
        }

        public String toString() {
            return String.format("LangSysTable[requiredFeatureIndex=%d]", new Object[]{Integer.valueOf(this.f15999a)});
        }
    }

    static abstract class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        a f16002b;

        h() {
        }

        abstract int a(int r1, int r2);
    }

    /* JADX INFO: renamed from: com.tom_roush.fontbox.f.i$i, reason: collision with other inner class name */
    static class C0849i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f16004b;
        int c;
        h[] d;

        C0849i() {
        }

        public String toString() {
            return String.format("LookupTable[lookupType=%d,lookupFlag=%d,markFilteringSet=%d]", new Object[]{Integer.valueOf(this.f16003a), Integer.valueOf(this.f16004b), Integer.valueOf(this.c)});
        }
    }

    static class j extends h {
        short c;

        j() {
        }

        @Override // com.tom_roush.fontbox.f.i.h
        int a(int r1, int r2) {
            if (r2 >= 0) goto L5;
            return r1;
        L5:
            return r1 + this.c;
        }

        public String toString() {
            return String.format("LookupTypeSingleSubstFormat1[substFormat=%d,deltaGlyphID=%d]", new Object[]{Integer.valueOf(this.f16001a), Short.valueOf(this.c)});
        }
    }

    static class k extends h {
        int[] c;

        k() {
        }

        @Override // com.tom_roush.fontbox.f.i.h
        int a(int r1, int r2) {
            if (r2 >= 0) goto L5;
            return r1;
        L5:
            return this.c[r2];
        }

        public String toString() {
            return String.format("LookupTypeSingleSubstFormat2[substFormat=%d,substituteGlyphIDs=%s]", new Object[]{Integer.valueOf(this.f16001a), Arrays.toString(this.c)});
        }
    }

    static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f16006b;
        int c;

        l() {
        }

        public String toString() {
            return String.format("RangeRecord[startGlyphID=%d,endGlyphID=%d,startCoverageIndex=%d]", new Object[]{Integer.valueOf(this.f16005a), Integer.valueOf(this.f16006b), Integer.valueOf(this.c)});
        }
    }

    static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f16007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        n f16008b;

        m() {
        }

        public String toString() {
            return String.format("ScriptRecord[scriptTag=%s]", new Object[]{this.f16007a});
        }
    }

    static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        g f16009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        LinkedHashMap<String, g> f16010b;

        n() {
        }

        public String toString() {
            Object[] r0 = new Object[2];
            if (this.f16009a == null) goto L5;
            boolean r1 = true;
        L6:
            r0[0] = Boolean.valueOf(r1);
            r0[1] = Integer.valueOf(this.f16010b.size());
            return String.format("ScriptTable[hasDefault=%s,langSysRecordsCount=%d]", r0);
        L5:
            r1 = false;
            goto L6
        }
    }

    i(ah r1) {
        super(r1);
        this.f = new HashMap();
        this.g = new HashMap();
    }

    private int a(d r7, int r8) {
        int[] r0 = r7.f15995b.f15996a;
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L9;
        C0849i r3 = this.e[r0[r2]];
        if (r3.f16003a == 1) goto L7;
        Log.d("PdfBox-Android", "Skipping GSUB feature '" + r7.f15994a + "' because it requires unsupported lookup table type " + r3.f16003a);
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        r8 = a(r3, r8);
        goto L8
    L9:
        return r8;
    }

    private int a(C0849i r4, int r5) {
        h[] r3 = r4.d;
        int r6 = r3.length;
        int r0 = 0;
    L3:
        if (r0 >= r6) goto L9;
        h r1 = r3[r0];
        int r2 = r1.f16002b.a(r5);
        if (r2 >= 0) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return r1.a(r5, r2);
    L9:
        return r5;
    }

    private String a(String[] r6) {
        if (r6.length != 1) goto L15;
        String r0 = r6[0];
        if ("Inherited".equals(r0) == true) goto L11;
        if ("DFLT".equals(r0) == false) goto L15;
        if (this.c.containsKey(r0) == true) goto L15;
    L11:
        if (this.h != null) goto L14;
        this.h = (String) ZeusTransformUtils.preCheckCast(this.c.keySet().iterator().next(), String.class, "com.obric.memorydata.plugin");
    L14:
        return this.h;
    L15:
        int r1 = r6.length;
        int r2 = 0;
    L16:
        if (r2 >= r1) goto L23;
        String r3 = r6[r2];
        if (this.c.containsKey(r3) == true) goto L19;
        r2 = r2 + 1;
        goto L16
    L19:
        this.h = r3;
        return r3;
    L23:
        return r6[0];
    }

    private List<d> a(Collection<g> r9, List<String> r10) {
        Collection r11 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.memorydata.plugin");
        final List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        if (r11.isEmpty() == true) goto L5;
        ArrayList r0 = new ArrayList();
        Iterator r13 = r11.iterator();
    L8:
        if (r13.hasNext() == false) goto L24;
        g r2 = (g) ZeusTransformUtils.preCheckCast(r13.next(), g.class, "com.obric.memorydata.plugin");
        int r3 = r2.f15999a;
        if (r3 == 65535) goto L14;
        d[] r4 = this.d;
        if (r3 >= r4.length) goto L14;
        r0.add(r4[r3]);
    L14:
        int[] r5 = r2.f16000b;
        int r6 = r5.length;
        int r7 = 0;
    L15:
        if (r7 >= r6) goto L8;
        int r8 = r5[r7];
        d[] r14 = this.d;
        if (r8 >= r14.length) goto L22;
        if (r12 != null) goto L20;
    L21:
        r0.add(this.d[r8]);
        goto L22
    L20:
        if (r12.contains(r14[r8].f15994a) == true) goto L21;
    L22:
        r7 = r7 + 1;
        goto L15
    L24:
        if (a(r0, "vrt2") == false) goto L26;
        b(r0, "vert");
    L26:
        if (r12 != null) goto L28;
    L30:
        return r0;
    L28:
        if (r0.size() <= 1) goto L30;
        Collections.sort(r0, new AnonymousClass1(this, r12));
        goto L30
    L5:
        return Collections.emptyList();
    }

    private boolean a(List<d> r3, String r4) {
        Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (((d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.memorydata.plugin")).f15994a.equals(r4) == false) goto L4;
        return true;
    L9:
        return false;
    }

    private Collection<g> b(String r3) {
        List r0 = Collections.emptyList();
        n r2 = (n) ZeusTransformUtils.preCheckCast(this.c.get(r3), n.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
        return r0;
    L5:
        if (r2.f16009a == null) goto L10;
        ArrayList r1 = new ArrayList(r2.f16010b.values());
        r1.add(r2.f16009a);
        return r1;
    L10:
        return r2.f16010b.values();
    }

    private void b(List<d> r3, String r4) {
        Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        if (((d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.memorydata.plugin")).f15994a.equals(r4) == false) goto L4;
        r2.remove();
        goto L4
    }

    public int a(int r3) {
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(this.g.get(Integer.valueOf(r3)), Integer.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        Log.w("PdfBox-Android", "Trying to un-substitute a never-before-seen gid: " + r3);
        return r3;
    L7:
        return r2.intValue();
    }

    public int a(int r4, String[] r5, List<String> r6) {
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        if (r4 != (-1)) goto L5;
        return -1;
    L5:
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(this.f.get(Integer.valueOf(r4)), Integer.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        Iterator<d> r8 = a(b(a(r5)), r7).iterator();
        int r9 = r4;
    L11:
        if (r8.hasNext() == false) goto L13;
        r9 = a((d) ZeusTransformUtils.preCheckCast(r8.next(), d.class, "com.obric.memorydata.plugin"), r9);
        goto L11
    L13:
        this.f.put(Integer.valueOf(r4), Integer.valueOf(r9));
        this.g.put(Integer.valueOf(r9), Integer.valueOf(r4));
        return r9;
    L8:
        return r0.intValue();
    }

    l a(ad r2) {
        l r1 = new l();
        r1.f16005a = r2.d();
        r1.f16006b = r2.d();
        r1.c = r2.d();
        return r1;
    }

    LinkedHashMap<String, n> a(ad r9, long r10) {
        r9.a(r10);
        int r0 = r9.d();
        m[] r1 = new m[r0];
        int[] r2 = new int[r0];
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r0) goto L5;
        m r5 = new m();
        r5.f16007a = r9.a(4);
        r2[r4] = r9.d();
        r1[r4] = r5;
        r4 = r4 + 1;
        goto L3
    L5:
        int r6 = 0;
    L6:
        if (r6 >= r0) goto L8;
        r1[r6].f16008b = b(r9, ((long) r2[r6]) + r10);
        r6 = r6 + 1;
        goto L6
    L8:
        LinkedHashMap<String, n> r8 = new LinkedHashMap(r0);
    L9:
        if (r3 >= r0) goto L11;
        m r11 = r1[r3];
        r8.put(r11.f16007a, r11.f16008b);
        r3 = r3 + 1;
        goto L9
    L11:
        return r8;
    }

    @Override // com.tom_roush.fontbox.f.af
    void a(ah r10, ad r11) {
        long r0 = r11.f();
        r11.d();
        int r12 = r11.d();
        int r2 = r11.d();
        int r3 = r11.d();
        int r4 = r11.d();
        if (r12 != 1) goto L5;
        r11.k();
    L5:
        this.c = a(r11, ((long) r2) + r0);
        this.d = d(r11, ((long) r3) + r0);
        this.e = f(r11, r0 + ((long) r4));
    }

    n b(ad r11, long r12) {
        r11.a(r12);
        n r0 = new n();
        int r1 = r11.d();
        int r2 = r11.d();
        f[] r3 = new f[r2];
        int[] r4 = new int[r2];
        int r5 = 0;
        String r6 = "";
        int r7 = 0;
    L3:
        if (r7 >= r2) goto L12;
        f r8 = new f();
        r8.f15997a = r11.a(4);
        if (r7 <= 0) goto L11;
        if (r8.f15997a.compareTo(r6) > 0) goto L11;
        throw new IOException("LangSysRecords not alphabetically sorted by LangSys tag: " + r8.f15997a + " <= " + r6);
    L11:
        r4[r7] = r11.d();
        r3[r7] = r8;
        r6 = r8.f15997a;
        r7 = r7 + 1;
        goto L3
    L12:
        if (r1 == 0) goto L14;
        r0.f16009a = c(r11, ((long) r1) + r12);
    L14:
        int r9 = 0;
    L15:
        if (r9 >= r2) goto L17;
        r3[r9].f15998b = c(r11, ((long) r4[r9]) + r12);
        r9 = r9 + 1;
        goto L15
    L17:
        r0.f16010b = new LinkedHashMap(r2);
    L18:
        if (r5 >= r2) goto L20;
        f r10 = r3[r5];
        r0.f16010b.put(r10.f15997a, r10.f15998b);
        r5 = r5 + 1;
        goto L18
    L20:
        return r0;
    }

    g c(ad r3, long r4) {
        r3.a(r4);
        g r2 = new g();
        r3.d();
        r2.f15999a = r3.d();
        int r5 = r3.d();
        r2.f16000b = new int[r5];
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L5;
        r2.f16000b[r6] = r3.d();
        r6 = r6 + 1;
        goto L3
    L5:
        return r2;
    }

    d[] d(ad r13, long r14) {
        r13.a(r14);
        int r0 = r13.d();
        d[] r1 = new d[r0];
        int[] r2 = new int[r0];
        int r3 = 0;
        String r4 = "";
        int r5 = 0;
    L3:
        if (r5 >= r0) goto L16;
        d r6 = new d();
        r6.f15994a = r13.a(4);
        if (r5 <= 0) goto L15;
        if (r6.f15994a.compareTo(r4) >= 0) goto L15;
        if (r6.f15994a.matches("\\w{4}") == false) goto L13;
        if (r4.matches("\\w{4}") == false) goto L13;
        Log.d("PdfBox-Android", "FeatureRecord array not alphabetically sorted by FeatureTag: " + r6.f15994a + " < " + r4);
    L13:
        Log.w("PdfBox-Android", "FeatureRecord array not alphabetically sorted by FeatureTag: " + r6.f15994a + " < " + r4);
        return new d[0];
    L15:
        r2[r5] = r13.d();
        r1[r5] = r6;
        r4 = r6.f15994a;
        r5 = r5 + 1;
    L16:
        if (r3 >= r0) goto L18;
        r1[r3].f15995b = e(r13, ((long) r2[r3]) + r14);
        r3 = r3 + 1;
        goto L16
    L18:
        return r1;
    }

    e e(ad r3, long r4) {
        r3.a(r4);
        e r2 = new e();
        r3.d();
        int r5 = r3.d();
        r2.f15996a = new int[r5];
        int r6 = 0;
    L3:
        if (r6 >= r5) goto L5;
        r2.f15996a[r6] = r3.d();
        r6 = r6 + 1;
        goto L3
    L5:
        return r2;
    }

    C0849i[] f(ad r7, long r8) {
        r7.a(r8);
        int r0 = r7.d();
        int[] r1 = new int[r0];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r1[r3] = r7.d();
        r3 = r3 + 1;
        goto L3
    L5:
        C0849i[] r4 = new C0849i[r0];
    L6:
        if (r2 >= r0) goto L8;
        r4[r2] = g(r7, ((long) r1[r2]) + r8);
        r2 = r2 + 1;
        goto L6
    L8:
        return r4;
    }

    C0849i g(ad r8, long r9) {
        r8.a(r9);
        C0849i r0 = new C0849i();
        r0.f16003a = r8.d();
        r0.f16004b = r8.d();
        int r1 = r8.d();
        int[] r2 = new int[r1];
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r4 >= r1) goto L6;
        r2[r4] = r8.d();
        r4 = r4 + 1;
        goto L3
    L6:
        if ((r0.f16004b & 16) == 0) goto L8;
        r0.c = r8.d();
    L8:
        r0.d = new h[r1];
        if (r0.f16003a == 1) goto L11;
        Log.d("PdfBox-Android", "Type " + r0.f16003a + " GSUB lookup table is not supported and will be ignored");
    L13:
        return r0;
    L11:
        if (r3 >= r1) goto L13;
        r0.d[r3] = h(r8, ((long) r2[r3]) + r9);
        r3 = r3 + 1;
        goto L11
    }

    h h(ad r7, long r8) {
        r7.a(r8);
        int r0 = r7.d();
        if (r0 != 1) goto L5;
        j r1 = new j();
        r1.f16001a = r0;
        int r2 = r7.d();
        r1.c = r7.e();
        r1.f16002b = i(r7, r8 + ((long) r2));
        return r1;
    L5:
        if (r0 != 2) goto L12;
        k r3 = new k();
        r3.f16001a = r0;
        int r4 = r7.d();
        int r5 = r7.d();
        r3.c = new int[r5];
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L9;
        r3.c[r6] = r7.d();
        r6 = r6 + 1;
        goto L7
    L9:
        r3.f16002b = i(r7, r8 + ((long) r4));
        return r3;
    L12:
        throw new IOException("Unknown substFormat: " + r0);
    }

    a i(ad r4, long r5) {
        r4.a(r5);
        int r6 = r4.d();
        int r7 = 0;
        if (r6 != 1) goto L5;
        b r3 = new b();
        r3.f15991a = r6;
        int r8 = r4.d();
        r3.f15992b = new int[r8];
    L13:
        if (r7 >= r8) goto L15;
        r3.f15992b[r7] = r4.d();
        r7 = r7 + 1;
        goto L13
    L15:
        return r3;
    L5:
        if (r6 != 2) goto L11;
        c r0 = new c();
        r0.f15991a = r6;
        int r9 = r4.d();
        r0.f15993b = new l[r9];
    L7:
        if (r7 >= r9) goto L9;
        r0.f15993b[r7] = a(r4);
        r7 = r7 + 1;
        goto L7
    L9:
        return r0;
    L11:
        throw new IOException("Unknown coverage format: " + r6);
    }
}
