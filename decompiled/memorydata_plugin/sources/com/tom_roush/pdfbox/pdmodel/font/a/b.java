package com.tom_roush.pdfbox.pdmodel.font.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class b extends c {
    private final com.tom_roush.pdfbox.a.d c;
    private final c d;
    private final Map<Integer, String> e;

    public b(com.tom_roush.pdfbox.a.d r2) {
        this.e = new HashMap();
        this.c = r2;
        this.d = null;
        f();
    }

    public b(com.tom_roush.pdfbox.a.d r2, boolean r3, c r4) {
        this.e = new HashMap();
        this.c = r2;
        if (r2.m(com.tom_roush.pdfbox.a.i.P) == false) goto L5;
        c r5 = c.a(r2.b(com.tom_roush.pdfbox.a.i.P));
    L6:
        if (r5 != null) goto L13;
        if (r3 == false) goto L9;
        r4 = h.c;
    L14:
        this.d = r4;
        this.f16215a.putAll(r4.f16215a);
        this.f16216b.putAll(r4.f16216b);
        f();
        return;
    L9:
        if (r4 != null) goto L14;
        throw new IllegalArgumentException("Symbolic fonts must have a built-in encoding");
    L13:
        r4 = r5;
        goto L14
    L5:
        r5 = null;
        goto L6
    }

    private void f() {
        com.tom_roush.pdfbox.a.b r0 = this.c.a(com.tom_roush.pdfbox.a.i.bQ);
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.a.class) == true) goto L5;
        return;
    L5:
        com.tom_roush.pdfbox.a.a r1 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        int r2 = -1;
        int r3 = 0;
    L7:
        if (r3 >= r1.b()) goto L15;
        com.tom_roush.pdfbox.a.b r4 = r1.a(r3);
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.k.class) == false) goto L12;
        r2 = ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).c();
    L14:
        r3 = r3 + 1;
        goto L7
    L12:
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.i.class) == false) goto L14;
        com.tom_roush.pdfbox.a.i r5 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        b(r2, r5.a());
        this.e.put(Integer.valueOf(r2), r5.a());
        r2 = r2 + 1;
        goto L14
    }

    public c a() {
        return this.d;
    }

    public Map<Integer, String> b() {
        return this.e;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        return this.c;
    }
}
