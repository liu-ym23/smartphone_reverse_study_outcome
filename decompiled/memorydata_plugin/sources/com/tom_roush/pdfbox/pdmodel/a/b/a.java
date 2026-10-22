package com.tom_roush.pdfbox.pdmodel.a.b;

import com.tom_roush.pdfbox.a.d;
import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.c.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f16157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f16158b;
    private final List<Object> c;

    public a(i r1, d r2) {
        if (r1 != null) goto L5;
        String r3 = null;
    L6:
        this.f16157a = r3;
        this.f16158b = r2;
        this.c = new ArrayList();
        return;
    L5:
        r3 = r1.a();
        goto L6
    }

    public static a a(i r1, d r2) {
        if (i.D.equals(r1) == false) goto L7;
        return new com.tom_roush.pdfbox.pdmodel.a.d.a(r2);
    L7:
        return new a(r1, r2);
    }

    public String a() {
        return this.f16157a;
    }

    public void a(c r1) {
        h().add(r1);
    }

    public void a(a r1) {
        h().add(r1);
    }

    public void a(com.tom_roush.pdfbox.pdmodel.graphics.d r1) {
        h().add(r1);
    }

    public d b() {
        return this.f16158b;
    }

    public int c() {
        if (b() != null) goto L6;
        return -1;
    L6:
        return b().i(i.eU);
    }

    public String d() {
        if (b() != null) goto L6;
        return null;
    L6:
        return b().g(i.eo);
    }

    public String e() {
        if (b() != null) goto L6;
        return null;
    L6:
        return b().h(i.f);
    }

    public String f() {
        if (b() != null) goto L6;
        return null;
    L6:
        return b().h(i.r);
    }

    public String g() {
        if (b() != null) goto L6;
        return null;
    L6:
        return b().h(i.cq);
    }

    public List<Object> h() {
        return this.c;
    }

    public String toString() {
        return "tag=" + this.f16157a + ", properties=" + this.f16158b + ", contents=" + this.c;
    }
}
