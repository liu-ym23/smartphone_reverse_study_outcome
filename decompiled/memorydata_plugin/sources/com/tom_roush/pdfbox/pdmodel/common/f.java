package com.tom_roush.pdfbox.pdmodel.common;

import android.util.Log;
import com.tom_roush.pdfbox.a.o;
import com.tom_roush.pdfbox.pdmodel.common.c;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class f<T extends c> implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16184a;

    public f() {
        this.f16184a = new com.tom_roush.pdfbox.a.d();
    }

    public f(com.tom_roush.pdfbox.a.d r1) {
        this.f16184a = r1;
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16184a;
    }

    public T a(String r7) {
        Map<String, T> r0 = c();
        if (r0 != null) goto L5;
        List<f<T>> r6 = b();
        if (r6 == null) goto L24;
        int r1 = 0;
    L10:
        if (r1 >= r6.size()) goto L34;
        f r2 = (f) ZeusTransformUtils.preCheckCast(r6.get(r1), f.class, "com.obric.memorydata.plugin");
        String r3 = r2.d();
        String r4 = r2.f();
        if (r3 == null) goto L23;
        if (r4 == null) goto L23;
        if (r3.compareTo(r4) < 0) goto L23;
        if (r4.compareTo(r7) > 0) goto L21;
        if (r3.compareTo(r7) >= 0) goto L23;
    L21:
        r1 = r1 + 1;
    L23:
        return (T) r2.a(r7);
    L34:
        return null;
    L24:
        Log.w("PdfBox-Android", "NameTreeNode does not have \"names\" nor \"kids\" objects.");
        return null;
    L5:
        return (T) ZeusTransformUtils.preCheckCast(r0.get(r7), c.class, "com.obric.memorydata.plugin");
    }

    public abstract f<T> a(com.tom_roush.pdfbox.a.d r1);

    public abstract T b(com.tom_roush.pdfbox.a.b r1);

    public List<f<T>> b() {
        com.tom_roush.pdfbox.a.a r0 = this.f16184a.f(com.tom_roush.pdfbox.a.i.el);
        if (r0 == null) goto L9;
        ArrayList r1 = new ArrayList(r0.b());
        int r2 = 0;
    L6:
        if (r2 >= r0.b()) goto L12;
        r1.add(a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r0.a(r2), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin")));
        r2 = r2 + 1;
        goto L6
    L12:
        return new a(r1, r0);
    L9:
        return null;
    }

    public Map<String, T> c() {
        com.tom_roush.pdfbox.a.a r0 = this.f16184a.f(com.tom_roush.pdfbox.a.i.fi);
        if (r0 == null) goto L17;
        LinkedHashMap r1 = new LinkedHashMap();
        if ((r0.b() % 2) == 0) goto L7;
        Log.w("PdfBox-Android", "Names array has odd size: " + r0.b());
    L7:
        int r2 = 0;
    L8:
        int r3 = r2 + 1;
        if (r3 >= r0.b()) goto L16;
        com.tom_roush.pdfbox.a.b r4 = r0.a(r2);
        if (ZeusTransformUtils.instanceOf(r4, o.class) == false) goto L14;
        r1.put(((o) ZeusTransformUtils.preCheckCast(r4, o.class, "com.obric.memorydata.plugin")).a(), b(r0.a(r3)));
        r2 = r2 + 2;
        goto L8
    L14:
        throw new IOException("Expected string, found " + r4 + " in name tree at index " + r2);
    L16:
        return Collections.unmodifiableMap(r1);
    L17:
        return null;
    }

    public String d() {
        com.tom_roush.pdfbox.a.a r1 = this.f16184a.f(com.tom_roush.pdfbox.a.i.eA);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.e(1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }

    public String f() {
        com.tom_roush.pdfbox.a.a r1 = this.f16184a.f(com.tom_roush.pdfbox.a.i.eA);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.e(0);
    }
}
