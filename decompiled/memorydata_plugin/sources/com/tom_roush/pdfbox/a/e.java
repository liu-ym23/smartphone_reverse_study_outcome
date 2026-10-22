package com.tom_roush.pdfbox.a;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class e extends b implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f16048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<m, l> f16049b;
    private final Map<m, Long> c;
    private final List<n> d;
    private d e;
    private boolean f;
    private boolean g;
    private long h;
    private boolean i;
    private boolean j;
    private com.tom_roush.pdfbox.io.i k;
    private long l;

    public e() {
        this(com.tom_roush.pdfbox.io.i.a());
    }

    public e(com.tom_roush.pdfbox.io.i r2) {
        this.f16048a = 1.4f;
        this.f16049b = new HashMap();
        this.c = new HashMap();
        this.d = new ArrayList();
        this.f = true;
        this.g = false;
        this.i = false;
        this.k = r2;
    }

    public l a(m r5) {
        if (r5 == null) goto L5;
        l r1 = (l) ZeusTransformUtils.preCheckCast(this.f16049b.get(r5), l.class, "com.obric.memorydata.plugin");
    L6:
        if (r1 != null) goto L10;
        r1 = new l(null);
        if (r5 == null) goto L10;
        r1.a(r5.b());
        r1.a(r5.a());
        this.f16049b.put(r5, r1);
    L10:
        return r1;
    L5:
        r1 = null;
        goto L6
    }

    public n a(d r5) {
        n r0 = new n(this.k);
        Iterator<Map.Entry<i, b>> r4 = r5.d().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r0.a((i) ZeusTransformUtils.preCheckCast(r6.getKey(), i.class, "com.obric.memorydata.plugin"), (b) ZeusTransformUtils.preCheckCast(r6.getValue(), b.class, "com.obric.memorydata.plugin"));
        goto L4
    L6:
        return r0;
    }

    public void a() {
        this.g = true;
    }

    public void a(float r1) {
        this.f16048a = r1;
    }

    public void a(long r1) {
        this.l = r1;
    }

    public void a(Map<m, Long> r3) {
        Map<? extends m, ? extends Long> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        this.c.putAll(r4);
    }

    public d b() {
        return this.e.d(i.cD);
    }

    public void b(long r1) {
        this.h = r1;
    }

    public void b(d r1) {
        this.e = r1;
    }

    public void b(boolean r1) {
        this.j = r1;
    }

    public a c() {
        return f().f(i.dJ);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.i == false) goto L5;
        return;
    L5:
        IOException r0 = null;
        Iterator<l> r1 = d().iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        b r2 = ((l) ZeusTransformUtils.preCheckCast(r1.next(), l.class, "com.obric.memorydata.plugin")).a();
        if (ZeusTransformUtils.instanceOf(r2, n.class) == false) goto L7;
        r0 = com.tom_roush.pdfbox.io.a.a((n) ZeusTransformUtils.preCheckCast(r2, n.class, "com.obric.memorydata.plugin"), "COSStream", r0);
        goto L7
    L11:
        Iterator<n> r3 = this.d.iterator();
    L13:
        if (r3.hasNext() == false) goto L15;
        r0 = com.tom_roush.pdfbox.io.a.a((n) ZeusTransformUtils.preCheckCast(r3.next(), n.class, "com.obric.memorydata.plugin"), "COSStream", r0);
        goto L13
    L15:
        com.tom_roush.pdfbox.io.i r4 = this.k;
        if (r4 == null) goto L18;
        r0 = com.tom_roush.pdfbox.io.a.a(r4, "ScratchFile", r0);
    L18:
        this.i = true;
        if (r0 != null) goto L21;
        return;
    L21:
        throw r0;
    }

    public List<l> d() {
        return new ArrayList(this.f16049b.values());
    }

    public d f() {
        return this.e;
    }

    public void finalize() {
        if (this.i == false) goto L5;
        return;
    L5:
        if (this.f == false) goto L7;
        Log.w("PdfBox-Android", "Warning: You did not close a PDF Document");
    L7:
        close();
    }

    public long g() {
        return this.l;
    }

    public boolean h() {
        return this.i;
    }

    public Map<m, Long> i() {
        return this.c;
    }
}
