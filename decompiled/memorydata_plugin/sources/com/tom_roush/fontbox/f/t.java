package com.tom_roush.fontbox.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class t extends af {
    private List<s> c;
    private Map<Integer, Map<Integer, Map<Integer, Map<Integer, String>>>> d;
    private String e;
    private String f;
    private String g;

    t(ah r1) {
        super(r1);
        this.e = null;
        this.f = null;
        this.g = null;
    }

    private String a(int r5) {
        int r0 = 4;
    L4:
        if (r0 < 0) goto L9;
        String r1 = a(r5, 0, r0, 0);
        if (r1 != null) goto L7;
        r0 = r0 - 1;
        goto L4
    L7:
        return r1;
    L9:
        String r2 = a(r5, 3, 1, 1033);
        if (r2 == null) goto L13;
        return r2;
    L13:
        return a(r5, 1, 0, 0);
    }

    public String a() {
        return this.e;
    }

    public String a(int r2, int r3, int r4, int r5) {
        Map r1 = (Map) ZeusTransformUtils.preCheckCast(this.d.get(Integer.valueOf(r2)), Map.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return null;
    L5:
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r3)), Map.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L8;
        return null;
    L8:
        Map r7 = (Map) ZeusTransformUtils.preCheckCast(r6.get(Integer.valueOf(r4)), Map.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L12;
        return null;
    L12:
        return (String) ZeusTransformUtils.preCheckCast(r7.get(Integer.valueOf(r5)), String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.tom_roush.fontbox.f.af
    void a(ah r13, ad r14) {
        r14.d();
        int r0 = r14.d();
        r14.d();
        this.c = new ArrayList(r0);
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        s r3 = new s();
        r3.a(r13, r14);
        this.c.add(r3);
        r2 = r2 + 1;
        goto L3
    L5:
        Iterator<s> r15 = this.c.iterator();
    L7:
        if (r15.hasNext() == false) goto L28;
        s r4 = (s) ZeusTransformUtils.preCheckCast(r15.next(), s.class, "com.obric.memorydata.plugin");
        if (r4.b() <= h()) goto L12;
        String r5 = null;
    L11:
        r4.a(r5);
        goto L7
    L12:
        r14.a(((i() + 6) + ((long) ((r0 * 2) * 6))) + ((long) r4.b()));
        int r6 = r4.f();
        int r7 = r4.e();
        Charset r8 = com.tom_roush.fontbox.g.b.f16026a;
        if (r6 != 3) goto L17;
        if (r7 == 0) goto L18;
        if (r7 != 1) goto L17;
    L18:
        r8 = com.tom_roush.fontbox.g.b.f16027b;
    L27:
        r5 = r14.a(r4.a(), r8);
    L17:
        if (r6 == 0) goto L18;
        if (r6 != 2) goto L27;
        if (r7 == 0) goto L26;
        if (r7 == 1) goto L25;
        if (r7 != 2) goto L27;
        r8 = com.tom_roush.fontbox.g.b.f16026a;
        goto L27
    L25:
        r8 = com.tom_roush.fontbox.g.b.e;
        goto L27
    L26:
        r8 = com.tom_roush.fontbox.g.b.d;
        goto L27
    L28:
        this.d = new HashMap(this.c.size());
        Iterator<s> r16 = this.c.iterator();
    L30:
        if (r16.hasNext() == false) goto L41;
        s r17 = (s) ZeusTransformUtils.preCheckCast(r16.next(), s.class, "com.obric.memorydata.plugin");
        Map<Integer, Map<Integer, Map<Integer, String>>> r1 = (Map) ZeusTransformUtils.preCheckCast(this.d.get(Integer.valueOf(r17.d())), Map.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L34;
        r1 = new HashMap();
        this.d.put(Integer.valueOf(r17.d()), r1);
    L34:
        Map<Integer, Map<Integer, String>> r9 = (Map) ZeusTransformUtils.preCheckCast(r1.get(Integer.valueOf(r17.f())), Map.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L37;
        r9 = new HashMap();
        r1.put(Integer.valueOf(r17.f()), r9);
    L37:
        Map<Integer, String> r10 = (Map) ZeusTransformUtils.preCheckCast(r9.get(Integer.valueOf(r17.e())), Map.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L40;
        r10 = new HashMap();
        r9.put(Integer.valueOf(r17.e()), r10);
    L40:
        r10.put(Integer.valueOf(r17.c()), r17.g());
        goto L30
    L41:
        this.e = a(1);
        this.f = a(2);
        String r18 = a(6, 1, 0, 0);
        this.g = r18;
        if (r18 != null) goto L44;
        this.g = a(6, 3, 1, 1033);
    L44:
        String r19 = this.g;
        if (r19 == null) goto L47;
        this.g = r19.trim();
    L47:
        this.f15974a = true;
    }

    public String b() {
        return this.f;
    }

    public String c() {
        return this.g;
    }
}
