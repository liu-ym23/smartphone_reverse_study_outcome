package org.jsoup.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.jsoup.nodes.Element;

/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<d> f18242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<d, Set<a>> f18243b;
    private final Map<d, Map<a, C0898b>> c;
    private final Map<d, Map<a, Set<c>>> d;
    private boolean e;

    static class a extends e {
        a(String r1) {
            super(r1);
        }

        static a a(String r1) {
            return new a(r1);
        }
    }

    /* JADX INFO: renamed from: org.jsoup.b.b$b, reason: collision with other inner class name */
    static class C0898b extends e {
    }

    static class c extends e {
        c(String r1) {
            super(r1);
        }

        static c a(String r1) {
            return new c(r1);
        }
    }

    static class d extends e {
        d(String r1) {
            super(r1);
        }

        static d a(String r1) {
            return new d(r1);
        }
    }

    static abstract class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f18244a;

        e(String r1) {
            org.jsoup.helper.b.a(r1);
            this.f18244a = r1;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (getClass() == r5.getClass()) goto L11;
            return false;
        L11:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            String r4 = this.f18244a;
            if (r4 != null) goto L19;
            if (r6.f18244a != null) goto L17;
            return true;
        L17:
            return false;
        L19:
            return r4.equals(r6.f18244a);
        }

        public int hashCode() {
            String r1 = this.f18244a;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return 31 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return this.f18244a;
        }
    }

    public b() {
        this.f18242a = new HashSet();
        this.f18243b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        this.e = false;
    }

    public static b a() {
        return new b();
    }

    private boolean a(Element r4, org.jsoup.nodes.a r5, Set<c> r6) {
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        String r8 = r4.a(r5.a());
        if (r8.length() != 0) goto L6;
        r8 = r5.b();
    L6:
        if (this.e == true) goto L8;
        r5.a(r8);
    L8:
        Iterator r9 = r7.iterator();
    L10:
        if (r9.hasNext() == false) goto L19;
        String r10 = ((c) ZeusTransformUtils.preCheckCast(r9.next(), c.class, "com.obric.memorydata.plugin")).toString();
        if (r10.equals("#") == true) goto L14;
        if (org.jsoup.a.a.a(r8).startsWith(r10 + ParameterizedMessage.ERROR_MSG_SEPARATOR) == false) goto L10;
        return true;
    L14:
        if (c(r8) == false) goto L10;
        return true;
    L19:
        return false;
    }

    private boolean c(String r1) {
        if (r1.startsWith("#") == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.matches(".*\\s.*") == true) goto L7;
        return true;
    }

    public b a(String r4, String r5, String... r6) {
        org.jsoup.helper.b.a(r4);
        org.jsoup.helper.b.a(r5);
        org.jsoup.helper.b.a(r6);
        d r7 = d.a(r4);
        a r8 = a.a(r5);
        if (this.d.containsKey(r7) == false) goto L5;
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(this.d.get(r7), Map.class, "com.obric.memorydata.plugin");
    L7:
        if (r9.containsKey(r8) == false) goto L9;
        Set r10 = (Set) ZeusTransformUtils.preCheckCast(r9.get(r8), Set.class, "com.obric.memorydata.plugin");
    L10:
        int r11 = r6.length;
        int r0 = 0;
    L11:
        if (r0 >= r11) goto L13;
        String r1 = r6[r0];
        org.jsoup.helper.b.a(r1);
        r10.add(c.a(r1));
        r0 = r0 + 1;
        goto L11
    L13:
        return this;
    L9:
        HashSet r2 = new HashSet();
        r9.put(r8, r2);
        r10 = r2;
        goto L10
    L5:
        HashMap r3 = new HashMap();
        this.d.put(r7, r3);
        r9 = r3;
        goto L7
    }

    public b a(String r5, String... r6) {
        org.jsoup.helper.b.a(r5);
        org.jsoup.helper.b.a(r6);
        int r1 = 0;
        if (r6.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        org.jsoup.helper.b.a(r0, "No attribute names supplied.");
        d r7 = d.a(r5);
        this.f18242a.add(r7);
        HashSet r2 = new HashSet();
        int r3 = r6.length;
    L7:
        if (r1 >= r3) goto L10;
        String r4 = r6[r1];
        org.jsoup.helper.b.a(r4);
        r2.add(a.a(r4));
        r1 = r1 + 1;
        goto L7
    L10:
        if (this.f18243b.containsKey(r7) == false) goto L12;
        ((Set) ZeusTransformUtils.preCheckCast(this.f18243b.get(r7), Set.class, "com.obric.memorydata.plugin")).addAll(r2);
    L13:
        return this;
    L12:
        this.f18243b.put(r7, r2);
        goto L13
    L5:
        r0 = false;
        goto L6
    }

    public b a(boolean r1) {
        this.e = r1;
        return this;
    }

    public b a(String... r5) {
        org.jsoup.helper.b.a(r5);
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        String r2 = r5[r1];
        org.jsoup.helper.b.a(r2);
        this.f18242a.add(d.a(r2));
        r1 = r1 + 1;
        goto L3
    L5:
        return this;
    }

    public boolean a(String r1) {
        return this.f18242a.contains(d.a(r1));
    }

    public boolean a(String r7, Element r8, org.jsoup.nodes.a r9) {
        d r0 = d.a(r7);
        a r1 = a.a(r9.a());
        Set r2 = (Set) ZeusTransformUtils.preCheckCast(this.f18243b.get(r0), Set.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L16;
        if (r2.contains(r1) == false) goto L16;
        if (this.d.containsKey(r0) == false) goto L14;
        Map r10 = (Map) ZeusTransformUtils.preCheckCast(this.d.get(r0), Map.class, "com.obric.memorydata.plugin");
        if (r10.containsKey(r1) == false) goto L13;
        if (a(r8, r9, (Set) ZeusTransformUtils.preCheckCast(r10.get(r1), Set.class, "com.obric.memorydata.plugin")) == true) goto L13;
        return false;
    L13:
        return true;
    L14:
        return true;
    L16:
        if (((Map) ZeusTransformUtils.preCheckCast(this.c.get(r0), Map.class, "com.obric.memorydata.plugin")) == null) goto L22;
        org.jsoup.nodes.b r3 = b(r7);
        String r4 = r9.a();
        if (r3.h(r4) == false) goto L22;
        return r3.c(r4).equals(r9.b());
    L22:
        if (r7.equals(":all") == false) goto L24;
        return false;
    L24:
        if (a(":all", r8, r9) == true) goto L26;
        return false;
    L26:
        return true;
    }

    org.jsoup.nodes.b b(String r5) {
        org.jsoup.nodes.b r0 = new org.jsoup.nodes.b();
        d r6 = d.a(r5);
        if (this.c.containsKey(r6) == false) goto L8;
        Iterator r4 = ((Map) ZeusTransformUtils.preCheckCast(this.c.get(r6), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.b(((a) ZeusTransformUtils.preCheckCast(r7.getKey(), a.class, "com.obric.memorydata.plugin")).toString(), ((C0898b) ZeusTransformUtils.preCheckCast(r7.getValue(), C0898b.class, "com.obric.memorydata.plugin")).toString());
    L8:
        return r0;
    }
}
