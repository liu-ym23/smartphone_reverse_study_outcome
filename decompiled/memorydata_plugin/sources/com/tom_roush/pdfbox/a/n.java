package com.tom_roush.pdfbox.a;

import android.util.Log;
import com.tom_roush.pdfbox.android.PDFBoxConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class n extends d implements Closeable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.tom_roush.pdfbox.io.c f16067b;
    private final com.tom_roush.pdfbox.io.i c;
    private boolean d;

    public n() {
        this(com.tom_roush.pdfbox.io.i.a());
    }

    public n(com.tom_roush.pdfbox.io.i r3) {
        a(i.ew, 0);
        if (r3 != null) goto L6;
        r3 = com.tom_roush.pdfbox.io.i.a();
    L6:
        this.c = r3;
    }

    static /* synthetic */ com.tom_roush.pdfbox.io.c a(n r0) {
        return r0.f16067b;
    }

    static /* synthetic */ boolean a(n r0, boolean r1) {
        r0.d = r1;
        return r1;
    }

    private void b(boolean r2) {
        if (this.f16067b != null) goto L10;
        if (r2 == true) goto L6;
    L8:
        this.f16067b = this.c.e();
        return;
    L6:
        if (PDFBoxConfig.b() == false) goto L8;
        Log.d("PdfBox-Android", "Create InputStream called without data being written before to stream.");
        goto L8
    }

    private void l() {
        com.tom_roush.pdfbox.io.c r1 = this.f16067b;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1.c() == true) goto L8;
        return;
    L8:
        throw new IOException("COSStream has been closed and cannot be read. Perhaps its enclosing PDDocument has been closed?");
    }

    private List<com.tom_roush.pdfbox.filter.j> m() {
        b r6 = k();
        if (ZeusTransformUtils.instanceOf(r6, i.class) == false) goto L6;
        ArrayList r0 = new ArrayList(1);
        r0.add(com.tom_roush.pdfbox.filter.k.f16109a.a((i) ZeusTransformUtils.preCheckCast(r6, i.class, "com.obric.memorydata.plugin")));
        return r0;
    L6:
        if (ZeusTransformUtils.instanceOf(r6, a.class) == false) goto L20;
        a r7 = (a) ZeusTransformUtils.preCheckCast(r6, a.class, "com.obric.memorydata.plugin");
        ArrayList r1 = new ArrayList(r7.b());
        int r2 = 0;
    L9:
        if (r2 >= r7.b()) goto L24;
        b r3 = r7.b(r2);
        if (ZeusTransformUtils.instanceOf(r3, i.class) == false) goto L12;
        r1.add(com.tom_roush.pdfbox.filter.k.f16109a.a((i) ZeusTransformUtils.preCheckCast(r3, i.class, "com.obric.memorydata.plugin")));
        r2 = r2 + 1;
        goto L9
    L12:
        StringBuilder r4 = new StringBuilder().append("Forbidden type in filter array: ");
        if (r3 != null) goto L15;
        String r5 = "null";
    L17:
        throw new IOException(r4.append(r5).toString());
    L15:
        r5 = r3.getClass().getName();
        goto L17
    L24:
        return r1;
    L20:
        return new ArrayList();
    }

    public g a(com.tom_roush.pdfbox.filter.h r4) {
        l();
        if (this.d == true) goto L7;
        b(true);
        com.tom_roush.pdfbox.io.e r0 = new com.tom_roush.pdfbox.io.e(this.f16067b);
        return g.a(m(), this, r0, this.c, r4);
    L7:
        throw new IllegalStateException("Cannot read while there is an open stream writer");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        com.tom_roush.pdfbox.io.c r0 = this.f16067b;
        if (r0 == null) goto L6;
        r0.close();
        return;
    }

    public InputStream g() {
        l();
        if (this.d == true) goto L7;
        b(true);
        return new com.tom_roush.pdfbox.io.e(this.f16067b);
    L7:
        throw new IllegalStateException("Cannot read while there is an open stream writer");
    }

    public g h() {
        return a(com.tom_roush.pdfbox.filter.h.f16105a);
    }

    public OutputStream i() {
        l();
        if (this.d == true) goto L7;
        com.tom_roush.pdfbox.io.a.a(this.f16067b);
        this.f16067b = this.c.e();
        final com.tom_roush.pdfbox.io.f r0 = new com.tom_roush.pdfbox.io.f(this.f16067b);
        this.d = true;
        return new AnonymousClass1(this, r0);
    L7:
        throw new IllegalStateException("Cannot have more than one open stream writer.");
    }

    public long j() {
        if (this.d == true) goto L7;
        return b(i.ew, 0);
    L7:
        throw new IllegalStateException("There is an open OutputStream associated with this COSStream. It must be closed before querying the length of this COSStream.");
    }

    public b k() {
        return a(i.cT);
    }
}
