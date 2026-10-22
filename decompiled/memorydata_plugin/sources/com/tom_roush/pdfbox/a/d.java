package com.tom_roush.pdfbox.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;

/* JADX INFO: loaded from: classes6.dex */
public class d extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Map<i, b> f16047a;

    public d() {
        this.f16047a = new com.tom_roush.pdfbox.util.d();
    }

    private static String a(b r7, List<b> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L7;
        return "null";
    L7:
        if (r9.contains(r7) == true) goto L9;
        r9.add(r7);
        if (ZeusTransformUtils.instanceOf(r7, d.class) == false) goto L22;
        StringBuilder r1 = new StringBuilder("COSDictionary{");
        Iterator<Map.Entry<i, b>> r0 = ((d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin")).d().iterator();
    L14:
        if (r0.hasNext() == false) goto L16;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r1.append(r5.getKey());
        r1.append(ParameterizedMessage.ERROR_MSG_SEPARATOR);
        r1.append(a((b) ZeusTransformUtils.preCheckCast(r5.getValue(), b.class, "com.obric.memorydata.plugin"), r9));
        r1.append(";");
        goto L14
    L16:
        r1.append("}");
        if (ZeusTransformUtils.instanceOf(r7, n.class) == false) goto L20;
        InputStream r10 = ((n) ZeusTransformUtils.preCheckCast(r7, n.class, "com.obric.memorydata.plugin")).g();
        r1.append("COSStream{").append(Arrays.hashCode(com.tom_roush.pdfbox.io.a.a(r10))).append("}");
        r10.close();
    L20:
        return r1.toString();
    L22:
        if (ZeusTransformUtils.instanceOf(r7, a.class) == false) goto L30;
        StringBuilder r2 = new StringBuilder("COSArray{");
        Iterator<b> r11 = ((a) ZeusTransformUtils.preCheckCast(r7, a.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r11.hasNext() == false) goto L27;
        r2.append(a((b) ZeusTransformUtils.preCheckCast(r11.next(), b.class, "com.obric.memorydata.plugin"), r9));
        r2.append(";");
        goto L25
    L27:
        r2.append("}");
        return r2.toString();
    L30:
        if (ZeusTransformUtils.instanceOf(r7, l.class) == false) goto L34;
        return "COSObject{" + a(((l) ZeusTransformUtils.preCheckCast(r7, l.class, "com.obric.memorydata.plugin")).a(), r9) + "}";
    L34:
        return r7.toString();
    L9:
        return String.valueOf(r7.hashCode());
    }

    public int a() {
        return this.f16047a.size();
    }

    public int a(i r1, i r2, int r3) {
        b r0 = a(r1, r2);
        if (ZeusTransformUtils.instanceOf(r0, k.class) == true) goto L5;
        return r3;
    L5:
        return ((k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.memorydata.plugin")).c();
    }

    public b a(i r2) {
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f16047a.get(r2), b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, l.class) == false) goto L6;
        r1 = ((l) ZeusTransformUtils.preCheckCast(r1, l.class, "com.obric.memorydata.plugin")).a();
    L6:
        if (ZeusTransformUtils.instanceOf(r1, j.class) == false) goto L9;
        return null;
    L9:
        return r1;
    }

    public b a(i r1, i r2) {
        b r3 = a(r1);
        if (r3 != null) goto L7;
        if (r2 != null) goto L6;
        return r3;
    L6:
        return a(r2);
    L7:
        return r3;
    }

    public b a(String r1) {
        return a(i.a(r1));
    }

    public void a(d r3) {
        if (ZeusTransformUtils.instanceOf(this.f16047a, com.tom_roush.pdfbox.util.d.class) == true) goto L5;
    L7:
        this.f16047a.putAll(r3.f16047a);
        return;
    L5:
        if ((this.f16047a.size() + r3.f16047a.size()) < 1000) goto L7;
        this.f16047a = new LinkedHashMap(this.f16047a);
        goto L7
    }

    public void a(i r2, float r3) {
        a(r2, new f(r3));
    }

    public void a(i r3, int r4) {
        a(r3, h.a(r4));
    }

    public void a(i r1, long r2) {
        a(r1, h.a(r2));
    }

    public void a(i r3, b r4) {
        if (r4 != null) goto L5;
        k(r3);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(this.f16047a, com.tom_roush.pdfbox.util.d.class) == true) goto L7;
    L9:
        this.f16047a.put(r3, r4);
        return;
    L7:
        if (this.f16047a.size() < 1000) goto L9;
        this.f16047a = new LinkedHashMap(this.f16047a);
        goto L9
    }

    public void a(i r3, com.tom_roush.pdfbox.pdmodel.common.c r4) {
        com.tom_roush.pdfbox.pdmodel.common.c r5 = (com.tom_roush.pdfbox.pdmodel.common.c) ZeusTransformUtils.wrapperContextForParams(r4, com.tom_roush.pdfbox.pdmodel.common.c.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        b r6 = r5.e();
    L6:
        a(r3, r6);
        return;
    L5:
        r6 = null;
        goto L6
    }

    public void a(i r1, String r2) {
        if (r2 == null) goto L4;
        i r3 = i.a(r2);
    L5:
        a(r1, r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void a(i r1, boolean r2) {
        a(r1, c.b(r2));
    }

    public void a(String r1, float r2) {
        a(i.a(r1), r2);
    }

    public void a(String r1, int r2) {
        a(i.a(r1), r2);
    }

    public void a(String r1, b r2) {
        a(i.a(r1), r2);
    }

    public void a(String r3, com.tom_roush.pdfbox.pdmodel.common.c r4) {
        com.tom_roush.pdfbox.pdmodel.common.c r5 = (com.tom_roush.pdfbox.pdmodel.common.c) ZeusTransformUtils.wrapperContextForParams(r4, com.tom_roush.pdfbox.pdmodel.common.c.class, "com.obric.memorydata.plugin");
        a(i.a(r3), r5);
    }

    public void a(String r1, String r2) {
        a(i.a(r1), r2);
    }

    public void a(String r1, boolean r2) {
        a(i.a(r1), c.b(r2));
    }

    public boolean a(i r1, i r2, boolean r3) {
        b r0 = a(r1, r2);
        if (ZeusTransformUtils.instanceOf(r0, c.class) == true) goto L5;
        return r3;
    L5:
        if (r0 != c.c) goto L7;
        boolean r4 = true;
    L9:
        return r4;
    L7:
        r4 = false;
        goto L9
    }

    public float b(i r1, float r2) {
        b r0 = a(r1);
        if (ZeusTransformUtils.instanceOf(r0, k.class) == true) goto L5;
        return r2;
    L5:
        return ((k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.memorydata.plugin")).a();
    }

    public float b(String r1, float r2) {
        return b(i.a(r1), r2);
    }

    public int b(i r2, int r3) {
        return a(r2, null, r3);
    }

    public int b(String r1, int r2) {
        return b(i.a(r1), r2);
    }

    public long b(i r1, long r2) {
        b r0 = a(r1);
        if (ZeusTransformUtils.instanceOf(r0, k.class) == true) goto L5;
        return r2;
    L5:
        return ((k) ZeusTransformUtils.preCheckCast(r0, k.class, "com.obric.memorydata.plugin")).b();
    }

    public i b(i r2) {
        b r1 = a(r2);
        if (ZeusTransformUtils.instanceOf(r1, i.class) == true) goto L5;
        return null;
    L5:
        return (i) ZeusTransformUtils.preCheckCast(r1, i.class, "com.obric.memorydata.plugin");
    }

    public i b(i r1, i r2) {
        b r0 = a(r1);
        if (ZeusTransformUtils.instanceOf(r0, i.class) == true) goto L5;
        return r2;
    L5:
        return (i) ZeusTransformUtils.preCheckCast(r0, i.class, "com.obric.memorydata.plugin");
    }

    public String b(String r1) {
        return g(i.a(r1));
    }

    public void b() {
        this.f16047a.clear();
    }

    public void b(i r2, String r3) {
        if (r3 == null) goto L4;
        o r0 = new o(r3);
    L5:
        a(r2, r0);
        return;
    L4:
        r0 = null;
        goto L5
    }

    public void b(String r1, String r2) {
        b(i.a(r1), r2);
    }

    public boolean b(i r2, boolean r3) {
        return a(r2, null, r3);
    }

    public boolean b(String r1, boolean r2) {
        return b(i.a(r1), r2);
    }

    public int c(i r2, i r3) {
        return a(r2, r3, -1);
    }

    public l c(i r2) {
        b r1 = l(r2);
        if (ZeusTransformUtils.instanceOf(r1, l.class) == true) goto L5;
        return null;
    L5:
        return (l) ZeusTransformUtils.preCheckCast(r1, l.class, "com.obric.memorydata.plugin");
    }

    public String c(i r1, String r2) {
        String r0 = g(r1);
        if (r0 != null) goto L6;
        return r2;
    L6:
        return r0;
    }

    public String c(String r1) {
        return h(i.a(r1));
    }

    public String c(String r1, String r2) {
        return c(i.a(r1), r2);
    }

    public Set<i> c() {
        return this.f16047a.keySet();
    }

    public float d(String r2) {
        return b(i.a(r2), -1.0f);
    }

    public b d(i r1, i r2) {
        b r3 = l(r1);
        if (r3 != null) goto L7;
        if (r2 != null) goto L6;
        return r3;
    L6:
        return l(r2);
    L7:
        return r3;
    }

    public d d(i r2) {
        b r1 = a(r2);
        if (ZeusTransformUtils.instanceOf(r1, d.class) == true) goto L5;
        return null;
    L5:
        return (d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.memorydata.plugin");
    }

    public Set<Map.Entry<i, b>> d() {
        return this.f16047a.entrySet();
    }

    public n e(i r2) {
        b r1 = a(r2);
        if (ZeusTransformUtils.instanceOf(r1, n.class) == true) goto L5;
        return null;
    L5:
        return (n) ZeusTransformUtils.preCheckCast(r1, n.class, "com.obric.memorydata.plugin");
    }

    public a f(i r2) {
        b r1 = a(r2);
        if (ZeusTransformUtils.instanceOf(r1, a.class) == true) goto L5;
        return null;
    L5:
        return (a) ZeusTransformUtils.preCheckCast(r1, a.class, "com.obric.memorydata.plugin");
    }

    public Collection<b> f() {
        return this.f16047a.values();
    }

    public String g(i r2) {
        b r1 = a(r2);
        if (ZeusTransformUtils.instanceOf(r1, i.class) == false) goto L6;
        return ((i) ZeusTransformUtils.preCheckCast(r1, i.class, "com.obric.memorydata.plugin")).a();
    L6:
        if (ZeusTransformUtils.instanceOf(r1, o.class) == true) goto L11;
        return null;
    L11:
        return ((o) ZeusTransformUtils.preCheckCast(r1, o.class, "com.obric.memorydata.plugin")).a();
    }

    public String h(i r2) {
        b r1 = a(r2);
        if (ZeusTransformUtils.instanceOf(r1, o.class) == true) goto L7;
        return null;
    L7:
        return ((o) ZeusTransformUtils.preCheckCast(r1, o.class, "com.obric.memorydata.plugin")).a();
    }

    public int i(i r2) {
        return b(r2, -1);
    }

    public long j(i r3) {
        return b(r3, -1);
    }

    public void k(i r1) {
        this.f16047a.remove(r1);
    }

    public b l(i r2) {
        return (b) ZeusTransformUtils.preCheckCast(this.f16047a.get(r2), b.class, "com.obric.memorydata.plugin");
    }

    public boolean m(i r1) {
        return this.f16047a.containsKey(r1);
    }

    public String toString() {
        return a(this, new ArrayList());
    L4:
        e = move-exception;
        return "COSDictionary{" + e.getMessage() + "}";
    }
}
