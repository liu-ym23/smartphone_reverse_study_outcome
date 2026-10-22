package com.ctc.wstx.h;

import com.ctc.wstx.a.b;
import com.ctc.wstx.d.n;
import com.ctc.wstx.d.u;
import com.ctc.wstx.exc.WstxIOException;
import com.ctc.wstx.g.h;
import com.ctc.wstx.g.l;
import com.ctc.wstx.io.o;
import com.ctc.wstx.io.q;
import com.ctc.wstx.io.r;
import com.ctc.wstx.util.SimpleCache;
import com.ctc.wstx.util.d;
import com.ctc.wstx.util.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import javax.xml.stream.e;

/* JADX INFO: loaded from: classes2.dex */
public class a extends org.codehaus.stax2.a implements h {
    static final k d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final b f3520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected javax.xml.stream.b.a f3521b;
    protected SimpleCache<n, u> c;
    private k e;

    static {
        k r0 = d.a();
        d = r0;
        r0.a(true);
    }

    public a() {
        this.f3521b = null;
        this.c = null;
        this.e = d;
        this.f3520a = b.b();
    }

    private org.codehaus.stax2.d b(b r7, r r8, com.ctc.wstx.io.k r9, boolean r10, boolean r11) {
        if (r11 == true) goto L4;
        r11 = r7.i();
    L4:
        boolean r5 = r11;
        Reader r4 = r9.a(r7, true, 0);     // Catch: IOException -> L10
        if (r9.b() == false) goto L9;
        r7.t(true);     // Catch: IOException -> L10
    L9:
        return l.a(com.ctc.wstx.io.l.a(r7, r9, null, r8, r4, r5), this, r7, r9, r10);
    L10:
        e = move-exception;
        throw new WstxIOException(e);
    }

    public b a() {
        return this.f3520a.a(this.e.a());
    }

    @Override // com.ctc.wstx.g.h
    public synchronized u a(n r3) {
        monitor-enter(this);
        SimpleCache<n, u> r0 = this.c;     // Catch: Throwable -> L9
        if (r0 != null) goto L6;
        u r4 = null;
    L7:
        monitor-exit(this);
        return r4;
    L6:
        r4 = (u) ZeusTransformUtils.preCheckCast(r0.a(r3), u.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    @Override // javax.xml.stream.b
    public e a(InputStream r7) {
        return a(null, r7, null, false, false);
    }

    public org.codehaus.stax2.d a(b r1, r r2, com.ctc.wstx.io.k r3, boolean r4, boolean r5) {
        return b(r1, r2, r3, r4, r5);
    }

    public org.codehaus.stax2.d a(r r7, InputStream r8, String r9, boolean r10, boolean r11) {
        if (r8 == null) goto L13;
        b r1 = a();
        if (r9 != null) goto L6;
    L11:
        com.ctc.wstx.io.k r3 = q.a(null, r7, r8);
    L10:
        return a(r1, r7, r3, r10, r11);
    L6:
        if (r9.length() == 0) goto L11;
        r3 = o.a(null, r7, com.ctc.wstx.io.h.a(r1, r8, false, r9), r9);
        goto L10
    L13:
        throw new IllegalArgumentException("Null InputStream is not a valid argument");
    }

    @Override // com.ctc.wstx.g.h
    public synchronized void a(n r3, u r4) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.c != null) goto L6;
        this.c = new SimpleCache(this.f3520a.d());     // Catch: Throwable -> L9
    L6:
        this.c.a(r3, r4);     // Catch: Throwable -> L9
        monitor-exit(this);
    }

    @Override // com.ctc.wstx.g.h
    public synchronized void a(k r3) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (r3.b(this.e) == true) goto L6;
    L12:
        monitor-exit(this);
        return;
    L6:
        if (r3.b() <= 12000) goto L8;
    L11:
        this.e = d;     // Catch: Throwable -> L14
        goto L12
    L8:
        if (r3.c() > 500) goto L11;
        this.e.a(r3);     // Catch: Throwable -> L14
        goto L12
    }

    public void a(String r2, Object r3) {
        if (this.f3520a.a(r2, r3) == false) goto L5;
        return;
    L5:
        if ("javax.xml.stream.allocator".equals(r2) == false) goto L9;
        a((javax.xml.stream.b.a) ZeusTransformUtils.preCheckCast(r3, javax.xml.stream.b.a.class, "com.obric.memorydata.plugin"));
        return;
    }

    public void a(javax.xml.stream.b.a r3) {
        this.f3521b = (javax.xml.stream.b.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.b.a.class, "com.obric.memorydata.plugin");
    }

    public void a(javax.xml.stream.d r3) {
        javax.xml.stream.d r4 = (javax.xml.stream.d) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.d.class, "com.obric.memorydata.plugin");
        this.f3520a.a(r4);
    }
}
