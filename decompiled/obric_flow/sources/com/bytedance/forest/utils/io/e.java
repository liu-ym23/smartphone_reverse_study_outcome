package com.bytedance.forest.utils.io;

import com.bytedance.forest.model.q;
import com.bytedance.forest.model.w;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f4640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f4641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4642c;
    public final AtomicInteger d;
    public final q e;
    public final w f;
    public final int g;

    public e(q r5, w r10) {
        this.e = r5;
        this.f = r10;
        this.g = 1024;
        this.f4640a = new AtomicBoolean(false);
        this.f4641b = new AtomicBoolean(false);
        this.d = new AtomicInteger(-1);
    }

    @Override // java.io.InputStream
    public final int available() {
        return Math.max(d(), 2);
    }

    public final void b(Throwable r11, String r12) {
        q r5 = this.e;
        com.bytedance.forest.utils.d.b(r5.getContext$forest_release().g, 6, "Streaming", "error happens when executing ".concat(r12), true, r11, null, 32);
        if (r5.isCacheClear$forest_release() == false) goto L6;
        w r10 = this.f;
        r10.f4441q.getForest().getMemoryManager$forest_release().a(r10.f4441q.getCacheKey$forest_release());
        r5.getContext$forest_release().f4619a.getClass();
        com.bytedance.forest.b.d(r10, r11);
        return;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        q r5 = this.e;
        com.bytedance.forest.b r10 = r5.getContext$forest_release().f4619a;
        Lazy r11 = com.bytedance.forest.b.f4230b;
        r10.getClass();
        com.bytedance.forest.b.d(this.f, null);
        this.f4641b.set(true);
        r5.close();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        b(th, "close");
        throw th;
    }

    public final int d() {
        q r5 = this.e;
        if (this.f4641b.get() == true) goto L15;
    L8:
        th = move-exception;
        b(th, "available");
        throw th;
    L5:
        if (r5.isCacheProvided$forest_release() == false) goto L11;
        return r5.size() - this.f4642c;
    L11:
        return r5.size();
    L15:
        throw new IOException("InputStream has been closed!");
    }

    @Override // java.io.InputStream
    public final int read() {
        return read(new byte[1], 0, 1);
    }

    @Override // java.io.InputStream
    public final int read(byte[] r27, int r28, int r29) {
        if (this.f4641b.get() == true) goto L31;
        AtomicBoolean r10 = this.f4640a;
        if (r10.get() == false) goto L7;
        return -1;
    L7:
        int r11 = this.d.incrementAndGet();
        if (r27 == null) goto L29;
        int r12 = hashCode();
        int r5 = Math.min(r27.length - r28, r29);
        if (r5 != 0) goto L12;
        return 0;
    L12:
        q r13 = this.e;
        int r14 = r13.size();
        int r15 = this.f4642c;
        if (r5 > (r14 - r15)) goto L15;
        int r16 = this.e.getBytesAtRange$forest_release(r15, r27, r28, r5, this.f);
    L23:
        if (r16 != (-1)) goto L26;
        com.bytedance.forest.utils.d.b(r13.getContext$forest_release().g, 4, "Streaming", "[" + r11 + '-' + r12 + "] read finished， cursor:" + this.f4642c, false, null, null, 56);
        r10.set(true);
        this.f4642c = r13.size();
        return r16;
    L26:
        this.f4642c += r16;
        return r16;
    L15:
        int r17 = this.g;
        int r18 = r5 / r17;
        if ((r5 % r17) == 0) goto L18;
        int r19 = 1;
    L19:
        int r20 = r17 * (r18 + r19);
        byte[] r21 = new byte[r20];
        int r22 = this.e.getBytesAtRange$forest_release(r15, r21, 0, r20, this.f);
        if (r22 <= 0) goto L22;
        r22 = Math.min(r22, r5);
        System.arraycopy(r21, 0, r27, r28, r22);
    L22:
        r16 = r22;
        goto L23
    L18:
        r19 = 0;
        goto L19
    L29:
        throw new NullPointerException("Input ByteArray is NULL!");
    L31:
        throw new IOException("InputStream has been closed!");
    }
}
