package com.tom_roush.pdfbox.io;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;

/* JADX INFO: loaded from: classes6.dex */
public class e extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g f16117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f16118b;

    public e(g r3) {
        this.f16117a = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        this.f16118b = 0;
    }

    void a() {
        this.f16117a.a(this.f16118b);
    }

    @Override // java.io.InputStream
    public int available() {
        a();
        long r0 = this.f16117a.b() - this.f16117a.a();
        if (r0 <= 2147483647L) goto L7;
        return Integer.MAX_VALUE;
    L7:
        return (int) r0;
    }

    @Override // java.io.InputStream
    public int read() {
        a();
        if (this.f16117a.e() == false) goto L5;
        return -1;
    L5:
        int r0 = this.f16117a.read();
        if (r0 == (-1)) goto L8;
        this.f16118b++;
    L9:
        return r0;
    L8:
        Log.e("PdfBox-Android", "read() returns -1, assumed position: " + this.f16118b + ", actual position: " + this.f16117a.a());
        goto L9
    }

    @Override // java.io.InputStream
    public int read(byte[] r3, int r4, int r5) {
        a();
        if (this.f16117a.e() == false) goto L5;
        return -1;
    L5:
        int r6 = this.f16117a.read(r3, r4, r5);
        if (r6 == (-1)) goto L8;
        this.f16118b += (long) r6;
    L9:
        return r6;
    L8:
        Log.e("PdfBox-Android", "read() returns -1, assumed position: " + this.f16118b + ", actual position: " + this.f16117a.a());
        goto L9
    }

    @Override // java.io.InputStream
    public long skip(long r4) {
        a();
        this.f16117a.a(this.f16118b + r4);
        this.f16118b += r4;
        return r4;
    }
}
