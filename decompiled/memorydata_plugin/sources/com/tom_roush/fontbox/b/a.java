package com.tom_roush.fontbox.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class a extends h {
    private String f;
    private String g;
    private int h;
    private List<Map<String, Object>> i;
    private List<Map<String, Object>> j;
    private s k;
    private final Map<Integer, o> l;
    private final C0847a m;

    /* JADX INFO: renamed from: com.tom_roush.fontbox.b.a$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: renamed from: com.tom_roush.fontbox.b.a$a, reason: collision with other inner class name */
    private class C0847a implements com.tom_roush.fontbox.type1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f15901a;

        private C0847a(a r1) {
            this.f15901a = r1;
        }

        /* synthetic */ C0847a(a r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.tom_roush.fontbox.type1.a
        public t b_(String r1) {
            return this.f15901a.b(0);
        }
    }

    public a() {
        this.i = new LinkedList();
        this.j = new LinkedList();
        this.l = new ConcurrentHashMap();
        this.m = new C0847a(this, null);
    }

    private int c(int r4) {
        int r5 = this.k.a(r4);
        if (r5 != (-1)) goto L5;
        return 1000;
    L5:
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(this.j.get(r5), Map.class, "com.obric.memorydata.plugin");
        if (r3.containsKey("defaultWidthX") == true) goto L8;
        return 1000;
    L8:
        return ((Number) ZeusTransformUtils.preCheckCast(r3.get("defaultWidthX"), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private int d(int r4) {
        int r5 = this.k.a(r4);
        if (r5 != (-1)) goto L5;
        return 0;
    L5:
        Map r3 = (Map) ZeusTransformUtils.preCheckCast(this.j.get(r5), Map.class, "com.obric.memorydata.plugin");
        if (r3.containsKey("nominalWidthX") == true) goto L8;
        return 0;
    L8:
        return ((Number) ZeusTransformUtils.preCheckCast(r3.get("nominalWidthX"), Number.class, "com.obric.memorydata.plugin")).intValue();
    }

    private byte[][] e(int r2) {
        int r3 = this.k.a(r2);
        if (r3 != (-1)) goto L7;
        return null;
    L7:
        return (byte[][]) ZeusTransformUtils.preCheckCast(((Map) ZeusTransformUtils.preCheckCast(this.j.get(r3), Map.class, "com.obric.memorydata.plugin")).get("Subrs"), byte[][].class, "com.obric.memorydata.plugin");
    }

    private int f(String r1) {
        if (r1.startsWith("\\") == false) goto L7;
        return Integer.parseInt(r1.substring(1));
    L7:
        throw new IllegalArgumentException("Invalid selector");
    }

    @Override // com.tom_roush.fontbox.b
    public float a(String r1) {
        return b(f(r1)).a();
    }

    public String a() {
        return this.f;
    }

    void a(int r1) {
        this.h = r1;
    }

    void a(s r1) {
        this.k = r1;
    }

    void a(List<Map<String, Object>> r3) {
        this.i = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public o b(int r10) {
        o r0 = (o) ZeusTransformUtils.preCheckCast(this.l.get(Integer.valueOf(r10)), o.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L9;
        int r5 = this.c.c(r10);
        byte[] r1 = this.d[r5];
        if (r1 != null) goto L7;
        r1 = this.d[0];
    L7:
        List<Object> r6 = new w(this.f15908a, r10).a(r1, this.e, e(r5));
        o r2 = new o(this.m, this.f15908a, r10, r5, r6, c(r5), d(r5));
        this.l.put(Integer.valueOf(r10), r2);
        return r2;
    L9:
        return r0;
    }

    void b(List<Map<String, Object>> r3) {
        this.j = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.tom_roush.fontbox.b
    public boolean b(String r1) {
        if (f(r1) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    void c(String r1) {
        this.f = r1;
    }

    @Override // com.tom_roush.fontbox.b
    public List<Number> d() {
        return (List) ZeusTransformUtils.preCheckCast(this.f15909b.get("FontMatrix"), List.class, "com.obric.memorydata.plugin");
    }

    void d(String r1) {
        this.g = r1;
    }

    public String e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    public List<Map<String, Object>> g() {
        return this.i;
    }
}
