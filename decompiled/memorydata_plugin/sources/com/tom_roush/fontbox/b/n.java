package com.tom_roush.fontbox.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class n extends h implements com.tom_roush.fontbox.a {
    private final Map<String, Object> f;
    private d g;
    private final Map<Integer, v> h;
    private final a i;

    /* JADX INFO: renamed from: com.tom_roush.fontbox.b.n$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a implements com.tom_roush.fontbox.type1.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n f15936a;

        private a(n r1) {
            this.f15936a = r1;
        }

        /* synthetic */ a(n r1, AnonymousClass1 r2) {
            this(r1);
        }

        @Override // com.tom_roush.fontbox.type1.a
        public t b_(String r1) {
            return this.f15936a.c(r1);
        }
    }

    public n() {
        this.f = new LinkedHashMap();
        this.h = new ConcurrentHashMap();
        this.i = new a(this, null);
    }

    private v a(int r13, String r14) {
        v r0 = (v) ZeusTransformUtils.preCheckCast(this.h.get(Integer.valueOf(r13)), v.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L11;
        byte[] r1 = null;
        if (r13 >= this.d.length) goto L7;
        r1 = this.d[r13];
    L7:
        if (r1 != null) goto L9;
        r1 = this.d[0];
    L9:
        List<Object> r9 = new w(this.f15908a, r14).a(r1, this.e, f());
        v r2 = new v(this.i, this.f15908a, r14, r13, r9, g(), i());
        this.h.put(Integer.valueOf(r13), r2);
        return r2;
    L11:
        return r0;
    }

    private Object f(String r2) {
        Object r0 = this.f15909b.get(r2);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return this.f.get(r2);
    }

    private byte[][] f() {
        return (byte[][]) ZeusTransformUtils.preCheckCast(this.f.get("Subrs"), byte[][].class, "com.obric.memorydata.plugin");
    }

    private int g() {
        Number r2 = (Number) ZeusTransformUtils.preCheckCast(f("defaultWidthX"), Number.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return 1000;
    L7:
        return r2.intValue();
    }

    private int i() {
        Number r2 = (Number) ZeusTransformUtils.preCheckCast(f("nominalWidthX"), Number.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return 0;
    L7:
        return r2.intValue();
    }

    @Override // com.tom_roush.fontbox.b
    public float a(String r1) {
        return c(r1).a();
    }

    public v a(int r3) {
        return a(r3, "GID+" + r3);
    }

    @Override // com.tom_roush.fontbox.a
    public /* synthetic */ com.tom_roush.fontbox.d.b a() {
        return e();
    }

    void a(d r1) {
        this.g = r1;
    }

    void b(String r1, Object r2) {
        if (r2 == null) goto L5;
        this.f.put(r1, r2);
        return;
    }

    @Override // com.tom_roush.fontbox.b
    public boolean b(String r2) {
        int r3 = this.c.a(r2);
        if (this.c.b(r3) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public t c(String r2) {
        return a(d(r2), r2);
    }

    public int d(String r2) {
        int r3 = this.c.a(r2);
        return this.c.b(r3);
    }

    @Override // com.tom_roush.fontbox.b
    public List<Number> d() {
        return (List) ZeusTransformUtils.preCheckCast(this.f15909b.get("FontMatrix"), List.class, "com.obric.memorydata.plugin");
    }

    public d e() {
        return this.g;
    }
}
