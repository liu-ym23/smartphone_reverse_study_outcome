package com.google.crypto.tink.shaded.protobuf;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
class ac extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Iterator<ByteBuffer> f4939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f4940b;
    private int c;
    private int d;
    private int e;
    private boolean f;
    private byte[] g;
    private int h;
    private long i;

    ac(Iterable<ByteBuffer> r5) {
        Iterable r6 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r5, Iterable.class, "com.obric.memorydata.plugin");
        this.f4939a = r6.iterator();
        this.c = 0;
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        ByteBuffer r2 = (ByteBuffer) ZeusTransformUtils.preCheckCast(r7.next(), ByteBuffer.class, "com.obric.memorydata.plugin");
        this.c++;
        goto L4
    L6:
        this.d = -1;
        if (a() == true) goto L11;
        this.f4940b = ab.e;
        this.d = 0;
        this.e = 0;
        this.i = 0;
        return;
    }

    private void a(int r2) {
        int r0 = this.e + r2;
        this.e = r0;
        if (r0 != this.f4940b.limit()) goto L6;
        a();
        return;
    }

    private boolean a() {
        this.d++;
        if (this.f4939a.hasNext() == true) goto L5;
        return false;
    L5:
        ByteBuffer r0 = (ByteBuffer) ZeusTransformUtils.preCheckCast(this.f4939a.next(), ByteBuffer.class, "com.obric.memorydata.plugin");
        this.f4940b = r0;
        this.e = r0.position();
        if (this.f4940b.hasArray() == false) goto L8;
        this.f = true;
        this.g = this.f4940b.array();
        this.h = this.f4940b.arrayOffset();
    L9:
        return true;
    L8:
        this.f = false;
        this.i = bx.a(this.f4940b);
        this.g = null;
        goto L9
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.d != this.c) goto L7;
        return -1;
    L7:
        if (this.f == false) goto L11;
        byte r0 = this.g[this.e + this.h];
    L9:
        int r1 = r0 & 255;
        a(1);
        return r1;
    L11:
        r0 = bx.a(((long) this.e) + this.i);
        goto L9
    }

    @Override // java.io.InputStream
    public int read(byte[] r4, int r5, int r6) {
        if (this.d != this.c) goto L6;
        return -1;
    L6:
        int r0 = this.f4940b.limit();
        int r1 = this.e;
        int r2 = r0 - r1;
        if (r6 <= r2) goto L10;
        r6 = r2;
    L10:
        if (this.f == false) goto L12;
        System.arraycopy(this.g, r1 + this.h, r4, r5, r6);
    L13:
        a(r6);
        return r6;
    L12:
        int r3 = this.f4940b.position();
        ad.b(this.f4940b, this.e);
        this.f4940b.get(r4, r5, r6);
        ad.b(this.f4940b, r3);
        goto L13
    }
}
